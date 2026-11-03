package g2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import i2.c1;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public final class i0 implements j0 {

    /* renamed from: d, reason: collision with root package name */
    public static final c f4048d = h(false, -9223372036854775807L);

    /* renamed from: e, reason: collision with root package name */
    public static final c f4049e = h(true, -9223372036854775807L);

    /* renamed from: f, reason: collision with root package name */
    public static final c f4050f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f4051g;

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f4052a;

    /* renamed from: b, reason: collision with root package name */
    private d<? extends e> f4053b;

    /* renamed from: c, reason: collision with root package name */
    private IOException f4054c;

    public interface b<T extends e> {
        void i(T t5, long j6, long j7);

        c m(T t5, long j6, long j7, IOException iOException, int i6);

        void u(T t5, long j6, long j7, boolean z5);
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final int f4055a;

        /* renamed from: b, reason: collision with root package name */
        private final long f4056b;

        private c(int i6, long j6) {
            this.f4055a = i6;
            this.f4056b = j6;
        }

        public boolean c() {
            int i6 = this.f4055a;
            return i6 == 0 || i6 == 1;
        }
    }

    private final class d<T extends e> extends Handler implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final int f4057a;

        /* renamed from: b, reason: collision with root package name */
        private final T f4058b;

        /* renamed from: c, reason: collision with root package name */
        private final long f4059c;

        /* renamed from: d, reason: collision with root package name */
        private b<T> f4060d;

        /* renamed from: e, reason: collision with root package name */
        private IOException f4061e;

        /* renamed from: j, reason: collision with root package name */
        private int f4062j;

        /* renamed from: k, reason: collision with root package name */
        private Thread f4063k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f4064l;

        /* renamed from: m, reason: collision with root package name */
        private volatile boolean f4065m;

        public d(Looper looper, T t5, b<T> bVar, int i6, long j6) {
            super(looper);
            this.f4058b = t5;
            this.f4060d = bVar;
            this.f4057a = i6;
            this.f4059c = j6;
        }

        private void b() {
            this.f4061e = null;
            i0.this.f4052a.execute((Runnable) i2.a.e(i0.this.f4053b));
        }

        private void c() {
            i0.this.f4053b = null;
        }

        private long d() {
            return Math.min((this.f4062j - 1) * 1000, 5000);
        }

        public void a(boolean z5) {
            this.f4065m = z5;
            this.f4061e = null;
            if (hasMessages(0)) {
                this.f4064l = true;
                removeMessages(0);
                if (!z5) {
                    sendEmptyMessage(1);
                }
            } else {
                synchronized (this) {
                    this.f4064l = true;
                    this.f4058b.c();
                    Thread thread = this.f4063k;
                    if (thread != null) {
                        thread.interrupt();
                    }
                }
            }
            if (z5) {
                c();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ((b) i2.a.e(this.f4060d)).u(this.f4058b, elapsedRealtime, elapsedRealtime - this.f4059c, true);
                this.f4060d = null;
            }
        }

        public void e(int i6) {
            IOException iOException = this.f4061e;
            if (iOException != null && this.f4062j > i6) {
                throw iOException;
            }
        }

        public void f(long j6) {
            i2.a.g(i0.this.f4053b == null);
            i0.this.f4053b = this;
            if (j6 > 0) {
                sendEmptyMessageDelayed(0, j6);
            } else {
                b();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.f4065m) {
                return;
            }
            int i6 = message.what;
            if (i6 == 0) {
                b();
                return;
            }
            if (i6 == 3) {
                throw ((Error) message.obj);
            }
            c();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j6 = elapsedRealtime - this.f4059c;
            b bVar = (b) i2.a.e(this.f4060d);
            if (this.f4064l) {
                bVar.u(this.f4058b, elapsedRealtime, j6, false);
                return;
            }
            int i7 = message.what;
            if (i7 == 1) {
                try {
                    bVar.i(this.f4058b, elapsedRealtime, j6);
                    return;
                } catch (RuntimeException e6) {
                    i2.t.d("LoadTask", "Unexpected exception handling load completed", e6);
                    i0.this.f4054c = new h(e6);
                    return;
                }
            }
            if (i7 != 2) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.f4061e = iOException;
            int i8 = this.f4062j + 1;
            this.f4062j = i8;
            c m6 = bVar.m(this.f4058b, elapsedRealtime, j6, iOException, i8);
            if (m6.f4055a == 3) {
                i0.this.f4054c = this.f4061e;
            } else if (m6.f4055a != 2) {
                if (m6.f4055a == 1) {
                    this.f4062j = 1;
                }
                f(m6.f4056b != -9223372036854775807L ? m6.f4056b : d());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar;
            Message obtainMessage;
            boolean z5;
            try {
                synchronized (this) {
                    z5 = !this.f4064l;
                    this.f4063k = Thread.currentThread();
                }
                if (z5) {
                    i2.s0.a("load:" + this.f4058b.getClass().getSimpleName());
                    try {
                        this.f4058b.a();
                        i2.s0.c();
                    } catch (Throwable th) {
                        i2.s0.c();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.f4063k = null;
                    Thread.interrupted();
                }
                if (this.f4065m) {
                    return;
                }
                sendEmptyMessage(1);
            } catch (IOException e6) {
                if (this.f4065m) {
                    return;
                }
                obtainMessage = obtainMessage(2, e6);
                obtainMessage.sendToTarget();
            } catch (Error e7) {
                if (!this.f4065m) {
                    i2.t.d("LoadTask", "Unexpected error loading stream", e7);
                    obtainMessage(3, e7).sendToTarget();
                }
                throw e7;
            } catch (Exception e8) {
                if (this.f4065m) {
                    return;
                }
                i2.t.d("LoadTask", "Unexpected exception loading stream", e8);
                hVar = new h(e8);
                obtainMessage = obtainMessage(2, hVar);
                obtainMessage.sendToTarget();
            } catch (OutOfMemoryError e9) {
                if (this.f4065m) {
                    return;
                }
                i2.t.d("LoadTask", "OutOfMemory error loading stream", e9);
                hVar = new h(e9);
                obtainMessage = obtainMessage(2, hVar);
                obtainMessage.sendToTarget();
            }
        }
    }

    public interface e {
        void a();

        void c();
    }

    public interface f {
        void k();
    }

    private static final class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final f f4067a;

        public g(f fVar) {
            this.f4067a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4067a.k();
        }
    }

    public static final class h extends IOException {
        public h(Throwable th) {
            super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
        }
    }

    static {
        long j6 = -9223372036854775807L;
        f4050f = new c(2, j6);
        f4051g = new c(3, j6);
    }

    public i0(String str) {
        this.f4052a = c1.E0("ExoPlayer:Loader:" + str);
    }

    public static c h(boolean z5, long j6) {
        return new c(z5 ? 1 : 0, j6);
    }

    @Override // g2.j0
    public void b() {
        k(Integer.MIN_VALUE);
    }

    public void f() {
        ((d) i2.a.i(this.f4053b)).a(false);
    }

    public void g() {
        this.f4054c = null;
    }

    public boolean i() {
        return this.f4054c != null;
    }

    public boolean j() {
        return this.f4053b != null;
    }

    public void k(int i6) {
        IOException iOException = this.f4054c;
        if (iOException != null) {
            throw iOException;
        }
        d<? extends e> dVar = this.f4053b;
        if (dVar != null) {
            if (i6 == Integer.MIN_VALUE) {
                i6 = dVar.f4057a;
            }
            dVar.e(i6);
        }
    }

    public void l() {
        m(null);
    }

    public void m(f fVar) {
        d<? extends e> dVar = this.f4053b;
        if (dVar != null) {
            dVar.a(true);
        }
        if (fVar != null) {
            this.f4052a.execute(new g(fVar));
        }
        this.f4052a.shutdown();
    }

    public <T extends e> long n(T t5, b<T> bVar, int i6) {
        Looper looper = (Looper) i2.a.i(Looper.myLooper());
        this.f4054c = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new d(looper, t5, bVar, i6, elapsedRealtime).f(0L);
        return elapsedRealtime;
    }
}
