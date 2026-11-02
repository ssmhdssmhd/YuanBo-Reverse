package com.tendcloud.tenddata;

import android.os.SystemClock;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class ar {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2300a = 600;

    /* renamed from: b, reason: collision with root package name */
    private int f2301b;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f2302c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, List<String>> f2303d;

    private ar(int i6, String str) {
        this(i6, str.getBytes(), null);
    }

    private ar(int i6, byte[] bArr, Map<String, List<String>> map) {
        this.f2301b = i6;
        this.f2302c = bArr;
        this.f2303d = map;
    }

    public static int a() {
        return f2300a;
    }

    private static ar a(int i6, int i7, InputStream inputStream, Map<String, List<String>> map) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = i7 != -1 ? new ByteArrayOutputStream(i7) : new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read();
                if (read == -1) {
                    inputStream.close();
                    return new ar(i6, byteArrayOutputStream.toByteArray(), map);
                }
                byteArrayOutputStream.write(read);
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    public static ar a(String str) {
        return new ar(f2300a, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        if (r9 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
    
        if (r9 != null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.tendcloud.tenddata.ar a(java.lang.String r11, java.net.HttpURLConnection r12, long r13, com.tendcloud.tenddata.an r15) {
        /*
            r0 = 0
            int r8 = r12.getResponseCode()     // Catch: java.lang.Throwable -> L32
            r1 = 400(0x190, float:5.6E-43)
            if (r8 <= r1) goto Le
            java.io.InputStream r1 = r12.getErrorStream()     // Catch: java.lang.Throwable -> L30
            goto L12
        Le:
            java.io.InputStream r1 = r12.getInputStream()     // Catch: java.lang.Throwable -> L30
        L12:
            r9 = r1
            java.util.Map r1 = r12.getHeaderFields()     // Catch: java.lang.Throwable -> L2e
            int r2 = r12.getContentLength()     // Catch: java.lang.Throwable -> L2e
            com.tendcloud.tenddata.ar r10 = a(r8, r2, r9, r1)     // Catch: java.lang.Throwable -> L2e
            r1 = r11
            r2 = r12
            r3 = r8
            r4 = r13
            r6 = r10
            r7 = r15
            a(r1, r2, r3, r4, r6, r7)     // Catch: java.lang.Throwable -> L2e
            if (r9 == 0) goto L41
        L2a:
            r9.close()     // Catch: java.lang.Throwable -> L41
            goto L41
        L2e:
            r11 = move-exception
            goto L36
        L30:
            r11 = move-exception
            goto L35
        L32:
            r11 = move-exception
            r8 = 600(0x258, float:8.41E-43)
        L35:
            r9 = r0
        L36:
            com.tendcloud.tenddata.bq.postSDKError(r11)     // Catch: java.lang.Throwable -> L42
            com.tendcloud.tenddata.ar r10 = new com.tendcloud.tenddata.ar     // Catch: java.lang.Throwable -> L42
            r10.<init>(r8, r0, r0)     // Catch: java.lang.Throwable -> L42
            if (r9 == 0) goto L41
            goto L2a
        L41:
            return r10
        L42:
            r11 = move-exception
            if (r9 == 0) goto L48
            r9.close()     // Catch: java.lang.Throwable -> L48
        L48:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.ar.a(java.lang.String, java.net.HttpURLConnection, long, com.tendcloud.tenddata.an):com.tendcloud.tenddata.ar");
    }

    private static String a(ar arVar) {
        if (arVar == null || arVar.c() == null) {
            return "";
        }
        try {
            byte[] c6 = arVar.c();
            return c6.length > 104857600 ? "Input stream more than 100 MB size limit" : new String(c6);
        } catch (Throwable th) {
            bq.postSDKError(th);
            return "";
        }
    }

    private static void a(String str, HttpURLConnection httpURLConnection, int i6, long j6, ar arVar, an anVar) {
        boolean z5;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getRequestMethod().equalsIgnoreCase("POST")) {
                    TreeMap treeMap = new TreeMap();
                    URL url = httpURLConnection.getURL();
                    treeMap.put("targetUrl", url.toString());
                    try {
                        treeMap.put("targetIP", InetAddress.getByName(url.getHost()).getHostAddress());
                    } catch (Throwable unused) {
                        treeMap.put("targetIP", "0.0.0.0");
                    }
                    if (i6 == 200) {
                        if (anVar != null && anVar.a() != null) {
                            treeMap.put("reqSize", Integer.valueOf(anVar.a().length));
                        }
                        treeMap.put("respTime", Long.valueOf(SystemClock.elapsedRealtime() - j6));
                        z5 = true;
                    } else {
                        treeMap.put("errorMsg", a(arVar));
                        treeMap.put("statusCode", Integer.valueOf(i6));
                        z5 = false;
                    }
                    bq.a(str, z5, treeMap);
                }
            } catch (Throwable th) {
                bq.postSDKError(th);
            }
        }
    }

    public int b() {
        return this.f2301b;
    }

    public byte[] c() {
        return this.f2302c;
    }

    public Map<String, List<String>> d() {
        return this.f2303d;
    }
}
