package androidx.lifecycle;

/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private final a f902a;

    /* renamed from: b, reason: collision with root package name */
    private final x f903b;

    public interface a {
        <T extends v> T a(Class<T> cls);
    }

    static abstract class b implements a {
        b() {
        }

        @Override // androidx.lifecycle.w.a
        public <T extends v> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends v> T b(String str, Class<T> cls);
    }

    public w(x xVar, a aVar) {
        this.f902a = aVar;
        this.f903b = xVar;
    }

    public <T extends v> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public <T extends v> T b(String str, Class<T> cls) {
        T t5 = (T) this.f903b.b(str);
        if (cls.isInstance(t5)) {
            return t5;
        }
        a aVar = this.f902a;
        T t6 = aVar instanceof b ? (T) ((b) aVar).b(str, cls) : (T) aVar.a(cls);
        this.f903b.c(str, t6);
        return t6;
    }
}
