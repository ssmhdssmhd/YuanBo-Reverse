package a1;

import a1.h0;
import a1.p;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.os.SystemClock;
import h0.y1;
import h0.z1;
import i0.o3;
import i2.c1;
import i2.q0;
import i2.s0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import l0.i;
import m0.o;

/* loaded from: classes.dex */
public abstract class w extends h0.l {
    private static final byte[] G0 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private final MediaCodec.BufferInfo A;
    private boolean A0;
    private final ArrayDeque<c> B;
    private h0.x B0;
    private y1 C;
    protected l0.g C0;
    private y1 D;
    private c D0;
    private m0.o E;
    private long E0;
    private m0.o F;
    private boolean F0;
    private MediaCrypto G;
    private boolean H;
    private long I;
    private float J;
    private float K;
    private p L;
    private y1 M;
    private MediaFormat N;
    private boolean O;
    private float P;
    private ArrayDeque<t> Q;
    private b R;
    private t S;
    private int T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f96a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f97b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f98c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f99d0;

    /* renamed from: e0, reason: collision with root package name */
    private m f100e0;

    /* renamed from: f0, reason: collision with root package name */
    private long f101f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f102g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f103h0;

    /* renamed from: i0, reason: collision with root package name */
    private ByteBuffer f104i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f105j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f106k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f107l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f108m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f109n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f110o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f111p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f112q0;

    /* renamed from: r, reason: collision with root package name */
    private final p.b f113r;

    /* renamed from: r0, reason: collision with root package name */
    private int f114r0;

    /* renamed from: s, reason: collision with root package name */
    private final y f115s;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f116s0;

    /* renamed from: t, reason: collision with root package name */
    private final boolean f117t;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f118t0;

    /* renamed from: u, reason: collision with root package name */
    private final float f119u;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f120u0;

    /* renamed from: v, reason: collision with root package name */
    private final l0.i f121v;

    /* renamed from: v0, reason: collision with root package name */
    private long f122v0;

    /* renamed from: w, reason: collision with root package name */
    private final l0.i f123w;

    /* renamed from: w0, reason: collision with root package name */
    private long f124w0;

    /* renamed from: x, reason: collision with root package name */
    private final l0.i f125x;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f126x0;

    /* renamed from: y, reason: collision with root package name */
    private final l f127y;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f128y0;

    /* renamed from: z, reason: collision with root package name */
    private final ArrayList<Long> f129z;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f130z0;

    private static final class a {
        public static void a(p.a aVar, o3 o3Var) {
            LogSessionId logSessionId;
            boolean equals;
            String stringId;
            LogSessionId a6 = o3Var.a();
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            equals = a6.equals(logSessionId);
            if (equals) {
                return;
            }
            MediaFormat mediaFormat = aVar.f78b;
            stringId = a6.getStringId();
            mediaFormat.setString("log-session-id", stringId);
        }
    }

    public static class b extends Exception {

        /* renamed from: a, reason: collision with root package name */
        public final String f131a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f132b;

        /* renamed from: c, reason: collision with root package name */
        public final t f133c;

        /* renamed from: d, reason: collision with root package name */
        public final String f134d;

        /* renamed from: e, reason: collision with root package name */
        public final b f135e;

        public b(y1 y1Var, Throwable th, boolean z5, int i6) {
            this("Decoder init failed: [" + i6 + "], " + y1Var, th, y1Var.f5066p, z5, null, b(i6), null);
        }

        public b(y1 y1Var, Throwable th, boolean z5, t tVar) {
            this("Decoder init failed: " + tVar.f85a + ", " + y1Var, th, y1Var.f5066p, z5, tVar, c1.f5548a >= 21 ? d(th) : null, null);
        }

        private b(String str, Throwable th, String str2, boolean z5, t tVar, String str3, b bVar) {
            super(str, th);
            this.f131a = str2;
            this.f132b = z5;
            this.f133c = tVar;
            this.f134d = str3;
            this.f135e = bVar;
        }

        private static String b(int i6) {
            return "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (i6 < 0 ? "neg_" : "") + Math.abs(i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b c(b bVar) {
            return new b(getMessage(), getCause(), this.f131a, this.f132b, this.f133c, this.f134d, bVar);
        }

        private static String d(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }
    }

    private static final class c {

        /* renamed from: e, reason: collision with root package name */
        public static final c f136e = new c(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L);

        /* renamed from: a, reason: collision with root package name */
        public final long f137a;

        /* renamed from: b, reason: collision with root package name */
        public final long f138b;

        /* renamed from: c, reason: collision with root package name */
        public final long f139c;

        /* renamed from: d, reason: collision with root package name */
        public final q0<y1> f140d = new q0<>();

        public c(long j6, long j7, long j8) {
            this.f137a = j6;
            this.f138b = j7;
            this.f139c = j8;
        }
    }

    public w(int i6, p.b bVar, y yVar, boolean z5, float f6) {
        super(i6);
        this.f113r = bVar;
        this.f115s = (y) i2.a.e(yVar);
        this.f117t = z5;
        this.f119u = f6;
        this.f121v = l0.i.s();
        this.f123w = new l0.i(0);
        this.f125x = new l0.i(2);
        l lVar = new l();
        this.f127y = lVar;
        this.f129z = new ArrayList<>();
        this.A = new MediaCodec.BufferInfo();
        this.J = 1.0f;
        this.K = 1.0f;
        this.I = -9223372036854775807L;
        this.B = new ArrayDeque<>();
        e1(c.f136e);
        lVar.p(0);
        lVar.f7162c.order(ByteOrder.nativeOrder());
        this.P = -1.0f;
        this.T = 0;
        this.f111p0 = 0;
        this.f102g0 = -1;
        this.f103h0 = -1;
        this.f101f0 = -9223372036854775807L;
        this.f122v0 = -9223372036854775807L;
        this.f124w0 = -9223372036854775807L;
        this.E0 = -9223372036854775807L;
        this.f112q0 = 0;
        this.f114r0 = 0;
    }

    private boolean A0() {
        return this.f103h0 >= 0;
    }

    private void B0(y1 y1Var) {
        e0();
        String str = y1Var.f5066p;
        if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
            this.f127y.A(32);
        } else {
            this.f127y.A(1);
        }
        this.f107l0 = true;
    }

    private void C0(t tVar, MediaCrypto mediaCrypto) {
        String str = tVar.f85a;
        int i6 = c1.f5548a;
        float s02 = i6 < 23 ? -1.0f : s0(this.K, this.C, F());
        float f6 = s02 > this.f119u ? s02 : -1.0f;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        p.a w02 = w0(tVar, this.C, mediaCrypto, f6);
        if (i6 >= 31) {
            a.a(w02, E());
        }
        try {
            s0.a("createCodec:" + str);
            this.L = this.f113r.a(w02);
            s0.c();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            if (!tVar.o(this.C)) {
                i2.t.i("MediaCodecRenderer", c1.C("Format exceeds selected codec's capabilities [%s, %s]", y1.i(this.C), str));
            }
            this.S = tVar;
            this.P = f6;
            this.M = this.C;
            this.T = U(str);
            this.U = V(str, this.M);
            this.V = a0(str);
            this.W = c0(str);
            this.X = X(str);
            this.Y = Y(str);
            this.Z = W(str);
            this.f96a0 = b0(str, this.M);
            this.f99d0 = Z(tVar) || r0();
            if (this.L.c()) {
                this.f110o0 = true;
                this.f111p0 = 1;
                this.f97b0 = this.T != 0;
            }
            if ("c2.android.mp3.decoder".equals(tVar.f85a)) {
                this.f100e0 = new m();
            }
            if (getState() == 2) {
                this.f101f0 = SystemClock.elapsedRealtime() + 1000;
            }
            this.C0.f7149a++;
            K0(str, w02, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
        } catch (Throwable th) {
            s0.c();
            throw th;
        }
    }

    private boolean D0(long j6) {
        int size = this.f129z.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (this.f129z.get(i6).longValue() == j6) {
                this.f129z.remove(i6);
                return true;
            }
        }
        return false;
    }

    private static boolean E0(IllegalStateException illegalStateException) {
        if (c1.f5548a >= 21 && F0(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    private static boolean F0(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    private static boolean G0(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void I0(android.media.MediaCrypto r8, boolean r9) {
        /*
            r7 = this;
            java.util.ArrayDeque<a1.t> r0 = r7.Q
            r1 = 0
            if (r0 != 0) goto L39
            java.util.List r0 = r7.o0(r9)     // Catch: a1.h0.c -> L2d
            java.util.ArrayDeque r2 = new java.util.ArrayDeque     // Catch: a1.h0.c -> L2d
            r2.<init>()     // Catch: a1.h0.c -> L2d
            r7.Q = r2     // Catch: a1.h0.c -> L2d
            boolean r3 = r7.f117t     // Catch: a1.h0.c -> L2d
            if (r3 == 0) goto L18
            r2.addAll(r0)     // Catch: a1.h0.c -> L2d
            goto L2a
        L18:
            boolean r2 = r0.isEmpty()     // Catch: a1.h0.c -> L2d
            if (r2 != 0) goto L2a
            java.util.ArrayDeque<a1.t> r2 = r7.Q     // Catch: a1.h0.c -> L2d
            r3 = 0
            java.lang.Object r0 = r0.get(r3)     // Catch: a1.h0.c -> L2d
            a1.t r0 = (a1.t) r0     // Catch: a1.h0.c -> L2d
            r2.add(r0)     // Catch: a1.h0.c -> L2d
        L2a:
            r7.R = r1     // Catch: a1.h0.c -> L2d
            goto L39
        L2d:
            r8 = move-exception
            a1.w$b r0 = new a1.w$b
            h0.y1 r1 = r7.C
            r2 = -49998(0xffffffffffff3cb2, float:NaN)
            r0.<init>(r1, r8, r9, r2)
            throw r0
        L39:
            java.util.ArrayDeque<a1.t> r0 = r7.Q
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lb4
            java.util.ArrayDeque<a1.t> r0 = r7.Q
            java.lang.Object r0 = r0.peekFirst()
            a1.t r0 = (a1.t) r0
        L49:
            a1.p r2 = r7.L
            if (r2 != 0) goto Lb1
            java.util.ArrayDeque<a1.t> r2 = r7.Q
            java.lang.Object r2 = r2.peekFirst()
            a1.t r2 = (a1.t) r2
            boolean r3 = r7.j1(r2)
            if (r3 != 0) goto L5c
            return
        L5c:
            r7.C0(r2, r8)     // Catch: java.lang.Exception -> L60
            goto L49
        L60:
            r3 = move-exception
            java.lang.String r4 = "MediaCodecRenderer"
            if (r2 != r0) goto L73
            java.lang.String r3 = "Preferred decoder instantiation failed. Sleeping for 50ms then retrying."
            i2.t.i(r4, r3)     // Catch: java.lang.Exception -> L74
            r5 = 50
            java.lang.Thread.sleep(r5)     // Catch: java.lang.Exception -> L74
            r7.C0(r2, r8)     // Catch: java.lang.Exception -> L74
            goto L49
        L73:
            throw r3     // Catch: java.lang.Exception -> L74
        L74:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to initialize decoder: "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            i2.t.j(r4, r5, r3)
            java.util.ArrayDeque<a1.t> r4 = r7.Q
            r4.removeFirst()
            a1.w$b r4 = new a1.w$b
            h0.y1 r5 = r7.C
            r4.<init>(r5, r3, r9, r2)
            r7.J0(r4)
            a1.w$b r2 = r7.R
            if (r2 != 0) goto L9f
            r7.R = r4
            goto La5
        L9f:
            a1.w$b r2 = a1.w.b.a(r2, r4)
            r7.R = r2
        La5:
            java.util.ArrayDeque<a1.t> r2 = r7.Q
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto Lae
            goto L49
        Lae:
            a1.w$b r8 = r7.R
            throw r8
        Lb1:
            r7.Q = r1
            return
        Lb4:
            a1.w$b r8 = new a1.w$b
            h0.y1 r0 = r7.C
            r2 = -49999(0xffffffffffff3cb1, float:NaN)
            r8.<init>(r0, r1, r9, r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.w.I0(android.media.MediaCrypto, boolean):void");
    }

    private void R() {
        i2.a.g(!this.f126x0);
        z1 C = C();
        this.f125x.f();
        do {
            this.f125x.f();
            int O = O(C, this.f125x, 0);
            if (O == -5) {
                M0(C);
                return;
            }
            if (O != -4) {
                if (O != -3) {
                    throw new IllegalStateException();
                }
                return;
            } else {
                if (this.f125x.k()) {
                    this.f126x0 = true;
                    return;
                }
                if (this.f130z0) {
                    y1 y1Var = (y1) i2.a.e(this.C);
                    this.D = y1Var;
                    N0(y1Var, null);
                    this.f130z0 = false;
                }
                this.f125x.q();
            }
        } while (this.f127y.u(this.f125x));
        this.f108m0 = true;
    }

    private boolean S(long j6, long j7) {
        i2.a.g(!this.f128y0);
        if (this.f127y.z()) {
            l lVar = this.f127y;
            if (!T0(j6, j7, null, lVar.f7162c, this.f103h0, 0, lVar.y(), this.f127y.w(), this.f127y.j(), this.f127y.k(), this.D)) {
                return false;
            }
            P0(this.f127y.x());
            this.f127y.f();
        }
        if (this.f126x0) {
            this.f128y0 = true;
            return false;
        }
        if (this.f108m0) {
            i2.a.g(this.f127y.u(this.f125x));
            this.f108m0 = false;
        }
        if (this.f109n0) {
            if (this.f127y.z()) {
                return true;
            }
            e0();
            this.f109n0 = false;
            H0();
            if (!this.f107l0) {
                return false;
            }
        }
        R();
        if (this.f127y.z()) {
            this.f127y.q();
        }
        return this.f127y.z() || this.f126x0 || this.f109n0;
    }

    private void S0() {
        int i6 = this.f114r0;
        if (i6 == 1) {
            l0();
            return;
        }
        if (i6 == 2) {
            l0();
            p1();
        } else if (i6 == 3) {
            W0();
        } else {
            this.f128y0 = true;
            Y0();
        }
    }

    private int U(String str) {
        int i6 = c1.f5548a;
        if (i6 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = c1.f5551d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i6 >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = c1.f5549b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    private void U0() {
        this.f120u0 = true;
        MediaFormat h6 = this.L.h();
        if (this.T != 0 && h6.getInteger("width") == 32 && h6.getInteger("height") == 32) {
            this.f98c0 = true;
            return;
        }
        if (this.f96a0) {
            h6.setInteger("channel-count", 1);
        }
        this.N = h6;
        this.O = true;
    }

    private static boolean V(String str, y1 y1Var) {
        return c1.f5548a < 21 && y1Var.f5068r.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private boolean V0(int i6) {
        z1 C = C();
        this.f121v.f();
        int O = O(C, this.f121v, i6 | 4);
        if (O == -5) {
            M0(C);
            return true;
        }
        if (O != -4 || !this.f121v.k()) {
            return false;
        }
        this.f126x0 = true;
        S0();
        return false;
    }

    private static boolean W(String str) {
        if (c1.f5548a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(c1.f5550c)) {
            String str2 = c1.f5549b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    private void W0() {
        X0();
        H0();
    }

    private static boolean X(String str) {
        int i6 = c1.f5548a;
        if (i6 > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i6 <= 19) {
                String str2 = c1.f5549b;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    private static boolean Y(String str) {
        return c1.f5548a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean Z(t tVar) {
        String str = tVar.f85a;
        int i6 = c1.f5548a;
        return (i6 <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i6 <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i6 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str) || "OMX.bcm.vdec.avc.tunnel".equals(str) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str) || "OMX.bcm.vdec.hevc.tunnel".equals(str) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str))) || ("Amazon".equals(c1.f5550c) && "AFTS".equals(c1.f5551d) && tVar.f91g));
    }

    private static boolean a0(String str) {
        int i6 = c1.f5548a;
        return i6 < 18 || (i6 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i6 == 19 && c1.f5551d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private static boolean b0(String str, y1 y1Var) {
        return c1.f5548a <= 18 && y1Var.C == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private void b1() {
        this.f102g0 = -1;
        this.f123w.f7162c = null;
    }

    private static boolean c0(String str) {
        return c1.f5548a == 29 && "c2.android.aac.decoder".equals(str);
    }

    private void c1() {
        this.f103h0 = -1;
        this.f104i0 = null;
    }

    private void d1(m0.o oVar) {
        m0.n.a(this.E, oVar);
        this.E = oVar;
    }

    private void e0() {
        this.f109n0 = false;
        this.f127y.f();
        this.f125x.f();
        this.f108m0 = false;
        this.f107l0 = false;
    }

    private void e1(c cVar) {
        this.D0 = cVar;
        long j6 = cVar.f139c;
        if (j6 != -9223372036854775807L) {
            this.F0 = true;
            O0(j6);
        }
    }

    private boolean f0() {
        if (this.f116s0) {
            this.f112q0 = 1;
            if (this.V || this.X) {
                this.f114r0 = 3;
                return false;
            }
            this.f114r0 = 1;
        }
        return true;
    }

    private void g0() {
        if (!this.f116s0) {
            W0();
        } else {
            this.f112q0 = 1;
            this.f114r0 = 3;
        }
    }

    private boolean h0() {
        if (this.f116s0) {
            this.f112q0 = 1;
            if (this.V || this.X) {
                this.f114r0 = 3;
                return false;
            }
            this.f114r0 = 2;
        } else {
            p1();
        }
        return true;
    }

    private void h1(m0.o oVar) {
        m0.n.a(this.F, oVar);
        this.F = oVar;
    }

    private boolean i0(long j6, long j7) {
        boolean z5;
        boolean T0;
        p pVar;
        ByteBuffer byteBuffer;
        int i6;
        MediaCodec.BufferInfo bufferInfo;
        int b6;
        if (!A0()) {
            if (this.Y && this.f118t0) {
                try {
                    b6 = this.L.b(this.A);
                } catch (IllegalStateException unused) {
                    S0();
                    if (this.f128y0) {
                        X0();
                    }
                    return false;
                }
            } else {
                b6 = this.L.b(this.A);
            }
            if (b6 < 0) {
                if (b6 == -2) {
                    U0();
                    return true;
                }
                if (this.f99d0 && (this.f126x0 || this.f112q0 == 2)) {
                    S0();
                }
                return false;
            }
            if (this.f98c0) {
                this.f98c0 = false;
                this.L.e(b6, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.A;
            if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                S0();
                return false;
            }
            this.f103h0 = b6;
            ByteBuffer m6 = this.L.m(b6);
            this.f104i0 = m6;
            if (m6 != null) {
                m6.position(this.A.offset);
                ByteBuffer byteBuffer2 = this.f104i0;
                MediaCodec.BufferInfo bufferInfo3 = this.A;
                byteBuffer2.limit(bufferInfo3.offset + bufferInfo3.size);
            }
            if (this.Z) {
                MediaCodec.BufferInfo bufferInfo4 = this.A;
                if (bufferInfo4.presentationTimeUs == 0 && (bufferInfo4.flags & 4) != 0) {
                    long j8 = this.f122v0;
                    if (j8 != -9223372036854775807L) {
                        bufferInfo4.presentationTimeUs = j8;
                    }
                }
            }
            this.f105j0 = D0(this.A.presentationTimeUs);
            long j9 = this.f124w0;
            long j10 = this.A.presentationTimeUs;
            this.f106k0 = j9 == j10;
            q1(j10);
        }
        if (this.Y && this.f118t0) {
            try {
                pVar = this.L;
                byteBuffer = this.f104i0;
                i6 = this.f103h0;
                bufferInfo = this.A;
                z5 = false;
            } catch (IllegalStateException unused2) {
                z5 = false;
            }
            try {
                T0 = T0(j6, j7, pVar, byteBuffer, i6, bufferInfo.flags, 1, bufferInfo.presentationTimeUs, this.f105j0, this.f106k0, this.D);
            } catch (IllegalStateException unused3) {
                S0();
                if (this.f128y0) {
                    X0();
                }
                return z5;
            }
        } else {
            z5 = false;
            p pVar2 = this.L;
            ByteBuffer byteBuffer3 = this.f104i0;
            int i7 = this.f103h0;
            MediaCodec.BufferInfo bufferInfo5 = this.A;
            T0 = T0(j6, j7, pVar2, byteBuffer3, i7, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.f105j0, this.f106k0, this.D);
        }
        if (T0) {
            P0(this.A.presentationTimeUs);
            boolean z6 = (this.A.flags & 4) != 0;
            c1();
            if (!z6) {
                return true;
            }
            S0();
        }
        return z5;
    }

    private boolean i1(long j6) {
        return this.I == -9223372036854775807L || SystemClock.elapsedRealtime() - j6 < this.I;
    }

    private boolean j0(t tVar, y1 y1Var, m0.o oVar, m0.o oVar2) {
        m0.h0 v02;
        if (oVar == oVar2) {
            return false;
        }
        if (oVar2 == null || oVar == null || !oVar2.d().equals(oVar.d()) || c1.f5548a < 23) {
            return true;
        }
        UUID uuid = h0.p.f4775e;
        if (uuid.equals(oVar.d()) || uuid.equals(oVar2.d()) || (v02 = v0(oVar2)) == null) {
            return true;
        }
        return !tVar.f91g && (v02.f7838c ? false : oVar2.g(y1Var.f5066p));
    }

    private boolean k0() {
        int i6;
        if (this.L == null || (i6 = this.f112q0) == 2 || this.f126x0) {
            return false;
        }
        if (i6 == 0 && k1()) {
            g0();
        }
        if (this.f102g0 < 0) {
            int o6 = this.L.o();
            this.f102g0 = o6;
            if (o6 < 0) {
                return false;
            }
            this.f123w.f7162c = this.L.i(o6);
            this.f123w.f();
        }
        if (this.f112q0 == 1) {
            if (!this.f99d0) {
                this.f118t0 = true;
                this.L.k(this.f102g0, 0, 0, 0L, 4);
                b1();
            }
            this.f112q0 = 2;
            return false;
        }
        if (this.f97b0) {
            this.f97b0 = false;
            ByteBuffer byteBuffer = this.f123w.f7162c;
            byte[] bArr = G0;
            byteBuffer.put(bArr);
            this.L.k(this.f102g0, 0, bArr.length, 0L, 0);
            b1();
            this.f116s0 = true;
            return true;
        }
        if (this.f111p0 == 1) {
            for (int i7 = 0; i7 < this.M.f5068r.size(); i7++) {
                this.f123w.f7162c.put(this.M.f5068r.get(i7));
            }
            this.f111p0 = 2;
        }
        int position = this.f123w.f7162c.position();
        z1 C = C();
        try {
            int O = O(C, this.f123w, 0);
            if (j()) {
                this.f124w0 = this.f122v0;
            }
            if (O == -3) {
                return false;
            }
            if (O == -5) {
                if (this.f111p0 == 2) {
                    this.f123w.f();
                    this.f111p0 = 1;
                }
                M0(C);
                return true;
            }
            if (this.f123w.k()) {
                if (this.f111p0 == 2) {
                    this.f123w.f();
                    this.f111p0 = 1;
                }
                this.f126x0 = true;
                if (!this.f116s0) {
                    S0();
                    return false;
                }
                try {
                    if (!this.f99d0) {
                        this.f118t0 = true;
                        this.L.k(this.f102g0, 0, 0, 0L, 4);
                        b1();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e6) {
                    throw z(e6, this.C, c1.W(e6.getErrorCode()));
                }
            }
            if (!this.f116s0 && !this.f123w.m()) {
                this.f123w.f();
                if (this.f111p0 == 2) {
                    this.f111p0 = 1;
                }
                return true;
            }
            boolean r6 = this.f123w.r();
            if (r6) {
                this.f123w.f7161b.b(position);
            }
            if (this.U && !r6) {
                i2.y.b(this.f123w.f7162c);
                if (this.f123w.f7162c.position() == 0) {
                    return true;
                }
                this.U = false;
            }
            l0.i iVar = this.f123w;
            long j6 = iVar.f7164e;
            m mVar = this.f100e0;
            if (mVar != null) {
                j6 = mVar.d(this.C, iVar);
                this.f122v0 = Math.max(this.f122v0, this.f100e0.b(this.C));
            }
            long j7 = j6;
            if (this.f123w.j()) {
                this.f129z.add(Long.valueOf(j7));
            }
            if (this.f130z0) {
                (!this.B.isEmpty() ? this.B.peekLast() : this.D0).f140d.a(j7, this.C);
                this.f130z0 = false;
            }
            this.f122v0 = Math.max(this.f122v0, j7);
            this.f123w.q();
            if (this.f123w.i()) {
                z0(this.f123w);
            }
            R0(this.f123w);
            try {
                if (r6) {
                    this.L.d(this.f102g0, 0, this.f123w.f7161b, j7, 0);
                } else {
                    this.L.k(this.f102g0, 0, this.f123w.f7162c.limit(), j7, 0);
                }
                b1();
                this.f116s0 = true;
                this.f111p0 = 0;
                this.C0.f7151c++;
                return true;
            } catch (MediaCodec.CryptoException e7) {
                throw z(e7, this.C, c1.W(e7.getErrorCode()));
            }
        } catch (i.a e8) {
            J0(e8);
            V0(0);
            l0();
            return true;
        }
    }

    private void l0() {
        try {
            this.L.flush();
        } finally {
            Z0();
        }
    }

    protected static boolean n1(y1 y1Var) {
        int i6 = y1Var.K;
        return i6 == 0 || i6 == 2;
    }

    private List<t> o0(boolean z5) {
        List<t> u02 = u0(this.f115s, this.C, z5);
        if (u02.isEmpty() && z5) {
            u02 = u0(this.f115s, this.C, false);
            if (!u02.isEmpty()) {
                i2.t.i("MediaCodecRenderer", "Drm session requires secure decoder for " + this.C.f5066p + ", but no secure decoder available. Trying to proceed with " + u02 + ".");
            }
        }
        return u02;
    }

    private boolean o1(y1 y1Var) {
        if (c1.f5548a >= 23 && this.L != null && this.f114r0 != 3 && getState() != 0) {
            float s02 = s0(this.K, y1Var, F());
            float f6 = this.P;
            if (f6 == s02) {
                return true;
            }
            if (s02 == -1.0f) {
                g0();
                return false;
            }
            if (f6 == -1.0f && s02 <= this.f119u) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", s02);
            this.L.l(bundle);
            this.P = s02;
        }
        return true;
    }

    private void p1() {
        try {
            this.G.setMediaDrmSession(v0(this.F).f7837b);
            d1(this.F);
            this.f112q0 = 0;
            this.f114r0 = 0;
        } catch (MediaCryptoException e6) {
            throw z(e6, this.C, 6006);
        }
    }

    private m0.h0 v0(m0.o oVar) {
        l0.b i6 = oVar.i();
        if (i6 == null || (i6 instanceof m0.h0)) {
            return (m0.h0) i6;
        }
        throw z(new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + i6), this.C, 6001);
    }

    @Override // h0.l
    protected void H() {
        this.C = null;
        e1(c.f136e);
        this.B.clear();
        n0();
    }

    protected final void H0() {
        y1 y1Var;
        if (this.L != null || this.f107l0 || (y1Var = this.C) == null) {
            return;
        }
        if (this.F == null && l1(y1Var)) {
            B0(this.C);
            return;
        }
        d1(this.F);
        String str = this.C.f5066p;
        m0.o oVar = this.E;
        if (oVar != null) {
            if (this.G == null) {
                m0.h0 v02 = v0(oVar);
                if (v02 != null) {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(v02.f7836a, v02.f7837b);
                        this.G = mediaCrypto;
                        this.H = !v02.f7838c && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e6) {
                        throw z(e6, this.C, 6006);
                    }
                } else if (this.E.h() == null) {
                    return;
                }
            }
            if (m0.h0.f7835d) {
                int state = this.E.getState();
                if (state == 1) {
                    o.a aVar = (o.a) i2.a.e(this.E.h());
                    throw z(aVar, this.C, aVar.f7859a);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            I0(this.G, this.H);
        } catch (b e7) {
            throw z(e7, this.C, 4001);
        }
    }

    @Override // h0.l
    protected void I(boolean z5, boolean z6) {
        this.C0 = new l0.g();
    }

    @Override // h0.l
    protected void J(long j6, boolean z5) {
        this.f126x0 = false;
        this.f128y0 = false;
        this.A0 = false;
        if (this.f107l0) {
            this.f127y.f();
            this.f125x.f();
            this.f108m0 = false;
        } else {
            m0();
        }
        if (this.D0.f140d.l() > 0) {
            this.f130z0 = true;
        }
        this.D0.f140d.c();
        this.B.clear();
    }

    protected abstract void J0(Exception exc);

    @Override // h0.l
    protected void K() {
        try {
            e0();
            X0();
        } finally {
            h1(null);
        }
    }

    protected abstract void K0(String str, p.a aVar, long j6, long j7);

    @Override // h0.l
    protected void L() {
    }

    protected abstract void L0(String str);

    @Override // h0.l
    protected void M() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
    
        if (h0() == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cf, code lost:
    
        r7 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b2, code lost:
    
        if (h0() == false) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected l0.k M0(h0.z1 r12) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.w.M0(h0.z1):l0.k");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
    
        if (r1 >= r17.f122v0) goto L12;
     */
    @Override // h0.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void N(h0.y1[] r18, long r19, long r21) {
        /*
            r17 = this;
            r0 = r17
            a1.w$c r1 = r0.D0
            long r1 = r1.f139c
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L36
            java.util.ArrayDeque<a1.w$c> r1 = r0.B
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L24
            long r1 = r0.E0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L24
            long r3 = r0.f122v0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L24
            goto L36
        L24:
            java.util.ArrayDeque<a1.w$c> r1 = r0.B
            a1.w$c r9 = new a1.w$c
            long r3 = r0.f122v0
            r2 = r9
            r5 = r19
            r7 = r21
            r2.<init>(r3, r5, r7)
            r1.add(r9)
            goto L48
        L36:
            a1.w$c r1 = new a1.w$c
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r10 = r1
            r13 = r19
            r15 = r21
            r10.<init>(r11, r13, r15)
            r0.e1(r1)
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.w.N(h0.y1[], long, long):void");
    }

    protected abstract void N0(y1 y1Var, MediaFormat mediaFormat);

    protected void O0(long j6) {
    }

    protected void P0(long j6) {
        this.E0 = j6;
        if (this.B.isEmpty() || j6 < this.B.peek().f137a) {
            return;
        }
        e1(this.B.poll());
        Q0();
    }

    protected void Q0() {
    }

    protected abstract void R0(l0.i iVar);

    protected abstract l0.k T(t tVar, y1 y1Var, y1 y1Var2);

    protected abstract boolean T0(long j6, long j7, p pVar, ByteBuffer byteBuffer, int i6, int i7, int i8, long j8, boolean z5, boolean z6, y1 y1Var);

    /* JADX WARN: Multi-variable type inference failed */
    protected void X0() {
        try {
            p pVar = this.L;
            if (pVar != null) {
                pVar.a();
                this.C0.f7150b++;
                L0(this.S.f85a);
            }
            this.L = null;
            try {
                MediaCrypto mediaCrypto = this.G;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th) {
            this.L = null;
            try {
                MediaCrypto mediaCrypto2 = this.G;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th;
            } finally {
            }
        }
    }

    protected void Y0() {
    }

    protected void Z0() {
        b1();
        c1();
        this.f101f0 = -9223372036854775807L;
        this.f118t0 = false;
        this.f116s0 = false;
        this.f97b0 = false;
        this.f98c0 = false;
        this.f105j0 = false;
        this.f106k0 = false;
        this.f129z.clear();
        this.f122v0 = -9223372036854775807L;
        this.f124w0 = -9223372036854775807L;
        this.E0 = -9223372036854775807L;
        m mVar = this.f100e0;
        if (mVar != null) {
            mVar.c();
        }
        this.f112q0 = 0;
        this.f114r0 = 0;
        this.f111p0 = this.f110o0 ? 1 : 0;
    }

    @Override // h0.z3
    public final int a(y1 y1Var) {
        try {
            return m1(this.f115s, y1Var);
        } catch (h0.c e6) {
            throw z(e6, y1Var, 4002);
        }
    }

    protected void a1() {
        Z0();
        this.B0 = null;
        this.f100e0 = null;
        this.Q = null;
        this.S = null;
        this.M = null;
        this.N = null;
        this.O = false;
        this.f120u0 = false;
        this.P = -1.0f;
        this.T = 0;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f96a0 = false;
        this.f99d0 = false;
        this.f110o0 = false;
        this.f111p0 = 0;
        this.H = false;
    }

    @Override // h0.x3
    public boolean c() {
        return this.f128y0;
    }

    protected q d0(Throwable th, t tVar) {
        return new q(th, tVar);
    }

    @Override // h0.x3
    public boolean e() {
        return this.C != null && (G() || A0() || (this.f101f0 != -9223372036854775807L && SystemClock.elapsedRealtime() < this.f101f0));
    }

    protected final void f1() {
        this.A0 = true;
    }

    protected final void g1(h0.x xVar) {
        this.B0 = xVar;
    }

    protected boolean j1(t tVar) {
        return true;
    }

    @Override // h0.l, h0.z3
    public final int k() {
        return 8;
    }

    protected boolean k1() {
        return false;
    }

    @Override // h0.x3
    public void l(long j6, long j7) {
        boolean z5 = false;
        if (this.A0) {
            this.A0 = false;
            S0();
        }
        h0.x xVar = this.B0;
        if (xVar != null) {
            this.B0 = null;
            throw xVar;
        }
        try {
            if (this.f128y0) {
                Y0();
                return;
            }
            if (this.C != null || V0(2)) {
                H0();
                if (this.f107l0) {
                    s0.a("bypassRender");
                    while (S(j6, j7)) {
                    }
                } else {
                    if (this.L == null) {
                        this.C0.f7152d += Q(j6);
                        V0(1);
                        this.C0.c();
                    }
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    s0.a("drainAndFeed");
                    while (i0(j6, j7) && i1(elapsedRealtime)) {
                    }
                    while (k0() && i1(elapsedRealtime)) {
                    }
                }
                s0.c();
                this.C0.c();
            }
        } catch (IllegalStateException e6) {
            if (!E0(e6)) {
                throw e6;
            }
            J0(e6);
            if (c1.f5548a >= 21 && G0(e6)) {
                z5 = true;
            }
            if (z5) {
                X0();
            }
            throw A(d0(e6, q0()), this.C, z5, 4003);
        }
    }

    protected boolean l1(y1 y1Var) {
        return false;
    }

    protected final boolean m0() {
        boolean n02 = n0();
        if (n02) {
            H0();
        }
        return n02;
    }

    protected abstract int m1(y yVar, y1 y1Var);

    protected boolean n0() {
        if (this.L == null) {
            return false;
        }
        int i6 = this.f114r0;
        if (i6 == 3 || this.V || ((this.W && !this.f120u0) || (this.X && this.f118t0))) {
            X0();
            return true;
        }
        if (i6 == 2) {
            int i7 = c1.f5548a;
            i2.a.g(i7 >= 23);
            if (i7 >= 23) {
                try {
                    p1();
                } catch (h0.x e6) {
                    i2.t.j("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e6);
                    X0();
                    return true;
                }
            }
        }
        l0();
        return false;
    }

    protected final p p0() {
        return this.L;
    }

    protected final t q0() {
        return this.S;
    }

    protected final void q1(long j6) {
        boolean z5;
        y1 j7 = this.D0.f140d.j(j6);
        if (j7 == null && this.F0 && this.N != null) {
            j7 = this.D0.f140d.i();
        }
        if (j7 != null) {
            this.D = j7;
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 || (this.O && this.D != null)) {
            N0(this.D, this.N);
            this.O = false;
            this.F0 = false;
        }
    }

    protected boolean r0() {
        return false;
    }

    protected abstract float s0(float f6, y1 y1Var, y1[] y1VarArr);

    protected final MediaFormat t0() {
        return this.N;
    }

    protected abstract List<t> u0(y yVar, y1 y1Var, boolean z5);

    protected abstract p.a w0(t tVar, y1 y1Var, MediaCrypto mediaCrypto, float f6);

    protected final long x0() {
        return this.D0.f139c;
    }

    @Override // h0.l, h0.x3
    public void y(float f6, float f7) {
        this.J = f6;
        this.K = f7;
        o1(this.M);
    }

    protected float y0() {
        return this.J;
    }

    protected void z0(l0.i iVar) {
    }
}
