package t2;

import q2.q;
import q2.r;
import q2.x;
import q2.y;

/* loaded from: classes.dex */
public final class m<T> extends l<T> {

    /* renamed from: a, reason: collision with root package name */
    private final r<T> f9456a;

    /* renamed from: b, reason: collision with root package name */
    private final q2.j<T> f9457b;

    /* renamed from: c, reason: collision with root package name */
    final q2.e f9458c;

    /* renamed from: d, reason: collision with root package name */
    private final x2.a<T> f9459d;

    /* renamed from: e, reason: collision with root package name */
    private final y f9460e;

    /* renamed from: f, reason: collision with root package name */
    private final m<T>.b f9461f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f9462g;

    /* renamed from: h, reason: collision with root package name */
    private volatile x<T> f9463h;

    private final class b implements q, q2.i {
        private b() {
        }
    }

    private static final class c implements y {

        /* renamed from: a, reason: collision with root package name */
        private final x2.a<?> f9465a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f9466b;

        /* renamed from: c, reason: collision with root package name */
        private final Class<?> f9467c;

        /* renamed from: d, reason: collision with root package name */
        private final r<?> f9468d;

        /* renamed from: e, reason: collision with root package name */
        private final q2.j<?> f9469e;

        c(Object obj, x2.a<?> aVar, boolean z5, Class<?> cls) {
            r<?> rVar = obj instanceof r ? (r) obj : null;
            this.f9468d = rVar;
            q2.j<?> jVar = obj instanceof q2.j ? (q2.j) obj : null;
            this.f9469e = jVar;
            s2.a.a((rVar == null && jVar == null) ? false : true);
            this.f9465a = aVar;
            this.f9466b = z5;
            this.f9467c = cls;
        }

        @Override // q2.y
        public <T> x<T> a(q2.e eVar, x2.a<T> aVar) {
            x2.a<?> aVar2 = this.f9465a;
            if (aVar2 != null ? aVar2.equals(aVar) || (this.f9466b && this.f9465a.d() == aVar.c()) : this.f9467c.isAssignableFrom(aVar.c())) {
                return new m(this.f9468d, this.f9469e, eVar, aVar, this);
            }
            return null;
        }
    }

    public m(r<T> rVar, q2.j<T> jVar, q2.e eVar, x2.a<T> aVar, y yVar) {
        this(rVar, jVar, eVar, aVar, yVar, true);
    }

    public m(r<T> rVar, q2.j<T> jVar, q2.e eVar, x2.a<T> aVar, y yVar, boolean z5) {
        this.f9461f = new b();
        this.f9456a = rVar;
        this.f9457b = jVar;
        this.f9458c = eVar;
        this.f9459d = aVar;
        this.f9460e = yVar;
        this.f9462g = z5;
    }

    private x<T> f() {
        x<T> xVar = this.f9463h;
        if (xVar != null) {
            return xVar;
        }
        x<T> m6 = this.f9458c.m(this.f9460e, this.f9459d);
        this.f9463h = m6;
        return m6;
    }

    public static y g(Class<?> cls, Object obj) {
        return new c(obj, null, false, cls);
    }

    @Override // q2.x
    public T b(y2.a aVar) {
        if (this.f9457b == null) {
            return f().b(aVar);
        }
        q2.k a6 = s2.m.a(aVar);
        if (this.f9462g && a6.g()) {
            return null;
        }
        return this.f9457b.b(a6, this.f9459d.d(), this.f9461f);
    }

    @Override // q2.x
    public void d(y2.c cVar, T t5) {
        r<T> rVar = this.f9456a;
        if (rVar == null) {
            f().d(cVar, t5);
        } else if (this.f9462g && t5 == null) {
            cVar.V();
        } else {
            s2.m.b(rVar.a(t5, this.f9459d.d(), this.f9461f), cVar);
        }
    }

    @Override // t2.l
    public x<T> e() {
        return this.f9456a != null ? this : f();
    }
}
