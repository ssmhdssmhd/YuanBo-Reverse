package kotlin.coroutines.jvm.internal;

import kotlin.jvm.internal.s;

/* loaded from: classes.dex */
public abstract class k extends d implements kotlin.jvm.internal.h<Object> {
    private final int arity;

    public k(int i6) {
        this(i6, null);
    }

    public k(int i6, h4.d<Object> dVar) {
        super(dVar);
        this.arity = i6;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String e6 = s.e(this);
        kotlin.jvm.internal.k.d(e6, "renderLambdaToString(this)");
        return e6;
    }
}
