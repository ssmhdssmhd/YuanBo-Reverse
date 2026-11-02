package io.flutter.embedding.android;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    long f5980a;

    /* renamed from: b, reason: collision with root package name */
    a f5981b;

    /* renamed from: c, reason: collision with root package name */
    long f5982c;

    /* renamed from: d, reason: collision with root package name */
    long f5983d;

    /* renamed from: e, reason: collision with root package name */
    boolean f5984e;

    /* renamed from: f, reason: collision with root package name */
    String f5985f;

    public enum a {
        kDown(0),
        kUp(1),
        kRepeat(2);


        /* renamed from: a, reason: collision with root package name */
        private long f5990a;

        a(long j6) {
            this.f5990a = j6;
        }

        public long a() {
            return this.f5990a;
        }
    }

    ByteBuffer a() {
        try {
            String str = this.f5985f;
            byte[] bytes = str == null ? null : str.getBytes("UTF-8");
            int length = bytes == null ? 0 : bytes.length;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length + 48);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.putLong(length);
            allocateDirect.putLong(this.f5980a);
            allocateDirect.putLong(this.f5981b.a());
            allocateDirect.putLong(this.f5982c);
            allocateDirect.putLong(this.f5983d);
            allocateDirect.putLong(this.f5984e ? 1L : 0L);
            if (bytes != null) {
                allocateDirect.put(bytes);
            }
            return allocateDirect;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }
}
