package com.tendcloud.tenddata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class bb {

    /* renamed from: a, reason: collision with root package name */
    private static int f2346a = 2;

    /* renamed from: b, reason: collision with root package name */
    private static int f2347b = 6;

    /* renamed from: c, reason: collision with root package name */
    private static int f2348c = 6;

    /* renamed from: d, reason: collision with root package name */
    private static int f2349d = -40;

    /* renamed from: e, reason: collision with root package name */
    private static int f2350e = 4;

    /* renamed from: f, reason: collision with root package name */
    private ay f2351f;

    class a {
        public ba fp1;
        public ba fp2;
        public double score;

        public a(ba baVar, ba baVar2, double d6) {
            this.fp1 = baVar;
            this.fp2 = baVar2;
            this.score = d6;
        }
    }

    class b {
        public Object key;
        public Object value;

        public b(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
        }
    }

    public bb() {
        this(new ay());
    }

    public bb(ay ayVar) {
        this.f2351f = ayVar;
    }

    public double a(int i6, int i7) {
        if (i6 >= 0 || i7 >= 0) {
            return 0.0d;
        }
        double d6 = (i7 + i6) / 2;
        double abs = Math.abs(i6 - d6);
        int i8 = f2346a;
        return Math.pow(((abs > ((double) i8) ? abs - i8 : 0.0d) + d6) / d6, f2347b);
    }

    public double a(ba baVar, ba baVar2) {
        Map<String, ax> a6 = baVar.a(false);
        Map<String, ax> a7 = baVar2.a(false);
        HashSet hashSet = new HashSet();
        int i6 = 0;
        int i7 = 0;
        double d6 = 0.0d;
        double d7 = 0.0d;
        for (Map.Entry<String, ax> entry : a6.entrySet()) {
            ax value = entry.getValue();
            ax axVar = a7.get(entry.getKey());
            i7 += value.c();
            if (axVar == null) {
                hashSet.add(value);
            } else {
                i6++;
                double b6 = b(value.c(), axVar.c());
                d6 += b6;
                d7 += b6 * a(value.c(), axVar.c());
            }
        }
        if (i6 == 0) {
            return 0.0d;
        }
        for (Map.Entry<String, ax> entry2 : a7.entrySet()) {
            i7 += entry2.getValue().c();
            if (!a6.containsKey(entry2.getKey())) {
                hashSet.add(entry2.getValue());
            }
        }
        int max = Math.max(this.f2351f.d(), (int) ((i7 / ((baVar.c().size() + baVar2.c().size()) - 0)) + 1.2d));
        Iterator it = hashSet.iterator();
        double d8 = 0.0d;
        while (it.hasNext()) {
            if (((ax) it.next()).c() > max) {
                d8 += 1.0d;
            }
        }
        return (d7 / d6) * (1.0d - Math.pow(d8 / ((i6 * 2) + d8), f2350e));
    }

    public double a(ba baVar, List<ba> list) {
        Iterator<ba> it = list.iterator();
        double d6 = 0.0d;
        while (it.hasNext()) {
            d6 = Math.max(a(it.next(), baVar), d6);
        }
        return d6;
    }

    public double a(List<ba> list, List<ba> list2) {
        double d6 = 0.0d;
        if (list.isEmpty() || list2.isEmpty()) {
            return 0.0d;
        }
        LinkedList linkedList = new LinkedList();
        b(list, list2, linkedList);
        int i6 = 0;
        for (a aVar : linkedList) {
            if (aVar.fp1 != null && aVar.fp2 != null) {
                d6 += aVar.score;
                i6++;
            }
        }
        return d6 / i6;
    }

    public double a(List<ba> list, List<ba> list2, List<ba> list3) {
        ba d6;
        ba baVar;
        double d7 = 0.0d;
        if (list.isEmpty() || list2.isEmpty()) {
            list3.addAll(list);
            list3.addAll(list2);
            return 0.0d;
        }
        LinkedList linkedList = new LinkedList();
        b(list, list2, linkedList);
        int i6 = 0;
        for (a aVar : linkedList) {
            ba baVar2 = aVar.fp1;
            if (baVar2 != null && (baVar = aVar.fp2) != null) {
                d7 += aVar.score;
                i6++;
                d6 = b(baVar2, baVar);
            } else if (list3.size() < this.f2351f.b()) {
                ba baVar3 = aVar.fp1;
                d6 = baVar3 == null ? aVar.fp2.d() : baVar3.d();
            }
            list3.add(d6);
        }
        return d7 / i6;
    }

    public double b(int i6, int i7) {
        if (i6 >= 0 || i7 >= 0) {
            return 0.0d;
        }
        double max = Math.max(i6, i7);
        if (max >= f2349d) {
            return 1.0d;
        }
        return Math.pow((max + 128.0d) / (r0 + 128), f2348c);
    }

    public ba b(ba baVar, ba baVar2) {
        Map<String, ax> a6 = baVar.a(false);
        Map<String, ax> a7 = baVar2.a(false);
        TreeMap treeMap = new TreeMap();
        ba baVar3 = new ba();
        baVar3.setPoiId(baVar2.b());
        baVar3.setTimestamp(baVar2.a());
        LinkedList linkedList = new LinkedList();
        baVar3.setBsslist(linkedList);
        for (Map.Entry<String, ax> entry : a6.entrySet()) {
            ax value = entry.getValue();
            ax axVar = a7.get(entry.getKey());
            if (axVar == null) {
                double d6 = -value.c();
                while (treeMap.containsKey(Double.valueOf(d6))) {
                    d6 += 1.0E-4d;
                }
                treeMap.put(Double.valueOf(d6), value);
            } else {
                linkedList.add(new ax(axVar.a(), axVar.b(), (byte) ((axVar.c() + value.c()) / 2), axVar.d(), axVar.e()));
            }
        }
        for (Map.Entry<String, ax> entry2 : a7.entrySet()) {
            if (!a6.containsKey(entry2.getKey())) {
                double d7 = -entry2.getValue().c();
                while (treeMap.containsKey(Double.valueOf(d7))) {
                    d7 += 1.0E-4d;
                }
                treeMap.put(Double.valueOf(d7), entry2.getValue());
            }
        }
        for (Map.Entry entry3 : treeMap.entrySet()) {
            byte b6 = (byte) (-((Double) entry3.getKey()).doubleValue());
            if (linkedList.size() >= this.f2351f.c() || b6 < this.f2351f.d()) {
                break;
            }
            linkedList.add(entry3.getValue());
        }
        return baVar3;
    }

    public void b(List<ba> list, List<ba> list2, List<a> list3) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (ba baVar : list) {
            for (ba baVar2 : list2) {
                hashSet2.add(baVar2);
                arrayList.add(new a(baVar, baVar2, a(baVar, baVar2)));
            }
            hashSet.add(baVar);
        }
        Collections.sort(arrayList, new Comparator<a>() { // from class: com.tendcloud.tenddata.bb.1
            @Override // java.util.Comparator
            public int compare(a aVar, a aVar2) {
                double d6 = aVar.score;
                double d7 = aVar2.score;
                if (d6 == d7) {
                    return 0;
                }
                return d6 < d7 ? 1 : -1;
            }
        });
        list3.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (hashSet.contains(aVar.fp1) && hashSet2.contains(aVar.fp2)) {
                hashSet.remove(aVar.fp1);
                hashSet2.remove(aVar.fp2);
                list3.add(aVar);
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            list3.add(new a((ba) it2.next(), null, 0.0d));
        }
        Iterator it3 = hashSet2.iterator();
        while (it3.hasNext()) {
            list3.add(new a(null, (ba) it3.next(), 0.0d));
        }
    }
}
