package cn.edu.xju.librarymanagementsystem.service;

import cn.edu.xju.librarymanagementsystem.mapper.LibrarianInfoApprovalMapper;
import cn.edu.xju.librarymanagementsystem.pojo.PendingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianInfoApprovalService {
    @Autowired
    LibrarianInfoApprovalMapper librarianInfoApprovalMapper;
    
    public List<PendingInfo> approveLibrarianInfo() {
        return librarianInfoApprovalMapper.queryPendingLibrarian();
    }
    
    public boolean approveLibrarianInfoApproval(String userId) {
        librarianInfoApprovalMapper.updateNewLibrarianInfo(librarianInfoApprovalMapper.queryPendingLibrarianById(userId));
        librarianInfoApprovalMapper.deletePendingLibrarian(userId);
        return true;
    }
    
    public boolean unPass(String userId) {
        librarianInfoApprovalMapper.deletePendingLibrarian(userId);
    }
}
