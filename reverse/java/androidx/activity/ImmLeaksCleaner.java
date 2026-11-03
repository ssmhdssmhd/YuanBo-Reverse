package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.d;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements g {

    /* renamed from: b, reason: collision with root package name */
    private static int f296b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f297c;

    /* renamed from: d, reason: collision with root package name */
    private static Field f298d;

    /* renamed from: e, reason: collision with root package name */
    private static Field f299e;

    /* renamed from: a, reason: collision with root package name */
    private Activity f300a;

    ImmLeaksCleaner(Activity activity) {
        this.f300a = activity;
    }

    private static void e() {
        try {
            f296b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f298d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f299e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f297c = declaredField3;
            declaredField3.setAccessible(true);
            f296b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.g
    public void d(i iVar, d.b bVar) {
        if (bVar != d.b.ON_DESTROY) {
            return;
        }
        if (f296b == 0) {
            e();
        }
        if (f296b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f300a.getSystemService("input_method");
            try {
                Object obj = f297c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f298d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f299e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
