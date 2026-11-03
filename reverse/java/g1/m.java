package g1;

import android.os.Parcel;
import android.os.Parcelable;
import com.tendcloud.tenddata.ab;
import h0.m2;
import i2.c1;
import java.util.ArrayList;
import java.util.List;
import m2.q;

/* loaded from: classes.dex */
public final class m extends i {
    public static final Parcelable.Creator<m> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f3997b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public final String f3998c;

    /* renamed from: d, reason: collision with root package name */
    public final q<String> f3999d;

    class a implements Parcelable.Creator<m> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i6) {
            return new m[i6];
        }
    }

    private m(Parcel parcel) {
        this((String) i2.a.e(parcel.readString()), parcel.readString(), q.n((String[]) i2.a.e(parcel.createStringArray())));
    }

    /* synthetic */ m(Parcel parcel, a aVar) {
        this(parcel);
    }

    public m(String str, String str2, List<String> list) {
        super(str);
        i2.a.a(!list.isEmpty());
        this.f3997b = str2;
        q<String> m6 = q.m(list);
        this.f3999d = m6;
        this.f3998c = m6.get(0);
    }

    private static List<Integer> d(String str) {
        int parseInt;
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                parseInt = Integer.parseInt(str.substring(8, 10));
            } else {
                if (str.length() < 7) {
                    if (str.length() >= 4) {
                        parseInt = Integer.parseInt(str.substring(0, 4));
                    }
                    return arrayList;
                }
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                parseInt = Integer.parseInt(str.substring(5, 7));
            }
            arrayList.add(Integer.valueOf(parseInt));
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // g1.i, b1.a.b
    public void a(m2.b bVar) {
        String str = this.f3986a;
        str.hashCode();
        char c6 = 65535;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    c6 = 0;
                    break;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    c6 = 1;
                    break;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    c6 = 2;
                    break;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    c6 = 3;
                    break;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    c6 = 4;
                    break;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    c6 = 5;
                    break;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    c6 = 6;
                    break;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    c6 = 7;
                    break;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    c6 = '\b';
                    break;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    c6 = '\t';
                    break;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    c6 = '\n';
                    break;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    c6 = 11;
                    break;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    c6 = '\f';
                    break;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    c6 = '\r';
                    break;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    c6 = 14;
                    break;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    c6 = 15;
                    break;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    c6 = 16;
                    break;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    c6 = 17;
                    break;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    c6 = 18;
                    break;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    c6 = 19;
                    break;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    c6 = 20;
                    break;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    c6 = 21;
                    break;
                }
                break;
        }
        try {
            switch (c6) {
                case 0:
                case '\n':
                    bVar.N(this.f3999d.get(0));
                    break;
                case 1:
                case 11:
                    bVar.S(this.f3999d.get(0));
                    break;
                case 2:
                case '\f':
                    String str2 = this.f3999d.get(0);
                    bVar.f0(Integer.valueOf(Integer.parseInt(str2.substring(2, 4)))).e0(Integer.valueOf(Integer.parseInt(str2.substring(0, 2))));
                    break;
                case 3:
                case ab.b.API_TYPE_INDUSTRY /* 17 */:
                    bVar.O(this.f3999d.get(0));
                    break;
                case 4:
                case 18:
                    bVar.M(this.f3999d.get(0));
                    break;
                case 5:
                case 19:
                    bVar.T(this.f3999d.get(0));
                    break;
                case 6:
                case 20:
                    String[] U0 = c1.U0(this.f3999d.get(0), "/");
                    bVar.p0(Integer.valueOf(Integer.parseInt(U0[0]))).o0(U0.length > 1 ? Integer.valueOf(Integer.parseInt(U0[1])) : null);
                    break;
                case 7:
                case 16:
                    bVar.m0(this.f3999d.get(0));
                    break;
                case '\b':
                case 15:
                    bVar.r0(this.f3999d.get(0));
                    break;
                case '\t':
                case 21:
                    bVar.g0(Integer.valueOf(Integer.parseInt(this.f3999d.get(0))));
                    break;
                case '\r':
                    List<Integer> d6 = d(this.f3999d.get(0));
                    int size = d6.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                bVar.e0(d6.get(2));
                            }
                        }
                        bVar.f0(d6.get(1));
                    }
                    bVar.g0(d6.get(0));
                    break;
                case 14:
                    List<Integer> d7 = d(this.f3999d.get(0));
                    int size2 = d7.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                bVar.h0(d7.get(2));
                            }
                        }
                        bVar.i0(d7.get(1));
                    }
                    bVar.j0(d7.get(0));
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        return c1.c(this.f3986a, mVar.f3986a) && c1.c(this.f3997b, mVar.f3997b) && this.f3999d.equals(mVar.f3999d);
    }

    public int hashCode() {
        int hashCode = (527 + this.f3986a.hashCode()) * 31;
        String str = this.f3997b;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f3999d.hashCode();
    }

    @Override // g1.i
    public String toString() {
        return this.f3986a + ": description=" + this.f3997b + ": values=" + this.f3999d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i6) {
        parcel.writeString(this.f3986a);
        parcel.writeString(this.f3997b);
        parcel.writeStringArray((String[]) this.f3999d.toArray(new String[0]));
    }
}
