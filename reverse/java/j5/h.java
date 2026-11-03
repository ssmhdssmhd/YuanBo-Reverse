package j5;

import d5.c0;

/* loaded from: classes.dex */
public final class h extends c0 {

    /* renamed from: b, reason: collision with root package name */
    private final String f6842b;

    /* renamed from: c, reason: collision with root package name */
    private final long f6843c;

    /* renamed from: d, reason: collision with root package name */
    private final q5.g f6844d;

    public h(String str, long j6, q5.g source) {
        kotlin.jvm.internal.k.e(source, "source");
        this.f6842b = str;
        this.f6843c = j6;
        this.f6844d = source;
    }

    @Override // d5.c0
    public long j() {
        return this.f6843c;
    }

    @Override // d5.c0
    public q5.g k() {
        return this.f6844d;
    }
}
