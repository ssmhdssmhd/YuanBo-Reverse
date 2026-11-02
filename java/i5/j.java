package i5;

import java.io.IOException;

/* loaded from: classes.dex */
public final class j extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private IOException f5807a;

    /* renamed from: b, reason: collision with root package name */
    private final IOException f5808b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(IOException firstConnectException) {
        super(firstConnectException);
        kotlin.jvm.internal.k.e(firstConnectException, "firstConnectException");
        this.f5808b = firstConnectException;
        this.f5807a = firstConnectException;
    }

    public final void a(IOException e6) {
        kotlin.jvm.internal.k.e(e6, "e");
        e4.b.a(this.f5808b, e6);
        this.f5807a = e6;
    }

    public final IOException b() {
        return this.f5808b;
    }

    public final IOException c() {
        return this.f5807a;
    }
}
