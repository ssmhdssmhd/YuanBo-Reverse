package x0;

import com.tendcloud.tenddata.ab;
import i2.c1;
import java.io.EOFException;
import java.io.IOException;
import o0.b0;
import o0.c0;
import o0.m;
import o0.o;

/* loaded from: classes.dex */
final class a implements g {

    /* renamed from: a, reason: collision with root package name */
    private final f f10391a;

    /* renamed from: b, reason: collision with root package name */
    private final long f10392b;

    /* renamed from: c, reason: collision with root package name */
    private final long f10393c;

    /* renamed from: d, reason: collision with root package name */
    private final i f10394d;

    /* renamed from: e, reason: collision with root package name */
    private int f10395e;

    /* renamed from: f, reason: collision with root package name */
    private long f10396f;

    /* renamed from: g, reason: collision with root package name */
    private long f10397g;

    /* renamed from: h, reason: collision with root package name */
    private long f10398h;

    /* renamed from: i, reason: collision with root package name */
    private long f10399i;

    /* renamed from: j, reason: collision with root package name */
    private long f10400j;

    /* renamed from: k, reason: collision with root package name */
    private long f10401k;

    /* renamed from: l, reason: collision with root package name */
    private long f10402l;

    private final class b implements b0 {
        private b() {
        }

        @Override // o0.b0
        public boolean f() {
            return true;
        }

        @Override // o0.b0
        public b0.a h(long j6) {
            return new b0.a(new c0(j6, c1.r((a.this.f10392b + ((a.this.f10394d.c(j6) * (a.this.f10393c - a.this.f10392b)) / a.this.f10396f)) - ab.aa, a.this.f10392b, a.this.f10393c - 1)));
        }

        @Override // o0.b0
        public long i() {
            return a.this.f10394d.b(a.this.f10396f);
        }
    }

    public a(i iVar, long j6, long j7, long j8, long j9, boolean z5) {
        i2.a.a(j6 >= 0 && j7 > j6);
        this.f10394d = iVar;
        this.f10392b = j6;
        this.f10393c = j7;
        if (j8 == j7 - j6 || z5) {
            this.f10396f = j9;
            this.f10395e = 4;
        } else {
            this.f10395e = 0;
        }
        this.f10391a = new f();
    }

    private long i(m mVar) {
        if (this.f10399i == this.f10400j) {
            return -1L;
        }
        long position = mVar.getPosition();
        if (!this.f10391a.d(mVar, this.f10400j)) {
            long j6 = this.f10399i;
            if (j6 != position) {
                return j6;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.f10391a.a(mVar, false);
        mVar.g();
        long j7 = this.f10398h;
        f fVar = this.f10391a;
        long j8 = fVar.f10421c;
        long j9 = j7 - j8;
        int i6 = fVar.f10426h + fVar.f10427i;
        if (0 <= j9 && j9 < 72000) {
            return -1L;
        }
        if (j9 < 0) {
            this.f10400j = position;
            this.f10402l = j8;
        } else {
            this.f10399i = mVar.getPosition() + i6;
            this.f10401k = this.f10391a.f10421c;
        }
        long j10 = this.f10400j;
        long j11 = this.f10399i;
        if (j10 - j11 < 100000) {
            this.f10400j = j11;
            return j11;
        }
        long position2 = mVar.getPosition() - (i6 * (j9 <= 0 ? 2L : 1L));
        long j12 = this.f10400j;
        long j13 = this.f10399i;
        return c1.r(position2 + ((j9 * (j12 - j13)) / (this.f10402l - this.f10401k)), j13, j12 - 1);
    }

    private void k(m mVar) {
        while (true) {
            this.f10391a.c(mVar);
            this.f10391a.a(mVar, false);
            f fVar = this.f10391a;
            if (fVar.f10421c > this.f10398h) {
                mVar.g();
                return;
            } else {
                mVar.h(fVar.f10426h + fVar.f10427i);
                this.f10399i = mVar.getPosition();
                this.f10401k = this.f10391a.f10421c;
            }
        }
    }

    @Override // x0.g
    public long b(m mVar) {
        int i6 = this.f10395e;
        if (i6 == 0) {
            long position = mVar.getPosition();
            this.f10397g = position;
            this.f10395e = 1;
            long j6 = this.f10393c - 65307;
            if (j6 > position) {
                return j6;
            }
        } else if (i6 != 1) {
            if (i6 == 2) {
                long i7 = i(mVar);
                if (i7 != -1) {
                    return i7;
                }
                this.f10395e = 3;
            } else if (i6 != 3) {
                if (i6 == 4) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            k(mVar);
            this.f10395e = 4;
            return -(this.f10401k + 2);
        }
        this.f10396f = j(mVar);
        this.f10395e = 4;
        return this.f10397g;
    }

    @Override // x0.g
    public void c(long j6) {
        this.f10398h = c1.r(j6, 0L, this.f10396f - 1);
        this.f10395e = 2;
        this.f10399i = this.f10392b;
        this.f10400j = this.f10393c;
        this.f10401k = 0L;
        this.f10402l = this.f10396f;
    }

    @Override // x0.g
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public b a() {
        if (this.f10396f != 0) {
            return new b();
        }
        return null;
    }

    long j(m mVar) {
        long j6;
        f fVar;
        this.f10391a.b();
        if (!this.f10391a.c(mVar)) {
            throw new EOFException();
        }
        this.f10391a.a(mVar, false);
        f fVar2 = this.f10391a;
        mVar.h(fVar2.f10426h + fVar2.f10427i);
        do {
            j6 = this.f10391a.f10421c;
            f fVar3 = this.f10391a;
            if ((fVar3.f10420b & 4) == 4 || !fVar3.c(mVar) || mVar.getPosition() >= this.f10393c || !this.f10391a.a(mVar, true)) {
                break;
            }
            fVar = this.f10391a;
        } while (o.e(mVar, fVar.f10426h + fVar.f10427i));
        return j6;
    }
}
