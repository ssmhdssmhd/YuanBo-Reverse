package i2;

import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static Method f5547a;

    public static IBinder a(Bundle bundle, String str) {
        return c1.f5548a >= 18 ? bundle.getBinder(str) : b(bundle, str);
    }

    private static IBinder b(Bundle bundle, String str) {
        String str2;
        Method method = f5547a;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", String.class);
                f5547a = method2;
                method2.setAccessible(true);
                method = f5547a;
            } catch (NoSuchMethodException e6) {
                e = e6;
                str2 = "Failed to retrieve getIBinder method";
                t.g("BundleUtil", str2, e);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e7) {
            e = e7;
            str2 = "Failed to invoke getIBinder via reflection";
            t.g("BundleUtil", str2, e);
            return null;
        }
    }
}
