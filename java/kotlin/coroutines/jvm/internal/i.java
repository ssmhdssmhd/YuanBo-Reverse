package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f6993a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static final a f6994b = new a(null, null, null);

    /* renamed from: c, reason: collision with root package name */
    private static a f6995c;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Method f6996a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f6997b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f6998c;

        public a(Method method, Method method2, Method method3) {
            this.f6996a = method;
            this.f6997b = method2;
            this.f6998c = method3;
        }
    }

    private i() {
    }

    private final a a(kotlin.coroutines.jvm.internal.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f6995c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f6994b;
            f6995c = aVar3;
            return aVar3;
        }
    }

    public final String b(kotlin.coroutines.jvm.internal.a continuation) {
        kotlin.jvm.internal.k.e(continuation, "continuation");
        a aVar = f6995c;
        if (aVar == null) {
            aVar = a(continuation);
        }
        if (aVar == f6994b) {
            return null;
        }
        Method method = aVar.f6996a;
        Object invoke = method != null ? method.invoke(continuation.getClass(), new Object[0]) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = aVar.f6997b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = aVar.f6998c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}
