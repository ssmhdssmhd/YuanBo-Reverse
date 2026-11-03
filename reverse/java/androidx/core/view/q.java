package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class q implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final View f539a;

    /* renamed from: b, reason: collision with root package name */
    private ViewTreeObserver f540b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f541c;

    private q(View view, Runnable runnable) {
        this.f539a = view;
        this.f540b = view.getViewTreeObserver();
        this.f541c = runnable;
    }

    public static q a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        q qVar = new q(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(qVar);
        view.addOnAttachStateChangeListener(qVar);
        return qVar;
    }

    public void b() {
        (this.f540b.isAlive() ? this.f540b : this.f539a.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f539a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f541c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f540b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
