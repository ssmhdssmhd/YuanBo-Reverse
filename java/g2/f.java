package g2;

import android.os.Handler;
import g2.f;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public interface f {

    public interface a {

        /* renamed from: g2.f$a$a, reason: collision with other inner class name */
        public static final class C0077a {

            /* renamed from: a, reason: collision with root package name */
            private final CopyOnWriteArrayList<C0078a> f4022a = new CopyOnWriteArrayList<>();

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: g2.f$a$a$a, reason: collision with other inner class name */
            static final class C0078a {

                /* renamed from: a, reason: collision with root package name */
                private final Handler f4023a;

                /* renamed from: b, reason: collision with root package name */
                private final a f4024b;

                /* renamed from: c, reason: collision with root package name */
                private boolean f4025c;

                public C0078a(Handler handler, a aVar) {
                    this.f4023a = handler;
                    this.f4024b = aVar;
                }

                public void d() {
                    this.f4025c = true;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void d(C0078a c0078a, int i6, long j6, long j7) {
                c0078a.f4024b.Z(i6, j6, j7);
            }

            public void b(Handler handler, a aVar) {
                i2.a.e(handler);
                i2.a.e(aVar);
                e(aVar);
                this.f4022a.add(new C0078a(handler, aVar));
            }

            public void c(final int i6, final long j6, final long j7) {
                Iterator<C0078a> it = this.f4022a.iterator();
                while (it.hasNext()) {
                    final C0078a next = it.next();
                    if (!next.f4025c) {
                        next.f4023a.post(new Runnable() { // from class: g2.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                f.a.C0077a.d(f.a.C0077a.C0078a.this, i6, j6, j7);
                            }
                        });
                    }
                }
            }

            public void e(a aVar) {
                Iterator<C0078a> it = this.f4022a.iterator();
                while (it.hasNext()) {
                    C0078a next = it.next();
                    if (next.f4024b == aVar) {
                        next.d();
                        this.f4022a.remove(next);
                    }
                }
            }
        }

        void Z(int i6, long j6, long j7);
    }

    u0 a();

    long c();

    long d();

    void h(a aVar);

    void i(Handler handler, a aVar);
}
