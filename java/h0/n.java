package h0;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import m2.q;

/* loaded from: classes.dex */
public final class n extends Binder {

    /* renamed from: a, reason: collision with root package name */
    private static final int f4708a;

    static {
        f4708a = i2.c1.f5548a >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536;
    }

    public static m2.q<Bundle> a(IBinder iBinder) {
        int readInt;
        q.a k6 = m2.q.k();
        int i6 = 1;
        int i7 = 0;
        while (i6 != 0) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInt(i7);
                try {
                    iBinder.transact(1, obtain, obtain2, 0);
                    while (true) {
                        readInt = obtain2.readInt();
                        if (readInt == 1) {
                            k6.a((Bundle) i2.a.e(obtain2.readBundle()));
                            i7++;
                        }
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    i6 = readInt;
                } catch (RemoteException e6) {
                    throw new RuntimeException(e6);
                }
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
        return k6.h();
    }
}
