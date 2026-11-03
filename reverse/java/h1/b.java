package h1;

import android.os.Parcel;
import android.os.Parcelable;
import b1.a;
import h0.m2;
import h0.y1;
import o2.g;

/* loaded from: classes.dex */
public final class b implements a.b {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final long f5117a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5118b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5119c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5120d;

    /* renamed from: e, reason: collision with root package name */
    public final long f5121e;

    class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i6) {
            return new b[i6];
        }
    }

    public b(long j6, long j7, long j8, long j9, long j10) {
        this.f5117a = j6;
        this.f5118b = j7;
        this.f5119c = j8;
        this.f5120d = j9;
        this.f5121e = j10;
    }

    private b(Parcel parcel) {
        this.f5117a = parcel.readLong();
        this.f5118b = parcel.readLong();
        this.f5119c = parcel.readLong();
        this.f5120d = parcel.readLong();
        this.f5121e = parcel.readLong();
    }

    /* synthetic */ b(Parcel parcel, a aVar) {
        this(parcel);
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
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f5117a == bVar.f5117a && this.f5118b == bVar.f5118b && this.f5119c == bVar.f5119c && this.f5120d == bVar.f5120d && this.f5121e == bVar.f5121e;
    }

    public int hashCode() {
        return ((((((((527 + g.b(this.f5117a)) * 31) + g.b(this.f5118b)) * 31) + g.b(this.f5119c)) * 31) + g.b(this.f5120d)) * 31) + g.b(this.f5121e);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f5117a + ", photoSize=" + this.f5118b + ", photoPresentationTimestampUs=" + this.f5119c + ", videoStartPosition=" + this.f5120d + ", videoSize=" + this.f5121e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeLong(this.f5117a);
        parcel.writeLong(this.f5118b);
        parcel.writeLong(this.f5119c);
        parcel.writeLong(this.f5120d);
        parcel.writeLong(this.f5121e);
    }
}
