package i3;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import f4.h;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import kotlin.jvm.internal.g;
import q3.a;
import y3.j;
import y3.k;

/* loaded from: classes.dex */
public final class f implements k.c, q3.a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f5709c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private Context f5710a;

    /* renamed from: b, reason: collision with root package name */
    private k f5711b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    private final String a(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[bArr.length * 2];
        int length = bArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = bArr[i6] & 255;
            int i8 = i6 * 2;
            cArr2[i8] = cArr[i7 >>> 4];
            cArr2[i8 + 1] = cArr[i7 & 15];
        }
        return new String(cArr2);
    }

    private final String c(PackageManager packageManager) {
        Object m6;
        Object m7;
        String f6;
        SigningInfo signingInfo;
        boolean hasMultipleSigners;
        Signature[] signingCertificateHistory;
        Object m8;
        Signature[] apkContentsSigners;
        Object m9;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                Context context = this.f5710a;
                kotlin.jvm.internal.k.b(context);
                signingInfo = packageManager.getPackageInfo(context.getPackageName(), 134217728).signingInfo;
                if (signingInfo == null) {
                    return null;
                }
                hasMultipleSigners = signingInfo.hasMultipleSigners();
                if (hasMultipleSigners) {
                    apkContentsSigners = signingInfo.getApkContentsSigners();
                    kotlin.jvm.internal.k.d(apkContentsSigners, "signingInfo.apkContentsSigners");
                    m9 = h.m(apkContentsSigners);
                    byte[] byteArray = ((Signature) m9).toByteArray();
                    kotlin.jvm.internal.k.d(byteArray, "signingInfo.apkContentsS…ers.first().toByteArray()");
                    f6 = f(byteArray);
                } else {
                    signingCertificateHistory = signingInfo.getSigningCertificateHistory();
                    kotlin.jvm.internal.k.d(signingCertificateHistory, "signingInfo.signingCertificateHistory");
                    m8 = h.m(signingCertificateHistory);
                    byte[] byteArray2 = ((Signature) m8).toByteArray();
                    kotlin.jvm.internal.k.d(byteArray2, "signingInfo.signingCerti…ory.first().toByteArray()");
                    f6 = f(byteArray2);
                }
            } else {
                Context context2 = this.f5710a;
                kotlin.jvm.internal.k.b(context2);
                Signature[] signatures = packageManager.getPackageInfo(context2.getPackageName(), 64).signatures;
                boolean z5 = true;
                if (signatures != null) {
                    if (!(signatures.length == 0)) {
                        z5 = false;
                    }
                }
                if (z5) {
                    return null;
                }
                kotlin.jvm.internal.k.d(signatures, "packageInfo.signatures");
                m6 = h.m(signatures);
                if (m6 == null) {
                    return null;
                }
                kotlin.jvm.internal.k.d(signatures, "signatures");
                m7 = h.m(signatures);
                byte[] byteArray3 = ((Signature) m7).toByteArray();
                kotlin.jvm.internal.k.d(byteArray3, "signatures.first().toByteArray()");
                f6 = f(byteArray3);
            }
            return f6;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private final long d(PackageInfo packageInfo) {
        long longVersionCode;
        if (Build.VERSION.SDK_INT < 28) {
            return packageInfo.versionCode;
        }
        longVersionCode = packageInfo.getLongVersionCode();
        return longVersionCode;
    }

    private final String f(byte[] bArr) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
        messageDigest.update(bArr);
        byte[] hashText = messageDigest.digest();
        kotlin.jvm.internal.k.d(hashText, "hashText");
        return a(hashText);
    }

    @Override // q3.a
    public void b(a.b binding) {
        kotlin.jvm.internal.k.e(binding, "binding");
        this.f5710a = binding.a();
        k kVar = new k(binding.b(), "dev.fluttercommunity.plus/package_info");
        this.f5711b = kVar;
        kotlin.jvm.internal.k.b(kVar);
        kVar.e(this);
    }

    @Override // y3.k.c
    public void e(j call, k.d result) {
        kotlin.jvm.internal.k.e(call, "call");
        kotlin.jvm.internal.k.e(result, "result");
        try {
            if (!kotlin.jvm.internal.k.a(call.f11100a, "getAll")) {
                result.c();
                return;
            }
            Context context = this.f5710a;
            kotlin.jvm.internal.k.b(context);
            PackageManager packageManager = context.getPackageManager();
            Context context2 = this.f5710a;
            kotlin.jvm.internal.k.b(context2);
            PackageInfo info = packageManager.getPackageInfo(context2.getPackageName(), 0);
            kotlin.jvm.internal.k.d(packageManager, "packageManager");
            String c6 = c(packageManager);
            Context context3 = this.f5710a;
            kotlin.jvm.internal.k.b(context3);
            String installerPackageName = packageManager.getInstallerPackageName(context3.getPackageName());
            HashMap hashMap = new HashMap();
            hashMap.put("appName", info.applicationInfo.loadLabel(packageManager).toString());
            Context context4 = this.f5710a;
            kotlin.jvm.internal.k.b(context4);
            hashMap.put("packageName", context4.getPackageName());
            hashMap.put("version", info.versionName);
            kotlin.jvm.internal.k.d(info, "info");
            hashMap.put("buildNumber", String.valueOf(d(info)));
            if (c6 != null) {
                hashMap.put("buildSignature", c6);
            }
            if (installerPackageName != null) {
                hashMap.put("installerStore", installerPackageName);
            }
            result.b(hashMap);
        } catch (PackageManager.NameNotFoundException e6) {
            result.a("Name not found", e6.getMessage(), null);
        }
    }

    @Override // q3.a
    public void j(a.b binding) {
        kotlin.jvm.internal.k.e(binding, "binding");
        this.f5710a = null;
        k kVar = this.f5711b;
        kotlin.jvm.internal.k.b(kVar);
        kVar.e(null);
        this.f5711b = null;
    }
}
