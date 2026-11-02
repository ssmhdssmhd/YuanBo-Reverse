package com.tendcloud.tenddata;

import com.tendcloud.tenddata.cs;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cx extends da {
    public cx(String str, String str2) {
        a("domain", str);
        a("name", str2);
    }

    public void setData(Map<String, Object> map) {
        if (map != null) {
            a(cs.a.DATA, (Object) new JSONObject(map));
        }
    }
}
