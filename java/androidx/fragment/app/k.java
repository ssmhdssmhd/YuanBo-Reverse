package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
class k extends v {

    /* renamed from: i, reason: collision with root package name */
    private static final w.a f702i = new a();

    /* renamed from: f, reason: collision with root package name */
    private final boolean f706f;

    /* renamed from: c, reason: collision with root package name */
    private final HashSet<Fragment> f703c = new HashSet<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, k> f704d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, x> f705e = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private boolean f707g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f708h = false;

    static class a implements w.a {
        a() {
        }

        @Override // androidx.lifecycle.w.a
        public <T extends v> T a(Class<T> cls) {
            return new k(true);
        }
    }

    k(boolean z5) {
        this.f706f = z5;
    }

    static k g(x xVar) {
        return (k) new w(xVar, f702i).a(k.class);
    }

    @Override // androidx.lifecycle.v
    protected void c() {
        if (i.H) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f707g = true;
    }

    boolean d(Fragment fragment) {
        return this.f703c.add(fragment);
    }

    void e(Fragment fragment) {
        if (i.H) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        k kVar = this.f704d.get(fragment.f565e);
        if (kVar != null) {
            kVar.c();
            this.f704d.remove(fragment.f565e);
        }
        x xVar = this.f705e.get(fragment.f565e);
        if (xVar != null) {
            xVar.a();
            this.f705e.remove(fragment.f565e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        return this.f703c.equals(kVar.f703c) && this.f704d.equals(kVar.f704d) && this.f705e.equals(kVar.f705e);
    }

    k f(Fragment fragment) {
        k kVar = this.f704d.get(fragment.f565e);
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = new k(this.f706f);
        this.f704d.put(fragment.f565e, kVar2);
        return kVar2;
    }

    Collection<Fragment> h() {
        return this.f703c;
    }

    public int hashCode() {
        return (((this.f703c.hashCode() * 31) + this.f704d.hashCode()) * 31) + this.f705e.hashCode();
    }

    x i(Fragment fragment) {
        x xVar = this.f705e.get(fragment.f565e);
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x();
        this.f705e.put(fragment.f565e, xVar2);
        return xVar2;
    }

    boolean j() {
        return this.f707g;
    }

    boolean k(Fragment fragment) {
        return this.f703c.remove(fragment);
    }

    boolean l(Fragment fragment) {
        if (this.f703c.contains(fragment)) {
            return this.f706f ? this.f707g : !this.f708h;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f703c.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f704d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f705e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
