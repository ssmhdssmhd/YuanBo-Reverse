package x0;

import h0.g3;
import h0.y1;
import i2.i0;
import java.util.ArrayList;
import java.util.Arrays;
import m2.q;
import o0.h0;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import x0.i;

/* loaded from: classes.dex */
final class j extends i {

    /* renamed from: n, reason: collision with root package name */
    private a f10448n;

    /* renamed from: o, reason: collision with root package name */
    private int f10449o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f10450p;

    /* renamed from: q, reason: collision with root package name */
    private h0.d f10451q;

    /* renamed from: r, reason: collision with root package name */
    private h0.b f10452r;

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final h0.d f10453a;

        /* renamed from: b, reason: collision with root package name */
        public final h0.b f10454b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f10455c;

        /* renamed from: d, reason: collision with root package name */
        public final h0.c[] f10456d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10457e;

        public a(h0.d dVar, h0.b bVar, byte[] bArr, h0.c[] cVarArr, int i6) {
            this.f10453a = dVar;
            this.f10454b = bVar;
            this.f10455c = bArr;
            this.f10456d = cVarArr;
            this.f10457e = i6;
        }
    }

    j() {
    }

    static void n(i0 i0Var, long j6) {
        if (i0Var.b() < i0Var.g() + 4) {
            i0Var.P(Arrays.copyOf(i0Var.e(), i0Var.g() + 4));
        } else {
            i0Var.R(i0Var.g() + 4);
        }
        byte[] e6 = i0Var.e();
        e6[i0Var.g() - 4] = (byte) (j6 & 255);
        e6[i0Var.g() - 3] = (byte) ((j6 >>> 8) & 255);
        e6[i0Var.g() - 2] = (byte) ((j6 >>> 16) & 255);
        e6[i0Var.g() - 1] = (byte) ((j6 >>> 24) & 255);
    }

    private static int o(byte b6, a aVar) {
        return !aVar.f10456d[p(b6, aVar.f10457e, 1)].f8377a ? aVar.f10453a.f8387g : aVar.f10453a.f8388h;
    }

    static int p(byte b6, int i6, int i7) {
        return (b6 >> i7) & (255 >>> (8 - i6));
    }

    public static boolean r(i0 i0Var) {
        try {
            return h0.m(1, i0Var, true);
        } catch (g3 unused) {
            return false;
        }
    }

    @Override // x0.i
    protected void e(long j6) {
        super.e(j6);
        this.f10450p = j6 != 0;
        h0.d dVar = this.f10451q;
        this.f10449o = dVar != null ? dVar.f8387g : 0;
    }

    @Override // x0.i
    protected long f(i0 i0Var) {
        if ((i0Var.e()[0] & 1) == 1) {
            return -1L;
        }
        int o6 = o(i0Var.e()[0], (a) i2.a.i(this.f10448n));
        long j6 = this.f10450p ? (this.f10449o + o6) / 4 : 0;
        n(i0Var, j6);
        this.f10450p = true;
        this.f10449o = o6;
        return j6;
    }

    @Override // x0.i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected boolean h(i0 i0Var, long j6, i.b bVar) {
        if (this.f10448n != null) {
            i2.a.e(bVar.f10446a);
            return false;
        }
        a q6 = q(i0Var);
        this.f10448n = q6;
        if (q6 == null) {
            return true;
        }
        h0.d dVar = q6.f10453a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.f8390j);
        arrayList.add(q6.f10455c);
        bVar.f10446a = new y1.b().g0("audio/vorbis").I(dVar.f8385e).b0(dVar.f8384d).J(dVar.f8382b).h0(dVar.f8383c).V(arrayList).Z(h0.c(q.n(q6.f10454b.f8375b))).G();
        return true;
    }

    @Override // x0.i
    protected void l(boolean z5) {
        super.l(z5);
        if (z5) {
            this.f10448n = null;
            this.f10451q = null;
            this.f10452r = null;
        }
        this.f10449o = 0;
        this.f10450p = false;
    }

    a q(i0 i0Var) {
        h0.d dVar = this.f10451q;
        if (dVar == null) {
            this.f10451q = h0.k(i0Var);
            return null;
        }
        h0.b bVar = this.f10452r;
        if (bVar == null) {
            this.f10452r = h0.i(i0Var);
            return null;
        }
        byte[] bArr = new byte[i0Var.g()];
        System.arraycopy(i0Var.e(), 0, bArr, 0, i0Var.g());
        return new a(dVar, bVar, bArr, h0.l(i0Var, dVar.f8382b), h0.a(r4.length - 1));
    }
}
