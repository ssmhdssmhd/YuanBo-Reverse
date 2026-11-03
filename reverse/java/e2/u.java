package e2;

import android.util.Pair;
import h0.a4;
import h0.m4;
import h0.y3;
import h0.z3;
import i2.c1;
import java.util.Arrays;
import l1.u0;
import l1.v;
import l1.w0;

/* loaded from: classes.dex */
public abstract class u extends b0 {

    /* renamed from: c, reason: collision with root package name */
    private a f3528c;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f3529a;

        /* renamed from: b, reason: collision with root package name */
        private final String[] f3530b;

        /* renamed from: c, reason: collision with root package name */
        private final int[] f3531c;

        /* renamed from: d, reason: collision with root package name */
        private final w0[] f3532d;

        /* renamed from: e, reason: collision with root package name */
        private final int[] f3533e;

        /* renamed from: f, reason: collision with root package name */
        private final int[][][] f3534f;

        /* renamed from: g, reason: collision with root package name */
        private final w0 f3535g;

        a(String[] strArr, int[] iArr, w0[] w0VarArr, int[] iArr2, int[][][] iArr3, w0 w0Var) {
            this.f3530b = strArr;
            this.f3531c = iArr;
            this.f3532d = w0VarArr;
            this.f3534f = iArr3;
            this.f3533e = iArr2;
            this.f3535g = w0Var;
            this.f3529a = iArr.length;
        }

        public int a(int i6, int i7, boolean z5) {
            int i8 = this.f3532d[i6].b(i7).f7445a;
            int[] iArr = new int[i8];
            int i9 = 0;
            for (int i10 = 0; i10 < i8; i10++) {
                int g6 = g(i6, i7, i10);
                if (g6 == 4 || (z5 && g6 == 3)) {
                    iArr[i9] = i10;
                    i9++;
                }
            }
            return b(i6, i7, Arrays.copyOf(iArr, i9));
        }

        public int b(int i6, int i7, int[] iArr) {
            int i8 = 0;
            String str = null;
            boolean z5 = false;
            int i9 = 0;
            int i10 = 16;
            while (i8 < iArr.length) {
                String str2 = this.f3532d[i6].b(i7).b(iArr[i8]).f5066p;
                int i11 = i9 + 1;
                if (i9 == 0) {
                    str = str2;
                } else {
                    z5 |= !c1.c(str, str2);
                }
                i10 = Math.min(i10, y3.d(this.f3534f[i6][i7][i8]));
                i8++;
                i9 = i11;
            }
            return z5 ? Math.min(i10, this.f3533e[i6]) : i10;
        }

        public int c(int i6, int i7, int i8) {
            return this.f3534f[i6][i7][i8];
        }

        public int d() {
            return this.f3529a;
        }

        public int e(int i6) {
            return this.f3531c[i6];
        }

        public w0 f(int i6) {
            return this.f3532d[i6];
        }

        public int g(int i6, int i7, int i8) {
            return y3.f(c(i6, i7, i8));
        }

        public w0 h() {
            return this.f3535g;
        }
    }

    private static int i(z3[] z3VarArr, u0 u0Var, int[] iArr, boolean z5) {
        int length = z3VarArr.length;
        int i6 = 0;
        boolean z6 = true;
        for (int i7 = 0; i7 < z3VarArr.length; i7++) {
            z3 z3Var = z3VarArr[i7];
            int i8 = 0;
            for (int i9 = 0; i9 < u0Var.f7445a; i9++) {
                i8 = Math.max(i8, y3.f(z3Var.a(u0Var.b(i9))));
            }
            boolean z7 = iArr[i7] == 0;
            if (i8 > i6 || (i8 == i6 && z5 && !z6 && z7)) {
                length = i7;
                z6 = z7;
                i6 = i8;
            }
        }
        return length;
    }

    private static int[] k(z3 z3Var, u0 u0Var) {
        int[] iArr = new int[u0Var.f7445a];
        for (int i6 = 0; i6 < u0Var.f7445a; i6++) {
            iArr[i6] = z3Var.a(u0Var.b(i6));
        }
        return iArr;
    }

    private static int[] l(z3[] z3VarArr) {
        int length = z3VarArr.length;
        int[] iArr = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            iArr[i6] = z3VarArr[i6].k();
        }
        return iArr;
    }

    @Override // e2.b0
    public final void e(Object obj) {
        this.f3528c = (a) obj;
    }

    @Override // e2.b0
    public final c0 g(z3[] z3VarArr, w0 w0Var, v.b bVar, m4 m4Var) {
        int[] iArr = new int[z3VarArr.length + 1];
        int length = z3VarArr.length + 1;
        u0[][] u0VarArr = new u0[length][];
        int[][][] iArr2 = new int[z3VarArr.length + 1][][];
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = w0Var.f7457a;
            u0VarArr[i6] = new u0[i7];
            iArr2[i6] = new int[i7][];
        }
        int[] l6 = l(z3VarArr);
        for (int i8 = 0; i8 < w0Var.f7457a; i8++) {
            u0 b6 = w0Var.b(i8);
            int i9 = i(z3VarArr, b6, iArr, b6.f7447c == 5);
            int[] k6 = i9 == z3VarArr.length ? new int[b6.f7445a] : k(z3VarArr[i9], b6);
            int i10 = iArr[i9];
            u0VarArr[i9][i10] = b6;
            iArr2[i9][i10] = k6;
            iArr[i9] = i10 + 1;
        }
        w0[] w0VarArr = new w0[z3VarArr.length];
        String[] strArr = new String[z3VarArr.length];
        int[] iArr3 = new int[z3VarArr.length];
        for (int i11 = 0; i11 < z3VarArr.length; i11++) {
            int i12 = iArr[i11];
            w0VarArr[i11] = new w0((u0[]) c1.I0(u0VarArr[i11], i12));
            iArr2[i11] = (int[][]) c1.I0(iArr2[i11], i12);
            strArr[i11] = z3VarArr[i11].getName();
            iArr3[i11] = z3VarArr[i11].f();
        }
        a aVar = new a(strArr, iArr3, w0VarArr, l6, iArr2, new w0((u0[]) c1.I0(u0VarArr[z3VarArr.length], iArr[z3VarArr.length])));
        Pair<a4[], s[]> m6 = m(aVar, iArr2, l6, bVar, m4Var);
        return new c0((a4[]) m6.first, (s[]) m6.second, a0.a(aVar, (v[]) m6.second), aVar);
    }

    public final a j() {
        return this.f3528c;
    }

    protected abstract Pair<a4[], s[]> m(a aVar, int[][][] iArr, int[] iArr2, v.b bVar, m4 m4Var);
}
