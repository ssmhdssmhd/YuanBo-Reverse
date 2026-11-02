package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ui.SubtitleView;
import i2.c1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class j extends FrameLayout implements SubtitleView.a {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.ui.a f2156a;

    /* renamed from: b, reason: collision with root package name */
    private final WebView f2157b;

    /* renamed from: c, reason: collision with root package name */
    private List<u1.b> f2158c;

    /* renamed from: d, reason: collision with root package name */
    private f2.a f2159d;

    /* renamed from: e, reason: collision with root package name */
    private float f2160e;

    /* renamed from: f, reason: collision with root package name */
    private int f2161f;

    /* renamed from: g, reason: collision with root package name */
    private float f2162g;

    class a extends WebView {
        a(j jVar, Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            super.performClick();
            return false;
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2163a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f2163a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2163a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2163a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public j(Context context) {
        this(context, null);
    }

    public j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2158c = Collections.emptyList();
        this.f2159d = f2.a.f3787g;
        this.f2160e = 0.0533f;
        this.f2161f = 0;
        this.f2162g = 0.08f;
        com.google.android.exoplayer2.ui.a aVar = new com.google.android.exoplayer2.ui.a(context, attributeSet);
        this.f2156a = aVar;
        a aVar2 = new a(this, context, attributeSet);
        this.f2157b = aVar2;
        aVar2.setBackgroundColor(0);
        addView(aVar);
        addView(aVar2);
    }

    private static int b(int i6) {
        if (i6 != 1) {
            return i6 != 2 ? 0 : -100;
        }
        return -50;
    }

    private static String c(Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i6 = b.f2163a[alignment.ordinal()];
        return i6 != 1 ? i6 != 2 ? "center" : "end" : "start";
    }

    private static String d(f2.a aVar) {
        int i6 = aVar.f3791d;
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? i6 != 4 ? "unset" : c1.C("-0.05em -0.05em 0.15em %s", com.google.android.exoplayer2.ui.b.b(aVar.f3792e)) : c1.C("0.06em 0.08em 0.15em %s", com.google.android.exoplayer2.ui.b.b(aVar.f3792e)) : c1.C("0.1em 0.12em 0.15em %s", com.google.android.exoplayer2.ui.b.b(aVar.f3792e)) : c1.C("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", com.google.android.exoplayer2.ui.b.b(aVar.f3792e));
    }

    private String e(int i6, float f6) {
        float h6 = i.h(i6, f6, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return h6 == -3.4028235E38f ? "unset" : c1.C("%.2fpx", Float.valueOf(h6 / getContext().getResources().getDisplayMetrics().density));
    }

    private static String f(int i6) {
        return i6 != 1 ? i6 != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    private static String h(u1.b bVar) {
        float f6 = bVar.f9620u;
        if (f6 == 0.0f) {
            return "";
        }
        int i6 = bVar.f9619t;
        return c1.C("%s(%.2fdeg)", (i6 == 2 || i6 == 1) ? "skewY" : "skewX", Float.valueOf(f6));
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0148, code lost:
    
        if (r13 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x014d, code lost:
    
        r21 = "left";
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x014f, code lost:
    
        r22 = "top";
        r13 = 2;
        r23 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014b, code lost:
    
        if (r13 != false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i() {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.j.i():void");
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<u1.b> list, f2.a aVar, float f6, int i6, float f7) {
        this.f2159d = aVar;
        this.f2160e = f6;
        this.f2161f = i6;
        this.f2162g = f7;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i7 = 0; i7 < list.size(); i7++) {
            u1.b bVar = list.get(i7);
            if (bVar.f9607d != null) {
                arrayList.add(bVar);
            } else {
                arrayList2.add(bVar);
            }
        }
        if (!this.f2158c.isEmpty() || !arrayList2.isEmpty()) {
            this.f2158c = arrayList2;
            i();
        }
        this.f2156a.a(arrayList, aVar, f6, i6, f7);
        invalidate();
    }

    public void g() {
        this.f2157b.destroy();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
        if (!z5 || this.f2158c.isEmpty()) {
            return;
        }
        i();
    }
}
