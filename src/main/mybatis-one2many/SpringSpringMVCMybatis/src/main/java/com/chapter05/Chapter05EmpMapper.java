package com.chapter05;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface Chapter05EmpMapper {
    //一对一 XML嵌套结果
    Emp one2oneByXml(Integer empno);

    //一对一 注解@One 嵌套select
    @Select("select empno,ename,job,deptno from emp where empno=#{empno}")
    @Results({
            @Result(property="empno",column="empno",id=true),
            @Result(property="ename",column="ename"),
            @Result(property="job",column="job"),
            @Result(property="deptno",column="deptno"),
            @Result(property="dept", column="deptno",
                    one=@One(select="com.chapter05.Chapter05DeptMapper.findById"))
    })
    Emp one2oneByAnn(Integer empno);

    //多对一 XML
    Emp many2oneByXml(Integer empno);

    //多对一 注解
    @Select("select empno,ename,job,deptno from emp where empno=#{empno}")
    @Results({
            @Result(property="empno",column="empno",id=true),
            @Result(property="ename",column="ename"),
            @Result(property="job",column="job"),
            @Result(property="deptno",column="deptno"),
            @Result(property="dept", column="deptno",
                    one=@One(select="com.chapter05.Chapter05DeptMapper.findById"))
    })
    Emp many2oneByAnn(Integer empno);

    //多对多 XML
    Emp many2manyByXml(Integer empno);

    //多对多注解 @Many
    @Select("select empno,ename,job,deptno from emp where empno=#{empno}")
    @Results({
            @Result(property="empno",column="empno",id=true),
            @Result(property="ename",column="ename"),
            @Result(property="job",column="job"),
            @Result(property="deptno",column="deptno"),
            @Result(property="skills", column="empno",
                    many=@Many(select="com.chapter05.Chapter05EmpMapper.selectSkillsByEmpno"))
    })
    Emp many2manyByAnn(Integer empno);

    //多对多子查询：根据员工编号查技能
    @Select("select s.skill_id skillId, s.skill_name skillName from skill s " +
            "join emp_skill es on s.skill_id = es.skill_id where es.empno=#{empno}")
    List<Skill> selectSkillsByEmpno(Integer empno);

    //一对多子查询，Dept注解版本调用
    @Select("select empno,ename,job,deptno from emp where deptno=#{deptno}")
    List<Emp> selectListByDeptno(Integer deptno);
}