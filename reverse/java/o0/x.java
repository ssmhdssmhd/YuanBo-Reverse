package o0;

import b1.a;
import i2.c1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f8432c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a, reason: collision with root package name */
    public int f8433a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f8434b = -1;

    private boolean b(String str) {
        Matcher matcher = f8432c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt((String) c1.j(matcher.group(1)), 16);
            int parseInt2 = Integer.parseInt((String) c1.j(matcher.group(2)), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f8433a = parseInt;
            this.f8434b = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean a() {
        return (this.f8433a == -1 || this.f8434b == -1) ? false : true;
    }

    public boolean c(b1.a aVar) {
        for (int i6 = 0; i6 < aVar.h(); i6++) {
            a.b g6 = aVar.g(i6);
            if (g6 instanceof g1.e) {
                g1.e eVar = (g1.e) g6;
                if ("iTunSMPB".equals(eVar.f3975c) && b(eVar.f3976d)) {
                    return true;
                }
            } else if (g6 instanceof g1.j) {
                g1.j jVar = (g1.j) g6;
                if ("com.apple.iTunes".equals(jVar.f3987b) && "iTunSMPB".equals(jVar.f3988c) && b(jVar.f3989d)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public boolean d(int i6) {
        int i7 = i6 >> 12;
        int i8 = i6 & 4095;
        if (i7 <= 0 && i8 <= 0) {
            return false;
        }
        this.f8433a = i7;
        this.f8434b = i8;
        return true;
    }
}
