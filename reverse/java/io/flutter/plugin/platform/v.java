package io.flutter.plugin.platform;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import io.flutter.plugin.platform.SingleViewPresentation;
import io.flutter.view.t;

/* loaded from: classes.dex */
class v {

    /* renamed from: a, reason: collision with root package name */
    SingleViewPresentation f6201a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f6202b;

    /* renamed from: c, reason: collision with root package name */
    private final io.flutter.plugin.platform.a f6203c;

    /* renamed from: d, reason: collision with root package name */
    private final int f6204d;

    /* renamed from: e, reason: collision with root package name */
    private final t.c f6205e;

    /* renamed from: f, reason: collision with root package name */
    private final View.OnFocusChangeListener f6206f;

    /* renamed from: g, reason: collision with root package name */
    private final Surface f6207g;

    /* renamed from: h, reason: collision with root package name */
    private VirtualDisplay f6208h;

    /* renamed from: i, reason: collision with root package name */
    private int f6209i;

    /* renamed from: j, reason: collision with root package name */
    private int f6210j;

    class a implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f6211a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f6212b;

        /* renamed from: io.flutter.plugin.platform.v$a$a, reason: collision with other inner class name */
        class RunnableC0092a implements Runnable {
            RunnableC0092a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                aVar.f6211a.postDelayed(aVar.f6212b, 128L);
            }
        }

        a(View view, Runnable runnable) {
            this.f6211a = view;
            this.f6212b = runnable;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b.a(this.f6211a, new RunnableC0092a());
            this.f6211a.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static class b implements ViewTreeObserver.OnDrawListener {

        /* renamed from: a, reason: collision with root package name */
        final View f6215a;

        /* renamed from: b, reason: collision with root package name */
        Runnable f6216b;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f6215a.getViewTreeObserver().removeOnDrawListener(b.this);
            }
        }

        b(View view, Runnable runnable) {
            this.f6215a = view;
            this.f6216b = runnable;
        }

        static void a(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new b(view, runnable));
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f6216b;
            if (runnable == null) {
                return;
            }
            runnable.run();
            this.f6216b = null;
            this.f6215a.post(new a());
        }
    }

    private v(Context context, io.flutter.plugin.platform.a aVar, VirtualDisplay virtualDisplay, h hVar, Surface surface, t.c cVar, View.OnFocusChangeListener onFocusChangeListener, int i6, Object obj) {
        this.f6202b = context;
        this.f6203c = aVar;
        this.f6205e = cVar;
        this.f6206f = onFocusChangeListener;
        this.f6207g = surface;
        this.f6208h = virtualDisplay;
        this.f6204d = context.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context, this.f6208h.getDisplay(), hVar, aVar, i6, onFocusChangeListener);
        this.f6201a = singleViewPresentation;
        singleViewPresentation.show();
    }

    public static v a(Context context, io.flutter.plugin.platform.a aVar, h hVar, t.c cVar, int i6, int i7, int i8, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        context.getResources().getDisplayMetrics();
        if (i6 == 0 || i7 == 0) {
            return null;
        }
        cVar.d().setDefaultBufferSize(i6, i7);
        Surface surface = new Surface(cVar.d());
        VirtualDisplay createVirtualDisplay = ((DisplayManager) context.getSystemService("display")).createVirtualDisplay("flutter-vd", i6, i7, context.getResources().getDisplayMetrics().densityDpi, surface, 0);
        if (createVirtualDisplay == null) {
            return null;
        }
        v vVar = new v(context, aVar, createVirtualDisplay, hVar, surface, cVar, onFocusChangeListener, i8, obj);
        vVar.f6209i = i6;
        vVar.f6210j = i7;
        return vVar;
    }

    public void b(MotionEvent motionEvent) {
        SingleViewPresentation singleViewPresentation = this.f6201a;
        if (singleViewPresentation == null) {
            return;
        }
        singleViewPresentation.dispatchTouchEvent(motionEvent);
    }

    public int c() {
        return this.f6210j;
    }

    public int d() {
        return this.f6209i;
    }

    public View e() {
        SingleViewPresentation singleViewPresentation = this.f6201a;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().d();
    }

    void f(View view) {
        SingleViewPresentation singleViewPresentation = this.f6201a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f6201a.getView().e(view);
    }

    void g() {
        SingleViewPresentation singleViewPresentation = this.f6201a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f6201a.getView().g();
    }

    void h() {
        SingleViewPresentation singleViewPresentation = this.f6201a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f6201a.getView().c();
    }

    public void i(int i6, int i7, Runnable runnable) {
        boolean isFocused = e().isFocused();
        SingleViewPresentation.e detachState = this.f6201a.detachState();
        this.f6208h.setSurface(null);
        this.f6208h.release();
        this.f6209i = i6;
        this.f6210j = i7;
        this.f6205e.d().setDefaultBufferSize(i6, i7);
        this.f6208h = ((DisplayManager) this.f6202b.getSystemService("display")).createVirtualDisplay("flutter-vd", i6, i7, this.f6204d, this.f6207g, 0);
        View e6 = e();
        e6.addOnAttachStateChangeListener(new a(e6, runnable));
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.f6202b, this.f6208h.getDisplay(), this.f6203c, detachState, this.f6206f, isFocused);
        singleViewPresentation.show();
        this.f6201a.cancel();
        this.f6201a = singleViewPresentation;
    }
}
