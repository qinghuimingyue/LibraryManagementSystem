package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("userInfo")
public class UserInfoController {
    
    @GetMapping("/userInfo")
    public Result getUserInfo() {
    
    }
    
    @GetMapping("/borrowingBooksInfo")
    public Result getBorrowingBooksInfo() {}
}
