package j0;

import a1.p;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import h0.n3;
import h0.x3;
import h0.y1;
import h0.y3;
import h0.z1;
import j0.v;
import j0.x;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public class j1 extends a1.w implements i2.v {
    private final Context H0;
    private final v.a I0;
    private final x J0;
    private int K0;
    private boolean L0;
    private y1 M0;
    private long N0;
    private boolean O0;
    private boolean P0;
    private boolean Q0;
    private boolean R0;
    private x3.a S0;

    private static final class b {
        public static void a(x xVar, Object obj) {
            xVar.setPreferredDevice((AudioDeviceInfo) obj);
        }
    }

    private final class c implements x.c {
        private c() {
        }

        @Override // j0.x.c
        public void a(long j6) {
            j1.this.I0.B(j6);
        }

        @Override // j0.x.c
        public void b(boolean z5) {
            j1.this.I0.C(z5);
        }

        @Override // j0.x.c
        public void c(Exception exc) {
            i2.t.d("MediaCodecAudioRenderer", "Audio sink error", exc);
            j1.this.I0.l(exc);
        }

        @Override // j0.x.c
        public void d() {
            j1.this.z1();
        }

        @Override // j0.x.c
        public void e() {
            if (j1.this.S0 != null) {
                j1.this.S0.a();
            }
        }

        @Override // j0.x.c
        public void f() {
            if (j1.this.S0 != null) {
                j1.this.S0.b();
            }
        }

        @Override // j0.x.c
        public void g(int i6, long j6, long j7) {
            j1.this.I0.D(i6, j6, j7);
        }
    }

    public j1(Context context, p.b bVar, a1.y yVar, boolean z5, Handler handler, v vVar, x xVar) {
        super(1, bVar, yVar, z5, 44100.0f);
        this.H0 = context.getApplicationContext();
        this.J0 = xVar;
        this.I0 = new v.a(handler, vVar);
        xVar.l(new c());
    }

    private void A1() {
        long r6 = this.J0.r(c());
        if (r6 != Long.MIN_VALUE) {
            if (!this.P0) {
                r6 = Math.max(this.N0, r6);
            }
            this.N0 = r6;
            this.P0 = false;
        }
    }

    private static boolean t1(String str) {
        if (i2.c1.f5548a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(i2.c1.f5550c)) {
            String str2 = i2.c1.f5549b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    private static boolean u1() {
        if (i2.c1.f5548a == 23) {
            String str = i2.c1.f5551d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int v1(a1.t tVar, y1 y1Var) {
        int i6;
        if (!"OMX.google.raw.decoder".equals(tVar.f85a) || (i6 = i2.c1.f5548a) >= 24 || (i6 == 23 && i2.c1.y0(this.H0))) {
            return y1Var.f5067q;
        }
        return -1;
    }

    private static List<a1.t> x1(a1.y yVar, y1 y1Var, boolean z5, x xVar) {
        a1.t v5;
        String str = y1Var.f5066p;
        if (str == null) {
            return m2.q.q();
        }
        if (xVar.a(y1Var) && (v5 = a1.h0.v()) != null) {
            return m2.q.r(v5);
        }
        List<a1.t> a6 = yVar.a(str, z5, false);
        String m6 = a1.h0.m(y1Var);
        return m6 == null ? m2.q.m(a6) : m2.q.k().g(a6).g(yVar.a(m6, z5, false)).h();
    }

    @Override // a1.w, h0.l
    protected void H() {
        this.Q0 = true;
        try {
            this.J0.flush();
            try {
                super.H();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.H();
                throw th;
            } finally {
            }
        }
    }

    @Override // a1.w, h0.l
    protected void I(boolean z5, boolean z6) {
        super.I(z5, z6);
        this.I0.p(this.C0);
        if (B().f4269a) {
            this.J0.e();
        } else {
            this.J0.s();
        }
        this.J0.j(E());
    }

    @Override // a1.w, h0.l
    protected void J(long j6, boolean z5) {
        super.J(j6, z5);
        if (this.R0) {
            this.J0.v();
        } else {
            this.J0.flush();
        }
        this.N0 = j6;
        this.O0 = true;
        this.P0 = true;
    }

    @Override // a1.w
    protected void J0(Exception exc) {
        i2.t.d("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.I0.k(exc);
    }

    @Override // a1.w, h0.l
    protected void K() {
        try {
            super.K();
        } finally {
            if (this.Q0) {
                this.Q0 = false;
                this.J0.reset();
            }
        }
    }

    @Override // a1.w
    protected void K0(String str, p.a aVar, long j6, long j7) {
        this.I0.m(str, j6, j7);
    }

    @Override // a1.w, h0.l
    protected void L() {
        super.L();
        this.J0.f();
    }

    @Override // a1.w
    protected void L0(String str) {
        this.I0.n(str);
    }

    @Override // a1.w, h0.l
    protected void M() {
        A1();
        this.J0.d();
        super.M();
    }

    @Override // a1.w
    protected l0.k M0(z1 z1Var) {
        l0.k M0 = super.M0(z1Var);
        this.I0.q(z1Var.f5109b, M0);
        return M0;
    }

    @Override // a1.w
    protected void N0(y1 y1Var, MediaFormat mediaFormat) {
        int i6;
        y1 y1Var2 = this.M0;
        int[] iArr = null;
        if (y1Var2 != null) {
            y1Var = y1Var2;
        } else if (p0() != null) {
            y1 G = new y1.b().g0("audio/raw").a0("audio/raw".equals(y1Var.f5066p) ? y1Var.E : (i2.c1.f5548a < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? i2.c1.d0(mediaFormat.getInteger("v-bits-per-sample")) : 2 : mediaFormat.getInteger("pcm-encoding")).P(y1Var.F).Q(y1Var.G).J(mediaFormat.getInteger("channel-count")).h0(mediaFormat.getInteger("sample-rate")).G();
            if (this.L0 && G.C == 6 && (i6 = y1Var.C) < 6) {
                iArr = new int[i6];
                for (int i7 = 0; i7 < y1Var.C; i7++) {
                    iArr[i7] = i7;
                }
            }
            y1Var = G;
        }
        try {
            this.J0.p(y1Var, 0, iArr);
        } catch (x.a e6) {
            throw z(e6, e6.f6617a, 5001);
        }
    }

    @Override // a1.w
    protected void O0(long j6) {
        this.J0.u(j6);
    }

    @Override // a1.w
    protected void Q0() {
        super.Q0();
        this.J0.x();
    }

    @Override // a1.w
    protected void R0(l0.i iVar) {
        if (!this.O0 || iVar.j()) {
            return;
        }
        if (Math.abs(iVar.f7164e - this.N0) > 500000) {
            this.N0 = iVar.f7164e;
        }
        this.O0 = false;
    }

    @Override // a1.w
    protected l0.k T(a1.t tVar, y1 y1Var, y1 y1Var2) {
        l0.k f6 = tVar.f(y1Var, y1Var2);
        int i6 = f6.f7176e;
        if (v1(tVar, y1Var2) > this.K0) {
            i6 |= 64;
        }
        int i7 = i6;
        return new l0.k(tVar.f85a, y1Var, y1Var2, i7 != 0 ? 0 : f6.f7175d, i7);
    }

    @Override // a1.w
    protected boolean T0(long j6, long j7, a1.p pVar, ByteBuffer byteBuffer, int i6, int i7, int i8, long j8, boolean z5, boolean z6, y1 y1Var) {
        i2.a.e(byteBuffer);
        if (this.M0 != null && (i7 & 2) != 0) {
            ((a1.p) i2.a.e(pVar)).e(i6, false);
            return true;
        }
        if (z5) {
            if (pVar != null) {
                pVar.e(i6, false);
            }
            this.C0.f7154f += i8;
            this.J0.x();
            return true;
        }
        try {
            if (!this.J0.q(byteBuffer, j8, i8)) {
                return false;
            }
            if (pVar != null) {
                pVar.e(i6, false);
            }
            this.C0.f7153e += i8;
            return true;
        } catch (x.b e6) {
            throw A(e6, e6.f6620c, e6.f6619b, 5001);
        } catch (x.e e7) {
            throw A(e7, y1Var, e7.f6624b, 5002);
        }
    }

    @Override // a1.w
    protected void Y0() {
        try {
            this.J0.g();
        } catch (x.e e6) {
            throw A(e6, e6.f6625c, e6.f6624b, 5002);
        }
    }

    @Override // a1.w, h0.x3
    public boolean c() {
        return super.c() && this.J0.c();
    }

    @Override // a1.w, h0.x3
    public boolean e() {
        return this.J0.k() || super.e();
    }

    @Override // h0.x3, h0.z3
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // i2.v
    public n3 h() {
        return this.J0.h();
    }

    @Override // i2.v
    public void i(n3 n3Var) {
        this.J0.i(n3Var);
    }

    @Override // a1.w
    protected boolean l1(y1 y1Var) {
        return this.J0.a(y1Var);
    }

    @Override // h0.l, h0.s3.b
    public void m(int i6, Object obj) {
        if (i6 == 2) {
            this.J0.m(((Float) obj).floatValue());
        }
        if (i6 == 3) {
            this.J0.b((e) obj);
            return;
        }
        if (i6 == 6) {
            this.J0.t((a0) obj);
            return;
        }
        switch (i6) {
            case 9:
                this.J0.w(((Boolean) obj).booleanValue());
                break;
            case 10:
                this.J0.o(((Integer) obj).intValue());
                break;
            case 11:
                this.S0 = (x3.a) obj;
                break;
            case 12:
                if (i2.c1.f5548a >= 23) {
                    b.a(this.J0, obj);
                    break;
                }
                break;
            default:
                super.m(i6, obj);
                break;
        }
    }

    @Override // a1.w
    protected int m1(a1.y yVar, y1 y1Var) {
        boolean z5;
        if (!i2.x.o(y1Var.f5066p)) {
            return y3.a(0);
        }
        int i6 = i2.c1.f5548a >= 21 ? 32 : 0;
        boolean z6 = true;
        boolean z7 = y1Var.K != 0;
        boolean n12 = a1.w.n1(y1Var);
        int i7 = 8;
        if (n12 && this.J0.a(y1Var) && (!z7 || a1.h0.v() != null)) {
            return y3.b(4, 8, i6);
        }
        if ((!"audio/raw".equals(y1Var.f5066p) || this.J0.a(y1Var)) && this.J0.a(i2.c1.e0(2, y1Var.C, y1Var.D))) {
            List<a1.t> x12 = x1(yVar, y1Var, false, this.J0);
            if (x12.isEmpty()) {
                return y3.a(1);
            }
            if (!n12) {
                return y3.a(2);
            }
            a1.t tVar = x12.get(0);
            boolean o6 = tVar.o(y1Var);
            if (!o6) {
                for (int i8 = 1; i8 < x12.size(); i8++) {
                    a1.t tVar2 = x12.get(i8);
                    if (tVar2.o(y1Var)) {
                        tVar = tVar2;
                        z5 = false;
                        break;
                    }
                }
            }
            z6 = o6;
            z5 = true;
            int i9 = z6 ? 4 : 3;
            if (z6 && tVar.r(y1Var)) {
                i7 = 16;
            }
            return y3.c(i9, i7, i6, tVar.f92h ? 64 : 0, z5 ? 128 : 0);
        }
        return y3.a(1);
    }

    @Override // a1.w
    protected float s0(float f6, y1 y1Var, y1[] y1VarArr) {
        int i6 = -1;
        for (y1 y1Var2 : y1VarArr) {
            int i7 = y1Var2.D;
            if (i7 != -1) {
                i6 = Math.max(i6, i7);
            }
        }
        if (i6 == -1) {
            return -1.0f;
        }
        return f6 * i6;
    }

    @Override // h0.l, h0.x3
    public i2.v u() {
        return this;
    }

    @Override // a1.w
    protected List<a1.t> u0(a1.y yVar, y1 y1Var, boolean z5) {
        return a1.h0.u(x1(yVar, y1Var, z5, this.J0), y1Var);
    }

    @Override // a1.w
    protected p.a w0(a1.t tVar, y1 y1Var, MediaCrypto mediaCrypto, float f6) {
        this.K0 = w1(tVar, y1Var, F());
        this.L0 = t1(tVar.f85a);
        MediaFormat y12 = y1(y1Var, tVar.f87c, this.K0, f6);
        this.M0 = "audio/raw".equals(tVar.f86b) && !"audio/raw".equals(y1Var.f5066p) ? y1Var : null;
        return p.a.a(tVar, y12, y1Var, mediaCrypto);
    }

    protected int w1(a1.t tVar, y1 y1Var, y1[] y1VarArr) {
        int v12 = v1(tVar, y1Var);
        if (y1VarArr.length == 1) {
            return v12;
        }
        for (y1 y1Var2 : y1VarArr) {
            if (tVar.f(y1Var, y1Var2).f7175d != 0) {
                v12 = Math.max(v12, v1(tVar, y1Var2));
            }
        }
        return v12;
    }

    @Override // i2.v
    public long x() {
        if (getState() == 2) {
            A1();
        }
        return this.N0;
    }

    protected MediaFormat y1(y1 y1Var, String str, int i6, float f6) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", y1Var.C);
        mediaFormat.setInteger("sample-rate", y1Var.D);
        i2.w.e(mediaFormat, y1Var.f5068r);
        i2.w.d(mediaFormat, "max-input-size", i6);
        int i7 = i2.c1.f5548a;
        if (i7 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f6 != -1.0f && !u1()) {
                mediaFormat.setFloat("operating-rate", f6);
            }
        }
        if (i7 <= 28 && "audio/ac4".equals(y1Var.f5066p)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i7 >= 24 && this.J0.n(i2.c1.e0(4, y1Var.C, y1Var.D)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i7 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        return mediaFormat;
    }

    protected void z1() {
        this.P0 = true;
    }
}
