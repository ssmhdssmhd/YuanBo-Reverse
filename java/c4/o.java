package c4;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.c;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.a;
import g2.m;
import g2.u;
import g2.v;
import h0.h2;
import h0.k3;
import h0.m2;
import h0.m4;
import h0.n3;
import h0.o3;
import h0.q3;
import h0.r4;
import h0.y;
import h0.y1;
import i2.c1;
import io.flutter.view.t;
import j0.e;
import j2.d0;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l1.j0;
import y3.d;

/* loaded from: classes.dex */
final class o {

    /* renamed from: a, reason: collision with root package name */
    private y f1863a;

    /* renamed from: b, reason: collision with root package name */
    private Surface f1864b;

    /* renamed from: c, reason: collision with root package name */
    private final t.c f1865c;

    /* renamed from: d, reason: collision with root package name */
    private n f1866d;

    /* renamed from: e, reason: collision with root package name */
    private final y3.d f1867e;

    /* renamed from: g, reason: collision with root package name */
    private final p f1869g;

    /* renamed from: f, reason: collision with root package name */
    boolean f1868f = false;

    /* renamed from: h, reason: collision with root package name */
    private v.b f1870h = new v.b();

    class a implements d.InterfaceC0171d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f1871a;

        a(n nVar) {
            this.f1871a = nVar;
        }

        @Override // y3.d.InterfaceC0171d
        public void a(Object obj) {
            this.f1871a.f(null);
        }

        @Override // y3.d.InterfaceC0171d
        public void b(Object obj, d.b bVar) {
            this.f1871a.f(bVar);
        }
    }

    class b implements o3.d {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1873a = false;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ n f1874b;

        b(n nVar) {
            this.f1874b = nVar;
        }

        @Override // h0.o3.d
        public /* synthetic */ void A(int i6) {
            q3.q(this, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void B(boolean z5, int i6) {
            q3.t(this, z5, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void C(boolean z5) {
            q3.j(this, z5);
        }

        @Override // h0.o3.d
        public /* synthetic */ void D(int i6) {
            q3.u(this, i6);
        }

        public void F(boolean z5) {
            if (this.f1873a != z5) {
                this.f1873a = z5;
                HashMap hashMap = new HashMap();
                hashMap.put("event", this.f1873a ? "bufferingStart" : "bufferingEnd");
                this.f1874b.b(hashMap);
            }
        }

        @Override // h0.o3.d
        public /* synthetic */ void G(k3 k3Var) {
            q3.s(this, k3Var);
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

        @Override // h0.o3.d
        public /* synthetic */ void O(h0.v vVar) {
            q3.e(this, vVar);
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
        public void T(k3 k3Var) {
            F(false);
            n nVar = this.f1874b;
            if (nVar != null) {
                nVar.a("VideoError", "Video player had error " + k3Var, null);
            }
        }

        @Override // h0.o3.d
        public void U(int i6) {
            if (i6 == 2) {
                F(true);
                o.this.h();
            } else if (i6 == 3) {
                o oVar = o.this;
                if (!oVar.f1868f) {
                    oVar.f1868f = true;
                    oVar.i();
                }
            } else if (i6 == 4) {
                HashMap hashMap = new HashMap();
                hashMap.put("event", "completed");
                this.f1874b.b(hashMap);
            }
            if (i6 != 2) {
                F(false);
            }
        }

        @Override // h0.o3.d
        public /* synthetic */ void V(boolean z5, int i6) {
            q3.n(this, z5, i6);
        }

        @Override // h0.o3.d
        public /* synthetic */ void W(j0.e eVar) {
            q3.a(this, eVar);
        }

        @Override // h0.o3.d
        public /* synthetic */ void b(boolean z5) {
            q3.A(this, z5);
        }

        @Override // h0.o3.d
        public /* synthetic */ void e0(boolean z5) {
            q3.z(this, z5);
        }

        @Override // h0.o3.d
        public /* synthetic */ void f0(o3.b bVar) {
            q3.b(this, bVar);
        }

        @Override // h0.o3.d
        public /* synthetic */ void h(n3 n3Var) {
            q3.o(this, n3Var);
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

        @Override // h0.o3.d
        public /* synthetic */ void o0(o3 o3Var, o3.c cVar) {
            q3.g(this, o3Var, cVar);
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
    }

    o(Context context, y3.d dVar, t.c cVar, String str, String str2, Map<String, String> map, p pVar) {
        this.f1867e = dVar;
        this.f1865c = cVar;
        this.f1869g = pVar;
        y g6 = new y.c(context).g();
        Uri parse = Uri.parse(str);
        a(map);
        g6.Q(b(parse, new u.a(context, this.f1870h), str2, context));
        g6.e();
        m(g6, new n());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private l1.v b(Uri uri, m.a aVar, String str, Context context) {
        char c6;
        int i6;
        if (str != null) {
            switch (str.hashCode()) {
                case 3680:
                    if (str.equals("ss")) {
                        c6 = 0;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 103407:
                    if (str.equals("hls")) {
                        c6 = 1;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3075986:
                    if (str.equals("dash")) {
                        c6 = 2;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 106069776:
                    if (str.equals("other")) {
                        c6 = 3;
                        break;
                    }
                    c6 = 65535;
                    break;
                default:
                    c6 = 65535;
                    break;
            }
            switch (c6) {
                case 0:
                    i6 = 1;
                    break;
                case 1:
                    i6 = 2;
                    break;
                case 2:
                    i6 = 0;
                    break;
                case 3:
                    i6 = 4;
                    break;
                default:
                    i6 = -1;
                    break;
            }
        } else {
            i6 = c1.o0(uri);
        }
        if (i6 == 0) {
            return new DashMediaSource.Factory(new c.a(aVar), aVar).a(h2.d(uri));
        }
        if (i6 == 1) {
            return new SsMediaSource.Factory(new a.C0046a(aVar), aVar).a(h2.d(uri));
        }
        if (i6 == 2) {
            return new HlsMediaSource.Factory(aVar).a(h2.d(uri));
        }
        if (i6 == 4) {
            return new j0.b(aVar).b(h2.d(uri));
        }
        throw new IllegalStateException("Unsupported type: " + i6);
    }

    private static void j(y yVar, boolean z5) {
        yVar.j(new e.C0096e().c(3).a(), !z5);
    }

    private void m(y yVar, n nVar) {
        this.f1863a = yVar;
        this.f1866d = nVar;
        this.f1867e.d(new a(nVar));
        Surface surface = new Surface(this.f1865c.d());
        this.f1864b = surface;
        yVar.p(surface);
        j(yVar, this.f1869g.f1876a);
        yVar.N(new b(nVar));
    }

    public void a(Map<String, String> map) {
        boolean z5 = !map.isEmpty();
        this.f1870h.g((z5 && map.containsKey("User-Agent")) ? map.get("User-Agent") : "ExoPlayer").c(true);
        if (z5) {
            this.f1870h.e(map);
        }
    }

    void c() {
        if (this.f1868f) {
            this.f1863a.b();
        }
        this.f1865c.a();
        this.f1867e.d(null);
        Surface surface = this.f1864b;
        if (surface != null) {
            surface.release();
        }
        y yVar = this.f1863a;
        if (yVar != null) {
            yVar.a();
        }
    }

    long d() {
        return this.f1863a.e0();
    }

    void e() {
        this.f1863a.o(false);
    }

    void f() {
        this.f1863a.o(true);
    }

    void g(int i6) {
        this.f1863a.l(i6);
    }

    void h() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "bufferingUpdate");
        hashMap.put("values", Collections.singletonList(Arrays.asList(0, Long.valueOf(this.f1863a.x()))));
        this.f1866d.b(hashMap);
    }

    void i() {
        if (this.f1868f) {
            HashMap hashMap = new HashMap();
            hashMap.put("event", "initialized");
            hashMap.put("duration", Long.valueOf(this.f1863a.getDuration()));
            if (this.f1863a.E() != null) {
                y1 E = this.f1863a.E();
                int i6 = E.f5071u;
                int i7 = E.f5072v;
                int i8 = E.f5074x;
                if (i8 == 90 || i8 == 270) {
                    i6 = this.f1863a.E().f5072v;
                    i7 = this.f1863a.E().f5071u;
                }
                hashMap.put("width", Integer.valueOf(i6));
                hashMap.put("height", Integer.valueOf(i7));
                if (i8 == 180) {
                    hashMap.put("rotationCorrection", Integer.valueOf(i8));
                }
            }
            this.f1866d.b(hashMap);
        }
    }

    void k(boolean z5) {
        this.f1863a.g(z5 ? 2 : 0);
    }

    void l(double d6) {
        this.f1863a.i(new n3((float) d6));
    }

    void n(double d6) {
        this.f1863a.m((float) Math.max(0.0d, Math.min(1.0d, d6)));
    }
}
