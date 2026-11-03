package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class g {
    private static final void a(int i6, int i7) {
        if (i7 <= i6) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i6 + ", got " + i7 + ". Please update the Kotlin standard library.").toString());
    }

    private static final f b(a aVar) {
        return (f) aVar.getClass().getAnnotation(f.class);
    }

    private static final int c(a aVar) {
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(a aVar) {
        String str;
        kotlin.jvm.internal.k.e(aVar, "<this>");
        f b6 = b(aVar);
        if (b6 == null) {
            return null;
        }
        a(1, b6.v());
        int c6 = c(aVar);
        int i6 = c6 < 0 ? -1 : b6.l()[c6];
        String b7 = i.f6993a.b(aVar);
        if (b7 == null) {
            str = b6.c();
        } else {
            str = b7 + '/' + b6.c();
        }
        return new StackTraceElement(str, b6.m(), b6.f(), i6);
    }
}
