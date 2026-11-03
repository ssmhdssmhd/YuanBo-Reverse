package com.tendcloud.tenddata;

import com.tendcloud.tenddata.zz;
import java.util.HashMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class bp {

    /* renamed from: a, reason: collision with root package name */
    private static volatile bp f2442a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, Object> f2443b = new HashMap<>();

    final class a {
        private String pageName;
        private String refer;
        private long startTime;

        private a(long j6, String str, String str2) {
            this.startTime = j6;
            this.refer = str;
            this.pageName = str2;
        }

        private String getPageName() {
            return this.pageName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getRefer() {
            return this.refer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getStartTime() {
            return this.startTime;
        }

        public String toString() {
            return "pageName: " + this.pageName + "\nfrom: " + this.refer + "\nstartTime: " + this.startTime;
        }
    }

    static {
        try {
            z.a().register(a());
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private bp() {
    }

    public static bp a() {
        if (f2442a == null) {
            synchronized (bs.class) {
                if (f2442a == null) {
                    f2442a = new bp();
                }
            }
        }
        return f2442a;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043 A[Catch: all -> 0x009a, TRY_LEAVE, TryCatch #0 {all -> 0x009a, blocks: (B:18:0x0010, B:20:0x0016, B:8:0x002d, B:10:0x0043, B:7:0x0031), top: B:17:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void a(long r9, java.lang.String r11, java.lang.String r12, com.tendcloud.tenddata.a r13) {
        /*
            r8 = this;
            r0 = 1
            com.tendcloud.tenddata.zz.f2796c = r0
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r8.f2443b
            boolean r0 = r0.containsKey(r11)
            if (r0 == 0) goto Lc
            return
        Lc:
            java.lang.String r0 = "onPageBegin being called!  pagename: "
            if (r12 == 0) goto L31
            boolean r1 = r12.isEmpty()     // Catch: java.lang.Throwable -> L9a
            if (r1 != 0) goto L31
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a
            r1.<init>()     // Catch: java.lang.Throwable -> L9a
            r1.append(r0)     // Catch: java.lang.Throwable -> L9a
            r1.append(r11)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r0 = ", refer: "
            r1.append(r0)     // Catch: java.lang.Throwable -> L9a
            r1.append(r12)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L9a
        L2d:
            com.tendcloud.tenddata.h.iForDeveloper(r0)     // Catch: java.lang.Throwable -> L9a
            goto L41
        L31:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9a
            r1.<init>()     // Catch: java.lang.Throwable -> L9a
            r1.append(r0)     // Catch: java.lang.Throwable -> L9a
            r1.append(r11)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L9a
            goto L2d
        L41:
            if (r11 == 0) goto L9e
            com.tendcloud.tenddata.bp$a r0 = new com.tendcloud.tenddata.bp$a     // Catch: java.lang.Throwable -> L9a
            r7 = 0
            r1 = r0
            r2 = r8
            r3 = r9
            r5 = r12
            r6 = r11
            r1.<init>(r3, r5, r6)     // Catch: java.lang.Throwable -> L9a
            java.util.HashMap<java.lang.String, java.lang.Object> r9 = r8.f2443b     // Catch: java.lang.Throwable -> L9a
            r9.put(r11, r0)     // Catch: java.lang.Throwable -> L9a
            com.tendcloud.tenddata.bz r9 = new com.tendcloud.tenddata.bz     // Catch: java.lang.Throwable -> L9a
            r9.<init>()     // Catch: java.lang.Throwable -> L9a
            java.lang.String r10 = "page"
            r9.f2493b = r10     // Catch: java.lang.Throwable -> L9a
            java.lang.String r10 = "enter"
            r9.f2494c = r10     // Catch: java.lang.Throwable -> L9a
            java.util.TreeMap r10 = new java.util.TreeMap     // Catch: java.lang.Throwable -> L9a
            r10.<init>()     // Catch: java.lang.Throwable -> L9a
            java.lang.String r11 = "startTime"
            long r1 = com.tendcloud.tenddata.bp.a.access$100(r0)     // Catch: java.lang.Throwable -> L9a
            java.lang.Long r12 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L9a
            r10.put(r11, r12)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r11 = "duration"
            r12 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L9a
            r10.put(r11, r12)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r11 = "name"
            java.lang.String r12 = com.tendcloud.tenddata.bp.a.access$200(r0)     // Catch: java.lang.Throwable -> L9a
            r10.put(r11, r12)     // Catch: java.lang.Throwable -> L9a
            java.lang.String r11 = "from"
            java.lang.String r12 = com.tendcloud.tenddata.bp.a.access$300(r0)     // Catch: java.lang.Throwable -> L9a
            r10.put(r11, r12)     // Catch: java.lang.Throwable -> L9a
            r9.f2495d = r10     // Catch: java.lang.Throwable -> L9a
            r9.f2492a = r13     // Catch: java.lang.Throwable -> L9a
            com.tendcloud.tenddata.z r10 = com.tendcloud.tenddata.z.a()     // Catch: java.lang.Throwable -> L9a
            r10.post(r9)     // Catch: java.lang.Throwable -> L9a
            goto L9e
        L9a:
            r9 = move-exception
            com.tendcloud.tenddata.bq.postSDKError(r9)
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.bp.a(long, java.lang.String, java.lang.String, com.tendcloud.tenddata.a):void");
    }

    private final void a(String str, com.tendcloud.tenddata.a aVar) {
        if (this.f2443b.containsKey(str)) {
            try {
                h.iForDeveloper("onPageEnd being called! pageName: " + str);
                a aVar2 = (a) this.f2443b.remove(str);
                if (aVar2 != null) {
                    bz bzVar = new bz();
                    bzVar.f2493b = "page";
                    bzVar.f2494c = "leave";
                    long round = Math.round((System.currentTimeMillis() - aVar2.getStartTime()) / 1000.0d);
                    TreeMap treeMap = new TreeMap();
                    treeMap.put("startTime", Long.valueOf(aVar2.getStartTime()));
                    treeMap.put("name", str);
                    treeMap.put("from", aVar2.getRefer());
                    treeMap.put("duration", Long.valueOf(round));
                    bzVar.f2495d = treeMap;
                    bzVar.f2492a = aVar;
                    z.a().post(bzVar);
                }
                if (ab.I) {
                    i.setLastActivity(str);
                }
                ab.J = str;
            } catch (Throwable th) {
                bq.postSDKError(th);
            }
        }
    }

    private void a(HashMap<String, Object> hashMap) {
        try {
            int parseInt = Integer.parseInt(String.valueOf(hashMap.get("apiType")));
            com.tendcloud.tenddata.a aVar = (com.tendcloud.tenddata.a) hashMap.get("service");
            if (parseInt != 4) {
                if (parseInt != 5) {
                    return;
                }
                a(String.valueOf(hashMap.get("pageName")), aVar);
            } else {
                String str = ab.J;
                if (str == null) {
                    str = i.d();
                }
                a(Long.parseLong(String.valueOf(hashMap.get("occurTime"))), String.valueOf(hashMap.get("pageName")), str, aVar);
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public final void onTDEBEventPage(zz.a aVar) {
        if (aVar != null) {
            try {
                HashMap<String, Object> hashMap = aVar.paraMap;
                if (hashMap == null) {
                    return;
                }
                int parseInt = Integer.parseInt(String.valueOf(hashMap.get("apiType")));
                if ((parseInt == 4 || parseInt == 5) && !String.valueOf(aVar.paraMap.get("occurTime")).trim().isEmpty()) {
                    a(aVar.paraMap);
                }
            } catch (Throwable th) {
                bq.postSDKError(th);
            }
        }
    }
}
