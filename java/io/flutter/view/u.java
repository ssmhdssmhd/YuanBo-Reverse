package io.flutter.view;

import android.hardware.display.DisplayManager;
import android.view.Choreographer;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Objects;

/* loaded from: classes.dex */
public class u {

    /* renamed from: e, reason: collision with root package name */
    private static u f6355e;

    /* renamed from: f, reason: collision with root package name */
    private static b f6356f;

    /* renamed from: b, reason: collision with root package name */
    private FlutterJNI f6358b;

    /* renamed from: a, reason: collision with root package name */
    private long f6357a = -1;

    /* renamed from: c, reason: collision with root package name */
    private c f6359c = new c(0);

    /* renamed from: d, reason: collision with root package name */
    private final FlutterJNI.b f6360d = new a();

    class a implements FlutterJNI.b {
        a() {
        }

        private Choreographer.FrameCallback b(long j6) {
            if (u.this.f6359c == null) {
                return u.this.new c(j6);
            }
            u.this.f6359c.f6364a = j6;
            c cVar = u.this.f6359c;
            u.this.f6359c = null;
            return cVar;
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.b
        public void a(long j6) {
            Choreographer.getInstance().postFrameCallback(b(j6));
        }
    }

    class b implements DisplayManager.DisplayListener {

        /* renamed from: a, reason: collision with root package name */
        private DisplayManager f6362a;

        b(DisplayManager displayManager) {
            this.f6362a = displayManager;
        }

        void a() {
            this.f6362a.registerDisplayListener(this, null);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i6) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i6) {
            if (i6 == 0) {
                float refreshRate = this.f6362a.getDisplay(0).getRefreshRate();
                u.this.f6357a = (long) (1.0E9d / refreshRate);
                u.this.f6358b.setRefreshRateFPS(refreshRate);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i6) {
        }
    }

    private class c implements Choreographer.FrameCallback {

        /* renamed from: a, reason: collision with root package name */
        private long f6364a;

        c(long j6) {
            this.f6364a = j6;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j6) {
            long nanoTime = System.nanoTime() - j6;
            u.this.f6358b.onVsync(nanoTime < 0 ? 0L : nanoTime, u.this.f6357a, this.f6364a);
            u.this.f6359c = this;
        }
    }

    private u(FlutterJNI flutterJNI) {
        this.f6358b = flutterJNI;
    }

    public static u f(DisplayManager displayManager, FlutterJNI flutterJNI) {
        if (f6355e == null) {
            f6355e = new u(flutterJNI);
        }
        if (f6356f == null) {
            u uVar = f6355e;
            Objects.requireNonNull(uVar);
            b bVar = uVar.new b(displayManager);
            f6356f = bVar;
            bVar.a();
        }
        if (f6355e.f6357a == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            f6355e.f6357a = (long) (1.0E9d / refreshRate);
            flutterJNI.setRefreshRateFPS(refreshRate);
        }
        return f6355e;
    }

    public void g() {
        this.f6358b.setAsyncWaitForVsyncDelegate(this.f6360d);
    }
}
