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





1. 搜索框.String -> list<House>  （1）
2. 房源 （2）
  public List<House> getHouseList( Map<String,List<String>> map)
  {
    List<String> list;
    list=map['publishUser'];
    HouseExample suithouse;
    for(String publish: list<String>) 
    {
      suithouse.(publish);
    }

     list=map['cityName'];
    HouseExample suithouse;
    for(String publish: list<String>) 
    {
      suithouse.(publish);
    }

     list=map['publishUser'];
    HouseExample suithouse;
    for(String publish: list<String>) 
    {
      suithouse.(publish);
    }

     list=map['publishUser'];
    HouseExample suithouse;
    for(String publish: list<String>) 
    {
      suithouse.(publish);
    }

    return List<House>;
  }

  public int counterHouseList( Map<String,List<String>> map)
  {
    List<String> list;
    list=map['publishUser'];
    HouseExample suithouse;
    for(String publish: list<String>) 
    {
      suithouse.(publish);
    }

     list=map['cityName'];
    HouseExample suithouse;
    for(String publish: list<String>) 
    {
      suithouse.(publish);
    }

     list=map['publishUser'];
    HouseExample suithouse;
    for(String publish: list<String>) 
    {
      suithouse.(publish);
    }

     list=map['publishUser'];
    HouseExample suithouse;
    for(String publish: list<String>) 
    {
      suithouse.(publish);
    }

    return ;
  }



  Map<String,List<String>>,start-> List<House>
  citylist=map['city'];
  for(city :ctiylist) exmp

  Map<String,List<String>>> number,


  Map< 'publishUser', List<String> 
        'cityNmae' ,List<String> 
        '
3. 发布房源
  House -> Map
4. 求租，发布求租如上图（2）
6. 房客中心，房东中心，返回统计信息（4）
  getListTransaction1
   userid -> List<transaction>
   同上，
7. 删除房源/求租信息，给一个id -> enum
8. 修改视图(暂时没有)。
7. 个人基本信息，给一个namenickid -> User
8. 修改密码,
9. 修改信息
10. 



