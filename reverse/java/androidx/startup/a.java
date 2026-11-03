package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import s.c;
import t.b;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f1436d;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f1437e = new Object();

    /* renamed from: c, reason: collision with root package name */
    final Context f1440c;

    /* renamed from: b, reason: collision with root package name */
    final Set<Class<? extends s.a<?>>> f1439b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    final Map<Class<?>, Object> f1438a = new HashMap();

    a(Context context) {
        this.f1440c = context.getApplicationContext();
    }

    public static a c(Context context) {
        if (f1436d == null) {
            synchronized (f1437e) {
                if (f1436d == null) {
                    f1436d = new a(context);
                }
            }
        }
        return f1436d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void a() {
        try {
            try {
                b.c("Startup");
                Bundle bundle = this.f1440c.getPackageManager().getProviderInfo(new ComponentName(this.f1440c.getPackageName(), InitializationProvider.class.getName()), 128).metaData;
                String string = this.f1440c.getString(s.b.f9178a);
                if (bundle != null) {
                    HashSet hashSet = new HashSet();
                    for (String str : bundle.keySet()) {
                        if (string.equals(bundle.getString(str, null))) {
                            Class<?> cls = Class.forName(str);
                            if (s.a.class.isAssignableFrom(cls)) {
                                this.f1439b.add(cls);
                                b(cls, hashSet);
                            }
                        }
                    }
                }
            } finally {
                b.f();
            }
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException e6) {
            throw new c(e6);
        }
    }

    <T> T b(Class<? extends s.a<?>> cls, Set<Class<?>> set) {
        T t5;
        synchronized (f1437e) {
            if (b.h()) {
                try {
                    b.c(cls.getSimpleName());
                } finally {
                    b.f();
                }
            }
            if (set.contains(cls)) {
                throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
            }
            if (this.f1438a.containsKey(cls)) {
                t5 = (T) this.f1438a.get(cls);
            } else {
                set.add(cls);
                try {
                    s.a<?> newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    List<Class<? extends s.a<?>>> a6 = newInstance.a();
                    if (!a6.isEmpty()) {
                        for (Class<? extends s.a<?>> cls2 : a6) {
                            if (!this.f1438a.containsKey(cls2)) {
                                b(cls2, set);
                            }
                        }
                    }
                    t5 = (T) newInstance.b(this.f1440c);
                    set.remove(cls);
                    this.f1438a.put(cls, t5);
                } catch (Throwable th) {
                    throw new c(th);
                }
            }
        }
        return t5;
    }
}
