package d5;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class c0 implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3029a = new a(null);

    public static final class a {

        /* renamed from: d5.c0$a$a, reason: collision with other inner class name */
        public static final class C0059a extends c0 {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ q5.g f3030b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ w f3031c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f3032d;

            C0059a(q5.g gVar, w wVar, long j6) {
                this.f3030b = gVar;
                this.f3031c = wVar;
                this.f3032d = j6;
            }

            @Override // d5.c0
            public long j() {
                return this.f3032d;
            }

            @Override // d5.c0
            public q5.g k() {
                return this.f3030b;
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public static /* synthetic */ c0 c(a aVar, byte[] bArr, w wVar, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                wVar = null;
            }
            return aVar.b(bArr, wVar);
        }

        public final c0 a(q5.g asResponseBody, w wVar, long j6) {
            kotlin.jvm.internal.k.e(asResponseBody, "$this$asResponseBody");
            return new C0059a(asResponseBody, wVar, j6);
        }

        public final c0 b(byte[] toResponseBody, w wVar) {
            kotlin.jvm.internal.k.e(toResponseBody, "$this$toResponseBody");
            return a(new q5.e().write(toResponseBody), wVar, toResponseBody.length);
        }
    }

    public final byte[] a() {
        long j6 = j();
        if (j6 > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + j6);
        }
        q5.g k6 = k();
        try {
            byte[] x5 = k6.x();
            m4.b.a(k6, null);
            int length = x5.length;
            if (j6 == -1 || j6 == length) {
                return x5;
            }
            throw new IOException("Content-Length (" + j6 + ") and stream length (" + length + ") disagree");
        } finally {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        e5.b.i(k());
    }

    public abstract long j();

    public abstract q5.g k();
}
