package com.tendcloud.tenddata;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ca {

    /* renamed from: a, reason: collision with root package name */
    public String f2499a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f2500b = null;

    /* renamed from: c, reason: collision with root package name */
    public String f2501c = String.valueOf(System.currentTimeMillis());

    /* renamed from: d, reason: collision with root package name */
    public JSONArray f2502d = new JSONArray();

    public HashMap<String, Object> a() {
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            if (this.f2502d.length() > 0) {
                hashMap.put("touch", this.f2502d);
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    public void a(cb cbVar, JSONArray jSONArray) {
        try {
            JSONObject a6 = cbVar.a();
            if (a6 == null || a6.length() <= 0) {
                return;
            }
            jSONArray.put(a6);
        } catch (Throwable unused) {
        }
    }
}
