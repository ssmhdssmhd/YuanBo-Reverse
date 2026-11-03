package w4;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class m1 extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final l1 f10325a;

    public m1(String str, Throwable th, l1 l1Var) {
        super(str);
        this.f10325a = l1Var;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof m1) {
                m1 m1Var = (m1) obj;
                if (!kotlin.jvm.internal.k.a(m1Var.getMessage(), getMessage()) || !kotlin.jvm.internal.k.a(m1Var.f10325a, this.f10325a) || !kotlin.jvm.internal.k.a(m1Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.k.b(message);
        int hashCode = ((message.hashCode() * 31) + this.f10325a.hashCode()) * 31;
        Throwable cause = getCause();
        return hashCode + (cause == null ? 0 : cause.hashCode());
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + "; job=" + this.f10325a;
    }
}
