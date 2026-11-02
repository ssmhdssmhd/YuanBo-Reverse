package r5;

import kotlin.jvm.internal.k;
import q5.e;
import q5.h;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f9177a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0066, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int c(byte[] r19, int r20) {
        /*
            Method dump skipped, instructions count: 469
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r5.b.c(byte[], int):int");
    }

    public static final void d(h commonWrite, e buffer, int i6, int i7) {
        k.e(commonWrite, "$this$commonWrite");
        k.e(buffer, "buffer");
        buffer.write(commonWrite.e(), i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(char c6) {
        if ('0' <= c6 && '9' >= c6) {
            return c6 - '0';
        }
        char c7 = 'a';
        if ('a' > c6 || 'f' < c6) {
            c7 = 'A';
            if ('A' > c6 || 'F' < c6) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c6);
            }
        }
        return (c6 - c7) + 10;
    }

    public static final char[] f() {
        return f9177a;
    }
}
