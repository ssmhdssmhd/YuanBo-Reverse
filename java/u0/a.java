package u0;

import h0.g3;
import java.util.ArrayDeque;
import o0.m;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
final class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f9522a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    private final ArrayDeque<b> f9523b = new ArrayDeque<>();

    /* renamed from: c, reason: collision with root package name */
    private final g f9524c = new g();

    /* renamed from: d, reason: collision with root package name */
    private u0.b f9525d;

    /* renamed from: e, reason: collision with root package name */
    private int f9526e;

    /* renamed from: f, reason: collision with root package name */
    private int f9527f;

    /* renamed from: g, reason: collision with root package name */
    private long f9528g;

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f9529a;

        /* renamed from: b, reason: collision with root package name */
        private final long f9530b;

        private b(int i6, long j6) {
            this.f9529a = i6;
            this.f9530b = j6;
        }
    }

    @RequiresNonNull({"processor"})
    private long c(m mVar) {
        mVar.g();
        while (true) {
            mVar.m(this.f9522a, 0, 4);
            int c6 = g.c(this.f9522a[0]);
            if (c6 != -1 && c6 <= 4) {
                int a6 = (int) g.a(this.f9522a, c6, false);
                if (this.f9525d.e(a6)) {
                    mVar.h(c6);
                    return a6;
                }
            }
            mVar.h(1);
        }
    }

    private double d(m mVar, int i6) {
        return i6 == 4 ? Float.intBitsToFloat((int) r0) : Double.longBitsToDouble(e(mVar, i6));
    }

    private long e(m mVar, int i6) {
        mVar.readFully(this.f9522a, 0, i6);
        long j6 = 0;
        for (int i7 = 0; i7 < i6; i7++) {
            j6 = (j6 << 8) | (this.f9522a[i7] & 255);
        }
        return j6;
    }

    private static String f(m mVar, int i6) {
        if (i6 == 0) {
            return "";
        }
        byte[] bArr = new byte[i6];
        mVar.readFully(bArr, 0, i6);
        while (i6 > 0 && bArr[i6 - 1] == 0) {
            i6--;
        }
        return new String(bArr, 0, i6);
    }

    @Override // u0.c
    public void a(u0.b bVar) {
        this.f9525d = bVar;
    }

    @Override // u0.c
    public boolean b(m mVar) {
        i2.a.i(this.f9525d);
        while (true) {
            b peek = this.f9523b.peek();
            if (peek != null && mVar.getPosition() >= peek.f9530b) {
                this.f9525d.a(this.f9523b.pop().f9529a);
                return true;
            }
            if (this.f9526e == 0) {
                long d6 = this.f9524c.d(mVar, true, false, 4);
                if (d6 == -2) {
                    d6 = c(mVar);
                }
                if (d6 == -1) {
                    return false;
                }
                this.f9527f = (int) d6;
                this.f9526e = 1;
            }
            if (this.f9526e == 1) {
                this.f9528g = this.f9524c.d(mVar, false, true, 8);
                this.f9526e = 2;
            }
            int b6 = this.f9525d.b(this.f9527f);
            if (b6 != 0) {
                if (b6 == 1) {
                    long position = mVar.getPosition();
                    this.f9523b.push(new b(this.f9527f, this.f9528g + position));
                    this.f9525d.g(this.f9527f, position, this.f9528g);
                    this.f9526e = 0;
                    return true;
                }
                if (b6 == 2) {
                    long j6 = this.f9528g;
                    if (j6 <= 8) {
                        this.f9525d.h(this.f9527f, e(mVar, (int) j6));
                        this.f9526e = 0;
                        return true;
                    }
                    throw g3.a("Invalid integer size: " + this.f9528g, null);
                }
                if (b6 == 3) {
                    long j7 = this.f9528g;
                    if (j7 <= 2147483647L) {
                        this.f9525d.f(this.f9527f, f(mVar, (int) j7));
                        this.f9526e = 0;
                        return true;
                    }
                    throw g3.a("String element size: " + this.f9528g, null);
                }
                if (b6 == 4) {
                    this.f9525d.d(this.f9527f, (int) this.f9528g, mVar);
                    this.f9526e = 0;
                    return true;
                }
                if (b6 != 5) {
                    throw g3.a("Invalid element type " + b6, null);
                }
                long j8 = this.f9528g;
                if (j8 == 4 || j8 == 8) {
                    this.f9525d.c(this.f9527f, d(mVar, (int) j8));
                    this.f9526e = 0;
                    return true;
                }
                throw g3.a("Invalid float size: " + this.f9528g, null);
            }
            mVar.h((int) this.f9528g);
            this.f9526e = 0;
        }
    }

    @Override // u0.c
    public void reset() {
        this.f9526e = 0;
        this.f9523b.clear();
        this.f9524c.e();
    }
}
