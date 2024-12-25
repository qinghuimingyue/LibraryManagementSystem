package cn.edu.xju.librarymanagementsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDetail {
    private String bookId;
    private String bookName;
    private String author;
    private String publishing;
    private String status;
    private String intro;
    private String douban;
    private String review;
    private Date publicationTime;
}
