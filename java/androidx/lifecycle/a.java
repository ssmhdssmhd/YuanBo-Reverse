package androidx.lifecycle;

import androidx.lifecycle.d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
final class a {

    /* renamed from: c, reason: collision with root package name */
    static a f860c = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, C0016a> f861a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, Boolean> f862b = new HashMap();

    @Deprecated
    /* renamed from: androidx.lifecycle.a$a, reason: collision with other inner class name */
    static class C0016a {

        /* renamed from: a, reason: collision with root package name */
        final Map<d.b, List<b>> f863a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        final Map<b, d.b> f864b;

        C0016a(Map<b, d.b> map) {
            this.f864b = map;
            for (Map.Entry<b, d.b> entry : map.entrySet()) {
                d.b value = entry.getValue();
                List<b> list = this.f863a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f863a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void b(List<b> list, i iVar, d.b bVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(iVar, bVar, obj);
                }
            }
        }

        void a(i iVar, d.b bVar, Object obj) {
            b(this.f863a.get(bVar), iVar, bVar, obj);
            b(this.f863a.get(d.b.ON_ANY), iVar, bVar, obj);
        }
    }

    @Deprecated
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        final int f865a;

        /* renamed from: b, reason: collision with root package name */
        final Method f866b;

        b(int i6, Method method) {
            this.f865a = i6;
            this.f866b = method;
            method.setAccessible(true);
        }

        void a(i iVar, d.b bVar, Object obj) {
            try {
                int i6 = this.f865a;
                if (i6 == 0) {
                    this.f866b.invoke(obj, new Object[0]);
                } else if (i6 == 1) {
                    this.f866b.invoke(obj, iVar);
                } else {
                    if (i6 != 2) {
                        return;
                    }
                    this.f866b.invoke(obj, iVar, bVar);
                }
            } catch (IllegalAccessException e6) {
                throw new RuntimeException(e6);
            } catch (InvocationTargetException e7) {
                throw new RuntimeException("Failed to call observer method", e7.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f865a == bVar.f865a && this.f866b.getName().equals(bVar.f866b.getName());
        }

        public int hashCode() {
            return (this.f865a * 31) + this.f866b.getName().hashCode();
        }
    }

    a() {
    }

    private C0016a a(Class<?> cls, Method[] methodArr) {
        int i6;
        C0016a c6;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c6 = c(superclass)) != null) {
            hashMap.putAll(c6.f864b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, d.b> entry : c(cls2).f864b.entrySet()) {
                e(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z5 = false;
        for (Method method : methodArr) {
            r rVar = (r) method.getAnnotation(r.class);
            if (rVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i6 = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(i.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i6 = 1;
                }
                d.b value = rVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(d.b.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != d.b.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i6 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(hashMap, new b(i6, method), value, cls);
                z5 = true;
            }
        }
        C0016a c0016a = new C0016a(hashMap);
        this.f861a.put(cls, c0016a);
        this.f862b.put(cls, Boolean.valueOf(z5));
        return c0016a;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e6) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e6);
        }
    }

    private void e(Map<b, d.b> map, b bVar, d.b bVar2, Class<?> cls) {
        d.b bVar3 = map.get(bVar);
        if (bVar3 == null || bVar2 == bVar3) {
            if (bVar3 == null) {
                map.put(bVar, bVar2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f866b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + bVar3 + ", new value " + bVar2);
    }

    C0016a c(Class<?> cls) {
        C0016a c0016a = this.f861a.get(cls);
        return c0016a != null ? c0016a : a(cls, null);
    }

    boolean d(Class<?> cls) {
        Boolean bool = this.f862b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b6 = b(cls);
        for (Method method : b6) {
            if (((r) method.getAnnotation(r.class)) != null) {
                a(cls, b6);
                return true;
            }
        }
        this.f862b.put(cls, Boolean.FALSE);
        return false;
    }
}
