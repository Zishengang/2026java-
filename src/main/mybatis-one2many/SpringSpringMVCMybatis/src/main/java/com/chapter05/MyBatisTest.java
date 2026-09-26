package com.chapter05;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        //1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.构建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3.获取SqlSession
        SqlSession sqlSession = factory.openSession(true); //自动提交事务

        //获取mapper
        Chapter05EmpMapper empMapper = sqlSession.getMapper(Chapter05EmpMapper.class);
        Chapter05DeptMapper deptMapper = sqlSession.getMapper(Chapter05DeptMapper.class);

        System.out.println("====多对一 XML方式查询员工（带部门）====");
        Emp emp1 = empMapper.many2oneByXml(1001);
        System.out.println(emp1);

        System.out.println("\n====多对一 注解方式查询员工（带部门）====");
        Emp emp2 = empMapper.many2oneByAnn(1001);
        System.out.println(emp2);

        System.out.println("\n====一对多 XML方式 查询部门（带所有员工）====");
        Dept dept1 = deptMapper.one2manyByXml(10);
        System.out.println(dept1);

        System.out.println("\n====一对多 注解方式 查询部门（带所有员工）====");
        Dept dept2 = deptMapper.one2manyByAnn(10);
        System.out.println(dept2);

        System.out.println("\n====多对多 XML方式 查询员工（带技能）====");
        Emp emp3 = empMapper.many2manyByXml(1001);
        System.out.println(emp3);

        System.out.println("\n====多对多 注解方式 查询员工（带技能）====");
        Emp emp4 = empMapper.many2manyByAnn(1001);
        System.out.println(emp4);

        sqlSession.close();
    }
}