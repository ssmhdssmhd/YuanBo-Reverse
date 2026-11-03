package n1;

import g2.q;
import h0.y1;
import i2.c1;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class l extends f {

    /* renamed from: j, reason: collision with root package name */
    private byte[] f8243j;

    /* renamed from: k, reason: collision with root package name */
    private volatile boolean f8244k;

    public l(g2.m mVar, q qVar, int i6, y1 y1Var, int i7, Object obj, byte[] bArr) {
        super(mVar, qVar, i6, y1Var, i7, obj, -9223372036854775807L, -9223372036854775807L);
        l lVar;
        byte[] bArr2;
        if (bArr == null) {
            bArr2 = c1.f5553f;
            lVar = this;
        } else {
            lVar = this;
            bArr2 = bArr;
        }
        lVar.f8243j = bArr2;
    }

    private void i(int i6) {
        byte[] bArr = this.f8243j;
        if (bArr.length < i6 + 16384) {
            this.f8243j = Arrays.copyOf(bArr, bArr.length + 16384);
        }
    }

    @Override // g2.i0.e
    public final void a() {
        try {
            this.f8207i.a(this.f8200b);
            int i6 = 0;
            int i7 = 0;
            while (i6 != -1 && !this.f8244k) {
                i(i7);
                i6 = this.f8207i.read(this.f8243j, i7, 16384);
                if (i6 != -1) {
                    i7 += i6;
                }
            }
            if (!this.f8244k) {
                g(this.f8243j, i7);
            }
        } finally {
            g2.p.a(this.f8207i);
        }
    }

    @Override // g2.i0.e
    public final void c() {
        this.f8244k = true;
    }

    protected abstract void g(byte[] bArr, int i6);

    public byte[] h() {
        return this.f8243j;
    }
}
