package com.google.android.exoplayer2.ui;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import l2.l;
import u1.b;

/* loaded from: classes.dex */
final class i {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean c(Object obj) {
        return !(obj instanceof y1.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean d(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    public static void e(b.C0148b c0148b) {
        c0148b.b();
        if (c0148b.e() instanceof Spanned) {
            if (!(c0148b.e() instanceof Spannable)) {
                c0148b.o(SpannableString.valueOf(c0148b.e()));
            }
            g((Spannable) i2.a.e(c0148b.e()), new l() { // from class: com.google.android.exoplayer2.ui.h
                @Override // l2.l
                public final boolean apply(Object obj) {
                    boolean c6;
                    c6 = i.c(obj);
                    return c6;
                }
            });
        }
        f(c0148b);
    }

    public static void f(b.C0148b c0148b) {
        c0148b.q(-3.4028235E38f, Integer.MIN_VALUE);
        if (c0148b.e() instanceof Spanned) {
            if (!(c0148b.e() instanceof Spannable)) {
                c0148b.o(SpannableString.valueOf(c0148b.e()));
            }
            g((Spannable) i2.a.e(c0148b.e()), new l() { // from class: com.google.android.exoplayer2.ui.g
                @Override // l2.l
                public final boolean apply(Object obj) {
                    boolean d6;
                    d6 = i.d(obj);
                    return d6;
                }
            });
        }
    }

    private static void g(Spannable spannable, l<Object> lVar) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (lVar.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static float h(int i6, float f6, int i7, int i8) {
        float f7;
        if (f6 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i6 == 0) {
            f7 = i8;
        } else {
            if (i6 != 1) {
                if (i6 != 2) {
                    return -3.4028235E38f;
                }
                return f6;
            }
            f7 = i7;
        }
        return f6 * f7;
    }
}
