package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import w4.v1;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f7072a;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f7073b;

    /* renamed from: c, reason: collision with root package name */
    public static final v1 f7074c;

    static {
        s sVar = new s();
        f7072a = sVar;
        f7073b = c0.e("kotlinx.coroutines.fast.service.loader", true);
        f7074c = sVar.a();
    }

    private s() {
    }

    private final v1 a() {
        u4.d a6;
        List<r> j6;
        Object next;
        try {
            if (f7073b) {
                j6 = h.f7044a.c();
            } else {
                a6 = u4.h.a(ServiceLoader.load(r.class, r.class.getClassLoader()).iterator());
                j6 = u4.j.j(a6);
            }
            Iterator<T> it = j6.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((r) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((r) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            r rVar = (r) next;
            v1 e6 = rVar == null ? null : t.e(rVar, j6);
            return e6 == null ? t.b(null, null, 3, null) : e6;
        } catch (Throwable th) {
            return t.b(th, null, 2, null);
        }
    }
}
