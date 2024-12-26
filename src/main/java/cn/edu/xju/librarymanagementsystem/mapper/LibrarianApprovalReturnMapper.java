package cn.edu.xju.librarymanagementsystem.mapper;

import cn.edu.xju.librarymanagementsystem.pojo.LibrarianApprovalInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface LibrarianApprovalReturnMapper {
    @Select("select borrowing_info.user_id,borrowing_info.book_id,borrowing_info.borrow_date,borrowing_info.estimated_return_date from borrowing_info where status=-1")
    public List<LibrarianApprovalInfo> getLibrarianApprovalInfo();
    
    //删除借阅信息
    @Delete("delete from borrowing_info where user_id=#{userId} and book_id=#{bookId} and status=-1")
    public int deleteBorrowingInfoByUserIdANDBookId(String userId, String bookId);
    
    //修改书籍状态字
    @Update("update book_info set status='在馆' where book_id=#{bookId}")
    public int updateBookStatus(String bookId);
    
    //拒绝还书请求
    @Update("update borrowing_info set status=1 where user_id=#{userId} and book_id=#{bookId}")
    public int updateBorrowingInfo(String userId, String bookId);
}
