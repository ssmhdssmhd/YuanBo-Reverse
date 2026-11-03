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
public class ce {

    /* renamed from: b, reason: collision with root package name */
    private static volatile ce f2510b = new ce();

    /* renamed from: a, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f2511a = new LinkedBlockingQueue<>(1);

    /* renamed from: c, reason: collision with root package name */
    private ServiceConnection f2512c = new ServiceConnection() { // from class: com.tendcloud.tenddata.ce.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            w.f2761a.execute(new Runnable() { // from class: com.tendcloud.tenddata.ce.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ce.this.f2511a.size() > 0) {
                            ce.this.f2511a.clear();
                        }
                        ce.this.f2511a.put(iBinder);
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
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.mIBinder.transact(3, obtain, obtain2, 0);
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

    private ce() {
    }

    public static boolean a(Context context) {
        try {
            return cd.j();
        } catch (Throwable unused) {
            return false;
        }
    }

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            if (context.bindService(intent, this.f2512c, 1)) {
                try {
                    dh.a().setOAID(new a(this.f2511a.take()).getOAID());
                } catch (Throwable unused) {
                }
                context.unbindService(this.f2512c);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void bindASUSServiceGetOAID(Context context) {
        f2510b.b(context);
    }
}
