package cn.edu.xju.librarymanagementsystem.service;

import cn.edu.xju.librarymanagementsystem.mapper.UserInfoMapper;
import cn.edu.xju.librarymanagementsystem.pojo.UserInfoANDBorrowingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    
    public UserInfoANDBorrowingInfo getUserInfoByUserId(String userId) {
        UserInfoANDBorrowingInfo userInfoANDBorrowingInfo = new UserInfoANDBorrowingInfo();
        userInfoANDBorrowingInfo.setBorrowingInfoList(userInfoMapper.getUserInfoList(userId));
        userInfoANDBorrowingInfo.setUserName(userInfoMapper.getUserInfo(userId).getUserName());
        userInfoANDBorrowingInfo.setGender(userInfoMapper.getUserInfo(userId).getGender());
        userInfoANDBorrowingInfo.setUserId(userId);
        return userInfoANDBorrowingInfo;
    }
}
