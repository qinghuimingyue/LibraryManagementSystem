package cn.edu.xju.librarymanagementsystem.mapper;

import cn.edu.xju.librarymanagementsystem.pojo.BookDetail;
import cn.edu.xju.librarymanagementsystem.pojo.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface SelectBookInfoMapper {
    @Select("select book_name,publishing,author,status from librarymanagementsystem.book_info")
    public List<BookInfo> getAllBookInfo();
    
    @Select("select * from librarymanagementsystem.book_info where book_id=#{bookId}")
    public BookDetail getBookInfo(String bookId);
}