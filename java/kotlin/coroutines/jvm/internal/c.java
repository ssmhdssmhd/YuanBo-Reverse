package kotlin.coroutines.jvm.internal;

/* loaded from: classes.dex */
public final class c implements h4.d<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final c f6992a = new c();

    private c() {
    }

    @Override // h4.d
    public h4.g getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // h4.d
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
