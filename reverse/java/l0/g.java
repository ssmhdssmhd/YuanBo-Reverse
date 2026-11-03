package l0;

import i2.c1;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public int f7149a;

    /* renamed from: b, reason: collision with root package name */
    public int f7150b;

    /* renamed from: c, reason: collision with root package name */
    public int f7151c;

    /* renamed from: d, reason: collision with root package name */
    public int f7152d;

    /* renamed from: e, reason: collision with root package name */
    public int f7153e;

    /* renamed from: f, reason: collision with root package name */
    public int f7154f;

    /* renamed from: g, reason: collision with root package name */
    public int f7155g;

    /* renamed from: h, reason: collision with root package name */
    public int f7156h;

    /* renamed from: i, reason: collision with root package name */
    public int f7157i;

    /* renamed from: j, reason: collision with root package name */
    public int f7158j;

    /* renamed from: k, reason: collision with root package name */
    public long f7159k;

    /* renamed from: l, reason: collision with root package name */
    public int f7160l;

    private void b(long j6, int i6) {
        this.f7159k += j6;
        this.f7160l += i6;
    }

    public void a(long j6) {
        b(j6, 1);
    }

    public synchronized void c() {
    }

    public String toString() {
        return c1.C("DecoderCounters {\n decoderInits=%s,\n decoderReleases=%s\n queuedInputBuffers=%s\n skippedInputBuffers=%s\n renderedOutputBuffers=%s\n skippedOutputBuffers=%s\n droppedBuffers=%s\n droppedInputBuffers=%s\n maxConsecutiveDroppedBuffers=%s\n droppedToKeyframeEvents=%s\n totalVideoFrameProcessingOffsetUs=%s\n videoFrameProcessingOffsetCount=%s\n}", Integer.valueOf(this.f7149a), Integer.valueOf(this.f7150b), Integer.valueOf(this.f7151c), Integer.valueOf(this.f7152d), Integer.valueOf(this.f7153e), Integer.valueOf(this.f7154f), Integer.valueOf(this.f7155g), Integer.valueOf(this.f7156h), Integer.valueOf(this.f7157i), Integer.valueOf(this.f7158j), Long.valueOf(this.f7159k), Integer.valueOf(this.f7160l));
    }
}
