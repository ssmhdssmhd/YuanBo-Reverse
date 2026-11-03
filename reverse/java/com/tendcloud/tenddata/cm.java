package com.tendcloud.tenddata;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public final class cm {

    /* renamed from: c, reason: collision with root package name */
    private static volatile cm f2527c = new cm();

    /* renamed from: b, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f2529b = new LinkedBlockingQueue<>(1);

    /* renamed from: a, reason: collision with root package name */
    ServiceConnection f2528a = new ServiceConnection() { // from class: com.tendcloud.tenddata.cm.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            w.f2761a.execute(new Runnable() { // from class: com.tendcloud.tenddata.cm.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (cm.this.f2529b.size() > 0) {
                            cm.this.f2529b.clear();
                        }
                        cm.this.f2529b.put(iBinder);
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

        public a(IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.mIBinder;
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
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.mIBinder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                } catch (Throwable unused2) {
                    obtain2.recycle();
                    obtain.recycle();
                }
                return str;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    private cm() {
    }

    public static boolean a(Context context) {
        try {
            if (!cd.g()) {
                return false;
            }
            context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (context.bindService(intent, this.f2528a, 1)) {
            try {
                dh.a().setOAID(new a(this.f2529b.take()).getOAID());
            } catch (Throwable unused) {
            }
            try {
                context.unbindService(this.f2528a);
            } catch (Throwable unused2) {
            }
        }
    }

    public static void bindSECServiceGetOAID(Context context) {
        f2527c.b(context);
    }
}
