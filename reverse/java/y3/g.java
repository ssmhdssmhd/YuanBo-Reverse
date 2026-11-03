package y3;

import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class g implements l {

    /* renamed from: a, reason: collision with root package name */
    public static final g f11099a = new g();

    private g() {
    }

    @Override // y3.l
    public ByteBuffer a(Object obj) {
        return f.f11098a.a(new JSONArray().put(h.a(obj)));
    }

    @Override // y3.l
    public ByteBuffer b(String str, String str2, Object obj, String str3) {
        return f.f11098a.a(new JSONArray().put(str).put(h.a(str2)).put(h.a(obj)).put(h.a(str3)));
    }

    @Override // y3.l
    public ByteBuffer c(String str, String str2, Object obj) {
        return f.f11098a.a(new JSONArray().put(str).put(h.a(str2)).put(h.a(obj)));
    }

    @Override // y3.l
    public ByteBuffer d(j jVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", jVar.f11100a);
            jSONObject.put("args", h.a(jVar.f11101b));
            return f.f11098a.a(jSONObject);
        } catch (JSONException e6) {
            throw new IllegalArgumentException("Invalid JSON", e6);
        }
    }

    @Override // y3.l
    public j e(ByteBuffer byteBuffer) {
        try {
            Object b6 = f.f11098a.b(byteBuffer);
            if (b6 instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) b6;
                Object obj = jSONObject.get("method");
                Object g6 = g(jSONObject.opt("args"));
                if (obj instanceof String) {
                    return new j((String) obj, g6);
                }
            }
            throw new IllegalArgumentException("Invalid method call: " + b6);
        } catch (JSONException e6) {
            throw new IllegalArgumentException("Invalid JSON", e6);
        }
    }

    @Override // y3.l
    public Object f(ByteBuffer byteBuffer) {
        try {
            Object b6 = f.f11098a.b(byteBuffer);
            if (b6 instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) b6;
                if (jSONArray.length() == 1) {
                    return g(jSONArray.opt(0));
                }
                if (jSONArray.length() == 3) {
                    Object obj = jSONArray.get(0);
                    Object g6 = g(jSONArray.opt(1));
                    Object g7 = g(jSONArray.opt(2));
                    if ((obj instanceof String) && (g6 == null || (g6 instanceof String))) {
                        throw new e((String) obj, (String) g6, g7);
                    }
                }
            }
            throw new IllegalArgumentException("Invalid envelope: " + b6);
        } catch (JSONException e6) {
            throw new IllegalArgumentException("Invalid JSON", e6);
        }
    }

    Object g(Object obj) {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj;
    }
}
