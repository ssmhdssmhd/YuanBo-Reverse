package q2;

import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class n extends k {

    /* renamed from: a, reason: collision with root package name */
    private final s2.h<String, k> f8913a = new s2.h<>(false);

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof n) && ((n) obj).f8913a.equals(this.f8913a));
    }

    public int hashCode() {
        return this.f8913a.hashCode();
    }

    public void j(String str, k kVar) {
        s2.h<String, k> hVar = this.f8913a;
        if (kVar == null) {
            kVar = m.f8912a;
        }
        hVar.put(str, kVar);
    }

    public Set<Map.Entry<String, k>> k() {
        return this.f8913a.entrySet();
    }
}
