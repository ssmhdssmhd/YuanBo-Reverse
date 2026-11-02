package y4;

import kotlinx.coroutines.internal.b0;

/* loaded from: classes.dex */
public class n<E> extends a<E> {
    public n(o4.l<? super E, e4.q> lVar) {
        super(lVar);
    }

    @Override // y4.c
    protected Object i(E e6) {
        q<?> k6;
        do {
            Object i6 = super.i(e6);
            b0 b0Var = b.f11128b;
            if (i6 == b0Var) {
                return b0Var;
            }
            if (i6 != b.f11129c) {
                if (i6 instanceof j) {
                    return i6;
                }
                throw new IllegalStateException(kotlin.jvm.internal.k.j("Invalid offerInternal result ", i6).toString());
            }
            k6 = k(e6);
            if (k6 == null) {
                return b0Var;
            }
        } while (!(k6 instanceof j));
        return k6;
    }

    @Override // y4.a
    protected final boolean r() {
        return true;
    }

    @Override // y4.a
    protected final boolean s() {
        return true;
    }
}
