package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.service.ListOFAdministratorInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ListOFAdministratorInformationController {
    @Autowired
    private ListOFAdministratorInformationService listOFAdministratorInformationService;
    
    @GetMapping("/listLibrarian")
    public Result listLibrarian() {
        return Result.success(listOFAdministratorInformationService.selectAllEMPInfo());
    }
    
    @PostMapping("/deleteEMP")
    public Result deleteEMP(@RequestParam String userId) {
        if (listOFAdministratorInformationService.deleteAllEMPBYId(userId)) {
            log.info("删除员工{}成功", userId);
            return Result.success("删除员工" + userId + "成功");
        }else{
            log.info("删除员工{}失败", userId);
            return Result.fail("删除员工" + userId + "失败");
        }
    }
}
