package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected final f.a<String, Method> f1442a;

    /* renamed from: b, reason: collision with root package name */
    protected final f.a<String, Method> f1443b;

    /* renamed from: c, reason: collision with root package name */
    protected final f.a<String, Class> f1444c;

    public a(f.a<String, Method> aVar, f.a<String, Method> aVar2, f.a<String, Class> aVar3) {
        this.f1442a = aVar;
        this.f1443b = aVar2;
        this.f1444c = aVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N(u.b bVar) {
        try {
            I(c(bVar.getClass()).getName());
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException(bVar.getClass().getSimpleName() + " does not have a Parcelizer", e6);
        }
    }

    private Class c(Class<? extends u.b> cls) {
        Class cls2 = this.f1444c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f1444c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) {
        Method method = this.f1442a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
        this.f1442a.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method e(Class cls) {
        Method method = this.f1443b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class c6 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c6.getDeclaredMethod("write", cls, a.class);
        this.f1443b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    protected abstract void A(byte[] bArr);

    public void B(byte[] bArr, int i6) {
        w(i6);
        A(bArr);
    }

    protected abstract void C(CharSequence charSequence);

    public void D(CharSequence charSequence, int i6) {
        w(i6);
        C(charSequence);
    }

    protected abstract void E(int i6);

    public void F(int i6, int i7) {
        w(i7);
        E(i6);
    }

    protected abstract void G(Parcelable parcelable);

    public void H(Parcelable parcelable, int i6) {
        w(i6);
        G(parcelable);
    }

    protected abstract void I(String str);

    public void J(String str, int i6) {
        w(i6);
        I(str);
    }

    protected <T extends u.b> void K(T t5, a aVar) {
        try {
            e(t5.getClass()).invoke(null, t5, aVar);
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e6);
        } catch (IllegalAccessException e7) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e7);
        } catch (NoSuchMethodException e8) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e8);
        } catch (InvocationTargetException e9) {
            if (!(e9.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e9);
            }
            throw ((RuntimeException) e9.getCause());
        }
    }

    protected void L(u.b bVar) {
        if (bVar == null) {
            I(null);
            return;
        }
        N(bVar);
        a b6 = b();
        K(bVar, b6);
        b6.a();
    }

    public void M(u.b bVar, int i6) {
        w(i6);
        L(bVar);
    }

    protected abstract void a();

    protected abstract a b();

    public boolean f() {
        return false;
    }

    protected abstract boolean g();

    public boolean h(boolean z5, int i6) {
        return !m(i6) ? z5 : g();
    }

    protected abstract byte[] i();

    public byte[] j(byte[] bArr, int i6) {
        return !m(i6) ? bArr : i();
    }

    protected abstract CharSequence k();

    public CharSequence l(CharSequence charSequence, int i6) {
        return !m(i6) ? charSequence : k();
    }

    protected abstract boolean m(int i6);

    protected <T extends u.b> T n(String str, a aVar) {
        try {
            return (T) d(str).invoke(null, aVar);
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e6);
        } catch (IllegalAccessException e7) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e7);
        } catch (NoSuchMethodException e8) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e8);
        } catch (InvocationTargetException e9) {
            if (e9.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e9.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e9);
        }
    }

    protected abstract int o();

    public int p(int i6, int i7) {
        return !m(i7) ? i6 : o();
    }

    protected abstract <T extends Parcelable> T q();

    public <T extends Parcelable> T r(T t5, int i6) {
        return !m(i6) ? t5 : (T) q();
    }

    protected abstract String s();

    public String t(String str, int i6) {
        return !m(i6) ? str : s();
    }

    protected <T extends u.b> T u() {
        String s5 = s();
        if (s5 == null) {
            return null;
        }
        return (T) n(s5, b());
    }

    public <T extends u.b> T v(T t5, int i6) {
        return !m(i6) ? t5 : (T) u();
    }

    protected abstract void w(int i6);

    public void x(boolean z5, boolean z6) {
    }

    protected abstract void y(boolean z5);

    public void z(boolean z5, int i6) {
        w(i6);
        y(z5);
    }
}
