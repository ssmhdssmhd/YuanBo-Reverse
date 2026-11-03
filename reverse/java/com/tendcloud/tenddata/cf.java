package com.tendcloud.tenddata;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public final class cf {

    /* renamed from: c, reason: collision with root package name */
    private static volatile cf f2513c = new cf();

    /* renamed from: b, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f2515b = new LinkedBlockingQueue<>(1);

    /* renamed from: a, reason: collision with root package name */
    ServiceConnection f2514a = new ServiceConnection() { // from class: com.tendcloud.tenddata.cf.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            w.f2761a.execute(new Runnable() { // from class: com.tendcloud.tenddata.cf.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (cf.this.f2515b.size() > 0) {
                            cf.this.f2515b.clear();
                        }
                        cf.this.f2515b.put(iBinder);
                    } catch (Throwable unused) {
                    }
                }
            });
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public static final class a implements IInterface {
        private IBinder iBinder;

        private a(IBinder iBinder) {
            this.iBinder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.iBinder;
        }

        public String getOAID() {
            Parcel obtain;
            Parcel obtain2;
            String str = null;
            try {
                obtain = Parcel.obtain();
                obtain2 = Parcel.obtain();
            } catch (Throwable unused) {
            }
            try {
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.iBinder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                } catch (Throwable unused2) {
                    obtain.recycle();
                    obtain2.recycle();
                }
                return str;
            } finally {
                obtain.recycle();
                obtain2.recycle();
            }
        }
    }

    private cf() {
    }

    public static boolean a(Context context) {
        try {
            if (cd.b() || cd.c()) {
                return !TextUtils.isEmpty(b(context));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean a(Context context, String str) {
        return b(context, str) != null;
    }

    private static PackageInfo b(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getPackageInfo(str, 128);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String b(Context context) {
        if (a(context, "com.huawei.hwid")) {
            return "com.huawei.hwid";
        }
        String str = "com.huawei.hms";
        if (!a(context, "com.huawei.hms")) {
            str = "com.huawei.hwid.tv";
            if (!a(context, "com.huawei.hwid.tv")) {
                return "com.huawei.hwid";
            }
        }
        return str;
    }

    public static void bindHWServiceGetOAID(Context context) {
        f2513c.c(context);
    }

    private void c(Context context) {
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(b(context));
            if (context.bindService(intent, this.f2514a, 1)) {
                try {
                    dh.a().setOAID(new a(this.f2515b.take()).getOAID());
                } catch (Throwable unused) {
                }
                context.unbindService(this.f2514a);
            }
        } catch (Throwable unused2) {
        }
    }
}
