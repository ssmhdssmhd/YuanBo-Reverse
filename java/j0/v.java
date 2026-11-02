package j0;

import android.os.Handler;
import h0.y1;
import j0.v;

/* loaded from: classes.dex */
public interface v {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f6615a;

        /* renamed from: b, reason: collision with root package name */
        private final v f6616b;

        public a(Handler handler, v vVar) {
            this.f6615a = vVar != null ? (Handler) i2.a.e(handler) : null;
            this.f6616b = vVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A(int i6, long j6, long j7) {
            ((v) i2.c1.j(this.f6616b)).v(i6, j6, j7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(Exception exc) {
            ((v) i2.c1.j(this.f6616b)).o(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(Exception exc) {
            ((v) i2.c1.j(this.f6616b)).c(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(String str, long j6, long j7) {
            ((v) i2.c1.j(this.f6616b)).s(str, j6, j7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(String str) {
            ((v) i2.c1.j(this.f6616b)).r(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(l0.g gVar) {
            gVar.c();
            ((v) i2.c1.j(this.f6616b)).d(gVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(l0.g gVar) {
            ((v) i2.c1.j(this.f6616b)).x(gVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(y1 y1Var, l0.k kVar) {
            ((v) i2.c1.j(this.f6616b)).C(y1Var);
            ((v) i2.c1.j(this.f6616b)).u(y1Var, kVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(long j6) {
            ((v) i2.c1.j(this.f6616b)).n(j6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(boolean z5) {
            ((v) i2.c1.j(this.f6616b)).b(z5);
        }

        public void B(final long j6) {
            Handler handler = this.f6615a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j0.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.y(j6);
                    }
                });
            }
        }

        public void C(final boolean z5) {
            Handler handler = this.f6615a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j0.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.z(z5);
                    }
                });
            }
        }

        public void D(final int i6, final long j6, final long j7) {
            Handler handler = this.f6615a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j0.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.A(i6, j6, j7);
                    }
                });
            }
        }

        public void k(final Exception exc) {
            Handler handler = this.f6615a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j0.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.r(exc);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            Handler handler = this.f6615a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j0.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.s(exc);
                    }
                });
            }
        }

        public void m(final String str, final long j6, final long j7) {
            Handler handler = this.f6615a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j0.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.t(str, j6, j7);
                    }
                });
            }
        }

        public void n(final String str) {
            Handler handler = this.f6615a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j0.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.u(str);
                    }
                });
            }
        }

        public void o(final l0.g gVar) {
            gVar.c();
            Handler handler = this.f6615a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j0.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.v(gVar);
                    }
                });
            }
        }

        public void p(final l0.g gVar) {
            Handler handler = this.f6615a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j0.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.w(gVar);
                    }
                });
            }
        }

        public void q(final y1 y1Var, final l0.k kVar) {
            Handler handler = this.f6615a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j0.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.a.this.x(y1Var, kVar);
                    }
                });
            }
        }
    }

    @Deprecated
    void C(y1 y1Var);

    void b(boolean z5);

    void c(Exception exc);

    void d(l0.g gVar);

    void n(long j6);

    void o(Exception exc);

    void r(String str);

    void s(String str, long j6, long j7);

    void u(y1 y1Var, l0.k kVar);

    void v(int i6, long j6, long j7);

    void x(l0.g gVar);
}
