package d5;

import java.util.List;

/* loaded from: classes.dex */
public interface n {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3183b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public static final n f3182a = new a.C0060a();

    public static final class a {

        /* renamed from: d5.n$a$a, reason: collision with other inner class name */
        private static final class C0060a implements n {
            @Override // d5.n
            public void a(u url, List<m> cookies) {
                kotlin.jvm.internal.k.e(url, "url");
                kotlin.jvm.internal.k.e(cookies, "cookies");
            }

            @Override // d5.n
            public List<m> b(u url) {
                kotlin.jvm.internal.k.e(url, "url");
                return f4.l.f();
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    void a(u uVar, List<m> list);

    List<m> b(u uVar);
}
