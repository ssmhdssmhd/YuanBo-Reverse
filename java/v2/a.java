package v2;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import q2.l;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final b f9874a;

    private static abstract class b {
        private b() {
        }

        public abstract Method a(Class<?> cls, Field field);

        abstract <T> Constructor<T> b(Class<T> cls);

        abstract String[] c(Class<?> cls);

        abstract boolean d(Class<?> cls);
    }

    private static class c extends b {
        private c() {
            super();
        }

        @Override // v2.a.b
        public Method a(Class<?> cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // v2.a.b
        <T> Constructor<T> b(Class<T> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // v2.a.b
        String[] c(Class<?> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // v2.a.b
        boolean d(Class<?> cls) {
            return false;
        }
    }

    private static class d extends b {

        /* renamed from: a, reason: collision with root package name */
        private final Method f9875a;

        /* renamed from: b, reason: collision with root package name */
        private final Method f9876b;

        /* renamed from: c, reason: collision with root package name */
        private final Method f9877c;

        /* renamed from: d, reason: collision with root package name */
        private final Method f9878d;

        private d() {
            super();
            this.f9875a = Class.class.getMethod("isRecord", new Class[0]);
            Method method = Class.class.getMethod("getRecordComponents", new Class[0]);
            this.f9876b = method;
            Class<?> componentType = method.getReturnType().getComponentType();
            this.f9877c = componentType.getMethod("getName", new Class[0]);
            this.f9878d = componentType.getMethod("getType", new Class[0]);
        }

        @Override // v2.a.b
        public Method a(Class<?> cls, Field field) {
            try {
                return cls.getMethod(field.getName(), new Class[0]);
            } catch (ReflectiveOperationException e6) {
                throw a.d(e6);
            }
        }

        @Override // v2.a.b
        public <T> Constructor<T> b(Class<T> cls) {
            try {
                Object[] objArr = (Object[]) this.f9876b.invoke(cls, new Object[0]);
                Class<?>[] clsArr = new Class[objArr.length];
                for (int i6 = 0; i6 < objArr.length; i6++) {
                    clsArr[i6] = (Class) this.f9878d.invoke(objArr[i6], new Object[0]);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e6) {
                throw a.d(e6);
            }
        }

        @Override // v2.a.b
        String[] c(Class<?> cls) {
            try {
                Object[] objArr = (Object[]) this.f9876b.invoke(cls, new Object[0]);
                String[] strArr = new String[objArr.length];
                for (int i6 = 0; i6 < objArr.length; i6++) {
                    strArr[i6] = (String) this.f9877c.invoke(objArr[i6], new Object[0]);
                }
                return strArr;
            } catch (ReflectiveOperationException e6) {
                throw a.d(e6);
            }
        }

        @Override // v2.a.b
        boolean d(Class<?> cls) {
            try {
                return ((Boolean) this.f9875a.invoke(cls, new Object[0])).booleanValue();
            } catch (ReflectiveOperationException e6) {
                throw a.d(e6);
            }
        }
    }

    static {
        b cVar;
        try {
            cVar = new d();
        } catch (NoSuchMethodException unused) {
            cVar = new c();
        }
        f9874a = cVar;
    }

    private static void b(AccessibleObject accessibleObject, StringBuilder sb) {
        sb.append('(');
        Class<?>[] parameterTypes = accessibleObject instanceof Method ? ((Method) accessibleObject).getParameterTypes() : ((Constructor) accessibleObject).getParameterTypes();
        for (int i6 = 0; i6 < parameterTypes.length; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i6].getSimpleName());
        }
        sb.append(')');
    }

    public static String c(Constructor<?> constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        b(constructor, sb);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RuntimeException d(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static RuntimeException e(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String f(java.lang.reflect.AccessibleObject r5, boolean r6) {
        /*
            boolean r0 = r5 instanceof java.lang.reflect.Field
            java.lang.String r1 = "#"
            java.lang.String r2 = "'"
            if (r0 == 0) goto L31
            java.lang.reflect.Field r5 = (java.lang.reflect.Field) r5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "field '"
            r0.append(r3)
            java.lang.Class r3 = r5.getDeclaringClass()
            java.lang.String r3 = r3.getName()
            r0.append(r3)
            r0.append(r1)
            java.lang.String r5 = r5.getName()
        L26:
            r0.append(r5)
            r0.append(r2)
        L2c:
            java.lang.String r5 = r0.toString()
            goto L91
        L31:
            boolean r0 = r5 instanceof java.lang.reflect.Method
            if (r0 == 0) goto L6a
            java.lang.reflect.Method r5 = (java.lang.reflect.Method) r5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = r5.getName()
            r0.<init>(r3)
            b(r5, r0)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "method '"
            r3.append(r4)
            java.lang.Class r5 = r5.getDeclaringClass()
            java.lang.String r5 = r5.getName()
            r3.append(r5)
            r3.append(r1)
            r3.append(r0)
            r3.append(r2)
            java.lang.String r5 = r3.toString()
            goto L91
        L6a:
            boolean r0 = r5 instanceof java.lang.reflect.Constructor
            if (r0 == 0) goto L7f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "constructor '"
            r0.append(r1)
            java.lang.reflect.Constructor r5 = (java.lang.reflect.Constructor) r5
            java.lang.String r5 = c(r5)
            goto L26
        L7f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "<unknown AccessibleObject> "
            r0.append(r1)
            java.lang.String r5 = r5.toString()
            r0.append(r5)
            goto L2c
        L91:
            if (r6 == 0) goto Lba
            r6 = 0
            char r0 = r5.charAt(r6)
            boolean r0 = java.lang.Character.isLowerCase(r0)
            if (r0 == 0) goto Lba
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r6 = r5.charAt(r6)
            char r6 = java.lang.Character.toUpperCase(r6)
            r0.append(r6)
            r6 = 1
            java.lang.String r5 = r5.substring(r6)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
        Lba:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: v2.a.f(java.lang.reflect.AccessibleObject, boolean):java.lang.String");
    }

    public static Method g(Class<?> cls, Field field) {
        return f9874a.a(cls, field);
    }

    public static <T> Constructor<T> h(Class<T> cls) {
        return f9874a.b(cls);
    }

    public static String[] i(Class<?> cls) {
        return f9874a.c(cls);
    }

    public static boolean j(Class<?> cls) {
        return f9874a.d(cls);
    }

    public static void k(AccessibleObject accessibleObject) {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e6) {
            throw new l("Failed making " + f(accessibleObject, false) + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e6);
        }
    }

    public static String l(Constructor<?> constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e6) {
            return "Failed making constructor '" + c(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e6.getMessage();
        }
    }
}
