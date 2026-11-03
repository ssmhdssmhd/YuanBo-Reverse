package q2;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class x<T> {

    class a extends x<T> {
        a() {
        }

        @Override // q2.x
        public T b(y2.a aVar) {
            if (aVar.g0() != y2.b.NULL) {
                return (T) x.this.b(aVar);
            }
            aVar.c0();
            return null;
        }

        @Override // q2.x
        public void d(y2.c cVar, T t5) {
            if (t5 == null) {
                cVar.V();
            } else {
                x.this.d(cVar, t5);
            }
        }
    }

    public final x<T> a() {
        return new a();
    }

    public abstract T b(y2.a aVar);

    public final k c(T t5) {
        try {
            t2.g gVar = new t2.g();
            d(gVar, t5);
            return gVar.m0();
        } catch (IOException e6) {
            throw new l(e6);
        }
    }

    public abstract void d(y2.c cVar, T t5);
}
