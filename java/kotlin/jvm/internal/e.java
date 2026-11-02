package kotlin.jvm.internal;

import f4.b0;
import f4.c0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import o4.w;

/* loaded from: classes.dex */
public final class e implements t4.c<Object>, d {

    /* renamed from: b, reason: collision with root package name */
    public static final a f7002b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends e4.c<?>>, Integer> f7003c;

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<String, String> f7004d;

    /* renamed from: e, reason: collision with root package name */
    private static final HashMap<String, String> f7005e;

    /* renamed from: j, reason: collision with root package name */
    private static final HashMap<String, String> f7006j;

    /* renamed from: k, reason: collision with root package name */
    private static final Map<String, String> f7007k;

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f7008a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x003d, code lost:
        
            if (r2 == null) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String a(java.lang.Class<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "jClass"
                kotlin.jvm.internal.k.e(r8, r0)
                boolean r0 = r8.isAnonymousClass()
                r1 = 0
                if (r0 == 0) goto Le
                goto Lb3
            Le:
                boolean r0 = r8.isLocalClass()
                if (r0 == 0) goto L69
                java.lang.String r0 = r8.getSimpleName()
                java.lang.reflect.Method r2 = r8.getEnclosingMethod()
                r3 = 2
                r4 = 36
                java.lang.String r5 = "name"
                if (r2 == 0) goto L43
                kotlin.jvm.internal.k.d(r0, r5)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r2 = r2.getName()
                r6.append(r2)
                r6.append(r4)
                java.lang.String r2 = r6.toString()
                java.lang.String r2 = v4.g.s0(r0, r2, r1, r3, r1)
                if (r2 != 0) goto L40
                goto L43
            L40:
                r1 = r2
                goto Lb3
            L43:
                java.lang.reflect.Constructor r8 = r8.getEnclosingConstructor()
                kotlin.jvm.internal.k.d(r0, r5)
                if (r8 == 0) goto L64
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r8 = r8.getName()
                r2.append(r8)
                r2.append(r4)
                java.lang.String r8 = r2.toString()
                java.lang.String r1 = v4.g.s0(r0, r8, r1, r3, r1)
                goto Lb3
            L64:
                java.lang.String r1 = v4.g.r0(r0, r4, r1, r3, r1)
                goto Lb3
            L69:
                boolean r0 = r8.isArray()
                if (r0 == 0) goto L9e
                java.lang.Class r8 = r8.getComponentType()
                boolean r0 = r8.isPrimitive()
                java.lang.String r2 = "Array"
                if (r0 == 0) goto L9b
                java.util.Map r0 = kotlin.jvm.internal.e.c()
                java.lang.String r8 = r8.getName()
                java.lang.Object r8 = r0.get(r8)
                java.lang.String r8 = (java.lang.String) r8
                if (r8 == 0) goto L9b
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r8)
                r0.append(r2)
                java.lang.String r8 = r0.toString()
                r1 = r8
            L9b:
                if (r1 != 0) goto Lb3
                goto L40
            L9e:
                java.util.Map r0 = kotlin.jvm.internal.e.c()
                java.lang.String r1 = r8.getName()
                java.lang.Object r0 = r0.get(r1)
                r1 = r0
                java.lang.String r1 = (java.lang.String) r1
                if (r1 != 0) goto Lb3
                java.lang.String r1 = r8.getSimpleName()
            Lb3:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.e.a.a(java.lang.Class):java.lang.String");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List h6;
        int n6;
        Map<Class<? extends e4.c<?>>, Integer> g6;
        int a6;
        String u02;
        String u03;
        int i6 = 0;
        h6 = f4.l.h(o4.a.class, o4.l.class, o4.p.class, o4.q.class, o4.r.class, o4.s.class, o4.t.class, o4.u.class, o4.v.class, w.class, o4.b.class, o4.c.class, o4.d.class, o4.e.class, o4.f.class, o4.g.class, o4.h.class, o4.i.class, o4.j.class, o4.k.class, o4.m.class, o4.n.class, o4.o.class);
        n6 = f4.m.n(h6, 10);
        ArrayList arrayList = new ArrayList(n6);
        for (Object obj : h6) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                f4.l.m();
            }
            arrayList.add(e4.n.a((Class) obj, Integer.valueOf(i6)));
            i6 = i7;
        }
        g6 = c0.g(arrayList);
        f7003c = g6;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f7004d = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f7005e = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        k.d(values, "primitiveFqNames.values");
        for (String kotlinName : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            k.d(kotlinName, "kotlinName");
            u03 = v4.q.u0(kotlinName, '.', null, 2, null);
            sb.append(u03);
            sb.append("CompanionObject");
            e4.j a7 = e4.n.a(sb.toString(), kotlinName + ".Companion");
            hashMap3.put(a7.c(), a7.d());
        }
        for (Map.Entry<Class<? extends e4.c<?>>, Integer> entry : f7003c.entrySet()) {
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f7006j = hashMap3;
        a6 = b0.a(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(a6);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            u02 = v4.q.u0((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key, u02);
        }
        f7007k = linkedHashMap;
    }

    public e(Class<?> jClass) {
        k.e(jClass, "jClass");
        this.f7008a = jClass;
    }

    @Override // t4.c
    public String a() {
        return f7002b.a(b());
    }

    @Override // kotlin.jvm.internal.d
    public Class<?> b() {
        return this.f7008a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && k.a(n4.a.a(this), n4.a.a((t4.c) obj));
    }

    public int hashCode() {
        return n4.a.a(this).hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
