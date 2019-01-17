# 记录

#### 1. 建立工程

```
maven-archetype-webapp
```

Groupid: cn.renting

Artifactid:rentHomeProj

#### 2.项目结构
与之前类似

#### 3.数据库建立
建立一个数据库rentsystem
```
CREATE SCHEMA `rentsystem` ;
```
建立5张数据库的表
##### 1.User
```
create table User(
    userId int auto_increment primary key,
    userNickName nvarchar(20),
    password varchar(20),
    userType int,
    userName nvarchar(20),
    cardType int,
    idNumber varchar(20),
    phoneNumber varchar(20),
    userLevel int default 0,
    registCity nvarchar(10),
    updateTime varchar(20)
  )default charset=utf8;

  insert into 
    User(UserNickName,Password,UserType,UserName,CardType,IdNumber,PhoneNumber,RegistCity,UpdateTime) 
  values('小明','123456',0,'王明',0,'123456789012345678','12345678901','北京','20181222');
```
##### 2.House
```
create table House(
    houseId int auto_increment primary key,
    publishUserId int,
    cityName nvarchar(10),
    communityName nvarchar(50),
    buildingNumber nvarchar(20),
    houseType int,
    houseArea int,
    floorNumber int,
    elevatorOrNot int,
    houseDescription nvarchar(500),
    housePhoto varchar(50),
    deposit float(10,2),
    paymentMethod int,
    rent float(10,2),
    registTime varchar(20),
    updateTime varchar(20),
    housestatus int
  )default charset=utf8;
  ```
  ##### 3.rentinformation
  ```
  create table rentinformation(
    rentId int auto_increment primary key,
    publishUserId int,
    cityName nvarchar(10),
    communityName nvarchar(50),
    houseType int,
    floorNumber int,
    elevatorOrNot int,
    houseDescription nvarchar(500),
    deposit float(10,2),
    paymentMethod int,
    rent float(10,2),
    registTime varchar(20),
    updateTime varchar(20)
  )default charset=utf8;
  ```
##### 4.renttransaction
```
create table renttransaction(
    transactionId int auto_increment primary key,
    houseId int,
    landlordId int,
    tenantId int,
    transactionDate varchar(20),
    startMonth varchar(10),
    endMonth varchar(10),
    deposit float(10,2),
    paymentMethod int,
    monthRent float(10,2),
    totalRent float(10,2),
    landlordPaymentAgencyFee float(12,4),
    tenantPaymentAgencyFee float(12,4)
  )default charset=utf8;
  ```
  ##### 5.income
  ```
  create table income(
    month varchar(20),
    area nvarchar(20),
    primary key(Month,Area),
    transactionNum int,
    feeIncome float(12,4)
  )default charset=utf8;
  ```


## 界面

### 主界面

1. 根据用户名查询密码，返回 null？

### 注册界面
1. 读进注册信息，返回null
### 房屋信息
1. 根据筛选条件，得到连续的几天房屋信息，list(x..)
### 房屋信息的详细
1. 得到某个房屋的信息(房屋id)
### 出租则
### 我要租房





1. 搜索框 
   
   调用HouseService层的 List<House> searchBar(String c)
   给出的是城市或小区名包含c的所有房源

2. 新建房源

    调用HouseService层的Map<String,Object> insertHouse(House record)

    插入失败会返回rescode、resmsg

    插入成功会返回rescode、resmsg、houseId

3. 修改房源
   
   调用HouseService层的Map<String,Object> updateHouse(House record)

   插入失败会返回rescode、resmsg

    插入成功会返回rescode、resmsg

4. 删除房源
   
   调用HouseService层的int deleteHouse(Integer houseId);
   
   成功返回1，失败返回0

5. 点击某房源以查看详细信息

    调用HouseService层的House selectHouseById(Integer houseId)
  
6. 按需求搜索房源
   
   调用HouseService层的int queryHouseNum(Map<String,List> map)先知道搜索出的房源的个数；再调用HouseService层的List<House> queryHouse(Map<String,List> map, int start,int end)
   
   ①租客要搜索房源

   可同时搜索多个城市、小区、楼号、户型、楼层数、有无电梯、租金支付方式；押金和租金是个范围值。注意房屋状态必须是0（未租）

   ②房东中心要搜索自己所有的房源

   只需要publishUserId是房东的UserId就行

   ③后台管理要所有房源

   map为空就行


7. 新建、修改、删除、搜索求租，租客中心查看自己求租，后台查看所有求租，全与上面相似

8.  个人基本信息查看
   
    调用UserService层的User selectUserById(int userId)

9.  注册、修改个人信息，点击某用户查看详细信息，后台查看所有用户，全与上面相似

10. 登录界面
    
    调用UserService层的Map<String,Object> checkUserLogin(User record)

11. 注册时审核是否已有该用户
    
    调用UserService层的User getExistUser(UserExample example);

12. 为某房源插入新照片、删除照片、显示照片全与上面相似。注意房源照片的张数在House实体的photoNum属性

13. 后台查看某月某地区的成交笔数和中介费
    
    调用IncomeService层的Map<String,Object> queryIncomeNum(Map<String,List> map)和List<Income> queryIncome(Map<String,List> map, int start, int end)

    前者返回这段时间这些地区的成交笔数总和和中介费总和，分别是transactionNum和feeIncome

    后者是把这些表全拿出来

14. 每成交一笔订单，需要修改
    
   



