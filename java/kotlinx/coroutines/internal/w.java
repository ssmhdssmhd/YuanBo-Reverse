package kotlinx.coroutines.internal;

import w4.k0;

/* loaded from: classes.dex */
public abstract class w {
    public abstract c<?> a();

    public final boolean b(w wVar) {
        c<?> a6;
        c<?> a7 = a();
        return (a7 == null || (a6 = wVar.a()) == null || a7.f() >= a6.f()) ? false : true;
    }

    public abstract Object c(Object obj);

    public String toString() {
        return k0.a(this) + '@' + k0.b(this);
    }
}
