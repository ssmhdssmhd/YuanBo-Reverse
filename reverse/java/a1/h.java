package a1;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import i2.c1;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
class h {

    /* renamed from: g, reason: collision with root package name */
    private static final ArrayDeque<b> f22g = new ArrayDeque<>();

    /* renamed from: h, reason: collision with root package name */
    private static final Object f23h = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final MediaCodec f24a;

    /* renamed from: b, reason: collision with root package name */
    private final HandlerThread f25b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f26c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicReference<RuntimeException> f27d;

    /* renamed from: e, reason: collision with root package name */
    private final i2.h f28e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f29f;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            h.this.f(message);
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f31a;

        /* renamed from: b, reason: collision with root package name */
        public int f32b;

        /* renamed from: c, reason: collision with root package name */
        public int f33c;

        /* renamed from: d, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f34d = new MediaCodec.CryptoInfo();

        /* renamed from: e, reason: collision with root package name */
        public long f35e;

        /* renamed from: f, reason: collision with root package name */
        public int f36f;

        b() {
        }

        public void a(int i6, int i7, int i8, long j6, int i9) {
            this.f31a = i6;
            this.f32b = i7;
            this.f33c = i8;
            this.f35e = j6;
            this.f36f = i9;
        }
    }

    public h(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new i2.h());
    }

    h(MediaCodec mediaCodec, HandlerThread handlerThread, i2.h hVar) {
        this.f24a = mediaCodec;
        this.f25b = handlerThread;
        this.f28e = hVar;
        this.f27d = new AtomicReference<>();
    }

    private void b() {
        this.f28e.c();
        ((Handler) i2.a.e(this.f26c)).obtainMessage(2).sendToTarget();
        this.f28e.a();
    }

    private static void c(l0.c cVar, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = cVar.f7142f;
        cryptoInfo.numBytesOfClearData = e(cVar.f7140d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = e(cVar.f7141e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) i2.a.e(d(cVar.f7138b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) i2.a.e(d(cVar.f7137a, cryptoInfo.iv));
        cryptoInfo.mode = cVar.f7139c;
        if (c1.f5548a >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(cVar.f7143g, cVar.f7144h));
        }
    }

    private static byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int[] e(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Message message) {
        b bVar;
        int i6 = message.what;
        if (i6 == 0) {
            bVar = (b) message.obj;
            g(bVar.f31a, bVar.f32b, bVar.f33c, bVar.f35e, bVar.f36f);
        } else if (i6 != 1) {
            bVar = null;
            if (i6 != 2) {
                g.a(this.f27d, null, new IllegalStateException(String.valueOf(message.what)));
            } else {
                this.f28e.e();
            }
        } else {
            bVar = (b) message.obj;
            h(bVar.f31a, bVar.f32b, bVar.f34d, bVar.f35e, bVar.f36f);
        }
        if (bVar != null) {
            o(bVar);
        }
    }

    private void g(int i6, int i7, int i8, long j6, int i9) {
        try {
            this.f24a.queueInputBuffer(i6, i7, i8, j6, i9);
        } catch (RuntimeException e6) {
            g.a(this.f27d, null, e6);
        }
    }

    private void h(int i6, int i7, MediaCodec.CryptoInfo cryptoInfo, long j6, int i8) {
        try {
            synchronized (f23h) {
                this.f24a.queueSecureInputBuffer(i6, i7, cryptoInfo, j6, i8);
            }
        } catch (RuntimeException e6) {
            g.a(this.f27d, null, e6);
        }
    }

    private void j() {
        ((Handler) i2.a.e(this.f26c)).removeCallbacksAndMessages(null);
        b();
    }

    private static b k() {
        ArrayDeque<b> arrayDeque = f22g;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new b();
            }
            return arrayDeque.removeFirst();
        }
    }

    private static void o(b bVar) {
        ArrayDeque<b> arrayDeque = f22g;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }

    public void i() {
        if (this.f29f) {
            try {
                j();
            } catch (InterruptedException e6) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e6);
            }
        }
    }

    public void l() {
        RuntimeException andSet = this.f27d.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }

    public void m(int i6, int i7, int i8, long j6, int i9) {
        l();
        b k6 = k();
        k6.a(i6, i7, i8, j6, i9);
        ((Handler) c1.j(this.f26c)).obtainMessage(0, k6).sendToTarget();
    }

    public void n(int i6, int i7, l0.c cVar, long j6, int i8) {
        l();
        b k6 = k();
        k6.a(i6, i7, 0, j6, i8);
        c(cVar, k6.f34d);
        ((Handler) c1.j(this.f26c)).obtainMessage(1, k6).sendToTarget();
    }

    public void p() {
        if (this.f29f) {
            i();
            this.f25b.quit();
        }
        this.f29f = false;
    }

    public void q() {
        if (this.f29f) {
            return;
        }
        this.f25b.start();
        this.f26c = new a(this.f25b.getLooper());
        this.f29f = true;
    }

    public void r() {
        b();
    }
}
