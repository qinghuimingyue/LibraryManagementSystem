package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.service.LibrarianInfoApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/librarianInfoApproval")
public class LibrarianInfoApprovalController {
    @Autowired
    private LibrarianInfoApprovalService librarianInfoApprovalService;
    
    @GetMapping("/approvalList")
    public Result approvalList() {
        return Result.success(librarianInfoApprovalService.approveLibrarianInfo());
    }
    
    @GetMapping("/approved")
    public Result approved(@RequestParam String userId) {
        librarianInfoApprovalService.approveLibrarianInfoApproval(userId);
        return Result.success("审批通过");
    }
    
    @GetMapping("/unPass")
    public Result unPass(@RequestParam String userId) {
        librarianInfoApprovalService.unPass(userId);
        return Result.success("拒绝审批");
    }
}
