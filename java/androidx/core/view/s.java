package androidx.core.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.a;
import androidx.core.view.h1;
import androidx.core.view.s;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class s {

    /* renamed from: c, reason: collision with root package name */
    private static Field f544c;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f542a = new AtomicInteger(1);

    /* renamed from: b, reason: collision with root package name */
    private static WeakHashMap<View, Object> f543b = null;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f545d = false;

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f546e = {g.b.f3911b, g.b.f3912c, g.b.f3923n, g.b.f3934y, g.b.B, g.b.C, g.b.D, g.b.E, g.b.F, g.b.G, g.b.f3913d, g.b.f3914e, g.b.f3915f, g.b.f3916g, g.b.f3917h, g.b.f3918i, g.b.f3919j, g.b.f3920k, g.b.f3921l, g.b.f3922m, g.b.f3924o, g.b.f3925p, g.b.f3926q, g.b.f3927r, g.b.f3928s, g.b.f3929t, g.b.f3930u, g.b.f3931v, g.b.f3932w, g.b.f3933x, g.b.f3935z, g.b.A};

    /* renamed from: f, reason: collision with root package name */
    private static final androidx.core.view.p f547f = new androidx.core.view.p() { // from class: androidx.core.view.r
    };

    /* renamed from: g, reason: collision with root package name */
    private static final e f548g = new e();

    class a extends f<Boolean> {
        a(int i6, Class cls, int i7) {
            super(i6, cls, i7);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.s.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(m.d(view));
        }
    }

    class b extends f<CharSequence> {
        b(int i6, Class cls, int i7, int i8) {
            super(i6, cls, i7, i8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.s.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return m.b(view);
        }
    }

    class c extends f<CharSequence> {
        c(int i6, Class cls, int i7, int i8) {
            super(i6, cls, i7, i8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.s.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return o.a(view);
        }
    }

    class d extends f<Boolean> {
        d(int i6, Class cls, int i7) {
            super(i6, cls, i7);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.core.view.s.f
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(m.c(view));
        }
    }

    static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakHashMap<View, Boolean> f549a = new WeakHashMap<>();

        e() {
        }

        private void a(View view, boolean z5) {
            boolean z6 = view.isShown() && view.getWindowVisibility() == 0;
            if (z5 != z6) {
                s.u(view, z6 ? 16 : 32);
                this.f549a.put(view, Boolean.valueOf(z6));
            }
        }

        private void b(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f549a.entrySet()) {
                    a(entry.getKey(), entry.getValue().booleanValue());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static abstract class f<T> {

        /* renamed from: a, reason: collision with root package name */
        private final int f550a;

        /* renamed from: b, reason: collision with root package name */
        private final Class<T> f551b;

        /* renamed from: c, reason: collision with root package name */
        private final int f552c;

        /* renamed from: d, reason: collision with root package name */
        private final int f553d;

        f(int i6, Class<T> cls, int i7) {
            this(i6, cls, 0, i7);
        }

        f(int i6, Class<T> cls, int i7, int i8) {
            this.f550a = i6;
            this.f551b = cls;
            this.f553d = i7;
            this.f552c = i8;
        }

        private boolean a() {
            return true;
        }

        private boolean b() {
            return Build.VERSION.SDK_INT >= this.f552c;
        }

        abstract T c(View view);

        T d(View view) {
            if (b()) {
                return c(view);
            }
            if (!a()) {
                return null;
            }
            T t5 = (T) view.getTag(this.f550a);
            if (this.f551b.isInstance(t5)) {
                return t5;
            }
            return null;
        }
    }

    static class g {
        static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        static int c(View view) {
            return view.getImportantForAccessibility();
        }

        static int d(View view) {
            return view.getMinimumHeight();
        }

        static int e(View view) {
            return view.getMinimumWidth();
        }

        static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        static boolean i(View view) {
            return view.hasTransientState();
        }

        static boolean j(View view, int i6, Bundle bundle) {
            return view.performAccessibilityAction(i6, bundle);
        }

        static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        static void l(View view, int i6, int i7, int i8, int i9) {
            view.postInvalidateOnAnimation(i6, i7, i8, i9);
        }

        static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        static void n(View view, Runnable runnable, long j6) {
            view.postOnAnimationDelayed(runnable, j6);
        }

        static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        static void p(View view) {
            view.requestFitSystemWindows();
        }

        static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        static void r(View view, boolean z5) {
            view.setHasTransientState(z5);
        }

        static void s(View view, int i6) {
            view.setImportantForAccessibility(i6);
        }
    }

    static class h {
        static int a() {
            return View.generateViewId();
        }

        static Display b(View view) {
            return view.getDisplay();
        }

        static int c(View view) {
            return view.getLabelFor();
        }

        static int d(View view) {
            return view.getLayoutDirection();
        }

        static int e(View view) {
            return view.getPaddingEnd();
        }

        static int f(View view) {
            return view.getPaddingStart();
        }

        static boolean g(View view) {
            return view.isPaddingRelative();
        }

        static void h(View view, int i6) {
            view.setLabelFor(i6);
        }

        static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        static void j(View view, int i6) {
            view.setLayoutDirection(i6);
        }

        static void k(View view, int i6, int i7, int i8, int i9) {
            view.setPaddingRelative(i6, i7, i8, i9);
        }
    }

    static class i {
        static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        static boolean b(View view) {
            return view.isAttachedToWindow();
        }

        static boolean c(View view) {
            return view.isLaidOut();
        }

        static boolean d(View view) {
            return view.isLayoutDirectionResolved();
        }

        static void e(ViewParent viewParent, View view, View view2, int i6) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i6);
        }

        static void f(View view, int i6) {
            view.setAccessibilityLiveRegion(i6);
        }

        static void g(AccessibilityEvent accessibilityEvent, int i6) {
            accessibilityEvent.setContentChangeTypes(i6);
        }
    }

    private static class j {

        class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            h1 f554a = null;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f555b;

            a(View view, androidx.core.view.o oVar) {
                this.f555b = view;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                h1 n6 = h1.n(windowInsets, view);
                if (Build.VERSION.SDK_INT < 30) {
                    j.a(windowInsets, this.f555b);
                    if (n6.equals(this.f554a)) {
                        throw null;
                    }
                }
                this.f554a = n6;
                throw null;
            }
        }

        static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(g.b.Q);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        static h1 b(View view, h1 h1Var, Rect rect) {
            WindowInsets l6 = h1Var.l();
            if (l6 != null) {
                return h1.n(view.computeSystemWindowInsets(l6, rect), view);
            }
            rect.setEmpty();
            return h1Var;
        }

        static boolean c(View view, float f6, float f7, boolean z5) {
            return view.dispatchNestedFling(f6, f7, z5);
        }

        static boolean d(View view, float f6, float f7) {
            return view.dispatchNestedPreFling(f6, f7);
        }

        static boolean e(View view, int i6, int i7, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i6, i7, iArr, iArr2);
        }

        static boolean f(View view, int i6, int i7, int i8, int i9, int[] iArr) {
            return view.dispatchNestedScroll(i6, i7, i8, i9, iArr);
        }

        static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        static float i(View view) {
            return view.getElevation();
        }

        public static h1 j(View view) {
            return h1.a.a(view);
        }

        static String k(View view) {
            return view.getTransitionName();
        }

        static float l(View view) {
            return view.getTranslationZ();
        }

        static float m(View view) {
            return view.getZ();
        }

        static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        static void s(View view, float f6) {
            view.setElevation(f6);
        }

        static void t(View view, boolean z5) {
            view.setNestedScrollingEnabled(z5);
        }

        static void u(View view, androidx.core.view.o oVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(g.b.L, oVar);
            }
            if (oVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(g.b.Q));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, oVar));
            }
        }

        static void v(View view, String str) {
            view.setTransitionName(str);
        }

        static void w(View view, float f6) {
            view.setTranslationZ(f6);
        }

        static void x(View view, float f6) {
            view.setZ(f6);
        }

        static boolean y(View view, int i6) {
            return view.startNestedScroll(i6);
        }

        static void z(View view) {
            view.stopNestedScroll();
        }
    }

    private static class k {
        public static h1 a(View view) {
            WindowInsets rootWindowInsets;
            rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            h1 m6 = h1.m(rootWindowInsets);
            m6.j(m6);
            m6.d(view.getRootView());
            return m6;
        }

        static int b(View view) {
            int scrollIndicators;
            scrollIndicators = view.getScrollIndicators();
            return scrollIndicators;
        }

        static void c(View view, int i6) {
            view.setScrollIndicators(i6);
        }

        static void d(View view, int i6, int i7) {
            view.setScrollIndicators(i6, i7);
        }
    }

    static class l {
        static void a(View view, Collection<View> collection, int i6) {
            view.addKeyboardNavigationClusters(collection, i6);
        }

        static int b(View view) {
            int importantForAutofill;
            importantForAutofill = view.getImportantForAutofill();
            return importantForAutofill;
        }

        static int c(View view) {
            int nextClusterForwardId;
            nextClusterForwardId = view.getNextClusterForwardId();
            return nextClusterForwardId;
        }

        static boolean d(View view) {
            boolean hasExplicitFocusable;
            hasExplicitFocusable = view.hasExplicitFocusable();
            return hasExplicitFocusable;
        }

        static boolean e(View view) {
            boolean isFocusedByDefault;
            isFocusedByDefault = view.isFocusedByDefault();
            return isFocusedByDefault;
        }

        static boolean f(View view) {
            boolean isImportantForAutofill;
            isImportantForAutofill = view.isImportantForAutofill();
            return isImportantForAutofill;
        }

        static boolean g(View view) {
            boolean isKeyboardNavigationCluster;
            isKeyboardNavigationCluster = view.isKeyboardNavigationCluster();
            return isKeyboardNavigationCluster;
        }

        static View h(View view, View view2, int i6) {
            View keyboardNavigationClusterSearch;
            keyboardNavigationClusterSearch = view.keyboardNavigationClusterSearch(view2, i6);
            return keyboardNavigationClusterSearch;
        }

        static boolean i(View view) {
            boolean restoreDefaultFocus;
            restoreDefaultFocus = view.restoreDefaultFocus();
            return restoreDefaultFocus;
        }

        static void j(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        static void k(View view, boolean z5) {
            view.setFocusedByDefault(z5);
        }

        static void l(View view, int i6) {
            view.setImportantForAutofill(i6);
        }

        static void m(View view, boolean z5) {
            view.setKeyboardNavigationCluster(z5);
        }

        static void n(View view, int i6) {
            view.setNextClusterForwardId(i6);
        }

        static void o(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    static class m {
        static void a(View view, final p pVar) {
            int i6 = g.b.P;
            f.f fVar = (f.f) view.getTag(i6);
            if (fVar == null) {
                fVar = new f.f();
                view.setTag(i6, fVar);
            }
            Objects.requireNonNull(pVar);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener() { // from class: androidx.core.view.v0
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return s.p.this.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            fVar.put(pVar, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static CharSequence b(View view) {
            CharSequence accessibilityPaneTitle;
            accessibilityPaneTitle = view.getAccessibilityPaneTitle();
            return accessibilityPaneTitle;
        }

        static boolean c(View view) {
            boolean isAccessibilityHeading;
            isAccessibilityHeading = view.isAccessibilityHeading();
            return isAccessibilityHeading;
        }

        static boolean d(View view) {
            boolean isScreenReaderFocusable;
            isScreenReaderFocusable = view.isScreenReaderFocusable();
            return isScreenReaderFocusable;
        }

        static void e(View view, p pVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            f.f fVar = (f.f) view.getTag(g.b.P);
            if (fVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) fVar.get(pVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        static <T> T f(View view, int i6) {
            KeyEvent.Callback requireViewById;
            requireViewById = view.requireViewById(i6);
            return (T) requireViewById;
        }

        static void g(View view, boolean z5) {
            view.setAccessibilityHeading(z5);
        }

        static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        static void i(View view, boolean z5) {
            view.setScreenReaderFocusable(z5);
        }
    }

    private static class n {
        static View.AccessibilityDelegate a(View view) {
            View.AccessibilityDelegate accessibilityDelegate;
            accessibilityDelegate = view.getAccessibilityDelegate();
            return accessibilityDelegate;
        }

        static List<Rect> b(View view) {
            List<Rect> systemGestureExclusionRects;
            systemGestureExclusionRects = view.getSystemGestureExclusionRects();
            return systemGestureExclusionRects;
        }

        static void c(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i6, int i7) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i6, i7);
        }

        static void d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    private static class o {
        static CharSequence a(View view) {
            CharSequence stateDescription;
            stateDescription = view.getStateDescription();
            return stateDescription;
        }

        static void b(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    public interface p {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    static class q {

        /* renamed from: d, reason: collision with root package name */
        private static final ArrayList<WeakReference<View>> f556d = new ArrayList<>();

        /* renamed from: a, reason: collision with root package name */
        private WeakHashMap<View, Boolean> f557a = null;

        /* renamed from: b, reason: collision with root package name */
        private SparseArray<WeakReference<View>> f558b = null;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<KeyEvent> f559c = null;

        q() {
        }

        static q a(View view) {
            int i6 = g.b.O;
            q qVar = (q) view.getTag(i6);
            if (qVar != null) {
                return qVar;
            }
            q qVar2 = new q();
            view.setTag(i6, qVar2);
            return qVar2;
        }

        private View c(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f557a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View c6 = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (c6 != null) {
                            return c6;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        private SparseArray<WeakReference<View>> d() {
            if (this.f558b == null) {
                this.f558b = new SparseArray<>();
            }
            return this.f558b;
        }

        private boolean e(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(g.b.P);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((p) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        private void g() {
            WeakHashMap<View, Boolean> weakHashMap = this.f557a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList = f556d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                if (this.f557a == null) {
                    this.f557a = new WeakHashMap<>();
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ArrayList<WeakReference<View>> arrayList2 = f556d;
                    View view = arrayList2.get(size).get();
                    if (view == null) {
                        arrayList2.remove(size);
                    } else {
                        this.f557a.put(view, Boolean.TRUE);
                        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                            this.f557a.put((View) parent, Boolean.TRUE);
                        }
                    }
                }
            }
        }

        boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View c6 = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (c6 != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference<>(c6));
                }
            }
            return c6 != null;
        }

        boolean f(KeyEvent keyEvent) {
            WeakReference<View> weakReference;
            int indexOfKey;
            WeakReference<KeyEvent> weakReference2 = this.f559c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.f559c = new WeakReference<>(keyEvent);
            SparseArray<WeakReference<View>> d6 = d();
            if (keyEvent.getAction() != 1 || (indexOfKey = d6.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = d6.valueAt(indexOfKey);
                d6.removeAt(indexOfKey);
            }
            if (weakReference == null) {
                weakReference = d6.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = weakReference.get();
            if (view != null && s.s(view)) {
                e(view, keyEvent);
            }
            return true;
        }
    }

    private static f<Boolean> A() {
        return new a(g.b.M, Boolean.class, 28);
    }

    public static void B(View view, androidx.core.view.a aVar) {
        if (aVar == null && (d(view) instanceof a.C0012a)) {
            aVar = new androidx.core.view.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.d());
    }

    public static void C(View view, int i6) {
        g.s(view, i6);
    }

    public static void D(View view, int i6) {
        if (Build.VERSION.SDK_INT >= 26) {
            l.l(view, i6);
        }
    }

    public static void E(View view, String str) {
        j.v(view, str);
    }

    private static void F(View view) {
        if (i(view) == 0) {
            C(view, 1);
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (i((View) parent) == 4) {
                C(view, 2);
                return;
            }
        }
    }

    private static f<CharSequence> G() {
        return new c(g.b.N, CharSequence.class, 64, 30);
    }

    public static void H(View view) {
        j.z(view);
    }

    private static f<Boolean> a() {
        return new d(g.b.J, Boolean.class, 28);
    }

    static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return q.a(view).b(view, keyEvent);
    }

    static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return q.a(view).f(keyEvent);
    }

    private static View.AccessibilityDelegate d(View view) {
        return Build.VERSION.SDK_INT >= 29 ? n.a(view) : e(view);
    }

    private static View.AccessibilityDelegate e(View view) {
        if (f545d) {
            return null;
        }
        if (f544c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f544c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f545d = true;
                return null;
            }
        }
        try {
            Object obj = f544c.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f545d = true;
            return null;
        }
    }

    public static int f(View view) {
        return i.a(view);
    }

    public static CharSequence g(View view) {
        return v().d(view);
    }

    public static Display h(View view) {
        return h.b(view);
    }

    public static int i(View view) {
        return g.c(view);
    }

    public static int j(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return l.b(view);
        }
        return 0;
    }

    public static int k(View view) {
        return h.d(view);
    }

    public static int l(View view) {
        return g.d(view);
    }

    public static int m(View view) {
        return g.e(view);
    }

    public static h1 n(View view) {
        return Build.VERSION.SDK_INT >= 23 ? k.a(view) : j.j(view);
    }

    public static CharSequence o(View view) {
        return G().d(view);
    }

    public static String p(View view) {
        return j.k(view);
    }

    public static boolean q(View view) {
        return g.i(view);
    }

    public static boolean r(View view) {
        Boolean d6 = a().d(view);
        return d6 != null && d6.booleanValue();
    }

    public static boolean s(View view) {
        return i.b(view);
    }

    public static boolean t(View view) {
        Boolean d6 = A().d(view);
        return d6 != null && d6.booleanValue();
    }

    static void u(View view, int i6) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z5 = g(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (f(view) != 0 || z5) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z5 ? 32 : 2048);
                i.g(obtain, i6);
                if (z5) {
                    obtain.getText().add(g(view));
                    F(view);
                }
                view.sendAccessibilityEventUnchecked(obtain);
                return;
            }
            if (i6 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                i.g(obtain2, i6);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(g(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
                return;
            }
            if (view.getParent() != null) {
                try {
                    i.e(view.getParent(), view, view, i6);
                } catch (AbstractMethodError e6) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e6);
                }
            }
        }
    }

    private static f<CharSequence> v() {
        return new b(g.b.K, CharSequence.class, 8, 28);
    }

    public static void w(View view) {
        g.k(view);
    }

    public static void x(View view, Runnable runnable) {
        g.m(view, runnable);
    }

    public static void y(View view, Runnable runnable, long j6) {
        g.n(view, runnable, j6);
    }

    public static void z(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i6, int i7) {
        if (Build.VERSION.SDK_INT >= 29) {
            n.c(view, context, iArr, attributeSet, typedArray, i6, i7);
        }
    }
}
