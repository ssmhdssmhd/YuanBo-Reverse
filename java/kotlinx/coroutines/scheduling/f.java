package kotlinx.coroutines.scheduling;

import w4.c1;

/* loaded from: classes.dex */
public class f extends c1 {

    /* renamed from: c, reason: collision with root package name */
    private final int f7114c;

    /* renamed from: d, reason: collision with root package name */
    private final int f7115d;

    /* renamed from: e, reason: collision with root package name */
    private final long f7116e;

    /* renamed from: j, reason: collision with root package name */
    private final String f7117j;

    /* renamed from: k, reason: collision with root package name */
    private a f7118k = Y();

    public f(int i6, int i7, long j6, String str) {
        this.f7114c = i6;
        this.f7115d = i7;
        this.f7116e = j6;
        this.f7117j = str;
    }

    private final a Y() {
        return new a(this.f7114c, this.f7115d, this.f7116e, this.f7117j);
    }

    @Override // w4.c0
    public void V(h4.g gVar, Runnable runnable) {
        a.t(this.f7118k, runnable, null, false, 6, null);
    }

    public final void Z(Runnable runnable, i iVar, boolean z5) {
        this.f7118k.s(runnable, iVar, z5);
    }
}
