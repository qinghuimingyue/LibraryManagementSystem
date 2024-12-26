package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.service.LibrarianApprovalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/librarianApproval")
public class LibrarianApprovalController {
    @Autowired
    private LibrarianApprovalService librarianApprovalService;
    
    @GetMapping("/allInfo")
    public Result allInfo() {
        log.info("查询所有未审批借阅信息");
        return Result.success(librarianApprovalService.selectAll());
    }
    
    @GetMapping("/pass")
    public Result pass(@RequestParam String userId, @RequestParam String bookId) {
        if (librarianApprovalService.pass(userId, bookId)) {
            log.info("用户：{}申请借阅{}已通过", userId, bookId);
            return Result.success("审批通过");
        }else {
            log.info("用户：{}申请借阅{}未知原因未通过", userId, bookId);
            return Result.fail("未知原因未通过");
        }
    }
    
    @GetMapping("noPass")
    public Result noPass(@RequestParam String userId, @RequestParam String bookId) {
        if (librarianApprovalService.notPass(userId, bookId)) {
            log.info("拒绝用户：{}申请借阅{}已通过", userId, bookId);
            return Result.success("已拒绝");
        }else {
            log.info("拒绝用户：{}申请借阅{}未知原因未通过", userId, bookId);
            return Result.fail("未知原因未成功拒绝");
        }
    }
}
