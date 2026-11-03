package com.tendcloud.tenddata;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tendcloud.tenddata.m;

/* loaded from: classes.dex */
public class f {

    /* renamed from: e, reason: collision with root package name */
    public static final Parcelable.Creator<f> f2648e = new Parcelable.Creator<f>() { // from class: com.tendcloud.tenddata.f.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public f createFromParcel(Parcel parcel) {
            try {
                return new f(parcel);
            } catch (Throwable unused) {
                return null;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public f[] newArray(int i6) {
            try {
                return new f[i6];
            } catch (Throwable unused) {
                return null;
            }
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public boolean f2649a;

    /* renamed from: b, reason: collision with root package name */
    public int f2650b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2651c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2652d;

    /* renamed from: f, reason: collision with root package name */
    private final m.a f2653f;

    public f(int i6) {
        int uid;
        this.f2652d = i6;
        this.f2651c = a(i6);
        m.a aVar = m.a.get(i6);
        this.f2653f = aVar;
        m.d d6 = d();
        if (aVar != null) {
            try {
                m.b group = aVar.getGroup("cpuacct");
                String str = aVar.getGroup("cpu").group;
                if (str != null) {
                    this.f2649a = !str.contains("bg_non_interactive");
                    if (group.group.split("/").length > 1) {
                        uid = Integer.parseInt(group.group.split("/")[1].replace("uid_", ""));
                    } else if (d6 == null) {
                        return;
                    } else {
                        uid = d6.getUid();
                    }
                } else if (d6 == null) {
                    return;
                } else {
                    uid = d6.getUid();
                }
                this.f2650b = uid;
            } catch (Throwable unused) {
                if (d6 != null) {
                    this.f2650b = d6.getUid();
                }
            }
        }
    }

    protected f(Parcel parcel) {
        this.f2651c = parcel.readString();
        this.f2652d = parcel.readInt();
        this.f2653f = (m.a) parcel.readParcelable(m.a.class.getClassLoader());
        this.f2649a = parcel.readByte() != 0;
    }

    static String a(int i6) {
        String str = null;
        try {
            str = m.readFile(String.format("/proc/%d/cmdline", Integer.valueOf(i6))).trim();
            if (TextUtils.isEmpty(str)) {
                return m.c.get(i6).getComm();
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    public String a() {
        try {
            return this.f2651c.split(":")[0];
        } catch (Throwable unused) {
            return "";
        }
    }

    public String b() {
        try {
            if (this.f2651c.split(":").length <= 1) {
                return "";
            }
            return ":" + this.f2651c.split(":")[1];
        } catch (Throwable unused) {
            return "";
        }
    }

    public m.a c() {
        return this.f2653f;
    }

    public final m.d d() {
        try {
            return m.d.get(this.f2652d);
        } catch (Throwable unused) {
            return null;
        }
    }

    public m.c e() {
        try {
            return m.c.get(this.f2652d);
        } catch (Throwable unused) {
            return null;
        }
    }
}
