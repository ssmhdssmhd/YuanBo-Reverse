package o2;

import l2.k;

/* loaded from: classes.dex */
public final class g {
    public static int a(long j6, long j7) {
        if (j6 < j7) {
            return -1;
        }
        return j6 > j7 ? 1 : 0;
    }

    public static int b(long j6) {
        return (int) (j6 ^ (j6 >>> 32));
    }

    public static long c(long... jArr) {
        k.d(jArr.length > 0);
        long j6 = jArr[0];
        for (int i6 = 1; i6 < jArr.length; i6++) {
            long j7 = jArr[i6];
            if (j7 > j6) {
                j6 = j7;
            }
        }
        return j6;
    }
}
