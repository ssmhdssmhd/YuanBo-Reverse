package m2;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class g<F, T> extends h0<F> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    final l2.f<F, ? extends T> f7984a;

    /* renamed from: b, reason: collision with root package name */
    final h0<T> f7985b;

    g(l2.f<F, ? extends T> fVar, h0<T> h0Var) {
        this.f7984a = (l2.f) l2.k.i(fVar);
        this.f7985b = (h0) l2.k.i(h0Var);
    }

    @Override // m2.h0, java.util.Comparator
    public int compare(F f6, F f7) {
        return this.f7985b.compare(this.f7984a.apply(f6), this.f7984a.apply(f7));
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f7984a.equals(gVar.f7984a) && this.f7985b.equals(gVar.f7985b);
    }

    public int hashCode() {
        return l2.j.b(this.f7984a, this.f7985b);
    }

    public String toString() {
        String valueOf = String.valueOf(this.f7985b);
        String valueOf2 = String.valueOf(this.f7984a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 13 + valueOf2.length());
        sb.append(valueOf);
        sb.append(".onResultOf(");
        sb.append(valueOf2);
        sb.append(")");
        return sb.toString();
    }
}
