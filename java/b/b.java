package b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import b.a;

/* loaded from: classes.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final boolean f1662a = false;

    /* renamed from: b, reason: collision with root package name */
    final Handler f1663b = null;

    /* renamed from: c, reason: collision with root package name */
    b.a f1664c;

    class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i6) {
            return new b[i6];
        }
    }

    /* renamed from: b.b$b, reason: collision with other inner class name */
    class BinderC0036b extends a.AbstractBinderC0034a {
        BinderC0036b() {
        }

        @Override // b.a
        public void m0(int i6, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f1663b;
            if (handler != null) {
                handler.post(bVar.new c(i6, bundle));
            } else {
                bVar.d(i6, bundle);
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final int f1666a;

        /* renamed from: b, reason: collision with root package name */
        final Bundle f1667b;

        c(int i6, Bundle bundle) {
            this.f1666a = i6;
            this.f1667b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.d(this.f1666a, this.f1667b);
        }
    }

    b(Parcel parcel) {
        this.f1664c = a.AbstractBinderC0034a.p0(parcel.readStrongBinder());
    }

    protected void d(int i6, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        synchronized (this) {
            if (this.f1664c == null) {
                this.f1664c = new BinderC0036b();
            }
            parcel.writeStrongBinder(this.f1664c.asBinder());
        }
    }
}
