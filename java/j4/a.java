package j4;

import java.lang.reflect.Method;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public class a {

    /* renamed from: j4.a$a, reason: collision with other inner class name */
    private static final class C0099a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0099a f6821a = new C0099a();

        /* renamed from: b, reason: collision with root package name */
        public static final Method f6822b;

        /* renamed from: c, reason: collision with root package name */
        public static final Method f6823c;

        /* JADX WARN: Removed duplicated region for block: B:10:0x003f A[LOOP:0: B:2:0x0015->B:10:0x003f, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0043 A[EDGE_INSN: B:11:0x0043->B:12:0x0043 BREAK  A[LOOP:0: B:2:0x0015->B:10:0x003f], SYNTHETIC] */
        static {
            /*
                j4.a$a r0 = new j4.a$a
                r0.<init>()
                j4.a.C0099a.f6821a = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                kotlin.jvm.internal.k.d(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L15:
                r5 = 0
                if (r4 >= r2) goto L42
                r6 = r1[r4]
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = kotlin.jvm.internal.k.a(r7, r8)
                if (r7 == 0) goto L3b
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "it.parameterTypes"
                kotlin.jvm.internal.k.d(r7, r8)
                java.lang.Object r7 = f4.d.q(r7)
                boolean r7 = kotlin.jvm.internal.k.a(r7, r0)
                if (r7 == 0) goto L3b
                r7 = 1
                goto L3c
            L3b:
                r7 = 0
            L3c:
                if (r7 == 0) goto L3f
                goto L43
            L3f:
                int r4 = r4 + 1
                goto L15
            L42:
                r6 = r5
            L43:
                j4.a.C0099a.f6822b = r6
                int r0 = r1.length
            L46:
                if (r3 >= r0) goto L5b
                r2 = r1[r3]
                java.lang.String r4 = r2.getName()
                java.lang.String r6 = "getSuppressed"
                boolean r4 = kotlin.jvm.internal.k.a(r4, r6)
                if (r4 == 0) goto L58
                r5 = r2
                goto L5b
            L58:
                int r3 = r3 + 1
                goto L46
            L5b:
                j4.a.C0099a.f6823c = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: j4.a.C0099a.<clinit>():void");
        }

        private C0099a() {
        }
    }

    public void a(Throwable cause, Throwable exception) {
        k.e(cause, "cause");
        k.e(exception, "exception");
        Method method = C0099a.f6822b;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public q4.c b() {
        return new q4.b();
    }
}
