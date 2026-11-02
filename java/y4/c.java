package y4;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.o;
import w4.k0;
import y4.i;

/* loaded from: classes.dex */
public abstract class c<E> implements t<E> {

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f11133d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "onCloseHandler");

    /* renamed from: b, reason: collision with root package name */
    protected final o4.l<E, e4.q> f11134b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlinx.coroutines.internal.m f11135c = new kotlinx.coroutines.internal.m();
    private volatile /* synthetic */ Object onCloseHandler = null;

    public static final class a<E> extends s {

        /* renamed from: d, reason: collision with root package name */
        public final E f11136d;

        public a(E e6) {
            this.f11136d = e6;
        }

        @Override // y4.s
        public b0 A(o.b bVar) {
            return w4.m.f10322a;
        }

        @Override // kotlinx.coroutines.internal.o
        public String toString() {
            return "SendBuffered@" + k0.b(this) + '(' + this.f11136d + ')';
        }

        @Override // y4.s
        public void y() {
        }

        @Override // y4.s
        public Object z() {
            return this.f11136d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(o4.l<? super E, e4.q> lVar) {
        this.f11134b = lVar;
    }

    private final int b() {
        kotlinx.coroutines.internal.m mVar = this.f11135c;
        int i6 = 0;
        for (kotlinx.coroutines.internal.o oVar = (kotlinx.coroutines.internal.o) mVar.o(); !kotlin.jvm.internal.k.a(oVar, mVar); oVar = oVar.p()) {
            if (oVar instanceof kotlinx.coroutines.internal.o) {
                i6++;
            }
        }
        return i6;
    }

    private final String f() {
        kotlinx.coroutines.internal.o p6 = this.f11135c.p();
        if (p6 == this.f11135c) {
            return "EmptyQueue";
        }
        String oVar = p6 instanceof j ? p6.toString() : p6 instanceof o ? "ReceiveQueued" : p6 instanceof s ? "SendQueued" : kotlin.jvm.internal.k.j("UNEXPECTED:", p6);
        kotlinx.coroutines.internal.o q6 = this.f11135c.q();
        if (q6 == p6) {
            return oVar;
        }
        String str = oVar + ",queueSize=" + b();
        if (!(q6 instanceof j)) {
            return str;
        }
        return str + ",closedForSend=" + q6;
    }

    private final void g(j<?> jVar) {
        Object b6 = kotlinx.coroutines.internal.j.b(null, 1, null);
        while (true) {
            kotlinx.coroutines.internal.o q6 = jVar.q();
            o oVar = q6 instanceof o ? (o) q6 : null;
            if (oVar == null) {
                break;
            } else if (oVar.u()) {
                b6 = kotlinx.coroutines.internal.j.c(b6, oVar);
            } else {
                oVar.r();
            }
        }
        if (b6 != null) {
            if (b6 instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) b6;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i6 = size - 1;
                        ((o) arrayList.get(size)).z(jVar);
                        if (i6 < 0) {
                            break;
                        } else {
                            size = i6;
                        }
                    }
                }
            } else {
                ((o) b6).z(jVar);
            }
        }
        j(jVar);
    }

    private final Throwable h(j<?> jVar) {
        g(jVar);
        return jVar.F();
    }

    @Override // y4.t
    public final Object a(E e6) {
        i.b bVar;
        j<?> jVar;
        Object i6 = i(e6);
        if (i6 == b.f11128b) {
            return i.f11150a.c(e4.q.f3710a);
        }
        if (i6 == b.f11129c) {
            jVar = d();
            if (jVar == null) {
                return i.f11150a.b();
            }
            bVar = i.f11150a;
        } else {
            if (!(i6 instanceof j)) {
                throw new IllegalStateException(kotlin.jvm.internal.k.j("trySend returned ", i6).toString());
            }
            bVar = i.f11150a;
            jVar = (j) i6;
        }
        return bVar.a(h(jVar));
    }

    protected String c() {
        return "";
    }

    protected final j<?> d() {
        kotlinx.coroutines.internal.o q6 = this.f11135c.q();
        j<?> jVar = q6 instanceof j ? (j) q6 : null;
        if (jVar == null) {
            return null;
        }
        g(jVar);
        return jVar;
    }

    protected final kotlinx.coroutines.internal.m e() {
        return this.f11135c;
    }

    protected Object i(E e6) {
        q<E> l6;
        do {
            l6 = l();
            if (l6 == null) {
                return b.f11129c;
            }
        } while (l6.g(e6, null) == null);
        l6.c(e6);
        return l6.e();
    }

    protected void j(kotlinx.coroutines.internal.o oVar) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final q<?> k(E e6) {
        kotlinx.coroutines.internal.o q6;
        kotlinx.coroutines.internal.m mVar = this.f11135c;
        a aVar = new a(e6);
        do {
            q6 = mVar.q();
            if (q6 instanceof q) {
                return (q) q6;
            }
        } while (!q6.j(aVar, mVar));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.internal.o] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    protected q<E> l() {
        ?? r12;
        kotlinx.coroutines.internal.o v5;
        kotlinx.coroutines.internal.m mVar = this.f11135c;
        while (true) {
            r12 = (kotlinx.coroutines.internal.o) mVar.o();
            if (r12 != mVar && (r12 instanceof q)) {
                if (((((q) r12) instanceof j) && !r12.t()) || (v5 = r12.v()) == null) {
                    break;
                }
                v5.s();
            }
        }
        r12 = 0;
        return (q) r12;
    }

    protected final s m() {
        kotlinx.coroutines.internal.o oVar;
        kotlinx.coroutines.internal.o v5;
        kotlinx.coroutines.internal.m mVar = this.f11135c;
        while (true) {
            oVar = (kotlinx.coroutines.internal.o) mVar.o();
            if (oVar != mVar && (oVar instanceof s)) {
                if (((((s) oVar) instanceof j) && !oVar.t()) || (v5 = oVar.v()) == null) {
                    break;
                }
                v5.s();
            }
        }
        oVar = null;
        return (s) oVar;
    }

    public String toString() {
        return k0.a(this) + '@' + k0.b(this) + '{' + f() + '}' + c();
    }
}
