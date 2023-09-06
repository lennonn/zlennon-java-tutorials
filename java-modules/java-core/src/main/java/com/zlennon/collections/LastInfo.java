package com.zlennon.collections;

public class LastInfo {
    private String id;
    private String  snrDof;
    private String  snrSse;
    private String  avgDof;
    private String  avgSse;
    private String type;

    public String getSnrDof() {
        return snrDof;
    }

    public void setSnrDof(String snrDof) {
        this.snrDof = snrDof;
    }

    public String getSnrSse() {
        return snrSse;
    }

    public void setSnrSse(String snrSse) {
        this.snrSse = snrSse;
    }

    public String getAvgDof() {
        return avgDof;
    }

    public void setAvgDof(String avgDof) {
        this.avgDof = avgDof;
    }

    public String getAvgSse() {
        return avgSse;
    }

    public void setAvgSse(String avgSse) {
        this.avgSse = avgSse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
