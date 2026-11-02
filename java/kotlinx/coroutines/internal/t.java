package kotlinx.coroutines.internal;

import java.util.List;
import w4.v1;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f7075a = true;

    private static final u a(Throwable th, String str) {
        if (f7075a) {
            return new u(th, str);
        }
        if (th != null) {
            throw th;
        }
        d();
        throw new e4.d();
    }

    static /* synthetic */ u b(Throwable th, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            th = null;
        }
        if ((i6 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(v1 v1Var) {
        return v1Var.Y() instanceof u;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final v1 e(r rVar, List<? extends r> list) {
        try {
            return rVar.createDispatcher(list);
        } catch (Throwable th) {
            return a(th, rVar.hintOnError());
        }
    }
}
