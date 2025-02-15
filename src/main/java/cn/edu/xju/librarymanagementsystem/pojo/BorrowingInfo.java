package cn.edu.xju.librarymanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowingInfo {
    private String bookName;
    private Date borrowDate;
    private Date estimatedReturnDate;
}
