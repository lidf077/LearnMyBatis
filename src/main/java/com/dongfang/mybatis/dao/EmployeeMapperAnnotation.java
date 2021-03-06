package com.dongfang.mybatis.dao;

import com.dongfang.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperAnnotation {

    @Select("select id, last_name lastName, gender, email from t_employee where id = #{id}")
    Employee getEmpById(Integer id);
}
