package cn.edu.xju.librarymanagementsystem.mapper;

import cn.edu.xju.librarymanagementsystem.pojo.BorrowingInfo;
import cn.edu.xju.librarymanagementsystem.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    @Select("select user_information.user_name,user_information.user_id,user_information.gender from user_information where user_id=#{userId}")
    public UserInfo getUserInfo(String userId);
    
    @Select("""
            SELECT bi.borrow_date, bi.estimated_return_date, bi.return_date, b.book_name
            FROM borrowing_info bi
                     JOIN book_info b ON bi.book_id = b.book_id
            WHERE bi.user_id = #{userId} and b.status=1;""")
    public List<BorrowingInfo> getUserInfoList(String userId);
}
