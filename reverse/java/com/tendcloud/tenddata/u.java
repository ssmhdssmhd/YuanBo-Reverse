package com.tendcloud.tenddata;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2757a = "RC4/ECB/NoPadding";

    /* renamed from: b, reason: collision with root package name */
    private static final String f2758b = "ARCFOUR";

    /* renamed from: c, reason: collision with root package name */
    private static final String f2759c = "r5czusfu0wjcaz4pp01v2k7qte55xc25fngq4ylby2civ230vdy6uy6goz9w4kgfqjk31l8khfzfvbxj7emcprjyy8nngf0r9dvxzwbhm2uw7ljre52jt95lg0knyp8e5c4go44s3z5ciy58h0tuosmwhupa62rdnkeicgdba6w6f0kenp0xac7so8j1vdbjpqwyprx2ouenv22isustwnpltt9ui5plnijd4bq4013o3mzdkllozn26zwds9x38";

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f2760d = f2759c.getBytes();

    public static byte[] a(byte[] bArr) {
        Cipher cipher = Cipher.getInstance(f2757a);
        cipher.init(1, new SecretKeySpec(f2760d, f2758b));
        return cipher.doFinal(bArr);
    }

    public static byte[] a(byte[] bArr, String str) {
        Cipher cipher = Cipher.getInstance(f2757a);
        cipher.init(1, new SecretKeySpec(str.getBytes(), f2758b));
        return cipher.doFinal(bArr);
    }

    public static byte[] b(byte[] bArr) {
        Cipher cipher = Cipher.getInstance(f2757a);
        cipher.init(2, new SecretKeySpec(f2760d, f2758b));
        return cipher.doFinal(bArr);
    }

    public static byte[] b(byte[] bArr, String str) {
        Cipher cipher = Cipher.getInstance(f2757a);
        cipher.init(2, new SecretKeySpec(str.getBytes(), f2758b));
        return cipher.doFinal(bArr);
    }
}
