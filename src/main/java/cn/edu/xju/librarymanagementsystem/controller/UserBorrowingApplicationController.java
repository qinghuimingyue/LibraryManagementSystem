package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.service.UserBorrowingApplicationService;
import cn.edu.xju.librarymanagementsystem.utils.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@Slf4j
public class UserBorrowingApplicationController {
    @Autowired
    UserBorrowingApplicationService userBorrowingApplicationService;
    
    @GetMapping("/borrowingApplication")
    public Result addUserBorrowingApplication(@RequestHeader String jwt, @RequestParam String bookId, @RequestParam Date estimatedReturnDate) {
        String userId = (String) JWT.parseJWT(jwt).get("userId");
        if (userBorrowingApplicationService.borrowApplication(userId, bookId, estimatedReturnDate)){
            log.info("用户：{}借书{}申请提交成功", userId, bookId);
            return Result.success("申请提交成功");
        }else {
            log.info("用户：{}借书{}申请提交失败", userId, bookId);
            return Result.fail("申请提交失败");
        }
    }
}
