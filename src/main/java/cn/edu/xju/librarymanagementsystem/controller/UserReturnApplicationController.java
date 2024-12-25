package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.service.UserReturnApplicationService;
import cn.edu.xju.librarymanagementsystem.utils.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserReturnApplicationController {
    @Autowired
    UserReturnApplicationService userReturnApplicationService;
    
    @GetMapping("/returnApplication")
    public Result returnApplication(@RequestHeader String jwt, @RequestParam String bookId) {
        String userId = (String) JWT.parseJWT(jwt).get("userId");
        if (userReturnApplicationService.updateStatus(userId, bookId)) {
            log.info("用户："+userId+"成功申请还书"+bookId);
            return Result.success("还书申请成功");
        }else {
            log.info("用户："+userId+"未能成功申请还书"+bookId);
            return Result.fail("申请还书失败");
        }
    }
}
