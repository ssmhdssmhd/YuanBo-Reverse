package l0;

import h0.y1;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f7172a;

    /* renamed from: b, reason: collision with root package name */
    public final y1 f7173b;

    /* renamed from: c, reason: collision with root package name */
    public final y1 f7174c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7175d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7176e;

    public k(String str, y1 y1Var, y1 y1Var2, int i6, int i7) {
        i2.a.a(i6 == 0 || i7 == 0);
        this.f7172a = i2.a.d(str);
        this.f7173b = (y1) i2.a.e(y1Var);
        this.f7174c = (y1) i2.a.e(y1Var2);
        this.f7175d = i6;
        this.f7176e = i7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f7175d == kVar.f7175d && this.f7176e == kVar.f7176e && this.f7172a.equals(kVar.f7172a) && this.f7173b.equals(kVar.f7173b) && this.f7174c.equals(kVar.f7174c);
    }

    public int hashCode() {
        return ((((((((527 + this.f7175d) * 31) + this.f7176e) * 31) + this.f7172a.hashCode()) * 31) + this.f7173b.hashCode()) * 31) + this.f7174c.hashCode();
    }
}
