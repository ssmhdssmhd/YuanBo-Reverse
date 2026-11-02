package q3;

import android.content.Context;
import io.flutter.plugin.platform.j;
import io.flutter.view.t;
import y3.c;

/* loaded from: classes.dex */
public interface a {

    /* renamed from: q3.a$a, reason: collision with other inner class name */
    public interface InterfaceC0133a {
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f8929a;

        /* renamed from: b, reason: collision with root package name */
        private final io.flutter.embedding.engine.a f8930b;

        /* renamed from: c, reason: collision with root package name */
        private final c f8931c;

        /* renamed from: d, reason: collision with root package name */
        private final t f8932d;

        /* renamed from: e, reason: collision with root package name */
        private final j f8933e;

        /* renamed from: f, reason: collision with root package name */
        private final InterfaceC0133a f8934f;

        public b(Context context, io.flutter.embedding.engine.a aVar, c cVar, t tVar, j jVar, InterfaceC0133a interfaceC0133a) {
            this.f8929a = context;
            this.f8930b = aVar;
            this.f8931c = cVar;
            this.f8932d = tVar;
            this.f8933e = jVar;
            this.f8934f = interfaceC0133a;
        }

        public Context a() {
            return this.f8929a;
        }

        public c b() {
            return this.f8931c;
        }

        public t c() {
            return this.f8932d;
        }
    }

    void b(b bVar);

    void j(b bVar);
}
