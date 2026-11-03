package a0;

import android.content.Context;
import android.os.Build;
import b0.i;
import d0.p;
import v.k;

/* loaded from: classes.dex */
public class d extends c<z.b> {
    public d(Context context, f0.a aVar) {
        super(i.c(context, aVar).d());
    }

    @Override // a0.c
    boolean b(p pVar) {
        return pVar.f2867j.b() == k.CONNECTED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // a0.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(z.b bVar) {
        return Build.VERSION.SDK_INT >= 26 ? (bVar.a() && bVar.d()) ? false : true : !bVar.a();
    }
}
