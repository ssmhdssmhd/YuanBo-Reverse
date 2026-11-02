package com.tendcloud.tenddata;

import com.tendcloud.tenddata.cs;
import com.tendcloud.tenddata.zz;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class bm {

    /* renamed from: a, reason: collision with root package name */
    private static volatile bm f2421a;

    static {
        try {
            z.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private bm() {
    }

    public static bm a() {
        if (f2421a == null) {
            synchronized (bm.class) {
                if (f2421a == null) {
                    f2421a = new bm();
                }
            }
        }
        return f2421a;
    }

    public final void onTDEBEventIndustry(zz.a aVar) {
        if (aVar != null) {
            try {
                HashMap<String, Object> hashMap = aVar.paraMap;
                if (hashMap != null && Integer.parseInt(String.valueOf(hashMap.get("apiType"))) == 17) {
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
                }
            } catch (Throwable unused) {
            }
        }
    }
}
