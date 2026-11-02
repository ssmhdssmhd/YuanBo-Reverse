package a4;

import android.view.PointerIcon;
import java.util.HashMap;
import x3.g;

/* loaded from: classes.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, Integer> f148c;

    /* renamed from: a, reason: collision with root package name */
    private final c f149a;

    /* renamed from: b, reason: collision with root package name */
    private final g f150b;

    class a implements g.b {
        a() {
        }

        @Override // x3.g.b
        public void a(String str) {
            b.this.f149a.setPointerIcon(b.this.d(str));
        }
    }

    /* renamed from: a4.b$b, reason: collision with other inner class name */
    class C0002b extends HashMap<String, Integer> {
        C0002b() {
            put("alias", 1010);
            put("allScroll", 1013);
            put("basic", 1000);
            put("cell", 1006);
            put("click", 1002);
            put("contextMenu", 1001);
            put("copy", 1011);
            put("forbidden", 1012);
            put("grab", 1020);
            put("grabbing", 1021);
            put("help", 1003);
            put("move", 1013);
            put("none", 0);
            put("noDrop", 1012);
            put("precise", 1007);
            put("text", 1008);
            put("resizeColumn", 1014);
            put("resizeDown", 1015);
            put("resizeUpLeft", 1016);
            put("resizeDownRight", 1017);
            put("resizeLeft", 1014);
            put("resizeLeftRight", 1014);
            put("resizeRight", 1014);
            put("resizeRow", 1015);
            put("resizeUp", 1015);
            put("resizeUpDown", 1015);
            put("resizeUpLeft", 1017);
            put("resizeUpRight", 1016);
            put("resizeUpLeftDownRight", 1017);
            put("resizeUpRightDownLeft", 1016);
            put("verticalText", 1009);
            put("wait", 1004);
            put("zoomIn", 1018);
            put("zoomOut", 1019);
        }
    }

    public interface c {
        PointerIcon b(int i6);

        void setPointerIcon(PointerIcon pointerIcon);
    }

    public b(c cVar, g gVar) {
        this.f149a = cVar;
        this.f150b = gVar;
        gVar.b(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointerIcon d(String str) {
        Object orDefault;
        if (f148c == null) {
            f148c = new C0002b();
        }
        orDefault = f148c.getOrDefault(str, 1000);
        return this.f149a.b(((Integer) orDefault).intValue());
    }

    public void c() {
        this.f150b.b(null);
    }
}
