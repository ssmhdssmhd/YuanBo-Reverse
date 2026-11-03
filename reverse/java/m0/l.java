package m0;

import android.net.Uri;
import g2.m;
import g2.v;
import h0.h2;
import i2.c1;
import java.util.Map;
import m0.h;

/* loaded from: classes.dex */
public final class l implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private final Object f7845a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private h2.f f7846b;

    /* renamed from: c, reason: collision with root package name */
    private y f7847c;

    /* renamed from: d, reason: collision with root package name */
    private m.a f7848d;

    /* renamed from: e, reason: collision with root package name */
    private String f7849e;

    private y b(h2.f fVar) {
        m.a aVar = this.f7848d;
        if (aVar == null) {
            aVar = new v.b().g(this.f7849e);
        }
        Uri uri = fVar.f4445c;
        p0 p0Var = new p0(uri == null ? null : uri.toString(), fVar.f4450h, aVar);
        m2.s0<Map.Entry<String, String>> it = fVar.f4447e.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            p0Var.e(next.getKey(), next.getValue());
        }
        h a6 = new h.b().f(fVar.f4443a, o0.f7860d).c(fVar.f4448f).d(fVar.f4449g).e(o2.e.k(fVar.f4452j)).a(p0Var);
        a6.G(0, fVar.c());
        return a6;
    }

    @Override // m0.b0
    public y a(h2 h2Var) {
        y yVar;
        i2.a.e(h2Var.f4406b);
        h2.f fVar = h2Var.f4406b.f4481c;
        if (fVar == null || c1.f5548a < 18) {
            return y.f7899a;
        }
        synchronized (this.f7845a) {
            if (!c1.c(fVar, this.f7846b)) {
                this.f7846b = fVar;
                this.f7847c = b(fVar);
            }
            yVar = (y) i2.a.e(this.f7847c);
        }
        return yVar;
    }
}
