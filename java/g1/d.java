package g1;

import android.os.Parcel;
import android.os.Parcelable;
import i2.c1;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class d extends i {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f3969b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3970c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3971d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f3972e;

    /* renamed from: j, reason: collision with root package name */
    private final i[] f3973j;

    class a implements Parcelable.Creator<d> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i6) {
            return new d[i6];
        }
    }

    d(Parcel parcel) {
        super("CTOC");
        this.f3969b = (String) c1.j(parcel.readString());
        this.f3970c = parcel.readByte() != 0;
        this.f3971d = parcel.readByte() != 0;
        this.f3972e = (String[]) c1.j(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.f3973j = new i[readInt];
        for (int i6 = 0; i6 < readInt; i6++) {
            this.f3973j[i6] = (i) parcel.readParcelable(i.class.getClassLoader());
        }
    }

    public d(String str, boolean z5, boolean z6, String[] strArr, i[] iVarArr) {
        super("CTOC");
        this.f3969b = str;
        this.f3970c = z5;
        this.f3971d = z6;
        this.f3972e = strArr;
        this.f3973j = iVarArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f3970c == dVar.f3970c && this.f3971d == dVar.f3971d && c1.c(this.f3969b, dVar.f3969b) && Arrays.equals(this.f3972e, dVar.f3972e) && Arrays.equals(this.f3973j, dVar.f3973j);
    }

    public int hashCode() {
        int i6 = (((527 + (this.f3970c ? 1 : 0)) * 31) + (this.f3971d ? 1 : 0)) * 31;
        String str = this.f3969b;
        return i6 + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f3969b);
        parcel.writeByte(this.f3970c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f3971d ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.f3972e);
        parcel.writeInt(this.f3973j.length);
        for (i iVar : this.f3973j) {
            parcel.writeParcelable(iVar, 0);
        }
    }
}
