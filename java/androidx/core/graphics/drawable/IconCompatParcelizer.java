package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(androidx.versionedparcelable.a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f423a = aVar.p(iconCompat.f423a, 1);
        iconCompat.f425c = aVar.j(iconCompat.f425c, 2);
        iconCompat.f426d = aVar.r(iconCompat.f426d, 3);
        iconCompat.f427e = aVar.p(iconCompat.f427e, 4);
        iconCompat.f428f = aVar.p(iconCompat.f428f, 5);
        iconCompat.f429g = (ColorStateList) aVar.r(iconCompat.f429g, 6);
        iconCompat.f431i = aVar.t(iconCompat.f431i, 7);
        iconCompat.f432j = aVar.t(iconCompat.f432j, 8);
        iconCompat.m();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, androidx.versionedparcelable.a aVar) {
        aVar.x(true, true);
        iconCompat.n(aVar.f());
        int i6 = iconCompat.f423a;
        if (-1 != i6) {
            aVar.F(i6, 1);
        }
        byte[] bArr = iconCompat.f425c;
        if (bArr != null) {
            aVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f426d;
        if (parcelable != null) {
            aVar.H(parcelable, 3);
        }
        int i7 = iconCompat.f427e;
        if (i7 != 0) {
            aVar.F(i7, 4);
        }
        int i8 = iconCompat.f428f;
        if (i8 != 0) {
            aVar.F(i8, 5);
        }
        ColorStateList colorStateList = iconCompat.f429g;
        if (colorStateList != null) {
            aVar.H(colorStateList, 6);
        }
        String str = iconCompat.f431i;
        if (str != null) {
            aVar.J(str, 7);
        }
        String str2 = iconCompat.f432j;
        if (str2 != null) {
            aVar.J(str2, 8);
        }
    }
}
