package kotlinx.coroutines.internal;

/* loaded from: classes.dex */
public final class e implements w4.g0 {

    /* renamed from: a, reason: collision with root package name */
    private final h4.g f7028a;

    public e(h4.g gVar) {
        this.f7028a = gVar;
    }

    @Override // w4.g0
    public h4.g e() {
        return this.f7028a;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + e() + ')';
    }
}
