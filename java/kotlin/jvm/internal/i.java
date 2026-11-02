package kotlin.jvm.internal;

/* loaded from: classes.dex */
public class i extends c implements h, t4.e {
    private final int arity;
    private final int flags;

    public i(int i6) {
        this(i6, c.NO_RECEIVER, null, null, null, 0);
    }

    public i(int i6, Object obj) {
        this(i6, obj, null, null, null, 0);
    }

    public i(int i6, Object obj, Class cls, String str, String str2, int i7) {
        super(obj, cls, str, str2, (i7 & 1) == 1);
        this.arity = i6;
        this.flags = i7 >> 1;
    }

    @Override // kotlin.jvm.internal.c
    protected t4.b computeReflected() {
        return s.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return getName().equals(iVar.getName()) && getSignature().equals(iVar.getSignature()) && this.flags == iVar.flags && this.arity == iVar.arity && k.a(getBoundReceiver(), iVar.getBoundReceiver()) && k.a(getOwner(), iVar.getOwner());
        }
        if (obj instanceof t4.e) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.h
    public int getArity() {
        return this.arity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c
    public t4.e getReflected() {
        return (t4.e) super.getReflected();
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // t4.e
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // t4.e
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // t4.e
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // t4.e
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.c, t4.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        t4.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
