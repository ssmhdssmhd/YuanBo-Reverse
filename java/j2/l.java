package j2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import i2.o;

/* loaded from: classes.dex */
public final class l extends Surface {

    /* renamed from: d, reason: collision with root package name */
    private static int f6746d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f6747e;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6748a;

    /* renamed from: b, reason: collision with root package name */
    private final b f6749b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6750c;

    private static class b extends HandlerThread implements Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        private i2.k f6751a;

        /* renamed from: b, reason: collision with root package name */
        private Handler f6752b;

        /* renamed from: c, reason: collision with root package name */
        private Error f6753c;

        /* renamed from: d, reason: collision with root package name */
        private RuntimeException f6754d;

        /* renamed from: e, reason: collision with root package name */
        private l f6755e;

        public b() {
            super("ExoPlayer:PlaceholderSurface");
        }

        private void b(int i6) {
            i2.a.e(this.f6751a);
            this.f6751a.h(i6);
            this.f6755e = new l(this, this.f6751a.g(), i6 != 0);
        }

        private void d() {
            i2.a.e(this.f6751a);
            this.f6751a.i();
        }

        public l a(int i6) {
            boolean z5;
            start();
            this.f6752b = new Handler(getLooper(), this);
            this.f6751a = new i2.k(this.f6752b);
            synchronized (this) {
                z5 = false;
                this.f6752b.obtainMessage(1, i6, 0).sendToTarget();
                while (this.f6755e == null && this.f6754d == null && this.f6753c == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z5 = true;
                    }
                }
            }
            if (z5) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f6754d;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.f6753c;
            if (error == null) {
                return (l) i2.a.e(this.f6755e);
            }
            throw error;
        }

        public void c() {
            i2.a.e(this.f6752b);
            this.f6752b.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i6 = message.what;
            try {
                if (i6 != 1) {
                    if (i6 != 2) {
                        return true;
                    }
                    try {
                        d();
                    } finally {
                        try {
                            return true;
                        } finally {
                        }
                    }
                    return true;
                }
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (o.a e6) {
                    i2.t.d("PlaceholderSurface", "Failed to initialize placeholder surface", e6);
                    this.f6754d = new IllegalStateException(e6);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e7) {
                    i2.t.d("PlaceholderSurface", "Failed to initialize placeholder surface", e7);
                    this.f6753c = e7;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e8) {
                    i2.t.d("PlaceholderSurface", "Failed to initialize placeholder surface", e8);
                    this.f6754d = e8;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th) {
                synchronized (this) {
                    notify();
                    throw th;
                }
            }
        }
    }

    private l(b bVar, SurfaceTexture surfaceTexture, boolean z5) {
        super(surfaceTexture);
        this.f6749b = bVar;
        this.f6748a = z5;
    }

    private static int d(Context context) {
        if (i2.o.h(context)) {
            return i2.o.i() ? 1 : 2;
        }
        return 0;
    }

    public static synchronized boolean e(Context context) {
        boolean z5;
        synchronized (l.class) {
            if (!f6747e) {
                f6746d = d(context);
                f6747e = true;
            }
            z5 = f6746d != 0;
        }
        return z5;
    }

    public static l f(Context context, boolean z5) {
        i2.a.g(!z5 || e(context));
        return new b().a(z5 ? f6746d : 0);
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.f6749b) {
            if (!this.f6750c) {
                this.f6749b.c();
                this.f6750c = true;
            }
        }
    }
}
