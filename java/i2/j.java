package i2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class j<E> implements Iterable<E> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f5582a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final Map<E, Integer> f5583b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private Set<E> f5584c = Collections.emptySet();

    /* renamed from: d, reason: collision with root package name */
    private List<E> f5585d = Collections.emptyList();

    public Set<E> a() {
        Set<E> set;
        synchronized (this.f5582a) {
            set = this.f5584c;
        }
        return set;
    }

    public void b(E e6) {
        synchronized (this.f5582a) {
            ArrayList arrayList = new ArrayList(this.f5585d);
            arrayList.add(e6);
            this.f5585d = Collections.unmodifiableList(arrayList);
            Integer num = this.f5583b.get(e6);
            if (num == null) {
                HashSet hashSet = new HashSet(this.f5584c);
                hashSet.add(e6);
                this.f5584c = Collections.unmodifiableSet(hashSet);
            }
            this.f5583b.put(e6, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    public int c(E e6) {
        int intValue;
        synchronized (this.f5582a) {
            intValue = this.f5583b.containsKey(e6) ? this.f5583b.get(e6).intValue() : 0;
        }
        return intValue;
    }

    public void d(E e6) {
        synchronized (this.f5582a) {
            Integer num = this.f5583b.get(e6);
            if (num == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f5585d);
            arrayList.remove(e6);
            this.f5585d = Collections.unmodifiableList(arrayList);
            if (num.intValue() == 1) {
                this.f5583b.remove(e6);
                HashSet hashSet = new HashSet(this.f5584c);
                hashSet.remove(e6);
                this.f5584c = Collections.unmodifiableSet(hashSet);
            } else {
                this.f5583b.put(e6, Integer.valueOf(num.intValue() - 1));
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.f5582a) {
            it = this.f5585d.iterator();
        }
        return it;
    }
}
