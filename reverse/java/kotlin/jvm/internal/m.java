package kotlin.jvm.internal;

/* loaded from: classes.dex */
public final class m implements d {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f7010a;

    /* renamed from: b, reason: collision with root package name */
    private final String f7011b;

    public m(Class<?> jClass, String moduleName) {
        k.e(jClass, "jClass");
        k.e(moduleName, "moduleName");
        this.f7010a = jClass;
        this.f7011b = moduleName;
    }

    @Override // kotlin.jvm.internal.d
    public Class<?> b() {
        return this.f7010a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && k.a(b(), ((m) obj).b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
