package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.n;
import androidx.core.graphics.drawable.IconCompat;

/* loaded from: classes.dex */
class i0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f329a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f330b = new Object();

    static Bundle a(n.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat d6 = aVar.d();
        bundle.putInt("icon", d6 != null ? d6.h() : 0);
        bundle.putCharSequence("title", aVar.h());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle.putBoolean("showsUserInterface", aVar.g());
        bundle.putInt("semanticAction", aVar.f());
        return bundle;
    }

    private static Bundle b(z0 z0Var) {
        new Bundle();
        throw null;
    }

    private static Bundle[] c(z0[] z0VarArr) {
        if (z0VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[z0VarArr.length];
        for (int i6 = 0; i6 < z0VarArr.length; i6++) {
            z0 z0Var = z0VarArr[i6];
            bundleArr[i6] = b(null);
        }
        return bundleArr;
    }
}
