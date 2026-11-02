package h1;

import android.os.Parcel;
import android.os.Parcelable;
import b1.a;
import h0.m2;
import h0.y1;

/* loaded from: classes.dex */
public final class e implements a.b {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final float f5127a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5128b;

    class a implements Parcelable.Creator<e> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i6) {
            return new e[i6];
        }
    }

    public e(float f6, int i6) {
        this.f5127a = f6;
        this.f5128b = i6;
    }

    private e(Parcel parcel) {
        this.f5127a = parcel.readFloat();
        this.f5128b = parcel.readInt();
    }

    /* synthetic */ e(Parcel parcel, a aVar) {
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
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        return this.f5127a == eVar.f5127a && this.f5128b == eVar.f5128b;
    }

    public int hashCode() {
        return ((527 + o2.c.a(this.f5127a)) * 31) + this.f5128b;
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.f5127a + ", svcTemporalLayerCount=" + this.f5128b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeFloat(this.f5127a);
        parcel.writeInt(this.f5128b);
    }
}
