package i2;

import android.opengl.GLES20;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final int f5613a;

    /* renamed from: b, reason: collision with root package name */
    private final a[] f5614b;

    /* renamed from: c, reason: collision with root package name */
    private final b[] f5615c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, a> f5616d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, b> f5617e;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f5618a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5619b;

        /* renamed from: c, reason: collision with root package name */
        private final int f5620c;

        private a(String str, int i6, int i7) {
            this.f5618a = str;
            this.f5619b = i6;
            this.f5620c = i7;
        }

        public static a a(int i6, int i7) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i6, 35722, iArr, 0);
            int i8 = iArr[0];
            byte[] bArr = new byte[i8];
            GLES20.glGetActiveAttrib(i6, i7, i8, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, n.h(bArr));
            return new a(str, i7, n.f(i6, str));
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f5621a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5622b;

        /* renamed from: c, reason: collision with root package name */
        private final int f5623c;

        /* renamed from: d, reason: collision with root package name */
        private final float[] f5624d = new float[16];

        private b(String str, int i6, int i7) {
            this.f5621a = str;
            this.f5622b = i6;
            this.f5623c = i7;
        }

        public static b a(int i6, int i7) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i6, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i8 = iArr[0];
            byte[] bArr = new byte[i8];
            GLES20.glGetActiveUniform(i6, i7, i8, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, n.h(bArr));
            return new b(str, n.i(i6, str), iArr2[0]);
        }
    }

    public n(String str, String str2) {
        int glCreateProgram = GLES20.glCreateProgram();
        this.f5613a = glCreateProgram;
        o.b();
        d(glCreateProgram, 35633, str);
        d(glCreateProgram, 35632, str2);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        o.c(iArr[0] == 1, "Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glUseProgram(glCreateProgram);
        this.f5616d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35721, iArr2, 0);
        this.f5614b = new a[iArr2[0]];
        for (int i6 = 0; i6 < iArr2[0]; i6++) {
            a a6 = a.a(this.f5613a, i6);
            this.f5614b[i6] = a6;
            this.f5616d.put(a6.f5618a, a6);
        }
        this.f5617e = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.f5613a, 35718, iArr3, 0);
        this.f5615c = new b[iArr3[0]];
        for (int i7 = 0; i7 < iArr3[0]; i7++) {
            b a7 = b.a(this.f5613a, i7);
            this.f5615c[i7] = a7;
            this.f5617e.put(a7.f5621a, a7);
        }
        o.b();
    }

    private static void d(int i6, int i7, String str) {
        int glCreateShader = GLES20.glCreateShader(i7);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        o.c(iArr[0] == 1, GLES20.glGetShaderInfoLog(glCreateShader) + ", source: " + str);
        GLES20.glAttachShader(i6, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        o.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(int i6, String str) {
        return GLES20.glGetAttribLocation(i6, str);
    }

    private int g(String str) {
        return f(this.f5613a, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(byte[] bArr) {
        for (int i6 = 0; i6 < bArr.length; i6++) {
            if (bArr[i6] == 0) {
                return i6;
            }
        }
        return bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(int i6, String str) {
        return GLES20.glGetUniformLocation(i6, str);
    }

    public int e(String str) {
        int g6 = g(str);
        GLES20.glEnableVertexAttribArray(g6);
        o.b();
        return g6;
    }

    public int j(String str) {
        return i(this.f5613a, str);
    }
}
