package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* loaded from: classes.dex */
public class n extends SurfaceView implements w3.c {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f5926a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5927b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5928c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5929d;

    /* renamed from: e, reason: collision with root package name */
    private w3.a f5930e;

    /* renamed from: f, reason: collision with root package name */
    private final SurfaceHolder.Callback f5931f;

    /* renamed from: g, reason: collision with root package name */
    private final w3.b f5932g;

    class a implements SurfaceHolder.Callback {
        a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i6, int i7, int i8) {
            k3.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceChanged()");
            if (n.this.f5929d) {
                n.this.j(i7, i8);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            k3.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.startRenderingToSurface()");
            n.this.f5927b = true;
            if (n.this.f5929d) {
                n.this.k();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            k3.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.stopRenderingToSurface()");
            n.this.f5927b = false;
            if (n.this.f5929d) {
                n.this.l();
            }
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
            k3.b.f("FlutterSurfaceView", "onFlutterUiDisplayed()");
            n.this.setAlpha(1.0f);
            if (n.this.f5930e != null) {
                n.this.f5930e.q(this);
            }
        }
    }

    private n(Context context, AttributeSet attributeSet, boolean z5) {
        super(context, attributeSet);
        this.f5927b = false;
        this.f5928c = false;
        this.f5929d = false;
        this.f5931f = new a();
        this.f5932g = new b();
        this.f5926a = z5;
        m();
    }

    public n(Context context, boolean z5) {
        this(context, null, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i6, int i7) {
        if (this.f5930e == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        k3.b.f("FlutterSurfaceView", "Notifying FlutterRenderer that Android surface size has changed to " + i6 + " x " + i7);
        this.f5930e.w(i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f5930e == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        this.f5930e.u(getHolder().getSurface(), this.f5928c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        w3.a aVar = this.f5930e;
        if (aVar == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        aVar.v();
    }

    private void m() {
        if (this.f5926a) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.f5931f);
        setAlpha(0.0f);
    }

    @Override // w3.c
    public void a(w3.a aVar) {
        k3.b.f("FlutterSurfaceView", "Attaching to FlutterRenderer.");
        if (this.f5930e != null) {
            k3.b.f("FlutterSurfaceView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f5930e.v();
            this.f5930e.q(this.f5932g);
        }
        this.f5930e = aVar;
        this.f5929d = true;
        aVar.g(this.f5932g);
        if (this.f5927b) {
            k3.b.f("FlutterSurfaceView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            k();
        }
        this.f5928c = false;
    }

    @Override // w3.c
    public void b() {
        if (this.f5930e == null) {
            k3.b.g("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            k3.b.f("FlutterSurfaceView", "Disconnecting FlutterRenderer from Android surface.");
            l();
        }
        setAlpha(0.0f);
        this.f5930e.q(this.f5932g);
        this.f5930e = null;
        this.f5929d = false;
    }

    @Override // w3.c
    public void d() {
        if (this.f5930e == null) {
            k3.b.g("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
            return;
        }
        this.f5930e = null;
        this.f5928c = true;
        this.f5929d = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i6 = iArr[0];
        region.op(i6, iArr[1], (getRight() + i6) - getLeft(), (iArr[1] + getBottom()) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // w3.c
    public w3.a getAttachedRenderer() {
        return this.f5930e;
    }
}
