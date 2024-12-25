package cn.edu.xju.librarymanagementsystem.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserFavoritesOptionsMapper {
    @Insert("insert collect_info set user_id=#{userId},book_id=#{userId},creat_time=current_time")
    public int doCollect(String userId, String bookId);
    
    @Delete("delete from collect_info where user_id=#{userId} and book_id=#{bookId}")
    public int doUnCollect(String userId, String bookId);
}
