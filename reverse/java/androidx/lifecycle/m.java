package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Class<?>, Integer> f887a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Map<Class<?>, List<Constructor<? extends c>>> f888b = new HashMap();

    private static c a(Constructor<? extends c> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException(e6);
        } catch (InstantiationException e7) {
            throw new RuntimeException(e7);
        } catch (InvocationTargetException e8) {
            throw new RuntimeException(e8);
        }
    }

    private static Constructor<? extends c> b(Class<?> cls) {
        try {
            Package r02 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r02 != null ? r02.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String c6 = c(canonicalName);
            if (!name.isEmpty()) {
                c6 = name + "." + c6;
            }
            Constructor declaredConstructor = Class.forName(c6).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException(e6);
        }
    }

    public static String c(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    private static int d(Class<?> cls) {
        Integer num = f887a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int g6 = g(cls);
        f887a.put(cls, Integer.valueOf(g6));
        return g6;
    }

    private static boolean e(Class<?> cls) {
        return cls != null && h.class.isAssignableFrom(cls);
    }

    static g f(Object obj) {
        boolean z5 = obj instanceof g;
        boolean z6 = obj instanceof b;
        if (z5 && z6) {
            return new FullLifecycleObserverAdapter((b) obj, (g) obj);
        }
        if (z6) {
            return new FullLifecycleObserverAdapter((b) obj, null);
        }
        if (z5) {
            return (g) obj;
        }
        Class<?> cls = obj.getClass();
        if (d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List<Constructor<? extends c>> list = f888b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a(list.get(0), obj));
        }
        c[] cVarArr = new c[list.size()];
        for (int i6 = 0; i6 < list.size(); i6++) {
            cVarArr[i6] = a(list.get(i6), obj);
        }
        return new CompositeGeneratedAdaptersObserver(cVarArr);
    }

    private static int g(Class<?> cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends c> b6 = b(cls);
        if (b6 != null) {
            f888b.put(cls, Collections.singletonList(b6));
            return 2;
        }
        if (a.f860c.d(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (!e(superclass)) {
            arrayList = null;
        } else {
            if (d(superclass) == 1) {
                return 1;
            }
            arrayList = new ArrayList(f888b.get(superclass));
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (e(cls2)) {
                if (d(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(f888b.get(cls2));
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f888b.put(cls, arrayList);
        return 2;
    }
}
