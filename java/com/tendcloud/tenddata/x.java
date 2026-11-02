package com.tendcloud.tenddata;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private static Location f2768a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f2769b = false;

    public static List<Location> a(Context context) {
        ArrayList arrayList = new ArrayList();
        if (ab.Q) {
            return arrayList;
        }
        try {
            arrayList.add(f(context));
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static String b(Context context) {
        try {
            List<Location> a6 = a(context);
            StringBuilder sb = new StringBuilder();
            for (Location location : a6) {
                if (location != null) {
                    sb.append(location.getLatitude());
                    sb.append(',');
                    sb.append(location.getLongitude());
                    sb.append(',');
                    sb.append(location.hasAltitude() ? Double.valueOf(location.getAltitude()) : "");
                    sb.append(',');
                    sb.append(location.getTime());
                    sb.append(',');
                    sb.append(location.hasAccuracy() ? Float.valueOf(location.getAccuracy()) : "");
                    sb.append(',');
                    sb.append(location.hasBearing() ? Float.valueOf(location.getBearing()) : "");
                    sb.append(',');
                    sb.append(location.hasSpeed() ? Float.valueOf(location.getSpeed()) : "");
                    sb.append(',');
                    sb.append(location.getProvider());
                    sb.append(':');
                }
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONArray c(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (ab.Q) {
            return jSONArray;
        }
        try {
            Location f6 = f(context);
            if (f6 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lat", f6.getLatitude());
                jSONObject.put("lng", f6.getLongitude());
                jSONObject.put("ts", f6.getTime());
                if (y.a(17)) {
                    jSONObject.put("elapsed", f6.getElapsedRealtimeNanos());
                }
                if (f6.hasAltitude()) {
                    jSONObject.put("altitude", f6.getAltitude());
                }
                if (f6.hasAccuracy()) {
                    jSONObject.put("hAccuracy", f6.getAccuracy());
                }
                if (f6.hasBearing()) {
                    jSONObject.put("bearing", f6.getBearing());
                }
                if (f6.hasSpeed()) {
                    jSONObject.put("speed", f6.getSpeed());
                }
                jSONObject.put("provider", f6.getProvider());
                jSONArray.put(jSONObject);
            }
        } catch (Throwable unused) {
        }
        return jSONArray;
    }

    public static JSONArray d(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray A = o.A(context);
            if (A.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "sim");
                jSONObject.put("extra", A);
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "account");
            String str = ab.f2245s;
            if (str != null) {
                jSONObject2.put("accountId", str);
            }
            String l6 = i.l();
            if (!y.b(l6)) {
                h.dForInternal(l6);
                JSONObject jSONObject3 = new JSONObject(l6);
                if (jSONObject3.length() > 0) {
                    jSONObject2.put("accountProp", jSONObject3);
                }
            }
            if (jSONObject2.length() > 1) {
                jSONArray.put(jSONObject2);
            }
            if (jSONArray.length() > 0) {
                return jSONArray;
            }
            return null;
        } catch (Throwable th) {
            bq.postSDKError(th);
            return null;
        }
    }

    public static Long[][] e(Context context) {
        return new Long[3][];
    }

    private static Location f(Context context) {
        boolean z5;
        boolean z6;
        if (f2769b) {
            return f2768a;
        }
        Location location = null;
        if (!y.b(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            f2769b = true;
            return null;
        }
        try {
            LocationManager locationManager = (LocationManager) ab.f2233g.getSystemService("location");
            if (locationManager != null) {
                z5 = locationManager.isProviderEnabled("gps");
                z6 = locationManager.isProviderEnabled("network");
            } else {
                z5 = false;
                z6 = false;
            }
            if (z5 || z6) {
                location = locationManager.getLastKnownLocation("passive");
            }
        } catch (Throwable unused) {
        }
        f2768a = location;
        f2769b = true;
        return location;
    }
}
