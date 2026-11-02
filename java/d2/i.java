package d2;

import h0.g3;
import i2.c1;
import i2.i0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f2976a = Pattern.compile("^NOTE([ \t].*)?$");

    public static Matcher a(i0 i0Var) {
        String q6;
        while (true) {
            String q7 = i0Var.q();
            if (q7 == null) {
                return null;
            }
            if (f2976a.matcher(q7).matches()) {
                do {
                    q6 = i0Var.q();
                    if (q6 != null) {
                    }
                } while (!q6.isEmpty());
            } else {
                Matcher matcher = f.f2950a.matcher(q7);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static boolean b(i0 i0Var) {
        String q6 = i0Var.q();
        return q6 != null && q6.startsWith("WEBVTT");
    }

    public static float c(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long d(String str) {
        String[] V0 = c1.V0(str, "\\.");
        long j6 = 0;
        for (String str2 : c1.U0(V0[0], ":")) {
            j6 = (j6 * 60) + Long.parseLong(str2);
        }
        long j7 = j6 * 1000;
        if (V0.length == 2) {
            j7 += Long.parseLong(V0[1]);
        }
        return j7 * 1000;
    }

    public static void e(i0 i0Var) {
        int f6 = i0Var.f();
        if (b(i0Var)) {
            return;
        }
        i0Var.S(f6);
        throw g3.a("Expected WEBVTT. Got " + i0Var.q(), null);
    }
}
