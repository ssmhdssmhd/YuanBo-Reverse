package q5;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: h, reason: collision with root package name */
    public static final a f8989h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f8990a;

    /* renamed from: b, reason: collision with root package name */
    public int f8991b;

    /* renamed from: c, reason: collision with root package name */
    public int f8992c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8993d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8994e;

    /* renamed from: f, reason: collision with root package name */
    public v f8995f;

    /* renamed from: g, reason: collision with root package name */
    public v f8996g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public v() {
        this.f8990a = new byte[8192];
        this.f8994e = true;
        this.f8993d = false;
    }

    public v(byte[] data, int i6, int i7, boolean z5, boolean z6) {
        kotlin.jvm.internal.k.e(data, "data");
        this.f8990a = data;
        this.f8991b = i6;
        this.f8992c = i7;
        this.f8993d = z5;
        this.f8994e = z6;
    }

    public final void a() {
        v vVar = this.f8996g;
        int i6 = 0;
        if (!(vVar != this)) {
            throw new IllegalStateException("cannot compact".toString());
        }
        kotlin.jvm.internal.k.b(vVar);
        if (vVar.f8994e) {
            int i7 = this.f8992c - this.f8991b;
            v vVar2 = this.f8996g;
            kotlin.jvm.internal.k.b(vVar2);
            int i8 = 8192 - vVar2.f8992c;
            v vVar3 = this.f8996g;
            kotlin.jvm.internal.k.b(vVar3);
            if (!vVar3.f8993d) {
                v vVar4 = this.f8996g;
                kotlin.jvm.internal.k.b(vVar4);
                i6 = vVar4.f8991b;
            }
            if (i7 > i8 + i6) {
                return;
            }
            v vVar5 = this.f8996g;
            kotlin.jvm.internal.k.b(vVar5);
            f(vVar5, i7);
            b();
            w.b(this);
        }
    }

    public final v b() {
        v vVar = this.f8995f;
        if (vVar == this) {
            vVar = null;
        }
        v vVar2 = this.f8996g;
        kotlin.jvm.internal.k.b(vVar2);
        vVar2.f8995f = this.f8995f;
        v vVar3 = this.f8995f;
        kotlin.jvm.internal.k.b(vVar3);
        vVar3.f8996g = this.f8996g;
        this.f8995f = null;
        this.f8996g = null;
        return vVar;
    }

    public final v c(v segment) {
        kotlin.jvm.internal.k.e(segment, "segment");
        segment.f8996g = this;
        segment.f8995f = this.f8995f;
        v vVar = this.f8995f;
        kotlin.jvm.internal.k.b(vVar);
        vVar.f8996g = segment;
        this.f8995f = segment;
        return segment;
    }

    public final v d() {
        this.f8993d = true;
        return new v(this.f8990a, this.f8991b, this.f8992c, true, false);
    }

    public final v e(int i6) {
        v c6;
        if (!(i6 > 0 && i6 <= this.f8992c - this.f8991b)) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (i6 >= 1024) {
            c6 = d();
        } else {
            c6 = w.c();
            byte[] bArr = this.f8990a;
            byte[] bArr2 = c6.f8990a;
            int i7 = this.f8991b;
            f4.g.e(bArr, bArr2, 0, i7, i7 + i6, 2, null);
        }
        c6.f8992c = c6.f8991b + i6;
        this.f8991b += i6;
        v vVar = this.f8996g;
        kotlin.jvm.internal.k.b(vVar);
        vVar.c(c6);
        return c6;
    }

    public final void f(v sink, int i6) {
        kotlin.jvm.internal.k.e(sink, "sink");
        if (!sink.f8994e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i7 = sink.f8992c;
        if (i7 + i6 > 8192) {
            if (sink.f8993d) {
                throw new IllegalArgumentException();
            }
            int i8 = sink.f8991b;
            if ((i7 + i6) - i8 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.f8990a;
            f4.g.e(bArr, bArr, 0, i8, i7, 2, null);
            sink.f8992c -= sink.f8991b;
            sink.f8991b = 0;
        }
        byte[] bArr2 = this.f8990a;
        byte[] bArr3 = sink.f8990a;
        int i9 = sink.f8992c;
        int i10 = this.f8991b;
        f4.g.c(bArr2, bArr3, i9, i10, i10 + i6);
        sink.f8992c += i6;
        this.f8991b += i6;
    }
}
