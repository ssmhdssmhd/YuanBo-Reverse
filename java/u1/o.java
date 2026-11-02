package u1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import h0.y1;
import h0.y3;
import h0.z1;
import i2.c1;
import i2.t;
import i2.x;
import m2.q;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class o extends h0.l implements Handler.Callback {
    private i A;
    private l B;
    private m C;
    private m D;
    private int E;
    private long F;
    private long G;
    private long H;

    /* renamed from: r, reason: collision with root package name */
    private final Handler f9658r;

    /* renamed from: s, reason: collision with root package name */
    private final n f9659s;

    /* renamed from: t, reason: collision with root package name */
    private final k f9660t;

    /* renamed from: u, reason: collision with root package name */
    private final z1 f9661u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f9662v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f9663w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f9664x;

    /* renamed from: y, reason: collision with root package name */
    private int f9665y;

    /* renamed from: z, reason: collision with root package name */
    private y1 f9666z;

    public o(n nVar, Looper looper) {
        this(nVar, looper, k.f9654a);
    }

    public o(n nVar, Looper looper, k kVar) {
        super(3);
        this.f9659s = (n) i2.a.e(nVar);
        this.f9658r = looper == null ? null : c1.v(looper, this);
        this.f9660t = kVar;
        this.f9661u = new z1();
        this.F = -9223372036854775807L;
        this.G = -9223372036854775807L;
        this.H = -9223372036854775807L;
    }

    private void R() {
        c0(new e(q.q(), U(this.H)));
    }

    @RequiresNonNull({"subtitle"})
    @SideEffectFree
    private long S(long j6) {
        int a6 = this.C.a(j6);
        if (a6 == 0 || this.C.d() == 0) {
            return this.C.f7170b;
        }
        if (a6 != -1) {
            return this.C.b(a6 - 1);
        }
        return this.C.b(r2.d() - 1);
    }

    private long T() {
        if (this.E == -1) {
            return Long.MAX_VALUE;
        }
        i2.a.e(this.C);
        if (this.E >= this.C.d()) {
            return Long.MAX_VALUE;
        }
        return this.C.b(this.E);
    }

    @SideEffectFree
    private long U(long j6) {
        i2.a.g(j6 != -9223372036854775807L);
        i2.a.g(this.G != -9223372036854775807L);
        return j6 - this.G;
    }

    private void V(j jVar) {
        t.d("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.f9666z, jVar);
        R();
        a0();
    }

    private void W() {
        this.f9664x = true;
        this.A = this.f9660t.b((y1) i2.a.e(this.f9666z));
    }

    private void X(e eVar) {
        this.f9659s.m(eVar.f9642a);
        this.f9659s.l(eVar);
    }

    private void Y() {
        this.B = null;
        this.E = -1;
        m mVar = this.C;
        if (mVar != null) {
            mVar.o();
            this.C = null;
        }
        m mVar2 = this.D;
        if (mVar2 != null) {
            mVar2.o();
            this.D = null;
        }
    }

    private void Z() {
        Y();
        ((i) i2.a.e(this.A)).a();
        this.A = null;
        this.f9665y = 0;
    }

    private void a0() {
        Z();
        W();
    }

    private void c0(e eVar) {
        Handler handler = this.f9658r;
        if (handler != null) {
            handler.obtainMessage(0, eVar).sendToTarget();
        } else {
            X(eVar);
        }
    }

    @Override // h0.l
    protected void H() {
        this.f9666z = null;
        this.F = -9223372036854775807L;
        R();
        this.G = -9223372036854775807L;
        this.H = -9223372036854775807L;
        Z();
    }

    @Override // h0.l
    protected void J(long j6, boolean z5) {
        this.H = j6;
        R();
        this.f9662v = false;
        this.f9663w = false;
        this.F = -9223372036854775807L;
        if (this.f9665y != 0) {
            a0();
        } else {
            Y();
            ((i) i2.a.e(this.A)).flush();
        }
    }

    @Override // h0.l
    protected void N(y1[] y1VarArr, long j6, long j7) {
        this.G = j7;
        this.f9666z = y1VarArr[0];
        if (this.A != null) {
            this.f9665y = 1;
        } else {
            W();
        }
    }

    @Override // h0.z3
    public int a(y1 y1Var) {
        if (this.f9660t.a(y1Var)) {
            return y3.a(y1Var.K == 0 ? 4 : 2);
        }
        return y3.a(x.r(y1Var.f5066p) ? 1 : 0);
    }

    public void b0(long j6) {
        i2.a.g(t());
        this.F = j6;
    }

    @Override // h0.x3
    public boolean c() {
        return this.f9663w;
    }

    @Override // h0.x3
    public boolean e() {
        return true;
    }

    @Override // h0.x3, h0.z3
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        X((e) message.obj);
        return true;
    }

    @Override // h0.x3
    public void l(long j6, long j7) {
        boolean z5;
        this.H = j6;
        if (t()) {
            long j8 = this.F;
            if (j8 != -9223372036854775807L && j6 >= j8) {
                Y();
                this.f9663w = true;
            }
        }
        if (this.f9663w) {
            return;
        }
        if (this.D == null) {
            ((i) i2.a.e(this.A)).b(j6);
            try {
                this.D = ((i) i2.a.e(this.A)).d();
            } catch (j e6) {
                V(e6);
                return;
            }
        }
        if (getState() != 2) {
            return;
        }
        if (this.C != null) {
            long T = T();
            z5 = false;
            while (T <= j6) {
                this.E++;
                T = T();
                z5 = true;
            }
        } else {
            z5 = false;
        }
        m mVar = this.D;
        if (mVar != null) {
            if (mVar.k()) {
                if (!z5 && T() == Long.MAX_VALUE) {
                    if (this.f9665y == 2) {
                        a0();
                    } else {
                        Y();
                        this.f9663w = true;
                    }
                }
            } else if (mVar.f7170b <= j6) {
                m mVar2 = this.C;
                if (mVar2 != null) {
                    mVar2.o();
                }
                this.E = mVar.a(j6);
                this.C = mVar;
                this.D = null;
                z5 = true;
            }
        }
        if (z5) {
            i2.a.e(this.C);
            c0(new e(this.C.c(j6), U(S(j6))));
        }
        if (this.f9665y == 2) {
            return;
        }
        while (!this.f9662v) {
            try {
                l lVar = this.B;
                if (lVar == null) {
                    lVar = ((i) i2.a.e(this.A)).e();
                    if (lVar == null) {
                        return;
                    } else {
                        this.B = lVar;
                    }
                }
                if (this.f9665y == 1) {
                    lVar.n(4);
                    ((i) i2.a.e(this.A)).c(lVar);
                    this.B = null;
                    this.f9665y = 2;
                    return;
                }
                int O = O(this.f9661u, lVar, 0);
                if (O == -4) {
                    if (lVar.k()) {
                        this.f9662v = true;
                        this.f9664x = false;
                    } else {
                        y1 y1Var = this.f9661u.f5109b;
                        if (y1Var == null) {
                            return;
                        }
                        lVar.f9655m = y1Var.f5070t;
                        lVar.q();
                        this.f9664x &= !lVar.m();
                    }
                    if (!this.f9664x) {
                        ((i) i2.a.e(this.A)).c(lVar);
                        this.B = null;
                    }
                } else if (O == -3) {
                    return;
                }
            } catch (j e7) {
                V(e7);
                return;
            }
        }
    }
}
