package b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: b.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0034a extends Binder implements a {

        /* renamed from: b.a$a$a, reason: collision with other inner class name */
        private static class C0035a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f1661a;

            C0035a(IBinder iBinder) {
                this.f1661a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1661a;
            }
        }

        public AbstractBinderC0034a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static a p0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0035a(iBinder) : (a) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i6, Parcel parcel, Parcel parcel2, int i7) {
            if (i6 >= 1 && i6 <= 16777215) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
            }
            if (i6 == 1598968902) {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
            if (i6 != 1) {
                return super.onTransact(i6, parcel, parcel2, i7);
            }
            m0(parcel.readInt(), (Bundle) b.b(parcel, Bundle.CREATOR));
            return true;
        }
    }

    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T b(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void m0(int i6, Bundle bundle);
}
