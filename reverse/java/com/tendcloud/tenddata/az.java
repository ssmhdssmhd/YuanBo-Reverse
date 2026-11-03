package com.tendcloud.tenddata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
final class az {

    /* renamed from: a, reason: collision with root package name */
    private static int f2336a = 2;

    /* renamed from: b, reason: collision with root package name */
    private static int f2337b = 6;

    /* renamed from: c, reason: collision with root package name */
    private static int f2338c = 6;

    /* renamed from: d, reason: collision with root package name */
    private static int f2339d = -40;

    /* renamed from: e, reason: collision with root package name */
    private static int f2340e = 4;

    /* renamed from: f, reason: collision with root package name */
    private b f2341f;

    class a {
        private byte band;
        private String bssid;
        private byte channel;
        private byte rssi;
        private String ssid;

        a() {
            this.ssid = "";
            this.bssid = "00:00:00:00:00:00";
            this.rssi = (byte) -127;
            this.band = (byte) 1;
            this.channel = (byte) 1;
        }

        a(String str, String str2, byte b6, byte b7, byte b8) {
            this.ssid = str;
            this.bssid = str2;
            this.rssi = b6;
            this.band = b7;
            this.channel = b8;
        }

        a cloneBssEntry() {
            return az.this.new a(this.ssid, this.bssid, this.rssi, this.band, this.channel);
        }

        byte getBand() {
            return this.band;
        }

        String getBssid() {
            return this.bssid;
        }

        byte getChannel() {
            return this.channel;
        }

        byte getRssi() {
            return this.rssi;
        }

        String getSsid() {
            return this.ssid;
        }

        void setBand(byte b6) {
            this.band = b6;
        }

        void setBssid(String str) {
            this.bssid = str;
        }

        void setChannel(byte b6) {
            this.channel = b6;
        }

        void setRssi(byte b6) {
            this.rssi = b6;
        }

        void setSsid(String str) {
            this.ssid = str;
        }
    }

    static class b {
        static final int DEFAULT_MAX_BSS_ENTRIES = 50;
        static final int DEFAULT_MAX_FINGERPRINTS = 10;
        static final int DEFAULT_MIN_FINGERPRINTS = 3;
        static final int DEFAULT_RSSI_THRESHOLD = -85;
        private int maxFingerprints = 10;
        private int minFingerprints = 3;
        private int maxBssEntries = 50;
        private int rssiThreshold = -85;

        b() {
        }

        int getMaxBssEntries() {
            return this.maxBssEntries;
        }

        int getMaxFingerprints() {
            return this.maxFingerprints;
        }

        int getMinFingerprints() {
            return this.minFingerprints;
        }

        int getRssiThreshold() {
            return this.rssiThreshold;
        }

        void setMaxBssEntries(int i6) {
            this.maxBssEntries = i6;
        }

        void setMaxFingerprints(int i6) {
            this.maxFingerprints = i6;
        }

        void setMinFingerprints(int i6) {
            this.minFingerprints = i6;
        }

        void setRssiThreshold(int i6) {
            this.rssiThreshold = i6;
        }
    }

    class c {
        private List<a> bsslist;
        private Map<String, a> bssmap;
        private long poiId;
        private int timestamp;

        c() {
        }

        c cloneFingerprint() {
            c cVar = az.this.new c();
            cVar.setTimestamp(this.timestamp);
            cVar.setPoiId(this.poiId);
            LinkedList linkedList = new LinkedList();
            Iterator<a> it = this.bsslist.iterator();
            while (it.hasNext()) {
                linkedList.add(it.next().cloneBssEntry());
            }
            cVar.setBsslist(linkedList);
            return cVar;
        }

        List<a> getBsslist() {
            return this.bsslist;
        }

        Map<String, a> getBssmap(boolean z5) {
            if (this.bssmap == null || z5) {
                this.bssmap = new HashMap();
                for (a aVar : this.bsslist) {
                    this.bssmap.put(aVar.getBssid(), aVar);
                }
            }
            return this.bssmap;
        }

        long getPoiId() {
            return this.poiId;
        }

        int getTimestamp() {
            return this.timestamp;
        }

        void setBsslist(List<a> list) {
            this.bsslist = list;
        }

        void setPoiId(long j6) {
            this.poiId = j6;
        }

        void setTimestamp(int i6) {
            this.timestamp = i6;
        }
    }

    class d {
        c fp1;
        c fp2;
        double score;

        d(c cVar, c cVar2, double d6) {
            this.fp1 = cVar;
            this.fp2 = cVar2;
            this.score = d6;
        }
    }

    class e {
        Object key;
        Object value;

        e(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
        }
    }

    az() {
        this(new b());
    }

    az(b bVar) {
        this.f2341f = bVar;
    }

    double a(int i6, int i7) {
        if (i6 >= 0 || i7 >= 0) {
            return 0.0d;
        }
        double d6 = (i7 + i6) / 2;
        double abs = Math.abs(i6 - d6);
        int i8 = f2336a;
        return Math.pow(((abs > ((double) i8) ? abs - i8 : 0.0d) + d6) / d6, f2337b);
    }

    double a(c cVar, c cVar2) {
        Map<String, a> bssmap = cVar.getBssmap(false);
        Map<String, a> bssmap2 = cVar2.getBssmap(false);
        HashSet hashSet = new HashSet();
        int i6 = 0;
        int i7 = 0;
        double d6 = 0.0d;
        double d7 = 0.0d;
        for (Map.Entry<String, a> entry : bssmap.entrySet()) {
            a value = entry.getValue();
            a aVar = bssmap2.get(entry.getKey());
            i7 += value.getRssi();
            if (aVar == null) {
                hashSet.add(value);
            } else {
                i6++;
                double b6 = b(value.getRssi(), aVar.getRssi());
                d6 += b6;
                d7 += b6 * a(value.getRssi(), aVar.getRssi());
            }
        }
        if (i6 == 0) {
            return 0.0d;
        }
        for (Map.Entry<String, a> entry2 : bssmap2.entrySet()) {
            i7 += entry2.getValue().getRssi();
            if (!bssmap.containsKey(entry2.getKey())) {
                hashSet.add(entry2.getValue());
            }
        }
        int max = Math.max(this.f2341f.getRssiThreshold(), (int) ((i7 / ((cVar.getBsslist().size() + cVar2.getBsslist().size()) - 0)) + 1.2d));
        Iterator it = hashSet.iterator();
        double d8 = 0.0d;
        while (it.hasNext()) {
            if (((a) it.next()).getRssi() > max) {
                d8 += 1.0d;
            }
        }
        return (d7 / d6) * (1.0d - Math.pow(d8 / ((i6 * 2) + d8), f2340e));
    }

    double a(c cVar, List<c> list) {
        Iterator<c> it = list.iterator();
        double d6 = 0.0d;
        while (it.hasNext()) {
            d6 = Math.max(a(it.next(), cVar), d6);
        }
        return d6;
    }

    double a(List<c> list, List<c> list2) {
        double d6 = 0.0d;
        if (list.isEmpty() || list2.isEmpty()) {
            return 0.0d;
        }
        LinkedList linkedList = new LinkedList();
        b(list, list2, linkedList);
        int i6 = 0;
        for (d dVar : linkedList) {
            if (dVar.fp1 != null && dVar.fp2 != null) {
                d6 += dVar.score;
                i6++;
            }
        }
        return d6 / i6;
    }

    double a(List<c> list, List<c> list2, List<c> list3) {
        c cloneFingerprint;
        c cVar;
        double d6 = 0.0d;
        if (list.isEmpty() || list2.isEmpty()) {
            list3.addAll(list);
            list3.addAll(list2);
            return 0.0d;
        }
        LinkedList linkedList = new LinkedList();
        b(list, list2, linkedList);
        int i6 = 0;
        for (d dVar : linkedList) {
            c cVar2 = dVar.fp1;
            if (cVar2 != null && (cVar = dVar.fp2) != null) {
                d6 += dVar.score;
                i6++;
                cloneFingerprint = b(cVar2, cVar);
            } else if (list3.size() < this.f2341f.getMinFingerprints()) {
                c cVar3 = dVar.fp1;
                cloneFingerprint = cVar3 == null ? dVar.fp2.cloneFingerprint() : cVar3.cloneFingerprint();
            }
            list3.add(cloneFingerprint);
        }
        return d6 / i6;
    }

    double b(int i6, int i7) {
        if (i6 >= 0 || i7 >= 0) {
            return 0.0d;
        }
        double max = Math.max(i6, i7);
        if (max >= f2339d) {
            return 1.0d;
        }
        return Math.pow((max + 128.0d) / (r0 + 128), f2338c);
    }

    c b(c cVar, c cVar2) {
        Map<String, a> bssmap = cVar.getBssmap(false);
        Map<String, a> bssmap2 = cVar2.getBssmap(false);
        TreeMap treeMap = new TreeMap();
        c cVar3 = new c();
        cVar3.setPoiId(cVar2.getPoiId());
        cVar3.setTimestamp(cVar2.getTimestamp());
        LinkedList linkedList = new LinkedList();
        cVar3.setBsslist(linkedList);
        for (Map.Entry<String, a> entry : bssmap.entrySet()) {
            a value = entry.getValue();
            a aVar = bssmap2.get(entry.getKey());
            if (aVar == null) {
                double d6 = -value.getRssi();
                while (treeMap.containsKey(Double.valueOf(d6))) {
                    d6 += 1.0E-4d;
                }
                treeMap.put(Double.valueOf(d6), value);
            } else {
                linkedList.add(new a(aVar.getSsid(), aVar.getBssid(), (byte) ((aVar.getRssi() + value.getRssi()) / 2), aVar.getBand(), aVar.getChannel()));
            }
        }
        for (Map.Entry<String, a> entry2 : bssmap2.entrySet()) {
            if (!bssmap.containsKey(entry2.getKey())) {
                double d7 = -entry2.getValue().getRssi();
                while (treeMap.containsKey(Double.valueOf(d7))) {
                    d7 += 1.0E-4d;
                }
                treeMap.put(Double.valueOf(d7), entry2.getValue());
            }
        }
        for (Map.Entry entry3 : treeMap.entrySet()) {
            byte b6 = (byte) (-((Double) entry3.getKey()).doubleValue());
            if (linkedList.size() >= this.f2341f.getMaxBssEntries() || b6 < this.f2341f.getRssiThreshold()) {
                break;
            }
            linkedList.add(entry3.getValue());
        }
        return cVar3;
    }

    void b(List<c> list, List<c> list2, List<d> list3) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (c cVar : list) {
            for (c cVar2 : list2) {
                hashSet2.add(cVar2);
                arrayList.add(new d(cVar, cVar2, a(cVar, cVar2)));
            }
            hashSet.add(cVar);
        }
        Collections.sort(arrayList, new Comparator<d>() { // from class: com.tendcloud.tenddata.az.1
            @Override // java.util.Comparator
            public int compare(d dVar, d dVar2) {
                if (Double.doubleToLongBits(dVar.score) == Double.doubleToLongBits(dVar2.score)) {
                    return 0;
                }
                return Double.doubleToLongBits(dVar.score) < Double.doubleToLongBits(dVar2.score) ? 1 : -1;
            }
        });
        list3.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (hashSet.contains(dVar.fp1) && hashSet2.contains(dVar.fp2)) {
                hashSet.remove(dVar.fp1);
                hashSet2.remove(dVar.fp2);
                list3.add(dVar);
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            list3.add(new d((c) it2.next(), null, 0.0d));
        }
        Iterator it3 = hashSet2.iterator();
        while (it3.hasNext()) {
            list3.add(new d(null, (c) it3.next(), 0.0d));
        }
    }
}
