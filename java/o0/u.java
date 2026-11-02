package o0;

import i2.c1;
import o0.b0;
import o0.v;

/* loaded from: classes.dex */
public final class u implements b0 {

    /* renamed from: a, reason: collision with root package name */
    private final v f8415a;

    /* renamed from: b, reason: collision with root package name */
    private final long f8416b;

    public u(v vVar, long j6) {
        this.f8415a = vVar;
        this.f8416b = j6;
    }

    private c0 a(long j6, long j7) {
        return new c0((j6 * 1000000) / this.f8415a.f8421e, this.f8416b + j7);
    }

    @Override // o0.b0
    public boolean f() {
        return true;
    }

    @Override // o0.b0
    public b0.a h(long j6) {
        i2.a.i(this.f8415a.f8427k);
        v vVar = this.f8415a;
        v.a aVar = vVar.f8427k;
        long[] jArr = aVar.f8429a;
        long[] jArr2 = aVar.f8430b;
        int i6 = c1.i(jArr, vVar.i(j6), true, false);
        c0 a6 = a(i6 == -1 ? 0L : jArr[i6], i6 != -1 ? jArr2[i6] : 0L);
        if (a6.f8332a == j6 || i6 == jArr.length - 1) {
            return new b0.a(a6);
        }
        int i7 = i6 + 1;
        return new b0.a(a6, a(jArr[i7], jArr2[i7]));
    }

    @Override // o0.b0
    public long i() {
        return this.f8415a.f();
    }
}
