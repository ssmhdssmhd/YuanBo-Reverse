package j0;

import j0.i;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: classes.dex */
public final class p1 implements i {

    /* renamed from: b, reason: collision with root package name */
    private int f6509b;

    /* renamed from: c, reason: collision with root package name */
    private float f6510c = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private float f6511d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    private i.a f6512e;

    /* renamed from: f, reason: collision with root package name */
    private i.a f6513f;

    /* renamed from: g, reason: collision with root package name */
    private i.a f6514g;

    /* renamed from: h, reason: collision with root package name */
    private i.a f6515h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f6516i;

    /* renamed from: j, reason: collision with root package name */
    private o1 f6517j;

    /* renamed from: k, reason: collision with root package name */
    private ByteBuffer f6518k;

    /* renamed from: l, reason: collision with root package name */
    private ShortBuffer f6519l;

    /* renamed from: m, reason: collision with root package name */
    private ByteBuffer f6520m;

    /* renamed from: n, reason: collision with root package name */
    private long f6521n;

    /* renamed from: o, reason: collision with root package name */
    private long f6522o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f6523p;

    public p1() {
        i.a aVar = i.a.f6443e;
        this.f6512e = aVar;
        this.f6513f = aVar;
        this.f6514g = aVar;
        this.f6515h = aVar;
        ByteBuffer byteBuffer = i.f6442a;
        this.f6518k = byteBuffer;
        this.f6519l = byteBuffer.asShortBuffer();
        this.f6520m = byteBuffer;
        this.f6509b = -1;
    }

    @Override // j0.i
    public boolean a() {
        return this.f6513f.f6444a != -1 && (Math.abs(this.f6510c - 1.0f) >= 1.0E-4f || Math.abs(this.f6511d - 1.0f) >= 1.0E-4f || this.f6513f.f6444a != this.f6512e.f6444a);
    }

    @Override // j0.i
    public ByteBuffer b() {
        int k6;
        o1 o1Var = this.f6517j;
        if (o1Var != null && (k6 = o1Var.k()) > 0) {
            if (this.f6518k.capacity() < k6) {
                ByteBuffer order = ByteBuffer.allocateDirect(k6).order(ByteOrder.nativeOrder());
                this.f6518k = order;
                this.f6519l = order.asShortBuffer();
            } else {
                this.f6518k.clear();
                this.f6519l.clear();
            }
            o1Var.j(this.f6519l);
            this.f6522o += k6;
            this.f6518k.limit(k6);
            this.f6520m = this.f6518k;
        }
        ByteBuffer byteBuffer = this.f6520m;
        this.f6520m = i.f6442a;
        return byteBuffer;
    }

    @Override // j0.i
    public boolean c() {
        o1 o1Var;
        return this.f6523p && ((o1Var = this.f6517j) == null || o1Var.k() == 0);
    }

    @Override // j0.i
    public void d() {
        o1 o1Var = this.f6517j;
        if (o1Var != null) {
            o1Var.s();
        }
        this.f6523p = true;
    }

    @Override // j0.i
    public void e(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            o1 o1Var = (o1) i2.a.e(this.f6517j);
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f6521n += remaining;
            o1Var.t(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    @Override // j0.i
    public i.a f(i.a aVar) {
        if (aVar.f6446c != 2) {
            throw new i.b(aVar);
        }
        int i6 = this.f6509b;
        if (i6 == -1) {
            i6 = aVar.f6444a;
        }
        this.f6512e = aVar;
        i.a aVar2 = new i.a(i6, aVar.f6445b, 2);
        this.f6513f = aVar2;
        this.f6516i = true;
        return aVar2;
    }

    @Override // j0.i
    public void flush() {
        if (a()) {
            i.a aVar = this.f6512e;
            this.f6514g = aVar;
            i.a aVar2 = this.f6513f;
            this.f6515h = aVar2;
            if (this.f6516i) {
                this.f6517j = new o1(aVar.f6444a, aVar.f6445b, this.f6510c, this.f6511d, aVar2.f6444a);
            } else {
                o1 o1Var = this.f6517j;
                if (o1Var != null) {
                    o1Var.i();
                }
            }
        }
        this.f6520m = i.f6442a;
        this.f6521n = 0L;
        this.f6522o = 0L;
        this.f6523p = false;
    }

    public long g(long j6) {
        if (this.f6522o < 1024) {
            return (long) (this.f6510c * j6);
        }
        long l6 = this.f6521n - ((o1) i2.a.e(this.f6517j)).l();
        int i6 = this.f6515h.f6444a;
        int i7 = this.f6514g.f6444a;
        return i6 == i7 ? i2.c1.P0(j6, l6, this.f6522o) : i2.c1.P0(j6, l6 * i6, this.f6522o * i7);
    }

    public void h(float f6) {
        if (this.f6511d != f6) {
            this.f6511d = f6;
            this.f6516i = true;
        }
    }

    public void i(float f6) {
        if (this.f6510c != f6) {
            this.f6510c = f6;
            this.f6516i = true;
        }
    }

    @Override // j0.i
    public void reset() {
        this.f6510c = 1.0f;
        this.f6511d = 1.0f;
        i.a aVar = i.a.f6443e;
        this.f6512e = aVar;
        this.f6513f = aVar;
        this.f6514g = aVar;
        this.f6515h = aVar;
        ByteBuffer byteBuffer = i.f6442a;
        this.f6518k = byteBuffer;
        this.f6519l = byteBuffer.asShortBuffer();
        this.f6520m = byteBuffer;
        this.f6509b = -1;
        this.f6516i = false;
        this.f6517j = null;
        this.f6521n = 0L;
        this.f6522o = 0L;
        this.f6523p = false;
    }
}
