package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.futures.d;
import d0.p;
import java.util.Collections;
import java.util.List;
import v.j;
import z.c;

/* loaded from: classes.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements c {

    /* renamed from: k, reason: collision with root package name */
    private static final String f1651k = j.f("ConstraintTrkngWrkr");

    /* renamed from: f, reason: collision with root package name */
    private WorkerParameters f1652f;

    /* renamed from: g, reason: collision with root package name */
    final Object f1653g;

    /* renamed from: h, reason: collision with root package name */
    volatile boolean f1654h;

    /* renamed from: i, reason: collision with root package name */
    d<ListenableWorker.a> f1655i;

    /* renamed from: j, reason: collision with root package name */
    private ListenableWorker f1656j;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ConstraintTrackingWorker.this.u();
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p2.a f1658a;

        b(p2.a aVar) {
            this.f1658a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (ConstraintTrackingWorker.this.f1653g) {
                if (ConstraintTrackingWorker.this.f1654h) {
                    ConstraintTrackingWorker.this.t();
                } else {
                    ConstraintTrackingWorker.this.f1655i.r(this.f1658a);
                }
            }
        }
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f1652f = workerParameters;
        this.f1653g = new Object();
        this.f1654h = false;
        this.f1655i = d.t();
    }

    @Override // z.c
    public void c(List<String> list) {
        j.c().a(f1651k, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.f1653g) {
            this.f1654h = true;
        }
    }

    @Override // z.c
    public void e(List<String> list) {
    }

    @Override // androidx.work.ListenableWorker
    public boolean i() {
        ListenableWorker listenableWorker = this.f1656j;
        return listenableWorker != null && listenableWorker.i();
    }

    @Override // androidx.work.ListenableWorker
    public void l() {
        super.l();
        ListenableWorker listenableWorker = this.f1656j;
        if (listenableWorker == null || listenableWorker.j()) {
            return;
        }
        this.f1656j.p();
    }

    @Override // androidx.work.ListenableWorker
    public p2.a<ListenableWorker.a> o() {
        b().execute(new a());
        return this.f1655i;
    }

    public f0.a q() {
        return w.j.l(a()).q();
    }

    public WorkDatabase r() {
        return w.j.l(a()).p();
    }

    void s() {
        this.f1655i.p(ListenableWorker.a.a());
    }

    void t() {
        this.f1655i.p(ListenableWorker.a.b());
    }

    void u() {
        String j6 = g().j("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(j6)) {
            j.c().b(f1651k, "No worker to delegate to.", new Throwable[0]);
        } else {
            ListenableWorker b6 = h().b(a(), j6, this.f1652f);
            this.f1656j = b6;
            if (b6 != null) {
                p l6 = r().D().l(f().toString());
                if (l6 == null) {
                    s();
                    return;
                }
                z.d dVar = new z.d(a(), q(), this);
                dVar.d(Collections.singletonList(l6));
                if (!dVar.c(f().toString())) {
                    j.c().a(f1651k, String.format("Constraints not met for delegate %s. Requesting retry.", j6), new Throwable[0]);
                    t();
                    return;
                }
                j.c().a(f1651k, String.format("Constraints met for delegate %s", j6), new Throwable[0]);
                try {
                    p2.a<ListenableWorker.a> o6 = this.f1656j.o();
                    o6.a(new b(o6), b());
                    return;
                } catch (Throwable th) {
                    j c6 = j.c();
                    String str = f1651k;
                    c6.a(str, String.format("Delegated worker %s threw exception in startWork.", j6), th);
                    synchronized (this.f1653g) {
                        if (this.f1654h) {
                            j.c().a(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                            t();
                        } else {
                            s();
                        }
                        return;
                    }
                }
            }
            j.c().a(f1651k, "No worker to delegate to.", new Throwable[0]);
        }
        s();
    }
}
