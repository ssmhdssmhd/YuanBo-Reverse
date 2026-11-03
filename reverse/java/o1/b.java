package o1;

import android.os.SystemClock;
import android.util.Pair;
import i2.c1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import m2.t;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Long> f8440a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Integer, Long> f8441b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<List<Pair<String, Integer>>, p1.b> f8442c;

    /* renamed from: d, reason: collision with root package name */
    private final Random f8443d;

    public b() {
        this(new Random());
    }

    b(Random random) {
        this.f8442c = new HashMap();
        this.f8443d = random;
        this.f8440a = new HashMap();
        this.f8441b = new HashMap();
    }

    private static <T> void b(T t5, long j6, Map<T, Long> map) {
        if (map.containsKey(t5)) {
            j6 = Math.max(j6, ((Long) c1.j(map.get(t5))).longValue());
        }
        map.put(t5, Long.valueOf(j6));
    }

    private List<p1.b> c(List<p1.b> list) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h(elapsedRealtime, this.f8440a);
        h(elapsedRealtime, this.f8441b);
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            p1.b bVar = list.get(i6);
            if (!this.f8440a.containsKey(bVar.f8542b) && !this.f8441b.containsKey(Integer.valueOf(bVar.f8543c))) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(p1.b bVar, p1.b bVar2) {
        int compare = Integer.compare(bVar.f8543c, bVar2.f8543c);
        return compare != 0 ? compare : bVar.f8542b.compareTo(bVar2.f8542b);
    }

    public static int f(List<p1.b> list) {
        HashSet hashSet = new HashSet();
        for (int i6 = 0; i6 < list.size(); i6++) {
            hashSet.add(Integer.valueOf(list.get(i6).f8543c));
        }
        return hashSet.size();
    }

    private static <T> void h(long j6, Map<T, Long> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<T, Long> entry : map.entrySet()) {
            if (entry.getValue().longValue() <= j6) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            map.remove(arrayList.get(i6));
        }
    }

    private p1.b k(List<p1.b> list) {
        int i6 = 0;
        for (int i7 = 0; i7 < list.size(); i7++) {
            i6 += list.get(i7).f8544d;
        }
        int nextInt = this.f8443d.nextInt(i6);
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            p1.b bVar = list.get(i9);
            i8 += bVar.f8544d;
            if (nextInt < i8) {
                return bVar;
            }
        }
        return (p1.b) t.c(list);
    }

    public void e(p1.b bVar, long j6) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j6;
        b(bVar.f8542b, elapsedRealtime, this.f8440a);
        int i6 = bVar.f8543c;
        if (i6 != Integer.MIN_VALUE) {
            b(Integer.valueOf(i6), elapsedRealtime, this.f8441b);
        }
    }

    public int g(List<p1.b> list) {
        HashSet hashSet = new HashSet();
        List<p1.b> c6 = c(list);
        for (int i6 = 0; i6 < c6.size(); i6++) {
            hashSet.add(Integer.valueOf(c6.get(i6).f8543c));
        }
        return hashSet.size();
    }

    public void i() {
        this.f8440a.clear();
        this.f8441b.clear();
        this.f8442c.clear();
    }

    public p1.b j(List<p1.b> list) {
        Object obj;
        List<p1.b> c6 = c(list);
        if (c6.size() >= 2) {
            Collections.sort(c6, new Comparator() { // from class: o1.a
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    int d6;
                    d6 = b.d((p1.b) obj2, (p1.b) obj3);
                    return d6;
                }
            });
            ArrayList arrayList = new ArrayList();
            int i6 = c6.get(0).f8543c;
            int i7 = 0;
            while (true) {
                if (i7 >= c6.size()) {
                    break;
                }
                p1.b bVar = c6.get(i7);
                if (i6 == bVar.f8543c) {
                    arrayList.add(new Pair(bVar.f8542b, Integer.valueOf(bVar.f8544d)));
                    i7++;
                } else if (arrayList.size() == 1) {
                    obj = c6.get(0);
                }
            }
            p1.b bVar2 = this.f8442c.get(arrayList);
            if (bVar2 != null) {
                return bVar2;
            }
            p1.b k6 = k(c6.subList(0, arrayList.size()));
            this.f8442c.put(arrayList, k6);
            return k6;
        }
        obj = t.b(c6, null);
        return (p1.b) obj;
    }
}
