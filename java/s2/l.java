package s2;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import q2.u;

/* loaded from: classes.dex */
public class l {

    private static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f9282a;

        class a extends b {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Method f9283b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Method method) {
                super();
                this.f9283b = method;
            }

            @Override // s2.l.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f9283b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e6) {
                    throw new RuntimeException("Failed invoking canAccess", e6);
                }
            }
        }

        /* renamed from: s2.l$b$b, reason: collision with other inner class name */
        class C0141b extends b {
            C0141b() {
                super();
            }

            @Override // s2.l.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x001f  */
        static {
            /*
                boolean r0 = s2.e.d()
                if (r0 == 0) goto L1c
                java.lang.Class<java.lang.reflect.AccessibleObject> r0 = java.lang.reflect.AccessibleObject.class
                java.lang.String r1 = "canAccess"
                r2 = 1
                java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: java.lang.NoSuchMethodException -> L1c
                java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
                r4 = 0
                r2[r4] = r3     // Catch: java.lang.NoSuchMethodException -> L1c
                java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch: java.lang.NoSuchMethodException -> L1c
                s2.l$b$a r1 = new s2.l$b$a     // Catch: java.lang.NoSuchMethodException -> L1c
                r1.<init>(r0)     // Catch: java.lang.NoSuchMethodException -> L1c
                goto L1d
            L1c:
                r1 = 0
            L1d:
                if (r1 != 0) goto L24
                s2.l$b$b r1 = new s2.l$b$b
                r1.<init>()
            L24:
                s2.l.b.f9282a = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s2.l.b.<clinit>():void");
        }

        private b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return b.f9282a.a(accessibleObject, obj);
    }

    public static u.a b(List<u> list, Class<?> cls) {
        Iterator<u> it = list.iterator();
        while (it.hasNext()) {
            u.a a6 = it.next().a(cls);
            if (a6 != u.a.INDECISIVE) {
                return a6;
            }
        }
        return u.a.ALLOW;
    }
}
