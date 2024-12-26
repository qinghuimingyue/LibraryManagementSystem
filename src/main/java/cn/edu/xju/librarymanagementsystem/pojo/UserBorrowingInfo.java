package cn.edu.xju.librarymanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserBorrowingInfo {
    private String userId;
    private String userName;
    private Date borrowDate;
    private Date returnDate;
    private int status;//0为逾期，1为在期
}