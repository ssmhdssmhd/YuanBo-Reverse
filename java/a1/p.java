package a1;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import h0.y1;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface p {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final t f77a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaFormat f78b;

        /* renamed from: c, reason: collision with root package name */
        public final y1 f79c;

        /* renamed from: d, reason: collision with root package name */
        public final Surface f80d;

        /* renamed from: e, reason: collision with root package name */
        public final MediaCrypto f81e;

        /* renamed from: f, reason: collision with root package name */
        public final int f82f;

        private a(t tVar, MediaFormat mediaFormat, y1 y1Var, Surface surface, MediaCrypto mediaCrypto, int i6) {
            this.f77a = tVar;
            this.f78b = mediaFormat;
            this.f79c = y1Var;
            this.f80d = surface;
            this.f81e = mediaCrypto;
            this.f82f = i6;
        }

        public static a a(t tVar, MediaFormat mediaFormat, y1 y1Var, MediaCrypto mediaCrypto) {
            return new a(tVar, mediaFormat, y1Var, null, mediaCrypto, 0);
        }

        public static a b(t tVar, MediaFormat mediaFormat, y1 y1Var, Surface surface, MediaCrypto mediaCrypto) {
            return new a(tVar, mediaFormat, y1Var, surface, mediaCrypto, 0);
        }
    }

    public interface b {
        p a(a aVar);
    }

    public interface c {
        void a(p pVar, long j6, long j7);
    }

    void a();

    int b(MediaCodec.BufferInfo bufferInfo);

    boolean c();

    void d(int i6, int i7, l0.c cVar, long j6, int i8);

    void e(int i6, boolean z5);

    void f(c cVar, Handler handler);

    void flush();

    void g(int i6);

    MediaFormat h();

    ByteBuffer i(int i6);

    void j(Surface surface);

    void k(int i6, int i7, int i8, long j6, int i9);

    void l(Bundle bundle);

    ByteBuffer m(int i6);

    void n(int i6, long j6);

    int o();
}
