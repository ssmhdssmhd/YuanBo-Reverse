package q1;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b1.a;
import h0.m2;
import h0.y1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class q implements a.b {
    public static final Parcelable.Creator<q> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f8833a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8834b;

    /* renamed from: c, reason: collision with root package name */
    public final List<b> f8835c;

    class a implements Parcelable.Creator<q> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public q createFromParcel(Parcel parcel) {
            return new q(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public q[] newArray(int i6) {
            return new q[i6];
        }
    }

    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public final int f8836a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8837b;

        /* renamed from: c, reason: collision with root package name */
        public final String f8838c;

        /* renamed from: d, reason: collision with root package name */
        public final String f8839d;

        /* renamed from: e, reason: collision with root package name */
        public final String f8840e;

        /* renamed from: j, reason: collision with root package name */
        public final String f8841j;

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

        public b(int i6, int i7, String str, String str2, String str3, String str4) {
            this.f8836a = i6;
            this.f8837b = i7;
            this.f8838c = str;
            this.f8839d = str2;
            this.f8840e = str3;
            this.f8841j = str4;
        }

        b(Parcel parcel) {
            this.f8836a = parcel.readInt();
            this.f8837b = parcel.readInt();
            this.f8838c = parcel.readString();
            this.f8839d = parcel.readString();
            this.f8840e = parcel.readString();
            this.f8841j = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f8836a == bVar.f8836a && this.f8837b == bVar.f8837b && TextUtils.equals(this.f8838c, bVar.f8838c) && TextUtils.equals(this.f8839d, bVar.f8839d) && TextUtils.equals(this.f8840e, bVar.f8840e) && TextUtils.equals(this.f8841j, bVar.f8841j);
        }

        public int hashCode() {
            int i6 = ((this.f8836a * 31) + this.f8837b) * 31;
            String str = this.f8838c;
            int hashCode = (i6 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f8839d;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f8840e;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f8841j;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeInt(this.f8836a);
            parcel.writeInt(this.f8837b);
            parcel.writeString(this.f8838c);
            parcel.writeString(this.f8839d);
            parcel.writeString(this.f8840e);
            parcel.writeString(this.f8841j);
        }
    }

    q(Parcel parcel) {
        this.f8833a = parcel.readString();
        this.f8834b = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i6 = 0; i6 < readInt; i6++) {
            arrayList.add((b) parcel.readParcelable(b.class.getClassLoader()));
        }
        this.f8835c = Collections.unmodifiableList(arrayList);
    }

    public q(String str, String str2, List<b> list) {
        this.f8833a = str;
        this.f8834b = str2;
        this.f8835c = Collections.unmodifiableList(new ArrayList(list));
    }

    @Override // b1.a.b
    public /* synthetic */ void a(m2.b bVar) {
        b1.b.c(this, bVar);
    }

    @Override // b1.a.b
    public /* synthetic */ y1 b() {
        return b1.b.b(this);
    }

    @Override // b1.a.b
    public /* synthetic */ byte[] c() {
        return b1.b.a(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        return TextUtils.equals(this.f8833a, qVar.f8833a) && TextUtils.equals(this.f8834b, qVar.f8834b) && this.f8835c.equals(qVar.f8835c);
    }

    public int hashCode() {
        String str = this.f8833a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f8834b;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f8835c.hashCode();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("HlsTrackMetadataEntry");
        if (this.f8833a != null) {
            str = " [" + this.f8833a + ", " + this.f8834b + "]";
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f8833a);
        parcel.writeString(this.f8834b);
        int size = this.f8835c.size();
        parcel.writeInt(size);
        for (int i7 = 0; i7 < size; i7++) {
            parcel.writeParcelable(this.f8835c.get(i7), 0);
        }
    }
}
