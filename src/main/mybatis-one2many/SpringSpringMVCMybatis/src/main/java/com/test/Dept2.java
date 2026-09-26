package com.chapter05;
import java.util.List;

public class Dept2 {
    private Integer did;
    private String dname;
    private List<Emp2> empList;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Emp2> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp2> empList) {
        this.empList = empList;
    }
}