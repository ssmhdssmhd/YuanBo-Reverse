package h4;

import h4.g;
import java.io.Serializable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import o4.p;

/* loaded from: classes.dex */
public final class c implements g, Serializable {

    /* renamed from: a, reason: collision with root package name */
    private final g f5241a;

    /* renamed from: b, reason: collision with root package name */
    private final g.b f5242b;

    static final class a extends l implements p<String, g.b, String> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5243a = new a();

        a() {
            super(2);
        }

        @Override // o4.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String acc, g.b element) {
            k.e(acc, "acc");
            k.e(element, "element");
            if (acc.length() == 0) {
                return element.toString();
            }
            return acc + ", " + element;
        }
    }

    public c(g left, g.b element) {
        k.e(left, "left");
        k.e(element, "element");
        this.f5241a = left;
        this.f5242b = element;
    }

    private final boolean b(g.b bVar) {
        return k.a(get(bVar.getKey()), bVar);
    }

    private final boolean c(c cVar) {
        while (b(cVar.f5242b)) {
            g gVar = cVar.f5241a;
            if (!(gVar instanceof c)) {
                k.c(gVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return b((g.b) gVar);
            }
            cVar = (c) gVar;
        }
        return false;
    }

    private final int d() {
        int i6 = 2;
        c cVar = this;
        while (true) {
            g gVar = cVar.f5241a;
            cVar = gVar instanceof c ? (c) gVar : null;
            if (cVar == null) {
                return i6;
            }
            i6++;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.d() != d() || !cVar.c(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // h4.g
    public <R> R fold(R r6, p<? super R, ? super g.b, ? extends R> operation) {
        k.e(operation, "operation");
        return operation.invoke((Object) this.f5241a.fold(r6, operation), this.f5242b);
    }

    @Override // h4.g
    public <E extends g.b> E get(g.c<E> key) {
        k.e(key, "key");
        c cVar = this;
        while (true) {
            E e6 = (E) cVar.f5242b.get(key);
            if (e6 != null) {
                return e6;
            }
            g gVar = cVar.f5241a;
            if (!(gVar instanceof c)) {
                return (E) gVar.get(key);
            }
            cVar = (c) gVar;
        }
    }

    public int hashCode() {
        return this.f5241a.hashCode() + this.f5242b.hashCode();
    }

    @Override // h4.g
    public g minusKey(g.c<?> key) {
        k.e(key, "key");
        if (this.f5242b.get(key) != null) {
            return this.f5241a;
        }
        g minusKey = this.f5241a.minusKey(key);
        return minusKey == this.f5241a ? this : minusKey == h.f5247a ? this.f5242b : new c(minusKey, this.f5242b);
    }

    @Override // h4.g
    public g plus(g gVar) {
        return g.a.a(this, gVar);
    }

    public String toString() {
        return '[' + ((String) fold("", a.f5243a)) + ']';
    }
}
