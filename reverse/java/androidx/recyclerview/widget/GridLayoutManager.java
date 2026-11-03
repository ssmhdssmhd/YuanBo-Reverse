package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.x;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    boolean G;
    int H;
    final SparseIntArray I;
    final SparseIntArray J;
    c K;
    final Rect L;
    private boolean M;

    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int e(int i6, int i7) {
            return i6 % i7;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i6) {
            return 1;
        }
    }

    public static class b extends RecyclerView.o {

        /* renamed from: e, reason: collision with root package name */
        int f927e;

        /* renamed from: f, reason: collision with root package name */
        int f928f;

        public b(int i6, int i7) {
            super(i6, i7);
            this.f927e = -1;
            this.f928f = 0;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f927e = -1;
            this.f928f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f927e = -1;
            this.f928f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f927e = -1;
            this.f928f = 0;
        }

        public int b() {
            return this.f927e;
        }

        public int c() {
            return this.f928f;
        }
    }

    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final SparseIntArray f929a = new SparseIntArray();

        /* renamed from: b, reason: collision with root package name */
        final SparseIntArray f930b = new SparseIntArray();

        /* renamed from: c, reason: collision with root package name */
        private boolean f931c = false;

        /* renamed from: d, reason: collision with root package name */
        private boolean f932d = false;

        static int a(SparseIntArray sparseIntArray, int i6) {
            int size = sparseIntArray.size() - 1;
            int i7 = 0;
            while (i7 <= size) {
                int i8 = (i7 + size) >>> 1;
                if (sparseIntArray.keyAt(i8) < i6) {
                    i7 = i8 + 1;
                } else {
                    size = i8 - 1;
                }
            }
            int i9 = i7 - 1;
            if (i9 < 0 || i9 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i9);
        }

        int b(int i6, int i7) {
            if (!this.f932d) {
                return d(i6, i7);
            }
            int i8 = this.f930b.get(i6, -1);
            if (i8 != -1) {
                return i8;
            }
            int d6 = d(i6, i7);
            this.f930b.put(i6, d6);
            return d6;
        }

        int c(int i6, int i7) {
            if (!this.f931c) {
                return e(i6, i7);
            }
            int i8 = this.f929a.get(i6, -1);
            if (i8 != -1) {
                return i8;
            }
            int e6 = e(i6, i7);
            this.f929a.put(i6, e6);
            return e6;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int d(int r7, int r8) {
            /*
                r6 = this;
                boolean r0 = r6.f932d
                r1 = 0
                if (r0 == 0) goto L24
                android.util.SparseIntArray r0 = r6.f930b
                int r0 = a(r0, r7)
                r2 = -1
                if (r0 == r2) goto L24
                android.util.SparseIntArray r2 = r6.f930b
                int r2 = r2.get(r0)
                int r3 = r0 + 1
                int r4 = r6.c(r0, r8)
                int r0 = r6.f(r0)
                int r4 = r4 + r0
                if (r4 != r8) goto L27
                int r2 = r2 + 1
                goto L26
            L24:
                r2 = 0
                r3 = 0
            L26:
                r4 = 0
            L27:
                int r0 = r6.f(r7)
            L2b:
                if (r3 >= r7) goto L40
                int r5 = r6.f(r3)
                int r4 = r4 + r5
                if (r4 != r8) goto L38
                int r2 = r2 + 1
                r4 = 0
                goto L3d
            L38:
                if (r4 <= r8) goto L3d
                int r2 = r2 + 1
                r4 = r5
            L3d:
                int r3 = r3 + 1
                goto L2b
            L40:
                int r4 = r4 + r0
                if (r4 <= r8) goto L45
                int r2 = r2 + 1
            L45:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.d(int, int):int");
        }

        public abstract int e(int i6, int i7);

        public abstract int f(int i6);

        public void g() {
            this.f930b.clear();
        }

        public void h() {
            this.f929a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.G = false;
        this.H = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new a();
        this.L = new Rect();
        a1(RecyclerView.n.J(context, attributeSet, i6, i7).f1069b);
    }

    private int X0(RecyclerView.y yVar) {
        if (t() != 0 && yVar.a() != 0) {
            L0();
            boolean T0 = T0();
            View N0 = N0(!T0, true);
            View M0 = M0(!T0, true);
            if (N0 != null && M0 != null) {
                int b6 = this.K.b(I(N0), this.H);
                int b7 = this.K.b(I(M0), this.H);
                int max = this.f938v ? Math.max(0, ((this.K.b(yVar.a() - 1, this.H) + 1) - Math.max(b6, b7)) - 1) : Math.max(0, Math.min(b6, b7));
                if (T0) {
                    return Math.round((max * (Math.abs(this.f935s.d(M0) - this.f935s.e(N0)) / ((this.K.b(I(M0), this.H) - this.K.b(I(N0), this.H)) + 1))) + (this.f935s.g() - this.f935s.e(N0)));
                }
                return max;
            }
        }
        return 0;
    }

    private int Y0(RecyclerView.y yVar) {
        if (t() != 0 && yVar.a() != 0) {
            L0();
            View N0 = N0(!T0(), true);
            View M0 = M0(!T0(), true);
            if (N0 != null && M0 != null) {
                if (!T0()) {
                    return this.K.b(yVar.a() - 1, this.H) + 1;
                }
                int d6 = this.f935s.d(M0) - this.f935s.e(N0);
                int b6 = this.K.b(I(N0), this.H);
                return (int) ((d6 / ((this.K.b(I(M0), this.H) - b6) + 1)) * (this.K.b(yVar.a() - 1, this.H) + 1));
            }
        }
        return 0;
    }

    private int Z0(RecyclerView.u uVar, RecyclerView.y yVar, int i6) {
        if (!yVar.b()) {
            return this.K.b(i6, this.H);
        }
        int d6 = uVar.d(i6);
        if (d6 != -1) {
            return this.K.b(d6, this.H);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i6);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.n
    public boolean G0() {
        return this.B == null && !this.G;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int L(RecyclerView.u uVar, RecyclerView.y yVar) {
        if (this.f933q == 0) {
            return this.H;
        }
        if (yVar.a() < 1) {
            return 0;
        }
        return Z0(uVar, yVar, yVar.a() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void W0(boolean z5) {
        if (z5) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.W0(false);
    }

    public void a1(int i6) {
        if (i6 == this.H) {
            return;
        }
        this.G = true;
        if (i6 >= 1) {
            this.H = i6;
            this.K.h();
            C0();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i6);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean d(RecyclerView.o oVar) {
        return oVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void e0(RecyclerView.u uVar, RecyclerView.y yVar, View view, x xVar) {
        int i6;
        int b6;
        int c6;
        boolean z5;
        boolean z6;
        int i7;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.d0(view, xVar);
            return;
        }
        b bVar = (b) layoutParams;
        int Z0 = Z0(uVar, yVar, bVar.a());
        if (this.f933q == 0) {
            i7 = bVar.b();
            i6 = bVar.c();
            c6 = 1;
            z5 = false;
            z6 = false;
            b6 = Z0;
        } else {
            i6 = 1;
            b6 = bVar.b();
            c6 = bVar.c();
            z5 = false;
            z6 = false;
            i7 = Z0;
        }
        xVar.K(x.c.a(i7, i6, b6, c6, z5, z6));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.n
    public int g(RecyclerView.y yVar) {
        return this.M ? X0(yVar) : super.g(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g0(RecyclerView recyclerView, int i6, int i7) {
        this.K.h();
        this.K.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.n
    public int h(RecyclerView.y yVar) {
        return this.M ? Y0(yVar) : super.h(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void h0(RecyclerView recyclerView) {
        this.K.h();
        this.K.g();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i0(RecyclerView recyclerView, int i6, int i7, int i8) {
        this.K.h();
        this.K.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.n
    public int j(RecyclerView.y yVar) {
        return this.M ? X0(yVar) : super.j(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void j0(RecyclerView recyclerView, int i6, int i7) {
        this.K.h();
        this.K.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.n
    public int k(RecyclerView.y yVar) {
        return this.M ? Y0(yVar) : super.k(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void l0(RecyclerView recyclerView, int i6, int i7, Object obj) {
        this.K.h();
        this.K.g();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o n() {
        return this.f933q == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o o(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o p(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int v(RecyclerView.u uVar, RecyclerView.y yVar) {
        if (this.f933q == 1) {
            return this.H;
        }
        if (yVar.a() < 1) {
            return 0;
        }
        return Z0(uVar, yVar, yVar.a() - 1) + 1;
    }
}
