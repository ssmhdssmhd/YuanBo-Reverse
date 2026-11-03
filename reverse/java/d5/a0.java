package d5;

/* loaded from: classes.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2994a = new a(null);

    public static final class a {

        /* renamed from: d5.a0$a$a, reason: collision with other inner class name */
        public static final class C0057a extends a0 {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ byte[] f2995b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ w f2996c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f2997d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f2998e;

            C0057a(byte[] bArr, w wVar, int i6, int i7) {
                this.f2995b = bArr;
                this.f2996c = wVar;
                this.f2997d = i6;
                this.f2998e = i7;
            }

            @Override // d5.a0
            public long a() {
                return this.f2997d;
            }

            @Override // d5.a0
            public w b() {
                return this.f2996c;
            }

            @Override // d5.a0
            public void e(q5.f sink) {
                kotlin.jvm.internal.k.e(sink, "sink");
                sink.write(this.f2995b, this.f2998e, this.f2997d);
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public static /* synthetic */ a0 c(a aVar, w wVar, byte[] bArr, int i6, int i7, int i8, Object obj) {
            if ((i8 & 4) != 0) {
                i6 = 0;
            }
            if ((i8 & 8) != 0) {
                i7 = bArr.length;
            }
            return aVar.a(wVar, bArr, i6, i7);
        }

        public static /* synthetic */ a0 d(a aVar, byte[] bArr, w wVar, int i6, int i7, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                wVar = null;
            }
            if ((i8 & 2) != 0) {
                i6 = 0;
            }
            if ((i8 & 4) != 0) {
                i7 = bArr.length;
            }
            return aVar.b(bArr, wVar, i6, i7);
        }

        public final a0 a(w wVar, byte[] content, int i6, int i7) {
            kotlin.jvm.internal.k.e(content, "content");
            return b(content, wVar, i6, i7);
        }

        public final a0 b(byte[] toRequestBody, w wVar, int i6, int i7) {
            kotlin.jvm.internal.k.e(toRequestBody, "$this$toRequestBody");
            e5.b.h(toRequestBody.length, i6, i7);
            return new C0057a(toRequestBody, wVar, i7, i6);
        }
    }

    public abstract long a();

    public abstract w b();

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public abstract void e(q5.f fVar);
}
