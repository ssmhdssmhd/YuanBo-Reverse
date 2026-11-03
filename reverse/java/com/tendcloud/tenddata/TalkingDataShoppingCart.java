package com.tendcloud.tenddata;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TalkingDataShoppingCart extends JSONArray {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2196a = "id";

    /* renamed from: b, reason: collision with root package name */
    private static final String f2197b = "category";

    /* renamed from: c, reason: collision with root package name */
    private static final String f2198c = "name";

    /* renamed from: d, reason: collision with root package name */
    private static final String f2199d = "unitPrice";

    /* renamed from: e, reason: collision with root package name */
    private static final String f2200e = "count";

    private TalkingDataShoppingCart() {
    }

    public static TalkingDataShoppingCart createShoppingCart() {
        return new TalkingDataShoppingCart();
    }

    public synchronized TalkingDataShoppingCart addItem(String str, String str2, String str3, int i6, int i7) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(f2196a, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(f2197b, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put(f2198c, str3);
            }
            jSONObject.put(f2199d, i6);
            jSONObject.put(f2200e, i7);
            put(jSONObject);
        } catch (JSONException e6) {
            e6.printStackTrace();
        }
        return this;
    }
}
