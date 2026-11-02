package e0;

import androidx.work.impl.WorkDatabase;
import v.s;

/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private static final String f3339d = v.j.f("StopWorkRunnable");

    /* renamed from: a, reason: collision with root package name */
    private final w.j f3340a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3341b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f3342c;

    public m(w.j jVar, String str, boolean z5) {
        this.f3340a = jVar;
        this.f3341b = str;
        this.f3342c = z5;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean o6;
        WorkDatabase p6 = this.f3340a.p();
        w.d n6 = this.f3340a.n();
        d0.q D = p6.D();
        p6.c();
        try {
            boolean h6 = n6.h(this.f3341b);
            if (this.f3342c) {
                o6 = this.f3340a.n().n(this.f3341b);
            } else {
                if (!h6 && D.j(this.f3341b) == s.a.RUNNING) {
                    D.c(s.a.ENQUEUED, this.f3341b);
                }
                o6 = this.f3340a.n().o(this.f3341b);
            }
            v.j.c().a(f3339d, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.f3341b, Boolean.valueOf(o6)), new Throwable[0]);
            p6.t();
        } finally {
            p6.g();
        }
    }
}
