package y3;

import java.nio.ByteBuffer;
import y3.c;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final y3.c f11102a;

    /* renamed from: b, reason: collision with root package name */
    private final String f11103b;

    /* renamed from: c, reason: collision with root package name */
    private final l f11104c;

    /* renamed from: d, reason: collision with root package name */
    private final c.InterfaceC0170c f11105d;

    private final class a implements c.a {

        /* renamed from: a, reason: collision with root package name */
        private final c f11106a;

        /* renamed from: y3.k$a$a, reason: collision with other inner class name */
        class C0172a implements d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c.b f11108a;

            C0172a(c.b bVar) {
                this.f11108a = bVar;
            }

            @Override // y3.k.d
            public void a(String str, String str2, Object obj) {
                this.f11108a.a(k.this.f11104c.c(str, str2, obj));
            }

            @Override // y3.k.d
            public void b(Object obj) {
                this.f11108a.a(k.this.f11104c.a(obj));
            }

            @Override // y3.k.d
            public void c() {
                this.f11108a.a(null);
            }
        }

        a(c cVar) {
            this.f11106a = cVar;
        }

        @Override // y3.c.a
        public void a(ByteBuffer byteBuffer, c.b bVar) {
            try {
                this.f11106a.e(k.this.f11104c.e(byteBuffer), new C0172a(bVar));
            } catch (RuntimeException e6) {
                k3.b.c("MethodChannel#" + k.this.f11103b, "Failed to handle method call", e6);
                bVar.a(k.this.f11104c.b("error", e6.getMessage(), null, k3.b.d(e6)));
            }
        }
    }

    private final class b implements c.b {

        /* renamed from: a, reason: collision with root package name */
        private final d f11110a;

        b(d dVar) {
            this.f11110a = dVar;
        }

        @Override // y3.c.b
        public void a(ByteBuffer byteBuffer) {
            try {
                if (byteBuffer == null) {
                    this.f11110a.c();
                } else {
                    try {
                        this.f11110a.b(k.this.f11104c.f(byteBuffer));
                    } catch (e e6) {
                        this.f11110a.a(e6.f11096a, e6.getMessage(), e6.f11097b);
                    }
                }
            } catch (RuntimeException e7) {
                k3.b.c("MethodChannel#" + k.this.f11103b, "Failed to handle method call result", e7);
            }
        }
    }

    public interface c {
        void e(j jVar, d dVar);
    }

    public interface d {
        void a(String str, String str2, Object obj);

        void b(Object obj);

        void c();
    }

    public k(y3.c cVar, String str) {
        this(cVar, str, r.f11115b);
    }

    public k(y3.c cVar, String str, l lVar) {
        this(cVar, str, lVar, null);
    }

    public k(y3.c cVar, String str, l lVar, c.InterfaceC0170c interfaceC0170c) {
        this.f11102a = cVar;
        this.f11103b = str;
        this.f11104c = lVar;
        this.f11105d = interfaceC0170c;
    }

    public void c(String str, Object obj) {
        d(str, obj, null);
    }

    public void d(String str, Object obj, d dVar) {
        this.f11102a.e(this.f11103b, this.f11104c.d(new j(str, obj)), dVar == null ? null : new b(dVar));
    }

    public void e(c cVar) {
        if (this.f11105d != null) {
            this.f11102a.c(this.f11103b, cVar != null ? new a(cVar) : null, this.f11105d);
        } else {
            this.f11102a.b(this.f11103b, cVar != null ? new a(cVar) : null);
        }
    }
}
