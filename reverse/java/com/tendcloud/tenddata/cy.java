package com.tendcloud.tenddata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cy extends da {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Object> f2570a = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, Object> f2571c = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private static volatile cy f2572f = null;

    /* renamed from: d, reason: collision with root package name */
    private final String[] f2573d = {"PUSH", "EAuth"};

    /* renamed from: e, reason: collision with root package name */
    private final String[] f2574e = {"APP", "TRACKING", "GAME", "BG", "SDK"};

    private cy() {
        a("displayName", g.a().h(ab.f2233g));
        a("globalId", g.a().a(ab.f2233g));
        a("versionName", i.k());
        a("versionCode", Integer.valueOf(i.j()));
        a("installTime", Long.valueOf(g.a().d(ab.f2233g)));
        a("updateTime", Long.valueOf(g.a().e(ab.f2233g)));
    }

    public static cy a() {
        if (f2572f == null) {
            synchronized (cr.class) {
                if (f2572f == null) {
                    f2572f = new cy();
                }
            }
        }
        return f2572f;
    }

    private Object a(a aVar) {
        Object obj = null;
        obj = null;
        if (aVar != null) {
            try {
                if (Arrays.asList(this.f2573d).contains(aVar.name())) {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appKey", (Object) null);
                    jSONObject.put("service", (Object) null);
                    jSONArray.put(jSONObject);
                    try {
                        if (!y.b((String) null)) {
                            a(jSONArray, aVar);
                        }
                    } catch (Throwable unused) {
                    }
                    obj = jSONArray;
                } else if (Arrays.asList(this.f2574e).contains(aVar.name())) {
                    String a6 = ab.a(ab.f2233g, aVar);
                    boolean b6 = y.b(a6);
                    obj = a6;
                    if (!b6) {
                        a((Object) a6, aVar);
                        obj = a6;
                    }
                } else {
                    obj = f2570a.get(c().get(0).name());
                }
            } catch (Throwable unused2) {
            }
        }
        return obj;
    }

    private ArrayList<a> c() {
        ArrayList<a> arrayList = new ArrayList<>();
        try {
            Iterator<Map.Entry<String, Object>> it = f2570a.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(a.valueOf(it.next().getKey().toString()));
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public void a(Object obj, a aVar) {
        f2570a.put(aVar.name(), obj);
    }

    public void b(Object obj, a aVar) {
        f2571c.put(aVar.name(), obj);
    }

    public void setAppChannel(String str) {
        a("channel", str);
    }

    public void setSubmitAppId(a aVar) {
        if (aVar != null) {
            try {
                Object obj = f2570a.get(aVar.name());
                if (obj == null && f2570a.size() > 0) {
                    obj = a(aVar);
                }
                a("appKey", obj);
            } catch (Throwable unused) {
            }
        }
    }

    public void setSubmitChannelId(a aVar) {
        if (aVar == null) {
            setAppChannel("Default");
            return;
        }
        try {
            Object obj = f2571c.get(aVar.name());
            if (obj == null && f2571c.size() > 0) {
                obj = f2571c.get(c().get(0).name());
            }
            a("channel", obj);
        } catch (Throwable unused) {
        }
    }

    public void setUniqueId(String str) {
        a("uniqueId", str);
    }
}
