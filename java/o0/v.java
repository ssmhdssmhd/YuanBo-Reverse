package o0;

import h0.y1;
import i2.c1;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final int f8417a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8418b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8419c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8420d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8421e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8422f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8423g;

    /* renamed from: h, reason: collision with root package name */
    public final int f8424h;

    /* renamed from: i, reason: collision with root package name */
    public final int f8425i;

    /* renamed from: j, reason: collision with root package name */
    public final long f8426j;

    /* renamed from: k, reason: collision with root package name */
    public final a f8427k;

    /* renamed from: l, reason: collision with root package name */
    private final b1.a f8428l;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final long[] f8429a;

        /* renamed from: b, reason: collision with root package name */
        public final long[] f8430b;

        public a(long[] jArr, long[] jArr2) {
            this.f8429a = jArr;
            this.f8430b = jArr2;
        }
    }

    private v(int i6, int i7, int i8, int i9, int i10, int i11, int i12, long j6, a aVar, b1.a aVar2) {
        this.f8417a = i6;
        this.f8418b = i7;
        this.f8419c = i8;
        this.f8420d = i9;
        this.f8421e = i10;
        this.f8422f = j(i10);
        this.f8423g = i11;
        this.f8424h = i12;
        this.f8425i = e(i12);
        this.f8426j = j6;
        this.f8427k = aVar;
        this.f8428l = aVar2;
    }

    public v(byte[] bArr, int i6) {
        i2.h0 h0Var = new i2.h0(bArr);
        h0Var.p(i6 * 8);
        this.f8417a = h0Var.h(16);
        this.f8418b = h0Var.h(16);
        this.f8419c = h0Var.h(24);
        this.f8420d = h0Var.h(24);
        int h6 = h0Var.h(20);
        this.f8421e = h6;
        this.f8422f = j(h6);
        this.f8423g = h0Var.h(3) + 1;
        int h7 = h0Var.h(5) + 1;
        this.f8424h = h7;
        this.f8425i = e(h7);
        this.f8426j = h0Var.j(36);
        this.f8427k = null;
        this.f8428l = null;
    }

    private static int e(int i6) {
        if (i6 == 8) {
            return 1;
        }
        if (i6 == 12) {
            return 2;
        }
        if (i6 == 16) {
            return 4;
        }
        if (i6 != 20) {
            return i6 != 24 ? -1 : 6;
        }
        return 5;
    }

    private static int j(int i6) {
        switch (i6) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public v a(List<e1.a> list) {
        return new v(this.f8417a, this.f8418b, this.f8419c, this.f8420d, this.f8421e, this.f8423g, this.f8424h, this.f8426j, this.f8427k, h(new b1.a(list)));
    }

    public v b(a aVar) {
        return new v(this.f8417a, this.f8418b, this.f8419c, this.f8420d, this.f8421e, this.f8423g, this.f8424h, this.f8426j, aVar, this.f8428l);
    }

    public v c(List<String> list) {
        return new v(this.f8417a, this.f8418b, this.f8419c, this.f8420d, this.f8421e, this.f8423g, this.f8424h, this.f8426j, this.f8427k, h(h0.c(list)));
    }

    public long d() {
        long j6;
        long j7;
        int i6 = this.f8420d;
        if (i6 > 0) {
            j6 = (i6 + this.f8419c) / 2;
            j7 = 1;
        } else {
            int i7 = this.f8417a;
            j6 = ((((i7 != this.f8418b || i7 <= 0) ? 4096L : i7) * this.f8423g) * this.f8424h) / 8;
            j7 = 64;
        }
        return j6 + j7;
    }

    public long f() {
        long j6 = this.f8426j;
        if (j6 == 0) {
            return -9223372036854775807L;
        }
        return (j6 * 1000000) / this.f8421e;
    }

    public y1 g(byte[] bArr, b1.a aVar) {
        bArr[4] = Byte.MIN_VALUE;
        int i6 = this.f8420d;
        if (i6 <= 0) {
            i6 = -1;
        }
        return new y1.b().g0("audio/flac").Y(i6).J(this.f8423g).h0(this.f8421e).V(Collections.singletonList(bArr)).Z(h(aVar)).G();
    }

    public b1.a h(b1.a aVar) {
        b1.a aVar2 = this.f8428l;
        return aVar2 == null ? aVar : aVar2.e(aVar);
    }

    public long i(long j6) {
        return c1.r((j6 * this.f8421e) / 1000000, 0L, this.f8426j - 1);
    }
}
