package cn.edu.xju.librarymanagementsystem.service;

import cn.edu.xju.librarymanagementsystem.mapper.SelectBookInfoMapper;
import cn.edu.xju.librarymanagementsystem.pojo.BookDetail;
import cn.edu.xju.librarymanagementsystem.pojo.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectBookInfoService {
    @Autowired
    SelectBookInfoMapper selectBookInfoMapper;
    
    public List<BookInfo> getAllBookInfo() {
        return selectBookInfoMapper.getAllBookInfo();
    }
    
    public BookDetail getBookInfoByBookId(String bookId) {
        return selectBookInfoMapper.getBookInfo(bookId);
    }
}
