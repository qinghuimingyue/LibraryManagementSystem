package cn.edu.xju.librarymanagementsystem.mapper;

import cn.edu.xju.librarymanagementsystem.pojo.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserCollectInfoMapper {
    @Select("select book_info.book_id, book_info.book_name,book_info.publishing,book_info.author from book_info where book_id=(select book_id from collect_info where user_id=#{userId})")
    public List<BookInfo> getCollectBookInfoByUserId(String userId);
}
