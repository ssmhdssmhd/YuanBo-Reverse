package kotlinx.coroutines.internal;

import e4.k;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f7045a;

    static {
        Object a6;
        try {
            k.a aVar = e4.k.f3704a;
            a6 = e4.k.a(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            k.a aVar2 = e4.k.f3704a;
            a6 = e4.k.a(e4.l.a(th));
        }
        f7045a = e4.k.d(a6);
    }

    public static final boolean a() {
        return f7045a;
    }
}
