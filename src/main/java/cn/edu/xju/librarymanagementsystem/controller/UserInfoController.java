package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.pojo.UserInfo;
import cn.edu.xju.librarymanagementsystem.service.UserInfoService;
import cn.edu.xju.librarymanagementsystem.utils.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    
    @GetMapping("/userInfo")
    public Result getUserInfo(@RequestHeader String jwt) {
        String userId = (String) JWT.parseJWT(jwt).get("userId");
        return Result.success(userInfoService.getUserInfoByUserId(userId));
    }
    
    @PostMapping("/updateUserInfo")
    public Result updateUserInfo(@RequestBody UserInfo userInfo) {
        if (userInfoService.updateUserInfo(userInfo)) {
            log.info("用户{}个人信息更新成功", userInfo.getUserId());
            return Result.success("用户"+userInfo.getUserId()+"个人信息更新成功");
        }else {
            log.info("用户{}个人信息更新失败", userInfo.getUserId());
            return Result.fail("用户"+userInfo.getUserId()+"个人信息更新失败");
        }
    }
}
