package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class c implements t4.b, Serializable {
    public static final Object NO_RECEIVER = a.f7001a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient t4.b reflected;
    private final String signature;

    private static class a implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private static final a f7001a = new a();

        private a() {
        }
    }

    public c() {
        this(NO_RECEIVER);
    }

    protected c(Object obj) {
        this(obj, null, null, null, false);
    }

    protected c(Object obj, Class cls, String str, String str2, boolean z5) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z5;
    }

    @Override // t4.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // t4.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public t4.b compute() {
        t4.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        t4.b computeReflected = computeReflected();
        this.reflected = computeReflected;
        return computeReflected;
    }

    protected abstract t4.b computeReflected();

    @Override // t4.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public t4.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? s.c(cls) : s.b(cls);
    }

    @Override // t4.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    protected t4.b getReflected() {
        t4.b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new n4.b();
    }

    @Override // t4.b
    public t4.h getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // t4.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // t4.b
    public t4.i getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // t4.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // t4.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // t4.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // t4.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
