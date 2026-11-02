package kotlinx.coroutines.android;

import android.os.Build;
import h4.a;
import h4.g;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import w4.d0;

/* loaded from: classes.dex */
public final class AndroidExceptionPreHandler extends a implements d0 {
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler() {
        super(d0.f10291h);
        this._preHandler = this;
    }

    private final Method preHandler() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            boolean z5 = false;
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                if (Modifier.isStatic(declaredMethod.getModifiers())) {
                    z5 = true;
                }
            }
            if (z5) {
                method = declaredMethod;
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    @Override // w4.d0
    public void handleException(g gVar, Throwable th) {
        int i6 = Build.VERSION.SDK_INT;
        if (26 <= i6 && i6 < 28) {
            Method preHandler = preHandler();
            Object invoke = preHandler == null ? null : preHandler.invoke(null, new Object[0]);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = invoke instanceof Thread.UncaughtExceptionHandler ? (Thread.UncaughtExceptionHandler) invoke : null;
            if (uncaughtExceptionHandler == null) {
                return;
            }
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
    }
}
