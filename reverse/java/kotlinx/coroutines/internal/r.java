package kotlinx.coroutines.internal;

import java.util.List;
import w4.v1;

/* loaded from: classes.dex */
public interface r {
    v1 createDispatcher(List<? extends r> list);

    int getLoadPriority();

    String hintOnError();
}
