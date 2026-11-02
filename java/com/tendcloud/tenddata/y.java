package com.tendcloud.tenddata;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f2770a = false;

    /* renamed from: b, reason: collision with root package name */
    public static String f2771b = "TDLog";

    /* renamed from: c, reason: collision with root package name */
    public static boolean f2772c = false;

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f2773d = true;

    /* renamed from: e, reason: collision with root package name */
    private static volatile int f2774e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static final String f2775f = "UTF-8";

    /* renamed from: g, reason: collision with root package name */
    private static final String f2776g = "ge";

    /* renamed from: h, reason: collision with root package name */
    private static final String f2777h = "tp";

    /* renamed from: i, reason: collision with root package name */
    private static final String f2778i = "rop";

    /* renamed from: l, reason: collision with root package name */
    private static final byte f2781l = 61;

    /* renamed from: m, reason: collision with root package name */
    private static final String f2782m = "US-ASCII";

    /* renamed from: q, reason: collision with root package name */
    private static final String f2786q = "00:00:00:00:00:00";

    /* renamed from: r, reason: collision with root package name */
    private static final String f2787r = "02:00:00:00:00:00";

    /* renamed from: j, reason: collision with root package name */
    private static final ExecutorService f2779j = Executors.newSingleThreadExecutor();

    /* renamed from: k, reason: collision with root package name */
    private static final HashMap<String, Boolean> f2780k = new HashMap<>();

    /* renamed from: n, reason: collision with root package name */
    private static final byte[] f2783n = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: o, reason: collision with root package name */
    private static byte[] f2784o = {1, 2, 3, 4, 5, 6, 7, 8};

    /* renamed from: p, reason: collision with root package name */
    private static final SecureRandom f2785p = new SecureRandom();

    /* renamed from: s, reason: collision with root package name */
    private static final Pattern f2788s = Pattern.compile("^([0-9A-F]{2}:){5}([0-9A-F]{2})$");

    public static String a() {
        BufferedReader bufferedReader;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop").getInputStream(), f2775f));
            try {
                StringBuilder sb = new StringBuilder();
                do {
                    try {
                        readLine = bufferedReader.readLine();
                    } catch (Throwable unused) {
                    }
                    if (readLine == null) {
                        String sb2 = sb.toString();
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused2) {
                        }
                        return sb2;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                } while (sb.length() <= 104857600);
                throw new RuntimeException("Input stream more than 100 MB size limit");
            } catch (Throwable unused3) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused4) {
                    }
                }
                return null;
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
    
        if (r2 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r2, java.lang.String r3) {
        /*
            r0 = 0
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.lang.Throwable -> L2f
            java.io.InputStream r2 = r2.open(r3)     // Catch: java.lang.Throwable -> L2f
            int r3 = r2.available()     // Catch: java.lang.Throwable -> L2d
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L2d
            int r1 = r2.read(r3)     // Catch: java.lang.Throwable -> L2d
            if (r1 <= 0) goto L29
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L2d
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L2d
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L2d
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L2d
            java.lang.String r1 = "td_channel_id"
            java.lang.String r3 = r3.getString(r1)     // Catch: java.lang.Throwable -> L2d
            r2.close()     // Catch: java.lang.Throwable -> L28
        L28:
            return r3
        L29:
            r2.close()     // Catch: java.lang.Throwable -> L34
            goto L34
        L2d:
            goto L31
        L2f:
            r2 = r0
        L31:
            if (r2 == 0) goto L34
            goto L29
        L34:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.y.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            Iterator<String> it = bundle.keySet().iterator();
            while (it.hasNext()) {
                if (it.next().equalsIgnoreCase(str)) {
                    return String.valueOf(bundle.get(str));
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static final String a(String str) {
        if (str == null) {
            return null;
        }
        return str.length() > 256 ? str.substring(0, 256) : str;
    }

    public static String a(byte[] bArr) {
        try {
            StringBuilder sb = new StringBuilder();
            for (byte b6 : bArr) {
                int i6 = b6 & 255;
                if (i6 < 16) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(i6));
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(byte[] bArr, int i6, int i7) {
        byte[] b6 = b(bArr, i6, i7);
        try {
            return new String(b6, f2782m);
        } catch (Throwable unused) {
            return new String(b6);
        }
    }

    public static Map<String, Object> a(JSONObject jSONObject) {
        TreeMap treeMap = new TreeMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                treeMap.put(next, jSONObject.get(next));
            }
        } catch (Throwable unused) {
        }
        return treeMap;
    }

    public static void a(File file, byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr2 = new byte[4096];
                while (true) {
                    int read = byteArrayInputStream.read(bArr2);
                    if (read == -1) {
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr2, 0, read);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                byteArrayInputStream.close();
                throw th;
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Class<?> cls, final v vVar, String str, String str2) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        final Object obj = declaredField.get(null);
        Class<?> cls2 = Class.forName(str2);
        declaredField.set(null, Proxy.newProxyInstance(cls.getClass().getClassLoader(), new Class[]{cls2}, new InvocationHandler() { // from class: com.tendcloud.tenddata.y.2
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj2, Method method, Object[] objArr) {
                v.this.beforeMethodInvoke(obj2, method, objArr);
                Object invoke = method.invoke(obj, objArr);
                v.this.afterMethodInvoked(obj2, method, objArr, invoke);
                return invoke;
            }
        }));
    }

    public static void a(Object obj, final v vVar, String str, String str2) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            final Object obj2 = declaredField.get(obj);
            Class<?> cls = Class.forName(str2);
            declaredField.set(obj, Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.tendcloud.tenddata.y.1
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj3, Method method, Object[] objArr) {
                    v.this.beforeMethodInvoke(obj3, method, objArr);
                    Object invoke = method.invoke(obj2, objArr);
                    v.this.afterMethodInvoked(obj3, method, objArr, invoke);
                    return invoke;
                }
            }));
        } catch (Throwable unused) {
        }
    }

    public static boolean a(int i6) {
        return Build.VERSION.SDK_INT >= i6;
    }

    public static boolean a(Context context) {
        if (f2774e != -1) {
            if (f2774e == 0) {
                return true;
            }
            f2774e = -1;
            return false;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).processName;
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (Process.myPid() == runningAppProcessInfo.pid && runningAppProcessInfo.processName.equals(str)) {
                        f2774e = 0;
                        return true;
                    }
                }
            } else {
                f2774e = 1;
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
        return false;
    }

    public static boolean a(Context context, int i6) {
        try {
            return c(context) >= i6;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static byte[] a(byte[] bArr, int i6, int i7, byte[] bArr2, int i8) {
        try {
            byte[] bArr3 = f2783n;
            int i9 = (i7 > 0 ? (bArr[i6] << 24) >>> 8 : 0) | (i7 > 1 ? (bArr[i6 + 1] << 24) >>> 16 : 0) | (i7 > 2 ? (bArr[i6 + 2] << 24) >>> 24 : 0);
            if (i7 == 1) {
                bArr2[i8] = bArr3[i9 >>> 18];
                bArr2[i8 + 1] = bArr3[(i9 >>> 12) & 63];
                bArr2[i8 + 2] = f2781l;
                bArr2[i8 + 3] = f2781l;
                return bArr2;
            }
            if (i7 == 2) {
                bArr2[i8] = bArr3[i9 >>> 18];
                bArr2[i8 + 1] = bArr3[(i9 >>> 12) & 63];
                bArr2[i8 + 2] = bArr3[(i9 >>> 6) & 63];
                bArr2[i8 + 3] = f2781l;
                return bArr2;
            }
            if (i7 != 3) {
                return bArr2;
            }
            bArr2[i8] = bArr3[i9 >>> 18];
            bArr2[i8 + 1] = bArr3[(i9 >>> 12) & 63];
            bArr2[i8 + 2] = bArr3[(i9 >>> 6) & 63];
            bArr2[i8 + 3] = bArr3[i9 & 63];
            return bArr2;
        } catch (Throwable th) {
            bq.postSDKError(th);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(1, generateSecret, new IvParameterSpec(f2784o));
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int b(Context context, int i6) {
        try {
            return (int) ((i6 * context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String b(File file, byte[] bArr) {
        FileOutputStream fileOutputStream;
        ByteArrayInputStream byteArrayInputStream;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr2 = new byte[4096];
                        while (true) {
                            int read = byteArrayInputStream.read(bArr2);
                            if (read != -1) {
                                fileOutputStream.write(bArr2, 0, read);
                                messageDigest.update(bArr2, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        fileOutputStream.close();
                        try {
                            byteArrayInputStream.close();
                        } catch (Throwable unused2) {
                        }
                        return a(messageDigest.digest());
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (byteArrayInputStream == null) {
                            throw th;
                        }
                        try {
                            byteArrayInputStream.close();
                            throw th;
                        } catch (Throwable unused4) {
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                byteArrayInputStream = null;
            }
        } catch (Throwable unused5) {
            return null;
        }
    }

    public static String b(byte[] bArr) {
        String str;
        try {
            str = a(bArr, 0, bArr.length);
        } catch (Throwable th) {
            if (!f2773d) {
                throw new AssertionError(th.getMessage());
            }
            str = null;
        }
        if (f2773d || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    public static SecureRandom b() {
        return f2785p;
    }

    public static Map<String, Object> b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.get(next));
            }
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b(int i6) {
        return Build.VERSION.SDK_INT < i6;
    }

    public static boolean b(Context context) {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0028, code lost:
    
        if (r4.checkCallingOrSelfPermission(r5) == 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            java.util.HashMap<java.lang.String, java.lang.Boolean> r1 = com.tendcloud.tenddata.y.f2780k     // Catch: java.lang.Throwable -> L35
            boolean r2 = r1.containsKey(r5)     // Catch: java.lang.Throwable -> L35
            if (r2 == 0) goto L14
            java.lang.Object r4 = r1.get(r5)     // Catch: java.lang.Throwable -> L35
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch: java.lang.Throwable -> L35
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Throwable -> L35
            goto L34
        L14:
            r2 = 23
            boolean r2 = a(r2)     // Catch: java.lang.Throwable -> L35
            r3 = 1
            if (r2 == 0) goto L24
            int r4 = g0.s.a(r4, r5)     // Catch: java.lang.Throwable -> L35
            if (r4 != 0) goto L2c
            goto L2a
        L24:
            int r4 = r4.checkCallingOrSelfPermission(r5)     // Catch: java.lang.Throwable -> L35
            if (r4 != 0) goto L2c
        L2a:
            r4 = 1
            goto L2d
        L2c:
            r4 = 0
        L2d:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Throwable -> L35
            r1.put(r5, r2)     // Catch: java.lang.Throwable -> L35
        L34:
            return r4
        L35:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.y.b(android.content.Context, java.lang.String):boolean");
    }

    public static final boolean b(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static byte[] b(byte[] bArr, int i6, int i7) {
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("Cannot have negative offset: " + i6);
        }
        if (i7 < 0) {
            throw new IllegalArgumentException("Cannot have length offset: " + i7);
        }
        if (i6 + i7 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(bArr.length)));
        }
        int i8 = ((i7 / 3) * 4) + (i7 % 3 <= 0 ? 0 : 4);
        byte[] bArr2 = new byte[i8];
        int i9 = i7 - 2;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            a(bArr, i10 + i6, 3, bArr2, i11);
            i10 += 3;
            i11 += 4;
        }
        if (i10 < i7) {
            a(bArr, i6 + i10, i7 - i10, bArr2, i11);
            i11 += 4;
        }
        if (i11 > i8 - 1) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i11];
        System.arraycopy(bArr2, 0, bArr3, 0, i11);
        return bArr3;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(2, generateSecret, new IvParameterSpec(f2784o));
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int c(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            if (applicationInfo != null) {
                return applicationInfo.targetSdkVersion;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String c(String str) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(str.getBytes(f2775f)));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        if (r1 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(byte[] r7) {
        /*
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r7)
            r7 = 0
            java.util.zip.GZIPInputStream r1 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L3c
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L3c
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r0]     // Catch: java.lang.Throwable -> L39
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L39
            r3.<init>()     // Catch: java.lang.Throwable -> L39
        L14:
            r4 = 0
            int r5 = r1.read(r2, r4, r0)     // Catch: java.lang.Throwable -> L35
            r6 = -1
            if (r5 == r6) goto L20
            r3.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L35
            goto L14
        L20:
            byte[] r0 = r3.toByteArray()     // Catch: java.lang.Throwable -> L35
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L35
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L35
            r3.flush()     // Catch: java.lang.Throwable -> L33
            r3.close()     // Catch: java.lang.Throwable -> L2f
        L2f:
            r1.close()     // Catch: java.lang.Throwable -> L49
            goto L49
        L33:
            goto L37
        L35:
            r2 = r7
        L37:
            r7 = r3
            goto L3f
        L39:
            r2 = r7
            goto L3f
        L3c:
            r1 = r7
            r2 = r1
        L3f:
            if (r7 == 0) goto L46
            r7.close()     // Catch: java.lang.Throwable -> L45
            goto L46
        L45:
        L46:
            if (r1 == 0) goto L49
            goto L2f
        L49:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.y.c(byte[]):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
    
        if (r3.checkCallingOrSelfPermission(r4) == 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(android.content.Context r3, java.lang.String r4) {
        /*
            r0 = 23
            r1 = 0
            boolean r0 = a(r0)     // Catch: java.lang.Throwable -> L18
            r2 = 1
            if (r0 == 0) goto L11
            int r3 = g0.s.a(r3, r4)     // Catch: java.lang.Throwable -> L18
            if (r3 != 0) goto L18
            goto L17
        L11:
            int r3 = r3.checkCallingOrSelfPermission(r4)     // Catch: java.lang.Throwable -> L18
            if (r3 != 0) goto L18
        L17:
            r1 = 1
        L18:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.y.c(android.content.Context, java.lang.String):boolean");
    }

    public static String d(Context context, String str) {
        try {
            return a(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData, str);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static byte[] d(String str) {
        try {
            int length = str.length();
            byte[] bArr = new byte[length / 2];
            for (int i6 = 0; i6 < length; i6 += 2) {
                bArr[i6 / 2] = (byte) ((Character.digit(str.charAt(i6), 16) << 4) + Character.digit(str.charAt(i6 + 1), 16));
            }
            return bArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] d(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.reset();
        inflater.setInput(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            byte[] bArr2 = new byte[1024];
            while (!inflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
            }
            bArr = byteArrayOutputStream.toByteArray();
        } catch (Throwable unused) {
        }
        try {
            byteArrayOutputStream.close();
        } catch (Throwable unused2) {
        }
        inflater.end();
        return bArr;
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(MessageDigest.getInstance("SHA-256").digest(str.getBytes(f2775f)));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static FileChannel e(Context context, String str) {
        RandomAccessFile randomAccessFile;
        try {
            File file = new File(context.getFilesDir(), str + "td.lock");
            if (!file.exists()) {
                file.createNewFile();
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable unused) {
            randomAccessFile = null;
        }
        try {
            return randomAccessFile.getChannel();
        } catch (Throwable unused2) {
            if (randomAccessFile == null) {
                return null;
            }
            try {
                randomAccessFile.close();
                return null;
            } catch (Throwable unused3) {
                return null;
            }
        }
    }

    public static void execute(Runnable runnable) {
        ExecutorService executorService = f2779j;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }

    public static byte[] f(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater(9, true);
        DeflaterOutputStream deflaterOutputStream = null;
        try {
            try {
                DeflaterOutputStream deflaterOutputStream2 = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                try {
                    deflaterOutputStream2.write(str.getBytes(f2775f));
                    deflaterOutputStream2.close();
                } catch (Throwable unused) {
                    deflaterOutputStream = deflaterOutputStream2;
                    if (deflaterOutputStream != null) {
                        deflaterOutputStream.close();
                    }
                    deflater.end();
                    return byteArrayOutputStream.toByteArray();
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    public static Long g(String str) {
        long j6 = -1L;
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (Throwable th) {
            bq.postSDKError(th);
            return j6;
        }
    }

    public static Integer h(String str) {
        int i6 = -1;
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (Throwable th) {
            bq.postSDKError(th);
            return i6;
        }
    }

    public static boolean i(String str) {
        return !b(str) && q.f2738h.matcher(str).matches();
    }

    public static boolean j(String str) {
        try {
            if (b(str) || !f2788s.matcher(str).matches() || f2787r.equals(str)) {
                return true;
            }
            return f2786q.equals(str);
        } catch (Throwable unused) {
            return false;
        }
    }
}
