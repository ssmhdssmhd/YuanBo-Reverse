package n;

import androidx.room.h;
import q.f;

/* loaded from: classes.dex */
public abstract class a<T> extends d {
    public a(h hVar) {
        super(hVar);
    }

    protected abstract void g(f fVar, T t5);

    public final void h(T t5) {
        f a6 = a();
        try {
            g(a6, t5);
            a6.R();
        } finally {
            f(a6);
        }
    }
}
