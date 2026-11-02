package com.tendcloud.tenddata;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class db extends da {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2582a = "TalkingData";

    /* renamed from: c, reason: collision with root package name */
    public static final String f2583c = "SaaS";

    /* renamed from: d, reason: collision with root package name */
    public static final int f2584d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static final int f2585e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final int f2586f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static final int f2587g = 3;

    /* renamed from: h, reason: collision with root package name */
    public static final int f2588h = 4;

    /* renamed from: i, reason: collision with root package name */
    public static final int f2589i = 5;

    /* renamed from: j, reason: collision with root package name */
    public static final int f2590j = 6;

    /* renamed from: k, reason: collision with root package name */
    public static final int f2591k = 7;

    /* renamed from: l, reason: collision with root package name */
    public static final int f2592l = 8;

    /* renamed from: n, reason: collision with root package name */
    private static String f2593n = "";

    /* renamed from: o, reason: collision with root package name */
    private static int f2594o = 4;

    /* renamed from: m, reason: collision with root package name */
    private final String f2595m = "Android";

    public db() {
        a("version", (Object) 5);
        a("minorVersion", (Object) 0);
        a("build", (Object) 13);
        if (!y.b(ab.f2249w)) {
            try {
                a("jobNum", Integer.valueOf(Integer.parseInt(ab.f2249w)));
            } catch (Throwable unused) {
            }
        }
        a("partner", f2583c);
        a("platform", "Android");
        a("type", f2582a);
        a("framework", f2593n);
        int i6 = f2594o;
        if (i6 > 0) {
            a("from", Integer.valueOf(i6));
        }
    }

    public String a() {
        return f2593n;
    }

    public void a(String str, String str2, String str3) {
        JSONArray jSONArray;
        if (this.f2581b.isNull("features")) {
            jSONArray = new JSONArray();
        } else {
            try {
                jSONArray = this.f2581b.getJSONArray("features");
            } catch (JSONException e6) {
                e6.printStackTrace();
                jSONArray = null;
            }
        }
        if (jSONArray != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", str);
                jSONObject.put("version", str2);
                jSONObject.put("minorVersion", str3);
                jSONArray.put(jSONObject);
            } catch (JSONException e7) {
                e7.printStackTrace();
                bq.postSDKError(e7);
            }
            a("features", jSONArray);
        }
    }

    public void setFrameWork(String str) {
        f2593n = str;
    }
}
