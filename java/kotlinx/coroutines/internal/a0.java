package kotlinx.coroutines.internal;

import e4.k;

/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7020a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f7021b;

    static {
        Object a6;
        Object a7;
        try {
            k.a aVar = e4.k.f3704a;
            a6 = e4.k.a(kotlin.coroutines.jvm.internal.a.class.getCanonicalName());
        } catch (Throwable th) {
            k.a aVar2 = e4.k.f3704a;
            a6 = e4.k.a(e4.l.a(th));
        }
        if (e4.k.b(a6) != null) {
            a6 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f7020a = (String) a6;
        try {
            a7 = e4.k.a(a0.class.getCanonicalName());
        } catch (Throwable th2) {
            k.a aVar3 = e4.k.f3704a;
            a7 = e4.k.a(e4.l.a(th2));
        }
        if (e4.k.b(a7) != null) {
            a7 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f7021b = (String) a7;
    }

    public static final <E extends Throwable> E a(E e6) {
        return e6;
    }
}
