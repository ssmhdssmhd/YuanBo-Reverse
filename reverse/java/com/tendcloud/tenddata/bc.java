package com.tendcloud.tenddata;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Base64;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes.dex */
public class bc {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2352a = "56fe6f68-75ba-4649-bc94-5a95c00c2209";

    /* renamed from: b, reason: collision with root package name */
    private static bc f2353b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f2354c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, String> f2355d = null;

    /* renamed from: e, reason: collision with root package name */
    private String f2356e = null;

    private bc() {
    }

    public static bc a() {
        if (f2353b == null) {
            synchronized (bc.class) {
                if (f2353b == null) {
                    f2353b = new bc();
                }
            }
        }
        return f2353b;
    }

    private String a(String str) {
        if (!str.startsWith(">>>")) {
            h.eForInternal("check deferred deeplink failed");
            return null;
        }
        try {
            return new String(u.b(Base64.decode(str.substring(3), 0), f2352a));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String b() {
        ClipData primaryClip;
        ClipData.Item itemAt;
        CharSequence coerceToText;
        try {
            ClipboardManager clipboardManager = (ClipboardManager) this.f2354c.get().getSystemService("clipboard");
            if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null || primaryClip.getItemCount() <= 0 || (itemAt = primaryClip.getItemAt(0)) == null || (coerceToText = itemAt.coerceToText(this.f2354c.get())) == null) {
                return null;
            }
            return coerceToText.toString();
        } catch (Exception e6) {
            h.eForInternal(e6.toString());
            return null;
        }
    }

    public String a(Context context) {
        try {
            this.f2354c = new WeakReference<>(context);
            String b6 = b();
            if (b6 != null) {
                this.f2356e = a(b6);
            }
        } catch (Exception e6) {
            h.eForInternal(e6.toString());
        }
        return this.f2356e;
    }
}
