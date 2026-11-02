package i0;

import a1.w;
import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.NetworkEvent;
import android.media.metrics.PlaybackErrorEvent;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.PlaybackStateEvent;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.window.embedding.EmbeddingCompat;
import g2.v0;
import g2.z;
import h0.h2;
import h0.m4;
import h0.o3;
import h0.r4;
import i0.c;
import i0.n3;
import j0.x;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import l1.v;
import m0.h;
import m0.o;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public final class m3 implements c, n3.a {
    private boolean A;

    /* renamed from: a, reason: collision with root package name */
    private final Context f5372a;

    /* renamed from: b, reason: collision with root package name */
    private final n3 f5373b;

    /* renamed from: c, reason: collision with root package name */
    private final PlaybackSession f5374c;

    /* renamed from: i, reason: collision with root package name */
    private String f5380i;

    /* renamed from: j, reason: collision with root package name */
    private PlaybackMetrics.Builder f5381j;

    /* renamed from: k, reason: collision with root package name */
    private int f5382k;

    /* renamed from: n, reason: collision with root package name */
    private h0.k3 f5385n;

    /* renamed from: o, reason: collision with root package name */
    private b f5386o;

    /* renamed from: p, reason: collision with root package name */
    private b f5387p;

    /* renamed from: q, reason: collision with root package name */
    private b f5388q;

    /* renamed from: r, reason: collision with root package name */
    private h0.y1 f5389r;

    /* renamed from: s, reason: collision with root package name */
    private h0.y1 f5390s;

    /* renamed from: t, reason: collision with root package name */
    private h0.y1 f5391t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f5392u;

    /* renamed from: v, reason: collision with root package name */
    private int f5393v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f5394w;

    /* renamed from: x, reason: collision with root package name */
    private int f5395x;

    /* renamed from: y, reason: collision with root package name */
    private int f5396y;

    /* renamed from: z, reason: collision with root package name */
    private int f5397z;

    /* renamed from: e, reason: collision with root package name */
    private final m4.d f5376e = new m4.d();

    /* renamed from: f, reason: collision with root package name */
    private final m4.b f5377f = new m4.b();

    /* renamed from: h, reason: collision with root package name */
    private final HashMap<String, Long> f5379h = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private final HashMap<String, Long> f5378g = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final long f5375d = SystemClock.elapsedRealtime();

    /* renamed from: l, reason: collision with root package name */
    private int f5383l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f5384m = 0;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f5398a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5399b;

        public a(int i6, int i7) {
            this.f5398a = i6;
            this.f5399b = i7;
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final h0.y1 f5400a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5401b;

        /* renamed from: c, reason: collision with root package name */
        public final String f5402c;

        public b(h0.y1 y1Var, int i6, String str) {
            this.f5400a = y1Var;
            this.f5401b = i6;
            this.f5402c = str;
        }
    }

    private m3(Context context, PlaybackSession playbackSession) {
        this.f5372a = context.getApplicationContext();
        this.f5374c = playbackSession;
        r1 r1Var = new r1();
        this.f5373b = r1Var;
        r1Var.f(this);
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = EmbeddingCompat.DEBUG)
    private boolean A0(b bVar) {
        return bVar != null && bVar.f5402c.equals(this.f5373b.a());
    }

    public static m3 B0(Context context) {
        PlaybackSession createPlaybackSession;
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        createPlaybackSession = mediaMetricsManager.createPlaybackSession();
        return new m3(context, createPlaybackSession);
    }

    private void C0() {
        PlaybackMetrics build;
        PlaybackMetrics.Builder builder = this.f5381j;
        if (builder != null && this.A) {
            builder.setAudioUnderrunCount(this.f5397z);
            this.f5381j.setVideoFramesDropped(this.f5395x);
            this.f5381j.setVideoFramesPlayed(this.f5396y);
            Long l6 = this.f5378g.get(this.f5380i);
            this.f5381j.setNetworkTransferDurationMillis(l6 == null ? 0L : l6.longValue());
            Long l7 = this.f5379h.get(this.f5380i);
            this.f5381j.setNetworkBytesRead(l7 == null ? 0L : l7.longValue());
            this.f5381j.setStreamSource((l7 == null || l7.longValue() <= 0) ? 0 : 1);
            PlaybackSession playbackSession = this.f5374c;
            build = this.f5381j.build();
            playbackSession.reportPlaybackMetrics(build);
        }
        this.f5381j = null;
        this.f5380i = null;
        this.f5397z = 0;
        this.f5395x = 0;
        this.f5396y = 0;
        this.f5389r = null;
        this.f5390s = null;
        this.f5391t = null;
        this.A = false;
    }

    private static int D0(int i6) {
        switch (i2.c1.W(i6)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private static m0.m E0(m2.q<r4.a> qVar) {
        m0.m mVar;
        m2.s0<r4.a> it = qVar.iterator();
        while (it.hasNext()) {
            r4.a next = it.next();
            for (int i6 = 0; i6 < next.f4853a; i6++) {
                if (next.g(i6) && (mVar = next.c(i6).f5069s) != null) {
                    return mVar;
                }
            }
        }
        return null;
    }

    private static int F0(m0.m mVar) {
        for (int i6 = 0; i6 < mVar.f7853d; i6++) {
            UUID uuid = mVar.h(i6).f7855b;
            if (uuid.equals(h0.p.f4774d)) {
                return 3;
            }
            if (uuid.equals(h0.p.f4775e)) {
                return 2;
            }
            if (uuid.equals(h0.p.f4773c)) {
                return 6;
            }
        }
        return 1;
    }

    private static a G0(h0.k3 k3Var, Context context, boolean z5) {
        int i6;
        boolean z6;
        if (k3Var.f4551a == 1001) {
            return new a(20, 0);
        }
        if (k3Var instanceof h0.x) {
            h0.x xVar = (h0.x) k3Var;
            z6 = xVar.f4997m == 1;
            i6 = xVar.f5001q;
        } else {
            i6 = 0;
            z6 = false;
        }
        Throwable th = (Throwable) i2.a.e(k3Var.getCause());
        if (!(th instanceof IOException)) {
            if (z6 && (i6 == 0 || i6 == 1)) {
                return new a(35, 0);
            }
            if (z6 && i6 == 3) {
                return new a(15, 0);
            }
            if (z6 && i6 == 2) {
                return new a(23, 0);
            }
            if (th instanceof w.b) {
                return new a(13, i2.c1.X(((w.b) th).f134d));
            }
            if (th instanceof a1.q) {
                return new a(14, i2.c1.X(((a1.q) th).f84b));
            }
            if (th instanceof OutOfMemoryError) {
                return new a(14, 0);
            }
            if (th instanceof x.b) {
                return new a(17, ((x.b) th).f6618a);
            }
            if (th instanceof x.e) {
                return new a(18, ((x.e) th).f6623a);
            }
            if (i2.c1.f5548a < 16 || !(th instanceof MediaCodec.CryptoException)) {
                return new a(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th).getErrorCode();
            return new a(D0(errorCode), errorCode);
        }
        if (th instanceof g2.d0) {
            return new a(5, ((g2.d0) th).f4012d);
        }
        if ((th instanceof g2.c0) || (th instanceof h0.g3)) {
            return new a(z5 ? 10 : 11, 0);
        }
        if ((th instanceof g2.b0) || (th instanceof v0.a)) {
            if (i2.a0.d(context).f() == 1) {
                return new a(3, 0);
            }
            Throwable cause = th.getCause();
            return cause instanceof UnknownHostException ? new a(6, 0) : cause instanceof SocketTimeoutException ? new a(7, 0) : ((th instanceof g2.b0) && ((g2.b0) th).f4005c == 1) ? new a(4, 0) : new a(8, 0);
        }
        if (k3Var.f4551a == 1002) {
            return new a(21, 0);
        }
        if (!(th instanceof o.a)) {
            if (!(th instanceof z.b) || !(th.getCause() instanceof FileNotFoundException)) {
                return new a(9, 0);
            }
            Throwable cause2 = ((Throwable) i2.a.e(th.getCause())).getCause();
            return (i2.c1.f5548a >= 21 && (cause2 instanceof ErrnoException) && ((ErrnoException) cause2).errno == OsConstants.EACCES) ? new a(32, 0) : new a(31, 0);
        }
        Throwable th2 = (Throwable) i2.a.e(th.getCause());
        int i7 = i2.c1.f5548a;
        if (i7 < 21 || !(th2 instanceof MediaDrm.MediaDrmStateException)) {
            return (i7 < 23 || !(th2 instanceof MediaDrmResetException)) ? (i7 < 18 || !(th2 instanceof NotProvisionedException)) ? (i7 < 18 || !(th2 instanceof DeniedByServerException)) ? th2 instanceof m0.v0 ? new a(23, 0) : th2 instanceof h.e ? new a(28, 0) : new a(30, 0) : new a(29, 0) : new a(24, 0) : new a(27, 0);
        }
        int X = i2.c1.X(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo());
        return new a(D0(X), X);
    }

    private static Pair<String, String> H0(String str) {
        String[] U0 = i2.c1.U0(str, "-");
        return Pair.create(U0[0], U0.length >= 2 ? U0[1] : null);
    }

    private static int J0(Context context) {
        switch (i2.a0.d(context).f()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
            case 8:
            default:
                return 1;
            case 7:
                return 3;
            case 9:
                return 8;
            case 10:
                return 7;
        }
    }

    private static int K0(h0.h2 h2Var) {
        h2.h hVar = h2Var.f4406b;
        if (hVar == null) {
            return 0;
        }
        int q02 = i2.c1.q0(hVar.f4479a, hVar.f4480b);
        if (q02 == 0) {
            return 3;
        }
        if (q02 != 1) {
            return q02 != 2 ? 1 : 4;
        }
        return 5;
    }

    private static int L0(int i6) {
        if (i6 == 1) {
            return 2;
        }
        if (i6 != 2) {
            return i6 != 3 ? 1 : 4;
        }
        return 3;
    }

    private void M0(c.b bVar) {
        for (int i6 = 0; i6 < bVar.d(); i6++) {
            int b6 = bVar.b(i6);
            c.a c6 = bVar.c(b6);
            if (b6 == 0) {
                this.f5373b.d(c6);
            } else if (b6 == 11) {
                this.f5373b.g(c6, this.f5382k);
            } else {
                this.f5373b.b(c6);
            }
        }
    }

    private void N0(long j6) {
        NetworkEvent.Builder networkType;
        NetworkEvent.Builder timeSinceCreatedMillis;
        NetworkEvent build;
        int J0 = J0(this.f5372a);
        if (J0 != this.f5384m) {
            this.f5384m = J0;
            PlaybackSession playbackSession = this.f5374c;
            networkType = new NetworkEvent.Builder().setNetworkType(J0);
            timeSinceCreatedMillis = networkType.setTimeSinceCreatedMillis(j6 - this.f5375d);
            build = timeSinceCreatedMillis.build();
            playbackSession.reportNetworkEvent(build);
        }
    }

    private void O0(long j6) {
        PlaybackErrorEvent.Builder timeSinceCreatedMillis;
        PlaybackErrorEvent.Builder errorCode;
        PlaybackErrorEvent.Builder subErrorCode;
        PlaybackErrorEvent.Builder exception;
        PlaybackErrorEvent build;
        h0.k3 k3Var = this.f5385n;
        if (k3Var == null) {
            return;
        }
        a G0 = G0(k3Var, this.f5372a, this.f5393v == 4);
        PlaybackSession playbackSession = this.f5374c;
        timeSinceCreatedMillis = new PlaybackErrorEvent.Builder().setTimeSinceCreatedMillis(j6 - this.f5375d);
        errorCode = timeSinceCreatedMillis.setErrorCode(G0.f5398a);
        subErrorCode = errorCode.setSubErrorCode(G0.f5399b);
        exception = subErrorCode.setException(k3Var);
        build = exception.build();
        playbackSession.reportPlaybackErrorEvent(build);
        this.A = true;
        this.f5385n = null;
    }

    private void P0(h0.o3 o3Var, c.b bVar, long j6) {
        PlaybackStateEvent.Builder state;
        PlaybackStateEvent.Builder timeSinceCreatedMillis;
        PlaybackStateEvent build;
        if (o3Var.c() != 2) {
            this.f5392u = false;
        }
        if (o3Var.n() == null) {
            this.f5394w = false;
        } else if (bVar.a(10)) {
            this.f5394w = true;
        }
        int X0 = X0(o3Var);
        if (this.f5383l != X0) {
            this.f5383l = X0;
            this.A = true;
            PlaybackSession playbackSession = this.f5374c;
            state = new PlaybackStateEvent.Builder().setState(this.f5383l);
            timeSinceCreatedMillis = state.setTimeSinceCreatedMillis(j6 - this.f5375d);
            build = timeSinceCreatedMillis.build();
            playbackSession.reportPlaybackStateEvent(build);
        }
    }

    private void Q0(h0.o3 o3Var, c.b bVar, long j6) {
        if (bVar.a(2)) {
            r4 F = o3Var.F();
            boolean c6 = F.c(2);
            boolean c7 = F.c(1);
            boolean c8 = F.c(3);
            if (c6 || c7 || c8) {
                if (!c6) {
                    V0(j6, null, 0);
                }
                if (!c7) {
                    R0(j6, null, 0);
                }
                if (!c8) {
                    T0(j6, null, 0);
                }
            }
        }
        if (A0(this.f5386o)) {
            b bVar2 = this.f5386o;
            h0.y1 y1Var = bVar2.f5400a;
            if (y1Var.f5072v != -1) {
                V0(j6, y1Var, bVar2.f5401b);
                this.f5386o = null;
            }
        }
        if (A0(this.f5387p)) {
            b bVar3 = this.f5387p;
            R0(j6, bVar3.f5400a, bVar3.f5401b);
            this.f5387p = null;
        }
        if (A0(this.f5388q)) {
            b bVar4 = this.f5388q;
            T0(j6, bVar4.f5400a, bVar4.f5401b);
            this.f5388q = null;
        }
    }

    private void R0(long j6, h0.y1 y1Var, int i6) {
        if (i2.c1.c(this.f5390s, y1Var)) {
            return;
        }
        int i7 = (this.f5390s == null && i6 == 0) ? 1 : i6;
        this.f5390s = y1Var;
        W0(0, j6, y1Var, i7);
    }

    private void S0(h0.o3 o3Var, c.b bVar) {
        m0.m E0;
        if (bVar.a(0)) {
            c.a c6 = bVar.c(0);
            if (this.f5381j != null) {
                U0(c6.f5284b, c6.f5286d);
            }
        }
        if (bVar.a(2) && this.f5381j != null && (E0 = E0(o3Var.F().b())) != null) {
            ((PlaybackMetrics.Builder) i2.c1.j(this.f5381j)).setDrmType(F0(E0));
        }
        if (bVar.a(1011)) {
            this.f5397z++;
        }
    }

    private void T0(long j6, h0.y1 y1Var, int i6) {
        if (i2.c1.c(this.f5391t, y1Var)) {
            return;
        }
        int i7 = (this.f5391t == null && i6 == 0) ? 1 : i6;
        this.f5391t = y1Var;
        W0(2, j6, y1Var, i7);
    }

    @RequiresNonNull({"metricsBuilder"})
    private void U0(m4 m4Var, v.b bVar) {
        int f6;
        PlaybackMetrics.Builder builder = this.f5381j;
        if (bVar == null || (f6 = m4Var.f(bVar.f7437a)) == -1) {
            return;
        }
        m4Var.j(f6, this.f5377f);
        m4Var.r(this.f5377f.f4677c, this.f5376e);
        builder.setStreamType(K0(this.f5376e.f4693c));
        m4.d dVar = this.f5376e;
        if (dVar.f4704r != -9223372036854775807L && !dVar.f4702p && !dVar.f4699m && !dVar.h()) {
            builder.setMediaDurationMillis(this.f5376e.f());
        }
        builder.setPlaybackType(this.f5376e.h() ? 2 : 1);
        this.A = true;
    }

    private void V0(long j6, h0.y1 y1Var, int i6) {
        if (i2.c1.c(this.f5389r, y1Var)) {
            return;
        }
        int i7 = (this.f5389r == null && i6 == 0) ? 1 : i6;
        this.f5389r = y1Var;
        W0(1, j6, y1Var, i7);
    }

    private void W0(int i6, long j6, h0.y1 y1Var, int i7) {
        TrackChangeEvent.Builder timeSinceCreatedMillis;
        TrackChangeEvent build;
        timeSinceCreatedMillis = new TrackChangeEvent.Builder(i6).setTimeSinceCreatedMillis(j6 - this.f5375d);
        if (y1Var != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(L0(i7));
            String str = y1Var.f5065o;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = y1Var.f5066p;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = y1Var.f5063m;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i8 = y1Var.f5062l;
            if (i8 != -1) {
                timeSinceCreatedMillis.setBitrate(i8);
            }
            int i9 = y1Var.f5071u;
            if (i9 != -1) {
                timeSinceCreatedMillis.setWidth(i9);
            }
            int i10 = y1Var.f5072v;
            if (i10 != -1) {
                timeSinceCreatedMillis.setHeight(i10);
            }
            int i11 = y1Var.C;
            if (i11 != -1) {
                timeSinceCreatedMillis.setChannelCount(i11);
            }
            int i12 = y1Var.D;
            if (i12 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i12);
            }
            String str4 = y1Var.f5057c;
            if (str4 != null) {
                Pair<String, String> H0 = H0(str4);
                timeSinceCreatedMillis.setLanguage((String) H0.first);
                Object obj = H0.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f6 = y1Var.f5073w;
            if (f6 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f6);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.A = true;
        PlaybackSession playbackSession = this.f5374c;
        build = timeSinceCreatedMillis.build();
        playbackSession.reportTrackChangeEvent(build);
    }

    private int X0(h0.o3 o3Var) {
        int c6 = o3Var.c();
        if (this.f5392u) {
            return 5;
        }
        if (this.f5394w) {
            return 13;
        }
        if (c6 == 4) {
            return 11;
        }
        if (c6 == 2) {
            int i6 = this.f5383l;
            if (i6 == 0 || i6 == 2) {
                return 2;
            }
            if (o3Var.y()) {
                return o3Var.S() != 0 ? 10 : 6;
            }
            return 7;
        }
        if (c6 == 3) {
            if (o3Var.y()) {
                return o3Var.S() != 0 ? 9 : 3;
            }
            return 4;
        }
        if (c6 != 1 || this.f5383l == 0) {
            return this.f5383l;
        }
        return 12;
    }

    @Override // i0.c
    public /* synthetic */ void A(c.a aVar, h0.v vVar) {
        i0.b.t(this, aVar, vVar);
    }

    @Override // i0.c
    public /* synthetic */ void B(c.a aVar) {
        i0.b.R(this, aVar);
    }

    @Override // i0.c
    public /* synthetic */ void C(c.a aVar, String str, long j6) {
        i0.b.f0(this, aVar, str, j6);
    }

    @Override // i0.c
    public /* synthetic */ void D(c.a aVar, o3.b bVar) {
        i0.b.m(this, aVar, bVar);
    }

    @Override // i0.c
    public /* synthetic */ void E(c.a aVar) {
        i0.b.B(this, aVar);
    }

    @Override // i0.c
    public /* synthetic */ void F(c.a aVar, String str, long j6, long j7) {
        i0.b.g0(this, aVar, str, j6, j7);
    }

    @Override // i0.c
    public /* synthetic */ void G(c.a aVar, float f6) {
        i0.b.n0(this, aVar, f6);
    }

    @Override // i0.c
    public /* synthetic */ void H(c.a aVar) {
        i0.b.y(this, aVar);
    }

    @Override // i0.c
    public void I(c.a aVar, o3.e eVar, o3.e eVar2, int i6) {
        if (i6 == 1) {
            this.f5392u = true;
        }
        this.f5382k = i6;
    }

    public LogSessionId I0() {
        LogSessionId sessionId;
        sessionId = this.f5374c.getSessionId();
        return sessionId;
    }

    @Override // i0.c
    public /* synthetic */ void J(c.a aVar, boolean z5) {
        i0.b.Z(this, aVar, z5);
    }

    @Override // i0.c
    public /* synthetic */ void K(c.a aVar, Exception exc) {
        i0.b.k(this, aVar, exc);
    }

    @Override // i0.c
    public /* synthetic */ void L(c.a aVar, h0.m2 m2Var) {
        i0.b.K(this, aVar, m2Var);
    }

    @Override // i0.c
    public /* synthetic */ void M(c.a aVar, String str) {
        i0.b.e(this, aVar, str);
    }

    @Override // i0.c
    public /* synthetic */ void N(c.a aVar, boolean z5) {
        i0.b.Y(this, aVar, z5);
    }

    @Override // i0.c
    public /* synthetic */ void O(c.a aVar, int i6) {
        i0.b.z(this, aVar, i6);
    }

    @Override // i0.c
    public /* synthetic */ void P(c.a aVar, List list) {
        i0.b.n(this, aVar, list);
    }

    @Override // i0.c
    public /* synthetic */ void Q(c.a aVar, l1.r rVar) {
        i0.b.d0(this, aVar, rVar);
    }

    @Override // i0.c
    public void R(c.a aVar, l1.r rVar) {
        if (aVar.f5286d == null) {
            return;
        }
        b bVar = new b((h0.y1) i2.a.e(rVar.f7414c), rVar.f7415d, this.f5373b.e(aVar.f5284b, (v.b) i2.a.e(aVar.f5286d)));
        int i6 = rVar.f7413b;
        if (i6 != 0) {
            if (i6 == 1) {
                this.f5387p = bVar;
                return;
            } else if (i6 != 2) {
                if (i6 != 3) {
                    return;
                }
                this.f5388q = bVar;
                return;
            }
        }
        this.f5386o = bVar;
    }

    @Override // i0.c
    public /* synthetic */ void S(c.a aVar, int i6, int i7) {
        i0.b.a0(this, aVar, i6, i7);
    }

    @Override // i0.c
    public /* synthetic */ void T(c.a aVar, b1.a aVar2) {
        i0.b.L(this, aVar, aVar2);
    }

    @Override // i0.c
    public /* synthetic */ void U(c.a aVar, r4 r4Var) {
        i0.b.c0(this, aVar, r4Var);
    }

    @Override // i0.c
    public /* synthetic */ void V(c.a aVar, boolean z5, int i6) {
        i0.b.M(this, aVar, z5, i6);
    }

    @Override // i0.c
    public /* synthetic */ void W(c.a aVar, int i6) {
        i0.b.O(this, aVar, i6);
    }

    @Override // i0.c
    public /* synthetic */ void X(c.a aVar, Exception exc) {
        i0.b.A(this, aVar, exc);
    }

    @Override // i0.c
    public /* synthetic */ void Y(c.a aVar, boolean z5) {
        i0.b.E(this, aVar, z5);
    }

    @Override // i0.c
    public /* synthetic */ void Z(c.a aVar, Exception exc) {
        i0.b.b(this, aVar, exc);
    }

    @Override // i0.c
    public /* synthetic */ void a(c.a aVar, u1.e eVar) {
        i0.b.o(this, aVar, eVar);
    }

    @Override // i0.c
    public void a0(c.a aVar, l0.g gVar) {
        this.f5395x += gVar.f7155g;
        this.f5396y += gVar.f7153e;
    }

    @Override // i0.c
    public /* synthetic */ void b(c.a aVar, int i6, l0.g gVar) {
        i0.b.q(this, aVar, i6, gVar);
    }

    @Override // i0.c
    public void b0(c.a aVar, int i6, long j6, long j7) {
        v.b bVar = aVar.f5286d;
        if (bVar != null) {
            String e6 = this.f5373b.e(aVar.f5284b, (v.b) i2.a.e(bVar));
            Long l6 = this.f5379h.get(e6);
            Long l7 = this.f5378g.get(e6);
            this.f5379h.put(e6, Long.valueOf((l6 == null ? 0L : l6.longValue()) + j6));
            this.f5378g.put(e6, Long.valueOf((l7 != null ? l7.longValue() : 0L) + i6));
        }
    }

    @Override // i0.c
    public /* synthetic */ void c(c.a aVar, l0.g gVar) {
        i0.b.g(this, aVar, gVar);
    }

    @Override // i0.c
    public /* synthetic */ void c0(c.a aVar, int i6, long j6) {
        i0.b.C(this, aVar, i6, j6);
    }

    @Override // i0.c
    public /* synthetic */ void d(c.a aVar, String str, long j6) {
        i0.b.c(this, aVar, str, j6);
    }

    @Override // i0.c
    public /* synthetic */ void d0(c.a aVar, int i6, int i7, int i8, float f6) {
        i0.b.m0(this, aVar, i6, i7, i8, f6);
    }

    @Override // i0.c
    public /* synthetic */ void e(c.a aVar, h0.h2 h2Var, int i6) {
        i0.b.J(this, aVar, h2Var, i6);
    }

    @Override // i0.c
    public /* synthetic */ void e0(c.a aVar) {
        i0.b.x(this, aVar);
    }

    @Override // i0.c
    public /* synthetic */ void f(c.a aVar, boolean z5) {
        i0.b.D(this, aVar, z5);
    }

    @Override // i0.c
    public /* synthetic */ void f0(c.a aVar, h0.y1 y1Var, l0.k kVar) {
        i0.b.l0(this, aVar, y1Var, kVar);
    }

    @Override // i0.c
    public /* synthetic */ void g(c.a aVar, int i6) {
        i0.b.V(this, aVar, i6);
    }

    @Override // i0.c
    public /* synthetic */ void g0(c.a aVar, l1.o oVar, l1.r rVar) {
        i0.b.H(this, aVar, oVar, rVar);
    }

    @Override // i0.c
    public /* synthetic */ void h(c.a aVar, long j6) {
        i0.b.j(this, aVar, j6);
    }

    @Override // i0.c
    public /* synthetic */ void h0(c.a aVar, l0.g gVar) {
        i0.b.i0(this, aVar, gVar);
    }

    @Override // i0.c
    public /* synthetic */ void i(c.a aVar, boolean z5, int i6) {
        i0.b.S(this, aVar, z5, i6);
    }

    @Override // i0.c
    public /* synthetic */ void i0(c.a aVar) {
        i0.b.w(this, aVar);
    }

    @Override // i0.c
    public /* synthetic */ void j(c.a aVar) {
        i0.b.W(this, aVar);
    }

    @Override // i0.c
    public /* synthetic */ void j0(c.a aVar, j0.e eVar) {
        i0.b.a(this, aVar, eVar);
    }

    @Override // i0.c
    public /* synthetic */ void k(c.a aVar, int i6, h0.y1 y1Var) {
        i0.b.s(this, aVar, i6, y1Var);
    }

    @Override // i0.c
    public /* synthetic */ void k0(c.a aVar, int i6, String str, long j6) {
        i0.b.r(this, aVar, i6, str, j6);
    }

    @Override // i0.c
    public /* synthetic */ void l(c.a aVar, l0.g gVar) {
        i0.b.f(this, aVar, gVar);
    }

    @Override // i0.c
    public /* synthetic */ void l0(c.a aVar, h0.y1 y1Var) {
        i0.b.h(this, aVar, y1Var);
    }

    @Override // i0.c
    public /* synthetic */ void m(c.a aVar, h0.y1 y1Var, l0.k kVar) {
        i0.b.i(this, aVar, y1Var, kVar);
    }

    @Override // i0.n3.a
    public void m0(c.a aVar, String str) {
    }

    @Override // i0.c
    public /* synthetic */ void n(c.a aVar, int i6) {
        i0.b.P(this, aVar, i6);
    }

    @Override // i0.n3.a
    public void n0(c.a aVar, String str, boolean z5) {
        v.b bVar = aVar.f5286d;
        if ((bVar == null || !bVar.b()) && str.equals(this.f5380i)) {
            C0();
        }
        this.f5378g.remove(str);
        this.f5379h.remove(str);
    }

    @Override // i0.c
    public /* synthetic */ void o(c.a aVar, l1.o oVar, l1.r rVar) {
        i0.b.G(this, aVar, oVar, rVar);
    }

    @Override // i0.c
    public /* synthetic */ void o0(c.a aVar, long j6, int i6) {
        i0.b.j0(this, aVar, j6, i6);
    }

    @Override // i0.c
    public void p(c.a aVar, h0.k3 k3Var) {
        this.f5385n = k3Var;
    }

    @Override // i0.c
    public /* synthetic */ void p0(c.a aVar, int i6) {
        i0.b.T(this, aVar, i6);
    }

    @Override // i0.n3.a
    public void q(c.a aVar, String str) {
        PlaybackMetrics.Builder playerName;
        PlaybackMetrics.Builder playerVersion;
        v.b bVar = aVar.f5286d;
        if (bVar == null || !bVar.b()) {
            C0();
            this.f5380i = str;
            playerName = new PlaybackMetrics.Builder().setPlayerName("ExoPlayerLib");
            playerVersion = playerName.setPlayerVersion("2.18.4");
            this.f5381j = playerVersion;
            U0(aVar.f5284b, aVar.f5286d);
        }
    }

    @Override // i0.c
    public /* synthetic */ void q0(c.a aVar, String str, long j6, long j7) {
        i0.b.d(this, aVar, str, j6, j7);
    }

    @Override // i0.c
    public void r(c.a aVar, j2.d0 d0Var) {
        b bVar = this.f5386o;
        if (bVar != null) {
            h0.y1 y1Var = bVar.f5400a;
            if (y1Var.f5072v == -1) {
                this.f5386o = new b(y1Var.b().n0(d0Var.f6695a).S(d0Var.f6696b).G(), bVar.f5401b, bVar.f5402c);
            }
        }
    }

    @Override // i0.c
    public /* synthetic */ void r0(c.a aVar, int i6, boolean z5) {
        i0.b.u(this, aVar, i6, z5);
    }

    @Override // i0.c
    public /* synthetic */ void s(c.a aVar, Object obj, long j6) {
        i0.b.U(this, aVar, obj, j6);
    }

    @Override // i0.c
    public /* synthetic */ void s0(c.a aVar, Exception exc) {
        i0.b.e0(this, aVar, exc);
    }

    @Override // i0.c
    public /* synthetic */ void t(c.a aVar, int i6, long j6, long j7) {
        i0.b.l(this, aVar, i6, j6, j7);
    }

    @Override // i0.c
    public /* synthetic */ void t0(c.a aVar, h0.k3 k3Var) {
        i0.b.Q(this, aVar, k3Var);
    }

    @Override // i0.c
    public /* synthetic */ void u(c.a aVar) {
        i0.b.v(this, aVar);
    }

    @Override // i0.c
    public /* synthetic */ void u0(c.a aVar, h0.y1 y1Var) {
        i0.b.k0(this, aVar, y1Var);
    }

    @Override // i0.c
    public /* synthetic */ void v(c.a aVar, int i6) {
        i0.b.b0(this, aVar, i6);
    }

    @Override // i0.c
    public /* synthetic */ void v0(c.a aVar, boolean z5) {
        i0.b.I(this, aVar, z5);
    }

    @Override // i0.c
    public /* synthetic */ void w(c.a aVar, int i6, l0.g gVar) {
        i0.b.p(this, aVar, i6, gVar);
    }

    @Override // i0.n3.a
    public void w0(c.a aVar, String str, String str2) {
    }

    @Override // i0.c
    public void x(c.a aVar, l1.o oVar, l1.r rVar, IOException iOException, boolean z5) {
        this.f5393v = rVar.f7412a;
    }

    @Override // i0.c
    public void x0(h0.o3 o3Var, c.b bVar) {
        if (bVar.d() == 0) {
            return;
        }
        M0(bVar);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        S0(o3Var, bVar);
        O0(elapsedRealtime);
        Q0(o3Var, bVar, elapsedRealtime);
        N0(elapsedRealtime);
        P0(o3Var, bVar, elapsedRealtime);
        if (bVar.a(1028)) {
            this.f5373b.c(bVar.c(1028));
        }
    }

    @Override // i0.c
    public /* synthetic */ void y(c.a aVar) {
        i0.b.X(this, aVar);
    }

    @Override // i0.c
    public /* synthetic */ void y0(c.a aVar, h0.n3 n3Var) {
        i0.b.N(this, aVar, n3Var);
    }

    @Override // i0.c
    public /* synthetic */ void z(c.a aVar, String str) {
        i0.b.h0(this, aVar, str);
    }

    @Override // i0.c
    public /* synthetic */ void z0(c.a aVar, l1.o oVar, l1.r rVar) {
        i0.b.F(this, aVar, oVar, rVar);
    }
}
