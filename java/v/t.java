package v;

import android.content.Context;
import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class t {
    protected t() {
    }

    public static t d(Context context) {
        return w.j.l(context);
    }

    public static void f(Context context, androidx.work.a aVar) {
        w.j.f(context, aVar);
    }

    public abstract m a(String str);

    public abstract m b(List<? extends u> list);

    public final m c(u uVar) {
        return b(Collections.singletonList(uVar));
    }

    public abstract LiveData<s> e(UUID uuid);
}
