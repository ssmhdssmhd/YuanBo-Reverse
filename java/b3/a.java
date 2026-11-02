package b3;

import java.util.Date;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private String f1779a;

    /* renamed from: b, reason: collision with root package name */
    private Date f1780b;

    /* renamed from: c, reason: collision with root package name */
    private String f1781c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f1782d;

    public a() {
        this(null, null, null, null, 15, null);
    }

    public a(String id, Date date, String str, byte[] bArr) {
        k.e(id, "id");
        this.f1779a = id;
        this.f1780b = date;
        this.f1781c = str;
        this.f1782d = bArr;
    }

    public /* synthetic */ a(String str, Date date, String str2, byte[] bArr, int i6, g gVar) {
        this((i6 & 1) != 0 ? "" : str, (i6 & 2) != 0 ? null : date, (i6 & 4) != 0 ? null : str2, (i6 & 8) != 0 ? null : bArr);
    }

    public final byte[] a() {
        return this.f1782d;
    }

    public final String b() {
        return this.f1781c;
    }

    public final Date c() {
        return this.f1780b;
    }
}
