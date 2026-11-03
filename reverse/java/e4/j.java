package e4;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class j<A, B> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private final A f3702a;

    /* renamed from: b, reason: collision with root package name */
    private final B f3703b;

    public j(A a6, B b6) {
        this.f3702a = a6;
        this.f3703b = b6;
    }

    public final A a() {
        return this.f3702a;
    }

    public final B b() {
        return this.f3703b;
    }

    public final A c() {
        return this.f3702a;
    }

    public final B d() {
        return this.f3703b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return kotlin.jvm.internal.k.a(this.f3702a, jVar.f3702a) && kotlin.jvm.internal.k.a(this.f3703b, jVar.f3703b);
    }

    public int hashCode() {
        A a6 = this.f3702a;
        int hashCode = (a6 == null ? 0 : a6.hashCode()) * 31;
        B b6 = this.f3703b;
        return hashCode + (b6 != null ? b6.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f3702a + ", " + this.f3703b + ')';
    }
}
