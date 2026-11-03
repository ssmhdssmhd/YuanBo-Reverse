package l1;

import android.os.Handler;
import h0.y1;
import i2.c1;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import l1.c0;
import l1.v;

/* loaded from: classes.dex */
public interface c0 {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f7209a;

        /* renamed from: b, reason: collision with root package name */
        public final v.b f7210b;

        /* renamed from: c, reason: collision with root package name */
        private final CopyOnWriteArrayList<C0106a> f7211c;

        /* renamed from: d, reason: collision with root package name */
        private final long f7212d;

        /* renamed from: l1.c0$a$a, reason: collision with other inner class name */
        private static final class C0106a {

            /* renamed from: a, reason: collision with root package name */
            public Handler f7213a;

            /* renamed from: b, reason: collision with root package name */
            public c0 f7214b;

            public C0106a(Handler handler, c0 c0Var) {
                this.f7213a = handler;
                this.f7214b = c0Var;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        private a(CopyOnWriteArrayList<C0106a> copyOnWriteArrayList, int i6, v.b bVar, long j6) {
            this.f7211c = copyOnWriteArrayList;
            this.f7209a = i6;
            this.f7210b = bVar;
            this.f7212d = j6;
        }

        private long h(long j6) {
            long e12 = c1.e1(j6);
            if (e12 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f7212d + e12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(c0 c0Var, r rVar) {
            c0Var.h0(this.f7209a, this.f7210b, rVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(c0 c0Var, o oVar, r rVar) {
            c0Var.P(this.f7209a, this.f7210b, oVar, rVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(c0 c0Var, o oVar, r rVar) {
            c0Var.c0(this.f7209a, this.f7210b, oVar, rVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(c0 c0Var, o oVar, r rVar, IOException iOException, boolean z5) {
            c0Var.b0(this.f7209a, this.f7210b, oVar, rVar, iOException, z5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(c0 c0Var, o oVar, r rVar) {
            c0Var.N(this.f7209a, this.f7210b, oVar, rVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(c0 c0Var, v.b bVar, r rVar) {
            c0Var.g0(this.f7209a, bVar, rVar);
        }

        public void A(o oVar, int i6, int i7, y1 y1Var, int i8, Object obj, long j6, long j7) {
            B(oVar, new r(i6, i7, y1Var, i8, obj, h(j6), h(j7)));
        }

        public void B(final o oVar, final r rVar) {
            Iterator<C0106a> it = this.f7211c.iterator();
            while (it.hasNext()) {
                C0106a next = it.next();
                final c0 c0Var = next.f7214b;
                c1.M0(next.f7213a, new Runnable() { // from class: l1.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        c0.a.this.o(c0Var, oVar, rVar);
                    }
                });
            }
        }

        public void C(c0 c0Var) {
            Iterator<C0106a> it = this.f7211c.iterator();
            while (it.hasNext()) {
                C0106a next = it.next();
                if (next.f7214b == c0Var) {
                    this.f7211c.remove(next);
                }
            }
        }

        public void D(int i6, long j6, long j7) {
            E(new r(1, i6, null, 3, null, h(j6), h(j7)));
        }

        public void E(final r rVar) {
            final v.b bVar = (v.b) i2.a.e(this.f7210b);
            Iterator<C0106a> it = this.f7211c.iterator();
            while (it.hasNext()) {
                C0106a next = it.next();
                final c0 c0Var = next.f7214b;
                c1.M0(next.f7213a, new Runnable() { // from class: l1.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        c0.a.this.p(c0Var, bVar, rVar);
                    }
                });
            }
        }

        public a F(int i6, v.b bVar, long j6) {
            return new a(this.f7211c, i6, bVar, j6);
        }

        public void g(Handler handler, c0 c0Var) {
            i2.a.e(handler);
            i2.a.e(c0Var);
            this.f7211c.add(new C0106a(handler, c0Var));
        }

        public void i(int i6, y1 y1Var, int i7, Object obj, long j6) {
            j(new r(1, i6, y1Var, i7, obj, h(j6), -9223372036854775807L));
        }

        public void j(final r rVar) {
            Iterator<C0106a> it = this.f7211c.iterator();
            while (it.hasNext()) {
                C0106a next = it.next();
                final c0 c0Var = next.f7214b;
                c1.M0(next.f7213a, new Runnable() { // from class: l1.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        c0.a.this.k(c0Var, rVar);
                    }
                });
            }
        }

        public void q(o oVar, int i6) {
            r(oVar, i6, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void r(o oVar, int i6, int i7, y1 y1Var, int i8, Object obj, long j6, long j7) {
            s(oVar, new r(i6, i7, y1Var, i8, obj, h(j6), h(j7)));
        }

        public void s(final o oVar, final r rVar) {
            Iterator<C0106a> it = this.f7211c.iterator();
            while (it.hasNext()) {
                C0106a next = it.next();
                final c0 c0Var = next.f7214b;
                c1.M0(next.f7213a, new Runnable() { // from class: l1.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        c0.a.this.l(c0Var, oVar, rVar);
                    }
                });
            }
        }

        public void t(o oVar, int i6) {
            u(oVar, i6, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }

        public void u(o oVar, int i6, int i7, y1 y1Var, int i8, Object obj, long j6, long j7) {
            v(oVar, new r(i6, i7, y1Var, i8, obj, h(j6), h(j7)));
        }

        public void v(final o oVar, final r rVar) {
            Iterator<C0106a> it = this.f7211c.iterator();
            while (it.hasNext()) {
                C0106a next = it.next();
                final c0 c0Var = next.f7214b;
                c1.M0(next.f7213a, new Runnable() { // from class: l1.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        c0.a.this.m(c0Var, oVar, rVar);
                    }
                });
            }
        }

        public void w(o oVar, int i6, int i7, y1 y1Var, int i8, Object obj, long j6, long j7, IOException iOException, boolean z5) {
            y(oVar, new r(i6, i7, y1Var, i8, obj, h(j6), h(j7)), iOException, z5);
        }

        public void x(o oVar, int i6, IOException iOException, boolean z5) {
            w(oVar, i6, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, z5);
        }

        public void y(final o oVar, final r rVar, final IOException iOException, final boolean z5) {
            Iterator<C0106a> it = this.f7211c.iterator();
            while (it.hasNext()) {
                C0106a next = it.next();
                final c0 c0Var = next.f7214b;
                c1.M0(next.f7213a, new Runnable() { // from class: l1.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        c0.a.this.n(c0Var, oVar, rVar, iOException, z5);
                    }
                });
            }
        }

        public void z(o oVar, int i6) {
            A(oVar, i6, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
        }
    }

    void N(int i6, v.b bVar, o oVar, r rVar);

    void P(int i6, v.b bVar, o oVar, r rVar);

    void b0(int i6, v.b bVar, o oVar, r rVar, IOException iOException, boolean z5);

    void c0(int i6, v.b bVar, o oVar, r rVar);

    void g0(int i6, v.b bVar, r rVar);

    void h0(int i6, v.b bVar, r rVar);
}
