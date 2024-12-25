package cn.edu.xju.librarymanagementsystem.service;

import cn.edu.xju.librarymanagementsystem.mapper.UserBorrowingApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties;
import org.springframework.stereotype.Service;

import java.sql.Date;


@Service
public class UserBorrowingApplicationService {
    @Autowired
    UserBorrowingApplicationMapper userBorrowingApplicationMapper;
    
    public boolean borrowApplication(String userId, String bookId, Date estimatedReturnDate) {
        return userBorrowingApplicationMapper.addUserBorrowingApplication(userId,bookId,estimatedReturnDate)==1;
    }
}
