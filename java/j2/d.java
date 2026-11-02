package j2;

import i2.i0;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f6686a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6687b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6688c;

    private d(int i6, int i7, String str) {
        this.f6686a = i6;
        this.f6687b = i7;
        this.f6688c = str;
    }

    public static d a(i0 i0Var) {
        String str;
        i0Var.T(2);
        int F = i0Var.F();
        int i6 = F >> 1;
        int F2 = ((i0Var.F() >> 3) & 31) | ((F & 1) << 5);
        if (i6 == 4 || i6 == 5 || i6 == 7) {
            str = "dvhe";
        } else if (i6 == 8) {
            str = "hev1";
        } else {
            if (i6 != 9) {
                return null;
            }
            str = "avc3";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".0");
        sb.append(i6);
        sb.append(F2 >= 10 ? "." : ".0");
        sb.append(F2);
        return new d(i6, F2, sb.toString());
    }
}
