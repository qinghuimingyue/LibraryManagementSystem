package cn.edu.xju.librarymanagementsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("""
            select count(*)
                    from password
                    where user_id = #{userId};""")
    public int checkLogin(String userId, String password);
}
