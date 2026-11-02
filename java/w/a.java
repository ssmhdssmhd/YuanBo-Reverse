package w;

import android.os.Handler;
import android.os.Looper;
import v.q;

/* loaded from: classes.dex */
public class a implements q {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f9905a = androidx.core.os.c.a(Looper.getMainLooper());

    @Override // v.q
    public void a(long j6, Runnable runnable) {
        this.f9905a.postDelayed(runnable, j6);
    }

    @Override // v.q
    public void b(Runnable runnable) {
        this.f9905a.removeCallbacks(runnable);
    }
}
