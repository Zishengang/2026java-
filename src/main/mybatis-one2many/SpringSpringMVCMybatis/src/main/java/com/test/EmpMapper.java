package com.test;

public interface EmpMapper {
    Emp findEmpById(Integer empno);
    Emp findEmpWithSkill(Integer empno);
}