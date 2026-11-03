package com.tendcloud.tenddata;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
final class ad {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Map<Class<?>, Set<Method>>> f2254a = new ConcurrentHashMap();

    private ad() {
    }

    static Map<Class<?>, Set<ae>> a(Object obj) {
        HashMap hashMap = new HashMap();
        try {
            Class<?> cls = obj.getClass();
            Map<Class<?>, Map<Class<?>, Set<Method>>> map = f2254a;
            if (!map.containsKey(cls)) {
                a(cls);
            }
            Map<Class<?>, Set<Method>> map2 = map.get(cls);
            if (map2 != null && !map2.isEmpty()) {
                for (Map.Entry<Class<?>, Set<Method>> entry : map2.entrySet()) {
                    HashSet hashSet = new HashSet();
                    Iterator<Method> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        hashSet.add(new ae(obj, it.next()));
                    }
                    hashMap.put(entry.getKey(), hashSet);
                }
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
        return hashMap;
    }

    private static void a(Class<?> cls) {
        try {
            Map<Class<?>, Set<Method>> hashMap = new HashMap<>();
            for (Method method : cls.getDeclaredMethods()) {
                if (method.getName().startsWith("onTDEBEvent") && method.getParameterTypes().length == 1) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != 1) {
                        h.eForInternal("Method " + method + " must have one and only one argument.");
                    }
                    Class<?> cls2 = parameterTypes[0];
                    if (cls2.isInterface()) {
                        h.eForInternal("Method " + method + " must have a argument whose type is a class which can be instantialized.");
                    }
                    if ((method.getModifiers() & 1) == 0) {
                        h.eForInternal("Method " + method + " must be 'public'.");
                    }
                    Set<Method> set = hashMap.get(cls2);
                    if (set == null) {
                        set = new HashSet<>();
                        hashMap.put(cls2, set);
                    }
                    set.add(method);
                }
            }
            f2254a.put(cls, hashMap);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }
}
