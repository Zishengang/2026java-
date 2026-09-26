package com.chapter05;

public class Emp2 {
    private Integer eid;
    private String ename;
    private Integer did;

    public Emp2() {
    }

    public Emp2(Integer eid, String ename, Integer did) {
        this.eid = eid;
        this.ename = ename;
        this.did = did;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Emp2{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", did=" + did +
                '}';
    }
}