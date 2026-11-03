package kotlin.jvm.internal;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class l<R> implements h<R>, Serializable {
    private final int arity;

    public l(int i6) {
        this.arity = i6;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String f6 = s.f(this);
        k.d(f6, "renderLambdaToString(this)");
        return f6;
    }
}
