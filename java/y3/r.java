package y3;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import y3.q;

/* loaded from: classes.dex */
public final class r implements l {

    /* renamed from: b, reason: collision with root package name */
    public static final r f11115b = new r(q.f11112a);

    /* renamed from: a, reason: collision with root package name */
    private final q f11116a;

    public r(q qVar) {
        this.f11116a = qVar;
    }

    @Override // y3.l
    public ByteBuffer a(Object obj) {
        q.a aVar = new q.a();
        aVar.write(0);
        this.f11116a.p(aVar, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // y3.l
    public ByteBuffer b(String str, String str2, Object obj, String str3) {
        q.a aVar = new q.a();
        aVar.write(1);
        this.f11116a.p(aVar, str);
        this.f11116a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f11116a.p(aVar, k3.b.d((Throwable) obj));
        } else {
            this.f11116a.p(aVar, obj);
        }
        this.f11116a.p(aVar, str3);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // y3.l
    public ByteBuffer c(String str, String str2, Object obj) {
        q.a aVar = new q.a();
        aVar.write(1);
        this.f11116a.p(aVar, str);
        this.f11116a.p(aVar, str2);
        if (obj instanceof Throwable) {
            this.f11116a.p(aVar, k3.b.d((Throwable) obj));
        } else {
            this.f11116a.p(aVar, obj);
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // y3.l
    public ByteBuffer d(j jVar) {
        q.a aVar = new q.a();
        this.f11116a.p(aVar, jVar.f11100a);
        this.f11116a.p(aVar, jVar.f11101b);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(aVar.size());
        allocateDirect.put(aVar.a(), 0, aVar.size());
        return allocateDirect;
    }

    @Override // y3.l
    public j e(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        Object f6 = this.f11116a.f(byteBuffer);
        Object f7 = this.f11116a.f(byteBuffer);
        if (!(f6 instanceof String) || byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Method call corrupted");
        }
        return new j((String) f6, f7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r0 == 1) goto L10;
     */
    @Override // y3.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.nio.ByteBuffer r5) {
        /*
            r4 = this;
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            r5.order(r0)
            byte r0 = r5.get()
            if (r0 == 0) goto L11
            r1 = 1
            if (r0 != r1) goto L4a
            goto L1e
        L11:
            y3.q r0 = r4.f11116a
            java.lang.Object r0 = r0.f(r5)
            boolean r1 = r5.hasRemaining()
            if (r1 != 0) goto L1e
            return r0
        L1e:
            y3.q r0 = r4.f11116a
            java.lang.Object r0 = r0.f(r5)
            y3.q r1 = r4.f11116a
            java.lang.Object r1 = r1.f(r5)
            y3.q r2 = r4.f11116a
            java.lang.Object r2 = r2.f(r5)
            boolean r3 = r0 instanceof java.lang.String
            if (r3 == 0) goto L4a
            if (r1 == 0) goto L3a
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L4a
        L3a:
            boolean r5 = r5.hasRemaining()
            if (r5 != 0) goto L4a
            y3.e r5 = new y3.e
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = (java.lang.String) r1
            r5.<init>(r0, r1, r2)
            throw r5
        L4a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Envelope corrupted"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.r.f(java.nio.ByteBuffer):java.lang.Object");
    }
}
