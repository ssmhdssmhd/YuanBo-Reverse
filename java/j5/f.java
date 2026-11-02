package j5;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f6832a = new f();

    private f() {
    }

    public static final boolean a(String method) {
        kotlin.jvm.internal.k.e(method, "method");
        return (kotlin.jvm.internal.k.a(method, "GET") || kotlin.jvm.internal.k.a(method, "HEAD")) ? false : true;
    }

    public static final boolean d(String method) {
        kotlin.jvm.internal.k.e(method, "method");
        return kotlin.jvm.internal.k.a(method, "POST") || kotlin.jvm.internal.k.a(method, "PUT") || kotlin.jvm.internal.k.a(method, "PATCH") || kotlin.jvm.internal.k.a(method, "PROPPATCH") || kotlin.jvm.internal.k.a(method, "REPORT");
    }

    public final boolean b(String method) {
        kotlin.jvm.internal.k.e(method, "method");
        return !kotlin.jvm.internal.k.a(method, "PROPFIND");
    }

    public final boolean c(String method) {
        kotlin.jvm.internal.k.e(method, "method");
        return kotlin.jvm.internal.k.a(method, "PROPFIND");
    }
}
