package cn.edu.xju.librarymanagementsystem.service;

import cn.edu.xju.librarymanagementsystem.mapper.UserCollectInfoMapper;
import cn.edu.xju.librarymanagementsystem.pojo.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCollectInfoService {
    @Autowired
    private UserCollectInfoMapper userCollectInfoMapper;
    
    public List<BookInfo> selectCollectBookInfoByUserId(String userId) {
        return userCollectInfoMapper.getCollectBookInfoByUserId(userId);
    }
}
