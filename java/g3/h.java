package g3;

import e3.d0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class h {
    public static Map<String, Object> a(e eVar) {
        d0 d6 = eVar.d();
        if (d6 == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sql", d6.c());
        hashMap.put("arguments", d6.b());
        return hashMap;
    }
}
