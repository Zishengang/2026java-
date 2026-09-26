package com.chapter05;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface Chapter05DeptMapper {
    //给@One引用，根据部门编号查部门
    @Select("select deptno,dname,loc from dept where deptno=#{deptno}")
    @Results({
            @Result(property="deptno",column="deptno",id=true),
            @Result(property="dname",column="dname"),
            @Result(property="loc",column="loc")
    })
    Dept findById(Integer deptno);

    //一对多 XML 嵌套结果
    Dept one2manyByXml(Integer deptno);

    //一对多注解 @Many
    @Select("select deptno,dname,loc from dept where deptno=#{deptno}")
    @Results({
            @Result(property="deptno",column="deptno",id=true),
            @Result(property="dname",column="dname"),
            @Result(property="loc",column="loc"),
            @Result(property="emps",column="deptno",
                    many=@Many(select="com.chapter05.Chapter05EmpMapper.selectListByDeptno"))
    })
    Dept one2manyByAnn(Integer deptno);
}