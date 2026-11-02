package g2;

import java.io.IOException;

/* loaded from: classes.dex */
public final class p {
    public static void a(m mVar) {
        if (mVar != null) {
            try {
                mVar.close();
            } catch (IOException unused) {
            }
        }
    }
}
