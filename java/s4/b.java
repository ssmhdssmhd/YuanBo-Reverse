package s4;

import f4.y;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class b extends y {

    /* renamed from: a, reason: collision with root package name */
    private final int f9298a;

    /* renamed from: b, reason: collision with root package name */
    private final int f9299b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f9300c;

    /* renamed from: d, reason: collision with root package name */
    private int f9301d;

    public b(int i6, int i7, int i8) {
        this.f9298a = i8;
        this.f9299b = i7;
        boolean z5 = true;
        if (i8 <= 0 ? i6 < i7 : i6 > i7) {
            z5 = false;
        }
        this.f9300c = z5;
        this.f9301d = z5 ? i6 : i7;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f9300c;
    }

    @Override // f4.y
    public int nextInt() {
        int i6 = this.f9301d;
        if (i6 != this.f9299b) {
            this.f9301d = this.f9298a + i6;
        } else {
            if (!this.f9300c) {
                throw new NoSuchElementException();
            }
            this.f9300c = false;
        }
        return i6;
    }
}
