package i2;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;

/* loaded from: classes.dex */
public final class k implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f5590k = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* renamed from: a, reason: collision with root package name */
    private final Handler f5591a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f5592b;

    /* renamed from: c, reason: collision with root package name */
    private EGLDisplay f5593c;

    /* renamed from: d, reason: collision with root package name */
    private EGLContext f5594d;

    /* renamed from: e, reason: collision with root package name */
    private EGLSurface f5595e;

    /* renamed from: j, reason: collision with root package name */
    private SurfaceTexture f5596j;

    public interface a {
    }

    public k(Handler handler) {
        this(handler, null);
    }

    public k(Handler handler, a aVar) {
        this.f5591a = handler;
        this.f5592b = new int[1];
    }

    private static EGLConfig a(EGLDisplay eGLDisplay) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean eglChooseConfig = EGL14.eglChooseConfig(eGLDisplay, f5590k, 0, eGLConfigArr, 0, 1, iArr, 0);
        o.c(eglChooseConfig && iArr[0] > 0 && eGLConfigArr[0] != null, c1.C("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr[0]), eGLConfigArr[0]));
        return eGLConfigArr[0];
    }

    private static EGLContext b(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i6) {
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, i6 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        o.c(eglCreateContext != null, "eglCreateContext failed");
        return eglCreateContext;
    }

    private static EGLSurface c(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i6) {
        EGLSurface eglCreatePbufferSurface;
        if (i6 == 1) {
            eglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i6 == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            o.c(eglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
        }
        o.c(EGL14.eglMakeCurrent(eGLDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eGLContext), "eglMakeCurrent failed");
        return eglCreatePbufferSurface;
    }

    private void d() {
    }

    private static void e(int[] iArr) {
        GLES20.glGenTextures(1, iArr, 0);
        o.b();
    }

    private static EGLDisplay f() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        o.c(eglGetDisplay != null, "eglGetDisplay failed");
        int[] iArr = new int[2];
        o.c(EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1), "eglInitialize failed");
        return eglGetDisplay;
    }

    public SurfaceTexture g() {
        return (SurfaceTexture) i2.a.e(this.f5596j);
    }

    public void h(int i6) {
        EGLDisplay f6 = f();
        this.f5593c = f6;
        EGLConfig a6 = a(f6);
        EGLContext b6 = b(this.f5593c, a6, i6);
        this.f5594d = b6;
        this.f5595e = c(this.f5593c, a6, b6, i6);
        e(this.f5592b);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f5592b[0]);
        this.f5596j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        this.f5591a.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.f5596j;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.f5592b, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.f5593c;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.f5593c;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.f5595e;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f5593c, this.f5595e);
            }
            EGLContext eGLContext = this.f5594d;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f5593c, eGLContext);
            }
            if (c1.f5548a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = this.f5593c;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.f5593c);
            }
            this.f5593c = null;
            this.f5594d = null;
            this.f5595e = null;
            this.f5596j = null;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f5591a.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        d();
        SurfaceTexture surfaceTexture = this.f5596j;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }
}
