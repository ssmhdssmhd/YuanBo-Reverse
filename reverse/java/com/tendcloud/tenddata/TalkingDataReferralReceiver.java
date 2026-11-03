package com.tendcloud.tenddata;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tendcloud.tenddata.cs;
import com.tendcloud.tenddata.zz;
import java.net.URLDecoder;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class TalkingDataReferralReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        try {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                extras.containsKey(null);
            }
            if (!"com.android.vending.INSTALL_REFERRER".equals(intent.getAction()) || (stringExtra = intent.getStringExtra("referrer")) == null || stringExtra.length() == 0) {
                return;
            }
            Log.d("install_referer", stringExtra);
            String decode = URLDecoder.decode(stringExtra, "UTF-8");
            if (ab.f2233g == null) {
                ab.f2233g = context.getApplicationContext();
            }
            zz.a aVar = new zz.a();
            aVar.paraMap.put("domain", "app");
            aVar.paraMap.put("apiType", 1);
            aVar.paraMap.put("action", "install");
            aVar.paraMap.put("service", a.UNIVERSAL);
            TreeMap treeMap = new TreeMap();
            treeMap.put("referer", decode);
            aVar.paraMap.put(cs.a.DATA, treeMap);
            zz.c().obtainMessage(zz.f2799f, aVar).sendToTarget();
        } catch (Throwable unused) {
        }
    }
}
