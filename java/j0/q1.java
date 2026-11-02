package j0;

import j0.i;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class q1 extends b0 {

    /* renamed from: i, reason: collision with root package name */
    private int f6526i;

    /* renamed from: j, reason: collision with root package name */
    private int f6527j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f6528k;

    /* renamed from: l, reason: collision with root package name */
    private int f6529l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f6530m = i2.c1.f5553f;

    /* renamed from: n, reason: collision with root package name */
    private int f6531n;

    /* renamed from: o, reason: collision with root package name */
    private long f6532o;

    @Override // j0.b0, j0.i
    public ByteBuffer b() {
        int i6;
        if (super.c() && (i6 = this.f6531n) > 0) {
            l(i6).put(this.f6530m, 0, this.f6531n).flip();
            this.f6531n = 0;
        }
        return super.b();
    }

    @Override // j0.b0, j0.i
    public boolean c() {
        return super.c() && this.f6531n == 0;
    }

    @Override // j0.i
    public void e(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i6 = limit - position;
        if (i6 == 0) {
            return;
        }
        int min = Math.min(i6, this.f6529l);
        this.f6532o += min / this.f6386b.f6447d;
        this.f6529l -= min;
        byteBuffer.position(position + min);
        if (this.f6529l > 0) {
            return;
        }
        int i7 = i6 - min;
        int length = (this.f6531n + i7) - this.f6530m.length;
        ByteBuffer l6 = l(length);
        int q6 = i2.c1.q(length, 0, this.f6531n);
        l6.put(this.f6530m, 0, q6);
        int q7 = i2.c1.q(length - q6, 0, i7);
        byteBuffer.limit(byteBuffer.position() + q7);
        l6.put(byteBuffer);
        byteBuffer.limit(limit);
        int i8 = i7 - q7;
        int i9 = this.f6531n - q6;
        this.f6531n = i9;
        byte[] bArr = this.f6530m;
        System.arraycopy(bArr, q6, bArr, 0, i9);
        byteBuffer.get(this.f6530m, this.f6531n, i8);
        this.f6531n += i8;
        l6.flip();
    }

    @Override // j0.b0
    public i.a h(i.a aVar) {
        if (aVar.f6446c != 2) {
            throw new i.b(aVar);
        }
        this.f6528k = true;
        return (this.f6526i == 0 && this.f6527j == 0) ? i.a.f6443e : aVar;
    }

    @Override // j0.b0
    protected void i() {
        if (this.f6528k) {
            this.f6528k = false;
            int i6 = this.f6527j;
            int i7 = this.f6386b.f6447d;
            this.f6530m = new byte[i6 * i7];
            this.f6529l = this.f6526i * i7;
        }
        this.f6531n = 0;
    }

    @Override // j0.b0
    protected void j() {
        if (this.f6528k) {
            if (this.f6531n > 0) {
                this.f6532o += r0 / this.f6386b.f6447d;
            }
            this.f6531n = 0;
        }
    }

    @Override // j0.b0
    protected void k() {
        this.f6530m = i2.c1.f5553f;
    }

    public long m() {
        return this.f6532o;
    }

    public void n() {
        this.f6532o = 0L;
    }

    public void o(int i6, int i7) {
        this.f6526i = i6;
        this.f6527j = i7;
    }
}
