package com.tendcloud.tenddata;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f2761a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f2762b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f2763c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f2764d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f2765e = 30;

    /* renamed from: f, reason: collision with root package name */
    private static final ThreadFactory f2766f;

    /* renamed from: g, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f2767g;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f2762b = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 4));
        f2763c = max;
        int i6 = (availableProcessors * 2) + 1;
        f2764d = i6;
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.tendcloud.tenddata.w.1
            private final AtomicInteger mCount = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ThreadPoolUtils #" + this.mCount.getAndIncrement());
            }
        };
        f2766f = threadFactory;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        f2767g = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, i6, 30L, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f2761a = threadPoolExecutor;
    }
}
