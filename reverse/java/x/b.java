package x;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import d0.p;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import v.j;
import v.s;
import w.e;
import z.c;
import z.d;

/* loaded from: classes.dex */
public class b implements e, c, w.b {

    /* renamed from: i, reason: collision with root package name */
    private static final String f10382i = j.f("GreedyScheduler");

    /* renamed from: a, reason: collision with root package name */
    private final Context f10383a;

    /* renamed from: b, reason: collision with root package name */
    private final w.j f10384b;

    /* renamed from: c, reason: collision with root package name */
    private final d f10385c;

    /* renamed from: e, reason: collision with root package name */
    private a f10387e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f10388f;

    /* renamed from: h, reason: collision with root package name */
    Boolean f10390h;

    /* renamed from: d, reason: collision with root package name */
    private final Set<p> f10386d = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private final Object f10389g = new Object();

    public b(Context context, androidx.work.a aVar, f0.a aVar2, w.j jVar) {
        this.f10383a = context;
        this.f10384b = jVar;
        this.f10385c = new d(context, aVar2, this);
        this.f10387e = new a(this, aVar.k());
    }

    private void g() {
        this.f10390h = Boolean.valueOf(e0.j.b(this.f10383a, this.f10384b.j()));
    }

    private void h() {
        if (this.f10388f) {
            return;
        }
        this.f10384b.n().d(this);
        this.f10388f = true;
    }

    private void i(String str) {
        synchronized (this.f10389g) {
            Iterator<p> it = this.f10386d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p next = it.next();
                if (next.f2858a.equals(str)) {
                    j.c().a(f10382i, String.format("Stopping tracking for %s", str), new Throwable[0]);
                    this.f10386d.remove(next);
                    this.f10385c.d(this.f10386d);
                    break;
                }
            }
        }
    }

    @Override // w.b
    public void a(String str, boolean z5) {
        i(str);
    }

    @Override // w.e
    public void b(String str) {
        if (this.f10390h == null) {
            g();
        }
        if (!this.f10390h.booleanValue()) {
            j.c().d(f10382i, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        h();
        j.c().a(f10382i, String.format("Cancelling work ID %s", str), new Throwable[0]);
        a aVar = this.f10387e;
        if (aVar != null) {
            aVar.b(str);
        }
        this.f10384b.y(str);
    }

    @Override // z.c
    public void c(List<String> list) {
        for (String str : list) {
            j.c().a(f10382i, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.f10384b.y(str);
        }
    }

    @Override // w.e
    public void d(p... pVarArr) {
        if (this.f10390h == null) {
            g();
        }
        if (!this.f10390h.booleanValue()) {
            j.c().d(f10382i, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        h();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (p pVar : pVarArr) {
            long a6 = pVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (pVar.f2859b == s.a.ENQUEUED) {
                if (currentTimeMillis < a6) {
                    a aVar = this.f10387e;
                    if (aVar != null) {
                        aVar.a(pVar);
                    }
                } else if (pVar.b()) {
                    int i6 = Build.VERSION.SDK_INT;
                    if (i6 >= 23 && pVar.f2867j.h()) {
                        j.c().a(f10382i, String.format("Ignoring WorkSpec %s, Requires device idle.", pVar), new Throwable[0]);
                    } else if (i6 < 24 || !pVar.f2867j.e()) {
                        hashSet.add(pVar);
                        hashSet2.add(pVar.f2858a);
                    } else {
                        j.c().a(f10382i, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", pVar), new Throwable[0]);
                    }
                } else {
                    j.c().a(f10382i, String.format("Starting work for %s", pVar.f2858a), new Throwable[0]);
                    this.f10384b.v(pVar.f2858a);
                }
            }
        }
        synchronized (this.f10389g) {
            if (!hashSet.isEmpty()) {
                j.c().a(f10382i, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.f10386d.addAll(hashSet);
                this.f10385c.d(this.f10386d);
            }
        }
    }

    @Override // z.c
    public void e(List<String> list) {
        for (String str : list) {
            j.c().a(f10382i, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            this.f10384b.v(str);
        }
    }

    @Override // w.e
    public boolean f() {
        return false;
    }
}
