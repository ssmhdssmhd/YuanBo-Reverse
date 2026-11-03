package i1;

import android.os.Parcel;
import android.os.Parcelable;
import i2.c1;
import i2.i0;

/* loaded from: classes.dex */
public final class a extends b {
    public static final Parcelable.Creator<a> CREATOR = new C0087a();

    /* renamed from: a, reason: collision with root package name */
    public final long f5497a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5498b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f5499c;

    /* renamed from: i1.a$a, reason: collision with other inner class name */
    class C0087a implements Parcelable.Creator<a> {
        C0087a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i6) {
            return new a[i6];
        }
    }

    private a(long j6, byte[] bArr, long j7) {
        this.f5497a = j7;
        this.f5498b = j6;
        this.f5499c = bArr;
    }

    private a(Parcel parcel) {
        this.f5497a = parcel.readLong();
        this.f5498b = parcel.readLong();
        this.f5499c = (byte[]) c1.j(parcel.createByteArray());
    }

    /* synthetic */ a(Parcel parcel, C0087a c0087a) {
        this(parcel);
    }

    static a d(i0 i0Var, int i6, long j6) {
        long H = i0Var.H();
        int i7 = i6 - 4;
        byte[] bArr = new byte[i7];
        i0Var.j(bArr, 0, i7);
        return new a(H, bArr, j6);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeLong(this.f5497a);
        parcel.writeLong(this.f5498b);
        parcel.writeByteArray(this.f5499c);
    }
}
