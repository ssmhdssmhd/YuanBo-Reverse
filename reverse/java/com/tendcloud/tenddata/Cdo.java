package com.tendcloud.tenddata;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tendcloud.tenddata.do, reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo extends JSONArray {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2638a = "id";

    /* renamed from: b, reason: collision with root package name */
    private static final String f2639b = "category";

    /* renamed from: c, reason: collision with root package name */
    private static final String f2640c = "name";

    /* renamed from: d, reason: collision with root package name */
    private static final String f2641d = "unitPrice";

    /* renamed from: e, reason: collision with root package name */
    private static final String f2642e = "count";

    private Cdo() {
    }

    public static Cdo a() {
        return new Cdo();
    }

    public synchronized Cdo a(String str, String str2, String str3, int i6, int i7) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(f2638a, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(f2639b, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put(f2640c, str3);
            }
            jSONObject.put(f2641d, i6);
            jSONObject.put(f2642e, i7);
            put(jSONObject);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        return this;
    }
}
