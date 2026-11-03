package w0;

import b1.a;
import h0.y1;
import i2.i0;
import i2.t;
import o0.x;

/* loaded from: classes.dex */
final class h {

    /* renamed from: a, reason: collision with root package name */
    static final String[] f10071a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    private static g1.e a(int i6, i0 i0Var) {
        int o6 = i0Var.o();
        if (i0Var.o() == 1684108385) {
            i0Var.T(8);
            String A = i0Var.A(o6 - 16);
            return new g1.e("und", A, A);
        }
        t.i("MetadataUtil", "Failed to parse comment attribute: " + a.a(i6));
        return null;
    }

    private static g1.a b(i0 i0Var) {
        String str;
        int o6 = i0Var.o();
        if (i0Var.o() == 1684108385) {
            int b6 = a.b(i0Var.o());
            String str2 = b6 == 13 ? "image/jpeg" : b6 == 14 ? "image/png" : null;
            if (str2 != null) {
                i0Var.T(4);
                int i6 = o6 - 16;
                byte[] bArr = new byte[i6];
                i0Var.j(bArr, 0, i6);
                return new g1.a(str2, null, 3, bArr);
            }
            str = "Unrecognized cover art flags: " + b6;
        } else {
            str = "Failed to parse cover art attribute";
        }
        t.i("MetadataUtil", str);
        return null;
    }

    public static a.b c(i0 i0Var) {
        int f6 = i0Var.f() + i0Var.o();
        int o6 = i0Var.o();
        int i6 = (o6 >> 24) & 255;
        try {
            if (i6 == 169 || i6 == 253) {
                int i7 = 16777215 & o6;
                if (i7 == 6516084) {
                    return a(o6, i0Var);
                }
                if (i7 == 7233901 || i7 == 7631467) {
                    return h(o6, "TIT2", i0Var);
                }
                if (i7 == 6516589 || i7 == 7828084) {
                    return h(o6, "TCOM", i0Var);
                }
                if (i7 == 6578553) {
                    return h(o6, "TDRC", i0Var);
                }
                if (i7 == 4280916) {
                    return h(o6, "TPE1", i0Var);
                }
                if (i7 == 7630703) {
                    return h(o6, "TSSE", i0Var);
                }
                if (i7 == 6384738) {
                    return h(o6, "TALB", i0Var);
                }
                if (i7 == 7108978) {
                    return h(o6, "USLT", i0Var);
                }
                if (i7 == 6776174) {
                    return h(o6, "TCON", i0Var);
                }
                if (i7 == 6779504) {
                    return h(o6, "TIT1", i0Var);
                }
            } else {
                if (o6 == 1735291493) {
                    return g(i0Var);
                }
                if (o6 == 1684632427) {
                    return d(o6, "TPOS", i0Var);
                }
                if (o6 == 1953655662) {
                    return d(o6, "TRCK", i0Var);
                }
                if (o6 == 1953329263) {
                    return i(o6, "TBPM", i0Var, true, false);
                }
                if (o6 == 1668311404) {
                    return i(o6, "TCMP", i0Var, true, true);
                }
                if (o6 == 1668249202) {
                    return b(i0Var);
                }
                if (o6 == 1631670868) {
                    return h(o6, "TPE2", i0Var);
                }
                if (o6 == 1936682605) {
                    return h(o6, "TSOT", i0Var);
                }
                if (o6 == 1936679276) {
                    return h(o6, "TSO2", i0Var);
                }
                if (o6 == 1936679282) {
                    return h(o6, "TSOA", i0Var);
                }
                if (o6 == 1936679265) {
                    return h(o6, "TSOP", i0Var);
                }
                if (o6 == 1936679791) {
                    return h(o6, "TSOC", i0Var);
                }
                if (o6 == 1920233063) {
                    return i(o6, "ITUNESADVISORY", i0Var, false, false);
                }
                if (o6 == 1885823344) {
                    return i(o6, "ITUNESGAPLESS", i0Var, false, true);
                }
                if (o6 == 1936683886) {
                    return h(o6, "TVSHOWSORT", i0Var);
                }
                if (o6 == 1953919848) {
                    return h(o6, "TVSHOW", i0Var);
                }
                if (o6 == 757935405) {
                    return e(i0Var, f6);
                }
            }
            t.b("MetadataUtil", "Skipped unknown metadata entry: " + a.a(o6));
            i0Var.S(f6);
            return null;
        } finally {
            i0Var.S(f6);
        }
    }

    private static g1.m d(int i6, String str, i0 i0Var) {
        int o6 = i0Var.o();
        if (i0Var.o() == 1684108385 && o6 >= 22) {
            i0Var.T(10);
            int L = i0Var.L();
            if (L > 0) {
                String str2 = "" + L;
                int L2 = i0Var.L();
                if (L2 > 0) {
                    str2 = str2 + "/" + L2;
                }
                return new g1.m(str, null, m2.q.r(str2));
            }
        }
        t.i("MetadataUtil", "Failed to parse index/count attribute: " + a.a(i6));
        return null;
    }

    private static g1.i e(i0 i0Var, int i6) {
        String str = null;
        String str2 = null;
        int i7 = -1;
        int i8 = -1;
        while (i0Var.f() < i6) {
            int f6 = i0Var.f();
            int o6 = i0Var.o();
            int o7 = i0Var.o();
            i0Var.T(4);
            if (o7 == 1835360622) {
                str = i0Var.A(o6 - 12);
            } else if (o7 == 1851878757) {
                str2 = i0Var.A(o6 - 12);
            } else {
                if (o7 == 1684108385) {
                    i7 = f6;
                    i8 = o6;
                }
                i0Var.T(o6 - 12);
            }
        }
        if (str == null || str2 == null || i7 == -1) {
            return null;
        }
        i0Var.S(i7);
        i0Var.T(16);
        return new g1.j(str, str2, i0Var.A(i8 - 16));
    }

    public static h1.a f(i0 i0Var, int i6, String str) {
        while (true) {
            int f6 = i0Var.f();
            if (f6 >= i6) {
                return null;
            }
            int o6 = i0Var.o();
            if (i0Var.o() == 1684108385) {
                int o7 = i0Var.o();
                int o8 = i0Var.o();
                int i7 = o6 - 16;
                byte[] bArr = new byte[i7];
                i0Var.j(bArr, 0, i7);
                return new h1.a(str, bArr, o8, o7);
            }
            i0Var.S(f6 + o6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static g1.m g(i2.i0 r3) {
        /*
            int r3 = j(r3)
            r0 = 0
            if (r3 <= 0) goto L11
            java.lang.String[] r1 = w0.h.f10071a
            int r2 = r1.length
            if (r3 > r2) goto L11
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L20
            g1.m r1 = new g1.m
            java.lang.String r2 = "TCON"
            m2.q r3 = m2.q.r(r3)
            r1.<init>(r2, r0, r3)
            return r1
        L20:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            i2.t.i(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.h.g(i2.i0):g1.m");
    }

    private static g1.m h(int i6, String str, i0 i0Var) {
        int o6 = i0Var.o();
        if (i0Var.o() == 1684108385) {
            i0Var.T(8);
            return new g1.m(str, null, m2.q.r(i0Var.A(o6 - 16)));
        }
        t.i("MetadataUtil", "Failed to parse text attribute: " + a.a(i6));
        return null;
    }

    private static g1.i i(int i6, String str, i0 i0Var, boolean z5, boolean z6) {
        int j6 = j(i0Var);
        if (z6) {
            j6 = Math.min(1, j6);
        }
        if (j6 >= 0) {
            return z5 ? new g1.m(str, null, m2.q.r(Integer.toString(j6))) : new g1.e("und", str, Integer.toString(j6));
        }
        t.i("MetadataUtil", "Failed to parse uint8 attribute: " + a.a(i6));
        return null;
    }

    private static int j(i0 i0Var) {
        i0Var.T(4);
        if (i0Var.o() == 1684108385) {
            i0Var.T(8);
            return i0Var.F();
        }
        t.i("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i6, x xVar, y1.b bVar) {
        if (i6 == 1 && xVar.a()) {
            bVar.P(xVar.f8433a).Q(xVar.f8434b);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
    
        if (r6 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void l(int r5, b1.a r6, b1.a r7, h0.y1.b r8, b1.a... r9) {
        /*
            b1.a r0 = new b1.a
            r1 = 0
            b1.a$b[] r2 = new b1.a.b[r1]
            r0.<init>(r2)
            r2 = 1
            if (r5 != r2) goto Le
            if (r6 == 0) goto L3c
            goto L3d
        Le:
            r6 = 2
            if (r5 != r6) goto L3c
            if (r7 == 0) goto L3c
            r5 = 0
        L14:
            int r6 = r7.h()
            if (r5 >= r6) goto L3c
            b1.a$b r6 = r7.g(r5)
            boolean r3 = r6 instanceof h1.a
            if (r3 == 0) goto L39
            h1.a r6 = (h1.a) r6
            java.lang.String r3 = r6.f5113a
            java.lang.String r4 = "com.android.capture.fps"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L39
            b1.a r5 = new b1.a
            b1.a$b[] r7 = new b1.a.b[r2]
            r7[r1] = r6
            r5.<init>(r7)
            r6 = r5
            goto L3d
        L39:
            int r5 = r5 + 1
            goto L14
        L3c:
            r6 = r0
        L3d:
            int r5 = r9.length
        L3e:
            if (r1 >= r5) goto L49
            r7 = r9[r1]
            b1.a r6 = r6.e(r7)
            int r1 = r1 + 1
            goto L3e
        L49:
            int r5 = r6.h()
            if (r5 <= 0) goto L52
            r8.Z(r6)
        L52:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.h.l(int, b1.a, b1.a, h0.y1$b, b1.a[]):void");
    }
}
