package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: c, reason: collision with root package name */
    private static g0 f5903c;

    /* renamed from: a, reason: collision with root package name */
    private final LongSparseArray<MotionEvent> f5904a = new LongSparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private final PriorityQueue<Long> f5905b = new PriorityQueue<>();

    public static class a {

        /* renamed from: b, reason: collision with root package name */
        private static final AtomicLong f5906b = new AtomicLong(0);

        /* renamed from: a, reason: collision with root package name */
        private final long f5907a;

        private a(long j6) {
            this.f5907a = j6;
        }

        public static a b() {
            return c(f5906b.incrementAndGet());
        }

        public static a c(long j6) {
            return new a(j6);
        }

        public long d() {
            return this.f5907a;
        }
    }

    private g0() {
    }

    public static g0 a() {
        if (f5903c == null) {
            f5903c = new g0();
        }
        return f5903c;
    }

    public MotionEvent b(a aVar) {
        while (!this.f5905b.isEmpty() && this.f5905b.peek().longValue() < aVar.f5907a) {
            this.f5904a.remove(this.f5905b.poll().longValue());
        }
        if (!this.f5905b.isEmpty() && this.f5905b.peek().longValue() == aVar.f5907a) {
            this.f5905b.poll();
        }
        MotionEvent motionEvent = this.f5904a.get(aVar.f5907a);
        this.f5904a.remove(aVar.f5907a);
        return motionEvent;
    }

    public a c(MotionEvent motionEvent) {
        a b6 = a.b();
        this.f5904a.put(b6.f5907a, MotionEvent.obtain(motionEvent));
        this.f5905b.add(Long.valueOf(b6.f5907a));
        return b6;
    }
}
