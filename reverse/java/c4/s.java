package c4;

import android.content.Context;
import android.util.LongSparseArray;
import c4.a;
import io.flutter.view.t;
import java.util.HashMap;
import java.util.Objects;
import q3.a;

/* loaded from: classes.dex */
public class s implements q3.a, a.b {

    /* renamed from: b, reason: collision with root package name */
    private a f1880b;

    /* renamed from: a, reason: collision with root package name */
    private final LongSparseArray<o> f1879a = new LongSparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private p f1881c = new p();

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f1882a;

        /* renamed from: b, reason: collision with root package name */
        private final y3.c f1883b;

        /* renamed from: c, reason: collision with root package name */
        private final c f1884c;

        /* renamed from: d, reason: collision with root package name */
        private final b f1885d;

        /* renamed from: e, reason: collision with root package name */
        private final t f1886e;

        a(Context context, y3.c cVar, c cVar2, b bVar, t tVar) {
            this.f1882a = context;
            this.f1883b = cVar;
            this.f1884c = cVar2;
            this.f1885d = bVar;
            this.f1886e = tVar;
        }

        void f(s sVar, y3.c cVar) {
            m.m(cVar, sVar);
        }

        void g(y3.c cVar) {
            m.m(cVar, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface b {
        String a(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface c {
        String a(String str);
    }

    private void n() {
        for (int i6 = 0; i6 < this.f1879a.size(); i6++) {
            this.f1879a.valueAt(i6).c();
        }
        this.f1879a.clear();
    }

    @Override // c4.a.b
    public void a() {
        n();
    }

    @Override // q3.a
    public void b(a.b bVar) {
        k3.a e6 = k3.a.e();
        Context a6 = bVar.a();
        y3.c b6 = bVar.b();
        final o3.d c6 = e6.c();
        Objects.requireNonNull(c6);
        c cVar = new c() { // from class: c4.q
            @Override // c4.s.c
            public final String a(String str) {
                return o3.d.this.h(str);
            }
        };
        final o3.d c7 = e6.c();
        Objects.requireNonNull(c7);
        a aVar = new a(a6, b6, cVar, new b() { // from class: c4.r
            @Override // c4.s.b
            public final String a(String str, String str2) {
                return o3.d.this.i(str, str2);
            }
        }, bVar.c());
        this.f1880b = aVar;
        aVar.f(this, bVar.b());
    }

    @Override // c4.a.b
    public a.h c(a.i iVar) {
        o oVar = this.f1879a.get(iVar.b().longValue());
        a.h a6 = new a.h.C0042a().b(Long.valueOf(oVar.d())).c(iVar.b()).a();
        oVar.h();
        return a6;
    }

    @Override // c4.a.b
    public void d(a.f fVar) {
        this.f1881c.f1876a = fVar.b().booleanValue();
    }

    @Override // c4.a.b
    public void e(a.i iVar) {
        this.f1879a.get(iVar.b().longValue()).e();
    }

    @Override // c4.a.b
    public void f(a.h hVar) {
        this.f1879a.get(hVar.c().longValue()).g(hVar.b().intValue());
    }

    @Override // c4.a.b
    public void g(a.j jVar) {
        this.f1879a.get(jVar.b().longValue()).n(jVar.c().doubleValue());
    }

    @Override // c4.a.b
    public void h(a.i iVar) {
        this.f1879a.get(iVar.b().longValue()).f();
    }

    @Override // c4.a.b
    public void i(a.i iVar) {
        this.f1879a.get(iVar.b().longValue()).c();
        this.f1879a.remove(iVar.b().longValue());
    }

    @Override // q3.a
    public void j(a.b bVar) {
        if (this.f1880b == null) {
            k3.b.i("VideoPlayerPlugin", "Detached from the engine before registering to it.");
        }
        this.f1880b.g(bVar.b());
        this.f1880b = null;
        a();
    }

    @Override // c4.a.b
    public void k(a.g gVar) {
        this.f1879a.get(gVar.c().longValue()).l(gVar.b().doubleValue());
    }

    @Override // c4.a.b
    public a.i l(a.d dVar) {
        o oVar;
        t.c a6 = this.f1880b.f1886e.a();
        y3.d dVar2 = new y3.d(this.f1880b.f1883b, "flutter.io/videoPlayer/videoEvents" + a6.e());
        if (dVar.b() != null) {
            String a7 = dVar.e() != null ? this.f1880b.f1885d.a(dVar.b(), dVar.e()) : this.f1880b.f1884c.a(dVar.b());
            oVar = new o(this.f1880b.f1882a, dVar2, a6, "asset:///" + a7, null, new HashMap(), this.f1881c);
        } else {
            oVar = new o(this.f1880b.f1882a, dVar2, a6, dVar.f(), dVar.c(), dVar.d(), this.f1881c);
        }
        this.f1879a.put(a6.e(), oVar);
        return new a.i.C0043a().b(Long.valueOf(a6.e())).a();
    }

    @Override // c4.a.b
    public void m(a.e eVar) {
        this.f1879a.get(eVar.c().longValue()).k(eVar.b().booleanValue());
    }
}
