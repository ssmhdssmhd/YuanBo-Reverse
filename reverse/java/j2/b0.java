package j2;

import android.os.Handler;
import android.os.SystemClock;
import h0.y1;
import i2.c1;
import j2.b0;

/* loaded from: classes.dex */
public interface b0 {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f6673a;

        /* renamed from: b, reason: collision with root package name */
        private final b0 f6674b;

        public a(Handler handler, b0 b0Var) {
            this.f6673a = b0Var != null ? (Handler) i2.a.e(handler) : null;
            this.f6674b = b0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(String str, long j6, long j7) {
            ((b0) c1.j(this.f6674b)).g(str, j6, j7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(String str) {
            ((b0) c1.j(this.f6674b)).e(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(l0.g gVar) {
            gVar.c();
            ((b0) c1.j(this.f6674b)).k(gVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(int i6, long j6) {
            ((b0) c1.j(this.f6674b)).w(i6, j6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(l0.g gVar) {
            ((b0) c1.j(this.f6674b)).t(gVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(y1 y1Var, l0.k kVar) {
            ((b0) c1.j(this.f6674b)).h(y1Var);
            ((b0) c1.j(this.f6674b)).z(y1Var, kVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(Object obj, long j6) {
            ((b0) c1.j(this.f6674b)).f(obj, j6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(long j6, int i6) {
            ((b0) c1.j(this.f6674b)).y(j6, i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(Exception exc) {
            ((b0) c1.j(this.f6674b)).q(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(d0 d0Var) {
            ((b0) c1.j(this.f6674b)).p(d0Var);
        }

        public void A(final Object obj) {
            if (this.f6673a != null) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                this.f6673a.post(new Runnable() { // from class: j2.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.a.this.w(obj, elapsedRealtime);
                    }
                });
            }
        }

        public void B(final long j6, final int i6) {
            Handler handler = this.f6673a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j2.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.a.this.x(j6, i6);
                    }
                });
            }
        }

        public void C(final Exception exc) {
            Handler handler = this.f6673a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j2.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.a.this.y(exc);
                    }
                });
            }
        }

        public void D(final d0 d0Var) {
            Handler handler = this.f6673a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j2.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.a.this.z(d0Var);
                    }
                });
            }
        }

        public void k(final String str, final long j6, final long j7) {
            Handler handler = this.f6673a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j2.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.a.this.q(str, j6, j7);
                    }
                });
            }
        }

        public void l(final String str) {
            Handler handler = this.f6673a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j2.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.a.this.r(str);
                    }
                });
            }
        }

        public void m(final l0.g gVar) {
            gVar.c();
            Handler handler = this.f6673a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j2.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.a.this.s(gVar);
                    }
                });
            }
        }

        public void n(final int i6, final long j6) {
            Handler handler = this.f6673a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j2.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.a.this.t(i6, j6);
                    }
                });
            }
        }

        public void o(final l0.g gVar) {
            Handler handler = this.f6673a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j2.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.a.this.u(gVar);
                    }
                });
            }
        }

        public void p(final y1 y1Var, final l0.k kVar) {
            Handler handler = this.f6673a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: j2.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.a.this.v(y1Var, kVar);
                    }
                });
            }
        }
    }

    void e(String str);

    void f(Object obj, long j6);

    void g(String str, long j6, long j7);

    @Deprecated
    void h(y1 y1Var);

    void k(l0.g gVar);

    void p(d0 d0Var);

    void q(Exception exc);

    void t(l0.g gVar);

    void w(int i6, long j6);

    void y(long j6, int i6);

    void z(y1 y1Var, l0.k kVar);
}
