package b1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import b1.a;
import h0.l;
import h0.y1;
import h0.y3;
import h0.z1;
import i2.c1;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* loaded from: classes.dex */
public final class g extends l implements Handler.Callback {
    private a A;
    private long B;

    /* renamed from: r, reason: collision with root package name */
    private final d f1698r;

    /* renamed from: s, reason: collision with root package name */
    private final f f1699s;

    /* renamed from: t, reason: collision with root package name */
    private final Handler f1700t;

    /* renamed from: u, reason: collision with root package name */
    private final e f1701u;

    /* renamed from: v, reason: collision with root package name */
    private final boolean f1702v;

    /* renamed from: w, reason: collision with root package name */
    private c f1703w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f1704x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f1705y;

    /* renamed from: z, reason: collision with root package name */
    private long f1706z;

    public g(f fVar, Looper looper) {
        this(fVar, looper, d.f1696a);
    }

    public g(f fVar, Looper looper, d dVar) {
        this(fVar, looper, dVar, false);
    }

    public g(f fVar, Looper looper, d dVar, boolean z5) {
        super(5);
        this.f1699s = (f) i2.a.e(fVar);
        this.f1700t = looper == null ? null : c1.v(looper, this);
        this.f1698r = (d) i2.a.e(dVar);
        this.f1702v = z5;
        this.f1701u = new e();
        this.B = -9223372036854775807L;
    }

    private void R(a aVar, List<a.b> list) {
        for (int i6 = 0; i6 < aVar.h(); i6++) {
            y1 b6 = aVar.g(i6).b();
            if (b6 == null || !this.f1698r.a(b6)) {
                list.add(aVar.g(i6));
            } else {
                c b7 = this.f1698r.b(b6);
                byte[] bArr = (byte[]) i2.a.e(aVar.g(i6).c());
                this.f1701u.f();
                this.f1701u.p(bArr.length);
                ((ByteBuffer) c1.j(this.f1701u.f7162c)).put(bArr);
                this.f1701u.q();
                a a6 = b7.a(this.f1701u);
                if (a6 != null) {
                    R(a6, list);
                }
            }
        }
    }

    @SideEffectFree
    private long S(long j6) {
        i2.a.g(j6 != -9223372036854775807L);
        i2.a.g(this.B != -9223372036854775807L);
        return j6 - this.B;
    }

    private void T(a aVar) {
        Handler handler = this.f1700t;
        if (handler != null) {
            handler.obtainMessage(0, aVar).sendToTarget();
        } else {
            U(aVar);
        }
    }

    private void U(a aVar) {
        this.f1699s.j(aVar);
    }

    private boolean V(long j6) {
        boolean z5;
        a aVar = this.A;
        if (aVar == null || (!this.f1702v && aVar.f1695b > S(j6))) {
            z5 = false;
        } else {
            T(this.A);
            this.A = null;
            z5 = true;
        }
        if (this.f1704x && this.A == null) {
            this.f1705y = true;
        }
        return z5;
    }

    private void W() {
        if (this.f1704x || this.A != null) {
            return;
        }
        this.f1701u.f();
        z1 C = C();
        int O = O(C, this.f1701u, 0);
        if (O != -4) {
            if (O == -5) {
                this.f1706z = ((y1) i2.a.e(C.f5109b)).f5070t;
            }
        } else {
            if (this.f1701u.k()) {
                this.f1704x = true;
                return;
            }
            e eVar = this.f1701u;
            eVar.f1697m = this.f1706z;
            eVar.q();
            a a6 = ((c) c1.j(this.f1703w)).a(this.f1701u);
            if (a6 != null) {
                ArrayList arrayList = new ArrayList(a6.h());
                R(a6, arrayList);
                if (arrayList.isEmpty()) {
                    return;
                }
                this.A = new a(S(this.f1701u.f7164e), arrayList);
            }
        }
    }

    @Override // h0.l
    protected void H() {
        this.A = null;
        this.f1703w = null;
        this.B = -9223372036854775807L;
    }

    @Override // h0.l
    protected void J(long j6, boolean z5) {
        this.A = null;
        this.f1704x = false;
        this.f1705y = false;
    }

    @Override // h0.l
    protected void N(y1[] y1VarArr, long j6, long j7) {
        this.f1703w = this.f1698r.b(y1VarArr[0]);
        a aVar = this.A;
        if (aVar != null) {
            this.A = aVar.f((aVar.f1695b + this.B) - j7);
        }
        this.B = j7;
    }

    @Override // h0.z3
    public int a(y1 y1Var) {
        if (this.f1698r.a(y1Var)) {
            return y3.a(y1Var.K == 0 ? 4 : 2);
        }
        return y3.a(0);
    }

    @Override // h0.x3
    public boolean c() {
        return this.f1705y;
    }

    @Override // h0.x3
    public boolean e() {
        return true;
    }

    @Override // h0.x3, h0.z3
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        U((a) message.obj);
        return true;
    }

    @Override // h0.x3
    public void l(long j6, long j7) {
        boolean z5 = true;
        while (z5) {
            W();
            z5 = V(j6);
        }
    }
}
