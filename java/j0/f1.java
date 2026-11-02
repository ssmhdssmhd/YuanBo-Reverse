package j0;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final /* synthetic */ class f1 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f6420a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f6420a.post(runnable);
    }
}
