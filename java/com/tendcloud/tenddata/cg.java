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
public class cg {

    /* renamed from: b, reason: collision with root package name */
    private static volatile cg f2516b = new cg();

    /* renamed from: a, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f2517a = new LinkedBlockingQueue<>(1);

    /* renamed from: c, reason: collision with root package name */
    private ServiceConnection f2518c = new ServiceConnection() { // from class: com.tendcloud.tenddata.cg.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            w.f2761a.execute(new Runnable() { // from class: com.tendcloud.tenddata.cg.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (cg.this.f2517a.size() > 0) {
                            cg.this.f2517a.clear();
                        }
                        cg.this.f2517a.put(iBinder);
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

        String getOAID() {
            String str = null;
            try {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.mIBinder.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str = obtain2.readString();
                } catch (Throwable unused) {
                }
                obtain.recycle();
                obtain2.recycle();
            } catch (Throwable unused2) {
            }
            return str;
        }
    }

    private cg() {
    }

    public static boolean a(Context context) {
        try {
            if (!cd.k()) {
                return false;
            }
            context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (context.bindService(intent, this.f2518c, 1)) {
                try {
                    dh.a().setOAID(new a(this.f2517a.take()).getOAID());
                } catch (Throwable unused) {
                }
                context.unbindService(this.f2518c);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void bindLENOVOServiceGetOAID(Context context) {
        f2516b.b(context);
    }
}
