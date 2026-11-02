package u0;

import i2.i0;
import o0.m;

/* loaded from: classes.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private final i0 f9593a = new i0(8);

    /* renamed from: b, reason: collision with root package name */
    private int f9594b;

    private long a(m mVar) {
        int i6 = 0;
        mVar.m(this.f9593a.e(), 0, 1);
        int i7 = this.f9593a.e()[0] & 255;
        if (i7 == 0) {
            return Long.MIN_VALUE;
        }
        int i8 = 128;
        int i9 = 0;
        while ((i7 & i8) == 0) {
            i8 >>= 1;
            i9++;
        }
        int i10 = i7 & (~i8);
        mVar.m(this.f9593a.e(), 1, i9);
        while (i6 < i9) {
            i6++;
            i10 = (this.f9593a.e()[i6] & 255) + (i10 << 8);
        }
        this.f9594b += i9 + 1;
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean b(o0.m r15) {
        /*
            r14 = this;
            long r0 = r15.getLength()
            r2 = -1
            r4 = 1024(0x400, double:5.06E-321)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L12
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 <= 0) goto L11
            goto L12
        L11:
            r4 = r0
        L12:
            int r2 = (int) r4
            i2.i0 r3 = r14.f9593a
            byte[] r3 = r3.e()
            r4 = 0
            r5 = 4
            r15.m(r3, r4, r5)
            i2.i0 r3 = r14.f9593a
            long r7 = r3.H()
            r14.f9594b = r5
        L26:
            r9 = 440786851(0x1a45dfa3, double:2.1777764E-315)
            r3 = 1
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 == 0) goto L52
            int r5 = r14.f9594b
            int r5 = r5 + r3
            r14.f9594b = r5
            if (r5 != r2) goto L36
            return r4
        L36:
            i2.i0 r5 = r14.f9593a
            byte[] r5 = r5.e()
            r15.m(r5, r4, r3)
            r3 = 8
            long r7 = r7 << r3
            r9 = -256(0xffffffffffffff00, double:NaN)
            long r7 = r7 & r9
            i2.i0 r3 = r14.f9593a
            byte[] r3 = r3.e()
            r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            long r9 = (long) r3
            long r7 = r7 | r9
            goto L26
        L52:
            long r7 = r14.a(r15)
            int r2 = r14.f9594b
            long r9 = (long) r2
            r11 = -9223372036854775808
            int r2 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r2 == 0) goto L9f
            if (r6 == 0) goto L68
            long r5 = r9 + r7
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 < 0) goto L68
            goto L9f
        L68:
            int r0 = r14.f9594b
            long r1 = (long) r0
            long r5 = r9 + r7
            int r13 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r13 >= 0) goto L99
            long r0 = r14.a(r15)
            int r2 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r2 != 0) goto L7a
            return r4
        L7a:
            long r0 = r14.a(r15)
            r5 = 0
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 < 0) goto L98
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r13 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r13 <= 0) goto L8c
            goto L98
        L8c:
            if (r2 == 0) goto L68
            int r1 = (int) r0
            r15.n(r1)
            int r0 = r14.f9594b
            int r0 = r0 + r1
            r14.f9594b = r0
            goto L68
        L98:
            return r4
        L99:
            long r0 = (long) r0
            int r15 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r15 != 0) goto L9f
            r4 = 1
        L9f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.f.b(o0.m):boolean");
    }
}
