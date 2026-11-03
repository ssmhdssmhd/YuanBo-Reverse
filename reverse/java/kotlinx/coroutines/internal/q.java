package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class q<E> {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* renamed from: a, reason: collision with root package name */
    private final int f7067a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f7068b;

    /* renamed from: c, reason: collision with root package name */
    private final int f7069c;

    /* renamed from: d, reason: collision with root package name */
    private /* synthetic */ AtomicReferenceArray f7070d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f7063e = new a(null);

    /* renamed from: h, reason: collision with root package name */
    public static final b0 f7066h = new b0("REMOVE_FROZEN");

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f7064f = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_next");

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f7065g = AtomicLongFieldUpdater.newUpdater(q.class, "_state");

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final int a(long j6) {
            return (j6 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j6, int i6) {
            return d(j6, 1073741823L) | (i6 << 0);
        }

        public final long c(long j6, int i6) {
            return d(j6, 1152921503533105152L) | (i6 << 30);
        }

        public final long d(long j6, long j7) {
            return j6 & (~j7);
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f7071a;

        public b(int i6) {
            this.f7071a = i6;
        }
    }

    public q(int i6, boolean z5) {
        this.f7067a = i6;
        this.f7068b = z5;
        int i7 = i6 - 1;
        this.f7069c = i7;
        this.f7070d = new AtomicReferenceArray(i6);
        if (!(i7 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i6 & i7) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final q<E> b(long j6) {
        q<E> qVar = new q<>(this.f7067a * 2, this.f7068b);
        int i6 = (int) ((1073741823 & j6) >> 0);
        int i7 = (int) ((1152921503533105152L & j6) >> 30);
        while (true) {
            int i8 = this.f7069c;
            if ((i6 & i8) == (i7 & i8)) {
                qVar._state = f7063e.d(j6, 1152921504606846976L);
                return qVar;
            }
            Object obj = this.f7070d.get(i8 & i6);
            if (obj == null) {
                obj = new b(i6);
            }
            qVar.f7070d.set(qVar.f7069c & i6, obj);
            i6++;
        }
    }

    private final q<E> c(long j6) {
        while (true) {
            q<E> qVar = (q) this._next;
            if (qVar != null) {
                return qVar;
            }
            androidx.work.impl.utils.futures.b.a(f7064f, this, null, b(j6));
        }
    }

    private final q<E> e(int i6, E e6) {
        Object obj = this.f7070d.get(this.f7069c & i6);
        if (!(obj instanceof b) || ((b) obj).f7071a != i6) {
            return null;
        }
        this.f7070d.set(i6 & this.f7069c, e6);
        return this;
    }

    private final long h() {
        long j6;
        long j7;
        do {
            j6 = this._state;
            if ((j6 & 1152921504606846976L) != 0) {
                return j6;
            }
            j7 = j6 | 1152921504606846976L;
        } while (!f7065g.compareAndSet(this, j6, j7));
        return j7;
    }

    private final q<E> k(int i6, int i7) {
        long j6;
        int i8;
        do {
            j6 = this._state;
            i8 = (int) ((1073741823 & j6) >> 0);
            if ((1152921504606846976L & j6) != 0) {
                return i();
            }
        } while (!f7065g.compareAndSet(this, j6, f7063e.b(j6, i7)));
        this.f7070d.set(i8 & this.f7069c, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(E r13) {
        /*
            r12 = this;
        L0:
            long r2 = r12._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L12
            kotlinx.coroutines.internal.q$a r13 = kotlinx.coroutines.internal.q.f7063e
            int r13 = r13.a(r2)
            return r13
        L12:
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            r8 = 0
            long r0 = r0 >> r8
            int r1 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r0 = 30
            long r4 = r4 >> r0
            int r9 = (int) r4
            int r10 = r12.f7069c
            int r0 = r9 + 2
            r0 = r0 & r10
            r4 = r1 & r10
            r5 = 1
            if (r0 != r4) goto L2e
            return r5
        L2e:
            boolean r0 = r12.f7068b
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 != 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f7070d
            r11 = r9 & r10
            java.lang.Object r0 = r0.get(r11)
            if (r0 == 0) goto L4d
            int r0 = r12.f7067a
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L4c
            int r9 = r9 - r1
            r1 = r9 & r4
            int r0 = r0 >> 1
            if (r1 <= r0) goto L0
        L4c:
            return r5
        L4d:
            int r0 = r9 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.q.f7065g
            kotlinx.coroutines.internal.q$a r4 = kotlinx.coroutines.internal.q.f7063e
            long r4 = r4.c(r2, r0)
            r0 = r1
            r1 = r12
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f7070d
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L68:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L72
            goto L7c
        L72:
            kotlinx.coroutines.internal.q r0 = r0.i()
            kotlinx.coroutines.internal.q r0 = r0.e(r9, r13)
            if (r0 != 0) goto L68
        L7c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.q.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j6;
        do {
            j6 = this._state;
            if ((j6 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j6) != 0) {
                return false;
            }
        } while (!f7065g.compareAndSet(this, j6, j6 | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j6 = this._state;
        return 1073741823 & (((int) ((j6 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j6) >> 0)));
    }

    public final boolean g() {
        long j6 = this._state;
        return ((int) ((1073741823 & j6) >> 0)) == ((int) ((j6 & 1152921503533105152L) >> 30));
    }

    public final q<E> i() {
        return c(h());
    }

    public final Object j() {
        while (true) {
            long j6 = this._state;
            if ((1152921504606846976L & j6) != 0) {
                return f7066h;
            }
            int i6 = (int) ((1073741823 & j6) >> 0);
            int i7 = (int) ((1152921503533105152L & j6) >> 30);
            int i8 = this.f7069c;
            if ((i7 & i8) == (i6 & i8)) {
                return null;
            }
            Object obj = this.f7070d.get(i8 & i6);
            if (obj == null) {
                if (this.f7068b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i9 = (i6 + 1) & 1073741823;
                if (f7065g.compareAndSet(this, j6, f7063e.b(j6, i9))) {
                    this.f7070d.set(this.f7069c & i6, null);
                    return obj;
                }
                if (this.f7068b) {
                    q<E> qVar = this;
                    do {
                        qVar = qVar.k(i6, i9);
                    } while (qVar != null);
                    return obj;
                }
            }
        }
    }
}
