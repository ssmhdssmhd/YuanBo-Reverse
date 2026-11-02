package w4;

import h4.g;
import java.io.Closeable;

/* loaded from: classes.dex */
public abstract class c1 extends c0 implements Closeable {

    /* renamed from: b, reason: collision with root package name */
    public static final a f10286b = new a(null);

    public static final class a extends h4.b<c0, c1> {

        /* renamed from: w4.c1$a$a, reason: collision with other inner class name */
        static final class C0161a extends kotlin.jvm.internal.l implements o4.l<g.b, c1> {

            /* renamed from: a, reason: collision with root package name */
            public static final C0161a f10287a = new C0161a();

            C0161a() {
                super(1);
            }

            @Override // o4.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final c1 invoke(g.b bVar) {
                if (bVar instanceof c1) {
                    return (c1) bVar;
                }
                return null;
            }
        }

        private a() {
            super(c0.f10284a, C0161a.f10287a);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }
}
