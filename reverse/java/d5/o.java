package d5;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f3184a = new o();

    private o() {
    }

    public static final String a(String username, String password, Charset charset) {
        kotlin.jvm.internal.k.e(username, "username");
        kotlin.jvm.internal.k.e(password, "password");
        kotlin.jvm.internal.k.e(charset, "charset");
        return "Basic " + q5.h.f8959e.b(username + ':' + password, charset).a();
    }
}
