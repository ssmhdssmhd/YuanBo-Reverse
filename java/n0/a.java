package n0;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import androidx.window.embedding.EmbeddingCompat;
import h0.h2;
import h0.k3;
import h0.m2;
import h0.m4;
import h0.n3;
import h0.o3;
import h0.q3;
import h0.r4;
import h0.v;
import h0.v1;
import i2.c1;
import j2.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: q, reason: collision with root package name */
    private static final MediaMetadataCompat f8150q;

    /* renamed from: a, reason: collision with root package name */
    public final MediaSessionCompat f8151a;

    /* renamed from: b, reason: collision with root package name */
    private final Looper f8152b;

    /* renamed from: c, reason: collision with root package name */
    private final d f8153c;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<c> f8154d;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<c> f8155e;

    /* renamed from: f, reason: collision with root package name */
    private e[] f8156f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, e> f8157g;

    /* renamed from: h, reason: collision with root package name */
    private h f8158h;

    /* renamed from: i, reason: collision with root package name */
    private o3 f8159i;

    /* renamed from: j, reason: collision with root package name */
    private Pair<Integer, CharSequence> f8160j;

    /* renamed from: k, reason: collision with root package name */
    private Bundle f8161k;

    /* renamed from: l, reason: collision with root package name */
    private long f8162l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f8163m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f8164n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f8165o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f8166p;

    public interface b extends c {
    }

    public interface c {
        boolean a(o3 o3Var, String str, Bundle bundle, ResultReceiver resultReceiver);
    }

    private class d extends MediaSessionCompat.b implements o3.d {

        /* renamed from: f, reason: collision with root package name */
        private int f8167f;

        /* renamed from: g, reason: collision with root package name */
        private int f8168g;

        private d() {
        }

        @Override // h0.o3.d
        public /* synthetic */ void A(int i6) {
            q3.q(this, i6);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void A0(int i6) {
            if (a.this.x(262144L)) {
                int i7 = 1;
                if (i6 != 1) {
                    i7 = 2;
                    if (i6 != 2 && i6 != 3) {
                        i7 = 0;
                    }
                }
                a.this.f8159i.g(i7);
            }
        }

        @Override // h0.o3.d
        public /* synthetic */ void B(boolean z5, int i6) {
            q3.t(this, z5, i6);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void B0(int i6) {
            if (a.this.x(2097152L)) {
                boolean z5 = true;
                if (i6 != 1 && i6 != 2) {
                    z5 = false;
                }
                a.this.f8159i.C(z5);
            }
        }

        @Override // h0.o3.d
        public /* synthetic */ void C(boolean z5) {
            q3.j(this, z5);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void C0() {
            if (a.this.C(32L)) {
                a.l(a.this);
                o3 unused = a.this.f8159i;
                throw null;
            }
        }

        @Override // h0.o3.d
        public /* synthetic */ void D(int i6) {
            q3.u(this, i6);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void D0() {
            if (a.this.C(16L)) {
                a.l(a.this);
                o3 unused = a.this.f8159i;
                throw null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void E0(long j6) {
            if (a.this.C(4096L)) {
                a.l(a.this);
                o3 unused = a.this.f8159i;
                throw null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void F0() {
            if (a.this.x(1L)) {
                a.this.f8159i.b();
                if (a.this.f8165o) {
                    a.this.f8159i.A();
                }
            }
        }

        @Override // h0.o3.d
        public /* synthetic */ void G(k3 k3Var) {
            q3.s(this, k3Var);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void H(MediaDescriptionCompat mediaDescriptionCompat) {
            if (a.this.y()) {
                a.h(a.this);
                o3 unused = a.this.f8159i;
                throw null;
            }
        }

        @Override // h0.o3.d
        public /* synthetic */ void I(boolean z5) {
            q3.h(this, z5);
        }

        @Override // h0.o3.d
        public /* synthetic */ void J(o3.e eVar, o3.e eVar2, int i6) {
            q3.v(this, eVar, eVar2, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void K(m4 m4Var, int i6) {
            q3.C(this, m4Var, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void L() {
            q3.w(this);
        }

        @Override // h0.o3.d
        public /* synthetic */ void M() {
            q3.y(this);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void N(MediaDescriptionCompat mediaDescriptionCompat, int i6) {
            if (a.this.y()) {
                a.h(a.this);
                o3 unused = a.this.f8159i;
                throw null;
            }
        }

        @Override // h0.o3.d
        public /* synthetic */ void O(v vVar) {
            q3.e(this, vVar);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void P(String str, Bundle bundle, ResultReceiver resultReceiver) {
            if (a.this.f8159i != null) {
                for (int i6 = 0; i6 < a.this.f8154d.size(); i6++) {
                    if (((c) a.this.f8154d.get(i6)).a(a.this.f8159i, str, bundle, resultReceiver)) {
                        return;
                    }
                }
                for (int i7 = 0; i7 < a.this.f8155e.size() && !((c) a.this.f8155e.get(i7)).a(a.this.f8159i, str, bundle, resultReceiver); i7++) {
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void Q(String str, Bundle bundle) {
            if (a.this.f8159i == null || !a.this.f8157g.containsKey(str)) {
                return;
            }
            ((e) a.this.f8157g.get(str)).a(a.this.f8159i, str, bundle);
            a.this.F();
        }

        @Override // h0.o3.d
        public /* synthetic */ void R(h2 h2Var, int i6) {
            q3.k(this, h2Var, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void S(float f6) {
            q3.F(this, f6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void T(k3 k3Var) {
            q3.r(this, k3Var);
        }

        @Override // h0.o3.d
        public /* synthetic */ void U(int i6) {
            q3.p(this, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void V(boolean z5, int i6) {
            q3.n(this, z5, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void W(j0.e eVar) {
            q3.a(this, eVar);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void X() {
            if (a.this.x(64L)) {
                a.this.f8159i.Z();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public boolean Y(Intent intent) {
            if (!a.this.w()) {
                return super.Y(intent);
            }
            a.m(a.this);
            o3 unused = a.this.f8159i;
            throw null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void Z() {
            if (a.this.x(2L)) {
                a.this.f8159i.d();
            }
        }

        @Override // h0.o3.d
        public /* synthetic */ void b(boolean z5) {
            q3.A(this, z5);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void b0() {
            if (a.this.x(4L)) {
                if (a.this.f8159i.c() == 1) {
                    a.p(a.this);
                    a.this.f8159i.e();
                } else if (a.this.f8159i.c() == 4) {
                    a aVar = a.this;
                    aVar.H(aVar.f8159i, a.this.f8159i.L(), -9223372036854775807L);
                }
                ((o3) i2.a.e(a.this.f8159i)).f();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void c0(String str, Bundle bundle) {
            if (a.this.B(1024L)) {
                a.p(a.this);
                throw null;
            }
        }

        @Override // h0.o3.d
        public /* synthetic */ void e0(boolean z5) {
            q3.z(this, z5);
        }

        @Override // h0.o3.d
        public /* synthetic */ void f0(o3.b bVar) {
            q3.b(this, bVar);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void g0(String str, Bundle bundle) {
            if (a.this.B(2048L)) {
                a.p(a.this);
                throw null;
            }
        }

        @Override // h0.o3.d
        public /* synthetic */ void h(n3 n3Var) {
            q3.o(this, n3Var);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void h0(Uri uri, Bundle bundle) {
            if (a.this.B(8192L)) {
                a.p(a.this);
                throw null;
            }
        }

        @Override // h0.o3.d
        public /* synthetic */ void i(int i6) {
            q3.x(this, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void i0(int i6, int i7) {
            q3.B(this, i6, i7);
        }

        @Override // h0.o3.d
        public /* synthetic */ void j(b1.a aVar) {
            q3.m(this, aVar);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void j0() {
            if (a.this.B(16384L)) {
                a.p(a.this);
                throw null;
            }
        }

        @Override // h0.o3.d
        public /* synthetic */ void k0(m2 m2Var) {
            q3.l(this, m2Var);
        }

        @Override // h0.o3.d
        public /* synthetic */ void l(u1.e eVar) {
            q3.d(this, eVar);
        }

        @Override // h0.o3.d
        public /* synthetic */ void m(List list) {
            q3.c(this, list);
        }

        @Override // h0.o3.d
        public /* synthetic */ void m0(r4 r4Var) {
            q3.D(this, r4Var);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void n0(String str, Bundle bundle) {
            if (a.this.B(32768L)) {
                a.p(a.this);
                throw null;
            }
        }

        @Override // h0.o3.d
        public void o0(o3 o3Var, o3.c cVar) {
            boolean z5;
            boolean z6;
            boolean z7 = true;
            if (cVar.a(11)) {
                if (this.f8167f != o3Var.L()) {
                    a.l(a.this);
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = true;
            } else {
                z5 = false;
                z6 = false;
            }
            if (cVar.a(0)) {
                int t5 = o3Var.T().t();
                int L = o3Var.L();
                a.l(a.this);
                if (this.f8168g != t5 || this.f8167f != L) {
                    z6 = true;
                }
                this.f8168g = t5;
                z5 = true;
            }
            this.f8167f = o3Var.L();
            if (cVar.b(4, 5, 7, 8, 12)) {
                z6 = true;
            }
            if (cVar.b(9)) {
                a.this.G();
            } else {
                z7 = z6;
            }
            if (z7) {
                a.this.F();
            }
            if (z5) {
                a.this.E();
            }
        }

        @Override // h0.o3.d
        public /* synthetic */ void p(d0 d0Var) {
            q3.E(this, d0Var);
        }

        @Override // h0.o3.d
        public /* synthetic */ void p0(int i6, boolean z5) {
            q3.f(this, i6, z5);
        }

        @Override // h0.o3.d
        public /* synthetic */ void q0(boolean z5) {
            q3.i(this, z5);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void r0(String str, Bundle bundle) {
            if (a.this.B(65536L)) {
                a.p(a.this);
                throw null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void s0(Uri uri, Bundle bundle) {
            if (a.this.B(131072L)) {
                a.p(a.this);
                throw null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void t0(MediaDescriptionCompat mediaDescriptionCompat) {
            if (a.this.y()) {
                a.h(a.this);
                o3 unused = a.this.f8159i;
                throw null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void u0() {
            if (a.this.x(8L)) {
                a.this.f8159i.a0();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void v0(long j6) {
            if (a.this.x(256L)) {
                a aVar = a.this;
                aVar.H(aVar.f8159i, a.this.f8159i.L(), j6);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void w0(boolean z5) {
            if (a.this.z()) {
                a.j(a.this);
                o3 unused = a.this.f8159i;
                throw null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void x0(float f6) {
            if (!a.this.x(4194304L) || f6 <= 0.0f) {
                return;
            }
            a.this.f8159i.i(a.this.f8159i.h().d(f6));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void y0(RatingCompat ratingCompat) {
            if (a.this.A()) {
                a.f(a.this);
                o3 unused = a.this.f8159i;
                throw null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.b
        public void z0(RatingCompat ratingCompat, Bundle bundle) {
            if (a.this.A()) {
                a.f(a.this);
                o3 unused = a.this.f8159i;
                throw null;
            }
        }
    }

    public interface e {
        void a(o3 o3Var, String str, Bundle bundle);

        PlaybackStateCompat.CustomAction b(o3 o3Var);
    }

    public static final class f implements h {

        /* renamed from: a, reason: collision with root package name */
        private final MediaControllerCompat f8170a;

        /* renamed from: b, reason: collision with root package name */
        private final String f8171b;

        public f(MediaControllerCompat mediaControllerCompat, String str) {
            this.f8170a = mediaControllerCompat;
            this.f8171b = str == null ? "" : str;
        }

        @Override // n0.a.h
        public MediaMetadataCompat a(o3 o3Var) {
            String str;
            long longValue;
            if (o3Var.T().u()) {
                return a.f8150q;
            }
            MediaMetadataCompat.b bVar = new MediaMetadataCompat.b();
            if (o3Var.q()) {
                bVar.c("android.media.metadata.ADVERTISEMENT", 1L);
            }
            bVar.c("android.media.metadata.DURATION", (o3Var.R() || o3Var.getDuration() == -9223372036854775807L) ? -1L : o3Var.getDuration());
            long f6 = this.f8170a.b().f();
            if (f6 != -1) {
                List<MediaSessionCompat.QueueItem> c6 = this.f8170a.c();
                int i6 = 0;
                while (true) {
                    if (c6 == null || i6 >= c6.size()) {
                        break;
                    }
                    MediaSessionCompat.QueueItem queueItem = c6.get(i6);
                    if (queueItem.g() == f6) {
                        MediaDescriptionCompat f7 = queueItem.f();
                        Bundle f8 = f7.f();
                        if (f8 != null) {
                            for (String str2 : f8.keySet()) {
                                Object obj = f8.get(str2);
                                if (obj instanceof String) {
                                    bVar.e(this.f8171b + str2, (String) obj);
                                } else if (obj instanceof CharSequence) {
                                    bVar.f(this.f8171b + str2, (CharSequence) obj);
                                } else {
                                    if (obj instanceof Long) {
                                        str = this.f8171b + str2;
                                        longValue = ((Long) obj).longValue();
                                    } else if (obj instanceof Integer) {
                                        str = this.f8171b + str2;
                                        longValue = ((Integer) obj).intValue();
                                    } else if (obj instanceof Bitmap) {
                                        bVar.b(this.f8171b + str2, (Bitmap) obj);
                                    } else if (obj instanceof RatingCompat) {
                                        bVar.d(this.f8171b + str2, (RatingCompat) obj);
                                    }
                                    bVar.c(str, longValue);
                                }
                            }
                        }
                        CharSequence m6 = f7.m();
                        if (m6 != null) {
                            String valueOf = String.valueOf(m6);
                            bVar.e("android.media.metadata.TITLE", valueOf);
                            bVar.e("android.media.metadata.DISPLAY_TITLE", valueOf);
                        }
                        CharSequence l6 = f7.l();
                        if (l6 != null) {
                            bVar.e("android.media.metadata.DISPLAY_SUBTITLE", String.valueOf(l6));
                        }
                        CharSequence e6 = f7.e();
                        if (e6 != null) {
                            bVar.e("android.media.metadata.DISPLAY_DESCRIPTION", String.valueOf(e6));
                        }
                        Bitmap g6 = f7.g();
                        if (g6 != null) {
                            bVar.b("android.media.metadata.DISPLAY_ICON", g6);
                        }
                        Uri h6 = f7.h();
                        if (h6 != null) {
                            bVar.e("android.media.metadata.DISPLAY_ICON_URI", String.valueOf(h6));
                        }
                        String j6 = f7.j();
                        if (j6 != null) {
                            bVar.e("android.media.metadata.MEDIA_ID", j6);
                        }
                        Uri k6 = f7.k();
                        if (k6 != null) {
                            bVar.e("android.media.metadata.MEDIA_URI", String.valueOf(k6));
                        }
                    } else {
                        i6++;
                    }
                }
            }
            return bVar.a();
        }

        @Override // n0.a.h
        public /* synthetic */ boolean b(MediaMetadataCompat mediaMetadataCompat, MediaMetadataCompat mediaMetadataCompat2) {
            return n0.b.a(this, mediaMetadataCompat, mediaMetadataCompat2);
        }
    }

    public interface g {
    }

    public interface h {
        MediaMetadataCompat a(o3 o3Var);

        boolean b(MediaMetadataCompat mediaMetadataCompat, MediaMetadataCompat mediaMetadataCompat2);
    }

    public interface i extends c {
    }

    public interface j extends c {
    }

    public interface k extends c {
    }

    public interface l extends c {
    }

    static {
        v1.a("goog.exo.mediasession");
        f8150q = new MediaMetadataCompat.b().a();
    }

    public a(MediaSessionCompat mediaSessionCompat) {
        this.f8151a = mediaSessionCompat;
        Looper Q = c1.Q();
        this.f8152b = Q;
        d dVar = new d();
        this.f8153c = dVar;
        this.f8154d = new ArrayList<>();
        this.f8155e = new ArrayList<>();
        this.f8156f = new e[0];
        this.f8157g = Collections.emptyMap();
        this.f8158h = new f(mediaSessionCompat.b(), null);
        this.f8162l = 2360143L;
        mediaSessionCompat.i(3);
        mediaSessionCompat.h(dVar, new Handler(Q));
        this.f8165o = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EnsuresNonNullIf(expression = {"player", "ratingCallback"}, result = EmbeddingCompat.DEBUG)
    public boolean A() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EnsuresNonNullIf(expression = {"playbackPreparer"}, result = EmbeddingCompat.DEBUG)
    public boolean B(long j6) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EnsuresNonNullIf(expression = {"player", "queueNavigator"}, result = EmbeddingCompat.DEBUG)
    public boolean C(long j6) {
        return false;
    }

    private int D(int i6, boolean z5) {
        if (i6 == 2) {
            return z5 ? 6 : 2;
        }
        if (i6 == 3) {
            return z5 ? 3 : 2;
        }
        if (i6 != 4) {
            return this.f8166p ? 1 : 0;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(o3 o3Var, int i6, long j6) {
        o3Var.v(i6, j6);
    }

    static /* synthetic */ l f(a aVar) {
        aVar.getClass();
        return null;
    }

    static /* synthetic */ j h(a aVar) {
        aVar.getClass();
        return null;
    }

    static /* synthetic */ b j(a aVar) {
        aVar.getClass();
        return null;
    }

    static /* synthetic */ k l(a aVar) {
        aVar.getClass();
        return null;
    }

    static /* synthetic */ g m(a aVar) {
        aVar.getClass();
        return null;
    }

    static /* synthetic */ i p(a aVar) {
        aVar.getClass();
        return null;
    }

    private long u(o3 o3Var) {
        boolean M = o3Var.M(5);
        boolean M2 = o3Var.M(11);
        boolean M3 = o3Var.M(12);
        if (!o3Var.T().u()) {
            o3Var.q();
        }
        long j6 = M ? 6554375L : 6554119L;
        if (M3) {
            j6 |= 64;
        }
        if (M2) {
            j6 |= 8;
        }
        return this.f8162l & j6;
    }

    private long v() {
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EnsuresNonNullIf(expression = {"player", "mediaButtonEventHandler"}, result = EmbeddingCompat.DEBUG)
    public boolean w() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EnsuresNonNullIf(expression = {"player"}, result = EmbeddingCompat.DEBUG)
    public boolean x(long j6) {
        return this.f8159i != null && ((j6 & this.f8162l) != 0 || this.f8164n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EnsuresNonNullIf(expression = {"player", "queueEditor"}, result = EmbeddingCompat.DEBUG)
    public boolean y() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EnsuresNonNullIf(expression = {"player", "captionCallback"}, result = EmbeddingCompat.DEBUG)
    public boolean z() {
        return false;
    }

    public final void E() {
        MediaMetadataCompat a6;
        o3 o3Var;
        h hVar = this.f8158h;
        MediaMetadataCompat a7 = (hVar == null || (o3Var = this.f8159i) == null) ? f8150q : hVar.a(o3Var);
        h hVar2 = this.f8158h;
        if (!this.f8163m || hVar2 == null || (a6 = this.f8151a.b().a()) == null || !hVar2.b(a6, a7)) {
            this.f8151a.j(a7);
        }
    }

    public final void F() {
        PlaybackStateCompat.d dVar = new PlaybackStateCompat.d();
        o3 o3Var = this.f8159i;
        int i6 = 0;
        if (o3Var == null) {
            dVar.c(v()).i(0, 0L, 0.0f, SystemClock.elapsedRealtime());
            this.f8151a.l(0);
            this.f8151a.m(0);
        } else {
            HashMap hashMap = new HashMap();
            for (e eVar : this.f8156f) {
                PlaybackStateCompat.CustomAction b6 = eVar.b(o3Var);
                if (b6 != null) {
                    hashMap.put(b6.e(), eVar);
                    dVar.a(b6);
                }
            }
            this.f8157g = Collections.unmodifiableMap(hashMap);
            Bundle bundle = new Bundle();
            int D = o3Var.n() != null || this.f8160j != null ? 7 : D(o3Var.c(), o3Var.y());
            Pair<Integer, CharSequence> pair = this.f8160j;
            if (pair != null) {
                dVar.f(((Integer) pair.first).intValue(), (CharSequence) this.f8160j.second);
                Bundle bundle2 = this.f8161k;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
            }
            float f6 = o3Var.h().f4732a;
            bundle.putFloat("EXO_SPEED", f6);
            float f7 = o3Var.I() ? f6 : 0.0f;
            h2 B = o3Var.B();
            if (B != null && !"".equals(B.f4405a)) {
                bundle.putString("androidx.media.PlaybackStateCompat.Extras.KEY_MEDIA_ID", B.f4405a);
            }
            dVar.c(v() | u(o3Var)).d(-1L).e(o3Var.x()).i(D, o3Var.e0(), f7, SystemClock.elapsedRealtime()).g(bundle);
            int k6 = o3Var.k();
            MediaSessionCompat mediaSessionCompat = this.f8151a;
            if (k6 == 1) {
                i6 = 1;
            } else if (k6 == 2) {
                i6 = 2;
            }
            mediaSessionCompat.l(i6);
            this.f8151a.m(o3Var.V() ? 1 : 0);
        }
        this.f8151a.k(dVar.b());
    }

    public final void G() {
    }

    public void I(o3 o3Var) {
        i2.a.a(o3Var == null || o3Var.U() == this.f8152b);
        o3 o3Var2 = this.f8159i;
        if (o3Var2 != null) {
            o3Var2.W(this.f8153c);
        }
        this.f8159i = o3Var;
        if (o3Var != null) {
            o3Var.N(this.f8153c);
        }
        F();
        E();
    }
}
