package w4;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class e1 {
    public static final c0 a(Executor executor) {
        s0 s0Var = executor instanceof s0 ? (s0) executor : null;
        c0 c0Var = s0Var != null ? s0Var.f10334a : null;
        return c0Var == null ? new d1(executor) : c0Var;
    }
}
