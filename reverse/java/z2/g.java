package z2;

import android.content.Context;
import android.util.Log;
import h2.u;
import java.io.File;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f11287a = new g();

    /* renamed from: b, reason: collision with root package name */
    private static volatile u f11288b;

    private g() {
    }

    public static final void b() {
        try {
            if (f11288b != null) {
                u uVar = f11288b;
                kotlin.jvm.internal.k.b(uVar);
                uVar.z();
                f11288b = null;
            }
        } catch (Exception e6) {
            Log.e("BetterPlayerCache", e6.toString());
        }
    }

    public final u a(Context context, long j6) {
        kotlin.jvm.internal.k.e(context, "context");
        if (f11288b == null) {
            synchronized (g.class) {
                if (f11288b == null) {
                    f11288b = new u(new File(context.getCacheDir(), "betterPlayerCache"), new h2.s(j6), new k0.c(context));
                }
                e4.q qVar = e4.q.f3710a;
            }
        }
        return f11288b;
    }
}
