package com.tendcloud.tenddata;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TalkingDataOrder extends JSONObject {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2171a = "id";

    /* renamed from: b, reason: collision with root package name */
    private static final String f2172b = "category";

    /* renamed from: c, reason: collision with root package name */
    private static final String f2173c = "name";

    /* renamed from: d, reason: collision with root package name */
    private static final String f2174d = "unitPrice";

    /* renamed from: e, reason: collision with root package name */
    private static final String f2175e = "count";
    public static final String keyCurrencyType = "keyCurrencyType";
    public static final String keyOrderDetail = "keyOrderDetail";
    public static final String keyOrderId = "keyOrderId";
    public static final String keyTotalPrice = "keyTotalPrice";

    /* renamed from: f, reason: collision with root package name */
    private JSONArray f2176f = null;

    private TalkingDataOrder() {
    }

    private TalkingDataOrder(String str, int i6, String str2) {
        try {
            put("keyOrderId", str);
            put("keyTotalPrice", i6);
            put("keyCurrencyType", str2);
        } catch (JSONException unused) {
        }
    }

    public static TalkingDataOrder createOrder(String str, int i6, String str2) {
        try {
            h.iForDeveloper("createOrder called --> orderId: " + str + " ,totalPrice: " + i6 + " ,currencyType: " + str2);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str)) {
            h.eForDeveloper("createOrder: orderId could not be null or empty");
            return null;
        }
        if (TextUtils.isEmpty(str2) || str2.trim().length() != 3) {
            h.eForDeveloper("createOrder: currencyType length must be 3 ,likes CNY");
            return null;
        }
        return new TalkingDataOrder(str, i6, str2);
    }

    public synchronized TalkingDataOrder addItem(String str, String str2, int i6, int i7) {
        try {
            if (this.f2176f == null) {
                JSONArray jSONArray = new JSONArray();
                this.f2176f = jSONArray;
                put("keyOrderDetail", jSONArray);
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(f2172b, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(f2173c, str2);
            }
            jSONObject.put(f2174d, i6);
            jSONObject.put(f2175e, i7);
            this.f2176f.put(jSONObject);
        } catch (JSONException unused) {
        }
        return this;
    }

    public synchronized TalkingDataOrder addItem(String str, String str2, String str3, int i6, int i7) {
        try {
            if (this.f2176f == null) {
                JSONArray jSONArray = new JSONArray();
                this.f2176f = jSONArray;
                put("keyOrderDetail", jSONArray);
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(f2171a, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(f2172b, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put(f2173c, str3);
            }
            jSONObject.put(f2174d, i6);
            jSONObject.put(f2175e, i7);
            this.f2176f.put(jSONObject);
        } catch (JSONException unused) {
        }
        return this;
    }
}
