package m0;

import android.util.Pair;
import java.util.Map;

/* loaded from: classes.dex */
public final class w0 {
    private static long a(Map<String, String> map, String str) {
        if (map == null) {
            return -9223372036854775807L;
        }
        try {
            String str2 = map.get(str);
            if (str2 != null) {
                return Long.parseLong(str2);
            }
            return -9223372036854775807L;
        } catch (NumberFormatException unused) {
            return -9223372036854775807L;
        }
    }

    public static Pair<Long, Long> b(o oVar) {
        Map<String, String> c6 = oVar.c();
        if (c6 == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(a(c6, "LicenseDurationRemaining")), Long.valueOf(a(c6, "PlaybackDurationRemaining")));
    }
}
