package y3;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f11100a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11101b;

    public j(String str, Object obj) {
        this.f11100a = str;
        this.f11101b = obj;
    }

    public <T> T a(String str) {
        Object obj = this.f11101b;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return (T) ((Map) obj).get(str);
        }
        if (obj instanceof JSONObject) {
            return (T) ((JSONObject) obj).opt(str);
        }
        throw new ClassCastException();
    }

    public <T> T b() {
        return (T) this.f11101b;
    }

    public boolean c(String str) {
        Object obj = this.f11101b;
        if (obj == null) {
            return false;
        }
        if (obj instanceof Map) {
            return ((Map) obj).containsKey(str);
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).has(str);
        }
        throw new ClassCastException();
    }
}
