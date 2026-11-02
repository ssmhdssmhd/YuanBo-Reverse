package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    protected final RecyclerView.n f1267a;

    /* renamed from: b, reason: collision with root package name */
    private int f1268b;

    /* renamed from: c, reason: collision with root package name */
    final Rect f1269c;

    class a extends h {
        a(RecyclerView.n nVar) {
            super(nVar, null);
        }

        @Override // androidx.recyclerview.widget.h
        public int d(View view) {
            return this.f1267a.z(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int e(View view) {
            return this.f1267a.y(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int f() {
            return this.f1267a.O() - this.f1267a.G();
        }

        @Override // androidx.recyclerview.widget.h
        public int g() {
            return this.f1267a.F();
        }

        @Override // androidx.recyclerview.widget.h
        public int h() {
            return (this.f1267a.O() - this.f1267a.F()) - this.f1267a.G();
        }
    }

    class b extends h {
        b(RecyclerView.n nVar) {
            super(nVar, null);
        }

        @Override // androidx.recyclerview.widget.h
        public int d(View view) {
            return this.f1267a.w(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int e(View view) {
            return this.f1267a.A(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.o) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.h
        public int f() {
            return this.f1267a.B() - this.f1267a.E();
        }

        @Override // androidx.recyclerview.widget.h
        public int g() {
            return this.f1267a.H();
        }

        @Override // androidx.recyclerview.widget.h
        public int h() {
            return (this.f1267a.B() - this.f1267a.H()) - this.f1267a.E();
        }
    }

    private h(RecyclerView.n nVar) {
        this.f1268b = Integer.MIN_VALUE;
        this.f1269c = new Rect();
        this.f1267a = nVar;
    }

    /* synthetic */ h(RecyclerView.n nVar, a aVar) {
        this(nVar);
    }

    public static h a(RecyclerView.n nVar) {
        return new a(nVar);
    }

    public static h b(RecyclerView.n nVar, int i6) {
        if (i6 == 0) {
            return a(nVar);
        }
        if (i6 == 1) {
            return c(nVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static h c(RecyclerView.n nVar) {
        return new b(nVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();
}
