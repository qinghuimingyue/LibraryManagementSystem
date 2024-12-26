package cn.edu.xju.librarymanagementsystem.mapper;

import cn.edu.xju.librarymanagementsystem.pojo.LibrarianApprovalInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface LibrarianApprovalMapper {
    @Select("select borrowing_info.user_id,borrowing_info.book_id,borrowing_info.borrow_date,borrowing_info.estimated_return_date from borrowing_info where status=0")
    public List<LibrarianApprovalInfo> getLibrarianApprovalInfo();
    
    //审批通过更新状态字
    @Update("update borrowing_info set status=1 where user_id=#{userId} and book_id=#{bookId}")
    public int updateBorrowingStatusByUserIdANDBookId(String userId,String bookId);
    
    //审批通过更新书籍状态字
    @Update("update book_info set status='借出' where book_id=#{bookId}")
    public int updateBookInfoStatusByBookId(String bookId);
    
    //拒绝审批删除申请信息
    @Delete("delete from borrowing_info where user_id=#{userId} and book_id=#{bookId}")
    public int deleteBorrowingInfoByUserIdANDBookId(String userId,String bookId);
    
}
