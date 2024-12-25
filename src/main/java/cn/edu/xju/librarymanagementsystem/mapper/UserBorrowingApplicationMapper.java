package cn.edu.xju.librarymanagementsystem.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;


@Mapper
public interface UserBorrowingApplicationMapper {
    @Insert("insert borrowing_info set book_id=#{bookId},user_id=#{userId},borrow_date=current_time,estimated_return_date=#{estimatedReturnDate},status=0")
    public int addUserBorrowingApplication(String userId, String bookId, Date estimatedReturnDate);
}
