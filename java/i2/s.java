package i2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import i2.m;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class s<T> {

    /* renamed from: a, reason: collision with root package name */
    private final e f5649a;

    /* renamed from: b, reason: collision with root package name */
    private final p f5650b;

    /* renamed from: c, reason: collision with root package name */
    private final b<T> f5651c;

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArraySet<c<T>> f5652d;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayDeque<Runnable> f5653e;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayDeque<Runnable> f5654f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f5655g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5656h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5657i;

    public interface a<T> {
        void invoke(T t5);
    }

    public interface b<T> {
        void a(T t5, m mVar);
    }

    private static final class c<T> {

        /* renamed from: a, reason: collision with root package name */
        public final T f5658a;

        /* renamed from: b, reason: collision with root package name */
        private m.b f5659b = new m.b();

        /* renamed from: c, reason: collision with root package name */
        private boolean f5660c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f5661d;

        public c(T t5) {
            this.f5658a = t5;
        }

        public void a(int i6, a<T> aVar) {
            if (this.f5661d) {
                return;
            }
            if (i6 != -1) {
                this.f5659b.a(i6);
            }
            this.f5660c = true;
            aVar.invoke(this.f5658a);
        }

        public void b(b<T> bVar) {
            if (this.f5661d || !this.f5660c) {
                return;
            }
            m e6 = this.f5659b.e();
            this.f5659b = new m.b();
            this.f5660c = false;
            bVar.a(this.f5658a, e6);
        }

        public void c(b<T> bVar) {
            this.f5661d = true;
            if (this.f5660c) {
                this.f5660c = false;
                bVar.a(this.f5658a, this.f5659b.e());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.f5658a.equals(((c) obj).f5658a);
        }

        public int hashCode() {
            return this.f5658a.hashCode();
        }
    }

    public s(Looper looper, e eVar, b<T> bVar) {
        this(new CopyOnWriteArraySet(), looper, eVar, bVar);
    }

    private s(CopyOnWriteArraySet<c<T>> copyOnWriteArraySet, Looper looper, e eVar, b<T> bVar) {
        this.f5649a = eVar;
        this.f5652d = copyOnWriteArraySet;
        this.f5651c = bVar;
        this.f5655g = new Object();
        this.f5653e = new ArrayDeque<>();
        this.f5654f = new ArrayDeque<>();
        this.f5650b = eVar.b(looper, new Handler.Callback() { // from class: i2.q
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean g6;
                g6 = s.this.g(message);
                return g6;
            }
        });
        this.f5657i = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(Message message) {
        Iterator<c<T>> it = this.f5652d.iterator();
        while (it.hasNext()) {
            it.next().b(this.f5651c);
            if (this.f5650b.a(0)) {
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(CopyOnWriteArraySet copyOnWriteArraySet, int i6, a aVar) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(i6, aVar);
        }
    }

    private void m() {
        if (this.f5657i) {
            i2.a.g(Thread.currentThread() == this.f5650b.j().getThread());
        }
    }

    public void c(T t5) {
        i2.a.e(t5);
        synchronized (this.f5655g) {
            if (this.f5656h) {
                return;
            }
            this.f5652d.add(new c<>(t5));
        }
    }

    public s<T> d(Looper looper, e eVar, b<T> bVar) {
        return new s<>(this.f5652d, looper, eVar, bVar);
    }

    public s<T> e(Looper looper, b<T> bVar) {
        return d(looper, this.f5649a, bVar);
    }

    public void f() {
        m();
        if (this.f5654f.isEmpty()) {
            return;
        }
        if (!this.f5650b.a(0)) {
            p pVar = this.f5650b;
            pVar.d(pVar.l(0));
        }
        boolean z5 = !this.f5653e.isEmpty();
        this.f5653e.addAll(this.f5654f);
        this.f5654f.clear();
        if (z5) {
            return;
        }
        while (!this.f5653e.isEmpty()) {
            this.f5653e.peekFirst().run();
            this.f5653e.removeFirst();
        }
    }

    public void i(final int i6, final a<T> aVar) {
        m();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f5652d);
        this.f5654f.add(new Runnable() { // from class: i2.r
            @Override // java.lang.Runnable
            public final void run() {
                s.h(copyOnWriteArraySet, i6, aVar);
            }
        });
    }

    public void j() {
        m();
        synchronized (this.f5655g) {
            this.f5656h = true;
        }
        Iterator<c<T>> it = this.f5652d.iterator();
        while (it.hasNext()) {
            it.next().c(this.f5651c);
        }
        this.f5652d.clear();
    }

    public void k(T t5) {
        m();
        Iterator<c<T>> it = this.f5652d.iterator();
        while (it.hasNext()) {
            c<T> next = it.next();
            if (next.f5658a.equals(t5)) {
                next.c(this.f5651c);
                this.f5652d.remove(next);
            }
        }
    }

    public void l(int i6, a<T> aVar) {
        i(i6, aVar);
        f();
    }
}
