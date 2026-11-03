package com.tendcloud.tenddata;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class bv extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name */
    ArrayList<ScanResult> f2465b;

    /* renamed from: c, reason: collision with root package name */
    JSONArray f2466c;

    /* renamed from: d, reason: collision with root package name */
    ba f2467d;

    /* renamed from: e, reason: collision with root package name */
    ba f2468e;

    /* renamed from: i, reason: collision with root package name */
    private WifiManager f2472i;

    /* renamed from: a, reason: collision with root package name */
    bb f2464a = new bb();

    /* renamed from: f, reason: collision with root package name */
    long f2469f = 0;

    /* renamed from: g, reason: collision with root package name */
    long f2470g = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f2471h = 180000;

    public bv(WifiManager wifiManager) {
        this.f2472i = wifiManager;
    }

    private ba a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i6);
                arrayList.add(new ax(jSONObject.getString("SSID"), jSONObject.getString("BSSID"), (byte) jSONObject.getInt("level"), (byte) 0, (byte) 0));
            } catch (Throwable th) {
                bq.postSDKError(th);
            }
        }
        ba baVar = new ba();
        baVar.setBsslist(arrayList);
        return baVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            bz bzVar = new bz();
            bzVar.f2493b = "env";
            bzVar.f2494c = "wifiUpdate";
            bzVar.f2492a = a.ENV;
            z.a().post(bzVar);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ba b() {
        try {
            this.f2467d = a(this.f2466c);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
        return this.f2467d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ba c() {
        try {
            ArrayList<ScanResult> arrayList = (ArrayList) this.f2472i.getScanResults();
            this.f2465b = arrayList;
            if (arrayList != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (int i6 = 0; i6 < this.f2465b.size(); i6++) {
                        if (this.f2465b.get(i6).level >= -75) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("SSID", this.f2465b.get(i6).SSID);
                            jSONObject.put("BSSID", this.f2465b.get(i6).BSSID);
                            jSONObject.put("level", this.f2465b.get(i6).level);
                            jSONArray.put(jSONObject);
                        }
                    }
                    this.f2466c = jSONArray;
                    this.f2468e = a(jSONArray);
                } catch (Throwable th) {
                    bq.postSDKError(th);
                }
            }
        } catch (Throwable th2) {
            bq.postSDKError(th2);
        }
        return this.f2468e;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        bo.f2430a.post(new Runnable() { // from class: com.tendcloud.tenddata.bv.1
            @Override // java.lang.Runnable
            public void run() {
                ba baVar;
                try {
                    bv.this.f2469f = System.currentTimeMillis();
                    bv bvVar = bv.this;
                    if (bvVar.f2469f - bvVar.f2470g > bvVar.f2471h) {
                        bv bvVar2 = bv.this;
                        bvVar2.f2470g = bvVar2.f2469f;
                        bvVar2.f2467d = bvVar2.b();
                        bv bvVar3 = bv.this;
                        if (bvVar3.f2467d == null) {
                            bvVar3.a();
                            bv bvVar4 = bv.this;
                            bvVar4.f2467d = bvVar4.c();
                        }
                        bv bvVar5 = bv.this;
                        bvVar5.f2468e = bvVar5.c();
                        bv bvVar6 = bv.this;
                        ba baVar2 = bvVar6.f2467d;
                        if (baVar2 == null || (baVar = bvVar6.f2468e) == null || bvVar6.f2464a.a(baVar2, baVar) >= 0.8d) {
                            return;
                        }
                        bv.this.a();
                    }
                } catch (Throwable th) {
                    bq.postSDKError(th);
                }
            }
        });
    }
}
