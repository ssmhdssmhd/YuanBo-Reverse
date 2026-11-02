package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.m;
import androidx.lifecycle.d;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    final int[] f611a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<String> f612b;

    /* renamed from: c, reason: collision with root package name */
    final int[] f613c;

    /* renamed from: d, reason: collision with root package name */
    final int[] f614d;

    /* renamed from: e, reason: collision with root package name */
    final int f615e;

    /* renamed from: j, reason: collision with root package name */
    final int f616j;

    /* renamed from: k, reason: collision with root package name */
    final String f617k;

    /* renamed from: l, reason: collision with root package name */
    final int f618l;

    /* renamed from: m, reason: collision with root package name */
    final int f619m;

    /* renamed from: n, reason: collision with root package name */
    final CharSequence f620n;

    /* renamed from: o, reason: collision with root package name */
    final int f621o;

    /* renamed from: p, reason: collision with root package name */
    final CharSequence f622p;

    /* renamed from: q, reason: collision with root package name */
    final ArrayList<String> f623q;

    /* renamed from: r, reason: collision with root package name */
    final ArrayList<String> f624r;

    /* renamed from: s, reason: collision with root package name */
    final boolean f625s;

    static class a implements Parcelable.Creator<b> {
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

    public b(Parcel parcel) {
        this.f611a = parcel.createIntArray();
        this.f612b = parcel.createStringArrayList();
        this.f613c = parcel.createIntArray();
        this.f614d = parcel.createIntArray();
        this.f615e = parcel.readInt();
        this.f616j = parcel.readInt();
        this.f617k = parcel.readString();
        this.f618l = parcel.readInt();
        this.f619m = parcel.readInt();
        this.f620n = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f621o = parcel.readInt();
        this.f622p = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f623q = parcel.createStringArrayList();
        this.f624r = parcel.createStringArrayList();
        this.f625s = parcel.readInt() != 0;
    }

    public b(androidx.fragment.app.a aVar) {
        int size = aVar.f723a.size();
        this.f611a = new int[size * 5];
        if (!aVar.f730h) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f612b = new ArrayList<>(size);
        this.f613c = new int[size];
        this.f614d = new int[size];
        int i6 = 0;
        int i7 = 0;
        while (i6 < size) {
            m.a aVar2 = aVar.f723a.get(i6);
            int i8 = i7 + 1;
            this.f611a[i7] = aVar2.f741a;
            ArrayList<String> arrayList = this.f612b;
            Fragment fragment = aVar2.f742b;
            arrayList.add(fragment != null ? fragment.f565e : null);
            int[] iArr = this.f611a;
            int i9 = i8 + 1;
            iArr[i8] = aVar2.f743c;
            int i10 = i9 + 1;
            iArr[i9] = aVar2.f744d;
            int i11 = i10 + 1;
            iArr[i10] = aVar2.f745e;
            iArr[i11] = aVar2.f746f;
            this.f613c[i6] = aVar2.f747g.ordinal();
            this.f614d[i6] = aVar2.f748h.ordinal();
            i6++;
            i7 = i11 + 1;
        }
        this.f615e = aVar.f728f;
        this.f616j = aVar.f729g;
        this.f617k = aVar.f732j;
        this.f618l = aVar.f610u;
        this.f619m = aVar.f733k;
        this.f620n = aVar.f734l;
        this.f621o = aVar.f735m;
        this.f622p = aVar.f736n;
        this.f623q = aVar.f737o;
        this.f624r = aVar.f738p;
        this.f625s = aVar.f739q;
    }

    public androidx.fragment.app.a d(i iVar) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(iVar);
        int i6 = 0;
        int i7 = 0;
        while (i6 < this.f611a.length) {
            m.a aVar2 = new m.a();
            int i8 = i6 + 1;
            aVar2.f741a = this.f611a[i6];
            if (i.H) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i7 + " base fragment #" + this.f611a[i8]);
            }
            String str = this.f612b.get(i7);
            aVar2.f742b = str != null ? iVar.f650g.get(str) : null;
            aVar2.f747g = d.c.values()[this.f613c[i7]];
            aVar2.f748h = d.c.values()[this.f614d[i7]];
            int[] iArr = this.f611a;
            int i9 = i8 + 1;
            int i10 = iArr[i8];
            aVar2.f743c = i10;
            int i11 = i9 + 1;
            int i12 = iArr[i9];
            aVar2.f744d = i12;
            int i13 = i11 + 1;
            int i14 = iArr[i11];
            aVar2.f745e = i14;
            int i15 = iArr[i13];
            aVar2.f746f = i15;
            aVar.f724b = i10;
            aVar.f725c = i12;
            aVar.f726d = i14;
            aVar.f727e = i15;
            aVar.b(aVar2);
            i7++;
            i6 = i13 + 1;
        }
        aVar.f728f = this.f615e;
        aVar.f729g = this.f616j;
        aVar.f732j = this.f617k;
        aVar.f610u = this.f618l;
        aVar.f730h = true;
        aVar.f733k = this.f619m;
        aVar.f734l = this.f620n;
        aVar.f735m = this.f621o;
        aVar.f736n = this.f622p;
        aVar.f737o = this.f623q;
        aVar.f738p = this.f624r;
        aVar.f739q = this.f625s;
        aVar.c(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeIntArray(this.f611a);
        parcel.writeStringList(this.f612b);
        parcel.writeIntArray(this.f613c);
        parcel.writeIntArray(this.f614d);
        parcel.writeInt(this.f615e);
        parcel.writeInt(this.f616j);
        parcel.writeString(this.f617k);
        parcel.writeInt(this.f618l);
        parcel.writeInt(this.f619m);
        TextUtils.writeToParcel(this.f620n, parcel, 0);
        parcel.writeInt(this.f621o);
        TextUtils.writeToParcel(this.f622p, parcel, 0);
        parcel.writeStringList(this.f623q);
        parcel.writeStringList(this.f624r);
        parcel.writeInt(this.f625s ? 1 : 0);
    }
}
