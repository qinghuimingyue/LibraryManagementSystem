package cn.edu.xju.librarymanagementsystem.controller;

import cn.edu.xju.librarymanagementsystem.pojo.Result;
import cn.edu.xju.librarymanagementsystem.service.UserFavoritesOptionsService;
import cn.edu.xju.librarymanagementsystem.utils.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/collect")
public class UserFavoritesOptionsController {
    @Autowired
    UserFavoritesOptionsService userFavoritesOptionsService;
    
    @GetMapping("/do")
    public Result userFavoritesOptions(@RequestHeader String jwt, @RequestParam String bookId) {
        String userId = (String) JWT.parseJWT(jwt).get("userId");
        if (userFavoritesOptionsService.doCollect(bookId, userId)){
            log.info("用户：{}收藏{}成功", userId, bookId);
            return Result.success("收藏成功");
        }else {
            log.info("用户：{}收藏{}失败", userId, bookId);
            return Result.fail("收藏失败");
        }
    }
    
    @GetMapping("/undo")
    public Result userUnDoFavoritesOptions(@RequestHeader String jwt, @RequestParam String bookId){
        String userId = (String) JWT.parseJWT(jwt).get("userId");
        if (userFavoritesOptionsService.doUnCollect(bookId, userId)){
            log.info("用户：{}取消收藏{}成功", userId, bookId);
            return Result.success("取消收藏成功");
        }else {
            log.info("用户：{}取消收藏{}失败", userId, bookId);
            return Result.fail("取消收藏失败");
        }
    }
}
