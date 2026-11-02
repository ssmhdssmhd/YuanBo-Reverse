package s2;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import q2.x;
import q2.y;

/* loaded from: classes.dex */
public final class d implements y, Cloneable {

    /* renamed from: k, reason: collision with root package name */
    public static final d f9240k = new d();

    /* renamed from: d, reason: collision with root package name */
    private boolean f9244d;

    /* renamed from: a, reason: collision with root package name */
    private double f9241a = -1.0d;

    /* renamed from: b, reason: collision with root package name */
    private int f9242b = 136;

    /* renamed from: c, reason: collision with root package name */
    private boolean f9243c = true;

    /* renamed from: e, reason: collision with root package name */
    private List<q2.a> f9245e = Collections.emptyList();

    /* renamed from: j, reason: collision with root package name */
    private List<q2.a> f9246j = Collections.emptyList();

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> extends x<T> {

        /* renamed from: a, reason: collision with root package name */
        private x<T> f9247a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f9248b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f9249c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ q2.e f9250d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ x2.a f9251e;

        a(boolean z5, boolean z6, q2.e eVar, x2.a aVar) {
            this.f9248b = z5;
            this.f9249c = z6;
            this.f9250d = eVar;
            this.f9251e = aVar;
        }

        private x<T> e() {
            x<T> xVar = this.f9247a;
            if (xVar != null) {
                return xVar;
            }
            x<T> m6 = this.f9250d.m(d.this, this.f9251e);
            this.f9247a = m6;
            return m6;
        }

        @Override // q2.x
        public T b(y2.a aVar) {
            if (!this.f9248b) {
                return e().b(aVar);
            }
            aVar.q0();
            return null;
        }

        @Override // q2.x
        public void d(y2.c cVar, T t5) {
            if (this.f9249c) {
                cVar.V();
            } else {
                e().d(cVar, t5);
            }
        }
    }

    private boolean d(Class<?> cls) {
        if (this.f9241a == -1.0d || m((r2.d) cls.getAnnotation(r2.d.class), (r2.e) cls.getAnnotation(r2.e.class))) {
            return (!this.f9243c && h(cls)) || g(cls);
        }
        return true;
    }

    private boolean e(Class<?> cls, boolean z5) {
        Iterator<q2.a> it = (z5 ? this.f9245e : this.f9246j).iterator();
        while (it.hasNext()) {
            if (it.next().a(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean g(Class<?> cls) {
        return (Enum.class.isAssignableFrom(cls) || i(cls) || (!cls.isAnonymousClass() && !cls.isLocalClass())) ? false : true;
    }

    private boolean h(Class<?> cls) {
        return cls.isMemberClass() && !i(cls);
    }

    private boolean i(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean k(r2.d dVar) {
        if (dVar != null) {
            return this.f9241a >= dVar.value();
        }
        return true;
    }

    private boolean l(r2.e eVar) {
        if (eVar != null) {
            return this.f9241a < eVar.value();
        }
        return true;
    }

    private boolean m(r2.d dVar, r2.e eVar) {
        return k(dVar) && l(eVar);
    }

    @Override // q2.y
    public <T> x<T> a(q2.e eVar, x2.a<T> aVar) {
        Class<? super T> c6 = aVar.c();
        boolean d6 = d(c6);
        boolean z5 = d6 || e(c6, true);
        boolean z6 = d6 || e(c6, false);
        if (z5 || z6) {
            return new a(z6, z5, eVar, aVar);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e6) {
            throw new AssertionError(e6);
        }
    }

    public boolean c(Class<?> cls, boolean z5) {
        return d(cls) || e(cls, z5);
    }

    public boolean f(Field field, boolean z5) {
        r2.a aVar;
        if ((this.f9242b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f9241a != -1.0d && !m((r2.d) field.getAnnotation(r2.d.class), (r2.e) field.getAnnotation(r2.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f9244d && ((aVar = (r2.a) field.getAnnotation(r2.a.class)) == null || (!z5 ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.f9243c && h(field.getType())) || g(field.getType())) {
            return true;
        }
        List<q2.a> list = z5 ? this.f9245e : this.f9246j;
        if (list.isEmpty()) {
            return false;
        }
        q2.b bVar = new q2.b(field);
        Iterator<q2.a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().b(bVar)) {
                return true;
            }
        }
        return false;
    }
}
