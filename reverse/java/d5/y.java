package d5;

import java.io.IOException;

/* loaded from: classes.dex */
public enum y {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* renamed from: m, reason: collision with root package name */
    public static final a f3289m = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f3290a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final y a(String protocol) {
            kotlin.jvm.internal.k.e(protocol, "protocol");
            y yVar = y.HTTP_1_0;
            if (!kotlin.jvm.internal.k.a(protocol, yVar.f3290a)) {
                yVar = y.HTTP_1_1;
                if (!kotlin.jvm.internal.k.a(protocol, yVar.f3290a)) {
                    yVar = y.H2_PRIOR_KNOWLEDGE;
                    if (!kotlin.jvm.internal.k.a(protocol, yVar.f3290a)) {
                        yVar = y.HTTP_2;
                        if (!kotlin.jvm.internal.k.a(protocol, yVar.f3290a)) {
                            yVar = y.SPDY_3;
                            if (!kotlin.jvm.internal.k.a(protocol, yVar.f3290a)) {
                                yVar = y.QUIC;
                                if (!kotlin.jvm.internal.k.a(protocol, yVar.f3290a)) {
                                    throw new IOException("Unexpected protocol: " + protocol);
                                }
                            }
                        }
                    }
                }
            }
            return yVar;
        }
    }

    y(String str) {
        this.f3290a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f3290a;
    }
}
