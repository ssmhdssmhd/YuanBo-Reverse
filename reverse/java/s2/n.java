package s2;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f9288a = c();

    class a extends n {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f9289b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f9290c;

        a(Method method, Object obj) {
            this.f9289b = method;
            this.f9290c = obj;
        }

        @Override // s2.n
        public <T> T d(Class<T> cls) {
            n.b(cls);
            return (T) this.f9289b.invoke(this.f9290c, cls);
        }
    }

    class b extends n {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f9291b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f9292c;

        b(Method method, int i6) {
            this.f9291b = method;
            this.f9292c = i6;
        }

        @Override // s2.n
        public <T> T d(Class<T> cls) {
            n.b(cls);
            return (T) this.f9291b.invoke(null, cls, Integer.valueOf(this.f9292c));
        }
    }

    class c extends n {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f9293b;

        c(Method method) {
            this.f9293b = method;
        }

        @Override // s2.n
        public <T> T d(Class<T> cls) {
            n.b(cls);
            return (T) this.f9293b.invoke(null, cls, Object.class);
        }
    }

    class d extends n {
        d() {
        }

        @Override // s2.n
        public <T> T d(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Class<?> cls) {
        String a6 = s2.c.a(cls);
        if (a6 == null) {
            return;
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + a6);
    }

    private static n c() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, intValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                }
            } catch (Exception unused3) {
                return new d();
            }
        }
    }

    public abstract <T> T d(Class<T> cls);
}
