package com.tendcloud.tenddata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a {
    public static final a ENV;
    private static volatile List<String> FeaturesList = new ArrayList();
    public static final String MF_JSON = "UNIFIED_SDK_JSON";
    public static final a UNIVERSAL;
    private static final a[] service;
    private int indexNum;
    private String nameString;

    static {
        a aVar = new a("ENV", 2) { // from class: com.tendcloud.tenddata.a.1
            @Override // com.tendcloud.tenddata.a
            public String getCert() {
                return "";
            }

            @Override // com.tendcloud.tenddata.a
            public String getDataFolder() {
                return super.getDataFolder();
            }

            @Override // com.tendcloud.tenddata.a
            public int getFileLimitType() {
                return super.getFileLimitType();
            }

            @Override // com.tendcloud.tenddata.a
            public String getHost() {
                return aa.f2210j;
            }

            @Override // com.tendcloud.tenddata.a
            public String getIP() {
                return aa.f2212l;
            }

            @Override // com.tendcloud.tenddata.a
            public String getMessageFormat() {
                return a.MF_JSON;
            }

            @Override // com.tendcloud.tenddata.a
            public String getRootFolder() {
                return super.getRootFolder();
            }

            @Override // com.tendcloud.tenddata.a
            public String getUrl() {
                return "https://me.cpatrk.net";
            }
        };
        ENV = aVar;
        a aVar2 = new a("SDK", 99) { // from class: com.tendcloud.tenddata.a.2
            private boolean isUrlUpdated = false;
            private String url;

            @Override // com.tendcloud.tenddata.a
            public String getCert() {
                return "";
            }

            @Override // com.tendcloud.tenddata.a
            public String getDataFolder() {
                return super.getDataFolder();
            }

            @Override // com.tendcloud.tenddata.a
            public int getFileLimitType() {
                return super.getFileLimitType();
            }

            @Override // com.tendcloud.tenddata.a
            public String getHost() {
                return aa.f2202b;
            }

            @Override // com.tendcloud.tenddata.a
            public String getIP() {
                return aa.f2205e;
            }

            @Override // com.tendcloud.tenddata.a
            public String getMessageFormat() {
                return a.MF_JSON;
            }

            @Override // com.tendcloud.tenddata.a
            public String getRootFolder() {
                return super.getRootFolder();
            }

            @Override // com.tendcloud.tenddata.a
            public String getUrl() {
                return this.isUrlUpdated ? this.url : aa.f2209i;
            }

            @Override // com.tendcloud.tenddata.a
            public void setUrl(String str) {
                this.isUrlUpdated = true;
                this.url = str;
            }
        };
        UNIVERSAL = aVar2;
        service = new a[]{aVar, aVar2};
    }

    protected a(String str, int i6) {
        this.nameString = str;
        this.indexNum = i6;
        addFeatures2List(str);
    }

    protected a(String str, int i6, boolean z5) {
        this.nameString = str;
        this.indexNum = i6;
    }

    private void addFeatures2List(String str) {
        try {
            if (y.b(str) || FeaturesList.contains(str)) {
                return;
            }
            FeaturesList.add(str);
        } catch (Throwable unused) {
        }
    }

    public static ArrayList<a> getFeaturesList() {
        ArrayList<a> arrayList = new ArrayList<>();
        for (int i6 = 0; i6 < FeaturesList.size(); i6++) {
            try {
                if (valueOf(FeaturesList.get(i6)) != null) {
                    arrayList.add(valueOf(FeaturesList.get(i6)));
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public static List<String> getFeaturesNameList() {
        return FeaturesList;
    }

    public static a valueOf(String str) {
        a aVar = ENV;
        if (str.equals(aVar.name())) {
            return aVar;
        }
        a aVar2 = UNIVERSAL;
        if (str.equals(aVar2.name())) {
            return aVar2;
        }
        return null;
    }

    public static a[] values() {
        a[] aVarArr = service;
        return (a[]) Arrays.copyOf(aVarArr, aVarArr.length);
    }

    public abstract String getCert();

    public String getDataFolder() {
        return "td_database" + index() + db.f2583c;
    }

    public int getFileLimitType() {
        return 1;
    }

    public abstract String getHost();

    public abstract String getIP();

    public abstract String getMessageFormat();

    public String getRootFolder() {
        return aa.C;
    }

    public abstract String getUrl();

    public int index() {
        return this.indexNum;
    }

    public String name() {
        return this.nameString;
    }

    public boolean needToSendData() {
        return true;
    }

    public void setUrl(String str) {
    }
}
