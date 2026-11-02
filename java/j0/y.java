package j0;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* loaded from: classes.dex */
final class y {

    /* renamed from: a, reason: collision with root package name */
    private final a f6626a;

    /* renamed from: b, reason: collision with root package name */
    private int f6627b;

    /* renamed from: c, reason: collision with root package name */
    private long f6628c;

    /* renamed from: d, reason: collision with root package name */
    private long f6629d;

    /* renamed from: e, reason: collision with root package name */
    private long f6630e;

    /* renamed from: f, reason: collision with root package name */
    private long f6631f;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final AudioTrack f6632a;

        /* renamed from: b, reason: collision with root package name */
        private final AudioTimestamp f6633b = new AudioTimestamp();

        /* renamed from: c, reason: collision with root package name */
        private long f6634c;

        /* renamed from: d, reason: collision with root package name */
        private long f6635d;

        /* renamed from: e, reason: collision with root package name */
        private long f6636e;

        public a(AudioTrack audioTrack) {
            this.f6632a = audioTrack;
        }

        public long a() {
            return this.f6636e;
        }

        public long b() {
            return this.f6633b.nanoTime / 1000;
        }

        public boolean c() {
            boolean timestamp = this.f6632a.getTimestamp(this.f6633b);
            if (timestamp) {
                long j6 = this.f6633b.framePosition;
                if (this.f6635d > j6) {
                    this.f6634c++;
                }
                this.f6635d = j6;
                this.f6636e = j6 + (this.f6634c << 32);
            }
            return timestamp;
        }
    }

    public y(AudioTrack audioTrack) {
        if (i2.c1.f5548a >= 19) {
            this.f6626a = new a(audioTrack);
            g();
        } else {
            this.f6626a = null;
            h(3);
        }
    }

    private void h(int i6) {
        this.f6627b = i6;
        long j6 = 10000;
        if (i6 == 0) {
            this.f6630e = 0L;
            this.f6631f = -1L;
            this.f6628c = System.nanoTime() / 1000;
        } else if (i6 != 1) {
            if (i6 == 2 || i6 == 3) {
                j6 = 10000000;
            } else {
                if (i6 != 4) {
                    throw new IllegalStateException();
                }
                j6 = 500000;
            }
        }
        this.f6629d = j6;
    }

    public void a() {
        if (this.f6627b == 4) {
            g();
        }
    }

    public long b() {
        a aVar = this.f6626a;
        if (aVar != null) {
            return aVar.a();
        }
        return -1L;
    }

    public long c() {
        a aVar = this.f6626a;
        if (aVar != null) {
            return aVar.b();
        }
        return -9223372036854775807L;
    }

    public boolean d() {
        return this.f6627b == 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        if (r0 != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        if (r0 == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(long r8) {
        /*
            r7 = this;
            j0.y$a r0 = r7.f6626a
            r1 = 0
            if (r0 == 0) goto L71
            long r2 = r7.f6630e
            long r2 = r8 - r2
            long r4 = r7.f6629d
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L10
            goto L71
        L10:
            r7.f6630e = r8
            boolean r0 = r0.c()
            int r2 = r7.f6627b
            r3 = 3
            r4 = 1
            if (r2 == 0) goto L49
            r8 = 2
            if (r2 == r4) goto L33
            if (r2 == r8) goto L30
            if (r2 == r3) goto L2d
            r8 = 4
            if (r2 != r8) goto L27
            goto L70
        L27:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L2d:
            if (r0 == 0) goto L70
            goto L45
        L30:
            if (r0 != 0) goto L70
            goto L45
        L33:
            if (r0 == 0) goto L45
            j0.y$a r9 = r7.f6626a
            long r1 = r9.a()
            long r3 = r7.f6631f
            int r9 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r9 <= 0) goto L70
            r7.h(r8)
            goto L70
        L45:
            r7.g()
            goto L70
        L49:
            if (r0 == 0) goto L63
            j0.y$a r8 = r7.f6626a
            long r8 = r8.b()
            long r2 = r7.f6628c
            int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r5 < 0) goto L71
            j0.y$a r8 = r7.f6626a
            long r8 = r8.a()
            r7.f6631f = r8
            r7.h(r4)
            goto L70
        L63:
            long r1 = r7.f6628c
            long r8 = r8 - r1
            r1 = 500000(0x7a120, double:2.47033E-318)
            int r4 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r4 <= 0) goto L70
            r7.h(r3)
        L70:
            r1 = r0
        L71:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.y.e(long):boolean");
    }

    public void f() {
        h(4);
    }

    public void g() {
        if (this.f6626a != null) {
            h(0);
        }
    }
}
