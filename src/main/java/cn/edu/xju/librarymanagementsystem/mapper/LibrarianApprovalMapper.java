package cn.edu.xju.librarymanagementsystem.mapper;

import cn.edu.xju.librarymanagementsystem.pojo.LibrarianApprovalInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LibrarianApprovalMapper {
    @Select("select borrowing_info.user_id,borrowing_info.book_id,borrowing_info.borrow_date,borrowing_info.estimated_return_date from borrowing_info where status=0")
    public List<LibrarianApprovalInfo> getLibrarianApprovalInfo();
}
