package g2;

import android.net.Uri;
import android.util.Base64;
import com.tendcloud.tenddata.cs;
import h0.g3;
import i2.c1;
import java.net.URLDecoder;

/* loaded from: classes.dex */
public final class j extends g {

    /* renamed from: e, reason: collision with root package name */
    private q f4068e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f4069f;

    /* renamed from: g, reason: collision with root package name */
    private int f4070g;

    /* renamed from: h, reason: collision with root package name */
    private int f4071h;

    public j() {
        super(false);
    }

    @Override // g2.m
    public long a(q qVar) {
        q(qVar);
        this.f4068e = qVar;
        Uri uri = qVar.f4097a;
        String scheme = uri.getScheme();
        i2.a.b(cs.a.DATA.equals(scheme), "Unsupported scheme: " + scheme);
        String[] U0 = c1.U0(uri.getSchemeSpecificPart(), ",");
        if (U0.length != 2) {
            throw g3.b("Unexpected URI format: " + uri, null);
        }
        String str = U0[1];
        if (U0[0].contains(";base64")) {
            try {
                this.f4069f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e6) {
                throw g3.b("Error while parsing Base64 encoded string: " + str, e6);
            }
        } else {
            this.f4069f = c1.n0(URLDecoder.decode(str, l2.d.f7487a.name()));
        }
        long j6 = qVar.f4103g;
        byte[] bArr = this.f4069f;
        if (j6 > bArr.length) {
            this.f4069f = null;
            throw new n(2008);
        }
        int i6 = (int) j6;
        this.f4070g = i6;
        int length = bArr.length - i6;
        this.f4071h = length;
        long j7 = qVar.f4104h;
        if (j7 != -1) {
            this.f4071h = (int) Math.min(length, j7);
        }
        r(qVar);
        long j8 = qVar.f4104h;
        return j8 != -1 ? j8 : this.f4071h;
    }

    @Override // g2.m
    public void close() {
        if (this.f4069f != null) {
            this.f4069f = null;
            p();
        }
        this.f4068e = null;
    }

    @Override // g2.m
    public Uri j() {
        q qVar = this.f4068e;
        if (qVar != null) {
            return qVar.f4097a;
        }
        return null;
    }

    @Override // g2.i
    public int read(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        int i8 = this.f4071h;
        if (i8 == 0) {
            return -1;
        }
        int min = Math.min(i7, i8);
        System.arraycopy(c1.j(this.f4069f), this.f4070g, bArr, i6, min);
        this.f4070g += min;
        this.f4071h -= min;
        o(min);
        return min;
    }
}
