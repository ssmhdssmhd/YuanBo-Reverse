package d2;

import android.text.TextUtils;
import i2.c1;
import i2.i0;
import i2.t;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
final class c {

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f2926c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f2927d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* renamed from: a, reason: collision with root package name */
    private final i0 f2928a = new i0();

    /* renamed from: b, reason: collision with root package name */
    private final StringBuilder f2929b = new StringBuilder();

    private void a(d dVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int indexOf = str.indexOf(91);
        if (indexOf != -1) {
            Matcher matcher = f2926c.matcher(str.substring(indexOf));
            if (matcher.matches()) {
                dVar.z((String) i2.a.e(matcher.group(1)));
            }
            str = str.substring(0, indexOf);
        }
        String[] U0 = c1.U0(str, "\\.");
        String str2 = U0[0];
        int indexOf2 = str2.indexOf(35);
        if (indexOf2 != -1) {
            dVar.y(str2.substring(0, indexOf2));
            dVar.x(str2.substring(indexOf2 + 1));
        } else {
            dVar.y(str2);
        }
        if (U0.length > 1) {
            dVar.w((String[]) c1.J0(U0, 1, U0.length));
        }
    }

    private static boolean b(i0 i0Var) {
        int f6 = i0Var.f();
        int g6 = i0Var.g();
        byte[] e6 = i0Var.e();
        if (f6 + 2 > g6) {
            return false;
        }
        int i6 = f6 + 1;
        if (e6[f6] != 47) {
            return false;
        }
        int i7 = i6 + 1;
        if (e6[i6] != 42) {
            return false;
        }
        while (true) {
            int i8 = i7 + 1;
            if (i8 >= g6) {
                i0Var.T(g6 - i0Var.f());
                return true;
            }
            if (((char) e6[i7]) == '*' && ((char) e6[i8]) == '/') {
                i7 = i8 + 1;
                g6 = i7;
            } else {
                i7 = i8;
            }
        }
    }

    private static boolean c(i0 i0Var) {
        char k6 = k(i0Var, i0Var.f());
        if (k6 != '\t' && k6 != '\n' && k6 != '\f' && k6 != '\r' && k6 != ' ') {
            return false;
        }
        i0Var.T(1);
        return true;
    }

    private static void e(String str, d dVar) {
        int i6;
        Matcher matcher = f2927d.matcher(l2.b.e(str));
        if (!matcher.matches()) {
            t.i("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        i6 = 2;
        String str2 = (String) i2.a.e(matcher.group(2));
        str2.hashCode();
        switch (str2) {
            case "%":
                i6 = 3;
            case "em":
                dVar.t(i6);
                dVar.s(Float.parseFloat((String) i2.a.e(matcher.group(1))));
                return;
            case "px":
                dVar.t(1);
                dVar.s(Float.parseFloat((String) i2.a.e(matcher.group(1))));
                return;
            default:
                throw new IllegalStateException();
        }
    }

    private static String f(i0 i0Var, StringBuilder sb) {
        boolean z5 = false;
        sb.setLength(0);
        int f6 = i0Var.f();
        int g6 = i0Var.g();
        while (f6 < g6 && !z5) {
            char c6 = (char) i0Var.e()[f6];
            if ((c6 < 'A' || c6 > 'Z') && ((c6 < 'a' || c6 > 'z') && !((c6 >= '0' && c6 <= '9') || c6 == '#' || c6 == '-' || c6 == '.' || c6 == '_'))) {
                z5 = true;
            } else {
                f6++;
                sb.append(c6);
            }
        }
        i0Var.T(f6 - i0Var.f());
        return sb.toString();
    }

    static String g(i0 i0Var, StringBuilder sb) {
        n(i0Var);
        if (i0Var.a() == 0) {
            return null;
        }
        String f6 = f(i0Var, sb);
        if (!"".equals(f6)) {
            return f6;
        }
        return "" + ((char) i0Var.F());
    }

    private static String h(i0 i0Var, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z5 = false;
        while (!z5) {
            int f6 = i0Var.f();
            String g6 = g(i0Var, sb);
            if (g6 == null) {
                return null;
            }
            if ("}".equals(g6) || ";".equals(g6)) {
                i0Var.S(f6);
                z5 = true;
            } else {
                sb2.append(g6);
            }
        }
        return sb2.toString();
    }

    private static String i(i0 i0Var, StringBuilder sb) {
        n(i0Var);
        if (i0Var.a() < 5 || !"::cue".equals(i0Var.C(5))) {
            return null;
        }
        int f6 = i0Var.f();
        String g6 = g(i0Var, sb);
        if (g6 == null) {
            return null;
        }
        if ("{".equals(g6)) {
            i0Var.S(f6);
            return "";
        }
        String l6 = "(".equals(g6) ? l(i0Var) : null;
        if (")".equals(g(i0Var, sb))) {
            return l6;
        }
        return null;
    }

    private static void j(i0 i0Var, d dVar, StringBuilder sb) {
        n(i0Var);
        String f6 = f(i0Var, sb);
        if (!"".equals(f6) && ":".equals(g(i0Var, sb))) {
            n(i0Var);
            String h6 = h(i0Var, sb);
            if (h6 == null || "".equals(h6)) {
                return;
            }
            int f7 = i0Var.f();
            String g6 = g(i0Var, sb);
            if (!";".equals(g6)) {
                if (!"}".equals(g6)) {
                    return;
                } else {
                    i0Var.S(f7);
                }
            }
            if ("color".equals(f6)) {
                dVar.q(i2.g.b(h6));
                return;
            }
            if ("background-color".equals(f6)) {
                dVar.n(i2.g.b(h6));
                return;
            }
            boolean z5 = true;
            if ("ruby-position".equals(f6)) {
                if ("over".equals(h6)) {
                    dVar.v(1);
                    return;
                } else {
                    if ("under".equals(h6)) {
                        dVar.v(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(f6)) {
                if (!"all".equals(h6) && !h6.startsWith("digits")) {
                    z5 = false;
                }
                dVar.p(z5);
                return;
            }
            if ("text-decoration".equals(f6)) {
                if ("underline".equals(h6)) {
                    dVar.A(true);
                    return;
                }
                return;
            }
            if ("font-family".equals(f6)) {
                dVar.r(h6);
                return;
            }
            if ("font-weight".equals(f6)) {
                if ("bold".equals(h6)) {
                    dVar.o(true);
                }
            } else if ("font-style".equals(f6)) {
                if ("italic".equals(h6)) {
                    dVar.u(true);
                }
            } else if ("font-size".equals(f6)) {
                e(h6, dVar);
            }
        }
    }

    private static char k(i0 i0Var, int i6) {
        return (char) i0Var.e()[i6];
    }

    private static String l(i0 i0Var) {
        int f6 = i0Var.f();
        int g6 = i0Var.g();
        boolean z5 = false;
        while (f6 < g6 && !z5) {
            int i6 = f6 + 1;
            z5 = ((char) i0Var.e()[f6]) == ')';
            f6 = i6;
        }
        return i0Var.C((f6 - 1) - i0Var.f()).trim();
    }

    static void m(i0 i0Var) {
        while (!TextUtils.isEmpty(i0Var.q())) {
        }
    }

    static void n(i0 i0Var) {
        while (true) {
            for (boolean z5 = true; i0Var.a() > 0 && z5; z5 = false) {
                if (!c(i0Var) && !b(i0Var)) {
                }
            }
            return;
        }
    }

    public List<d> d(i0 i0Var) {
        this.f2929b.setLength(0);
        int f6 = i0Var.f();
        m(i0Var);
        this.f2928a.Q(i0Var.e(), i0Var.f());
        this.f2928a.S(f6);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String i6 = i(this.f2928a, this.f2929b);
            if (i6 == null || !"{".equals(g(this.f2928a, this.f2929b))) {
                return arrayList;
            }
            d dVar = new d();
            a(dVar, i6);
            String str = null;
            boolean z5 = false;
            while (!z5) {
                int f7 = this.f2928a.f();
                String g6 = g(this.f2928a, this.f2929b);
                boolean z6 = g6 == null || "}".equals(g6);
                if (!z6) {
                    this.f2928a.S(f7);
                    j(this.f2928a, dVar, this.f2929b);
                }
                str = g6;
                z5 = z6;
            }
            if ("}".equals(str)) {
                arrayList.add(dVar);
            }
        }
    }
}
