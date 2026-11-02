package t0;

import java.util.List;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f9318a;

    /* renamed from: b, reason: collision with root package name */
    public final List<a> f9319b;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f9320a;

        /* renamed from: b, reason: collision with root package name */
        public final String f9321b;

        /* renamed from: c, reason: collision with root package name */
        public final long f9322c;

        /* renamed from: d, reason: collision with root package name */
        public final long f9323d;

        public a(String str, String str2, long j6, long j7) {
            this.f9320a = str;
            this.f9321b = str2;
            this.f9322c = j6;
            this.f9323d = j7;
        }
    }

    public b(long j6, List<a> list) {
        this.f9318a = j6;
        this.f9319b = list;
    }

    public h1.b a(long j6) {
        long j7;
        if (this.f9319b.size() < 2) {
            return null;
        }
        long j8 = j6;
        long j9 = -1;
        long j10 = -1;
        long j11 = -1;
        long j12 = -1;
        boolean z5 = false;
        for (int size = this.f9319b.size() - 1; size >= 0; size--) {
            a aVar = this.f9319b.get(size);
            boolean equals = "video/mp4".equals(aVar.f9320a) | z5;
            if (size == 0) {
                j8 -= aVar.f9323d;
                j7 = 0;
            } else {
                j7 = j8 - aVar.f9322c;
            }
            long j13 = j8;
            j8 = j7;
            if (!equals || j8 == j13) {
                z5 = equals;
            } else {
                j12 = j13 - j8;
                j11 = j8;
                z5 = false;
            }
            if (size == 0) {
                j9 = j8;
                j10 = j13;
            }
        }
        if (j11 == -1 || j12 == -1 || j9 == -1 || j10 == -1) {
            return null;
        }
        return new h1.b(j9, j10, this.f9318a, j11, j12);
    }
}
