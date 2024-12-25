package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.service.LibrarianInfoApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/librarianInfoApproval")
public class LibrarianInfoApprovalController {
    @Autowired
    LibrarianInfoApprovalService librarianInfoApprovalService;
    
    @GetMapping("/approvalList")
    public Result approvalList() {
        return Result.success(librarianInfoApprovalService.approveLibrarianInfo());
    }
    
    @GetMapping("/approved")
    public Result approved() {
    
    }
}
