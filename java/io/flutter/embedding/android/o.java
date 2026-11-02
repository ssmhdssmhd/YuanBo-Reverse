package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;

/* loaded from: classes.dex */
public class o extends TextureView implements w3.c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f5935a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5936b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5937c;

    /* renamed from: d, reason: collision with root package name */
    private w3.a f5938d;

    /* renamed from: e, reason: collision with root package name */
    private Surface f5939e;

    /* renamed from: f, reason: collision with root package name */
    private final TextureView.SurfaceTextureListener f5940f;

    class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i6, int i7) {
            k3.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
            o.this.f5935a = true;
            if (o.this.f5936b) {
                o.this.l();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            k3.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
            o.this.f5935a = false;
            if (o.this.f5936b) {
                o.this.m();
            }
            if (o.this.f5939e == null) {
                return true;
            }
            o.this.f5939e.release();
            o.this.f5939e = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i6, int i7) {
            k3.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
            if (o.this.f5936b) {
                o.this.k(i6, i7);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public o(Context context) {
        this(context, null);
    }

    public o(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5935a = false;
        this.f5936b = false;
        this.f5937c = false;
        this.f5940f = new a();
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i6, int i7) {
        if (this.f5938d == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        k3.b.f("FlutterTextureView", "Notifying FlutterRenderer that Android surface size has changed to " + i6 + " x " + i7);
        this.f5938d.w(i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f5938d == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        Surface surface = this.f5939e;
        if (surface != null) {
            surface.release();
            this.f5939e = null;
        }
        Surface surface2 = new Surface(getSurfaceTexture());
        this.f5939e = surface2;
        this.f5938d.u(surface2, this.f5937c);
        this.f5937c = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        w3.a aVar = this.f5938d;
        if (aVar == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        aVar.v();
        Surface surface = this.f5939e;
        if (surface != null) {
            surface.release();
            this.f5939e = null;
        }
    }

    private void n() {
        setSurfaceTextureListener(this.f5940f);
    }

    @Override // w3.c
    public void a(w3.a aVar) {
        k3.b.f("FlutterTextureView", "Attaching to FlutterRenderer.");
        if (this.f5938d != null) {
            k3.b.f("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f5938d.v();
        }
        this.f5938d = aVar;
        this.f5936b = true;
        if (this.f5935a) {
            k3.b.f("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            l();
        }
    }

    @Override // w3.c
    public void b() {
        if (this.f5938d == null) {
            k3.b.g("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            k3.b.f("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
            m();
        }
        this.f5938d = null;
        this.f5936b = false;
    }

    @Override // w3.c
    public void d() {
        if (this.f5938d == null) {
            k3.b.g("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
            return;
        }
        this.f5938d = null;
        this.f5937c = true;
        this.f5936b = false;
    }

    @Override // w3.c
    public w3.a getAttachedRenderer() {
        return this.f5938d;
    }

    public void setRenderSurface(Surface surface) {
        this.f5939e = surface;
    }
}
