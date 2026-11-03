package com.tendcloud.tenddata;

import com.tendcloud.tenddata.zz;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class bg {

    /* renamed from: a, reason: collision with root package name */
    private static volatile bg f2388a;

    static {
        try {
            z.a().register(a());
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private bg() {
    }

    public static bg a() {
        if (f2388a == null) {
            synchronized (bg.class) {
                if (f2388a == null) {
                    f2388a = new bg();
                }
            }
        }
        return f2388a;
    }

    private Map<String, Object> a(Map<String, Object> map) {
        String a6;
        Object a7;
        TreeMap treeMap = new TreeMap();
        if (map != null) {
            try {
                if (map.size() == 0) {
                    return treeMap;
                }
                int i6 = 0;
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (entry.getValue() instanceof Number) {
                        a6 = entry.getKey();
                        a7 = entry.getValue();
                    } else {
                        a6 = y.a(String.valueOf(entry.getKey()));
                        a7 = y.a(String.valueOf(entry.getValue()));
                    }
                    treeMap.put(a6, a7);
                    i6++;
                    if (i6 == 50) {
                        break;
                    }
                }
            } catch (Throwable th) {
                bq.postSDKError(th);
            }
        }
        return treeMap;
    }

    public final void onTDEBEventAppEvent(zz.a aVar) {
        if (aVar != null) {
            try {
                HashMap<String, Object> hashMap = aVar.paraMap;
                if (hashMap != null && Integer.parseInt(String.valueOf(hashMap.get("apiType"))) == 2) {
                    a aVar2 = (a) aVar.paraMap.get("service");
                    TreeMap treeMap = new TreeMap();
                    String valueOf = String.valueOf(aVar.paraMap.get("eventId"));
                    Object obj = aVar.paraMap.get("value");
                    Map<String, Object> map = ab.f2230d;
                    if (map.size() > 0) {
                        treeMap.putAll(map);
                    }
                    Object obj2 = aVar.paraMap.get("map");
                    if (obj2 != null && (obj2 instanceof Map)) {
                        treeMap.putAll((Map) obj2);
                    }
                    bz bzVar = new bz();
                    bzVar.f2493b = "appEvent";
                    bzVar.f2494c = valueOf;
                    bzVar.f2492a = aVar2;
                    TreeMap treeMap2 = new TreeMap();
                    Object obj3 = aVar.paraMap.get("eventLabel");
                    if (obj3 != null) {
                        treeMap2.put("eventLabel", String.valueOf(obj3));
                    }
                    treeMap2.put("eventParam", new JSONObject(a(treeMap)));
                    if (obj instanceof Double) {
                        treeMap2.put("value", obj);
                    }
                    Object obj4 = aVar.paraMap.get("eventValue");
                    if (obj4 != null) {
                        treeMap2.put("eventValue", obj4);
                    }
                    bzVar.f2495d = treeMap2;
                    z.a().post(bzVar);
                }
            } catch (NumberFormatException e6) {
                bq.postSDKError(e6);
            }
        }
    }
}
