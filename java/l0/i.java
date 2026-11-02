package l0;

import com.tendcloud.tenddata.cs;
import h0.v1;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes.dex */
public class i extends l0.a {

    /* renamed from: b, reason: collision with root package name */
    public final c f7161b;

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer f7162c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7163d;

    /* renamed from: e, reason: collision with root package name */
    public long f7164e;

    /* renamed from: j, reason: collision with root package name */
    public ByteBuffer f7165j;

    /* renamed from: k, reason: collision with root package name */
    private final int f7166k;

    /* renamed from: l, reason: collision with root package name */
    private final int f7167l;

    public static final class a extends IllegalStateException {

        /* renamed from: a, reason: collision with root package name */
        public final int f7168a;

        /* renamed from: b, reason: collision with root package name */
        public final int f7169b;

        public a(int i6, int i7) {
            super("Buffer too small (" + i6 + " < " + i7 + ")");
            this.f7168a = i6;
            this.f7169b = i7;
        }
    }

    static {
        v1.a("goog.exo.decoder");
    }

    public i(int i6) {
        this(i6, 0);
    }

    public i(int i6, int i7) {
        this.f7161b = new c();
        this.f7166k = i6;
        this.f7167l = i7;
    }

    private ByteBuffer o(int i6) {
        int i7 = this.f7166k;
        if (i7 == 1) {
            return ByteBuffer.allocate(i6);
        }
        if (i7 == 2) {
            return ByteBuffer.allocateDirect(i6);
        }
        ByteBuffer byteBuffer = this.f7162c;
        throw new a(byteBuffer == null ? 0 : byteBuffer.capacity(), i6);
    }

    public static i s() {
        return new i(0);
    }

    @Override // l0.a
    public void f() {
        super.f();
        ByteBuffer byteBuffer = this.f7162c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f7165j;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f7163d = false;
    }

    @EnsuresNonNull({cs.a.DATA})
    public void p(int i6) {
        int i7 = i6 + this.f7167l;
        ByteBuffer byteBuffer = this.f7162c;
        if (byteBuffer == null) {
            this.f7162c = o(i7);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i8 = i7 + position;
        if (capacity >= i8) {
            this.f7162c = byteBuffer;
            return;
        }
        ByteBuffer o6 = o(i8);
        o6.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            o6.put(byteBuffer);
        }
        this.f7162c = o6;
    }

    public final void q() {
        ByteBuffer byteBuffer = this.f7162c;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f7165j;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean r() {
        return h(1073741824);
    }

    @EnsuresNonNull({"supplementalData"})
    public void t(int i6) {
        ByteBuffer byteBuffer = this.f7165j;
        if (byteBuffer == null || byteBuffer.capacity() < i6) {
            this.f7165j = ByteBuffer.allocate(i6);
        } else {
            this.f7165j.clear();
        }
    }
}
