package androidx.lifecycle;

import androidx.lifecycle.d;

/* loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements g {

    /* renamed from: a, reason: collision with root package name */
    private final c[] f813a;

    CompositeGeneratedAdaptersObserver(c[] cVarArr) {
        this.f813a = cVarArr;
    }

    @Override // androidx.lifecycle.g
    public void d(i iVar, d.b bVar) {
        o oVar = new o();
        for (c cVar : this.f813a) {
            cVar.a(iVar, bVar, false, oVar);
        }
        for (c cVar2 : this.f813a) {
            cVar2.a(iVar, bVar, true, oVar);
        }
    }
}
