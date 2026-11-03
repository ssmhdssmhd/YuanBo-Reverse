package t2;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import q2.s;
import q2.u;
import q2.x;
import q2.y;

/* loaded from: classes.dex */
public final class k implements y {

    /* renamed from: a, reason: collision with root package name */
    private final s2.c f9431a;

    /* renamed from: b, reason: collision with root package name */
    private final q2.d f9432b;

    /* renamed from: c, reason: collision with root package name */
    private final s2.d f9433c;

    /* renamed from: d, reason: collision with root package name */
    private final t2.e f9434d;

    /* renamed from: e, reason: collision with root package name */
    private final List<u> f9435e;

    class a extends c {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f9436e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Method f9437f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Field f9438g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f9439h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ x f9440i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ q2.e f9441j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ x2.a f9442k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f9443l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f9444m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, String str2, boolean z5, boolean z6, boolean z7, Method method, Field field, boolean z8, x xVar, q2.e eVar, x2.a aVar, boolean z9, boolean z10) {
            super(str, str2, z5, z6);
            this.f9436e = z7;
            this.f9437f = method;
            this.f9438g = field;
            this.f9439h = z8;
            this.f9440i = xVar;
            this.f9441j = eVar;
            this.f9442k = aVar;
            this.f9443l = z9;
            this.f9444m = z10;
        }

        @Override // t2.k.c
        void a(y2.a aVar, int i6, Object[] objArr) {
            Object b6 = this.f9440i.b(aVar);
            if (b6 != null || !this.f9443l) {
                objArr[i6] = b6;
                return;
            }
            throw new q2.o("null is not allowed as value for record component '" + this.f9448b + "' of primitive type; at path " + aVar.z());
        }

        @Override // t2.k.c
        void b(y2.a aVar, Object obj) {
            Object b6 = this.f9440i.b(aVar);
            if (b6 == null && this.f9443l) {
                return;
            }
            if (this.f9436e) {
                k.c(obj, this.f9438g);
            } else if (this.f9444m) {
                throw new q2.l("Cannot set value of 'static final' " + v2.a.f(this.f9438g, false));
            }
            this.f9438g.set(obj, b6);
        }

        @Override // t2.k.c
        void c(y2.c cVar, Object obj) {
            Object obj2;
            if (this.f9449c) {
                if (this.f9436e) {
                    AccessibleObject accessibleObject = this.f9437f;
                    if (accessibleObject == null) {
                        accessibleObject = this.f9438g;
                    }
                    k.c(obj, accessibleObject);
                }
                Method method = this.f9437f;
                if (method != null) {
                    try {
                        obj2 = method.invoke(obj, new Object[0]);
                    } catch (InvocationTargetException e6) {
                        throw new q2.l("Accessor " + v2.a.f(this.f9437f, false) + " threw exception", e6.getCause());
                    }
                } else {
                    obj2 = this.f9438g.get(obj);
                }
                if (obj2 == obj) {
                    return;
                }
                cVar.M(this.f9447a);
                (this.f9439h ? this.f9440i : new n(this.f9441j, this.f9440i, this.f9442k.d())).d(cVar, obj2);
            }
        }
    }

    public static abstract class b<T, A> extends x<T> {

        /* renamed from: a, reason: collision with root package name */
        final Map<String, c> f9446a;

        b(Map<String, c> map) {
            this.f9446a = map;
        }

        @Override // q2.x
        public T b(y2.a aVar) {
            if (aVar.g0() == y2.b.NULL) {
                aVar.c0();
                return null;
            }
            A e6 = e();
            try {
                aVar.j();
                while (aVar.K()) {
                    c cVar = this.f9446a.get(aVar.a0());
                    if (cVar != null && cVar.f9450d) {
                        g(e6, aVar, cVar);
                    }
                    aVar.q0();
                }
                aVar.v();
                return f(e6);
            } catch (IllegalAccessException e7) {
                throw v2.a.e(e7);
            } catch (IllegalStateException e8) {
                throw new s(e8);
            }
        }

        @Override // q2.x
        public void d(y2.c cVar, T t5) {
            if (t5 == null) {
                cVar.V();
                return;
            }
            cVar.q();
            try {
                Iterator<c> it = this.f9446a.values().iterator();
                while (it.hasNext()) {
                    it.next().c(cVar, t5);
                }
                cVar.v();
            } catch (IllegalAccessException e6) {
                throw v2.a.e(e6);
            }
        }

        abstract A e();

        abstract T f(A a6);

        abstract void g(A a6, y2.a aVar, c cVar);
    }

    static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final String f9447a;

        /* renamed from: b, reason: collision with root package name */
        final String f9448b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f9449c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f9450d;

        protected c(String str, String str2, boolean z5, boolean z6) {
            this.f9447a = str;
            this.f9448b = str2;
            this.f9449c = z5;
            this.f9450d = z6;
        }

        abstract void a(y2.a aVar, int i6, Object[] objArr);

        abstract void b(y2.a aVar, Object obj);

        abstract void c(y2.c cVar, Object obj);
    }

    private static final class d<T> extends b<T, T> {

        /* renamed from: b, reason: collision with root package name */
        private final s2.i<T> f9451b;

        d(s2.i<T> iVar, Map<String, c> map) {
            super(map);
            this.f9451b = iVar;
        }

        @Override // t2.k.b
        T e() {
            return this.f9451b.a();
        }

        @Override // t2.k.b
        T f(T t5) {
            return t5;
        }

        @Override // t2.k.b
        void g(T t5, y2.a aVar, c cVar) {
            cVar.b(aVar, t5);
        }
    }

    private static final class e<T> extends b<T, Object[]> {

        /* renamed from: e, reason: collision with root package name */
        static final Map<Class<?>, Object> f9452e = j();

        /* renamed from: b, reason: collision with root package name */
        private final Constructor<T> f9453b;

        /* renamed from: c, reason: collision with root package name */
        private final Object[] f9454c;

        /* renamed from: d, reason: collision with root package name */
        private final Map<String, Integer> f9455d;

        e(Class<T> cls, Map<String, c> map, boolean z5) {
            super(map);
            this.f9455d = new HashMap();
            Constructor<T> h6 = v2.a.h(cls);
            this.f9453b = h6;
            if (z5) {
                k.c(null, h6);
            } else {
                v2.a.k(h6);
            }
            String[] i6 = v2.a.i(cls);
            for (int i7 = 0; i7 < i6.length; i7++) {
                this.f9455d.put(i6[i7], Integer.valueOf(i7));
            }
            Class<?>[] parameterTypes = this.f9453b.getParameterTypes();
            this.f9454c = new Object[parameterTypes.length];
            for (int i8 = 0; i8 < parameterTypes.length; i8++) {
                this.f9454c[i8] = f9452e.get(parameterTypes[i8]);
            }
        }

        private static Map<Class<?>, Object> j() {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, Double.valueOf(0.0d));
            hashMap.put(Character.TYPE, (char) 0);
            hashMap.put(Boolean.TYPE, Boolean.FALSE);
            return hashMap;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // t2.k.b
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Object[] e() {
            return (Object[]) this.f9454c.clone();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // t2.k.b
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public T f(Object[] objArr) {
            try {
                return this.f9453b.newInstance(objArr);
            } catch (IllegalAccessException e6) {
                throw v2.a.e(e6);
            } catch (IllegalArgumentException e7) {
                e = e7;
                throw new RuntimeException("Failed to invoke constructor '" + v2.a.c(this.f9453b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e8) {
                e = e8;
                throw new RuntimeException("Failed to invoke constructor '" + v2.a.c(this.f9453b) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e9) {
                throw new RuntimeException("Failed to invoke constructor '" + v2.a.c(this.f9453b) + "' with args " + Arrays.toString(objArr), e9.getCause());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // t2.k.b
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public void g(Object[] objArr, y2.a aVar, c cVar) {
            Integer num = this.f9455d.get(cVar.f9448b);
            if (num != null) {
                cVar.a(aVar, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + v2.a.c(this.f9453b) + "' for field with name '" + cVar.f9448b + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public k(s2.c cVar, q2.d dVar, s2.d dVar2, t2.e eVar, List<u> list) {
        this.f9431a = cVar;
        this.f9432b = dVar;
        this.f9433c = dVar2;
        this.f9434d = eVar;
        this.f9435e = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <M extends AccessibleObject & Member> void c(Object obj, M m6) {
        if (Modifier.isStatic(m6.getModifiers())) {
            obj = null;
        }
        if (s2.l.a(m6, obj)) {
            return;
        }
        throw new q2.l(v2.a.f(m6, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private c d(q2.e eVar, Field field, Method method, String str, x2.a<?> aVar, boolean z5, boolean z6, boolean z7) {
        boolean a6 = s2.k.a(aVar.c());
        int modifiers = field.getModifiers();
        boolean z8 = Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers);
        r2.b bVar = (r2.b) field.getAnnotation(r2.b.class);
        x<?> b6 = bVar != null ? this.f9434d.b(this.f9431a, eVar, aVar, bVar) : null;
        boolean z9 = b6 != null;
        if (b6 == null) {
            b6 = eVar.l(aVar);
        }
        return new a(str, field.getName(), z5, z6, z7, method, field, z9, b6, eVar, aVar, a6, z8);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0160 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0152 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.Map<java.lang.String, t2.k.c> e(q2.e r29, x2.a<?> r30, java.lang.Class<?> r31, boolean r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.k.e(q2.e, x2.a, java.lang.Class, boolean, boolean):java.util.Map");
    }

    private List<String> f(Field field) {
        r2.c cVar = (r2.c) field.getAnnotation(r2.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.f9432b.a(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        Collections.addAll(arrayList, alternate);
        return arrayList;
    }

    private boolean g(Field field, boolean z5) {
        return (this.f9433c.c(field.getType(), z5) || this.f9433c.f(field, z5)) ? false : true;
    }

    @Override // q2.y
    public <T> x<T> a(q2.e eVar, x2.a<T> aVar) {
        Class<? super T> c6 = aVar.c();
        if (!Object.class.isAssignableFrom(c6)) {
            return null;
        }
        u.a b6 = s2.l.b(this.f9435e, c6);
        if (b6 != u.a.BLOCK_ALL) {
            boolean z5 = b6 == u.a.BLOCK_INACCESSIBLE;
            return v2.a.j(c6) ? new e(c6, e(eVar, aVar, c6, z5, true), z5) : new d(this.f9431a.b(aVar), e(eVar, aVar, c6, z5, false));
        }
        throw new q2.l("ReflectionAccessFilter does not permit using reflection for " + c6 + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
