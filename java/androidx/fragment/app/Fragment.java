package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.a1;
import androidx.lifecycle.d;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

/* loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.i, y, androidx.savedstate.b {
    static final Object X = new Object();
    public static final /* synthetic */ int Y = 0;
    boolean A;
    boolean B;
    boolean C;
    private boolean E;
    ViewGroup F;
    View G;
    View H;
    boolean I;
    d K;
    boolean M;
    boolean N;
    float O;
    LayoutInflater P;
    boolean Q;
    androidx.lifecycle.j S;
    q T;
    androidx.savedstate.a V;
    private int W;

    /* renamed from: b, reason: collision with root package name */
    Bundle f562b;

    /* renamed from: c, reason: collision with root package name */
    SparseArray<Parcelable> f563c;

    /* renamed from: d, reason: collision with root package name */
    Boolean f564d;

    /* renamed from: f, reason: collision with root package name */
    Bundle f566f;

    /* renamed from: g, reason: collision with root package name */
    Fragment f567g;

    /* renamed from: i, reason: collision with root package name */
    int f569i;

    /* renamed from: k, reason: collision with root package name */
    boolean f571k;

    /* renamed from: l, reason: collision with root package name */
    boolean f572l;

    /* renamed from: m, reason: collision with root package name */
    boolean f573m;

    /* renamed from: n, reason: collision with root package name */
    boolean f574n;

    /* renamed from: o, reason: collision with root package name */
    boolean f575o;

    /* renamed from: p, reason: collision with root package name */
    boolean f576p;

    /* renamed from: q, reason: collision with root package name */
    int f577q;

    /* renamed from: r, reason: collision with root package name */
    i f578r;

    /* renamed from: s, reason: collision with root package name */
    g f579s;

    /* renamed from: u, reason: collision with root package name */
    Fragment f581u;

    /* renamed from: v, reason: collision with root package name */
    int f582v;

    /* renamed from: w, reason: collision with root package name */
    int f583w;

    /* renamed from: x, reason: collision with root package name */
    String f584x;

    /* renamed from: y, reason: collision with root package name */
    boolean f585y;

    /* renamed from: z, reason: collision with root package name */
    boolean f586z;

    /* renamed from: a, reason: collision with root package name */
    int f561a = 0;

    /* renamed from: e, reason: collision with root package name */
    String f565e = UUID.randomUUID().toString();

    /* renamed from: h, reason: collision with root package name */
    String f568h = null;

    /* renamed from: j, reason: collision with root package name */
    private Boolean f570j = null;

    /* renamed from: t, reason: collision with root package name */
    i f580t = new i();
    boolean D = true;
    boolean J = true;
    Runnable L = new a();
    d.c R = d.c.RESUMED;
    androidx.lifecycle.p<androidx.lifecycle.i> U = new androidx.lifecycle.p<>();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.i1();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.b();
        }
    }

    class c extends androidx.fragment.app.d {
        c() {
        }

        @Override // androidx.fragment.app.d
        public View c(int i6) {
            View view = Fragment.this.G;
            if (view != null) {
                return view.findViewById(i6);
            }
            throw new IllegalStateException("Fragment " + this + " does not have a view");
        }

        @Override // androidx.fragment.app.d
        public boolean e() {
            return Fragment.this.G != null;
        }
    }

    static class d {

        /* renamed from: a, reason: collision with root package name */
        View f591a;

        /* renamed from: b, reason: collision with root package name */
        Animator f592b;

        /* renamed from: c, reason: collision with root package name */
        int f593c;

        /* renamed from: d, reason: collision with root package name */
        int f594d;

        /* renamed from: e, reason: collision with root package name */
        int f595e;

        /* renamed from: f, reason: collision with root package name */
        int f596f;

        /* renamed from: g, reason: collision with root package name */
        Object f597g = null;

        /* renamed from: h, reason: collision with root package name */
        Object f598h;

        /* renamed from: i, reason: collision with root package name */
        Object f599i;

        /* renamed from: j, reason: collision with root package name */
        Object f600j;

        /* renamed from: k, reason: collision with root package name */
        Object f601k;

        /* renamed from: l, reason: collision with root package name */
        Object f602l;

        /* renamed from: m, reason: collision with root package name */
        Boolean f603m;

        /* renamed from: n, reason: collision with root package name */
        Boolean f604n;

        /* renamed from: o, reason: collision with root package name */
        boolean f605o;

        /* renamed from: p, reason: collision with root package name */
        f f606p;

        /* renamed from: q, reason: collision with root package name */
        boolean f607q;

        d() {
            Object obj = Fragment.X;
            this.f598h = obj;
            this.f599i = null;
            this.f600j = obj;
            this.f601k = null;
            this.f602l = obj;
        }
    }

    public static class e extends RuntimeException {
        public e(String str, Exception exc) {
            super(str, exc);
        }
    }

    interface f {
        void a();

        void b();
    }

    public Fragment() {
        J();
    }

    private void J() {
        this.S = new androidx.lifecycle.j(this);
        this.V = androidx.savedstate.a.a(this);
        this.S.a(new androidx.lifecycle.g() { // from class: androidx.fragment.app.Fragment.2
            @Override // androidx.lifecycle.g
            public void d(androidx.lifecycle.i iVar, d.b bVar) {
                View view;
                if (bVar != d.b.ON_STOP || (view = Fragment.this.G) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
    }

    @Deprecated
    public static Fragment L(Context context, String str, Bundle bundle) {
        try {
            Fragment newInstance = androidx.fragment.app.f.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.c1(bundle);
            }
            return newInstance;
        } catch (IllegalAccessException e6) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e6);
        } catch (InstantiationException e7) {
            throw new e("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e7);
        } catch (NoSuchMethodException e8) {
            throw new e("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e8);
        } catch (InvocationTargetException e9) {
            throw new e("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e9);
        }
    }

    private d e() {
        if (this.K == null) {
            this.K = new d();
        }
        return this.K;
    }

    public Object A() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f600j;
        return obj == X ? r() : obj;
    }

    void A0(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.f580t.u(configuration);
    }

    public final Resources B() {
        return W0().getResources();
    }

    boolean B0(MenuItem menuItem) {
        if (this.f585y) {
            return false;
        }
        return W(menuItem) || this.f580t.v(menuItem);
    }

    public final boolean C() {
        return this.A;
    }

    void C0(Bundle bundle) {
        this.f580t.N0();
        this.f561a = 1;
        this.E = false;
        this.V.c(bundle);
        X(bundle);
        this.Q = true;
        if (this.E) {
            this.S.h(d.b.ON_CREATE);
            return;
        }
        throw new r("Fragment " + this + " did not call through to super.onCreate()");
    }

    public Object D() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f598h;
        return obj == X ? p() : obj;
    }

    boolean D0(Menu menu, MenuInflater menuInflater) {
        boolean z5 = false;
        if (this.f585y) {
            return false;
        }
        if (this.C && this.D) {
            a0(menu, menuInflater);
            z5 = true;
        }
        return z5 | this.f580t.x(menu, menuInflater);
    }

    public Object E() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        return dVar.f601k;
    }

    void E0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f580t.N0();
        this.f576p = true;
        this.T = new q();
        View b02 = b0(layoutInflater, viewGroup, bundle);
        this.G = b02;
        if (b02 != null) {
            this.T.c();
            this.U.k(this.T);
        } else {
            if (this.T.d()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.T = null;
        }
    }

    public Object F() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        Object obj = dVar.f602l;
        return obj == X ? E() : obj;
    }

    void F0() {
        this.f580t.y();
        this.S.h(d.b.ON_DESTROY);
        this.f561a = 0;
        this.E = false;
        this.Q = false;
        c0();
        if (this.E) {
            return;
        }
        throw new r("Fragment " + this + " did not call through to super.onDestroy()");
    }

    int G() {
        d dVar = this.K;
        if (dVar == null) {
            return 0;
        }
        return dVar.f593c;
    }

    void G0() {
        this.f580t.z();
        if (this.G != null) {
            this.T.b(d.b.ON_DESTROY);
        }
        this.f561a = 1;
        this.E = false;
        e0();
        if (this.E) {
            androidx.loader.app.a.b(this).c();
            this.f576p = false;
        } else {
            throw new r("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    public final Fragment H() {
        String str;
        Fragment fragment = this.f567g;
        if (fragment != null) {
            return fragment;
        }
        i iVar = this.f578r;
        if (iVar == null || (str = this.f568h) == null) {
            return null;
        }
        return iVar.f650g.get(str);
    }

    void H0() {
        this.E = false;
        f0();
        this.P = null;
        if (this.E) {
            if (this.f580t.y0()) {
                return;
            }
            this.f580t.y();
            this.f580t = new i();
            return;
        }
        throw new r("Fragment " + this + " did not call through to super.onDetach()");
    }

    public View I() {
        return this.G;
    }

    LayoutInflater I0(Bundle bundle) {
        LayoutInflater g02 = g0(bundle);
        this.P = g02;
        return g02;
    }

    void J0() {
        onLowMemory();
        this.f580t.A();
    }

    void K() {
        J();
        this.f565e = UUID.randomUUID().toString();
        this.f571k = false;
        this.f572l = false;
        this.f573m = false;
        this.f574n = false;
        this.f575o = false;
        this.f577q = 0;
        this.f578r = null;
        this.f580t = new i();
        this.f579s = null;
        this.f582v = 0;
        this.f583w = 0;
        this.f584x = null;
        this.f585y = false;
        this.f586z = false;
    }

    void K0(boolean z5) {
        k0(z5);
        this.f580t.B(z5);
    }

    boolean L0(MenuItem menuItem) {
        if (this.f585y) {
            return false;
        }
        return (this.C && this.D && l0(menuItem)) || this.f580t.Q(menuItem);
    }

    boolean M() {
        d dVar = this.K;
        if (dVar == null) {
            return false;
        }
        return dVar.f607q;
    }

    void M0(Menu menu) {
        if (this.f585y) {
            return;
        }
        if (this.C && this.D) {
            m0(menu);
        }
        this.f580t.R(menu);
    }

    final boolean N() {
        return this.f577q > 0;
    }

    void N0() {
        this.f580t.T();
        if (this.G != null) {
            this.T.b(d.b.ON_PAUSE);
        }
        this.S.h(d.b.ON_PAUSE);
        this.f561a = 3;
        this.E = false;
        n0();
        if (this.E) {
            return;
        }
        throw new r("Fragment " + this + " did not call through to super.onPause()");
    }

    boolean O() {
        d dVar = this.K;
        if (dVar == null) {
            return false;
        }
        return dVar.f605o;
    }

    void O0(boolean z5) {
        o0(z5);
        this.f580t.U(z5);
    }

    public final boolean P() {
        i iVar = this.f578r;
        if (iVar == null) {
            return false;
        }
        return iVar.C0();
    }

    boolean P0(Menu menu) {
        boolean z5 = false;
        if (this.f585y) {
            return false;
        }
        if (this.C && this.D) {
            p0(menu);
            z5 = true;
        }
        return z5 | this.f580t.V(menu);
    }

    void Q() {
        this.f580t.N0();
    }

    void Q0() {
        boolean A0 = this.f578r.A0(this);
        Boolean bool = this.f570j;
        if (bool == null || bool.booleanValue() != A0) {
            this.f570j = Boolean.valueOf(A0);
            q0(A0);
            this.f580t.W();
        }
    }

    public void R(Bundle bundle) {
        this.E = true;
    }

    void R0() {
        this.f580t.N0();
        this.f580t.f0();
        this.f561a = 4;
        this.E = false;
        s0();
        if (!this.E) {
            throw new r("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.j jVar = this.S;
        d.b bVar = d.b.ON_RESUME;
        jVar.h(bVar);
        if (this.G != null) {
            this.T.b(bVar);
        }
        this.f580t.X();
        this.f580t.f0();
    }

    public void S(int i6, int i7, Intent intent) {
    }

    void S0(Bundle bundle) {
        t0(bundle);
        this.V.d(bundle);
        Parcelable Z0 = this.f580t.Z0();
        if (Z0 != null) {
            bundle.putParcelable("android:support:fragments", Z0);
        }
    }

    @Deprecated
    public void T(Activity activity) {
        this.E = true;
    }

    void T0() {
        this.f580t.N0();
        this.f580t.f0();
        this.f561a = 3;
        this.E = false;
        u0();
        if (!this.E) {
            throw new r("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.j jVar = this.S;
        d.b bVar = d.b.ON_START;
        jVar.h(bVar);
        if (this.G != null) {
            this.T.b(bVar);
        }
        this.f580t.Y();
    }

    public void U(Context context) {
        this.E = true;
        g gVar = this.f579s;
        Activity f6 = gVar == null ? null : gVar.f();
        if (f6 != null) {
            this.E = false;
            T(f6);
        }
    }

    void U0() {
        this.f580t.a0();
        if (this.G != null) {
            this.T.b(d.b.ON_STOP);
        }
        this.S.h(d.b.ON_STOP);
        this.f561a = 2;
        this.E = false;
        v0();
        if (this.E) {
            return;
        }
        throw new r("Fragment " + this + " did not call through to super.onStop()");
    }

    public void V(Fragment fragment) {
    }

    public final androidx.fragment.app.c V0() {
        androidx.fragment.app.c g6 = g();
        if (g6 != null) {
            return g6;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public boolean W(MenuItem menuItem) {
        return false;
    }

    public final Context W0() {
        Context o6 = o();
        if (o6 != null) {
            return o6;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public void X(Bundle bundle) {
        this.E = true;
        Y0(bundle);
        if (this.f580t.B0(1)) {
            return;
        }
        this.f580t.w();
    }

    public final View X0() {
        View I = I();
        if (I != null) {
            return I;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    public Animation Y(int i6, boolean z5, int i7) {
        return null;
    }

    void Y0(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.f580t.X0(parcelable);
        this.f580t.w();
    }

    public Animator Z(int i6, boolean z5, int i7) {
        return null;
    }

    final void Z0(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f563c;
        if (sparseArray != null) {
            this.H.restoreHierarchyState(sparseArray);
            this.f563c = null;
        }
        this.E = false;
        x0(bundle);
        if (this.E) {
            if (this.G != null) {
                this.T.b(d.b.ON_CREATE);
            }
        } else {
            throw new r("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    @Override // androidx.lifecycle.i
    public androidx.lifecycle.d a() {
        return this.S;
    }

    public void a0(Menu menu, MenuInflater menuInflater) {
    }

    void a1(View view) {
        e().f591a = view;
    }

    void b() {
        d dVar = this.K;
        f fVar = null;
        if (dVar != null) {
            dVar.f605o = false;
            f fVar2 = dVar.f606p;
            dVar.f606p = null;
            fVar = fVar2;
        }
        if (fVar != null) {
            fVar.a();
        }
    }

    public View b0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i6 = this.W;
        if (i6 != 0) {
            return layoutInflater.inflate(i6, viewGroup, false);
        }
        return null;
    }

    void b1(Animator animator) {
        e().f592b = animator;
    }

    public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f582v));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f583w));
        printWriter.print(" mTag=");
        printWriter.println(this.f584x);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f561a);
        printWriter.print(" mWho=");
        printWriter.print(this.f565e);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f577q);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f571k);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f572l);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f573m);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f574n);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f585y);
        printWriter.print(" mDetached=");
        printWriter.print(this.f586z);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.D);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.C);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.A);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.J);
        if (this.f578r != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f578r);
        }
        if (this.f579s != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f579s);
        }
        if (this.f581u != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f581u);
        }
        if (this.f566f != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f566f);
        }
        if (this.f562b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f562b);
        }
        if (this.f563c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f563c);
        }
        Fragment H = H();
        if (H != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(H);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f569i);
        }
        if (w() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(w());
        }
        if (this.F != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.F);
        }
        if (this.G != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.G);
        }
        if (this.H != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.G);
        }
        if (l() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(l());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(G());
        }
        if (o() != null) {
            androidx.loader.app.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f580t + ":");
        this.f580t.a(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public void c0() {
        this.E = true;
    }

    public void c1(Bundle bundle) {
        if (this.f578r != null && P()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f566f = bundle;
    }

    @Override // androidx.lifecycle.y
    public x d() {
        i iVar = this.f578r;
        if (iVar != null) {
            return iVar.v0(this);
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void d0() {
    }

    void d1(boolean z5) {
        e().f607q = z5;
    }

    public void e0() {
        this.E = true;
    }

    void e1(int i6) {
        if (this.K == null && i6 == 0) {
            return;
        }
        e().f594d = i6;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    Fragment f(String str) {
        return str.equals(this.f565e) ? this : this.f580t.l0(str);
    }

    public void f0() {
        this.E = true;
    }

    void f1(int i6, int i7) {
        if (this.K == null && i6 == 0 && i7 == 0) {
            return;
        }
        e();
        d dVar = this.K;
        dVar.f595e = i6;
        dVar.f596f = i7;
    }

    public final androidx.fragment.app.c g() {
        g gVar = this.f579s;
        if (gVar == null) {
            return null;
        }
        return (androidx.fragment.app.c) gVar.f();
    }

    public LayoutInflater g0(Bundle bundle) {
        return v(bundle);
    }

    void g1(f fVar) {
        e();
        d dVar = this.K;
        f fVar2 = dVar.f606p;
        if (fVar == fVar2) {
            return;
        }
        if (fVar != null && fVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (dVar.f605o) {
            dVar.f606p = fVar;
        }
        if (fVar != null) {
            fVar.b();
        }
    }

    public void h0(boolean z5) {
    }

    void h1(int i6) {
        e().f593c = i6;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry i() {
        return this.V.b();
    }

    @Deprecated
    public void i0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.E = true;
    }

    public void i1() {
        i iVar = this.f578r;
        if (iVar == null || iVar.f660q == null) {
            e().f605o = false;
        } else if (Looper.myLooper() != this.f578r.f660q.j().getLooper()) {
            this.f578r.f660q.j().postAtFrontOfQueue(new b());
        } else {
            b();
        }
    }

    public boolean j() {
        Boolean bool;
        d dVar = this.K;
        if (dVar == null || (bool = dVar.f604n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void j0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.E = true;
        g gVar = this.f579s;
        Activity f6 = gVar == null ? null : gVar.f();
        if (f6 != null) {
            this.E = false;
            i0(f6, attributeSet, bundle);
        }
    }

    public boolean k() {
        Boolean bool;
        d dVar = this.K;
        if (dVar == null || (bool = dVar.f603m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void k0(boolean z5) {
    }

    View l() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        return dVar.f591a;
    }

    public boolean l0(MenuItem menuItem) {
        return false;
    }

    Animator m() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        return dVar.f592b;
    }

    public void m0(Menu menu) {
    }

    public final h n() {
        if (this.f579s != null) {
            return this.f580t;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public void n0() {
        this.E = true;
    }

    public Context o() {
        g gVar = this.f579s;
        if (gVar == null) {
            return null;
        }
        return gVar.g();
    }

    public void o0(boolean z5) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.E = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        V0().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.E = true;
    }

    public Object p() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        return dVar.f597g;
    }

    public void p0(Menu menu) {
    }

    a1 q() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        dVar.getClass();
        return null;
    }

    public void q0(boolean z5) {
    }

    public Object r() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        return dVar.f599i;
    }

    public void r0(int i6, String[] strArr, int[] iArr) {
    }

    a1 s() {
        d dVar = this.K;
        if (dVar == null) {
            return null;
        }
        dVar.getClass();
        return null;
    }

    public void s0() {
        this.E = true;
    }

    public final h t() {
        return this.f578r;
    }

    public void t0(Bundle bundle) {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        androidx.core.util.b.a(this, sb);
        sb.append(" (");
        sb.append(this.f565e);
        sb.append(")");
        if (this.f582v != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f582v));
        }
        if (this.f584x != null) {
            sb.append(" ");
            sb.append(this.f584x);
        }
        sb.append('}');
        return sb.toString();
    }

    public final Object u() {
        g gVar = this.f579s;
        if (gVar == null) {
            return null;
        }
        return gVar.m();
    }

    public void u0() {
        this.E = true;
    }

    @Deprecated
    public LayoutInflater v(Bundle bundle) {
        g gVar = this.f579s;
        if (gVar == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater n6 = gVar.n();
        androidx.core.view.j.a(n6, this.f580t.t0());
        return n6;
    }

    public void v0() {
        this.E = true;
    }

    int w() {
        d dVar = this.K;
        if (dVar == null) {
            return 0;
        }
        return dVar.f594d;
    }

    public void w0(View view, Bundle bundle) {
    }

    int x() {
        d dVar = this.K;
        if (dVar == null) {
            return 0;
        }
        return dVar.f595e;
    }

    public void x0(Bundle bundle) {
        this.E = true;
    }

    int y() {
        d dVar = this.K;
        if (dVar == null) {
            return 0;
        }
        return dVar.f596f;
    }

    void y0(Bundle bundle) {
        this.f580t.N0();
        this.f561a = 2;
        this.E = false;
        R(bundle);
        if (this.E) {
            this.f580t.t();
            return;
        }
        throw new r("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public final Fragment z() {
        return this.f581u;
    }

    void z0() {
        this.f580t.k(this.f579s, new c(), this);
        this.E = false;
        U(this.f579s.g());
        if (this.E) {
            return;
        }
        throw new r("Fragment " + this + " did not call through to super.onAttach()");
    }
}
