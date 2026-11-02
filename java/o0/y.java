package o0;

import g1.h;
import i2.i0;
import java.io.EOFException;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private final i0 f8435a = new i0(10);

    public b1.a a(m mVar, h.a aVar) {
        b1.a aVar2 = null;
        int i6 = 0;
        while (true) {
            try {
                mVar.m(this.f8435a.e(), 0, 10);
                this.f8435a.S(0);
                if (this.f8435a.I() != 4801587) {
                    break;
                }
                this.f8435a.T(3);
                int E = this.f8435a.E();
                int i7 = E + 10;
                if (aVar2 == null) {
                    byte[] bArr = new byte[i7];
                    System.arraycopy(this.f8435a.e(), 0, bArr, 0, 10);
                    mVar.m(bArr, 10, E);
                    aVar2 = new g1.h(aVar).e(bArr, i7);
                } else {
                    mVar.n(E);
                }
                i6 += i7;
            } catch (EOFException unused) {
            }
        }
        mVar.g();
        mVar.n(i6);
        return aVar2;
    }
}
