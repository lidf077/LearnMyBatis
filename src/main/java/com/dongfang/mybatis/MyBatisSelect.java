package com.dongfang.mybatis;

import com.dongfang.mybatis.bean.Employee;
import com.dongfang.mybatis.dao.SelectEmployeeMapper;
import com.dongfang.mybatis.dao.SelectParamMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MyBatisSelect {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "MyBatis/mybatis-conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testSelectList() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            SelectEmployeeMapper mapper = sqlSession.getMapper(SelectEmployeeMapper.class);
            List<Employee> employees = mapper.getEmpsByLastNameLike("Jerry");
            System.out.println("employees = " + employees);
        }
    }

    @Test
    public void testSelectMap() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            SelectEmployeeMapper mapper = sqlSession.getMapper(SelectEmployeeMapper.class);
            Map<String, Object> empMap = mapper.getEmpMapById(1);
            System.out.println("empMap = " + empMap);
        }
    }

    @Test
    public void testSelectMapSetKey() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            SelectEmployeeMapper mapper = sqlSession.getMapper(SelectEmployeeMapper.class);
            Map<Integer, Employee> empMap = mapper.getAllEmpByLastNameLike("Jerry");
            System.out.println("empMap = " + empMap);
        }
    }
}
