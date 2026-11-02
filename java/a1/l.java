package a1;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class l extends l0.i {

    /* renamed from: m, reason: collision with root package name */
    private long f64m;

    /* renamed from: n, reason: collision with root package name */
    private int f65n;

    /* renamed from: o, reason: collision with root package name */
    private int f66o;

    public l() {
        super(2);
        this.f66o = 32;
    }

    private boolean v(l0.i iVar) {
        ByteBuffer byteBuffer;
        if (!z()) {
            return true;
        }
        if (this.f65n >= this.f66o || iVar.j() != j()) {
            return false;
        }
        ByteBuffer byteBuffer2 = iVar.f7162c;
        return byteBuffer2 == null || (byteBuffer = this.f7162c) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    public void A(int i6) {
        i2.a.a(i6 > 0);
        this.f66o = i6;
    }

    @Override // l0.i, l0.a
    public void f() {
        super.f();
        this.f65n = 0;
    }

    public boolean u(l0.i iVar) {
        i2.a.a(!iVar.r());
        i2.a.a(!iVar.i());
        i2.a.a(!iVar.k());
        if (!v(iVar)) {
            return false;
        }
        int i6 = this.f65n;
        this.f65n = i6 + 1;
        if (i6 == 0) {
            this.f7164e = iVar.f7164e;
            if (iVar.m()) {
                n(1);
            }
        }
        if (iVar.j()) {
            n(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer = iVar.f7162c;
        if (byteBuffer != null) {
            p(byteBuffer.remaining());
            this.f7162c.put(byteBuffer);
        }
        this.f64m = iVar.f7164e;
        return true;
    }

    public long w() {
        return this.f7164e;
    }

    public long x() {
        return this.f64m;
    }

    public int y() {
        return this.f65n;
    }

    public boolean z() {
        return this.f65n > 0;
    }
}
