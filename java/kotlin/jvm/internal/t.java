package kotlin.jvm.internal;

/* loaded from: classes.dex */
public class t {
    public t4.e a(i iVar) {
        return iVar;
    }

    public t4.c b(Class cls) {
        return new e(cls);
    }

    public t4.d c(Class cls, String str) {
        return new m(cls, str);
    }

    public t4.f d(n nVar) {
        return nVar;
    }

    public String e(h hVar) {
        String obj = hVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String f(l lVar) {
        return e(lVar);
    }
}
