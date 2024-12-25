package cn.edu.xju.librarymanagementsystem.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserReturnApplicationMapper {
    
    @Update("update borrowing_info set status=-1 where user_id=#{userId} and book_id=#{bookId} and status=1")
    public int updateStatus(String userId, String bookId);
}
