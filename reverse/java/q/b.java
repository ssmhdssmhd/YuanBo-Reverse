package q;

import android.database.Cursor;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

/* loaded from: classes.dex */
public interface b extends Closeable {
    boolean B();

    void J();

    void L(String str, Object[] objArr);

    Cursor N(e eVar);

    Cursor S(String str);

    void e();

    void f();

    List<Pair<String, String>> h();

    boolean isOpen();

    void l(String str);

    Cursor n(e eVar, CancellationSignal cancellationSignal);

    f p(String str);

    String z();
}
