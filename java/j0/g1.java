package j0;

import com.tendcloud.tenddata.ab;
import j0.s0;
import java.math.RoundingMode;

/* loaded from: classes.dex */
public class g1 implements s0.e {

    /* renamed from: b, reason: collision with root package name */
    protected final int f6421b;

    /* renamed from: c, reason: collision with root package name */
    protected final int f6422c;

    /* renamed from: d, reason: collision with root package name */
    protected final int f6423d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f6424e;

    /* renamed from: f, reason: collision with root package name */
    protected final int f6425f;

    /* renamed from: g, reason: collision with root package name */
    public final int f6426g;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f6427a = 250000;

        /* renamed from: b, reason: collision with root package name */
        private int f6428b = 750000;

        /* renamed from: c, reason: collision with root package name */
        private int f6429c = 4;

        /* renamed from: d, reason: collision with root package name */
        private int f6430d = 250000;

        /* renamed from: e, reason: collision with root package name */
        private int f6431e = 50000000;

        /* renamed from: f, reason: collision with root package name */
        private int f6432f = 2;

        public g1 g() {
            return new g1(this);
        }
    }

    protected g1(a aVar) {
        this.f6421b = aVar.f6427a;
        this.f6422c = aVar.f6428b;
        this.f6423d = aVar.f6429c;
        this.f6424e = aVar.f6430d;
        this.f6425f = aVar.f6431e;
        this.f6426g = aVar.f6432f;
    }

    protected static int b(int i6, int i7, int i8) {
        return o2.e.d(((i6 * i7) * i8) / 1000000);
    }

    protected static int d(int i6) {
        switch (i6) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 13:
            case 19:
            default:
                throw new IllegalArgumentException();
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case ab.b.API_TYPE_INDUSTRY /* 17 */:
                return 336000;
            case 20:
                return 63750;
        }
    }

    @Override // j0.s0.e
    public int a(int i6, int i7, int i8, int i9, int i10, int i11, double d6) {
        return (((Math.max(i6, (int) (c(i6, i7, i8, i9, i10, i11) * d6)) + i9) - 1) / i9) * i9;
    }

    protected int c(int i6, int i7, int i8, int i9, int i10, int i11) {
        if (i8 == 0) {
            return g(i6, i10, i9);
        }
        if (i8 == 1) {
            return e(i7);
        }
        if (i8 == 2) {
            return f(i7, i11);
        }
        throw new IllegalArgumentException();
    }

    protected int e(int i6) {
        return o2.e.d((this.f6425f * d(i6)) / 1000000);
    }

    protected int f(int i6, int i7) {
        int i8 = this.f6424e;
        if (i6 == 5) {
            i8 *= this.f6426g;
        }
        return o2.e.d((i8 * (i7 != -1 ? n2.b.a(i7, 8, RoundingMode.CEILING) : d(i6))) / 1000000);
    }

    protected int g(int i6, int i7, int i8) {
        return i2.c1.q(i6 * this.f6423d, b(this.f6421b, i7, i8), b(this.f6422c, i7, i8));
    }
}
