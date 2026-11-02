package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.lifecycle.d;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
final class i extends androidx.fragment.app.h implements LayoutInflater.Factory2 {
    static boolean H = false;
    static final Interpolator I = new DecelerateInterpolator(2.5f);
    static final Interpolator J = new DecelerateInterpolator(1.5f);
    ArrayList<Boolean> A;
    ArrayList<Fragment> B;
    ArrayList<l> E;
    private androidx.fragment.app.k F;

    /* renamed from: c, reason: collision with root package name */
    ArrayList<k> f646c;

    /* renamed from: d, reason: collision with root package name */
    boolean f647d;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f651h;

    /* renamed from: i, reason: collision with root package name */
    ArrayList<Fragment> f652i;

    /* renamed from: j, reason: collision with root package name */
    private OnBackPressedDispatcher f653j;

    /* renamed from: l, reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f655l;

    /* renamed from: m, reason: collision with root package name */
    ArrayList<Integer> f656m;

    /* renamed from: n, reason: collision with root package name */
    ArrayList<h.a> f657n;

    /* renamed from: q, reason: collision with root package name */
    androidx.fragment.app.g f660q;

    /* renamed from: r, reason: collision with root package name */
    androidx.fragment.app.d f661r;

    /* renamed from: s, reason: collision with root package name */
    Fragment f662s;

    /* renamed from: t, reason: collision with root package name */
    Fragment f663t;

    /* renamed from: u, reason: collision with root package name */
    boolean f664u;

    /* renamed from: v, reason: collision with root package name */
    boolean f665v;

    /* renamed from: w, reason: collision with root package name */
    boolean f666w;

    /* renamed from: x, reason: collision with root package name */
    boolean f667x;

    /* renamed from: y, reason: collision with root package name */
    boolean f668y;

    /* renamed from: z, reason: collision with root package name */
    ArrayList<androidx.fragment.app.a> f669z;

    /* renamed from: e, reason: collision with root package name */
    int f648e = 0;

    /* renamed from: f, reason: collision with root package name */
    final ArrayList<Fragment> f649f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    final HashMap<String, Fragment> f650g = new HashMap<>();

    /* renamed from: k, reason: collision with root package name */
    private final androidx.activity.b f654k = new a(false);

    /* renamed from: o, reason: collision with root package name */
    private final CopyOnWriteArrayList<C0014i> f658o = new CopyOnWriteArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    int f659p = 0;
    Bundle C = null;
    SparseArray<Parcelable> D = null;
    Runnable G = new b();

    class a extends androidx.activity.b {
        a(boolean z5) {
            super(z5);
        }

        @Override // androidx.activity.b
        public void b() {
            i.this.w0();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.f0();
        }
    }

    class c implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f672a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Fragment f673b;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f673b.l() != null) {
                    c.this.f673b.a1(null);
                    c cVar = c.this;
                    i iVar = i.this;
                    Fragment fragment = cVar.f673b;
                    iVar.M0(fragment, fragment.G(), 0, 0, false);
                }
            }
        }

        c(ViewGroup viewGroup, Fragment fragment) {
            this.f672a = viewGroup;
            this.f673b = fragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f672a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f676a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f677b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f678c;

        d(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f676a = viewGroup;
            this.f677b = view;
            this.f678c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f676a.endViewTransition(this.f677b);
            Animator m6 = this.f678c.m();
            this.f678c.b1(null);
            if (m6 == null || this.f676a.indexOfChild(this.f677b) >= 0) {
                return;
            }
            i iVar = i.this;
            Fragment fragment = this.f678c;
            iVar.M0(fragment, fragment.G(), 0, 0, false);
        }
    }

    class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f680a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f681b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Fragment f682c;

        e(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f680a = viewGroup;
            this.f681b = view;
            this.f682c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f680a.endViewTransition(this.f681b);
            animator.removeListener(this);
            Fragment fragment = this.f682c;
            View view = fragment.G;
            if (view == null || !fragment.f585y) {
                return;
            }
            view.setVisibility(8);
        }
    }

    class f extends androidx.fragment.app.f {
        f() {
        }

        @Override // androidx.fragment.app.f
        public Fragment a(ClassLoader classLoader, String str) {
            androidx.fragment.app.g gVar = i.this.f660q;
            return gVar.b(gVar.g(), str, null);
        }
    }

    private static class g {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f685a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f686b;

        g(Animator animator) {
            this.f685a = null;
            this.f686b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        g(Animation animation) {
            this.f685a = animation;
            this.f686b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    private static class h extends AnimationSet implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final ViewGroup f687a;

        /* renamed from: b, reason: collision with root package name */
        private final View f688b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f689c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f690d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f691e;

        h(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f691e = true;
            this.f687a = viewGroup;
            this.f688b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j6, Transformation transformation) {
            this.f691e = true;
            if (this.f689c) {
                return !this.f690d;
            }
            if (!super.getTransformation(j6, transformation)) {
                this.f689c = true;
                androidx.core.view.q.a(this.f687a, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j6, Transformation transformation, float f6) {
            this.f691e = true;
            if (this.f689c) {
                return !this.f690d;
            }
            if (!super.getTransformation(j6, transformation, f6)) {
                this.f689c = true;
                androidx.core.view.q.a(this.f687a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f689c || !this.f691e) {
                this.f687a.endViewTransition(this.f688b);
                this.f690d = true;
            } else {
                this.f691e = false;
                this.f687a.post(this);
            }
        }
    }

    /* renamed from: androidx.fragment.app.i$i, reason: collision with other inner class name */
    private static final class C0014i {

        /* renamed from: a, reason: collision with root package name */
        final boolean f692a;
    }

    static class j {

        /* renamed from: a, reason: collision with root package name */
        public static final int[] f693a = {R.attr.name, R.attr.id, R.attr.tag};
    }

    interface k {
        boolean a(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    static class l implements Fragment.f {

        /* renamed from: a, reason: collision with root package name */
        final boolean f694a;

        /* renamed from: b, reason: collision with root package name */
        final androidx.fragment.app.a f695b;

        /* renamed from: c, reason: collision with root package name */
        private int f696c;

        l(androidx.fragment.app.a aVar, boolean z5) {
            this.f694a = z5;
            this.f695b = aVar;
        }

        @Override // androidx.fragment.app.Fragment.f
        public void a() {
            int i6 = this.f696c - 1;
            this.f696c = i6;
            if (i6 != 0) {
                return;
            }
            this.f695b.f608s.c1();
        }

        @Override // androidx.fragment.app.Fragment.f
        public void b() {
            this.f696c++;
        }

        public void c() {
            androidx.fragment.app.a aVar = this.f695b;
            aVar.f608s.q(aVar, this.f694a, false, false);
        }

        public void d() {
            boolean z5 = this.f696c > 0;
            i iVar = this.f695b.f608s;
            int size = iVar.f649f.size();
            for (int i6 = 0; i6 < size; i6++) {
                Fragment fragment = iVar.f649f.get(i6);
                fragment.g1(null);
                if (z5 && fragment.O()) {
                    fragment.i1();
                }
            }
            androidx.fragment.app.a aVar = this.f695b;
            aVar.f608s.q(aVar, this.f694a, !z5, true);
        }

        public boolean e() {
            return this.f696c == 0;
        }
    }

    i() {
    }

    static g F0(float f6, float f7) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f6, f7);
        alphaAnimation.setInterpolator(J);
        alphaAnimation.setDuration(220L);
        return new g(alphaAnimation);
    }

    static g H0(float f6, float f7, float f8, float f9) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f6, f7, f6, f7, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(I);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f8, f9);
        alphaAnimation.setInterpolator(J);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new g(animationSet);
    }

    private void I0(f.b<Fragment> bVar) {
        int size = bVar.size();
        for (int i6 = 0; i6 < size; i6++) {
            Fragment i7 = bVar.i(i6);
            if (!i7.f571k) {
                View X0 = i7.X0();
                i7.O = X0.getAlpha();
                X0.setAlpha(0.0f);
            }
        }
    }

    private boolean P0(String str, int i6, int i7) {
        f0();
        d0(true);
        Fragment fragment = this.f663t;
        if (fragment != null && i6 < 0 && str == null && fragment.n().d()) {
            return true;
        }
        boolean Q0 = Q0(this.f669z, this.A, str, i6, i7);
        if (Q0) {
            this.f647d = true;
            try {
                U0(this.f669z, this.A);
            } finally {
                p();
            }
        }
        k1();
        b0();
        m();
        return Q0;
    }

    private int R0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i6, int i7, f.b<Fragment> bVar) {
        int i8 = i7;
        for (int i9 = i7 - 1; i9 >= i6; i9--) {
            androidx.fragment.app.a aVar = arrayList.get(i9);
            boolean booleanValue = arrayList2.get(i9).booleanValue();
            if (aVar.m() && !aVar.k(arrayList, i9 + 1, i7)) {
                if (this.E == null) {
                    this.E = new ArrayList<>();
                }
                l lVar = new l(aVar, booleanValue);
                this.E.add(lVar);
                aVar.o(lVar);
                if (booleanValue) {
                    aVar.f();
                } else {
                    aVar.g(false);
                }
                i8--;
                if (i9 != i8) {
                    arrayList.remove(i9);
                    arrayList.add(i8, aVar);
                }
                f(bVar);
            }
        }
        return i8;
    }

    private void S(Fragment fragment) {
        if (fragment == null || this.f650g.get(fragment.f565e) != fragment) {
            return;
        }
        fragment.Q0();
    }

    private void U0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        i0(arrayList, arrayList2);
        int size = arrayList.size();
        int i6 = 0;
        int i7 = 0;
        while (i6 < size) {
            if (!arrayList.get(i6).f739q) {
                if (i7 != i6) {
                    h0(arrayList, arrayList2, i7, i6);
                }
                i7 = i6 + 1;
                if (arrayList2.get(i6).booleanValue()) {
                    while (i7 < size && arrayList2.get(i7).booleanValue() && !arrayList.get(i7).f739q) {
                        i7++;
                    }
                }
                h0(arrayList, arrayList2, i6, i7);
                i6 = i7 - 1;
            }
            i6++;
        }
        if (i7 != size) {
            h0(arrayList, arrayList2, i7, size);
        }
    }

    public static int Y0(int i6) {
        if (i6 == 4097) {
            return 8194;
        }
        if (i6 != 4099) {
            return i6 != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    private void Z(int i6) {
        try {
            this.f647d = true;
            K0(i6, false);
            this.f647d = false;
            f0();
        } catch (Throwable th) {
            this.f647d = false;
            throw th;
        }
    }

    private void c0() {
        for (Fragment fragment : this.f650g.values()) {
            if (fragment != null) {
                if (fragment.l() != null) {
                    int G = fragment.G();
                    View l6 = fragment.l();
                    Animation animation = l6.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        l6.clearAnimation();
                    }
                    fragment.a1(null);
                    M0(fragment, G, 0, 0, false);
                } else if (fragment.m() != null) {
                    fragment.m().end();
                }
            }
        }
    }

    private void d0(boolean z5) {
        if (this.f647d) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f660q == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.f660q.j().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z5) {
            o();
        }
        if (this.f669z == null) {
            this.f669z = new ArrayList<>();
            this.A = new ArrayList<>();
        }
        this.f647d = true;
        try {
            i0(null, null);
        } finally {
            this.f647d = false;
        }
    }

    private void f(f.b<Fragment> bVar) {
        int i6 = this.f659p;
        if (i6 < 1) {
            return;
        }
        int min = Math.min(i6, 3);
        int size = this.f649f.size();
        for (int i7 = 0; i7 < size; i7++) {
            Fragment fragment = this.f649f.get(i7);
            if (fragment.f561a < min) {
                M0(fragment, min, fragment.w(), fragment.x(), false);
                if (fragment.G != null && !fragment.f585y && fragment.M) {
                    bVar.add(fragment);
                }
            }
        }
    }

    private static void g0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i6, int i7) {
        while (i6 < i7) {
            androidx.fragment.app.a aVar = arrayList.get(i6);
            if (arrayList2.get(i6).booleanValue()) {
                aVar.c(-1);
                aVar.g(i6 == i7 + (-1));
            } else {
                aVar.c(1);
                aVar.f();
            }
            i6++;
        }
    }

    private void h0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, int i6, int i7) {
        int i8;
        int i9;
        int i10 = i6;
        boolean z5 = arrayList.get(i10).f739q;
        ArrayList<Fragment> arrayList3 = this.B;
        if (arrayList3 == null) {
            this.B = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.B.addAll(this.f649f);
        Fragment u02 = u0();
        boolean z6 = false;
        for (int i11 = i10; i11 < i7; i11++) {
            androidx.fragment.app.a aVar = arrayList.get(i11);
            u02 = !arrayList2.get(i11).booleanValue() ? aVar.h(this.B, u02) : aVar.p(this.B, u02);
            z6 = z6 || aVar.f730h;
        }
        this.B.clear();
        if (!z5) {
            n.B(this, arrayList, arrayList2, i6, i7, false);
        }
        g0(arrayList, arrayList2, i6, i7);
        if (z5) {
            f.b<Fragment> bVar = new f.b<>();
            f(bVar);
            int R0 = R0(arrayList, arrayList2, i6, i7, bVar);
            I0(bVar);
            i8 = R0;
        } else {
            i8 = i7;
        }
        if (i8 != i10 && z5) {
            n.B(this, arrayList, arrayList2, i6, i8, true);
            K0(this.f659p, true);
        }
        while (i10 < i7) {
            androidx.fragment.app.a aVar2 = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue() && (i9 = aVar2.f610u) >= 0) {
                o0(i9);
                aVar2.f610u = -1;
            }
            aVar2.n();
            i10++;
        }
        if (z6) {
            W0();
        }
    }

    private void i0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<l> arrayList3 = this.E;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i6 = 0;
        while (i6 < size) {
            l lVar = this.E.get(i6);
            if (arrayList == null || lVar.f694a || (indexOf2 = arrayList.indexOf(lVar.f695b)) == -1 || !arrayList2.get(indexOf2).booleanValue()) {
                if (lVar.e() || (arrayList != null && lVar.f695b.k(arrayList, 0, arrayList.size()))) {
                    this.E.remove(i6);
                    i6--;
                    size--;
                    if (arrayList == null || lVar.f694a || (indexOf = arrayList.indexOf(lVar.f695b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                        lVar.d();
                    }
                }
                i6++;
            } else {
                this.E.remove(i6);
                i6--;
                size--;
            }
            lVar.c();
            i6++;
        }
    }

    private void i1(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new androidx.core.util.c("FragmentManager"));
        androidx.fragment.app.g gVar = this.f660q;
        try {
            if (gVar != null) {
                gVar.l("  ", null, printWriter, new String[0]);
            } else {
                a("  ", null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception e6) {
            Log.e("FragmentManager", "Failed dumping state", e6);
            throw runtimeException;
        }
    }

    private void j(Fragment fragment, g gVar, int i6) {
        View view = fragment.G;
        ViewGroup viewGroup = fragment.F;
        viewGroup.startViewTransition(view);
        fragment.h1(i6);
        if (gVar.f685a != null) {
            h hVar = new h(gVar.f685a, viewGroup, view);
            fragment.a1(fragment.G);
            hVar.setAnimationListener(new c(viewGroup, fragment));
            fragment.G.startAnimation(hVar);
            return;
        }
        Animator animator = gVar.f686b;
        fragment.b1(animator);
        animator.addListener(new d(viewGroup, view, fragment));
        animator.setTarget(fragment.G);
        animator.start();
    }

    public static int j1(int i6, boolean z5) {
        if (i6 == 4097) {
            return z5 ? 1 : 2;
        }
        if (i6 == 4099) {
            return z5 ? 5 : 6;
        }
        if (i6 != 8194) {
            return -1;
        }
        return z5 ? 3 : 4;
    }

    private void k1() {
        ArrayList<k> arrayList = this.f646c;
        if (arrayList == null || arrayList.isEmpty()) {
            this.f654k.f(q0() > 0 && A0(this.f662s));
        } else {
            this.f654k.f(true);
        }
    }

    private void m() {
        this.f650g.values().removeAll(Collections.singleton(null));
    }

    private Fragment m0(Fragment fragment) {
        ViewGroup viewGroup = fragment.F;
        View view = fragment.G;
        if (viewGroup != null && view != null) {
            for (int indexOf = this.f649f.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.f649f.get(indexOf);
                if (fragment2.F == viewGroup && fragment2.G != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    private void n0() {
        if (this.E != null) {
            while (!this.E.isEmpty()) {
                this.E.remove(0).d();
            }
        }
    }

    private void o() {
        if (C0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    private void p() {
        this.f647d = false;
        this.A.clear();
        this.f669z.clear();
    }

    private boolean p0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            ArrayList<k> arrayList3 = this.f646c;
            if (arrayList3 != null && arrayList3.size() != 0) {
                int size = this.f646c.size();
                boolean z5 = false;
                for (int i6 = 0; i6 < size; i6++) {
                    z5 |= this.f646c.get(i6).a(arrayList, arrayList2);
                }
                this.f646c.clear();
                this.f660q.j().removeCallbacks(this.G);
                return z5;
            }
            return false;
        }
    }

    private boolean z0(Fragment fragment) {
        return (fragment.C && fragment.D) || fragment.f580t.n();
    }

    public void A() {
        for (int i6 = 0; i6 < this.f649f.size(); i6++) {
            Fragment fragment = this.f649f.get(i6);
            if (fragment != null) {
                fragment.J0();
            }
        }
    }

    boolean A0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        i iVar = fragment.f578r;
        return fragment == iVar.u0() && A0(iVar.f662s);
    }

    public void B(boolean z5) {
        for (int size = this.f649f.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f649f.get(size);
            if (fragment != null) {
                fragment.K0(z5);
            }
        }
    }

    boolean B0(int i6) {
        return this.f659p >= i6;
    }

    void C(Fragment fragment, Bundle bundle, boolean z5) {
        Fragment fragment2 = this.f662s;
        if (fragment2 != null) {
            androidx.fragment.app.h t5 = fragment2.t();
            if (t5 instanceof i) {
                ((i) t5).C(fragment, bundle, true);
            }
        }
        Iterator<C0014i> it = this.f658o.iterator();
        while (it.hasNext()) {
            C0014i next = it.next();
            if (!z5 || next.f692a) {
                next.getClass();
                throw null;
            }
        }
    }

    public boolean C0() {
        return this.f665v || this.f666w;
    }

    void D(Fragment fragment, Context context, boolean z5) {
        Fragment fragment2 = this.f662s;
        if (fragment2 != null) {
            androidx.fragment.app.h t5 = fragment2.t();
            if (t5 instanceof i) {
                ((i) t5).D(fragment, context, true);
            }
        }
        Iterator<C0014i> it = this.f658o.iterator();
        while (it.hasNext()) {
            C0014i next = it.next();
            if (!z5 || next.f692a) {
                next.getClass();
                throw null;
            }
        }
    }

    g D0(Fragment fragment, int i6, boolean z5, int i7) {
        int j12;
        int w5 = fragment.w();
        boolean z6 = false;
        fragment.e1(0);
        ViewGroup viewGroup = fragment.F;
        if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
            return null;
        }
        Animation Y = fragment.Y(i6, z5, w5);
        if (Y != null) {
            return new g(Y);
        }
        Animator Z = fragment.Z(i6, z5, w5);
        if (Z != null) {
            return new g(Z);
        }
        if (w5 != 0) {
            boolean equals = "anim".equals(this.f660q.g().getResources().getResourceTypeName(w5));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.f660q.g(), w5);
                    if (loadAnimation != null) {
                        return new g(loadAnimation);
                    }
                    z6 = true;
                } catch (Resources.NotFoundException e6) {
                    throw e6;
                } catch (RuntimeException unused) {
                }
            }
            if (!z6) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.f660q.g(), w5);
                    if (loadAnimator != null) {
                        return new g(loadAnimator);
                    }
                } catch (RuntimeException e7) {
                    if (equals) {
                        throw e7;
                    }
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f660q.g(), w5);
                    if (loadAnimation2 != null) {
                        return new g(loadAnimation2);
                    }
                }
            }
        }
        if (i6 == 0 || (j12 = j1(i6, z5)) < 0) {
            return null;
        }
        switch (j12) {
            case 1:
                return H0(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return H0(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return H0(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return H0(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return F0(0.0f, 1.0f);
            case 6:
                return F0(1.0f, 0.0f);
            default:
                if (i7 == 0 && this.f660q.p()) {
                    this.f660q.o();
                }
                return null;
        }
    }

    void E(Fragment fragment, Bundle bundle, boolean z5) {
        Fragment fragment2 = this.f662s;
        if (fragment2 != null) {
            androidx.fragment.app.h t5 = fragment2.t();
            if (t5 instanceof i) {
                ((i) t5).E(fragment, bundle, true);
            }
        }
        Iterator<C0014i> it = this.f658o.iterator();
        while (it.hasNext()) {
            C0014i next = it.next();
            if (!z5 || next.f692a) {
                next.getClass();
                throw null;
            }
        }
    }

    void E0(Fragment fragment) {
        if (this.f650g.get(fragment.f565e) != null) {
            return;
        }
        this.f650g.put(fragment.f565e, fragment);
        if (fragment.B) {
            if (fragment.A) {
                i(fragment);
            } else {
                V0(fragment);
            }
            fragment.B = false;
        }
        if (H) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    void F(Fragment fragment, boolean z5) {
        Fragment fragment2 = this.f662s;
        if (fragment2 != null) {
            androidx.fragment.app.h t5 = fragment2.t();
            if (t5 instanceof i) {
                ((i) t5).F(fragment, true);
            }
        }
        Iterator<C0014i> it = this.f658o.iterator();
        while (it.hasNext()) {
            C0014i next = it.next();
            if (!z5 || next.f692a) {
                next.getClass();
                throw null;
            }
        }
    }

    void G(Fragment fragment, boolean z5) {
        Fragment fragment2 = this.f662s;
        if (fragment2 != null) {
            androidx.fragment.app.h t5 = fragment2.t();
            if (t5 instanceof i) {
                ((i) t5).G(fragment, true);
            }
        }
        Iterator<C0014i> it = this.f658o.iterator();
        while (it.hasNext()) {
            C0014i next = it.next();
            if (!z5 || next.f692a) {
                next.getClass();
                throw null;
            }
        }
    }

    void G0(Fragment fragment) {
        if (this.f650g.get(fragment.f565e) == null) {
            return;
        }
        if (H) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
        for (Fragment fragment2 : this.f650g.values()) {
            if (fragment2 != null && fragment.f565e.equals(fragment2.f568h)) {
                fragment2.f567g = fragment;
                fragment2.f568h = null;
            }
        }
        this.f650g.put(fragment.f565e, null);
        V0(fragment);
        String str = fragment.f568h;
        if (str != null) {
            fragment.f567g = this.f650g.get(str);
        }
        fragment.K();
    }

    void H(Fragment fragment, boolean z5) {
        Fragment fragment2 = this.f662s;
        if (fragment2 != null) {
            androidx.fragment.app.h t5 = fragment2.t();
            if (t5 instanceof i) {
                ((i) t5).H(fragment, true);
            }
        }
        Iterator<C0014i> it = this.f658o.iterator();
        while (it.hasNext()) {
            C0014i next = it.next();
            if (!z5 || next.f692a) {
                next.getClass();
                throw null;
            }
        }
    }

    void I(Fragment fragment, Context context, boolean z5) {
        Fragment fragment2 = this.f662s;
        if (fragment2 != null) {
            androidx.fragment.app.h t5 = fragment2.t();
            if (t5 instanceof i) {
                ((i) t5).I(fragment, context, true);
            }
        }
        Iterator<C0014i> it = this.f658o.iterator();
        while (it.hasNext()) {
            C0014i next = it.next();
            if (!z5 || next.f692a) {
                next.getClass();
                throw null;
            }
        }
    }

    void J(Fragment fragment, Bundle bundle, boolean z5) {
        Fragment fragment2 = this.f662s;
        if (fragment2 != null) {
            androidx.fragment.app.h t5 = fragment2.t();
            if (t5 instanceof i) {
                ((i) t5).J(fragment, bundle, true);
            }
        }
        Iterator<C0014i> it = this.f658o.iterator();
        while (it.hasNext()) {
            C0014i next = it.next();
            if (!z5 || next.f692a) {
                next.getClass();
                throw null;
            }
        }
    }

    void J0(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        if (!this.f650g.containsKey(fragment.f565e)) {
            if (H) {
                Log.v("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f659p + "since it is not added to " + this);
                return;
            }
            return;
        }
        int i6 = this.f659p;
        if (fragment.f572l) {
            i6 = fragment.N() ? Math.min(i6, 1) : Math.min(i6, 0);
        }
        M0(fragment, i6, fragment.x(), fragment.y(), false);
        if (fragment.G != null) {
            Fragment m02 = m0(fragment);
            if (m02 != null) {
                View view = m02.G;
                ViewGroup viewGroup = fragment.F;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(fragment.G);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.G, indexOfChild);
                }
            }
            if (fragment.M && fragment.F != null) {
                float f6 = fragment.O;
                if (f6 > 0.0f) {
                    fragment.G.setAlpha(f6);
                }
                fragment.O = 0.0f;
                fragment.M = false;
                g D0 = D0(fragment, fragment.x(), true, fragment.y());
                if (D0 != null) {
                    Animation animation = D0.f685a;
                    if (animation != null) {
                        fragment.G.startAnimation(animation);
                    } else {
                        D0.f686b.setTarget(fragment.G);
                        D0.f686b.start();
                    }
                }
            }
        }
        if (fragment.N) {
            r(fragment);
        }
    }

    void K(Fragment fragment, boolean z5) {
        Fragment fragment2 = this.f662s;
        if (fragment2 != null) {
            androidx.fragment.app.h t5 = fragment2.t();
            if (t5 instanceof i) {
                ((i) t5).K(fragment, true);
            }
        }
        Iterator<C0014i> it = this.f658o.iterator();
        while (it.hasNext()) {
            C0014i next = it.next();
            if (!z5 || next.f692a) {
                next.getClass();
                throw null;
            }
        }
    }

    void K0(int i6, boolean z5) {
        androidx.fragment.app.g gVar;
        if (this.f660q == null && i6 != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z5 || i6 != this.f659p) {
            this.f659p = i6;
            int size = this.f649f.size();
            for (int i7 = 0; i7 < size; i7++) {
                J0(this.f649f.get(i7));
            }
            for (Fragment fragment : this.f650g.values()) {
                if (fragment != null && (fragment.f572l || fragment.f586z)) {
                    if (!fragment.M) {
                        J0(fragment);
                    }
                }
            }
            h1();
            if (this.f664u && (gVar = this.f660q) != null && this.f659p == 4) {
                gVar.r();
                this.f664u = false;
            }
        }
    }

    void L(Fragment fragment, Bundle bundle, boolean z5) {
        Fragment fragment2 = this.f662s;
        if (fragment2 != null) {
            androidx.fragment.app.h t5 = fragment2.t();
            if (t5 instanceof i) {
                ((i) t5).L(fragment, bundle, true);
            }
        }
        Iterator<C0014i> it = this.f658o.iterator();
        while (it.hasNext()) {
            C0014i next = it.next();
            if (!z5 || next.f692a) {
                next.getClass();
                throw null;
            }
        }
    }

    void L0(Fragment fragment) {
        M0(fragment, this.f659p, 0, 0, false);
    }

    void M(Fragment fragment, boolean z5) {
        Fragment fragment2 = this.f662s;
        if (fragment2 != null) {
            androidx.fragment.app.h t5 = fragment2.t();
            if (t5 instanceof i) {
                ((i) t5).M(fragment, true);
            }
        }
        Iterator<C0014i> it = this.f658o.iterator();
        while (it.hasNext()) {
            C0014i next = it.next();
            if (!z5 || next.f692a) {
                next.getClass();
                throw null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0084, code lost:
    
        if (r0 != 3) goto L265;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void M0(androidx.fragment.app.Fragment r19, int r20, int r21, int r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 1282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.i.M0(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    void N(Fragment fragment, boolean z5) {
        Fragment fragment2 = this.f662s;
        if (fragment2 != null) {
            androidx.fragment.app.h t5 = fragment2.t();
            if (t5 instanceof i) {
                ((i) t5).N(fragment, true);
            }
        }
        Iterator<C0014i> it = this.f658o.iterator();
        while (it.hasNext()) {
            C0014i next = it.next();
            if (!z5 || next.f692a) {
                next.getClass();
                throw null;
            }
        }
    }

    public void N0() {
        this.f665v = false;
        this.f666w = false;
        int size = this.f649f.size();
        for (int i6 = 0; i6 < size; i6++) {
            Fragment fragment = this.f649f.get(i6);
            if (fragment != null) {
                fragment.Q();
            }
        }
    }

    void O(Fragment fragment, View view, Bundle bundle, boolean z5) {
        Fragment fragment2 = this.f662s;
        if (fragment2 != null) {
            androidx.fragment.app.h t5 = fragment2.t();
            if (t5 instanceof i) {
                ((i) t5).O(fragment, view, bundle, true);
            }
        }
        Iterator<C0014i> it = this.f658o.iterator();
        while (it.hasNext()) {
            C0014i next = it.next();
            if (!z5 || next.f692a) {
                next.getClass();
                throw null;
            }
        }
    }

    public void O0(Fragment fragment) {
        if (fragment.I) {
            if (this.f647d) {
                this.f668y = true;
            } else {
                fragment.I = false;
                M0(fragment, this.f659p, 0, 0, false);
            }
        }
    }

    void P(Fragment fragment, boolean z5) {
        Fragment fragment2 = this.f662s;
        if (fragment2 != null) {
            androidx.fragment.app.h t5 = fragment2.t();
            if (t5 instanceof i) {
                ((i) t5).P(fragment, true);
            }
        }
        Iterator<C0014i> it = this.f658o.iterator();
        while (it.hasNext()) {
            C0014i next = it.next();
            if (!z5 || next.f692a) {
                next.getClass();
                throw null;
            }
        }
    }

    public boolean Q(MenuItem menuItem) {
        if (this.f659p < 1) {
            return false;
        }
        for (int i6 = 0; i6 < this.f649f.size(); i6++) {
            Fragment fragment = this.f649f.get(i6);
            if (fragment != null && fragment.L0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    boolean Q0(ArrayList<androidx.fragment.app.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i6, int i7) {
        int i8;
        ArrayList<androidx.fragment.app.a> arrayList3 = this.f651h;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i6 < 0 && (i7 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f651h.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i6 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    androidx.fragment.app.a aVar = this.f651h.get(size2);
                    if ((str != null && str.equals(aVar.i())) || (i6 >= 0 && i6 == aVar.f610u)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i7 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        androidx.fragment.app.a aVar2 = this.f651h.get(size2);
                        if (str == null || !str.equals(aVar2.i())) {
                            if (i6 < 0 || i6 != aVar2.f610u) {
                                break;
                            }
                        }
                    }
                }
                i8 = size2;
            } else {
                i8 = -1;
            }
            if (i8 == this.f651h.size() - 1) {
                return false;
            }
            for (int size3 = this.f651h.size() - 1; size3 > i8; size3--) {
                arrayList.add(this.f651h.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public void R(Menu menu) {
        if (this.f659p < 1) {
            return;
        }
        for (int i6 = 0; i6 < this.f649f.size(); i6++) {
            Fragment fragment = this.f649f.get(i6);
            if (fragment != null) {
                fragment.M0(menu);
            }
        }
    }

    public void S0(Bundle bundle, String str, Fragment fragment) {
        if (fragment.f578r != this) {
            i1(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.f565e);
    }

    public void T() {
        Z(3);
    }

    public void T0(Fragment fragment) {
        if (H) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f577q);
        }
        boolean z5 = !fragment.N();
        if (!fragment.f586z || z5) {
            synchronized (this.f649f) {
                this.f649f.remove(fragment);
            }
            if (z0(fragment)) {
                this.f664u = true;
            }
            fragment.f571k = false;
            fragment.f572l = true;
        }
    }

    public void U(boolean z5) {
        for (int size = this.f649f.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f649f.get(size);
            if (fragment != null) {
                fragment.O0(z5);
            }
        }
    }

    public boolean V(Menu menu) {
        if (this.f659p < 1) {
            return false;
        }
        boolean z5 = false;
        for (int i6 = 0; i6 < this.f649f.size(); i6++) {
            Fragment fragment = this.f649f.get(i6);
            if (fragment != null && fragment.P0(menu)) {
                z5 = true;
            }
        }
        return z5;
    }

    void V0(Fragment fragment) {
        if (C0()) {
            if (H) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.F.k(fragment) && H) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    void W() {
        k1();
        S(this.f663t);
    }

    void W0() {
        if (this.f657n != null) {
            for (int i6 = 0; i6 < this.f657n.size(); i6++) {
                this.f657n.get(i6).onBackStackChanged();
            }
        }
    }

    public void X() {
        this.f665v = false;
        this.f666w = false;
        Z(4);
    }

    void X0(Parcelable parcelable) {
        androidx.fragment.app.l lVar;
        if (parcelable == null) {
            return;
        }
        androidx.fragment.app.j jVar = (androidx.fragment.app.j) parcelable;
        if (jVar.f697a == null) {
            return;
        }
        for (Fragment fragment : this.F.h()) {
            if (H) {
                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
            }
            Iterator<androidx.fragment.app.l> it = jVar.f697a.iterator();
            while (true) {
                if (it.hasNext()) {
                    lVar = it.next();
                    if (lVar.f710b.equals(fragment.f565e)) {
                        break;
                    }
                } else {
                    lVar = null;
                    break;
                }
            }
            if (lVar == null) {
                if (H) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + jVar.f697a);
                }
                M0(fragment, 1, 0, 0, false);
                fragment.f572l = true;
                M0(fragment, 0, 0, 0, false);
            } else {
                lVar.f722r = fragment;
                fragment.f563c = null;
                fragment.f577q = 0;
                fragment.f574n = false;
                fragment.f571k = false;
                Fragment fragment2 = fragment.f567g;
                fragment.f568h = fragment2 != null ? fragment2.f565e : null;
                fragment.f567g = null;
                Bundle bundle = lVar.f721q;
                if (bundle != null) {
                    bundle.setClassLoader(this.f660q.g().getClassLoader());
                    fragment.f563c = lVar.f721q.getSparseParcelableArray("android:view_state");
                    fragment.f562b = lVar.f721q;
                }
            }
        }
        this.f650g.clear();
        Iterator<androidx.fragment.app.l> it2 = jVar.f697a.iterator();
        while (it2.hasNext()) {
            androidx.fragment.app.l next = it2.next();
            if (next != null) {
                Fragment d6 = next.d(this.f660q.g().getClassLoader(), b());
                d6.f578r = this;
                if (H) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + d6.f565e + "): " + d6);
                }
                this.f650g.put(d6.f565e, d6);
                next.f722r = null;
            }
        }
        this.f649f.clear();
        ArrayList<String> arrayList = jVar.f698b;
        if (arrayList != null) {
            Iterator<String> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                String next2 = it3.next();
                Fragment fragment3 = this.f650g.get(next2);
                if (fragment3 == null) {
                    i1(new IllegalStateException("No instantiated fragment for (" + next2 + ")"));
                }
                fragment3.f571k = true;
                if (H) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + next2 + "): " + fragment3);
                }
                if (this.f649f.contains(fragment3)) {
                    throw new IllegalStateException("Already added " + fragment3);
                }
                synchronized (this.f649f) {
                    this.f649f.add(fragment3);
                }
            }
        }
        if (jVar.f699c != null) {
            this.f651h = new ArrayList<>(jVar.f699c.length);
            int i6 = 0;
            while (true) {
                androidx.fragment.app.b[] bVarArr = jVar.f699c;
                if (i6 >= bVarArr.length) {
                    break;
                }
                androidx.fragment.app.a d7 = bVarArr[i6].d(this);
                if (H) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i6 + " (index " + d7.f610u + "): " + d7);
                    PrintWriter printWriter = new PrintWriter(new androidx.core.util.c("FragmentManager"));
                    d7.e("  ", printWriter, false);
                    printWriter.close();
                }
                this.f651h.add(d7);
                int i7 = d7.f610u;
                if (i7 >= 0) {
                    d1(i7, d7);
                }
                i6++;
            }
        } else {
            this.f651h = null;
        }
        String str = jVar.f700d;
        if (str != null) {
            Fragment fragment4 = this.f650g.get(str);
            this.f663t = fragment4;
            S(fragment4);
        }
        this.f648e = jVar.f701e;
    }

    public void Y() {
        this.f665v = false;
        this.f666w = false;
        Z(3);
    }

    Parcelable Z0() {
        ArrayList<String> arrayList;
        int size;
        n0();
        c0();
        f0();
        this.f665v = true;
        androidx.fragment.app.b[] bVarArr = null;
        if (this.f650g.isEmpty()) {
            return null;
        }
        ArrayList<androidx.fragment.app.l> arrayList2 = new ArrayList<>(this.f650g.size());
        boolean z5 = false;
        for (Fragment fragment : this.f650g.values()) {
            if (fragment != null) {
                if (fragment.f578r != this) {
                    i1(new IllegalStateException("Failure saving state: active " + fragment + " was removed from the FragmentManager"));
                }
                androidx.fragment.app.l lVar = new androidx.fragment.app.l(fragment);
                arrayList2.add(lVar);
                if (fragment.f561a <= 0 || lVar.f721q != null) {
                    lVar.f721q = fragment.f562b;
                } else {
                    lVar.f721q = a1(fragment);
                    String str = fragment.f568h;
                    if (str != null) {
                        Fragment fragment2 = this.f650g.get(str);
                        if (fragment2 == null) {
                            i1(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.f568h));
                        }
                        if (lVar.f721q == null) {
                            lVar.f721q = new Bundle();
                        }
                        S0(lVar.f721q, "android:target_state", fragment2);
                        int i6 = fragment.f569i;
                        if (i6 != 0) {
                            lVar.f721q.putInt("android:target_req_state", i6);
                        }
                    }
                }
                if (H) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + lVar.f721q);
                }
                z5 = true;
            }
        }
        if (!z5) {
            if (H) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.f649f.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            Iterator<Fragment> it = this.f649f.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.f565e);
                if (next.f578r != this) {
                    i1(new IllegalStateException("Failure saving state: active " + next + " was removed from the FragmentManager"));
                }
                if (H) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.f565e + "): " + next);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<androidx.fragment.app.a> arrayList3 = this.f651h;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            bVarArr = new androidx.fragment.app.b[size];
            for (int i7 = 0; i7 < size; i7++) {
                bVarArr[i7] = new androidx.fragment.app.b(this.f651h.get(i7));
                if (H) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i7 + ": " + this.f651h.get(i7));
                }
            }
        }
        androidx.fragment.app.j jVar = new androidx.fragment.app.j();
        jVar.f697a = arrayList2;
        jVar.f698b = arrayList;
        jVar.f699c = bVarArr;
        Fragment fragment3 = this.f663t;
        if (fragment3 != null) {
            jVar.f700d = fragment3.f565e;
        }
        jVar.f701e = this.f648e;
        return jVar;
    }

    @Override // androidx.fragment.app.h
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.f650g.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment fragment : this.f650g.values()) {
                printWriter.print(str);
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.c(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.f649f.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i6 = 0; i6 < size5; i6++) {
                Fragment fragment2 = this.f649f.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<Fragment> arrayList = this.f652i;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i7 = 0; i7 < size4; i7++) {
                Fragment fragment3 = this.f652i.get(i7);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i7);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.f651h;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i8 = 0; i8 < size3; i8++) {
                androidx.fragment.app.a aVar = this.f651h.get(i8);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i8);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.d(str2, printWriter);
            }
        }
        synchronized (this) {
            ArrayList<androidx.fragment.app.a> arrayList3 = this.f655l;
            if (arrayList3 != null && (size2 = arrayList3.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i9 = 0; i9 < size2; i9++) {
                    Object obj = (androidx.fragment.app.a) this.f655l.get(i9);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i9);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            ArrayList<Integer> arrayList4 = this.f656m;
            if (arrayList4 != null && arrayList4.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f656m.toArray()));
            }
        }
        ArrayList<k> arrayList5 = this.f646c;
        if (arrayList5 != null && (size = arrayList5.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i10 = 0; i10 < size; i10++) {
                Object obj2 = (k) this.f646c.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f660q);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f661r);
        if (this.f662s != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f662s);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f659p);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f665v);
        printWriter.print(" mStopped=");
        printWriter.print(this.f666w);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f667x);
        if (this.f664u) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f664u);
        }
    }

    public void a0() {
        this.f666w = true;
        Z(2);
    }

    Bundle a1(Fragment fragment) {
        if (this.C == null) {
            this.C = new Bundle();
        }
        fragment.S0(this.C);
        L(fragment, this.C, false);
        Bundle bundle = null;
        if (!this.C.isEmpty()) {
            Bundle bundle2 = this.C;
            this.C = null;
            bundle = bundle2;
        }
        if (fragment.G != null) {
            b1(fragment);
        }
        if (fragment.f563c != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f563c);
        }
        if (!fragment.J) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.J);
        }
        return bundle;
    }

    @Override // androidx.fragment.app.h
    public androidx.fragment.app.f b() {
        if (super.b() == androidx.fragment.app.h.f644b) {
            Fragment fragment = this.f662s;
            if (fragment != null) {
                return fragment.f578r.b();
            }
            e(new f());
        }
        return super.b();
    }

    void b0() {
        if (this.f668y) {
            this.f668y = false;
            h1();
        }
    }

    void b1(Fragment fragment) {
        if (fragment.H == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.D;
        if (sparseArray == null) {
            this.D = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.H.saveHierarchyState(this.D);
        if (this.D.size() > 0) {
            fragment.f563c = this.D;
            this.D = null;
        }
    }

    @Override // androidx.fragment.app.h
    public List<Fragment> c() {
        List<Fragment> list;
        if (this.f649f.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f649f) {
            list = (List) this.f649f.clone();
        }
        return list;
    }

    void c1() {
        synchronized (this) {
            ArrayList<l> arrayList = this.E;
            boolean z5 = false;
            boolean z6 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            ArrayList<k> arrayList2 = this.f646c;
            if (arrayList2 != null && arrayList2.size() == 1) {
                z5 = true;
            }
            if (z6 || z5) {
                this.f660q.j().removeCallbacks(this.G);
                this.f660q.j().post(this.G);
                k1();
            }
        }
    }

    @Override // androidx.fragment.app.h
    public boolean d() {
        o();
        return P0(null, -1, 0);
    }

    public void d1(int i6, androidx.fragment.app.a aVar) {
        synchronized (this) {
            if (this.f655l == null) {
                this.f655l = new ArrayList<>();
            }
            int size = this.f655l.size();
            if (i6 < size) {
                if (H) {
                    Log.v("FragmentManager", "Setting back stack index " + i6 + " to " + aVar);
                }
                this.f655l.set(i6, aVar);
            } else {
                while (size < i6) {
                    this.f655l.add(null);
                    if (this.f656m == null) {
                        this.f656m = new ArrayList<>();
                    }
                    if (H) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f656m.add(Integer.valueOf(size));
                    size++;
                }
                if (H) {
                    Log.v("FragmentManager", "Adding back stack index " + i6 + " with " + aVar);
                }
                this.f655l.add(aVar);
            }
        }
    }

    void e0(Fragment fragment) {
        if (!fragment.f573m || fragment.f576p) {
            return;
        }
        fragment.E0(fragment.I0(fragment.f562b), null, fragment.f562b);
        View view = fragment.G;
        if (view == null) {
            fragment.H = null;
            return;
        }
        fragment.H = view;
        view.setSaveFromParentEnabled(false);
        if (fragment.f585y) {
            fragment.G.setVisibility(8);
        }
        fragment.w0(fragment.G, fragment.f562b);
        O(fragment, fragment.G, fragment.f562b, false);
    }

    public void e1(Fragment fragment, d.c cVar) {
        if (this.f650g.get(fragment.f565e) == fragment && (fragment.f579s == null || fragment.t() == this)) {
            fragment.R = cVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public boolean f0() {
        d0(true);
        boolean z5 = false;
        while (p0(this.f669z, this.A)) {
            this.f647d = true;
            try {
                U0(this.f669z, this.A);
                p();
                z5 = true;
            } catch (Throwable th) {
                p();
                throw th;
            }
        }
        k1();
        b0();
        m();
        return z5;
    }

    public void f1(Fragment fragment) {
        if (fragment == null || (this.f650g.get(fragment.f565e) == fragment && (fragment.f579s == null || fragment.t() == this))) {
            Fragment fragment2 = this.f663t;
            this.f663t = fragment;
            S(fragment2);
            S(this.f663t);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    void g(androidx.fragment.app.a aVar) {
        if (this.f651h == null) {
            this.f651h = new ArrayList<>();
        }
        this.f651h.add(aVar);
    }

    public void g1(Fragment fragment) {
        if (H) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f585y) {
            fragment.f585y = false;
            fragment.N = !fragment.N;
        }
    }

    public void h(Fragment fragment, boolean z5) {
        if (H) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        E0(fragment);
        if (fragment.f586z) {
            return;
        }
        if (this.f649f.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f649f) {
            this.f649f.add(fragment);
        }
        fragment.f571k = true;
        fragment.f572l = false;
        if (fragment.G == null) {
            fragment.N = false;
        }
        if (z0(fragment)) {
            this.f664u = true;
        }
        if (z5) {
            L0(fragment);
        }
    }

    void h1() {
        for (Fragment fragment : this.f650g.values()) {
            if (fragment != null) {
                O0(fragment);
            }
        }
    }

    void i(Fragment fragment) {
        if (C0()) {
            if (H) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.F.d(fragment) && H) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public Fragment j0(int i6) {
        for (int size = this.f649f.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f649f.get(size);
            if (fragment != null && fragment.f582v == i6) {
                return fragment;
            }
        }
        for (Fragment fragment2 : this.f650g.values()) {
            if (fragment2 != null && fragment2.f582v == i6) {
                return fragment2;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void k(androidx.fragment.app.g gVar, androidx.fragment.app.d dVar, Fragment fragment) {
        if (this.f660q != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f660q = gVar;
        this.f661r = dVar;
        this.f662s = fragment;
        if (fragment != null) {
            k1();
        }
        if (gVar instanceof androidx.activity.c) {
            androidx.activity.c cVar = (androidx.activity.c) gVar;
            OnBackPressedDispatcher h6 = cVar.h();
            this.f653j = h6;
            androidx.lifecycle.i iVar = cVar;
            if (fragment != null) {
                iVar = fragment;
            }
            h6.a(iVar, this.f654k);
        }
        this.F = fragment != null ? fragment.f578r.r0(fragment) : gVar instanceof y ? androidx.fragment.app.k.g(((y) gVar).d()) : new androidx.fragment.app.k(false);
    }

    public Fragment k0(String str) {
        if (str != null) {
            for (int size = this.f649f.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f649f.get(size);
                if (fragment != null && str.equals(fragment.f584x)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (Fragment fragment2 : this.f650g.values()) {
            if (fragment2 != null && str.equals(fragment2.f584x)) {
                return fragment2;
            }
        }
        return null;
    }

    public void l(Fragment fragment) {
        if (H) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f586z) {
            fragment.f586z = false;
            if (fragment.f571k) {
                return;
            }
            if (this.f649f.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            if (H) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            synchronized (this.f649f) {
                this.f649f.add(fragment);
            }
            fragment.f571k = true;
            if (z0(fragment)) {
                this.f664u = true;
            }
        }
    }

    public Fragment l0(String str) {
        Fragment f6;
        for (Fragment fragment : this.f650g.values()) {
            if (fragment != null && (f6 = fragment.f(str)) != null) {
                return f6;
            }
        }
        return null;
    }

    boolean n() {
        boolean z5 = false;
        for (Fragment fragment : this.f650g.values()) {
            if (fragment != null) {
                z5 = z0(fragment);
            }
            if (z5) {
                return true;
            }
        }
        return false;
    }

    public void o0(int i6) {
        synchronized (this) {
            this.f655l.set(i6, null);
            if (this.f656m == null) {
                this.f656m = new ArrayList<>();
            }
            if (H) {
                Log.v("FragmentManager", "Freeing back stack index " + i6);
            }
            this.f656m.add(Integer.valueOf(i6));
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f693a);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (str2 == null || !androidx.fragment.app.f.b(context.getClassLoader(), str2)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        Fragment j02 = resourceId != -1 ? j0(resourceId) : null;
        if (j02 == null && string != null) {
            j02 = k0(string);
        }
        if (j02 == null && id != -1) {
            j02 = j0(id);
        }
        if (H) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + j02);
        }
        if (j02 == null) {
            j02 = b().a(context.getClassLoader(), str2);
            j02.f573m = true;
            j02.f582v = resourceId != 0 ? resourceId : id;
            j02.f583w = id;
            j02.f584x = string;
            j02.f574n = true;
            j02.f578r = this;
            androidx.fragment.app.g gVar = this.f660q;
            j02.f579s = gVar;
            j02.j0(gVar.g(), attributeSet, j02.f562b);
            h(j02, true);
        } else {
            if (j02.f574n) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            }
            j02.f574n = true;
            androidx.fragment.app.g gVar2 = this.f660q;
            j02.f579s = gVar2;
            j02.j0(gVar2.g(), attributeSet, j02.f562b);
        }
        Fragment fragment = j02;
        if (this.f659p >= 1 || !fragment.f573m) {
            L0(fragment);
        } else {
            M0(fragment, 1, 0, 0, false);
        }
        View view2 = fragment.G;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.G.getTag() == null) {
                fragment.G.setTag(string);
            }
            return fragment.G;
        }
        throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    void q(androidx.fragment.app.a aVar, boolean z5, boolean z6, boolean z7) {
        if (z5) {
            aVar.g(z7);
        } else {
            aVar.f();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z5));
        if (z6) {
            n.B(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z7) {
            K0(this.f659p, true);
        }
        for (Fragment fragment : this.f650g.values()) {
            if (fragment != null && fragment.G != null && fragment.M && aVar.j(fragment.f583w)) {
                float f6 = fragment.O;
                if (f6 > 0.0f) {
                    fragment.G.setAlpha(f6);
                }
                if (z7) {
                    fragment.O = 0.0f;
                } else {
                    fragment.O = -1.0f;
                    fragment.M = false;
                }
            }
        }
    }

    public int q0() {
        ArrayList<androidx.fragment.app.a> arrayList = this.f651h;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    void r(Fragment fragment) {
        Animator animator;
        if (fragment.G != null) {
            g D0 = D0(fragment, fragment.x(), !fragment.f585y, fragment.y());
            if (D0 == null || (animator = D0.f686b) == null) {
                if (D0 != null) {
                    fragment.G.startAnimation(D0.f685a);
                    D0.f685a.start();
                }
                fragment.G.setVisibility((!fragment.f585y || fragment.M()) ? 0 : 8);
                if (fragment.M()) {
                    fragment.d1(false);
                }
            } else {
                animator.setTarget(fragment.G);
                if (!fragment.f585y) {
                    fragment.G.setVisibility(0);
                } else if (fragment.M()) {
                    fragment.d1(false);
                } else {
                    ViewGroup viewGroup = fragment.F;
                    View view = fragment.G;
                    viewGroup.startViewTransition(view);
                    D0.f686b.addListener(new e(viewGroup, view, fragment));
                }
                D0.f686b.start();
            }
        }
        if (fragment.f571k && z0(fragment)) {
            this.f664u = true;
        }
        fragment.N = false;
        fragment.h0(fragment.f585y);
    }

    androidx.fragment.app.k r0(Fragment fragment) {
        return this.F.f(fragment);
    }

    public void s(Fragment fragment) {
        if (H) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.f586z) {
            return;
        }
        fragment.f586z = true;
        if (fragment.f571k) {
            if (H) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            synchronized (this.f649f) {
                this.f649f.remove(fragment);
            }
            if (z0(fragment)) {
                this.f664u = true;
            }
            fragment.f571k = false;
        }
    }

    public Fragment s0(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragment = this.f650g.get(string);
        if (fragment == null) {
            i1(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragment;
    }

    public void t() {
        this.f665v = false;
        this.f666w = false;
        Z(2);
    }

    LayoutInflater.Factory2 t0() {
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.f662s;
        if (obj == null) {
            obj = this.f660q;
        }
        androidx.core.util.b.a(obj, sb);
        sb.append("}}");
        return sb.toString();
    }

    public void u(Configuration configuration) {
        for (int i6 = 0; i6 < this.f649f.size(); i6++) {
            Fragment fragment = this.f649f.get(i6);
            if (fragment != null) {
                fragment.A0(configuration);
            }
        }
    }

    public Fragment u0() {
        return this.f663t;
    }

    public boolean v(MenuItem menuItem) {
        if (this.f659p < 1) {
            return false;
        }
        for (int i6 = 0; i6 < this.f649f.size(); i6++) {
            Fragment fragment = this.f649f.get(i6);
            if (fragment != null && fragment.B0(menuItem)) {
                return true;
            }
        }
        return false;
    }

    x v0(Fragment fragment) {
        return this.F.i(fragment);
    }

    public void w() {
        this.f665v = false;
        this.f666w = false;
        Z(1);
    }

    void w0() {
        f0();
        if (this.f654k.c()) {
            d();
        } else {
            this.f653j.c();
        }
    }

    public boolean x(Menu menu, MenuInflater menuInflater) {
        if (this.f659p < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z5 = false;
        for (int i6 = 0; i6 < this.f649f.size(); i6++) {
            Fragment fragment = this.f649f.get(i6);
            if (fragment != null && fragment.D0(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z5 = true;
            }
        }
        if (this.f652i != null) {
            for (int i7 = 0; i7 < this.f652i.size(); i7++) {
                Fragment fragment2 = this.f652i.get(i7);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.d0();
                }
            }
        }
        this.f652i = arrayList;
        return z5;
    }

    public void x0(Fragment fragment) {
        if (H) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.f585y) {
            return;
        }
        fragment.f585y = true;
        fragment.N = true ^ fragment.N;
    }

    public void y() {
        this.f667x = true;
        f0();
        Z(0);
        this.f660q = null;
        this.f661r = null;
        this.f662s = null;
        if (this.f653j != null) {
            this.f654k.d();
            this.f653j = null;
        }
    }

    public boolean y0() {
        return this.f667x;
    }

    public void z() {
        Z(1);
    }
}
