package y3;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface c {

    public interface a {
        void a(ByteBuffer byteBuffer, b bVar);
    }

    public interface b {
        void a(ByteBuffer byteBuffer);
    }

    /* renamed from: y3.c$c, reason: collision with other inner class name */
    public interface InterfaceC0170c {
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private boolean f11086a = true;

        public boolean a() {
            return this.f11086a;
        }
    }

    InterfaceC0170c a(d dVar);

    void b(String str, a aVar);

    void c(String str, a aVar, InterfaceC0170c interfaceC0170c);

    InterfaceC0170c d();

    void e(String str, ByteBuffer byteBuffer, b bVar);

    void f(String str, ByteBuffer byteBuffer);
}
