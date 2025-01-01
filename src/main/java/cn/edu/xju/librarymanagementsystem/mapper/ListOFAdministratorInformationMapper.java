package cn.edu.xju.librarymanagementsystem.mapper;

import cn.edu.xju.librarymanagementsystem.pojo.EMPInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ListOFAdministratorInformationMapper {
    @Select("select user_information.user_id,user_information.user_name,user_information.gender,user_information.enrollment_date from user_information where type='图书管理员'")
    public List<EMPInfo> selectAllEMPInfo();
    
    @Delete("delete from user_information where user_id=#{userId} and type='图书管理员'")
    public int deleteUserInformation(String userId);
}
