package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.service.SelectBookInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/book")
@Slf4j
public class SelectBookInfoController {
    @Autowired
    SelectBookInfoService selectBookInfoService;
    
    @GetMapping("/allBookInfor")
    public Result bookInfor() {
        return Result.success(selectBookInfoService.getAllBookInfo());
    }
    
    @GetMapping("/bookDetail")
    public Result bookDetail(@RequestParam String bookId) {
        return Result.success(selectBookInfoService.getBookInfoByBookId(bookId));
    }
}
