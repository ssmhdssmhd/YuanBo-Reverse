package y3;

import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes.dex */
public final class f implements i<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final f f11098a = new f();

    private f() {
    }

    @Override // y3.i
    public ByteBuffer a(Object obj) {
        s sVar;
        String obj2;
        if (obj == null) {
            return null;
        }
        Object a6 = h.a(obj);
        if (a6 instanceof String) {
            sVar = s.f11118b;
            obj2 = JSONObject.quote((String) a6);
        } else {
            sVar = s.f11118b;
            obj2 = a6.toString();
        }
        return sVar.a(obj2);
    }

    @Override // y3.i
    public Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            JSONTokener jSONTokener = new JSONTokener(s.f11118b.b(byteBuffer));
            Object nextValue = jSONTokener.nextValue();
            if (jSONTokener.more()) {
                throw new IllegalArgumentException("Invalid JSON");
            }
            return nextValue;
        } catch (JSONException e6) {
            throw new IllegalArgumentException("Invalid JSON", e6);
        }
    }
}
