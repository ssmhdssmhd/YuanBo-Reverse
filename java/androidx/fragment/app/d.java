package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* loaded from: classes.dex */
public abstract class d {
    @Deprecated
    public Fragment b(Context context, String str, Bundle bundle) {
        return Fragment.L(context, str, bundle);
    }

    public abstract View c(int i6);

    public abstract boolean e();
}
