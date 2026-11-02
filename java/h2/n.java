package h2;

import android.net.Uri;

/* loaded from: classes.dex */
public final /* synthetic */ class n {
    public static long a(o oVar) {
        return oVar.b("exo_len", -1L);
    }

    public static Uri b(o oVar) {
        String a6 = oVar.a("exo_redir", null);
        if (a6 == null) {
            return null;
        }
        return Uri.parse(a6);
    }
}
