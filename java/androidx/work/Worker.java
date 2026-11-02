package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.d;

/* loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {

    /* renamed from: f, reason: collision with root package name */
    d<ListenableWorker.a> f1473f;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Worker.this.f1473f.p(Worker.this.q());
            } catch (Throwable th) {
                Worker.this.f1473f.q(th);
            }
        }
    }

    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    public final p2.a<ListenableWorker.a> o() {
        this.f1473f = d.t();
        b().execute(new a());
        return this.f1473f;
    }

    public abstract ListenableWorker.a q();
}
