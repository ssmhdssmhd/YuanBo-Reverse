package com.tendcloud.tenddata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    private static volatile z f2789a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, Set<ae>> f2790b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final ThreadLocal<ConcurrentLinkedQueue<a>> f2791c = new ThreadLocal<ConcurrentLinkedQueue<a>>() { // from class: com.tendcloud.tenddata.z.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ConcurrentLinkedQueue<a> initialValue() {
            return new ConcurrentLinkedQueue<>();
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private final ThreadLocal<Boolean> f2792d = new ThreadLocal<Boolean>() { // from class: com.tendcloud.tenddata.z.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private final Map<Class<?>, Set<Class<?>>> f2793e = new HashMap();

    static class a {
        final Object event;
        final ae handler;

        public a(Object obj, ae aeVar) {
            this.event = obj;
            this.handler = aeVar;
        }
    }

    private z() {
    }

    public static z a() {
        if (f2789a == null) {
            synchronized (z.class) {
                if (f2789a == null) {
                    f2789a = new z();
                }
            }
        }
        return f2789a;
    }

    private Set<Class<?>> c(Class<?> cls) {
        try {
            LinkedList linkedList = new LinkedList();
            HashSet hashSet = new HashSet();
            while (true) {
                linkedList.add(cls);
                while (!linkedList.isEmpty()) {
                    Class cls2 = (Class) linkedList.remove(0);
                    hashSet.add(cls2);
                    cls = cls2.getSuperclass();
                    if (cls != null) {
                        break;
                    }
                }
                return hashSet;
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
            return null;
        }
    }

    Set<ae> a(Class<?> cls) {
        try {
            return this.f2790b.get(cls);
        } catch (Throwable th) {
            bq.postSDKError(th);
            return null;
        }
    }

    protected void a(Object obj, ae aeVar) {
        try {
            this.f2791c.get().offer(new a(obj, aeVar));
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    Set<Class<?>> b(Class<?> cls) {
        try {
            Set<Class<?>> set = this.f2793e.get(cls);
            if (set != null) {
                return set;
            }
            Set<Class<?>> c6 = c(cls);
            this.f2793e.put(cls, c6);
            return c6;
        } catch (Throwable th) {
            bq.postSDKError(th);
            return null;
        }
    }

    protected void b() {
        try {
            if (this.f2792d.get().booleanValue()) {
                return;
            }
            this.f2792d.set(Boolean.TRUE);
            while (true) {
                a poll = this.f2791c.get().poll();
                if (poll == null) {
                    return;
                }
                if (poll.handler.a()) {
                    b(poll.event, poll.handler);
                }
            }
        } finally {
            this.f2792d.set(Boolean.FALSE);
        }
    }

    protected void b(Object obj, ae aeVar) {
        try {
            aeVar.handleEvent(obj);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public void post(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            Iterator<Class<?>> it = b(obj.getClass()).iterator();
            boolean z5 = false;
            while (it.hasNext()) {
                Set<ae> a6 = a(it.next());
                if (a6 != null && !a6.isEmpty()) {
                    Iterator<ae> it2 = a6.iterator();
                    while (it2.hasNext()) {
                        a(obj, it2.next());
                    }
                    z5 = true;
                }
            }
            if (!z5 && !(obj instanceof ag)) {
                post(new ag(this, obj));
            }
            b();
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public void register(Object obj) {
        Set<ae> putIfAbsent;
        if (obj == null) {
            return;
        }
        try {
            Map<Class<?>, Set<ae>> a6 = ad.a(obj);
            for (Class<?> cls : a6.keySet()) {
                Set<ae> set = this.f2790b.get(cls);
                if (set == null && (putIfAbsent = this.f2790b.putIfAbsent(cls, (set = new CopyOnWriteArraySet<>()))) != null) {
                    set = putIfAbsent;
                }
                if (!set.addAll(a6.get(cls))) {
                    return;
                }
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public void unregister(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            for (Map.Entry<Class<?>, Set<ae>> entry : ad.a(obj).entrySet()) {
                Set<ae> a6 = a(entry.getKey());
                Set<ae> value = entry.getValue();
                if (a6 != null && a6.containsAll(value)) {
                    for (ae aeVar : a6) {
                        if (value.contains(aeVar)) {
                            aeVar.b();
                        }
                    }
                    a6.removeAll(value);
                }
                return;
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }
}
