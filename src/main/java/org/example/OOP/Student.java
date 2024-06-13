package org.example.OOP;


public class Student {
    private String sid;
    private String sname;
    private int sex;
    private int dob;
    private String phonenumber;
    private String rid;

    public Student() {

    }

    public Student(String sid, String sname, int sex, int dob, String phonenumber, String rid) {
        this.sid=sid;
        this.sname=sname;
        this.sex=sex;
        this.dob=dob;
        this.phonenumber=phonenumber;
        this.rid=rid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

}
