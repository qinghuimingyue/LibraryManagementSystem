package cn.edu.xju.librarymanagementsystem.mapper;

import cn.edu.xju.librarymanagementsystem.pojo.EMPInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LibrarianSelfInfoMapper {
    @Select("select user_information.user_id,user_information.user_name,user_information.gender,user_information.birthday,user_information.enrollment_date from user_information where user_id=#{userId} and type='图书管理员'")
    public EMPInfo selectUserInfoByUserId(String userId);
}
