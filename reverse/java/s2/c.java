package s2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import q2.u;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Type, q2.g<?>> f9218a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f9219b;

    /* renamed from: c, reason: collision with root package name */
    private final List<u> f9220c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> implements s2.i<T> {
        a() {
        }

        @Override // s2.i
        public T a() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> implements s2.i<T> {
        b() {
        }

        @Override // s2.i
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: s2.c$c, reason: collision with other inner class name */
    class C0140c<T> implements s2.i<T> {
        C0140c() {
        }

        @Override // s2.i
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class d<T> implements s2.i<T> {
        d() {
        }

        @Override // s2.i
        public T a() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class e<T> implements s2.i<T> {
        e() {
        }

        @Override // s2.i
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class f<T> implements s2.i<T> {
        f() {
        }

        @Override // s2.i
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class g<T> implements s2.i<T> {
        g() {
        }

        @Override // s2.i
        public T a() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class h<T> implements s2.i<T> {
        h() {
        }

        @Override // s2.i
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class i<T> implements s2.i<T> {
        i() {
        }

        @Override // s2.i
        public T a() {
            return (T) new s2.h();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class j<T> implements s2.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f9221a;

        j(Class cls) {
            this.f9221a = cls;
        }

        @Override // s2.i
        public T a() {
            try {
                return (T) s2.n.f9288a.d(this.f9221a);
            } catch (Exception e6) {
                throw new RuntimeException("Unable to create instance of " + this.f9221a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e6);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class k<T> implements s2.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q2.g f9223a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f9224b;

        k(q2.g gVar, Type type) {
            this.f9223a = gVar;
            this.f9224b = type;
        }

        @Override // s2.i
        public T a() {
            return (T) this.f9223a.a(this.f9224b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class l<T> implements s2.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9226a;

        l(String str) {
            this.f9226a = str;
        }

        @Override // s2.i
        public T a() {
            throw new q2.l(this.f9226a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class m<T> implements s2.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q2.g f9228a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f9229b;

        m(q2.g gVar, Type type) {
            this.f9228a = gVar;
            this.f9229b = type;
        }

        @Override // s2.i
        public T a() {
            return (T) this.f9228a.a(this.f9229b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class n<T> implements s2.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9231a;

        n(String str) {
            this.f9231a = str;
        }

        @Override // s2.i
        public T a() {
            throw new q2.l(this.f9231a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class o<T> implements s2.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9233a;

        o(String str) {
            this.f9233a = str;
        }

        @Override // s2.i
        public T a() {
            throw new q2.l(this.f9233a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class p<T> implements s2.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f9235a;

        p(Type type) {
            this.f9235a = type;
        }

        @Override // s2.i
        public T a() {
            Type type = this.f9235a;
            if (!(type instanceof ParameterizedType)) {
                throw new q2.l("Invalid EnumSet type: " + this.f9235a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new q2.l("Invalid EnumSet type: " + this.f9235a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class q<T> implements s2.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f9236a;

        q(Type type) {
            this.f9236a = type;
        }

        @Override // s2.i
        public T a() {
            Type type = this.f9236a;
            if (!(type instanceof ParameterizedType)) {
                throw new q2.l("Invalid EnumMap type: " + this.f9236a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) new EnumMap((Class) type2);
            }
            throw new q2.l("Invalid EnumMap type: " + this.f9236a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class r<T> implements s2.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9237a;

        r(String str) {
            this.f9237a = str;
        }

        @Override // s2.i
        public T a() {
            throw new q2.l(this.f9237a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class s<T> implements s2.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9238a;

        s(String str) {
            this.f9238a = str;
        }

        @Override // s2.i
        public T a() {
            throw new q2.l(this.f9238a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class t<T> implements s2.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f9239a;

        t(Constructor constructor) {
            this.f9239a = constructor;
        }

        @Override // s2.i
        public T a() {
            try {
                return (T) this.f9239a.newInstance(new Object[0]);
            } catch (IllegalAccessException e6) {
                throw v2.a.e(e6);
            } catch (InstantiationException e7) {
                throw new RuntimeException("Failed to invoke constructor '" + v2.a.c(this.f9239a) + "' with no args", e7);
            } catch (InvocationTargetException e8) {
                throw new RuntimeException("Failed to invoke constructor '" + v2.a.c(this.f9239a) + "' with no args", e8.getCause());
            }
        }
    }

    public c(Map<Type, q2.g<?>> map, boolean z5, List<u> list) {
        this.f9218a = map;
        this.f9219b = z5;
        this.f9220c = list;
    }

    static String a(Class<?> cls) {
        StringBuilder sb;
        String str;
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            sb = new StringBuilder();
            str = "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ";
        } else {
            if (!Modifier.isAbstract(modifiers)) {
                return null;
            }
            sb = new StringBuilder();
            str = "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ";
        }
        sb.append(str);
        sb.append(cls.getName());
        return sb.toString();
    }

    private static <T> s2.i<T> c(Class<? super T> cls, u.a aVar) {
        String l6;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        boolean z5 = false;
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            u.a aVar2 = u.a.ALLOW;
            if (aVar == aVar2 || (s2.l.a(declaredConstructor, null) && (aVar != u.a.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                z5 = true;
            }
            if (z5) {
                return (aVar != aVar2 || (l6 = v2.a.l(declaredConstructor)) == null) ? new t(declaredConstructor) : new s(l6);
            }
            return new r("Unable to invoke no-args constructor of " + cls + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static <T> s2.i<T> d(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new a() : Set.class.isAssignableFrom(cls) ? new b() : Queue.class.isAssignableFrom(cls) ? new C0140c() : new d();
        }
        if (Map.class.isAssignableFrom(cls)) {
            return ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new e() : ConcurrentMap.class.isAssignableFrom(cls) ? new f() : SortedMap.class.isAssignableFrom(cls) ? new g() : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(x2.a.b(((ParameterizedType) type).getActualTypeArguments()[0]).c())) ? new i() : new h();
        }
        return null;
    }

    private static <T> s2.i<T> e(Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new p(type);
        }
        if (cls == EnumMap.class) {
            return new q(type);
        }
        return null;
    }

    private <T> s2.i<T> f(Class<? super T> cls) {
        if (this.f9219b) {
            return new j(cls);
        }
        return new l("Unable to create instance of " + cls + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public <T> s2.i<T> b(x2.a<T> aVar) {
        Type d6 = aVar.d();
        Class<? super T> c6 = aVar.c();
        q2.g<?> gVar = this.f9218a.get(d6);
        if (gVar != null) {
            return new k(gVar, d6);
        }
        q2.g<?> gVar2 = this.f9218a.get(c6);
        if (gVar2 != null) {
            return new m(gVar2, d6);
        }
        s2.i<T> e6 = e(d6, c6);
        if (e6 != null) {
            return e6;
        }
        u.a b6 = s2.l.b(this.f9220c, c6);
        s2.i<T> c7 = c(c6, b6);
        if (c7 != null) {
            return c7;
        }
        s2.i<T> d7 = d(d6, c6);
        if (d7 != null) {
            return d7;
        }
        String a6 = a(c6);
        if (a6 != null) {
            return new n(a6);
        }
        if (b6 == u.a.ALLOW) {
            return f(c6);
        }
        return new o("Unable to create instance of " + c6 + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    }

    public String toString() {
        return this.f9218a.toString();
    }
}
