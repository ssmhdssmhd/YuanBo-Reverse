package io.flutter.plugin.platform;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import io.flutter.view.t;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
class n extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private int f6148a;

    /* renamed from: b, reason: collision with root package name */
    private int f6149b;

    /* renamed from: c, reason: collision with root package name */
    private int f6150c;

    /* renamed from: d, reason: collision with root package name */
    private int f6151d;

    /* renamed from: e, reason: collision with root package name */
    private int f6152e;

    /* renamed from: f, reason: collision with root package name */
    private int f6153f;

    /* renamed from: g, reason: collision with root package name */
    private SurfaceTexture f6154g;

    /* renamed from: h, reason: collision with root package name */
    private Surface f6155h;

    /* renamed from: i, reason: collision with root package name */
    private io.flutter.embedding.android.a f6156i;

    /* renamed from: j, reason: collision with root package name */
    ViewTreeObserver.OnGlobalFocusChangeListener f6157j;

    /* renamed from: k, reason: collision with root package name */
    private final AtomicLong f6158k;

    /* renamed from: l, reason: collision with root package name */
    private final t.a f6159l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f6160m;

    /* renamed from: n, reason: collision with root package name */
    private final t.b f6161n;

    class a implements t.a {
        a() {
        }

        @Override // io.flutter.view.t.a
        public void a() {
            if (Build.VERSION.SDK_INT == 29) {
                n.this.f6158k.decrementAndGet();
            }
        }
    }

    class b implements t.b {
        b() {
        }

        @Override // io.flutter.view.t.b
        public void onTrimMemory(int i6) {
            if (i6 != 80 || Build.VERSION.SDK_INT < 29) {
                return;
            }
            n.this.f6160m = true;
        }
    }

    class c implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View.OnFocusChangeListener f6164a;

        c(View.OnFocusChangeListener onFocusChangeListener) {
            this.f6164a = onFocusChangeListener;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            View.OnFocusChangeListener onFocusChangeListener = this.f6164a;
            n nVar = n.this;
            onFocusChangeListener.onFocusChange(nVar, d4.i.c(nVar));
        }
    }

    public n(Context context) {
        super(context);
        this.f6158k = new AtomicLong(0L);
        this.f6159l = new a();
        this.f6160m = false;
        this.f6161n = new b();
        setWillNotDraw(false);
    }

    public n(Context context, t.c cVar) {
        this(context);
        cVar.c(this.f6159l);
        cVar.b(this.f6161n);
        l(cVar.d());
    }

    private void f() {
        if (Build.VERSION.SDK_INT == 29) {
            this.f6158k.incrementAndGet();
        }
    }

    private void g() {
        if (this.f6160m) {
            Surface surface = this.f6155h;
            if (surface != null) {
                surface.release();
            }
            this.f6155h = c(this.f6154g);
            this.f6160m = false;
        }
    }

    private boolean n() {
        return Build.VERSION.SDK_INT != 29 || this.f6158k.get() <= 0;
    }

    protected Surface c(SurfaceTexture surfaceTexture) {
        return new Surface(surfaceTexture);
    }

    public int d() {
        return this.f6153f;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        String str;
        boolean isReleased;
        Canvas lockHardwareCanvas;
        Surface surface = this.f6155h;
        if (surface == null) {
            super.draw(canvas);
            str = "Platform view cannot be composed without a surface.";
        } else if (surface.isValid()) {
            SurfaceTexture surfaceTexture = this.f6154g;
            if (surfaceTexture != null) {
                isReleased = surfaceTexture.isReleased();
                if (!isReleased) {
                    if (!n()) {
                        invalidate();
                        return;
                    }
                    g();
                    lockHardwareCanvas = this.f6155h.lockHardwareCanvas();
                    try {
                        lockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        super.draw(lockHardwareCanvas);
                        f();
                        return;
                    } finally {
                        this.f6155h.unlockCanvasAndPost(lockHardwareCanvas);
                    }
                }
            }
            str = "Invalid texture. The platform view cannot be displayed.";
        } else {
            str = "Invalid surface. The platform view cannot be displayed.";
        }
        k3.b.b("PlatformViewWrapper", str);
    }

    public int e() {
        return this.f6152e;
    }

    public void h() {
        this.f6154g = null;
        Surface surface = this.f6155h;
        if (surface != null) {
            surface.release();
            this.f6155h = null;
        }
    }

    public void i(int i6, int i7) {
        this.f6152e = i6;
        this.f6153f = i7;
        SurfaceTexture surfaceTexture = this.f6154g;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i6, i7);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    public void j(FrameLayout.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.f6150c = layoutParams.leftMargin;
        this.f6151d = layoutParams.topMargin;
    }

    public void k(View.OnFocusChangeListener onFocusChangeListener) {
        o();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f6157j == null) {
            c cVar = new c(onFocusChangeListener);
            this.f6157j = cVar;
            viewTreeObserver.addOnGlobalFocusChangeListener(cVar);
        }
    }

    public void l(SurfaceTexture surfaceTexture) {
        Canvas lockHardwareCanvas;
        int i6;
        if (Build.VERSION.SDK_INT < 23) {
            k3.b.b("PlatformViewWrapper", "Platform views cannot be displayed below API level 23. You can prevent this issue by setting `minSdkVersion: 23` in build.gradle.");
            return;
        }
        this.f6154g = surfaceTexture;
        int i7 = this.f6152e;
        if (i7 > 0 && (i6 = this.f6153f) > 0) {
            surfaceTexture.setDefaultBufferSize(i7, i6);
        }
        Surface surface = this.f6155h;
        if (surface != null) {
            surface.release();
        }
        Surface c6 = c(surfaceTexture);
        this.f6155h = c6;
        lockHardwareCanvas = c6.lockHardwareCanvas();
        try {
            lockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            f();
        } finally {
            this.f6155h.unlockCanvasAndPost(lockHardwareCanvas);
        }
    }

    public void m(io.flutter.embedding.android.a aVar) {
        this.f6156i = aVar;
    }

    public void o() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.f6157j) == null) {
            return;
        }
        this.f6157j = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(View view, View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i6;
        float f6;
        if (this.f6156i == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i7 = this.f6150c;
            this.f6148a = i7;
            i6 = this.f6151d;
            this.f6149b = i6;
            f6 = i7;
        } else {
            if (action == 2) {
                matrix.postTranslate(this.f6148a, this.f6149b);
                this.f6148a = this.f6150c;
                this.f6149b = this.f6151d;
                return this.f6156i.g(motionEvent, matrix);
            }
            f6 = this.f6150c;
            i6 = this.f6151d;
        }
        matrix.postTranslate(f6, i6);
        return this.f6156i.g(motionEvent, matrix);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }
}
