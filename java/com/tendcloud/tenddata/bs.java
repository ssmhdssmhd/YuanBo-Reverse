package com.tendcloud.tenddata;

import com.tendcloud.tenddata.by;
import com.tendcloud.tenddata.zz;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.UUID;

/* loaded from: classes.dex */
public class bs {

    /* renamed from: a, reason: collision with root package name */
    private static volatile bs f2451a;

    static {
        try {
            z.a().register(a());
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private bs() {
    }

    public static bs a() {
        if (f2451a == null) {
            synchronized (bs.class) {
                if (f2451a == null) {
                    f2451a = new bs();
                }
            }
        }
        return f2451a;
    }

    private void a(long j6, final a aVar) {
        try {
            h.iForDeveloper("[" + aVar.name() + "][Session] - New session!");
            String uuid = UUID.randomUUID().toString();
            h.iForDeveloper("[" + aVar.name() + "][Session] - Id: " + uuid);
            long f6 = i.f(aVar);
            long j7 = j6 - f6;
            if (0 == f6) {
                j7 = 0;
            }
            i.a(uuid, aVar);
            i.a(j6, aVar);
            i.b(uuid, aVar);
            cv.a().setSessionId(uuid);
            cv.a().setSessionStartTime(j6);
            bz bzVar = new bz();
            bzVar.f2493b = "session";
            bzVar.f2494c = "begin";
            TreeMap treeMap = new TreeMap();
            treeMap.put("sessionId", uuid);
            treeMap.put("interval", Long.valueOf(j7 / 1000));
            bzVar.f2495d = treeMap;
            bzVar.f2492a = aVar;
            bzVar.f2497f = new cu() { // from class: com.tendcloud.tenddata.bs.2
                @Override // com.tendcloud.tenddata.cu
                public void onStoreFailed() {
                }

                @Override // com.tendcloud.tenddata.cu
                public void onStoreSuccess() {
                    try {
                        bs.this.b(aVar);
                    } catch (Throwable unused) {
                    }
                }
            };
            z.a().post(bzVar);
            ab.Z.set(false);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private void a(final a aVar) {
        try {
            String a6 = i.a(aVar);
            if (a6 == null || a6.trim().isEmpty()) {
                return;
            }
            long c6 = i.c(aVar);
            long f6 = i.f(aVar) - c6;
            if ((aVar.name().equals("APP") || aVar.name().equals("APP_SQL") || aVar.name().equals("TRACKING") || aVar.name().equals("SDK")) && f6 < 500) {
                f6 = -1000;
            }
            bz bzVar = new bz();
            bzVar.f2493b = "session";
            bzVar.f2494c = "end";
            TreeMap treeMap = new TreeMap();
            treeMap.put("sessionId", a6);
            treeMap.put("start", Long.valueOf(c6));
            treeMap.put("duration", Long.valueOf(f6 / 1000));
            bzVar.f2495d = treeMap;
            bzVar.f2492a = aVar;
            bzVar.f2497f = new cu() { // from class: com.tendcloud.tenddata.bs.1
                @Override // com.tendcloud.tenddata.cu
                public void onStoreFailed() {
                }

                @Override // com.tendcloud.tenddata.cu
                public void onStoreSuccess() {
                    try {
                        bs.this.b(aVar);
                    } catch (Throwable unused) {
                    }
                }
            };
            z.a().post(bzVar);
            i.a((String) null, aVar);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private final void a(HashMap<String, Object> hashMap) {
        try {
            a aVar = (a) hashMap.get("service");
            long parseLong = Long.parseLong(String.valueOf(hashMap.get("occurTime")));
            long c6 = i.c(aVar);
            long f6 = i.f(aVar);
            if (f6 <= c6) {
                f6 = c6;
            }
            if (parseLong - f6 > ab.aa) {
                a(aVar);
                a(parseLong, aVar);
            } else {
                String a6 = i.a(aVar);
                if (a6 != null) {
                    h.iForDeveloper("[" + aVar.name() + "][Session] - Same session as before! Session id is " + a6);
                    cv.a().setSessionId(a6);
                    cv.a().setSessionStartTime(c6);
                    return;
                }
                a(parseLong, aVar);
            }
            i.setLastActivity("");
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        by byVar = new by();
        byVar.f2490a = aVar;
        byVar.f2491b = by.a.IMMEDIATELY;
        z.a().post(byVar);
    }

    private final void b(HashMap<String, Object> hashMap) {
        try {
            a aVar = (a) hashMap.get("service");
            long parseLong = Long.parseLong(String.valueOf(hashMap.get("occurTime")));
            if (hashMap.containsKey("sessionEnd")) {
                a(aVar);
                return;
            }
            if (hashMap.containsKey("pageName")) {
                i.setLastActivity(String.valueOf(hashMap.get("pageName")));
            }
            b(aVar);
            i.c(parseLong, aVar);
            ab.J = null;
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public final void onTDEBEventSession(zz.a aVar) {
        HashMap<String, Object> hashMap;
        if (aVar == null || (hashMap = aVar.paraMap) == null) {
            return;
        }
        try {
            int parseInt = Integer.parseInt(String.valueOf(hashMap.get("apiType")));
            if (parseInt == 10) {
                a(aVar.paraMap);
            } else if (parseInt == 11) {
                b(aVar.paraMap);
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }
}
