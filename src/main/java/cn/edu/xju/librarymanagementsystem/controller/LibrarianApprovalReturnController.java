package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.service.LibrarianApprovalReturnService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/librarianReturn")
@Slf4j
public class LibrarianApprovalReturnController {
    @Autowired
    private LibrarianApprovalReturnService librarianApprovalReturnService;
    
    @GetMapping("/getAllInfo")
    public Result getAllInfo() {
        return Result.success(librarianApprovalReturnService.selectAll());
    }
    
    @GetMapping("/pass")
    public Result pass(@RequestParam String userId, @RequestParam String bookId) {
        if (librarianApprovalReturnService.pass(userId, bookId)) {
            log.info("用户：{}还书{}申请已通过", userId, bookId);
            return Result.success("还书通过");
        }else {
            log.info("用户：{}还书{}申请未知原因无法通过", userId, bookId);
            return Result.fail("申请未知原因未通过");
        }
    }
    
    @GetMapping("/noPass")
    public Result noPass(@RequestParam String userId, @RequestParam String bookId) {
        if (librarianApprovalReturnService.notPass(userId, bookId)) {
            log.info("已拒绝用户：{}还书{}申请", userId, bookId);
            return Result.success("已拒绝");
        }else {
            log.info("未知原因无法拒绝用户：{}还书{}申请", userId, bookId);
            return Result.fail("未知原因无法拒绝");
        }
    }
}
