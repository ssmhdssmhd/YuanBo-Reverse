package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    private final int f452a;

    /* renamed from: b, reason: collision with root package name */
    private final x f453b;

    /* renamed from: c, reason: collision with root package name */
    private final int f454c;

    public a(int i6, x xVar, int i7) {
        this.f452a = i6;
        this.f453b = xVar;
        this.f454c = i7;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f452a);
        this.f453b.G(this.f454c, bundle);
    }
}
