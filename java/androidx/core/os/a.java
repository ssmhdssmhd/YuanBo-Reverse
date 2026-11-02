package androidx.core.os;

import android.os.Build;
import java.util.Locale;

/* loaded from: classes.dex */
public class a {
    protected static boolean a(String str, String str2) {
        if ("REL".equals(str2)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        return str2.toUpperCase(locale).compareTo(str.toUpperCase(locale)) >= 0;
    }

    @Deprecated
    public static boolean b() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @Deprecated
    public static boolean c() {
        int i6 = Build.VERSION.SDK_INT;
        return i6 >= 31 || (i6 >= 30 && a("S", Build.VERSION.CODENAME));
    }

    public static boolean d() {
        int i6 = Build.VERSION.SDK_INT;
        return i6 >= 33 || (i6 >= 32 && a("Tiramisu", Build.VERSION.CODENAME));
    }
}
