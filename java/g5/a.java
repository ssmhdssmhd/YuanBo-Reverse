package g5;

import d5.b0;
import d5.c;
import d5.c0;
import d5.e;
import d5.r;
import d5.t;
import d5.v;
import d5.y;
import d5.z;
import g5.b;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import v4.p;

/* loaded from: classes.dex */
public final class a implements v {

    /* renamed from: a, reason: collision with root package name */
    public static final C0079a f4241a = new C0079a(null);

    /* renamed from: g5.a$a, reason: collision with other inner class name */
    public static final class C0079a {
        private C0079a() {
        }

        public /* synthetic */ C0079a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final t c(t tVar, t tVar2) {
            boolean o6;
            t.a aVar = new t.a();
            int size = tVar.size();
            for (int i6 = 0; i6 < size; i6++) {
                String c6 = tVar.c(i6);
                String e6 = tVar.e(i6);
                o6 = p.o("Warning", c6, true);
                if ((!o6 || !p.A(e6, "1", false, 2, null)) && (d(c6) || !e(c6) || tVar2.b(c6) == null)) {
                    aVar.c(c6, e6);
                }
            }
            int size2 = tVar2.size();
            for (int i7 = 0; i7 < size2; i7++) {
                String c7 = tVar2.c(i7);
                if (!d(c7) && e(c7)) {
                    aVar.c(c7, tVar2.e(i7));
                }
            }
            return aVar.d();
        }

        private final boolean d(String str) {
            boolean o6;
            boolean o7;
            boolean o8;
            o6 = p.o("Content-Length", str, true);
            if (o6) {
                return true;
            }
            o7 = p.o("Content-Encoding", str, true);
            if (o7) {
                return true;
            }
            o8 = p.o("Content-Type", str, true);
            return o8;
        }

        private final boolean e(String str) {
            boolean o6;
            boolean o7;
            boolean o8;
            boolean o9;
            boolean o10;
            boolean o11;
            boolean o12;
            boolean o13;
            o6 = p.o("Connection", str, true);
            if (!o6) {
                o7 = p.o("Keep-Alive", str, true);
                if (!o7) {
                    o8 = p.o("Proxy-Authenticate", str, true);
                    if (!o8) {
                        o9 = p.o("Proxy-Authorization", str, true);
                        if (!o9) {
                            o10 = p.o("TE", str, true);
                            if (!o10) {
                                o11 = p.o("Trailers", str, true);
                                if (!o11) {
                                    o12 = p.o("Transfer-Encoding", str, true);
                                    if (!o12) {
                                        o13 = p.o("Upgrade", str, true);
                                        if (!o13) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final b0 f(b0 b0Var) {
            return (b0Var != null ? b0Var.a() : null) != null ? b0Var.U().b(null).c() : b0Var;
        }
    }

    public a(c cVar) {
    }

    @Override // d5.v
    public b0 a(v.a chain) {
        r rVar;
        k.e(chain, "chain");
        e call = chain.call();
        b b6 = new b.C0080b(System.currentTimeMillis(), chain.b(), null).b();
        z b7 = b6.b();
        b0 a6 = b6.a();
        i5.e eVar = (i5.e) (!(call instanceof i5.e) ? null : call);
        if (eVar == null || (rVar = eVar.m()) == null) {
            rVar = r.f3194a;
        }
        if (b7 == null && a6 == null) {
            b0 c6 = new b0.a().r(chain.b()).p(y.HTTP_1_1).g(504).m("Unsatisfiable Request (only-if-cached)").b(e5.b.f3713c).s(-1L).q(System.currentTimeMillis()).c();
            rVar.z(call, c6);
            return c6;
        }
        if (b7 == null) {
            k.b(a6);
            b0 c7 = a6.U().d(f4241a.f(a6)).c();
            rVar.b(call, c7);
            return c7;
        }
        if (a6 != null) {
            rVar.a(call, a6);
        }
        b0 a7 = chain.a(b7);
        if (a6 != null) {
            if (a7 != null && a7.s() == 304) {
                b0.a U = a6.U();
                C0079a c0079a = f4241a;
                U.k(c0079a.c(a6.I(), a7.I())).s(a7.Z()).q(a7.X()).d(c0079a.f(a6)).n(c0079a.f(a7)).c();
                c0 a8 = a7.a();
                k.b(a8);
                a8.close();
                k.b(null);
                throw null;
            }
            c0 a9 = a6.a();
            if (a9 != null) {
                e5.b.i(a9);
            }
        }
        k.b(a7);
        b0.a U2 = a7.U();
        C0079a c0079a2 = f4241a;
        return U2.d(c0079a2.f(a6)).n(c0079a2.f(a7)).c();
    }
}
