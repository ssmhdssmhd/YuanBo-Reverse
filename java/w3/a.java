package w3;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.view.t;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class a implements t {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterJNI f10226a;

    /* renamed from: c, reason: collision with root package name */
    private Surface f10228c;

    /* renamed from: g, reason: collision with root package name */
    private final w3.b f10232g;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicLong f10227b = new AtomicLong(0);

    /* renamed from: d, reason: collision with root package name */
    private boolean f10229d = false;

    /* renamed from: e, reason: collision with root package name */
    private Handler f10230e = new Handler();

    /* renamed from: f, reason: collision with root package name */
    private final Set<WeakReference<t.b>> f10231f = new HashSet();

    /* renamed from: w3.a$a, reason: collision with other inner class name */
    class C0158a implements w3.b {
        C0158a() {
        }

        @Override // w3.b
        public void c() {
            a.this.f10229d = false;
        }

        @Override // w3.b
        public void f() {
            a.this.f10229d = true;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f10234a;

        /* renamed from: b, reason: collision with root package name */
        public final d f10235b;

        /* renamed from: c, reason: collision with root package name */
        public final c f10236c;

        public b(Rect rect, d dVar) {
            this.f10234a = rect;
            this.f10235b = dVar;
            this.f10236c = c.UNKNOWN;
        }

        public b(Rect rect, d dVar, c cVar) {
            this.f10234a = rect;
            this.f10235b = dVar;
            this.f10236c = cVar;
        }
    }

    public enum c {
        UNKNOWN(0),
        POSTURE_FLAT(1),
        POSTURE_HALF_OPENED(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f10241a;

        c(int i6) {
            this.f10241a = i6;
        }
    }

    public enum d {
        UNKNOWN(0),
        FOLD(1),
        HINGE(2),
        CUTOUT(3);


        /* renamed from: a, reason: collision with root package name */
        public final int f10247a;

        d(int i6) {
            this.f10247a = i6;
        }
    }

    static final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final long f10248a;

        /* renamed from: b, reason: collision with root package name */
        private final FlutterJNI f10249b;

        e(long j6, FlutterJNI flutterJNI) {
            this.f10248a = j6;
            this.f10249b = flutterJNI;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f10249b.isAttached()) {
                k3.b.f("FlutterRenderer", "Releasing a SurfaceTexture (" + this.f10248a + ").");
                this.f10249b.unregisterTexture(this.f10248a);
            }
        }
    }

    final class f implements t.c, t.b {

        /* renamed from: a, reason: collision with root package name */
        private final long f10250a;

        /* renamed from: b, reason: collision with root package name */
        private final SurfaceTextureWrapper f10251b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f10252c;

        /* renamed from: d, reason: collision with root package name */
        private t.b f10253d;

        /* renamed from: e, reason: collision with root package name */
        private t.a f10254e;

        /* renamed from: f, reason: collision with root package name */
        private final Runnable f10255f;

        /* renamed from: g, reason: collision with root package name */
        private SurfaceTexture.OnFrameAvailableListener f10256g;

        /* renamed from: w3.a$f$a, reason: collision with other inner class name */
        class RunnableC0159a implements Runnable {
            RunnableC0159a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (f.this.f10254e != null) {
                    f.this.f10254e.a();
                }
            }
        }

        class b implements SurfaceTexture.OnFrameAvailableListener {
            b() {
            }

            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (f.this.f10252c || !a.this.f10226a.isAttached()) {
                    return;
                }
                f fVar = f.this;
                a.this.m(fVar.f10250a);
            }
        }

        f(long j6, SurfaceTexture surfaceTexture) {
            RunnableC0159a runnableC0159a = new RunnableC0159a();
            this.f10255f = runnableC0159a;
            this.f10256g = new b();
            this.f10250a = j6;
            this.f10251b = new SurfaceTextureWrapper(surfaceTexture, runnableC0159a);
            d().setOnFrameAvailableListener(this.f10256g, new Handler());
        }

        private void i() {
            a.this.r(this);
        }

        @Override // io.flutter.view.t.c
        public void a() {
            if (this.f10252c) {
                return;
            }
            k3.b.f("FlutterRenderer", "Releasing a SurfaceTexture (" + this.f10250a + ").");
            this.f10251b.release();
            a.this.y(this.f10250a);
            i();
            this.f10252c = true;
        }

        @Override // io.flutter.view.t.c
        public void b(t.b bVar) {
            this.f10253d = bVar;
        }

        @Override // io.flutter.view.t.c
        public void c(t.a aVar) {
            this.f10254e = aVar;
        }

        @Override // io.flutter.view.t.c
        public SurfaceTexture d() {
            return this.f10251b.surfaceTexture();
        }

        @Override // io.flutter.view.t.c
        public long e() {
            return this.f10250a;
        }

        protected void finalize() {
            try {
                if (this.f10252c) {
                    return;
                }
                a.this.f10230e.post(new e(this.f10250a, a.this.f10226a));
            } finally {
                super.finalize();
            }
        }

        public SurfaceTextureWrapper j() {
            return this.f10251b;
        }

        @Override // io.flutter.view.t.b
        public void onTrimMemory(int i6) {
            t.b bVar = this.f10253d;
            if (bVar != null) {
                bVar.onTrimMemory(i6);
            }
        }
    }

    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public float f10260a = 1.0f;

        /* renamed from: b, reason: collision with root package name */
        public int f10261b = 0;

        /* renamed from: c, reason: collision with root package name */
        public int f10262c = 0;

        /* renamed from: d, reason: collision with root package name */
        public int f10263d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f10264e = 0;

        /* renamed from: f, reason: collision with root package name */
        public int f10265f = 0;

        /* renamed from: g, reason: collision with root package name */
        public int f10266g = 0;

        /* renamed from: h, reason: collision with root package name */
        public int f10267h = 0;

        /* renamed from: i, reason: collision with root package name */
        public int f10268i = 0;

        /* renamed from: j, reason: collision with root package name */
        public int f10269j = 0;

        /* renamed from: k, reason: collision with root package name */
        public int f10270k = 0;

        /* renamed from: l, reason: collision with root package name */
        public int f10271l = 0;

        /* renamed from: m, reason: collision with root package name */
        public int f10272m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f10273n = 0;

        /* renamed from: o, reason: collision with root package name */
        public int f10274o = 0;

        /* renamed from: p, reason: collision with root package name */
        public int f10275p = -1;

        /* renamed from: q, reason: collision with root package name */
        public List<b> f10276q = new ArrayList();

        boolean a() {
            return this.f10261b > 0 && this.f10262c > 0 && this.f10260a > 0.0f;
        }
    }

    public a(FlutterJNI flutterJNI) {
        C0158a c0158a = new C0158a();
        this.f10232g = c0158a;
        this.f10226a = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(c0158a);
    }

    private void i() {
        Iterator<WeakReference<t.b>> it = this.f10231f.iterator();
        while (it.hasNext()) {
            if (it.next().get() == null) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(long j6) {
        this.f10226a.markTextureFrameAvailable(j6);
    }

    private void p(long j6, SurfaceTextureWrapper surfaceTextureWrapper) {
        this.f10226a.registerTexture(j6, surfaceTextureWrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(long j6) {
        this.f10226a.unregisterTexture(j6);
    }

    @Override // io.flutter.view.t
    public t.c a() {
        k3.b.f("FlutterRenderer", "Creating a SurfaceTexture.");
        return o(new SurfaceTexture(0));
    }

    public void g(w3.b bVar) {
        this.f10226a.addIsDisplayingFlutterUiListener(bVar);
        if (this.f10229d) {
            bVar.f();
        }
    }

    void h(t.b bVar) {
        i();
        this.f10231f.add(new WeakReference<>(bVar));
    }

    public void j(ByteBuffer byteBuffer, int i6) {
        this.f10226a.dispatchPointerDataPacket(byteBuffer, i6);
    }

    public boolean k() {
        return this.f10229d;
    }

    public boolean l() {
        return this.f10226a.getIsSoftwareRenderingEnabled();
    }

    public void n(int i6) {
        Iterator<WeakReference<t.b>> it = this.f10231f.iterator();
        while (it.hasNext()) {
            t.b bVar = it.next().get();
            if (bVar != null) {
                bVar.onTrimMemory(i6);
            } else {
                it.remove();
            }
        }
    }

    public t.c o(SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        f fVar = new f(this.f10227b.getAndIncrement(), surfaceTexture);
        k3.b.f("FlutterRenderer", "New SurfaceTexture ID: " + fVar.e());
        p(fVar.e(), fVar.j());
        h(fVar);
        return fVar;
    }

    public void q(w3.b bVar) {
        this.f10226a.removeIsDisplayingFlutterUiListener(bVar);
    }

    void r(t.b bVar) {
        for (WeakReference<t.b> weakReference : this.f10231f) {
            if (weakReference.get() == bVar) {
                this.f10231f.remove(weakReference);
                return;
            }
        }
    }

    public void s(boolean z5) {
        this.f10226a.setSemanticsEnabled(z5);
    }

    public void t(g gVar) {
        if (gVar.a()) {
            k3.b.f("FlutterRenderer", "Setting viewport metrics\nSize: " + gVar.f10261b + " x " + gVar.f10262c + "\nPadding - L: " + gVar.f10266g + ", T: " + gVar.f10263d + ", R: " + gVar.f10264e + ", B: " + gVar.f10265f + "\nInsets - L: " + gVar.f10270k + ", T: " + gVar.f10267h + ", R: " + gVar.f10268i + ", B: " + gVar.f10269j + "\nSystem Gesture Insets - L: " + gVar.f10274o + ", T: " + gVar.f10271l + ", R: " + gVar.f10272m + ", B: " + gVar.f10272m + "\nDisplay Features: " + gVar.f10276q.size());
            int[] iArr = new int[gVar.f10276q.size() * 4];
            int[] iArr2 = new int[gVar.f10276q.size()];
            int[] iArr3 = new int[gVar.f10276q.size()];
            for (int i6 = 0; i6 < gVar.f10276q.size(); i6++) {
                b bVar = gVar.f10276q.get(i6);
                int i7 = i6 * 4;
                Rect rect = bVar.f10234a;
                iArr[i7] = rect.left;
                iArr[i7 + 1] = rect.top;
                iArr[i7 + 2] = rect.right;
                iArr[i7 + 3] = rect.bottom;
                iArr2[i6] = bVar.f10235b.f10247a;
                iArr3[i6] = bVar.f10236c.f10241a;
            }
            this.f10226a.setViewportMetrics(gVar.f10260a, gVar.f10261b, gVar.f10262c, gVar.f10263d, gVar.f10264e, gVar.f10265f, gVar.f10266g, gVar.f10267h, gVar.f10268i, gVar.f10269j, gVar.f10270k, gVar.f10271l, gVar.f10272m, gVar.f10273n, gVar.f10274o, gVar.f10275p, iArr, iArr2, iArr3);
        }
    }

    public void u(Surface surface, boolean z5) {
        if (this.f10228c != null && !z5) {
            v();
        }
        this.f10228c = surface;
        this.f10226a.onSurfaceCreated(surface);
    }

    public void v() {
        this.f10226a.onSurfaceDestroyed();
        this.f10228c = null;
        if (this.f10229d) {
            this.f10232g.c();
        }
        this.f10229d = false;
    }

    public void w(int i6, int i7) {
        this.f10226a.onSurfaceChanged(i6, i7);
    }

    public void x(Surface surface) {
        this.f10228c = surface;
        this.f10226a.onSurfaceWindowChanged(surface);
    }
}
