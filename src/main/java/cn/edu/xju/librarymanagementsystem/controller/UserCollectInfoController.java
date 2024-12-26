package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.service.UserCollectInfoService;
import cn.edu.xju.librarymanagementsystem.utils.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserCollectInfoController {
    @Autowired
    private UserCollectInfoService userCollectInfoService;
    
    @GetMapping("/userCollectInfoByUserId")
    public Result userCollectInfoByUserId(@RequestHeader String jwt) {
        String userId = (String) JWT.parseJWT(jwt).get("userId");
        return Result.success(userCollectInfoService.selectCollectBookInfoByUserId(userId));
    }
}
