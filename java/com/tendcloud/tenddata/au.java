package com.tendcloud.tenddata;

import com.tendcloud.tenddata.n;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;

/* loaded from: classes.dex */
final class au {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2309a = 128;

    /* renamed from: b, reason: collision with root package name */
    private static final int f2310b = 10000;

    /* renamed from: c, reason: collision with root package name */
    private static final String f2311c = "iv";

    /* renamed from: d, reason: collision with root package name */
    private static final String f2312d = "salt";

    /* renamed from: e, reason: collision with root package name */
    private static final int f2313e = 16;

    /* renamed from: f, reason: collision with root package name */
    private static final int f2314f = 32;

    /* renamed from: g, reason: collision with root package name */
    private static final String f2315g = "AES/CBC/PKCS5Padding";

    /* renamed from: h, reason: collision with root package name */
    private static final String f2316h = "PBKDF2WithHmacSHA1";

    /* renamed from: i, reason: collision with root package name */
    private static final String f2317i = "AES";

    au() {
    }

    static SecretKey a(char[] cArr, byte[] bArr) {
        return SecretKeyFactory.getInstance(f2316h).generateSecret(new PBEKeySpec(cArr, bArr, f2310b, f2309a));
    }

    static IvParameterSpec a() {
        try {
            n.b bVar = n.b.AES_IV_LOCK;
            n.getFileLock(bVar.toString());
            byte[] a6 = av.a(f2311c, 16);
            if (a6 == null) {
                a6 = a(16);
                av.a(f2311c, a6);
            }
            IvParameterSpec ivParameterSpec = new IvParameterSpec(a6);
            n.releaseFileLock(bVar.toString());
            return ivParameterSpec;
        } catch (Throwable unused) {
            n.releaseFileLock(n.b.AES_IV_LOCK.toString());
            return null;
        }
    }

    private static byte[] a(int i6) {
        byte[] bArr = new byte[i6];
        y.b().nextBytes(bArr);
        return bArr;
    }

    static byte[] a(byte[] bArr, SecretKey secretKey, IvParameterSpec ivParameterSpec) {
        Cipher cipher = Cipher.getInstance(y.b(19) ? f2317i : f2315g);
        cipher.init(1, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    static byte[] b() {
        String bVar;
        byte[] bArr = null;
        try {
            n.b bVar2 = n.b.AES_SALT_LOCK;
            n.getFileLock(bVar2.toString());
            bArr = av.a(f2312d, f2314f);
            if (bArr == null || bArr.length == 0) {
                bArr = a(f2314f);
                av.a(f2312d, bArr);
            }
            bVar = bVar2.toString();
        } catch (Throwable unused) {
            bVar = n.b.AES_SALT_LOCK.toString();
        }
        n.releaseFileLock(bVar);
        return bArr;
    }

    static byte[] b(byte[] bArr, SecretKey secretKey, IvParameterSpec ivParameterSpec) {
        Cipher cipher = Cipher.getInstance(y.b(19) ? f2317i : f2315g);
        cipher.init(2, secretKey, ivParameterSpec);
        return cipher.doFinal(bArr);
    }
}
