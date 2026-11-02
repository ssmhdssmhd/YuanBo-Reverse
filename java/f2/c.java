package f2;

import android.content.res.Resources;
import android.text.TextUtils;
import h0.y1;
import i2.c1;
import i2.x;
import java.util.Locale;

/* loaded from: classes.dex */
public class c implements k {

    /* renamed from: a, reason: collision with root package name */
    private final Resources f3795a;

    public c(Resources resources) {
        this.f3795a = (Resources) i2.a.e(resources);
    }

    private String b(y1 y1Var) {
        Resources resources;
        int i6;
        int i7 = y1Var.C;
        if (i7 == -1 || i7 < 1) {
            return "";
        }
        if (i7 == 1) {
            resources = this.f3795a;
            i6 = i.f3861j;
        } else if (i7 == 2) {
            resources = this.f3795a;
            i6 = i.f3869r;
        } else if (i7 == 6 || i7 == 7) {
            resources = this.f3795a;
            i6 = i.f3871t;
        } else if (i7 != 8) {
            resources = this.f3795a;
            i6 = i.f3870s;
        } else {
            resources = this.f3795a;
            i6 = i.f3872u;
        }
        return resources.getString(i6);
    }

    private String c(y1 y1Var) {
        int i6 = y1Var.f5062l;
        return i6 == -1 ? "" : this.f3795a.getString(i.f3860i, Float.valueOf(i6 / 1000000.0f));
    }

    private String d(y1 y1Var) {
        return TextUtils.isEmpty(y1Var.f5056b) ? "" : y1Var.f5056b;
    }

    private String e(y1 y1Var) {
        String j6 = j(f(y1Var), h(y1Var));
        return TextUtils.isEmpty(j6) ? d(y1Var) : j6;
    }

    private String f(y1 y1Var) {
        String str = y1Var.f5057c;
        if (TextUtils.isEmpty(str) || "und".equals(str)) {
            return "";
        }
        Locale forLanguageTag = c1.f5548a >= 21 ? Locale.forLanguageTag(str) : new Locale(str);
        Locale R = c1.R();
        String displayName = forLanguageTag.getDisplayName(R);
        if (TextUtils.isEmpty(displayName)) {
            return "";
        }
        try {
            int offsetByCodePoints = displayName.offsetByCodePoints(0, 1);
            return displayName.substring(0, offsetByCodePoints).toUpperCase(R) + displayName.substring(offsetByCodePoints);
        } catch (IndexOutOfBoundsException unused) {
            return displayName;
        }
    }

    private String g(y1 y1Var) {
        int i6 = y1Var.f5071u;
        int i7 = y1Var.f5072v;
        return (i6 == -1 || i7 == -1) ? "" : this.f3795a.getString(i.f3862k, Integer.valueOf(i6), Integer.valueOf(i7));
    }

    private String h(y1 y1Var) {
        String string = (y1Var.f5059e & 2) != 0 ? this.f3795a.getString(i.f3863l) : "";
        if ((y1Var.f5059e & 4) != 0) {
            string = j(string, this.f3795a.getString(i.f3866o));
        }
        if ((y1Var.f5059e & 8) != 0) {
            string = j(string, this.f3795a.getString(i.f3865n));
        }
        return (y1Var.f5059e & 1088) != 0 ? j(string, this.f3795a.getString(i.f3864m)) : string;
    }

    private static int i(y1 y1Var) {
        int k6 = x.k(y1Var.f5066p);
        if (k6 != -1) {
            return k6;
        }
        if (x.n(y1Var.f5063m) != null) {
            return 2;
        }
        if (x.c(y1Var.f5063m) != null) {
            return 1;
        }
        if (y1Var.f5071u == -1 && y1Var.f5072v == -1) {
            return (y1Var.C == -1 && y1Var.D == -1) ? -1 : 1;
        }
        return 2;
    }

    private String j(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                str = TextUtils.isEmpty(str) ? str2 : this.f3795a.getString(i.f3859h, str, str2);
            }
        }
        return str;
    }

    @Override // f2.k
    public String a(y1 y1Var) {
        int i6 = i(y1Var);
        String j6 = i6 == 2 ? j(h(y1Var), g(y1Var), c(y1Var)) : i6 == 1 ? j(e(y1Var), b(y1Var), c(y1Var)) : e(y1Var);
        return j6.length() == 0 ? this.f3795a.getString(i.f3873v) : j6;
    }
}
