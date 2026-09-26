package com.chapter05;
import java.util.List;

public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private Integer deptno;
    //一对一/多对一：员工所属部门
    private Dept dept;
    //多对多：员工掌握的技能
    private List<Skill> skills;

    public Integer getEmpno() { return empno; }
    public void setEmpno(Integer empno) { this.empno = empno; }
    public String getEname() { return ename; }
    public void setEname(String ename) { this.ename = ename; }
    public String getJob() { return job; }
    public void setJob(String job) { this.job = job; }
    public Integer getDeptno() { return deptno; }
    public void setDeptno(Integer deptno) { this.deptno = deptno; }
    public Dept getDept() { return dept; }
    public void setDept(Dept dept) { this.dept = dept; }
    public List<Skill> getSkills() { return skills; }
    public void setSkills(List<Skill> skills) { this.skills = skills; }
    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", deptno=" + deptno +
                ", dept=" + dept +
                ", skills=" + skills +
                '}';
    }
}