package com.tendcloud.tenddata;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class ba {

    /* renamed from: a, reason: collision with root package name */
    private int f2342a;

    /* renamed from: b, reason: collision with root package name */
    private long f2343b;

    /* renamed from: c, reason: collision with root package name */
    private List<ax> f2344c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, ax> f2345d;

    public int a() {
        return this.f2342a;
    }

    public Map<String, ax> a(boolean z5) {
        if (this.f2345d == null || z5) {
            this.f2345d = new HashMap();
            for (ax axVar : this.f2344c) {
                this.f2345d.put(axVar.b(), axVar);
            }
        }
        return this.f2345d;
    }

    public long b() {
        return this.f2343b;
    }

    public List<ax> c() {
        return this.f2344c;
    }

    public ba d() {
        ba baVar = new ba();
        baVar.setTimestamp(this.f2342a);
        baVar.setPoiId(this.f2343b);
        LinkedList linkedList = new LinkedList();
        Iterator<ax> it = this.f2344c.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().f());
        }
        baVar.setBsslist(linkedList);
        return baVar;
    }

    public void setBsslist(List<ax> list) {
        this.f2344c = list;
    }

    public void setPoiId(long j6) {
        this.f2343b = j6;
    }

    public void setTimestamp(int i6) {
        this.f2342a = i6;
    }
}
