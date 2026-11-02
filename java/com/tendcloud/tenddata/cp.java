package com.tendcloud.tenddata;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.lang.reflect.Constructor;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public class cp {

    /* renamed from: b, reason: collision with root package name */
    private static final String f2530b = "android.app.ZteDeviceIdentifyManager";

    /* renamed from: c, reason: collision with root package name */
    private static String f2531c = "com.mdid.msa";

    /* renamed from: d, reason: collision with root package name */
    private static volatile cp f2532d = new cp();

    /* renamed from: a, reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f2533a = new LinkedBlockingQueue<>(1);

    /* renamed from: e, reason: collision with root package name */
    private ServiceConnection f2534e = new ServiceConnection() { // from class: com.tendcloud.tenddata.cp.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            w.f2761a.execute(new Runnable() { // from class: com.tendcloud.tenddata.cp.1.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (cp.this.f2533a.size() > 0) {
                            cp.this.f2533a.clear();
                        }
                        cp.this.f2533a.put(iBinder);
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
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
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

    private cp() {
    }

    private static void a(String str, Context context) {
        Intent intent = new Intent();
        intent.setClassName(f2531c, "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context) {
        try {
            if (!cd.h()) {
                return false;
            }
            if (Build.VERSION.SDK_INT > 29) {
                return true;
            }
            context.getPackageManager().getPackageInfo(f2531c, 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void b(Context context) {
        try {
            Class<?> cls = Class.forName(f2530b);
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Context.class);
            if (declaredConstructor != null) {
                dh.a().setOAID((String) cls.getDeclaredMethod("getOAID", Context.class).invoke(declaredConstructor.newInstance(context), context));
            }
        } catch (Throwable unused) {
        }
    }

    public static void bindZTEServiceGetOAID(Context context) {
        if (Build.VERSION.SDK_INT <= 29) {
            f2532d.c(context);
        } else {
            b(context);
        }
    }

    private void c(Context context) {
        try {
            String packageName = context.getPackageName();
            a(packageName, context);
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", packageName);
            if (context.bindService(intent, this.f2534e, 1)) {
                try {
                    dh.a().setOAID(new a(this.f2533a.take()).getOAID());
                } catch (Throwable unused) {
                }
                context.unbindService(this.f2534e);
            }
        } catch (Throwable unused2) {
        }
    }
}
