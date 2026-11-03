package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f249a;

    /* renamed from: b, reason: collision with root package name */
    public int f250b;

    /* renamed from: c, reason: collision with root package name */
    public int f251c;

    /* renamed from: d, reason: collision with root package name */
    public int f252d;

    /* renamed from: e, reason: collision with root package name */
    public int f253e;

    class a implements Parcelable.Creator<ParcelableVolumeInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableVolumeInfo[] newArray(int i6) {
            return new ParcelableVolumeInfo[i6];
        }
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f249a = parcel.readInt();
        this.f251c = parcel.readInt();
        this.f252d = parcel.readInt();
        this.f253e = parcel.readInt();
        this.f250b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeInt(this.f249a);
        parcel.writeInt(this.f251c);
        parcel.writeInt(this.f252d);
        parcel.writeInt(this.f253e);
        parcel.writeInt(this.f250b);
    }
}
