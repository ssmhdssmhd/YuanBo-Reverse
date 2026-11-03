package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class b extends a {

    /* renamed from: d, reason: collision with root package name */
    private final SparseIntArray f1445d;

    /* renamed from: e, reason: collision with root package name */
    private final Parcel f1446e;

    /* renamed from: f, reason: collision with root package name */
    private final int f1447f;

    /* renamed from: g, reason: collision with root package name */
    private final int f1448g;

    /* renamed from: h, reason: collision with root package name */
    private final String f1449h;

    /* renamed from: i, reason: collision with root package name */
    private int f1450i;

    /* renamed from: j, reason: collision with root package name */
    private int f1451j;

    /* renamed from: k, reason: collision with root package name */
    private int f1452k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new f.a(), new f.a(), new f.a());
    }

    private b(Parcel parcel, int i6, int i7, String str, f.a<String, Method> aVar, f.a<String, Method> aVar2, f.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f1445d = new SparseIntArray();
        this.f1450i = -1;
        this.f1452k = -1;
        this.f1446e = parcel;
        this.f1447f = i6;
        this.f1448g = i7;
        this.f1451j = i6;
        this.f1449h = str;
    }

    @Override // androidx.versionedparcelable.a
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f1446e.writeInt(-1);
        } else {
            this.f1446e.writeInt(bArr.length);
            this.f1446e.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f1446e, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void E(int i6) {
        this.f1446e.writeInt(i6);
    }

    @Override // androidx.versionedparcelable.a
    public void G(Parcelable parcelable) {
        this.f1446e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void I(String str) {
        this.f1446e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a() {
        int i6 = this.f1450i;
        if (i6 >= 0) {
            int i7 = this.f1445d.get(i6);
            int dataPosition = this.f1446e.dataPosition();
            this.f1446e.setDataPosition(i7);
            this.f1446e.writeInt(dataPosition - i7);
            this.f1446e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a b() {
        Parcel parcel = this.f1446e;
        int dataPosition = parcel.dataPosition();
        int i6 = this.f1451j;
        if (i6 == this.f1447f) {
            i6 = this.f1448g;
        }
        return new b(parcel, dataPosition, i6, this.f1449h + "  ", this.f1442a, this.f1443b, this.f1444c);
    }

    @Override // androidx.versionedparcelable.a
    public boolean g() {
        return this.f1446e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.a
    public byte[] i() {
        int readInt = this.f1446e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f1446e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f1446e);
    }

    @Override // androidx.versionedparcelable.a
    public boolean m(int i6) {
        while (this.f1451j < this.f1448g) {
            int i7 = this.f1452k;
            if (i7 == i6) {
                return true;
            }
            if (String.valueOf(i7).compareTo(String.valueOf(i6)) > 0) {
                return false;
            }
            this.f1446e.setDataPosition(this.f1451j);
            int readInt = this.f1446e.readInt();
            this.f1452k = this.f1446e.readInt();
            this.f1451j += readInt;
        }
        return this.f1452k == i6;
    }

    @Override // androidx.versionedparcelable.a
    public int o() {
        return this.f1446e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public <T extends Parcelable> T q() {
        return (T) this.f1446e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public String s() {
        return this.f1446e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public void w(int i6) {
        a();
        this.f1450i = i6;
        this.f1445d.put(i6, this.f1446e.dataPosition());
        E(0);
        E(i6);
    }

    @Override // androidx.versionedparcelable.a
    public void y(boolean z5) {
        this.f1446e.writeInt(z5 ? 1 : 0);
    }
}
