package l1;

import android.os.Handler;
import android.os.Looper;
import h0.m4;
import i0.o3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import l1.c0;
import l1.v;
import m0.w;

/* loaded from: classes.dex */
public abstract class a implements v {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<v.c> f7191a = new ArrayList<>(1);

    /* renamed from: b, reason: collision with root package name */
    private final HashSet<v.c> f7192b = new HashSet<>(1);

    /* renamed from: c, reason: collision with root package name */
    private final c0.a f7193c = new c0.a();

    /* renamed from: d, reason: collision with root package name */
    private final w.a f7194d = new w.a();

    /* renamed from: e, reason: collision with root package name */
    private Looper f7195e;

    /* renamed from: j, reason: collision with root package name */
    private m4 f7196j;

    /* renamed from: k, reason: collision with root package name */
    private o3 f7197k;

    protected final o3 A() {
        return (o3) i2.a.i(this.f7197k);
    }

    protected final boolean B() {
        return !this.f7192b.isEmpty();
    }

    protected abstract void C(g2.u0 u0Var);

    protected final void D(m4 m4Var) {
        this.f7196j = m4Var;
        Iterator<v.c> it = this.f7191a.iterator();
        while (it.hasNext()) {
            it.next().a(this, m4Var);
        }
    }

    protected abstract void E();

    @Override // l1.v
    public final void c(m0.w wVar) {
        this.f7194d.t(wVar);
    }

    @Override // l1.v
    public final void e(v.c cVar) {
        boolean z5 = !this.f7192b.isEmpty();
        this.f7192b.remove(cVar);
        if (z5 && this.f7192b.isEmpty()) {
            y();
        }
    }

    @Override // l1.v
    public final void g(v.c cVar) {
        i2.a.e(this.f7195e);
        boolean isEmpty = this.f7192b.isEmpty();
        this.f7192b.add(cVar);
        if (isEmpty) {
            z();
        }
    }

    @Override // l1.v
    public final void h(v.c cVar) {
        this.f7191a.remove(cVar);
        if (!this.f7191a.isEmpty()) {
            e(cVar);
            return;
        }
        this.f7195e = null;
        this.f7196j = null;
        this.f7197k = null;
        this.f7192b.clear();
        E();
    }

    @Override // l1.v
    public /* synthetic */ boolean j() {
        return u.b(this);
    }

    @Override // l1.v
    public final void k(Handler handler, m0.w wVar) {
        i2.a.e(handler);
        i2.a.e(wVar);
        this.f7194d.g(handler, wVar);
    }

    @Override // l1.v
    public final void l(Handler handler, c0 c0Var) {
        i2.a.e(handler);
        i2.a.e(c0Var);
        this.f7193c.g(handler, c0Var);
    }

    @Override // l1.v
    public /* synthetic */ m4 n() {
        return u.a(this);
    }

    @Override // l1.v
    public final void o(c0 c0Var) {
        this.f7193c.C(c0Var);
    }

    @Override // l1.v
    public final void p(v.c cVar, g2.u0 u0Var, o3 o3Var) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f7195e;
        i2.a.a(looper == null || looper == myLooper);
        this.f7197k = o3Var;
        m4 m4Var = this.f7196j;
        this.f7191a.add(cVar);
        if (this.f7195e == null) {
            this.f7195e = myLooper;
            this.f7192b.add(cVar);
            C(u0Var);
        } else if (m4Var != null) {
            g(cVar);
            cVar.a(this, m4Var);
        }
    }

    protected final w.a s(int i6, v.b bVar) {
        return this.f7194d.u(i6, bVar);
    }

    protected final w.a t(v.b bVar) {
        return this.f7194d.u(0, bVar);
    }

    protected final c0.a v(int i6, v.b bVar, long j6) {
        return this.f7193c.F(i6, bVar, j6);
    }

    protected final c0.a w(v.b bVar) {
        return this.f7193c.F(0, bVar, 0L);
    }

    protected final c0.a x(v.b bVar, long j6) {
        i2.a.e(bVar);
        return this.f7193c.F(0, bVar, j6);
    }

    protected void y() {
    }

    protected void z() {
    }
}
