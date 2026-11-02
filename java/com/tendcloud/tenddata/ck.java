package com.tendcloud.tenddata;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public class ck {

    /* renamed from: b, reason: collision with root package name */
    private static String f2519b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile ck f2520c = new ck();

    /* renamed from: a, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f2521a = new LinkedBlockingQueue<>(1);

    /* renamed from: d, reason: collision with root package name */
    private ServiceConnection f2522d = new ServiceConnection() { // from class: com.tendcloud.tenddata.ck.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            w.f2761a.execute(new Runnable() { // from class: com.tendcloud.tenddata.ck.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ck.this.f2521a.size() > 0) {
                            ck.this.f2521a.clear();
                        }
                        ck.this.f2521a.put(iBinder);
                    } catch (Throwable unused) {
                    }
                }
            });
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    static class a implements IInterface {
        private IBinder mIBinder;

        a(IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.mIBinder;
        }

        String getSerID(String str, String str2, String str3) {
            String str4 = null;
            try {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mIBinder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str4 = obtain2.readString();
                } catch (Throwable unused) {
                }
                obtain.recycle();
                obtain2.recycle();
            } catch (Throwable unused2) {
            }
            return str4;
        }
    }

    private ck() {
    }

    private static String a(String str, Context context, a aVar) {
        Signature[] signatureArr;
        String packageName = context.getPackageName();
        if (f2519b == null) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Throwable unused) {
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b6 : digest) {
                            sb.append(Integer.toHexString((b6 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (Throwable unused2) {
                }
            }
            f2519b = str2;
        }
        return aVar.getSerID(packageName, f2519b, str);
    }

    public static boolean a(Context context) {
        PackageInfo packageInfo;
        try {
            if (cd.e() && (packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0)) != null) {
                return packageInfo.versionCode >= 1;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (context.bindService(intent, this.f2522d, 1)) {
                a aVar = new a(this.f2521a.take());
                try {
                    dh.a().setOAID(a("OUID", context, aVar));
                } catch (Throwable unused) {
                }
                try {
                    dh.a().setVAID(a("DUID", context, aVar));
                } catch (Throwable unused2) {
                }
                try {
                    dh.a().setAAID(a("AUID", context, aVar));
                } catch (Throwable unused3) {
                }
                context.unbindService(this.f2522d);
            }
        } catch (Throwable unused4) {
        }
    }

    public static void bindONEPLUSServiceGetOAID(Context context) {
        f2520c.b(context);
    }
}
