package h2;

import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public interface a {

    /* renamed from: h2.a$a, reason: collision with other inner class name */
    public static class C0083a extends IOException {
        public C0083a(String str) {
            super(str);
        }

        public C0083a(String str, Throwable th) {
            super(str, th);
        }

        public C0083a(Throwable th) {
            super(th);
        }
    }

    public interface b {
        void a(a aVar, j jVar, j jVar2);

        void c(a aVar, j jVar);

        void d(a aVar, j jVar);
    }

    File a(String str, long j6, long j7);

    void b(j jVar);

    void c(File file, long j6);

    o d(String str);

    void e(String str, p pVar);

    long f(String str, long j6, long j7);

    void g(j jVar);

    j h(String str, long j6, long j7);

    long i(String str, long j6, long j7);

    j j(String str, long j6, long j7);
}
