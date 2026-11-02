package g0;

import android.app.Activity;
import android.content.Context;
import q3.a;

/* loaded from: classes.dex */
public final class m implements q3.a, r3.a {

    /* renamed from: a, reason: collision with root package name */
    private final t f3950a = new t();

    /* renamed from: b, reason: collision with root package name */
    private y3.k f3951b;

    /* renamed from: c, reason: collision with root package name */
    private r3.c f3952c;

    /* renamed from: d, reason: collision with root package name */
    private l f3953d;

    private void e() {
        r3.c cVar = this.f3952c;
        if (cVar != null) {
            cVar.e(this.f3950a);
            this.f3952c.b(this.f3950a);
        }
    }

    private void g() {
        r3.c cVar = this.f3952c;
        if (cVar != null) {
            cVar.a(this.f3950a);
            this.f3952c.c(this.f3950a);
        }
    }

    private void h(Context context, y3.c cVar) {
        this.f3951b = new y3.k(cVar, "flutter.baseflow.com/permissions/methods");
        l lVar = new l(context, new a(), this.f3950a, new x());
        this.f3953d = lVar;
        this.f3951b.e(lVar);
    }

    private void i(Activity activity) {
        l lVar = this.f3953d;
        if (lVar != null) {
            lVar.j(activity);
        }
    }

    private void k() {
        this.f3951b.e(null);
        this.f3951b = null;
        this.f3953d = null;
    }

    private void l() {
        l lVar = this.f3953d;
        if (lVar != null) {
            lVar.j(null);
        }
    }

    @Override // r3.a
    public void a(r3.c cVar) {
        d(cVar);
    }

    @Override // q3.a
    public void b(a.b bVar) {
        h(bVar.a(), bVar.b());
    }

    @Override // r3.a
    public void c() {
        l();
        e();
    }

    @Override // r3.a
    public void d(r3.c cVar) {
        i(cVar.d());
        this.f3952c = cVar;
        g();
    }

    @Override // r3.a
    public void f() {
        c();
    }

    @Override // q3.a
    public void j(a.b bVar) {
        k();
    }
}
