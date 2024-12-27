# Java小学期——图书管理系统接口文档

## 一、用户界面

### 1、用户登录

#### Ⅰ 接口概述

1. **接口名称**：用户登录接口
2. **接口地址**：/login
3. **请求方式**：POST

#### Ⅱ 请求参数

| 参数名   | 必选 | 类型   | 描述                                         |
| -------- | ---- | ------ | -------------------------------------------- |
| userId   | 是   | string | 用户唯一标识                                 |
| password | 是   | string | 用户密码                                     |
| type     | 是   | string | 用户身份（超级管理员、图书管理员和普通用户） |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "登录成功",
    "data": null,
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyVHlwZSI6IuWbvuS5pueuoeeQhuWRmCIsImV4cCI6MTczNTI4MDg4NiwidXNlcklkIjoiMzMzMzMzMzMzMzQifQ.RLjYeaH8giewmQFsVjrjHjTLteW2AS-9yOblkYpP2wA",
    "role": "图书管理员"
}
```

```json
{
    "code": 500,
    "message": "密码或用户名不正确！",
    "data": null,
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 2、用户信息

#### Ⅰ 接口概述

1. **接口名称**：用户信息接口
2. **接口地址**：/userInfo
3. **请求方式**：GET

#### Ⅱ 请求参数

无

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": {
        "userId": "33333333333",
        "userName": "王五",
        "gender": "男",
        "borrowingInfoList": [
            {
                "bookName": "《百年孤独》",
                "borrowDate": "2024-12-27",
                "estimatedReturnDate": "2024-12-01"
            }
        ]
    },
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 3、用户收藏书籍

#### Ⅰ 接口概述

1. **接口名称**：用户收藏书籍接口
2. **接口地址**：/collect/do
3. **请求方式**：GET

#### Ⅱ 请求参数

| 参数名 | 必选 | 类型   | 描述                   |
| ------ | ---- | ------ | ---------------------- |
| bookId | 是   | string | 用户收藏的书籍唯一标识 |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": "收藏成功",
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 4、用户取消收藏书籍

#### Ⅰ 接口概述

1. **接口名称**：用户取消收藏书籍接口
2. **接口地址**：/collect/undo
3. **请求方式**：GET

#### Ⅱ 请求参数

| 参数名 | 必选 | 类型   | 描述                   |
| ------ | ---- | ------ | ---------------------- |
| bookId | 是   | string | 用户收藏的书籍唯一标识 |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": "取消收藏成功",
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 5、用户所有收藏信息

#### Ⅰ 接口概述

1. **接口名称**：用户所有收藏信息
2. **接口地址**：/userCollectInfoByUserId
3. **请求方式**：GET

#### Ⅱ 请求参数

无

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": [
        {
            "bookName": "《平凡的世界》",
            "author": "路遥",
            "publishing": "北京十月文艺出版社",
            "status": null
        }
    ],
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 6、用户提交借出书籍申请

#### Ⅰ 接口概述

1. **接口名称**：用户提交借出书籍申请接口
2. **接口地址**：/borrowingApplication
3. **请求方式**：GET

#### Ⅱ 请求参数

| 参数名              | 必选 | 类型   | 描述         |
| ------------------- | ---- | ------ | ------------ |
| bookId              | 是   | string | 书籍唯一标识 |
| estimatedReturnDate | 是   | Date   | 预计还书时间 |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": "申请提交成功",
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 7、用户提交归还书籍申请

#### Ⅰ 接口概述

1. **接口名称**：用户提交归还书籍申请接口
2. **接口地址**：/returnApplication
3. **请求方式**：GET

#### Ⅱ 请求参数

| 参数名 | 必选 | 类型   | 描述         |
| ------ | ---- | ------ | ------------ |
| bookId | 是   | string | 书籍唯一标识 |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": "还书申请成功",
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 8、书籍概览查询

#### Ⅰ 接口概述

1. **接口名称**：书籍概览查询接口
2. **接口地址**：/book/allBookInfor
3. **请求方式**：GET

#### Ⅱ 请求参数

无

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": [
        {
            "bookName": "《平凡的世界》",
            "author": "路遥",
            "publishing": "北京十月文艺出版社",
            "status": "在馆"
        },
        {
            "bookName": "《活着》",
            "author": "余华",
            "publishing": "上海文艺出版社",
            "status": "在馆"
        },
        {
            "bookName": "《百年孤独》",
            "author": "加西亚·马尔克斯",
            "publishing": "南海出版公司",
            "status": "借出"
        },
        {
            "bookName": "《你梁哥帅不帅》",
            "author": "王嘉梁",
            "publishing": "422男宿出版社",
            "status": "在馆"
        }
    ],
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 9、书籍详情页查询

#### Ⅰ 接口概述

1. **接口名称**：书籍详情页查询接口
2. **接口地址**：/book/bookDetail
3. **请求方式**：GET

#### Ⅱ 请求参数

| 参数名 | 必选 | 类型   | 描述         |
| ------ | ---- | ------ | ------------ |
| bookId | 是   | string | 书籍唯一标识 |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": {
        "bookId": "00000000004",
        "bookName": "《你梁哥帅不帅》",
        "author": "王嘉梁",
        "publishing": "422男宿出版社",
        "status": "在馆",
        "intro": "作者将自己帅气的容貌写进Java小学期作业中，企图蒙混过关让自己的帅脸名垂青史",
        "douban": "9",
        "review": null,
        "publicationTime": "2024-12-27"
    },
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

## 二、图书管理员界面

### 1、查询所有借出书籍申请

#### Ⅰ 接口概述

1. **接口名称**：书查询所有借出书籍申请接口
2. **接口地址**：/librarianApproval/allInfo
3. **请求方式**：GET

#### Ⅱ 请求参数

无

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": [
        {
            "userId": "33333333333",
            "bookId": "00000000004",
            "borrowDate": "2024-12-27",
            "estimatedReturnDate": "2024-12-01"
        },
        {
            "userId": "66666666666",
            "bookId": "00000000004",
            "borrowDate": "2024-12-05",
            "estimatedReturnDate": "2024-12-20"
        },
        {
            "userId": "88888888888",
            "bookId": "00000000006",
            "borrowDate": "2024-12-10",
            "estimatedReturnDate": "2024-12-25"
        },
        {
            "userId": "99999999999",
            "bookId": "00000000007",
            "borrowDate": "2024-12-12",
            "estimatedReturnDate": "2024-12-28"
        },
        {
            "userId": "10101010101",
            "bookId": "00000000008",
            "borrowDate": "2024-12-15",
            "estimatedReturnDate": "2024-12-30"
        },
        {
            "userId": "11111111112",
            "bookId": "00000000009",
            "borrowDate": "2024-12-18",
            "estimatedReturnDate": "2025-01-02"
        }
    ],
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 2、通过用户借书申请

#### Ⅰ 接口概述

1. **接口名称**：通过用户借书申请接口
2. **接口地址**：/librarianApproval/pass
3. **请求方式**：GET

#### Ⅱ 请求参数

| 参数名 | 必选 | 类型   | 描述         |
| ------ | ---- | ------ | ------------ |
| userId | 是   | string | 用户唯一标识 |
| bookId | 是   | string | 书籍唯一标识 |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": "审批通过",
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 3、拒绝用户借书申请

#### Ⅰ 接口概述

1. **接口名称**：拒绝用户借书申请接口
2. **接口地址**：/librarianApproval/noPass
3. **请求方式**：GET

#### Ⅱ 请求参数

| 参数名 | 必选 | 类型   | 描述         |
| ------ | ---- | ------ | ------------ |
| userId | 是   | string | 用户唯一标识 |
| bookId | 是   | string | 书籍唯一标识 |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": "审批通过",
    "token": null,
    "role": null
}
```

```json
{
    "code": 500,
    "message": "未知原因未通过",
    "data": null,
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 4、查询所有归还书籍申请

#### Ⅰ 接口概述

1. **接口名称**：书查询所有归还书籍申请接口
2. **接口地址**：/librarianReturn/getAllInfo
3. **请求方式**：GET

#### Ⅱ 请求参数

无

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": [
        {
            "userId": "33333333333",
            "bookId": "00000000003",
            "borrowDate": "2024-12-27",
            "estimatedReturnDate": "2024-12-01"
        }
    ],
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 5、通过用户还书申请

#### Ⅰ 接口概述

1. **接口名称**：通过用户还书申请接口
2. **接口地址**：/librarianReturn/pass
3. **请求方式**：GET

#### Ⅱ 请求参数

| 参数名 | 必选 | 类型   | 描述         |
| ------ | ---- | ------ | ------------ |
| userId | 是   | string | 用户唯一标识 |
| bookId | 是   | string | 书籍唯一标识 |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": "还书通过",
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 6、拒绝用户还书申请

#### Ⅰ 接口概述

1. **接口名称**：拒绝用户还书申请接口
2. **接口地址**：/librarianReturn/noPass
3. **请求方式**：GET

#### Ⅱ 请求参数

| 参数名 | 必选 | 类型   | 描述         |
| ------ | ---- | ------ | ------------ |
| userId | 是   | string | 用户唯一标识 |
| bookId | 是   | string | 书籍唯一标识 |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": "已拒绝",
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 7、图书管理员信息

#### Ⅰ 接口概述

1. **接口名称**：图书管理员信息接口
2. **接口地址**：/selfInfo
3. **请求方式**：GET

#### Ⅱ 请求参数

无

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": {
        "userId": "44444444444",
        "userName": "赵六",
        "gender": "女",
        "birthday": "1998-06-15",0
        "enrollmentDate": "2024-02-01"
    },
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 8、书籍概览查询

#### Ⅰ 接口概述

1. **接口名称**：书籍概览查询接口
2. **接口地址**：/book/allBookInfor
3. **请求方式**：GET

#### Ⅱ 请求参数

无

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": [
        {
            "bookName": "《平凡的世界》",
            "author": "路遥",
            "publishing": "北京十月文艺出版社",
            "status": "在馆"
        },
        {
            "bookName": "《活着》",
            "author": "余华",
            "publishing": "上海文艺出版社",
            "status": "在馆"
        },
        {
            "bookName": "《百年孤独》",
            "author": "加西亚·马尔克斯",
            "publishing": "南海出版公司",
            "status": "借出"
        },
        {
            "bookName": "《你梁哥帅不帅》",
            "author": "王嘉梁",
            "publishing": "422男宿出版社",
            "status": "在馆"
        }
    ],
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 9、书籍详情页查询

#### Ⅰ 接口概述

1. **接口名称**：书籍详情页查询接口
2. **接口地址**：/book/bookDetail
3. **请求方式**：GET

#### Ⅱ 请求参数

| 参数名 | 必选 | 类型   | 描述         |
| ------ | ---- | ------ | ------------ |
| bookId | 是   | string | 书籍唯一标识 |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": {
        "bookId": "00000000004",
        "bookName": "《你梁哥帅不帅》",
        "author": "王嘉梁",
        "publishing": "422男宿出版社",
        "status": "在馆",
        "intro": "作者将自己帅气的容貌写进Java小学期作业中，企图蒙混过关让自己的帅脸名垂青史",
        "douban": "9",
        "review": null,
        "publicationTime": "2024-12-27"
    },
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 10、书籍过往借阅详情

#### Ⅰ 接口概述

1. **接口名称**：书籍详情页查询接口
2. **接口地址**：/book/userBorrowingInfo
3. **请求方式**：GET

#### Ⅱ 请求参数

| 参数名 | 必选 | 类型   | 描述         |
| ------ | ---- | ------ | ------------ |
| bookId | 是   | string | 书籍唯一标识 |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": [
        {
            "userId": "33333333333",
            "userName": "王五",
            "borrowDate": "2024-12-27",
            "returnDate": "2024-12-27",
            "status": 0
        },
        {
            "userId": "66666666666",
            "userName": "郑一",
            "borrowDate": "2024-12-05",
            "returnDate": "2024-08-27",
            "status": 0
        },
        {
            "userId": "77777777777",
            "userName": "钱二",
            "borrowDate": "2024-12-08",
            "returnDate": "2024-07-18",
            "status": 0
        }
    ],
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

## 三、超级管理员

### 1、创建图书管理员信息

#### Ⅰ 接口概述

1. **接口名称**：创建图书管理员信息接口
2. **接口地址**：/creatLibrarian
3. **请求方式**：POST

#### Ⅱ 请求参数

| 参数名   | 必选 | 类型   | 描述               |
| -------- | ---- | ------ | ------------------ |
| userId   | 是   | string | 图书管理员唯一标识 |
| userName | 是   | string | 图书管理员姓名     |
| gender   | 是   | string | 性别               |
| birthday | 是   | Date   | 图书管理员出生日期 |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": "创建成功",
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 2、书籍概览查询

#### Ⅰ 接口概述

1. **接口名称**：书籍概览查询接口
2. **接口地址**：/book/allBookInfor
3. **请求方式**：GET

#### Ⅱ 请求参数

无

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": [
        {
            "bookName": "《平凡的世界》",
            "author": "路遥",
            "publishing": "北京十月文艺出版社",
            "status": "在馆"
        },
        {
            "bookName": "《活着》",
            "author": "余华",
            "publishing": "上海文艺出版社",
            "status": "在馆"
        },
        {
            "bookName": "《百年孤独》",
            "author": "加西亚·马尔克斯",
            "publishing": "南海出版公司",
            "status": "借出"
        },
        {
            "bookName": "《你梁哥帅不帅》",
            "author": "王嘉梁",
            "publishing": "422男宿出版社",
            "status": "在馆"
        }
    ],
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 3、书籍详情页查询

#### Ⅰ 接口概述

1. **接口名称**：书籍详情页查询接口
2. **接口地址**：/book/bookDetail
3. **请求方式**：GET

#### Ⅱ 请求参数

| 参数名 | 必选 | 类型   | 描述         |
| ------ | ---- | ------ | ------------ |
| bookId | 是   | string | 书籍唯一标识 |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": {
        "bookId": "00000000004",
        "bookName": "《你梁哥帅不帅》",
        "author": "王嘉梁",
        "publishing": "422男宿出版社",
        "status": "在馆",
        "intro": "作者将自己帅气的容貌写进Java小学期作业中，企图蒙混过关让自己的帅脸名垂青史",
        "douban": "9",
        "review": null,
        "publicationTime": "2024-12-27"
    },
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 4、书籍过往借阅详情

#### Ⅰ 接口概述

1. **接口名称**：书籍详情页查询接口
2. **接口地址**：/book/userBorrowingInfo
3. **请求方式**：GET

#### Ⅱ 请求参数

| 参数名 | 必选 | 类型   | 描述         |
| ------ | ---- | ------ | ------------ |
| bookId | 是   | string | 书籍唯一标识 |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": [
        {
            "userId": "33333333333",
            "userName": "王五",
            "borrowDate": "2024-12-27",
            "returnDate": "2024-12-27",
            "status": 0
        },
        {
            "userId": "66666666666",
            "userName": "郑一",
            "borrowDate": "2024-12-05",
            "returnDate": "2024-08-27",
            "status": 0
        },
        {
            "userId": "77777777777",
            "userName": "钱二",
            "borrowDate": "2024-12-08",
            "returnDate": "2024-07-18",
            "status": 0
        }
    ],
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 5、查询图书管理员信息修改申请

#### Ⅰ 接口概述

1. **接口名称**：查询图书管理员信息修改申请接口
2. **接口地址**：/librarianInfoApproval/approvalList
3. **请求方式**：GET

#### Ⅱ 请求参数

无

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": [
        {
            "userId": "11111111111",
            "userName": "张三",
            "modifyProject": "姓名",
            "gender": "",
            "birthday": null
        },
        {
            "userId": "22222222222",
            "userName": "",
            "modifyProject": "出生日期",
            "gender": "",
            "birthday": "1992-08-10"
        },
        {
            "userId": "33333333334",
            "userName": "",
            "modifyProject": "性别",
            "gender": "男",
            "birthday": null
        },
        {
            "userId": "44444444445",
            "userName": "",
            "modifyProject": "出生日期",
            "gender": "",
            "birthday": "1991-07-20"
        },
        {
            "userId": "55555555556",
            "userName": "刘七",
            "modifyProject": "姓名",
            "gender": "",
            "birthday": null
        },
        {
            "userId": "66666666667",
            "userName": "陈八",
            "modifyProject": "姓名",
            "gender": "",
            "birthday": null
        },
        {
            "userId": "77777777778",
            "userName": "孙九",
            "modifyProject": "姓名",
            "gender": "",
            "birthday": null
        },
        {
            "userId": "88888888889",
            "userName": "周十",
            "modifyProject": "姓名",
            "gender": "",
            "birthday": null
        }
    ],
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |
|        |      |

### 6、批准图书管理员信息修改申请

#### Ⅰ 接口概述

1. **接口名称**：批准图书管理员信息修改申请接口
2. **接口地址**：/librarianInfoApproval/approved
3. **请求方式**：POST

#### Ⅱ 请求参数

| 参数名 | 必选 | 类型   | 描述               |
| ------ | ---- | ------ | ------------------ |
| userId | 是   | string | 图书管理员唯一标识 |

#### Ⅲ 响应示例

```json
接口问题，更改后提供响应值
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |

### 7、拒绝图书管理员信息修改申请

#### Ⅰ 接口概述

1. **接口名称**：批准图书管理员信息修改申请接口
2. **接口地址**：/librarianInfoApproval/unPass
3. **请求方式**：POST

#### Ⅱ 请求参数

| 参数名 | 必选 | 类型   | 描述               |
| ------ | ---- | ------ | ------------------ |
| userId | 是   | string | 图书管理员唯一标识 |

#### Ⅲ 响应示例

```json
{
    "code": 200,
    "message": "success",
    "data": "拒绝审批",
    "token": null,
    "role": null
}
```

#### Ⅳ 错误码说明

| 错误码 | 描述 |
| ------ | ---- |
|        |      |

### 