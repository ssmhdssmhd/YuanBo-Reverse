package r5;

import kotlin.jvm.internal.k;
import q5.x;

/* loaded from: classes.dex */
public final class c {
    public static final int a(int[] binarySearch, int i6, int i7, int i8) {
        k.e(binarySearch, "$this$binarySearch");
        int i9 = i8 - 1;
        while (i7 <= i9) {
            int i10 = (i7 + i9) >>> 1;
            int i11 = binarySearch[i10];
            if (i11 < i6) {
                i7 = i10 + 1;
            } else {
                if (i11 <= i6) {
                    return i10;
                }
                i9 = i10 - 1;
            }
        }
        return (-i7) - 1;
    }

    public static final int b(x segment, int i6) {
        k.e(segment, "$this$segment");
        int a6 = a(segment.w(), i6 + 1, 0, segment.x().length);
        return a6 >= 0 ? a6 : ~a6;
    }
}
