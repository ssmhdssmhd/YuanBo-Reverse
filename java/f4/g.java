package f4;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends f {
    public static <T> List<T> b(T[] tArr) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        List<T> a6 = i.a(tArr);
        kotlin.jvm.internal.k.d(a6, "asList(this)");
        return a6;
    }

    public static byte[] c(byte[] bArr, byte[] destination, int i6, int i7, int i8) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        System.arraycopy(bArr, i7, destination, i6, i8 - i7);
        return destination;
    }

    public static final <T> T[] d(T[] tArr, T[] destination, int i6, int i7, int i8) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        kotlin.jvm.internal.k.e(destination, "destination");
        System.arraycopy(tArr, i7, destination, i6, i8 - i7);
        return destination;
    }

    public static /* synthetic */ byte[] e(byte[] bArr, byte[] bArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = bArr.length;
        }
        return c(bArr, bArr2, i6, i7, i8);
    }

    public static /* synthetic */ Object[] f(Object[] objArr, Object[] objArr2, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i6 = 0;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = objArr.length;
        }
        return d(objArr, objArr2, i6, i7, i8);
    }

    public static byte[] g(byte[] bArr, int i6, int i7) {
        kotlin.jvm.internal.k.e(bArr, "<this>");
        e.a(i7, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i6, i7);
        kotlin.jvm.internal.k.d(copyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return copyOfRange;
    }

    public static <T> void h(T[] tArr, T t5, int i6, int i7) {
        kotlin.jvm.internal.k.e(tArr, "<this>");
        Arrays.fill(tArr, i6, i7, t5);
    }

    public static /* synthetic */ void i(Object[] objArr, Object obj, int i6, int i7, int i8, Object obj2) {
        if ((i8 & 2) != 0) {
            i6 = 0;
        }
        if ((i8 & 4) != 0) {
            i7 = objArr.length;
        }
        h(objArr, obj, i6, i7);
    }
}
