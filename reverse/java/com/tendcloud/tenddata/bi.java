package com.tendcloud.tenddata;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tendcloud.tenddata.an;
import com.tendcloud.tenddata.by;
import com.tendcloud.tenddata.n;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class bi {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2392a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final int f2393b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f2394c = 3;

    /* renamed from: i, reason: collision with root package name */
    private static String f2395i = null;

    /* renamed from: j, reason: collision with root package name */
    private static String f2396j = "TDpref_cloudcontrol";

    /* renamed from: k, reason: collision with root package name */
    private static final String f2397k = "TDpref_config";

    /* renamed from: l, reason: collision with root package name */
    private static final String f2398l = "TDpref_last_request_time";

    /* renamed from: m, reason: collision with root package name */
    private static final String f2399m = "TDpref_cloud_cv";

    /* renamed from: o, reason: collision with root package name */
    private static boolean f2401o;

    /* renamed from: s, reason: collision with root package name */
    private static String f2405s;

    /* renamed from: t, reason: collision with root package name */
    private static String f2406t;

    /* renamed from: u, reason: collision with root package name */
    private static String f2407u;

    /* renamed from: v, reason: collision with root package name */
    private static String f2408v;

    /* renamed from: d, reason: collision with root package name */
    private long f2411d = 720;

    /* renamed from: e, reason: collision with root package name */
    private long f2412e = 604800000;

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, JSONObject> f2413f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private HashSet<String> f2414g = new HashSet<>();

    /* renamed from: h, reason: collision with root package name */
    private JSONObject f2415h = new JSONObject();

    /* renamed from: x, reason: collision with root package name */
    private int f2416x;

    /* renamed from: y, reason: collision with root package name */
    private Handler f2417y;

    /* renamed from: n, reason: collision with root package name */
    private static String[] f2400n = {"232", "206", "284", "280", "219", "230", "238", "248", "244", "208", "308", "340", "543", "546", "547", "647", "742", "262", "202", "216", "272", "222", "247", "246", "270", "278", "204", "363", "362", "260", "268", "226", "231", "293", "214", "240", "234", "235", "266", "346", "348", "350", "354", "376", "750", "454", "455", "466", "525", "310", "311", "312", "313", "314", "315", "316", "330", "332", "534", "535", "544", "302", "505", "530", "548"};

    /* renamed from: p, reason: collision with root package name */
    private static boolean f2402p = true;

    /* renamed from: q, reason: collision with root package name */
    private static boolean f2403q = false;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f2404r = true;

    /* renamed from: w, reason: collision with root package name */
    private static boolean f2409w = false;

    /* renamed from: z, reason: collision with root package name */
    private static boolean f2410z = true;
    private static volatile bi A = null;

    private bi() {
        this.f2417y = null;
        HandlerThread handlerThread = new HandlerThread("ModuleCloudControl", 10);
        handlerThread.start();
        this.f2417y = new Handler(handlerThread.getLooper()) { // from class: com.tendcloud.tenddata.bi.1
            String appId;
            String channelId;
            a features;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                bi biVar;
                String str;
                String str2;
                a aVar;
                try {
                    Object obj = message.obj;
                    if (obj != null) {
                        HashMap hashMap = (HashMap) obj;
                        this.appId = String.valueOf(hashMap.get("appId"));
                        this.channelId = String.valueOf(hashMap.get("channelId"));
                        this.features = (a) hashMap.get("Features");
                    }
                    int i6 = message.what;
                    if (i6 == 0) {
                        biVar = bi.this;
                        str = this.appId;
                        str2 = this.channelId;
                        aVar = this.features;
                    } else {
                        if (i6 != 1) {
                            if (i6 != 3) {
                                return;
                            }
                            bz bzVar = new bz();
                            bzVar.f2493b = "app";
                            bzVar.f2494c = "initaddition";
                            bzVar.f2492a = this.features;
                            z.a().post(bzVar);
                            by byVar = new by();
                            byVar.f2490a = this.features;
                            byVar.f2491b = by.a.IMMEDIATELY;
                            z.a().post(byVar);
                            return;
                        }
                        boolean unused = bi.f2410z = false;
                        biVar = bi.this;
                        str = this.appId;
                        str2 = this.channelId;
                        aVar = this.features;
                    }
                    biVar.b(str, str2, aVar);
                } catch (Throwable th) {
                    bq.postSDKError(th);
                }
            }
        };
    }

    private int a(a aVar) {
        int index = aVar.index();
        if (index == 0) {
            return 1;
        }
        if (index == 1) {
            return 2;
        }
        if (index != 3) {
            return index != 99 ? -1 : 4;
        }
        return 3;
    }

    public static bi a() {
        if (A == null) {
            synchronized (bi.class) {
                if (A == null) {
                    A = new bi();
                }
            }
        }
        return A;
    }

    private String a(RandomAccessFile randomAccessFile) {
        try {
            byte[] bArr = new byte[(int) randomAccessFile.length()];
            randomAccessFile.seek(0L);
            randomAccessFile.read(bArr);
            return new String(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    private JSONObject a(JSONObject jSONObject) {
        try {
            String b6 = s.b(ab.f2233g, f2396j, f2397k, "");
            if (y.b(b6)) {
                s.a(ab.f2233g, f2396j, f2397k, jSONObject.toString());
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(b6);
            if (jSONObject.has("cv") && jSONObject2.getInt("cv") == jSONObject.getInt("cv")) {
                if (jSONObject.has("r")) {
                    jSONObject2.put("r", jSONObject.getJSONArray("r"));
                }
                s.a(ab.f2233g, f2396j, f2397k, jSONObject2.toString());
                return jSONObject2;
            }
            s.a(ab.f2233g, f2396j, f2397k, jSONObject.toString());
            if (!jSONObject.has("cv")) {
                return jSONObject;
            }
            s.a(ab.f2233g, f2396j, f2399m, jSONObject.getLong("cv"));
            return jSONObject;
        } catch (Throwable th) {
            bq.postSDKError(th);
            return null;
        }
    }

    private void a(RandomAccessFile randomAccessFile, String str) {
        try {
            randomAccessFile.setLength(0L);
            randomAccessFile.seek(0L);
            randomAccessFile.write(str.getBytes());
        } catch (Throwable unused) {
        }
    }

    private void a(JSONObject jSONObject, String str) {
        try {
            JSONArray jSONArray = (JSONArray) jSONObject.remove("clt");
            jSONObject.remove("id");
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                String string = jSONArray.getString(i6);
                if (!y.b(string)) {
                    if (this.f2413f.containsKey(string)) {
                        this.f2413f.get(string).put(str, jSONObject);
                    } else {
                        this.f2413f.put(string, new JSONObject().put(str, jSONObject));
                    }
                }
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private void a(JSONObject jSONObject, String str, Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if ((obj instanceof String) && ((String) obj).length() == 0) {
                return;
            }
            jSONObject.put(str, obj);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, a aVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            a(jSONObject, "bl", Integer.valueOf(this.f2416x));
            a(jSONObject, "pl", (Object) 1);
            a(jSONObject, "sv", "5.0.13");
            a(jSONObject, "smcc", f2405s);
            a(jSONObject, "smnc", f2406t);
            a(jSONObject, "bmcc", f2407u);
            a(jSONObject, "bmnc", f2408v);
            a(jSONObject, "dt", "Mobile");
            a(jSONObject, "ov", k.a());
            a(jSONObject, "av", i.k());
            a(jSONObject, "px", k.e(ab.f2233g));
            a(jSONObject, "nt", o.l(ab.f2233g));
            a(jSONObject, "op", o.s(ab.f2233g));
            a(jSONObject, "ch", str2);
            a(jSONObject, "cv", Long.valueOf(s.b(ab.f2233g, f2396j, f2399m, 0L)));
            a(jSONObject, "TDID", j.a(ab.f2233g));
            if (!y.b(str)) {
                a(jSONObject, "AppID", str);
            }
            ar b6 = al.b(al.a().url(aa.f2222v).host("cloud.cpatrk.net").body(new an(an.a.JSON, jSONObject.toString().getBytes())).header(new ap().a("Accept-Encoding", "")).method(aq.POST).build());
            n.getFileLock(f2395i);
            String c6 = y.c(b6.c());
            if (b6.b() == 200) {
                b(a(new JSONObject(c6)));
                s.a(ab.f2233g, f2396j, f2398l, System.currentTimeMillis());
            } else if (f2410z) {
                HashMap hashMap = new HashMap();
                if (!y.b(str)) {
                    hashMap.put("appId", str);
                }
                hashMap.put("channelId", str2);
                hashMap.put("Features", aVar);
                this.f2417y.sendMessageDelayed(this.f2417y.obtainMessage(1, hashMap), 5000L);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.has("i")) {
                this.f2411d = jSONObject.getInt("i");
            }
            this.f2414g = new HashSet<>();
            if (jSONObject.has("c") && jSONObject.has("r")) {
                JSONArray jSONArray = jSONObject.getJSONArray("c");
                JSONArray jSONArray2 = jSONObject.getJSONArray("r");
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i6);
                    int i7 = jSONObject2.getInt("id");
                    for (int i8 = 0; i8 < jSONArray2.length(); i8++) {
                        if (i7 == jSONArray2.getInt(i8)) {
                            a(jSONObject2, String.valueOf(i7));
                        }
                        this.f2414g.add(String.valueOf(i7));
                    }
                }
                if (jSONArray.length() == 0) {
                    this.f2413f = new HashMap<>();
                }
                g();
                i();
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private boolean b(String str) {
        try {
            if (y.b(str)) {
                return false;
            }
            int i6 = 0;
            while (true) {
                String[] strArr = f2400n;
                if (i6 >= strArr.length) {
                    return true;
                }
                if (str.equals(strArr[i6])) {
                    return false;
                }
                i6++;
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
            return true;
        }
    }

    private void d() {
        try {
            f2396j += this.f2416x;
            f2395i = n.b.Cloud_Control_Lock_File.toString() + this.f2416x;
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private boolean e() {
        long b6 = s.b(ab.f2233g, f2396j, f2398l, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (b6 == 0) {
            return true;
        }
        long j6 = currentTimeMillis - b6;
        return j6 > (this.f2411d * 60) * 1000 || j6 > this.f2412e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            ar b6 = al.b(al.a().host("cloud.cpatrk.net").url(aa.B).method(aq.GET).build());
            if (b6 != null && b6.b() == 200) {
                f2402p = new JSONObject(new String(b6.c())).optBoolean("GDPRregion");
            }
        } catch (Throwable unused) {
        }
    }

    private void g() {
        try {
            if (this.f2415h.length() == 0) {
                String a6 = a(n.b(f2395i));
                JSONObject jSONObject = !y.b(a6) ? new JSONObject(a6) : null;
                if (jSONObject == null || jSONObject.length() <= 0) {
                    return;
                }
                this.f2415h = jSONObject;
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private void h() {
        try {
            n.getFileLock(f2395i);
            String b6 = s.b(ab.f2233g, f2396j, f2397k, "");
            b(!y.b(b6) ? new JSONObject(b6) : null);
        } finally {
            try {
            } finally {
            }
        }
    }

    private void i() {
        try {
            Iterator<String> keys = this.f2415h.keys();
            while (keys.hasNext()) {
                JSONObject jSONObject = this.f2415h.getJSONObject(keys.next());
                Iterator<String> keys2 = jSONObject.keys();
                ArrayList arrayList = new ArrayList();
                while (keys2.hasNext()) {
                    String next = keys2.next();
                    if (!this.f2414g.contains(next)) {
                        arrayList.add(next);
                    }
                }
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    jSONObject.remove((String) arrayList.get(i6));
                }
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public JSONArray a(String str) {
        return a(str, (JSONObject) null, (JSONObject) null);
    }

    public JSONArray a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        int parseInt;
        JSONArray jSONArray = new JSONArray();
        if (!f2409w) {
            return jSONArray;
        }
        try {
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
        if (ab.f2243q) {
            return jSONArray;
        }
        if (f2403q && f2404r) {
            if (f2402p) {
                return null;
            }
            return jSONArray;
        }
        if (!this.f2413f.containsKey(str)) {
            if (f2401o) {
                return jSONArray;
            }
            return null;
        }
        if (jSONObject != null && jSONObject2 != null) {
            if (jSONObject.has(str)) {
                return jSONArray;
            }
            if (jSONObject2.has(str)) {
                return null;
            }
            jSONObject2.put(str, true);
        }
        JSONObject jSONObject3 = this.f2413f.get(str);
        Iterator<String> keys = jSONObject3.keys();
        ArrayList arrayList = new ArrayList();
        g();
        while (keys.hasNext()) {
            String next = keys.next();
            arrayList.add(next);
            JSONObject jSONObject4 = jSONObject3.getJSONObject(next);
            long j6 = jSONObject4.getLong("st");
            long j7 = jSONObject4.getLong("et");
            int i6 = jSONObject4.getInt("cn");
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis >= j6 && currentTimeMillis <= j7 && i6 > 0) {
                if (this.f2415h.has(str)) {
                    JSONObject jSONObject5 = this.f2415h.getJSONObject(str);
                    if (!jSONObject5.has(next)) {
                        this.f2415h.put(str, jSONObject5.put(next, 1));
                        parseInt = Integer.parseInt(next);
                    } else if (jSONObject5.getInt(next) < i6) {
                        jSONArray.put(Integer.parseInt(next));
                        jSONObject5.put(next, jSONObject5.getInt(next) + 1);
                        this.f2415h.put(str, jSONObject5);
                    }
                } else {
                    this.f2415h.put(str, new JSONObject().put(next, 1));
                    parseInt = Integer.parseInt(next);
                }
                jSONArray.put(parseInt);
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return jSONArray;
    }

    public void a(String str, String str2, a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        if (y.b(str2)) {
            str2 = "Default";
        }
        hashMap.put("channelId", str2);
        hashMap.put("Features", aVar);
        this.f2416x = a(aVar);
        d();
        boolean z5 = i.e(aVar) == 1;
        f2403q = z5;
        if (z5) {
            if (!o.h(ab.f2233g)) {
                w.f2761a.execute(new Runnable() { // from class: com.tendcloud.tenddata.bi.2
                    @Override // java.lang.Runnable
                    public void run() {
                        bi.this.f();
                    }
                });
                Handler handler = this.f2417y;
                handler.sendMessageDelayed(handler.obtainMessage(3, hashMap), 5000L);
                f2409w = true;
                return;
            }
            f2404r = false;
        }
        String p6 = o.p(ab.f2233g);
        String o6 = o.o(ab.f2233g);
        f2405s = y.b(p6) ? "" : p6.substring(0, 3);
        f2406t = y.b(p6) ? "" : p6.substring(3);
        f2407u = y.b(o6) ? "" : o6.substring(0, 3);
        f2408v = y.b(o6) ? "" : o6.substring(3);
        f2401o = b(f2405s) || b(f2407u);
        h();
        try {
            if (ab.f2243q || e()) {
                this.f2417y.sendMessage(this.f2417y.obtainMessage(0, hashMap));
            }
        } catch (Throwable unused) {
        }
        f2409w = true;
    }

    public String b() {
        return f2395i;
    }

    public void c() {
        a(n.b(f2395i), this.f2415h.toString());
        this.f2415h = new JSONObject();
    }
}
