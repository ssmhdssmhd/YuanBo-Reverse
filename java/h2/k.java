package h2;

import java.io.InterruptedIOException;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final c f5171a;

    /* renamed from: b, reason: collision with root package name */
    private final h2.a f5172b;

    /* renamed from: c, reason: collision with root package name */
    private final g2.q f5173c;

    /* renamed from: d, reason: collision with root package name */
    private final String f5174d;

    /* renamed from: e, reason: collision with root package name */
    private final byte[] f5175e;

    /* renamed from: f, reason: collision with root package name */
    private final a f5176f;

    /* renamed from: g, reason: collision with root package name */
    private long f5177g;

    /* renamed from: h, reason: collision with root package name */
    private long f5178h;

    /* renamed from: i, reason: collision with root package name */
    private long f5179i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f5180j;

    public interface a {
        void a(long j6, long j7, long j8);
    }

    public k(c cVar, g2.q qVar, byte[] bArr, a aVar) {
        this.f5171a = cVar;
        this.f5172b = cVar.p();
        this.f5173c = qVar;
        this.f5175e = bArr == null ? new byte[131072] : bArr;
        this.f5176f = aVar;
        this.f5174d = cVar.q().a(qVar);
        this.f5177g = qVar.f4103g;
    }

    private long c() {
        long j6 = this.f5178h;
        if (j6 == -1) {
            return -1L;
        }
        return j6 - this.f5173c.f4103g;
    }

    private void d(long j6) {
        this.f5179i += j6;
        a aVar = this.f5176f;
        if (aVar != null) {
            aVar.a(c(), this.f5179i, j6);
        }
    }

    private void e(long j6) {
        if (this.f5178h == j6) {
            return;
        }
        this.f5178h = j6;
        a aVar = this.f5176f;
        if (aVar != null) {
            aVar.a(c(), this.f5179i, 0L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006f A[Catch: IOException -> 0x0068, TryCatch #0 {IOException -> 0x0068, blocks: (B:25:0x0064, B:33:0x006f, B:36:0x007d, B:42:0x0085), top: B:24:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085 A[Catch: IOException -> 0x0068, TRY_LEAVE, TryCatch #0 {IOException -> 0x0068, blocks: (B:25:0x0064, B:33:0x006f, B:36:0x007d, B:42:0x0085), top: B:24:0x0064 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long f(long r10, long r12) {
        /*
            r9 = this;
            long r0 = r10 + r12
            long r2 = r9.f5178h
            r4 = 1
            r5 = 0
            r6 = -1
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 == 0) goto L13
            int r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r0 != 0) goto L11
            goto L13
        L11:
            r0 = 0
            goto L14
        L13:
            r0 = 1
        L14:
            int r1 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r1 == 0) goto L36
            g2.q r1 = r9.f5173c
            g2.q$b r1 = r1.a()
            g2.q$b r1 = r1.h(r10)
            g2.q$b r12 = r1.g(r12)
            g2.q r12 = r12.a()
            h2.c r13 = r9.f5171a     // Catch: java.io.IOException -> L31
            long r12 = r13.a(r12)     // Catch: java.io.IOException -> L31
            goto L38
        L31:
            h2.c r12 = r9.f5171a
            g2.p.a(r12)
        L36:
            r12 = r6
            r4 = 0
        L38:
            if (r4 != 0) goto L5d
            r9.g()
            g2.q r12 = r9.f5173c
            g2.q$b r12 = r12.a()
            g2.q$b r12 = r12.h(r10)
            g2.q$b r12 = r12.g(r6)
            g2.q r12 = r12.a()
            h2.c r13 = r9.f5171a     // Catch: java.io.IOException -> L56
            long r12 = r13.a(r12)     // Catch: java.io.IOException -> L56
            goto L5d
        L56:
            r10 = move-exception
            h2.c r11 = r9.f5171a
            g2.p.a(r11)
            throw r10
        L5d:
            if (r0 == 0) goto L6a
            int r1 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r1 == 0) goto L6a
            long r12 = r12 + r10
            r9.e(r12)     // Catch: java.io.IOException -> L68
            goto L6a
        L68:
            r10 = move-exception
            goto L8b
        L6a:
            r12 = 0
            r13 = 0
        L6c:
            r1 = -1
            if (r12 == r1) goto L83
            r9.g()     // Catch: java.io.IOException -> L68
            h2.c r12 = r9.f5171a     // Catch: java.io.IOException -> L68
            byte[] r2 = r9.f5175e     // Catch: java.io.IOException -> L68
            int r3 = r2.length     // Catch: java.io.IOException -> L68
            int r12 = r12.read(r2, r5, r3)     // Catch: java.io.IOException -> L68
            if (r12 == r1) goto L6c
            long r1 = (long) r12     // Catch: java.io.IOException -> L68
            r9.d(r1)     // Catch: java.io.IOException -> L68
            int r13 = r13 + r12
            goto L6c
        L83:
            if (r0 == 0) goto L91
            long r0 = (long) r13     // Catch: java.io.IOException -> L68
            long r10 = r10 + r0
            r9.e(r10)     // Catch: java.io.IOException -> L68
            goto L91
        L8b:
            h2.c r11 = r9.f5171a
            g2.p.a(r11)
            throw r10
        L91:
            h2.c r10 = r9.f5171a
            r10.close()
            long r10 = (long) r13
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.k.f(long, long):long");
    }

    private void g() {
        if (this.f5180j) {
            throw new InterruptedIOException();
        }
    }

    public void a() {
        long j6;
        g();
        h2.a aVar = this.f5172b;
        String str = this.f5174d;
        g2.q qVar = this.f5173c;
        this.f5179i = aVar.f(str, qVar.f4103g, qVar.f4104h);
        g2.q qVar2 = this.f5173c;
        long j7 = qVar2.f4104h;
        if (j7 != -1) {
            this.f5178h = qVar2.f4103g + j7;
        } else {
            long a6 = n.a(this.f5172b.d(this.f5174d));
            if (a6 == -1) {
                a6 = -1;
            }
            this.f5178h = a6;
        }
        a aVar2 = this.f5176f;
        if (aVar2 != null) {
            aVar2.a(c(), this.f5179i, 0L);
        }
        while (true) {
            long j8 = this.f5178h;
            if (j8 != -1 && this.f5177g >= j8) {
                return;
            }
            g();
            long j9 = this.f5178h;
            long i6 = this.f5172b.i(this.f5174d, this.f5177g, j9 == -1 ? Long.MAX_VALUE : j9 - this.f5177g);
            if (i6 > 0) {
                j6 = this.f5177g;
            } else {
                long j10 = -i6;
                if (j10 == Long.MAX_VALUE) {
                    j10 = -1;
                }
                j6 = this.f5177g;
                i6 = f(j6, j10);
            }
            this.f5177g = j6 + i6;
        }
    }

    public void b() {
        this.f5180j = true;
    }
}
