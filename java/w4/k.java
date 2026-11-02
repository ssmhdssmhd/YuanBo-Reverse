package w4;

/* loaded from: classes.dex */
public interface k<T> extends h4.d<T> {

    public static final class a {
        public static /* synthetic */ Object a(k kVar, Object obj, Object obj2, int i6, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
            }
            if ((i6 & 2) != 0) {
                obj2 = null;
            }
            return kVar.c(obj, obj2);
        }
    }

    void b(o4.l<? super Throwable, e4.q> lVar);

    Object c(T t5, Object obj);

    Object f(T t5, Object obj, o4.l<? super Throwable, e4.q> lVar);

    void g(T t5, o4.l<? super Throwable, e4.q> lVar);

    Object h(Throwable th);

    void i(Object obj);
}
