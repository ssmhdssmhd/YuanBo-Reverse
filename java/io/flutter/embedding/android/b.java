package io.flutter.embedding.android;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

@Deprecated
/* loaded from: classes.dex */
public final class b implements j0 {

    /* renamed from: a, reason: collision with root package name */
    private final Drawable f5842a;

    /* renamed from: b, reason: collision with root package name */
    private final ImageView.ScaleType f5843b;

    /* renamed from: c, reason: collision with root package name */
    private final long f5844c;

    /* renamed from: d, reason: collision with root package name */
    private C0089b f5845d;

    class a implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f5846a;

        a(Runnable runnable) {
            this.f5846a = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f5846a.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5846a.run();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: io.flutter.embedding.android.b$b, reason: collision with other inner class name */
    public static class C0089b extends ImageView {
        public C0089b(Context context) {
            this(context, null, 0);
        }

        public C0089b(Context context, AttributeSet attributeSet, int i6) {
            super(context, attributeSet, i6);
        }

        public void a(Drawable drawable, ImageView.ScaleType scaleType) {
            setScaleType(scaleType);
            setImageDrawable(drawable);
        }

        public void setSplashDrawable(Drawable drawable) {
            a(drawable, ImageView.ScaleType.FIT_XY);
        }
    }

    public b(Drawable drawable) {
        this(drawable, ImageView.ScaleType.FIT_XY, 500L);
    }

    public b(Drawable drawable, ImageView.ScaleType scaleType, long j6) {
        this.f5842a = drawable;
        this.f5843b = scaleType;
        this.f5844c = j6;
    }

    @Override // io.flutter.embedding.android.j0
    public void a(Runnable runnable) {
        C0089b c0089b = this.f5845d;
        if (c0089b == null) {
            runnable.run();
        } else {
            c0089b.animate().alpha(0.0f).setDuration(this.f5844c).setListener(new a(runnable));
        }
    }

    @Override // io.flutter.embedding.android.j0
    public /* synthetic */ boolean b() {
        return i0.a(this);
    }

    @Override // io.flutter.embedding.android.j0
    public View c(Context context, Bundle bundle) {
        C0089b c0089b = new C0089b(context);
        this.f5845d = c0089b;
        c0089b.a(this.f5842a, this.f5843b);
        return this.f5845d;
    }

    @Override // io.flutter.embedding.android.j0
    public /* synthetic */ Bundle d() {
        return i0.b(this);
    }
}
