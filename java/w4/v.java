package w4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public class v {

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f10361b = AtomicIntegerFieldUpdater.newUpdater(v.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f10362a;

    public v(Throwable th, boolean z5) {
        this.f10362a = th;
        this._handled = z5 ? 1 : 0;
    }

    public /* synthetic */ v(Throwable th, boolean z5, int i6, kotlin.jvm.internal.g gVar) {
        this(th, (i6 & 2) != 0 ? false : z5);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return f10361b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return k0.a(this) + '[' + this.f10362a + ']';
    }
}
