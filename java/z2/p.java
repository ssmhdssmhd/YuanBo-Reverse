package z2;

import android.util.Log;
import d5.a0;
import d5.b0;
import d5.c0;
import d5.w;
import d5.x;
import d5.z;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.UUID;
import m0.g0;
import m0.s0;

/* loaded from: classes.dex */
public final class p implements s0 {

    /* renamed from: c, reason: collision with root package name */
    public static final a f11320c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final String f11321d = "BetterPlayerEx-CustomDrmCallback";

    /* renamed from: a, reason: collision with root package name */
    private final String f11322a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, String> f11323b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public p(String str, Map<String, String> map) {
        this.f11322a = str;
        this.f11323b = map;
        Log.i(f11321d, "licenseUrl: " + str + ", drmHeaders: " + map);
    }

    private final byte[] c(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                inputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                kotlin.jvm.internal.k.d(byteArray, "byteArrOutputStream.toByteArray()");
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private final byte[] d(String str, byte[] bArr, Map<String, String> map) {
        URLConnection openConnection = new URL(str).openConnection();
        kotlin.jvm.internal.k.c(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(bArr != null);
        httpURLConnection.setDoInput(true);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (bArr != null) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.close();
        }
        try {
            return c(new BufferedInputStream(httpURLConnection.getInputStream()));
        } finally {
            httpURLConnection.disconnect();
        }
    }

    @Override // m0.s0
    public byte[] a(UUID uuid, g0.a keyRequest) {
        kotlin.jvm.internal.k.e(uuid, "uuid");
        kotlin.jvm.internal.k.e(keyRequest, "keyRequest");
        x a6 = new x.a().a();
        a0.a aVar = a0.f2994a;
        w a7 = w.f3229g.a("application/octet-stream");
        byte[] a8 = keyRequest.a();
        kotlin.jvm.internal.k.d(a8, "keyRequest.data");
        a0 c6 = a0.a.c(aVar, a7, a8, 0, 0, 12, null);
        z.a aVar2 = new z.a();
        String str = this.f11322a;
        kotlin.jvm.internal.k.b(str);
        z.a h6 = aVar2.h(str);
        Map<String, String> map = this.f11323b;
        kotlin.jvm.internal.k.b(map);
        String str2 = map.get("X-AxDRM-Message");
        kotlin.jvm.internal.k.b(str2);
        b0 j6 = a6.u(h6.b("X-AxDRM-Message", str2).e(c6).a()).j();
        Log.i(f11321d, "*>>>httpResponse: " + j6);
        c0 a9 = j6.a();
        kotlin.jvm.internal.k.b(a9);
        return a9.a();
    }

    @Override // m0.s0
    public byte[] b(UUID uuid, g0.d provisionRequest) {
        kotlin.jvm.internal.k.e(uuid, "uuid");
        kotlin.jvm.internal.k.e(provisionRequest, "provisionRequest");
        StringBuilder sb = new StringBuilder();
        sb.append(provisionRequest.b());
        sb.append("&signedRequest=");
        byte[] a6 = provisionRequest.a();
        kotlin.jvm.internal.k.d(a6, "provisionRequest.data");
        sb.append(new String(a6, v4.d.f9880b));
        return d(sb.toString(), null, null);
    }
}
