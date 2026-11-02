package s0;

import h0.y1;
import i2.i0;
import j0.a;
import java.util.Collections;
import o0.e0;
import s0.e;

/* loaded from: classes.dex */
final class a extends e {

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f9179e = {5512, 11025, 22050, 44100};

    /* renamed from: b, reason: collision with root package name */
    private boolean f9180b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f9181c;

    /* renamed from: d, reason: collision with root package name */
    private int f9182d;

    public a(e0 e0Var) {
        super(e0Var);
    }

    @Override // s0.e
    protected boolean b(i0 i0Var) {
        y1.b h02;
        if (this.f9180b) {
            i0Var.T(1);
        } else {
            int F = i0Var.F();
            int i6 = (F >> 4) & 15;
            this.f9182d = i6;
            if (i6 == 2) {
                h02 = new y1.b().g0("audio/mpeg").J(1).h0(f9179e[(F >> 2) & 3]);
            } else if (i6 == 7 || i6 == 8) {
                h02 = new y1.b().g0(i6 == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").J(1).h0(8000);
            } else {
                if (i6 != 10) {
                    throw new e.a("Audio format not supported: " + this.f9182d);
                }
                this.f9180b = true;
            }
            this.f9203a.c(h02.G());
            this.f9181c = true;
            this.f9180b = true;
        }
        return true;
    }

    @Override // s0.e
    protected boolean c(i0 i0Var, long j6) {
        if (this.f9182d == 2) {
            int a6 = i0Var.a();
            this.f9203a.d(i0Var, a6);
            this.f9203a.e(j6, 1, a6, 0, null);
            return true;
        }
        int F = i0Var.F();
        if (F != 0 || this.f9181c) {
            if (this.f9182d == 10 && F != 1) {
                return false;
            }
            int a7 = i0Var.a();
            this.f9203a.d(i0Var, a7);
            this.f9203a.e(j6, 1, a7, 0, null);
            return true;
        }
        int a8 = i0Var.a();
        byte[] bArr = new byte[a8];
        i0Var.j(bArr, 0, a8);
        a.b f6 = j0.a.f(bArr);
        this.f9203a.c(new y1.b().g0("audio/mp4a-latm").K(f6.f6370c).J(f6.f6369b).h0(f6.f6368a).V(Collections.singletonList(bArr)).G());
        this.f9181c = true;
        return false;
    }
}
