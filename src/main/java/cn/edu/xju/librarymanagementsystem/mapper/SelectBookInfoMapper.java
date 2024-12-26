package cn.edu.xju.librarymanagementsystem.mapper;

import cn.edu.xju.librarymanagementsystem.pojo.BookDetail;
import cn.edu.xju.librarymanagementsystem.pojo.BookInfo;
import cn.edu.xju.librarymanagementsystem.pojo.UserBorrowingInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.List;

@Mapper
public interface SelectBookInfoMapper {
    @Select("select book_name,publishing,author,status from librarymanagementsystem.book_info")
    public List<BookInfo> getAllBookInfo();
    
    @Select("select * from librarymanagementsystem.book_info where book_id=#{bookId}")
    public BookDetail getBookInfo(String bookId);
    
    @Select("""
            SELECT
                b.book_id,
                b.borrow_date,
                b.return_date,
                bi.book_name
            FROM
                borrowing_info b
                    JOIN book_info bi ON b.book_id = #{bookId}
            WHERE
                b.status IN (1, -2);""")
    public List<UserBorrowingInfo> selectUserBorrowingInfo(String bookId);
    
    @Select("select  borrowing_info.estimated_return_date from borrowing_info where book_id=#{bookId} and status IN (1, -2)")
    public List<Date> getUserEstimated(String bookId);
}