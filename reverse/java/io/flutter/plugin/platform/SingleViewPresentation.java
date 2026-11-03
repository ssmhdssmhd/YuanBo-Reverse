package io.flutter.plugin.platform;

import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
class SingleViewPresentation extends Presentation {
    private static final String TAG = "PlatformViewsController";
    private final io.flutter.plugin.platform.a accessibilityEventsDelegate;
    private FrameLayout container;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private a rootView;
    private boolean startFocused;
    private final e state;
    private int viewId;

    private static class a extends FrameLayout {

        /* renamed from: a, reason: collision with root package name */
        private final io.flutter.plugin.platform.a f6117a;

        /* renamed from: b, reason: collision with root package name */
        private final View f6118b;

        public a(Context context, io.flutter.plugin.platform.a aVar, View view) {
            super(context);
            this.f6117a = aVar;
            this.f6118b = view;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f6117a.b(this.f6118b, view, accessibilityEvent);
        }
    }

    static class b extends ViewGroup {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f6119a;

        /* renamed from: b, reason: collision with root package name */
        private final Rect f6120b;

        public b(Context context) {
            super(context);
            this.f6119a = new Rect();
            this.f6120b = new Rect();
        }

        private static int a(int i6) {
            return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i6), Integer.MIN_VALUE);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
            for (int i10 = 0; i10 < getChildCount(); i10++) {
                View childAt = getChildAt(i10);
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) childAt.getLayoutParams();
                this.f6119a.set(i6, i7, i8, i9);
                Gravity.apply(layoutParams.gravity, childAt.getMeasuredWidth(), childAt.getMeasuredHeight(), this.f6119a, layoutParams.x, layoutParams.y, this.f6120b);
                Rect rect = this.f6120b;
                childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
        }

        @Override // android.view.View
        protected void onMeasure(int i6, int i7) {
            for (int i8 = 0; i8 < getChildCount(); i8++) {
                getChildAt(i8).measure(a(i6), a(i7));
            }
            super.onMeasure(i6, i7);
        }
    }

    private static class c extends ContextWrapper {

        /* renamed from: a, reason: collision with root package name */
        private final InputMethodManager f6121a;

        c(Context context) {
            this(context, null);
        }

        private c(Context context, InputMethodManager inputMethodManager) {
            super(context);
            this.f6121a = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context createDisplayContext(Display display) {
            return new c(super.createDisplayContext(display), this.f6121a);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "input_method".equals(str) ? this.f6121a : super.getSystemService(str);
        }
    }

    private static class d extends ContextWrapper {

        /* renamed from: a, reason: collision with root package name */
        private final f f6122a;

        /* renamed from: b, reason: collision with root package name */
        private WindowManager f6123b;

        /* renamed from: c, reason: collision with root package name */
        private final Context f6124c;

        d(Context context, f fVar, Context context2) {
            super(context);
            this.f6122a = fVar;
            this.f6124c = context2;
        }

        private WindowManager a() {
            if (this.f6123b == null) {
                this.f6123b = this.f6122a.b();
            }
            return this.f6123b;
        }

        private boolean b() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i6 = 0; i6 < stackTrace.length && i6 < 11; i6++) {
                if (stackTrace[i6].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i6].getMethodName().equals("<init>")) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "window".equals(str) ? b() ? this.f6124c.getSystemService(str) : a() : super.getSystemService(str);
        }
    }

    static class e {

        /* renamed from: a, reason: collision with root package name */
        private h f6125a;

        /* renamed from: b, reason: collision with root package name */
        private f f6126b;

        /* renamed from: c, reason: collision with root package name */
        private b f6127c;

        e() {
        }
    }

    static class f implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final WindowManager f6128a;

        /* renamed from: b, reason: collision with root package name */
        b f6129b;

        f(WindowManager windowManager, b bVar) {
            this.f6128a = windowManager;
            this.f6129b = bVar;
        }

        private void a(Object[] objArr) {
            b bVar = this.f6129b;
            if (bVar == null) {
                k3.b.g(SingleViewPresentation.TAG, "Embedded view called addView while detached from presentation");
            } else {
                bVar.addView((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
            }
        }

        private void c(Object[] objArr) {
            b bVar = this.f6129b;
            if (bVar == null) {
                k3.b.g(SingleViewPresentation.TAG, "Embedded view called removeView while detached from presentation");
            } else {
                bVar.removeView((View) objArr[0]);
            }
        }

        private void d(Object[] objArr) {
            if (this.f6129b == null) {
                k3.b.g(SingleViewPresentation.TAG, "Embedded view called removeViewImmediate while detached from presentation");
                return;
            }
            View view = (View) objArr[0];
            view.clearAnimation();
            this.f6129b.removeView(view);
        }

        private void e(Object[] objArr) {
            b bVar = this.f6129b;
            if (bVar == null) {
                k3.b.g(SingleViewPresentation.TAG, "Embedded view called updateViewLayout while detached from presentation");
            } else {
                bVar.updateViewLayout((View) objArr[0], (WindowManager.LayoutParams) objArr[1]);
            }
        }

        public WindowManager b() {
            return (WindowManager) Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[]{WindowManager.class}, this);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            name.hashCode();
            switch (name) {
                case "addView":
                    a(objArr);
                    return null;
                case "removeViewImmediate":
                    d(objArr);
                    return null;
                case "updateViewLayout":
                    e(objArr);
                    return null;
                case "removeView":
                    c(objArr);
                    return null;
                default:
                    try {
                        return method.invoke(this.f6128a, objArr);
                    } catch (InvocationTargetException e6) {
                        throw e6.getCause();
                    }
            }
        }
    }

    public SingleViewPresentation(Context context, Display display, io.flutter.plugin.platform.a aVar, e eVar, View.OnFocusChangeListener onFocusChangeListener, boolean z5) {
        super(new c(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = aVar;
        this.state = eVar;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z5;
    }

    public SingleViewPresentation(Context context, Display display, h hVar, io.flutter.plugin.platform.a aVar, int i6, View.OnFocusChangeListener onFocusChangeListener) {
        super(new c(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = aVar;
        this.viewId = i6;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        e eVar = new e();
        this.state = eVar;
        eVar.f6125a = hVar;
        getWindow().setFlags(8, 8);
        getWindow().setType(2030);
    }

    public e detachState() {
        this.container.removeAllViews();
        this.rootView.removeAllViews();
        return this.state;
    }

    public h getView() {
        if (this.state.f6125a == null) {
            return null;
        }
        return this.state.f6125a;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.state.f6127c == null) {
            this.state.f6127c = new b(getContext());
        }
        if (this.state.f6126b == null) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            e eVar = this.state;
            eVar.f6126b = new f(windowManager, eVar.f6127c);
        }
        this.container = new FrameLayout(getContext());
        d dVar = new d(getContext(), this.state.f6126b, this.outerContext);
        View d6 = this.state.f6125a.d();
        if (d6.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) d6.getContext()).setBaseContext(dVar);
        } else {
            k3.b.g(TAG, "Unexpected platform view context for view ID " + this.viewId + "; some functionality may not work correctly. When constructing a platform view in the factory, ensure that the view returned from PlatformViewFactory#create returns the provided context from getContext(). If you are unable to associate the view with that context, consider using Hybrid Composition instead.");
        }
        this.container.addView(d6);
        a aVar = new a(getContext(), this.accessibilityEventsDelegate, d6);
        this.rootView = aVar;
        aVar.addView(this.container);
        this.rootView.addView(this.state.f6127c);
        d6.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            d6.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }
}
