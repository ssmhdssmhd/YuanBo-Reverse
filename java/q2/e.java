package q2;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes.dex */
public final class e {
    static final q2.d A = q2.c.f8852a;
    static final w B = v.f8923a;
    static final w C = v.f8924b;

    /* renamed from: z, reason: collision with root package name */
    static final String f8860z = null;

    /* renamed from: a, reason: collision with root package name */
    private final ThreadLocal<Map<x2.a<?>, f<?>>> f8861a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentMap<x2.a<?>, x<?>> f8862b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final s2.c f8863c;

    /* renamed from: d, reason: collision with root package name */
    private final t2.e f8864d;

    /* renamed from: e, reason: collision with root package name */
    final List<y> f8865e;

    /* renamed from: f, reason: collision with root package name */
    final s2.d f8866f;

    /* renamed from: g, reason: collision with root package name */
    final q2.d f8867g;

    /* renamed from: h, reason: collision with root package name */
    final Map<Type, g<?>> f8868h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f8869i;

    /* renamed from: j, reason: collision with root package name */
    final boolean f8870j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f8871k;

    /* renamed from: l, reason: collision with root package name */
    final boolean f8872l;

    /* renamed from: m, reason: collision with root package name */
    final boolean f8873m;

    /* renamed from: n, reason: collision with root package name */
    final boolean f8874n;

    /* renamed from: o, reason: collision with root package name */
    final boolean f8875o;

    /* renamed from: p, reason: collision with root package name */
    final boolean f8876p;

    /* renamed from: q, reason: collision with root package name */
    final String f8877q;

    /* renamed from: r, reason: collision with root package name */
    final int f8878r;

    /* renamed from: s, reason: collision with root package name */
    final int f8879s;

    /* renamed from: t, reason: collision with root package name */
    final t f8880t;

    /* renamed from: u, reason: collision with root package name */
    final List<y> f8881u;

    /* renamed from: v, reason: collision with root package name */
    final List<y> f8882v;

    /* renamed from: w, reason: collision with root package name */
    final w f8883w;

    /* renamed from: x, reason: collision with root package name */
    final w f8884x;

    /* renamed from: y, reason: collision with root package name */
    final List<u> f8885y;

    class a extends x<Number> {
        a() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Double b(y2.a aVar) {
            if (aVar.g0() != y2.b.NULL) {
                return Double.valueOf(aVar.X());
            }
            aVar.c0();
            return null;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Number number) {
            if (number == null) {
                cVar.V();
                return;
            }
            double doubleValue = number.doubleValue();
            e.d(doubleValue);
            cVar.f0(doubleValue);
        }
    }

    class b extends x<Number> {
        b() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Float b(y2.a aVar) {
            if (aVar.g0() != y2.b.NULL) {
                return Float.valueOf((float) aVar.X());
            }
            aVar.c0();
            return null;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Number number) {
            if (number == null) {
                cVar.V();
                return;
            }
            float floatValue = number.floatValue();
            e.d(floatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(floatValue);
            }
            cVar.i0(number);
        }
    }

    class c extends x<Number> {
        c() {
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(y2.a aVar) {
            if (aVar.g0() != y2.b.NULL) {
                return Long.valueOf(aVar.Z());
            }
            aVar.c0();
            return null;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, Number number) {
            if (number == null) {
                cVar.V();
            } else {
                cVar.j0(number.toString());
            }
        }
    }

    class d extends x<AtomicLong> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f8888a;

        d(x xVar) {
            this.f8888a = xVar;
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLong b(y2.a aVar) {
            return new AtomicLong(((Number) this.f8888a.b(aVar)).longValue());
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, AtomicLong atomicLong) {
            this.f8888a.d(cVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* renamed from: q2.e$e, reason: collision with other inner class name */
    class C0132e extends x<AtomicLongArray> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f8889a;

        C0132e(x xVar) {
            this.f8889a = xVar;
        }

        @Override // q2.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray b(y2.a aVar) {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.K()) {
                arrayList.add(Long.valueOf(((Number) this.f8889a.b(aVar)).longValue()));
            }
            aVar.t();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i6 = 0; i6 < size; i6++) {
                atomicLongArray.set(i6, ((Long) arrayList.get(i6)).longValue());
            }
            return atomicLongArray;
        }

        @Override // q2.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(y2.c cVar, AtomicLongArray atomicLongArray) {
            cVar.k();
            int length = atomicLongArray.length();
            for (int i6 = 0; i6 < length; i6++) {
                this.f8889a.d(cVar, Long.valueOf(atomicLongArray.get(i6)));
            }
            cVar.t();
        }
    }

    static class f<T> extends t2.l<T> {

        /* renamed from: a, reason: collision with root package name */
        private x<T> f8890a;

        f() {
        }

        private x<T> f() {
            x<T> xVar = this.f8890a;
            if (xVar != null) {
                return xVar;
            }
            throw new IllegalStateException("Delegate has not been set yet");
        }

        @Override // q2.x
        public T b(y2.a aVar) {
            return f().b(aVar);
        }

        @Override // q2.x
        public void d(y2.c cVar, T t5) {
            f().d(cVar, t5);
        }

        @Override // t2.l
        public x<T> e() {
            return f();
        }

        public void g(x<T> xVar) {
            if (this.f8890a != null) {
                throw new AssertionError();
            }
            this.f8890a = xVar;
        }
    }

    e(s2.d dVar, q2.d dVar2, Map<Type, g<?>> map, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, t tVar, String str, int i6, int i7, List<y> list, List<y> list2, List<y> list3, w wVar, w wVar2, List<u> list4) {
        this.f8866f = dVar;
        this.f8867g = dVar2;
        this.f8868h = map;
        s2.c cVar = new s2.c(map, z12, list4);
        this.f8863c = cVar;
        this.f8869i = z5;
        this.f8870j = z6;
        this.f8871k = z7;
        this.f8872l = z8;
        this.f8873m = z9;
        this.f8874n = z10;
        this.f8875o = z11;
        this.f8876p = z12;
        this.f8880t = tVar;
        this.f8877q = str;
        this.f8878r = i6;
        this.f8879s = i7;
        this.f8881u = list;
        this.f8882v = list2;
        this.f8883w = wVar;
        this.f8884x = wVar2;
        this.f8885y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(t2.o.W);
        arrayList.add(t2.j.e(wVar));
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(t2.o.C);
        arrayList.add(t2.o.f9485m);
        arrayList.add(t2.o.f9479g);
        arrayList.add(t2.o.f9481i);
        arrayList.add(t2.o.f9483k);
        x<Number> n6 = n(tVar);
        arrayList.add(t2.o.a(Long.TYPE, Long.class, n6));
        arrayList.add(t2.o.a(Double.TYPE, Double.class, e(z11)));
        arrayList.add(t2.o.a(Float.TYPE, Float.class, f(z11)));
        arrayList.add(t2.i.e(wVar2));
        arrayList.add(t2.o.f9487o);
        arrayList.add(t2.o.f9489q);
        arrayList.add(t2.o.b(AtomicLong.class, b(n6)));
        arrayList.add(t2.o.b(AtomicLongArray.class, c(n6)));
        arrayList.add(t2.o.f9491s);
        arrayList.add(t2.o.f9496x);
        arrayList.add(t2.o.E);
        arrayList.add(t2.o.G);
        arrayList.add(t2.o.b(BigDecimal.class, t2.o.f9498z));
        arrayList.add(t2.o.b(BigInteger.class, t2.o.A));
        arrayList.add(t2.o.b(s2.g.class, t2.o.B));
        arrayList.add(t2.o.I);
        arrayList.add(t2.o.K);
        arrayList.add(t2.o.O);
        arrayList.add(t2.o.Q);
        arrayList.add(t2.o.U);
        arrayList.add(t2.o.M);
        arrayList.add(t2.o.f9476d);
        arrayList.add(t2.c.f9397b);
        arrayList.add(t2.o.S);
        if (w2.d.f10220a) {
            arrayList.add(w2.d.f10224e);
            arrayList.add(w2.d.f10223d);
            arrayList.add(w2.d.f10225f);
        }
        arrayList.add(t2.a.f9391c);
        arrayList.add(t2.o.f9474b);
        arrayList.add(new t2.b(cVar));
        arrayList.add(new t2.h(cVar, z6));
        t2.e eVar = new t2.e(cVar);
        this.f8864d = eVar;
        arrayList.add(eVar);
        arrayList.add(t2.o.X);
        arrayList.add(new t2.k(cVar, dVar2, dVar, eVar, list4));
        this.f8865e = Collections.unmodifiableList(arrayList);
    }

    private static void a(Object obj, y2.a aVar) {
        if (obj != null) {
            try {
                if (aVar.g0() == y2.b.END_DOCUMENT) {
                } else {
                    throw new s("JSON document was not fully consumed.");
                }
            } catch (y2.d e6) {
                throw new s(e6);
            } catch (IOException e7) {
                throw new l(e7);
            }
        }
    }

    private static x<AtomicLong> b(x<Number> xVar) {
        return new d(xVar).a();
    }

    private static x<AtomicLongArray> c(x<Number> xVar) {
        return new C0132e(xVar).a();
    }

    static void d(double d6) {
        if (Double.isNaN(d6) || Double.isInfinite(d6)) {
            throw new IllegalArgumentException(d6 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private x<Number> e(boolean z5) {
        return z5 ? t2.o.f9494v : new a();
    }

    private x<Number> f(boolean z5) {
        return z5 ? t2.o.f9493u : new b();
    }

    private static x<Number> n(t tVar) {
        return tVar == t.f8915a ? t2.o.f9492t : new c();
    }

    public <T> T g(Reader reader, x2.a<T> aVar) {
        y2.a o6 = o(reader);
        T t5 = (T) j(o6, aVar);
        a(t5, o6);
        return t5;
    }

    public <T> T h(String str, Class<T> cls) {
        return (T) s2.k.b(cls).cast(i(str, x2.a.a(cls)));
    }

    public <T> T i(String str, x2.a<T> aVar) {
        if (str == null) {
            return null;
        }
        return (T) g(new StringReader(str), aVar);
    }

    public <T> T j(y2.a aVar, x2.a<T> aVar2) {
        boolean M = aVar.M();
        boolean z5 = true;
        aVar.l0(true);
        try {
            try {
                try {
                    aVar.g0();
                    z5 = false;
                    return l(aVar2).b(aVar);
                } catch (IOException e6) {
                    throw new s(e6);
                } catch (AssertionError e7) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON 2.10): " + e7.getMessage());
                    assertionError.initCause(e7);
                    throw assertionError;
                }
            } catch (EOFException e8) {
                if (!z5) {
                    throw new s(e8);
                }
                aVar.l0(M);
                return null;
            } catch (IllegalStateException e9) {
                throw new s(e9);
            }
        } finally {
            aVar.l0(M);
        }
    }

    public <T> x<T> k(Class<T> cls) {
        return l(x2.a.a(cls));
    }

    public <T> x<T> l(x2.a<T> aVar) {
        boolean z5;
        Objects.requireNonNull(aVar, "type must not be null");
        x<T> xVar = (x) this.f8862b.get(aVar);
        if (xVar != null) {
            return xVar;
        }
        Map<x2.a<?>, f<?>> map = this.f8861a.get();
        if (map == null) {
            map = new HashMap<>();
            this.f8861a.set(map);
            z5 = true;
        } else {
            z5 = false;
        }
        f<?> fVar = map.get(aVar);
        if (fVar != null) {
            return fVar;
        }
        try {
            f<?> fVar2 = new f<>();
            map.put(aVar, fVar2);
            Iterator<y> it = this.f8865e.iterator();
            while (it.hasNext()) {
                x<T> a6 = it.next().a(this, aVar);
                if (a6 != null) {
                    x<T> xVar2 = (x) this.f8862b.putIfAbsent(aVar, a6);
                    if (xVar2 != null) {
                        a6 = xVar2;
                    }
                    fVar2.g(a6);
                    return a6;
                }
            }
            throw new IllegalArgumentException("GSON (2.10) cannot handle " + aVar);
        } finally {
            map.remove(aVar);
            if (z5) {
                this.f8861a.remove();
            }
        }
    }

    public <T> x<T> m(y yVar, x2.a<T> aVar) {
        if (!this.f8865e.contains(yVar)) {
            yVar = this.f8864d;
        }
        boolean z5 = false;
        for (y yVar2 : this.f8865e) {
            if (z5) {
                x<T> a6 = yVar2.a(this, aVar);
                if (a6 != null) {
                    return a6;
                }
            } else if (yVar2 == yVar) {
                z5 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public y2.a o(Reader reader) {
        y2.a aVar = new y2.a(reader);
        aVar.l0(this.f8874n);
        return aVar;
    }

    public y2.c p(Writer writer) {
        if (this.f8871k) {
            writer.write(")]}'\n");
        }
        y2.c cVar = new y2.c(writer);
        if (this.f8873m) {
            cVar.b0("  ");
        }
        cVar.a0(this.f8872l);
        cVar.c0(this.f8874n);
        cVar.d0(this.f8869i);
        return cVar;
    }

    public String q(Object obj) {
        return obj == null ? s(m.f8912a) : r(obj, obj.getClass());
    }

    public String r(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        t(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String s(k kVar) {
        StringWriter stringWriter = new StringWriter();
        v(kVar, stringWriter);
        return stringWriter.toString();
    }

    public void t(Object obj, Type type, Appendable appendable) {
        try {
            u(obj, type, p(s2.m.c(appendable)));
        } catch (IOException e6) {
            throw new l(e6);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f8869i + ",factories:" + this.f8865e + ",instanceCreators:" + this.f8863c + "}";
    }

    public void u(Object obj, Type type, y2.c cVar) {
        x l6 = l(x2.a.b(type));
        boolean I = cVar.I();
        cVar.c0(true);
        boolean F = cVar.F();
        cVar.a0(this.f8872l);
        boolean D = cVar.D();
        cVar.d0(this.f8869i);
        try {
            try {
                l6.d(cVar, obj);
            } catch (IOException e6) {
                throw new l(e6);
            } catch (AssertionError e7) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.10): " + e7.getMessage());
                assertionError.initCause(e7);
                throw assertionError;
            }
        } finally {
            cVar.c0(I);
            cVar.a0(F);
            cVar.d0(D);
        }
    }

    public void v(k kVar, Appendable appendable) {
        try {
            w(kVar, p(s2.m.c(appendable)));
        } catch (IOException e6) {
            throw new l(e6);
        }
    }

    public void w(k kVar, y2.c cVar) {
        boolean I = cVar.I();
        cVar.c0(true);
        boolean F = cVar.F();
        cVar.a0(this.f8872l);
        boolean D = cVar.D();
        cVar.d0(this.f8869i);
        try {
            try {
                s2.m.b(kVar, cVar);
            } catch (IOException e6) {
                throw new l(e6);
            } catch (AssertionError e7) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.10): " + e7.getMessage());
                assertionError.initCause(e7);
                throw assertionError;
            }
        } finally {
            cVar.c0(I);
            cVar.a0(F);
            cVar.d0(D);
        }
    }
}
