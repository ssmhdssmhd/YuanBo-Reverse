package j0;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public interface i {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f6442a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class a {

        /* renamed from: e, reason: collision with root package name */
        public static final a f6443e = new a(-1, -1, -1);

        /* renamed from: a, reason: collision with root package name */
        public final int f6444a;

        /* renamed from: b, reason: collision with root package name */
        public final int f6445b;

        /* renamed from: c, reason: collision with root package name */
        public final int f6446c;

        /* renamed from: d, reason: collision with root package name */
        public final int f6447d;

        public a(int i6, int i7, int i8) {
            this.f6444a = i6;
            this.f6445b = i7;
            this.f6446c = i8;
            this.f6447d = i2.c1.v0(i8) ? i2.c1.f0(i8, i7) : -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f6444a == aVar.f6444a && this.f6445b == aVar.f6445b && this.f6446c == aVar.f6446c;
        }

        public int hashCode() {
            return l2.j.b(Integer.valueOf(this.f6444a), Integer.valueOf(this.f6445b), Integer.valueOf(this.f6446c));
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f6444a + ", channelCount=" + this.f6445b + ", encoding=" + this.f6446c + ']';
        }
    }

    public static final class b extends Exception {
        public b(a aVar) {
            super("Unhandled format: " + aVar);
        }
    }

    boolean a();

    ByteBuffer b();

    boolean c();

    void d();

    void e(ByteBuffer byteBuffer);

    a f(a aVar);

    void flush();

    void reset();
}
