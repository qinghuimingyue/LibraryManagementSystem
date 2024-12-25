package cn.edu.xju.librarymanagementsystem.service;

import cn.edu.xju.librarymanagementsystem.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginMapper loginMapper;
    
    public boolean login(String username, String password) {
        return loginMapper.checkLogin(username, password) == 1;
    }
}
