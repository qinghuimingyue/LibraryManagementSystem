package cn.edu.xju.librarymanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfoANDBorrowingInfo {
    private String userId;
    private String userName;
    private String gender;
    private List<BorrowingInfo> borrowingInfoList;
}
