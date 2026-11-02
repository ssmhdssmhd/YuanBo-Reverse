package b1;

import h0.y1;

/* loaded from: classes.dex */
public interface d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1696a = new a();

    class a implements d {
        a() {
        }

        @Override // b1.d
        public boolean a(y1 y1Var) {
            String str = y1Var.f5066p;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        @Override // b1.d
        public c b(y1 y1Var) {
            String str = y1Var.f5066p;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new c1.b();
                    case "application/x-icy":
                        return new f1.a();
                    case "application/id3":
                        return new g1.h();
                    case "application/x-emsg":
                        return new d1.b();
                    case "application/x-scte35":
                        return new i1.c();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(y1 y1Var);

    c b(y1 y1Var);
}
