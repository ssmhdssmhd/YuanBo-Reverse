package h5;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private d f5248a;

    /* renamed from: b, reason: collision with root package name */
    private long f5249b;

    /* renamed from: c, reason: collision with root package name */
    private final String f5250c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f5251d;

    public a(String name, boolean z5) {
        k.e(name, "name");
        this.f5250c = name;
        this.f5251d = z5;
        this.f5249b = -1L;
    }

    public /* synthetic */ a(String str, boolean z5, int i6, g gVar) {
        this(str, (i6 & 2) != 0 ? true : z5);
    }

    public final boolean a() {
        return this.f5251d;
    }

    public final String b() {
        return this.f5250c;
    }

    public final long c() {
        return this.f5249b;
    }

    public final d d() {
        return this.f5248a;
    }

    public final void e(d queue) {
        k.e(queue, "queue");
        d dVar = this.f5248a;
        if (dVar == queue) {
            return;
        }
        if (!(dVar == null)) {
            throw new IllegalStateException("task is in multiple queues".toString());
        }
        this.f5248a = queue;
    }

    public abstract long f();

    public final void g(long j6) {
        this.f5249b = j6;
    }

    public String toString() {
        return this.f5250c;
    }
}
