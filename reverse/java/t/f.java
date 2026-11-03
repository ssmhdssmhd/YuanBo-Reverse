package t;

import android.os.Trace;

/* loaded from: classes.dex */
final class f {
    public static void a(String str, int i6) {
        Trace.beginAsyncSection(str, i6);
    }

    public static void b(String str, int i6) {
        Trace.endAsyncSection(str, i6);
    }
}
