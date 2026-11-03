package a3;

import android.util.Base64;
import java.lang.reflect.Type;
import q2.i;
import q2.j;
import q2.k;
import q2.p;
import q2.q;
import q2.r;

/* loaded from: classes.dex */
public final class a implements r<byte[]>, j<byte[]> {
    @Override // q2.j
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public byte[] b(k kVar, Type type, i iVar) {
        byte[] decode = Base64.decode(kVar != null ? kVar.e() : null, 2);
        kotlin.jvm.internal.k.d(decode, "decode(json?.asString, Base64.NO_WRAP)");
        return decode;
    }

    @Override // q2.r
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public k a(byte[] bArr, Type type, q qVar) {
        return new p(Base64.encodeToString(bArr, 2));
    }
}
