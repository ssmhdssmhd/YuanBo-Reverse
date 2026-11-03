package androidx.window.embedding;

import f4.t;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class SplitPairRule extends SplitRule {
    private final boolean clearTop;
    private final Set<SplitPairFilter> filters;
    private final boolean finishPrimaryWithSecondary;
    private final boolean finishSecondaryWithPrimary;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitPairRule(Set<SplitPairFilter> filters, boolean z5, boolean z6, boolean z7, int i6, int i7, float f6, int i8) {
        super(i6, i7, f6, i8);
        Set<SplitPairFilter> K;
        k.e(filters, "filters");
        this.finishPrimaryWithSecondary = z5;
        this.finishSecondaryWithPrimary = z6;
        this.clearTop = z7;
        K = t.K(filters);
        this.filters = K;
    }

    public /* synthetic */ SplitPairRule(Set set, boolean z5, boolean z6, boolean z7, int i6, int i7, float f6, int i8, int i9, kotlin.jvm.internal.g gVar) {
        this(set, (i9 & 2) != 0 ? false : z5, (i9 & 4) != 0 ? true : z6, (i9 & 8) != 0 ? false : z7, (i9 & 16) != 0 ? 0 : i6, (i9 & 32) == 0 ? i7 : 0, (i9 & 64) != 0 ? 0.5f : f6, (i9 & 128) != 0 ? 3 : i8);
    }

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairRule) || !super.equals(obj)) {
            return false;
        }
        SplitPairRule splitPairRule = (SplitPairRule) obj;
        return k.a(this.filters, splitPairRule.filters) && this.finishPrimaryWithSecondary == splitPairRule.finishPrimaryWithSecondary && this.finishSecondaryWithPrimary == splitPairRule.finishSecondaryWithPrimary && this.clearTop == splitPairRule.clearTop;
    }

    public final boolean getClearTop() {
        return this.clearTop;
    }

    public final Set<SplitPairFilter> getFilters() {
        return this.filters;
    }

    public final boolean getFinishPrimaryWithSecondary() {
        return this.finishPrimaryWithSecondary;
    }

    public final boolean getFinishSecondaryWithPrimary() {
        return this.finishSecondaryWithPrimary;
    }

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        return (((((((super.hashCode() * 31) + this.filters.hashCode()) * 31) + a.a(this.finishPrimaryWithSecondary)) * 31) + a.a(this.finishSecondaryWithPrimary)) * 31) + a.a(this.clearTop);
    }

    public final SplitPairRule plus$window_release(SplitPairFilter filter) {
        Set K;
        k.e(filter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(filter);
        K = t.K(linkedHashSet);
        return new SplitPairRule(K, this.finishPrimaryWithSecondary, this.finishSecondaryWithPrimary, this.clearTop, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }
}
