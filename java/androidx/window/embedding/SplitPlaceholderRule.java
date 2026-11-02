package androidx.window.embedding;

import android.content.Intent;
import f4.t;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class SplitPlaceholderRule extends SplitRule {
    private final Set<ActivityFilter> filters;
    private final Intent placeholderIntent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitPlaceholderRule(Set<ActivityFilter> filters, Intent placeholderIntent, int i6, int i7, float f6, int i8) {
        super(i6, i7, f6, i8);
        Set<ActivityFilter> K;
        k.e(filters, "filters");
        k.e(placeholderIntent, "placeholderIntent");
        this.placeholderIntent = placeholderIntent;
        K = t.K(filters);
        this.filters = K;
    }

    public /* synthetic */ SplitPlaceholderRule(Set set, Intent intent, int i6, int i7, float f6, int i8, int i9, kotlin.jvm.internal.g gVar) {
        this(set, intent, (i9 & 4) != 0 ? 0 : i6, (i9 & 8) != 0 ? 0 : i7, (i9 & 16) != 0 ? 0.5f : f6, (i9 & 32) != 0 ? 3 : i8);
    }

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPlaceholderRule) || !super.equals(obj) || !super.equals(obj)) {
            return false;
        }
        SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) obj;
        return k.a(this.filters, splitPlaceholderRule.filters) && k.a(this.placeholderIntent, splitPlaceholderRule.placeholderIntent);
    }

    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public final Intent getPlaceholderIntent() {
        return this.placeholderIntent;
    }

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        return (((super.hashCode() * 31) + this.filters.hashCode()) * 31) + this.placeholderIntent.hashCode();
    }

    public final SplitPlaceholderRule plus$window_release(ActivityFilter filter) {
        Set K;
        k.e(filter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(filter);
        K = t.K(linkedHashSet);
        return new SplitPlaceholderRule(K, this.placeholderIntent, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }
}
