package com.tendcloud.tenddata;

import android.os.Environment;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class dd extends da {
    public dd() {
        a("manufacture", k.f());
        a("brand", k.g());
        a("model", k.h());
        a("dummy0", l.a("dummy0"));
        JSONArray jSONArray = new JSONArray();
        for (String str : k.p()) {
            jSONArray.put(str);
        }
        a("cpuInfo", jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        for (int i6 : k.t()) {
            jSONArray2.put(i6);
        }
        a("memoryInfo", jSONArray2);
        JSONArray jSONArray3 = new JSONArray();
        for (int i7 : k.s()) {
            jSONArray3.put(i7);
        }
        a("sdCardInfo", jSONArray3);
        k.a(ab.f2233g, this.f2581b);
        k.b(ab.f2233g, this.f2581b);
        a("totalDiskSpace", Integer.valueOf(a()));
        a("support", k.h(ab.f2233g));
        a("cpu", k.q());
        a("nfcHce", k.b(ab.f2233g));
    }

    public static int a() {
        try {
            int[] u5 = k.u();
            if (u5 != null) {
                return !Environment.isExternalStorageEmulated() ? u5[0] + u5[2] : u5[0];
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void setSlots(int i6) {
        a("slots", Integer.valueOf(i6));
    }
}
