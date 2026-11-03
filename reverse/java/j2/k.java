package j2;

import a1.h0;
import a1.p;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import com.tendcloud.tenddata.ab;
import h0.y1;
import h0.y3;
import h0.z1;
import i2.c1;
import i2.s0;
import j2.b0;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public class k extends a1.w {

    /* renamed from: r1, reason: collision with root package name */
    private static final int[] f6721r1 = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};

    /* renamed from: s1, reason: collision with root package name */
    private static boolean f6722s1;

    /* renamed from: t1, reason: collision with root package name */
    private static boolean f6723t1;
    private final Context H0;
    private final p I0;
    private final b0.a J0;
    private final long K0;
    private final int L0;
    private final boolean M0;
    private b N0;
    private boolean O0;
    private boolean P0;
    private Surface Q0;
    private l R0;
    private boolean S0;
    private int T0;
    private boolean U0;
    private boolean V0;
    private boolean W0;
    private long X0;
    private long Y0;
    private long Z0;

    /* renamed from: a1, reason: collision with root package name */
    private int f6724a1;

    /* renamed from: b1, reason: collision with root package name */
    private int f6725b1;

    /* renamed from: c1, reason: collision with root package name */
    private int f6726c1;

    /* renamed from: d1, reason: collision with root package name */
    private long f6727d1;

    /* renamed from: e1, reason: collision with root package name */
    private long f6728e1;

    /* renamed from: f1, reason: collision with root package name */
    private long f6729f1;

    /* renamed from: g1, reason: collision with root package name */
    private int f6730g1;

    /* renamed from: h1, reason: collision with root package name */
    private long f6731h1;

    /* renamed from: i1, reason: collision with root package name */
    private int f6732i1;

    /* renamed from: j1, reason: collision with root package name */
    private int f6733j1;

    /* renamed from: k1, reason: collision with root package name */
    private int f6734k1;

    /* renamed from: l1, reason: collision with root package name */
    private float f6735l1;

    /* renamed from: m1, reason: collision with root package name */
    private d0 f6736m1;

    /* renamed from: n1, reason: collision with root package name */
    private boolean f6737n1;

    /* renamed from: o1, reason: collision with root package name */
    private int f6738o1;

    /* renamed from: p1, reason: collision with root package name */
    c f6739p1;

    /* renamed from: q1, reason: collision with root package name */
    private m f6740q1;

    private static final class a {
        public static boolean a(Context context) {
            boolean isHdr;
            Display.HdrCapabilities hdrCapabilities;
            int[] supportedHdrTypes;
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display == null) {
                return false;
            }
            isHdr = display.isHdr();
            if (!isHdr) {
                return false;
            }
            hdrCapabilities = display.getHdrCapabilities();
            supportedHdrTypes = hdrCapabilities.getSupportedHdrTypes();
            for (int i6 : supportedHdrTypes) {
                if (i6 == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    protected static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f6741a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6742b;

        /* renamed from: c, reason: collision with root package name */
        public final int f6743c;

        public b(int i6, int i7, int i8) {
            this.f6741a = i6;
            this.f6742b = i7;
            this.f6743c = i8;
        }
    }

    private final class c implements p.c, Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f6744a;

        public c(a1.p pVar) {
            Handler x5 = c1.x(this);
            this.f6744a = x5;
            pVar.f(this, x5);
        }

        private void b(long j6) {
            k kVar = k.this;
            if (this != kVar.f6739p1 || kVar.p0() == null) {
                return;
            }
            if (j6 == Long.MAX_VALUE) {
                k.this.T1();
                return;
            }
            try {
                k.this.S1(j6);
            } catch (h0.x e6) {
                k.this.g1(e6);
            }
        }

        @Override // a1.p.c
        public void a(a1.p pVar, long j6, long j7) {
            if (c1.f5548a >= 30) {
                b(j6);
            } else {
                this.f6744a.sendMessageAtFrontOfQueue(Message.obtain(this.f6744a, 0, (int) (j6 >> 32), (int) j6));
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b(c1.a1(message.arg1, message.arg2));
            return true;
        }
    }

    public k(Context context, p.b bVar, a1.y yVar, long j6, boolean z5, Handler handler, b0 b0Var, int i6) {
        this(context, bVar, yVar, j6, z5, handler, b0Var, i6, 30.0f);
    }

    public k(Context context, p.b bVar, a1.y yVar, long j6, boolean z5, Handler handler, b0 b0Var, int i6, float f6) {
        super(2, bVar, yVar, z5, f6);
        this.K0 = j6;
        this.L0 = i6;
        Context applicationContext = context.getApplicationContext();
        this.H0 = applicationContext;
        this.I0 = new p(applicationContext);
        this.J0 = new b0.a(handler, b0Var);
        this.M0 = y1();
        this.Y0 = -9223372036854775807L;
        this.f6732i1 = -1;
        this.f6733j1 = -1;
        this.f6735l1 = -1.0f;
        this.T0 = 1;
        this.f6738o1 = 0;
        v1();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x0848, code lost:
    
        if (r0.equals("PGN528") == false) goto L91;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean A1() {
        /*
            Method dump skipped, instructions count: 3186
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.k.A1():boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x007a, code lost:
    
        if (r3.equals("video/av01") == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int B1(a1.t r9, h0.y1 r10) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.k.B1(a1.t, h0.y1):int");
    }

    private static Point C1(a1.t tVar, y1 y1Var) {
        int i6 = y1Var.f5072v;
        int i7 = y1Var.f5071u;
        boolean z5 = i6 > i7;
        int i8 = z5 ? i6 : i7;
        if (z5) {
            i6 = i7;
        }
        float f6 = i6 / i8;
        for (int i9 : f6721r1) {
            int i10 = (int) (i9 * f6);
            if (i9 <= i8 || i10 <= i6) {
                break;
            }
            if (c1.f5548a >= 21) {
                int i11 = z5 ? i10 : i9;
                if (!z5) {
                    i9 = i10;
                }
                Point c6 = tVar.c(i11, i9);
                if (tVar.w(c6.x, c6.y, y1Var.f5073w)) {
                    return c6;
                }
            } else {
                try {
                    int l6 = c1.l(i9, 16) * 16;
                    int l7 = c1.l(i10, 16) * 16;
                    if (l6 * l7 <= h0.N()) {
                        int i12 = z5 ? l7 : l6;
                        if (!z5) {
                            l6 = l7;
                        }
                        return new Point(i12, l6);
                    }
                } catch (h0.c unused) {
                }
            }
        }
        return null;
    }

    private static List<a1.t> E1(Context context, a1.y yVar, y1 y1Var, boolean z5, boolean z6) {
        String str = y1Var.f5066p;
        if (str == null) {
            return m2.q.q();
        }
        List<a1.t> a6 = yVar.a(str, z5, z6);
        String m6 = h0.m(y1Var);
        if (m6 == null) {
            return m2.q.m(a6);
        }
        List<a1.t> a7 = yVar.a(m6, z5, z6);
        return (c1.f5548a < 26 || !"video/dolby-vision".equals(y1Var.f5066p) || a7.isEmpty() || a.a(context)) ? m2.q.k().g(a6).g(a7).h() : m2.q.m(a7);
    }

    protected static int F1(a1.t tVar, y1 y1Var) {
        if (y1Var.f5067q == -1) {
            return B1(tVar, y1Var);
        }
        int size = y1Var.f5068r.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            i6 += y1Var.f5068r.get(i7).length;
        }
        return y1Var.f5067q + i6;
    }

    private static int G1(int i6, int i7) {
        return (i6 * 3) / (i7 * 2);
    }

    private static boolean I1(long j6) {
        return j6 < -30000;
    }

    private static boolean J1(long j6) {
        return j6 < -500000;
    }

    private void L1() {
        if (this.f6724a1 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.J0.n(this.f6724a1, elapsedRealtime - this.Z0);
            this.f6724a1 = 0;
            this.Z0 = elapsedRealtime;
        }
    }

    private void N1() {
        int i6 = this.f6730g1;
        if (i6 != 0) {
            this.J0.B(this.f6729f1, i6);
            this.f6729f1 = 0L;
            this.f6730g1 = 0;
        }
    }

    private void O1() {
        int i6 = this.f6732i1;
        if (i6 == -1 && this.f6733j1 == -1) {
            return;
        }
        d0 d0Var = this.f6736m1;
        if (d0Var != null && d0Var.f6695a == i6 && d0Var.f6696b == this.f6733j1 && d0Var.f6697c == this.f6734k1 && d0Var.f6698d == this.f6735l1) {
            return;
        }
        d0 d0Var2 = new d0(this.f6732i1, this.f6733j1, this.f6734k1, this.f6735l1);
        this.f6736m1 = d0Var2;
        this.J0.D(d0Var2);
    }

    private void P1() {
        if (this.S0) {
            this.J0.A(this.Q0);
        }
    }

    private void Q1() {
        d0 d0Var = this.f6736m1;
        if (d0Var != null) {
            this.J0.D(d0Var);
        }
    }

    private void R1(long j6, long j7, y1 y1Var) {
        m mVar = this.f6740q1;
        if (mVar != null) {
            mVar.h(j6, j7, y1Var, t0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1() {
        f1();
    }

    private void U1() {
        Surface surface = this.Q0;
        l lVar = this.R0;
        if (surface == lVar) {
            this.Q0 = null;
        }
        lVar.release();
        this.R0 = null;
    }

    private static void X1(a1.p pVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        pVar.l(bundle);
    }

    private void Y1() {
        this.Y0 = this.K0 > 0 ? SystemClock.elapsedRealtime() + this.K0 : -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [a1.w, h0.l, j2.k] */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.view.Surface] */
    private void Z1(Object obj) {
        l lVar = obj instanceof Surface ? (Surface) obj : null;
        if (lVar == null) {
            l lVar2 = this.R0;
            if (lVar2 != null) {
                lVar = lVar2;
            } else {
                a1.t q02 = q0();
                if (q02 != null && e2(q02)) {
                    lVar = l.f(this.H0, q02.f91g);
                    this.R0 = lVar;
                }
            }
        }
        if (this.Q0 == lVar) {
            if (lVar == null || lVar == this.R0) {
                return;
            }
            Q1();
            P1();
            return;
        }
        this.Q0 = lVar;
        this.I0.m(lVar);
        this.S0 = false;
        int state = getState();
        a1.p p02 = p0();
        if (p02 != null) {
            if (c1.f5548a < 23 || lVar == null || this.O0) {
                X0();
                H0();
            } else {
                a2(p02, lVar);
            }
        }
        if (lVar == null || lVar == this.R0) {
            v1();
            u1();
            return;
        }
        Q1();
        u1();
        if (state == 2) {
            Y1();
        }
    }

    private boolean e2(a1.t tVar) {
        return c1.f5548a >= 23 && !this.f6737n1 && !w1(tVar.f85a) && (!tVar.f91g || l.e(this.H0));
    }

    private void u1() {
        a1.p p02;
        this.U0 = false;
        if (c1.f5548a < 23 || !this.f6737n1 || (p02 = p0()) == null) {
            return;
        }
        this.f6739p1 = new c(p02);
    }

    private void v1() {
        this.f6736m1 = null;
    }

    private static void x1(MediaFormat mediaFormat, int i6) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i6);
    }

    private static boolean y1() {
        return "NVIDIA".equals(c1.f5550c);
    }

    protected b D1(a1.t tVar, y1 y1Var, y1[] y1VarArr) {
        int B1;
        int i6 = y1Var.f5071u;
        int i7 = y1Var.f5072v;
        int F1 = F1(tVar, y1Var);
        if (y1VarArr.length == 1) {
            if (F1 != -1 && (B1 = B1(tVar, y1Var)) != -1) {
                F1 = Math.min((int) (F1 * 1.5f), B1);
            }
            return new b(i6, i7, F1);
        }
        int length = y1VarArr.length;
        boolean z5 = false;
        for (int i8 = 0; i8 < length; i8++) {
            y1 y1Var2 = y1VarArr[i8];
            if (y1Var.B != null && y1Var2.B == null) {
                y1Var2 = y1Var2.b().L(y1Var.B).G();
            }
            if (tVar.f(y1Var, y1Var2).f7175d != 0) {
                int i9 = y1Var2.f5071u;
                z5 |= i9 == -1 || y1Var2.f5072v == -1;
                i6 = Math.max(i6, i9);
                i7 = Math.max(i7, y1Var2.f5072v);
                F1 = Math.max(F1, F1(tVar, y1Var2));
            }
        }
        if (z5) {
            i2.t.i("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + i6 + "x" + i7);
            Point C1 = C1(tVar, y1Var);
            if (C1 != null) {
                i6 = Math.max(i6, C1.x);
                i7 = Math.max(i7, C1.y);
                F1 = Math.max(F1, B1(tVar, y1Var.b().n0(i6).S(i7).G()));
                i2.t.i("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + i6 + "x" + i7);
            }
        }
        return new b(i6, i7, F1);
    }

    @Override // a1.w, h0.l
    protected void H() {
        v1();
        u1();
        this.S0 = false;
        this.f6739p1 = null;
        try {
            super.H();
        } finally {
            this.J0.m(this.C0);
        }
    }

    protected MediaFormat H1(y1 y1Var, String str, b bVar, float f6, boolean z5, int i6) {
        Pair<Integer, Integer> q6;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", y1Var.f5071u);
        mediaFormat.setInteger("height", y1Var.f5072v);
        i2.w.e(mediaFormat, y1Var.f5068r);
        i2.w.c(mediaFormat, "frame-rate", y1Var.f5073w);
        i2.w.d(mediaFormat, "rotation-degrees", y1Var.f5074x);
        i2.w.b(mediaFormat, y1Var.B);
        if ("video/dolby-vision".equals(y1Var.f5066p) && (q6 = h0.q(y1Var)) != null) {
            i2.w.d(mediaFormat, "profile", ((Integer) q6.first).intValue());
        }
        mediaFormat.setInteger("max-width", bVar.f6741a);
        mediaFormat.setInteger("max-height", bVar.f6742b);
        i2.w.d(mediaFormat, "max-input-size", bVar.f6743c);
        if (c1.f5548a >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f6 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f6);
            }
        }
        if (z5) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i6 != 0) {
            x1(mediaFormat, i6);
        }
        return mediaFormat;
    }

    @Override // a1.w, h0.l
    protected void I(boolean z5, boolean z6) {
        super.I(z5, z6);
        boolean z7 = B().f4269a;
        i2.a.g((z7 && this.f6738o1 == 0) ? false : true);
        if (this.f6737n1 != z7) {
            this.f6737n1 = z7;
            X0();
        }
        this.J0.o(this.C0);
        this.V0 = z6;
        this.W0 = false;
    }

    @Override // a1.w, h0.l
    protected void J(long j6, boolean z5) {
        super.J(j6, z5);
        u1();
        this.I0.j();
        this.f6727d1 = -9223372036854775807L;
        this.X0 = -9223372036854775807L;
        this.f6725b1 = 0;
        if (z5) {
            Y1();
        } else {
            this.Y0 = -9223372036854775807L;
        }
    }

    @Override // a1.w
    protected void J0(Exception exc) {
        i2.t.d("MediaCodecVideoRenderer", "Video codec error", exc);
        this.J0.C(exc);
    }

    @Override // a1.w, h0.l
    protected void K() {
        try {
            super.K();
        } finally {
            if (this.R0 != null) {
                U1();
            }
        }
    }

    @Override // a1.w
    protected void K0(String str, p.a aVar, long j6, long j7) {
        this.J0.k(str, j6, j7);
        this.O0 = w1(str);
        this.P0 = ((a1.t) i2.a.e(q0())).p();
        if (c1.f5548a < 23 || !this.f6737n1) {
            return;
        }
        this.f6739p1 = new c((a1.p) i2.a.e(p0()));
    }

    protected boolean K1(long j6, boolean z5) {
        int Q = Q(j6);
        if (Q == 0) {
            return false;
        }
        if (z5) {
            l0.g gVar = this.C0;
            gVar.f7152d += Q;
            gVar.f7154f += this.f6726c1;
        } else {
            this.C0.f7158j++;
            g2(Q, this.f6726c1);
        }
        m0();
        return true;
    }

    @Override // a1.w, h0.l
    protected void L() {
        super.L();
        this.f6724a1 = 0;
        this.Z0 = SystemClock.elapsedRealtime();
        this.f6728e1 = SystemClock.elapsedRealtime() * 1000;
        this.f6729f1 = 0L;
        this.f6730g1 = 0;
        this.I0.k();
    }

    @Override // a1.w
    protected void L0(String str) {
        this.J0.l(str);
    }

    @Override // a1.w, h0.l
    protected void M() {
        this.Y0 = -9223372036854775807L;
        L1();
        N1();
        this.I0.l();
        super.M();
    }

    @Override // a1.w
    protected l0.k M0(z1 z1Var) {
        l0.k M0 = super.M0(z1Var);
        this.J0.p(z1Var.f5109b, M0);
        return M0;
    }

    void M1() {
        this.W0 = true;
        if (this.U0) {
            return;
        }
        this.U0 = true;
        this.J0.A(this.Q0);
        this.S0 = true;
    }

    @Override // a1.w
    protected void N0(y1 y1Var, MediaFormat mediaFormat) {
        a1.p p02 = p0();
        if (p02 != null) {
            p02.g(this.T0);
        }
        if (this.f6737n1) {
            this.f6732i1 = y1Var.f5071u;
            this.f6733j1 = y1Var.f5072v;
        } else {
            i2.a.e(mediaFormat);
            boolean z5 = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
            this.f6732i1 = z5 ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
            this.f6733j1 = z5 ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        }
        float f6 = y1Var.f5075y;
        this.f6735l1 = f6;
        if (c1.f5548a >= 21) {
            int i6 = y1Var.f5074x;
            if (i6 == 90 || i6 == 270) {
                int i7 = this.f6732i1;
                this.f6732i1 = this.f6733j1;
                this.f6733j1 = i7;
                this.f6735l1 = 1.0f / f6;
            }
        } else {
            this.f6734k1 = y1Var.f5074x;
        }
        this.I0.g(y1Var.f5073w);
    }

    @Override // a1.w
    protected void P0(long j6) {
        super.P0(j6);
        if (this.f6737n1) {
            return;
        }
        this.f6726c1--;
    }

    @Override // a1.w
    protected void Q0() {
        super.Q0();
        u1();
    }

    @Override // a1.w
    protected void R0(l0.i iVar) {
        boolean z5 = this.f6737n1;
        if (!z5) {
            this.f6726c1++;
        }
        if (c1.f5548a >= 23 || !z5) {
            return;
        }
        S1(iVar.f7164e);
    }

    protected void S1(long j6) {
        q1(j6);
        O1();
        this.C0.f7153e++;
        M1();
        P0(j6);
    }

    @Override // a1.w
    protected l0.k T(a1.t tVar, y1 y1Var, y1 y1Var2) {
        l0.k f6 = tVar.f(y1Var, y1Var2);
        int i6 = f6.f7176e;
        int i7 = y1Var2.f5071u;
        b bVar = this.N0;
        if (i7 > bVar.f6741a || y1Var2.f5072v > bVar.f6742b) {
            i6 |= 256;
        }
        if (F1(tVar, y1Var2) > this.N0.f6743c) {
            i6 |= 64;
        }
        int i8 = i6;
        return new l0.k(tVar.f85a, y1Var, y1Var2, i8 != 0 ? 0 : f6.f7175d, i8);
    }

    @Override // a1.w
    protected boolean T0(long j6, long j7, a1.p pVar, ByteBuffer byteBuffer, int i6, int i7, int i8, long j8, boolean z5, boolean z6, y1 y1Var) {
        long j9;
        boolean z7;
        i2.a.e(pVar);
        if (this.X0 == -9223372036854775807L) {
            this.X0 = j6;
        }
        if (j8 != this.f6727d1) {
            this.I0.h(j8);
            this.f6727d1 = j8;
        }
        long x02 = x0();
        long j10 = j8 - x02;
        if (z5 && !z6) {
            f2(pVar, i6, j10);
            return true;
        }
        double y02 = y0();
        boolean z8 = getState() == 2;
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        long j11 = (long) ((j8 - j6) / y02);
        if (z8) {
            j11 -= elapsedRealtime - j7;
        }
        if (this.Q0 == this.R0) {
            if (!I1(j11)) {
                return false;
            }
            f2(pVar, i6, j10);
            h2(j11);
            return true;
        }
        long j12 = elapsedRealtime - this.f6728e1;
        if (this.W0 ? this.U0 : !(z8 || this.V0)) {
            j9 = j12;
            z7 = false;
        } else {
            j9 = j12;
            z7 = true;
        }
        if (!(this.Y0 == -9223372036854775807L && j6 >= x02 && (z7 || (z8 && d2(j11, j9))))) {
            if (z8 && j6 != this.X0) {
                long nanoTime = System.nanoTime();
                long b6 = this.I0.b((j11 * 1000) + nanoTime);
                long j13 = (b6 - nanoTime) / 1000;
                boolean z9 = this.Y0 != -9223372036854775807L;
                if (b2(j13, j7, z6) && K1(j6, z9)) {
                    return false;
                }
                if (c2(j13, j7, z6)) {
                    if (z9) {
                        f2(pVar, i6, j10);
                    } else {
                        z1(pVar, i6, j10);
                    }
                    j11 = j13;
                } else {
                    j11 = j13;
                    if (c1.f5548a >= 21) {
                        if (j11 < 50000) {
                            if (b6 == this.f6731h1) {
                                f2(pVar, i6, j10);
                            } else {
                                R1(j10, b6, y1Var);
                                W1(pVar, i6, j10, b6);
                            }
                            h2(j11);
                            this.f6731h1 = b6;
                            return true;
                        }
                    } else if (j11 < ab.aa) {
                        if (j11 > 11000) {
                            try {
                                Thread.sleep((j11 - 10000) / 1000);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                return false;
                            }
                        }
                        R1(j10, b6, y1Var);
                        V1(pVar, i6, j10);
                    }
                }
            }
            return false;
        }
        long nanoTime2 = System.nanoTime();
        R1(j10, nanoTime2, y1Var);
        if (c1.f5548a >= 21) {
            W1(pVar, i6, j10, nanoTime2);
        }
        V1(pVar, i6, j10);
        h2(j11);
        return true;
    }

    protected void V1(a1.p pVar, int i6, long j6) {
        O1();
        s0.a("releaseOutputBuffer");
        pVar.e(i6, true);
        s0.c();
        this.f6728e1 = SystemClock.elapsedRealtime() * 1000;
        this.C0.f7153e++;
        this.f6725b1 = 0;
        M1();
    }

    protected void W1(a1.p pVar, int i6, long j6, long j7) {
        O1();
        s0.a("releaseOutputBuffer");
        pVar.n(i6, j7);
        s0.c();
        this.f6728e1 = SystemClock.elapsedRealtime() * 1000;
        this.C0.f7153e++;
        this.f6725b1 = 0;
        M1();
    }

    @Override // a1.w
    protected void Z0() {
        super.Z0();
        this.f6726c1 = 0;
    }

    protected void a2(a1.p pVar, Surface surface) {
        pVar.j(surface);
    }

    protected boolean b2(long j6, long j7, boolean z5) {
        return J1(j6) && !z5;
    }

    protected boolean c2(long j6, long j7, boolean z5) {
        return I1(j6) && !z5;
    }

    @Override // a1.w
    protected a1.q d0(Throwable th, a1.t tVar) {
        return new g(th, tVar, this.Q0);
    }

    protected boolean d2(long j6, long j7) {
        return I1(j6) && j7 > 100000;
    }

    @Override // a1.w, h0.x3
    public boolean e() {
        l lVar;
        if (super.e() && (this.U0 || (((lVar = this.R0) != null && this.Q0 == lVar) || p0() == null || this.f6737n1))) {
            this.Y0 = -9223372036854775807L;
            return true;
        }
        if (this.Y0 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.Y0) {
            return true;
        }
        this.Y0 = -9223372036854775807L;
        return false;
    }

    protected void f2(a1.p pVar, int i6, long j6) {
        s0.a("skipVideoBuffer");
        pVar.e(i6, false);
        s0.c();
        this.C0.f7154f++;
    }

    protected void g2(int i6, int i7) {
        l0.g gVar = this.C0;
        gVar.f7156h += i6;
        int i8 = i6 + i7;
        gVar.f7155g += i8;
        this.f6724a1 += i8;
        int i9 = this.f6725b1 + i8;
        this.f6725b1 = i9;
        gVar.f7157i = Math.max(i9, gVar.f7157i);
        int i10 = this.L0;
        if (i10 <= 0 || this.f6724a1 < i10) {
            return;
        }
        L1();
    }

    @Override // h0.x3, h0.z3
    public String getName() {
        return "MediaCodecVideoRenderer";
    }

    protected void h2(long j6) {
        this.C0.a(j6);
        this.f6729f1 += j6;
        this.f6730g1++;
    }

    @Override // a1.w
    protected boolean j1(a1.t tVar) {
        return this.Q0 != null || e2(tVar);
    }

    @Override // h0.l, h0.s3.b
    public void m(int i6, Object obj) {
        if (i6 == 1) {
            Z1(obj);
            return;
        }
        if (i6 == 7) {
            this.f6740q1 = (m) obj;
            return;
        }
        if (i6 == 10) {
            int intValue = ((Integer) obj).intValue();
            if (this.f6738o1 != intValue) {
                this.f6738o1 = intValue;
                if (this.f6737n1) {
                    X0();
                    return;
                }
                return;
            }
            return;
        }
        if (i6 != 4) {
            if (i6 != 5) {
                super.m(i6, obj);
                return;
            } else {
                this.I0.o(((Integer) obj).intValue());
                return;
            }
        }
        this.T0 = ((Integer) obj).intValue();
        a1.p p02 = p0();
        if (p02 != null) {
            p02.g(this.T0);
        }
    }

    @Override // a1.w
    protected int m1(a1.y yVar, y1 y1Var) {
        boolean z5;
        int i6 = 0;
        if (!i2.x.s(y1Var.f5066p)) {
            return y3.a(0);
        }
        boolean z6 = y1Var.f5069s != null;
        List<a1.t> E1 = E1(this.H0, yVar, y1Var, z6, false);
        if (z6 && E1.isEmpty()) {
            E1 = E1(this.H0, yVar, y1Var, false, false);
        }
        if (E1.isEmpty()) {
            return y3.a(1);
        }
        if (!a1.w.n1(y1Var)) {
            return y3.a(2);
        }
        a1.t tVar = E1.get(0);
        boolean o6 = tVar.o(y1Var);
        if (!o6) {
            for (int i7 = 1; i7 < E1.size(); i7++) {
                a1.t tVar2 = E1.get(i7);
                if (tVar2.o(y1Var)) {
                    tVar = tVar2;
                    z5 = false;
                    o6 = true;
                    break;
                }
            }
        }
        z5 = true;
        int i8 = o6 ? 4 : 3;
        int i9 = tVar.r(y1Var) ? 16 : 8;
        int i10 = tVar.f92h ? 64 : 0;
        int i11 = z5 ? 128 : 0;
        if (c1.f5548a >= 26 && "video/dolby-vision".equals(y1Var.f5066p) && !a.a(this.H0)) {
            i11 = 256;
        }
        if (o6) {
            List<a1.t> E12 = E1(this.H0, yVar, y1Var, z6, true);
            if (!E12.isEmpty()) {
                a1.t tVar3 = h0.u(E12, y1Var).get(0);
                if (tVar3.o(y1Var) && tVar3.r(y1Var)) {
                    i6 = 32;
                }
            }
        }
        return y3.c(i8, i9, i6, i10, i11);
    }

    @Override // a1.w
    protected boolean r0() {
        return this.f6737n1 && c1.f5548a < 23;
    }

    @Override // a1.w
    protected float s0(float f6, y1 y1Var, y1[] y1VarArr) {
        float f7 = -1.0f;
        for (y1 y1Var2 : y1VarArr) {
            float f8 = y1Var2.f5073w;
            if (f8 != -1.0f) {
                f7 = Math.max(f7, f8);
            }
        }
        if (f7 == -1.0f) {
            return -1.0f;
        }
        return f7 * f6;
    }

    @Override // a1.w
    protected List<a1.t> u0(a1.y yVar, y1 y1Var, boolean z5) {
        return h0.u(E1(this.H0, yVar, y1Var, z5, this.f6737n1), y1Var);
    }

    @Override // a1.w
    protected p.a w0(a1.t tVar, y1 y1Var, MediaCrypto mediaCrypto, float f6) {
        l lVar = this.R0;
        if (lVar != null && lVar.f6748a != tVar.f91g) {
            U1();
        }
        String str = tVar.f87c;
        b D1 = D1(tVar, y1Var, F());
        this.N0 = D1;
        MediaFormat H1 = H1(y1Var, str, D1, f6, this.M0, this.f6737n1 ? this.f6738o1 : 0);
        if (this.Q0 == null) {
            if (!e2(tVar)) {
                throw new IllegalStateException();
            }
            if (this.R0 == null) {
                this.R0 = l.f(this.H0, tVar.f91g);
            }
            this.Q0 = this.R0;
        }
        return p.a.b(tVar, H1, y1Var, this.Q0, mediaCrypto);
    }

    protected boolean w1(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (k.class) {
            if (!f6722s1) {
                f6723t1 = A1();
                f6722s1 = true;
            }
        }
        return f6723t1;
    }

    @Override // a1.w, h0.l, h0.x3
    public void y(float f6, float f7) {
        super.y(f6, f7);
        this.I0.i(f6);
    }

    @Override // a1.w
    protected void z0(l0.i iVar) {
        if (this.P0) {
            ByteBuffer byteBuffer = (ByteBuffer) i2.a.e(iVar.f7165j);
            if (byteBuffer.remaining() >= 7) {
                byte b6 = byteBuffer.get();
                short s5 = byteBuffer.getShort();
                short s6 = byteBuffer.getShort();
                byte b7 = byteBuffer.get();
                byte b8 = byteBuffer.get();
                byteBuffer.position(0);
                if (b6 == -75 && s5 == 60 && s6 == 1 && b7 == 4) {
                    if (b8 == 0 || b8 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        X1(p0(), bArr);
                    }
                }
            }
        }
    }

    protected void z1(a1.p pVar, int i6, long j6) {
        s0.a("dropVideoBuffer");
        pVar.e(i6, false);
        s0.c();
        g2(0, 1);
    }
}
