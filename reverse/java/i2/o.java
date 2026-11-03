package i2;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f5630a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f5631b = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f5632c = {12344};

    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static void a(int i6, int i7) {
        GLES20.glBindTexture(i6, i7);
        b();
        GLES20.glTexParameteri(i6, 10240, 9729);
        b();
        GLES20.glTexParameteri(i6, 10241, 9729);
        b();
        GLES20.glTexParameteri(i6, 10242, 33071);
        b();
        GLES20.glTexParameteri(i6, 10243, 33071);
        b();
    }

    public static void b() {
        StringBuilder sb = new StringBuilder();
        boolean z5 = false;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            if (z5) {
                sb.append('\n');
            }
            sb.append("glError: ");
            sb.append(GLU.gluErrorString(glGetError));
            z5 = true;
        }
        if (z5) {
            throw new a(sb.toString());
        }
    }

    public static void c(boolean z5, String str) {
        if (!z5) {
            throw new a(str);
        }
    }

    private static FloatBuffer d(int i6) {
        return ByteBuffer.allocateDirect(i6 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer e(float[] fArr) {
        return (FloatBuffer) d(fArr.length).put(fArr).flip();
    }

    public static int f() {
        int g6 = g();
        a(36197, g6);
        return g6;
    }

    private static int g() {
        c(!c1.c(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT), "No current context");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        b();
        return iArr[0];
    }

    public static boolean h(Context context) {
        String eglQueryString;
        int i6 = c1.f5548a;
        if (i6 < 24) {
            return false;
        }
        if (i6 >= 26 || !("samsung".equals(c1.f5550c) || "XT1650".equals(c1.f5551d))) {
            return (i6 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean i() {
        String eglQueryString;
        return c1.f5548a >= 17 && (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && eglQueryString.contains("EGL_KHR_surfaceless_context");
    }

    public static void j(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }
}
