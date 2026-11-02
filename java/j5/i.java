package j5;

import d5.u;
import d5.z;
import java.net.Proxy;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f6845a = new i();

    private i() {
    }

    private final boolean b(z zVar, Proxy.Type type) {
        return !zVar.f() && type == Proxy.Type.HTTP;
    }

    public final String a(z request, Proxy.Type proxyType) {
        kotlin.jvm.internal.k.e(request, "request");
        kotlin.jvm.internal.k.e(proxyType, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.g());
        sb.append(' ');
        i iVar = f6845a;
        boolean b6 = iVar.b(request, proxyType);
        u i6 = request.i();
        if (b6) {
            sb.append(i6);
        } else {
            sb.append(iVar.c(i6));
        }
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        kotlin.jvm.internal.k.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String c(u url) {
        kotlin.jvm.internal.k.e(url, "url");
        String d6 = url.d();
        String f6 = url.f();
        if (f6 == null) {
            return d6;
        }
        return d6 + '?' + f6;
    }
}
