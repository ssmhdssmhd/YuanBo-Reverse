package l1;

import g2.b;
import i2.c1;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import l1.n0;
import o0.e0;

/* loaded from: classes.dex */
class l0 {

    /* renamed from: a, reason: collision with root package name */
    private final g2.b f7334a;

    /* renamed from: b, reason: collision with root package name */
    private final int f7335b;

    /* renamed from: c, reason: collision with root package name */
    private final i2.i0 f7336c;

    /* renamed from: d, reason: collision with root package name */
    private a f7337d;

    /* renamed from: e, reason: collision with root package name */
    private a f7338e;

    /* renamed from: f, reason: collision with root package name */
    private a f7339f;

    /* renamed from: g, reason: collision with root package name */
    private long f7340g;

    private static final class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public long f7341a;

        /* renamed from: b, reason: collision with root package name */
        public long f7342b;

        /* renamed from: c, reason: collision with root package name */
        public g2.a f7343c;

        /* renamed from: d, reason: collision with root package name */
        public a f7344d;

        public a(long j6, int i6) {
            d(j6, i6);
        }

        @Override // g2.b.a
        public g2.a a() {
            return (g2.a) i2.a.e(this.f7343c);
        }

        public a b() {
            this.f7343c = null;
            a aVar = this.f7344d;
            this.f7344d = null;
            return aVar;
        }

        public void c(g2.a aVar, a aVar2) {
            this.f7343c = aVar;
            this.f7344d = aVar2;
        }

        public void d(long j6, int i6) {
            i2.a.g(this.f7343c == null);
            this.f7341a = j6;
            this.f7342b = j6 + i6;
        }

        public int e(long j6) {
            return ((int) (j6 - this.f7341a)) + this.f7343c.f4003b;
        }

        @Override // g2.b.a
        public b.a next() {
            a aVar = this.f7344d;
            if (aVar == null || aVar.f7343c == null) {
                return null;
            }
            return aVar;
        }
    }

    public l0(g2.b bVar) {
        this.f7334a = bVar;
        int e6 = bVar.e();
        this.f7335b = e6;
        this.f7336c = new i2.i0(32);
        a aVar = new a(0L, e6);
        this.f7337d = aVar;
        this.f7338e = aVar;
        this.f7339f = aVar;
    }

    private void a(a aVar) {
        if (aVar.f7343c == null) {
            return;
        }
        this.f7334a.a(aVar);
        aVar.b();
    }

    private static a d(a aVar, long j6) {
        while (j6 >= aVar.f7342b) {
            aVar = aVar.f7344d;
        }
        return aVar;
    }

    private void g(int i6) {
        long j6 = this.f7340g + i6;
        this.f7340g = j6;
        a aVar = this.f7339f;
        if (j6 == aVar.f7342b) {
            this.f7339f = aVar.f7344d;
        }
    }

    private int h(int i6) {
        a aVar = this.f7339f;
        if (aVar.f7343c == null) {
            aVar.c(this.f7334a.d(), new a(this.f7339f.f7342b, this.f7335b));
        }
        return Math.min(i6, (int) (this.f7339f.f7342b - this.f7340g));
    }

    private static a i(a aVar, long j6, ByteBuffer byteBuffer, int i6) {
        a d6 = d(aVar, j6);
        while (i6 > 0) {
            int min = Math.min(i6, (int) (d6.f7342b - j6));
            byteBuffer.put(d6.f7343c.f4002a, d6.e(j6), min);
            i6 -= min;
            j6 += min;
            if (j6 == d6.f7342b) {
                d6 = d6.f7344d;
            }
        }
        return d6;
    }

    private static a j(a aVar, long j6, byte[] bArr, int i6) {
        a d6 = d(aVar, j6);
        int i7 = i6;
        while (i7 > 0) {
            int min = Math.min(i7, (int) (d6.f7342b - j6));
            System.arraycopy(d6.f7343c.f4002a, d6.e(j6), bArr, i6 - i7, min);
            i7 -= min;
            j6 += min;
            if (j6 == d6.f7342b) {
                d6 = d6.f7344d;
            }
        }
        return d6;
    }

    private static a k(a aVar, l0.i iVar, n0.b bVar, i2.i0 i0Var) {
        int i6;
        long j6 = bVar.f7378b;
        i0Var.O(1);
        a j7 = j(aVar, j6, i0Var.e(), 1);
        long j8 = j6 + 1;
        byte b6 = i0Var.e()[0];
        boolean z5 = (b6 & 128) != 0;
        int i7 = b6 & Byte.MAX_VALUE;
        l0.c cVar = iVar.f7161b;
        byte[] bArr = cVar.f7137a;
        if (bArr == null) {
            cVar.f7137a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        a j9 = j(j7, j8, cVar.f7137a, i7);
        long j10 = j8 + i7;
        if (z5) {
            i0Var.O(2);
            j9 = j(j9, j10, i0Var.e(), 2);
            j10 += 2;
            i6 = i0Var.L();
        } else {
            i6 = 1;
        }
        int[] iArr = cVar.f7140d;
        if (iArr == null || iArr.length < i6) {
            iArr = new int[i6];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cVar.f7141e;
        if (iArr3 == null || iArr3.length < i6) {
            iArr3 = new int[i6];
        }
        int[] iArr4 = iArr3;
        if (z5) {
            int i8 = i6 * 6;
            i0Var.O(i8);
            j9 = j(j9, j10, i0Var.e(), i8);
            j10 += i8;
            i0Var.S(0);
            for (int i9 = 0; i9 < i6; i9++) {
                iArr2[i9] = i0Var.L();
                iArr4[i9] = i0Var.J();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = bVar.f7377a - ((int) (j10 - bVar.f7378b));
        }
        e0.a aVar2 = (e0.a) c1.j(bVar.f7379c);
        cVar.c(i6, iArr2, iArr4, aVar2.f8348b, cVar.f7137a, aVar2.f8347a, aVar2.f8349c, aVar2.f8350d);
        long j11 = bVar.f7378b;
        int i10 = (int) (j10 - j11);
        bVar.f7378b = j11 + i10;
        bVar.f7377a -= i10;
        return j9;
    }

    private static a l(a aVar, l0.i iVar, n0.b bVar, i2.i0 i0Var) {
        long j6;
        ByteBuffer byteBuffer;
        if (iVar.r()) {
            aVar = k(aVar, iVar, bVar, i0Var);
        }
        if (iVar.i()) {
            i0Var.O(4);
            a j7 = j(aVar, bVar.f7378b, i0Var.e(), 4);
            int J = i0Var.J();
            bVar.f7378b += 4;
            bVar.f7377a -= 4;
            iVar.p(J);
            aVar = i(j7, bVar.f7378b, iVar.f7162c, J);
            bVar.f7378b += J;
            int i6 = bVar.f7377a - J;
            bVar.f7377a = i6;
            iVar.t(i6);
            j6 = bVar.f7378b;
            byteBuffer = iVar.f7165j;
        } else {
            iVar.p(bVar.f7377a);
            j6 = bVar.f7378b;
            byteBuffer = iVar.f7162c;
        }
        return i(aVar, j6, byteBuffer, bVar.f7377a);
    }

    public void b(long j6) {
        a aVar;
        if (j6 == -1) {
            return;
        }
        while (true) {
            aVar = this.f7337d;
            if (j6 < aVar.f7342b) {
                break;
            }
            this.f7334a.c(aVar.f7343c);
            this.f7337d = this.f7337d.b();
        }
        if (this.f7338e.f7341a < aVar.f7341a) {
            this.f7338e = aVar;
        }
    }

    public void c(long j6) {
        i2.a.a(j6 <= this.f7340g);
        this.f7340g = j6;
        if (j6 != 0) {
            a aVar = this.f7337d;
            if (j6 != aVar.f7341a) {
                while (this.f7340g > aVar.f7342b) {
                    aVar = aVar.f7344d;
                }
                a aVar2 = (a) i2.a.e(aVar.f7344d);
                a(aVar2);
                a aVar3 = new a(aVar.f7342b, this.f7335b);
                aVar.f7344d = aVar3;
                if (this.f7340g == aVar.f7342b) {
                    aVar = aVar3;
                }
                this.f7339f = aVar;
                if (this.f7338e == aVar2) {
                    this.f7338e = aVar3;
                    return;
                }
                return;
            }
        }
        a(this.f7337d);
        a aVar4 = new a(this.f7340g, this.f7335b);
        this.f7337d = aVar4;
        this.f7338e = aVar4;
        this.f7339f = aVar4;
    }

    public long e() {
        return this.f7340g;
    }

    public void f(l0.i iVar, n0.b bVar) {
        l(this.f7338e, iVar, bVar, this.f7336c);
    }

    public void m(l0.i iVar, n0.b bVar) {
        this.f7338e = l(this.f7338e, iVar, bVar, this.f7336c);
    }

    public void n() {
        a(this.f7337d);
        this.f7337d.d(0L, this.f7335b);
        a aVar = this.f7337d;
        this.f7338e = aVar;
        this.f7339f = aVar;
        this.f7340g = 0L;
        this.f7334a.b();
    }

    public void o() {
        this.f7338e = this.f7337d;
    }

    public int p(g2.i iVar, int i6, boolean z5) {
        int h6 = h(i6);
        a aVar = this.f7339f;
        int read = iVar.read(aVar.f7343c.f4002a, aVar.e(this.f7340g), h6);
        if (read != -1) {
            g(read);
            return read;
        }
        if (z5) {
            return -1;
        }
        throw new EOFException();
    }

    public void q(i2.i0 i0Var, int i6) {
        while (i6 > 0) {
            int h6 = h(i6);
            a aVar = this.f7339f;
            i0Var.j(aVar.f7343c.f4002a, aVar.e(this.f7340g), h6);
            i6 -= h6;
            g(h6);
        }
    }
}
