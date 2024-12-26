package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.service.SelectBookInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/book")
public class SelectBookInfoController {
    @Autowired
    private SelectBookInfoService selectBookInfoService;
    
    @GetMapping("/allBookInfor")
    public Result bookInfor() {
        return Result.success(selectBookInfoService.getAllBookInfo());
    }
    
    @GetMapping("/bookDetail")
    public Result bookDetail(@RequestParam String bookId) {
        return Result.success(selectBookInfoService.getBookInfoByBookId(bookId));
    }
    
    @GetMapping("/userBorrowingInfo")
    public Result userBorrowingInfo(@RequestParam String bookId) {
        return Result.success(selectBookInfoService.getAllUserBorrowingInfo(bookId));
    }
}
