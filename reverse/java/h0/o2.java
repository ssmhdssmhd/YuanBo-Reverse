package h0;

import l1.v;

/* loaded from: classes.dex */
final class o2 {

    /* renamed from: a, reason: collision with root package name */
    public final v.b f4737a;

    /* renamed from: b, reason: collision with root package name */
    public final long f4738b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4739c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4740d;

    /* renamed from: e, reason: collision with root package name */
    public final long f4741e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4742f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f4743g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f4744h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f4745i;

    o2(v.b bVar, long j6, long j7, long j8, long j9, boolean z5, boolean z6, boolean z7, boolean z8) {
        boolean z9 = false;
        i2.a.a(!z8 || z6);
        i2.a.a(!z7 || z6);
        if (!z5 || (!z6 && !z7 && !z8)) {
            z9 = true;
        }
        i2.a.a(z9);
        this.f4737a = bVar;
        this.f4738b = j6;
        this.f4739c = j7;
        this.f4740d = j8;
        this.f4741e = j9;
        this.f4742f = z5;
        this.f4743g = z6;
        this.f4744h = z7;
        this.f4745i = z8;
    }

    public o2 a(long j6) {
        return j6 == this.f4739c ? this : new o2(this.f4737a, this.f4738b, j6, this.f4740d, this.f4741e, this.f4742f, this.f4743g, this.f4744h, this.f4745i);
    }

    public o2 b(long j6) {
        return j6 == this.f4738b ? this : new o2(this.f4737a, j6, this.f4739c, this.f4740d, this.f4741e, this.f4742f, this.f4743g, this.f4744h, this.f4745i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o2.class != obj.getClass()) {
            return false;
        }
        o2 o2Var = (o2) obj;
        return this.f4738b == o2Var.f4738b && this.f4739c == o2Var.f4739c && this.f4740d == o2Var.f4740d && this.f4741e == o2Var.f4741e && this.f4742f == o2Var.f4742f && this.f4743g == o2Var.f4743g && this.f4744h == o2Var.f4744h && this.f4745i == o2Var.f4745i && i2.c1.c(this.f4737a, o2Var.f4737a);
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f4737a.hashCode()) * 31) + ((int) this.f4738b)) * 31) + ((int) this.f4739c)) * 31) + ((int) this.f4740d)) * 31) + ((int) this.f4741e)) * 31) + (this.f4742f ? 1 : 0)) * 31) + (this.f4743g ? 1 : 0)) * 31) + (this.f4744h ? 1 : 0)) * 31) + (this.f4745i ? 1 : 0);
    }
}
