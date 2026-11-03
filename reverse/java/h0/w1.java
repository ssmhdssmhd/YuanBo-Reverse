package h0;

/* loaded from: classes.dex */
public final class w1 extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final int f4983a;

    public w1(int i6) {
        super(a(i6));
        this.f4983a = i6;
    }

    private static String a(int i6) {
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? "Undefined timeout." : "Detaching surface timed out." : "Setting foreground mode timed out." : "Player release timed out.";
    }
}
