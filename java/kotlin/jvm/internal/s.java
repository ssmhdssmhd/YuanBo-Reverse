package kotlin.jvm.internal;

/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private static final t f7014a;

    /* renamed from: b, reason: collision with root package name */
    private static final t4.c[] f7015b;

    static {
        t tVar = null;
        try {
            tVar = (t) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (tVar == null) {
            tVar = new t();
        }
        f7014a = tVar;
        f7015b = new t4.c[0];
    }

    public static t4.e a(i iVar) {
        return f7014a.a(iVar);
    }

    public static t4.c b(Class cls) {
        return f7014a.b(cls);
    }

    public static t4.d c(Class cls) {
        return f7014a.c(cls, "");
    }

    public static t4.f d(n nVar) {
        return f7014a.d(nVar);
    }

    public static String e(h hVar) {
        return f7014a.e(hVar);
    }

    public static String f(l lVar) {
        return f7014a.f(lVar);
    }
}
