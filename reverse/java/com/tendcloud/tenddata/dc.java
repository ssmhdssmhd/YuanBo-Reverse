package com.tendcloud.tenddata;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class dc extends da {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2596a = "accounts";

    public void a() {
        a(f2596a, x.d(ab.f2233g));
    }

    public void c() {
        try {
            JSONObject jSONObject = (JSONObject) b();
            if (jSONObject.has(f2596a)) {
                JSONArray jSONArray = jSONObject.getJSONArray(f2596a);
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    if ("sim".equals(jSONArray.getJSONObject(i6).getString("type"))) {
                        JSONArray a6 = bi.a().a("IMEI", dm.b().f2626a, dm.b().f2627b);
                        if (a6 != null) {
                            jSONArray.getJSONObject(i6).put("extra", o.A(ab.f2233g));
                            if (a6.length() > 0) {
                                dm.b().a("IMEI", a6);
                            }
                        } else {
                            JSONArray jSONArray2 = jSONArray.getJSONObject(i6).getJSONArray("extra");
                            if (jSONArray2 != null) {
                                for (int i7 = 0; i7 < jSONArray2.length(); i7++) {
                                    a("imei", jSONArray2.getJSONObject(i7));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void d() {
        try {
            if (((JSONObject) b()).has(f2596a)) {
                return;
            }
            a(f2596a, x.d(ab.f2233g));
        } catch (Throwable unused) {
        }
    }

    public void setUserAccount(cw cwVar) {
        if (cwVar == null || cwVar.b() == null) {
            return;
        }
        if (this.f2581b.isNull(f2596a)) {
            new JSONArray().put(cwVar.b());
            a(f2596a, cwVar.b());
            return;
        }
        try {
            this.f2581b.getJSONArray(f2596a).put(cwVar.b());
        } catch (JSONException e6) {
            bq.postSDKError(e6);
            e6.printStackTrace();
        }
    }
}
