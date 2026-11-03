package q0;

import i2.c1;
import i2.i0;
import i2.t;

/* loaded from: classes.dex */
final class d implements a {

    /* renamed from: a, reason: collision with root package name */
    public final int f8687a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8688b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8689c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8690d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8691e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8692f;

    private d(int i6, int i7, int i8, int i9, int i10, int i11) {
        this.f8687a = i6;
        this.f8688b = i7;
        this.f8689c = i8;
        this.f8690d = i9;
        this.f8691e = i10;
        this.f8692f = i11;
    }

    public static d d(i0 i0Var) {
        int s5 = i0Var.s();
        i0Var.T(12);
        int s6 = i0Var.s();
        int s7 = i0Var.s();
        int s8 = i0Var.s();
        i0Var.T(4);
        int s9 = i0Var.s();
        int s10 = i0Var.s();
        i0Var.T(8);
        return new d(s5, s6, s7, s8, s9, s10);
    }

    @Override // q0.a
    public int a() {
        return 1752331379;
    }

    public long b() {
        return c1.P0(this.f8691e, this.f8689c * 1000000, this.f8690d);
    }

    public int c() {
        int i6 = this.f8687a;
        if (i6 == 1935960438) {
            return 2;
        }
        if (i6 == 1935963489) {
            return 1;
        }
        if (i6 == 1937012852) {
            return 3;
        }
        t.i("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(this.f8687a));
        return -1;
    }
}
