package com.tendcloud.tenddata;

import android.util.EventLogTags;
import android.util.Pair;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class dm {

    /* renamed from: c, reason: collision with root package name */
    private static cy f2621c;

    /* renamed from: d, reason: collision with root package name */
    private static db f2622d;

    /* renamed from: e, reason: collision with root package name */
    private static df f2623e = new df();

    /* renamed from: f, reason: collision with root package name */
    private static dc f2624f = null;

    /* renamed from: g, reason: collision with root package name */
    private static volatile dm f2625g = null;

    /* renamed from: a, reason: collision with root package name */
    public JSONObject f2626a = null;

    /* renamed from: b, reason: collision with root package name */
    public JSONObject f2627b = null;

    public static dm b() {
        if (f2625g == null) {
            synchronized (dm.class) {
                if (f2625g == null) {
                    f2625g = new dm();
                }
            }
        }
        return f2625g;
    }

    public synchronized JSONObject a(cx cxVar, boolean z5) {
        return a(cxVar, z5, null);
    }

    public synchronized JSONObject a(cx cxVar, boolean z5, a aVar) {
        return a(cxVar, z5, aVar, null);
    }

    public synchronized JSONObject a(cx cxVar, boolean z5, a aVar, Pair<String, JSONArray> pair) {
        JSONObject jSONObject;
        String b6;
        if (cxVar != null) {
            if (cxVar.b() != null) {
                synchronized (EventLogTags.class) {
                    jSONObject = new JSONObject();
                    try {
                        n.getFileLock(bi.a().b());
                        this.f2626a = new JSONObject();
                        this.f2627b = new JSONObject();
                        try {
                            if (f2621c == null) {
                                f2621c = cy.a();
                                f2621c.setUniqueId(dl.a(ab.f2233g, ab.f2233g.getPackageName()));
                            }
                            f2621c.setSubmitAppId(aVar);
                            f2621c.setSubmitChannelId(aVar);
                            if (f2623e == null) {
                                f2623e = new df();
                            }
                            df.f2597a.a();
                            f2623e.c().setSlots(o.B(ab.f2233g));
                            if (f2622d == null) {
                                f2622d = new db();
                            }
                            if (f2624f == null) {
                                dc dcVar = new dc();
                                f2624f = dcVar;
                                dcVar.a();
                            }
                        } catch (Throwable unused) {
                        }
                        f2624f.c();
                        try {
                            jSONObject.put("version", "2.0");
                            jSONObject.put("action", cxVar.b());
                            jSONObject.put("device", f2623e.b());
                            jSONObject.put("app", f2621c.b());
                            jSONObject.put("sdk", f2622d.b());
                            jSONObject.put("appContext", cv.a().b());
                            jSONObject.put("user", f2624f.b());
                            jSONObject.put("sharingFilterPermission", ab.f2248v.ordinal());
                            long currentTimeMillis = System.currentTimeMillis();
                            jSONObject.put("ts", currentTimeMillis);
                            jSONObject.put("fingerprint", y.c(currentTimeMillis + dl.a(ab.f2233g) + f2623e.a().a() + f2623e.a().c()));
                            if (z5) {
                                JSONArray jSONArray = new JSONArray();
                                jSONArray.put(new dj(dk.WIFI).b());
                                jSONArray.put(new dj(dk.CELLULAR).b());
                                try {
                                    if (y.b(ab.f2233g, "android.permission.BLUETOOTH")) {
                                        jSONArray.put(new dj(dk.BLUETOOTH).b());
                                    }
                                } catch (Throwable unused2) {
                                }
                                jSONObject.put("networks", jSONArray);
                                JSONArray a6 = bi.a().a("Location");
                                if (a6 != null) {
                                    jSONObject.put("locations", new cz().b());
                                    if (a6.length() > 0) {
                                        a("Location", a6);
                                    }
                                }
                            }
                            if (pair != null && ((JSONArray) pair.second).length() > 0) {
                                a((String) pair.first, (JSONArray) pair.second);
                            }
                            if (!ab.f2243q) {
                                jSONObject.put("cloudcontrol", this.f2626a);
                            }
                            bi.a().c();
                        } catch (Throwable th) {
                            bq.postSDKError(th);
                        }
                        b6 = bi.a().b();
                    } catch (Throwable unused3) {
                        b6 = bi.a().b();
                    }
                    n.releaseFileLock(b6);
                }
                return jSONObject;
            }
        }
        return null;
    }

    public void a() {
        dc dcVar = f2624f;
        if (dcVar != null) {
            dcVar.d();
        }
    }

    public void a(String str, JSONArray jSONArray) {
        try {
            if (ab.f2243q || this.f2626a == null || jSONArray.length() <= 0) {
                return;
            }
            this.f2626a.put(str, jSONArray);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }
}
