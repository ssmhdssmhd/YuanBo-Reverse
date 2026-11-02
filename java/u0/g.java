package u0;

import o0.m;

/* loaded from: classes.dex */
final class g {

    /* renamed from: d, reason: collision with root package name */
    private static final long[] f9595d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f9596a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    private int f9597b;

    /* renamed from: c, reason: collision with root package name */
    private int f9598c;

    public static long a(byte[] bArr, int i6, boolean z5) {
        long j6 = bArr[0] & 255;
        if (z5) {
            j6 &= ~f9595d[i6 - 1];
        }
        for (int i7 = 1; i7 < i6; i7++) {
            j6 = (j6 << 8) | (bArr[i7] & 255);
        }
        return j6;
    }

    public static int c(int i6) {
        long j6;
        int i7 = 0;
        do {
            long[] jArr = f9595d;
            if (i7 >= jArr.length) {
                return -1;
            }
            j6 = jArr[i7] & i6;
            i7++;
        } while (j6 == 0);
        return i7;
    }

    public int b() {
        return this.f9598c;
    }

    public long d(m mVar, boolean z5, boolean z6, int i6) {
        if (this.f9597b == 0) {
            if (!mVar.d(this.f9596a, 0, 1, z5)) {
                return -1L;
            }
            int c6 = c(this.f9596a[0] & 255);
            this.f9598c = c6;
            if (c6 == -1) {
                throw new IllegalStateException("No valid varint length mask found");
            }
            this.f9597b = 1;
        }
        int i7 = this.f9598c;
        if (i7 > i6) {
            this.f9597b = 0;
            return -2L;
        }
        if (i7 != 1) {
            mVar.readFully(this.f9596a, 1, i7 - 1);
        }
        this.f9597b = 0;
        return a(this.f9596a, this.f9598c, z6);
    }

    public void e() {
        this.f9597b = 0;
        this.f9598c = 0;
    }
}
