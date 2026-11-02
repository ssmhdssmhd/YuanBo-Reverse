package h3;

import h3.a;
import kotlin.jvm.internal.k;
import q3.a;

/* loaded from: classes.dex */
public final class g implements q3.a, a.c, r3.a {

    /* renamed from: a, reason: collision with root package name */
    private f f5238a;

    @Override // r3.a
    public void a(r3.c binding) {
        k.e(binding, "binding");
        d(binding);
    }

    @Override // q3.a
    public void b(a.b flutterPluginBinding) {
        k.e(flutterPluginBinding, "flutterPluginBinding");
        d.d(flutterPluginBinding.b(), this);
        this.f5238a = new f();
    }

    @Override // r3.a
    public void c() {
        f fVar = this.f5238a;
        if (fVar == null) {
            return;
        }
        fVar.c(null);
    }

    @Override // r3.a
    public void d(r3.c binding) {
        k.e(binding, "binding");
        f fVar = this.f5238a;
        if (fVar == null) {
            return;
        }
        fVar.c(binding.d());
    }

    @Override // h3.a.c
    public void e(a.b bVar) {
        f fVar = this.f5238a;
        k.b(fVar);
        k.b(bVar);
        fVar.d(bVar);
    }

    @Override // r3.a
    public void f() {
        c();
    }

    @Override // h3.a.c
    public a.C0084a isEnabled() {
        f fVar = this.f5238a;
        k.b(fVar);
        return fVar.b();
    }

    @Override // q3.a
    public void j(a.b binding) {
        k.e(binding, "binding");
        d.d(binding.b(), null);
        this.f5238a = null;
    }
}
