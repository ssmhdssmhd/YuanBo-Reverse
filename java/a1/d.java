package a1;

import a1.d;
import a1.p;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import i2.s0;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class d implements p {

    /* renamed from: a, reason: collision with root package name */
    private final MediaCodec f9a;

    /* renamed from: b, reason: collision with root package name */
    private final k f10b;

    /* renamed from: c, reason: collision with root package name */
    private final h f11c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f12d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f13e;

    /* renamed from: f, reason: collision with root package name */
    private int f14f;

    public static final class b implements p.b {

        /* renamed from: a, reason: collision with root package name */
        private final l2.p<HandlerThread> f15a;

        /* renamed from: b, reason: collision with root package name */
        private final l2.p<HandlerThread> f16b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f17c;

        public b(final int i6, boolean z5) {
            this(new l2.p() { // from class: a1.e
                @Override // l2.p
                public final Object get() {
                    HandlerThread e6;
                    e6 = d.b.e(i6);
                    return e6;
                }
            }, new l2.p() { // from class: a1.f
                @Override // l2.p
                public final Object get() {
                    HandlerThread f6;
                    f6 = d.b.f(i6);
                    return f6;
                }
            }, z5);
        }

        b(l2.p<HandlerThread> pVar, l2.p<HandlerThread> pVar2, boolean z5) {
            this.f15a = pVar;
            this.f16b = pVar2;
            this.f17c = z5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread e(int i6) {
            return new HandlerThread(d.t(i6));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread f(int i6) {
            return new HandlerThread(d.u(i6));
        }

        @Override // a1.p.b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public d a(p.a aVar) {
            MediaCodec mediaCodec;
            d dVar;
            String str = aVar.f77a.f85a;
            d dVar2 = null;
            try {
                s0.a("createCodec:" + str);
                mediaCodec = MediaCodec.createByCodecName(str);
                try {
                    dVar = new d(mediaCodec, this.f15a.get(), this.f16b.get(), this.f17c);
                } catch (Exception e6) {
                    e = e6;
                }
            } catch (Exception e7) {
                e = e7;
                mediaCodec = null;
            }
            try {
                s0.c();
                dVar.w(aVar.f78b, aVar.f80d, aVar.f81e, aVar.f82f);
                return dVar;
            } catch (Exception e8) {
                e = e8;
                dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.a();
                } else if (mediaCodec != null) {
                    mediaCodec.release();
                }
                throw e;
            }
        }
    }

    private d(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z5) {
        this.f9a = mediaCodec;
        this.f10b = new k(handlerThread);
        this.f11c = new h(mediaCodec, handlerThread2);
        this.f12d = z5;
        this.f14f = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String t(int i6) {
        return v(i6, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String u(int i6) {
        return v(i6, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String v(int i6, String str) {
        String str2;
        StringBuilder sb = new StringBuilder(str);
        if (i6 == 1) {
            str2 = "Audio";
        } else if (i6 == 2) {
            str2 = "Video";
        } else {
            sb.append("Unknown(");
            sb.append(i6);
            str2 = ")";
        }
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i6) {
        this.f10b.h(this.f9a);
        s0.a("configureCodec");
        this.f9a.configure(mediaFormat, surface, mediaCrypto, i6);
        s0.c();
        this.f11c.q();
        s0.a("startCodec");
        this.f9a.start();
        s0.c();
        this.f14f = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(p.c cVar, MediaCodec mediaCodec, long j6, long j7) {
        cVar.a(this, j6, j7);
    }

    private void y() {
        if (this.f12d) {
            try {
                this.f11c.r();
            } catch (InterruptedException e6) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e6);
            }
        }
    }

    @Override // a1.p
    public void a() {
        try {
            if (this.f14f == 1) {
                this.f11c.p();
                this.f10b.o();
            }
            this.f14f = 2;
        } finally {
            if (!this.f13e) {
                this.f9a.release();
                this.f13e = true;
            }
        }
    }

    @Override // a1.p
    public int b(MediaCodec.BufferInfo bufferInfo) {
        this.f11c.l();
        return this.f10b.d(bufferInfo);
    }

    @Override // a1.p
    public boolean c() {
        return false;
    }

    @Override // a1.p
    public void d(int i6, int i7, l0.c cVar, long j6, int i8) {
        this.f11c.n(i6, i7, cVar, j6, i8);
    }

    @Override // a1.p
    public void e(int i6, boolean z5) {
        this.f9a.releaseOutputBuffer(i6, z5);
    }

    @Override // a1.p
    public void f(final p.c cVar, Handler handler) {
        y();
        this.f9a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: a1.c
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j6, long j7) {
                d.this.x(cVar, mediaCodec, j6, j7);
            }
        }, handler);
    }

    @Override // a1.p
    public void flush() {
        this.f11c.i();
        this.f9a.flush();
        this.f10b.e();
        this.f9a.start();
    }

    @Override // a1.p
    public void g(int i6) {
        y();
        this.f9a.setVideoScalingMode(i6);
    }

    @Override // a1.p
    public MediaFormat h() {
        return this.f10b.g();
    }

    @Override // a1.p
    public ByteBuffer i(int i6) {
        return this.f9a.getInputBuffer(i6);
    }

    @Override // a1.p
    public void j(Surface surface) {
        y();
        this.f9a.setOutputSurface(surface);
    }

    @Override // a1.p
    public void k(int i6, int i7, int i8, long j6, int i9) {
        this.f11c.m(i6, i7, i8, j6, i9);
    }

    @Override // a1.p
    public void l(Bundle bundle) {
        y();
        this.f9a.setParameters(bundle);
    }

    @Override // a1.p
    public ByteBuffer m(int i6) {
        return this.f9a.getOutputBuffer(i6);
    }

    @Override // a1.p
    public void n(int i6, long j6) {
        this.f9a.releaseOutputBuffer(i6, j6);
    }

    @Override // a1.p
    public int o() {
        this.f11c.l();
        return this.f10b.c();
    }
}
