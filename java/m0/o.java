package m0;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import m0.w;

/* loaded from: classes.dex */
public interface o {

    public static class a extends IOException {

        /* renamed from: a, reason: collision with root package name */
        public final int f7859a;

        public a(Throwable th, int i6) {
            super(th);
            this.f7859a = i6;
        }
    }

    boolean a();

    void b(w.a aVar);

    Map<String, String> c();

    UUID d();

    void e(w.a aVar);

    byte[] f();

    boolean g(String str);

    int getState();

    a h();

    l0.b i();
}
