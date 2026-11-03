package a1;

import a1.p;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import i2.c1;
import i2.s0;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class j0 implements p {

    /* renamed from: a, reason: collision with root package name */
    private final MediaCodec f48a;

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer[] f49b;

    /* renamed from: c, reason: collision with root package name */
    private ByteBuffer[] f50c;

    public static class b implements p.b {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [a1.j0$a] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // a1.p.b
        public p a(p.a aVar) {
            MediaCodec b6;
            MediaCodec mediaCodec = 0;
            mediaCodec = 0;
            try {
                b6 = b(aVar);
            } catch (IOException e6) {
                e = e6;
            } catch (RuntimeException e7) {
                e = e7;
            }
            try {
                s0.a("configureCodec");
                b6.configure(aVar.f78b, aVar.f80d, aVar.f81e, aVar.f82f);
                s0.c();
                s0.a("startCodec");
                b6.start();
                s0.c();
                return new j0(b6);
            } catch (IOException | RuntimeException e8) {
                e = e8;
                mediaCodec = b6;
                if (mediaCodec != 0) {
                    mediaCodec.release();
                }
                throw e;
            }
        }

        protected MediaCodec b(p.a aVar) {
            i2.a.e(aVar.f77a);
            String str = aVar.f77a.f85a;
            s0.a("createCodec:" + str);
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            s0.c();
            return createByCodecName;
        }
    }

    private j0(MediaCodec mediaCodec) {
        this.f48a = mediaCodec;
        if (c1.f5548a < 21) {
            this.f49b = mediaCodec.getInputBuffers();
            this.f50c = mediaCodec.getOutputBuffers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(p.c cVar, MediaCodec mediaCodec, long j6, long j7) {
        cVar.a(this, j6, j7);
    }

    @Override // a1.p
    public void a() {
        this.f49b = null;
        this.f50c = null;
        this.f48a.release();
    }

    @Override // a1.p
    public int b(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.f48a.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer == -3 && c1.f5548a < 21) {
                this.f50c = this.f48a.getOutputBuffers();
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    @Override // a1.p
    public boolean c() {
        return false;
    }

    @Override // a1.p
    public void d(int i6, int i7, l0.c cVar, long j6, int i8) {
        this.f48a.queueSecureInputBuffer(i6, i7, cVar.a(), j6, i8);
    }

    @Override // a1.p
    public void e(int i6, boolean z5) {
        this.f48a.releaseOutputBuffer(i6, z5);
    }

    @Override // a1.p
    public void f(final p.c cVar, Handler handler) {
        this.f48a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: a1.i0
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j6, long j7) {
                j0.this.q(cVar, mediaCodec, j6, j7);
            }
        }, handler);
    }

    @Override // a1.p
    public void flush() {
        this.f48a.flush();
    }

    @Override // a1.p
    public void g(int i6) {
        this.f48a.setVideoScalingMode(i6);
    }

    @Override // a1.p
    public MediaFormat h() {
        return this.f48a.getOutputFormat();
    }

    @Override // a1.p
    public ByteBuffer i(int i6) {
        return c1.f5548a >= 21 ? this.f48a.getInputBuffer(i6) : ((ByteBuffer[]) c1.j(this.f49b))[i6];
    }

    @Override // a1.p
    public void j(Surface surface) {
        this.f48a.setOutputSurface(surface);
    }

    @Override // a1.p
    public void k(int i6, int i7, int i8, long j6, int i9) {
        this.f48a.queueInputBuffer(i6, i7, i8, j6, i9);
    }

    @Override // a1.p
    public void l(Bundle bundle) {
        this.f48a.setParameters(bundle);
    }

    @Override // a1.p
    public ByteBuffer m(int i6) {
        return c1.f5548a >= 21 ? this.f48a.getOutputBuffer(i6) : ((ByteBuffer[]) c1.j(this.f50c))[i6];
    }

    @Override // a1.p
    public void n(int i6, long j6) {
        this.f48a.releaseOutputBuffer(i6, j6);
    }

    @Override // a1.p
    public int o() {
        return this.f48a.dequeueInputBuffer(0L);
    }
}
