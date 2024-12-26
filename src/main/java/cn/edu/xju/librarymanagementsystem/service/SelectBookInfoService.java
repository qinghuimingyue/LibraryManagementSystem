package cn.edu.xju.librarymanagementsystem.service;

import cn.edu.xju.librarymanagementsystem.mapper.SelectBookInfoMapper;
import cn.edu.xju.librarymanagementsystem.pojo.BookDetail;
import cn.edu.xju.librarymanagementsystem.pojo.BookInfo;
import cn.edu.xju.librarymanagementsystem.pojo.UserBorrowingInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Slf4j
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
    
    public List<UserBorrowingInfo> getAllUserBorrowingInfo(String bookId) {
        List<UserBorrowingInfo> info = selectBookInfoMapper.selectUserBorrowingInfo(bookId);
        List<Date> dates = selectBookInfoMapper.getUserEstimated(bookId);
        for (int i = 0; i < info.size(); i++) {
            if (dates.get(i).toLocalDate().isBefore(LocalDate.now())){
                info.get(i).setStatus(0);
            }else info.get(i).setStatus(1);
        }
        return info;
    }
}
