package j0;

import j0.i;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public abstract class b0 implements i {

    /* renamed from: b, reason: collision with root package name */
    protected i.a f6386b;

    /* renamed from: c, reason: collision with root package name */
    protected i.a f6387c;

    /* renamed from: d, reason: collision with root package name */
    private i.a f6388d;

    /* renamed from: e, reason: collision with root package name */
    private i.a f6389e;

    /* renamed from: f, reason: collision with root package name */
    private ByteBuffer f6390f;

    /* renamed from: g, reason: collision with root package name */
    private ByteBuffer f6391g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6392h;

    public b0() {
        ByteBuffer byteBuffer = i.f6442a;
        this.f6390f = byteBuffer;
        this.f6391g = byteBuffer;
        i.a aVar = i.a.f6443e;
        this.f6388d = aVar;
        this.f6389e = aVar;
        this.f6386b = aVar;
        this.f6387c = aVar;
    }

    @Override // j0.i
    public boolean a() {
        return this.f6389e != i.a.f6443e;
    }

    @Override // j0.i
    public ByteBuffer b() {
        ByteBuffer byteBuffer = this.f6391g;
        this.f6391g = i.f6442a;
        return byteBuffer;
    }

    @Override // j0.i
    public boolean c() {
        return this.f6392h && this.f6391g == i.f6442a;
    }

    @Override // j0.i
    public final void d() {
        this.f6392h = true;
        j();
    }

    @Override // j0.i
    public final i.a f(i.a aVar) {
        this.f6388d = aVar;
        this.f6389e = h(aVar);
        return a() ? this.f6389e : i.a.f6443e;
    }

    @Override // j0.i
    public final void flush() {
        this.f6391g = i.f6442a;
        this.f6392h = false;
        this.f6386b = this.f6388d;
        this.f6387c = this.f6389e;
        i();
    }

    protected final boolean g() {
        return this.f6391g.hasRemaining();
    }

    protected abstract i.a h(i.a aVar);

    protected void i() {
    }

    protected void j() {
    }

    protected void k() {
    }

    protected final ByteBuffer l(int i6) {
        if (this.f6390f.capacity() < i6) {
            this.f6390f = ByteBuffer.allocateDirect(i6).order(ByteOrder.nativeOrder());
        } else {
            this.f6390f.clear();
        }
        ByteBuffer byteBuffer = this.f6390f;
        this.f6391g = byteBuffer;
        return byteBuffer;
    }

    @Override // j0.i
    public final void reset() {
        flush();
        this.f6390f = i.f6442a;
        i.a aVar = i.a.f6443e;
        this.f6388d = aVar;
        this.f6389e = aVar;
        this.f6386b = aVar;
        this.f6387c = aVar;
        k();
    }
}
