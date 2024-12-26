package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.LoginInfo;
import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.service.LoginService;
import cn.edu.xju.librarymanagementsystem.utils.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class LoginController {
    
    @Autowired
    private LoginService loginService;
    
    @PostMapping("/login")
    public Result Login(@RequestBody LoginInfo loginInfo) {
        if (loginService.login(loginInfo.getUserId(), loginInfo.getPassword())) {
            log.info("用户:{} 登入", loginInfo.getUserId());
            Map<String, Object> claims = new HashMap<>();
            claims.put("userId", loginInfo.getUserId());
            claims.put("userType", loginInfo.getType());
            return Result.success(JWT.getJWT(claims), loginInfo.getType());
        } else return Result.fail("密码或用户名不正确！");
    }
}
