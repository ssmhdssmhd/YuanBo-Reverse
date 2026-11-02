package io.flutter.plugin.editing;

import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import x3.n;
import y3.k;

/* loaded from: classes.dex */
public class k implements n.b, SpellCheckerSession.SpellCheckerSessionListener {

    /* renamed from: a, reason: collision with root package name */
    private final x3.n f6105a;

    /* renamed from: b, reason: collision with root package name */
    private final TextServicesManager f6106b;

    /* renamed from: c, reason: collision with root package name */
    private SpellCheckerSession f6107c;

    /* renamed from: d, reason: collision with root package name */
    k.d f6108d;

    public k(TextServicesManager textServicesManager, x3.n nVar) {
        this.f6106b = textServicesManager;
        this.f6105a = nVar;
        nVar.b(this);
    }

    @Override // x3.n.b
    public void a(String str, String str2, k.d dVar) {
        if (this.f6108d != null) {
            dVar.a("error", "Previous spell check request still pending.", null);
        } else {
            this.f6108d = dVar;
            c(str, str2);
        }
    }

    public void b() {
        this.f6105a.b(null);
        SpellCheckerSession spellCheckerSession = this.f6107c;
        if (spellCheckerSession != null) {
            spellCheckerSession.close();
        }
    }

    public void c(String str, String str2) {
        Locale b6 = z3.d.b(str);
        if (this.f6107c == null) {
            this.f6107c = this.f6106b.newSpellCheckerSession(null, b6, this, true);
        }
        this.f6107c.getSentenceSuggestions(new TextInfo[]{new TextInfo(str2)}, 5);
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
        ArrayList arrayList;
        k.d dVar;
        if (sentenceSuggestionsInfoArr.length == 0) {
            dVar = this.f6108d;
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList();
            SentenceSuggestionsInfo sentenceSuggestionsInfo = sentenceSuggestionsInfoArr[0];
            for (int i6 = 0; i6 < sentenceSuggestionsInfo.getSuggestionsCount(); i6++) {
                SuggestionsInfo suggestionsInfoAt = sentenceSuggestionsInfo.getSuggestionsInfoAt(i6);
                int suggestionsCount = suggestionsInfoAt.getSuggestionsCount();
                if (suggestionsCount > 0) {
                    HashMap hashMap = new HashMap();
                    int offsetAt = sentenceSuggestionsInfo.getOffsetAt(i6);
                    int lengthAt = sentenceSuggestionsInfo.getLengthAt(i6) + offsetAt;
                    hashMap.put("startIndex", Integer.valueOf(offsetAt));
                    hashMap.put("endIndex", Integer.valueOf(lengthAt));
                    ArrayList arrayList2 = new ArrayList();
                    for (int i7 = 0; i7 < suggestionsCount; i7++) {
                        arrayList2.add(suggestionsInfoAt.getSuggestionAt(i7));
                    }
                    hashMap.put("suggestions", arrayList2);
                    arrayList.add(hashMap);
                }
            }
            dVar = this.f6108d;
        }
        dVar.b(arrayList);
        this.f6108d = null;
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr) {
    }
}
