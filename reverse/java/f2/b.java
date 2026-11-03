package f2;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import f2.e;
import h0.o3;

/* loaded from: classes.dex */
public final class b implements e.InterfaceC0072e {

    /* renamed from: a, reason: collision with root package name */
    private final PendingIntent f3794a;

    public b(PendingIntent pendingIntent) {
        this.f3794a = pendingIntent;
    }

    @Override // f2.e.InterfaceC0072e
    public CharSequence a(o3 o3Var) {
        CharSequence charSequence = o3Var.c0().f4620e;
        if (!TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        CharSequence charSequence2 = o3Var.c0().f4616a;
        return charSequence2 != null ? charSequence2 : "";
    }

    @Override // f2.e.InterfaceC0072e
    public CharSequence b(o3 o3Var) {
        CharSequence charSequence = o3Var.c0().f4617b;
        return !TextUtils.isEmpty(charSequence) ? charSequence : o3Var.c0().f4619d;
    }

    @Override // f2.e.InterfaceC0072e
    public PendingIntent c(o3 o3Var) {
        return this.f3794a;
    }

    @Override // f2.e.InterfaceC0072e
    public /* synthetic */ CharSequence d(o3 o3Var) {
        return f.a(this, o3Var);
    }

    @Override // f2.e.InterfaceC0072e
    public Bitmap e(o3 o3Var, e.b bVar) {
        byte[] bArr = o3Var.c0().f4625n;
        if (bArr == null) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }
}
