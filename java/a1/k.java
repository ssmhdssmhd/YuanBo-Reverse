package a1;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import i2.c1;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
final class k extends MediaCodec.Callback {

    /* renamed from: b, reason: collision with root package name */
    private final HandlerThread f52b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f53c;

    /* renamed from: h, reason: collision with root package name */
    private MediaFormat f58h;

    /* renamed from: i, reason: collision with root package name */
    private MediaFormat f59i;

    /* renamed from: j, reason: collision with root package name */
    private MediaCodec.CodecException f60j;

    /* renamed from: k, reason: collision with root package name */
    private long f61k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f62l;

    /* renamed from: m, reason: collision with root package name */
    private IllegalStateException f63m;

    /* renamed from: a, reason: collision with root package name */
    private final Object f51a = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final o f54d = new o();

    /* renamed from: e, reason: collision with root package name */
    private final o f55e = new o();

    /* renamed from: f, reason: collision with root package name */
    private final ArrayDeque<MediaCodec.BufferInfo> f56f = new ArrayDeque<>();

    /* renamed from: g, reason: collision with root package name */
    private final ArrayDeque<MediaFormat> f57g = new ArrayDeque<>();

    k(HandlerThread handlerThread) {
        this.f52b = handlerThread;
    }

    private void b(MediaFormat mediaFormat) {
        this.f55e.a(-2);
        this.f57g.add(mediaFormat);
    }

    private void f() {
        if (!this.f57g.isEmpty()) {
            this.f59i = this.f57g.getLast();
        }
        this.f54d.b();
        this.f55e.b();
        this.f56f.clear();
        this.f57g.clear();
    }

    private boolean i() {
        return this.f61k > 0 || this.f62l;
    }

    private void j() {
        k();
        l();
    }

    private void k() {
        IllegalStateException illegalStateException = this.f63m;
        if (illegalStateException == null) {
            return;
        }
        this.f63m = null;
        throw illegalStateException;
    }

    private void l() {
        MediaCodec.CodecException codecException = this.f60j;
        if (codecException == null) {
            return;
        }
        this.f60j = null;
        throw codecException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        synchronized (this.f51a) {
            if (this.f62l) {
                return;
            }
            long j6 = this.f61k - 1;
            this.f61k = j6;
            if (j6 > 0) {
                return;
            }
            if (j6 < 0) {
                n(new IllegalStateException());
            } else {
                f();
            }
        }
    }

    private void n(IllegalStateException illegalStateException) {
        synchronized (this.f51a) {
            this.f63m = illegalStateException;
        }
    }

    public int c() {
        synchronized (this.f51a) {
            int i6 = -1;
            if (i()) {
                return -1;
            }
            j();
            if (!this.f54d.d()) {
                i6 = this.f54d.e();
            }
            return i6;
        }
    }

    public int d(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f51a) {
            if (i()) {
                return -1;
            }
            j();
            if (this.f55e.d()) {
                return -1;
            }
            int e6 = this.f55e.e();
            if (e6 >= 0) {
                i2.a.i(this.f58h);
                MediaCodec.BufferInfo remove = this.f56f.remove();
                bufferInfo.set(remove.offset, remove.size, remove.presentationTimeUs, remove.flags);
            } else if (e6 == -2) {
                this.f58h = this.f57g.remove();
            }
            return e6;
        }
    }

    public void e() {
        synchronized (this.f51a) {
            this.f61k++;
            ((Handler) c1.j(this.f53c)).post(new Runnable() { // from class: a1.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.this.m();
                }
            });
        }
    }

    public MediaFormat g() {
        MediaFormat mediaFormat;
        synchronized (this.f51a) {
            mediaFormat = this.f58h;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public void h(MediaCodec mediaCodec) {
        i2.a.g(this.f53c == null);
        this.f52b.start();
        Handler handler = new Handler(this.f52b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f53c = handler;
    }

    public void o() {
        synchronized (this.f51a) {
            this.f62l = true;
            this.f52b.quit();
            f();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f51a) {
            this.f60j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i6) {
        synchronized (this.f51a) {
            this.f54d.a(i6);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i6, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f51a) {
            MediaFormat mediaFormat = this.f59i;
            if (mediaFormat != null) {
                b(mediaFormat);
                this.f59i = null;
            }
            this.f55e.a(i6);
            this.f56f.add(bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f51a) {
            b(mediaFormat);
            this.f59i = null;
        }
    }
}
