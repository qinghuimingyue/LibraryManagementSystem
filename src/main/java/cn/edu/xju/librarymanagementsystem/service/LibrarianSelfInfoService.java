package cn.edu.xju.librarymanagementsystem.service;

import cn.edu.xju.librarymanagementsystem.mapper.LibrarianSelfInfoMapper;
import cn.edu.xju.librarymanagementsystem.pojo.EMPInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrarianSelfInfoService {
    @Autowired
    private LibrarianSelfInfoMapper librarianSelfInfoMapper;
    
    public EMPInfo selectByUserId(String userId) {
        return librarianSelfInfoMapper.selectUserInfoByUserId(userId);
    }
}
