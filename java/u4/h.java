package u4;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends g {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements d<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f9673a;

        public a(Iterator it) {
            this.f9673a = it;
        }

        @Override // u4.d
        public Iterator<T> iterator() {
            return this.f9673a;
        }
    }

    public static <T> d<T> a(Iterator<? extends T> it) {
        kotlin.jvm.internal.k.e(it, "<this>");
        return b(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> d<T> b(d<? extends T> dVar) {
        kotlin.jvm.internal.k.e(dVar, "<this>");
        return dVar instanceof u4.a ? dVar : new u4.a(dVar);
    }
}
