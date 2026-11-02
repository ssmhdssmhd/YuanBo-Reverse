package com.tendcloud.tenddata;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class cv extends da {

    /* renamed from: a, reason: collision with root package name */
    static cv f2564a;

    private cv() {
    }

    public static synchronized cv a() {
        cv cvVar;
        synchronized (cv.class) {
            if (f2564a == null) {
                f2564a = new cv();
            }
            cvVar = f2564a;
        }
        return cvVar;
    }

    @Override // com.tendcloud.tenddata.da
    public Object b() {
        String m6;
        try {
            if (!f2564a.f2581b.has("account") && (m6 = i.m()) != null) {
                f2564a.a("account", (Object) new JSONObject(m6));
            }
        } catch (Throwable unused) {
        }
        return super.b();
    }

    public void setCurrentPageName(String str) {
        a("page", str);
    }

    public void setDeepLink(String str) {
        try {
            a("deeplink", str);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public void setProfile(JSONObject jSONObject) {
        a("account", (Object) jSONObject);
    }

    public void setSessionId(String str) {
        a("sessionId", str);
    }

    public void setSessionStartTime(long j6) {
        a("sessionStartTime", Long.valueOf(j6));
    }

    public void setSubprofile(JSONObject jSONObject) {
        a("subaccount", (Object) jSONObject);
    }
}
