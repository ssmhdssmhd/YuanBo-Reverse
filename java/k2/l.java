package k2;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import i2.c1;
import i2.o;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import k2.d;
import k2.m;

/* loaded from: classes.dex */
public final class l extends GLSurfaceView {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<b> f6923a;

    /* renamed from: b, reason: collision with root package name */
    private final SensorManager f6924b;

    /* renamed from: c, reason: collision with root package name */
    private final Sensor f6925c;

    /* renamed from: d, reason: collision with root package name */
    private final d f6926d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f6927e;

    /* renamed from: f, reason: collision with root package name */
    private final m f6928f;

    /* renamed from: g, reason: collision with root package name */
    private final i f6929g;

    /* renamed from: h, reason: collision with root package name */
    private SurfaceTexture f6930h;

    /* renamed from: i, reason: collision with root package name */
    private Surface f6931i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f6932j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f6933k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f6934l;

    final class a implements GLSurfaceView.Renderer, m.a, d.a {

        /* renamed from: a, reason: collision with root package name */
        private final i f6935a;

        /* renamed from: d, reason: collision with root package name */
        private final float[] f6938d;

        /* renamed from: e, reason: collision with root package name */
        private final float[] f6939e;

        /* renamed from: f, reason: collision with root package name */
        private final float[] f6940f;

        /* renamed from: g, reason: collision with root package name */
        private float f6941g;

        /* renamed from: h, reason: collision with root package name */
        private float f6942h;

        /* renamed from: b, reason: collision with root package name */
        private final float[] f6936b = new float[16];

        /* renamed from: c, reason: collision with root package name */
        private final float[] f6937c = new float[16];

        /* renamed from: i, reason: collision with root package name */
        private final float[] f6943i = new float[16];

        /* renamed from: j, reason: collision with root package name */
        private final float[] f6944j = new float[16];

        public a(i iVar) {
            float[] fArr = new float[16];
            this.f6938d = fArr;
            float[] fArr2 = new float[16];
            this.f6939e = fArr2;
            float[] fArr3 = new float[16];
            this.f6940f = fArr3;
            this.f6935a = iVar;
            o.j(fArr);
            o.j(fArr2);
            o.j(fArr3);
            this.f6942h = 3.1415927f;
        }

        private float c(float f6) {
            if (f6 > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / f6)) * 2.0d);
            }
            return 90.0f;
        }

        private void d() {
            Matrix.setRotateM(this.f6939e, 0, -this.f6941g, (float) Math.cos(this.f6942h), (float) Math.sin(this.f6942h), 0.0f);
        }

        @Override // k2.d.a
        public synchronized void a(float[] fArr, float f6) {
            float[] fArr2 = this.f6938d;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f6942h = -f6;
            d();
        }

        @Override // k2.m.a
        public synchronized void b(PointF pointF) {
            this.f6941g = pointF.y;
            d();
            Matrix.setRotateM(this.f6940f, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f6944j, 0, this.f6938d, 0, this.f6940f, 0);
                Matrix.multiplyMM(this.f6943i, 0, this.f6939e, 0, this.f6944j, 0);
            }
            Matrix.multiplyMM(this.f6937c, 0, this.f6936b, 0, this.f6943i, 0);
            this.f6935a.c(this.f6937c, false);
        }

        @Override // k2.m.a
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return l.this.performClick();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i6, int i7) {
            GLES20.glViewport(0, 0, i6, i7);
            float f6 = i6 / i7;
            Matrix.perspectiveM(this.f6936b, 0, c(f6), f6, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            l.this.f(this.f6935a.d());
        }
    }

    public interface b {
        void A(Surface surface);

        void i(Surface surface);
    }

    public l(Context context) {
        this(context, null);
    }

    public l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6923a = new CopyOnWriteArrayList<>();
        this.f6927e = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) i2.a.e(context.getSystemService("sensor"));
        this.f6924b = sensorManager;
        Sensor defaultSensor = c1.f5548a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f6925c = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        i iVar = new i();
        this.f6929g = iVar;
        a aVar = new a(iVar);
        m mVar = new m(context, aVar, 25.0f);
        this.f6928f = mVar;
        this.f6926d = new d(((WindowManager) i2.a.e((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), mVar, aVar);
        this.f6932j = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        Surface surface = this.f6931i;
        if (surface != null) {
            Iterator<b> it = this.f6923a.iterator();
            while (it.hasNext()) {
                it.next().i(surface);
            }
        }
        g(this.f6930h, surface);
        this.f6930h = null;
        this.f6931i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f6930h;
        Surface surface = this.f6931i;
        Surface surface2 = new Surface(surfaceTexture);
        this.f6930h = surfaceTexture;
        this.f6931i = surface2;
        Iterator<b> it = this.f6923a.iterator();
        while (it.hasNext()) {
            it.next().A(surface2);
        }
        g(surfaceTexture2, surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final SurfaceTexture surfaceTexture) {
        this.f6927e.post(new Runnable() { // from class: k2.j
            @Override // java.lang.Runnable
            public final void run() {
                l.this.e(surfaceTexture);
            }
        });
    }

    private static void g(SurfaceTexture surfaceTexture, Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    private void i() {
        boolean z5 = this.f6932j && this.f6933k;
        Sensor sensor = this.f6925c;
        if (sensor == null || z5 == this.f6934l) {
            return;
        }
        if (z5) {
            this.f6924b.registerListener(this.f6926d, sensor, 0);
        } else {
            this.f6924b.unregisterListener(this.f6926d);
        }
        this.f6934l = z5;
    }

    public k2.a getCameraMotionListener() {
        return this.f6929g;
    }

    public j2.m getVideoFrameMetadataListener() {
        return this.f6929g;
    }

    public Surface getVideoSurface() {
        return this.f6931i;
    }

    public void h(b bVar) {
        this.f6923a.remove(bVar);
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f6927e.post(new Runnable() { // from class: k2.k
            @Override // java.lang.Runnable
            public final void run() {
                l.this.d();
            }
        });
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f6933k = false;
        i();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f6933k = true;
        i();
    }

    public void setDefaultStereoMode(int i6) {
        this.f6929g.f(i6);
    }

    public void setUseSensorRotation(boolean z5) {
        this.f6932j = z5;
        i();
    }
}
