package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.service.UserInfoService;
import cn.edu.xju.librarymanagementsystem.utils.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("userInfo")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    
    @GetMapping("/userInfo")
    public Result getUserInfo(@RequestHeader String jwt) {
        String userId = (String) JWT.parseJWT(jwt).get("userId");
        return Result.success(userInfoService.getUserInfoByUserId(userId));
    }
}
