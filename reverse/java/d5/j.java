package d5;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private final i5.h f3152a;

    public j() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(int i6, long j6, TimeUnit timeUnit) {
        this(new i5.h(h5.e.f5261h, i6, j6, timeUnit));
        kotlin.jvm.internal.k.e(timeUnit, "timeUnit");
    }

    public j(i5.h delegate) {
        kotlin.jvm.internal.k.e(delegate, "delegate");
        this.f3152a = delegate;
    }

    public final i5.h a() {
        return this.f3152a;
    }
}
