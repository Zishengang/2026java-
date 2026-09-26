package com.chapter05;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestOne2Many {
    public static void main(String[] args) throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession(true);

        Dept2Mapper mapper = session.getMapper(Dept2Mapper.class);
        Dept2 dept2 = mapper.findDeptById(1);

        System.out.println("部门id："+dept2.getDid());
        System.out.println("部门名称："+dept2.getDname());
        System.out.println("部门员工："+dept2.getEmpList());

        session.close();
    }
}