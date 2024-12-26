package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.service.LibrarianSelfInfoService;
import cn.edu.xju.librarymanagementsystem.utils.JWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibrarianSelfInfoController {
    @Autowired
    private LibrarianSelfInfoService librarianSelfInfoService;
    
    @GetMapping("/selfInfo")
    public Result selfInfo(@RequestHeader String jwt) {
        String userId = (String) JWT.parseJWT(jwt).get("userId");
        return Result.success(librarianSelfInfoService.selectByUserId(userId));
    }
}
