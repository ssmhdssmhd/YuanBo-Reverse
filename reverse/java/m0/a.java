package m0;

import i2.c1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class a {
    public static byte[] a(byte[] bArr) {
        return c1.f5548a >= 27 ? bArr : c1.n0(c(c1.D(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (c1.f5548a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(c1.D(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                if (i6 != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i6);
                sb.append("{\"k\":\"");
                sb.append(d(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(d(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return c1.n0(sb.toString());
        } catch (JSONException e6) {
            i2.t.d("ClearKeyUtil", "Failed to adjust response data: " + c1.D(bArr), e6);
            return bArr;
        }
    }

    private static String c(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    private static String d(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
