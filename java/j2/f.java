package j2;

import h0.g3;
import i2.i0;
import i2.y;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final List<byte[]> f6713a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6714b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6715c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6716d;

    /* renamed from: e, reason: collision with root package name */
    public final float f6717e;

    /* renamed from: f, reason: collision with root package name */
    public final String f6718f;

    private f(List<byte[]> list, int i6, int i7, int i8, float f6, String str) {
        this.f6713a = list;
        this.f6714b = i6;
        this.f6715c = i7;
        this.f6716d = i8;
        this.f6717e = f6;
        this.f6718f = str;
    }

    public static f a(i0 i0Var) {
        int i6;
        int i7;
        try {
            i0Var.T(21);
            int F = i0Var.F() & 3;
            int F2 = i0Var.F();
            int f6 = i0Var.f();
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < F2; i10++) {
                i0Var.T(1);
                int L = i0Var.L();
                for (int i11 = 0; i11 < L; i11++) {
                    int L2 = i0Var.L();
                    i9 += L2 + 4;
                    i0Var.T(L2);
                }
            }
            i0Var.S(f6);
            byte[] bArr = new byte[i9];
            String str = null;
            int i12 = 0;
            int i13 = 0;
            int i14 = -1;
            int i15 = -1;
            float f7 = 1.0f;
            while (i12 < F2) {
                int F3 = i0Var.F() & 63;
                int L3 = i0Var.L();
                int i16 = 0;
                while (i16 < L3) {
                    int L4 = i0Var.L();
                    byte[] bArr2 = i2.y.f5676a;
                    int i17 = F2;
                    System.arraycopy(bArr2, i8, bArr, i13, bArr2.length);
                    int length = i13 + bArr2.length;
                    System.arraycopy(i0Var.e(), i0Var.f(), bArr, length, L4);
                    if (F3 == 33 && i16 == 0) {
                        y.a h6 = i2.y.h(bArr, length, length + L4);
                        int i18 = h6.f5687h;
                        i15 = h6.f5688i;
                        f7 = h6.f5689j;
                        i6 = F3;
                        i7 = L3;
                        i14 = i18;
                        str = i2.f.c(h6.f5680a, h6.f5681b, h6.f5682c, h6.f5683d, h6.f5684e, h6.f5685f);
                    } else {
                        i6 = F3;
                        i7 = L3;
                    }
                    i13 = length + L4;
                    i0Var.T(L4);
                    i16++;
                    F2 = i17;
                    F3 = i6;
                    L3 = i7;
                    i8 = 0;
                }
                i12++;
                i8 = 0;
            }
            return new f(i9 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), F + 1, i14, i15, f7, str);
        } catch (ArrayIndexOutOfBoundsException e6) {
            throw g3.a("Error parsing HEVC config", e6);
        }
    }
}
