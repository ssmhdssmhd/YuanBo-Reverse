package f2;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import i2.c1;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: g, reason: collision with root package name */
    public static final a f3787g = new a(-1, -16777216, 0, 0, -1, null);

    /* renamed from: a, reason: collision with root package name */
    public final int f3788a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3789b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3790c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3791d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3792e;

    /* renamed from: f, reason: collision with root package name */
    public final Typeface f3793f;

    public a(int i6, int i7, int i8, int i9, int i10, Typeface typeface) {
        this.f3788a = i6;
        this.f3789b = i7;
        this.f3790c = i8;
        this.f3791d = i9;
        this.f3792e = i10;
        this.f3793f = typeface;
    }

    public static a a(CaptioningManager.CaptionStyle captionStyle) {
        return c1.f5548a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    private static a b(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    private static a c(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f3787g.f3788a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f3787g.f3789b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f3787g.f3790c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f3787g.f3791d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f3787g.f3792e, captionStyle.getTypeface());
    }
}
