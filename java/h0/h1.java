package h0;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import h0.b;
import h0.f3;
import h0.h1;
import h0.h4;
import h0.j;
import h0.m4;
import h0.o3;
import h0.s3;
import h0.u1;
import h0.y;
import i2.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import k2.l;
import l1.q0;
import l1.v;

/* loaded from: classes.dex */
final class h1 extends k implements y, y.a {
    private final j A;
    private final h4 B;
    private final s4 C;
    private final t4 D;
    private final long E;
    private int F;
    private boolean G;
    private int H;
    private int I;
    private boolean J;
    private int K;
    private c4 L;
    private l1.q0 M;
    private boolean N;
    private o3.b O;
    private m2 P;
    private m2 Q;
    private y1 R;
    private y1 S;
    private AudioTrack T;
    private Object U;
    private Surface V;
    private SurfaceHolder W;
    private k2.l X;
    private boolean Y;
    private TextureView Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f4344a0;

    /* renamed from: b, reason: collision with root package name */
    final e2.c0 f4345b;

    /* renamed from: b0, reason: collision with root package name */
    private int f4346b0;

    /* renamed from: c, reason: collision with root package name */
    final o3.b f4347c;

    /* renamed from: c0, reason: collision with root package name */
    private i2.l0 f4348c0;

    /* renamed from: d, reason: collision with root package name */
    private final i2.h f4349d;

    /* renamed from: d0, reason: collision with root package name */
    private l0.g f4350d0;

    /* renamed from: e, reason: collision with root package name */
    private final Context f4351e;

    /* renamed from: e0, reason: collision with root package name */
    private l0.g f4352e0;

    /* renamed from: f, reason: collision with root package name */
    private final o3 f4353f;

    /* renamed from: f0, reason: collision with root package name */
    private int f4354f0;

    /* renamed from: g, reason: collision with root package name */
    private final x3[] f4355g;

    /* renamed from: g0, reason: collision with root package name */
    private j0.e f4356g0;

    /* renamed from: h, reason: collision with root package name */
    private final e2.b0 f4357h;

    /* renamed from: h0, reason: collision with root package name */
    private float f4358h0;

    /* renamed from: i, reason: collision with root package name */
    private final i2.p f4359i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f4360i0;

    /* renamed from: j, reason: collision with root package name */
    private final u1.f f4361j;

    /* renamed from: j0, reason: collision with root package name */
    private u1.e f4362j0;

    /* renamed from: k, reason: collision with root package name */
    private final u1 f4363k;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f4364k0;

    /* renamed from: l, reason: collision with root package name */
    private final i2.s<o3.d> f4365l;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f4366l0;

    /* renamed from: m, reason: collision with root package name */
    private final CopyOnWriteArraySet<y.b> f4367m;

    /* renamed from: m0, reason: collision with root package name */
    private i2.k0 f4368m0;

    /* renamed from: n, reason: collision with root package name */
    private final m4.b f4369n;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f4370n0;

    /* renamed from: o, reason: collision with root package name */
    private final List<e> f4371o;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f4372o0;

    /* renamed from: p, reason: collision with root package name */
    private final boolean f4373p;

    /* renamed from: p0, reason: collision with root package name */
    private v f4374p0;

    /* renamed from: q, reason: collision with root package name */
    private final v.a f4375q;

    /* renamed from: q0, reason: collision with root package name */
    private j2.d0 f4376q0;

    /* renamed from: r, reason: collision with root package name */
    private final i0.a f4377r;

    /* renamed from: r0, reason: collision with root package name */
    private m2 f4378r0;

    /* renamed from: s, reason: collision with root package name */
    private final Looper f4379s;

    /* renamed from: s0, reason: collision with root package name */
    private l3 f4380s0;

    /* renamed from: t, reason: collision with root package name */
    private final g2.f f4381t;

    /* renamed from: t0, reason: collision with root package name */
    private int f4382t0;

    /* renamed from: u, reason: collision with root package name */
    private final long f4383u;

    /* renamed from: u0, reason: collision with root package name */
    private int f4384u0;

    /* renamed from: v, reason: collision with root package name */
    private final long f4385v;

    /* renamed from: v0, reason: collision with root package name */
    private long f4386v0;

    /* renamed from: w, reason: collision with root package name */
    private final i2.e f4387w;

    /* renamed from: x, reason: collision with root package name */
    private final c f4388x;

    /* renamed from: y, reason: collision with root package name */
    private final d f4389y;

    /* renamed from: z, reason: collision with root package name */
    private final h0.b f4390z;

    private static final class b {
        public static i0.o3 a(Context context, h1 h1Var, boolean z5) {
            LogSessionId logSessionId;
            i0.m3 B0 = i0.m3.B0(context);
            if (B0 == null) {
                i2.t.i("ExoPlayerImpl", "MediaMetricsService unavailable.");
                logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
                return new i0.o3(logSessionId);
            }
            if (z5) {
                h1Var.s1(B0);
            }
            return new i0.o3(B0.I0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class c implements j2.b0, j0.v, u1.n, b1.f, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, l.b, j.b, b.InterfaceC0081b, h4.b, y.b {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void S(o3.d dVar) {
            dVar.k0(h1.this.P);
        }

        @Override // k2.l.b
        public void A(Surface surface) {
            h1.this.y2(surface);
        }

        @Override // h0.h4.b
        public void B(final int i6, final boolean z5) {
            h1.this.f4365l.l(30, new s.a() { // from class: h0.n1
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    ((o3.d) obj).p0(i6, z5);
                }
            });
        }

        @Override // j0.v
        public /* synthetic */ void C(y1 y1Var) {
            j0.k.a(this, y1Var);
        }

        @Override // h0.h4.b
        public void D(int i6) {
            final v w12 = h1.w1(h1.this.B);
            if (w12.equals(h1.this.f4374p0)) {
                return;
            }
            h1.this.f4374p0 = w12;
            h1.this.f4365l.l(29, new s.a() { // from class: h0.m1
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    ((o3.d) obj).O(v.this);
                }
            });
        }

        @Override // h0.y.b
        public /* synthetic */ void E(boolean z5) {
            z.a(this, z5);
        }

        @Override // h0.b.InterfaceC0081b
        public void F() {
            h1.this.B2(false, -1, 3);
        }

        @Override // h0.y.b
        public void G(boolean z5) {
            h1.this.E2();
        }

        @Override // h0.j.b
        public void H(float f6) {
            h1.this.t2();
        }

        @Override // h0.j.b
        public void a(int i6) {
            boolean y5 = h1.this.y();
            h1.this.B2(y5, i6, h1.F1(y5, i6));
        }

        @Override // j0.v
        public void b(final boolean z5) {
            if (h1.this.f4360i0 == z5) {
                return;
            }
            h1.this.f4360i0 = z5;
            h1.this.f4365l.l(23, new s.a() { // from class: h0.r1
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    ((o3.d) obj).b(z5);
                }
            });
        }

        @Override // j0.v
        public void c(Exception exc) {
            h1.this.f4377r.c(exc);
        }

        @Override // j0.v
        public void d(l0.g gVar) {
            h1.this.f4377r.d(gVar);
            h1.this.S = null;
            h1.this.f4352e0 = null;
        }

        @Override // j2.b0
        public void e(String str) {
            h1.this.f4377r.e(str);
        }

        @Override // j2.b0
        public void f(Object obj, long j6) {
            h1.this.f4377r.f(obj, j6);
            if (h1.this.U == obj) {
                h1.this.f4365l.l(26, new s.a() { // from class: h0.p1
                    @Override // i2.s.a
                    public final void invoke(Object obj2) {
                        ((o3.d) obj2).L();
                    }
                });
            }
        }

        @Override // j2.b0
        public void g(String str, long j6, long j7) {
            h1.this.f4377r.g(str, j6, j7);
        }

        @Override // j2.b0
        public /* synthetic */ void h(y1 y1Var) {
            j2.q.a(this, y1Var);
        }

        @Override // k2.l.b
        public void i(Surface surface) {
            h1.this.y2(null);
        }

        @Override // b1.f
        public void j(final b1.a aVar) {
            h1 h1Var = h1.this;
            h1Var.f4378r0 = h1Var.f4378r0.b().K(aVar).H();
            m2 v12 = h1.this.v1();
            if (!v12.equals(h1.this.P)) {
                h1.this.P = v12;
                h1.this.f4365l.i(14, new s.a() { // from class: h0.j1
                    @Override // i2.s.a
                    public final void invoke(Object obj) {
                        h1.c.this.S((o3.d) obj);
                    }
                });
            }
            h1.this.f4365l.i(28, new s.a() { // from class: h0.k1
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    ((o3.d) obj).j(b1.a.this);
                }
            });
            h1.this.f4365l.f();
        }

        @Override // j2.b0
        public void k(l0.g gVar) {
            h1.this.f4377r.k(gVar);
            h1.this.R = null;
            h1.this.f4350d0 = null;
        }

        @Override // u1.n
        public void l(final u1.e eVar) {
            h1.this.f4362j0 = eVar;
            h1.this.f4365l.l(27, new s.a() { // from class: h0.o1
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    ((o3.d) obj).l(u1.e.this);
                }
            });
        }

        @Override // u1.n
        public void m(final List<u1.b> list) {
            h1.this.f4365l.l(27, new s.a() { // from class: h0.l1
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    ((o3.d) obj).m(list);
                }
            });
        }

        @Override // j0.v
        public void n(long j6) {
            h1.this.f4377r.n(j6);
        }

        @Override // j0.v
        public void o(Exception exc) {
            h1.this.f4377r.o(exc);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i6, int i7) {
            h1.this.x2(surfaceTexture);
            h1.this.n2(i6, i7);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            h1.this.y2(null);
            h1.this.n2(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i6, int i7) {
            h1.this.n2(i6, i7);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // j2.b0
        public void p(final j2.d0 d0Var) {
            h1.this.f4376q0 = d0Var;
            h1.this.f4365l.l(25, new s.a() { // from class: h0.q1
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    ((o3.d) obj).p(j2.d0.this);
                }
            });
        }

        @Override // j2.b0
        public void q(Exception exc) {
            h1.this.f4377r.q(exc);
        }

        @Override // j0.v
        public void r(String str) {
            h1.this.f4377r.r(str);
        }

        @Override // j0.v
        public void s(String str, long j6, long j7) {
            h1.this.f4377r.s(str, j6, j7);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i6, int i7, int i8) {
            h1.this.n2(i7, i8);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (h1.this.Y) {
                h1.this.y2(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (h1.this.Y) {
                h1.this.y2(null);
            }
            h1.this.n2(0, 0);
        }

        @Override // j2.b0
        public void t(l0.g gVar) {
            h1.this.f4350d0 = gVar;
            h1.this.f4377r.t(gVar);
        }

        @Override // j0.v
        public void u(y1 y1Var, l0.k kVar) {
            h1.this.S = y1Var;
            h1.this.f4377r.u(y1Var, kVar);
        }

        @Override // j0.v
        public void v(int i6, long j6, long j7) {
            h1.this.f4377r.v(i6, j6, j7);
        }

        @Override // j2.b0
        public void w(int i6, long j6) {
            h1.this.f4377r.w(i6, j6);
        }

        @Override // j0.v
        public void x(l0.g gVar) {
            h1.this.f4352e0 = gVar;
            h1.this.f4377r.x(gVar);
        }

        @Override // j2.b0
        public void y(long j6, int i6) {
            h1.this.f4377r.y(j6, i6);
        }

        @Override // j2.b0
        public void z(y1 y1Var, l0.k kVar) {
            h1.this.R = y1Var;
            h1.this.f4377r.z(y1Var, kVar);
        }
    }

    private static final class d implements j2.m, k2.a, s3.b {

        /* renamed from: a, reason: collision with root package name */
        private j2.m f4392a;

        /* renamed from: b, reason: collision with root package name */
        private k2.a f4393b;

        /* renamed from: c, reason: collision with root package name */
        private j2.m f4394c;

        /* renamed from: d, reason: collision with root package name */
        private k2.a f4395d;

        private d() {
        }

        @Override // k2.a
        public void a(long j6, float[] fArr) {
            k2.a aVar = this.f4395d;
            if (aVar != null) {
                aVar.a(j6, fArr);
            }
            k2.a aVar2 = this.f4393b;
            if (aVar2 != null) {
                aVar2.a(j6, fArr);
            }
        }

        @Override // j2.m
        public void h(long j6, long j7, y1 y1Var, MediaFormat mediaFormat) {
            j2.m mVar = this.f4394c;
            if (mVar != null) {
                mVar.h(j6, j7, y1Var, mediaFormat);
            }
            j2.m mVar2 = this.f4392a;
            if (mVar2 != null) {
                mVar2.h(j6, j7, y1Var, mediaFormat);
            }
        }

        @Override // k2.a
        public void i() {
            k2.a aVar = this.f4395d;
            if (aVar != null) {
                aVar.i();
            }
            k2.a aVar2 = this.f4393b;
            if (aVar2 != null) {
                aVar2.i();
            }
        }

        @Override // h0.s3.b
        public void m(int i6, Object obj) {
            k2.a cameraMotionListener;
            if (i6 == 7) {
                this.f4392a = (j2.m) obj;
                return;
            }
            if (i6 == 8) {
                this.f4393b = (k2.a) obj;
                return;
            }
            if (i6 != 10000) {
                return;
            }
            k2.l lVar = (k2.l) obj;
            if (lVar == null) {
                cameraMotionListener = null;
                this.f4394c = null;
            } else {
                this.f4394c = lVar.getVideoFrameMetadataListener();
                cameraMotionListener = lVar.getCameraMotionListener();
            }
            this.f4395d = cameraMotionListener;
        }
    }

    private static final class e implements r2 {

        /* renamed from: a, reason: collision with root package name */
        private final Object f4396a;

        /* renamed from: b, reason: collision with root package name */
        private m4 f4397b;

        public e(Object obj, m4 m4Var) {
            this.f4396a = obj;
            this.f4397b = m4Var;
        }

        @Override // h0.r2
        public Object a() {
            return this.f4396a;
        }

        @Override // h0.r2
        public m4 b() {
            return this.f4397b;
        }
    }

    static {
        v1.a("goog.exo.exoplayer");
    }

    public h1(y.c cVar, o3 o3Var) {
        i2.h hVar = new i2.h();
        this.f4349d = hVar;
        try {
            i2.t.f("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.4] [" + i2.c1.f5552e + "]");
            Context applicationContext = cVar.f5008a.getApplicationContext();
            this.f4351e = applicationContext;
            i0.a apply = cVar.f5016i.apply(cVar.f5009b);
            this.f4377r = apply;
            this.f4368m0 = cVar.f5018k;
            this.f4356g0 = cVar.f5019l;
            this.f4344a0 = cVar.f5024q;
            this.f4346b0 = cVar.f5025r;
            this.f4360i0 = cVar.f5023p;
            this.E = cVar.f5032y;
            c cVar2 = new c();
            this.f4388x = cVar2;
            d dVar = new d();
            this.f4389y = dVar;
            Handler handler = new Handler(cVar.f5017j);
            x3[] a6 = cVar.f5011d.get().a(handler, cVar2, cVar2, cVar2, cVar2);
            this.f4355g = a6;
            i2.a.g(a6.length > 0);
            e2.b0 b0Var = cVar.f5013f.get();
            this.f4357h = b0Var;
            this.f4375q = cVar.f5012e.get();
            g2.f fVar = cVar.f5015h.get();
            this.f4381t = fVar;
            this.f4373p = cVar.f5026s;
            this.L = cVar.f5027t;
            this.f4383u = cVar.f5028u;
            this.f4385v = cVar.f5029v;
            this.N = cVar.f5033z;
            Looper looper = cVar.f5017j;
            this.f4379s = looper;
            i2.e eVar = cVar.f5009b;
            this.f4387w = eVar;
            o3 o3Var2 = o3Var == null ? this : o3Var;
            this.f4353f = o3Var2;
            this.f4365l = new i2.s<>(looper, eVar, new s.b() { // from class: h0.t0
                @Override // i2.s.b
                public final void a(Object obj, i2.m mVar) {
                    h1.this.O1((o3.d) obj, mVar);
                }
            });
            this.f4367m = new CopyOnWriteArraySet<>();
            this.f4371o = new ArrayList();
            this.M = new q0.a(0);
            e2.c0 c0Var = new e2.c0(new a4[a6.length], new e2.s[a6.length], r4.f4844b, null);
            this.f4345b = c0Var;
            this.f4369n = new m4.b();
            o3.b e6 = new o3.b.a().c(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 23, 24, 25, 26, 27, 28).d(29, b0Var.d()).e();
            this.f4347c = e6;
            this.O = new o3.b.a().b(e6).a(4).a(10).e();
            this.f4359i = eVar.b(looper, null);
            u1.f fVar2 = new u1.f() { // from class: h0.z0
                @Override // h0.u1.f
                public final void a(u1.e eVar2) {
                    h1.this.Q1(eVar2);
                }
            };
            this.f4361j = fVar2;
            this.f4380s0 = l3.j(c0Var);
            apply.E(o3Var2, looper);
            int i6 = i2.c1.f5548a;
            u1 u1Var = new u1(a6, b0Var, c0Var, cVar.f5014g.get(), fVar, this.F, this.G, apply, this.L, cVar.f5030w, cVar.f5031x, this.N, looper, eVar, fVar2, i6 < 31 ? new i0.o3() : b.a(applicationContext, this, cVar.A), cVar.B);
            this.f4363k = u1Var;
            this.f4358h0 = 1.0f;
            this.F = 0;
            m2 m2Var = m2.M;
            this.P = m2Var;
            this.Q = m2Var;
            this.f4378r0 = m2Var;
            this.f4382t0 = -1;
            this.f4354f0 = i6 < 21 ? L1(0) : i2.c1.F(applicationContext);
            this.f4362j0 = u1.e.f9638c;
            this.f4364k0 = true;
            N(apply);
            fVar.i(new Handler(looper), apply);
            t1(cVar2);
            long j6 = cVar.f5010c;
            if (j6 > 0) {
                u1Var.v(j6);
            }
            h0.b bVar = new h0.b(cVar.f5008a, handler, cVar2);
            this.f4390z = bVar;
            bVar.b(cVar.f5022o);
            j jVar = new j(cVar.f5008a, handler, cVar2);
            this.A = jVar;
            jVar.m(cVar.f5020m ? this.f4356g0 : null);
            h4 h4Var = new h4(cVar.f5008a, handler, cVar2);
            this.B = h4Var;
            h4Var.h(i2.c1.h0(this.f4356g0.f6410c));
            s4 s4Var = new s4(cVar.f5008a);
            this.C = s4Var;
            s4Var.a(cVar.f5021n != 0);
            t4 t4Var = new t4(cVar.f5008a);
            this.D = t4Var;
            t4Var.a(cVar.f5021n == 2);
            this.f4374p0 = w1(h4Var);
            this.f4376q0 = j2.d0.f6689e;
            this.f4348c0 = i2.l0.f5600c;
            b0Var.h(this.f4356g0);
            s2(1, 10, Integer.valueOf(this.f4354f0));
            s2(2, 10, Integer.valueOf(this.f4354f0));
            s2(1, 3, this.f4356g0);
            s2(2, 4, Integer.valueOf(this.f4344a0));
            s2(2, 5, Integer.valueOf(this.f4346b0));
            s2(1, 9, Boolean.valueOf(this.f4360i0));
            s2(2, 7, dVar);
            s2(6, 8, dVar);
            hVar.e();
        } catch (Throwable th) {
            this.f4349d.e();
            throw th;
        }
    }

    private void A2() {
        o3.b bVar = this.O;
        o3.b H = i2.c1.H(this.f4353f, this.f4347c);
        this.O = H;
        if (H.equals(bVar)) {
            return;
        }
        this.f4365l.i(13, new s.a() { // from class: h0.y0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                h1.this.W1((o3.d) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B2(boolean z5, int i6, int i7) {
        int i8 = 0;
        boolean z6 = z5 && i6 != -1;
        if (z6 && i6 != 1) {
            i8 = 1;
        }
        l3 l3Var = this.f4380s0;
        if (l3Var.f4584l == z6 && l3Var.f4585m == i8) {
            return;
        }
        this.H++;
        l3 d6 = l3Var.d(z6, i8);
        this.f4363k.R0(z6, i8);
        C2(d6, 0, i7, false, false, 5, -9223372036854775807L, -1, false);
    }

    private long C1(l3 l3Var) {
        return l3Var.f4573a.u() ? i2.c1.D0(this.f4386v0) : l3Var.f4574b.b() ? l3Var.f4590r : o2(l3Var.f4573a, l3Var.f4574b, l3Var.f4590r);
    }

    private void C2(final l3 l3Var, final int i6, final int i7, boolean z5, boolean z6, final int i8, long j6, int i9, boolean z7) {
        l3 l3Var2 = this.f4380s0;
        this.f4380s0 = l3Var;
        boolean z8 = !l3Var2.f4573a.equals(l3Var.f4573a);
        Pair<Boolean, Integer> z12 = z1(l3Var, l3Var2, z6, i8, z8, z7);
        boolean booleanValue = ((Boolean) z12.first).booleanValue();
        final int intValue = ((Integer) z12.second).intValue();
        m2 m2Var = this.P;
        if (booleanValue) {
            r3 = l3Var.f4573a.u() ? null : l3Var.f4573a.r(l3Var.f4573a.l(l3Var.f4574b.f7437a, this.f4369n).f4677c, this.f4542a).f4693c;
            this.f4378r0 = m2.M;
        }
        if (booleanValue || !l3Var2.f4582j.equals(l3Var.f4582j)) {
            this.f4378r0 = this.f4378r0.b().L(l3Var.f4582j).H();
            m2Var = v1();
        }
        boolean z9 = !m2Var.equals(this.P);
        this.P = m2Var;
        boolean z10 = l3Var2.f4584l != l3Var.f4584l;
        boolean z11 = l3Var2.f4577e != l3Var.f4577e;
        if (z11 || z10) {
            E2();
        }
        boolean z13 = l3Var2.f4579g;
        boolean z14 = l3Var.f4579g;
        boolean z15 = z13 != z14;
        if (z15) {
            D2(z14);
        }
        if (z8) {
            this.f4365l.i(0, new s.a() { // from class: h0.e1
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    h1.X1(l3.this, i6, (o3.d) obj);
                }
            });
        }
        if (z6) {
            final o3.e I1 = I1(i8, l3Var2, i9);
            final o3.e H1 = H1(j6);
            this.f4365l.i(11, new s.a() { // from class: h0.m0
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    h1.Y1(i8, I1, H1, (o3.d) obj);
                }
            });
        }
        if (booleanValue) {
            this.f4365l.i(1, new s.a() { // from class: h0.n0
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    ((o3.d) obj).R(h2.this, intValue);
                }
            });
        }
        if (l3Var2.f4578f != l3Var.f4578f) {
            this.f4365l.i(10, new s.a() { // from class: h0.o0
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    h1.a2(l3.this, (o3.d) obj);
                }
            });
            if (l3Var.f4578f != null) {
                this.f4365l.i(10, new s.a() { // from class: h0.p0
                    @Override // i2.s.a
                    public final void invoke(Object obj) {
                        h1.b2(l3.this, (o3.d) obj);
                    }
                });
            }
        }
        e2.c0 c0Var = l3Var2.f4581i;
        e2.c0 c0Var2 = l3Var.f4581i;
        if (c0Var != c0Var2) {
            this.f4357h.e(c0Var2.f3426e);
            this.f4365l.i(2, new s.a() { // from class: h0.q0
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    h1.c2(l3.this, (o3.d) obj);
                }
            });
        }
        if (z9) {
            final m2 m2Var2 = this.P;
            this.f4365l.i(14, new s.a() { // from class: h0.r0
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    ((o3.d) obj).k0(m2.this);
                }
            });
        }
        if (z15) {
            this.f4365l.i(3, new s.a() { // from class: h0.s0
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    h1.e2(l3.this, (o3.d) obj);
                }
            });
        }
        if (z11 || z10) {
            this.f4365l.i(-1, new s.a() { // from class: h0.u0
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    h1.f2(l3.this, (o3.d) obj);
                }
            });
        }
        if (z11) {
            this.f4365l.i(4, new s.a() { // from class: h0.v0
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    h1.g2(l3.this, (o3.d) obj);
                }
            });
        }
        if (z10) {
            this.f4365l.i(5, new s.a() { // from class: h0.f1
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    h1.h2(l3.this, i7, (o3.d) obj);
                }
            });
        }
        if (l3Var2.f4585m != l3Var.f4585m) {
            this.f4365l.i(6, new s.a() { // from class: h0.g1
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    h1.i2(l3.this, (o3.d) obj);
                }
            });
        }
        if (M1(l3Var2) != M1(l3Var)) {
            this.f4365l.i(7, new s.a() { // from class: h0.j0
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    h1.j2(l3.this, (o3.d) obj);
                }
            });
        }
        if (!l3Var2.f4586n.equals(l3Var.f4586n)) {
            this.f4365l.i(12, new s.a() { // from class: h0.k0
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    h1.k2(l3.this, (o3.d) obj);
                }
            });
        }
        if (z5) {
            this.f4365l.i(-1, new s.a() { // from class: h0.l0
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    ((o3.d) obj).M();
                }
            });
        }
        A2();
        this.f4365l.f();
        if (l3Var2.f4587o != l3Var.f4587o) {
            Iterator<y.b> it = this.f4367m.iterator();
            while (it.hasNext()) {
                it.next().G(l3Var.f4587o);
            }
        }
    }

    private int D1() {
        if (this.f4380s0.f4573a.u()) {
            return this.f4382t0;
        }
        l3 l3Var = this.f4380s0;
        return l3Var.f4573a.l(l3Var.f4574b.f7437a, this.f4369n).f4677c;
    }

    private void D2(boolean z5) {
        i2.k0 k0Var = this.f4368m0;
        if (k0Var != null) {
            if (z5 && !this.f4370n0) {
                k0Var.a(0);
                this.f4370n0 = true;
            } else {
                if (z5 || !this.f4370n0) {
                    return;
                }
                k0Var.c(0);
                this.f4370n0 = false;
            }
        }
    }

    private Pair<Object, Long> E1(m4 m4Var, m4 m4Var2) {
        long t5 = t();
        if (m4Var.u() || m4Var2.u()) {
            boolean z5 = !m4Var.u() && m4Var2.u();
            int D1 = z5 ? -1 : D1();
            if (z5) {
                t5 = -9223372036854775807L;
            }
            return m2(m4Var2, D1, t5);
        }
        Pair<Object, Long> n6 = m4Var.n(this.f4542a, this.f4369n, L(), i2.c1.D0(t5));
        Object obj = ((Pair) i2.c1.j(n6)).first;
        if (m4Var2.f(obj) != -1) {
            return n6;
        }
        Object z02 = u1.z0(this.f4542a, this.f4369n, this.F, this.G, obj, m4Var, m4Var2);
        if (z02 == null) {
            return m2(m4Var2, -1, -9223372036854775807L);
        }
        m4Var2.l(z02, this.f4369n);
        int i6 = this.f4369n.f4677c;
        return m2(m4Var2, i6, m4Var2.r(i6, this.f4542a).d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E2() {
        int c6 = c();
        if (c6 != 1) {
            if (c6 == 2 || c6 == 3) {
                this.C.b(y() && !A1());
                this.D.b(y());
                return;
            } else if (c6 != 4) {
                throw new IllegalStateException();
            }
        }
        this.C.b(false);
        this.D.b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int F1(boolean z5, int i6) {
        return (!z5 || i6 == 1) ? 1 : 2;
    }

    private void F2() {
        this.f4349d.b();
        if (Thread.currentThread() != U().getThread()) {
            String C = i2.c1.C("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), U().getThread().getName());
            if (this.f4364k0) {
                throw new IllegalStateException(C);
            }
            i2.t.j("ExoPlayerImpl", C, this.f4366l0 ? null : new IllegalStateException());
            this.f4366l0 = true;
        }
    }

    private o3.e H1(long j6) {
        Object obj;
        h2 h2Var;
        Object obj2;
        int i6;
        int L = L();
        if (this.f4380s0.f4573a.u()) {
            obj = null;
            h2Var = null;
            obj2 = null;
            i6 = -1;
        } else {
            l3 l3Var = this.f4380s0;
            Object obj3 = l3Var.f4574b.f7437a;
            l3Var.f4573a.l(obj3, this.f4369n);
            i6 = this.f4380s0.f4573a.f(obj3);
            obj2 = obj3;
            obj = this.f4380s0.f4573a.r(L, this.f4542a).f4691a;
            h2Var = this.f4542a.f4693c;
        }
        long e12 = i2.c1.e1(j6);
        long e13 = this.f4380s0.f4574b.b() ? i2.c1.e1(J1(this.f4380s0)) : e12;
        v.b bVar = this.f4380s0.f4574b;
        return new o3.e(obj, L, h2Var, obj2, i6, e12, e13, bVar.f7438b, bVar.f7439c);
    }

    private o3.e I1(int i6, l3 l3Var, int i7) {
        int i8;
        Object obj;
        h2 h2Var;
        Object obj2;
        int i9;
        long j6;
        long j7;
        m4.b bVar = new m4.b();
        if (l3Var.f4573a.u()) {
            i8 = i7;
            obj = null;
            h2Var = null;
            obj2 = null;
            i9 = -1;
        } else {
            Object obj3 = l3Var.f4574b.f7437a;
            l3Var.f4573a.l(obj3, bVar);
            int i10 = bVar.f4677c;
            int f6 = l3Var.f4573a.f(obj3);
            Object obj4 = l3Var.f4573a.r(i10, this.f4542a).f4691a;
            h2Var = this.f4542a.f4693c;
            obj2 = obj3;
            i9 = f6;
            obj = obj4;
            i8 = i10;
        }
        boolean b6 = l3Var.f4574b.b();
        if (i6 == 0) {
            if (b6) {
                v.b bVar2 = l3Var.f4574b;
                j6 = bVar.e(bVar2.f7438b, bVar2.f7439c);
                j7 = J1(l3Var);
            } else {
                j6 = l3Var.f4574b.f7441e != -1 ? J1(this.f4380s0) : bVar.f4679e + bVar.f4678d;
                j7 = j6;
            }
        } else if (b6) {
            j6 = l3Var.f4590r;
            j7 = J1(l3Var);
        } else {
            j6 = bVar.f4679e + l3Var.f4590r;
            j7 = j6;
        }
        long e12 = i2.c1.e1(j6);
        long e13 = i2.c1.e1(j7);
        v.b bVar3 = l3Var.f4574b;
        return new o3.e(obj, i8, h2Var, obj2, i9, e12, e13, bVar3.f7438b, bVar3.f7439c);
    }

    private static long J1(l3 l3Var) {
        m4.d dVar = new m4.d();
        m4.b bVar = new m4.b();
        l3Var.f4573a.l(l3Var.f4574b.f7437a, bVar);
        return l3Var.f4575c == -9223372036854775807L ? l3Var.f4573a.r(bVar.f4677c, dVar).e() : bVar.q() + l3Var.f4575c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K1, reason: merged with bridge method [inline-methods] */
    public void P1(u1.e eVar) {
        long j6;
        boolean z5;
        long j7;
        int i6 = this.H - eVar.f4950c;
        this.H = i6;
        boolean z6 = true;
        if (eVar.f4951d) {
            this.I = eVar.f4952e;
            this.J = true;
        }
        if (eVar.f4953f) {
            this.K = eVar.f4954g;
        }
        if (i6 == 0) {
            m4 m4Var = eVar.f4949b.f4573a;
            if (!this.f4380s0.f4573a.u() && m4Var.u()) {
                this.f4382t0 = -1;
                this.f4386v0 = 0L;
                this.f4384u0 = 0;
            }
            if (!m4Var.u()) {
                List<m4> I = ((t3) m4Var).I();
                i2.a.g(I.size() == this.f4371o.size());
                for (int i7 = 0; i7 < I.size(); i7++) {
                    this.f4371o.get(i7).f4397b = I.get(i7);
                }
            }
            if (this.J) {
                if (eVar.f4949b.f4574b.equals(this.f4380s0.f4574b) && eVar.f4949b.f4576d == this.f4380s0.f4590r) {
                    z6 = false;
                }
                if (z6) {
                    if (m4Var.u() || eVar.f4949b.f4574b.b()) {
                        j7 = eVar.f4949b.f4576d;
                    } else {
                        l3 l3Var = eVar.f4949b;
                        j7 = o2(m4Var, l3Var.f4574b, l3Var.f4576d);
                    }
                    j6 = j7;
                } else {
                    j6 = -9223372036854775807L;
                }
                z5 = z6;
            } else {
                j6 = -9223372036854775807L;
                z5 = false;
            }
            this.J = false;
            C2(eVar.f4949b, 1, this.K, false, z5, this.I, j6, -1, false);
        }
    }

    private int L1(int i6) {
        AudioTrack audioTrack = this.T;
        if (audioTrack != null && audioTrack.getAudioSessionId() != i6) {
            this.T.release();
            this.T = null;
        }
        if (this.T == null) {
            this.T = new AudioTrack(3, 4000, 4, 2, 2, 0, i6);
        }
        return this.T.getAudioSessionId();
    }

    private static boolean M1(l3 l3Var) {
        return l3Var.f4577e == 3 && l3Var.f4584l && l3Var.f4585m == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O1(o3.d dVar, i2.m mVar) {
        dVar.o0(this.f4353f, new o3.c(mVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q1(final u1.e eVar) {
        this.f4359i.k(new Runnable() { // from class: h0.w0
            @Override // java.lang.Runnable
            public final void run() {
                h1.this.P1(eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R1(o3.d dVar) {
        dVar.T(x.i(new w1(1), 1003));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W1(o3.d dVar) {
        dVar.f0(this.O);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X1(l3 l3Var, int i6, o3.d dVar) {
        dVar.K(l3Var.f4573a, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y1(int i6, o3.e eVar, o3.e eVar2, o3.d dVar) {
        dVar.D(i6);
        dVar.J(eVar, eVar2, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a2(l3 l3Var, o3.d dVar) {
        dVar.G(l3Var.f4578f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b2(l3 l3Var, o3.d dVar) {
        dVar.T(l3Var.f4578f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c2(l3 l3Var, o3.d dVar) {
        dVar.m0(l3Var.f4581i.f3425d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e2(l3 l3Var, o3.d dVar) {
        dVar.C(l3Var.f4579g);
        dVar.I(l3Var.f4579g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f2(l3 l3Var, o3.d dVar) {
        dVar.B(l3Var.f4584l, l3Var.f4577e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g2(l3 l3Var, o3.d dVar) {
        dVar.U(l3Var.f4577e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h2(l3 l3Var, int i6, o3.d dVar) {
        dVar.V(l3Var.f4584l, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i2(l3 l3Var, o3.d dVar) {
        dVar.A(l3Var.f4585m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j2(l3 l3Var, o3.d dVar) {
        dVar.q0(M1(l3Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k2(l3 l3Var, o3.d dVar) {
        dVar.h(l3Var.f4586n);
    }

    private l3 l2(l3 l3Var, m4 m4Var, Pair<Object, Long> pair) {
        long j6;
        i2.a.a(m4Var.u() || pair != null);
        m4 m4Var2 = l3Var.f4573a;
        l3 i6 = l3Var.i(m4Var);
        if (m4Var.u()) {
            v.b k6 = l3.k();
            long D0 = i2.c1.D0(this.f4386v0);
            l3 b6 = i6.c(k6, D0, D0, D0, 0L, l1.w0.f7454d, this.f4345b, m2.q.q()).b(k6);
            b6.f4588p = b6.f4590r;
            return b6;
        }
        Object obj = i6.f4574b.f7437a;
        boolean z5 = !obj.equals(((Pair) i2.c1.j(pair)).first);
        v.b bVar = z5 ? new v.b(pair.first) : i6.f4574b;
        long longValue = ((Long) pair.second).longValue();
        long D02 = i2.c1.D0(t());
        if (!m4Var2.u()) {
            D02 -= m4Var2.l(obj, this.f4369n).q();
        }
        if (z5 || longValue < D02) {
            i2.a.g(!bVar.b());
            l3 b7 = i6.c(bVar, longValue, longValue, longValue, 0L, z5 ? l1.w0.f7454d : i6.f4580h, z5 ? this.f4345b : i6.f4581i, z5 ? m2.q.q() : i6.f4582j).b(bVar);
            b7.f4588p = longValue;
            return b7;
        }
        if (longValue == D02) {
            int f6 = m4Var.f(i6.f4583k.f7437a);
            if (f6 == -1 || m4Var.j(f6, this.f4369n).f4677c != m4Var.l(bVar.f7437a, this.f4369n).f4677c) {
                m4Var.l(bVar.f7437a, this.f4369n);
                j6 = bVar.b() ? this.f4369n.e(bVar.f7438b, bVar.f7439c) : this.f4369n.f4678d;
                i6 = i6.c(bVar, i6.f4590r, i6.f4590r, i6.f4576d, j6 - i6.f4590r, i6.f4580h, i6.f4581i, i6.f4582j).b(bVar);
            }
            return i6;
        }
        i2.a.g(!bVar.b());
        long max = Math.max(0L, i6.f4589q - (longValue - D02));
        j6 = i6.f4588p;
        if (i6.f4583k.equals(i6.f4574b)) {
            j6 = longValue + max;
        }
        i6 = i6.c(bVar, longValue, longValue, longValue, max, i6.f4580h, i6.f4581i, i6.f4582j);
        i6.f4588p = j6;
        return i6;
    }

    private Pair<Object, Long> m2(m4 m4Var, int i6, long j6) {
        if (m4Var.u()) {
            this.f4382t0 = i6;
            if (j6 == -9223372036854775807L) {
                j6 = 0;
            }
            this.f4386v0 = j6;
            this.f4384u0 = 0;
            return null;
        }
        if (i6 == -1 || i6 >= m4Var.t()) {
            i6 = m4Var.e(this.G);
            j6 = m4Var.r(i6, this.f4542a).d();
        }
        return m4Var.n(this.f4542a, this.f4369n, i6, i2.c1.D0(j6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n2(final int i6, final int i7) {
        if (i6 == this.f4348c0.b() && i7 == this.f4348c0.a()) {
            return;
        }
        this.f4348c0 = new i2.l0(i6, i7);
        this.f4365l.l(24, new s.a() { // from class: h0.i0
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((o3.d) obj).i0(i6, i7);
            }
        });
    }

    private long o2(m4 m4Var, v.b bVar, long j6) {
        m4Var.l(bVar.f7437a, this.f4369n);
        return j6 + this.f4369n.q();
    }

    private l3 p2(int i6, int i7) {
        int L = L();
        m4 T = T();
        int size = this.f4371o.size();
        this.H++;
        q2(i6, i7);
        m4 x12 = x1();
        l3 l22 = l2(this.f4380s0, x12, E1(T, x12));
        int i8 = l22.f4577e;
        if (i8 != 1 && i8 != 4 && i6 < i7 && i7 == size && L >= l22.f4573a.t()) {
            l22 = l22.g(4);
        }
        this.f4363k.o0(i6, i7, this.M);
        return l22;
    }

    private void q2(int i6, int i7) {
        for (int i8 = i7 - 1; i8 >= i6; i8--) {
            this.f4371o.remove(i8);
        }
        this.M = this.M.a(i6, i7);
    }

    private void r2() {
        if (this.X != null) {
            y1(this.f4389y).n(10000).m(null).l();
            this.X.h(this.f4388x);
            this.X = null;
        }
        TextureView textureView = this.Z;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f4388x) {
                i2.t.i("ExoPlayerImpl", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.Z.setSurfaceTextureListener(null);
            }
            this.Z = null;
        }
        SurfaceHolder surfaceHolder = this.W;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f4388x);
            this.W = null;
        }
    }

    private void s2(int i6, int i7, Object obj) {
        for (x3 x3Var : this.f4355g) {
            if (x3Var.f() == i6) {
                y1(x3Var).n(i7).m(obj).l();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t2() {
        s2(1, 2, Float.valueOf(this.f4358h0 * this.A.g()));
    }

    private List<f3.c> u1(int i6, List<l1.v> list) {
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < list.size(); i7++) {
            f3.c cVar = new f3.c(list.get(i7), this.f4373p);
            arrayList.add(cVar);
            this.f4371o.add(i7 + i6, new e(cVar.f4336b, cVar.f4335a.Z()));
        }
        this.M = this.M.c(i6, arrayList.size());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m2 v1() {
        m4 T = T();
        if (T.u()) {
            return this.f4378r0;
        }
        return this.f4378r0.b().J(T.r(L(), this.f4542a).f4693c.f4409e).H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static v w1(h4 h4Var) {
        return new v(0, h4Var.d(), h4Var.c());
    }

    private void w2(List<l1.v> list, int i6, long j6, boolean z5) {
        int i7;
        long j7;
        int D1 = D1();
        long e02 = e0();
        this.H++;
        if (!this.f4371o.isEmpty()) {
            q2(0, this.f4371o.size());
        }
        List<f3.c> u12 = u1(0, list);
        m4 x12 = x1();
        if (!x12.u() && i6 >= x12.t()) {
            throw new d2(x12, i6, j6);
        }
        if (z5) {
            j7 = -9223372036854775807L;
            i7 = x12.e(this.G);
        } else if (i6 == -1) {
            i7 = D1;
            j7 = e02;
        } else {
            i7 = i6;
            j7 = j6;
        }
        l3 l22 = l2(this.f4380s0, x12, m2(x12, i7, j7));
        int i8 = l22.f4577e;
        if (i7 != -1 && i8 != 1) {
            i8 = (x12.u() || i7 >= x12.t()) ? 4 : 2;
        }
        l3 g6 = l22.g(i8);
        this.f4363k.O0(u12, i7, i2.c1.D0(j7), this.M);
        C2(g6, 0, 1, false, (this.f4380s0.f4574b.f7437a.equals(g6.f4574b.f7437a) || this.f4380s0.f4573a.u()) ? false : true, 4, C1(g6), -1, false);
    }

    private m4 x1() {
        return new t3(this.f4371o, this.M);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x2(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        y2(surface);
        this.V = surface;
    }

    private s3 y1(s3.b bVar) {
        int D1 = D1();
        u1 u1Var = this.f4363k;
        return new s3(u1Var, bVar, this.f4380s0.f4573a, D1 == -1 ? 0 : D1, this.f4387w, u1Var.C());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y2(Object obj) {
        boolean z5;
        ArrayList arrayList = new ArrayList();
        x3[] x3VarArr = this.f4355g;
        int length = x3VarArr.length;
        int i6 = 0;
        while (true) {
            z5 = true;
            if (i6 >= length) {
                break;
            }
            x3 x3Var = x3VarArr[i6];
            if (x3Var.f() == 2) {
                arrayList.add(y1(x3Var).n(1).m(obj).l());
            }
            i6++;
        }
        Object obj2 = this.U;
        if (obj2 == null || obj2 == obj) {
            z5 = false;
        } else {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((s3) it.next()).a(this.E);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z5 = false;
            Object obj3 = this.U;
            Surface surface = this.V;
            if (obj3 == surface) {
                surface.release();
                this.V = null;
            }
        }
        this.U = obj;
        if (z5) {
            z2(false, x.i(new w1(3), 1003));
        }
    }

    private Pair<Boolean, Integer> z1(l3 l3Var, l3 l3Var2, boolean z5, int i6, boolean z6, boolean z7) {
        m4 m4Var = l3Var2.f4573a;
        m4 m4Var2 = l3Var.f4573a;
        if (m4Var2.u() && m4Var.u()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i7 = 3;
        if (m4Var2.u() != m4Var.u()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        if (m4Var.r(m4Var.l(l3Var2.f4574b.f7437a, this.f4369n).f4677c, this.f4542a).f4691a.equals(m4Var2.r(m4Var2.l(l3Var.f4574b.f7437a, this.f4369n).f4677c, this.f4542a).f4691a)) {
            return (z5 && i6 == 0 && l3Var2.f4574b.f7440d < l3Var.f4574b.f7440d) ? new Pair<>(Boolean.TRUE, 0) : (z5 && i6 == 1 && z7) ? new Pair<>(Boolean.TRUE, 2) : new Pair<>(Boolean.FALSE, -1);
        }
        if (z5 && i6 == 0) {
            i7 = 1;
        } else if (z5 && i6 == 1) {
            i7 = 2;
        } else if (!z6) {
            throw new IllegalStateException();
        }
        return new Pair<>(Boolean.TRUE, Integer.valueOf(i7));
    }

    private void z2(boolean z5, x xVar) {
        l3 b6;
        if (z5) {
            b6 = p2(0, this.f4371o.size()).e(null);
        } else {
            l3 l3Var = this.f4380s0;
            b6 = l3Var.b(l3Var.f4574b);
            b6.f4588p = b6.f4590r;
            b6.f4589q = 0L;
        }
        l3 g6 = b6.g(1);
        if (xVar != null) {
            g6 = g6.e(xVar);
        }
        l3 l3Var2 = g6;
        this.H++;
        this.f4363k.i1();
        C2(l3Var2, 0, 1, false, l3Var2.f4573a.u() && !this.f4380s0.f4573a.u(), 4, C1(l3Var2), -1, false);
    }

    public boolean A1() {
        F2();
        return this.f4380s0.f4587o;
    }

    public long B1() {
        F2();
        if (this.f4380s0.f4573a.u()) {
            return this.f4386v0;
        }
        l3 l3Var = this.f4380s0;
        if (l3Var.f4583k.f7440d != l3Var.f4574b.f7440d) {
            return l3Var.f4573a.r(L(), this.f4542a).f();
        }
        long j6 = l3Var.f4588p;
        if (this.f4380s0.f4583k.b()) {
            l3 l3Var2 = this.f4380s0;
            m4.b l6 = l3Var2.f4573a.l(l3Var2.f4583k.f7437a, this.f4369n);
            long i6 = l6.i(this.f4380s0.f4583k.f7438b);
            j6 = i6 == Long.MIN_VALUE ? l6.f4678d : i6;
        }
        l3 l3Var3 = this.f4380s0;
        return i2.c1.e1(o2(l3Var3.f4573a, l3Var3.f4583k, j6));
    }

    @Override // h0.o3
    public void C(final boolean z5) {
        F2();
        if (this.G != z5) {
            this.G = z5;
            this.f4363k.Y0(z5);
            this.f4365l.i(9, new s.a() { // from class: h0.x0
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    ((o3.d) obj).e0(z5);
                }
            });
            A2();
            this.f4365l.f();
        }
    }

    @Override // h0.o3
    public void D(boolean z5) {
        F2();
        this.A.p(y(), 1);
        z2(z5, null);
        this.f4362j0 = new u1.e(m2.q.q(), this.f4380s0.f4590r);
    }

    @Override // h0.y
    public y1 E() {
        F2();
        return this.R;
    }

    @Override // h0.o3
    public r4 F() {
        F2();
        return this.f4380s0.f4581i.f3425d;
    }

    @Override // h0.o3
    public long G() {
        F2();
        return 3000L;
    }

    @Override // h0.o3
    /* renamed from: G1, reason: merged with bridge method [inline-methods] */
    public x n() {
        F2();
        return this.f4380s0.f4578f;
    }

    @Override // h0.o3
    public int J() {
        F2();
        if (this.f4380s0.f4573a.u()) {
            return this.f4384u0;
        }
        l3 l3Var = this.f4380s0;
        return l3Var.f4573a.f(l3Var.f4574b.f7437a);
    }

    @Override // h0.o3
    public int K() {
        F2();
        if (q()) {
            return this.f4380s0.f4574b.f7438b;
        }
        return -1;
    }

    @Override // h0.o3
    public int L() {
        F2();
        int D1 = D1();
        if (D1 == -1) {
            return 0;
        }
        return D1;
    }

    @Override // h0.o3
    public void N(o3.d dVar) {
        this.f4365l.c((o3.d) i2.a.e(dVar));
    }

    @Override // h0.o3
    public int P() {
        F2();
        if (q()) {
            return this.f4380s0.f4574b.f7439c;
        }
        return -1;
    }

    @Override // h0.y
    public void Q(l1.v vVar) {
        F2();
        u2(Collections.singletonList(vVar));
    }

    @Override // h0.o3
    public int S() {
        F2();
        return this.f4380s0.f4585m;
    }

    @Override // h0.o3
    public m4 T() {
        F2();
        return this.f4380s0.f4573a;
    }

    @Override // h0.o3
    public Looper U() {
        return this.f4379s;
    }

    @Override // h0.o3
    public boolean V() {
        F2();
        return this.G;
    }

    @Override // h0.o3
    public void W(o3.d dVar) {
        F2();
        this.f4365l.k((o3.d) i2.a.e(dVar));
    }

    @Override // h0.o3
    public void X(int i6, int i7) {
        F2();
        i2.a.a(i6 >= 0 && i7 >= i6);
        int size = this.f4371o.size();
        int min = Math.min(i7, size);
        if (i6 >= size || i6 == min) {
            return;
        }
        l3 p22 = p2(i6, min);
        C2(p22, 0, 1, false, !p22.f4574b.f7437a.equals(this.f4380s0.f4574b.f7437a), 4, C1(p22), -1, false);
    }

    @Override // h0.o3
    public void a() {
        AudioTrack audioTrack;
        i2.t.f("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.18.4] [" + i2.c1.f5552e + "] [" + v1.b() + "]");
        F2();
        if (i2.c1.f5548a < 21 && (audioTrack = this.T) != null) {
            audioTrack.release();
            this.T = null;
        }
        this.f4390z.b(false);
        this.B.g();
        this.C.b(false);
        this.D.b(false);
        this.A.i();
        if (!this.f4363k.l0()) {
            this.f4365l.l(10, new s.a() { // from class: h0.b1
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    h1.R1((o3.d) obj);
                }
            });
        }
        this.f4365l.j();
        this.f4359i.i(null);
        this.f4381t.h(this.f4377r);
        l3 g6 = this.f4380s0.g(1);
        this.f4380s0 = g6;
        l3 b6 = g6.b(g6.f4574b);
        this.f4380s0 = b6;
        b6.f4588p = b6.f4590r;
        this.f4380s0.f4589q = 0L;
        this.f4377r.a();
        this.f4357h.f();
        r2();
        Surface surface = this.V;
        if (surface != null) {
            surface.release();
            this.V = null;
        }
        if (this.f4370n0) {
            ((i2.k0) i2.a.e(this.f4368m0)).c(0);
            this.f4370n0 = false;
        }
        this.f4362j0 = u1.e.f9638c;
        this.f4372o0 = true;
    }

    @Override // h0.o3
    public void b() {
        F2();
        D(false);
    }

    @Override // h0.y
    @Deprecated
    public y.a b0() {
        F2();
        return this;
    }

    @Override // h0.o3
    public int c() {
        F2();
        return this.f4380s0.f4577e;
    }

    @Override // h0.o3
    public m2 c0() {
        F2();
        return this.P;
    }

    @Override // h0.o3
    public void e() {
        F2();
        boolean y5 = y();
        int p6 = this.A.p(y5, 2);
        B2(y5, p6, F1(y5, p6));
        l3 l3Var = this.f4380s0;
        if (l3Var.f4577e != 1) {
            return;
        }
        l3 e6 = l3Var.e(null);
        l3 g6 = e6.g(e6.f4573a.u() ? 4 : 2);
        this.H++;
        this.f4363k.j0();
        C2(g6, 1, 1, false, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // h0.o3
    public long e0() {
        F2();
        return i2.c1.e1(C1(this.f4380s0));
    }

    @Override // h0.o3
    public long f0() {
        F2();
        return this.f4383u;
    }

    @Override // h0.o3
    public void g(final int i6) {
        F2();
        if (this.F != i6) {
            this.F = i6;
            this.f4363k.V0(i6);
            this.f4365l.i(8, new s.a() { // from class: h0.d1
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    ((o3.d) obj).i(i6);
                }
            });
            A2();
            this.f4365l.f();
        }
    }

    @Override // h0.o3
    public long getDuration() {
        F2();
        if (!q()) {
            return h0();
        }
        l3 l3Var = this.f4380s0;
        v.b bVar = l3Var.f4574b;
        l3Var.f4573a.l(bVar.f7437a, this.f4369n);
        return i2.c1.e1(this.f4369n.e(bVar.f7438b, bVar.f7439c));
    }

    @Override // h0.o3
    public n3 h() {
        F2();
        return this.f4380s0.f4586n;
    }

    @Override // h0.o3
    public void i(n3 n3Var) {
        F2();
        if (n3Var == null) {
            n3Var = n3.f4728d;
        }
        if (this.f4380s0.f4586n.equals(n3Var)) {
            return;
        }
        l3 f6 = this.f4380s0.f(n3Var);
        this.H++;
        this.f4363k.T0(n3Var);
        C2(f6, 0, 1, false, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // h0.y, h0.y.a
    public void j(final j0.e eVar, boolean z5) {
        F2();
        if (this.f4372o0) {
            return;
        }
        if (!i2.c1.c(this.f4356g0, eVar)) {
            this.f4356g0 = eVar;
            s2(1, 3, eVar);
            this.B.h(i2.c1.h0(eVar.f6410c));
            this.f4365l.i(20, new s.a() { // from class: h0.a1
                @Override // i2.s.a
                public final void invoke(Object obj) {
                    ((o3.d) obj).W(j0.e.this);
                }
            });
        }
        this.A.m(z5 ? eVar : null);
        this.f4357h.h(eVar);
        boolean y5 = y();
        int p6 = this.A.p(y5, c());
        B2(y5, p6, F1(y5, p6));
        this.f4365l.f();
    }

    @Override // h0.o3
    public int k() {
        F2();
        return this.F;
    }

    @Override // h0.o3
    public void m(float f6) {
        F2();
        final float p6 = i2.c1.p(f6, 0.0f, 1.0f);
        if (this.f4358h0 == p6) {
            return;
        }
        this.f4358h0 = p6;
        t2();
        this.f4365l.l(22, new s.a() { // from class: h0.c1
            @Override // i2.s.a
            public final void invoke(Object obj) {
                ((o3.d) obj).S(p6);
            }
        });
    }

    @Override // h0.k
    public void m0(int i6, long j6, int i7, boolean z5) {
        F2();
        i2.a.a(i6 >= 0);
        this.f4377r.d0();
        m4 m4Var = this.f4380s0.f4573a;
        if (m4Var.u() || i6 < m4Var.t()) {
            this.H++;
            if (q()) {
                i2.t.i("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                u1.e eVar = new u1.e(this.f4380s0);
                eVar.b(1);
                this.f4361j.a(eVar);
                return;
            }
            int i8 = c() != 1 ? 2 : 1;
            int L = L();
            l3 l22 = l2(this.f4380s0.g(i8), m4Var, m2(m4Var, i6, j6));
            this.f4363k.B0(m4Var, i6, i2.c1.D0(j6));
            C2(l22, 0, 1, true, true, 1, C1(l22), L, z5);
        }
    }

    @Override // h0.o3
    public void o(boolean z5) {
        F2();
        int p6 = this.A.p(z5, c());
        B2(z5, p6, F1(z5, p6));
    }

    @Override // h0.o3
    public void p(Surface surface) {
        F2();
        r2();
        y2(surface);
        int i6 = surface == null ? 0 : -1;
        n2(i6, i6);
    }

    @Override // h0.o3
    public boolean q() {
        F2();
        return this.f4380s0.f4574b.b();
    }

    @Override // h0.o3
    public long s() {
        F2();
        return this.f4385v;
    }

    public void s1(i0.c cVar) {
        this.f4377r.a0((i0.c) i2.a.e(cVar));
    }

    @Override // h0.o3
    public long t() {
        F2();
        if (!q()) {
            return e0();
        }
        l3 l3Var = this.f4380s0;
        l3Var.f4573a.l(l3Var.f4574b.f7437a, this.f4369n);
        l3 l3Var2 = this.f4380s0;
        return l3Var2.f4575c == -9223372036854775807L ? l3Var2.f4573a.r(L(), this.f4542a).d() : this.f4369n.p() + i2.c1.e1(this.f4380s0.f4575c);
    }

    public void t1(y.b bVar) {
        this.f4367m.add(bVar);
    }

    @Override // h0.o3
    public long u() {
        F2();
        return i2.c1.e1(this.f4380s0.f4589q);
    }

    public void u2(List<l1.v> list) {
        F2();
        v2(list, true);
    }

    public void v2(List<l1.v> list, boolean z5) {
        F2();
        w2(list, -1, -9223372036854775807L, z5);
    }

    @Override // h0.o3
    public o3.b w() {
        F2();
        return this.O;
    }

    @Override // h0.o3
    public long x() {
        F2();
        if (!q()) {
            return B1();
        }
        l3 l3Var = this.f4380s0;
        return l3Var.f4583k.equals(l3Var.f4574b) ? i2.c1.e1(this.f4380s0.f4588p) : getDuration();
    }

    @Override // h0.o3
    public boolean y() {
        F2();
        return this.f4380s0.f4584l;
    }
}
