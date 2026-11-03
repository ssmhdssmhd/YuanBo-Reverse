package com.tendcloud.tenddata;

import android.os.Process;
import java.util.Properties;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public class cs extends Properties implements Comparable<cs> {

    /* renamed from: a, reason: collision with root package name */
    private String f2551a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f2552b;

    /* renamed from: c, reason: collision with root package name */
    private int f2553c;

    /* renamed from: d, reason: collision with root package name */
    private int f2554d;

    /* renamed from: e, reason: collision with root package name */
    private CRC32 f2555e;

    public static final class a {
        public static final String DATA = "data";
        public static final String LENGTH = "length";
        public static final String RCS32 = "rcs32";
    }

    public cs(String str) {
        this.f2551a = str;
    }

    private cs(String str, byte[] bArr) {
        this(str);
        this.f2555e = new CRC32();
        writeData(bArr);
    }

    public cs(byte[] bArr) {
        this(a(), bArr);
    }

    public static String a() {
        return System.currentTimeMillis() + "_" + Long.toString(Process.myPid());
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(cs csVar) {
        return b().compareTo(csVar.b());
    }

    public int a(String str) {
        return Integer.parseInt(super.getProperty(str));
    }

    public int a(String str, int i6) {
        String str2 = (String) setProperty(str, String.valueOf(i6));
        if (str2 == null) {
            return 0;
        }
        return Integer.parseInt(str2);
    }

    public String a(byte[] bArr) {
        return new String(bArr);
    }

    public byte[] a(String str, byte[] bArr) {
        String str2 = (String) setProperty(str, a(bArr));
        if (str2 == null) {
            return null;
        }
        return c(str2);
    }

    public String b() {
        return this.f2551a;
    }

    public byte[] b(String str) {
        return c(super.getProperty(str));
    }

    public byte[] c() {
        return this.f2552b;
    }

    public byte[] c(String str) {
        if (str != null) {
            return str.getBytes();
        }
        return null;
    }

    public int d() {
        return this.f2553c;
    }

    public int e() {
        return this.f2554d;
    }

    public final void writeData(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        if (this.f2555e == null) {
            this.f2555e = new CRC32();
        }
        byte[] bArr2 = new byte[bArr.length];
        this.f2552b = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.f2554d = this.f2552b.length;
        this.f2555e.reset();
        this.f2555e.update(this.f2552b);
        this.f2553c = (int) this.f2555e.getValue();
    }
}
