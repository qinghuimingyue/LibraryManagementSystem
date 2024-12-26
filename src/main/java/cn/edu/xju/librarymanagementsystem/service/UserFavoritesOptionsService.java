package cn.edu.xju.librarymanagementsystem.service;

import cn.edu.xju.librarymanagementsystem.mapper.UserFavoritesOptionsMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserFavoritesOptionsService {
    @Autowired
    private UserFavoritesOptionsMapper userFavoritesOptionsMapper;
    
    public boolean doCollect(String userId,String bookId) {
        return userFavoritesOptionsMapper.doCollect(userId,bookId)==1;
    }
    
    public boolean doUnCollect(String userId,String bookId) {
        return userFavoritesOptionsMapper.doUnCollect(userId,bookId)==1;
    }
}
