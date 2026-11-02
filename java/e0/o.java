package e0;

import android.content.Context;
import androidx.work.ListenableWorker;

/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: k, reason: collision with root package name */
    static final String f3345k = v.j.f("WorkForegroundRunnable");

    /* renamed from: a, reason: collision with root package name */
    final androidx.work.impl.utils.futures.d<Void> f3346a = androidx.work.impl.utils.futures.d.t();

    /* renamed from: b, reason: collision with root package name */
    final Context f3347b;

    /* renamed from: c, reason: collision with root package name */
    final d0.p f3348c;

    /* renamed from: d, reason: collision with root package name */
    final ListenableWorker f3349d;

    /* renamed from: e, reason: collision with root package name */
    final v.f f3350e;

    /* renamed from: j, reason: collision with root package name */
    final f0.a f3351j;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.futures.d f3352a;

        a(androidx.work.impl.utils.futures.d dVar) {
            this.f3352a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3352a.r(o.this.f3349d.d());
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.futures.d f3354a;

        b(androidx.work.impl.utils.futures.d dVar) {
            this.f3354a = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            try {
                v.e eVar = (v.e) this.f3354a.get();
                if (eVar == null) {
                    throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", o.this.f3348c.f2860c));
                }
                v.j.c().a(o.f3345k, String.format("Updating notification for %s", o.this.f3348c.f2860c), new Throwable[0]);
                o.this.f3349d.m(true);
                o oVar = o.this;
                oVar.f3346a.r(oVar.f3350e.a(oVar.f3347b, oVar.f3349d.f(), eVar));
            } catch (Throwable th) {
                o.this.f3346a.q(th);
            }
        }
    }

    public o(Context context, d0.p pVar, ListenableWorker listenableWorker, v.f fVar, f0.a aVar) {
        this.f3347b = context;
        this.f3348c = pVar;
        this.f3349d = listenableWorker;
        this.f3350e = fVar;
        this.f3351j = aVar;
    }

    public p2.a<Void> a() {
        return this.f3346a;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f3348c.f2874q || androidx.core.os.a.c()) {
            this.f3346a.p(null);
            return;
        }
        androidx.work.impl.utils.futures.d t5 = androidx.work.impl.utils.futures.d.t();
        this.f3351j.a().execute(new a(t5));
        t5.a(new b(t5), this.f3351j.a());
    }
}
