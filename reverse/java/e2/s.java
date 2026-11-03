package e2;

import h0.m4;
import h0.y1;
import java.util.List;
import l1.u0;
import l1.v;

/* loaded from: classes.dex */
public interface s extends v {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final u0 f3523a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f3524b;

        /* renamed from: c, reason: collision with root package name */
        public final int f3525c;

        public a(u0 u0Var, int... iArr) {
            this(u0Var, iArr, 0);
        }

        public a(u0 u0Var, int[] iArr, int i6) {
            if (iArr.length == 0) {
                i2.t.d("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.f3523a = u0Var;
            this.f3524b = iArr;
            this.f3525c = i6;
        }
    }

    public interface b {
        s[] a(a[] aVarArr, g2.f fVar, v.b bVar, m4 m4Var);
    }

    void d();

    boolean e(int i6, long j6);

    boolean f(int i6, long j6);

    void g(boolean z5);

    void h();

    boolean i(long j6, n1.f fVar, List<? extends n1.n> list);

    int j(long j6, List<? extends n1.n> list);

    int k();

    y1 l();

    int m();

    int n();

    void o(long j6, long j7, long j8, List<? extends n1.n> list, n1.o[] oVarArr);

    void p(float f6);

    Object q();

    void s();

    void t();
}
