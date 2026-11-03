package androidx.window.embedding;

import f4.t;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class ActivityRule extends EmbeddingRule {
    private final boolean alwaysExpand;
    private final Set<ActivityFilter> filters;

    public ActivityRule(Set<ActivityFilter> filters, boolean z5) {
        Set<ActivityFilter> K;
        k.e(filters, "filters");
        this.alwaysExpand = z5;
        K = t.K(filters);
        this.filters = K;
    }

    public /* synthetic */ ActivityRule(Set set, boolean z5, int i6, kotlin.jvm.internal.g gVar) {
        this(set, (i6 & 2) != 0 ? false : z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityRule)) {
            return false;
        }
        ActivityRule activityRule = (ActivityRule) obj;
        return k.a(this.filters, activityRule.filters) && this.alwaysExpand == activityRule.alwaysExpand;
    }

    public final boolean getAlwaysExpand() {
        return this.alwaysExpand;
    }

    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public int hashCode() {
        return (this.filters.hashCode() * 31) + a.a(this.alwaysExpand);
    }

    public final ActivityRule plus$window_release(ActivityFilter filter) {
        Set K;
        k.e(filter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(filter);
        K = t.K(linkedHashSet);
        return new ActivityRule(K, this.alwaysExpand);
    }
}
