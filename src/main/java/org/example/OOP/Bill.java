package org.example.OOP;


public class Bill {
    private String bid;
    private String sid;
    private double total;
    private String mid;

    public Bill() {

    }

    public Bill(String bid, String sid, double total, String mid) {
        this.bid=bid;
        this.sid=sid;
        this.total=total;
        this.mid=mid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}

