package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.lifecycle.d;

/* loaded from: classes.dex */
final class l implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final String f709a;

    /* renamed from: b, reason: collision with root package name */
    final String f710b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f711c;

    /* renamed from: d, reason: collision with root package name */
    final int f712d;

    /* renamed from: e, reason: collision with root package name */
    final int f713e;

    /* renamed from: j, reason: collision with root package name */
    final String f714j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f715k;

    /* renamed from: l, reason: collision with root package name */
    final boolean f716l;

    /* renamed from: m, reason: collision with root package name */
    final boolean f717m;

    /* renamed from: n, reason: collision with root package name */
    final Bundle f718n;

    /* renamed from: o, reason: collision with root package name */
    final boolean f719o;

    /* renamed from: p, reason: collision with root package name */
    final int f720p;

    /* renamed from: q, reason: collision with root package name */
    Bundle f721q;

    /* renamed from: r, reason: collision with root package name */
    Fragment f722r;

    static class a implements Parcelable.Creator<l> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public l[] newArray(int i6) {
            return new l[i6];
        }
    }

    l(Parcel parcel) {
        this.f709a = parcel.readString();
        this.f710b = parcel.readString();
        this.f711c = parcel.readInt() != 0;
        this.f712d = parcel.readInt();
        this.f713e = parcel.readInt();
        this.f714j = parcel.readString();
        this.f715k = parcel.readInt() != 0;
        this.f716l = parcel.readInt() != 0;
        this.f717m = parcel.readInt() != 0;
        this.f718n = parcel.readBundle();
        this.f719o = parcel.readInt() != 0;
        this.f721q = parcel.readBundle();
        this.f720p = parcel.readInt();
    }

    l(Fragment fragment) {
        this.f709a = fragment.getClass().getName();
        this.f710b = fragment.f565e;
        this.f711c = fragment.f573m;
        this.f712d = fragment.f582v;
        this.f713e = fragment.f583w;
        this.f714j = fragment.f584x;
        this.f715k = fragment.A;
        this.f716l = fragment.f572l;
        this.f717m = fragment.f586z;
        this.f718n = fragment.f566f;
        this.f719o = fragment.f585y;
        this.f720p = fragment.R.ordinal();
    }

    public Fragment d(ClassLoader classLoader, f fVar) {
        Fragment fragment;
        Bundle bundle;
        if (this.f722r == null) {
            Bundle bundle2 = this.f718n;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
            }
            Fragment a6 = fVar.a(classLoader, this.f709a);
            this.f722r = a6;
            a6.c1(this.f718n);
            Bundle bundle3 = this.f721q;
            if (bundle3 != null) {
                bundle3.setClassLoader(classLoader);
                fragment = this.f722r;
                bundle = this.f721q;
            } else {
                fragment = this.f722r;
                bundle = new Bundle();
            }
            fragment.f562b = bundle;
            Fragment fragment2 = this.f722r;
            fragment2.f565e = this.f710b;
            fragment2.f573m = this.f711c;
            fragment2.f575o = true;
            fragment2.f582v = this.f712d;
            fragment2.f583w = this.f713e;
            fragment2.f584x = this.f714j;
            fragment2.A = this.f715k;
            fragment2.f572l = this.f716l;
            fragment2.f586z = this.f717m;
            fragment2.f585y = this.f719o;
            fragment2.R = d.c.values()[this.f720p];
            if (i.H) {
                Log.v("FragmentManager", "Instantiated fragment " + this.f722r);
            }
        }
        return this.f722r;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f709a);
        sb.append(" (");
        sb.append(this.f710b);
        sb.append(")}:");
        if (this.f711c) {
            sb.append(" fromLayout");
        }
        if (this.f713e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f713e));
        }
        String str = this.f714j;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f714j);
        }
        if (this.f715k) {
            sb.append(" retainInstance");
        }
        if (this.f716l) {
            sb.append(" removing");
        }
        if (this.f717m) {
            sb.append(" detached");
        }
        if (this.f719o) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f709a);
        parcel.writeString(this.f710b);
        parcel.writeInt(this.f711c ? 1 : 0);
        parcel.writeInt(this.f712d);
        parcel.writeInt(this.f713e);
        parcel.writeString(this.f714j);
        parcel.writeInt(this.f715k ? 1 : 0);
        parcel.writeInt(this.f716l ? 1 : 0);
        parcel.writeInt(this.f717m ? 1 : 0);
        parcel.writeBundle(this.f718n);
        parcel.writeInt(this.f719o ? 1 : 0);
        parcel.writeBundle(this.f721q);
        parcel.writeInt(this.f720p);
    }
}
