package k2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;

/* loaded from: classes.dex */
final class d implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f6872a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f6873b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    private final float[] f6874c = new float[16];

    /* renamed from: d, reason: collision with root package name */
    private final float[] f6875d = new float[3];

    /* renamed from: e, reason: collision with root package name */
    private final Display f6876e;

    /* renamed from: f, reason: collision with root package name */
    private final a[] f6877f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f6878g;

    public interface a {
        void a(float[] fArr, float f6);
    }

    public d(Display display, a... aVarArr) {
        this.f6876e = display;
        this.f6877f = aVarArr;
    }

    private float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.f6873b);
        SensorManager.getOrientation(this.f6873b, this.f6875d);
        return this.f6875d[2];
    }

    private void b(float[] fArr, float f6) {
        for (a aVar : this.f6877f) {
            aVar.a(fArr, f6);
        }
    }

    private void c(float[] fArr) {
        if (!this.f6878g) {
            c.a(this.f6874c, fArr);
            this.f6878g = true;
        }
        float[] fArr2 = this.f6873b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f6873b, 0, this.f6874c, 0);
    }

    private void d(float[] fArr, int i6) {
        if (i6 != 0) {
            int i7 = 129;
            int i8 = 1;
            if (i6 == 1) {
                i7 = 2;
                i8 = 129;
            } else if (i6 == 2) {
                i8 = 130;
            } else {
                if (i6 != 3) {
                    throw new IllegalStateException();
                }
                i7 = 130;
            }
            float[] fArr2 = this.f6873b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f6873b, i7, i8, fArr);
        }
    }

    private static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i6) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f6872a, sensorEvent.values);
        d(this.f6872a, this.f6876e.getRotation());
        float a6 = a(this.f6872a);
        e(this.f6872a);
        c(this.f6872a);
        b(this.f6872a, a6);
    }
}
