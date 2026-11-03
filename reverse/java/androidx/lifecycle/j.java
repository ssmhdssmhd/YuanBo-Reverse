package androidx.lifecycle;

import androidx.lifecycle.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class j extends d {

    /* renamed from: b, reason: collision with root package name */
    private d.a<h, a> f876b;

    /* renamed from: c, reason: collision with root package name */
    private d.c f877c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<i> f878d;

    /* renamed from: e, reason: collision with root package name */
    private int f879e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f880f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f881g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<d.c> f882h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f883i;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        d.c f884a;

        /* renamed from: b, reason: collision with root package name */
        g f885b;

        a(h hVar, d.c cVar) {
            this.f885b = m.f(hVar);
            this.f884a = cVar;
        }

        void a(i iVar, d.b bVar) {
            d.c b6 = bVar.b();
            this.f884a = j.k(this.f884a, b6);
            this.f885b.d(iVar, bVar);
            this.f884a = b6;
        }
    }

    public j(i iVar) {
        this(iVar, true);
    }

    private j(i iVar, boolean z5) {
        this.f876b = new d.a<>();
        this.f879e = 0;
        this.f880f = false;
        this.f881g = false;
        this.f882h = new ArrayList<>();
        this.f878d = new WeakReference<>(iVar);
        this.f877c = d.c.INITIALIZED;
        this.f883i = z5;
    }

    private void d(i iVar) {
        Iterator<Map.Entry<h, a>> descendingIterator = this.f876b.descendingIterator();
        while (descendingIterator.hasNext() && !this.f881g) {
            Map.Entry<h, a> next = descendingIterator.next();
            a value = next.getValue();
            while (value.f884a.compareTo(this.f877c) > 0 && !this.f881g && this.f876b.contains(next.getKey())) {
                d.b a6 = d.b.a(value.f884a);
                if (a6 == null) {
                    throw new IllegalStateException("no event down from " + value.f884a);
                }
                n(a6.b());
                value.a(iVar, a6);
                m();
            }
        }
    }

    private d.c e(h hVar) {
        Map.Entry<h, a> i6 = this.f876b.i(hVar);
        d.c cVar = null;
        d.c cVar2 = i6 != null ? i6.getValue().f884a : null;
        if (!this.f882h.isEmpty()) {
            cVar = this.f882h.get(r0.size() - 1);
        }
        return k(k(this.f877c, cVar2), cVar);
    }

    private void f(String str) {
        if (!this.f883i || c.a.f().c()) {
            return;
        }
        throw new IllegalStateException("Method " + str + " must be called on the main thread");
    }

    private void g(i iVar) {
        d.b<h, a>.d d6 = this.f876b.d();
        while (d6.hasNext() && !this.f881g) {
            Map.Entry next = d6.next();
            a aVar = (a) next.getValue();
            while (aVar.f884a.compareTo(this.f877c) < 0 && !this.f881g && this.f876b.contains((h) next.getKey())) {
                n(aVar.f884a);
                d.b c6 = d.b.c(aVar.f884a);
                if (c6 == null) {
                    throw new IllegalStateException("no event up from " + aVar.f884a);
                }
                aVar.a(iVar, c6);
                m();
            }
        }
    }

    private boolean i() {
        if (this.f876b.size() == 0) {
            return true;
        }
        d.c cVar = this.f876b.b().getValue().f884a;
        d.c cVar2 = this.f876b.e().getValue().f884a;
        return cVar == cVar2 && this.f877c == cVar2;
    }

    static d.c k(d.c cVar, d.c cVar2) {
        return (cVar2 == null || cVar2.compareTo(cVar) >= 0) ? cVar : cVar2;
    }

    private void l(d.c cVar) {
        d.c cVar2 = this.f877c;
        if (cVar2 == cVar) {
            return;
        }
        if (cVar2 == d.c.INITIALIZED && cVar == d.c.DESTROYED) {
            throw new IllegalStateException("no event down from " + this.f877c);
        }
        this.f877c = cVar;
        if (this.f880f || this.f879e != 0) {
            this.f881g = true;
            return;
        }
        this.f880f = true;
        p();
        this.f880f = false;
        if (this.f877c == d.c.DESTROYED) {
            this.f876b = new d.a<>();
        }
    }

    private void m() {
        this.f882h.remove(r0.size() - 1);
    }

    private void n(d.c cVar) {
        this.f882h.add(cVar);
    }

    private void p() {
        i iVar = this.f878d.get();
        if (iVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean i6 = i();
            this.f881g = false;
            if (i6) {
                return;
            }
            if (this.f877c.compareTo(this.f876b.b().getValue().f884a) < 0) {
                d(iVar);
            }
            Map.Entry<h, a> e6 = this.f876b.e();
            if (!this.f881g && e6 != null && this.f877c.compareTo(e6.getValue().f884a) > 0) {
                g(iVar);
            }
        }
    }

    @Override // androidx.lifecycle.d
    public void a(h hVar) {
        i iVar;
        f("addObserver");
        d.c cVar = this.f877c;
        d.c cVar2 = d.c.DESTROYED;
        if (cVar != cVar2) {
            cVar2 = d.c.INITIALIZED;
        }
        a aVar = new a(hVar, cVar2);
        if (this.f876b.g(hVar, aVar) == null && (iVar = this.f878d.get()) != null) {
            boolean z5 = this.f879e != 0 || this.f880f;
            d.c e6 = e(hVar);
            this.f879e++;
            while (aVar.f884a.compareTo(e6) < 0 && this.f876b.contains(hVar)) {
                n(aVar.f884a);
                d.b c6 = d.b.c(aVar.f884a);
                if (c6 == null) {
                    throw new IllegalStateException("no event up from " + aVar.f884a);
                }
                aVar.a(iVar, c6);
                m();
                e6 = e(hVar);
            }
            if (!z5) {
                p();
            }
            this.f879e--;
        }
    }

    @Override // androidx.lifecycle.d
    public d.c b() {
        return this.f877c;
    }

    @Override // androidx.lifecycle.d
    public void c(h hVar) {
        f("removeObserver");
        this.f876b.h(hVar);
    }

    public void h(d.b bVar) {
        f("handleLifecycleEvent");
        l(bVar.b());
    }

    @Deprecated
    public void j(d.c cVar) {
        f("markState");
        o(cVar);
    }

    public void o(d.c cVar) {
        f("setCurrentState");
        l(cVar);
    }
}
