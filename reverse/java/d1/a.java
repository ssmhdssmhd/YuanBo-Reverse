package d1;

import android.os.Parcel;
import android.os.Parcelable;
import b1.a;
import h0.m2;
import h0.y1;
import i2.c1;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements a.b {

    /* renamed from: a, reason: collision with root package name */
    public final String f2916a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2917b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2918c;

    /* renamed from: d, reason: collision with root package name */
    public final long f2919d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f2920e;

    /* renamed from: j, reason: collision with root package name */
    private int f2921j;

    /* renamed from: k, reason: collision with root package name */
    private static final y1 f2914k = new y1.b().g0("application/id3").G();

    /* renamed from: l, reason: collision with root package name */
    private static final y1 f2915l = new y1.b().g0("application/x-scte35").G();
    public static final Parcelable.Creator<a> CREATOR = new C0056a();

    /* renamed from: d1.a$a, reason: collision with other inner class name */
    class C0056a implements Parcelable.Creator<a> {
        C0056a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i6) {
            return new a[i6];
        }
    }

    a(Parcel parcel) {
        this.f2916a = (String) c1.j(parcel.readString());
        this.f2917b = (String) c1.j(parcel.readString());
        this.f2918c = parcel.readLong();
        this.f2919d = parcel.readLong();
        this.f2920e = (byte[]) c1.j(parcel.createByteArray());
    }

    public a(String str, String str2, long j6, long j7, byte[] bArr) {
        this.f2916a = str;
        this.f2917b = str2;
        this.f2918c = j6;
        this.f2919d = j7;
        this.f2920e = bArr;
    }

    @Override // b1.a.b
    public /* synthetic */ void a(m2.b bVar) {
        b1.b.c(this, bVar);
    }

    @Override // b1.a.b
    public y1 b() {
        String str = this.f2916a;
        str.hashCode();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return f2915l;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return f2914k;
            default:
                return null;
        }
    }

    @Override // b1.a.b
    public byte[] c() {
        if (b() != null) {
            return this.f2920e;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2918c == aVar.f2918c && this.f2919d == aVar.f2919d && c1.c(this.f2916a, aVar.f2916a) && c1.c(this.f2917b, aVar.f2917b) && Arrays.equals(this.f2920e, aVar.f2920e);
    }

    public int hashCode() {
        if (this.f2921j == 0) {
            String str = this.f2916a;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f2917b;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            long j6 = this.f2918c;
            int i6 = (((hashCode + hashCode2) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31;
            long j7 = this.f2919d;
            this.f2921j = ((i6 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + Arrays.hashCode(this.f2920e);
        }
        return this.f2921j;
    }

    public String toString() {
        return "EMSG: scheme=" + this.f2916a + ", id=" + this.f2919d + ", durationMs=" + this.f2918c + ", value=" + this.f2917b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f2916a);
        parcel.writeString(this.f2917b);
        parcel.writeLong(this.f2918c);
        parcel.writeLong(this.f2919d);
        parcel.writeByteArray(this.f2920e);
    }
}
