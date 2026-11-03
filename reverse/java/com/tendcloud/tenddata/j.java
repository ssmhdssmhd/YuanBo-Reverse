package com.tendcloud.tenddata;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Environment;
import android.preference.PreferenceManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2683a = "pref.deviceid.key";

    /* renamed from: d, reason: collision with root package name */
    private static final String f2686d = ".tcookieid";

    /* renamed from: e, reason: collision with root package name */
    private static final String f2687e = ".tlocalcookieid";

    /* renamed from: f, reason: collision with root package name */
    private static volatile String f2688f;

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f2684b = Pattern.compile("[0-4][0-9a-f]{24,32}");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f2685c = Pattern.compile("[0-4][0-9a-f]{32}");

    /* renamed from: g, reason: collision with root package name */
    private static String f2689g = "TD_Custom_Dev_Id";

    /* renamed from: h, reason: collision with root package name */
    private static String f2690h = null;

    public static synchronized String a(Context context) {
        String str;
        synchronized (j.class) {
            if (f2688f == null) {
                f2688f = d(context);
            }
            str = f2688f;
        }
        return str;
    }

    static String a(Context context, boolean z5, String str) {
        int checkSelfPermission;
        if (y.a(23)) {
            checkSelfPermission = context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
            if (checkSelfPermission != 0) {
                return null;
            }
        }
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return "";
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (!z5) {
            str = str + c(context);
        }
        String a6 = a(new File(externalStorageDirectory, str));
        if (!y.b(a6)) {
            return a6;
        }
        return a(new File(Environment.getExternalStorageDirectory(), ".tid" + c(context)));
    }

    private static String a(File file) {
        FileInputStream fileInputStream;
        try {
            if (file.exists() && file.canRead()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[128];
                        String str = new String(bArr, 0, fileInputStream.read(bArr));
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused) {
                        }
                        return str;
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                }
            }
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Throwable unused4) {
        }
        return null;
    }

    static String a(String str) {
        String str2 = null;
        try {
            File[] listFiles = new File("/").listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file : listFiles) {
                    if (file.isDirectory() && !"/sdcard".equals(file.getAbsolutePath())) {
                        if (file.canWrite()) {
                            str2 = a(new File(file, str));
                            if (!y.b(str2)) {
                                return str2;
                            }
                        }
                        if (file.listFiles() != null) {
                            for (File file2 : file.listFiles()) {
                                if (file2.isDirectory()) {
                                    str2 = a(new File(file2, str));
                                    if (!y.b(str2)) {
                                        return str2;
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return str2;
    }

    private static void a(Context context, String str) {
        try {
            File[] listFiles = new File("/").listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file : listFiles) {
                    if (file.isDirectory() && !"/sdcard".equals(file.getAbsolutePath())) {
                        if (file.canWrite()) {
                            if (!new File(file, f2686d + c(context)).exists()) {
                                a(new File(file, f2686d), str);
                            }
                        }
                        if (file.listFiles() != null) {
                            for (File file2 : file.listFiles()) {
                                if (file2.isDirectory() && file2.canWrite()) {
                                    if (!new File(file2, f2686d + c(context)).exists()) {
                                        a(new File(file2, f2686d), str);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, String str, boolean z5) {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            String str2 = f2687e;
            if (!z5) {
                str2 = f2687e + c(context);
            }
            a(new File(externalStorageDirectory, str2), str);
        } catch (Throwable unused) {
        }
    }

    private static void a(File file, String str) {
        FileOutputStream fileOutputStream = null;
        if (file.exists() || !y.b(ab.f2233g, "android.permission.WRITE_EXTERNAL_STORAGE") || ((y.a(ab.f2233g, 29) && y.a(29)) || file.createNewFile())) {
            if (file.canWrite()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(str.getBytes());
                    if (y.a(9)) {
                        Class<?> cls = file.getClass();
                        Class<?> cls2 = Boolean.TYPE;
                        cls.getMethod("setReadable", cls2, cls2).invoke(file, Boolean.TRUE, Boolean.FALSE);
                    } else {
                        Runtime.getRuntime().exec("chmod 444 " + file.getAbsolutePath());
                    }
                    fileOutputStream = fileOutputStream2;
                } catch (Throwable unused) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream == null) {
                        return;
                    }
                    fileOutputStream.close();
                }
            }
            if (fileOutputStream == null) {
                return;
            }
            try {
                fileOutputStream.close();
            } catch (Throwable unused2) {
            }
        }
    }

    static boolean a() {
        boolean z5;
        if (y.a(9)) {
            z5 = Environment.isExternalStorageRemovable();
            return !z5;
        }
        z5 = true;
        return !z5;
    }

    private static String b() {
        String a6 = l.a("mac");
        if (y.b(a6)) {
            a6 = l.a("androidId");
        }
        if (y.b(a6)) {
            a6 = UUID.randomUUID().toString();
        }
        return "4" + y.c(3 + a6);
    }

    static String b(Context context) {
        try {
            String b6 = s.b(context, "tdid", f2683a, (String) null);
            return y.b(b6) ? PreferenceManager.getDefaultSharedPreferences(context).getString(f2683a, null) : b6;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void b(Context context, String str) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("tdid", 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(f2683a, str);
                edit.apply();
            }
        } catch (Throwable unused) {
        }
    }

    static String c(Context context) {
        if (f2690h == null) {
            try {
                Sensor[] sensorArr = new Sensor[64];
                for (Sensor sensor : ((SensorManager) context.getSystemService("sensor")).getSensorList(-1)) {
                    if (sensor.getType() < 64 && sensor.getType() >= 0) {
                        sensorArr[sensor.getType()] = sensor;
                    }
                }
                StringBuffer stringBuffer = new StringBuffer();
                for (int i6 = 0; i6 < 64; i6++) {
                    if (sensorArr[i6] != null) {
                        stringBuffer.append(i6);
                        stringBuffer.append('.');
                        stringBuffer.append(sensorArr[i6].getVendor());
                        stringBuffer.append('-');
                        stringBuffer.append(sensorArr[i6].getName());
                        stringBuffer.append('-');
                        stringBuffer.append(sensorArr[i6].getVersion());
                        stringBuffer.append('\n');
                    }
                }
                f2690h = String.valueOf(stringBuffer.toString().hashCode());
            } catch (Throwable unused) {
            }
        }
        return f2690h;
    }

    private static String d(Context context) {
        String str;
        String b6 = b(context);
        boolean a6 = a();
        String a7 = a(context, a6, f2687e);
        if (!y.b(b6) && f2685c.matcher(b6).matches()) {
            str = b6;
        } else if (y.b(a7) || !f2685c.matcher(a7).matches()) {
            int i6 = 0;
            String[] strArr = {a(f2686d), a(context, a6, f2686d)};
            while (true) {
                if (i6 >= 2) {
                    str = null;
                    break;
                }
                str = strArr[i6];
                if (!y.b(str) && f2685c.matcher(str).matches()) {
                    break;
                }
                i6++;
            }
        } else {
            str = a7;
        }
        if (y.b(str)) {
            str = y.a(29) ? b() : e(context);
        }
        if (!str.equals(b6)) {
            b(context, str);
        }
        if (y.b(a7)) {
            a(context, str, a6);
        }
        return str;
    }

    private static String e(Context context) {
        return "3" + y.c(f(context));
    }

    private static String f(Context context) {
        try {
            return l.f(context) + '-' + l.a("mac") + '-' + l.a("androidId");
        } catch (Throwable unused) {
            return "";
        }
    }
}
