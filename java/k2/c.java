package k2;

import android.opengl.Matrix;
import i2.o;
import i2.q0;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f6868a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f6869b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    private final q0<float[]> f6870c = new q0<>();

    /* renamed from: d, reason: collision with root package name */
    private boolean f6871d;

    public static void a(float[] fArr, float[] fArr2) {
        o.j(fArr);
        float f6 = fArr2[10];
        float f7 = fArr2[8];
        float sqrt = (float) Math.sqrt((f6 * f6) + (f7 * f7));
        float f8 = fArr2[10];
        fArr[0] = f8 / sqrt;
        float f9 = fArr2[8];
        fArr[2] = f9 / sqrt;
        fArr[8] = (-f9) / sqrt;
        fArr[10] = f8 / sqrt;
    }

    private static void b(float[] fArr, float[] fArr2) {
        float f6 = fArr2[0];
        float f7 = -fArr2[1];
        float f8 = -fArr2[2];
        float length = Matrix.length(f6, f7, f8);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees(length), f6 / length, f7 / length, f8 / length);
        } else {
            o.j(fArr);
        }
    }

    public boolean c(float[] fArr, long j6) {
        float[] j7 = this.f6870c.j(j6);
        if (j7 == null) {
            return false;
        }
        b(this.f6869b, j7);
        if (!this.f6871d) {
            a(this.f6868a, this.f6869b);
            this.f6871d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f6868a, 0, this.f6869b, 0);
        return true;
    }

    public void d() {
        this.f6870c.c();
        this.f6871d = false;
    }

    public void e(long j6, float[] fArr) {
        this.f6870c.a(j6, fArr);
    }
}
