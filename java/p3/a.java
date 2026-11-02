package p3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import d4.i;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import java.util.Iterator;

/* loaded from: classes.dex */
public class a extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private FlutterMutatorsStack f8637a;

    /* renamed from: b, reason: collision with root package name */
    private float f8638b;

    /* renamed from: c, reason: collision with root package name */
    private int f8639c;

    /* renamed from: d, reason: collision with root package name */
    private int f8640d;

    /* renamed from: e, reason: collision with root package name */
    private int f8641e;

    /* renamed from: f, reason: collision with root package name */
    private int f8642f;

    /* renamed from: g, reason: collision with root package name */
    private final io.flutter.embedding.android.a f8643g;

    /* renamed from: h, reason: collision with root package name */
    ViewTreeObserver.OnGlobalFocusChangeListener f8644h;

    /* renamed from: p3.a$a, reason: collision with other inner class name */
    class ViewTreeObserverOnGlobalFocusChangeListenerC0127a implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View.OnFocusChangeListener f8645a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f8646b;

        ViewTreeObserverOnGlobalFocusChangeListenerC0127a(View.OnFocusChangeListener onFocusChangeListener, View view) {
            this.f8645a = onFocusChangeListener;
            this.f8646b = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public void onGlobalFocusChanged(View view, View view2) {
            View.OnFocusChangeListener onFocusChangeListener = this.f8645a;
            View view3 = this.f8646b;
            onFocusChangeListener.onFocusChange(view3, i.c(view3));
        }
    }

    public a(Context context, float f6, io.flutter.embedding.android.a aVar) {
        super(context, null);
        this.f8638b = f6;
        this.f8643g = aVar;
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.f8637a.getFinalMatrix());
        float f6 = this.f8638b;
        matrix.preScale(1.0f / f6, 1.0f / f6);
        matrix.postTranslate(-this.f8639c, -this.f8640d);
        return matrix;
    }

    public void a(FlutterMutatorsStack flutterMutatorsStack, int i6, int i7, int i8, int i9) {
        this.f8637a = flutterMutatorsStack;
        this.f8639c = i6;
        this.f8640d = i7;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i8, i9);
        layoutParams.leftMargin = i6;
        layoutParams.topMargin = i7;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    public void b() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive() || (onGlobalFocusChangeListener = this.f8644h) == null) {
            return;
        }
        this.f8644h = null;
        viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.save();
        Iterator<Path> it = this.f8637a.getFinalClippingPaths().iterator();
        while (it.hasNext()) {
            Path path = new Path(it.next());
            path.offset(-this.f8639c, -this.f8640d);
            canvas.clipPath(path);
        }
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i6;
        float f6;
        if (this.f8643g == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i7 = this.f8639c;
            this.f8641e = i7;
            i6 = this.f8640d;
            this.f8642f = i6;
            f6 = i7;
        } else {
            if (action == 2) {
                matrix.postTranslate(this.f8641e, this.f8642f);
                this.f8641e = this.f8639c;
                this.f8642f = this.f8640d;
                return this.f8643g.g(motionEvent, matrix);
            }
            f6 = this.f8639c;
            i6 = this.f8640d;
        }
        matrix.postTranslate(f6, i6);
        return this.f8643g.g(motionEvent, matrix);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f8644h == null) {
            ViewTreeObserverOnGlobalFocusChangeListenerC0127a viewTreeObserverOnGlobalFocusChangeListenerC0127a = new ViewTreeObserverOnGlobalFocusChangeListenerC0127a(onFocusChangeListener, this);
            this.f8644h = viewTreeObserverOnGlobalFocusChangeListenerC0127a;
            viewTreeObserver.addOnGlobalFocusChangeListener(viewTreeObserverOnGlobalFocusChangeListenerC0127a);
        }
    }
}
