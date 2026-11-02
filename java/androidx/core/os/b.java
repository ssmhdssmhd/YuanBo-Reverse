package androidx.core.os;

import android.os.Handler;
import androidx.core.util.g;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class b {

    private static class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f438a;

        a(Handler handler) {
            this.f438a = (Handler) g.a(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f438a.post((Runnable) g.a(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f438a + " is shutting down");
        }
    }

    public static Executor a(Handler handler) {
        return new a(handler);
    }
}
