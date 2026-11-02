package com.tendcloud.tenddata;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* loaded from: classes.dex */
public class cj {
    public static boolean a(Context context) {
        try {
            return cd.l();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void reflectNUBIA(Context context) {
        String string;
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            int i6 = Build.VERSION.SDK_INT;
            ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
            if (acquireContentProviderClient != null) {
                Bundle call = acquireContentProviderClient.call("getOAID", null, null);
                if (i6 >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
                if (call == null || call.getInt("code", -1) != 0 || (string = call.getString("id")) == null) {
                    return;
                }
                dh.a().setOAID(string);
            }
        } catch (Throwable unused) {
        }
    }
}
