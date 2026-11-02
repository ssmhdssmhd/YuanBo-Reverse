package androidx.recyclerview.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.n {
    private boolean A;

    /* renamed from: r, reason: collision with root package name */
    private c f934r;

    /* renamed from: s, reason: collision with root package name */
    h f935s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f936t;

    /* renamed from: q, reason: collision with root package name */
    int f933q = 1;

    /* renamed from: u, reason: collision with root package name */
    private boolean f937u = false;

    /* renamed from: v, reason: collision with root package name */
    boolean f938v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f939w = false;

    /* renamed from: x, reason: collision with root package name */
    private boolean f940x = true;

    /* renamed from: y, reason: collision with root package name */
    int f941y = -1;

    /* renamed from: z, reason: collision with root package name */
    int f942z = Integer.MIN_VALUE;
    d B = null;
    final a C = new a();
    private final b D = new b();
    private int E = 2;
    private int[] F = new int[2];

    static class a {

        /* renamed from: a, reason: collision with root package name */
        h f943a;

        /* renamed from: b, reason: collision with root package name */
        int f944b;

        /* renamed from: c, reason: collision with root package name */
        int f945c;

        /* renamed from: d, reason: collision with root package name */
        boolean f946d;

        /* renamed from: e, reason: collision with root package name */
        boolean f947e;

        a() {
            a();
        }

        void a() {
            this.f944b = -1;
            this.f945c = Integer.MIN_VALUE;
            this.f946d = false;
            this.f947e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f944b + ", mCoordinate=" + this.f945c + ", mLayoutFromEnd=" + this.f946d + ", mValid=" + this.f947e + '}';
        }
    }

    protected static class b {
        protected b() {
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        boolean f948a = true;

        /* renamed from: b, reason: collision with root package name */
        int f949b = 0;

        /* renamed from: c, reason: collision with root package name */
        int f950c = 0;

        /* renamed from: d, reason: collision with root package name */
        boolean f951d = false;

        /* renamed from: e, reason: collision with root package name */
        List<RecyclerView.b0> f952e = null;

        c() {
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f953a;

        /* renamed from: b, reason: collision with root package name */
        int f954b;

        /* renamed from: c, reason: collision with root package name */
        boolean f955c;

        class a implements Parcelable.Creator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d[] newArray(int i6) {
                return new d[i6];
            }
        }

        public d() {
        }

        d(Parcel parcel) {
            this.f953a = parcel.readInt();
            this.f954b = parcel.readInt();
            this.f955c = parcel.readInt() == 1;
        }

        public d(d dVar) {
            this.f953a = dVar.f953a;
            this.f954b = dVar.f954b;
            this.f955c = dVar.f955c;
        }

        void d() {
            this.f953a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeInt(this.f953a);
            parcel.writeInt(this.f954b);
            parcel.writeInt(this.f955c ? 1 : 0);
        }
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i6, int i7) {
        RecyclerView.n.c J = RecyclerView.n.J(context, attributeSet, i6, i7);
        U0(J.f1068a);
        V0(J.f1070c);
        W0(J.f1071d);
    }

    private int H0(RecyclerView.y yVar) {
        if (t() == 0) {
            return 0;
        }
        L0();
        return j.a(yVar, this.f935s, N0(!this.f940x, true), M0(!this.f940x, true), this, this.f940x);
    }

    private int I0(RecyclerView.y yVar) {
        if (t() == 0) {
            return 0;
        }
        L0();
        return j.b(yVar, this.f935s, N0(!this.f940x, true), M0(!this.f940x, true), this, this.f940x, this.f938v);
    }

    private int J0(RecyclerView.y yVar) {
        if (t() == 0) {
            return 0;
        }
        L0();
        return j.c(yVar, this.f935s, N0(!this.f940x, true), M0(!this.f940x, true), this, this.f940x);
    }

    private View R0() {
        return s(this.f938v ? 0 : t() - 1);
    }

    private View S0() {
        return s(this.f938v ? t() - 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean G0() {
        return this.B == null && this.f936t == this.f939w;
    }

    c K0() {
        return new c();
    }

    void L0() {
        if (this.f934r == null) {
            this.f934r = K0();
        }
    }

    View M0(boolean z5, boolean z6) {
        int t5;
        int i6;
        if (this.f938v) {
            t5 = 0;
            i6 = t();
        } else {
            t5 = t() - 1;
            i6 = -1;
        }
        return Q0(t5, i6, z5, z6);
    }

    View N0(boolean z5, boolean z6) {
        int i6;
        int t5;
        if (this.f938v) {
            i6 = t() - 1;
            t5 = -1;
        } else {
            i6 = 0;
            t5 = t();
        }
        return Q0(i6, t5, z5, z6);
    }

    public int O0() {
        View Q0 = Q0(0, t(), false, true);
        if (Q0 == null) {
            return -1;
        }
        return I(Q0);
    }

    public int P0() {
        View Q0 = Q0(t() - 1, -1, false, true);
        if (Q0 == null) {
            return -1;
        }
        return I(Q0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean Q() {
        return true;
    }

    View Q0(int i6, int i7, boolean z5, boolean z6) {
        L0();
        return (this.f933q == 0 ? this.f1054e : this.f1055f).a(i6, i7, z5 ? 24579 : 320, z6 ? 320 : 0);
    }

    public boolean T0() {
        return this.f940x;
    }

    public void U0(int i6) {
        if (i6 != 0 && i6 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i6);
        }
        a(null);
        if (i6 != this.f933q || this.f935s == null) {
            h b6 = h.b(this, i6);
            this.f935s = b6;
            this.C.f943a = b6;
            this.f933q = i6;
            C0();
        }
    }

    public void V0(boolean z5) {
        a(null);
        if (z5 == this.f937u) {
            return;
        }
        this.f937u = z5;
        C0();
    }

    public void W0(boolean z5) {
        a(null);
        if (this.f939w == z5) {
            return;
        }
        this.f939w = z5;
        C0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void Y(RecyclerView recyclerView, RecyclerView.u uVar) {
        super.Y(recyclerView, uVar);
        if (this.A) {
            v0(uVar);
            uVar.b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void Z(AccessibilityEvent accessibilityEvent) {
        super.Z(accessibilityEvent);
        if (t() > 0) {
            accessibilityEvent.setFromIndex(O0());
            accessibilityEvent.setToIndex(P0());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(String str) {
        if (this.B == null) {
            super.a(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean b() {
        return this.f933q == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public boolean c() {
        return this.f933q == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int f(RecyclerView.y yVar) {
        return H0(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int g(RecyclerView.y yVar) {
        return I0(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int h(RecyclerView.y yVar) {
        return J0(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int i(RecyclerView.y yVar) {
        return H0(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int j(RecyclerView.y yVar) {
        return I0(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public int k(RecyclerView.y yVar) {
        return J0(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public RecyclerView.o n() {
        return new RecyclerView.o(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public Parcelable p0() {
        if (this.B != null) {
            return new d(this.B);
        }
        d dVar = new d();
        if (t() > 0) {
            L0();
            boolean z5 = this.f936t ^ this.f938v;
            dVar.f955c = z5;
            if (z5) {
                View R0 = R0();
                dVar.f954b = this.f935s.f() - this.f935s.d(R0);
                dVar.f953a = I(R0);
            } else {
                View S0 = S0();
                dVar.f953a = I(S0);
                dVar.f954b = this.f935s.e(S0) - this.f935s.g();
            }
        } else {
            dVar.d();
        }
        return dVar;
    }
}
