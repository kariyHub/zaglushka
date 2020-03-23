package com.example.zaglushka.data;

public class DataModel {
    String reg, time1, time2, url;
    int pow, id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPow() {
        return pow;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }

    public DataModel(int id, String reg, String time1, String time2, String url, int pow) {
        this.id = id;
        this.reg = reg;
        this.time1 = time1;
        this.time2 = time2;
        this.url = url;
        this.pow = pow;
    }
}
