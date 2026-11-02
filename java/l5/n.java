package l5;

import java.io.IOException;

/* loaded from: classes.dex */
public final class n extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final b f7731a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(b errorCode) {
        super("stream was reset: " + errorCode);
        kotlin.jvm.internal.k.e(errorCode, "errorCode");
        this.f7731a = errorCode;
    }
}
