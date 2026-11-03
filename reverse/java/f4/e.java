package f4;

/* loaded from: classes.dex */
class e {
    public static final void a(int i6, int i7) {
        if (i6 <= i7) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i6 + ") is greater than size (" + i7 + ").");
    }
}
