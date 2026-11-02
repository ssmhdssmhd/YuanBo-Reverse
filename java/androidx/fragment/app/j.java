package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class j implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    ArrayList<l> f697a;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<String> f698b;

    /* renamed from: c, reason: collision with root package name */
    b[] f699c;

    /* renamed from: d, reason: collision with root package name */
    String f700d;

    /* renamed from: e, reason: collision with root package name */
    int f701e;

    static class a implements Parcelable.Creator<j> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i6) {
            return new j[i6];
        }
    }

    public j() {
        this.f700d = null;
    }

    public j(Parcel parcel) {
        this.f700d = null;
        this.f697a = parcel.createTypedArrayList(l.CREATOR);
        this.f698b = parcel.createStringArrayList();
        this.f699c = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f700d = parcel.readString();
        this.f701e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeTypedList(this.f697a);
        parcel.writeStringList(this.f698b);
        parcel.writeTypedArray(this.f699c, i6);
        parcel.writeString(this.f700d);
        parcel.writeInt(this.f701e);
    }
}
