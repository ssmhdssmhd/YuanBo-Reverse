package k5;

import d5.t;
import kotlin.jvm.internal.k;
import q5.g;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final C0103a f6964c = new C0103a(null);

    /* renamed from: a, reason: collision with root package name */
    private long f6965a;

    /* renamed from: b, reason: collision with root package name */
    private final g f6966b;

    /* renamed from: k5.a$a, reason: collision with other inner class name */
    public static final class C0103a {
        private C0103a() {
        }

        public /* synthetic */ C0103a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public a(g source) {
        k.e(source, "source");
        this.f6966b = source;
        this.f6965a = 262144;
    }

    public final t a() {
        t.a aVar = new t.a();
        while (true) {
            String b6 = b();
            if (b6.length() == 0) {
                return aVar.d();
            }
            aVar.b(b6);
        }
    }

    public final String b() {
        String G = this.f6966b.G(this.f6965a);
        this.f6965a -= G.length();
        return G;
    }
}
