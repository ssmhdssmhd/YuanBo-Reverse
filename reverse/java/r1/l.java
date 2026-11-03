package r1;

import android.net.Uri;
import g2.h0;
import java.io.IOException;
import l1.c0;

/* loaded from: classes.dex */
public interface l {

    public interface a {
        l a(q1.g gVar, h0 h0Var, k kVar);
    }

    public interface b {
        void b();

        boolean e(Uri uri, h0.c cVar, boolean z5);
    }

    public static final class c extends IOException {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f9174a;

        public c(Uri uri) {
            this.f9174a = uri;
        }
    }

    public static final class d extends IOException {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f9175a;

        public d(Uri uri) {
            this.f9175a = uri;
        }
    }

    public interface e {
        void d(g gVar);
    }

    boolean a();

    void b();

    h c();

    boolean d(Uri uri, long j6);

    boolean e(Uri uri);

    void f(Uri uri, c0.a aVar, e eVar);

    void g();

    void h(b bVar);

    void j(Uri uri);

    void k(b bVar);

    void l(Uri uri);

    g n(Uri uri, boolean z5);

    long o();
}
