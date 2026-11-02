package q1;

import java.io.IOException;

/* loaded from: classes.dex */
public final class r extends IOException {
    public r(String str) {
        super("Unable to bind a sample queue to TrackGroup with mime type " + str + ".");
    }
}
