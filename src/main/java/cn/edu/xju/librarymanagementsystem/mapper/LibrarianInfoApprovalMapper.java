package cn.edu.xju.librarymanagementsystem.mapper;

import cn.edu.xju.librarymanagementsystem.pojo.PendingInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LibrarianInfoApprovalMapper {
    @Select("select user_id,modify_project,user_name,gender,birthday from librarymanagementsystem.pending_librarian")
    public List<PendingInfo> queryPendingLibrarian();
    
    @Select("select * from librarymanagementsystem.pending_librarian where user_id=#{userId}")
    public PendingInfo queryPendingLibrarianById(String userId);
    
    public void updateNewLibrarianInfo(PendingInfo pendingInfo);
    
    @Delete("delete from pending_librarian where user_id=#{userId}")
    public void deletePendingLibrarian(String userId);
}

