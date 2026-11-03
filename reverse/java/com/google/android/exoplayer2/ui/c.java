package com.google.android.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import com.google.android.exoplayer2.ui.c;
import i2.c1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import m2.r;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f2119a = Pattern.compile("(&#13;)?&#10;");

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f2120a;

        /* renamed from: b, reason: collision with root package name */
        public final Map<String, String> f2121b;

        private b(String str, Map<String, String> map) {
            this.f2120a = str;
            this.f2121b = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.ui.c$c, reason: collision with other inner class name */
    static final class C0047c {

        /* renamed from: e, reason: collision with root package name */
        private static final Comparator<C0047c> f2122e = new Comparator() { // from class: com.google.android.exoplayer2.ui.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e6;
                e6 = c.C0047c.e((c.C0047c) obj, (c.C0047c) obj2);
                return e6;
            }
        };

        /* renamed from: f, reason: collision with root package name */
        private static final Comparator<C0047c> f2123f = new Comparator() { // from class: com.google.android.exoplayer2.ui.e
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int f6;
                f6 = c.C0047c.f((c.C0047c) obj, (c.C0047c) obj2);
                return f6;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final int f2124a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2125b;

        /* renamed from: c, reason: collision with root package name */
        public final String f2126c;

        /* renamed from: d, reason: collision with root package name */
        public final String f2127d;

        private C0047c(int i6, int i7, String str, String str2) {
            this.f2124a = i6;
            this.f2125b = i7;
            this.f2126c = str;
            this.f2127d = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int e(C0047c c0047c, C0047c c0047c2) {
            int compare = Integer.compare(c0047c2.f2125b, c0047c.f2125b);
            if (compare != 0) {
                return compare;
            }
            int compareTo = c0047c.f2126c.compareTo(c0047c2.f2126c);
            return compareTo != 0 ? compareTo : c0047c.f2127d.compareTo(c0047c2.f2127d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int f(C0047c c0047c, C0047c c0047c2) {
            int compare = Integer.compare(c0047c2.f2124a, c0047c.f2124a);
            if (compare != 0) {
                return compare;
            }
            int compareTo = c0047c2.f2126c.compareTo(c0047c.f2126c);
            return compareTo != 0 ? compareTo : c0047c2.f2127d.compareTo(c0047c.f2127d);
        }
    }

    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final List<C0047c> f2128a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private final List<C0047c> f2129b = new ArrayList();
    }

    public static b a(CharSequence charSequence, float f6) {
        if (charSequence == null) {
            return new b("", r.j());
        }
        if (!(charSequence instanceof Spanned)) {
            return new b(b(charSequence), r.j());
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet hashSet = new HashSet();
        int i6 = 0;
        for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
        }
        HashMap hashMap = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            hashMap.put(com.google.android.exoplayer2.ui.b.a("bg_" + intValue), c1.C("background-color:%s;", com.google.android.exoplayer2.ui.b.b(intValue)));
        }
        SparseArray<d> c6 = c(spanned, f6);
        StringBuilder sb = new StringBuilder(spanned.length());
        int i7 = 0;
        while (i6 < c6.size()) {
            int keyAt = c6.keyAt(i6);
            sb.append(b(spanned.subSequence(i7, keyAt)));
            d dVar = c6.get(keyAt);
            Collections.sort(dVar.f2129b, C0047c.f2123f);
            Iterator it2 = dVar.f2129b.iterator();
            while (it2.hasNext()) {
                sb.append(((C0047c) it2.next()).f2127d);
            }
            Collections.sort(dVar.f2128a, C0047c.f2122e);
            Iterator it3 = dVar.f2128a.iterator();
            while (it3.hasNext()) {
                sb.append(((C0047c) it3.next()).f2126c);
            }
            i6++;
            i7 = keyAt;
        }
        sb.append(b(spanned.subSequence(i7, spanned.length())));
        return new b(sb.toString(), hashMap);
    }

    private static String b(CharSequence charSequence) {
        return f2119a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    private static SparseArray<d> c(Spanned spanned, float f6) {
        SparseArray<d> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String e6 = e(obj, f6);
            String d6 = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (e6 != null) {
                i2.a.e(d6);
                C0047c c0047c = new C0047c(spanStart, spanEnd, e6, d6);
                f(sparseArray, spanStart).f2128a.add(c0047c);
                f(sparseArray, spanEnd).f2129b.add(c0047c);
            }
        }
        return sparseArray;
    }

    private static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof y1.a) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof y1.e)) {
            return "</span>";
        }
        if (obj instanceof TypefaceSpan) {
            if (((TypefaceSpan) obj).getFamily() != null) {
                return "</span>";
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "</b>";
            }
            if (style == 2) {
                return "</i>";
            }
            if (style == 3) {
                return "</i></b>";
            }
        } else {
            if (obj instanceof y1.c) {
                return "<rt>" + b(((y1.c) obj).f11033a) + "</rt></ruby>";
            }
            if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
        }
        return null;
    }

    private static String e(Object obj, float f6) {
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return c1.C("<span style='color:%s;'>", com.google.android.exoplayer2.ui.b.b(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return c1.C("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof y1.a) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
            boolean dip = absoluteSizeSpan.getDip();
            float size = absoluteSizeSpan.getSize();
            if (!dip) {
                size /= f6;
            }
            return c1.C("<span style='font-size:%.2fpx;'>", Float.valueOf(size));
        }
        if (obj instanceof RelativeSizeSpan) {
            return c1.C("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        }
        if (obj instanceof TypefaceSpan) {
            String family = ((TypefaceSpan) obj).getFamily();
            if (family != null) {
                return c1.C("<span style='font-family:\"%s\";'>", family);
            }
            return null;
        }
        if (obj instanceof StyleSpan) {
            int style = ((StyleSpan) obj).getStyle();
            if (style == 1) {
                return "<b>";
            }
            if (style == 2) {
                return "<i>";
            }
            if (style != 3) {
                return null;
            }
            return "<b><i>";
        }
        if (!(obj instanceof y1.c)) {
            if (obj instanceof UnderlineSpan) {
                return "<u>";
            }
            if (!(obj instanceof y1.e)) {
                return null;
            }
            y1.e eVar = (y1.e) obj;
            return c1.C("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(eVar.f11035a, eVar.f11036b), g(eVar.f11037c));
        }
        int i6 = ((y1.c) obj).f11034b;
        if (i6 == -1) {
            return "<ruby style='ruby-position:unset;'>";
        }
        if (i6 == 1) {
            return "<ruby style='ruby-position:over;'>";
        }
        if (i6 != 2) {
            return null;
        }
        return "<ruby style='ruby-position:under;'>";
    }

    private static d f(SparseArray<d> sparseArray, int i6) {
        d dVar = sparseArray.get(i6);
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        sparseArray.put(i6, dVar2);
        return dVar2;
    }

    private static String g(int i6) {
        return i6 != 2 ? "over right" : "under left";
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String h(int r3, int r4) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 2
            r2 = 1
            if (r4 == r2) goto Lf
            if (r4 == r1) goto Lc
            goto L14
        Lc:
            java.lang.String r4 = "open "
            goto L11
        Lf:
            java.lang.String r4 = "filled "
        L11:
            r0.append(r4)
        L14:
            if (r3 == 0) goto L29
            if (r3 == r2) goto L26
            if (r3 == r1) goto L23
            r4 = 3
            if (r3 == r4) goto L20
            java.lang.String r3 = "unset"
            goto L2b
        L20:
            java.lang.String r3 = "sesame"
            goto L2b
        L23:
            java.lang.String r3 = "dot"
            goto L2b
        L26:
            java.lang.String r3 = "circle"
            goto L2b
        L29:
            java.lang.String r3 = "none"
        L2b:
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.c.h(int, int):java.lang.String");
    }
}
