package kotlin.jvm.internal;

/* loaded from: classes.dex */
public abstract class p extends c implements t4.g {
    public p() {
    }

    public p(Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, (i6 & 1) == 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t4.g getReflected() {
        return (t4.g) super.getReflected();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return getOwner().equals(pVar.getOwner()) && getName().equals(pVar.getName()) && getSignature().equals(pVar.getSignature()) && k.a(getBoundReceiver(), pVar.getBoundReceiver());
        }
        if (obj instanceof t4.g) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        t4.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
