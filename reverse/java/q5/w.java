package q5;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: c, reason: collision with root package name */
    private static final int f8999c;

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicReference<v>[] f9000d;

    /* renamed from: e, reason: collision with root package name */
    public static final w f9001e = new w();

    /* renamed from: a, reason: collision with root package name */
    private static final int f8997a = 65536;

    /* renamed from: b, reason: collision with root package name */
    private static final v f8998b = new v(new byte[0], 0, 0, false, false);

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f8999c = highestOneBit;
        AtomicReference<v>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i6 = 0; i6 < highestOneBit; i6++) {
            atomicReferenceArr[i6] = new AtomicReference<>();
        }
        f9000d = atomicReferenceArr;
    }

    private w() {
    }

    private final AtomicReference<v> a() {
        Thread currentThread = Thread.currentThread();
        kotlin.jvm.internal.k.d(currentThread, "Thread.currentThread()");
        return f9000d[(int) (currentThread.getId() & (f8999c - 1))];
    }

    public static final void b(v segment) {
        AtomicReference<v> a6;
        v vVar;
        kotlin.jvm.internal.k.e(segment, "segment");
        if (!(segment.f8995f == null && segment.f8996g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (segment.f8993d || (vVar = (a6 = f9001e.a()).get()) == f8998b) {
            return;
        }
        int i6 = vVar != null ? vVar.f8992c : 0;
        if (i6 >= f8997a) {
            return;
        }
        segment.f8995f = vVar;
        segment.f8991b = 0;
        segment.f8992c = i6 + 8192;
        if (a1.g.a(a6, vVar, segment)) {
            return;
        }
        segment.f8995f = null;
    }

    public static final v c() {
        AtomicReference<v> a6 = f9001e.a();
        v vVar = f8998b;
        v andSet = a6.getAndSet(vVar);
        if (andSet == vVar) {
            return new v();
        }
        if (andSet == null) {
            a6.set(null);
            return new v();
        }
        a6.set(andSet.f8995f);
        andSet.f8995f = null;
        andSet.f8992c = 0;
        return andSet;
    }
}
