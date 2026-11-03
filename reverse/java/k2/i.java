package k2;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import h0.y1;
import i2.o;
import i2.q0;
import i2.t;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
final class i implements j2.m, a {

    /* renamed from: m, reason: collision with root package name */
    private int f6915m;

    /* renamed from: n, reason: collision with root package name */
    private SurfaceTexture f6916n;

    /* renamed from: q, reason: collision with root package name */
    private byte[] f6919q;

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f6907a = new AtomicBoolean();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f6908b = new AtomicBoolean(true);

    /* renamed from: c, reason: collision with root package name */
    private final g f6909c = new g();

    /* renamed from: d, reason: collision with root package name */
    private final c f6910d = new c();

    /* renamed from: e, reason: collision with root package name */
    private final q0<Long> f6911e = new q0<>();

    /* renamed from: j, reason: collision with root package name */
    private final q0<e> f6912j = new q0<>();

    /* renamed from: k, reason: collision with root package name */
    private final float[] f6913k = new float[16];

    /* renamed from: l, reason: collision with root package name */
    private final float[] f6914l = new float[16];

    /* renamed from: o, reason: collision with root package name */
    private volatile int f6917o = 0;

    /* renamed from: p, reason: collision with root package name */
    private int f6918p = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(SurfaceTexture surfaceTexture) {
        this.f6907a.set(true);
    }

    private void g(byte[] bArr, int i6, long j6) {
        byte[] bArr2 = this.f6919q;
        int i7 = this.f6918p;
        this.f6919q = bArr;
        if (i6 == -1) {
            i6 = this.f6917o;
        }
        this.f6918p = i6;
        if (i7 == i6 && Arrays.equals(bArr2, this.f6919q)) {
            return;
        }
        byte[] bArr3 = this.f6919q;
        e a6 = bArr3 != null ? f.a(bArr3, this.f6918p) : null;
        if (a6 == null || !g.c(a6)) {
            a6 = e.b(this.f6918p);
        }
        this.f6912j.a(j6, a6);
    }

    @Override // k2.a
    public void a(long j6, float[] fArr) {
        this.f6910d.e(j6, fArr);
    }

    public void c(float[] fArr, boolean z5) {
        GLES20.glClear(16384);
        try {
            o.b();
        } catch (o.a e6) {
            t.d("SceneRenderer", "Failed to draw a frame", e6);
        }
        if (this.f6907a.compareAndSet(true, false)) {
            ((SurfaceTexture) i2.a.e(this.f6916n)).updateTexImage();
            try {
                o.b();
            } catch (o.a e7) {
                t.d("SceneRenderer", "Failed to draw a frame", e7);
            }
            if (this.f6908b.compareAndSet(true, false)) {
                o.j(this.f6913k);
            }
            long timestamp = this.f6916n.getTimestamp();
            Long g6 = this.f6911e.g(timestamp);
            if (g6 != null) {
                this.f6910d.c(this.f6913k, g6.longValue());
            }
            e j6 = this.f6912j.j(timestamp);
            if (j6 != null) {
                this.f6909c.d(j6);
            }
        }
        Matrix.multiplyMM(this.f6914l, 0, fArr, 0, this.f6913k, 0);
        this.f6909c.a(this.f6915m, this.f6914l, z5);
    }

    public SurfaceTexture d() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            o.b();
            this.f6909c.b();
            o.b();
            this.f6915m = o.f();
        } catch (o.a e6) {
            t.d("SceneRenderer", "Failed to initialize the renderer", e6);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f6915m);
        this.f6916n = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: k2.h
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                i.this.e(surfaceTexture2);
            }
        });
        return this.f6916n;
    }

    public void f(int i6) {
        this.f6917o = i6;
    }

    @Override // j2.m
    public void h(long j6, long j7, y1 y1Var, MediaFormat mediaFormat) {
        this.f6911e.a(j7, Long.valueOf(j6));
        g(y1Var.f5076z, y1Var.A, j7);
    }

    @Override // k2.a
    public void i() {
        this.f6911e.c();
        this.f6910d.d();
        this.f6908b.set(true);
    }
}
