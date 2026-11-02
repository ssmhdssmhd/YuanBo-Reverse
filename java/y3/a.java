package y3;

import java.nio.ByteBuffer;
import y3.c;

/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final y3.c f11076a;

    /* renamed from: b, reason: collision with root package name */
    private final String f11077b;

    /* renamed from: c, reason: collision with root package name */
    private final i<T> f11078c;

    /* renamed from: d, reason: collision with root package name */
    private final c.InterfaceC0170c f11079d;

    private final class b implements c.a {

        /* renamed from: a, reason: collision with root package name */
        private final d<T> f11080a;

        /* renamed from: y3.a$b$a, reason: collision with other inner class name */
        class C0169a implements e<T> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ c.b f11082a;

            C0169a(c.b bVar) {
                this.f11082a = bVar;
            }

            @Override // y3.a.e
            public void a(T t5) {
                this.f11082a.a(a.this.f11078c.a(t5));
            }
        }

        private b(d<T> dVar) {
            this.f11080a = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // y3.c.a
        public void a(ByteBuffer byteBuffer, c.b bVar) {
            try {
                this.f11080a.a(a.this.f11078c.b(byteBuffer), new C0169a(bVar));
            } catch (RuntimeException e6) {
                k3.b.c("BasicMessageChannel#" + a.this.f11077b, "Failed to handle message", e6);
                bVar.a(null);
            }
        }
    }

    private final class c implements c.b {

        /* renamed from: a, reason: collision with root package name */
        private final e<T> f11084a;

        private c(e<T> eVar) {
            this.f11084a = eVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // y3.c.b
        public void a(ByteBuffer byteBuffer) {
            try {
                this.f11084a.a(a.this.f11078c.b(byteBuffer));
            } catch (RuntimeException e6) {
                k3.b.c("BasicMessageChannel#" + a.this.f11077b, "Failed to handle message reply", e6);
            }
        }
    }

    public interface d<T> {
        void a(T t5, e<T> eVar);
    }

    public interface e<T> {
        void a(T t5);
    }

    public a(y3.c cVar, String str, i<T> iVar) {
        this(cVar, str, iVar, null);
    }

    public a(y3.c cVar, String str, i<T> iVar, c.InterfaceC0170c interfaceC0170c) {
        this.f11076a = cVar;
        this.f11077b = str;
        this.f11078c = iVar;
        this.f11079d = interfaceC0170c;
    }

    public void c(T t5) {
        d(t5, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d(T t5, e<T> eVar) {
        this.f11076a.e(this.f11077b, this.f11078c.a(t5), eVar != null ? new c(eVar) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [y3.c] */
    /* JADX WARN: Type inference failed for: r1v0, types: [y3.a$a] */
    /* JADX WARN: Type inference failed for: r1v1, types: [y3.c$a] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public void e(d<T> dVar) {
        if (this.f11079d != null) {
            this.f11076a.c(this.f11077b, dVar != null ? new b(dVar) : null, this.f11079d);
        } else {
            this.f11076a.b(this.f11077b, dVar != null ? new b(dVar) : 0);
        }
    }
}
