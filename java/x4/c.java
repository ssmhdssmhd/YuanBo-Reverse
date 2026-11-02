package x4;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import e4.k;
import e4.l;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final b f10662a;
    private static volatile Choreographer choreographer;

    static {
        Object a6;
        try {
            k.a aVar = k.f3704a;
            a6 = k.a(new a(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            k.a aVar2 = k.f3704a;
            a6 = k.a(l.a(th));
        }
        f10662a = (b) (k.c(a6) ? null : a6);
    }

    public static final Handler a(Looper looper, boolean z5) {
        if (!z5) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        if (invoke != null) {
            return (Handler) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }
}
