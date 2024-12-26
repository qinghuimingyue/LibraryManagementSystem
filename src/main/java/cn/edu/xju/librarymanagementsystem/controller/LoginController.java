package cn.edu.xju.librarymanagementsystem.controller;

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
    
    @PostMapping("/Login")
    public Result Login(@RequestBody String userId, @RequestBody String password, @RequestBody String userType) {
        if (loginService.login(userId, password)) {
            log.info("用户:{} 登入", userId);
            Map<String, Object> claims = new HashMap<>();
            claims.put("userId", userId);
            claims.put("userType", userType);
            return Result.success(JWT.getJWT(claims), userType);
        } else return Result.fail("密码或用户名不正确！");
    }
}
