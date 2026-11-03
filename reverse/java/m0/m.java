package m0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import i2.c1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public final class m implements Comparator<b>, Parcelable {
    public static final Parcelable.Creator<m> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final b[] f7850a;

    /* renamed from: b, reason: collision with root package name */
    private int f7851b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7852c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7853d;

    class a implements Parcelable.Creator<m> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i6) {
            return new m[i6];
        }
    }

    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private int f7854a;

        /* renamed from: b, reason: collision with root package name */
        public final UUID f7855b;

        /* renamed from: c, reason: collision with root package name */
        public final String f7856c;

        /* renamed from: d, reason: collision with root package name */
        public final String f7857d;

        /* renamed from: e, reason: collision with root package name */
        public final byte[] f7858e;

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

        b(Parcel parcel) {
            this.f7855b = new UUID(parcel.readLong(), parcel.readLong());
            this.f7856c = parcel.readString();
            this.f7857d = (String) c1.j(parcel.readString());
            this.f7858e = parcel.createByteArray();
        }

        public b(UUID uuid, String str, String str2, byte[] bArr) {
            this.f7855b = (UUID) i2.a.e(uuid);
            this.f7856c = str;
            this.f7857d = (String) i2.a.e(str2);
            this.f7858e = bArr;
        }

        public b(UUID uuid, String str, byte[] bArr) {
            this(uuid, null, str, bArr);
        }

        public boolean d(b bVar) {
            return f() && !bVar.f() && g(bVar.f7855b);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public b e(byte[] bArr) {
            return new b(this.f7855b, this.f7856c, this.f7857d, bArr);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            return c1.c(this.f7856c, bVar.f7856c) && c1.c(this.f7857d, bVar.f7857d) && c1.c(this.f7855b, bVar.f7855b) && Arrays.equals(this.f7858e, bVar.f7858e);
        }

        public boolean f() {
            return this.f7858e != null;
        }

        public boolean g(UUID uuid) {
            return h0.p.f4771a.equals(this.f7855b) || uuid.equals(this.f7855b);
        }

        public int hashCode() {
            if (this.f7854a == 0) {
                int hashCode = this.f7855b.hashCode() * 31;
                String str = this.f7856c;
                this.f7854a = ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f7857d.hashCode()) * 31) + Arrays.hashCode(this.f7858e);
            }
            return this.f7854a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i6) {
            parcel.writeLong(this.f7855b.getMostSignificantBits());
            parcel.writeLong(this.f7855b.getLeastSignificantBits());
            parcel.writeString(this.f7856c);
            parcel.writeString(this.f7857d);
            parcel.writeByteArray(this.f7858e);
        }
    }

    m(Parcel parcel) {
        this.f7852c = parcel.readString();
        b[] bVarArr = (b[]) c1.j((b[]) parcel.createTypedArray(b.CREATOR));
        this.f7850a = bVarArr;
        this.f7853d = bVarArr.length;
    }

    public m(String str, List<b> list) {
        this(str, false, (b[]) list.toArray(new b[0]));
    }

    private m(String str, boolean z5, b... bVarArr) {
        this.f7852c = str;
        bVarArr = z5 ? (b[]) bVarArr.clone() : bVarArr;
        this.f7850a = bVarArr;
        this.f7853d = bVarArr.length;
        Arrays.sort(bVarArr, this);
    }

    public m(String str, b... bVarArr) {
        this(str, true, bVarArr);
    }

    public m(List<b> list) {
        this(null, false, (b[]) list.toArray(new b[0]));
    }

    public m(b... bVarArr) {
        this((String) null, bVarArr);
    }

    private static boolean e(ArrayList<b> arrayList, int i6, UUID uuid) {
        for (int i7 = 0; i7 < i6; i7++) {
            if (arrayList.get(i7).f7855b.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public static m g(m mVar, m mVar2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (mVar != null) {
            str = mVar.f7852c;
            for (b bVar : mVar.f7850a) {
                if (bVar.f()) {
                    arrayList.add(bVar);
                }
            }
        } else {
            str = null;
        }
        if (mVar2 != null) {
            if (str == null) {
                str = mVar2.f7852c;
            }
            int size = arrayList.size();
            for (b bVar2 : mVar2.f7850a) {
                if (bVar2.f() && !e(arrayList, size, bVar2.f7855b)) {
                    arrayList.add(bVar2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new m(str, arrayList);
    }

    @Override // java.util.Comparator
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compare(b bVar, b bVar2) {
        UUID uuid = h0.p.f4771a;
        return uuid.equals(bVar.f7855b) ? uuid.equals(bVar2.f7855b) ? 0 : 1 : bVar.f7855b.compareTo(bVar2.f7855b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return c1.c(this.f7852c, mVar.f7852c) && Arrays.equals(this.f7850a, mVar.f7850a);
    }

    public m f(String str) {
        return c1.c(this.f7852c, str) ? this : new m(str, false, this.f7850a);
    }

    public b h(int i6) {
        return this.f7850a[i6];
    }

    public int hashCode() {
        if (this.f7851b == 0) {
            String str = this.f7852c;
            this.f7851b = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f7850a);
        }
        return this.f7851b;
    }

    public m i(m mVar) {
        String str;
        String str2 = this.f7852c;
        i2.a.g(str2 == null || (str = mVar.f7852c) == null || TextUtils.equals(str2, str));
        String str3 = this.f7852c;
        if (str3 == null) {
            str3 = mVar.f7852c;
        }
        return new m(str3, (b[]) c1.H0(this.f7850a, mVar.f7850a));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f7852c);
        parcel.writeTypedArray(this.f7850a, 0);
    }
}
