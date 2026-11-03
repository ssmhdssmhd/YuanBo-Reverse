package j5;

import d5.a0;
import d5.b0;
import d5.c0;
import d5.m;
import d5.n;
import d5.v;
import d5.w;
import d5.z;
import f4.l;
import java.util.List;
import q5.o;
import v4.p;

/* loaded from: classes.dex */
public final class a implements v {

    /* renamed from: a, reason: collision with root package name */
    private final n f6825a;

    public a(n cookieJar) {
        kotlin.jvm.internal.k.e(cookieJar, "cookieJar");
        this.f6825a = cookieJar;
    }

    private final String b(List<m> list) {
        StringBuilder sb = new StringBuilder();
        int i6 = 0;
        for (Object obj : list) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                l.m();
            }
            m mVar = (m) obj;
            if (i6 > 0) {
                sb.append("; ");
            }
            sb.append(mVar.e());
            sb.append('=');
            sb.append(mVar.g());
            i6 = i7;
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.k.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Override // d5.v
    public b0 a(v.a chain) {
        boolean o6;
        c0 a6;
        kotlin.jvm.internal.k.e(chain, "chain");
        z b6 = chain.b();
        z.a h6 = b6.h();
        a0 a7 = b6.a();
        if (a7 != null) {
            w b7 = a7.b();
            if (b7 != null) {
                h6.b("Content-Type", b7.toString());
            }
            long a8 = a7.a();
            if (a8 != -1) {
                h6.b("Content-Length", String.valueOf(a8));
                h6.f("Transfer-Encoding");
            } else {
                h6.b("Transfer-Encoding", "chunked");
                h6.f("Content-Length");
            }
        }
        boolean z5 = false;
        if (b6.d("Host") == null) {
            h6.b("Host", e5.b.K(b6.i(), false, 1, null));
        }
        if (b6.d("Connection") == null) {
            h6.b("Connection", "Keep-Alive");
        }
        if (b6.d("Accept-Encoding") == null && b6.d("Range") == null) {
            h6.b("Accept-Encoding", "gzip");
            z5 = true;
        }
        List<m> b8 = this.f6825a.b(b6.i());
        if (!b8.isEmpty()) {
            h6.b("Cookie", b(b8));
        }
        if (b6.d("User-Agent") == null) {
            h6.b("User-Agent", "okhttp/4.9.0");
        }
        b0 a9 = chain.a(h6.a());
        e.f(this.f6825a, b6.i(), a9.I());
        b0.a r6 = a9.U().r(b6);
        if (z5) {
            o6 = p.o("gzip", b0.F(a9, "Content-Encoding", null, 2, null), true);
            if (o6 && e.b(a9) && (a6 = a9.a()) != null) {
                q5.l lVar = new q5.l(a6.k());
                r6.k(a9.I().d().f("Content-Encoding").f("Content-Length").d());
                r6.b(new h(b0.F(a9, "Content-Type", null, 2, null), -1L, o.b(lVar)));
            }
        }
        return r6.c();
    }
}
