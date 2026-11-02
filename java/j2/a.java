package j2;

import h0.g3;
import i2.i0;
import i2.y;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final List<byte[]> f6663a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6664b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6665c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6666d;

    /* renamed from: e, reason: collision with root package name */
    public final float f6667e;

    /* renamed from: f, reason: collision with root package name */
    public final String f6668f;

    private a(List<byte[]> list, int i6, int i7, int i8, float f6, String str) {
        this.f6663a = list;
        this.f6664b = i6;
        this.f6665c = i7;
        this.f6666d = i8;
        this.f6667e = f6;
        this.f6668f = str;
    }

    private static byte[] a(i0 i0Var) {
        int L = i0Var.L();
        int f6 = i0Var.f();
        i0Var.T(L);
        return i2.f.d(i0Var.e(), f6, L);
    }

    public static a b(i0 i0Var) {
        String str;
        int i6;
        int i7;
        float f6;
        try {
            i0Var.T(4);
            int F = (i0Var.F() & 3) + 1;
            if (F == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int F2 = i0Var.F() & 31;
            for (int i8 = 0; i8 < F2; i8++) {
                arrayList.add(a(i0Var));
            }
            int F3 = i0Var.F();
            for (int i9 = 0; i9 < F3; i9++) {
                arrayList.add(a(i0Var));
            }
            if (F2 > 0) {
                y.c l6 = i2.y.l((byte[]) arrayList.get(0), F, ((byte[]) arrayList.get(0)).length);
                int i10 = l6.f5698f;
                int i11 = l6.f5699g;
                float f7 = l6.f5700h;
                str = i2.f.a(l6.f5693a, l6.f5694b, l6.f5695c);
                i6 = i10;
                i7 = i11;
                f6 = f7;
            } else {
                str = null;
                i6 = -1;
                i7 = -1;
                f6 = 1.0f;
            }
            return new a(arrayList, F, i6, i7, f6, str);
        } catch (ArrayIndexOutOfBoundsException e6) {
            throw g3.a("Error parsing AVC config", e6);
        }
    }
}
