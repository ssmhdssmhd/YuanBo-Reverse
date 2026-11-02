package a1;

import h0.y1;
import j0.k1;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class m {

    /* renamed from: a, reason: collision with root package name */
    private long f67a;

    /* renamed from: b, reason: collision with root package name */
    private long f68b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f69c;

    m() {
    }

    private long a(long j6) {
        return this.f67a + Math.max(0L, ((this.f68b - 529) * 1000000) / j6);
    }

    public long b(y1 y1Var) {
        return a(y1Var.D);
    }

    public void c() {
        this.f67a = 0L;
        this.f68b = 0L;
        this.f69c = false;
    }

    public long d(y1 y1Var, l0.i iVar) {
        if (this.f68b == 0) {
            this.f67a = iVar.f7164e;
        }
        if (this.f69c) {
            return iVar.f7164e;
        }
        ByteBuffer byteBuffer = (ByteBuffer) i2.a.e(iVar.f7162c);
        int i6 = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            i6 = (i6 << 8) | (byteBuffer.get(i7) & 255);
        }
        int m6 = k1.m(i6);
        if (m6 != -1) {
            long a6 = a(y1Var.D);
            this.f68b += m6;
            return a6;
        }
        this.f69c = true;
        this.f68b = 0L;
        this.f67a = iVar.f7164e;
        i2.t.i("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
        return iVar.f7164e;
    }
}
