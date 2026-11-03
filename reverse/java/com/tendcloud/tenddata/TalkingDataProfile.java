package com.tendcloud.tenddata;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class TalkingDataProfile extends JSONObject {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2177a = "name";

    /* renamed from: b, reason: collision with root package name */
    private static final String f2178b = "type";

    /* renamed from: c, reason: collision with root package name */
    private static final String f2179c = "gender";

    /* renamed from: d, reason: collision with root package name */
    private static final String f2180d = "age";

    /* renamed from: e, reason: collision with root package name */
    private static final String f2181e = "property1";

    /* renamed from: f, reason: collision with root package name */
    private static final String f2182f = "property2";

    /* renamed from: g, reason: collision with root package name */
    private static final String f2183g = "property3";

    /* renamed from: h, reason: collision with root package name */
    private static final String f2184h = "property4";

    /* renamed from: i, reason: collision with root package name */
    private static final String f2185i = "property5";

    /* renamed from: j, reason: collision with root package name */
    private static final String f2186j = "property6";

    /* renamed from: k, reason: collision with root package name */
    private static final String f2187k = "property7";

    /* renamed from: l, reason: collision with root package name */
    private static final String f2188l = "property8";

    /* renamed from: m, reason: collision with root package name */
    private static final String f2189m = "property9";

    /* renamed from: n, reason: collision with root package name */
    private static final String f2190n = "property10";

    private TalkingDataProfile() {
    }

    public static TalkingDataProfile createProfile() {
        return new TalkingDataProfile();
    }

    public TalkingDataProfile setAge(int i6) {
        try {
            put(f2180d, i6);
        } catch (Throwable th) {
            h.a("set age error ", th);
        }
        return this;
    }

    public TalkingDataProfile setGender(TalkingDataGender talkingDataGender) {
        try {
            put(f2179c, talkingDataGender.index());
        } catch (Throwable th) {
            h.a("set gender error ", th);
        }
        return this;
    }

    public TalkingDataProfile setName(String str) {
        try {
            put(f2177a, str);
        } catch (Throwable th) {
            h.a("set name error ", th);
        }
        return this;
    }

    public TalkingDataProfile setProperty1(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f2181e, obj);
            }
        } catch (Throwable th) {
            h.a("set property1 error ", th);
        }
        return this;
    }

    public TalkingDataProfile setProperty10(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f2190n, obj);
            }
        } catch (Throwable th) {
            h.a("set property10 error ", th);
        }
        return this;
    }

    public TalkingDataProfile setProperty2(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f2182f, obj);
            }
        } catch (Throwable th) {
            h.a("set property2 error ", th);
        }
        return this;
    }

    public TalkingDataProfile setProperty3(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f2183g, obj);
            }
        } catch (Throwable th) {
            h.a("set property3 error ", th);
        }
        return this;
    }

    public TalkingDataProfile setProperty4(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f2184h, obj);
            }
        } catch (Throwable th) {
            h.a("set property4 error ", th);
        }
        return this;
    }

    public TalkingDataProfile setProperty5(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f2185i, obj);
            }
        } catch (Throwable th) {
            h.a("set property5 error ", th);
        }
        return this;
    }

    public TalkingDataProfile setProperty6(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f2186j, obj);
            }
        } catch (Throwable th) {
            h.a("set property6 error ", th);
        }
        return this;
    }

    public TalkingDataProfile setProperty7(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f2187k, obj);
            }
        } catch (Throwable th) {
            h.a("set property7 error ", th);
        }
        return this;
    }

    public TalkingDataProfile setProperty8(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f2188l, obj);
            }
        } catch (Throwable th) {
            h.a("set property8 error ", th);
        }
        return this;
    }

    public TalkingDataProfile setProperty9(Object obj) {
        try {
            if ((obj instanceof String) || (obj instanceof Number)) {
                put(f2189m, obj);
            }
        } catch (Throwable th) {
            h.a("set property9 error ", th);
        }
        return this;
    }

    public TalkingDataProfile setType(TalkingDataProfileType talkingDataProfileType) {
        try {
            put(f2178b, talkingDataProfileType.index());
        } catch (Throwable th) {
            h.a("set type error ", th);
        }
        return this;
    }
}
