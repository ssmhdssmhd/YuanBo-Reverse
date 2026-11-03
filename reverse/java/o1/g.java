package o1;

import android.net.Uri;
import g2.k0;
import g2.m;
import g2.q;
import h0.y1;
import java.util.List;
import p1.i;
import p1.j;

/* loaded from: classes.dex */
public final class g {
    public static q a(j jVar, String str, i iVar, int i6) {
        return new q.b().i(iVar.b(str)).h(iVar.f8590a).g(iVar.f8591b).f(j(jVar, iVar)).b(i6).a();
    }

    private static j b(p1.g gVar, int i6) {
        int a6 = gVar.a(i6);
        if (a6 == -1) {
            return null;
        }
        List<j> list = gVar.f8582c.get(a6).f8537c;
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static y1 c(m mVar, p1.g gVar) {
        int i6 = 2;
        j b6 = b(gVar, 2);
        if (b6 == null) {
            i6 = 1;
            b6 = b(gVar, 1);
            if (b6 == null) {
                return null;
            }
        }
        y1 y1Var = b6.f8595b;
        y1 g6 = g(mVar, i6, b6);
        return g6 == null ? y1Var : g6.j(y1Var);
    }

    private static void d(m mVar, j jVar, int i6, n1.g gVar, i iVar) {
        new n1.m(mVar, a(jVar, jVar.f8596c.get(i6).f8541a, iVar, 0), jVar.f8595b, 0, null, gVar).a();
    }

    private static void e(n1.g gVar, m mVar, j jVar, int i6, boolean z5) {
        i iVar = (i) i2.a.e(jVar.n());
        if (z5) {
            i c6 = jVar.c();
            if (c6 == null) {
                return;
            }
            i a6 = iVar.a(c6, jVar.f8596c.get(i6).f8541a);
            if (a6 == null) {
                d(mVar, jVar, i6, gVar, iVar);
                iVar = c6;
            } else {
                iVar = a6;
            }
        }
        d(mVar, jVar, i6, gVar, iVar);
    }

    public static p1.c f(m mVar, Uri uri) {
        return (p1.c) k0.g(mVar, new p1.d(), uri, 4);
    }

    public static y1 g(m mVar, int i6, j jVar) {
        return h(mVar, i6, jVar, 0);
    }

    public static y1 h(m mVar, int i6, j jVar, int i7) {
        if (jVar.n() == null) {
            return null;
        }
        n1.g i8 = i(i6, jVar.f8595b);
        try {
            e(i8, mVar, jVar, i7, false);
            i8.a();
            return ((y1[]) i2.a.i(i8.f()))[0];
        } catch (Throwable th) {
            i8.a();
            throw th;
        }
    }

    private static n1.g i(int i6, y1 y1Var) {
        String str = y1Var.f5065o;
        return new n1.e(str != null && (str.startsWith("video/webm") || str.startsWith("audio/webm")) ? new u0.e() : new w0.g(), i6, y1Var);
    }

    public static String j(j jVar, i iVar) {
        String a6 = jVar.a();
        return a6 != null ? a6 : iVar.b(jVar.f8596c.get(0).f8541a).toString();
    }
}
