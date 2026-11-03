package l5;

import java.util.List;

/* loaded from: classes.dex */
public interface l {

    /* renamed from: b, reason: collision with root package name */
    public static final a f7727b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public static final l f7726a = new a.C0112a();

    public static final class a {

        /* renamed from: l5.l$a$a, reason: collision with other inner class name */
        private static final class C0112a implements l {
            @Override // l5.l
            public boolean a(int i6, List<c> requestHeaders) {
                kotlin.jvm.internal.k.e(requestHeaders, "requestHeaders");
                return true;
            }

            @Override // l5.l
            public boolean b(int i6, List<c> responseHeaders, boolean z5) {
                kotlin.jvm.internal.k.e(responseHeaders, "responseHeaders");
                return true;
            }

            @Override // l5.l
            public boolean c(int i6, q5.g source, int i7, boolean z5) {
                kotlin.jvm.internal.k.e(source, "source");
                source.skip(i7);
                return true;
            }

            @Override // l5.l
            public void d(int i6, b errorCode) {
                kotlin.jvm.internal.k.e(errorCode, "errorCode");
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    boolean a(int i6, List<c> list);

    boolean b(int i6, List<c> list, boolean z5);

    boolean c(int i6, q5.g gVar, int i7, boolean z5);

    void d(int i6, b bVar);
}
