package l5;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: c, reason: collision with root package name */
    public static final a f7728c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private int f7729a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f7730b = new int[10];

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public final int a(int i6) {
        return this.f7730b[i6];
    }

    public final int b() {
        if ((this.f7729a & 2) != 0) {
            return this.f7730b[1];
        }
        return -1;
    }

    public final int c() {
        if ((this.f7729a & 128) != 0) {
            return this.f7730b[7];
        }
        return 65535;
    }

    public final int d() {
        if ((this.f7729a & 16) != 0) {
            return this.f7730b[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int e(int i6) {
        return (this.f7729a & 32) != 0 ? this.f7730b[5] : i6;
    }

    public final boolean f(int i6) {
        return ((1 << i6) & this.f7729a) != 0;
    }

    public final void g(m other) {
        kotlin.jvm.internal.k.e(other, "other");
        for (int i6 = 0; i6 < 10; i6++) {
            if (other.f(i6)) {
                h(i6, other.a(i6));
            }
        }
    }

    public final m h(int i6, int i7) {
        if (i6 >= 0) {
            int[] iArr = this.f7730b;
            if (i6 < iArr.length) {
                this.f7729a = (1 << i6) | this.f7729a;
                iArr[i6] = i7;
            }
        }
        return this;
    }

    public final int i() {
        return Integer.bitCount(this.f7729a);
    }
}
