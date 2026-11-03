package kotlin.jvm.internal;

/* loaded from: classes.dex */
public abstract class n extends p implements t4.f {
    public n(Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, i6);
    }

    @Override // kotlin.jvm.internal.c
    protected t4.b computeReflected() {
        return s.d(this);
    }

    @Override // o4.a
    public Object invoke() {
        return get();
    }
}
