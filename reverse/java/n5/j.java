package n5;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: d, reason: collision with root package name */
    public static final a f8290d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Method f8291a;

    /* renamed from: b, reason: collision with root package name */
    private final Method f8292b;

    /* renamed from: c, reason: collision with root package name */
    private final Method f8293c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final j a() {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod("get", new Class[0]);
                method3 = cls.getMethod("open", String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new j(method, method3, method2);
        }
    }

    public j(Method method, Method method2, Method method3) {
        this.f8291a = method;
        this.f8292b = method2;
        this.f8293c = method3;
    }

    public final Object a(String closer) {
        kotlin.jvm.internal.k.e(closer, "closer");
        Method method = this.f8291a;
        if (method != null) {
            try {
                Object invoke = method.invoke(null, new Object[0]);
                Method method2 = this.f8292b;
                kotlin.jvm.internal.k.b(method2);
                method2.invoke(invoke, closer);
                return invoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Method method = this.f8293c;
            kotlin.jvm.internal.k.b(method);
            method.invoke(obj, new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
