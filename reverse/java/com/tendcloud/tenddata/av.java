package com.tendcloud.tenddata;

import android.content.SharedPreferences;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
final class av {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2318a = "mPBE";

    /* renamed from: b, reason: collision with root package name */
    private static final String f2319b = "_Ladder_Project";

    /* renamed from: c, reason: collision with root package name */
    private static final String f2320c = "Pythagoras_phase";

    private av() {
    }

    static String a(String str) {
        SharedPreferences sharedPreferences = ab.f2233g.getSharedPreferences(f2320c, 0);
        String string = sharedPreferences.getString(str, "");
        String str2 = ab.f2233g.getFilesDir() + File.separator + f2319b;
        String d6 = d(str2, str);
        if (!y.b(d6) || y.b(string)) {
            return d6;
        }
        a(str2, str, string);
        sharedPreferences.edit().putString(str, "").apply();
        return string;
    }

    static void a(String str, String str2) {
        a(ab.f2233g.getFilesDir() + File.separator + f2319b, str, str2);
    }

    private static void a(String str, String str2, String str3) {
        File file;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                file = new File(str);
            } catch (Throwable unused) {
                return;
            }
        } catch (Throwable unused2) {
        }
        if (file.exists() || file.isDirectory() || file.mkdirs()) {
            File file2 = new File(file, str2);
            if (file2.exists() || file2.createNewFile()) {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    fileOutputStream2.write(str3.getBytes());
                    fileOutputStream2.close();
                } catch (Throwable unused3) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
            }
        }
    }

    static void a(String str, byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b6 : bArr) {
            sb.append((int) b6);
            sb.append(",");
        }
        a(ab.f2233g.getFilesDir() + File.separator + f2318a, str, sb.toString());
    }

    private static byte[] a(int i6, String str) {
        try {
            if (y.b(str)) {
                return null;
            }
            byte[] bArr = new byte[i6];
            String[] split = str.split(",");
            for (int i7 = 0; i7 < split.length; i7++) {
                bArr[i7] = Byte.parseByte(split[i7]);
            }
            return bArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    static byte[] a(String str, int i6) {
        SharedPreferences sharedPreferences = ab.f2233g.getSharedPreferences(f2318a, 0);
        String string = sharedPreferences.getString(str, "");
        String str2 = ab.f2233g.getFilesDir() + File.separator + f2318a;
        String d6 = d(str2, str);
        if (!y.b(d6)) {
            return a(i6, d6);
        }
        if (y.b(string)) {
            return null;
        }
        a(str2, str, string);
        sharedPreferences.edit().putString(str, "").apply();
        return a(i6, string);
    }

    static String b(String str) {
        return d(ab.f2233g.getFilesDir().getPath(), str);
    }

    static void b(String str, String str2) {
        a(ab.f2233g.getFilesDir().getPath(), str, str2);
    }

    static String c(String str) {
        return System.getProperties().getProperty(str);
    }

    static void c(String str, String str2) {
        System.getProperties().setProperty(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        if (r4 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        if (r4 == null) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String d(java.lang.String r4, java.lang.String r5) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r4 = r0.exists()
            java.lang.String r1 = ""
            if (r4 != 0) goto L1a
            boolean r4 = r0.isDirectory()
            if (r4 != 0) goto L1a
            boolean r4 = r0.mkdirs()
            if (r4 != 0) goto L1a
            return r1
        L1a:
            r4 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L50
            r2.<init>(r0, r5)     // Catch: java.lang.Throwable -> L50
            boolean r5 = r2.exists()     // Catch: java.lang.Throwable -> L50
            if (r5 == 0) goto L43
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L50
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L50
            long r2 = r2.length()     // Catch: java.lang.Throwable -> L40
            int r4 = (int) r2     // Catch: java.lang.Throwable -> L40
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L40
            int r0 = r5.read(r4)     // Catch: java.lang.Throwable -> L40
            if (r0 <= 0) goto L3e
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L40
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L40
            r1 = r0
        L3e:
            r4 = r5
            goto L4a
        L40:
            r4 = r5
            goto L51
        L43:
            boolean r5 = r2.createNewFile()     // Catch: java.lang.Throwable -> L50
            if (r5 != 0) goto L4a
            return r1
        L4a:
            if (r4 == 0) goto L54
        L4c:
            r4.close()     // Catch: java.lang.Throwable -> L54
            goto L54
        L50:
        L51:
            if (r4 == 0) goto L54
            goto L4c
        L54:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.av.d(java.lang.String, java.lang.String):java.lang.String");
    }
}
