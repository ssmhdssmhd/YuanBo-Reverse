package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.app.l;
import androidx.lifecycle.d;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.j;
import androidx.lifecycle.s;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.savedstate.SavedStateRegistry;

/* loaded from: classes.dex */
public class ComponentActivity extends l implements y, androidx.savedstate.b, c {

    /* renamed from: e, reason: collision with root package name */
    private x f288e;

    /* renamed from: g, reason: collision with root package name */
    private int f290g;

    /* renamed from: c, reason: collision with root package name */
    private final j f286c = new j(this);

    /* renamed from: d, reason: collision with root package name */
    private final androidx.savedstate.a f287d = androidx.savedstate.a.a(this);

    /* renamed from: f, reason: collision with root package name */
    private final OnBackPressedDispatcher f289f = new OnBackPressedDispatcher(new a());

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity.super.onBackPressed();
        }
    }

    static final class b {

        /* renamed from: a, reason: collision with root package name */
        Object f294a;

        /* renamed from: b, reason: collision with root package name */
        x f295b;

        b() {
        }
    }

    public ComponentActivity() {
        if (a() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i6 = Build.VERSION.SDK_INT;
        a().a(new g() { // from class: androidx.activity.ComponentActivity.2
            @Override // androidx.lifecycle.g
            public void d(i iVar, d.b bVar) {
                if (bVar == d.b.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View peekDecorView = window != null ? window.peekDecorView() : null;
                    if (peekDecorView != null) {
                        peekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        a().a(new g() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.g
            public void d(i iVar, d.b bVar) {
                if (bVar != d.b.ON_DESTROY || ComponentActivity.this.isChangingConfigurations()) {
                    return;
                }
                ComponentActivity.this.d().a();
            }
        });
        if (i6 <= 23) {
            a().a(new ImmLeaksCleaner(this));
        }
    }

    @Override // androidx.lifecycle.i
    public d a() {
        return this.f286c;
    }

    @Override // androidx.lifecycle.y
    public x d() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f288e == null) {
            b bVar = (b) getLastNonConfigurationInstance();
            if (bVar != null) {
                this.f288e = bVar.f295b;
            }
            if (this.f288e == null) {
                this.f288e = new x();
            }
        }
        return this.f288e;
    }

    @Deprecated
    public Object f() {
        return null;
    }

    @Override // androidx.activity.c
    public final OnBackPressedDispatcher h() {
        return this.f289f;
    }

    @Override // androidx.savedstate.b
    public final SavedStateRegistry i() {
        return this.f287d.b();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f289f.c();
    }

    @Override // androidx.core.app.l, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f287d.c(bundle);
        s.f(this);
        int i6 = this.f290g;
        if (i6 != 0) {
            setContentView(i6);
        }
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        b bVar;
        Object f6 = f();
        x xVar = this.f288e;
        if (xVar == null && (bVar = (b) getLastNonConfigurationInstance()) != null) {
            xVar = bVar.f295b;
        }
        if (xVar == null && f6 == null) {
            return null;
        }
        b bVar2 = new b();
        bVar2.f294a = f6;
        bVar2.f295b = xVar;
        return bVar2;
    }

    @Override // androidx.core.app.l, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        d a6 = a();
        if (a6 instanceof j) {
            ((j) a6).o(d.c.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f287d.d(bundle);
    }
}
