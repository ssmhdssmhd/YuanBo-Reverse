package i2;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f5564a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f5565b = {"", "A", "B", "C"};

    public static String a(int i6, int i7, int i8) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
    }

    public static List<byte[]> b(boolean z5) {
        return Collections.singletonList(z5 ? new byte[]{1} : new byte[]{0});
    }

    public static String c(int i6, boolean z5, int i7, int i8, int[] iArr, int i9) {
        Object[] objArr = new Object[5];
        objArr[0] = f5565b[i6];
        objArr[1] = Integer.valueOf(i7);
        objArr[2] = Integer.valueOf(i8);
        objArr[3] = Character.valueOf(z5 ? 'H' : 'L');
        objArr[4] = Integer.valueOf(i9);
        StringBuilder sb = new StringBuilder(c1.C("hvc1.%s%d.%X.%c%d", objArr));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i10 = 0; i10 < length; i10++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i10])));
        }
        return sb.toString();
    }

    public static byte[] d(byte[] bArr, int i6, int i7) {
        byte[] bArr2 = f5564a;
        byte[] bArr3 = new byte[bArr2.length + i7];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i6, bArr3, bArr2.length, i7);
        return bArr3;
    }

    private static int e(byte[] bArr, int i6) {
        int length = bArr.length - f5564a.length;
        while (i6 <= length) {
            if (f(bArr, i6)) {
                return i6;
            }
            i6++;
        }
        return -1;
    }

    private static boolean f(byte[] bArr, int i6) {
        if (bArr.length - i6 <= f5564a.length) {
            return false;
        }
        int i7 = 0;
        while (true) {
            byte[] bArr2 = f5564a;
            if (i7 >= bArr2.length) {
                return true;
            }
            if (bArr[i6 + i7] != bArr2[i7]) {
                return false;
            }
            i7++;
        }
    }

    public static Pair<Integer, Integer> g(byte[] bArr) {
        i0 i0Var = new i0(bArr);
        i0Var.S(9);
        int F = i0Var.F();
        i0Var.S(20);
        return Pair.create(Integer.valueOf(i0Var.J()), Integer.valueOf(F));
    }

    public static boolean h(List<byte[]> list) {
        return list.size() == 1 && list.get(0).length == 1 && list.get(0)[0] == 1;
    }

    public static byte[][] i(byte[] bArr) {
        if (!f(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        do {
            arrayList.add(Integer.valueOf(i6));
            i6 = e(bArr, i6 + f5564a.length);
        } while (i6 != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i7 = 0;
        while (i7 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i7)).intValue();
            int intValue2 = (i7 < arrayList.size() + (-1) ? ((Integer) arrayList.get(i7 + 1)).intValue() : bArr.length) - intValue;
            byte[] bArr3 = new byte[intValue2];
            System.arraycopy(bArr, intValue, bArr3, 0, intValue2);
            bArr2[i7] = bArr3;
            i7++;
        }
        return bArr2;
    }
}
