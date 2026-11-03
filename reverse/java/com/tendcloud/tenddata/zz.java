package com.tendcloud.tenddata;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tendcloud.tenddata.af;
import com.tendcloud.tenddata.cs;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zz implements ao {

    /* renamed from: a, reason: collision with root package name */
    public static String f2794a = null;

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f2795b = false;

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f2796c = false;

    /* renamed from: d, reason: collision with root package name */
    static boolean f2797d = false;

    /* renamed from: e, reason: collision with root package name */
    public static b f2798e = null;

    /* renamed from: f, reason: collision with root package name */
    public static final int f2799f = 102;

    /* renamed from: g, reason: collision with root package name */
    private static volatile zz f2800g = null;

    /* renamed from: h, reason: collision with root package name */
    private static String f2801h = null;

    /* renamed from: i, reason: collision with root package name */
    private static String f2802i = null;

    /* renamed from: j, reason: collision with root package name */
    private static String f2803j = null;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f2804k = false;

    /* renamed from: l, reason: collision with root package name */
    private static final int f2805l = 101;

    /* renamed from: m, reason: collision with root package name */
    private static final int f2806m = 103;

    /* renamed from: n, reason: collision with root package name */
    private static Handler f2807n;

    /* renamed from: o, reason: collision with root package name */
    private static final HandlerThread f2808o;

    /* renamed from: p, reason: collision with root package name */
    private static Handler f2809p;

    /* renamed from: q, reason: collision with root package name */
    private static final HandlerThread f2810q;

    public static class a {
        public HashMap<String, Object> paraMap = new HashMap<>();
    }

    static {
        HandlerThread handlerThread = new HandlerThread("ProcessingThread", 10);
        f2808o = handlerThread;
        f2809p = null;
        HandlerThread handlerThread2 = new HandlerThread("PauseEventThread", 10);
        f2810q = handlerThread2;
        handlerThread.start();
        f2807n = new Handler(handlerThread.getLooper()) { // from class: com.tendcloud.tenddata.zz.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                cr.a();
                cq.a();
                Object obj = message.obj;
                if (obj == null || !(obj instanceof a)) {
                    return;
                }
                try {
                    z.a().post((a) obj);
                } catch (Throwable unused) {
                }
            }
        };
        handlerThread2.start();
        f2809p = new Handler(handlerThread2.getLooper()) { // from class: com.tendcloud.tenddata.zz.12
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    com.tendcloud.tenddata.a aVar = (com.tendcloud.tenddata.a) message.obj;
                    if (ab.f2240n == 1) {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 11);
                        aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                        aVar2.paraMap.put("sessionEnd", 1);
                        aVar2.paraMap.put("service", aVar);
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                        ab.Z.set(true);
                        ab.f2240n = 2;
                    }
                } catch (Exception e6) {
                    bq.postSDKError(e6);
                }
            }
        };
    }

    public zz() {
        f2800g = this;
    }

    static synchronized zz a() {
        zz zzVar;
        synchronized (zz.class) {
            if (f2800g == null) {
                synchronized (zz.class) {
                    if (f2800g == null) {
                        f2800g = new zz();
                    }
                }
            }
            zzVar = f2800g;
        }
        return zzVar;
    }

    private void a(final Context context) {
        if (!y.a(14)) {
            try {
                y.a(Class.forName("android.app.ActivityManagerNative"), new v() { // from class: com.tendcloud.tenddata.zz.28
                    @Override // com.tendcloud.tenddata.v
                    public void afterMethodInvoked(Object obj, Method method, Object[] objArr, Object obj2) {
                    }

                    @Override // com.tendcloud.tenddata.v
                    public void beforeMethodInvoke(Object obj, Method method, Object[] objArr) {
                        String name = method.getName();
                        if (context instanceof Activity) {
                            if (name.equalsIgnoreCase("activityPaused")) {
                                c.b((Activity) context, com.tendcloud.tenddata.a.UNIVERSAL);
                            } else if (name.equalsIgnoreCase("activityIdle")) {
                                c.a((Activity) context, com.tendcloud.tenddata.a.UNIVERSAL);
                            }
                        }
                    }
                }, "gDefault", "android.app.IActivityManager");
                f2804k = true;
                return;
            } catch (Throwable th) {
                h.eForDeveloper("registerActivityLifecycleListener " + th.getMessage());
                return;
            }
        }
        try {
            Context context2 = ab.f2233g;
            Application application = context2 instanceof Activity ? ((Activity) context2).getApplication() : context2 instanceof Application ? (Application) context2 : null;
            if (application == null || f2804k) {
                return;
            }
            b bVar = new b();
            f2798e = bVar;
            application.registerActivityLifecycleCallbacks(bVar);
            f2804k = true;
        } catch (Throwable unused) {
        }
    }

    private void a(Context context, final String str, final int i6, final com.tendcloud.tenddata.a aVar) {
        y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.34
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (zz.f2795b) {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", Integer.valueOf(i6));
                        aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                        HashMap<String, Object> hashMap = aVar2.paraMap;
                        String str2 = str;
                        hashMap.put("pageName", str2 == null ? "" : y.a(str2));
                        aVar2.paraMap.put("service", aVar);
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    static Handler b() {
        return f2809p;
    }

    public static Handler c() {
        return f2807n;
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Activity activity, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
            } else {
                if (f2804k && ab.K) {
                    return;
                }
                a(activity);
                c.a(activity, aVar);
                ab.K = true;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Activity activity, String str, String str2, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
            } else {
                a(activity);
                a(activity, aVar);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, com.tendcloud.tenddata.a aVar) {
        a(context, (String) null, (String) null, aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, String str, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (f2797d) {
                f2797d = false;
                return;
            }
            if (y.b(str) && (context instanceof Activity)) {
                str = ((Activity) context).getLocalClassName();
            }
            a(context, str, 4, aVar);
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, String str, String str2, com.tendcloud.tenddata.a aVar) {
        a(context, str, str2, (String) null, aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, String str, String str2, String str3, final com.tendcloud.tenddata.a aVar) {
        try {
            if (context == null) {
                h.iForDeveloper("Init failed Context is null");
                return;
            }
            if (!y.b(context, "android.permission.INTERNET")) {
                h.eForDeveloper("[SDKInit] Permission \"android.permission.INTERNET\" is needed.");
                return;
            }
            if (aVar == null) {
                h.eForDeveloper("Failed to initialize!");
                return;
            }
            try {
                if (f2795b) {
                    return;
                }
                ab.f2233g = context.getApplicationContext();
                f2801h = str;
                f2803j = str2;
                f2794a = str3;
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                String a6 = y.a(bundle, ab.ac);
                String a7 = y.a(bundle, "TD_CHANNEL_ID");
                if (y.b(a6)) {
                    a6 = f2801h;
                }
                f2801h = a6;
                if (y.b(a7)) {
                    a7 = f2803j;
                }
                f2803j = a7;
                ab.c(f2794a, aVar);
                String a8 = y.a(context, "ChannelConfig.json");
                if (y.b(a8)) {
                    a8 = f2803j;
                }
                f2803j = a8;
                if (y.b(f2801h)) {
                    h.eForDeveloper("[SDKInit] TD AppId is null");
                    return;
                }
                String trim = f2801h.trim();
                f2801h = trim;
                ab.a(trim, f2803j, aVar);
                bk.a();
                bi.a().a(f2801h, f2803j, aVar);
                a(context);
                bj.a();
                y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.23
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            bn.a();
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 1);
                            aVar2.paraMap.put("appId", zz.f2801h != null ? zz.f2801h : "");
                            aVar2.paraMap.put("channelId", zz.f2803j != null ? zz.f2803j : "");
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("action", "init");
                            Message.obtain(zz.c(), zz.f2805l, aVar2).sendToTarget();
                            bo.a();
                            if (y.a(ab.f2233g)) {
                                c.a(aVar);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
                f2795b = true;
            } catch (Throwable th) {
                h.a("[SDKInit] Failed to initialize!", th);
                bq.postSDKError(th);
            }
        } catch (Throwable th2) {
            bq.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, final String str, final String str2, final Map<String, Object> map, final double d6, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                h.eForDeveloper("onEvent()# event id is empty.");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onEvent being called! eventId: ");
            sb.append(str);
            String str3 = "null";
            if (aVar.index() != 3) {
                sb.append(", eventLabel: ");
                sb.append(str2 == null ? "null" : str2);
            }
            sb.append(", eventMap: ");
            if (map != null) {
                str3 = map.toString();
            }
            sb.append(str3);
            sb.append(", value: ");
            sb.append(d6);
            h.iForDeveloper(sb.toString());
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.37
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("apiType", 2);
                        aVar2.paraMap.put("eventId", y.a(str));
                        HashMap<String, Object> hashMap = aVar2.paraMap;
                        String str4 = str2;
                        hashMap.put("eventLabel", str4 == null ? null : y.a(str4));
                        aVar2.paraMap.put("map", map);
                        aVar2.paraMap.put("value", Double.valueOf(d6));
                        aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, String str, String str2, Map<String, Object> map, com.tendcloud.tenddata.a aVar) {
        a(context, str, str2, map, new HashMap(), aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, final String str, final String str2, final Map<String, Object> map, final Map<String, Object> map2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                h.eForDeveloper("onEvent()# event id is empty.");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onEvent being called! eventId: ");
            sb.append(str);
            String str3 = "null";
            if (aVar.index() != 3) {
                sb.append(", eventLabel: ");
                sb.append(str2 == null ? "null" : str2);
            }
            sb.append(", eventMap: ");
            if (map != null) {
                str3 = map.toString();
            }
            sb.append(str3);
            if (map2 != null && !map2.isEmpty()) {
                sb.append(", eventValue: ");
                sb.append(map2.toString());
            }
            h.iForDeveloper(sb.toString());
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.36
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("apiType", 2);
                        aVar2.paraMap.put("eventId", y.a(str));
                        HashMap<String, Object> hashMap = aVar2.paraMap;
                        String str4 = str2;
                        hashMap.put("eventLabel", str4 == null ? null : y.a(str4));
                        aVar2.paraMap.put("map", map);
                        aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                        Map map3 = map2;
                        if (map3 != null && !map3.isEmpty()) {
                            aVar2.paraMap.put("eventValue", map2);
                        }
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, final String str, final Map<String, Object> map, final double d6, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                h.eForDeveloper("onEvent()# event id is empty.");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onEvent being called! eventId: ");
            sb.append(str);
            sb.append(", eventMap: ");
            sb.append(map == null ? "null" : map.toString());
            sb.append(", value: ");
            sb.append(d6);
            h.iForDeveloper(sb.toString());
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.38
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("apiType", 2);
                        aVar2.paraMap.put("eventId", y.a(str));
                        aVar2.paraMap.put("map", map);
                        aVar2.paraMap.put("value", Double.valueOf(d6));
                        aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, final Throwable th, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
            } else {
                if (th == null) {
                    return;
                }
                y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.39
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 3);
                            aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                            aVar2.paraMap.put("throwable", th);
                            aVar2.paraMap.put("service", aVar);
                            Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final TalkingDataOrder talkingDataOrder, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (talkingDataOrder != null && !talkingDataOrder.optString("keyOrderId").isEmpty()) {
                h.iForDeveloper("onCancelOrder called --> order: " + talkingDataOrder.toString());
                y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.24
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 8);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", "iap");
                            aVar2.paraMap.put("action", "cancelOrder");
                            TreeMap treeMap = new TreeMap();
                            treeMap.put("orderId", talkingDataOrder.getString("keyOrderId"));
                            treeMap.put("amount", Integer.valueOf(talkingDataOrder.optInt("keyTotalPrice")));
                            String optString = talkingDataOrder.optString("keyCurrencyType");
                            if (TextUtils.isEmpty(optString)) {
                                optString = "CNY";
                            }
                            treeMap.put("currencyType", optString);
                            aVar2.paraMap.put(cs.a.DATA, treeMap);
                            Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            }
            h.eForDeveloper("onCancelOrder: order or orderID could not be null or empty");
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(TalkingDataOrder talkingDataOrder, String str, com.tendcloud.tenddata.a aVar) {
        a(talkingDataOrder, str, new HashMap(), aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final TalkingDataOrder talkingDataOrder, final String str, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (talkingDataOrder == null) {
                h.eForDeveloper("onPay: order could not be null or empty");
                return;
            }
            h.iForDeveloper("onOrderPaySucc called --> order: " + talkingDataOrder.toString() + " ,paymentType: " + str + " ,profileId: " + str2);
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.13
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 8);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "iap");
                        aVar2.paraMap.put("action", "pay");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str2);
                        treeMap.put("orderId", talkingDataOrder.getString("keyOrderId"));
                        treeMap.put("amount", Integer.valueOf(talkingDataOrder.optInt("keyTotalPrice")));
                        String optString = talkingDataOrder.optString("keyCurrencyType");
                        if (TextUtils.isEmpty(optString)) {
                            optString = "CNY";
                        }
                        treeMap.put("currencyType", optString);
                        if (!TextUtils.isEmpty(str)) {
                            treeMap.put("payType", str);
                        }
                        aVar2.paraMap.put(cs.a.DATA, treeMap);
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final TalkingDataOrder talkingDataOrder, final String str, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        String str2;
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (talkingDataOrder != null && !talkingDataOrder.optString("keyOrderId").isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlaceOrder called --> order: ");
                sb.append(talkingDataOrder.toString());
                sb.append(", profileId: ");
                sb.append(str);
                if (map == null || map.isEmpty()) {
                    str2 = "";
                } else {
                    str2 = ", eventValue: " + map.toString();
                }
                sb.append(str2);
                h.iForDeveloper(sb.toString());
                y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.21
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONArray jSONArray;
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 8);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", "iap");
                            aVar2.paraMap.put("action", "placeOrder");
                            TreeMap treeMap = new TreeMap();
                            treeMap.put("accountId", str);
                            treeMap.put("orderId", talkingDataOrder.getString("keyOrderId"));
                            treeMap.put("amount", Integer.valueOf(talkingDataOrder.optInt("keyTotalPrice")));
                            String optString = talkingDataOrder.optString("keyCurrencyType");
                            if (TextUtils.isEmpty(optString)) {
                                optString = "CNY";
                            }
                            treeMap.put("currencyType", optString);
                            if (talkingDataOrder.has("keyOrderDetail") && (jSONArray = talkingDataOrder.getJSONArray("keyOrderDetail")) != null && jSONArray.length() > 0) {
                                treeMap.put("items", jSONArray);
                            }
                            Map map2 = map;
                            if (map2 != null && !map2.isEmpty()) {
                                treeMap.put("eventValue", map);
                            }
                            aVar2.paraMap.put(cs.a.DATA, treeMap);
                            Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            }
            h.eForDeveloper("onPlaceOrder: order or orderID could not be null or empty");
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final TalkingDataProfile talkingDataProfile, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            h.iForDeveloper("onProfileUpdate called --> profile is " + y.a(talkingDataProfile).toString());
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", "account");
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("action", "update");
                        if ("APP".equals(aVar.name())) {
                            aVar2.paraMap.put("action", "_td_update");
                        }
                        aVar2.paraMap.put(cs.a.DATA, y.a(talkingDataProfile));
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final TalkingDataSearch talkingDataSearch, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (talkingDataSearch == null) {
                h.eForDeveloper("TDSearch cannot be null ");
                return;
            }
            h.iForDeveloper("onSearch called --> search: " + talkingDataSearch);
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.31
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "ad");
                        aVar2.paraMap.put("action", "search");
                        aVar2.paraMap.put(cs.a.DATA, y.a(talkingDataSearch));
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final TalkingDataShoppingCart talkingDataShoppingCart, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            h.iForDeveloper("onViewShoppingCart called --> shoppingCart: " + talkingDataShoppingCart);
            if (talkingDataShoppingCart != null && talkingDataShoppingCart.length() > 0) {
                y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.27
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 8);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", "iap");
                            aVar2.paraMap.put("action", "viewItems");
                            TreeMap treeMap = new TreeMap();
                            treeMap.put("items", talkingDataShoppingCart);
                            aVar2.paraMap.put(cs.a.DATA, treeMap);
                            Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            }
            h.eForDeveloper("viewShoppingCart# shoppingCart can't be null or empty");
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final Cdo cdo, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            h.iForDeveloper("onViewShoppingCart called --> shoppingCart: " + cdo);
            if (cdo != null && cdo.length() > 0) {
                y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.26
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 8);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", "iap");
                            aVar2.paraMap.put("action", "viewItems");
                            TreeMap treeMap = new TreeMap();
                            treeMap.put("items", cdo);
                            aVar2.paraMap.put(cs.a.DATA, treeMap);
                            Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            }
            h.eForDeveloper("viewShoppingCart# shoppingCart can't be null or empty");
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final dp dpVar, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (dpVar == null) {
                h.eForDeveloper("TDSearch cannot be null ");
                return;
            }
            h.iForDeveloper("onSearch called --> search: " + dpVar);
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.30
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "ad");
                        aVar2.paraMap.put("action", "search");
                        aVar2.paraMap.put(cs.a.DATA, y.a(dpVar));
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(String str, int i6, String str2, com.tendcloud.tenddata.a aVar) {
        a(str, i6, str2, new HashMap(), aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final int i6, final String str2, final String str3, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && !str.isEmpty()) {
                h.iForDeveloper("onOrderPaySucc called --> orderid: " + str + " ,amount: " + i6 + " ,currencyType: " + str2 + " ,payType: " + str3);
                if (str2 != null && str2.trim().length() == 3) {
                    y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.11
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", "iap");
                                aVar2.paraMap.put("action", "pay");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("orderId", str);
                                treeMap.put("amount", Integer.valueOf(i6));
                                treeMap.put("currencyType", str2);
                                treeMap.put("payType", str3);
                                aVar2.paraMap.put(cs.a.DATA, treeMap);
                                Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                h.eForDeveloper("currencyType length must be 3 likes CNY so so");
                return;
            }
            h.eForDeveloper("onOrderPaySucc: orderId could not be null or empty");
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final int i6, final String str2, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        String str3;
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && !str.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPlaceOrder called --> orderId: ");
                sb.append(str);
                sb.append(" ,amount: ");
                sb.append(i6);
                sb.append(" ,currencyType: ");
                sb.append(str2);
                if (map == null || map.isEmpty()) {
                    str3 = "";
                } else {
                    str3 = ", eventValue: " + map.toString();
                }
                sb.append(str3);
                h.iForDeveloper(sb.toString());
                if (str2 != null && str2.trim().length() == 3) {
                    y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.20
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", "iap");
                                aVar2.paraMap.put("action", "placeOrder");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("orderId", str);
                                treeMap.put("amount", Integer.valueOf(i6));
                                treeMap.put("currencyType", str2);
                                Map map2 = map;
                                if (map2 != null && !map2.isEmpty()) {
                                    treeMap.put("eventValue", map);
                                }
                                aVar2.paraMap.put(cs.a.DATA, treeMap);
                                Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                h.eForDeveloper("currencyType length must be 3 likes CNY so so");
                return;
            }
            h.eForDeveloper("onPlaceOrder: orderId could not be null or empty");
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(String str, TalkingDataProfile talkingDataProfile, com.tendcloud.tenddata.a aVar) {
        a(str, talkingDataProfile, new HashMap(), aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(String str, TalkingDataProfile talkingDataProfile, String str2, com.tendcloud.tenddata.a aVar) {
        a(str, talkingDataProfile, str2, new HashMap(), aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final TalkingDataProfile talkingDataProfile, final String str2, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        String sb;
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                h.eForDeveloper("onRegister: profileId could not be null or empty");
                return;
            }
            String str3 = "";
            if (talkingDataProfile != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onRegister called --> profileId is ");
                sb2.append(str);
                sb2.append(" , profile is ");
                sb2.append(y.a(talkingDataProfile).toString());
                sb2.append(" , invitationCode is ");
                sb2.append(str2);
                if (map != null && !map.isEmpty()) {
                    str3 = ", eventValue: " + map.toString();
                }
                sb2.append(str3);
                sb = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("onRegister called --> profileId is ");
                sb3.append(str);
                sb3.append(" , invitationCode is ");
                sb3.append(str2);
                if (map != null && !map.isEmpty()) {
                    str3 = ", eventValue: " + map.toString();
                }
                sb3.append(str3);
                sb = sb3.toString();
            }
            h.iForDeveloper(sb);
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", "account");
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("action", "register");
                        if ("APP".equals(aVar.name())) {
                            aVar2.paraMap.put("action", "_td_register");
                        }
                        aVar2.paraMap.put("accountId", str);
                        aVar2.paraMap.put("invitationCode", str2);
                        aVar2.paraMap.put(cs.a.DATA, y.a(talkingDataProfile));
                        Map map2 = map;
                        if (map2 != null && !map2.isEmpty()) {
                            aVar2.paraMap.put("eventValue", map);
                        }
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final TalkingDataProfile talkingDataProfile, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        String sb;
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                h.eForDeveloper("onLogin: profileId could not be null or empty");
                return;
            }
            String str2 = "";
            if (talkingDataProfile != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onLogin called --> profileId is ");
                sb2.append(str);
                sb2.append(" ，profile is ");
                sb2.append(y.a(talkingDataProfile).toString());
                if (map != null && !map.isEmpty()) {
                    str2 = ", eventValue: " + map.toString();
                }
                sb2.append(str2);
                sb = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("onLogin called --> profileId is ");
                sb3.append(str);
                if (map != null && !map.isEmpty()) {
                    str2 = ", eventValue: " + map.toString();
                }
                sb3.append(str2);
                sb = sb3.toString();
            }
            h.iForDeveloper(sb);
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", "account");
                        aVar2.paraMap.put("action", "login");
                        if ("APP".equals(aVar.name())) {
                            aVar2.paraMap.put("action", "_td_login");
                        }
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("accountId", str);
                        aVar2.paraMap.put(cs.a.DATA, y.a(talkingDataProfile));
                        Map map2 = map;
                        if (map2 != null && !map2.isEmpty()) {
                            aVar2.paraMap.put("eventValue", map);
                        }
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(String str, com.tendcloud.tenddata.a aVar) {
        a(str, new HashMap(), aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(String str, af.ProfileType profileType, String str2, com.tendcloud.tenddata.a aVar) {
        a(str, profileType, str2, new HashMap(), aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final af.ProfileType profileType, final String str2, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        String str3;
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                h.eForDeveloper("onRegister: profileId could not be null or empty");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onRegister called --> profileId is ");
            sb.append(str);
            sb.append(" ，type is ");
            sb.append(profileType);
            sb.append(" , name is ");
            sb.append(str2);
            if (map == null || map.isEmpty()) {
                str3 = "";
            } else {
                str3 = ", eventValue: " + map.toString();
            }
            sb.append(str3);
            h.iForDeveloper(sb.toString());
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", "account");
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("action", "register");
                        aVar2.paraMap.put("accountId", str);
                        af.ProfileType profileType2 = profileType;
                        if (profileType2 != null) {
                            aVar2.paraMap.put("type", profileType2.name());
                        }
                        String str4 = str2;
                        if (str4 != null) {
                            aVar2.paraMap.put("name", str4);
                        }
                        Map map2 = map;
                        if (map2 != null && !map2.isEmpty()) {
                            aVar2.paraMap.put("eventValue", map);
                        }
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(String str, dn dnVar, com.tendcloud.tenddata.a aVar) {
        a(str, dnVar, new HashMap(), aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final dn dnVar, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        String str2;
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                if (dnVar != null && !dnVar.optString("keyOrderId").isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onPlaceOrder called --> profileId: ");
                    sb.append(str);
                    sb.append(" ,order: ");
                    sb.append(dnVar.toString());
                    if (map == null || map.isEmpty()) {
                        str2 = "";
                    } else {
                        str2 = ", eventValue: " + map.toString();
                    }
                    sb.append(str2);
                    h.iForDeveloper(sb.toString());
                    y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.19
                        @Override // java.lang.Runnable
                        public void run() {
                            String optString;
                            Map map2;
                            JSONArray jSONArray;
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", "iap");
                                aVar2.paraMap.put("action", "placeOrder");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("accountId", str);
                                treeMap.put("orderId", dnVar.getString("keyOrderId"));
                                treeMap.put("amount", Integer.valueOf(dnVar.optInt("keyTotalPrice")));
                                if (!aVar.name().equals("TRACKING")) {
                                    if (aVar.name().equals("APP")) {
                                        optString = dnVar.optString("keyCurrencyType");
                                        if (TextUtils.isEmpty(optString)) {
                                            optString = "CNY";
                                        }
                                    }
                                    if (dnVar.has("keyOrderDetail") && (jSONArray = dnVar.getJSONArray("keyOrderDetail")) != null && jSONArray.length() > 0) {
                                        treeMap.put("items", jSONArray);
                                    }
                                    map2 = map;
                                    if (map2 != null && !map2.isEmpty()) {
                                        treeMap.put("eventValue", map);
                                    }
                                    aVar2.paraMap.put(cs.a.DATA, treeMap);
                                    Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                                }
                                optString = dnVar.optString("keyCurrencyType");
                                treeMap.put("currencyType", optString);
                                if (dnVar.has("keyOrderDetail")) {
                                    treeMap.put("items", jSONArray);
                                }
                                map2 = map;
                                if (map2 != null) {
                                    treeMap.put("eventValue", map);
                                }
                                aVar2.paraMap.put(cs.a.DATA, treeMap);
                                Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                h.eForDeveloper("onPlaceOrder: order or orderID could not be null or empty");
                return;
            }
            h.eForDeveloper("onPlaceOrder: profileId could not be null or empty");
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(String str, Object obj) {
        if (!f2795b) {
            h.eForDeveloper("SDK have not been initialized");
            return;
        }
        if (str != null && obj != null) {
            h.iForDeveloper("setGlobalKV# key:" + str + " value:" + obj.toString());
        }
        ab.f2230d.put(str, obj);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final int i6, final String str3, final String str4, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                h.iForDeveloper("onOrderPaySucc called --> profileId: " + str + " ,orderid: " + str2 + " ,amount: " + i6 + " ,currencyType: " + str3 + " ,payType: " + str4);
                if (str3 != null && str3.trim().length() == 3) {
                    y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.14
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", "iap");
                                aVar2.paraMap.put("action", "recharge");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("accountId", str);
                                treeMap.put("orderId", str2);
                                treeMap.put("amount", Integer.valueOf(i6));
                                treeMap.put("currencyType", str3);
                                treeMap.put("payType", str4);
                                aVar2.paraMap.put(cs.a.DATA, treeMap);
                                Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                h.eForDeveloper("currencyType length must be 3 likes CNY so so");
                return;
            }
            h.eForDeveloper("onOrderPaySucc: profileId could not be null or empty");
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final int i6, final String str3, final String str4, final dn dnVar, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                if (dnVar == null) {
                    h.eForDeveloper("onPay: order could not be null");
                    return;
                }
                h.iForDeveloper("onPay called --> profileId: " + str + " ,orderid: " + str2 + " ,amount: " + i6 + " ,currencyType: " + str3 + " ,payType: " + str4 + " ,order: " + dnVar.toString());
                if (str3 != null && str3.trim().length() == 3) {
                    y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.17
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONArray jSONArray;
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", "iap");
                                aVar2.paraMap.put("action", "recharge");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("accountId", str);
                                treeMap.put("orderId", str2);
                                treeMap.put("amount", Integer.valueOf(i6));
                                treeMap.put("currencyType", str3);
                                treeMap.put("payType", str4);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("orderId", dnVar.getString("keyOrderId"));
                                jSONObject.put("amount", dnVar.getInt("keyTotalPrice"));
                                jSONObject.put("currencyType", dnVar.getString("keyCurrencyType"));
                                if (dnVar.has("keyOrderDetail") && (jSONArray = dnVar.getJSONArray("keyOrderDetail")) != null && jSONArray.length() > 0) {
                                    jSONObject.put("items", jSONArray);
                                }
                                treeMap.put("order", jSONObject);
                                aVar2.paraMap.put(cs.a.DATA, treeMap);
                                Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                h.eForDeveloper("currencyType length must be 3 likes CNY so so");
                return;
            }
            h.eForDeveloper("onPay: profileId could not be null or empty");
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final int i6, final String str3, final String str4, final String str5, final int i7, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str2 != null && str2.trim().length() > 0) {
                h.iForDeveloper("onPay called --> profileId: " + str + " ,orderid: " + str2 + " ,amount: " + i6 + " ,currencyType: " + str3 + " ,payType: " + str4 + " ,itemId: " + str5 + " ,itemCount: " + i7);
                if (str3 != null && str3.trim().length() == 3) {
                    y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.16
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", "iap");
                                aVar2.paraMap.put("action", "currencyPurchase");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("accountId", str);
                                treeMap.put("orderId", str2);
                                treeMap.put("amount", Integer.valueOf(i6));
                                treeMap.put("currencyType", str3);
                                treeMap.put("payType", str4);
                                treeMap.put("itemId", str5);
                                treeMap.put("itemCount", Integer.valueOf(i7));
                                aVar2.paraMap.put(cs.a.DATA, treeMap);
                                Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                h.eForDeveloper("currencyType length must be 3 likes CNY so so");
                return;
            }
            h.eForDeveloper("onPay: orderId could not be null or empty");
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(String str, String str2, com.tendcloud.tenddata.a aVar) {
        a(str, str2, new HashMap(), aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final dn dnVar, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                if (dnVar != null && !dnVar.optString("keyOrderId").isEmpty()) {
                    h.iForDeveloper("onPay called --> profileId: " + str + " ,payType: " + str2 + " ,order: " + dnVar.toString());
                    y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.18
                        @Override // java.lang.Runnable
                        public void run() {
                            String optString;
                            JSONArray jSONArray;
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", "iap");
                                aVar2.paraMap.put("action", "pay");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("accountId", str);
                                if (aVar.name().equals("APP")) {
                                    treeMap.put("orderId", dnVar.getString("keyOrderId"));
                                    if (!TextUtils.isEmpty(str2)) {
                                        treeMap.put("payType", str2);
                                    }
                                    treeMap.put("amount", Integer.valueOf(dnVar.optInt("keyTotalPrice")));
                                    optString = dnVar.optString("keyCurrencyType");
                                    if (TextUtils.isEmpty(optString)) {
                                        optString = "CNY";
                                    }
                                } else {
                                    treeMap.put("payType", str2);
                                    treeMap.put("orderId", dnVar.getString("keyOrderId"));
                                    treeMap.put("amount", Integer.valueOf(dnVar.optInt("keyTotalPrice")));
                                    optString = dnVar.optString("keyCurrencyType");
                                }
                                treeMap.put("currencyType", optString);
                                if (dnVar.has("keyOrderDetail") && (jSONArray = dnVar.getJSONArray("keyOrderDetail")) != null && jSONArray.length() > 0) {
                                    treeMap.put("items", jSONArray);
                                }
                                aVar2.paraMap.put(cs.a.DATA, treeMap);
                                Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                h.eForDeveloper("onPay: order or orderID could not be null or empty");
                return;
            }
            h.eForDeveloper("onPay: profileId could not be null or empty");
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(String str, String str2, String str3, int i6, int i7, com.tendcloud.tenddata.a aVar) {
        a(str, str2, str3, i6, i7, new HashMap(), aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final String str3, final int i6, final int i7, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        String str4;
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onAddItemToShoppingCart called --> itemId: ");
            sb.append(str);
            sb.append(" ,category: ");
            sb.append(str2);
            sb.append(" ,name: ");
            sb.append(str3);
            sb.append(" ,unitPrice: ");
            sb.append(i6);
            sb.append(" ,amount: ");
            sb.append(i7);
            if (map == null || map.isEmpty()) {
                str4 = "";
            } else {
                str4 = ", eventValue: " + map.toString();
            }
            sb.append(str4);
            h.iForDeveloper(sb.toString());
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.10
                @Override // java.lang.Runnable
                public void run() {
                    int i8;
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 8);
                        aVar2.paraMap.put("domain", "iap");
                        aVar2.paraMap.put("action", "addItem");
                        aVar2.paraMap.put("service", aVar);
                        TreeMap treeMap = new TreeMap();
                        if (aVar.name().equals("APP")) {
                            if (!TextUtils.isEmpty(str)) {
                                treeMap.put("id", str);
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                treeMap.put("category", str2);
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                treeMap.put("name", str3);
                            }
                            treeMap.put("unitPrice", Integer.valueOf(i6));
                            i8 = i7;
                        } else {
                            treeMap.put("id", str);
                            treeMap.put("category", str2);
                            treeMap.put("name", str3);
                            treeMap.put("unitPrice", Integer.valueOf(i6));
                            i8 = i7;
                        }
                        treeMap.put("count", Integer.valueOf(i8));
                        Map map2 = map;
                        if (map2 != null && !map2.isEmpty()) {
                            treeMap.put("eventValue", map);
                        }
                        aVar2.paraMap.put(cs.a.DATA, treeMap);
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(String str, String str2, String str3, int i6, com.tendcloud.tenddata.a aVar) {
        a(str, str2, str3, i6, new HashMap(), aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final String str3, final int i6, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        String str4;
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onViewItem called --> itemId: ");
            sb.append(str);
            sb.append(" ,category: ");
            sb.append(str2);
            sb.append(" ,name: ");
            sb.append(str3);
            sb.append(" ,unitPrice: ");
            sb.append(i6);
            if (map == null || map.isEmpty()) {
                str4 = "";
            } else {
                str4 = ", eventValue: " + map.toString();
            }
            sb.append(str4);
            h.iForDeveloper(sb.toString());
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.25
                @Override // java.lang.Runnable
                public void run() {
                    int i7;
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 8);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "iap");
                        aVar2.paraMap.put("action", "viewItem");
                        TreeMap treeMap = new TreeMap();
                        if (aVar.name().equals("APP")) {
                            if (!TextUtils.isEmpty(str)) {
                                treeMap.put("id", str);
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                treeMap.put("category", str2);
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                treeMap.put("name", str3);
                            }
                            i7 = i6;
                        } else {
                            treeMap.put("id", str);
                            treeMap.put("category", str2);
                            treeMap.put("name", str3);
                            i7 = i6;
                        }
                        treeMap.put("unitPrice", Integer.valueOf(i7));
                        Map map2 = map;
                        if (map2 != null && !map2.isEmpty()) {
                            treeMap.put("eventValue", map);
                        }
                        aVar2.paraMap.put(cs.a.DATA, treeMap);
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final String str3, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            h.iForDeveloper("onCreateCard called --> profileId: " + str + " method: " + str2 + "  content: " + str3);
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "account");
                        aVar2.paraMap.put("action", "card");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("method", str2);
                        treeMap.put("content", str3);
                        aVar2.paraMap.put(cs.a.DATA, treeMap);
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        String str3;
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                h.eForDeveloper("onRegister: profileId could not be null or empty");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onRegister called --> profileId is ");
            sb.append(str);
            sb.append(" invitationCode: ");
            sb.append(str2);
            if (map == null || map.isEmpty()) {
                str3 = "";
            } else {
                str3 = ", eventValue: " + map.toString();
            }
            sb.append(str3);
            h.iForDeveloper(sb.toString());
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", "account");
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("action", "register");
                        aVar2.paraMap.put("accountId", str);
                        aVar2.paraMap.put("invitationCode", str2);
                        Map map2 = map;
                        if (map2 != null && !map2.isEmpty()) {
                            aVar2.paraMap.put("eventValue", map);
                        }
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        String str2;
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                h.eForDeveloper("onLogin: profileId could not be null or empty");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onLogin called --> profileId is ");
            sb.append(str);
            if (map == null || map.isEmpty()) {
                str2 = "";
            } else {
                str2 = ", eventValue: " + map.toString();
            }
            sb.append(str2);
            h.iForDeveloper(sb.toString());
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.40
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", "account");
                        aVar2.paraMap.put("action", "login");
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("accountId", str);
                        Map map2 = map;
                        if (map2 != null && !map2.isEmpty()) {
                            aVar2.paraMap.put("eventValue", map);
                        }
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Map<String, Object> map, TDGenerateUrl tDGenerateUrl) {
        bd.a().a(map).getShortUrl(tDGenerateUrl);
    }

    @Override // com.tendcloud.tenddata.ao
    public String b(Context context) {
        try {
            return j.a(context);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public String b(Context context, com.tendcloud.tenddata.a aVar) {
        if (context != null) {
            try {
                if (!f2795b) {
                    h.iForDeveloper("SDK have not been initialized");
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return j.a(context);
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(Activity activity, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
            } else {
                if (f2804k) {
                    return;
                }
                a(activity);
                c.b(activity, aVar);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(Context context, String str, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (y.b(str)) {
                    str = activity.getLocalClassName();
                }
                if ((activity.getChangingConfigurations() & 128) == 128) {
                    f2797d = true;
                    return;
                }
            }
            a(context, str, 5, aVar);
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final int i6, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && !str.isEmpty()) {
                h.iForDeveloper("onCancelOrder called --> orderId: " + str + " ,amount: " + i6 + " ,currencyType: " + str2);
                if (str2 != null && str2.trim().length() == 3) {
                    y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.22
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", "iap");
                                aVar2.paraMap.put("action", "cancelOrder");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("orderId", str);
                                treeMap.put("amount", Integer.valueOf(i6));
                                treeMap.put("currencyType", str2);
                                aVar2.paraMap.put(cs.a.DATA, treeMap);
                                Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                h.eForDeveloper("currencyType length must be 3 likes CNY so so");
                return;
            }
            h.eForDeveloper("onCancelOrder: orderId could not be null or empty");
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(String str, com.tendcloud.tenddata.a aVar) {
        b(str, new HashMap(), aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(String str, af.ProfileType profileType, String str2, com.tendcloud.tenddata.a aVar) {
        b(str, profileType, str2, new HashMap(), aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final af.ProfileType profileType, final String str2, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        String str3;
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                h.eForDeveloper("onLogin: profileId could not be null or empty");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onLogin called --> profileId is ");
            sb.append(str);
            sb.append(" ，profile is ");
            sb.append(profileType);
            sb.append(" , name is ");
            sb.append(str2);
            if (map == null || map.isEmpty()) {
                str3 = "";
            } else {
                str3 = ", eventValue: " + map.toString();
            }
            sb.append(str3);
            h.iForDeveloper(sb.toString());
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", "account");
                        aVar2.paraMap.put("action", "login");
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("accountId", str);
                        af.ProfileType profileType2 = profileType;
                        if (profileType2 != null) {
                            aVar2.paraMap.put("type", profileType2.name());
                        }
                        String str4 = str2;
                        if (str4 != null) {
                            aVar2.paraMap.put("name", str4);
                        }
                        Map map2 = map;
                        if (map2 != null && !map2.isEmpty()) {
                            aVar2.paraMap.put("eventValue", map);
                        }
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final String str2, final int i6, final String str3, final String str4, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                h.iForDeveloper("onPay called --> profileId: " + str + " ,orderid: " + str2 + " ,amount: " + i6 + " ,currencyType: " + str3 + " ,payType: " + str4);
                if (str3 != null && str3.trim().length() == 3) {
                    y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.15
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("domain", "iap");
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("action", "recharge");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("accountId", str);
                                treeMap.put("orderId", str2);
                                treeMap.put("amount", Integer.valueOf(i6));
                                treeMap.put("currencyType", str3);
                                treeMap.put("payType", str4);
                                aVar2.paraMap.put(cs.a.DATA, treeMap);
                                Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                h.eForDeveloper("currencyType length must be 3 likes CNY so so");
                return;
            }
            h.eForDeveloper("onPay: profileId could not be null or empty");
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(String str, String str2, com.tendcloud.tenddata.a aVar) {
        b(str, str2, new HashMap(), aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final String str2, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        String str3;
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onFavorite called --> category: ");
            sb.append(str);
            sb.append(", content: ");
            sb.append(str2);
            if (map == null || map.isEmpty()) {
                str3 = "";
            } else {
                str3 = ", eventValue: " + map.toString();
            }
            sb.append(str3);
            h.iForDeveloper(sb.toString());
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.32
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "user");
                        aVar2.paraMap.put("action", "favorites");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("category", str);
                        treeMap.put("content", str2);
                        Map map2 = map;
                        if (map2 != null && !map2.isEmpty()) {
                            treeMap.put("eventValue", map);
                        }
                        aVar2.paraMap.put(cs.a.DATA, treeMap);
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        String str2;
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                h.eForDeveloper("onRegister: profileId could not be null or empty");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onRegister called --> profileId is ");
            sb.append(str);
            if (map == null || map.isEmpty()) {
                str2 = "";
            } else {
                str2 = ", eventValue: " + map.toString();
            }
            sb.append(str2);
            h.iForDeveloper(sb.toString());
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", "account");
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("action", "register");
                        aVar2.paraMap.put("accountId", str);
                        Map map2 = map;
                        if (map2 != null && !map2.isEmpty()) {
                            aVar2.paraMap.put("eventValue", map);
                        }
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public String c(Context context, com.tendcloud.tenddata.a aVar) {
        return ab.a(context, aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void c(final String str, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (TextUtils.isEmpty(str)) {
                h.eForDeveloper("onReceiveDeepLink: url could not be null or empty");
                return;
            }
            h.iForDeveloper("onReceiveDeepLink --> link: " + str);
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.29
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        cv.a().setDeepLink(str);
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 1);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "app");
                        aVar2.paraMap.put("action", "deeplink");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("link", str);
                        aVar2.paraMap.put(cs.a.DATA, treeMap);
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void c(String str, String str2, com.tendcloud.tenddata.a aVar) {
        c(str, str2, new HashMap(), aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void c(final String str, final String str2, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        String str3;
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("onShare called --> profileId: ");
            sb.append(str);
            sb.append(", content: ");
            sb.append(str2);
            if (map == null || map.isEmpty()) {
                str3 = "";
            } else {
                str3 = ", eventValue: " + map.toString();
            }
            sb.append(str3);
            h.iForDeveloper(sb.toString());
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.33
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "user");
                        aVar2.paraMap.put("action", "share");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("content", str2);
                        Map map2 = map;
                        if (map2 != null && !map2.isEmpty()) {
                            treeMap.put("eventValue", map);
                        }
                        aVar2.paraMap.put(cs.a.DATA, treeMap);
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void c(boolean z5) {
        try {
            ab.f2231e = z5;
            h.iForDeveloper(" setReportUncaughtExceptions: " + z5);
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public Context d() {
        try {
            return ab.f2233g;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public String d(Context context, com.tendcloud.tenddata.a aVar) {
        return ab.b(context, aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void d(final String str, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
                return;
            }
            h.iForDeveloper("onPunch called --> profileId: " + str + " punchId: " + str2);
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.35
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "user");
                        aVar2.paraMap.put("action", "punch");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("punchId", str2);
                        aVar2.paraMap.put(cs.a.DATA, treeMap);
                        Message.obtain(zz.c(), zz.f2799f, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public String e(Context context, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f2795b) {
                h.eForDeveloper("SDK have not been initialized");
            }
            return dh.a().c();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void e() {
        try {
            h.f2656a = false;
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void removeGlobalKV(String str) {
        if (!f2795b) {
            h.eForDeveloper("SDK have not been initialized");
            return;
        }
        if (str != null) {
            h.iForDeveloper("removeGlobalKV# key:" + str);
        }
        ab.f2230d.remove(str);
    }

    @Override // com.tendcloud.tenddata.ao
    public void setCustomDataSwitch(TalkingDataSharingFilter talkingDataSharingFilter) {
        ab.f2248v = talkingDataSharingFilter;
    }
}
