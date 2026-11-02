package x3;

import android.os.Bundle;
import com.tendcloud.tenddata.cs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y3.k;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final y3.k f10611a;

    /* renamed from: b, reason: collision with root package name */
    private f f10612b;

    /* renamed from: c, reason: collision with root package name */
    final k.c f10613c;

    class a implements k.c {
        a() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // y3.k.c
        public void e(y3.j jVar, k.d dVar) {
            Bundle bundle;
            if (p.this.f10612b == null) {
            }
            String str = jVar.f11100a;
            Object obj = jVar.f11101b;
            k3.b.f("TextInputChannel", "Received '" + str + "' message.");
            str.hashCode();
            char c6 = 65535;
            switch (str.hashCode()) {
                case -1779068172:
                    if (str.equals("TextInput.setPlatformViewClient")) {
                        c6 = 0;
                        break;
                    }
                    break;
                case -1015421462:
                    if (str.equals("TextInput.setEditingState")) {
                        c6 = 1;
                        break;
                    }
                    break;
                case -37561188:
                    if (str.equals("TextInput.setClient")) {
                        c6 = 2;
                        break;
                    }
                    break;
                case 270476819:
                    if (str.equals("TextInput.hide")) {
                        c6 = 3;
                        break;
                    }
                    break;
                case 270803918:
                    if (str.equals("TextInput.show")) {
                        c6 = 4;
                        break;
                    }
                    break;
                case 649192816:
                    if (str.equals("TextInput.sendAppPrivateCommand")) {
                        c6 = 5;
                        break;
                    }
                    break;
                case 1204752139:
                    if (str.equals("TextInput.setEditableSizeAndTransform")) {
                        c6 = 6;
                        break;
                    }
                    break;
                case 1727570905:
                    if (str.equals("TextInput.finishAutofillContext")) {
                        c6 = 7;
                        break;
                    }
                    break;
                case 1904427655:
                    if (str.equals("TextInput.clearClient")) {
                        c6 = '\b';
                        break;
                    }
                    break;
                case 2113369584:
                    if (str.equals("TextInput.requestAutofill")) {
                        c6 = '\t';
                        break;
                    }
                    break;
            }
            try {
                switch (c6) {
                    case 0:
                        JSONObject jSONObject = (JSONObject) obj;
                        p.this.f10612b.f(jSONObject.getInt("platformViewId"), jSONObject.optBoolean("usesVirtualDisplay", false));
                        dVar.b(null);
                        break;
                    case 1:
                        p.this.f10612b.d(e.a((JSONObject) obj));
                        dVar.b(null);
                        break;
                    case 2:
                        try {
                            JSONArray jSONArray = (JSONArray) obj;
                            p.this.f10612b.a(jSONArray.getInt(0), b.a(jSONArray.getJSONObject(1)));
                            dVar.b(null);
                            break;
                        } catch (NoSuchFieldException e6) {
                            e = e6;
                            dVar.a("error", e.getMessage(), null);
                            return;
                        }
                    case 3:
                        p.this.f10612b.j();
                        dVar.b(null);
                        break;
                    case 4:
                        p.this.f10612b.c();
                        dVar.b(null);
                        break;
                    case 5:
                        JSONObject jSONObject2 = (JSONObject) obj;
                        String string = jSONObject2.getString("action");
                        String string2 = jSONObject2.getString(cs.a.DATA);
                        if (string2 == null || string2.isEmpty()) {
                            bundle = null;
                        } else {
                            bundle = new Bundle();
                            bundle.putString(cs.a.DATA, string2);
                        }
                        p.this.f10612b.e(string, bundle);
                        dVar.b(null);
                        break;
                    case 6:
                        JSONObject jSONObject3 = (JSONObject) obj;
                        double d6 = jSONObject3.getDouble("width");
                        double d7 = jSONObject3.getDouble("height");
                        JSONArray jSONArray2 = jSONObject3.getJSONArray("transform");
                        double[] dArr = new double[16];
                        for (int i6 = 0; i6 < 16; i6++) {
                            dArr[i6] = jSONArray2.getDouble(i6);
                        }
                        p.this.f10612b.g(d6, d7, dArr);
                        dVar.b(null);
                        break;
                    case 7:
                        p.this.f10612b.i(((Boolean) obj).booleanValue());
                        dVar.b(null);
                        break;
                    case '\b':
                        p.this.f10612b.b();
                        dVar.b(null);
                        break;
                    case '\t':
                        p.this.f10612b.h();
                        dVar.b(null);
                        break;
                    default:
                        dVar.c();
                        break;
                }
            } catch (JSONException e7) {
                e = e7;
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f10615a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10616b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f10617c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f10618d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f10619e;

        /* renamed from: f, reason: collision with root package name */
        public final d f10620f;

        /* renamed from: g, reason: collision with root package name */
        public final c f10621g;

        /* renamed from: h, reason: collision with root package name */
        public final Integer f10622h;

        /* renamed from: i, reason: collision with root package name */
        public final String f10623i;

        /* renamed from: j, reason: collision with root package name */
        public final a f10624j;

        /* renamed from: k, reason: collision with root package name */
        public final String[] f10625k;

        /* renamed from: l, reason: collision with root package name */
        public final b[] f10626l;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            public final String f10627a;

            /* renamed from: b, reason: collision with root package name */
            public final String[] f10628b;

            /* renamed from: c, reason: collision with root package name */
            public final e f10629c;

            /* renamed from: d, reason: collision with root package name */
            public final String f10630d;

            public a(String str, String[] strArr, String str2, e eVar) {
                this.f10627a = str;
                this.f10628b = strArr;
                this.f10630d = str2;
                this.f10629c = eVar;
            }

            public static a a(JSONObject jSONObject) {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                String string2 = jSONObject.isNull("hintText") ? null : jSONObject.getString("hintText");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                String[] strArr = new String[jSONArray.length()];
                for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                    strArr[i6] = b(jSONArray.getString(i6));
                }
                return new a(string, strArr, string2, e.a(jSONObject2));
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:74:0x00a5, code lost:
            
                if (r17.equals("familyName") == false) goto L7;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            private static java.lang.String b(java.lang.String r17) {
                /*
                    Method dump skipped, instructions count: 804
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: x3.p.b.a.b(java.lang.String):java.lang.String");
            }
        }

        public b(boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, d dVar, c cVar, Integer num, String str, a aVar, String[] strArr, b[] bVarArr) {
            this.f10615a = z5;
            this.f10616b = z6;
            this.f10617c = z7;
            this.f10618d = z8;
            this.f10619e = z9;
            this.f10620f = dVar;
            this.f10621g = cVar;
            this.f10622h = num;
            this.f10623i = str;
            this.f10624j = aVar;
            this.f10625k = strArr;
            this.f10626l = bVarArr;
        }

        public static b a(JSONObject jSONObject) {
            b[] bVarArr;
            String string = jSONObject.getString("inputAction");
            if (string == null) {
                throw new JSONException("Configuration JSON missing 'inputAction' property.");
            }
            if (jSONObject.isNull("fields")) {
                bVarArr = null;
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("fields");
                int length = jSONArray.length();
                b[] bVarArr2 = new b[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bVarArr2[i6] = a(jSONArray.getJSONObject(i6));
                }
                bVarArr = bVarArr2;
            }
            Integer b6 = b(string);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray2 = jSONObject.isNull("contentCommitMimeTypes") ? null : jSONObject.getJSONArray("contentCommitMimeTypes");
            if (jSONArray2 != null) {
                for (int i7 = 0; i7 < jSONArray2.length(); i7++) {
                    arrayList.add(jSONArray2.optString(i7));
                }
            }
            return new b(jSONObject.optBoolean("obscureText"), jSONObject.optBoolean("autocorrect", true), jSONObject.optBoolean("enableSuggestions"), jSONObject.optBoolean("enableIMEPersonalizedLearning"), jSONObject.optBoolean("enableDeltaModel"), d.a(jSONObject.getString("textCapitalization")), c.a(jSONObject.getJSONObject("inputType")), b6, jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel"), jSONObject.isNull("autofill") ? null : a.a(jSONObject.getJSONObject("autofill")), (String[]) arrayList.toArray(new String[arrayList.size()]), bVarArr);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0072, code lost:
        
            if (r12.equals("TextInputAction.done") == false) goto L4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static java.lang.Integer b(java.lang.String r12) {
            /*
                r12.hashCode()
                int r0 = r12.hashCode()
                r1 = 7
                r2 = 6
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r7 = 1
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                r9 = 0
                java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
                r11 = -1
                switch(r0) {
                    case -810971940: goto L75;
                    case -737377923: goto L6c;
                    case -737089298: goto L61;
                    case -737080013: goto L56;
                    case -736940669: goto L4b;
                    case 469250275: goto L40;
                    case 1241689507: goto L35;
                    case 1539450297: goto L2a;
                    case 2110497650: goto L1e;
                    default: goto L1b;
                }
            L1b:
                r7 = -1
                goto L7f
            L1e:
                java.lang.String r0 = "TextInputAction.previous"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L27
                goto L1b
            L27:
                r7 = 8
                goto L7f
            L2a:
                java.lang.String r0 = "TextInputAction.newline"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L33
                goto L1b
            L33:
                r7 = 7
                goto L7f
            L35:
                java.lang.String r0 = "TextInputAction.go"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L3e
                goto L1b
            L3e:
                r7 = 6
                goto L7f
            L40:
                java.lang.String r0 = "TextInputAction.search"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L49
                goto L1b
            L49:
                r7 = 5
                goto L7f
            L4b:
                java.lang.String r0 = "TextInputAction.send"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L54
                goto L1b
            L54:
                r7 = 4
                goto L7f
            L56:
                java.lang.String r0 = "TextInputAction.none"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L5f
                goto L1b
            L5f:
                r7 = 3
                goto L7f
            L61:
                java.lang.String r0 = "TextInputAction.next"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L6a
                goto L1b
            L6a:
                r7 = 2
                goto L7f
            L6c:
                java.lang.String r0 = "TextInputAction.done"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L7f
                goto L1b
            L75:
                java.lang.String r0 = "TextInputAction.unspecified"
                boolean r12 = r12.equals(r0)
                if (r12 != 0) goto L7e
                goto L1b
            L7e:
                r7 = 0
            L7f:
                switch(r7) {
                    case 0: goto La3;
                    case 1: goto L9e;
                    case 2: goto L99;
                    case 3: goto L98;
                    case 4: goto L93;
                    case 5: goto L8e;
                    case 6: goto L89;
                    case 7: goto L88;
                    case 8: goto L83;
                    default: goto L82;
                }
            L82:
                return r10
            L83:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
                return r12
            L88:
                return r8
            L89:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
                return r12
            L8e:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r5)
                return r12
            L93:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r4)
                return r12
            L98:
                return r8
            L99:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
                return r12
            L9e:
                java.lang.Integer r12 = java.lang.Integer.valueOf(r2)
                return r12
            La3:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: x3.p.b.b(java.lang.String):java.lang.Integer");
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final g f10631a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10632b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f10633c;

        public c(g gVar, boolean z5, boolean z6) {
            this.f10631a = gVar;
            this.f10632b = z5;
            this.f10633c = z6;
        }

        public static c a(JSONObject jSONObject) {
            return new c(g.a(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    public enum d {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");


        /* renamed from: a, reason: collision with root package name */
        private final String f10639a;

        d(String str) {
            this.f10639a = str;
        }

        static d a(String str) {
            for (d dVar : values()) {
                if (dVar.f10639a.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final String f10640a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10641b;

        /* renamed from: c, reason: collision with root package name */
        public final int f10642c;

        /* renamed from: d, reason: collision with root package name */
        public final int f10643d;

        /* renamed from: e, reason: collision with root package name */
        public final int f10644e;

        public e(String str, int i6, int i7, int i8, int i9) {
            if (!(i6 == -1 && i7 == -1) && (i6 < 0 || i7 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i6) + ", " + String.valueOf(i7) + ")");
            }
            if (!(i8 == -1 && i9 == -1) && (i8 < 0 || i8 > i9)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i8) + ", " + String.valueOf(i9) + ")");
            }
            if (i9 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i8));
            }
            if (i6 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i6));
            }
            if (i7 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i7));
            }
            this.f10640a = str;
            this.f10641b = i6;
            this.f10642c = i7;
            this.f10643d = i8;
            this.f10644e = i9;
        }

        public static e a(JSONObject jSONObject) {
            return new e(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }

        public boolean b() {
            int i6 = this.f10643d;
            return i6 >= 0 && this.f10644e > i6;
        }

        public boolean c() {
            return this.f10641b >= 0;
        }
    }

    public interface f {
        void a(int i6, b bVar);

        void b();

        void c();

        void d(e eVar);

        void e(String str, Bundle bundle);

        void f(int i6, boolean z5);

        void g(double d6, double d7, double[] dArr);

        void h();

        void i(boolean z5);

        void j();
    }

    public enum g {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword"),
        NONE("TextInputType.none");


        /* renamed from: a, reason: collision with root package name */
        private final String f10657a;

        g(String str) {
            this.f10657a = str;
        }

        static g a(String str) {
            for (g gVar : values()) {
                if (gVar.f10657a.equals(str)) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public p(m3.a aVar) {
        a aVar2 = new a();
        this.f10613c = aVar2;
        y3.k kVar = new y3.k(aVar, "flutter/textinput", y3.g.f11099a);
        this.f10611a = kVar;
        kVar.e(aVar2);
    }

    private static HashMap<Object, Object> c(ArrayList<io.flutter.plugin.editing.l> arrayList) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        JSONArray jSONArray = new JSONArray();
        Iterator<io.flutter.plugin.editing.l> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().b());
        }
        hashMap.put("deltas", jSONArray);
        return hashMap;
    }

    private static HashMap<Object, Object> d(String str, int i6, int i7, int i8, int i9) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i6));
        hashMap.put("selectionExtent", Integer.valueOf(i7));
        hashMap.put("composingBase", Integer.valueOf(i8));
        hashMap.put("composingExtent", Integer.valueOf(i9));
        return hashMap;
    }

    public void b(int i6, Map<String, Object> map) {
        k3.b.f("TextInputChannel", "Sending 'commitContent' message.");
        this.f10611a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i6), "TextInputAction.commitContent", map));
    }

    public void e(int i6) {
        k3.b.f("TextInputChannel", "Sending 'done' message.");
        this.f10611a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i6), "TextInputAction.done"));
    }

    public void f(int i6) {
        k3.b.f("TextInputChannel", "Sending 'go' message.");
        this.f10611a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i6), "TextInputAction.go"));
    }

    public void g(int i6) {
        k3.b.f("TextInputChannel", "Sending 'newline' message.");
        this.f10611a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i6), "TextInputAction.newline"));
    }

    public void h(int i6) {
        k3.b.f("TextInputChannel", "Sending 'next' message.");
        this.f10611a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i6), "TextInputAction.next"));
    }

    public void i(int i6, String str, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        if (bundle != null) {
            HashMap hashMap2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    hashMap2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    hashMap2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    hashMap2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    hashMap2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    hashMap2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    hashMap2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    hashMap2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    hashMap2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            hashMap.put(cs.a.DATA, hashMap2);
        }
        this.f10611a.c("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(i6), hashMap));
    }

    public void j(int i6) {
        k3.b.f("TextInputChannel", "Sending 'previous' message.");
        this.f10611a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i6), "TextInputAction.previous"));
    }

    public void k() {
        this.f10611a.c("TextInputClient.requestExistingInputState", null);
    }

    public void l(int i6) {
        k3.b.f("TextInputChannel", "Sending 'search' message.");
        this.f10611a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i6), "TextInputAction.search"));
    }

    public void m(int i6) {
        k3.b.f("TextInputChannel", "Sending 'send' message.");
        this.f10611a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i6), "TextInputAction.send"));
    }

    public void n(f fVar) {
        this.f10612b = fVar;
    }

    public void o(int i6) {
        k3.b.f("TextInputChannel", "Sending 'unspecified' message.");
        this.f10611a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i6), "TextInputAction.unspecified"));
    }

    public void p(int i6, String str, int i7, int i8, int i9, int i10) {
        k3.b.f("TextInputChannel", "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i7 + "\nSelection end: " + i8 + "\nComposing start: " + i9 + "\nComposing end: " + i10);
        this.f10611a.c("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i6), d(str, i7, i8, i9, i10)));
    }

    public void q(int i6, ArrayList<io.flutter.plugin.editing.l> arrayList) {
        k3.b.f("TextInputChannel", "Sending message to update editing state with deltas: \nNumber of deltas: " + arrayList.size());
        this.f10611a.c("TextInputClient.updateEditingStateWithDeltas", Arrays.asList(Integer.valueOf(i6), c(arrayList)));
    }

    public void r(int i6, HashMap<String, e> hashMap) {
        k3.b.f("TextInputChannel", "Sending message to update editing state for " + String.valueOf(hashMap.size()) + " field(s).");
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, e> entry : hashMap.entrySet()) {
            e value = entry.getValue();
            hashMap2.put(entry.getKey(), d(value.f10640a, value.f10641b, value.f10642c, -1, -1));
        }
        this.f10611a.c("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i6), hashMap2));
    }
}
