package cn.edu.xju.librarymanagementsystem.service;

import cn.edu.xju.librarymanagementsystem.mapper.UserReturnApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserReturnApplicationService {
    @Autowired
    UserReturnApplicationMapper userReturnApplicationMapper;
    
    public boolean updateStatus(String userId, String bookId) {
        return userReturnApplicationMapper.updateStatus(userId, bookId) == 1;
    }
}
