package com.tendcloud.tenddata;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    private static TelephonyManager f2702a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f2703b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f2704c = false;

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<String, String> f2705d;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f2705d = hashMap;
        try {
            Context context = ab.f2233g;
            if (context != null) {
                f2702a = (TelephonyManager) context.getSystemService("phone");
                hashMap.put("imei1", a(ab.f2233g, 0));
                hashMap.put("meid1", a(0));
                if (o.B(ab.f2233g) == 2) {
                    hashMap.put("imei2", a(ab.f2233g, 1));
                    hashMap.put("meid2", a(1));
                }
                hashMap.put("imsi", g(ab.f2233g));
                hashMap.put("androidId", e(ab.f2233g));
                hashMap.put("mac", d(ab.f2233g));
                hashMap.put("ethMac", c());
                hashMap.put("dummy0", b());
                hashMap.put("serialNo", c(ab.f2233g));
            }
        } catch (Throwable unused) {
        }
    }

    private l() {
    }

    static String a(int i6) {
        String meid;
        if (y.a(26)) {
            try {
                meid = f2702a.getMeid(i6);
                return meid;
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static String a(Context context) {
        try {
            String a6 = a("mac");
            if (!y.b(a6)) {
                a6 = String.valueOf(Long.parseLong(a6.replaceAll(":", ""), 16));
            }
            String a7 = a("androidId");
            String a8 = a("imeis");
            String a9 = a("imsi");
            String a10 = a("simId");
            String a11 = j.a(context);
            String d6 = d();
            String a12 = a("serialNo");
            StringBuilder sb = new StringBuilder(170);
            sb.append(2);
            sb.append("|");
            sb.append(a6);
            sb.append("|");
            sb.append(a7);
            sb.append("|");
            sb.append(a8);
            sb.append("|");
            sb.append(a9);
            sb.append("|");
            sb.append(a10);
            sb.append("|");
            sb.append(a11);
            sb.append("|");
            sb.append(d6);
            sb.append("|");
            sb.append(a12);
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(Context context, int i6) {
        String imei;
        String deviceId;
        if (y.b(context, "android.permission.READ_PHONE_STATE")) {
            if (!y.a(26)) {
                if (!y.a(23)) {
                    return f2702a.getDeviceId();
                }
                deviceId = f2702a.getDeviceId(i6);
                return deviceId;
            }
            try {
                imei = f2702a.getImei(i6);
                return imei;
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static String a(String str) {
        return f2705d.get(str);
    }

    public static void a() {
        try {
            if (y.c(ab.f2233g, "android.permission.READ_PHONE_STATE")) {
                o.tryGetDoubleSimInfoReCheck(ab.f2233g);
                dm.b().a();
            }
        } catch (Throwable unused) {
        }
    }

    public static String b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.getName().toLowerCase().startsWith("dummy")) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        String hostAddress = inetAddresses.nextElement().getHostAddress();
                        if (hostAddress.contains("dummy")) {
                            return hostAddress.split("%")[0];
                        }
                    }
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(int i6) {
        try {
            String a6 = a(i6 == 1 ? "imei2" : "imei1");
            if (y.b(a6)) {
                return null;
            }
            return y.c(a6);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(final Context context) {
        try {
            if (!f2704c) {
                w.f2761a.execute(new Runnable() { // from class: com.tendcloud.tenddata.l.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            boolean unused = l.f2704c = true;
                            String unused2 = l.f2703b = (String) Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context), new Object[0]);
                        } catch (Throwable unused3) {
                        }
                    }
                });
            }
            return f2703b;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c() {
        String str;
        Throwable th;
        try {
            str = f();
            try {
                if (y.j(str)) {
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                bq.postSDKError(th);
                return str;
            }
        } catch (Throwable th3) {
            str = null;
            th = th3;
        }
        return str;
    }

    public static String c(int i6) {
        try {
            String a6 = a(i6 == 1 ? "meid2" : "meid1");
            if (y.b(a6)) {
                return null;
            }
            return y.c(a6);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(Context context) {
        String serial;
        try {
            if (y.a(9) && y.b(26)) {
                return Build.SERIAL;
            }
            if (!y.a(26) || !y.b(context, "android.permission.READ_PHONE_STATE")) {
                return null;
            }
            serial = Build.getSerial();
            return serial;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String d() {
        try {
            return dh.a().c();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String d(Context context) {
        String str = null;
        try {
            String e6 = y.a(23) ? e() : j(context);
            try {
                if (y.j(e6)) {
                    return null;
                }
                return e6;
            } catch (Throwable th) {
                str = e6;
                th = th;
                bq.postSDKError(th);
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String e() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b6 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b6)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString().toUpperCase().trim();
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String e(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String f() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("eth0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b6 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b6)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString().toUpperCase().trim();
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String f(Context context) {
        HashMap<String, String> hashMap;
        String str;
        try {
            if (o.B(context) == 2) {
                hashMap = f2705d;
                str = "imei2";
            } else {
                hashMap = f2705d;
                str = "imei1";
            }
            return hashMap.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String g(Context context) {
        try {
            if (y.b(context, "android.permission.READ_PHONE_STATE")) {
                return f2702a.getSubscriberId();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String h(Context context) {
        try {
            if (!y.b(context, "android.permission.READ_PHONE_STATE")) {
                return null;
            }
            String str = "";
            if (o.B(context) == 2) {
                try {
                    HashMap<String, String> hashMap = f2705d;
                    hashMap.get("imei1");
                    str = hashMap.get("imei2");
                } catch (Exception unused) {
                }
            }
            return y.b(str) ? f2705d.get("imei1") : str;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static String i(Context context) {
        try {
            if (y.b(context, "android.permission.READ_PHONE_STATE")) {
                return f2702a.getSimSerialNumber();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String j(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        String macAddress;
        try {
            if (!y.b(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null || !wifiManager.isWifiEnabled() || (connectionInfo = wifiManager.getConnectionInfo()) == null || (macAddress = connectionInfo.getMacAddress()) == null) {
                return null;
            }
            return macAddress.toUpperCase().trim();
        } catch (Throwable unused) {
            return null;
        }
    }
}
