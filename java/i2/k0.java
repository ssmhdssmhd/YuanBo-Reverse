package i2;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    private final Object f5597a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final PriorityQueue<Integer> f5598b = new PriorityQueue<>(10, Collections.reverseOrder());

    /* renamed from: c, reason: collision with root package name */
    private int f5599c = Integer.MIN_VALUE;

    public static class a extends IOException {
        public a(int i6, int i7) {
            super("Priority too low [priority=" + i6 + ", highest=" + i7 + "]");
        }
    }

    public void a(int i6) {
        synchronized (this.f5597a) {
            this.f5598b.add(Integer.valueOf(i6));
            this.f5599c = Math.max(this.f5599c, i6);
        }
    }

    public void b(int i6) {
        synchronized (this.f5597a) {
            if (this.f5599c != i6) {
                throw new a(i6, this.f5599c);
            }
        }
    }

    public void c(int i6) {
        synchronized (this.f5597a) {
            this.f5598b.remove(Integer.valueOf(i6));
            this.f5599c = this.f5598b.isEmpty() ? Integer.MIN_VALUE : ((Integer) c1.j(this.f5598b.peek())).intValue();
            this.f5597a.notifyAll();
        }
    }
}
