package cn.edu.xju.librarymanagementsystem.mapper;

import cn.edu.xju.librarymanagementsystem.pojo.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CreatLibrarianMapper {
    @Insert("INSERT librarymanagementsystem.user_information set librarymanagementsystem.user_information.user_id=#{userId},librarymanagementsystem.user_information.user_name=#{userName},librarymanagementsystem.user_information.gender=#{gender},birthday=#{birthday}")
    public int insertUserInformation(UserInfo user);
}
