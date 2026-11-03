package r5;

import kotlin.jvm.internal.k;
import q5.e;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f9176a = q5.b.a("0123456789abcdef");

    public static final byte[] a() {
        return f9176a;
    }

    public static final String b(e readUtf8Line, long j6) {
        k.e(readUtf8Line, "$this$readUtf8Line");
        if (j6 > 0) {
            long j7 = j6 - 1;
            if (readUtf8Line.v(j7) == ((byte) 13)) {
                String Y = readUtf8Line.Y(j7);
                readUtf8Line.skip(2L);
                return Y;
            }
        }
        String Y2 = readUtf8Line.Y(j6);
        readUtf8Line.skip(1L);
        return Y2;
    }
}
