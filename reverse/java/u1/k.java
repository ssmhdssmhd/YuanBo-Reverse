package u1;

import h0.y1;

/* loaded from: classes.dex */
public interface k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f9654a = new a();

    class a implements k {
        a() {
        }

        @Override // u1.k
        public boolean a(y1 y1Var) {
            String str = y1Var.f5066p;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || "text/x-exoplayer-cues".equals(str);
        }

        @Override // u1.k
        public i b(y1 y1Var) {
            String str = y1Var.f5066p;
            if (str != null) {
                switch (str) {
                    case "application/dvbsubs":
                        return new w1.a(y1Var.f5068r);
                    case "application/pgs":
                        return new x1.a();
                    case "application/x-mp4-vtt":
                        return new d2.a();
                    case "text/vtt":
                        return new d2.h();
                    case "application/x-quicktime-tx3g":
                        return new c2.a(y1Var.f5068r);
                    case "text/x-ssa":
                        return new z1.a(y1Var.f5068r);
                    case "application/x-mp4-cea-608":
                    case "application/cea-608":
                        return new v1.a(str, y1Var.H, 16000L);
                    case "text/x-exoplayer-cues":
                        return new f();
                    case "application/cea-708":
                        return new v1.c(y1Var.H, y1Var.f5068r);
                    case "application/x-subrip":
                        return new a2.a();
                    case "application/ttml+xml":
                        return new b2.c();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(y1 y1Var);

    i b(y1 y1Var);
}
