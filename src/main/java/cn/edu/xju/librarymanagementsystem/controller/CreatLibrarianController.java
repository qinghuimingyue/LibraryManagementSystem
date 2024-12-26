package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.pojo.UserInfo;
import cn.edu.xju.librarymanagementsystem.service.CreatLibrarianService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CreatLibrarianController {
    @Autowired
    private CreatLibrarianService creatLibrarianService;
    
    @PostMapping("/creatLibrarian")
    public Result creatLibrarian(@RequestBody UserInfo userInfo) {
        if (creatLibrarianService.insertUserInformation(userInfo)) {
            return Result.success("创建成功");
        }else return Result.fail("创建失败");
    }
}
