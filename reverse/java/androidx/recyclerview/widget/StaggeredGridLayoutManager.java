package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.n {
    private boolean D;
    private boolean E;
    private e F;

    /* renamed from: r, reason: collision with root package name */
    f[] f1105r;

    /* renamed from: s, reason: collision with root package name */
    h f1106s;

    /* renamed from: t, reason: collision with root package name */
    h f1107t;

    /* renamed from: u, reason: collision with root package name */
    private int f1108u;

    /* renamed from: v, reason: collision with root package name */
    private final androidx.recyclerview.widget.f f1109v;

    /* renamed from: y, reason: collision with root package name */
    private BitSet f1112y;

    /* renamed from: q, reason: collision with root package name */
    private int f1104q = -1;

    /* renamed from: w, reason: collision with root package name */
    boolean f1110w = false;

    /* renamed from: x, reason: collision with root package name */
    boolean f1111x = false;

    /* renamed from: z, reason: collision with root package name */
    int f1113z = -1;
    int A = Integer.MIN_VALUE;
    d B = new d();
    private int C = 2;
    private final Rect G = new Rect();
    private final b H = new b();
    private boolean I = false;
    private boolean J = true;
    private final Runnable K = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.H0();
        }
    }

    class b {

        /* renamed from: a, reason: collision with root package name */
        int f1115a;

        /* renamed from: b, reason: collision with root package name */
        int f1116b;

        /* renamed from: c, reason: collision with root package name */
        boolean f1117c;

        /* renamed from: d, reason: collision with root package name */
        boolean f1118d;

        /* renamed from: e, reason: collision with root package name */
        boolean f1119e;

        /* renamed from: f, reason: collision with root package name */
        int[] f1120f;

        b() {
            a();
        }

        void a() {
            this.f1115a = -1;
            this.f1116b = Integer.MIN_VALUE;
            this.f1117c = false;
            this.f1118d = false;
            this.f1119e = false;
            int[] iArr = this.f1120f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    public static class c extends RecyclerView.o {

        /* renamed from: e, reason: collision with root package name */
        f f1122e;

        /* renamed from: f, reason: collision with root package name */
        boolean f1123f;

        public c(int i6, int i7) {
            super(i6, i7);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        int[] f1124a;

        /* renamed from: b, reason: collision with root package name */
        List<a> f1125b;

        static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0018a();

            /* renamed from: a, reason: collision with root package name */
            int f1126a;

            /* renamed from: b, reason: collision with root package name */
            int f1127b;

            /* renamed from: c, reason: collision with root package name */
            int[] f1128c;

            /* renamed from: d, reason: collision with root package name */
            boolean f1129d;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a, reason: collision with other inner class name */
            class C0018a implements Parcelable.Creator<a> {
                C0018a() {
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public a[] newArray(int i6) {
                    return new a[i6];
                }
            }

            a() {
            }

            a(Parcel parcel) {
                this.f1126a = parcel.readInt();
                this.f1127b = parcel.readInt();
                this.f1129d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f1128c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            int d(int i6) {
                int[] iArr = this.f1128c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i6];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f1126a + ", mGapDir=" + this.f1127b + ", mHasUnwantedGapAfter=" + this.f1129d + ", mGapPerSpan=" + Arrays.toString(this.f1128c) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i6) {
                parcel.writeInt(this.f1126a);
                parcel.writeInt(this.f1127b);
                parcel.writeInt(this.f1129d ? 1 : 0);
                int[] iArr = this.f1128c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f1128c);
                }
            }
        }

        d() {
        }

        private int g(int i6) {
            if (this.f1125b == null) {
                return -1;
            }
            a e6 = e(i6);
            if (e6 != null) {
                this.f1125b.remove(e6);
            }
            int size = this.f1125b.size();
            int i7 = 0;
            while (true) {
                if (i7 >= size) {
                    i7 = -1;
                    break;
                }
                if (this.f1125b.get(i7).f1126a >= i6) {
                    break;
                }
                i7++;
            }
            if (i7 == -1) {
                return -1;
            }
            a aVar = this.f1125b.get(i7);
            this.f1125b.remove(i7);
            return aVar.f1126a;
        }

        private void j(int i6, int i7) {
            List<a> list = this.f1125b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1125b.get(size);
                int i8 = aVar.f1126a;
                if (i8 >= i6) {
                    aVar.f1126a = i8 + i7;
                }
            }
        }

        private void k(int i6, int i7) {
            List<a> list = this.f1125b;
            if (list == null) {
                return;
            }
            int i8 = i6 + i7;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1125b.get(size);
                int i9 = aVar.f1126a;
                if (i9 >= i6) {
                    if (i9 < i8) {
                        this.f1125b.remove(size);
                    } else {
                        aVar.f1126a = i9 - i7;
                    }
                }
            }
        }

        void a() {
            int[] iArr = this.f1124a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1125b = null;
        }

        void b(int i6) {
            int[] iArr = this.f1124a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i6, 10) + 1];
                this.f1124a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i6 >= iArr.length) {
                int[] iArr3 = new int[l(i6)];
                this.f1124a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f1124a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        int c(int i6) {
            List<a> list = this.f1125b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f1125b.get(size).f1126a >= i6) {
                        this.f1125b.remove(size);
                    }
                }
            }
            return f(i6);
        }

        public a d(int i6, int i7, int i8, boolean z5) {
            List<a> list = this.f1125b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i9 = 0; i9 < size; i9++) {
                a aVar = this.f1125b.get(i9);
                int i10 = aVar.f1126a;
                if (i10 >= i7) {
                    return null;
                }
                if (i10 >= i6 && (i8 == 0 || aVar.f1127b == i8 || (z5 && aVar.f1129d))) {
                    return aVar;
                }
            }
            return null;
        }

        public a e(int i6) {
            List<a> list = this.f1125b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f1125b.get(size);
                if (aVar.f1126a == i6) {
                    return aVar;
                }
            }
            return null;
        }

        int f(int i6) {
            int[] iArr = this.f1124a;
            if (iArr == null || i6 >= iArr.length) {
                return -1;
            }
            int g6 = g(i6);
            if (g6 == -1) {
                int[] iArr2 = this.f1124a;
                Arrays.fill(iArr2, i6, iArr2.length, -1);
                return this.f1124a.length;
            }
            int min = Math.min(g6 + 1, this.f1124a.length);
            Arrays.fill(this.f1124a, i6, min, -1);
            return min;
        }

        void h(int i6, int i7) {
            int[] iArr = this.f1124a;
            if (iArr == null || i6 >= iArr.length) {
                return;
            }
            int i8 = i6 + i7;
            b(i8);
            int[] iArr2 = this.f1124a;
            System.arraycopy(iArr2, i6, iArr2, i8, (iArr2.length - i6) - i7);
            Arrays.fill(this.f1124a, i6, i8, -1);
            j(i6, i7);
        }

        void i(int i6, int i7) {
            int[] iArr = this.f1124a;
            if (iArr == null || i6 >= iArr.length) {
                return;
            }
            int i8 = i6 + i7;
            b(i8);
            int[] iArr2 = this.f1124a;
            System.arraycopy(iArr2, i8, iArr2, i6, (iArr2.length - i6) - i7);
            int[] iArr3 = this.f1124a;
            Arrays.fill(iArr3, iArr3.length - i7, iArr3.length, -1);
            k(i6, i7);
        }

        int l(int i6) {
            int length = this.f1124a.length;
            while (length <= i6) {
                length *= 2;
            }
            return length;
        }
    }

    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f1130a;

        /* renamed from: b, reason: collision with root package name */
        int f1131b;

        /* renamed from: c, reason: collision with root package name */
        int f1132c;

        /* renamed from: d, reason: collision with root package name */
        int[] f1133d;

        /* renamed from: e, reason: collision with root package name */
        int f1134e;

        /* renamed from: j, reason: collision with root package name */
        int[] f1135j;

        /* renamed from: k, reason: collision with root package name */
        List<d.a> f1136k;

        /* renamed from: l, reason: collision with root package name */
        boolean f1137l;

        /* renamed from: m, reason: collision with root package name */
        boolean f1138m;

        /* renamed from: n, reason: collision with root package name */
        boolean f1139n;

        class a implements Parcelable.Creator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i6) {
                return new e[i6];
            }
        }

        public e() {
        }

        e(Parcel parcel) {
            this.f1130a = parcel.readInt();
            this.f1131b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f1132c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f1133d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f1134e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f1135j = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f1137l = parcel.readInt() == 1;
            this.f1138m = parcel.readInt() == 1;
            this.f1139n = parcel.readInt() == 1;
            this.f1136k = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f1132c = eVar.f1132c;
            this.f1130a = eVar.f1130a;
            this.f1131b = eVar.f1131b;
            this.f1133d = eVar.f1133d;
            this.f1134e = eVar.f1134e;
            this.f1135j = eVar.f1135j;
            this.f1137l = eVar.f1137l;
            this.f1138m = eVar.f1138m;
            this.f1139n = eVar.f1139n;
            this.f1136k = eVar.f1136k;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeInt(this.f1130a);
            parcel.writeInt(this.f1131b);
            parcel.writeInt(this.f1132c);
            if (this.f1132c > 0) {
                parcel.writeIntArray(this.f1133d);
            }
            parcel.writeInt(this.f1134e);
            if (this.f1134e > 0) {
                parcel.writeIntArray(this.f1135j);
            }
            parcel.writeInt(this.f1137l ? 1 : 0);
            parcel.writeInt(this.f1138m ? 1 : 0);
            parcel.writeInt(this.f1139n ? 1 : 0);
            parcel.writeList(this.f1136k);
        }
    }

    class f {

        /* renamed from: a, reason: collision with root package name */
        ArrayList<View> f1140a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        int f1141b = Integer.MIN_VALUE;

        /* renamed from: c, reason: collision with root package name */
        int f1142c = Integer.MIN_VALUE;

        /* renamed from: d, reason: collision with root package name */
        int f1143d = 0;

        /* renamed from: e, reason: collision with root package name */
        final int f1144e;

        f(int i6) {
            this.f1144e = i6;
        }

        void a() {
            d.a e6;
            ArrayList<View> arrayList = this.f1140a;
            View view = arrayList.get(arrayList.size() - 1);
            c f6 = f(view);
            this.f1142c = StaggeredGridLayoutManager.this.f1106s.d(view);
            if (f6.f1123f && (e6 = StaggeredGridLayoutManager.this.B.e(f6.a())) != null && e6.f1127b == 1) {
                this.f1142c += e6.d(this.f1144e);
            }
        }

        void b() {
            d.a e6;
            View view = this.f1140a.get(0);
            c f6 = f(view);
            this.f1141b = StaggeredGridLayoutManager.this.f1106s.e(view);
            if (f6.f1123f && (e6 = StaggeredGridLayoutManager.this.B.e(f6.a())) != null && e6.f1127b == -1) {
                this.f1141b -= e6.d(this.f1144e);
            }
        }

        void c() {
            this.f1140a.clear();
            i();
            this.f1143d = 0;
        }

        int d() {
            int i6 = this.f1142c;
            if (i6 != Integer.MIN_VALUE) {
                return i6;
            }
            a();
            return this.f1142c;
        }

        int e(int i6) {
            int i7 = this.f1142c;
            if (i7 != Integer.MIN_VALUE) {
                return i7;
            }
            if (this.f1140a.size() == 0) {
                return i6;
            }
            a();
            return this.f1142c;
        }

        c f(View view) {
            return (c) view.getLayoutParams();
        }

        int g() {
            int i6 = this.f1141b;
            if (i6 != Integer.MIN_VALUE) {
                return i6;
            }
            b();
            return this.f1141b;
        }

        int h(int i6) {
            int i7 = this.f1141b;
            if (i7 != Integer.MIN_VALUE) {
                return i7;
            }
            if (this.f1140a.size() == 0) {
                return i6;
            }
            b();
            return this.f1141b;
        }

        void i() {
            this.f1141b = Integer.MIN_VALUE;
            this.f1142c = Integer.MIN_VALUE;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i6, int i7) {
        RecyclerView.n.c J = RecyclerView.n.J(context, attributeSet, i6, i7);
        W0(J.f1068a);
        Y0(J.f1069b);
        X0(J.f1070c);
        this.f1109v = new androidx.recyclerview.widget.f();
        M0();
    }

    private boolean I0(f fVar) {
        if (this.f1111x) {
            if (fVar.d() < this.f1106s.f()) {
                ArrayList<View> arrayList = fVar.f1140a;
                return !fVar.f(arrayList.get(arrayList.size() - 1)).f1123f;
            }
        } else if (fVar.g() > this.f1106s.g()) {
            return !fVar.f(fVar.f1140a.get(0)).f1123f;
        }
        return false;
    }

    private int J0(RecyclerView.y yVar) {
        if (t() == 0) {
            return 0;
        }
        return j.a(yVar, this.f1106s, O0(!this.J), N0(!this.J), this, this.J);
    }

    private int K0(RecyclerView.y yVar) {
        if (t() == 0) {
            return 0;
        }
        return j.b(yVar, this.f1106s, O0(!this.J), N0(!this.J), this, this.J, this.f1111x);
    }

    private int L0(RecyclerView.y yVar) {
        if (t() == 0) {
            return 0;
        }
        return j.c(yVar, this.f1106s, O0(!this.J), N0(!this.J), this, this.J);
    }

    private void M0() {
        this.f1106s = h.b(this, this.f1108u);
        this.f1107t = h.b(this, 1 - this.f1108u);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void S0(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f1111x
            if (r0 == 0) goto L9
            int r0 = r6.R0()
            goto Ld
        L9:
            int r0 = r6.Q0()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1a
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1c
        L16:
            int r2 = r7 + 1
            r3 = r8
            goto L1d
        L1a:
            int r2 = r7 + r8
        L1c:
            r3 = r7
        L1d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.B
            r4.f(r3)
            r4 = 1
            if (r9 == r4) goto L3c
            r5 = 2
            if (r9 == r5) goto L36
            if (r9 == r1) goto L2b
            goto L41
        L2b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.B
            r9.i(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.B
            r7.h(r8, r4)
            goto L41
        L36:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.B
            r9.i(r7, r8)
            goto L41
        L3c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.B
            r9.h(r7, r8)
        L41:
            if (r2 > r0) goto L44
            return
        L44:
            boolean r7 = r6.f1111x
            if (r7 == 0) goto L4d
            int r7 = r6.Q0()
            goto L51
        L4d:
            int r7 = r6.R0()
        L51:
            if (r3 > r7) goto L56
            r6.C0()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.S0(int, int, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean G0() {
        return this.F == null;
    }

    boolean H0() {
        int Q0;
        int R0;
        if (t() == 0 || this.C == 0 || !P()) {
            return false;
        }
        if (this.f1111x) {
            Q0 = R0();
            R0 = Q0();
        } else {
            Q0 = Q0();
            R0 = R0();
        }
        if (Q0 == 0 && T0() != null) {
            this.B.a();
        } else {
            if (!this.I) {
                return false;
            }
            int i6 = this.f1111x ? -1 : 1;
            int i7 = R0 + 1;
            d.a d6 = this.B.d(Q0, i7, i6, true);
            if (d6 == null) {
                this.I = false;
                this.B.c(i7);
                return false;
            }
            d.a d7 = this.B.d(Q0, d6.f1126a, i6 * (-1), true);
            if (d7 == null) {
                this.B.c(d6.f1126a);
            } else {
                this.B.c(d7.f1126a + 1);
            }
        }
        D0();
        C0();
        return true;
    }

    View N0(boolean z5) {
        int g6 = this.f1106s.g();
        int f6 = this.f1106s.f();
        View view = null;
        for (int t5 = t() - 1; t5 >= 0; t5--) {
            View s5 = s(t5);
            int e6 = this.f1106s.e(s5);
            int d6 = this.f1106s.d(s5);
            if (d6 > g6 && e6 < f6) {
                if (d6 <= f6 || !z5) {
                    return s5;
                }
                if (view == null) {
                    view = s5;
                }
            }
        }
        return view;
    }

    View O0(boolean z5) {
        int g6 = this.f1106s.g();
        int f6 = this.f1106s.f();
        int t5 = t();
        View view = null;
        for (int i6 = 0; i6 < t5; i6++) {
            View s5 = s(i6);
            int e6 = this.f1106s.e(s5);
            if (this.f1106s.d(s5) > g6 && e6 < f6) {
                if (e6 >= g6 || !z5) {
                    return s5;
                }
                if (view == null) {
                    view = s5;
                }
            }
        }
        return view;
    }

    int P0() {
        View N0 = this.f1111x ? N0(true) : O0(true);
        if (N0 == null) {
            return -1;
        }
        return I(N0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean Q() {
        return this.C != 0;
    }

    int Q0() {
        if (t() == 0) {
            return 0;
        }
        return I(s(0));
    }

    int R0() {
        int t5 = t();
        if (t5 == 0) {
            return 0;
        }
        return I(s(t5 - 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        if (r10 == r11) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0088, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
    
        if (r10 == r11) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View T0() {
        /*
            r12 = this;
            int r0 = r12.t()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f1104q
            r2.<init>(r3)
            int r3 = r12.f1104q
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f1108u
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.V0()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.f1111x
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.s(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f1122e
            int r9 = r9.f1144e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f1122e
            boolean r9 = r12.I0(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f1122e
            int r9 = r9.f1144e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f1123f
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.s(r9)
            boolean r10 = r12.f1111x
            if (r10 == 0) goto L77
            androidx.recyclerview.widget.h r10 = r12.f1106s
            int r10 = r10.d(r7)
            androidx.recyclerview.widget.h r11 = r12.f1106s
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            androidx.recyclerview.widget.h r10 = r12.f1106s
            int r10 = r10.e(r7)
            androidx.recyclerview.widget.h r11 = r12.f1106s
            int r11 = r11.e(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = 1
            goto L8b
        L8a:
            r10 = 0
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r8 = r8.f1122e
            int r8 = r8.f1144e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r9.f1122e
            int r9 = r9.f1144e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = 1
            goto La1
        La0:
            r8 = 0
        La1:
            if (r3 >= 0) goto La5
            r9 = 1
            goto La6
        La5:
            r9 = 0
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.T0():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void U(RecyclerView.g gVar, RecyclerView.g gVar2) {
        this.B.a();
        for (int i6 = 0; i6 < this.f1104q; i6++) {
            this.f1105r[i6].c();
        }
    }

    public void U0() {
        this.B.a();
        C0();
    }

    boolean V0() {
        return C() == 1;
    }

    public void W0(int i6) {
        if (i6 != 0 && i6 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        a(null);
        if (i6 == this.f1108u) {
            return;
        }
        this.f1108u = i6;
        h hVar = this.f1106s;
        this.f1106s = this.f1107t;
        this.f1107t = hVar;
        C0();
    }

    public void X0(boolean z5) {
        a(null);
        e eVar = this.F;
        if (eVar != null && eVar.f1137l != z5) {
            eVar.f1137l = z5;
        }
        this.f1110w = z5;
        C0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void Y(RecyclerView recyclerView, RecyclerView.u uVar) {
        super.Y(recyclerView, uVar);
        y0(this.K);
        for (int i6 = 0; i6 < this.f1104q; i6++) {
            this.f1105r[i6].c();
        }
        recyclerView.requestLayout();
    }

    public void Y0(int i6) {
        a(null);
        if (i6 != this.f1104q) {
            U0();
            this.f1104q = i6;
            this.f1112y = new BitSet(this.f1104q);
            this.f1105r = new f[this.f1104q];
            for (int i7 = 0; i7 < this.f1104q; i7++) {
                this.f1105r[i7] = new f(i7);
            }
            C0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void Z(AccessibilityEvent accessibilityEvent) {
        super.Z(accessibilityEvent);
        if (t() > 0) {
            View O0 = O0(false);
            View N0 = N0(false);
            if (O0 == null || N0 == null) {
                return;
            }
            int I = I(O0);
            int I2 = I(N0);
            if (I < I2) {
                accessibilityEvent.setFromIndex(I);
                accessibilityEvent.setToIndex(I2);
            } else {
                accessibilityEvent.setFromIndex(I2);
                accessibilityEvent.setToIndex(I);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(String str) {
        if (this.F == null) {
            super.a(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean b() {
        return this.f1108u == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean c() {
        return this.f1108u == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean d(RecyclerView.o oVar) {
        return oVar instanceof c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int f(RecyclerView.y yVar) {
        return J0(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int g(RecyclerView.y yVar) {
        return K0(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g0(RecyclerView recyclerView, int i6, int i7) {
        S0(i6, i7, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int h(RecyclerView.y yVar) {
        return L0(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void h0(RecyclerView recyclerView) {
        this.B.a();
        C0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int i(RecyclerView.y yVar) {
        return J0(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i0(RecyclerView recyclerView, int i6, int i7, int i8) {
        S0(i6, i7, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int j(RecyclerView.y yVar) {
        return K0(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void j0(RecyclerView recyclerView, int i6, int i7) {
        S0(i6, i7, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int k(RecyclerView.y yVar) {
        return L0(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void l0(RecyclerView recyclerView, int i6, int i7, Object obj) {
        S0(i6, i7, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o n() {
        return this.f1108u == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o o(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o p(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public Parcelable p0() {
        int h6;
        int g6;
        int[] iArr;
        if (this.F != null) {
            return new e(this.F);
        }
        e eVar = new e();
        eVar.f1137l = this.f1110w;
        eVar.f1138m = this.D;
        eVar.f1139n = this.E;
        d dVar = this.B;
        if (dVar == null || (iArr = dVar.f1124a) == null) {
            eVar.f1134e = 0;
        } else {
            eVar.f1135j = iArr;
            eVar.f1134e = iArr.length;
            eVar.f1136k = dVar.f1125b;
        }
        if (t() > 0) {
            eVar.f1130a = this.D ? R0() : Q0();
            eVar.f1131b = P0();
            int i6 = this.f1104q;
            eVar.f1132c = i6;
            eVar.f1133d = new int[i6];
            for (int i7 = 0; i7 < this.f1104q; i7++) {
                if (this.D) {
                    h6 = this.f1105r[i7].e(Integer.MIN_VALUE);
                    if (h6 != Integer.MIN_VALUE) {
                        g6 = this.f1106s.f();
                        h6 -= g6;
                        eVar.f1133d[i7] = h6;
                    } else {
                        eVar.f1133d[i7] = h6;
                    }
                } else {
                    h6 = this.f1105r[i7].h(Integer.MIN_VALUE);
                    if (h6 != Integer.MIN_VALUE) {
                        g6 = this.f1106s.g();
                        h6 -= g6;
                        eVar.f1133d[i7] = h6;
                    } else {
                        eVar.f1133d[i7] = h6;
                    }
                }
            }
        } else {
            eVar.f1130a = -1;
            eVar.f1131b = -1;
            eVar.f1132c = 0;
        }
        return eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void q0(int i6) {
        if (i6 == 0) {
            H0();
        }
    }
}
