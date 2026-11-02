package androidx.core.app;

import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class z0 {

    static class a {
        static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(z0 z0Var) {
            throw null;
        }

        static Bundle c(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    static RemoteInput a(z0 z0Var) {
        return a.b(z0Var);
    }

    static RemoteInput[] b(z0[] z0VarArr) {
        if (z0VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[z0VarArr.length];
        for (int i6 = 0; i6 < z0VarArr.length; i6++) {
            z0 z0Var = z0VarArr[i6];
            remoteInputArr[i6] = a(null);
        }
        return remoteInputArr;
    }
}
