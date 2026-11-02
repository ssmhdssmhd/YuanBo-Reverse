package com.google.android.exoplayer2.source.dash;

import h0.y1;
import h0.z1;
import i2.c1;
import l0.i;
import l1.o0;
import p1.f;

/* loaded from: classes.dex */
final class d implements o0 {

    /* renamed from: a, reason: collision with root package name */
    private final y1 f1979a;

    /* renamed from: c, reason: collision with root package name */
    private long[] f1981c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1982d;

    /* renamed from: e, reason: collision with root package name */
    private f f1983e;

    /* renamed from: j, reason: collision with root package name */
    private boolean f1984j;

    /* renamed from: k, reason: collision with root package name */
    private int f1985k;

    /* renamed from: b, reason: collision with root package name */
    private final d1.c f1980b = new d1.c();

    /* renamed from: l, reason: collision with root package name */
    private long f1986l = -9223372036854775807L;

    public d(f fVar, y1 y1Var, boolean z5) {
        this.f1979a = y1Var;
        this.f1983e = fVar;
        this.f1981c = fVar.f8576b;
        d(fVar, z5);
    }

    public String a() {
        return this.f1983e.a();
    }

    @Override // l1.o0
    public void b() {
    }

    public void c(long j6) {
        int e6 = c1.e(this.f1981c, j6, true, false);
        this.f1985k = e6;
        if (!(this.f1982d && e6 == this.f1981c.length)) {
            j6 = -9223372036854775807L;
        }
        this.f1986l = j6;
    }

    public void d(f fVar, boolean z5) {
        int i6 = this.f1985k;
        long j6 = i6 == 0 ? -9223372036854775807L : this.f1981c[i6 - 1];
        this.f1982d = z5;
        this.f1983e = fVar;
        long[] jArr = fVar.f8576b;
        this.f1981c = jArr;
        long j7 = this.f1986l;
        if (j7 != -9223372036854775807L) {
            c(j7);
        } else if (j6 != -9223372036854775807L) {
            this.f1985k = c1.e(jArr, j6, false, false);
        }
    }

    @Override // l1.o0
    public boolean e() {
        return true;
    }

    @Override // l1.o0
    public int j(z1 z1Var, i iVar, int i6) {
        int i7 = this.f1985k;
        boolean z5 = i7 == this.f1981c.length;
        if (z5 && !this.f1982d) {
            iVar.n(4);
            return -4;
        }
        if ((i6 & 2) != 0 || !this.f1984j) {
            z1Var.f5109b = this.f1979a;
            this.f1984j = true;
            return -5;
        }
        if (z5) {
            return -3;
        }
        if ((i6 & 1) == 0) {
            this.f1985k = i7 + 1;
        }
        if ((i6 & 4) == 0) {
            byte[] a6 = this.f1980b.a(this.f1983e.f8575a[i7]);
            iVar.p(a6.length);
            iVar.f7162c.put(a6);
        }
        iVar.f7164e = this.f1981c[i7];
        iVar.n(1);
        return -4;
    }

    @Override // l1.o0
    public int t(long j6) {
        int max = Math.max(this.f1985k, c1.e(this.f1981c, j6, true, false));
        int i6 = max - this.f1985k;
        this.f1985k = max;
        return i6;
    }
}
