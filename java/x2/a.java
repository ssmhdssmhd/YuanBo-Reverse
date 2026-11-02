package x2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import s2.b;

/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<? super T> f10472a;

    /* renamed from: b, reason: collision with root package name */
    private final Type f10473b;

    /* renamed from: c, reason: collision with root package name */
    private final int f10474c;

    protected a() {
        Type e6 = e();
        this.f10473b = e6;
        this.f10472a = (Class<? super T>) b.k(e6);
        this.f10474c = e6.hashCode();
    }

    private a(Type type) {
        Objects.requireNonNull(type);
        Type b6 = b.b(type);
        this.f10473b = b6;
        this.f10472a = (Class<? super T>) b.k(b6);
        this.f10474c = b6.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    public static a<?> b(Type type) {
        return new a<>(type);
    }

    private Type e() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == a.class) {
                return b.b(parameterizedType.getActualTypeArguments()[0]);
            }
        } else if (genericSuperclass == a.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.");
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public final Class<? super T> c() {
        return this.f10472a;
    }

    public final Type d() {
        return this.f10473b;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.f(this.f10473b, ((a) obj).f10473b);
    }

    public final int hashCode() {
        return this.f10474c;
    }

    public final String toString() {
        return b.t(this.f10473b);
    }
}
