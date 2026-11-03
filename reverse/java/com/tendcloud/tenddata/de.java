package com.tendcloud.tenddata;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class de extends da {
    public de() {
        a("tid", j.a(ab.f2233g));
    }

    public void a() {
        a("serialNo", l.a("serialNo"));
        JSONArray a6 = bi.a().a("AdID");
        if (a6 != null) {
            a("adId", l.b(ab.f2233g));
            if (a6.length() > 0) {
                dm.b().a("AdID", a6);
            }
        } else {
            a("adId", this.f2581b);
        }
        JSONArray a7 = bi.a().a("IMEI", dm.b().f2626a, dm.b().f2627b);
        if (a7 != null) {
            try {
                JSONArray A = o.A(ab.f2233g);
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                JSONArray jSONArray4 = new JSONArray();
                if (A != null && A.length() > 0) {
                    JSONObject jSONObject = A.getJSONObject(0);
                    if (jSONObject.has("imei")) {
                        jSONArray.put(jSONObject.get("imei"));
                    }
                    if (jSONObject.has("imei5")) {
                        jSONArray2.put(jSONObject.get("imei5"));
                    }
                    if (jSONObject.has("meid")) {
                        jSONArray3.put(jSONObject.get("meid"));
                    }
                    if (jSONObject.has("meid5")) {
                        jSONArray4.put(jSONObject.get("meid5"));
                    }
                    if (A.length() == 2) {
                        JSONObject jSONObject2 = A.getJSONObject(1);
                        if (jSONObject2.has("imei")) {
                            jSONArray.put(jSONObject2.get("imei"));
                        }
                        if (jSONObject2.has("imei5")) {
                            jSONArray2.put(jSONObject2.get("imei5"));
                        }
                        if (jSONObject2.has("meid")) {
                            jSONArray3.put(jSONObject2.get("meid"));
                        }
                        if (jSONObject2.has("meid5")) {
                            jSONArray4.put(jSONObject2.get("meid5"));
                        }
                    }
                }
                a("imeis", jSONArray);
                a("imeis5", jSONArray2);
                a("meids", jSONArray3);
                a("meids5", jSONArray4);
            } catch (Exception unused) {
            }
            if (a7.length() > 0) {
                dm.b().a("IMEI", a7);
            }
        } else {
            a("imeis", this.f2581b);
        }
        JSONArray a8 = bi.a().a("MacAddress");
        if (a8 != null) {
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(l.a("mac"));
            a("wifiMacs", jSONArray5);
            JSONArray jSONArray6 = new JSONArray();
            jSONArray6.put(l.a("ethMac"));
            a("ethMacs", jSONArray6);
            if (a8.length() > 0) {
                dm.b().a("MacAddress", a8);
            }
        } else {
            a("wifiMacs", this.f2581b);
        }
        JSONArray a9 = bi.a().a("AndroidId");
        if (a9 != null) {
            a("androidId", l.a("androidId"));
            if (a9.length() > 0) {
                dm.b().a("AndroidId", a9);
            }
        } else {
            a("androidId", this.f2581b);
        }
        a("msaIds", dh.a().b());
    }
}
