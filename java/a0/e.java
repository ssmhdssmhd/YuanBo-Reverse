package a0;

import android.content.Context;
import android.os.Build;
import b0.i;
import d0.p;
import v.j;
import v.k;

/* loaded from: classes.dex */
public class e extends c<z.b> {

    /* renamed from: e, reason: collision with root package name */
    private static final String f5e = j.f("NetworkMeteredCtrlr");

    public e(Context context, f0.a aVar) {
        super(i.c(context, aVar).d());
    }

    @Override // a0.c
    boolean b(p pVar) {
        return pVar.f2867j.b() == k.METERED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a0.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(z.b bVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            return (bVar.a() && bVar.b()) ? false : true;
        }
        j.c().a(f5e, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
        return !bVar.a();
    }
}
