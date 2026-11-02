package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import w4.k0;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f7057a = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_next");

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f7058b = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_prev");

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f7059c = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    public static abstract class a extends kotlinx.coroutines.internal.c<o> {

        /* renamed from: b, reason: collision with root package name */
        public final o f7060b;

        /* renamed from: c, reason: collision with root package name */
        public o f7061c;

        public a(o oVar) {
            this.f7060b = oVar;
        }

        @Override // kotlinx.coroutines.internal.c
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(o oVar, Object obj) {
            boolean z5 = obj == null;
            o oVar2 = z5 ? this.f7060b : this.f7061c;
            if (oVar2 != null && androidx.work.impl.utils.futures.b.a(o.f7057a, oVar, this, oVar2) && z5) {
                o oVar3 = this.f7060b;
                o oVar4 = this.f7061c;
                kotlin.jvm.internal.k.b(oVar4);
                oVar3.n(oVar4);
            }
        }
    }

    public static final class b extends w {
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (androidx.work.impl.utils.futures.b.a(kotlinx.coroutines.internal.o.f7057a, r3, r2, ((kotlinx.coroutines.internal.x) r4).f7081a) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlinx.coroutines.internal.o l(kotlinx.coroutines.internal.w r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.o r0 = (kotlinx.coroutines.internal.o) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.o.f7058b
            boolean r0 = androidx.work.impl.utils.futures.b.a(r1, r7, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r7.t()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r8) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.w
            if (r5 == 0) goto L38
            if (r8 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.w r0 = (kotlinx.coroutines.internal.w) r0
            boolean r0 = r8.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.w r4 = (kotlinx.coroutines.internal.w) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.x
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.o.f7057a
            kotlinx.coroutines.internal.x r4 = (kotlinx.coroutines.internal.x) r4
            kotlinx.coroutines.internal.o r4 = r4.f7081a
            boolean r2 = androidx.work.impl.utils.futures.b.a(r5, r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.o r2 = (kotlinx.coroutines.internal.o) r2
            goto L7
        L52:
            r3 = r4
            kotlinx.coroutines.internal.o r3 = (kotlinx.coroutines.internal.o) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.o.l(kotlinx.coroutines.internal.w):kotlinx.coroutines.internal.o");
    }

    private final o m(o oVar) {
        while (oVar.t()) {
            oVar = (o) oVar._prev;
        }
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(o oVar) {
        o oVar2;
        do {
            oVar2 = (o) oVar._prev;
            if (o() != oVar) {
                return;
            }
        } while (!androidx.work.impl.utils.futures.b.a(f7058b, oVar, oVar2, this));
        if (t()) {
            oVar.l(null);
        }
    }

    private final x w() {
        x xVar = (x) this._removedRef;
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(this);
        f7059c.lazySet(this, xVar2);
        return xVar2;
    }

    public final boolean j(o oVar, o oVar2) {
        f7058b.lazySet(oVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7057a;
        atomicReferenceFieldUpdater.lazySet(oVar, oVar2);
        if (!androidx.work.impl.utils.futures.b.a(atomicReferenceFieldUpdater, this, oVar2, oVar)) {
            return false;
        }
        oVar.n(oVar2);
        return true;
    }

    public final boolean k(o oVar) {
        f7058b.lazySet(oVar, this);
        f7057a.lazySet(oVar, this);
        while (o() == this) {
            if (androidx.work.impl.utils.futures.b.a(f7057a, this, this, oVar)) {
                oVar.n(this);
                return true;
            }
        }
        return false;
    }

    public final Object o() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof w)) {
                return obj;
            }
            ((w) obj).c(this);
        }
    }

    public final o p() {
        return n.b(o());
    }

    public final o q() {
        o l6 = l(null);
        return l6 == null ? m((o) this._prev) : l6;
    }

    public final void r() {
        ((x) o()).f7081a.s();
    }

    public final void s() {
        o oVar = this;
        while (true) {
            Object o6 = oVar.o();
            if (!(o6 instanceof x)) {
                oVar.l(null);
                return;
            }
            oVar = ((x) o6).f7081a;
        }
    }

    public boolean t() {
        return o() instanceof x;
    }

    public String toString() {
        return new kotlin.jvm.internal.o(this) { // from class: kotlinx.coroutines.internal.o.c
            @Override // t4.f
            public Object get() {
                return k0.a(this.receiver);
            }
        } + '@' + k0.b(this);
    }

    public boolean u() {
        return v() == null;
    }

    public final o v() {
        Object o6;
        o oVar;
        do {
            o6 = o();
            if (o6 instanceof x) {
                return ((x) o6).f7081a;
            }
            if (o6 == this) {
                return (o) o6;
            }
            oVar = (o) o6;
        } while (!androidx.work.impl.utils.futures.b.a(f7057a, this, o6, oVar.w()));
        oVar.l(null);
        return null;
    }

    public final int x(o oVar, o oVar2, a aVar) {
        f7058b.lazySet(oVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7057a;
        atomicReferenceFieldUpdater.lazySet(oVar, oVar2);
        aVar.f7061c = oVar2;
        if (androidx.work.impl.utils.futures.b.a(atomicReferenceFieldUpdater, this, oVar2, aVar)) {
            return aVar.c(this) == null ? 1 : 2;
        }
        return 0;
    }
}
