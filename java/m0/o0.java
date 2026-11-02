package m0;

import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.UnsupportedSchemeException;
import android.media.metrics.LogSessionId;
import android.text.TextUtils;
import i0.o3;
import i2.c1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import m0.g0;
import m0.m;

/* loaded from: classes.dex */
public final class o0 implements g0 {

    /* renamed from: d, reason: collision with root package name */
    public static final g0.c f7860d = new g0.c() { // from class: m0.j0
        @Override // m0.g0.c
        public final g0 a(UUID uuid) {
            g0 B;
            B = o0.B(uuid);
            return B;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final UUID f7861a;

    /* renamed from: b, reason: collision with root package name */
    private final MediaDrm f7862b;

    /* renamed from: c, reason: collision with root package name */
    private int f7863c;

    private static class a {
        public static boolean a(MediaDrm mediaDrm, String str) {
            boolean requiresSecureDecoder;
            requiresSecureDecoder = mediaDrm.requiresSecureDecoder(str);
            return requiresSecureDecoder;
        }

        public static void b(MediaDrm mediaDrm, byte[] bArr, o3 o3Var) {
            LogSessionId logSessionId;
            boolean equals;
            MediaDrm.PlaybackComponent playbackComponent;
            LogSessionId a6 = o3Var.a();
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            equals = a6.equals(logSessionId);
            if (equals) {
                return;
            }
            playbackComponent = mediaDrm.getPlaybackComponent(bArr);
            ((MediaDrm.PlaybackComponent) i2.a.e(playbackComponent)).setLogSessionId(a6);
        }
    }

    private o0(UUID uuid) {
        i2.a.e(uuid);
        i2.a.b(!h0.p.f4772b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f7861a = uuid;
        MediaDrm mediaDrm = new MediaDrm(v(uuid));
        this.f7862b = mediaDrm;
        this.f7863c = 1;
        if (h0.p.f4774d.equals(uuid) && C()) {
            x(mediaDrm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(g0.b bVar, MediaDrm mediaDrm, byte[] bArr, int i6, int i7, byte[] bArr2) {
        bVar.a(this, bArr, i6, i7, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ g0 B(UUID uuid) {
        try {
            return D(uuid);
        } catch (v0 unused) {
            i2.t.c("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new d0();
        }
    }

    private static boolean C() {
        return "ASUS_Z00AD".equals(c1.f5551d);
    }

    public static o0 D(UUID uuid) {
        try {
            return new o0(uuid);
        } catch (UnsupportedSchemeException e6) {
            throw new v0(1, e6);
        } catch (Exception e7) {
            throw new v0(2, e7);
        }
    }

    private static byte[] q(byte[] bArr) {
        i2.i0 i0Var = new i2.i0(bArr);
        int s5 = i0Var.s();
        short u5 = i0Var.u();
        short u6 = i0Var.u();
        if (u5 != 1 || u6 != 1) {
            i2.t.f("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short u7 = i0Var.u();
        Charset charset = l2.d.f7491e;
        String D = i0Var.D(u7, charset);
        if (D.contains("<LA_URL>")) {
            return bArr;
        }
        int indexOf = D.indexOf("</DATA>");
        if (indexOf == -1) {
            i2.t.i("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String str = D.substring(0, indexOf) + "<LA_URL>https://x</LA_URL>" + D.substring(indexOf);
        int i6 = s5 + 52;
        ByteBuffer allocate = ByteBuffer.allocate(i6);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(i6);
        allocate.putShort(u5);
        allocate.putShort(u6);
        allocate.putShort((short) (str.length() * 2));
        allocate.put(str.getBytes(charset));
        return allocate.array();
    }

    private static String r(String str) {
        return "<LA_URL>https://x</LA_URL>".equals(str) ? "" : (c1.f5548a == 33 && "https://default.url".equals(str)) ? "" : str;
    }

    private static byte[] s(UUID uuid, byte[] bArr) {
        return h0.p.f4773c.equals(uuid) ? m0.a.a(bArr) : bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        if ("AFTT".equals(r0) == false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] t(java.util.UUID r3, byte[] r4) {
        /*
            java.util.UUID r0 = h0.p.f4775e
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L18
            byte[] r1 = w0.l.e(r4, r3)
            if (r1 != 0) goto Lf
            goto L10
        Lf:
            r4 = r1
        L10:
            byte[] r4 = q(r4)
            byte[] r4 = w0.l.a(r0, r4)
        L18:
            int r1 = i2.c1.f5548a
            r2 = 23
            if (r1 >= r2) goto L26
            java.util.UUID r1 = h0.p.f4774d
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L58
        L26:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L5f
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = i2.c1.f5550c
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L5f
            java.lang.String r0 = i2.c1.f5551d
            java.lang.String r1 = "AFTB"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5f
        L58:
            byte[] r3 = w0.l.e(r4, r3)
            if (r3 == 0) goto L5f
            return r3
        L5f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.o0.t(java.util.UUID, byte[]):byte[]");
    }

    private static String u(UUID uuid, String str) {
        return (c1.f5548a < 26 && h0.p.f4773c.equals(uuid) && ("video/mp4".equals(str) || "audio/mp4".equals(str))) ? "cenc" : str;
    }

    private static UUID v(UUID uuid) {
        return (c1.f5548a >= 27 || !h0.p.f4773c.equals(uuid)) ? uuid : h0.p.f4772b;
    }

    private static void x(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static m.b z(UUID uuid, List<m.b> list) {
        boolean z5;
        if (h0.p.f4774d.equals(uuid)) {
            if (c1.f5548a >= 28 && list.size() > 1) {
                m.b bVar = list.get(0);
                int i6 = 0;
                for (int i7 = 0; i7 < list.size(); i7++) {
                    m.b bVar2 = list.get(i7);
                    byte[] bArr = (byte[]) i2.a.e(bVar2.f7858e);
                    if (!c1.c(bVar2.f7857d, bVar.f7857d) || !c1.c(bVar2.f7856c, bVar.f7856c) || !w0.l.c(bArr)) {
                        z5 = false;
                        break;
                    }
                    i6 += bArr.length;
                }
                z5 = true;
                if (z5) {
                    byte[] bArr2 = new byte[i6];
                    int i8 = 0;
                    for (int i9 = 0; i9 < list.size(); i9++) {
                        byte[] bArr3 = (byte[]) i2.a.e(list.get(i9).f7858e);
                        int length = bArr3.length;
                        System.arraycopy(bArr3, 0, bArr2, i8, length);
                        i8 += length;
                    }
                    return bVar.e(bArr2);
                }
            }
            for (int i10 = 0; i10 < list.size(); i10++) {
                m.b bVar3 = list.get(i10);
                int g6 = w0.l.g((byte[]) i2.a.e(bVar3.f7858e));
                int i11 = c1.f5548a;
                if (i11 < 23 && g6 == 0) {
                    return bVar3;
                }
                if (i11 >= 23 && g6 == 1) {
                    return bVar3;
                }
            }
        }
        return list.get(0);
    }

    public void E(String str, String str2) {
        this.f7862b.setPropertyString(str, str2);
    }

    @Override // m0.g0
    public synchronized void a() {
        int i6 = this.f7863c - 1;
        this.f7863c = i6;
        if (i6 == 0) {
            this.f7862b.release();
        }
    }

    @Override // m0.g0
    public boolean b(byte[] bArr, String str) {
        if (c1.f5548a >= 31) {
            return a.a(this.f7862b, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f7861a, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // m0.g0
    public void c(byte[] bArr, byte[] bArr2) {
        this.f7862b.restoreKeys(bArr, bArr2);
    }

    @Override // m0.g0
    public Map<String, String> d(byte[] bArr) {
        return this.f7862b.queryKeyStatus(bArr);
    }

    @Override // m0.g0
    public void e(byte[] bArr) {
        this.f7862b.closeSession(bArr);
    }

    @Override // m0.g0
    public byte[] f(byte[] bArr, byte[] bArr2) {
        if (h0.p.f4773c.equals(this.f7861a)) {
            bArr2 = m0.a.b(bArr2);
        }
        return this.f7862b.provideKeyResponse(bArr, bArr2);
    }

    @Override // m0.g0
    public void g(byte[] bArr, o3 o3Var) {
        if (c1.f5548a >= 31) {
            try {
                a.b(this.f7862b, bArr, o3Var);
            } catch (UnsupportedOperationException unused) {
                i2.t.i("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // m0.g0
    public g0.d h() {
        MediaDrm.ProvisionRequest provisionRequest = this.f7862b.getProvisionRequest();
        return new g0.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // m0.g0
    public void i(byte[] bArr) {
        this.f7862b.provideProvisionResponse(bArr);
    }

    @Override // m0.g0
    public void j(final g0.b bVar) {
        this.f7862b.setOnEventListener(bVar == null ? null : new MediaDrm.OnEventListener() { // from class: m0.k0
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i6, int i7, byte[] bArr2) {
                o0.this.A(bVar, mediaDrm, bArr, i6, i7, bArr2);
            }
        });
    }

    @Override // m0.g0
    public g0.a k(byte[] bArr, List<m.b> list, int i6, HashMap<String, String> hashMap) {
        m.b bVar;
        byte[] bArr2;
        String str;
        if (list != null) {
            bVar = z(this.f7861a, list);
            bArr2 = t(this.f7861a, (byte[]) i2.a.e(bVar.f7858e));
            str = u(this.f7861a, bVar.f7857d);
        } else {
            bVar = null;
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f7862b.getKeyRequest(bArr, bArr2, str, i6, hashMap);
        byte[] s5 = s(this.f7861a, keyRequest.getData());
        String r6 = r(keyRequest.getDefaultUrl());
        if (TextUtils.isEmpty(r6) && bVar != null && !TextUtils.isEmpty(bVar.f7856c)) {
            r6 = bVar.f7856c;
        }
        return new g0.a(s5, r6, c1.f5548a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // m0.g0
    public int l() {
        return 2;
    }

    @Override // m0.g0
    public byte[] n() {
        return this.f7862b.openSession();
    }

    @Override // m0.g0
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public h0 m(byte[] bArr) {
        return new h0(v(this.f7861a), bArr, c1.f5548a < 21 && h0.p.f4774d.equals(this.f7861a) && "L3".equals(y("securityLevel")));
    }

    public String y(String str) {
        return this.f7862b.getPropertyString(str);
    }
}
