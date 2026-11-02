package com.tendcloud.tenddata;

import android.content.Context;

/* loaded from: classes.dex */
public final class co {
    public static boolean a() {
        try {
            if (!cd.a()) {
                return false;
            }
            Class.forName("com.android.id.impl.IdProviderImpl");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void reflectMiUi(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            Object newInstance = cls.newInstance();
            try {
                dh.a().setUDID((String) cls.getMethod("getUDID", Context.class).invoke(newInstance, context));
            } catch (Throwable unused) {
            }
            try {
                dh.a().setOAID((String) cls.getMethod("getOAID", Context.class).invoke(newInstance, context));
            } catch (Throwable unused2) {
            }
            try {
                dh.a().setVAID((String) cls.getMethod("getVAID", Context.class).invoke(newInstance, context));
            } catch (Throwable unused3) {
            }
            dh.a().setAAID((String) cls.getMethod("getAAID", Context.class).invoke(newInstance, context));
        } catch (Throwable unused4) {
        }
    }
}
