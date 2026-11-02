package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.accessibility.x;
import androidx.core.view.e1;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.b;
import androidx.recyclerview.widget.e;
import androidx.recyclerview.widget.i;
import androidx.recyclerview.widget.l;
import androidx.recyclerview.widget.m;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup {
    static final boolean A0;
    static final boolean B0;
    static final boolean C0;
    static final boolean D0;
    private static final boolean E0;
    private static final boolean F0;
    private static final Class<?>[] G0;
    static final Interpolator H0;

    /* renamed from: z0, reason: collision with root package name */
    private static final int[] f956z0 = {R.attr.nestedScrollingEnabled};
    boolean A;
    private final AccessibilityManager B;
    private List<p> C;
    boolean D;
    boolean E;
    private int F;
    private int G;
    private j H;
    private EdgeEffect I;
    private EdgeEffect J;
    private EdgeEffect K;
    private EdgeEffect L;
    k M;
    private int N;
    private int O;
    private VelocityTracker P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private final int V;
    private final int W;

    /* renamed from: a, reason: collision with root package name */
    private final w f957a;

    /* renamed from: a0, reason: collision with root package name */
    private float f958a0;

    /* renamed from: b, reason: collision with root package name */
    final u f959b;

    /* renamed from: b0, reason: collision with root package name */
    private float f960b0;

    /* renamed from: c, reason: collision with root package name */
    x f961c;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f962c0;

    /* renamed from: d, reason: collision with root package name */
    androidx.recyclerview.widget.a f963d;

    /* renamed from: d0, reason: collision with root package name */
    final a0 f964d0;

    /* renamed from: e, reason: collision with root package name */
    androidx.recyclerview.widget.b f965e;

    /* renamed from: e0, reason: collision with root package name */
    androidx.recyclerview.widget.e f966e0;

    /* renamed from: f, reason: collision with root package name */
    final androidx.recyclerview.widget.m f967f;

    /* renamed from: f0, reason: collision with root package name */
    e.b f968f0;

    /* renamed from: g, reason: collision with root package name */
    boolean f969g;

    /* renamed from: g0, reason: collision with root package name */
    final y f970g0;

    /* renamed from: h, reason: collision with root package name */
    final Runnable f971h;

    /* renamed from: h0, reason: collision with root package name */
    private s f972h0;

    /* renamed from: i, reason: collision with root package name */
    final Rect f973i;

    /* renamed from: i0, reason: collision with root package name */
    private List<s> f974i0;

    /* renamed from: j, reason: collision with root package name */
    private final Rect f975j;

    /* renamed from: j0, reason: collision with root package name */
    boolean f976j0;

    /* renamed from: k, reason: collision with root package name */
    final RectF f977k;

    /* renamed from: k0, reason: collision with root package name */
    boolean f978k0;

    /* renamed from: l, reason: collision with root package name */
    n f979l;

    /* renamed from: l0, reason: collision with root package name */
    private k.b f980l0;

    /* renamed from: m, reason: collision with root package name */
    v f981m;

    /* renamed from: m0, reason: collision with root package name */
    boolean f982m0;

    /* renamed from: n, reason: collision with root package name */
    final List<v> f983n;

    /* renamed from: n0, reason: collision with root package name */
    androidx.recyclerview.widget.i f984n0;

    /* renamed from: o, reason: collision with root package name */
    final ArrayList<m> f985o;

    /* renamed from: o0, reason: collision with root package name */
    private final int[] f986o0;

    /* renamed from: p, reason: collision with root package name */
    private final ArrayList<r> f987p;

    /* renamed from: p0, reason: collision with root package name */
    private androidx.core.view.l f988p0;

    /* renamed from: q, reason: collision with root package name */
    private r f989q;

    /* renamed from: q0, reason: collision with root package name */
    private final int[] f990q0;

    /* renamed from: r, reason: collision with root package name */
    boolean f991r;

    /* renamed from: r0, reason: collision with root package name */
    private final int[] f992r0;

    /* renamed from: s, reason: collision with root package name */
    boolean f993s;

    /* renamed from: s0, reason: collision with root package name */
    final int[] f994s0;

    /* renamed from: t, reason: collision with root package name */
    boolean f995t;

    /* renamed from: t0, reason: collision with root package name */
    final List<b0> f996t0;

    /* renamed from: u, reason: collision with root package name */
    boolean f997u;

    /* renamed from: u0, reason: collision with root package name */
    private Runnable f998u0;

    /* renamed from: v, reason: collision with root package name */
    private int f999v;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f1000v0;

    /* renamed from: w, reason: collision with root package name */
    boolean f1001w;

    /* renamed from: w0, reason: collision with root package name */
    private int f1002w0;

    /* renamed from: x, reason: collision with root package name */
    boolean f1003x;

    /* renamed from: x0, reason: collision with root package name */
    private int f1004x0;

    /* renamed from: y, reason: collision with root package name */
    private boolean f1005y;

    /* renamed from: y0, reason: collision with root package name */
    private final m.b f1006y0;

    /* renamed from: z, reason: collision with root package name */
    private int f1007z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.f997u || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.f991r) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.f1003x) {
                recyclerView2.f1001w = true;
            } else {
                recyclerView2.m();
            }
        }
    }

    class a0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private int f1009a;

        /* renamed from: b, reason: collision with root package name */
        private int f1010b;

        /* renamed from: c, reason: collision with root package name */
        OverScroller f1011c;

        /* renamed from: d, reason: collision with root package name */
        Interpolator f1012d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f1013e;

        /* renamed from: j, reason: collision with root package name */
        private boolean f1014j;

        a0() {
            Interpolator interpolator = RecyclerView.H0;
            this.f1012d = interpolator;
            this.f1013e = false;
            this.f1014j = false;
            this.f1011c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        private int a(int i6, int i7) {
            int abs = Math.abs(i6);
            int abs2 = Math.abs(i7);
            boolean z5 = abs > abs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z5 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z5) {
                abs = abs2;
            }
            return Math.min((int) (((abs / width) + 1.0f) * 300.0f), 2000);
        }

        private void c() {
            RecyclerView.this.removeCallbacks(this);
            androidx.core.view.s.x(RecyclerView.this, this);
        }

        public void b(int i6, int i7) {
            RecyclerView.this.setScrollState(2);
            this.f1010b = 0;
            this.f1009a = 0;
            Interpolator interpolator = this.f1012d;
            Interpolator interpolator2 = RecyclerView.H0;
            if (interpolator != interpolator2) {
                this.f1012d = interpolator2;
                this.f1011c = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f1011c.fling(0, 0, i6, i7, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            d();
        }

        void d() {
            if (this.f1013e) {
                this.f1014j = true;
            } else {
                c();
            }
        }

        public void e(int i6, int i7, int i8, Interpolator interpolator) {
            if (i8 == Integer.MIN_VALUE) {
                i8 = a(i6, i7);
            }
            int i9 = i8;
            if (interpolator == null) {
                interpolator = RecyclerView.H0;
            }
            if (this.f1012d != interpolator) {
                this.f1012d = interpolator;
                this.f1011c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f1010b = 0;
            this.f1009a = 0;
            RecyclerView.this.setScrollState(2);
            this.f1011c.startScroll(0, 0, i6, i7, i9);
            if (Build.VERSION.SDK_INT < 23) {
                this.f1011c.computeScrollOffset();
            }
            d();
        }

        public void f() {
            RecyclerView.this.removeCallbacks(this);
            this.f1011c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f979l == null) {
                f();
                return;
            }
            this.f1014j = false;
            this.f1013e = true;
            recyclerView.m();
            OverScroller overScroller = this.f1011c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i6 = currX - this.f1009a;
                int i7 = currY - this.f1010b;
                this.f1009a = currX;
                this.f1010b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.f994s0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.s(i6, i7, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.f994s0;
                    i6 -= iArr2[0];
                    i7 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.l(i6, i7);
                }
                RecyclerView.this.getClass();
                if (!RecyclerView.this.f985o.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                int[] iArr3 = recyclerView3.f994s0;
                iArr3[0] = 0;
                iArr3[1] = 0;
                recyclerView3.t(0, 0, i6, i7, null, 1, iArr3);
                RecyclerView recyclerView4 = RecyclerView.this;
                int[] iArr4 = recyclerView4.f994s0;
                int i8 = i6 - iArr4[0];
                int i9 = i7 - iArr4[1];
                if (!recyclerView4.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z5 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i8 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i9 != 0));
                RecyclerView.this.f979l.getClass();
                if (z5) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i10 = i8 < 0 ? -currVelocity : i8 > 0 ? currVelocity : 0;
                        if (i9 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i9 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.a(i10, currVelocity);
                    }
                    if (RecyclerView.D0) {
                        RecyclerView.this.f968f0.a();
                    }
                } else {
                    d();
                    RecyclerView recyclerView5 = RecyclerView.this;
                    androidx.recyclerview.widget.e eVar = recyclerView5.f966e0;
                    if (eVar != null) {
                        eVar.f(recyclerView5, 0, 0);
                    }
                }
            }
            RecyclerView.this.f979l.getClass();
            this.f1013e = false;
            if (this.f1014j) {
                c();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.F0(1);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = RecyclerView.this.M;
            if (kVar != null) {
                kVar.p();
            }
            RecyclerView.this.f982m0 = false;
        }
    }

    public static abstract class b0 {

        /* renamed from: s, reason: collision with root package name */
        private static final List<Object> f1017s = Collections.emptyList();

        /* renamed from: a, reason: collision with root package name */
        public final View f1018a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<RecyclerView> f1019b;

        /* renamed from: c, reason: collision with root package name */
        int f1020c;

        /* renamed from: d, reason: collision with root package name */
        int f1021d;

        /* renamed from: e, reason: collision with root package name */
        long f1022e;

        /* renamed from: f, reason: collision with root package name */
        int f1023f;

        /* renamed from: g, reason: collision with root package name */
        int f1024g;

        /* renamed from: h, reason: collision with root package name */
        b0 f1025h;

        /* renamed from: i, reason: collision with root package name */
        b0 f1026i;

        /* renamed from: j, reason: collision with root package name */
        int f1027j;

        /* renamed from: k, reason: collision with root package name */
        List<Object> f1028k;

        /* renamed from: l, reason: collision with root package name */
        List<Object> f1029l;

        /* renamed from: m, reason: collision with root package name */
        private int f1030m;

        /* renamed from: n, reason: collision with root package name */
        u f1031n;

        /* renamed from: o, reason: collision with root package name */
        boolean f1032o;

        /* renamed from: p, reason: collision with root package name */
        private int f1033p;

        /* renamed from: q, reason: collision with root package name */
        int f1034q;

        /* renamed from: r, reason: collision with root package name */
        RecyclerView f1035r;

        private void f() {
            if (this.f1028k == null) {
                ArrayList arrayList = new ArrayList();
                this.f1028k = arrayList;
                this.f1029l = Collections.unmodifiableList(arrayList);
            }
        }

        void A() {
            this.f1027j = 0;
            this.f1020c = -1;
            this.f1021d = -1;
            this.f1022e = -1L;
            this.f1024g = -1;
            this.f1030m = 0;
            this.f1025h = null;
            this.f1026i = null;
            c();
            this.f1033p = 0;
            this.f1034q = -1;
            RecyclerView.k(this);
        }

        void B(int i6, int i7) {
            this.f1027j = (i6 & i7) | (this.f1027j & (~i7));
        }

        public final void C(boolean z5) {
            int i6;
            int i7 = this.f1030m;
            int i8 = z5 ? i7 - 1 : i7 + 1;
            this.f1030m = i8;
            if (i8 < 0) {
                this.f1030m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z5 && i8 == 1) {
                i6 = this.f1027j | 16;
            } else if (!z5 || i8 != 0) {
                return;
            } else {
                i6 = this.f1027j & (-17);
            }
            this.f1027j = i6;
        }

        void D(u uVar, boolean z5) {
            this.f1031n = uVar;
            this.f1032o = z5;
        }

        boolean E() {
            return (this.f1027j & 16) != 0;
        }

        boolean F() {
            return (this.f1027j & 128) != 0;
        }

        void G() {
            this.f1031n.B(this);
        }

        boolean H() {
            return (this.f1027j & 32) != 0;
        }

        void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.f1027j) == 0) {
                f();
                this.f1028k.add(obj);
            }
        }

        void b(int i6) {
            this.f1027j = i6 | this.f1027j;
        }

        void c() {
            List<Object> list = this.f1028k;
            if (list != null) {
                list.clear();
            }
            this.f1027j &= -1025;
        }

        void d() {
            this.f1027j &= -33;
        }

        void e() {
            this.f1027j &= -257;
        }

        boolean g() {
            return (this.f1027j & 16) == 0 && androidx.core.view.s.q(this.f1018a);
        }

        void h(int i6, int i7, boolean z5) {
            b(8);
            y(i7, z5);
            this.f1020c = i6;
        }

        public final int i() {
            RecyclerView recyclerView = this.f1035r;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.G(this);
        }

        public final int j() {
            return this.f1023f;
        }

        public final int k() {
            int i6 = this.f1024g;
            return i6 == -1 ? this.f1020c : i6;
        }

        public final int l() {
            return this.f1021d;
        }

        List<Object> m() {
            if ((this.f1027j & 1024) != 0) {
                return f1017s;
            }
            List<Object> list = this.f1028k;
            return (list == null || list.size() == 0) ? f1017s : this.f1029l;
        }

        boolean n(int i6) {
            return (i6 & this.f1027j) != 0;
        }

        boolean o() {
            return (this.f1027j & 512) != 0 || r();
        }

        boolean p() {
            return (this.f1018a.getParent() == null || this.f1018a.getParent() == this.f1035r) ? false : true;
        }

        boolean q() {
            return (this.f1027j & 1) != 0;
        }

        boolean r() {
            return (this.f1027j & 4) != 0;
        }

        public final boolean s() {
            return (this.f1027j & 16) == 0 && !androidx.core.view.s.q(this.f1018a);
        }

        boolean t() {
            return (this.f1027j & 8) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.f1020c + " id=" + this.f1022e + ", oldPos=" + this.f1021d + ", pLpos:" + this.f1024g);
            if (u()) {
                sb.append(" scrap ");
                sb.append(this.f1032o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (r()) {
                sb.append(" invalid");
            }
            if (!q()) {
                sb.append(" unbound");
            }
            if (x()) {
                sb.append(" update");
            }
            if (t()) {
                sb.append(" removed");
            }
            if (F()) {
                sb.append(" ignored");
            }
            if (v()) {
                sb.append(" tmpDetached");
            }
            if (!s()) {
                sb.append(" not recyclable(" + this.f1030m + ")");
            }
            if (o()) {
                sb.append(" undefined adapter position");
            }
            if (this.f1018a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        boolean u() {
            return this.f1031n != null;
        }

        boolean v() {
            return (this.f1027j & 256) != 0;
        }

        boolean w() {
            return (this.f1027j & 2) != 0;
        }

        boolean x() {
            return (this.f1027j & 2) != 0;
        }

        void y(int i6, boolean z5) {
            if (this.f1021d == -1) {
                this.f1021d = this.f1020c;
            }
            if (this.f1024g == -1) {
                this.f1024g = this.f1020c;
            }
            if (z5) {
                this.f1024g += i6;
            }
            this.f1020c += i6;
            if (this.f1018a.getLayoutParams() != null) {
                ((o) this.f1018a.getLayoutParams()).f1074c = true;
            }
        }

        void z(RecyclerView recyclerView) {
            recyclerView.w0(this, this.f1033p);
            this.f1033p = 0;
        }
    }

    class c implements Interpolator {
        c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float f7 = f6 - 1.0f;
            return (f7 * f7 * f7 * f7 * f7) + 1.0f;
        }
    }

    class d implements m.b {
        d() {
        }
    }

    class e implements b.InterfaceC0020b {
        e() {
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0020b
        public View a(int i6) {
            return RecyclerView.this.getChildAt(i6);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0020b
        public b0 b(View view) {
            return RecyclerView.I(view);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0020b
        public void c(int i6) {
            b0 I;
            View a6 = a(i6);
            if (a6 != null && (I = RecyclerView.I(a6)) != null) {
                if (I.v() && !I.F()) {
                    throw new IllegalArgumentException("called detach on an already detached child " + I + RecyclerView.this.B());
                }
                I.b(256);
            }
            RecyclerView.this.detachViewFromParent(i6);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0020b
        public void d(View view) {
            b0 I = RecyclerView.I(view);
            if (I != null) {
                I.z(RecyclerView.this);
            }
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0020b
        public int e() {
            return RecyclerView.this.getChildCount();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0020b
        public void f(int i6) {
            View childAt = RecyclerView.this.getChildAt(i6);
            if (childAt != null) {
                RecyclerView.this.p(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i6);
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0020b
        public void g() {
            int e6 = e();
            for (int i6 = 0; i6 < e6; i6++) {
                View a6 = a(i6);
                RecyclerView.this.p(a6);
                a6.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.b.InterfaceC0020b
        public int h(View view) {
            return RecyclerView.this.indexOfChild(view);
        }
    }

    class f implements a.InterfaceC0019a {
        f() {
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public void a(int i6, int i7) {
            RecyclerView.this.Z(i6, i7);
            RecyclerView.this.f976j0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public void b(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public b0 c(int i6) {
            b0 E = RecyclerView.this.E(i6, true);
            if (E == null || RecyclerView.this.f965e.i(E.f1018a)) {
                return null;
            }
            return E;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public void d(int i6, int i7) {
            RecyclerView.this.a0(i6, i7, false);
            RecyclerView.this.f976j0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public void e(int i6, int i7) {
            RecyclerView.this.Y(i6, i7);
            RecyclerView.this.f976j0 = true;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public void f(int i6, int i7) {
            RecyclerView.this.a0(i6, i7, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f976j0 = true;
            recyclerView.f970g0.f1095d += i7;
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public void g(a.b bVar) {
            i(bVar);
        }

        @Override // androidx.recyclerview.widget.a.InterfaceC0019a
        public void h(int i6, int i7, Object obj) {
            RecyclerView.this.I0(i6, i7, obj);
            RecyclerView.this.f978k0 = true;
        }

        void i(a.b bVar) {
            int i6 = bVar.f1154a;
            if (i6 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.f979l.g0(recyclerView, bVar.f1155b, bVar.f1157d);
                return;
            }
            if (i6 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.f979l.j0(recyclerView2, bVar.f1155b, bVar.f1157d);
            } else if (i6 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.f979l.l0(recyclerView3, bVar.f1155b, bVar.f1157d, bVar.f1156c);
            } else {
                if (i6 != 8) {
                    return;
                }
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.f979l.i0(recyclerView4, bVar.f1155b, bVar.f1157d, 1);
            }
        }
    }

    public static abstract class g<VH extends b0> {
    }

    public static abstract class h {
    }

    public interface i {
    }

    public static class j {
        protected EdgeEffect a(RecyclerView recyclerView, int i6) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class k {

        /* renamed from: a, reason: collision with root package name */
        private b f1039a = null;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<a> f1040b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        private long f1041c = 120;

        /* renamed from: d, reason: collision with root package name */
        private long f1042d = 120;

        /* renamed from: e, reason: collision with root package name */
        private long f1043e = 250;

        /* renamed from: f, reason: collision with root package name */
        private long f1044f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(b0 b0Var);
        }

        public static class c {

            /* renamed from: a, reason: collision with root package name */
            public int f1045a;

            /* renamed from: b, reason: collision with root package name */
            public int f1046b;

            /* renamed from: c, reason: collision with root package name */
            public int f1047c;

            /* renamed from: d, reason: collision with root package name */
            public int f1048d;

            public c a(b0 b0Var) {
                return b(b0Var, 0);
            }

            public c b(b0 b0Var, int i6) {
                View view = b0Var.f1018a;
                this.f1045a = view.getLeft();
                this.f1046b = view.getTop();
                this.f1047c = view.getRight();
                this.f1048d = view.getBottom();
                return this;
            }
        }

        static int a(b0 b0Var) {
            int i6 = b0Var.f1027j & 14;
            if (b0Var.r()) {
                return 4;
            }
            if ((i6 & 4) != 0) {
                return i6;
            }
            int l6 = b0Var.l();
            int i7 = b0Var.i();
            return (l6 == -1 || i7 == -1 || l6 == i7) ? i6 : i6 | 2048;
        }

        public abstract boolean b(b0 b0Var);

        public boolean c(b0 b0Var, List<Object> list) {
            return b(b0Var);
        }

        public final void d(b0 b0Var) {
            n(b0Var);
            b bVar = this.f1039a;
            if (bVar != null) {
                bVar.a(b0Var);
            }
        }

        public final void e() {
            int size = this.f1040b.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.f1040b.get(i6).a();
            }
            this.f1040b.clear();
        }

        public abstract void f(b0 b0Var);

        public abstract void g();

        public long h() {
            return this.f1041c;
        }

        public long i() {
            return this.f1044f;
        }

        public long j() {
            return this.f1043e;
        }

        public long k() {
            return this.f1042d;
        }

        public abstract boolean l();

        public c m() {
            return new c();
        }

        public void n(b0 b0Var) {
        }

        public c o(y yVar, b0 b0Var, int i6, List<Object> list) {
            return m().a(b0Var);
        }

        public abstract void p();

        void q(b bVar) {
            this.f1039a = bVar;
        }
    }

    private class l implements k.b {
        l() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.k.b
        public void a(b0 b0Var) {
            b0Var.C(true);
            if (b0Var.f1025h != null && b0Var.f1026i == null) {
                b0Var.f1025h = null;
            }
            b0Var.f1026i = null;
            if (b0Var.E() || RecyclerView.this.o0(b0Var.f1018a) || !b0Var.v()) {
                return;
            }
            RecyclerView.this.removeDetachedView(b0Var.f1018a, false);
        }
    }

    public static abstract class m {
        @Deprecated
        public void d(Canvas canvas, RecyclerView recyclerView) {
        }

        public void e(Canvas canvas, RecyclerView recyclerView, y yVar) {
            d(canvas, recyclerView);
        }

        @Deprecated
        public void f(Canvas canvas, RecyclerView recyclerView) {
        }

        public void g(Canvas canvas, RecyclerView recyclerView, y yVar) {
            f(canvas, recyclerView);
        }
    }

    public static abstract class n {

        /* renamed from: a, reason: collision with root package name */
        androidx.recyclerview.widget.b f1050a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView f1051b;

        /* renamed from: c, reason: collision with root package name */
        private final l.b f1052c;

        /* renamed from: d, reason: collision with root package name */
        private final l.b f1053d;

        /* renamed from: e, reason: collision with root package name */
        androidx.recyclerview.widget.l f1054e;

        /* renamed from: f, reason: collision with root package name */
        androidx.recyclerview.widget.l f1055f;

        /* renamed from: g, reason: collision with root package name */
        boolean f1056g;

        /* renamed from: h, reason: collision with root package name */
        boolean f1057h;

        /* renamed from: i, reason: collision with root package name */
        boolean f1058i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f1059j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f1060k;

        /* renamed from: l, reason: collision with root package name */
        int f1061l;

        /* renamed from: m, reason: collision with root package name */
        private int f1062m;

        /* renamed from: n, reason: collision with root package name */
        private int f1063n;

        /* renamed from: o, reason: collision with root package name */
        private int f1064o;

        /* renamed from: p, reason: collision with root package name */
        private int f1065p;

        class a implements l.b {
            a() {
            }

            @Override // androidx.recyclerview.widget.l.b
            public View a(int i6) {
                return n.this.s(i6);
            }

            @Override // androidx.recyclerview.widget.l.b
            public int b() {
                return n.this.O() - n.this.G();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int c(View view) {
                return n.this.y(view) - ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).leftMargin;
            }

            @Override // androidx.recyclerview.widget.l.b
            public int d() {
                return n.this.F();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int e(View view) {
                return n.this.z(view) + ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).rightMargin;
            }
        }

        class b implements l.b {
            b() {
            }

            @Override // androidx.recyclerview.widget.l.b
            public View a(int i6) {
                return n.this.s(i6);
            }

            @Override // androidx.recyclerview.widget.l.b
            public int b() {
                return n.this.B() - n.this.E();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int c(View view) {
                return n.this.A(view) - ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).topMargin;
            }

            @Override // androidx.recyclerview.widget.l.b
            public int d() {
                return n.this.H();
            }

            @Override // androidx.recyclerview.widget.l.b
            public int e(View view) {
                return n.this.w(view) + ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).bottomMargin;
            }
        }

        public static class c {

            /* renamed from: a, reason: collision with root package name */
            public int f1068a;

            /* renamed from: b, reason: collision with root package name */
            public int f1069b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f1070c;

            /* renamed from: d, reason: collision with root package name */
            public boolean f1071d;
        }

        public n() {
            a aVar = new a();
            this.f1052c = aVar;
            b bVar = new b();
            this.f1053d = bVar;
            this.f1054e = new androidx.recyclerview.widget.l(aVar);
            this.f1055f = new androidx.recyclerview.widget.l(bVar);
            this.f1056g = false;
            this.f1057h = false;
            this.f1058i = false;
            this.f1059j = true;
            this.f1060k = true;
        }

        public static c J(Context context, AttributeSet attributeSet, int i6, int i7) {
            c cVar = new c();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.c.f7741f, i6, i7);
            cVar.f1068a = obtainStyledAttributes.getInt(m.c.f7742g, 1);
            cVar.f1069b = obtainStyledAttributes.getInt(m.c.f7752q, 1);
            cVar.f1070c = obtainStyledAttributes.getBoolean(m.c.f7751p, false);
            cVar.f1071d = obtainStyledAttributes.getBoolean(m.c.f7753r, false);
            obtainStyledAttributes.recycle();
            return cVar;
        }

        private boolean R(RecyclerView recyclerView, int i6, int i7) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int F = F();
            int H = H();
            int O = O() - G();
            int B = B() - E();
            Rect rect = this.f1051b.f973i;
            x(focusedChild, rect);
            return rect.left - i6 < O && rect.right - i6 > F && rect.top - i7 < B && rect.bottom - i7 > H;
        }

        public static int e(int i6, int i7, int i8) {
            int mode = View.MeasureSpec.getMode(i6);
            int size = View.MeasureSpec.getSize(i6);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i7, i8) : size : Math.min(size, Math.max(i7, i8));
        }

        private int[] u(View view, Rect rect) {
            int[] iArr = new int[2];
            int F = F();
            int H = H();
            int O = O() - G();
            int B = B() - E();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i6 = left - F;
            int min = Math.min(0, i6);
            int i7 = top - H;
            int min2 = Math.min(0, i7);
            int i8 = width - O;
            int max = Math.max(0, i8);
            int max2 = Math.max(0, height - B);
            if (C() != 1) {
                if (min == 0) {
                    min = Math.min(i6, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i8);
            }
            if (min2 == 0) {
                min2 = Math.min(i7, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public int A(View view) {
            return view.getTop() - N(view);
        }

        public boolean A0(RecyclerView recyclerView, View view, Rect rect, boolean z5) {
            return B0(recyclerView, view, rect, z5, false);
        }

        public int B() {
            return this.f1065p;
        }

        public boolean B0(RecyclerView recyclerView, View view, Rect rect, boolean z5, boolean z6) {
            int[] u5 = u(view, rect);
            int i6 = u5[0];
            int i7 = u5[1];
            if ((z6 && !R(recyclerView, i6, i7)) || (i6 == 0 && i7 == 0)) {
                return false;
            }
            if (z5) {
                recyclerView.scrollBy(i6, i7);
            } else {
                recyclerView.y0(i6, i7);
            }
            return true;
        }

        public int C() {
            return androidx.core.view.s.k(this.f1051b);
        }

        public void C0() {
            RecyclerView recyclerView = this.f1051b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int D(View view) {
            return ((o) view.getLayoutParams()).f1073b.left;
        }

        public void D0() {
            this.f1056g = true;
        }

        public int E() {
            RecyclerView recyclerView = this.f1051b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        void E0(RecyclerView recyclerView) {
            int height;
            if (recyclerView == null) {
                this.f1051b = null;
                this.f1050a = null;
                height = 0;
                this.f1064o = 0;
            } else {
                this.f1051b = recyclerView;
                this.f1050a = recyclerView.f965e;
                this.f1064o = recyclerView.getWidth();
                height = recyclerView.getHeight();
            }
            this.f1065p = height;
            this.f1062m = 1073741824;
            this.f1063n = 1073741824;
        }

        public int F() {
            RecyclerView recyclerView = this.f1051b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        void F0() {
        }

        public int G() {
            RecyclerView recyclerView = this.f1051b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public boolean G0() {
            return false;
        }

        public int H() {
            RecyclerView recyclerView = this.f1051b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int I(View view) {
            return ((o) view.getLayoutParams()).a();
        }

        public int K(View view) {
            return ((o) view.getLayoutParams()).f1073b.right;
        }

        public int L(u uVar, y yVar) {
            return -1;
        }

        public int M(u uVar, y yVar) {
            return 0;
        }

        public int N(View view) {
            return ((o) view.getLayoutParams()).f1073b.top;
        }

        public int O() {
            return this.f1064o;
        }

        public boolean P() {
            return this.f1057h;
        }

        public boolean Q() {
            return this.f1058i;
        }

        public boolean S(u uVar, y yVar) {
            return false;
        }

        public boolean T() {
            return false;
        }

        public void U(g gVar, g gVar2) {
        }

        public boolean V(RecyclerView recyclerView, ArrayList<View> arrayList, int i6, int i7) {
            return false;
        }

        public void W(RecyclerView recyclerView) {
        }

        @Deprecated
        public void X(RecyclerView recyclerView) {
        }

        public void Y(RecyclerView recyclerView, u uVar) {
            X(recyclerView);
        }

        public void Z(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1051b;
            a0(recyclerView.f959b, recyclerView.f970g0, accessibilityEvent);
        }

        public void a(String str) {
            RecyclerView recyclerView = this.f1051b;
            if (recyclerView != null) {
                recyclerView.h(str);
            }
        }

        public void a0(u uVar, y yVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f1051b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z5 = true;
            if (!recyclerView.canScrollVertically(1) && !this.f1051b.canScrollVertically(-1) && !this.f1051b.canScrollHorizontally(-1) && !this.f1051b.canScrollHorizontally(1)) {
                z5 = false;
            }
            accessibilityEvent.setScrollable(z5);
            this.f1051b.getClass();
        }

        public boolean b() {
            return false;
        }

        void b0(androidx.core.view.accessibility.x xVar) {
            RecyclerView recyclerView = this.f1051b;
            c0(recyclerView.f959b, recyclerView.f970g0, xVar);
        }

        public boolean c() {
            return false;
        }

        public void c0(u uVar, y yVar, androidx.core.view.accessibility.x xVar) {
            if (this.f1051b.canScrollVertically(-1) || this.f1051b.canScrollHorizontally(-1)) {
                xVar.a(8192);
                xVar.O(true);
            }
            if (this.f1051b.canScrollVertically(1) || this.f1051b.canScrollHorizontally(1)) {
                xVar.a(4096);
                xVar.O(true);
            }
            xVar.J(x.b.a(L(uVar, yVar), v(uVar, yVar), S(uVar, yVar), M(uVar, yVar)));
        }

        public boolean d(o oVar) {
            return oVar != null;
        }

        void d0(View view, androidx.core.view.accessibility.x xVar) {
            b0 I = RecyclerView.I(view);
            if (I == null || I.t() || this.f1050a.i(I.f1018a)) {
                return;
            }
            RecyclerView recyclerView = this.f1051b;
            e0(recyclerView.f959b, recyclerView.f970g0, view, xVar);
        }

        public void e0(u uVar, y yVar, View view, androidx.core.view.accessibility.x xVar) {
        }

        public int f(y yVar) {
            return 0;
        }

        public View f0(View view, int i6) {
            return null;
        }

        public int g(y yVar) {
            return 0;
        }

        public void g0(RecyclerView recyclerView, int i6, int i7) {
        }

        public int h(y yVar) {
            return 0;
        }

        public void h0(RecyclerView recyclerView) {
        }

        public int i(y yVar) {
            return 0;
        }

        public void i0(RecyclerView recyclerView, int i6, int i7, int i8) {
        }

        public int j(y yVar) {
            return 0;
        }

        public void j0(RecyclerView recyclerView, int i6, int i7) {
        }

        public int k(y yVar) {
            return 0;
        }

        public void k0(RecyclerView recyclerView, int i6, int i7) {
        }

        void l(RecyclerView recyclerView) {
            this.f1057h = true;
            W(recyclerView);
        }

        public void l0(RecyclerView recyclerView, int i6, int i7, Object obj) {
            k0(recyclerView, i6, i7);
        }

        void m(RecyclerView recyclerView, u uVar) {
            this.f1057h = false;
            Y(recyclerView, uVar);
        }

        public void m0(u uVar, y yVar, int i6, int i7) {
            this.f1051b.o(i6, i7);
        }

        public abstract o n();

        @Deprecated
        public boolean n0(RecyclerView recyclerView, View view, View view2) {
            return T() || recyclerView.T();
        }

        public o o(Context context, AttributeSet attributeSet) {
            return new o(context, attributeSet);
        }

        public boolean o0(RecyclerView recyclerView, y yVar, View view, View view2) {
            return n0(recyclerView, view, view2);
        }

        public o p(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof o ? new o((o) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new o((ViewGroup.MarginLayoutParams) layoutParams) : new o(layoutParams);
        }

        public Parcelable p0() {
            return null;
        }

        public int q() {
            return -1;
        }

        public void q0(int i6) {
        }

        public int r(View view) {
            return ((o) view.getLayoutParams()).f1073b.bottom;
        }

        boolean r0(int i6, Bundle bundle) {
            RecyclerView recyclerView = this.f1051b;
            return s0(recyclerView.f959b, recyclerView.f970g0, i6, bundle);
        }

        public View s(int i6) {
            androidx.recyclerview.widget.b bVar = this.f1050a;
            if (bVar != null) {
                return bVar.c(i6);
            }
            return null;
        }

        public boolean s0(u uVar, y yVar, int i6, Bundle bundle) {
            int B;
            int O;
            int i7;
            int i8;
            RecyclerView recyclerView = this.f1051b;
            if (recyclerView == null) {
                return false;
            }
            if (i6 == 4096) {
                B = recyclerView.canScrollVertically(1) ? (B() - H()) - E() : 0;
                if (this.f1051b.canScrollHorizontally(1)) {
                    O = (O() - F()) - G();
                    i7 = B;
                    i8 = O;
                }
                i7 = B;
                i8 = 0;
            } else if (i6 != 8192) {
                i8 = 0;
                i7 = 0;
            } else {
                B = recyclerView.canScrollVertically(-1) ? -((B() - H()) - E()) : 0;
                if (this.f1051b.canScrollHorizontally(-1)) {
                    O = -((O() - F()) - G());
                    i7 = B;
                    i8 = O;
                }
                i7 = B;
                i8 = 0;
            }
            if (i7 == 0 && i8 == 0) {
                return false;
            }
            this.f1051b.B0(i8, i7, null, Integer.MIN_VALUE, true);
            return true;
        }

        public int t() {
            androidx.recyclerview.widget.b bVar = this.f1050a;
            if (bVar != null) {
                return bVar.d();
            }
            return 0;
        }

        boolean t0(View view, int i6, Bundle bundle) {
            RecyclerView recyclerView = this.f1051b;
            return u0(recyclerView.f959b, recyclerView.f970g0, view, i6, bundle);
        }

        public boolean u0(u uVar, y yVar, View view, int i6, Bundle bundle) {
            return false;
        }

        public int v(u uVar, y yVar) {
            return -1;
        }

        public void v0(u uVar) {
            for (int t5 = t() - 1; t5 >= 0; t5--) {
                if (!RecyclerView.I(s(t5)).F()) {
                    x0(t5, uVar);
                }
            }
        }

        public int w(View view) {
            return view.getBottom() + r(view);
        }

        void w0(u uVar) {
            int h6 = uVar.h();
            for (int i6 = h6 - 1; i6 >= 0; i6--) {
                View j6 = uVar.j(i6);
                b0 I = RecyclerView.I(j6);
                if (!I.F()) {
                    I.C(false);
                    if (I.v()) {
                        this.f1051b.removeDetachedView(j6, false);
                    }
                    k kVar = this.f1051b.M;
                    if (kVar != null) {
                        kVar.f(I);
                    }
                    I.C(true);
                    uVar.q(j6);
                }
            }
            uVar.c();
            if (h6 > 0) {
                this.f1051b.invalidate();
            }
        }

        public void x(View view, Rect rect) {
            RecyclerView.J(view, rect);
        }

        public void x0(int i6, u uVar) {
            View s5 = s(i6);
            z0(i6);
            uVar.t(s5);
        }

        public int y(View view) {
            return view.getLeft() - D(view);
        }

        public boolean y0(Runnable runnable) {
            RecyclerView recyclerView = this.f1051b;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public int z(View view) {
            return view.getRight() + K(view);
        }

        public void z0(int i6) {
            if (s(i6) != null) {
                this.f1050a.k(i6);
            }
        }
    }

    public static class o extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        b0 f1072a;

        /* renamed from: b, reason: collision with root package name */
        final Rect f1073b;

        /* renamed from: c, reason: collision with root package name */
        boolean f1074c;

        /* renamed from: d, reason: collision with root package name */
        boolean f1075d;

        public o(int i6, int i7) {
            super(i6, i7);
            this.f1073b = new Rect();
            this.f1074c = true;
            this.f1075d = false;
        }

        public o(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1073b = new Rect();
            this.f1074c = true;
            this.f1075d = false;
        }

        public o(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1073b = new Rect();
            this.f1074c = true;
            this.f1075d = false;
        }

        public o(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1073b = new Rect();
            this.f1074c = true;
            this.f1075d = false;
        }

        public o(o oVar) {
            super((ViewGroup.LayoutParams) oVar);
            this.f1073b = new Rect();
            this.f1074c = true;
            this.f1075d = false;
        }

        public int a() {
            return this.f1072a.k();
        }
    }

    public interface p {
        void a(View view);
    }

    public static abstract class q {
    }

    public interface r {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z5);
    }

    public static abstract class s {
        public void a(RecyclerView recyclerView, int i6) {
        }
    }

    public static class t {

        /* renamed from: a, reason: collision with root package name */
        SparseArray<a> f1076a = new SparseArray<>();

        /* renamed from: b, reason: collision with root package name */
        private int f1077b = 0;

        static class a {

            /* renamed from: a, reason: collision with root package name */
            final ArrayList<b0> f1078a = new ArrayList<>();

            /* renamed from: b, reason: collision with root package name */
            int f1079b = 5;

            /* renamed from: c, reason: collision with root package name */
            long f1080c = 0;

            /* renamed from: d, reason: collision with root package name */
            long f1081d = 0;

            a() {
            }
        }

        private a c(int i6) {
            a aVar = this.f1076a.get(i6);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f1076a.put(i6, aVar2);
            return aVar2;
        }

        public void a() {
            for (int i6 = 0; i6 < this.f1076a.size(); i6++) {
                this.f1076a.valueAt(i6).f1078a.clear();
            }
        }

        void b() {
            this.f1077b--;
        }

        void d(g gVar, g gVar2, boolean z5) {
            if (z5 || this.f1077b != 0) {
                return;
            }
            a();
        }

        public void e(b0 b0Var) {
            int j6 = b0Var.j();
            ArrayList<b0> arrayList = c(j6).f1078a;
            if (this.f1076a.get(j6).f1079b <= arrayList.size()) {
                return;
            }
            b0Var.A();
            arrayList.add(b0Var);
        }

        boolean f(int i6, long j6, long j7) {
            long j8 = c(i6).f1081d;
            return j8 == 0 || j6 + j8 < j7;
        }
    }

    public final class u {

        /* renamed from: a, reason: collision with root package name */
        final ArrayList<b0> f1082a;

        /* renamed from: b, reason: collision with root package name */
        ArrayList<b0> f1083b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList<b0> f1084c;

        /* renamed from: d, reason: collision with root package name */
        private final List<b0> f1085d;

        /* renamed from: e, reason: collision with root package name */
        private int f1086e;

        /* renamed from: f, reason: collision with root package name */
        int f1087f;

        /* renamed from: g, reason: collision with root package name */
        t f1088g;

        public u() {
            ArrayList<b0> arrayList = new ArrayList<>();
            this.f1082a = arrayList;
            this.f1083b = null;
            this.f1084c = new ArrayList<>();
            this.f1085d = Collections.unmodifiableList(arrayList);
            this.f1086e = 2;
            this.f1087f = 2;
        }

        private boolean z(b0 b0Var, int i6, int i7, long j6) {
            b0Var.getClass();
            b0Var.f1035r = RecyclerView.this;
            int j7 = b0Var.j();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j6 != Long.MAX_VALUE && !this.f1088g.f(j7, nanoTime, j6)) {
                return false;
            }
            RecyclerView.this.getClass();
            throw null;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00a1  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x013c A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0127  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        androidx.recyclerview.widget.RecyclerView.b0 A(int r12, boolean r13, long r14) {
            /*
                Method dump skipped, instructions count: 379
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.u.A(int, boolean, long):androidx.recyclerview.widget.RecyclerView$b0");
        }

        void B(b0 b0Var) {
            (b0Var.f1032o ? this.f1083b : this.f1082a).remove(b0Var);
            b0Var.f1031n = null;
            b0Var.f1032o = false;
            b0Var.d();
        }

        void C() {
            n nVar = RecyclerView.this.f979l;
            this.f1087f = this.f1086e + (nVar != null ? nVar.f1061l : 0);
            for (int size = this.f1084c.size() - 1; size >= 0 && this.f1084c.size() > this.f1087f; size--) {
                s(size);
            }
        }

        boolean D(b0 b0Var) {
            if (b0Var.t()) {
                return RecyclerView.this.f970g0.b();
            }
            if (b0Var.f1020c >= 0) {
                RecyclerView.this.getClass();
                throw null;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + b0Var + RecyclerView.this.B());
        }

        void E(int i6, int i7) {
            int i8;
            int i9 = i7 + i6;
            for (int size = this.f1084c.size() - 1; size >= 0; size--) {
                b0 b0Var = this.f1084c.get(size);
                if (b0Var != null && (i8 = b0Var.f1020c) >= i6 && i8 < i9) {
                    b0Var.b(2);
                    s(size);
                }
            }
        }

        void a(b0 b0Var, boolean z5) {
            RecyclerView.k(b0Var);
            View view = b0Var.f1018a;
            androidx.recyclerview.widget.i iVar = RecyclerView.this.f984n0;
            if (iVar != null) {
                androidx.core.view.a n6 = iVar.n();
                androidx.core.view.s.B(view, n6 instanceof i.a ? ((i.a) n6).n(view) : null);
            }
            if (z5) {
                e(b0Var);
            }
            b0Var.f1035r = null;
            g().e(b0Var);
        }

        public void b() {
            this.f1082a.clear();
            r();
        }

        void c() {
            this.f1082a.clear();
            ArrayList<b0> arrayList = this.f1083b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int d(int i6) {
            if (i6 >= 0 && i6 < RecyclerView.this.f970g0.a()) {
                return !RecyclerView.this.f970g0.b() ? i6 : RecyclerView.this.f963d.m(i6);
            }
            throw new IndexOutOfBoundsException("invalid position " + i6 + ". State item count is " + RecyclerView.this.f970g0.a() + RecyclerView.this.B());
        }

        void e(b0 b0Var) {
            v vVar = RecyclerView.this.f981m;
            if (vVar != null) {
                vVar.a(b0Var);
            }
            int size = RecyclerView.this.f983n.size();
            for (int i6 = 0; i6 < size; i6++) {
                RecyclerView.this.f983n.get(i6).a(b0Var);
            }
            RecyclerView.this.getClass();
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.f970g0 != null) {
                recyclerView.f967f.d(b0Var);
            }
        }

        b0 f(int i6) {
            int size;
            ArrayList<b0> arrayList = this.f1083b;
            if (arrayList == null || (size = arrayList.size()) == 0) {
                return null;
            }
            for (int i7 = 0; i7 < size; i7++) {
                b0 b0Var = this.f1083b.get(i7);
                if (!b0Var.H() && b0Var.k() == i6) {
                    b0Var.b(32);
                    return b0Var;
                }
            }
            RecyclerView.this.getClass();
            throw null;
        }

        t g() {
            if (this.f1088g == null) {
                this.f1088g = new t();
            }
            return this.f1088g;
        }

        int h() {
            return this.f1082a.size();
        }

        b0 i(int i6, boolean z5) {
            View b6;
            int size = this.f1082a.size();
            for (int i7 = 0; i7 < size; i7++) {
                b0 b0Var = this.f1082a.get(i7);
                if (!b0Var.H() && b0Var.k() == i6 && !b0Var.r() && (RecyclerView.this.f970g0.f1099h || !b0Var.t())) {
                    b0Var.b(32);
                    return b0Var;
                }
            }
            if (z5 || (b6 = RecyclerView.this.f965e.b(i6)) == null) {
                int size2 = this.f1084c.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    b0 b0Var2 = this.f1084c.get(i8);
                    if (!b0Var2.r() && b0Var2.k() == i6 && !b0Var2.p()) {
                        if (!z5) {
                            this.f1084c.remove(i8);
                        }
                        return b0Var2;
                    }
                }
                return null;
            }
            b0 I = RecyclerView.I(b6);
            RecyclerView.this.f965e.m(b6);
            int h6 = RecyclerView.this.f965e.h(b6);
            if (h6 != -1) {
                RecyclerView.this.f965e.a(h6);
                v(b6);
                I.b(8224);
                return I;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + I + RecyclerView.this.B());
        }

        View j(int i6) {
            return this.f1082a.get(i6).f1018a;
        }

        void k() {
            int size = this.f1084c.size();
            for (int i6 = 0; i6 < size; i6++) {
                o oVar = (o) this.f1084c.get(i6).f1018a.getLayoutParams();
                if (oVar != null) {
                    oVar.f1074c = true;
                }
            }
        }

        void l() {
            int size = this.f1084c.size();
            for (int i6 = 0; i6 < size; i6++) {
                b0 b0Var = this.f1084c.get(i6);
                if (b0Var != null) {
                    b0Var.b(6);
                    b0Var.a(null);
                }
            }
            RecyclerView.this.getClass();
            r();
        }

        void m(int i6, int i7) {
            int size = this.f1084c.size();
            for (int i8 = 0; i8 < size; i8++) {
                b0 b0Var = this.f1084c.get(i8);
                if (b0Var != null && b0Var.f1020c >= i6) {
                    b0Var.y(i7, false);
                }
            }
        }

        void n(int i6, int i7) {
            int i8;
            int i9;
            int i10;
            int i11;
            if (i6 < i7) {
                i8 = -1;
                i10 = i6;
                i9 = i7;
            } else {
                i8 = 1;
                i9 = i6;
                i10 = i7;
            }
            int size = this.f1084c.size();
            for (int i12 = 0; i12 < size; i12++) {
                b0 b0Var = this.f1084c.get(i12);
                if (b0Var != null && (i11 = b0Var.f1020c) >= i10 && i11 <= i9) {
                    if (i11 == i6) {
                        b0Var.y(i7 - i6, false);
                    } else {
                        b0Var.y(i8, false);
                    }
                }
            }
        }

        void o(int i6, int i7, boolean z5) {
            int i8 = i6 + i7;
            for (int size = this.f1084c.size() - 1; size >= 0; size--) {
                b0 b0Var = this.f1084c.get(size);
                if (b0Var != null) {
                    int i9 = b0Var.f1020c;
                    if (i9 >= i8) {
                        b0Var.y(-i7, z5);
                    } else if (i9 >= i6) {
                        b0Var.b(8);
                        s(size);
                    }
                }
            }
        }

        void p(g gVar, g gVar2, boolean z5) {
            b();
            g().d(gVar, gVar2, z5);
        }

        void q(View view) {
            b0 I = RecyclerView.I(view);
            I.f1031n = null;
            I.f1032o = false;
            I.d();
            u(I);
        }

        void r() {
            for (int size = this.f1084c.size() - 1; size >= 0; size--) {
                s(size);
            }
            this.f1084c.clear();
            if (RecyclerView.D0) {
                RecyclerView.this.f968f0.a();
            }
        }

        void s(int i6) {
            a(this.f1084c.get(i6), true);
            this.f1084c.remove(i6);
        }

        public void t(View view) {
            b0 I = RecyclerView.I(view);
            if (I.v()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (I.u()) {
                I.G();
            } else if (I.H()) {
                I.d();
            }
            u(I);
            if (RecyclerView.this.M == null || I.s()) {
                return;
            }
            RecyclerView.this.M.f(I);
        }

        void u(b0 b0Var) {
            boolean z5;
            boolean z6 = true;
            if (b0Var.u() || b0Var.f1018a.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(b0Var.u());
                sb.append(" isAttached:");
                sb.append(b0Var.f1018a.getParent() != null);
                sb.append(RecyclerView.this.B());
                throw new IllegalArgumentException(sb.toString());
            }
            if (b0Var.v()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + b0Var + RecyclerView.this.B());
            }
            if (b0Var.F()) {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.B());
            }
            boolean g6 = b0Var.g();
            RecyclerView.this.getClass();
            if (b0Var.s()) {
                if (this.f1087f <= 0 || b0Var.n(526)) {
                    z5 = false;
                } else {
                    int size = this.f1084c.size();
                    if (size >= this.f1087f && size > 0) {
                        s(0);
                        size--;
                    }
                    if (RecyclerView.D0 && size > 0 && !RecyclerView.this.f968f0.c(b0Var.f1020c)) {
                        int i6 = size - 1;
                        while (i6 >= 0) {
                            if (!RecyclerView.this.f968f0.c(this.f1084c.get(i6).f1020c)) {
                                break;
                            } else {
                                i6--;
                            }
                        }
                        size = i6 + 1;
                    }
                    this.f1084c.add(size, b0Var);
                    z5 = true;
                }
                if (!z5) {
                    a(b0Var, true);
                    r1 = z5;
                    RecyclerView.this.f967f.d(b0Var);
                    if (r1 && !z6 && g6) {
                        b0Var.f1035r = null;
                        return;
                    }
                    return;
                }
                r1 = z5;
            }
            z6 = false;
            RecyclerView.this.f967f.d(b0Var);
            if (r1) {
            }
        }

        void v(View view) {
            ArrayList<b0> arrayList;
            b0 I = RecyclerView.I(view);
            if (!I.n(12) && I.w() && !RecyclerView.this.i(I)) {
                if (this.f1083b == null) {
                    this.f1083b = new ArrayList<>();
                }
                I.D(this, true);
                arrayList = this.f1083b;
            } else {
                if (I.r() && !I.t()) {
                    RecyclerView.this.getClass();
                    throw null;
                }
                I.D(this, false);
                arrayList = this.f1082a;
            }
            arrayList.add(I);
        }

        void w(t tVar) {
            t tVar2 = this.f1088g;
            if (tVar2 != null) {
                tVar2.b();
            }
            this.f1088g = tVar;
            if (tVar != null) {
                RecyclerView.this.getAdapter();
            }
        }

        void x(z zVar) {
        }

        public void y(int i6) {
            this.f1086e = i6;
            C();
        }
    }

    public interface v {
        void a(b0 b0Var);
    }

    private class w extends h {
        w() {
        }
    }

    public static class x extends i.a {
        public static final Parcelable.Creator<x> CREATOR = new a();

        /* renamed from: c, reason: collision with root package name */
        Parcelable f1091c;

        class a implements Parcelable.ClassLoaderCreator<x> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public x createFromParcel(Parcel parcel) {
                return new x(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public x createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new x(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public x[] newArray(int i6) {
                return new x[i6];
            }
        }

        x(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1091c = parcel.readParcelable(classLoader == null ? n.class.getClassLoader() : classLoader);
        }

        x(Parcelable parcelable) {
            super(parcelable);
        }

        void e(x xVar) {
            this.f1091c = xVar.f1091c;
        }

        @Override // i.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeParcelable(this.f1091c, 0);
        }
    }

    public static class y {

        /* renamed from: b, reason: collision with root package name */
        private SparseArray<Object> f1093b;

        /* renamed from: a, reason: collision with root package name */
        int f1092a = -1;

        /* renamed from: c, reason: collision with root package name */
        int f1094c = 0;

        /* renamed from: d, reason: collision with root package name */
        int f1095d = 0;

        /* renamed from: e, reason: collision with root package name */
        int f1096e = 1;

        /* renamed from: f, reason: collision with root package name */
        int f1097f = 0;

        /* renamed from: g, reason: collision with root package name */
        boolean f1098g = false;

        /* renamed from: h, reason: collision with root package name */
        boolean f1099h = false;

        /* renamed from: i, reason: collision with root package name */
        boolean f1100i = false;

        /* renamed from: j, reason: collision with root package name */
        boolean f1101j = false;

        /* renamed from: k, reason: collision with root package name */
        boolean f1102k = false;

        /* renamed from: l, reason: collision with root package name */
        boolean f1103l = false;

        public int a() {
            return this.f1099h ? this.f1094c - this.f1095d : this.f1097f;
        }

        public boolean b() {
            return this.f1099h;
        }

        void c(g gVar) {
            this.f1096e = 1;
            throw null;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1092a + ", mData=" + this.f1093b + ", mItemCount=" + this.f1097f + ", mIsMeasuring=" + this.f1101j + ", mPreviousLayoutItemCount=" + this.f1094c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1095d + ", mStructureChanged=" + this.f1098g + ", mInPreLayout=" + this.f1099h + ", mRunSimpleAnimations=" + this.f1102k + ", mRunPredictiveAnimations=" + this.f1103l + '}';
        }
    }

    public static abstract class z {
    }

    static {
        int i6 = Build.VERSION.SDK_INT;
        A0 = false;
        B0 = i6 >= 23;
        C0 = true;
        D0 = true;
        E0 = false;
        F0 = false;
        Class<?> cls = Integer.TYPE;
        G0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        H0 = new c();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.a.f7732a);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f957a = new w();
        this.f959b = new u();
        this.f967f = new androidx.recyclerview.widget.m();
        this.f971h = new a();
        this.f973i = new Rect();
        this.f975j = new Rect();
        this.f977k = new RectF();
        this.f983n = new ArrayList();
        this.f985o = new ArrayList<>();
        this.f987p = new ArrayList<>();
        this.f999v = 0;
        this.D = false;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.H = new j();
        this.M = new androidx.recyclerview.widget.c();
        this.N = 0;
        this.O = -1;
        this.f958a0 = Float.MIN_VALUE;
        this.f960b0 = Float.MIN_VALUE;
        this.f962c0 = true;
        this.f964d0 = new a0();
        this.f968f0 = D0 ? new e.b() : null;
        this.f970g0 = new y();
        this.f976j0 = false;
        this.f978k0 = false;
        this.f980l0 = new l();
        this.f982m0 = false;
        this.f986o0 = new int[2];
        this.f990q0 = new int[2];
        this.f992r0 = new int[2];
        this.f994s0 = new int[2];
        this.f996t0 = new ArrayList();
        this.f998u0 = new b();
        this.f1002w0 = 0;
        this.f1004x0 = 0;
        this.f1006y0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.U = viewConfiguration.getScaledTouchSlop();
        this.f958a0 = e1.b(viewConfiguration, context);
        this.f960b0 = e1.c(viewConfiguration, context);
        this.V = viewConfiguration.getScaledMinimumFlingVelocity();
        this.W = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.M.q(this.f980l0);
        N();
        P();
        O();
        if (androidx.core.view.s.i(this) == 0) {
            androidx.core.view.s.C(this, 1);
        }
        this.B = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new androidx.recyclerview.widget.i(this));
        int[] iArr = m.c.f7741f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i6, 0);
        androidx.core.view.s.z(this, context, iArr, attributeSet, obtainStyledAttributes, i6, 0);
        String string = obtainStyledAttributes.getString(m.c.f7750o);
        if (obtainStyledAttributes.getInt(m.c.f7744i, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f969g = obtainStyledAttributes.getBoolean(m.c.f7743h, true);
        boolean z5 = obtainStyledAttributes.getBoolean(m.c.f7745j, false);
        this.f995t = z5;
        if (z5) {
            Q((StateListDrawable) obtainStyledAttributes.getDrawable(m.c.f7748m), obtainStyledAttributes.getDrawable(m.c.f7749n), (StateListDrawable) obtainStyledAttributes.getDrawable(m.c.f7746k), obtainStyledAttributes.getDrawable(m.c.f7747l));
        }
        obtainStyledAttributes.recycle();
        n(context, string, attributeSet, i6, 0);
        int[] iArr2 = f956z0;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i6, 0);
        androidx.core.view.s.z(this, context, iArr2, attributeSet, obtainStyledAttributes2, i6, 0);
        boolean z6 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z6);
    }

    private boolean D(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.f987p.size();
        for (int i6 = 0; i6 < size; i6++) {
            r rVar = this.f987p.get(i6);
            if (rVar.a(this, motionEvent) && action != 3) {
                this.f989q = rVar;
                return true;
            }
        }
        return false;
    }

    private void H0() {
        this.f964d0.f();
        n nVar = this.f979l;
        if (nVar != null) {
            nVar.F0();
        }
    }

    static b0 I(View view) {
        if (view == null) {
            return null;
        }
        return ((o) view.getLayoutParams()).f1072a;
    }

    static void J(View view, Rect rect) {
        o oVar = (o) view.getLayoutParams();
        Rect rect2 = oVar.f1073b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) oVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) oVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) oVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin);
    }

    private String K(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(".")) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private boolean M() {
        int d6 = this.f965e.d();
        for (int i6 = 0; i6 < d6; i6++) {
            b0 I = I(this.f965e.c(i6));
            if (I != null && !I.F() && I.w()) {
                return true;
            }
        }
        return false;
    }

    private void O() {
        if (androidx.core.view.s.j(this) == 0) {
            androidx.core.view.s.D(this, 8);
        }
    }

    private void P() {
        this.f965e = new androidx.recyclerview.widget.b(new e());
    }

    private boolean U(View view, View view2, int i6) {
        int i7;
        if (view2 == null || view2 == this || view2 == view || C(view2) == null) {
            return false;
        }
        if (view == null || C(view) == null) {
            return true;
        }
        this.f973i.set(0, 0, view.getWidth(), view.getHeight());
        this.f975j.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f973i);
        offsetDescendantRectToMyCoords(view2, this.f975j);
        char c6 = 65535;
        int i8 = this.f979l.C() == 1 ? -1 : 1;
        Rect rect = this.f973i;
        int i9 = rect.left;
        Rect rect2 = this.f975j;
        int i10 = rect2.left;
        if ((i9 < i10 || rect.right <= i10) && rect.right < rect2.right) {
            i7 = 1;
        } else {
            int i11 = rect.right;
            int i12 = rect2.right;
            i7 = ((i11 > i12 || i9 >= i12) && i9 > i10) ? -1 : 0;
        }
        int i13 = rect.top;
        int i14 = rect2.top;
        if ((i13 < i14 || rect.bottom <= i14) && rect.bottom < rect2.bottom) {
            c6 = 1;
        } else {
            int i15 = rect.bottom;
            int i16 = rect2.bottom;
            if ((i15 <= i16 && i13 < i16) || i13 <= i14) {
                c6 = 0;
            }
        }
        if (i6 == 1) {
            return c6 < 0 || (c6 == 0 && i7 * i8 < 0);
        }
        if (i6 == 2) {
            return c6 > 0 || (c6 == 0 && i7 * i8 > 0);
        }
        if (i6 == 17) {
            return i7 < 0;
        }
        if (i6 == 33) {
            return c6 < 0;
        }
        if (i6 == 66) {
            return i7 > 0;
        }
        if (i6 == 130) {
            return c6 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i6 + B());
    }

    private void X(int i6, int i7, MotionEvent motionEvent, int i8) {
        n nVar = this.f979l;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f1003x) {
            return;
        }
        int[] iArr = this.f994s0;
        iArr[0] = 0;
        iArr[1] = 0;
        boolean b6 = nVar.b();
        boolean c6 = this.f979l.c();
        D0(c6 ? (b6 ? 1 : 0) | 2 : b6 ? 1 : 0, i8);
        if (s(b6 ? i6 : 0, c6 ? i7 : 0, this.f994s0, this.f990q0, i8)) {
            int[] iArr2 = this.f994s0;
            i6 -= iArr2[0];
            i7 -= iArr2[1];
        }
        u0(b6 ? i6 : 0, c6 ? i7 : 0, motionEvent, i8);
        androidx.recyclerview.widget.e eVar = this.f966e0;
        if (eVar != null && (i6 != 0 || i7 != 0)) {
            eVar.f(this, i6, i7);
        }
        F0(i8);
    }

    private void f0(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.O) {
            int i6 = actionIndex == 0 ? 1 : 0;
            this.O = motionEvent.getPointerId(i6);
            int x5 = (int) (motionEvent.getX(i6) + 0.5f);
            this.S = x5;
            this.Q = x5;
            int y5 = (int) (motionEvent.getY(i6) + 0.5f);
            this.T = y5;
            this.R = y5;
        }
    }

    private androidx.core.view.l getScrollingChildHelper() {
        if (this.f988p0 == null) {
            this.f988p0 = new androidx.core.view.l(this);
        }
        return this.f988p0;
    }

    private boolean h0() {
        return this.M != null && this.f979l.G0();
    }

    private void i0() {
        boolean z5;
        boolean z6;
        if (this.D) {
            this.f963d.t();
            if (this.E) {
                this.f979l.h0(this);
            }
        }
        if (h0()) {
            this.f963d.r();
        } else {
            this.f963d.j();
        }
        boolean z7 = false;
        boolean z8 = this.f976j0 || this.f978k0;
        y yVar = this.f970g0;
        if (!this.f997u || this.M == null || (!(z6 = this.D) && !z8 && !this.f979l.f1056g)) {
            z5 = false;
        } else {
            if (z6) {
                throw null;
            }
            z5 = true;
        }
        yVar.f1102k = z5;
        if (z5 && z8 && !this.D && h0()) {
            z7 = true;
        }
        yVar.f1103l = z7;
    }

    private void j() {
        t0();
        setScrollState(0);
    }

    static void k(b0 b0Var) {
        WeakReference<RecyclerView> weakReference = b0Var.f1019b;
        if (weakReference != null) {
            Object obj = weakReference.get();
            while (true) {
                for (View view = (View) obj; view != null; view = null) {
                    if (view == b0Var.f1018a) {
                        return;
                    }
                    obj = view.getParent();
                    if (obj instanceof View) {
                        break;
                    }
                }
                b0Var.f1019b = null;
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void k0(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.y()
            android.widget.EdgeEffect r3 = r6.I
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
        L1c:
            androidx.core.widget.a.a(r3, r4, r9)
            r9 = 1
            goto L39
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L38
            r6.z()
            android.widget.EdgeEffect r3 = r6.K
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            goto L1c
        L38:
            r9 = 0
        L39:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L53
            r6.A()
            android.widget.EdgeEffect r9 = r6.J
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.a.a(r9, r0, r7)
            goto L6f
        L53:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L6e
            r6.x()
            android.widget.EdgeEffect r9 = r6.L
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.a.a(r9, r3, r0)
            goto L6f
        L6e:
            r1 = r9
        L6f:
            if (r1 != 0) goto L79
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L79
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7c
        L79:
            androidx.core.view.s.w(r6)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.k0(float, float, float, float):void");
    }

    private void m0() {
        boolean z5;
        EdgeEffect edgeEffect = this.I;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z5 = this.I.isFinished();
        } else {
            z5 = false;
        }
        EdgeEffect edgeEffect2 = this.J;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z5 |= this.J.isFinished();
        }
        EdgeEffect edgeEffect3 = this.K;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z5 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect4 = this.L;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z5 |= this.L.isFinished();
        }
        if (z5) {
            androidx.core.view.s.w(this);
        }
    }

    private void n(Context context, String str, AttributeSet attributeSet, int i6, int i7) {
        Constructor constructor;
        Object[] objArr;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String K = K(context, trim);
            try {
                Class<? extends U> asSubclass = Class.forName(K, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(n.class);
                try {
                    constructor = asSubclass.getConstructor(G0);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i6), Integer.valueOf(i7)};
                } catch (NoSuchMethodException e6) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    } catch (NoSuchMethodException e7) {
                        e7.initCause(e6);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + K, e7);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((n) constructor.newInstance(objArr));
            } catch (ClassCastException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + K, e8);
            } catch (ClassNotFoundException e9) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + K, e9);
            } catch (IllegalAccessException e10) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + K, e10);
            } catch (InstantiationException e11) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + K, e11);
            } catch (InvocationTargetException e12) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + K, e12);
            }
        }
    }

    private void q() {
        int i6 = this.f1007z;
        this.f1007z = 0;
        if (i6 == 0 || !S()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        androidx.core.view.accessibility.b.b(obtain, i6);
        sendAccessibilityEventUnchecked(obtain);
    }

    private void s0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f973i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof o) {
            o oVar = (o) layoutParams;
            if (!oVar.f1074c) {
                Rect rect = oVar.f1073b;
                Rect rect2 = this.f973i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f973i);
            offsetRectIntoDescendantCoords(view, this.f973i);
        }
        this.f979l.B0(this, view, this.f973i, !this.f997u, view2 == null);
    }

    private void t0() {
        VelocityTracker velocityTracker = this.P;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        F0(0);
        m0();
    }

    private void v0(g gVar, boolean z5, boolean z6) {
        if (!z5 || z6) {
            n0();
        }
        this.f963d.t();
        n nVar = this.f979l;
        if (nVar != null) {
            nVar.U(null, null);
        }
        this.f959b.p(null, null, z5);
        this.f970g0.f1098g = true;
    }

    private boolean w(MotionEvent motionEvent) {
        r rVar = this.f989q;
        if (rVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return D(motionEvent);
        }
        rVar.b(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.f989q = null;
        }
        return true;
    }

    void A() {
        int measuredWidth;
        int measuredHeight;
        if (this.J != null) {
            return;
        }
        EdgeEffect a6 = this.H.a(this, 1);
        this.J = a6;
        if (this.f969g) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        a6.setSize(measuredWidth, measuredHeight);
    }

    public void A0(int i6, int i7, Interpolator interpolator, int i8) {
        B0(i6, i7, interpolator, i8, false);
    }

    String B() {
        return " " + super.toString() + ", adapter:" + ((Object) null) + ", layout:" + this.f979l + ", context:" + getContext();
    }

    void B0(int i6, int i7, Interpolator interpolator, int i8, boolean z5) {
        n nVar = this.f979l;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f1003x) {
            return;
        }
        if (!nVar.b()) {
            i6 = 0;
        }
        if (!this.f979l.c()) {
            i7 = 0;
        }
        if (i6 == 0 && i7 == 0) {
            return;
        }
        if (!(i8 == Integer.MIN_VALUE || i8 > 0)) {
            scrollBy(i6, i7);
            return;
        }
        if (z5) {
            int i9 = i6 != 0 ? 1 : 0;
            if (i7 != 0) {
                i9 |= 2;
            }
            D0(i9, 1);
        }
        this.f964d0.e(i6, i7, i8, interpolator);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View C(android.view.View r3) {
        /*
            r2 = this;
        L0:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L10
            if (r0 == r2) goto L10
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L10
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L0
        L10:
            if (r0 != r2) goto L13
            goto L14
        L13:
            r3 = 0
        L14:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C(android.view.View):android.view.View");
    }

    void C0() {
        int i6 = this.f999v + 1;
        this.f999v = i6;
        if (i6 != 1 || this.f1003x) {
            return;
        }
        this.f1001w = false;
    }

    public boolean D0(int i6, int i7) {
        return getScrollingChildHelper().p(i6, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    androidx.recyclerview.widget.RecyclerView.b0 E(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.b r0 = r5.f965e
            int r0 = r0.g()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.b r3 = r5.f965e
            android.view.View r3 = r3.f(r2)
            androidx.recyclerview.widget.RecyclerView$b0 r3 = I(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.t()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.f1020c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.k()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.b r1 = r5.f965e
            android.view.View r4 = r3.f1018a
            boolean r1 = r1.i(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.E(int, boolean):androidx.recyclerview.widget.RecyclerView$b0");
    }

    void E0(boolean z5) {
        if (this.f999v < 1) {
            this.f999v = 1;
        }
        if (!z5 && !this.f1003x) {
            this.f1001w = false;
        }
        int i6 = this.f999v;
        if (i6 == 1) {
            if (z5 && this.f1001w && !this.f1003x) {
                n nVar = this.f979l;
            }
            if (!this.f1003x) {
                this.f1001w = false;
            }
        }
        this.f999v = i6 - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean F(int i6, int i7) {
        n nVar = this.f979l;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.f1003x) {
            return false;
        }
        boolean b6 = nVar.b();
        boolean c6 = this.f979l.c();
        if (b6 == 0 || Math.abs(i6) < this.V) {
            i6 = 0;
        }
        if (!c6 || Math.abs(i7) < this.V) {
            i7 = 0;
        }
        if (i6 == 0 && i7 == 0) {
            return false;
        }
        float f6 = i6;
        float f7 = i7;
        if (!dispatchNestedPreFling(f6, f7)) {
            boolean z5 = b6 != 0 || c6;
            dispatchNestedFling(f6, f7, z5);
            int i8 = b6;
            if (z5) {
                if (c6) {
                    i8 = (b6 ? 1 : 0) | 2;
                }
                D0(i8, 1);
                int i9 = this.W;
                int max = Math.max(-i9, Math.min(i6, i9));
                int i10 = this.W;
                this.f964d0.b(max, Math.max(-i10, Math.min(i7, i10)));
                return true;
            }
        }
        return false;
    }

    public void F0(int i6) {
        getScrollingChildHelper().r(i6);
    }

    int G(b0 b0Var) {
        if (b0Var.n(524) || !b0Var.q()) {
            return -1;
        }
        return this.f963d.e(b0Var.f1020c);
    }

    public void G0() {
        setScrollState(0);
        H0();
    }

    long H(b0 b0Var) {
        throw null;
    }

    void I0(int i6, int i7, Object obj) {
        int i8;
        int g6 = this.f965e.g();
        int i9 = i6 + i7;
        for (int i10 = 0; i10 < g6; i10++) {
            View f6 = this.f965e.f(i10);
            b0 I = I(f6);
            if (I != null && !I.F() && (i8 = I.f1020c) >= i6 && i8 < i9) {
                I.b(2);
                I.a(obj);
                ((o) f6.getLayoutParams()).f1074c = true;
            }
        }
        this.f959b.E(i6, i7);
    }

    public boolean L() {
        return !this.f997u || this.D || this.f963d.p();
    }

    void N() {
        this.f963d = new androidx.recyclerview.widget.a(new f());
    }

    void Q(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new androidx.recyclerview.widget.d(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(m.b.f7733a), resources.getDimensionPixelSize(m.b.f7735c), resources.getDimensionPixelOffset(m.b.f7734b));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + B());
        }
    }

    void R() {
        this.L = null;
        this.J = null;
        this.K = null;
        this.I = null;
    }

    boolean S() {
        AccessibilityManager accessibilityManager = this.B;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean T() {
        return this.F > 0;
    }

    void V() {
        int g6 = this.f965e.g();
        for (int i6 = 0; i6 < g6; i6++) {
            ((o) this.f965e.f(i6).getLayoutParams()).f1074c = true;
        }
        this.f959b.k();
    }

    void W() {
        int g6 = this.f965e.g();
        for (int i6 = 0; i6 < g6; i6++) {
            b0 I = I(this.f965e.f(i6));
            if (I != null && !I.F()) {
                I.b(6);
            }
        }
        V();
        this.f959b.l();
    }

    void Y(int i6, int i7) {
        int g6 = this.f965e.g();
        for (int i8 = 0; i8 < g6; i8++) {
            b0 I = I(this.f965e.f(i8));
            if (I != null && !I.F() && I.f1020c >= i6) {
                I.y(i7, false);
                this.f970g0.f1098g = true;
            }
        }
        this.f959b.m(i6, i7);
        requestLayout();
    }

    void Z(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int g6 = this.f965e.g();
        if (i6 < i7) {
            i10 = -1;
            i9 = i6;
            i8 = i7;
        } else {
            i8 = i6;
            i9 = i7;
            i10 = 1;
        }
        for (int i12 = 0; i12 < g6; i12++) {
            b0 I = I(this.f965e.f(i12));
            if (I != null && (i11 = I.f1020c) >= i9 && i11 <= i8) {
                if (i11 == i6) {
                    I.y(i7 - i6, false);
                } else {
                    I.y(i10, false);
                }
                this.f970g0.f1098g = true;
            }
        }
        this.f959b.n(i6, i7);
        requestLayout();
    }

    void a(int i6, int i7) {
        if (i6 < 0) {
            y();
            if (this.I.isFinished()) {
                this.I.onAbsorb(-i6);
            }
        } else if (i6 > 0) {
            z();
            if (this.K.isFinished()) {
                this.K.onAbsorb(i6);
            }
        }
        if (i7 < 0) {
            A();
            if (this.J.isFinished()) {
                this.J.onAbsorb(-i7);
            }
        } else if (i7 > 0) {
            x();
            if (this.L.isFinished()) {
                this.L.onAbsorb(i7);
            }
        }
        if (i6 == 0 && i7 == 0) {
            return;
        }
        androidx.core.view.s.w(this);
    }

    void a0(int i6, int i7, boolean z5) {
        int i8 = i6 + i7;
        int g6 = this.f965e.g();
        for (int i9 = 0; i9 < g6; i9++) {
            b0 I = I(this.f965e.f(i9));
            if (I != null && !I.F()) {
                int i10 = I.f1020c;
                if (i10 >= i8) {
                    I.y(-i7, z5);
                } else if (i10 >= i6) {
                    I.h(i6 - 1, -i7, z5);
                }
                this.f970g0.f1098g = true;
            }
        }
        this.f959b.o(i6, i7, z5);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i6, int i7) {
        n nVar = this.f979l;
        if (nVar == null || !nVar.V(this, arrayList, i6, i7)) {
            super.addFocusables(arrayList, i6, i7);
        }
    }

    public void b0(View view) {
    }

    void c0() {
        this.F++;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof o) && this.f979l.d((o) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        n nVar = this.f979l;
        if (nVar != null && nVar.b()) {
            return this.f979l.f(this.f970g0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        n nVar = this.f979l;
        if (nVar != null && nVar.b()) {
            return this.f979l.g(this.f970g0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        n nVar = this.f979l;
        if (nVar != null && nVar.b()) {
            return this.f979l.h(this.f970g0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        n nVar = this.f979l;
        if (nVar != null && nVar.c()) {
            return this.f979l.i(this.f970g0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        n nVar = this.f979l;
        if (nVar != null && nVar.c()) {
            return this.f979l.j(this.f970g0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        n nVar = this.f979l;
        if (nVar != null && nVar.c()) {
            return this.f979l.k(this.f970g0);
        }
        return 0;
    }

    public void d(m mVar) {
        e(mVar, -1);
    }

    void d0() {
        e0(true);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f6, float f7, boolean z5) {
        return getScrollingChildHelper().a(f6, f7, z5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f6, float f7) {
        return getScrollingChildHelper().b(f6, f7);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i6, int i7, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i6, i7, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i6, int i7, int i8, int i9, int[] iArr) {
        return getScrollingChildHelper().f(i6, i7, i8, i9, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z5;
        float f6;
        int i6;
        super.draw(canvas);
        int size = this.f985o.size();
        boolean z6 = false;
        for (int i7 = 0; i7 < size; i7++) {
            this.f985o.get(i7).g(canvas, this, this.f970g0);
        }
        EdgeEffect edgeEffect = this.I;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z5 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f969g ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.I;
            z5 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.J;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f969g) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.J;
            z5 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.K;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f969g ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.K;
            z5 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.L;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f969g) {
                f6 = (-getWidth()) + getPaddingRight();
                i6 = (-getHeight()) + getPaddingBottom();
            } else {
                f6 = -getWidth();
                i6 = -getHeight();
            }
            canvas.translate(f6, i6);
            EdgeEffect edgeEffect8 = this.L;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z6 = true;
            }
            z5 |= z6;
            canvas.restoreToCount(save4);
        }
        if ((z5 || this.M == null || this.f985o.size() <= 0 || !this.M.l()) ? z5 : true) {
            androidx.core.view.s.w(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j6) {
        return super.drawChild(canvas, view, j6);
    }

    public void e(m mVar, int i6) {
        n nVar = this.f979l;
        if (nVar != null) {
            nVar.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f985o.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i6 < 0) {
            this.f985o.add(mVar);
        } else {
            this.f985o.add(i6, mVar);
        }
        V();
        requestLayout();
    }

    void e0(boolean z5) {
        int i6 = this.F - 1;
        this.F = i6;
        if (i6 < 1) {
            this.F = 0;
            if (z5) {
                q();
                v();
            }
        }
    }

    public void f(r rVar) {
        this.f987p.add(rVar);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i6) {
        View f02 = this.f979l.f0(view, i6);
        if (f02 != null) {
            return f02;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i6);
        if (findNextFocus == null || findNextFocus.hasFocusable()) {
            return U(view, findNextFocus, i6) ? findNextFocus : super.focusSearch(view, i6);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i6);
        }
        s0(findNextFocus, null);
        return view;
    }

    public void g(s sVar) {
        if (this.f974i0 == null) {
            this.f974i0 = new ArrayList();
        }
        this.f974i0.add(sVar);
    }

    public void g0(int i6) {
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        n nVar = this.f979l;
        if (nVar != null) {
            return nVar.n();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + B());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        n nVar = this.f979l;
        if (nVar != null) {
            return nVar.o(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + B());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        n nVar = this.f979l;
        if (nVar != null) {
            return nVar.p(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + B());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public g getAdapter() {
        return null;
    }

    @Override // android.view.View
    public int getBaseline() {
        n nVar = this.f979l;
        return nVar != null ? nVar.q() : super.getBaseline();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i6, int i7) {
        return super.getChildDrawingOrder(i6, i7);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f969g;
    }

    public androidx.recyclerview.widget.i getCompatAccessibilityDelegate() {
        return this.f984n0;
    }

    public j getEdgeEffectFactory() {
        return this.H;
    }

    public k getItemAnimator() {
        return this.M;
    }

    public int getItemDecorationCount() {
        return this.f985o.size();
    }

    public n getLayoutManager() {
        return this.f979l;
    }

    public int getMaxFlingVelocity() {
        return this.W;
    }

    public int getMinFlingVelocity() {
        return this.V;
    }

    long getNanoTime() {
        if (D0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public q getOnFlingListener() {
        return null;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f962c0;
    }

    public t getRecycledViewPool() {
        return this.f959b.g();
    }

    public int getScrollState() {
        return this.N;
    }

    void h(String str) {
        if (T()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + B());
        }
        if (this.G > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + B()));
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().j();
    }

    boolean i(b0 b0Var) {
        k kVar = this.M;
        return kVar == null || kVar.c(b0Var, b0Var.m());
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.f991r;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f1003x;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().l();
    }

    void j0(boolean z5) {
        this.E = z5 | this.E;
        this.D = true;
        W();
    }

    void l(int i6, int i7) {
        boolean z5;
        EdgeEffect edgeEffect = this.I;
        if (edgeEffect == null || edgeEffect.isFinished() || i6 <= 0) {
            z5 = false;
        } else {
            this.I.onRelease();
            z5 = this.I.isFinished();
        }
        EdgeEffect edgeEffect2 = this.K;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i6 < 0) {
            this.K.onRelease();
            z5 |= this.K.isFinished();
        }
        EdgeEffect edgeEffect3 = this.J;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i7 > 0) {
            this.J.onRelease();
            z5 |= this.J.isFinished();
        }
        EdgeEffect edgeEffect4 = this.L;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i7 < 0) {
            this.L.onRelease();
            z5 |= this.L.isFinished();
        }
        if (z5) {
            androidx.core.view.s.w(this);
        }
    }

    void l0(b0 b0Var, k.c cVar) {
        b0Var.B(0, 8192);
        if (this.f970g0.f1100i && b0Var.w() && !b0Var.t() && !b0Var.F()) {
            this.f967f.a(H(b0Var), b0Var);
        }
        this.f967f.b(b0Var, cVar);
    }

    void m() {
        if (!this.f997u || this.D) {
            androidx.core.os.d.a("RV FullInvalidate");
            r();
            androidx.core.os.d.b();
            return;
        }
        if (this.f963d.p()) {
            if (this.f963d.o(4) && !this.f963d.o(11)) {
                androidx.core.os.d.a("RV PartialInvalidate");
                C0();
                c0();
                this.f963d.r();
                if (!this.f1001w) {
                    if (M()) {
                        r();
                    } else {
                        this.f963d.i();
                    }
                }
                E0(true);
                d0();
            } else {
                if (!this.f963d.p()) {
                    return;
                }
                androidx.core.os.d.a("RV FullInvalidate");
                r();
            }
            androidx.core.os.d.b();
        }
    }

    void n0() {
        k kVar = this.M;
        if (kVar != null) {
            kVar.g();
        }
        n nVar = this.f979l;
        if (nVar != null) {
            nVar.v0(this.f959b);
            this.f979l.w0(this.f959b);
        }
        this.f959b.b();
    }

    void o(int i6, int i7) {
        setMeasuredDimension(n.e(i6, getPaddingLeft() + getPaddingRight(), androidx.core.view.s.m(this)), n.e(i7, getPaddingTop() + getPaddingBottom(), androidx.core.view.s.l(this)));
    }

    boolean o0(View view) {
        C0();
        boolean l6 = this.f965e.l(view);
        if (l6) {
            b0 I = I(view);
            this.f959b.B(I);
            this.f959b.u(I);
        }
        E0(!l6);
        return l6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
    
        if (r1 >= 30.0f) goto L22;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.F = r0
            r1 = 1
            r5.f991r = r1
            boolean r2 = r5.f997u
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r5.f997u = r1
            androidx.recyclerview.widget.RecyclerView$n r1 = r5.f979l
            if (r1 == 0) goto L1e
            r1.l(r5)
        L1e:
            r5.f982m0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.D0
            if (r0 == 0) goto L61
            java.lang.ThreadLocal<androidx.recyclerview.widget.e> r0 = androidx.recyclerview.widget.e.f1244e
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.e r1 = (androidx.recyclerview.widget.e) r1
            r5.f966e0 = r1
            if (r1 != 0) goto L5c
            androidx.recyclerview.widget.e r1 = new androidx.recyclerview.widget.e
            r1.<init>()
            r5.f966e0 = r1
            android.view.Display r1 = androidx.core.view.s.h(r5)
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L4e
            if (r1 == 0) goto L4e
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L4e
            goto L50
        L4e:
            r1 = 1114636288(0x42700000, float:60.0)
        L50:
            androidx.recyclerview.widget.e r2 = r5.f966e0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f1248c = r3
            r0.set(r2)
        L5c:
            androidx.recyclerview.widget.e r0 = r5.f966e0
            r0.a(r5)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.e eVar;
        super.onDetachedFromWindow();
        k kVar = this.M;
        if (kVar != null) {
            kVar.g();
        }
        G0();
        this.f991r = false;
        n nVar = this.f979l;
        if (nVar != null) {
            nVar.m(this, this.f959b);
        }
        this.f996t0.clear();
        removeCallbacks(this.f998u0);
        this.f967f.c();
        if (!D0 || (eVar = this.f966e0) == null) {
            return;
        }
        eVar.j(this);
        this.f966e0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f985o.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f985o.get(i6).e(canvas, this, this.f970g0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$n r0 = r5.f979l
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.f1003x
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L78
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            androidx.recyclerview.widget.RecyclerView$n r0 = r5.f979l
            boolean r0 = r0.c()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$n r3 = r5.f979l
            boolean r3 = r3.b()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$n r3 = r5.f979l
            boolean r3 = r3.c()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            androidx.recyclerview.widget.RecyclerView$n r3 = r5.f979l
            boolean r3 = r3.b()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L78
        L6a:
            float r2 = r5.f958a0
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.f960b0
            float r0 = r0 * r3
            int r0 = (int) r0
            r3 = 1
            r5.X(r2, r0, r6, r3)
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        if (this.f1003x) {
            return false;
        }
        this.f989q = null;
        if (D(motionEvent)) {
            j();
            return true;
        }
        n nVar = this.f979l;
        if (nVar == null) {
            return false;
        }
        boolean b6 = nVar.b();
        boolean c6 = this.f979l.c();
        if (this.P == null) {
            this.P = VelocityTracker.obtain();
        }
        this.P.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.f1005y) {
                this.f1005y = false;
            }
            this.O = motionEvent.getPointerId(0);
            int x5 = (int) (motionEvent.getX() + 0.5f);
            this.S = x5;
            this.Q = x5;
            int y5 = (int) (motionEvent.getY() + 0.5f);
            this.T = y5;
            this.R = y5;
            if (this.N == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                F0(1);
            }
            int[] iArr = this.f992r0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i6 = b6;
            if (c6) {
                i6 = (b6 ? 1 : 0) | 2;
            }
            D0(i6, 0);
        } else if (actionMasked == 1) {
            this.P.clear();
            F0(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.O);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.O + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x6 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y6 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.N != 1) {
                int i7 = x6 - this.Q;
                int i8 = y6 - this.R;
                if (b6 == 0 || Math.abs(i7) <= this.U) {
                    z5 = false;
                } else {
                    this.S = x6;
                    z5 = true;
                }
                if (c6 && Math.abs(i8) > this.U) {
                    this.T = y6;
                    z5 = true;
                }
                if (z5) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            j();
        } else if (actionMasked == 5) {
            this.O = motionEvent.getPointerId(actionIndex);
            int x7 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.S = x7;
            this.Q = x7;
            int y7 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.T = y7;
            this.R = y7;
        } else if (actionMasked == 6) {
            f0(motionEvent);
        }
        return this.N == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        androidx.core.os.d.a("RV OnLayout");
        r();
        androidx.core.os.d.b();
        this.f997u = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i6, int i7) {
        n nVar = this.f979l;
        if (nVar == null) {
            o(i6, i7);
            return;
        }
        if (nVar.Q()) {
            int mode = View.MeasureSpec.getMode(i6);
            int mode2 = View.MeasureSpec.getMode(i7);
            this.f979l.m0(this.f959b, this.f970g0, i6, i7);
            this.f1000v0 = mode == 1073741824 && mode2 == 1073741824;
            return;
        }
        if (this.f993s) {
            this.f979l.m0(this.f959b, this.f970g0, i6, i7);
            return;
        }
        if (this.A) {
            C0();
            c0();
            i0();
            d0();
            y yVar = this.f970g0;
            if (yVar.f1103l) {
                yVar.f1099h = true;
            } else {
                this.f963d.j();
                this.f970g0.f1099h = false;
            }
            this.A = false;
            E0(false);
        } else if (this.f970g0.f1103l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        this.f970g0.f1097f = 0;
        C0();
        this.f979l.m0(this.f959b, this.f970g0, i6, i7);
        E0(false);
        this.f970g0.f1099h = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i6, Rect rect) {
        if (T()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i6, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof x)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        x xVar = (x) parcelable;
        this.f961c = xVar;
        super.onRestoreInstanceState(xVar.d());
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        x xVar = new x(super.onSaveInstanceState());
        x xVar2 = this.f961c;
        if (xVar2 != null) {
            xVar.e(xVar2);
        } else {
            n nVar = this.f979l;
            xVar.f1091c = nVar != null ? nVar.p0() : null;
        }
        return xVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        if (i6 == i8 && i7 == i9) {
            return;
        }
        R();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void p(View view) {
        I(view);
        b0(view);
        List<p> list = this.C;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.C.get(size).a(view);
            }
        }
    }

    public void p0(m mVar) {
        n nVar = this.f979l;
        if (nVar != null) {
            nVar.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.f985o.remove(mVar);
        if (this.f985o.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        V();
        requestLayout();
    }

    public void q0(r rVar) {
        this.f987p.remove(rVar);
        if (this.f989q == rVar) {
            this.f989q = null;
        }
    }

    void r() {
        Log.w("RecyclerView", "No adapter attached; skipping layout");
    }

    public void r0(s sVar) {
        List<s> list = this.f974i0;
        if (list != null) {
            list.remove(sVar);
        }
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z5) {
        b0 I = I(view);
        if (I != null) {
            if (I.v()) {
                I.e();
            } else if (!I.F()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + I + B());
            }
        }
        view.clearAnimation();
        p(view);
        super.removeDetachedView(view, z5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.f979l.o0(this, this.f970g0, view, view2) && view2 != null) {
            s0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z5) {
        return this.f979l.A0(this, view, rect, z5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z5) {
        int size = this.f987p.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f987p.get(i6).c(z5);
        }
        super.requestDisallowInterceptTouchEvent(z5);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f999v != 0 || this.f1003x) {
            this.f1001w = true;
        } else {
            super.requestLayout();
        }
    }

    public boolean s(int i6, int i7, int[] iArr, int[] iArr2, int i8) {
        return getScrollingChildHelper().d(i6, i7, iArr, iArr2, i8);
    }

    @Override // android.view.View
    public void scrollBy(int i6, int i7) {
        n nVar = this.f979l;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f1003x) {
            return;
        }
        boolean b6 = nVar.b();
        boolean c6 = this.f979l.c();
        if (b6 || c6) {
            if (!b6) {
                i6 = 0;
            }
            if (!c6) {
                i7 = 0;
            }
            u0(i6, i7, null, 0);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i6, int i7) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (x0(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(androidx.recyclerview.widget.i iVar) {
        this.f984n0 = iVar;
        androidx.core.view.s.B(this, iVar);
    }

    public void setAdapter(g gVar) {
        setLayoutFrozen(false);
        v0(gVar, false, true);
        j0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(i iVar) {
        if (iVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z5) {
        if (z5 != this.f969g) {
            R();
        }
        this.f969g = z5;
        super.setClipToPadding(z5);
        if (this.f997u) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(j jVar) {
        androidx.core.util.g.a(jVar);
        this.H = jVar;
        R();
    }

    public void setHasFixedSize(boolean z5) {
        this.f993s = z5;
    }

    public void setItemAnimator(k kVar) {
        k kVar2 = this.M;
        if (kVar2 != null) {
            kVar2.g();
            this.M.q(null);
        }
        this.M = kVar;
        if (kVar != null) {
            kVar.q(this.f980l0);
        }
    }

    public void setItemViewCacheSize(int i6) {
        this.f959b.y(i6);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z5) {
        suppressLayout(z5);
    }

    public void setLayoutManager(n nVar) {
        if (nVar == this.f979l) {
            return;
        }
        G0();
        if (this.f979l != null) {
            k kVar = this.M;
            if (kVar != null) {
                kVar.g();
            }
            this.f979l.v0(this.f959b);
            this.f979l.w0(this.f959b);
            this.f959b.b();
            if (this.f991r) {
                this.f979l.m(this, this.f959b);
            }
            this.f979l.E0(null);
            this.f979l = null;
        } else {
            this.f959b.b();
        }
        this.f965e.j();
        this.f979l = nVar;
        if (nVar != null) {
            if (nVar.f1051b != null) {
                throw new IllegalArgumentException("LayoutManager " + nVar + " is already attached to a RecyclerView:" + nVar.f1051b.B());
            }
            nVar.E0(this);
            if (this.f991r) {
                this.f979l.l(this);
            }
        }
        this.f959b.C();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z5) {
        getScrollingChildHelper().m(z5);
    }

    public void setOnFlingListener(q qVar) {
    }

    @Deprecated
    public void setOnScrollListener(s sVar) {
        this.f972h0 = sVar;
    }

    public void setPreserveFocusAfterLayout(boolean z5) {
        this.f962c0 = z5;
    }

    public void setRecycledViewPool(t tVar) {
        this.f959b.w(tVar);
    }

    @Deprecated
    public void setRecyclerListener(v vVar) {
        this.f981m = vVar;
    }

    void setScrollState(int i6) {
        if (i6 == this.N) {
            return;
        }
        this.N = i6;
        if (i6 != 2) {
            H0();
        }
        u(i6);
    }

    public void setScrollingTouchSlop(int i6) {
        int scaledTouchSlop;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i6 != 0) {
            if (i6 == 1) {
                scaledTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                this.U = scaledTouchSlop;
            } else {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i6 + "; using default value");
            }
        }
        scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.U = scaledTouchSlop;
    }

    public void setViewCacheExtension(z zVar) {
        this.f959b.x(zVar);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i6) {
        return getScrollingChildHelper().o(i6);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().q();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z5) {
        if (z5 != this.f1003x) {
            h("Do not suppressLayout in layout or scroll");
            if (!z5) {
                this.f1003x = false;
                if (this.f1001w) {
                    n nVar = this.f979l;
                }
                this.f1001w = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f1003x = true;
            this.f1005y = true;
            G0();
        }
    }

    public final void t(int i6, int i7, int i8, int i9, int[] iArr, int i10, int[] iArr2) {
        getScrollingChildHelper().e(i6, i7, i8, i9, iArr, i10, iArr2);
    }

    void u(int i6) {
        n nVar = this.f979l;
        if (nVar != null) {
            nVar.q0(i6);
        }
        g0(i6);
        s sVar = this.f972h0;
        if (sVar != null) {
            sVar.a(this, i6);
        }
        List<s> list = this.f974i0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f974i0.get(size).a(this, i6);
            }
        }
    }

    boolean u0(int i6, int i7, MotionEvent motionEvent, int i8) {
        m();
        if (!this.f985o.isEmpty()) {
            invalidate();
        }
        int[] iArr = this.f994s0;
        iArr[0] = 0;
        iArr[1] = 0;
        t(0, 0, 0, 0, this.f990q0, i8, iArr);
        int[] iArr2 = this.f994s0;
        int i9 = iArr2[0];
        int i10 = 0 - i9;
        int i11 = iArr2[1];
        int i12 = 0 - i11;
        boolean z5 = (i9 == 0 && i11 == 0) ? false : true;
        int i13 = this.S;
        int[] iArr3 = this.f990q0;
        int i14 = iArr3[0];
        this.S = i13 - i14;
        int i15 = this.T;
        int i16 = iArr3[1];
        this.T = i15 - i16;
        int[] iArr4 = this.f992r0;
        iArr4[0] = iArr4[0] + i14;
        iArr4[1] = iArr4[1] + i16;
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !androidx.core.view.k.a(motionEvent, 8194)) {
                k0(motionEvent.getX(), i10, motionEvent.getY(), i12);
            }
            l(i6, i7);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return z5;
    }

    void v() {
        int i6;
        for (int size = this.f996t0.size() - 1; size >= 0; size--) {
            b0 b0Var = this.f996t0.get(size);
            if (b0Var.f1018a.getParent() == this && !b0Var.F() && (i6 = b0Var.f1034q) != -1) {
                androidx.core.view.s.C(b0Var.f1018a, i6);
                b0Var.f1034q = -1;
            }
        }
        this.f996t0.clear();
    }

    boolean w0(b0 b0Var, int i6) {
        if (!T()) {
            androidx.core.view.s.C(b0Var.f1018a, i6);
            return true;
        }
        b0Var.f1034q = i6;
        this.f996t0.add(b0Var);
        return false;
    }

    void x() {
        int measuredWidth;
        int measuredHeight;
        if (this.L != null) {
            return;
        }
        EdgeEffect a6 = this.H.a(this, 3);
        this.L = a6;
        if (this.f969g) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        a6.setSize(measuredWidth, measuredHeight);
    }

    boolean x0(AccessibilityEvent accessibilityEvent) {
        if (!T()) {
            return false;
        }
        int a6 = accessibilityEvent != null ? androidx.core.view.accessibility.b.a(accessibilityEvent) : 0;
        this.f1007z |= a6 != 0 ? a6 : 0;
        return true;
    }

    void y() {
        int measuredHeight;
        int measuredWidth;
        if (this.I != null) {
            return;
        }
        EdgeEffect a6 = this.H.a(this, 0);
        this.I = a6;
        if (this.f969g) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        a6.setSize(measuredHeight, measuredWidth);
    }

    public void y0(int i6, int i7) {
        z0(i6, i7, null);
    }

    void z() {
        int measuredHeight;
        int measuredWidth;
        if (this.K != null) {
            return;
        }
        EdgeEffect a6 = this.H.a(this, 2);
        this.K = a6;
        if (this.f969g) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        a6.setSize(measuredHeight, measuredWidth);
    }

    public void z0(int i6, int i7, Interpolator interpolator) {
        A0(i6, i7, interpolator, Integer.MIN_VALUE);
    }
}
