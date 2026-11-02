package w4;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final Object f10364a;

    /* renamed from: b, reason: collision with root package name */
    public final o4.l<Throwable, e4.q> f10365b;

    /* JADX WARN: Multi-variable type inference failed */
    public w(Object obj, o4.l<? super Throwable, e4.q> lVar) {
        this.f10364a = obj;
        this.f10365b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return kotlin.jvm.internal.k.a(this.f10364a, wVar.f10364a) && kotlin.jvm.internal.k.a(this.f10365b, wVar.f10365b);
    }

    public int hashCode() {
        Object obj = this.f10364a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f10365b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f10364a + ", onCancellation=" + this.f10365b + ')';
    }
}
