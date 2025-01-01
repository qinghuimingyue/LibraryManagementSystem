package cn.edu.xju.librarymanagementsystem.service;

import cn.edu.xju.librarymanagementsystem.mapper.ListOFAdministratorInformationMapper;
import cn.edu.xju.librarymanagementsystem.pojo.EMPInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListOFAdministratorInformationService {
    @Autowired
    private ListOFAdministratorInformationMapper listOFAdministratorInformationMapper;
    
    public List<EMPInfo> selectAllEMPInfo() {
        return listOFAdministratorInformationMapper.selectAllEMPInfo();
    }
    
    public boolean deleteAllEMPBYId(String userId) {
        return listOFAdministratorInformationMapper.deleteUserInformation(userId) == 1;
    }
}
