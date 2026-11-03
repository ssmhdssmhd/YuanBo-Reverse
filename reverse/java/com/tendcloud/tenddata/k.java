package com.tendcloud.tenddata;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.nfc.cardemulation.CardEmulation;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2691a = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq";

    /* renamed from: b, reason: collision with root package name */
    public static final String f2692b = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq";

    /* renamed from: c, reason: collision with root package name */
    public static final String f2693c = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";

    /* renamed from: d, reason: collision with root package name */
    private static final int f2694d = 3600000;

    /* renamed from: i, reason: collision with root package name */
    private static int[] f2699i;

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f2695e = Pattern.compile("([0-9]+)");

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f2696f = Pattern.compile("\\s*([0-9]+)");

    /* renamed from: g, reason: collision with root package name */
    private static List<PackageInfo> f2697g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private static boolean f2698h = false;

    /* renamed from: j, reason: collision with root package name */
    private static final FileFilter f2700j = new FileFilter() { // from class: com.tendcloud.tenddata.k.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (file != null) {
                try {
                    String name = file.getName();
                    if (name != null && name.startsWith("cpu")) {
                        for (int i6 = 3; i6 < name.length(); i6++) {
                            if (name.charAt(i6) < '0' || name.charAt(i6) > '9') {
                                return false;
                            }
                        }
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
            return false;
        }
    };

    /* renamed from: k, reason: collision with root package name */
    private static BroadcastReceiver f2701k = new BroadcastReceiver() { // from class: com.tendcloud.tenddata.k.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }
    };

    public static class a {
        static final int HCE_ENABLED = 3;
        static final int NFC_ENABLED = 2;
        static final int NOT_ENALBED = 1;
        static final int UNKNOWN = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0045, code lost:
    
        if (r5 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.String r5) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = -1
            if (r0 == 0) goto L8
            return r1
        L8:
            r0 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3c
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L3c
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L38
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = r5.readLine()     // Catch: java.lang.Throwable -> L36
            int r3 = r0.length()     // Catch: java.lang.Throwable -> L36
            r4 = 104857600(0x6400000, float:3.6111186E-35)
            if (r3 > r4) goto L2e
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L36
            int r1 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L36
            r2.close()     // Catch: java.lang.Throwable -> L2a
        L2a:
            r5.close()     // Catch: java.lang.Throwable -> L48
            goto L48
        L2e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L36
            java.lang.String r3 = "Input stream more than 100 MB size limit"
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L36
            throw r0     // Catch: java.lang.Throwable -> L36
        L36:
            goto L3a
        L38:
            r5 = r0
        L3a:
            r0 = r2
            goto L3e
        L3c:
            r5 = r0
        L3e:
            if (r0 == 0) goto L45
            r0.close()     // Catch: java.lang.Throwable -> L44
            goto L45
        L44:
        L45:
            if (r5 == 0) goto L48
            goto L2a
        L48:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.k.a(java.lang.String):int");
    }

    public static String a() {
        return ab.f2236j + Build.VERSION.RELEASE;
    }

    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    private static List<PackageInfo> a(Context context, int i6) {
        ArrayList arrayList = new ArrayList();
        try {
            return d(context);
        } catch (Throwable unused) {
            PackageManager packageManager = context.getPackageManager();
            BufferedReader bufferedReader = null;
            try {
                try {
                    Process exec = Runtime.getRuntime().exec("pm list packages");
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            arrayList.add(packageManager.getPackageInfo(readLine.substring(readLine.indexOf(58) + 1), i6));
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            try {
                                bq.postSDKError(th);
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                return arrayList;
                            } catch (Throwable th2) {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable unused2) {
                                    }
                                }
                                throw th2;
                            }
                        }
                    }
                    exec.waitFor();
                    bufferedReader2.close();
                } catch (Throwable unused3) {
                    return arrayList;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            return arrayList;
        }
    }

    public static JSONObject a(Context context, JSONObject jSONObject) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                int i6 = displayMetrics.widthPixels;
                int i7 = displayMetrics.heightPixels;
                jSONObject.put("pixel", Math.min(i6, i7) + "*" + Math.max(i6, i7) + "*" + displayMetrics.densityDpi);
                jSONObject.put("densityDpi", displayMetrics.densityDpi);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static boolean a(Context context) {
        try {
            if (y.a(17)) {
                return Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static int[] a(int[] iArr) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            iArr[0] = (statFs.getBlockCount() * (statFs.getBlockSize() / 512)) / 2;
            iArr[1] = (statFs.getAvailableBlocks() * (statFs.getBlockSize() / 512)) / 2;
        } catch (Throwable unused) {
        }
        try {
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            iArr[2] = (statFs2.getBlockCount() * (statFs2.getBlockSize() / 512)) / 2;
            iArr[3] = (statFs2.getAvailableBlocks() * (statFs2.getBlockSize() / 512)) / 2;
        } catch (Throwable unused2) {
        }
        return iArr;
    }

    private static int b(String str) {
        try {
            Matcher matcher = f2695e.matcher(str);
            return Integer.parseInt(matcher.find() ? matcher.toMatchResult().group(0) : "");
        } catch (Exception e6) {
            bq.postSDKError(e6);
            return 0;
        }
    }

    private static String b(String str, String str2) {
        try {
            String lowerCase = str.toLowerCase();
            if (!lowerCase.startsWith("unknown") && !lowerCase.startsWith("alps") && !lowerCase.startsWith("android") && !lowerCase.startsWith("sprd") && !lowerCase.startsWith("spreadtrum") && !lowerCase.startsWith("rockchip") && !lowerCase.startsWith("wondermedia") && !lowerCase.startsWith("mtk") && !lowerCase.startsWith("mt65") && !lowerCase.startsWith("nvidia") && !lowerCase.startsWith("brcm") && !lowerCase.startsWith("marvell")) {
                if (!str2.toLowerCase().contains(lowerCase)) {
                    return str;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static JSONObject b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("nfcStatus", c(context));
            jSONObject.put("appsRegistedHCE", t(context));
            jSONObject.put("ssMode", u(context));
            return jSONObject;
        } catch (Throwable th) {
            bq.postSDKError(th);
            return null;
        }
    }

    public static JSONObject b(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put("brightness", s(context));
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static boolean b() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Object invoke = cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
            if (invoke == null) {
                return false;
            }
            return "harmony".equalsIgnoreCase(invoke.toString());
        } catch (Throwable th) {
            h.iForInternal("SA.HasHarmonyOS", th.getMessage());
            return false;
        }
    }

    public static int c(Context context) {
        NfcAdapter defaultAdapter;
        if (context == null) {
            return 0;
        }
        try {
            if (!y.a(10) || (defaultAdapter = ((NfcManager) context.getSystemService("nfc")).getDefaultAdapter()) == null) {
                return 0;
            }
            if (!defaultAdapter.isEnabled()) {
                return 1;
            }
            if (y.a(19)) {
                if (context.getPackageManager().hasSystemFeature("android.hardware.nfc.hce")) {
                    return 3;
                }
            }
            return 2;
        } catch (Throwable th) {
            bq.postSDKError(th);
            return 0;
        }
    }

    public static String c() {
        return a("hw_sc.build.platform.version", (String) null);
    }

    private static String c(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            FileReader fileReader = new FileReader(str);
            char[] cArr = new char[1024];
            BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
            while (true) {
                int read = bufferedReader.read(cArr, 0, 1024);
                if (-1 == read) {
                    break;
                }
                stringBuffer.append(new String(cArr, 0, read));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    public static String d() {
        InputStream inputStream;
        BufferedReader bufferedReader;
        try {
            Process exec = Runtime.getRuntime().exec("uname -r");
            inputStream = exec.waitFor() == 0 ? exec.getInputStream() : exec.getErrorStream();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 512);
                try {
                    String readLine = bufferedReader.readLine();
                    inputStream.close();
                    bufferedReader.close();
                    exec.destroy();
                    try {
                        inputStream.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    return readLine;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        th.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                        return null;
                    } finally {
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            bufferedReader = null;
        }
    }

    public static synchronized List<PackageInfo> d(Context context) {
        synchronized (k.class) {
            if (ab.T) {
                return null;
            }
            if (f2698h) {
                return f2697g;
            }
            try {
                f2697g = context.getPackageManager().getInstalledPackages(5);
                f2698h = true;
            } catch (Throwable unused) {
            }
            return f2697g;
        }
    }

    public static String e() {
        try {
            return Build.ID;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String e(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics == null) {
                return "";
            }
            int i6 = displayMetrics.widthPixels;
            int i7 = displayMetrics.heightPixels;
            return Math.min(i6, i7) + "*" + Math.max(i6, i7) + "*" + displayMetrics.densityDpi;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int f(Context context) {
        if (context == null) {
            try {
                context = ab.f2233g;
                if (context == null) {
                    return 0;
                }
            } catch (Throwable th) {
                bq.postSDKError(th);
                return 0;
            }
        }
        Intent registerReceiver = context.registerReceiver(f2701k, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i6 = registerReceiver != null ? registerReceiver.getExtras().getInt("level", 0) : 0;
        context.unregisterReceiver(f2701k);
        return i6;
    }

    public static String f() {
        return Build.MANUFACTURER.trim();
    }

    public static int g(Context context) {
        if (context == null) {
            try {
                context = ab.f2233g;
                if (context == null) {
                    return 0;
                }
            } catch (Throwable th) {
                bq.postSDKError(th);
                return 0;
            }
        }
        Intent registerReceiver = context.registerReceiver(f2701k, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("status", 0) : 0;
        context.unregisterReceiver(f2701k);
        return intExtra;
    }

    public static String g() {
        return Build.BRAND.trim();
    }

    public static String h() {
        return Build.MODEL.trim();
    }

    public static JSONObject h(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mobile", o(context));
            jSONObject.put("wifi", k(context));
            jSONObject.put("gps", j(context));
            jSONObject.put("telephone", n(context));
            jSONObject.put("nfc", m(context));
            jSONObject.put("bluetooth", l(context));
            jSONObject.put("otg", i(context));
            return jSONObject;
        } catch (Throwable th) {
            bq.postSDKError(th);
            return null;
        }
    }

    public static int i() {
        return TimeZone.getDefault().getRawOffset() / f2694d;
    }

    public static boolean i(Context context) {
        if (context == null && (context = ab.f2233g) == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.hasSystemFeature("android.hardware.usb.host");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String j() {
        try {
            String trim = Build.MODEL.trim();
            String b6 = b(Build.MANUFACTURER.trim(), trim);
            if (TextUtils.isEmpty(b6)) {
                b6 = b(Build.BRAND.trim(), trim);
            }
            if (b6 == null) {
                b6 = "";
            }
            return b6 + ":" + trim;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean j(Context context) {
        if (context == null && (context = ab.f2233g) == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.hasSystemFeature("android.hardware.location.gps");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String k() {
        try {
            return y.a(14) ? Build.getRadioVersion() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static boolean k(Context context) {
        if (context == null && (context = ab.f2233g) == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.hasSystemFeature("android.hardware.wifi");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int l() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean l(Context context) {
        if (context == null && (context = ab.f2233g) == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.hasSystemFeature("android.hardware.bluetooth");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String m() {
        return Build.VERSION.RELEASE;
    }

    public static boolean m(Context context) {
        if (context == null && (context = ab.f2233g) == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.hasSystemFeature("android.hardware.nfc");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String n() {
        return Locale.getDefault().getLanguage();
    }

    public static boolean n(Context context) {
        if (context == null && (context = ab.f2233g) == null) {
            return false;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getPhoneType() != 0;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String o() {
        return Locale.getDefault().getCountry();
    }

    public static boolean o(Context context) {
        if (context == null && (context = ab.f2233g) == null) {
            return false;
        }
        try {
            return context.getPackageManager().hasSystemFeature("android.hardware.telephony");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int p(Context context) {
        if (context == null) {
            try {
                context = ab.f2233g;
                if (context == null) {
                    return -1;
                }
            } catch (Throwable unused) {
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.widthPixels;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0058 A[Catch: all -> 0x0091, TryCatch #1 {all -> 0x0091, blocks: (B:7:0x0013, B:21:0x003c, B:23:0x004b, B:25:0x0058, B:27:0x005f, B:29:0x0068, B:31:0x0078, B:33:0x0082, B:36:0x0085, B:38:0x0088, B:43:0x0044), top: B:6:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] p() {
        /*
            r0 = 4
            java.lang.String[] r1 = new java.lang.String[r0]
            r2 = 0
            r3 = 0
        L5:
            if (r3 >= r0) goto Le
            java.lang.String r4 = ""
            r1[r3] = r4
            int r3 = r3 + 1
            goto L5
        Le:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L91
            java.lang.String r4 = "/proc/cpuinfo"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L91
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L91
            r5 = 1024(0x400, float:1.435E-42)
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L91
        L21:
            r5 = 1
            java.lang.String r6 = r4.readLine()     // Catch: java.lang.Throwable -> L44
            if (r6 == 0) goto L3c
            r0.add(r6)     // Catch: java.lang.Throwable -> L44
            int r6 = r0.size()     // Catch: java.lang.Throwable -> L44
            r7 = 104857600(0x6400000, float:3.6111186E-35)
            if (r6 > r7) goto L34
            goto L21
        L34:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L44
            java.lang.String r7 = "List size more than 104857600 limit"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L44
            throw r6     // Catch: java.lang.Throwable -> L44
        L3c:
            r4.close()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L91
            r3.close()     // Catch: java.io.IOException -> L42 java.lang.Throwable -> L91
        L42:
            r3 = 1
            goto L4b
        L44:
            r4.close()     // Catch: java.io.IOException -> L4a java.lang.Throwable -> L91
            r3.close()     // Catch: java.io.IOException -> L4a java.lang.Throwable -> L91
        L4a:
            r3 = 0
        L4b:
            java.lang.String r4 = "Processor\\s*:\\s*(.*)"
            java.lang.String r6 = "CPU\\s*variant\\s*:\\s*0x(.*)"
            java.lang.String r7 = "Hardware\\s*:\\s*(.*)"
            java.lang.String[] r4 = new java.lang.String[]{r4, r6, r7}     // Catch: java.lang.Throwable -> L91
            r6 = 3
            if (r3 == 0) goto L88
            int r3 = r0.size()     // Catch: java.lang.Throwable -> L91
            r7 = 0
        L5d:
            if (r7 >= r6) goto L88
            r8 = r4[r7]     // Catch: java.lang.Throwable -> L91
            java.util.regex.Pattern r8 = java.util.regex.Pattern.compile(r8)     // Catch: java.lang.Throwable -> L91
            r9 = 0
        L66:
            if (r9 >= r3) goto L85
            java.lang.Object r10 = r0.get(r9)     // Catch: java.lang.Throwable -> L91
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L91
            java.util.regex.Matcher r10 = r8.matcher(r10)     // Catch: java.lang.Throwable -> L91
            boolean r11 = r10.find()     // Catch: java.lang.Throwable -> L91
            if (r11 == 0) goto L82
            java.util.regex.MatchResult r10 = r10.toMatchResult()     // Catch: java.lang.Throwable -> L91
            java.lang.String r10 = r10.group(r5)     // Catch: java.lang.Throwable -> L91
            r1[r7] = r10     // Catch: java.lang.Throwable -> L91
        L82:
            int r9 = r9 + 1
            goto L66
        L85:
            int r7 = r7 + 1
            goto L5d
        L88:
            java.lang.String r0 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"
            java.lang.String r0 = c(r0)     // Catch: java.lang.Throwable -> L91
            r1[r6] = r0     // Catch: java.lang.Throwable -> L91
            goto L95
        L91:
            r0 = move-exception
            com.tendcloud.tenddata.bq.postSDKError(r0)
        L95:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.k.p():java.lang.String[]");
    }

    public static int q(Context context) {
        if (context == null) {
            try {
                context = ab.f2233g;
                if (context == null) {
                    return -1;
                }
            } catch (Throwable unused) {
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.heightPixels;
        }
        return -1;
    }

    public static JSONObject q() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", p()[2]);
            jSONObject.put("coreNum", r());
            jSONObject.put("maxFreq", a(f2691a));
            jSONObject.put("minFreq", a(f2692b));
            jSONObject.put("curFreq", a(f2693c));
            return jSONObject;
        } catch (Throwable th) {
            bq.postSDKError(th);
            return null;
        }
    }

    public static int r() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(f2700j);
            if (listFiles != null) {
                return listFiles.length;
            }
            return 1;
        } catch (Throwable unused) {
            return 1;
        }
    }

    public static int r(Context context) {
        if (context == null) {
            try {
                context = ab.f2233g;
                if (context == null) {
                    return -1;
                }
            } catch (Throwable unused) {
            }
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            return displayMetrics.densityDpi;
        }
        return -1;
    }

    public static int s(Context context) {
        if (context == null && (context = ab.f2233g) == null) {
            return -1;
        }
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int[] s() {
        int[] iArr = {0, 0};
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                int blockSize = statFs.getBlockSize();
                int blockCount = statFs.getBlockCount();
                int availableBlocks = statFs.getAvailableBlocks();
                iArr[0] = (blockCount * (blockSize / 512)) / 2;
                iArr[1] = (availableBlocks * (blockSize / 512)) / 2;
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    private static JSONArray t(Context context) {
        ServiceInfo[] serviceInfoArr;
        if (!y.a(19)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            List<PackageInfo> a6 = a(context, 4);
            if (a6 != null) {
                for (PackageInfo packageInfo : a6) {
                    if (packageInfo != null && (serviceInfoArr = packageInfo.services) != null) {
                        int length = serviceInfoArr.length;
                        int i6 = 0;
                        while (true) {
                            if (i6 < length) {
                                ServiceInfo serviceInfo = serviceInfoArr[i6];
                                try {
                                    Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(serviceInfo.packageName, serviceInfo.name), 128).metaData;
                                    if (bundle != null && bundle.containsKey("android.nfc.cardemulation.host_apdu_service")) {
                                        jSONArray.put(packageInfo.packageName);
                                        break;
                                    }
                                } catch (Throwable unused) {
                                }
                                i6++;
                            }
                        }
                    }
                }
            }
            return jSONArray;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int[] t() {
        int[] iArr = {0, 0};
        int[] iArr2 = new int[4];
        for (int i6 = 0; i6 < 4; i6++) {
            iArr2[i6] = 0;
        }
        try {
            FileReader fileReader = new FileReader("/proc/meminfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
            for (int i7 = 0; i7 < 4; i7++) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine.length() > 104857600) {
                            throw new RuntimeException("Input stream more than 100 MB size limit");
                        }
                        iArr2[i7] = b(readLine);
                    } catch (IOException unused) {
                        bufferedReader.close();
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                            fileReader.close();
                        } catch (IOException unused2) {
                        }
                        throw th;
                    }
                } catch (IOException unused3) {
                }
            }
            iArr[0] = iArr2[0];
            iArr[1] = iArr2[1] + iArr2[2] + iArr2[3];
            bufferedReader.close();
            fileReader.close();
        } catch (Throwable th2) {
            bq.postSDKError(th2);
        }
        return iArr;
    }

    private static int u(Context context) {
        NfcAdapter defaultAdapter;
        try {
            if (!y.a(19) || (defaultAdapter = ((NfcManager) context.getSystemService("nfc")).getDefaultAdapter()) == null) {
                return -1;
            }
            return CardEmulation.getInstance(defaultAdapter).getSelectionModeForCategory("payment");
        } catch (Throwable th) {
            bq.postSDKError(th);
            return -1;
        }
    }

    public static int[] u() {
        int[] iArr = new int[4];
        int[] iArr2 = f2699i;
        if (iArr2 == null || iArr2.length <= 0) {
            f2699i = a(iArr);
        }
        return f2699i;
    }

    public static int v() {
        try {
            Matcher matcher = f2696f.matcher(c("/sys/class/power_supply/battery/full_bat"));
            if (matcher.find()) {
                return Integer.parseInt(matcher.toMatchResult().group(0));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }
}
