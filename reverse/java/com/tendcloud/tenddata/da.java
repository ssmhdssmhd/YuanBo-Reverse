package com.tendcloud.tenddata;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class da {

    /* renamed from: b, reason: collision with root package name */
    protected JSONObject f2581b = new JSONObject();

    protected void a(String str, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (a(obj)) {
                return;
            }
            this.f2581b.put(str, obj);
        } catch (Throwable unused) {
        }
    }

    protected void a(String str, JSONObject jSONObject) {
        if (str == null) {
            return;
        }
        try {
            if (jSONObject.has(str)) {
                jSONObject.remove(str);
            }
        } catch (Throwable unused) {
        }
    }

    protected boolean a(Object obj) {
        return obj instanceof JSONObject ? ((JSONObject) obj).length() <= 0 : (obj instanceof JSONArray) && ((JSONArray) obj).length() <= 0;
    }

    public Object b() {
        return this.f2581b;
    }
}
