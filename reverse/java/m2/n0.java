package m2;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class n0<T> extends h0<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    final h0<? super T> f8018a;

    n0(h0<? super T> h0Var) {
        this.f8018a = (h0) l2.k.i(h0Var);
    }

    @Override // m2.h0, java.util.Comparator
    public int compare(T t5, T t6) {
        return this.f8018a.compare(t6, t5);
    }

    @Override // m2.h0
    public <S extends T> h0<S> d() {
        return this.f8018a;
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n0) {
            return this.f8018a.equals(((n0) obj).f8018a);
        }
        return false;
    }

    public int hashCode() {
        return -this.f8018a.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f8018a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 10);
        sb.append(valueOf);
        sb.append(".reverse()");
        return sb.toString();
    }
}
