package i1;

import android.os.Parcel;
import android.os.Parcelable;
import i2.i0;
import i2.r0;

/* loaded from: classes.dex */
public final class g extends b {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final long f5533a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5534b;

    class a implements Parcelable.Creator<g> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel.readLong(), parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public g[] newArray(int i6) {
            return new g[i6];
        }
    }

    private g(long j6, long j7) {
        this.f5533a = j6;
        this.f5534b = j7;
    }

    /* synthetic */ g(long j6, long j7, a aVar) {
        this(j6, j7);
    }

    static g d(i0 i0Var, long j6, r0 r0Var) {
        long e6 = e(i0Var, j6);
        return new g(e6, r0Var.b(e6));
    }

    static long e(i0 i0Var, long j6) {
        long F = i0Var.F();
        if ((128 & F) != 0) {
            return 8589934591L & ((((F & 1) << 32) | i0Var.H()) + j6);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeLong(this.f5533a);
        parcel.writeLong(this.f5534b);
    }
}
