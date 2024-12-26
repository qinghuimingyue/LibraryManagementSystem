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
            SELECT
                b.borrow_date,
                b.estimated_return_date,
                b.return_date,
                bi.book_name
            FROM
                borrowing_info b
                    JOIN
                book_info bi ON b.book_id = bi.book_id
            WHERE
                b.user_id = #{userId}
              AND b.status = 1;""")
    public List<BorrowingInfo> getUserInfoList(String userId);
}
