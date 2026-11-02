package io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import io.flutter.embedding.android.w;

/* loaded from: classes.dex */
final class FlutterSplashView extends FrameLayout {

    /* renamed from: j, reason: collision with root package name */
    private static String f5823j = "FlutterSplashView";

    /* renamed from: a, reason: collision with root package name */
    private j0 f5824a;

    /* renamed from: b, reason: collision with root package name */
    private w f5825b;

    /* renamed from: c, reason: collision with root package name */
    private View f5826c;

    /* renamed from: d, reason: collision with root package name */
    Bundle f5827d;

    /* renamed from: e, reason: collision with root package name */
    private String f5828e;

    /* renamed from: f, reason: collision with root package name */
    private String f5829f;

    /* renamed from: g, reason: collision with root package name */
    private final w.f f5830g;

    /* renamed from: h, reason: collision with root package name */
    private final w3.b f5831h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f5832i;

    public static class SavedState extends View.BaseSavedState {
        public static Parcelable.Creator<SavedState> CREATOR = new a();
        private String previousCompletedSplashIsolate;
        private Bundle splashScreenState;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i6) {
                return new SavedState[i6];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.previousCompletedSplashIsolate = parcel.readString();
            this.splashScreenState = parcel.readBundle(getClass().getClassLoader());
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            super.writeToParcel(parcel, i6);
            parcel.writeString(this.previousCompletedSplashIsolate);
            parcel.writeBundle(this.splashScreenState);
        }
    }

    class a implements w.f {
        a() {
        }

        @Override // io.flutter.embedding.android.w.f
        public void a() {
        }

        @Override // io.flutter.embedding.android.w.f
        public void b(io.flutter.embedding.engine.a aVar) {
            FlutterSplashView.this.f5825b.y(this);
            FlutterSplashView flutterSplashView = FlutterSplashView.this;
            flutterSplashView.g(flutterSplashView.f5825b, FlutterSplashView.this.f5824a);
        }
    }

    class b implements w3.b {
        b() {
        }

        @Override // w3.b
        public void c() {
        }

        @Override // w3.b
        public void f() {
            if (FlutterSplashView.this.f5824a != null) {
                FlutterSplashView.this.k();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FlutterSplashView flutterSplashView = FlutterSplashView.this;
            flutterSplashView.removeView(flutterSplashView.f5826c);
            FlutterSplashView flutterSplashView2 = FlutterSplashView.this;
            flutterSplashView2.f5829f = flutterSplashView2.f5828e;
        }
    }

    public FlutterSplashView(Context context) {
        this(context, null, 0);
    }

    public FlutterSplashView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f5830g = new a();
        this.f5831h = new b();
        this.f5832i = new c();
        setSaveEnabled(true);
    }

    private boolean h() {
        w wVar = this.f5825b;
        if (wVar == null) {
            throw new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
        }
        if (wVar.w()) {
            return this.f5825b.getAttachedFlutterEngine().h().k() != null && this.f5825b.getAttachedFlutterEngine().h().k().equals(this.f5829f);
        }
        throw new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
    }

    private boolean i() {
        w wVar = this.f5825b;
        return (wVar == null || !wVar.w() || this.f5825b.u() || h()) ? false : true;
    }

    private boolean j() {
        j0 j0Var;
        w wVar = this.f5825b;
        return wVar != null && wVar.w() && (j0Var = this.f5824a) != null && j0Var.b() && l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f5828e = this.f5825b.getAttachedFlutterEngine().h().k();
        k3.b.f(f5823j, "Transitioning splash screen to a Flutter UI. Isolate: " + this.f5828e);
        this.f5824a.a(this.f5832i);
    }

    private boolean l() {
        w wVar = this.f5825b;
        if (wVar == null) {
            throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterView is set.");
        }
        if (wVar.w()) {
            return this.f5825b.u() && !h();
        }
        throw new IllegalStateException("Cannot determine if previous splash transition was interrupted when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
    }

    public void g(w wVar, j0 j0Var) {
        w wVar2 = this.f5825b;
        if (wVar2 != null) {
            wVar2.z(this.f5831h);
            removeView(this.f5825b);
        }
        View view = this.f5826c;
        if (view != null) {
            removeView(view);
        }
        this.f5825b = wVar;
        addView(wVar);
        this.f5824a = j0Var;
        if (j0Var != null) {
            if (i()) {
                k3.b.f(f5823j, "Showing splash screen UI.");
                View c6 = j0Var.c(getContext(), this.f5827d);
                this.f5826c = c6;
                addView(c6);
                wVar.l(this.f5831h);
                return;
            }
            if (!j()) {
                if (wVar.w()) {
                    return;
                }
                k3.b.f(f5823j, "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.");
                wVar.k(this.f5830g);
                return;
            }
            k3.b.f(f5823j, "Showing an immediate splash transition to Flutter due to previously interrupted transition.");
            View c7 = j0Var.c(getContext(), this.f5827d);
            this.f5826c = c7;
            addView(c7);
            k();
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f5829f = savedState.previousCompletedSplashIsolate;
        this.f5827d = savedState.splashScreenState;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.previousCompletedSplashIsolate = this.f5829f;
        j0 j0Var = this.f5824a;
        savedState.splashScreenState = j0Var != null ? j0Var.d() : null;
        return savedState;
    }
}
