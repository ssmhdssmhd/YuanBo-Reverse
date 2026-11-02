package com.tendcloud.tenddata;

import com.tendcloud.tenddata.by;
import com.tendcloud.tenddata.cs;
import com.tendcloud.tenddata.zz;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class bl {

    /* renamed from: a, reason: collision with root package name */
    private static volatile bl f2420a;

    static {
        try {
            z.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private bl() {
    }

    public static bl a() {
        if (f2420a == null) {
            synchronized (bl.class) {
                if (f2420a == null) {
                    f2420a = new bl();
                }
            }
        }
        return f2420a;
    }

    public final void onTDEBEventIAP(zz.a aVar) {
        if (aVar != null) {
            try {
                HashMap<String, Object> hashMap = aVar.paraMap;
                if (hashMap != null && Integer.parseInt(String.valueOf(hashMap.get("apiType"))) == 8) {
                    bz bzVar = new bz();
                    Object obj = aVar.paraMap.get(cs.a.DATA);
                    a aVar2 = (a) aVar.paraMap.get("service");
                    bzVar.f2493b = String.valueOf(aVar.paraMap.get("domain"));
                    bzVar.f2494c = String.valueOf(aVar.paraMap.get("action"));
                    if (obj instanceof Map) {
                        bzVar.f2495d = (Map) obj;
                    }
                    bzVar.f2492a = aVar2;
                    z.a().post(bzVar);
                    by byVar = new by();
                    byVar.f2490a = aVar2;
                    byVar.f2491b = by.a.IMMEDIATELY;
                    z.a().post(byVar);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
