package androidx.work;

import androidx.work.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import v.h;

/* loaded from: classes.dex */
public final class OverwritingInputMerger extends h {
    @Override // v.h
    public b b(List<b> list) {
        b.a aVar = new b.a();
        HashMap hashMap = new HashMap();
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            hashMap.putAll(it.next().h());
        }
        aVar.d(hashMap);
        return aVar.a();
    }
}
