package i2;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class l {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int a(String str) {
        char c6;
        if (str == null) {
            return -1;
        }
        String t5 = x.t(str);
        t5.hashCode();
        switch (t5.hashCode()) {
            case -2123537834:
                if (t5.equals("audio/eac3-joc")) {
                    c6 = 0;
                    break;
                }
                c6 = 65535;
                break;
            case -1662384011:
                if (t5.equals("video/mp2p")) {
                    c6 = 1;
                    break;
                }
                c6 = 65535;
                break;
            case -1662384007:
                if (t5.equals("video/mp2t")) {
                    c6 = 2;
                    break;
                }
                c6 = 65535;
                break;
            case -1662095187:
                if (t5.equals("video/webm")) {
                    c6 = 3;
                    break;
                }
                c6 = 65535;
                break;
            case -1606874997:
                if (t5.equals("audio/amr-wb")) {
                    c6 = 4;
                    break;
                }
                c6 = 65535;
                break;
            case -1487394660:
                if (t5.equals("image/jpeg")) {
                    c6 = 5;
                    break;
                }
                c6 = 65535;
                break;
            case -1248337486:
                if (t5.equals("application/mp4")) {
                    c6 = 6;
                    break;
                }
                c6 = 65535;
                break;
            case -1079884372:
                if (t5.equals("video/x-msvideo")) {
                    c6 = 7;
                    break;
                }
                c6 = 65535;
                break;
            case -1004728940:
                if (t5.equals("text/vtt")) {
                    c6 = '\b';
                    break;
                }
                c6 = 65535;
                break;
            case -387023398:
                if (t5.equals("audio/x-matroska")) {
                    c6 = '\t';
                    break;
                }
                c6 = 65535;
                break;
            case -43467528:
                if (t5.equals("application/webm")) {
                    c6 = '\n';
                    break;
                }
                c6 = 65535;
                break;
            case 13915911:
                if (t5.equals("video/x-flv")) {
                    c6 = 11;
                    break;
                }
                c6 = 65535;
                break;
            case 187078296:
                if (t5.equals("audio/ac3")) {
                    c6 = '\f';
                    break;
                }
                c6 = 65535;
                break;
            case 187078297:
                if (t5.equals("audio/ac4")) {
                    c6 = '\r';
                    break;
                }
                c6 = 65535;
                break;
            case 187078669:
                if (t5.equals("audio/amr")) {
                    c6 = 14;
                    break;
                }
                c6 = 65535;
                break;
            case 187090232:
                if (t5.equals("audio/mp4")) {
                    c6 = 15;
                    break;
                }
                c6 = 65535;
                break;
            case 187091926:
                if (t5.equals("audio/ogg")) {
                    c6 = 16;
                    break;
                }
                c6 = 65535;
                break;
            case 187099443:
                if (t5.equals("audio/wav")) {
                    c6 = 17;
                    break;
                }
                c6 = 65535;
                break;
            case 1331848029:
                if (t5.equals("video/mp4")) {
                    c6 = 18;
                    break;
                }
                c6 = 65535;
                break;
            case 1503095341:
                if (t5.equals("audio/3gpp")) {
                    c6 = 19;
                    break;
                }
                c6 = 65535;
                break;
            case 1504578661:
                if (t5.equals("audio/eac3")) {
                    c6 = 20;
                    break;
                }
                c6 = 65535;
                break;
            case 1504619009:
                if (t5.equals("audio/flac")) {
                    c6 = 21;
                    break;
                }
                c6 = 65535;
                break;
            case 1504824762:
                if (t5.equals("audio/midi")) {
                    c6 = 22;
                    break;
                }
                c6 = 65535;
                break;
            case 1504831518:
                if (t5.equals("audio/mpeg")) {
                    c6 = 23;
                    break;
                }
                c6 = 65535;
                break;
            case 1505118770:
                if (t5.equals("audio/webm")) {
                    c6 = 24;
                    break;
                }
                c6 = 65535;
                break;
            case 2039520277:
                if (t5.equals("video/x-matroska")) {
                    c6 = 25;
                    break;
                }
                c6 = 65535;
                break;
            default:
                c6 = 65535;
                break;
        }
        switch (c6) {
        }
        return -1;
    }

    public static int b(Map<String, List<String>> map) {
        List<String> list = map.get("Content-Type");
        return a((list == null || list.isEmpty()) ? null : list.get(0));
    }

    public static int c(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
            return 15;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
            return 14;
        }
        return lastPathSegment.endsWith(".avi") ? 16 : -1;
    }
}
