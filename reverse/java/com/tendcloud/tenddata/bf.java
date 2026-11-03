package com.tendcloud.tenddata;

import com.tendcloud.tenddata.by;
import com.tendcloud.tenddata.cs;
import com.tendcloud.tenddata.zz;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class bf {

    /* renamed from: a, reason: collision with root package name */
    private static volatile bf f2362a;

    /* renamed from: b, reason: collision with root package name */
    private static String f2363b;

    /* renamed from: c, reason: collision with root package name */
    private static String f2364c;

    /* renamed from: d, reason: collision with root package name */
    private static String f2365d;

    /* renamed from: e, reason: collision with root package name */
    private static String f2366e;

    /* renamed from: f, reason: collision with root package name */
    private static String f2367f;

    /* renamed from: g, reason: collision with root package name */
    private static String f2368g;

    /* renamed from: h, reason: collision with root package name */
    private static String f2369h;

    /* renamed from: i, reason: collision with root package name */
    private static String f2370i;

    /* renamed from: j, reason: collision with root package name */
    private static String f2371j;

    /* renamed from: k, reason: collision with root package name */
    private static String f2372k;

    /* renamed from: l, reason: collision with root package name */
    private static String f2373l;

    /* renamed from: m, reason: collision with root package name */
    private static String f2374m;

    /* renamed from: n, reason: collision with root package name */
    private static String f2375n;

    /* renamed from: o, reason: collision with root package name */
    private static String f2376o;

    /* renamed from: p, reason: collision with root package name */
    private static String f2377p;

    /* renamed from: q, reason: collision with root package name */
    private static String f2378q;

    /* renamed from: r, reason: collision with root package name */
    private static String f2379r;

    /* renamed from: t, reason: collision with root package name */
    private static String f2380t;

    /* renamed from: z, reason: collision with root package name */
    private static JSONObject f2381z;

    /* renamed from: s, reason: collision with root package name */
    private String f2382s;

    /* renamed from: v, reason: collision with root package name */
    private String f2384v;

    /* renamed from: w, reason: collision with root package name */
    private int f2385w;

    /* renamed from: x, reason: collision with root package name */
    private String f2386x;

    /* renamed from: y, reason: collision with root package name */
    private JSONObject f2387y;

    /* renamed from: u, reason: collision with root package name */
    private a f2383u = a.UNKNOWN;
    private Map<String, Object> A = new TreeMap();

    public enum a {
        MALE,
        FEMALE,
        UNKNOWN
    }

    static {
        try {
            z.a().register(a());
        } catch (Throwable unused) {
        }
        f2363b = "account";
        f2364c = "accountId";
        f2365d = "name";
        f2366e = "gender";
        f2367f = "age";
        f2368g = "type";
        f2369h = "accountCus";
        f2370i = "property1";
        f2371j = "property2";
        f2372k = "property3";
        f2373l = "property4";
        f2374m = "property5";
        f2375n = "property6";
        f2376o = "property7";
        f2377p = "property8";
        f2378q = "property9";
        f2379r = "property10";
        f2380t = "default";
    }

    private bf() {
    }

    public static bf a() {
        if (f2362a == null) {
            synchronized (bf.class) {
                if (f2362a == null) {
                    f2362a = new bf();
                }
            }
        }
        return f2362a;
    }

    private void a(com.tendcloud.tenddata.a aVar) {
        try {
            by byVar = new by();
            byVar.f2491b = by.a.IMMEDIATELY;
            byVar.f2490a = aVar;
            z.a().post(byVar);
        } catch (Throwable unused) {
        }
    }

    protected static void a(Object obj, Object obj2, Object obj3, com.tendcloud.tenddata.a aVar) {
        a(obj, obj2, obj3, null, aVar);
    }

    protected static void a(Object obj, Object obj2, Object obj3, Object obj4, com.tendcloud.tenddata.a aVar) {
        if (aVar == null || obj == null || obj2 == null || !(obj instanceof String) || !(obj2 instanceof String)) {
            return;
        }
        bz bzVar = new bz();
        bzVar.f2493b = String.valueOf(obj);
        bzVar.f2494c = String.valueOf(obj2);
        if (obj3 != null && (obj3 instanceof Map)) {
            Map<String, Object> map = (Map) obj3;
            if (obj4 != null) {
                map.put("eventValue", obj4);
            }
            bzVar.f2495d = map;
        }
        bzVar.f2492a = aVar;
        z.a().post(bzVar);
    }

    private void a(String str) {
        try {
            this.f2382s = str;
            String a6 = i.a(str);
            if (a6 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(a6);
                    if (jSONObject.has(f2365d)) {
                        this.f2384v = jSONObject.getString(f2365d);
                    }
                    if (jSONObject.has(f2366e)) {
                        this.f2383u = a.valueOf(jSONObject.getString(f2366e));
                    }
                    if (jSONObject.has(f2367f)) {
                        this.f2385w = jSONObject.getInt(f2367f);
                    }
                    if (jSONObject.has(f2368g)) {
                        this.f2386x = jSONObject.getString(f2368g);
                    }
                    if (jSONObject.has(f2369h)) {
                        this.f2387y = jSONObject.getJSONObject(f2369h);
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public static synchronized void a(String str, com.tendcloud.tenddata.a aVar) {
        synchronized (bf.class) {
            try {
                f2381z = new JSONObject();
                f2380t = str;
                Map<String, Object> g6 = g();
                a(f2363b, "roleCreate", g6, aVar);
                cv.a().setSubprofile(new JSONObject(g6));
            } catch (Throwable unused) {
            }
        }
    }

    private void a(String str, Object obj, Object obj2, Object obj3, Object obj4, com.tendcloud.tenddata.a aVar) {
        a(str, obj, obj2, obj3, obj4, null, aVar);
    }

    private void a(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, com.tendcloud.tenddata.a aVar) {
        try {
            c();
            String str2 = this.f2382s;
            if (str2 != null && !str2.equals(str)) {
                this.A.clear();
            }
            this.f2382s = str;
            TreeMap treeMap = new TreeMap();
            treeMap.put(f2364c, this.f2382s);
            treeMap.putAll((Map) obj);
            if (obj4 != null) {
                treeMap.put("invitationCode", String.valueOf(obj4));
            }
            this.A.putAll(treeMap);
            JSONObject jSONObject = new JSONObject(this.A);
            i.setUniversalProfileInfo(jSONObject.toString());
            cv.a().setProfile(jSONObject);
            a(obj3, obj2, treeMap, obj5, aVar);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private Map<String, Object> b() {
        try {
            String str = this.f2382s;
            if (str != null) {
                this.A.put(f2364c, str);
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
        return this.A;
    }

    private static void b(com.tendcloud.tenddata.a aVar) {
        try {
            Map<String, Object> g6 = g();
            cv.a().setSubprofile(new JSONObject(g6));
            a(f2363b, "roleUpdate", g6, aVar);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private void b(Object obj, Object obj2, Object obj3, com.tendcloud.tenddata.a aVar) {
        try {
            c();
            Map<String, Object> b6 = b();
            b6.putAll((Map) obj);
            JSONObject jSONObject = new JSONObject(b6);
            i.setUniversalProfileInfo(jSONObject.toString());
            cv.a().setProfile(jSONObject);
            a(obj3, obj2, obj, aVar);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private void c() {
        try {
            String m6 = i.m();
            if (m6 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(m6);
                    if (jSONObject.has(f2364c)) {
                        String string = jSONObject.getString(f2364c);
                        this.f2382s = string;
                        this.A.put(f2364c, string);
                    }
                    if (jSONObject.has(f2365d)) {
                        Map<String, Object> map = this.A;
                        String str = f2365d;
                        map.put(str, jSONObject.getString(str));
                    }
                    if (jSONObject.has(f2368g)) {
                        Map<String, Object> map2 = this.A;
                        String str2 = f2368g;
                        map2.put(str2, Integer.valueOf(jSONObject.getInt(str2)));
                    }
                    if (jSONObject.has(f2366e)) {
                        Map<String, Object> map3 = this.A;
                        String str3 = f2366e;
                        map3.put(str3, Integer.valueOf(jSONObject.getInt(str3)));
                    }
                    if (jSONObject.has(f2367f)) {
                        Map<String, Object> map4 = this.A;
                        String str4 = f2367f;
                        map4.put(str4, Integer.valueOf(jSONObject.getInt(str4)));
                    }
                    if (jSONObject.has(f2370i)) {
                        Map<String, Object> map5 = this.A;
                        String str5 = f2370i;
                        map5.put(str5, jSONObject.get(str5));
                    }
                    if (jSONObject.has(f2371j)) {
                        Map<String, Object> map6 = this.A;
                        String str6 = f2371j;
                        map6.put(str6, jSONObject.get(str6));
                    }
                    if (jSONObject.has(f2372k)) {
                        Map<String, Object> map7 = this.A;
                        String str7 = f2372k;
                        map7.put(str7, jSONObject.get(str7));
                    }
                    if (jSONObject.has(f2373l)) {
                        Map<String, Object> map8 = this.A;
                        String str8 = f2373l;
                        map8.put(str8, jSONObject.get(str8));
                    }
                    if (jSONObject.has(f2374m)) {
                        Map<String, Object> map9 = this.A;
                        String str9 = f2374m;
                        map9.put(str9, jSONObject.get(str9));
                    }
                    if (jSONObject.has(f2375n)) {
                        Map<String, Object> map10 = this.A;
                        String str10 = f2375n;
                        map10.put(str10, jSONObject.get(str10));
                    }
                    if (jSONObject.has(f2376o)) {
                        Map<String, Object> map11 = this.A;
                        String str11 = f2376o;
                        map11.put(str11, jSONObject.get(str11));
                    }
                    if (jSONObject.has(f2377p)) {
                        Map<String, Object> map12 = this.A;
                        String str12 = f2377p;
                        map12.put(str12, jSONObject.get(str12));
                    }
                    if (jSONObject.has(f2378q)) {
                        Map<String, Object> map13 = this.A;
                        String str13 = f2378q;
                        map13.put(str13, jSONObject.get(str13));
                    }
                    if (jSONObject.has(f2379r)) {
                        Map<String, Object> map14 = this.A;
                        String str14 = f2379r;
                        map14.put(str14, jSONObject.get(str14));
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private void d() {
        try {
            Map<String, Object> f6 = f();
            zz.a aVar = new zz.a();
            aVar.paraMap.put("apiType", 9);
            aVar.paraMap.put("domain", f2363b);
            aVar.paraMap.put("action", "update");
            aVar.paraMap.put(cs.a.DATA, f6);
            zz.c().obtainMessage(zz.f2799f, aVar).sendToTarget();
            cv.a().setProfile(new JSONObject(f6));
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private static void e() {
        i.setLastRoleName(f2380t);
        i.b(f2380t, f2381z.toString());
    }

    private Map<String, Object> f() {
        TreeMap treeMap = new TreeMap();
        try {
            treeMap.put(f2364c, this.f2382s);
            int i6 = this.f2385w;
            if (i6 != 0) {
                treeMap.put(f2367f, Integer.valueOf(i6));
            }
            if (!"UNKNOWN".equals(this.f2383u.name())) {
                treeMap.put(f2366e, this.f2383u.name());
            }
            String str = this.f2384v;
            if (str != null) {
                treeMap.put(f2365d, str);
            }
            String str2 = this.f2386x;
            if (str2 != null) {
                treeMap.put(f2368g, str2);
            }
            JSONObject jSONObject = this.f2387y;
            if (jSONObject != null && jSONObject.length() > 0) {
                treeMap.put("custom", this.f2387y);
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
        return treeMap;
    }

    private static Map<String, Object> g() {
        TreeMap treeMap = new TreeMap();
        try {
            treeMap.put("name", f2380t);
            JSONObject jSONObject = f2381z;
            if (jSONObject != null && jSONObject.length() > 0) {
                treeMap.put("custom", f2381z);
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
        return treeMap;
    }

    private static void h() {
        try {
            cv.a().setSubprofile(new JSONObject(g()));
            b(null);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public synchronized void a(String str, int i6) {
        if (f2381z == null) {
            f2381z = new JSONObject();
        }
        try {
            f2381z.put(str, i6);
            e();
            h();
        } catch (Throwable unused) {
        }
    }

    public synchronized void a(String str, String str2) {
        if (f2381z == null) {
            f2381z = new JSONObject();
        }
        try {
            f2381z.put(str, str2);
            e();
            h();
        } catch (Throwable unused) {
        }
    }

    public synchronized void b(String str, int i6) {
        if (this.f2387y == null) {
            this.f2387y = new JSONObject();
        }
        try {
            this.f2387y.put(str, i6);
            d();
        } catch (Throwable unused) {
        }
    }

    public synchronized void b(String str, String str2) {
        if (this.f2387y == null) {
            this.f2387y = new JSONObject();
        }
        try {
            this.f2387y.put(str, str2);
            d();
        } catch (Throwable unused) {
        }
    }

    public final void onTDEBEventAccount(zz.a aVar) {
        if (aVar != null) {
            try {
                HashMap<String, Object> hashMap = aVar.paraMap;
                if (hashMap != null && Integer.parseInt(String.valueOf(hashMap.get("apiType"))) == 9) {
                    aVar.paraMap.get("account");
                    com.tendcloud.tenddata.a aVar2 = (com.tendcloud.tenddata.a) aVar.paraMap.get("service");
                    Object obj = aVar.paraMap.get(cs.a.DATA);
                    Object obj2 = aVar.paraMap.get("domain");
                    Object obj3 = aVar.paraMap.get("action");
                    Object obj4 = aVar.paraMap.get("immediate");
                    if (obj3 != null) {
                        if (!obj3.equals("login") && !obj3.equals("register")) {
                            if (obj3.equals("roleCreate")) {
                                a(String.valueOf(aVar.paraMap.get("parameter")), aVar2);
                                return;
                            } else if (obj3.equals("update")) {
                                b(obj, obj3, obj2, aVar2);
                                return;
                            }
                        }
                        a(String.valueOf(aVar.paraMap.get("accountId")), obj, obj3, obj2, aVar.paraMap.get("invitationCode"), aVar.paraMap.get("eventValue"), aVar2);
                        return;
                    }
                    if (obj3 != null) {
                        a(obj2, obj3, obj, aVar2);
                        if (a(obj4)) {
                            a(aVar2);
                        }
                    }
                }
            } catch (Throwable th) {
                bq.postSDKError(th);
            }
        }
    }

    public void setAccountType(String str) {
        try {
            String str2 = this.f2386x;
            if (str2 == null || !str2.equalsIgnoreCase(str)) {
                this.f2386x = str;
                d();
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public void setAge(int i6) {
        try {
            if (this.f2385w != i6) {
                this.f2385w = i6;
                d();
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public void setGender(a aVar) {
        try {
            if (this.f2383u != aVar) {
                this.f2383u = aVar;
                d();
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public void setName(String str) {
        try {
            String str2 = this.f2384v;
            if (str2 == null || !str2.equalsIgnoreCase(str)) {
                this.f2384v = str;
                d();
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }
}
