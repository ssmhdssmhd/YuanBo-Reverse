package e0;

import android.content.ComponentName;
import android.content.Context;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3327a = v.j.f("PackageManagerHelper");

    public static void a(Context context, Class<?> cls, boolean z5) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z5 ? 1 : 2, 1);
            v.j c6 = v.j.c();
            String str = f3327a;
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            objArr[1] = z5 ? "enabled" : "disabled";
            c6.a(str, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e6) {
            v.j c7 = v.j.c();
            String str2 = f3327a;
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            objArr2[1] = z5 ? "enabled" : "disabled";
            c7.a(str2, String.format("%s could not be %s", objArr2), e6);
        }
    }
}
