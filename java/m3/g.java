package m3;

import android.os.Handler;
import android.os.Looper;
import m3.c;

/* loaded from: classes.dex */
public class g implements c.d {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f8101a = d4.a.a(Looper.getMainLooper());

    @Override // m3.c.d
    public void a(Runnable runnable) {
        this.f8101a.post(runnable);
    }
}
