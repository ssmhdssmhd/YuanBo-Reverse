package k2;

import h0.y1;
import h0.y3;
import i2.c1;
import i2.i0;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class b extends h0.l {

    /* renamed from: r, reason: collision with root package name */
    private final l0.i f6863r;

    /* renamed from: s, reason: collision with root package name */
    private final i0 f6864s;

    /* renamed from: t, reason: collision with root package name */
    private long f6865t;

    /* renamed from: u, reason: collision with root package name */
    private a f6866u;

    /* renamed from: v, reason: collision with root package name */
    private long f6867v;

    public b() {
        super(6);
        this.f6863r = new l0.i(1);
        this.f6864s = new i0();
    }

    private float[] R(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f6864s.Q(byteBuffer.array(), byteBuffer.limit());
        this.f6864s.S(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i6 = 0; i6 < 3; i6++) {
            fArr[i6] = Float.intBitsToFloat(this.f6864s.s());
        }
        return fArr;
    }

    private void S() {
        a aVar = this.f6866u;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // h0.l
    protected void H() {
        S();
    }

    @Override // h0.l
    protected void J(long j6, boolean z5) {
        this.f6867v = Long.MIN_VALUE;
        S();
    }

    @Override // h0.l
    protected void N(y1[] y1VarArr, long j6, long j7) {
        this.f6865t = j7;
    }

    @Override // h0.z3
    public int a(y1 y1Var) {
        return y3.a("application/x-camera-motion".equals(y1Var.f5066p) ? 4 : 0);
    }

    @Override // h0.x3
    public boolean c() {
        return j();
    }

    @Override // h0.x3
    public boolean e() {
        return true;
    }

    @Override // h0.x3, h0.z3
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // h0.x3
    public void l(long j6, long j7) {
        while (!j() && this.f6867v < 100000 + j6) {
            this.f6863r.f();
            if (O(C(), this.f6863r, 0) != -4 || this.f6863r.k()) {
                return;
            }
            l0.i iVar = this.f6863r;
            this.f6867v = iVar.f7164e;
            if (this.f6866u != null && !iVar.j()) {
                this.f6863r.q();
                float[] R = R((ByteBuffer) c1.j(this.f6863r.f7162c));
                if (R != null) {
                    ((a) c1.j(this.f6866u)).a(this.f6867v - this.f6865t, R);
                }
            }
        }
    }

    @Override // h0.l, h0.s3.b
    public void m(int i6, Object obj) {
        if (i6 == 8) {
            this.f6866u = (a) obj;
        } else {
            super.m(i6, obj);
        }
    }
}
