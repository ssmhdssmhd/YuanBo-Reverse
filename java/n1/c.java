package n1;

import i2.t;
import l1.n0;
import n1.g;
import o0.e0;

/* loaded from: classes.dex */
public final class c implements g.b {

    /* renamed from: a, reason: collision with root package name */
    private final int[] f8179a;

    /* renamed from: b, reason: collision with root package name */
    private final n0[] f8180b;

    public c(int[] iArr, n0[] n0VarArr) {
        this.f8179a = iArr;
        this.f8180b = n0VarArr;
    }

    public int[] a() {
        int[] iArr = new int[this.f8180b.length];
        int i6 = 0;
        while (true) {
            n0[] n0VarArr = this.f8180b;
            if (i6 >= n0VarArr.length) {
                return iArr;
            }
            iArr[i6] = n0VarArr[i6].G();
            i6++;
        }
    }

    public void b(long j6) {
        for (n0 n0Var : this.f8180b) {
            n0Var.a0(j6);
        }
    }

    @Override // n1.g.b
    public e0 e(int i6, int i7) {
        int i8 = 0;
        while (true) {
            int[] iArr = this.f8179a;
            if (i8 >= iArr.length) {
                t.c("BaseMediaChunkOutput", "Unmatched track of type: " + i7);
                return new o0.k();
            }
            if (i7 == iArr[i8]) {
                return this.f8180b[i8];
            }
            i8++;
        }
    }
}
