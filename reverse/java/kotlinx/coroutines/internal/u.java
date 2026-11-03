package kotlinx.coroutines.internal;

import w4.n0;
import w4.v1;

/* loaded from: classes.dex */
final class u extends v1 implements n0 {

    /* renamed from: b, reason: collision with root package name */
    private final Throwable f7076b;

    /* renamed from: c, reason: collision with root package name */
    private final String f7077c;

    public u(Throwable th, String str) {
        this.f7076b = th;
        this.f7077c = str;
    }

    private final Void b0() {
        String j6;
        if (this.f7076b == null) {
            t.d();
            throw new e4.d();
        }
        String str = this.f7077c;
        String str2 = "";
        if (str != null && (j6 = kotlin.jvm.internal.k.j(". ", str)) != null) {
            str2 = j6;
        }
        throw new IllegalStateException(kotlin.jvm.internal.k.j("Module with the Main dispatcher had failed to initialize", str2), this.f7076b);
    }

    @Override // w4.c0
    public boolean W(h4.g gVar) {
        b0();
        throw new e4.d();
    }

    @Override // w4.v1
    public v1 Y() {
        return this;
    }

    @Override // w4.c0
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public Void V(h4.g gVar, Runnable runnable) {
        b0();
        throw new e4.d();
    }

    @Override // w4.v1, w4.c0
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        Throwable th = this.f7076b;
        sb.append(th != null ? kotlin.jvm.internal.k.j(", cause=", th) : "");
        sb.append(']');
        return sb.toString();
    }
}
