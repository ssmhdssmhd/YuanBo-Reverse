package j0;

import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import com.tendcloud.tenddata.ab;
import h0.n3;
import h0.y;
import h0.y1;
import i0.o3;
import j0.g1;
import j0.i;
import j0.x;
import j0.z;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public final class s0 implements x {

    /* renamed from: e0, reason: collision with root package name */
    public static boolean f6541e0 = false;

    /* renamed from: f0, reason: collision with root package name */
    private static final Object f6542f0 = new Object();

    /* renamed from: g0, reason: collision with root package name */
    private static ExecutorService f6543g0;

    /* renamed from: h0, reason: collision with root package name */
    private static int f6544h0;
    private ByteBuffer A;
    private int B;
    private long C;
    private long D;
    private long E;
    private long F;
    private int G;
    private boolean H;
    private boolean I;
    private long J;
    private float K;
    private j0.i[] L;
    private ByteBuffer[] M;
    private ByteBuffer N;
    private int O;
    private ByteBuffer P;
    private byte[] Q;
    private int R;
    private int S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private int X;
    private a0 Y;
    private d Z;

    /* renamed from: a, reason: collision with root package name */
    private final j0.h f6545a;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f6546a0;

    /* renamed from: b, reason: collision with root package name */
    private final j0.j f6547b;

    /* renamed from: b0, reason: collision with root package name */
    private long f6548b0;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f6549c;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f6550c0;

    /* renamed from: d, reason: collision with root package name */
    private final c0 f6551d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f6552d0;

    /* renamed from: e, reason: collision with root package name */
    private final q1 f6553e;

    /* renamed from: f, reason: collision with root package name */
    private final j0.i[] f6554f;

    /* renamed from: g, reason: collision with root package name */
    private final j0.i[] f6555g;

    /* renamed from: h, reason: collision with root package name */
    private final i2.h f6556h;

    /* renamed from: i, reason: collision with root package name */
    private final z f6557i;

    /* renamed from: j, reason: collision with root package name */
    private final ArrayDeque<j> f6558j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f6559k;

    /* renamed from: l, reason: collision with root package name */
    private final int f6560l;

    /* renamed from: m, reason: collision with root package name */
    private m f6561m;

    /* renamed from: n, reason: collision with root package name */
    private final k<x.b> f6562n;

    /* renamed from: o, reason: collision with root package name */
    private final k<x.e> f6563o;

    /* renamed from: p, reason: collision with root package name */
    private final e f6564p;

    /* renamed from: q, reason: collision with root package name */
    private final y.b f6565q;

    /* renamed from: r, reason: collision with root package name */
    private o3 f6566r;

    /* renamed from: s, reason: collision with root package name */
    private x.c f6567s;

    /* renamed from: t, reason: collision with root package name */
    private g f6568t;

    /* renamed from: u, reason: collision with root package name */
    private g f6569u;

    /* renamed from: v, reason: collision with root package name */
    private AudioTrack f6570v;

    /* renamed from: w, reason: collision with root package name */
    private j0.e f6571w;

    /* renamed from: x, reason: collision with root package name */
    private j f6572x;

    /* renamed from: y, reason: collision with root package name */
    private j f6573y;

    /* renamed from: z, reason: collision with root package name */
    private n3 f6574z;

    private static final class b {
        public static void a(AudioTrack audioTrack, d dVar) {
            audioTrack.setPreferredDevice(dVar == null ? null : dVar.f6575a);
        }
    }

    private static final class c {
        public static void a(AudioTrack audioTrack, o3 o3Var) {
            LogSessionId logSessionId;
            boolean equals;
            LogSessionId a6 = o3Var.a();
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            equals = a6.equals(logSessionId);
            if (equals) {
                return;
            }
            audioTrack.setLogSessionId(a6);
        }
    }

    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final AudioDeviceInfo f6575a;

        public d(AudioDeviceInfo audioDeviceInfo) {
            this.f6575a = audioDeviceInfo;
        }
    }

    public interface e {

        /* renamed from: a, reason: collision with root package name */
        public static final e f6576a = new g1.a().g();

        int a(int i6, int i7, int i8, int i9, int i10, int i11, double d6);
    }

    public static final class f {

        /* renamed from: b, reason: collision with root package name */
        private j0.j f6578b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f6579c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f6580d;

        /* renamed from: g, reason: collision with root package name */
        y.b f6583g;

        /* renamed from: a, reason: collision with root package name */
        private j0.h f6577a = j0.h.f6433c;

        /* renamed from: e, reason: collision with root package name */
        private int f6581e = 0;

        /* renamed from: f, reason: collision with root package name */
        e f6582f = e.f6576a;

        public s0 f() {
            if (this.f6578b == null) {
                this.f6578b = new h(new j0.i[0]);
            }
            return new s0(this);
        }

        public f g(j0.h hVar) {
            i2.a.e(hVar);
            this.f6577a = hVar;
            return this;
        }

        public f h(boolean z5) {
            this.f6580d = z5;
            return this;
        }

        public f i(boolean z5) {
            this.f6579c = z5;
            return this;
        }

        public f j(int i6) {
            this.f6581e = i6;
            return this;
        }
    }

    private static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final y1 f6584a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6585b;

        /* renamed from: c, reason: collision with root package name */
        public final int f6586c;

        /* renamed from: d, reason: collision with root package name */
        public final int f6587d;

        /* renamed from: e, reason: collision with root package name */
        public final int f6588e;

        /* renamed from: f, reason: collision with root package name */
        public final int f6589f;

        /* renamed from: g, reason: collision with root package name */
        public final int f6590g;

        /* renamed from: h, reason: collision with root package name */
        public final int f6591h;

        /* renamed from: i, reason: collision with root package name */
        public final j0.i[] f6592i;

        public g(y1 y1Var, int i6, int i7, int i8, int i9, int i10, int i11, int i12, j0.i[] iVarArr) {
            this.f6584a = y1Var;
            this.f6585b = i6;
            this.f6586c = i7;
            this.f6587d = i8;
            this.f6588e = i9;
            this.f6589f = i10;
            this.f6590g = i11;
            this.f6591h = i12;
            this.f6592i = iVarArr;
        }

        private AudioTrack d(boolean z5, j0.e eVar, int i6) {
            int i7 = i2.c1.f5548a;
            return i7 >= 29 ? f(z5, eVar, i6) : i7 >= 21 ? e(z5, eVar, i6) : g(eVar, i6);
        }

        private AudioTrack e(boolean z5, j0.e eVar, int i6) {
            return new AudioTrack(i(eVar, z5), s0.N(this.f6588e, this.f6589f, this.f6590g), this.f6591h, 1, i6);
        }

        private AudioTrack f(boolean z5, j0.e eVar, int i6) {
            AudioTrack.Builder audioAttributes;
            AudioTrack.Builder audioFormat;
            AudioTrack.Builder transferMode;
            AudioTrack.Builder bufferSizeInBytes;
            AudioTrack.Builder sessionId;
            AudioTrack.Builder offloadedPlayback;
            AudioTrack build;
            AudioFormat N = s0.N(this.f6588e, this.f6589f, this.f6590g);
            audioAttributes = new AudioTrack.Builder().setAudioAttributes(i(eVar, z5));
            audioFormat = audioAttributes.setAudioFormat(N);
            transferMode = audioFormat.setTransferMode(1);
            bufferSizeInBytes = transferMode.setBufferSizeInBytes(this.f6591h);
            sessionId = bufferSizeInBytes.setSessionId(i6);
            offloadedPlayback = sessionId.setOffloadedPlayback(this.f6586c == 1);
            build = offloadedPlayback.build();
            return build;
        }

        private AudioTrack g(j0.e eVar, int i6) {
            int h02 = i2.c1.h0(eVar.f6410c);
            int i7 = this.f6588e;
            int i8 = this.f6589f;
            int i9 = this.f6590g;
            int i10 = this.f6591h;
            return i6 == 0 ? new AudioTrack(h02, i7, i8, i9, i10, 1) : new AudioTrack(h02, i7, i8, i9, i10, 1, i6);
        }

        private static AudioAttributes i(j0.e eVar, boolean z5) {
            return z5 ? j() : eVar.b().f6414a;
        }

        private static AudioAttributes j() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public AudioTrack a(boolean z5, j0.e eVar, int i6) {
            try {
                AudioTrack d6 = d(z5, eVar, i6);
                int state = d6.getState();
                if (state == 1) {
                    return d6;
                }
                try {
                    d6.release();
                } catch (Exception unused) {
                }
                throw new x.b(state, this.f6588e, this.f6589f, this.f6591h, this.f6584a, l(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e6) {
                throw new x.b(0, this.f6588e, this.f6589f, this.f6591h, this.f6584a, l(), e6);
            }
        }

        public boolean b(g gVar) {
            return gVar.f6586c == this.f6586c && gVar.f6590g == this.f6590g && gVar.f6588e == this.f6588e && gVar.f6589f == this.f6589f && gVar.f6587d == this.f6587d;
        }

        public g c(int i6) {
            return new g(this.f6584a, this.f6585b, this.f6586c, this.f6587d, this.f6588e, this.f6589f, this.f6590g, i6, this.f6592i);
        }

        public long h(long j6) {
            return (j6 * 1000000) / this.f6588e;
        }

        public long k(long j6) {
            return (j6 * 1000000) / this.f6584a.D;
        }

        public boolean l() {
            return this.f6586c == 1;
        }
    }

    public static class h implements j0.j {

        /* renamed from: a, reason: collision with root package name */
        private final j0.i[] f6593a;

        /* renamed from: b, reason: collision with root package name */
        private final n1 f6594b;

        /* renamed from: c, reason: collision with root package name */
        private final p1 f6595c;

        public h(j0.i... iVarArr) {
            this(iVarArr, new n1(), new p1());
        }

        public h(j0.i[] iVarArr, n1 n1Var, p1 p1Var) {
            j0.i[] iVarArr2 = new j0.i[iVarArr.length + 2];
            this.f6593a = iVarArr2;
            System.arraycopy(iVarArr, 0, iVarArr2, 0, iVarArr.length);
            this.f6594b = n1Var;
            this.f6595c = p1Var;
            iVarArr2[iVarArr.length] = n1Var;
            iVarArr2[iVarArr.length + 1] = p1Var;
        }

        @Override // j0.j
        public n3 a(n3 n3Var) {
            this.f6595c.i(n3Var.f4732a);
            this.f6595c.h(n3Var.f4733b);
            return n3Var;
        }

        @Override // j0.j
        public long b() {
            return this.f6594b.p();
        }

        @Override // j0.j
        public boolean c(boolean z5) {
            this.f6594b.v(z5);
            return z5;
        }

        @Override // j0.j
        public long d(long j6) {
            return this.f6595c.g(j6);
        }

        @Override // j0.j
        public j0.i[] e() {
            return this.f6593a;
        }
    }

    public static final class i extends RuntimeException {
        private i(String str) {
            super(str);
        }
    }

    private static final class j {

        /* renamed from: a, reason: collision with root package name */
        public final n3 f6596a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f6597b;

        /* renamed from: c, reason: collision with root package name */
        public final long f6598c;

        /* renamed from: d, reason: collision with root package name */
        public final long f6599d;

        private j(n3 n3Var, boolean z5, long j6, long j7) {
            this.f6596a = n3Var;
            this.f6597b = z5;
            this.f6598c = j6;
            this.f6599d = j7;
        }
    }

    private static final class k<T extends Exception> {

        /* renamed from: a, reason: collision with root package name */
        private final long f6600a;

        /* renamed from: b, reason: collision with root package name */
        private T f6601b;

        /* renamed from: c, reason: collision with root package name */
        private long f6602c;

        public k(long j6) {
            this.f6600a = j6;
        }

        public void a() {
            this.f6601b = null;
        }

        public void b(T t5) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f6601b == null) {
                this.f6601b = t5;
                this.f6602c = this.f6600a + elapsedRealtime;
            }
            if (elapsedRealtime >= this.f6602c) {
                T t6 = this.f6601b;
                if (t6 != t5) {
                    t6.addSuppressed(t5);
                }
                T t7 = this.f6601b;
                a();
                throw t7;
            }
        }
    }

    private final class l implements z.a {
        private l() {
        }

        @Override // j0.z.a
        public void a(long j6) {
            if (s0.this.f6567s != null) {
                s0.this.f6567s.a(j6);
            }
        }

        @Override // j0.z.a
        public void b(int i6, long j6) {
            if (s0.this.f6567s != null) {
                s0.this.f6567s.g(i6, j6, SystemClock.elapsedRealtime() - s0.this.f6548b0);
            }
        }

        @Override // j0.z.a
        public void c(long j6, long j7, long j8, long j9) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j6 + ", " + j7 + ", " + j8 + ", " + j9 + ", " + s0.this.U() + ", " + s0.this.V();
            if (s0.f6541e0) {
                throw new i(str);
            }
            i2.t.i("DefaultAudioSink", str);
        }

        @Override // j0.z.a
        public void d(long j6, long j7, long j8, long j9) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j6 + ", " + j7 + ", " + j8 + ", " + j9 + ", " + s0.this.U() + ", " + s0.this.V();
            if (s0.f6541e0) {
                throw new i(str);
            }
            i2.t.i("DefaultAudioSink", str);
        }

        @Override // j0.z.a
        public void e(long j6) {
            i2.t.i("DefaultAudioSink", "Ignoring impossibly large audio latency: " + j6);
        }
    }

    private final class m {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f6604a = new Handler(Looper.myLooper());

        /* renamed from: b, reason: collision with root package name */
        private final AudioTrack.StreamEventCallback f6605b;

        class a extends AudioTrack.StreamEventCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ s0 f6607a;

            a(s0 s0Var) {
                this.f6607a = s0Var;
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(AudioTrack audioTrack, int i6) {
                if (audioTrack.equals(s0.this.f6570v) && s0.this.f6567s != null && s0.this.V) {
                    s0.this.f6567s.f();
                }
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(AudioTrack audioTrack) {
                if (audioTrack.equals(s0.this.f6570v) && s0.this.f6567s != null && s0.this.V) {
                    s0.this.f6567s.f();
                }
            }
        }

        public m() {
            this.f6605b = new a(s0.this);
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.f6604a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new f1(handler), this.f6605b);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f6605b);
            this.f6604a.removeCallbacksAndMessages(null);
        }
    }

    @RequiresNonNull({"#1.audioProcessorChain"})
    private s0(f fVar) {
        this.f6545a = fVar.f6577a;
        j0.j jVar = fVar.f6578b;
        this.f6547b = jVar;
        int i6 = i2.c1.f5548a;
        this.f6549c = i6 >= 21 && fVar.f6579c;
        this.f6559k = i6 >= 23 && fVar.f6580d;
        this.f6560l = i6 >= 29 ? fVar.f6581e : 0;
        this.f6564p = fVar.f6582f;
        i2.h hVar = new i2.h(i2.e.f5563a);
        this.f6556h = hVar;
        hVar.e();
        this.f6557i = new z(new l());
        c0 c0Var = new c0();
        this.f6551d = c0Var;
        q1 q1Var = new q1();
        this.f6553e = q1Var;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new m1(), c0Var, q1Var);
        Collections.addAll(arrayList, jVar.e());
        this.f6554f = (j0.i[]) arrayList.toArray(new j0.i[0]);
        this.f6555g = new j0.i[]{new i1()};
        this.K = 1.0f;
        this.f6571w = j0.e.f6401k;
        this.X = 0;
        this.Y = new a0(0, 0.0f);
        n3 n3Var = n3.f4728d;
        this.f6573y = new j(n3Var, false, 0L, 0L);
        this.f6574z = n3Var;
        this.S = -1;
        this.L = new j0.i[0];
        this.M = new ByteBuffer[0];
        this.f6558j = new ArrayDeque<>();
        this.f6562n = new k<>(100L);
        this.f6563o = new k<>(100L);
        this.f6565q = fVar.f6583g;
    }

    private void G(long j6) {
        n3 a6 = n0() ? this.f6547b.a(O()) : n3.f4728d;
        boolean c6 = n0() ? this.f6547b.c(T()) : false;
        this.f6558j.add(new j(a6, c6, Math.max(0L, j6), this.f6569u.h(V())));
        m0();
        x.c cVar = this.f6567s;
        if (cVar != null) {
            cVar.b(c6);
        }
    }

    private long H(long j6) {
        while (!this.f6558j.isEmpty() && j6 >= this.f6558j.getFirst().f6599d) {
            this.f6573y = this.f6558j.remove();
        }
        j jVar = this.f6573y;
        long j7 = j6 - jVar.f6599d;
        if (jVar.f6596a.equals(n3.f4728d)) {
            return this.f6573y.f6598c + j7;
        }
        if (this.f6558j.isEmpty()) {
            return this.f6573y.f6598c + this.f6547b.d(j7);
        }
        j first = this.f6558j.getFirst();
        return first.f6598c - i2.c1.b0(first.f6599d - j6, this.f6573y.f6596a.f4732a);
    }

    private long I(long j6) {
        return j6 + this.f6569u.h(this.f6547b.b());
    }

    private AudioTrack J(g gVar) {
        try {
            AudioTrack a6 = gVar.a(this.f6546a0, this.f6571w, this.X);
            y.b bVar = this.f6565q;
            if (bVar != null) {
                bVar.E(Z(a6));
            }
            return a6;
        } catch (x.b e6) {
            x.c cVar = this.f6567s;
            if (cVar != null) {
                cVar.c(e6);
            }
            throw e6;
        }
    }

    private AudioTrack K() {
        try {
            return J((g) i2.a.e(this.f6569u));
        } catch (x.b e6) {
            g gVar = this.f6569u;
            if (gVar.f6591h > 1000000) {
                g c6 = gVar.c(1000000);
                try {
                    AudioTrack J = J(c6);
                    this.f6569u = c6;
                    return J;
                } catch (x.b e7) {
                    e6.addSuppressed(e7);
                    b0();
                    throw e6;
                }
            }
            b0();
            throw e6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0029 -> B:4:0x0009). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean L() {
        /*
            r9 = this;
            int r0 = r9.S
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto Lb
            r9.S = r2
        L9:
            r0 = 1
            goto Lc
        Lb:
            r0 = 0
        Lc:
            int r4 = r9.S
            j0.i[] r5 = r9.L
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.d()
        L1f:
            r9.d0(r7)
            boolean r0 = r4.c()
            if (r0 != 0) goto L29
            return r2
        L29:
            int r0 = r9.S
            int r0 = r0 + r1
            r9.S = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.P
            if (r0 == 0) goto L3b
            r9.q0(r0, r7)
            java.nio.ByteBuffer r0 = r9.P
            if (r0 == 0) goto L3b
            return r2
        L3b:
            r9.S = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.s0.L():boolean");
    }

    private void M() {
        int i6 = 0;
        while (true) {
            j0.i[] iVarArr = this.L;
            if (i6 >= iVarArr.length) {
                return;
            }
            j0.i iVar = iVarArr[i6];
            iVar.flush();
            this.M[i6] = iVar.b();
            i6++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AudioFormat N(int i6, int i7, int i8) {
        return new AudioFormat.Builder().setSampleRate(i6).setChannelMask(i7).setEncoding(i8).build();
    }

    private n3 O() {
        return R().f6596a;
    }

    private static int P(int i6, int i7, int i8) {
        int minBufferSize = AudioTrack.getMinBufferSize(i6, i7, i8);
        i2.a.g(minBufferSize != -2);
        return minBufferSize;
    }

    private static int Q(int i6, ByteBuffer byteBuffer) {
        switch (i6) {
            case 5:
            case 6:
            case 18:
                return j0.b.e(byteBuffer);
            case 7:
            case 8:
                return h1.e(byteBuffer);
            case 9:
                int m6 = k1.m(i2.c1.I(byteBuffer, byteBuffer.position()));
                if (m6 != -1) {
                    return m6;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            case 19:
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i6);
            case 14:
                int b6 = j0.b.b(byteBuffer);
                if (b6 == -1) {
                    return 0;
                }
                return j0.b.i(byteBuffer, b6) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case ab.b.API_TYPE_INDUSTRY /* 17 */:
                return j0.c.c(byteBuffer);
            case 20:
                return l1.g(byteBuffer);
        }
    }

    private j R() {
        j jVar = this.f6572x;
        return jVar != null ? jVar : !this.f6558j.isEmpty() ? this.f6558j.getLast() : this.f6573y;
    }

    private int S(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        boolean isOffloadedPlaybackSupported;
        int playbackOffloadSupport;
        int i6 = i2.c1.f5548a;
        if (i6 >= 31) {
            playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
            return playbackOffloadSupport;
        }
        isOffloadedPlaybackSupported = AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes);
        if (isOffloadedPlaybackSupported) {
            return (i6 == 30 && i2.c1.f5551d.startsWith("Pixel")) ? 2 : 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long U() {
        return this.f6569u.f6586c == 0 ? this.C / r0.f6585b : this.D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long V() {
        return this.f6569u.f6586c == 0 ? this.E / r0.f6587d : this.F;
    }

    private boolean W() {
        o3 o3Var;
        if (!this.f6556h.d()) {
            return false;
        }
        AudioTrack K = K();
        this.f6570v = K;
        if (Z(K)) {
            e0(this.f6570v);
            if (this.f6560l != 3) {
                AudioTrack audioTrack = this.f6570v;
                y1 y1Var = this.f6569u.f6584a;
                audioTrack.setOffloadDelayPadding(y1Var.F, y1Var.G);
            }
        }
        int i6 = i2.c1.f5548a;
        if (i6 >= 31 && (o3Var = this.f6566r) != null) {
            c.a(this.f6570v, o3Var);
        }
        this.X = this.f6570v.getAudioSessionId();
        z zVar = this.f6557i;
        AudioTrack audioTrack2 = this.f6570v;
        g gVar = this.f6569u;
        zVar.s(audioTrack2, gVar.f6586c == 2, gVar.f6590g, gVar.f6587d, gVar.f6591h);
        j0();
        int i7 = this.Y.f6371a;
        if (i7 != 0) {
            this.f6570v.attachAuxEffect(i7);
            this.f6570v.setAuxEffectSendLevel(this.Y.f6372b);
        }
        d dVar = this.Z;
        if (dVar != null && i6 >= 23) {
            b.a(this.f6570v, dVar);
        }
        this.I = true;
        return true;
    }

    private static boolean X(int i6) {
        return (i2.c1.f5548a >= 24 && i6 == -6) || i6 == -32;
    }

    private boolean Y() {
        return this.f6570v != null;
    }

    private static boolean Z(AudioTrack audioTrack) {
        boolean isOffloadedPlayback;
        if (i2.c1.f5548a >= 29) {
            isOffloadedPlayback = audioTrack.isOffloadedPlayback();
            if (isOffloadedPlayback) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a0(AudioTrack audioTrack, i2.h hVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            hVar.e();
            synchronized (f6542f0) {
                int i6 = f6544h0 - 1;
                f6544h0 = i6;
                if (i6 == 0) {
                    f6543g0.shutdown();
                    f6543g0 = null;
                }
            }
        } catch (Throwable th) {
            hVar.e();
            synchronized (f6542f0) {
                int i7 = f6544h0 - 1;
                f6544h0 = i7;
                if (i7 == 0) {
                    f6543g0.shutdown();
                    f6543g0 = null;
                }
                throw th;
            }
        }
    }

    private void b0() {
        if (this.f6569u.l()) {
            this.f6550c0 = true;
        }
    }

    private void c0() {
        if (this.U) {
            return;
        }
        this.U = true;
        this.f6557i.g(V());
        this.f6570v.stop();
        this.B = 0;
    }

    private void d0(long j6) {
        ByteBuffer byteBuffer;
        int length = this.L.length;
        int i6 = length;
        while (i6 >= 0) {
            if (i6 > 0) {
                byteBuffer = this.M[i6 - 1];
            } else {
                byteBuffer = this.N;
                if (byteBuffer == null) {
                    byteBuffer = j0.i.f6442a;
                }
            }
            if (i6 == length) {
                q0(byteBuffer, j6);
            } else {
                j0.i iVar = this.L[i6];
                if (i6 > this.S) {
                    iVar.e(byteBuffer);
                }
                ByteBuffer b6 = iVar.b();
                this.M[i6] = b6;
                if (b6.hasRemaining()) {
                    i6++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i6--;
            }
        }
    }

    private void e0(AudioTrack audioTrack) {
        if (this.f6561m == null) {
            this.f6561m = new m();
        }
        this.f6561m.a(audioTrack);
    }

    private static void f0(final AudioTrack audioTrack, final i2.h hVar) {
        hVar.c();
        synchronized (f6542f0) {
            if (f6543g0 == null) {
                f6543g0 = i2.c1.E0("ExoPlayer:AudioTrackReleaseThread");
            }
            f6544h0++;
            f6543g0.execute(new Runnable() { // from class: j0.r0
                @Override // java.lang.Runnable
                public final void run() {
                    s0.a0(audioTrack, hVar);
                }
            });
        }
    }

    private void g0() {
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.f6552d0 = false;
        this.G = 0;
        this.f6573y = new j(O(), T(), 0L, 0L);
        this.J = 0L;
        this.f6572x = null;
        this.f6558j.clear();
        this.N = null;
        this.O = 0;
        this.P = null;
        this.U = false;
        this.T = false;
        this.S = -1;
        this.A = null;
        this.B = 0;
        this.f6553e.n();
        M();
    }

    private void h0(n3 n3Var, boolean z5) {
        j R = R();
        if (n3Var.equals(R.f6596a) && z5 == R.f6597b) {
            return;
        }
        j jVar = new j(n3Var, z5, -9223372036854775807L, -9223372036854775807L);
        if (Y()) {
            this.f6572x = jVar;
        } else {
            this.f6573y = jVar;
        }
    }

    private void i0(n3 n3Var) {
        PlaybackParams allowDefaults;
        PlaybackParams speed;
        PlaybackParams pitch;
        PlaybackParams audioFallbackMode;
        PlaybackParams playbackParams;
        float speed2;
        PlaybackParams playbackParams2;
        float pitch2;
        if (Y()) {
            allowDefaults = new PlaybackParams().allowDefaults();
            speed = allowDefaults.setSpeed(n3Var.f4732a);
            pitch = speed.setPitch(n3Var.f4733b);
            audioFallbackMode = pitch.setAudioFallbackMode(2);
            try {
                this.f6570v.setPlaybackParams(audioFallbackMode);
            } catch (IllegalArgumentException e6) {
                i2.t.j("DefaultAudioSink", "Failed to set playback params", e6);
            }
            playbackParams = this.f6570v.getPlaybackParams();
            speed2 = playbackParams.getSpeed();
            playbackParams2 = this.f6570v.getPlaybackParams();
            pitch2 = playbackParams2.getPitch();
            n3Var = new n3(speed2, pitch2);
            this.f6557i.t(n3Var.f4732a);
        }
        this.f6574z = n3Var;
    }

    private void j0() {
        if (Y()) {
            if (i2.c1.f5548a >= 21) {
                k0(this.f6570v, this.K);
            } else {
                l0(this.f6570v, this.K);
            }
        }
    }

    private static void k0(AudioTrack audioTrack, float f6) {
        audioTrack.setVolume(f6);
    }

    private static void l0(AudioTrack audioTrack, float f6) {
        audioTrack.setStereoVolume(f6, f6);
    }

    private void m0() {
        j0.i[] iVarArr = this.f6569u.f6592i;
        ArrayList arrayList = new ArrayList();
        for (j0.i iVar : iVarArr) {
            if (iVar.a()) {
                arrayList.add(iVar);
            } else {
                iVar.flush();
            }
        }
        int size = arrayList.size();
        this.L = (j0.i[]) arrayList.toArray(new j0.i[size]);
        this.M = new ByteBuffer[size];
        M();
    }

    private boolean n0() {
        return (this.f6546a0 || !"audio/raw".equals(this.f6569u.f6584a.f5066p) || o0(this.f6569u.f6584a.E)) ? false : true;
    }

    private boolean o0(int i6) {
        return this.f6549c && i2.c1.u0(i6);
    }

    private boolean p0(y1 y1Var, j0.e eVar) {
        int f6;
        int G;
        int S;
        if (i2.c1.f5548a < 29 || this.f6560l == 0 || (f6 = i2.x.f((String) i2.a.e(y1Var.f5066p), y1Var.f5063m)) == 0 || (G = i2.c1.G(y1Var.C)) == 0 || (S = S(N(y1Var.D, G, f6), eVar.b().f6414a)) == 0) {
            return false;
        }
        if (S == 1) {
            return ((y1Var.F != 0 || y1Var.G != 0) && (this.f6560l == 1)) ? false : true;
        }
        if (S == 2) {
            return true;
        }
        throw new IllegalStateException();
    }

    private void q0(ByteBuffer byteBuffer, long j6) {
        int r02;
        x.c cVar;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.P;
            if (byteBuffer2 != null) {
                i2.a.a(byteBuffer2 == byteBuffer);
            } else {
                this.P = byteBuffer;
                if (i2.c1.f5548a < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.Q;
                    if (bArr == null || bArr.length < remaining) {
                        this.Q = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.Q, 0, remaining);
                    byteBuffer.position(position);
                    this.R = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (i2.c1.f5548a < 21) {
                int c6 = this.f6557i.c(this.E);
                if (c6 > 0) {
                    r02 = this.f6570v.write(this.Q, this.R, Math.min(remaining2, c6));
                    if (r02 > 0) {
                        this.R += r02;
                        byteBuffer.position(byteBuffer.position() + r02);
                    }
                } else {
                    r02 = 0;
                }
            } else if (this.f6546a0) {
                i2.a.g(j6 != -9223372036854775807L);
                r02 = s0(this.f6570v, byteBuffer, remaining2, j6);
            } else {
                r02 = r0(this.f6570v, byteBuffer, remaining2);
            }
            this.f6548b0 = SystemClock.elapsedRealtime();
            if (r02 < 0) {
                x.e eVar = new x.e(r02, this.f6569u.f6584a, X(r02) && this.F > 0);
                x.c cVar2 = this.f6567s;
                if (cVar2 != null) {
                    cVar2.c(eVar);
                }
                if (eVar.f6624b) {
                    throw eVar;
                }
                this.f6563o.b(eVar);
                return;
            }
            this.f6563o.a();
            if (Z(this.f6570v)) {
                if (this.F > 0) {
                    this.f6552d0 = false;
                }
                if (this.V && (cVar = this.f6567s) != null && r02 < remaining2 && !this.f6552d0) {
                    cVar.e();
                }
            }
            int i6 = this.f6569u.f6586c;
            if (i6 == 0) {
                this.E += r02;
            }
            if (r02 == remaining2) {
                if (i6 != 0) {
                    i2.a.g(byteBuffer == this.N);
                    this.F += this.G * this.O;
                }
                this.P = null;
            }
        }
    }

    private static int r0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i6) {
        return audioTrack.write(byteBuffer, i6, 1);
    }

    private int s0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i6, long j6) {
        int write;
        if (i2.c1.f5548a >= 26) {
            write = audioTrack.write(byteBuffer, i6, 1, j6 * 1000);
            return write;
        }
        if (this.A == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.A = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.A.putInt(1431633921);
        }
        if (this.B == 0) {
            this.A.putInt(4, i6);
            this.A.putLong(8, j6 * 1000);
            this.A.position(0);
            this.B = i6;
        }
        int remaining = this.A.remaining();
        if (remaining > 0) {
            int write2 = audioTrack.write(this.A, remaining, 1);
            if (write2 < 0) {
                this.B = 0;
                return write2;
            }
            if (write2 < remaining) {
                return 0;
            }
        }
        int r02 = r0(audioTrack, byteBuffer, i6);
        if (r02 < 0) {
            this.B = 0;
            return r02;
        }
        this.B -= r02;
        return r02;
    }

    public boolean T() {
        return R().f6597b;
    }

    @Override // j0.x
    public boolean a(y1 y1Var) {
        return n(y1Var) != 0;
    }

    @Override // j0.x
    public void b(j0.e eVar) {
        if (this.f6571w.equals(eVar)) {
            return;
        }
        this.f6571w = eVar;
        if (this.f6546a0) {
            return;
        }
        flush();
    }

    @Override // j0.x
    public boolean c() {
        return !Y() || (this.T && !k());
    }

    @Override // j0.x
    public void d() {
        this.V = false;
        if (Y() && this.f6557i.p()) {
            this.f6570v.pause();
        }
    }

    @Override // j0.x
    public void e() {
        i2.a.g(i2.c1.f5548a >= 21);
        i2.a.g(this.W);
        if (this.f6546a0) {
            return;
        }
        this.f6546a0 = true;
        flush();
    }

    @Override // j0.x
    public void f() {
        this.V = true;
        if (Y()) {
            this.f6557i.u();
            this.f6570v.play();
        }
    }

    @Override // j0.x
    public void flush() {
        if (Y()) {
            g0();
            if (this.f6557i.i()) {
                this.f6570v.pause();
            }
            if (Z(this.f6570v)) {
                ((m) i2.a.e(this.f6561m)).b(this.f6570v);
            }
            if (i2.c1.f5548a < 21 && !this.W) {
                this.X = 0;
            }
            g gVar = this.f6568t;
            if (gVar != null) {
                this.f6569u = gVar;
                this.f6568t = null;
            }
            this.f6557i.q();
            f0(this.f6570v, this.f6556h);
            this.f6570v = null;
        }
        this.f6563o.a();
        this.f6562n.a();
    }

    @Override // j0.x
    public void g() {
        if (!this.T && Y() && L()) {
            c0();
            this.T = true;
        }
    }

    @Override // j0.x
    public n3 h() {
        return this.f6559k ? this.f6574z : O();
    }

    @Override // j0.x
    public void i(n3 n3Var) {
        n3 n3Var2 = new n3(i2.c1.p(n3Var.f4732a, 0.1f, 8.0f), i2.c1.p(n3Var.f4733b, 0.1f, 8.0f));
        if (!this.f6559k || i2.c1.f5548a < 23) {
            h0(n3Var2, T());
        } else {
            i0(n3Var2);
        }
    }

    @Override // j0.x
    public void j(o3 o3Var) {
        this.f6566r = o3Var;
    }

    @Override // j0.x
    public boolean k() {
        return Y() && this.f6557i.h(V());
    }

    @Override // j0.x
    public void l(x.c cVar) {
        this.f6567s = cVar;
    }

    @Override // j0.x
    public void m(float f6) {
        if (this.K != f6) {
            this.K = f6;
            j0();
        }
    }

    @Override // j0.x
    public int n(y1 y1Var) {
        if (!"audio/raw".equals(y1Var.f5066p)) {
            return ((this.f6550c0 || !p0(y1Var, this.f6571w)) && !this.f6545a.h(y1Var)) ? 0 : 2;
        }
        if (i2.c1.v0(y1Var.E)) {
            int i6 = y1Var.E;
            return (i6 == 2 || (this.f6549c && i6 == 4)) ? 2 : 1;
        }
        i2.t.i("DefaultAudioSink", "Invalid PCM encoding: " + y1Var.E);
        return 0;
    }

    @Override // j0.x
    public void o(int i6) {
        if (this.X != i6) {
            this.X = i6;
            this.W = i6 != 0;
            flush();
        }
    }

    @Override // j0.x
    public void p(y1 y1Var, int i6, int[] iArr) {
        j0.i[] iVarArr;
        int i7;
        int intValue;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int a6;
        int[] iArr2;
        if ("audio/raw".equals(y1Var.f5066p)) {
            i2.a.a(i2.c1.v0(y1Var.E));
            i9 = i2.c1.f0(y1Var.E, y1Var.C);
            j0.i[] iVarArr2 = o0(y1Var.E) ? this.f6555g : this.f6554f;
            this.f6553e.o(y1Var.F, y1Var.G);
            if (i2.c1.f5548a < 21 && y1Var.C == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i16 = 0; i16 < 6; i16++) {
                    iArr2[i16] = i16;
                }
            } else {
                iArr2 = iArr;
            }
            this.f6551d.m(iArr2);
            i.a aVar = new i.a(y1Var.D, y1Var.C, y1Var.E);
            for (j0.i iVar : iVarArr2) {
                try {
                    i.a f6 = iVar.f(aVar);
                    if (iVar.a()) {
                        aVar = f6;
                    }
                } catch (i.b e6) {
                    throw new x.a(e6, y1Var);
                }
            }
            int i17 = aVar.f6446c;
            int i18 = aVar.f6444a;
            int G = i2.c1.G(aVar.f6445b);
            iVarArr = iVarArr2;
            i10 = i2.c1.f0(i17, aVar.f6445b);
            i8 = i17;
            i7 = i18;
            intValue = G;
            i11 = 0;
        } else {
            j0.i[] iVarArr3 = new j0.i[0];
            int i19 = y1Var.D;
            if (p0(y1Var, this.f6571w)) {
                iVarArr = iVarArr3;
                i7 = i19;
                i8 = i2.x.f((String) i2.a.e(y1Var.f5066p), y1Var.f5063m);
                intValue = i2.c1.G(y1Var.C);
                i9 = -1;
                i10 = -1;
                i11 = 1;
            } else {
                Pair<Integer, Integer> f7 = this.f6545a.f(y1Var);
                if (f7 == null) {
                    throw new x.a("Unable to configure passthrough for: " + y1Var, y1Var);
                }
                int intValue2 = ((Integer) f7.first).intValue();
                iVarArr = iVarArr3;
                i7 = i19;
                intValue = ((Integer) f7.second).intValue();
                i8 = intValue2;
                i9 = -1;
                i10 = -1;
                i11 = 2;
            }
        }
        if (i8 == 0) {
            throw new x.a("Invalid output encoding (mode=" + i11 + ") for: " + y1Var, y1Var);
        }
        if (intValue == 0) {
            throw new x.a("Invalid output channel config (mode=" + i11 + ") for: " + y1Var, y1Var);
        }
        if (i6 != 0) {
            a6 = i6;
            i12 = i8;
            i13 = intValue;
            i14 = i10;
            i15 = i7;
        } else {
            i12 = i8;
            i13 = intValue;
            i14 = i10;
            i15 = i7;
            a6 = this.f6564p.a(P(i7, intValue, i8), i8, i11, i10 != -1 ? i10 : 1, i7, y1Var.f5062l, this.f6559k ? 8.0d : 1.0d);
        }
        this.f6550c0 = false;
        g gVar = new g(y1Var, i9, i11, i14, i15, i13, i12, a6, iVarArr);
        if (Y()) {
            this.f6568t = gVar;
        } else {
            this.f6569u = gVar;
        }
    }

    @Override // j0.x
    public boolean q(ByteBuffer byteBuffer, long j6, int i6) {
        ByteBuffer byteBuffer2 = this.N;
        i2.a.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.f6568t != null) {
            if (!L()) {
                return false;
            }
            if (this.f6568t.b(this.f6569u)) {
                this.f6569u = this.f6568t;
                this.f6568t = null;
                if (Z(this.f6570v) && this.f6560l != 3) {
                    if (this.f6570v.getPlayState() == 3) {
                        this.f6570v.setOffloadEndOfStream();
                    }
                    AudioTrack audioTrack = this.f6570v;
                    y1 y1Var = this.f6569u.f6584a;
                    audioTrack.setOffloadDelayPadding(y1Var.F, y1Var.G);
                    this.f6552d0 = true;
                }
            } else {
                c0();
                if (k()) {
                    return false;
                }
                flush();
            }
            G(j6);
        }
        if (!Y()) {
            try {
                if (!W()) {
                    return false;
                }
            } catch (x.b e6) {
                if (e6.f6619b) {
                    throw e6;
                }
                this.f6562n.b(e6);
                return false;
            }
        }
        this.f6562n.a();
        if (this.I) {
            this.J = Math.max(0L, j6);
            this.H = false;
            this.I = false;
            if (this.f6559k && i2.c1.f5548a >= 23) {
                i0(this.f6574z);
            }
            G(j6);
            if (this.V) {
                f();
            }
        }
        if (!this.f6557i.k(V())) {
            return false;
        }
        if (this.N == null) {
            i2.a.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            g gVar = this.f6569u;
            if (gVar.f6586c != 0 && this.G == 0) {
                int Q = Q(gVar.f6590g, byteBuffer);
                this.G = Q;
                if (Q == 0) {
                    return true;
                }
            }
            if (this.f6572x != null) {
                if (!L()) {
                    return false;
                }
                G(j6);
                this.f6572x = null;
            }
            long k6 = this.J + this.f6569u.k(U() - this.f6553e.m());
            if (!this.H && Math.abs(k6 - j6) > 200000) {
                x.c cVar = this.f6567s;
                if (cVar != null) {
                    cVar.c(new x.d(j6, k6));
                }
                this.H = true;
            }
            if (this.H) {
                if (!L()) {
                    return false;
                }
                long j7 = j6 - k6;
                this.J += j7;
                this.H = false;
                G(j6);
                x.c cVar2 = this.f6567s;
                if (cVar2 != null && j7 != 0) {
                    cVar2.d();
                }
            }
            if (this.f6569u.f6586c == 0) {
                this.C += byteBuffer.remaining();
            } else {
                this.D += this.G * i6;
            }
            this.N = byteBuffer;
            this.O = i6;
        }
        d0(j6);
        if (!this.N.hasRemaining()) {
            this.N = null;
            this.O = 0;
            return true;
        }
        if (!this.f6557i.j(V())) {
            return false;
        }
        i2.t.i("DefaultAudioSink", "Resetting stalled audio track");
        flush();
        return true;
    }

    @Override // j0.x
    public long r(boolean z5) {
        if (!Y() || this.I) {
            return Long.MIN_VALUE;
        }
        return I(H(Math.min(this.f6557i.d(z5), this.f6569u.h(V()))));
    }

    @Override // j0.x
    public void reset() {
        flush();
        for (j0.i iVar : this.f6554f) {
            iVar.reset();
        }
        for (j0.i iVar2 : this.f6555g) {
            iVar2.reset();
        }
        this.V = false;
        this.f6550c0 = false;
    }

    @Override // j0.x
    public void s() {
        if (this.f6546a0) {
            this.f6546a0 = false;
            flush();
        }
    }

    @Override // j0.x
    public void setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
        d dVar = audioDeviceInfo == null ? null : new d(audioDeviceInfo);
        this.Z = dVar;
        AudioTrack audioTrack = this.f6570v;
        if (audioTrack != null) {
            b.a(audioTrack, dVar);
        }
    }

    @Override // j0.x
    public void t(a0 a0Var) {
        if (this.Y.equals(a0Var)) {
            return;
        }
        int i6 = a0Var.f6371a;
        float f6 = a0Var.f6372b;
        AudioTrack audioTrack = this.f6570v;
        if (audioTrack != null) {
            if (this.Y.f6371a != i6) {
                audioTrack.attachAuxEffect(i6);
            }
            if (i6 != 0) {
                this.f6570v.setAuxEffectSendLevel(f6);
            }
        }
        this.Y = a0Var;
    }

    @Override // j0.x
    public /* synthetic */ void u(long j6) {
        w.a(this, j6);
    }

    @Override // j0.x
    public void v() {
        if (i2.c1.f5548a < 25) {
            flush();
            return;
        }
        this.f6563o.a();
        this.f6562n.a();
        if (Y()) {
            g0();
            if (this.f6557i.i()) {
                this.f6570v.pause();
            }
            this.f6570v.flush();
            this.f6557i.q();
            z zVar = this.f6557i;
            AudioTrack audioTrack = this.f6570v;
            g gVar = this.f6569u;
            zVar.s(audioTrack, gVar.f6586c == 2, gVar.f6590g, gVar.f6587d, gVar.f6591h);
            this.I = true;
        }
    }

    @Override // j0.x
    public void w(boolean z5) {
        h0(O(), z5);
    }

    @Override // j0.x
    public void x() {
        this.H = true;
    }
}
