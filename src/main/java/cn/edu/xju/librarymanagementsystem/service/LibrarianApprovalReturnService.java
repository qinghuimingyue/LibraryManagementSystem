package cn.edu.xju.librarymanagementsystem.service;

import cn.edu.xju.librarymanagementsystem.mapper.LibrarianApprovalMapper;
import cn.edu.xju.librarymanagementsystem.mapper.LibrarianApprovalReturnMapper;
import cn.edu.xju.librarymanagementsystem.pojo.LibrarianApprovalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianApprovalReturnService {
    @Autowired
    private LibrarianApprovalReturnMapper librarianApprovalReturnMapper;
    
    public List<LibrarianApprovalInfo> selectAll() {
        return librarianApprovalReturnMapper.getLibrarianApprovalInfo();
    }
    
    public boolean pass(String userId, String bookId) {
        return (librarianApprovalReturnMapper.deleteBorrowingInfoByUserIdANDBookId(userId, bookId) == 1) && (librarianApprovalReturnMapper.updateBookStatus(bookId) == 1);
    }
    
    public boolean notPass(String userId, String bookId) {
        return librarianApprovalReturnMapper.updateBorrowingInfo(userId, bookId) == 1;
    }
}
