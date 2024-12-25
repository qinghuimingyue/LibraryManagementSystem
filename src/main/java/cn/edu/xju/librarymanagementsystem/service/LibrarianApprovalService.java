package cn.edu.xju.librarymanagementsystem.service;

import cn.edu.xju.librarymanagementsystem.mapper.LibrarianApprovalMapper;
import cn.edu.xju.librarymanagementsystem.pojo.LibrarianApprovalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianApprovalService {
    @Autowired
    LibrarianApprovalMapper librarianApprovalMapper;
    
    public List<LibrarianApprovalInfo> selectAll() {
        return librarianApprovalMapper.getLibrarianApprovalInfo();
    }
}
