package f0;

import android.os.Handler;
import android.os.Looper;
import e0.k;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class b implements f0.a {

    /* renamed from: a, reason: collision with root package name */
    private final k f3771a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f3772b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    private final Executor f3773c = new a();

    class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            b.this.d(runnable);
        }
    }

    public b(Executor executor) {
        this.f3771a = new k(executor);
    }

    @Override // f0.a
    public Executor a() {
        return this.f3773c;
    }

    @Override // f0.a
    public void b(Runnable runnable) {
        this.f3771a.execute(runnable);
    }

    @Override // f0.a
    public k c() {
        return this.f3771a;
    }

    public void d(Runnable runnable) {
        this.f3772b.post(runnable);
    }
}
