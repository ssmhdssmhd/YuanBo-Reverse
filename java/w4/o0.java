package w4;

/* loaded from: classes.dex */
final class o0 extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private final h4.g f10327a;

    public o0(h4.g gVar) {
        this.f10327a = gVar;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.f10327a.toString();
    }
}
