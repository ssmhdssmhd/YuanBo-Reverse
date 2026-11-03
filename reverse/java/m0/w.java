package m0;

import android.os.Handler;
import i2.c1;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import l1.v;
import m0.w;

/* loaded from: classes.dex */
public interface w {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f7894a;

        /* renamed from: b, reason: collision with root package name */
        public final v.b f7895b;

        /* renamed from: c, reason: collision with root package name */
        private final CopyOnWriteArrayList<C0114a> f7896c;

        /* renamed from: m0.w$a$a, reason: collision with other inner class name */
        private static final class C0114a {

            /* renamed from: a, reason: collision with root package name */
            public Handler f7897a;

            /* renamed from: b, reason: collision with root package name */
            public w f7898b;

            public C0114a(Handler handler, w wVar) {
                this.f7897a = handler;
                this.f7898b = wVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        private a(CopyOnWriteArrayList<C0114a> copyOnWriteArrayList, int i6, v.b bVar) {
            this.f7896c = copyOnWriteArrayList;
            this.f7894a = i6;
            this.f7895b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void n(w wVar) {
            wVar.H(this.f7894a, this.f7895b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(w wVar) {
            wVar.Q(this.f7894a, this.f7895b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(w wVar) {
            wVar.j0(this.f7894a, this.f7895b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(w wVar, int i6) {
            wVar.F(this.f7894a, this.f7895b);
            wVar.X(this.f7894a, this.f7895b, i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(w wVar, Exception exc) {
            wVar.Y(this.f7894a, this.f7895b, exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(w wVar) {
            wVar.n0(this.f7894a, this.f7895b);
        }

        public void g(Handler handler, w wVar) {
            i2.a.e(handler);
            i2.a.e(wVar);
            this.f7896c.add(new C0114a(handler, wVar));
        }

        public void h() {
            Iterator<C0114a> it = this.f7896c.iterator();
            while (it.hasNext()) {
                C0114a next = it.next();
                final w wVar = next.f7898b;
                c1.M0(next.f7897a, new Runnable() { // from class: m0.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.n(wVar);
                    }
                });
            }
        }

        public void i() {
            Iterator<C0114a> it = this.f7896c.iterator();
            while (it.hasNext()) {
                C0114a next = it.next();
                final w wVar = next.f7898b;
                c1.M0(next.f7897a, new Runnable() { // from class: m0.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.o(wVar);
                    }
                });
            }
        }

        public void j() {
            Iterator<C0114a> it = this.f7896c.iterator();
            while (it.hasNext()) {
                C0114a next = it.next();
                final w wVar = next.f7898b;
                c1.M0(next.f7897a, new Runnable() { // from class: m0.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.p(wVar);
                    }
                });
            }
        }

        public void k(final int i6) {
            Iterator<C0114a> it = this.f7896c.iterator();
            while (it.hasNext()) {
                C0114a next = it.next();
                final w wVar = next.f7898b;
                c1.M0(next.f7897a, new Runnable() { // from class: m0.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.q(wVar, i6);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            Iterator<C0114a> it = this.f7896c.iterator();
            while (it.hasNext()) {
                C0114a next = it.next();
                final w wVar = next.f7898b;
                c1.M0(next.f7897a, new Runnable() { // from class: m0.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.r(wVar, exc);
                    }
                });
            }
        }

        public void m() {
            Iterator<C0114a> it = this.f7896c.iterator();
            while (it.hasNext()) {
                C0114a next = it.next();
                final w wVar = next.f7898b;
                c1.M0(next.f7897a, new Runnable() { // from class: m0.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.s(wVar);
                    }
                });
            }
        }

        public void t(w wVar) {
            Iterator<C0114a> it = this.f7896c.iterator();
            while (it.hasNext()) {
                C0114a next = it.next();
                if (next.f7898b == wVar) {
                    this.f7896c.remove(next);
                }
            }
        }

        public a u(int i6, v.b bVar) {
            return new a(this.f7896c, i6, bVar);
        }
    }

    @Deprecated
    void F(int i6, v.b bVar);

    void H(int i6, v.b bVar);

    void Q(int i6, v.b bVar);

    void X(int i6, v.b bVar, int i7);

    void Y(int i6, v.b bVar, Exception exc);

    void j0(int i6, v.b bVar);

    void n0(int i6, v.b bVar);
}
