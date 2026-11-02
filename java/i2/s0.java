package i2;

import android.os.Trace;

/* loaded from: classes.dex */
public final class s0 {
    public static void a(String str) {
        if (c1.f5548a >= 18) {
            b(str);
        }
    }

    private static void b(String str) {
        Trace.beginSection(str);
    }

    public static void c() {
        if (c1.f5548a >= 18) {
            d();
        }
    }

    private static void d() {
        Trace.endSection();
    }
}
