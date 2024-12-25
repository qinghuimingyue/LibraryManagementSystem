package cn.edu.xju.librarymanagementsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("""
            select count(*)
                    from employee_password
                    where (select employee.emp_id from employee where #{empName} = name) = emp_id
                      and #{password} = emp_password;""")
    public int checkLogin(String empName, String password);
}
