package m2;

import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class j<T> extends h0<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    final Comparator<T> f7988a;

    j(Comparator<T> comparator) {
        this.f7988a = (Comparator) l2.k.i(comparator);
    }

    @Override // m2.h0, java.util.Comparator
    public int compare(T t5, T t6) {
        return this.f7988a.compare(t5, t6);
    }

    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return this.f7988a.equals(((j) obj).f7988a);
        }
        return false;
    }

    public int hashCode() {
        return this.f7988a.hashCode();
    }

    public String toString() {
        return this.f7988a.toString();
    }
}
