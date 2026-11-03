package com.tendcloud.tenddata;

import android.os.Build;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class dg extends da {
    public dg() {
        a("os", "android");
        a("osVersionName", k.a());
        a("isHarmony", Boolean.valueOf(k.b()));
        a("harmonyOsVersion", k.c());
        a("kernelVersion", k.d());
        a("osVersionCode", String.valueOf(k.l()));
        a("timezone", TimeZone.getDefault().getID());
        a("locale", e());
        a("timezoneV", g());
        a("language", k.n());
        a("romVersion", Build.FINGERPRINT);
        a("basebandVersion", d());
        a("osBuild", k.e());
        a("isAdbEnabled", Boolean.valueOf(k.a(ab.f2233g)));
    }

    public static String d() {
        try {
            if (y.a(14)) {
                return Build.getRadioVersion();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String e() {
        try {
            return Locale.getDefault().toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static float f() {
        try {
            return TimeZone.getDefault().getRawOffset() / 3600000.0f;
        } catch (Throwable unused) {
            return -1.0f;
        }
    }

    private static String g() {
        try {
            return String.valueOf(f());
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a() {
        return ((JSONObject) b()).optString("timezoneV");
    }

    public String c() {
        return ((JSONObject) b()).optString("locale");
    }
}
