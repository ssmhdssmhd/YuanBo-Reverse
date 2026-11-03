package k2;

import android.opengl.GLES20;
import android.util.Log;
import i2.n;
import i2.o;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import k2.e;

/* loaded from: classes.dex */
final class g {

    /* renamed from: j, reason: collision with root package name */
    private static final float[] f6888j = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    private static final float[] f6889k = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: l, reason: collision with root package name */
    private static final float[] f6890l = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: m, reason: collision with root package name */
    private static final float[] f6891m = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: n, reason: collision with root package name */
    private static final float[] f6892n = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    private int f6893a;

    /* renamed from: b, reason: collision with root package name */
    private a f6894b;

    /* renamed from: c, reason: collision with root package name */
    private a f6895c;

    /* renamed from: d, reason: collision with root package name */
    private n f6896d;

    /* renamed from: e, reason: collision with root package name */
    private int f6897e;

    /* renamed from: f, reason: collision with root package name */
    private int f6898f;

    /* renamed from: g, reason: collision with root package name */
    private int f6899g;

    /* renamed from: h, reason: collision with root package name */
    private int f6900h;

    /* renamed from: i, reason: collision with root package name */
    private int f6901i;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f6902a;

        /* renamed from: b, reason: collision with root package name */
        private final FloatBuffer f6903b;

        /* renamed from: c, reason: collision with root package name */
        private final FloatBuffer f6904c;

        /* renamed from: d, reason: collision with root package name */
        private final int f6905d;

        public a(e.b bVar) {
            this.f6902a = bVar.a();
            this.f6903b = o.e(bVar.f6886c);
            this.f6904c = o.e(bVar.f6887d);
            int i6 = bVar.f6885b;
            this.f6905d = i6 != 1 ? i6 != 2 ? 4 : 6 : 5;
        }
    }

    g() {
    }

    public static boolean c(e eVar) {
        e.a aVar = eVar.f6879a;
        e.a aVar2 = eVar.f6880b;
        return aVar.b() == 1 && aVar.a(0).f6884a == 0 && aVar2.b() == 1 && aVar2.a(0).f6884a == 0;
    }

    public void a(int i6, float[] fArr, boolean z5) {
        a aVar = z5 ? this.f6895c : this.f6894b;
        if (aVar == null) {
            return;
        }
        int i7 = this.f6893a;
        GLES20.glUniformMatrix3fv(this.f6898f, 1, false, i7 == 1 ? z5 ? f6890l : f6889k : i7 == 2 ? z5 ? f6892n : f6891m : f6888j, 0);
        GLES20.glUniformMatrix4fv(this.f6897e, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i6);
        GLES20.glUniform1i(this.f6901i, 0);
        try {
            o.b();
        } catch (o.a e6) {
            Log.e("ProjectionRenderer", "Failed to bind uniforms", e6);
        }
        GLES20.glVertexAttribPointer(this.f6899g, 3, 5126, false, 12, (Buffer) aVar.f6903b);
        try {
            o.b();
        } catch (o.a e7) {
            Log.e("ProjectionRenderer", "Failed to load position data", e7);
        }
        GLES20.glVertexAttribPointer(this.f6900h, 2, 5126, false, 8, (Buffer) aVar.f6904c);
        try {
            o.b();
        } catch (o.a e8) {
            Log.e("ProjectionRenderer", "Failed to load texture data", e8);
        }
        GLES20.glDrawArrays(aVar.f6905d, 0, aVar.f6902a);
        try {
            o.b();
        } catch (o.a e9) {
            Log.e("ProjectionRenderer", "Failed to render", e9);
        }
    }

    public void b() {
        try {
            n nVar = new n("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
            this.f6896d = nVar;
            this.f6897e = nVar.j("uMvpMatrix");
            this.f6898f = this.f6896d.j("uTexMatrix");
            this.f6899g = this.f6896d.e("aPosition");
            this.f6900h = this.f6896d.e("aTexCoords");
            this.f6901i = this.f6896d.j("uTexture");
        } catch (o.a e6) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e6);
        }
    }

    public void d(e eVar) {
        if (c(eVar)) {
            this.f6893a = eVar.f6881c;
            a aVar = new a(eVar.f6879a.a(0));
            this.f6894b = aVar;
            if (!eVar.f6882d) {
                aVar = new a(eVar.f6880b.a(0));
            }
            this.f6895c = aVar;
        }
    }
}
