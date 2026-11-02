package q5;

import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class x extends h {

    /* renamed from: j, reason: collision with root package name */
    private final transient byte[][] f9002j;

    /* renamed from: k, reason: collision with root package name */
    private final transient int[] f9003k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(byte[][] segments, int[] directory) {
        super(h.f8958d.e());
        kotlin.jvm.internal.k.e(segments, "segments");
        kotlin.jvm.internal.k.e(directory, "directory");
        this.f9002j = segments;
        this.f9003k = directory;
    }

    private final h z() {
        return new h(y());
    }

    @Override // q5.h
    public String a() {
        return z().a();
    }

    @Override // q5.h
    public h c(String algorithm) {
        kotlin.jvm.internal.k.e(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = x().length;
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            int i8 = w()[length + i6];
            int i9 = w()[i6];
            messageDigest.update(x()[i6], i8, i9 - i7);
            i6++;
            i7 = i9;
        }
        byte[] digest = messageDigest.digest();
        kotlin.jvm.internal.k.d(digest, "digest.digest()");
        return new h(digest);
    }

    @Override // q5.h
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (hVar.r() == r() && l(0, hVar, 0, r())) {
                return true;
            }
        }
        return false;
    }

    @Override // q5.h
    public int g() {
        return w()[x().length - 1];
    }

    @Override // q5.h
    public int hashCode() {
        int f6 = f();
        if (f6 != 0) {
            return f6;
        }
        int length = x().length;
        int i6 = 0;
        int i7 = 1;
        int i8 = 0;
        while (i6 < length) {
            int i9 = w()[length + i6];
            int i10 = w()[i6];
            byte[] bArr = x()[i6];
            int i11 = (i10 - i8) + i9;
            while (i9 < i11) {
                i7 = (i7 * 31) + bArr[i9];
                i9++;
            }
            i6++;
            i8 = i10;
        }
        n(i7);
        return i7;
    }

    @Override // q5.h
    public String i() {
        return z().i();
    }

    @Override // q5.h
    public byte[] j() {
        return y();
    }

    @Override // q5.h
    public byte k(int i6) {
        c.b(w()[x().length - 1], i6, 1L);
        int b6 = r5.c.b(this, i6);
        return x()[b6][(i6 - (b6 == 0 ? 0 : w()[b6 - 1])) + w()[x().length + b6]];
    }

    @Override // q5.h
    public boolean l(int i6, h other, int i7, int i8) {
        kotlin.jvm.internal.k.e(other, "other");
        if (i6 < 0 || i6 > r() - i8) {
            return false;
        }
        int i9 = i8 + i6;
        int b6 = r5.c.b(this, i6);
        while (i6 < i9) {
            int i10 = b6 == 0 ? 0 : w()[b6 - 1];
            int i11 = w()[b6] - i10;
            int i12 = w()[x().length + b6];
            int min = Math.min(i9, i11 + i10) - i6;
            if (!other.m(i7, x()[b6], i12 + (i6 - i10), min)) {
                return false;
            }
            i7 += min;
            i6 += min;
            b6++;
        }
        return true;
    }

    @Override // q5.h
    public boolean m(int i6, byte[] other, int i7, int i8) {
        kotlin.jvm.internal.k.e(other, "other");
        if (i6 < 0 || i6 > r() - i8 || i7 < 0 || i7 > other.length - i8) {
            return false;
        }
        int i9 = i8 + i6;
        int b6 = r5.c.b(this, i6);
        while (i6 < i9) {
            int i10 = b6 == 0 ? 0 : w()[b6 - 1];
            int i11 = w()[b6] - i10;
            int i12 = w()[x().length + b6];
            int min = Math.min(i9, i11 + i10) - i6;
            if (!c.a(x()[b6], i12 + (i6 - i10), other, i7, min)) {
                return false;
            }
            i7 += min;
            i6 += min;
            b6++;
        }
        return true;
    }

    @Override // q5.h
    public h t() {
        return z().t();
    }

    @Override // q5.h
    public String toString() {
        return z().toString();
    }

    @Override // q5.h
    public void v(e buffer, int i6, int i7) {
        kotlin.jvm.internal.k.e(buffer, "buffer");
        int i8 = i7 + i6;
        int b6 = r5.c.b(this, i6);
        while (i6 < i8) {
            int i9 = b6 == 0 ? 0 : w()[b6 - 1];
            int i10 = w()[b6] - i9;
            int i11 = w()[x().length + b6];
            int min = Math.min(i8, i10 + i9) - i6;
            int i12 = i11 + (i6 - i9);
            v vVar = new v(x()[b6], i12, i12 + min, true, false);
            v vVar2 = buffer.f8956a;
            if (vVar2 == null) {
                vVar.f8996g = vVar;
                vVar.f8995f = vVar;
                buffer.f8956a = vVar;
            } else {
                kotlin.jvm.internal.k.b(vVar2);
                v vVar3 = vVar2.f8996g;
                kotlin.jvm.internal.k.b(vVar3);
                vVar3.c(vVar);
            }
            i6 += min;
            b6++;
        }
        buffer.Z(buffer.size() + r());
    }

    public final int[] w() {
        return this.f9003k;
    }

    public final byte[][] x() {
        return this.f9002j;
    }

    public byte[] y() {
        byte[] bArr = new byte[r()];
        int length = x().length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < length) {
            int i9 = w()[length + i6];
            int i10 = w()[i6];
            int i11 = i10 - i7;
            f4.g.c(x()[i6], bArr, i8, i9, i9 + i11);
            i8 += i11;
            i6++;
            i7 = i10;
        }
        return bArr;
    }
}
