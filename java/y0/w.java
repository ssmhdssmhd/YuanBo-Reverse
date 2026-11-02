package y0;

import i2.r0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import y0.i0;

/* loaded from: classes.dex */
public final class w implements i0 {

    /* renamed from: a, reason: collision with root package name */
    private final m f11011a;

    /* renamed from: b, reason: collision with root package name */
    private final i2.h0 f11012b = new i2.h0(new byte[10]);

    /* renamed from: c, reason: collision with root package name */
    private int f11013c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f11014d;

    /* renamed from: e, reason: collision with root package name */
    private r0 f11015e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f11016f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f11017g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f11018h;

    /* renamed from: i, reason: collision with root package name */
    private int f11019i;

    /* renamed from: j, reason: collision with root package name */
    private int f11020j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f11021k;

    /* renamed from: l, reason: collision with root package name */
    private long f11022l;

    public w(m mVar) {
        this.f11011a = mVar;
    }

    private boolean d(i2.i0 i0Var, byte[] bArr, int i6) {
        int min = Math.min(i0Var.a(), i6 - this.f11014d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            i0Var.T(min);
        } else {
            i0Var.j(bArr, this.f11014d, min);
        }
        int i7 = this.f11014d + min;
        this.f11014d = i7;
        return i7 == i6;
    }

    private boolean e() {
        this.f11012b.p(0);
        int h6 = this.f11012b.h(24);
        if (h6 != 1) {
            i2.t.i("PesReader", "Unexpected start code prefix: " + h6);
            this.f11020j = -1;
            return false;
        }
        this.f11012b.r(8);
        int h7 = this.f11012b.h(16);
        this.f11012b.r(5);
        this.f11021k = this.f11012b.g();
        this.f11012b.r(2);
        this.f11016f = this.f11012b.g();
        this.f11017g = this.f11012b.g();
        this.f11012b.r(6);
        int h8 = this.f11012b.h(8);
        this.f11019i = h8;
        if (h7 != 0) {
            int i6 = ((h7 + 6) - 9) - h8;
            this.f11020j = i6;
            if (i6 < 0) {
                i2.t.i("PesReader", "Found negative packet payload size: " + this.f11020j);
            }
            return true;
        }
        this.f11020j = -1;
        return true;
    }

    @RequiresNonNull({"timestampAdjuster"})
    private void f() {
        this.f11012b.p(0);
        this.f11022l = -9223372036854775807L;
        if (this.f11016f) {
            this.f11012b.r(4);
            this.f11012b.r(1);
            this.f11012b.r(1);
            long h6 = (this.f11012b.h(3) << 30) | (this.f11012b.h(15) << 15) | this.f11012b.h(15);
            this.f11012b.r(1);
            if (!this.f11018h && this.f11017g) {
                this.f11012b.r(4);
                this.f11012b.r(1);
                this.f11012b.r(1);
                this.f11012b.r(1);
                this.f11015e.b((this.f11012b.h(3) << 30) | (this.f11012b.h(15) << 15) | this.f11012b.h(15));
                this.f11018h = true;
            }
            this.f11022l = this.f11015e.b(h6);
        }
    }

    private void g(int i6) {
        this.f11013c = i6;
        this.f11014d = 0;
    }

    @Override // y0.i0
    public final void a() {
        this.f11013c = 0;
        this.f11014d = 0;
        this.f11018h = false;
        this.f11011a.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x007a -> B:12:0x007c). Please report as a decompilation issue!!! */
    @Override // y0.i0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(i2.i0 r8, int r9) {
        /*
            r7 = this;
            i2.r0 r0 = r7.f11015e
            i2.a.i(r0)
            r0 = r9 & 1
            r1 = -1
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == 0) goto L47
            int r0 = r7.f11013c
            if (r0 == 0) goto L44
            if (r0 == r4) goto L44
            java.lang.String r5 = "PesReader"
            if (r0 == r3) goto L3f
            if (r0 != r2) goto L39
            int r0 = r7.f11020j
            if (r0 == r1) goto L7c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "Unexpected start indicator: expected "
            r0.append(r6)
            int r6 = r7.f11020j
            r0.append(r6)
            java.lang.String r6 = " more bytes"
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            i2.t.i(r5, r0)
            goto L7c
        L39:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L3f:
            java.lang.String r0 = "Unexpected start indicator reading extended header"
            i2.t.i(r5, r0)
        L44:
            r7.g(r4)
        L47:
            int r0 = r8.a()
            if (r0 <= 0) goto Ld8
            int r0 = r7.f11013c
            if (r0 == 0) goto Lcf
            r5 = 0
            if (r0 == r4) goto Lb7
            if (r0 == r3) goto L88
            if (r0 != r2) goto L82
            int r0 = r8.a()
            int r6 = r7.f11020j
            if (r6 != r1) goto L61
            goto L63
        L61:
            int r5 = r0 - r6
        L63:
            if (r5 <= 0) goto L6e
            int r0 = r0 - r5
            int r5 = r8.f()
            int r5 = r5 + r0
            r8.R(r5)
        L6e:
            y0.m r5 = r7.f11011a
            r5.b(r8)
            int r5 = r7.f11020j
            if (r5 == r1) goto L47
            int r5 = r5 - r0
            r7.f11020j = r5
            if (r5 != 0) goto L47
        L7c:
            y0.m r0 = r7.f11011a
            r0.c()
            goto L44
        L82:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L88:
            r0 = 10
            int r6 = r7.f11019i
            int r0 = java.lang.Math.min(r0, r6)
            i2.h0 r6 = r7.f11012b
            byte[] r6 = r6.f5572a
            boolean r0 = r7.d(r8, r6, r0)
            if (r0 == 0) goto L47
            r0 = 0
            int r6 = r7.f11019i
            boolean r0 = r7.d(r8, r0, r6)
            if (r0 == 0) goto L47
            r7.f()
            boolean r0 = r7.f11021k
            if (r0 == 0) goto Lab
            r5 = 4
        Lab:
            r9 = r9 | r5
            y0.m r0 = r7.f11011a
            long r5 = r7.f11022l
            r0.d(r5, r9)
            r7.g(r2)
            goto L47
        Lb7:
            i2.h0 r0 = r7.f11012b
            byte[] r0 = r0.f5572a
            r6 = 9
            boolean r0 = r7.d(r8, r0, r6)
            if (r0 == 0) goto L47
            boolean r0 = r7.e()
            if (r0 == 0) goto Lca
            r5 = 2
        Lca:
            r7.g(r5)
            goto L47
        Lcf:
            int r0 = r8.a()
            r8.T(r0)
            goto L47
        Ld8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y0.w.b(i2.i0, int):void");
    }

    @Override // y0.i0
    public void c(r0 r0Var, o0.n nVar, i0.d dVar) {
        this.f11015e = r0Var;
        this.f11011a.e(nVar, dVar);
    }
}
