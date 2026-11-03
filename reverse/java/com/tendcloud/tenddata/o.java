package com.tendcloud.tenddata;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.tendcloud.tenddata.ab;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    static final String f2707a = "www.talkingdata.net";

    /* renamed from: b, reason: collision with root package name */
    static final int f2708b = 80;

    /* renamed from: c, reason: collision with root package name */
    private static TelephonyManager f2709c = null;

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<String, String> f2710d;

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f2711e;

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f2712f;

    /* renamed from: g, reason: collision with root package name */
    private static a f2713g = null;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f2714h = false;

    /* renamed from: i, reason: collision with root package name */
    private static final long f2715i = 300000;

    /* renamed from: j, reason: collision with root package name */
    private static long f2716j;

    /* renamed from: k, reason: collision with root package name */
    private static volatile boolean f2717k;

    /* renamed from: l, reason: collision with root package name */
    private static volatile boolean f2718l;

    /* renamed from: m, reason: collision with root package name */
    private static JSONArray f2719m;

    /* renamed from: n, reason: collision with root package name */
    private static JSONArray f2720n;

    /* renamed from: o, reason: collision with root package name */
    private static volatile boolean f2721o;

    /* renamed from: p, reason: collision with root package name */
    private static volatile boolean f2722p;

    /* renamed from: q, reason: collision with root package name */
    private static volatile boolean f2723q;

    /* renamed from: r, reason: collision with root package name */
    private static JSONArray f2724r;

    /* renamed from: s, reason: collision with root package name */
    private static JSONArray f2725s;

    /* renamed from: t, reason: collision with root package name */
    private static JSONArray f2726t;

    /* renamed from: u, reason: collision with root package name */
    private static boolean f2727u;

    /* renamed from: v, reason: collision with root package name */
    private static b f2728v;

    /* renamed from: w, reason: collision with root package name */
    private static JSONArray f2729w;

    /* renamed from: x, reason: collision with root package name */
    private static volatile boolean f2730x;

    public static class a implements Runnable {
        private Context context;
        private Object lock;
        private BroadcastReceiver receiver;

        public a(Context context, Object obj, BroadcastReceiver broadcastReceiver) {
            this.context = context;
            this.lock = obj;
            this.receiver = broadcastReceiver;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            BroadcastReceiver broadcastReceiver;
            try {
                synchronized (this.lock) {
                    try {
                        this.lock.notifyAll();
                        context = this.context;
                        broadcastReceiver = this.receiver;
                    } catch (Throwable unused) {
                        context = this.context;
                        broadcastReceiver = this.receiver;
                    }
                    context.unregisterReceiver(broadcastReceiver);
                }
            } catch (Throwable unused2) {
            }
        }

        public void unRegisterReceiver() {
            BroadcastReceiver broadcastReceiver = this.receiver;
            if (broadcastReceiver != null) {
                try {
                    this.context.unregisterReceiver(broadcastReceiver);
                } catch (Throwable unused) {
                }
            }
        }
    }

    static class b extends BroadcastReceiver {
        private CountDownLatch latch = new CountDownLatch(1);

        b() {
        }

        void await() {
            try {
                this.latch.await(2000L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                h.eForInternal(th);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!"android.net.wifi.SCAN_RESULTS".equals(intent.getAction()) || this.latch.getCount() <= 0) {
                return;
            }
            this.latch.countDown();
        }

        void reset() {
            this.latch = new CountDownLatch(1);
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f2710d = hashMap;
        f2711e = new String[]{"UNKNOWN", "GPRS", "EDGE", "UMTS", "CDMA", "EVDO_0", "EVDO_A", "1xRTT", "HSDPA", "HSUPA", "HSPA", "IDEN", "EVDO_B", "LTE", "EHRPD", "HSPAP"};
        f2712f = new String[]{"NONE", "GSM", "CDMA", "SIP"};
        f2713g = null;
        if (ab.f2233g != null) {
            String[] a6 = a();
            hashMap.put("ip", a6[0]);
            hashMap.put("ipv6", a6[1]);
            hashMap.put("cell_ip", a6[2]);
            hashMap.put("cell_ipv6", a6[3]);
            hashMap.put("bssid", q(ab.f2233g));
            hashMap.put("ssid", w(ab.f2233g));
        }
        f2714h = false;
        f2716j = -300000L;
        f2717k = false;
        f2718l = false;
        f2719m = new JSONArray();
        f2721o = false;
        f2722p = false;
        f2723q = false;
        f2724r = new JSONArray();
        f2727u = false;
        f2728v = new b();
        f2729w = new JSONArray();
        f2730x = false;
    }

    public static JSONArray A(Context context) {
        if (f2729w.length() > 0 || f2730x) {
            return f2729w;
        }
        if (!y.b(context, "android.permission.READ_PHONE_STATE")) {
            return f2729w;
        }
        D(context);
        return f2729w;
    }

    public static int B(Context context) {
        int phoneCount;
        try {
            if (!y.a(23)) {
                return A(context).length();
            }
            if (f2709c == null) {
                a(context);
            }
            phoneCount = f2709c.getPhoneCount();
            return phoneCount;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static Map<String, Object> C(Context context) {
        DatagramSocket datagramSocket;
        if (d(context)) {
            try {
                String str = f2710d.get("ip");
                if (str != null) {
                    String substring = str.substring(0, str.lastIndexOf(46) + 1);
                    DatagramPacket datagramPacket = new DatagramPacket(new byte[0], 0, 0);
                    datagramSocket = new DatagramSocket();
                    for (int i6 = 1; i6 < 255; i6++) {
                        try {
                            try {
                                datagramPacket.setAddress(InetAddress.getByName(substring + i6));
                                datagramSocket.send(datagramPacket);
                                if (i6 == 125) {
                                    datagramSocket.close();
                                    datagramSocket = new DatagramSocket();
                                }
                            } catch (Throwable unused) {
                            }
                        } catch (Throwable unused2) {
                            if (datagramSocket != null) {
                                try {
                                    datagramSocket.close();
                                } catch (Throwable unused3) {
                                }
                            }
                            return null;
                        }
                    }
                    datagramSocket.close();
                } else {
                    datagramSocket = null;
                }
                Thread.sleep(5000L);
                Map<String, Object> c6 = c();
                if (datagramSocket != null) {
                    try {
                        datagramSocket.close();
                    } catch (Throwable unused4) {
                    }
                }
                return c6;
            } catch (Throwable unused5) {
                datagramSocket = null;
            }
        }
        return null;
    }

    private static void D(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            ArrayList arrayList = new ArrayList();
            if (y.a(22)) {
                SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
                try {
                    JSONObject a6 = a(context, subscriptionManager, 0);
                    if (y.a(26)) {
                        try {
                            a6.put("imei", l.a("imei1"));
                            a6.put("imei5", l.b(0));
                        } catch (Throwable unused) {
                        }
                        try {
                            a6.put("meid", l.a("meid1"));
                            a6.put("meid5", l.c(0));
                        } catch (Throwable unused2) {
                        }
                    } else {
                        a6.put("imei", l.a("imei1"));
                        a6.put("imei5", l.b(0));
                    }
                    if (a6.length() > 0) {
                        f2729w.put(a6);
                    }
                } catch (Throwable unused3) {
                }
                JSONObject a7 = a(context, subscriptionManager, 1);
                if (telephonyManager != null) {
                    if (y.a(26)) {
                        try {
                            a7.put("imei", l.a("imei2"));
                            a7.put("imei5", l.b(1));
                        } catch (Throwable unused4) {
                        }
                        try {
                            a7.put("meid", l.a("meid2"));
                            a7.put("meid5", l.c(1));
                        } catch (Throwable unused5) {
                        }
                    } else {
                        a7.put("imei", l.a("imei2"));
                        a7.put("imei5", l.b(1));
                    }
                }
                if (a7.length() > 0) {
                    f2729w.put(a7);
                }
            } else {
                String deviceId = telephonyManager != null ? telephonyManager.getDeviceId() : "";
                if (c(deviceId.trim()).booleanValue()) {
                    arrayList.add(deviceId.trim());
                    JSONObject a8 = a(telephonyManager, deviceId);
                    if (a8 != null) {
                        f2729w.put(a8);
                    }
                }
                try {
                    TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone1");
                    String deviceId2 = telephonyManager2 != null ? telephonyManager2.getDeviceId() : "";
                    if (deviceId2 != null && c(deviceId2).booleanValue() && !arrayList.contains(deviceId2)) {
                        arrayList.add(deviceId2);
                        JSONObject a9 = a(telephonyManager2, deviceId2);
                        if (a9 != null) {
                            f2729w.put(a9);
                        }
                    }
                } catch (Throwable unused6) {
                }
                try {
                    TelephonyManager telephonyManager3 = (TelephonyManager) context.getSystemService("phone2");
                    String deviceId3 = telephonyManager3 != null ? telephonyManager3.getDeviceId() : "";
                    if (deviceId3 != null && c(deviceId3).booleanValue() && !arrayList.contains(deviceId3)) {
                        arrayList.add(deviceId3);
                        JSONObject a10 = a(telephonyManager3, deviceId3);
                        if (a10 != null) {
                            f2729w.put(a10);
                        }
                    }
                } catch (Throwable unused7) {
                }
                JSONArray H = H(context);
                JSONArray G = G(context);
                if (G != null) {
                    H = G;
                }
                JSONArray F = F(context);
                if (F != null) {
                    H = F;
                }
                JSONArray E = E(context);
                if (E != null) {
                    H = E;
                }
                if (H != null && H.length() > 0) {
                    for (int i6 = 0; i6 < H.length(); i6++) {
                        JSONObject jSONObject = H.getJSONObject(i6);
                        String string = jSONObject.getString("imei");
                        if (!arrayList.contains(string)) {
                            arrayList.add(string);
                            f2729w.put(jSONObject);
                        }
                    }
                }
            }
        } catch (Throwable unused8) {
        }
        f2730x = true;
    }

    private static JSONArray E(Context context) {
        int i6;
        int i7;
        try {
            JSONArray jSONArray = new JSONArray();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Class<?> cls = Class.forName("com.android.internal.telephony.Phone");
            try {
                Field field = cls.getField("GEMINI_SIM_1");
                field.setAccessible(true);
                i6 = (Integer) field.get(null);
                Field field2 = cls.getField("GEMINI_SIM_2");
                field2.setAccessible(true);
                i7 = (Integer) field2.get(null);
            } catch (Throwable unused) {
                i6 = 0;
                i7 = 1;
            }
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getDeviceIdGemini", Integer.TYPE);
            if (telephonyManager != null && declaredMethod != null) {
                String trim = ((String) declaredMethod.invoke(telephonyManager, i6)).trim();
                String trim2 = ((String) declaredMethod.invoke(telephonyManager, i7)).trim();
                if (c(trim).booleanValue()) {
                    jSONArray.put(a(TelephonyManager.class, telephonyManager, i6, trim, "Gemini"));
                }
                if (c(trim2).booleanValue()) {
                    jSONArray.put(a(TelephonyManager.class, telephonyManager, i7, trim2, "Gemini"));
                }
                return jSONArray;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    private static JSONArray F(Context context) {
        int i6;
        int i7;
        JSONObject a6;
        JSONObject a7;
        try {
            JSONArray jSONArray = new JSONArray();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            Class<?> cls = Class.forName("com.android.internal.telephony.Phone");
            try {
                Field field = cls.getField("GEMINI_SIM_1");
                field.setAccessible(true);
                i6 = (Integer) field.get(null);
                Field field2 = cls.getField("GEMINI_SIM_2");
                field2.setAccessible(true);
                i7 = (Integer) field2.get(null);
            } catch (Throwable unused) {
                i6 = 0;
                i7 = 1;
            }
            Method method = TelephonyManager.class.getMethod("getDefault", Integer.TYPE);
            TelephonyManager telephonyManager2 = (TelephonyManager) method.invoke(telephonyManager, i6);
            TelephonyManager telephonyManager3 = (TelephonyManager) method.invoke(telephonyManager, i7);
            String trim = telephonyManager2.getDeviceId().trim();
            String trim2 = telephonyManager3.getDeviceId().trim();
            if (c(trim).booleanValue() && (a7 = a(telephonyManager2, trim)) != null) {
                jSONArray.put(a7);
            }
            if (c(trim2).booleanValue() && (a6 = a(telephonyManager3, trim2)) != null) {
                jSONArray.put(a6);
            }
            return jSONArray;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static JSONArray G(Context context) {
        JSONObject a6;
        JSONObject a7;
        try {
            JSONArray jSONArray = new JSONArray();
            Class<?> cls = Class.forName("com.android.internal.telephony.PhoneFactory");
            String str = (String) cls.getMethod("getServiceName", String.class, Integer.TYPE).invoke(cls, "phone", 1);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String trim = telephonyManager.getDeviceId().trim();
            TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService(str);
            String trim2 = telephonyManager2.getDeviceId().trim();
            if (c(trim).booleanValue() && (a7 = a(telephonyManager, trim)) != null) {
                jSONArray.put(a7);
            }
            if (c(trim2).booleanValue() && (a6 = a(telephonyManager2, trim2)) != null) {
                jSONArray.put(a6);
            }
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static JSONArray H(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            Class<?> cls = Class.forName("android.telephony.MSimTelephonyManager");
            Object systemService = context.getSystemService("phone_msim");
            Method method = cls.getMethod("getDeviceId", Integer.TYPE);
            String trim = ((String) method.invoke(systemService, 0)).trim();
            String trim2 = ((String) method.invoke(systemService, 1)).trim();
            if (c(trim).booleanValue()) {
                jSONArray.put(a(cls, systemService, 0, trim, ""));
            }
            if (c(trim2).booleanValue()) {
                jSONArray.put(a(cls, systemService, 1, trim2, ""));
            }
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(int i6) {
        if (i6 >= 0) {
            String[] strArr = f2711e;
            if (i6 < strArr.length) {
                return strArr[i6];
            }
        }
        return String.valueOf(i6);
    }

    public static String a(String str) {
        return f2710d.get(str);
    }

    public static JSONArray a(Context context, boolean z5) {
        CdmaCellLocation cdmaCellLocation;
        if (context == null) {
            try {
                context = ab.f2233g;
                if (context == null) {
                    return null;
                }
            } catch (Throwable th) {
                bq.postSDKError(th);
                return null;
            }
        }
        if (f2719m.length() <= 0 && !f2717k) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", n(context));
            jSONObject.put("mcc", o(context));
            jSONObject.put("operator", s(context));
            jSONObject.put("country", r(context));
            if (y.b(context, "android.permission.ACCESS_COARSE_LOCATION") || y.b(context, "android.permission.ACCESS_FINE_LOCATION")) {
                if (f2709c == null) {
                    a(context);
                }
                if ((y.f2772c || z5) && !ab.Q) {
                    CellLocation cellLocation = f2709c.getCellLocation();
                    if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        if (gsmCellLocation != null) {
                            jSONObject.put("systemId", gsmCellLocation.getLac());
                            jSONObject.put("networkId", gsmCellLocation.getCid());
                            if (y.a(9)) {
                                jSONObject.put("basestationId", gsmCellLocation.getPsc());
                            }
                        }
                    } else if ((cellLocation instanceof CdmaCellLocation) && (cdmaCellLocation = (CdmaCellLocation) cellLocation) != null) {
                        jSONObject.put("systemId", cdmaCellLocation.getSystemId());
                        jSONObject.put("networkId", cdmaCellLocation.getNetworkId());
                        jSONObject.put("basestationId", cdmaCellLocation.getBaseStationId());
                        jSONObject.put("location", a(cdmaCellLocation.getBaseStationLatitude(), cdmaCellLocation.getBaseStationLongitude()));
                    }
                }
            }
            f2717k = true;
            f2719m.put(jSONObject);
            return f2719m;
        }
        return f2719m;
    }

    public static JSONArray a(ArrayList arrayList, int i6) {
        try {
            Collections.sort(arrayList, new Comparator<JSONObject>() { // from class: com.tendcloud.tenddata.o.4
                @Override // java.util.Comparator
                public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                    try {
                        return jSONObject2.getInt("level") - jSONObject.getInt("level");
                    } catch (Throwable unused) {
                        return 0;
                    }
                }
            });
            if (arrayList.size() <= i6) {
                i6 = arrayList.size();
            }
            return new JSONArray((Collection) arrayList.subList(0, i6));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static JSONArray a(BitSet bitSet) {
        if (bitSet == null || bitSet.cardinality() < 1) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i6 = 0;
        while (true) {
            int nextSetBit = bitSet.nextSetBit(i6);
            if (nextSetBit < 0) {
                return jSONArray;
            }
            jSONArray.put(nextSetBit);
            i6 = nextSetBit + 1;
        }
    }

    public static JSONArray a(JSONArray jSONArray, int i6) {
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                arrayList.add(jSONArray.optJSONObject(i7));
            }
            Collections.sort(arrayList, new Comparator<JSONObject>() { // from class: com.tendcloud.tenddata.o.2
                @Override // java.util.Comparator
                public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                    try {
                        return jSONObject2.getInt("asuLevel") - jSONObject.getInt("asuLevel");
                    } catch (Throwable unused) {
                        return 0;
                    }
                }
            });
            if (arrayList.size() <= i6) {
                i6 = arrayList.size();
            }
            return new JSONArray((Collection) arrayList.subList(0, i6));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject a(int i6, int i7) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lat", i6);
            jSONObject.put("lng", i7);
            jSONObject.put("unit", "qd");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
    
        r4 = r4.getActiveSubscriptionInfoForSimSlotIndex(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static org.json.JSONObject a(android.content.Context r3, android.telephony.SubscriptionManager r4, int r5) {
        /*
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r0 = 22
            boolean r0 = com.tendcloud.tenddata.y.a(r0)     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L73
            android.telephony.SubscriptionInfo r4 = com.tendcloud.tenddata.h0.a(r4, r5)     // Catch: java.lang.Throwable -> L73
            if (r4 == 0) goto L73
            java.lang.String r5 = com.tendcloud.tenddata.i0.a(r4)     // Catch: java.lang.Throwable -> L73
            java.lang.String r0 = ""
            if (r5 != 0) goto L1d
            r5 = r0
            goto L21
        L1d:
            java.lang.String r5 = com.tendcloud.tenddata.i0.a(r4)     // Catch: java.lang.Throwable -> L73
        L21:
            java.lang.String r1 = "simSerialNumber"
            r3.put(r1, r5)     // Catch: java.lang.Throwable -> L73
            java.lang.String r5 = "simOperator"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L73
            int r2 = com.tendcloud.tenddata.j0.a(r4)     // Catch: java.lang.Throwable -> L73
            r1.append(r2)     // Catch: java.lang.Throwable -> L73
            java.lang.String r2 = "0"
            r1.append(r2)     // Catch: java.lang.Throwable -> L73
            int r2 = com.tendcloud.tenddata.k0.a(r4)     // Catch: java.lang.Throwable -> L73
            r1.append(r2)     // Catch: java.lang.Throwable -> L73
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L73
            r3.put(r5, r1)     // Catch: java.lang.Throwable -> L73
            java.lang.String r5 = "simOperatorName"
            java.lang.CharSequence r1 = com.tendcloud.tenddata.l0.a(r4)     // Catch: java.lang.Throwable -> L73
            if (r1 != 0) goto L51
            r1 = r0
            goto L55
        L51:
            java.lang.CharSequence r1 = com.tendcloud.tenddata.l0.a(r4)     // Catch: java.lang.Throwable -> L73
        L55:
            r3.put(r5, r1)     // Catch: java.lang.Throwable -> L73
            java.lang.String r5 = "simCountryIso"
            java.lang.String r1 = com.tendcloud.tenddata.m0.a(r4)     // Catch: java.lang.Throwable -> L73
            if (r1 != 0) goto L61
            goto L65
        L61:
            java.lang.String r0 = com.tendcloud.tenddata.m0.a(r4)     // Catch: java.lang.Throwable -> L73
        L65:
            r3.put(r5, r0)     // Catch: java.lang.Throwable -> L73
            java.lang.String r4 = "subscriberId"
            java.lang.String r5 = "imsi"
            java.lang.String r5 = com.tendcloud.tenddata.l.a(r5)     // Catch: java.lang.Throwable -> L73
            r3.put(r4, r5)     // Catch: java.lang.Throwable -> L73
        L73:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.o.a(android.content.Context, android.telephony.SubscriptionManager, int):org.json.JSONObject");
    }

    private static JSONObject a(TelephonyManager telephonyManager, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("imei", str.trim());
            jSONObject.put("imei5", y.c(str.trim()));
            String str2 = "";
            jSONObject.put("subscriberId", telephonyManager.getSubscriberId() == null ? "" : telephonyManager.getSubscriberId());
            jSONObject.put("simSerialNumber", telephonyManager.getSimSerialNumber() == null ? "" : telephonyManager.getSimSerialNumber());
            jSONObject.put("dataState", telephonyManager.getDataState());
            jSONObject.put("networkType", a(telephonyManager.getNetworkType()));
            jSONObject.put("networkOperator", telephonyManager.getNetworkOperator());
            jSONObject.put("phoneType", c(telephonyManager.getPhoneType()));
            jSONObject.put("simOperator", telephonyManager.getSimOperator() == null ? "" : telephonyManager.getSimOperator());
            jSONObject.put("simOperatorName", telephonyManager.getSimOperatorName() == null ? "" : telephonyManager.getSimOperatorName());
            if (telephonyManager.getSimCountryIso() != null) {
                str2 = telephonyManager.getSimCountryIso();
            }
            jSONObject.put("simCountryIso", str2);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static JSONObject a(Class<?> cls, Object obj, Integer num, String str, String str2) {
        String str3 = "";
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("imei", str);
        jSONObject.put("imei5", y.c(str));
        try {
            Method method = cls.getMethod("getSubscriberId" + str2, Integer.TYPE);
            jSONObject.put("subscriberId", method.invoke(obj, num) == null ? "" : ((String) method.invoke(obj, num)).trim());
        } catch (Throwable unused) {
        }
        try {
            Method method2 = cls.getMethod("getSimSerialNumber" + str2, Integer.TYPE);
            jSONObject.put("simSerialNumber", method2.invoke(obj, num) == null ? "" : ((String) method2.invoke(obj, num)).trim());
        } catch (Throwable unused2) {
        }
        try {
            jSONObject.put("dataState", (Integer) cls.getMethod("getDataState" + str2, Integer.TYPE).invoke(obj, num));
        } catch (Throwable unused3) {
        }
        try {
            jSONObject.put("networkType", a(((Integer) cls.getMethod("getNetworkType" + str2, Integer.TYPE).invoke(obj, num)).intValue()));
        } catch (Throwable unused4) {
        }
        try {
            jSONObject.put("networkOperator", (String) cls.getMethod("getNetworkOperator" + str2, Integer.TYPE).invoke(obj, num));
        } catch (Throwable unused5) {
        }
        try {
            jSONObject.put("phoneType", c(((Integer) cls.getMethod("getPhoneType" + str2, Integer.TYPE).invoke(obj, num)).intValue()));
        } catch (Throwable unused6) {
        }
        try {
            Method method3 = cls.getMethod("getSimOperator" + str2, Integer.TYPE);
            jSONObject.put("simOperator", method3.invoke(obj, num) == null ? "" : ((String) method3.invoke(obj, num)).trim());
        } catch (Throwable unused7) {
        }
        try {
            Method method4 = cls.getMethod("getSimOperatorName" + str2, Integer.TYPE);
            if (method4.invoke(obj, num) != null) {
                str3 = ((String) method4.invoke(obj, num)).trim();
            }
            jSONObject.put("simOperatorName", str3);
        } catch (Throwable unused8) {
        }
        return jSONObject;
    }

    static void a(Context context) {
        try {
            f2709c = (TelephonyManager) context.getSystemService("phone");
        } catch (Throwable unused) {
        }
    }

    private static void a(String[] strArr) {
        Enumeration<InetAddress> inetAddresses;
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface nextElement = networkInterfaces.nextElement();
            if (!nextElement.isLoopback()) {
                String lowerCase = nextElement.getName().toLowerCase();
                if (!lowerCase.startsWith("wlan") && !lowerCase.startsWith("eth") && !lowerCase.startsWith("dummy") && (inetAddresses = nextElement.getInetAddresses()) != null && inetAddresses.hasMoreElements()) {
                    arrayList.add(Collections.list(inetAddresses));
                }
            }
        }
        if (arrayList.size() == 0) {
            return;
        }
        Collections.sort(arrayList, new Comparator<List<InetAddress>>() { // from class: com.tendcloud.tenddata.o.1
            @Override // java.util.Comparator
            public int compare(List<InetAddress> list, List<InetAddress> list2) {
                return list.size() - list2.size();
            }
        });
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            for (InetAddress inetAddress : (List) arrayList.get(size)) {
                if (!inetAddress.isLinkLocalAddress() && !inetAddress.isLoopbackAddress()) {
                    if (inetAddress instanceof Inet4Address) {
                        strArr[2] = inetAddress.getHostAddress();
                    } else if (inetAddress instanceof Inet6Address) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (!hostAddress.contains("ff:fe")) {
                            strArr[3] = hostAddress;
                        }
                    }
                }
            }
            if (strArr[2] != null || strArr[3] != null) {
                return;
            }
        }
    }

    public static String[] a() {
        String[] strArr = {null, null, null, null};
        if (ab.S) {
            return strArr;
        }
        boolean i6 = i(ab.f2233g);
        boolean j6 = j(ab.f2233g);
        if (!i6 && !j6) {
            h.iForInternal("no-network");
            return strArr;
        }
        try {
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
        if (!i6) {
            if (j6) {
                a(strArr);
            }
            return strArr;
        }
        b(strArr);
        return strArr;
    }

    private static Boolean b(String str) {
        try {
            char charAt = str.length() > 0 ? str.charAt(0) : '0';
            Boolean bool = Boolean.TRUE;
            for (int i6 = 0; i6 < str.length(); i6++) {
                if (charAt != str.charAt(i6)) {
                    return Boolean.FALSE;
                }
            }
            return bool;
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }

    private static String b(int i6) {
        switch (i6) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case ab.b.API_TYPE_INDUSTRY /* 17 */:
                return "3G";
            case 13:
            case 18:
                return "4G";
            default:
                return "UNKNOWN";
        }
    }

    public static JSONArray b(JSONArray jSONArray, int i6) {
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                arrayList.add(jSONArray.optJSONObject(i7));
            }
            Collections.sort(arrayList, new Comparator<JSONObject>() { // from class: com.tendcloud.tenddata.o.3
                @Override // java.util.Comparator
                public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                    try {
                        return jSONObject.getInt("networkId") - jSONObject2.getInt("networkId");
                    } catch (Throwable unused) {
                        return 0;
                    }
                }
            });
            if (arrayList.size() <= i6) {
                i6 = arrayList.size();
            }
            return new JSONArray((Collection) arrayList.subList(0, i6));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void b(String[] strArr) {
        Enumeration<InetAddress> inetAddresses;
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces == null) {
            return;
        }
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface nextElement = networkInterfaces.nextElement();
            if (nextElement.getName().toLowerCase().startsWith("wlan") && (inetAddresses = nextElement.getInetAddresses()) != null) {
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    if (nextElement2 != null && !nextElement2.isLoopbackAddress()) {
                        String hostAddress = nextElement2.getHostAddress();
                        if (!TextUtils.isEmpty(hostAddress)) {
                            if (nextElement2 instanceof Inet4Address) {
                                strArr[0] = hostAddress;
                            } else if (nextElement2 instanceof Inet6Address) {
                                int indexOf = hostAddress.indexOf("%");
                                if (indexOf > 0) {
                                    hostAddress = hostAddress.substring(0, indexOf);
                                }
                                strArr[1] = hostAddress;
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean b() {
        try {
            return y.a(11) ? !TextUtils.isEmpty(System.getProperty("http.proxyHost")) : !TextUtils.isEmpty(Proxy.getDefaultHost());
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x008d, code lost:
    
        if (r7 == null) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(android.content.Context r7) {
        /*
            java.lang.String r0 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r0 = com.tendcloud.tenddata.y.b(r7, r0)     // Catch: java.lang.Throwable -> L97
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L52
            java.lang.String r0 = "connectivity"
            java.lang.Object r7 = r7.getSystemService(r0)     // Catch: java.lang.Throwable -> L97
            android.net.ConnectivityManager r7 = (android.net.ConnectivityManager) r7     // Catch: java.lang.Throwable -> L97
            if (r7 == 0) goto L52
            r0 = 29
            boolean r0 = com.tendcloud.tenddata.y.a(r0)     // Catch: java.lang.Throwable -> L97
            if (r0 == 0) goto L33
            android.net.Network r0 = b0.e.a(r7)     // Catch: java.lang.Throwable -> L97
            if (r0 == 0) goto L52
            android.net.NetworkCapabilities r7 = r7.getNetworkCapabilities(r0)     // Catch: java.lang.Throwable -> L97
            if (r7 == 0) goto L31
            r0 = 12
            boolean r7 = r7.hasCapability(r0)     // Catch: java.lang.Throwable -> L97
            if (r7 == 0) goto L31
            goto L32
        L31:
            r1 = 0
        L32:
            return r1
        L33:
            android.net.NetworkInfo r0 = r7.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L97
            if (r0 == 0) goto L3e
            boolean r7 = r0.isConnected()     // Catch: java.lang.Throwable -> L97
            return r7
        L3e:
            android.net.NetworkInfo r7 = r7.getNetworkInfo(r2)     // Catch: java.lang.Throwable -> L97
            if (r7 == 0) goto L51
            android.net.NetworkInfo$State r7 = r7.getState()     // Catch: java.lang.Throwable -> L97
            android.net.NetworkInfo$State r0 = android.net.NetworkInfo.State.UNKNOWN     // Catch: java.lang.Throwable -> L97
            boolean r7 = r7.equals(r0)     // Catch: java.lang.Throwable -> L97
            if (r7 == 0) goto L51
            goto L52
        L51:
            return r2
        L52:
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L97
            long r5 = com.tendcloud.tenddata.o.f2716j     // Catch: java.lang.Throwable -> L97
            long r3 = r3 - r5
            r5 = 300000(0x493e0, double:1.482197E-318)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L9b
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L97
            com.tendcloud.tenddata.o.f2716j = r3     // Catch: java.lang.Throwable -> L97
            r7 = 0
            boolean r0 = b()     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L7b
            java.net.Socket r0 = new java.net.Socket     // Catch: java.lang.Throwable -> L8b
            java.lang.String r3 = android.net.Proxy.getDefaultHost()     // Catch: java.lang.Throwable -> L8b
            int r4 = android.net.Proxy.getDefaultPort()     // Catch: java.lang.Throwable -> L8b
            r0.<init>(r3, r4)     // Catch: java.lang.Throwable -> L8b
            goto L84
        L7b:
            java.net.Socket r0 = new java.net.Socket     // Catch: java.lang.Throwable -> L8b
            java.lang.String r3 = "www.talkingdata.net"
            r4 = 80
            r0.<init>(r3, r4)     // Catch: java.lang.Throwable -> L8b
        L84:
            r7 = r0
            com.tendcloud.tenddata.o.f2714h = r1     // Catch: java.lang.Throwable -> L8b
        L87:
            r7.close()     // Catch: java.lang.Throwable -> L9b
            goto L9b
        L8b:
            com.tendcloud.tenddata.o.f2714h = r2     // Catch: java.lang.Throwable -> L90
            if (r7 == 0) goto L9b
            goto L87
        L90:
            r0 = move-exception
            if (r7 == 0) goto L96
            r7.close()     // Catch: java.lang.Throwable -> L96
        L96:
            throw r0     // Catch: java.lang.Throwable -> L97
        L97:
            r7 = move-exception
            com.tendcloud.tenddata.bq.postSDKError(r7)
        L9b:
            boolean r7 = com.tendcloud.tenddata.o.f2714h
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.o.b(android.content.Context):boolean");
    }

    private static Boolean c(String str) {
        try {
            Integer valueOf = Integer.valueOf(str.length());
            if (valueOf.intValue() > 10 && valueOf.intValue() < 20 && !b(str.trim()).booleanValue()) {
                return Boolean.TRUE;
            }
        } catch (Throwable unused) {
        }
        return Boolean.FALSE;
    }

    private static String c(int i6) {
        if (i6 >= 0) {
            String[] strArr = f2712f;
            if (i6 < strArr.length) {
                return strArr[i6];
            }
        }
        return String.valueOf(i6);
    }

    private static String c(String[] strArr) {
        if (strArr != null && strArr.length >= 6) {
            int i6 = 0;
            int i7 = 0;
            while (true) {
                if (i7 >= strArr.length) {
                    break;
                }
                if ("lladdr".equalsIgnoreCase(strArr[i7])) {
                    i6 = i7 + 1;
                    break;
                }
                i7++;
            }
            if (i6 > 0 && i6 < strArr.length) {
                String str = strArr[i6];
                if (str.matches("([\\da-fA-F]{2}:){5}([\\da-fA-F]{2}){1}") && !str.equals("00:00:00:00:00:00")) {
                    return str;
                }
            }
        }
        return null;
    }

    private static Map<String, Object> c() {
        try {
            if (y.a(29)) {
                return d();
            }
            HashMap hashMap = new HashMap();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/net/arp")));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return hashMap;
                }
                String[] split = readLine.split("[ ]+");
                if (!split[0].matches("IP")) {
                    String str = split[0];
                    String str2 = split[3];
                    if (!hashMap.containsKey(str) && !str2.equals("00:00:00:00:00:00")) {
                        hashMap.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (!y.b(context, "android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0074, code lost:
    
        if (r1 == null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.Map<java.lang.String, java.lang.Object> d() {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = "ip n"
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L6a
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L67
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L67
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L67
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L67
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L67
            java.util.HashMap r3 = new java.util.HashMap     // Catch: java.lang.Throwable -> L63
            r3.<init>()     // Catch: java.lang.Throwable -> L63
        L1e:
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L61
            if (r0 == 0) goto L57
            java.lang.String r4 = "lladdr"
            int r4 = r0.indexOf(r4)     // Catch: java.lang.Throwable -> L61
            r5 = -1
            if (r4 <= r5) goto L1e
            java.lang.String r4 = " "
            java.lang.String[] r0 = r0.split(r4)     // Catch: java.lang.Throwable -> L61
            if (r0 == 0) goto L1e
            int r4 = r0.length     // Catch: java.lang.Throwable -> L61
            r5 = 5
            if (r4 <= r5) goto L1e
            r4 = 0
            r4 = r0[r4]     // Catch: java.lang.Throwable -> L61
            java.lang.String r0 = c(r0)     // Catch: java.lang.Throwable -> L61
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L61
            if (r5 != 0) goto L1e
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L61
            if (r5 == 0) goto L4d
            goto L1e
        L4d:
            boolean r5 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L61
            if (r5 != 0) goto L1e
            r3.put(r4, r0)     // Catch: java.lang.Throwable -> L61
            goto L1e
        L57:
            r1.waitFor()     // Catch: java.lang.Throwable -> L61
            r2.close()     // Catch: java.lang.Throwable -> L5d
        L5d:
            r1.destroy()
            goto L77
        L61:
            goto L65
        L63:
            r3 = r0
        L65:
            r0 = r2
            goto L6d
        L67:
            r3 = r0
            goto L6d
        L6a:
            r1 = r0
            r3 = r1
        L6d:
            if (r0 == 0) goto L74
            r0.close()     // Catch: java.lang.Throwable -> L73
            goto L74
        L73:
        L74:
            if (r1 == 0) goto L77
            goto L5d
        L77:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.o.d():java.util.Map");
    }

    public static boolean d(Context context) {
        try {
            if (i(context)) {
                return true;
            }
            return ((WifiManager) context.getSystemService("wifi")).isWifiEnabled();
        } catch (Throwable th) {
            bq.postSDKError(th);
            return false;
        }
    }

    public static boolean e(Context context) {
        try {
            if (f2709c == null) {
                a(context);
            }
            return f2709c.getSimState() == 5;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean f(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean g(Context context) {
        try {
            return y.a(17) ? Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1 : Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean h(Context context) {
        try {
            if (f2709c == null) {
                a(context);
            }
            int simState = f2709c.getSimState();
            return (1 == simState || simState == 0) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean i(Context context) {
        ConnectivityManager connectivityManager;
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        if (context == null && (context = ab.f2233g) == null) {
            return false;
        }
        try {
            if (!y.b(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return false;
            }
            if (y.a(29)) {
                activeNetwork = connectivityManager.getActiveNetwork();
                return (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasTransport(1)) ? false : true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && 1 == activeNetworkInfo.getType() && activeNetworkInfo.isConnected();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean j(Context context) {
        if (context == null && (context = ab.f2233g) == null) {
            return false;
        }
        try {
            if (f2709c == null) {
                a(context);
            }
            return f2709c.getDataState() == 2;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String k(Context context) {
        return !b(context) ? "OFFLINE" : i(context) ? "WIFI" : a(n(context));
    }

    public static String l(Context context) {
        return !b(context) ? "offline" : i(context) ? "wifi" : "cellular";
    }

    public static String m(Context context) {
        return (!(context == null && (context = ab.f2233g) == null) && b(context)) ? i(context) ? "WIFI" : b(n(context)) : "UNKNOWN";
    }

    public static int n(Context context) {
        if (context == null) {
            try {
                context = ab.f2233g;
                if (context == null) {
                    return 0;
                }
            } catch (Throwable unused) {
                return 0;
            }
        }
        if (f2709c == null) {
            a(context);
        }
        return f2709c.getNetworkType();
    }

    public static String o(Context context) {
        try {
            if (f2709c == null) {
                a(context);
            }
            return f2709c.getNetworkOperator();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String p(Context context) {
        try {
            if (f2709c == null) {
                a(context);
            }
            return f2709c.getSimOperator();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String q(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        if (ab.R || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null || !y.b(context, "android.permission.ACCESS_WIFI_STATE") || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return null;
        }
        return connectionInfo.getBSSID();
    }

    public static String r(Context context) {
        try {
            if (f2709c == null) {
                a(context);
            }
            return f2709c.getNetworkCountryIso();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String s(Context context) {
        try {
            if (f2709c == null) {
                a(context);
            }
            return f2709c.getNetworkOperatorName();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String t(Context context) {
        try {
            if (f2709c == null) {
                a(context);
            }
            return f2709c.getSimOperatorName();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void tryGetDoubleSimInfoReCheck(Context context) {
        try {
            if (f2729w.length() <= 0 && !f2730x) {
                D(context);
            }
        } catch (Throwable th) {
            h.eForInternal(th);
        }
    }

    public static JSONArray u(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "wifi");
            jSONObject.put("available", d(context));
            jSONObject.put("connected", i(context));
            jSONObject.put("current", y(context));
            jSONObject.put("scannable", z(context));
            jSONObject.put("configured", x(context));
            jSONArray.put(jSONObject);
        } catch (Throwable unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "cellular");
            jSONObject2.put("available", e(context));
            jSONObject2.put("connected", j(context));
            jSONObject2.put("current", a(context, false));
            jSONObject2.put("scannable", v(context));
            jSONArray.put(jSONObject2);
        } catch (Throwable unused2) {
        }
        if (jSONArray.length() > 0) {
            return jSONArray;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x015b A[Catch: all -> 0x0190, TryCatch #0 {all -> 0x0190, blocks: (B:36:0x0068, B:38:0x0083, B:41:0x015b, B:43:0x0160, B:45:0x0167, B:47:0x016c, B:49:0x0173, B:51:0x017a, B:52:0x018a, B:55:0x00a3, B:57:0x00a7, B:58:0x0106, B:60:0x010a, B:62:0x012c, B:64:0x0130), top: B:35:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0160 A[Catch: all -> 0x0190, TryCatch #0 {all -> 0x0190, blocks: (B:36:0x0068, B:38:0x0083, B:41:0x015b, B:43:0x0160, B:45:0x0167, B:47:0x016c, B:49:0x0173, B:51:0x017a, B:52:0x018a, B:55:0x00a3, B:57:0x00a7, B:58:0x0106, B:60:0x010a, B:62:0x012c, B:64:0x0130), top: B:35:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0167 A[Catch: all -> 0x0190, TryCatch #0 {all -> 0x0190, blocks: (B:36:0x0068, B:38:0x0083, B:41:0x015b, B:43:0x0160, B:45:0x0167, B:47:0x016c, B:49:0x0173, B:51:0x017a, B:52:0x018a, B:55:0x00a3, B:57:0x00a7, B:58:0x0106, B:60:0x010a, B:62:0x012c, B:64:0x0130), top: B:35:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x016c A[Catch: all -> 0x0190, TryCatch #0 {all -> 0x0190, blocks: (B:36:0x0068, B:38:0x0083, B:41:0x015b, B:43:0x0160, B:45:0x0167, B:47:0x016c, B:49:0x0173, B:51:0x017a, B:52:0x018a, B:55:0x00a3, B:57:0x00a7, B:58:0x0106, B:60:0x010a, B:62:0x012c, B:64:0x0130), top: B:35:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0173 A[Catch: all -> 0x0190, TryCatch #0 {all -> 0x0190, blocks: (B:36:0x0068, B:38:0x0083, B:41:0x015b, B:43:0x0160, B:45:0x0167, B:47:0x016c, B:49:0x0173, B:51:0x017a, B:52:0x018a, B:55:0x00a3, B:57:0x00a7, B:58:0x0106, B:60:0x010a, B:62:0x012c, B:64:0x0130), top: B:35:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x017a A[Catch: all -> 0x0190, TryCatch #0 {all -> 0x0190, blocks: (B:36:0x0068, B:38:0x0083, B:41:0x015b, B:43:0x0160, B:45:0x0167, B:47:0x016c, B:49:0x0173, B:51:0x017a, B:52:0x018a, B:55:0x00a3, B:57:0x00a7, B:58:0x0106, B:60:0x010a, B:62:0x012c, B:64:0x0130), top: B:35:0x0068 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONArray v(android.content.Context r16) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.o.v(android.content.Context):org.json.JSONArray");
    }

    public static String w(Context context) {
        WifiInfo connectionInfo;
        if (ab.R) {
            return null;
        }
        try {
            if (!y.b(context, "android.permission.ACCESS_WIFI_STATE")) {
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager.isWifiEnabled() && i(context) && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                return connectionInfo.getSSID();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONArray x(Context context) {
        List<WifiConfiguration> configuredNetworks;
        if (ab.R) {
            return null;
        }
        JSONArray jSONArray = f2725s;
        if (jSONArray != null && (jSONArray.length() > 0 || f2722p)) {
            return f2725s;
        }
        try {
            if (y.b(context, "android.permission.ACCESS_WIFI_STATE") && (configuredNetworks = ((WifiManager) context.getSystemService("wifi")).getConfiguredNetworks()) != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (WifiConfiguration wifiConfiguration : configuredNetworks) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("networkId", wifiConfiguration.networkId);
                        jSONObject.put("priority", wifiConfiguration.priority);
                        jSONObject.put("name", wifiConfiguration.SSID);
                        jSONObject.put("id", wifiConfiguration.BSSID);
                        jSONArray2.put(jSONObject);
                    } catch (Throwable unused) {
                    }
                }
                f2722p = true;
                JSONArray b6 = b(jSONArray2, 30);
                f2725s = b6;
                return b6;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    public static JSONArray y(Context context) {
        WifiInfo connectionInfo;
        if (ab.R) {
            return null;
        }
        if (f2724r.length() > 0 || f2721o) {
            return f2724r;
        }
        try {
            if (y.b(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.isWifiEnabled() && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                    String a6 = a("bssid");
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("name", a("ssid"));
                        jSONObject.put("id", a6);
                        jSONObject.put("level", connectionInfo.getRssi());
                        jSONObject.put("hidden", connectionInfo.getHiddenSSID());
                        jSONObject.put("ip", connectionInfo.getIpAddress());
                        jSONObject.put("speed", connectionInfo.getLinkSpeed());
                        jSONObject.put("networkId", connectionInfo.getNetworkId());
                        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
                        if (dhcpInfo != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("dns1", dhcpInfo.dns1);
                            jSONObject2.put("dns2", dhcpInfo.dns2);
                            jSONObject2.put("gw", dhcpInfo.gateway);
                            jSONObject2.put("ip", dhcpInfo.ipAddress);
                            jSONObject2.put("mask", dhcpInfo.netmask);
                            jSONObject2.put("server", dhcpInfo.serverAddress);
                            jSONObject2.put("leaseDuration", dhcpInfo.leaseDuration);
                            jSONObject.put("dhcp", jSONObject2);
                        }
                    } catch (Throwable unused) {
                    }
                    f2721o = true;
                    f2724r.put(jSONObject);
                    return f2724r;
                }
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    public static synchronized JSONArray z(Context context) {
        synchronized (o.class) {
            if (!y.f2772c) {
                return null;
            }
            if (ab.R) {
                return null;
            }
            JSONArray jSONArray = f2726t;
            if (jSONArray != null && (jSONArray.length() > 0 || f2723q)) {
                return f2726t;
            }
            try {
                if (y.b(context, "android.permission.ACCESS_WIFI_STATE")) {
                    WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                    if (wifiManager.isWifiEnabled() || wifiManager.isScanAlwaysAvailable()) {
                        if (y.b(context, "android.permission.CHANGE_WIFI_STATE") && !f2727u) {
                            try {
                                context.registerReceiver(f2728v, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                            } catch (Throwable unused) {
                            }
                            f2727u = true;
                        }
                        wifiManager.startScan();
                        f2728v.await();
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        f2728v.reset();
                        if (scanResults != null) {
                            ArrayList arrayList = new ArrayList();
                            for (ScanResult scanResult : scanResults) {
                                if (scanResult.level >= -85) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("id", scanResult.BSSID);
                                        jSONObject.put("name", scanResult.SSID);
                                        jSONObject.put("level", scanResult.level);
                                        jSONObject.put("freq", scanResult.frequency);
                                        if (y.a(17)) {
                                            jSONObject.put("ts", scanResult.timestamp);
                                            jSONObject.put("scanTs", (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (scanResult.timestamp / 1000));
                                        }
                                        arrayList.add(jSONObject);
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                            f2723q = true;
                            JSONArray a6 = a(arrayList, 20);
                            f2726t = a6;
                            return a6;
                        }
                    }
                }
            } catch (Throwable unused3) {
            }
            return null;
        }
    }
}
