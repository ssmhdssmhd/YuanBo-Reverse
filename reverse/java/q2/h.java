package q2;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class h extends k implements Iterable<k> {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<k> f8911a = new ArrayList<>();

    private k k() {
        int size = this.f8911a.size();
        if (size == 1) {
            return this.f8911a.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }

    @Override // q2.k
    public String e() {
        return k().e();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof h) && ((h) obj).f8911a.equals(this.f8911a));
    }

    public int hashCode() {
        return this.f8911a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<k> iterator() {
        return this.f8911a.iterator();
    }

    public void j(k kVar) {
        if (kVar == null) {
            kVar = m.f8912a;
        }
        this.f8911a.add(kVar);
    }
}
