package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.service.LibrarianApprovalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
