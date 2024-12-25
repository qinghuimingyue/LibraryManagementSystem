package cn.edu.xju.librarymanagementsystem.service;

import cn.edu.xju.librarymanagementsystem.mapper.CreatLibrarianMapper;
import cn.edu.xju.librarymanagementsystem.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatLibrarianService {
    @Autowired
    CreatLibrarianMapper creatLibrarianMapper;
    
    public boolean insertUserInformation(UserInfo userInfo) {
        return creatLibrarianMapper.insertUserInformation(userInfo)==1;
    }
}
