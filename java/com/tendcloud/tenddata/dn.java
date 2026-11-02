package com.tendcloud.tenddata;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class dn extends JSONObject {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2628a = "keyOrderId";

    /* renamed from: b, reason: collision with root package name */
    public static final String f2629b = "keyTotalPrice";

    /* renamed from: c, reason: collision with root package name */
    public static final String f2630c = "keyCurrencyType";

    /* renamed from: d, reason: collision with root package name */
    public static final String f2631d = "keyOrderDetail";

    /* renamed from: e, reason: collision with root package name */
    private static final String f2632e = "id";

    /* renamed from: f, reason: collision with root package name */
    private static final String f2633f = "category";

    /* renamed from: g, reason: collision with root package name */
    private static final String f2634g = "name";

    /* renamed from: h, reason: collision with root package name */
    private static final String f2635h = "unitPrice";

    /* renamed from: i, reason: collision with root package name */
    private static final String f2636i = "count";

    /* renamed from: j, reason: collision with root package name */
    private JSONArray f2637j = null;

    private dn() {
    }

    private dn(String str, int i6, String str2) {
        try {
            put("keyOrderId", str);
            put("keyTotalPrice", i6);
            put("keyCurrencyType", str2);
        } catch (JSONException unused) {
        }
    }

    public static dn a(String str, int i6, String str2) {
        try {
            h.iForDeveloper("createOrder called --> orderId: " + str + " ,totalPrice: " + i6 + " ,currencyType: " + str2);
            if (TextUtils.isEmpty(str)) {
                h.eForDeveloper("createOrder: orderId could not be null or empty");
            }
            if (TextUtils.isEmpty(str2) || str2.trim().length() != 3) {
                h.eForDeveloper("createOrder: currencyType length must be 3 ,likes CNY");
            }
        } catch (Throwable unused) {
        }
        return new dn(str, i6, str2);
    }

    public synchronized dn a(String str, String str2, int i6, int i7) {
        try {
            if (this.f2637j == null) {
                JSONArray jSONArray = new JSONArray();
                this.f2637j = jSONArray;
                put("keyOrderDetail", jSONArray);
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(f2633f, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(f2634g, str2);
            }
            jSONObject.put(f2635h, i6);
            jSONObject.put(f2636i, i7);
            this.f2637j.put(jSONObject);
        } catch (JSONException unused) {
        }
        return this;
    }

    public synchronized dn a(String str, String str2, String str3, int i6, int i7) {
        try {
            if (this.f2637j == null) {
                JSONArray jSONArray = new JSONArray();
                this.f2637j = jSONArray;
                put("keyOrderDetail", jSONArray);
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(f2632e, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(f2633f, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put(f2634g, str3);
            }
            jSONObject.put(f2635h, i6);
            jSONObject.put(f2636i, i7);
            this.f2637j.put(jSONObject);
        } catch (JSONException unused) {
        }
        return this;
    }
}
