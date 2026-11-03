package j0;

import j0.i;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class n1 extends b0 {

    /* renamed from: i, reason: collision with root package name */
    private final long f6471i;

    /* renamed from: j, reason: collision with root package name */
    private final long f6472j;

    /* renamed from: k, reason: collision with root package name */
    private final short f6473k;

    /* renamed from: l, reason: collision with root package name */
    private int f6474l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f6475m;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f6476n;

    /* renamed from: o, reason: collision with root package name */
    private byte[] f6477o;

    /* renamed from: p, reason: collision with root package name */
    private int f6478p;

    /* renamed from: q, reason: collision with root package name */
    private int f6479q;

    /* renamed from: r, reason: collision with root package name */
    private int f6480r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f6481s;

    /* renamed from: t, reason: collision with root package name */
    private long f6482t;

    public n1() {
        this(150000L, 20000L, (short) 1024);
    }

    public n1(long j6, long j7, short s5) {
        i2.a.a(j7 <= j6);
        this.f6471i = j6;
        this.f6472j = j7;
        this.f6473k = s5;
        byte[] bArr = i2.c1.f5553f;
        this.f6476n = bArr;
        this.f6477o = bArr;
    }

    private int m(long j6) {
        return (int) ((j6 * this.f6386b.f6444a) / 1000000);
    }

    private int n(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        do {
            limit -= 2;
            if (limit < byteBuffer.position()) {
                return byteBuffer.position();
            }
        } while (Math.abs((int) byteBuffer.getShort(limit)) <= this.f6473k);
        int i6 = this.f6474l;
        return ((limit / i6) * i6) + i6;
    }

    private int o(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs((int) byteBuffer.getShort(position)) > this.f6473k) {
                int i6 = this.f6474l;
                return i6 * (position / i6);
            }
        }
        return byteBuffer.limit();
    }

    private void q(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        l(remaining).put(byteBuffer).flip();
        if (remaining > 0) {
            this.f6481s = true;
        }
    }

    private void r(byte[] bArr, int i6) {
        l(i6).put(bArr, 0, i6).flip();
        if (i6 > 0) {
            this.f6481s = true;
        }
    }

    private void s(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int o6 = o(byteBuffer);
        int position = o6 - byteBuffer.position();
        byte[] bArr = this.f6476n;
        int length = bArr.length;
        int i6 = this.f6479q;
        int i7 = length - i6;
        if (o6 < limit && position < i7) {
            r(bArr, i6);
            this.f6479q = 0;
            this.f6478p = 0;
            return;
        }
        int min = Math.min(position, i7);
        byteBuffer.limit(byteBuffer.position() + min);
        byteBuffer.get(this.f6476n, this.f6479q, min);
        int i8 = this.f6479q + min;
        this.f6479q = i8;
        byte[] bArr2 = this.f6476n;
        if (i8 == bArr2.length) {
            if (this.f6481s) {
                r(bArr2, this.f6480r);
                this.f6482t += (this.f6479q - (this.f6480r * 2)) / this.f6474l;
            } else {
                this.f6482t += (i8 - this.f6480r) / this.f6474l;
            }
            w(byteBuffer, this.f6476n, this.f6479q);
            this.f6479q = 0;
            this.f6478p = 2;
        }
        byteBuffer.limit(limit);
    }

    private void t(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.f6476n.length));
        int n6 = n(byteBuffer);
        if (n6 == byteBuffer.position()) {
            this.f6478p = 1;
        } else {
            byteBuffer.limit(n6);
            q(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    private void u(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int o6 = o(byteBuffer);
        byteBuffer.limit(o6);
        this.f6482t += byteBuffer.remaining() / this.f6474l;
        w(byteBuffer, this.f6477o, this.f6480r);
        if (o6 < limit) {
            r(this.f6477o, this.f6480r);
            this.f6478p = 0;
            byteBuffer.limit(limit);
        }
    }

    private void w(ByteBuffer byteBuffer, byte[] bArr, int i6) {
        int min = Math.min(byteBuffer.remaining(), this.f6480r);
        int i7 = this.f6480r - min;
        System.arraycopy(bArr, i6 - i7, this.f6477o, 0, i7);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.f6477o, i7, min);
    }

    @Override // j0.b0, j0.i
    public boolean a() {
        return this.f6475m;
    }

    @Override // j0.i
    public void e(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !g()) {
            int i6 = this.f6478p;
            if (i6 == 0) {
                t(byteBuffer);
            } else if (i6 == 1) {
                s(byteBuffer);
            } else {
                if (i6 != 2) {
                    throw new IllegalStateException();
                }
                u(byteBuffer);
            }
        }
    }

    @Override // j0.b0
    public i.a h(i.a aVar) {
        if (aVar.f6446c == 2) {
            return this.f6475m ? aVar : i.a.f6443e;
        }
        throw new i.b(aVar);
    }

    @Override // j0.b0
    protected void i() {
        if (this.f6475m) {
            this.f6474l = this.f6386b.f6447d;
            int m6 = m(this.f6471i) * this.f6474l;
            if (this.f6476n.length != m6) {
                this.f6476n = new byte[m6];
            }
            int m7 = m(this.f6472j) * this.f6474l;
            this.f6480r = m7;
            if (this.f6477o.length != m7) {
                this.f6477o = new byte[m7];
            }
        }
        this.f6478p = 0;
        this.f6482t = 0L;
        this.f6479q = 0;
        this.f6481s = false;
    }

    @Override // j0.b0
    protected void j() {
        int i6 = this.f6479q;
        if (i6 > 0) {
            r(this.f6476n, i6);
        }
        if (this.f6481s) {
            return;
        }
        this.f6482t += this.f6480r / this.f6474l;
    }

    @Override // j0.b0
    protected void k() {
        this.f6475m = false;
        this.f6480r = 0;
        byte[] bArr = i2.c1.f5553f;
        this.f6476n = bArr;
        this.f6477o = bArr;
    }

    public long p() {
        return this.f6482t;
    }

    public void v(boolean z5) {
        this.f6475m = z5;
    }
}
