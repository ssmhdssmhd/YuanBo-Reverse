package w4;

/* loaded from: classes.dex */
final class v0 implements g1 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f10363a;

    public v0(boolean z5) {
        this.f10363a = z5;
    }

    @Override // w4.g1
    public boolean a() {
        return this.f10363a;
    }

    @Override // w4.g1
    public w1 h() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(a() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
