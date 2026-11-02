package a2;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import i2.i0;
import i2.t;
import i2.u;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l2.d;
import u1.b;
import u1.g;
import u1.h;

/* loaded from: classes.dex */
public final class a extends g {

    /* renamed from: q, reason: collision with root package name */
    private static final Pattern f142q = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* renamed from: r, reason: collision with root package name */
    private static final Pattern f143r = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: o, reason: collision with root package name */
    private final StringBuilder f144o;

    /* renamed from: p, reason: collision with root package name */
    private final ArrayList<String> f145p;

    public a() {
        super("SubripDecoder");
        this.f144o = new StringBuilder();
        this.f145p = new ArrayList<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private u1.b C(Spanned spanned, String str) {
        char c6;
        char c7;
        b.C0148b o6 = new b.C0148b().o(spanned);
        if (str == null) {
            return o6.a();
        }
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    c6 = 0;
                    break;
                }
                c6 = 65535;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    c6 = 6;
                    break;
                }
                c6 = 65535;
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    c6 = 3;
                    break;
                }
                c6 = 65535;
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    c6 = 1;
                    break;
                }
                c6 = 65535;
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    c6 = 7;
                    break;
                }
                c6 = 65535;
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    c6 = 4;
                    break;
                }
                c6 = 65535;
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    c6 = 2;
                    break;
                }
                c6 = 65535;
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    c6 = '\b';
                    break;
                }
                c6 = 65535;
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    c6 = 5;
                    break;
                }
                c6 = 65535;
                break;
            default:
                c6 = 65535;
                break;
        }
        if (c6 == 0 || c6 == 1 || c6 == 2) {
            o6.l(0);
        } else if (c6 == 3 || c6 == 4 || c6 == 5) {
            o6.l(2);
        } else {
            o6.l(1);
        }
        switch (str.hashCode()) {
            case -685620710:
                if (str.equals("{\\an1}")) {
                    c7 = 0;
                    break;
                }
                c7 = 65535;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    c7 = 1;
                    break;
                }
                c7 = 65535;
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    c7 = 2;
                    break;
                }
                c7 = 65535;
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    c7 = 6;
                    break;
                }
                c7 = 65535;
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    c7 = 7;
                    break;
                }
                c7 = 65535;
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    c7 = '\b';
                    break;
                }
                c7 = 65535;
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    c7 = 3;
                    break;
                }
                c7 = 65535;
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    c7 = 4;
                    break;
                }
                c7 = 65535;
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    c7 = 5;
                    break;
                }
                c7 = 65535;
                break;
            default:
                c7 = 65535;
                break;
        }
        if (c7 == 0 || c7 == 1 || c7 == 2) {
            o6.i(2);
        } else if (c7 == 3 || c7 == 4 || c7 == 5) {
            o6.i(0);
        } else {
            o6.i(1);
        }
        return o6.k(E(o6.d())).h(E(o6.c()), 0).a();
    }

    private Charset D(i0 i0Var) {
        Charset N = i0Var.N();
        return N != null ? N : d.f7489c;
    }

    static float E(int i6) {
        if (i6 == 0) {
            return 0.08f;
        }
        if (i6 == 1) {
            return 0.5f;
        }
        if (i6 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    private static long F(Matcher matcher, int i6) {
        String group = matcher.group(i6 + 1);
        long parseLong = (group != null ? Long.parseLong(group) * 60 * 60 * 1000 : 0L) + (Long.parseLong((String) i2.a.e(matcher.group(i6 + 2))) * 60 * 1000) + (Long.parseLong((String) i2.a.e(matcher.group(i6 + 3))) * 1000);
        String group2 = matcher.group(i6 + 4);
        if (group2 != null) {
            parseLong += Long.parseLong(group2);
        }
        return parseLong * 1000;
    }

    private String G(String str, ArrayList<String> arrayList) {
        String trim = str.trim();
        StringBuilder sb = new StringBuilder(trim);
        Matcher matcher = f143r.matcher(trim);
        int i6 = 0;
        while (matcher.find()) {
            String group = matcher.group();
            arrayList.add(group);
            int start = matcher.start() - i6;
            int length = group.length();
            sb.replace(start, start + length, "");
            i6 += length;
        }
        return sb.toString();
    }

    @Override // u1.g
    protected h A(byte[] bArr, int i6, boolean z5) {
        StringBuilder sb;
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        u uVar = new u();
        i0 i0Var = new i0(bArr, i6);
        Charset D = D(i0Var);
        while (true) {
            String r6 = i0Var.r(D);
            int i7 = 0;
            if (r6 == null) {
                break;
            }
            if (r6.length() != 0) {
                try {
                    Integer.parseInt(r6);
                    r6 = i0Var.r(D);
                } catch (NumberFormatException unused) {
                    sb = new StringBuilder();
                    str = "Skipping invalid index: ";
                }
                if (r6 == null) {
                    t.i("SubripDecoder", "Unexpected end");
                    break;
                }
                Matcher matcher = f142q.matcher(r6);
                if (matcher.matches()) {
                    uVar.a(F(matcher, 1));
                    uVar.a(F(matcher, 6));
                    this.f144o.setLength(0);
                    this.f145p.clear();
                    while (true) {
                        String r7 = i0Var.r(D);
                        if (TextUtils.isEmpty(r7)) {
                            break;
                        }
                        if (this.f144o.length() > 0) {
                            this.f144o.append("<br>");
                        }
                        this.f144o.append(G(r7, this.f145p));
                    }
                    Spanned fromHtml = Html.fromHtml(this.f144o.toString());
                    while (true) {
                        if (i7 >= this.f145p.size()) {
                            str2 = null;
                            break;
                        }
                        str2 = this.f145p.get(i7);
                        if (str2.matches("\\{\\\\an[1-9]\\}")) {
                            break;
                        }
                        i7++;
                    }
                    arrayList.add(C(fromHtml, str2));
                    arrayList.add(u1.b.f9599v);
                } else {
                    sb = new StringBuilder();
                    str = "Skipping invalid timing: ";
                    sb.append(str);
                    sb.append(r6);
                    t.i("SubripDecoder", sb.toString());
                }
            }
        }
        return new b((u1.b[]) arrayList.toArray(new u1.b[0]), uVar.d());
    }
}
