package com.tendcloud.tenddata;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ap {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f2295a = new HashMap();

    public ap a(String str, String str2) {
        this.f2295a.put(str, str2);
        return this;
    }

    void a(HttpURLConnection httpURLConnection) {
        try {
            if (y.a(14) && y.b(19)) {
                this.f2295a.put("Connection", "close");
            }
            for (String str : this.f2295a.keySet()) {
                httpURLConnection.setRequestProperty(str, this.f2295a.get(str));
            }
        } catch (Throwable unused) {
        }
    }

    public String toString() {
        return this.f2295a.toString();
    }
}
