package kotlinx.coroutines.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class e0 {
    public static final int a(String str, int i6, int i7, int i8) {
        return (int) c0.c(str, i6, i7, i8);
    }

    public static final long b(String str, long j6, long j7, long j8) {
        Long k6;
        String d6 = c0.d(str);
        if (d6 == null) {
            return j6;
        }
        k6 = v4.o.k(d6);
        if (k6 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d6 + '\'').toString());
        }
        long longValue = k6.longValue();
        boolean z5 = false;
        if (j7 <= longValue && longValue <= j8) {
            z5 = true;
        }
        if (z5) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j7 + ".." + j8 + ", but is '" + longValue + '\'').toString());
    }

    public static final boolean c(String str, boolean z5) {
        String d6 = c0.d(str);
        return d6 == null ? z5 : Boolean.parseBoolean(d6);
    }

    public static /* synthetic */ int d(String str, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            i7 = 1;
        }
        if ((i9 & 8) != 0) {
            i8 = Integer.MAX_VALUE;
        }
        return c0.b(str, i6, i7, i8);
    }

    public static /* synthetic */ long e(String str, long j6, long j7, long j8, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            j7 = 1;
        }
        long j9 = j7;
        if ((i6 & 8) != 0) {
            j8 = Long.MAX_VALUE;
        }
        return c0.c(str, j6, j9, j8);
    }
}
