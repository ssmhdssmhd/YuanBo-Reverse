package b2;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import i2.c1;
import i2.t;
import java.util.ArrayDeque;
import java.util.Map;

/* loaded from: classes.dex */
final class f {
    public static void a(Spannable spannable, int i6, int i7, g gVar, d dVar, Map<String, g> map, int i8) {
        d e6;
        Object cVar;
        g f6;
        Object absoluteSizeSpan;
        int i9;
        if (gVar.l() != -1) {
            spannable.setSpan(new StyleSpan(gVar.l()), i6, i7, 33);
        }
        if (gVar.s()) {
            spannable.setSpan(new StrikethroughSpan(), i6, i7, 33);
        }
        if (gVar.t()) {
            spannable.setSpan(new UnderlineSpan(), i6, i7, 33);
        }
        if (gVar.q()) {
            y1.d.a(spannable, new ForegroundColorSpan(gVar.c()), i6, i7, 33);
        }
        if (gVar.p()) {
            y1.d.a(spannable, new BackgroundColorSpan(gVar.b()), i6, i7, 33);
        }
        if (gVar.d() != null) {
            y1.d.a(spannable, new TypefaceSpan(gVar.d()), i6, i7, 33);
        }
        if (gVar.o() != null) {
            b bVar = (b) i2.a.e(gVar.o());
            int i10 = bVar.f1712a;
            if (i10 == -1) {
                i10 = (i8 == 2 || i8 == 1) ? 3 : 1;
                i9 = 1;
            } else {
                i9 = bVar.f1713b;
            }
            int i11 = bVar.f1714c;
            if (i11 == -2) {
                i11 = 1;
            }
            y1.d.a(spannable, new y1.e(i10, i9, i11), i6, i7, 33);
        }
        int j6 = gVar.j();
        if (j6 == 2) {
            d d6 = d(dVar, map);
            if (d6 != null && (e6 = e(d6, map)) != null) {
                if (e6.g() != 1 || e6.f(0).f1733b == null) {
                    t.f("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) c1.j(e6.f(0).f1733b);
                    g f7 = f(e6.f1737f, e6.l(), map);
                    int i12 = f7 != null ? f7.i() : -1;
                    if (i12 == -1 && (f6 = f(d6.f1737f, d6.l(), map)) != null) {
                        i12 = f6.i();
                    }
                    cVar = new y1.c(str, i12);
                    spannable.setSpan(cVar, i6, i7, 33);
                }
            }
        } else if (j6 == 3 || j6 == 4) {
            cVar = new a();
            spannable.setSpan(cVar, i6, i7, 33);
        }
        if (gVar.n()) {
            y1.d.a(spannable, new y1.a(), i6, i7, 33);
        }
        int f8 = gVar.f();
        if (f8 == 1) {
            absoluteSizeSpan = new AbsoluteSizeSpan((int) gVar.e(), true);
        } else if (f8 == 2) {
            absoluteSizeSpan = new RelativeSizeSpan(gVar.e());
        } else if (f8 != 3) {
            return;
        } else {
            absoluteSizeSpan = new RelativeSizeSpan(gVar.e() / 100.0f);
        }
        y1.d.a(spannable, absoluteSizeSpan, i6, i7, 33);
    }

    static String b(String str) {
        return str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    private static d d(d dVar, Map<String, g> map) {
        while (dVar != null) {
            g f6 = f(dVar.f1737f, dVar.l(), map);
            if (f6 != null && f6.j() == 1) {
                return dVar;
            }
            dVar = dVar.f1741j;
        }
        return null;
    }

    private static d e(d dVar, Map<String, g> map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(dVar);
        while (!arrayDeque.isEmpty()) {
            d dVar2 = (d) arrayDeque.pop();
            g f6 = f(dVar2.f1737f, dVar2.l(), map);
            if (f6 != null && f6.j() == 3) {
                return dVar2;
            }
            for (int g6 = dVar2.g() - 1; g6 >= 0; g6--) {
                arrayDeque.push(dVar2.f(g6));
            }
        }
        return null;
    }

    public static g f(g gVar, String[] strArr, Map<String, g> map) {
        int i6 = 0;
        if (gVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                g gVar2 = new g();
                int length = strArr.length;
                while (i6 < length) {
                    gVar2.a(map.get(strArr[i6]));
                    i6++;
                }
                return gVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return gVar.a(map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i6 < length2) {
                    gVar.a(map.get(strArr[i6]));
                    i6++;
                }
            }
        }
        return gVar;
    }
}
