package cn.edu.xju.librarymanagementsystem.service;

import cn.edu.xju.librarymanagementsystem.mapper.UserFavoritesOptionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFavoritesOptionsService {
    @Autowired
    UserFavoritesOptionsMapper userFavoritesOptionsMapper;
    
    public boolean doCollect(String userId,String bookId) {
        return userFavoritesOptionsMapper.doCollect(userId,bookId)==1;
    }
    
    public boolean doUnCollect(String userId,String bookId) {
        return userFavoritesOptionsMapper.doUnCollect(userId,bookId)==1;
    }
}
