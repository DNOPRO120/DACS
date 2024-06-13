package org.example.OOP;


public class Manager {
    private String mid;
    private String mname;
    private String pnumber;

    public Manager() {

    }

    public Manager(String mid, String mname, String pnumber) {
        this.mid=mid;
        this.mname=mname;
        this.pnumber=pnumber;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

}

