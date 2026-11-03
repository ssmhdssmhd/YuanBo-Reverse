package j2;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import i2.c1;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final j2.e f6757a = new j2.e();

    /* renamed from: b, reason: collision with root package name */
    private final b f6758b;

    /* renamed from: c, reason: collision with root package name */
    private final e f6759c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6760d;

    /* renamed from: e, reason: collision with root package name */
    private Surface f6761e;

    /* renamed from: f, reason: collision with root package name */
    private float f6762f;

    /* renamed from: g, reason: collision with root package name */
    private float f6763g;

    /* renamed from: h, reason: collision with root package name */
    private float f6764h;

    /* renamed from: i, reason: collision with root package name */
    private float f6765i;

    /* renamed from: j, reason: collision with root package name */
    private int f6766j;

    /* renamed from: k, reason: collision with root package name */
    private long f6767k;

    /* renamed from: l, reason: collision with root package name */
    private long f6768l;

    /* renamed from: m, reason: collision with root package name */
    private long f6769m;

    /* renamed from: n, reason: collision with root package name */
    private long f6770n;

    /* renamed from: o, reason: collision with root package name */
    private long f6771o;

    /* renamed from: p, reason: collision with root package name */
    private long f6772p;

    /* renamed from: q, reason: collision with root package name */
    private long f6773q;

    private static final class a {
        public static void a(Surface surface, float f6) {
            try {
                surface.setFrameRate(f6, f6 == 0.0f ? 0 : 1);
            } catch (IllegalStateException e6) {
                i2.t.d("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface b {

        public interface a {
            void a(Display display);
        }

        void a(a aVar);

        void b();
    }

    private static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final WindowManager f6774a;

        private c(WindowManager windowManager) {
            this.f6774a = windowManager;
        }

        public static b c(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new c(windowManager);
            }
            return null;
        }

        @Override // j2.p.b
        public void a(b.a aVar) {
            aVar.a(this.f6774a.getDefaultDisplay());
        }

        @Override // j2.p.b
        public void b() {
        }
    }

    private static final class d implements b, DisplayManager.DisplayListener {

        /* renamed from: a, reason: collision with root package name */
        private final DisplayManager f6775a;

        /* renamed from: b, reason: collision with root package name */
        private b.a f6776b;

        private d(DisplayManager displayManager) {
            this.f6775a = displayManager;
        }

        private Display c() {
            return this.f6775a.getDisplay(0);
        }

        public static b d(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager != null) {
                return new d(displayManager);
            }
            return null;
        }

        @Override // j2.p.b
        public void a(b.a aVar) {
            this.f6776b = aVar;
            this.f6775a.registerDisplayListener(this, c1.w());
            aVar.a(c());
        }

        @Override // j2.p.b
        public void b() {
            this.f6775a.unregisterDisplayListener(this);
            this.f6776b = null;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i6) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i6) {
            b.a aVar = this.f6776b;
            if (aVar == null || i6 != 0) {
                return;
            }
            aVar.a(c());
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i6) {
        }
    }

    private static final class e implements Choreographer.FrameCallback, Handler.Callback {

        /* renamed from: j, reason: collision with root package name */
        private static final e f6777j = new e();

        /* renamed from: a, reason: collision with root package name */
        public volatile long f6778a = -9223372036854775807L;

        /* renamed from: b, reason: collision with root package name */
        private final Handler f6779b;

        /* renamed from: c, reason: collision with root package name */
        private final HandlerThread f6780c;

        /* renamed from: d, reason: collision with root package name */
        private Choreographer f6781d;

        /* renamed from: e, reason: collision with root package name */
        private int f6782e;

        private e() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.f6780c = handlerThread;
            handlerThread.start();
            Handler v5 = c1.v(handlerThread.getLooper(), this);
            this.f6779b = v5;
            v5.sendEmptyMessage(0);
        }

        private void b() {
            Choreographer choreographer = this.f6781d;
            if (choreographer != null) {
                int i6 = this.f6782e + 1;
                this.f6782e = i6;
                if (i6 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        private void c() {
            try {
                this.f6781d = Choreographer.getInstance();
            } catch (RuntimeException e6) {
                i2.t.j("VideoFrameReleaseHelper", "Vsync sampling disabled due to platform error", e6);
            }
        }

        public static e d() {
            return f6777j;
        }

        private void f() {
            Choreographer choreographer = this.f6781d;
            if (choreographer != null) {
                int i6 = this.f6782e - 1;
                this.f6782e = i6;
                if (i6 == 0) {
                    choreographer.removeFrameCallback(this);
                    this.f6778a = -9223372036854775807L;
                }
            }
        }

        public void a() {
            this.f6779b.sendEmptyMessage(1);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j6) {
            this.f6778a = j6;
            ((Choreographer) i2.a.e(this.f6781d)).postFrameCallbackDelayed(this, 500L);
        }

        public void e() {
            this.f6779b.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i6 = message.what;
            if (i6 == 0) {
                c();
                return true;
            }
            if (i6 == 1) {
                b();
                return true;
            }
            if (i6 != 2) {
                return false;
            }
            f();
            return true;
        }
    }

    public p(Context context) {
        b f6 = f(context);
        this.f6758b = f6;
        this.f6759c = f6 != null ? e.d() : null;
        this.f6767k = -9223372036854775807L;
        this.f6768l = -9223372036854775807L;
        this.f6762f = -1.0f;
        this.f6765i = 1.0f;
        this.f6766j = 0;
    }

    private static boolean c(long j6, long j7) {
        return Math.abs(j6 - j7) <= 20000000;
    }

    private void d() {
        Surface surface;
        if (c1.f5548a < 30 || (surface = this.f6761e) == null || this.f6766j == Integer.MIN_VALUE || this.f6764h == 0.0f) {
            return;
        }
        this.f6764h = 0.0f;
        a.a(surface, 0.0f);
    }

    private static long e(long j6, long j7, long j8) {
        long j9;
        long j10 = j7 + (((j6 - j7) / j8) * j8);
        if (j6 <= j10) {
            j9 = j10 - j8;
        } else {
            j10 = j8 + j10;
            j9 = j10;
        }
        return j10 - j6 < j6 - j9 ? j10 : j9;
    }

    private static b f(Context context) {
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        b d6 = c1.f5548a >= 17 ? d.d(applicationContext) : null;
        return d6 == null ? c.c(applicationContext) : d6;
    }

    private void n() {
        this.f6769m = 0L;
        this.f6772p = -1L;
        this.f6770n = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(Display display) {
        long j6;
        if (display != null) {
            long refreshRate = (long) (1.0E9d / display.getRefreshRate());
            this.f6767k = refreshRate;
            j6 = (refreshRate * 80) / 100;
        } else {
            i2.t.i("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            j6 = -9223372036854775807L;
            this.f6767k = -9223372036854775807L;
        }
        this.f6768l = j6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        if (java.lang.Math.abs(r0 - r8.f6763g) >= (r8.f6757a.e() && (r8.f6757a.d() > 5000000000L ? 1 : (r8.f6757a.d() == 5000000000L ? 0 : -1)) >= 0 ? 0.02f : 1.0f)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006a, code lost:
    
        if (r8.f6757a.c() >= 30) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void q() {
        /*
            r8 = this;
            int r0 = i2.c1.f5548a
            r1 = 30
            if (r0 < r1) goto L73
            android.view.Surface r0 = r8.f6761e
            if (r0 != 0) goto Lc
            goto L73
        Lc:
            j2.e r0 = r8.f6757a
            boolean r0 = r0.e()
            if (r0 == 0) goto L1b
            j2.e r0 = r8.f6757a
            float r0 = r0.b()
            goto L1d
        L1b:
            float r0 = r8.f6762f
        L1d:
            float r2 = r8.f6763g
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 != 0) goto L24
            return
        L24:
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            r4 = 0
            r5 = 1
            int r6 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r6 == 0) goto L61
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L61
            j2.e r1 = r8.f6757a
            boolean r1 = r1.e()
            if (r1 == 0) goto L49
            j2.e r1 = r8.f6757a
            long r1 = r1.d()
            r6 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 < 0) goto L49
            r1 = 1
            goto L4a
        L49:
            r1 = 0
        L4a:
            if (r1 == 0) goto L50
            r1 = 1017370378(0x3ca3d70a, float:0.02)
            goto L52
        L50:
            r1 = 1065353216(0x3f800000, float:1.0)
        L52:
            float r2 = r8.f6763g
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L5f
            goto L6c
        L5f:
            r5 = 0
            goto L6c
        L61:
            if (r6 == 0) goto L64
            goto L6c
        L64:
            j2.e r2 = r8.f6757a
            int r2 = r2.c()
            if (r2 < r1) goto L5f
        L6c:
            if (r5 == 0) goto L73
            r8.f6763g = r0
            r8.r(r4)
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.p.q():void");
    }

    private void r(boolean z5) {
        Surface surface;
        float f6;
        if (c1.f5548a < 30 || (surface = this.f6761e) == null || this.f6766j == Integer.MIN_VALUE) {
            return;
        }
        if (this.f6760d) {
            float f7 = this.f6763g;
            if (f7 != -1.0f) {
                f6 = f7 * this.f6765i;
                if (z5 && this.f6764h == f6) {
                    return;
                }
                this.f6764h = f6;
                a.a(surface, f6);
            }
        }
        f6 = 0.0f;
        if (z5) {
        }
        this.f6764h = f6;
        a.a(surface, f6);
    }

    public long b(long j6) {
        long j7;
        e eVar;
        if (this.f6772p != -1 && this.f6757a.e()) {
            long a6 = this.f6773q + ((long) ((this.f6757a.a() * (this.f6769m - this.f6772p)) / this.f6765i));
            if (c(j6, a6)) {
                j7 = a6;
                this.f6770n = this.f6769m;
                this.f6771o = j7;
                eVar = this.f6759c;
                if (eVar != null || this.f6767k == -9223372036854775807L) {
                    return j7;
                }
                long j8 = eVar.f6778a;
                return j8 == -9223372036854775807L ? j7 : e(j7, j8, this.f6767k) - this.f6768l;
            }
            n();
        }
        j7 = j6;
        this.f6770n = this.f6769m;
        this.f6771o = j7;
        eVar = this.f6759c;
        if (eVar != null) {
        }
        return j7;
    }

    public void g(float f6) {
        this.f6762f = f6;
        this.f6757a.g();
        q();
    }

    public void h(long j6) {
        long j7 = this.f6770n;
        if (j7 != -1) {
            this.f6772p = j7;
            this.f6773q = this.f6771o;
        }
        this.f6769m++;
        this.f6757a.f(j6 * 1000);
        q();
    }

    public void i(float f6) {
        this.f6765i = f6;
        n();
        r(false);
    }

    public void j() {
        n();
    }

    public void k() {
        this.f6760d = true;
        n();
        if (this.f6758b != null) {
            ((e) i2.a.e(this.f6759c)).a();
            this.f6758b.a(new b.a() { // from class: j2.n
                @Override // j2.p.b.a
                public final void a(Display display) {
                    p.this.p(display);
                }
            });
        }
        r(false);
    }

    public void l() {
        this.f6760d = false;
        b bVar = this.f6758b;
        if (bVar != null) {
            bVar.b();
            ((e) i2.a.e(this.f6759c)).e();
        }
        d();
    }

    public void m(Surface surface) {
        if (surface instanceof l) {
            surface = null;
        }
        if (this.f6761e == surface) {
            return;
        }
        d();
        this.f6761e = surface;
        r(true);
    }

    public void o(int i6) {
        if (this.f6766j == i6) {
            return;
        }
        this.f6766j = i6;
        r(true);
    }
}
