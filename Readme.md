文档分析：

### 系统用户

#### 普通用户

- 注册用户基本信息； 
  注册系统，需要一个注册页面的视图(url+/register)。核心为一个表格，其中需要填入各种信息{具体信息如下：blabla}
  点击注册按钮，调用url+"/register/submit"逻辑
  register在业务层需要判断:
    1. 是否信息完整，回到注册页面，并提示错误
    2. 是否信息冲突(除了姓名，其他信息不冲突?)，回到册页页面，并提示错误(先省略)
    3. 成功，返回主页面
  
  也就是说，输入参数为User，输出参数为RegisterError(枚举类型)

  具体各层的工作：
  数据库SQL：查询,增加用户,User
  Dao层：
  ```
    User queryUserByPhone(String phoneNumber);
    int addUser(User user);
  ```
  service层：
  web-controller层:
  ```
  hasuser=userService.userQuery();
  if (hasuser == null) {
      userService.userAdd(user);
  }
  else {
    return userService.userError();
  }

  ```

- 修改用户联系电话、密码信息； 

  对于修改用户联系电话：
  一个电话号码只能注册一次，故现在数据库里查询电话号码，如果没有，执行修改操作
  数据库SQL:User表中，(1)查找某个号码是否存在(2)修改某个用户的号码
  Dao层：
  service层：
  web-controller层：

  对于修改密码信息：
  密码的形式应有一定的判断,
  要求:
    1. 密码不少于8位
    2. 必须含有两个数字
    3. 不能全位大写或者小写

  此外还要求：密码不得与原来的相似(相等吧)
  数据库SQL:User表中，(1)查找用户密码(2)修改某个用户的密码
  Dao层：
  service层：
  web-controller层：


- 登录系统:
  登录系统有一个登入界面的视图，登陆界面需要输入用户名(userNickName)和密码(password)。然后接受用户名与密码,根据用户名查询密码,比较与用户输入的密码是否一致。
  数据库SQL:User表:(1)查询对应用户名的密码
  Dao层:
  service层：
  web-controller层：

- 房东身份
  - 填写发布房源信息，上传房屋内部照片:
    在发布房源信息时中同时支持上传房屋内部照片

    数据库SQL:增加一个条目
    Dao层：
    service层：
    (1)接受上传的图片
    (2)调用增加条目
    web-controller层：
    
  - 查询自己发布的房屋信息
    数据库SQL:
    Dao层：
    service层：
    web-controller层：
  - 对于有申请出租的房屋可点击同意或拒绝，如果同意则平台按照规则计算中介费并提交数据库存储
    数据库SQL：
    Dao层：
    service层：
    web-controller层：
  - 修改自己已发布未成交的自己房源信息
    数据库SQL：
    Dao层：
    service层：
    web-controller层：
  - 删除已发布未成交的自己房源信息
    数据库SQL：
    Dao层：
    service层：
    web-controller层：
  - 查询所有租房需求信息
    数据库SQL：
    Dao层：
    service层：
    web-controller层：
  - 查询所有出租房屋信息
    数据库SQL：
    Dao层：
    service层：
    web-controller层：
- 租户身份

  -  填写想租房的需求信息
    数据库SQL：
    Dao层：
    service层：
    web-controller层：
  - 查询或修改自己发布的租房需求信息
    数据库SQL：
    Dao层：
    service层：
    web-controller层：
  - 删除已发布的求租信息

  - 查询所有租房需求信息

  - 查询所有出租房屋信息

  - 点击某一具体房源可看到明细信息

  - 点击申请租用可模拟申请租房的请求

#### 管理员

- 可以查询当前所有用户基本信息；
- 查询一定条件的房源及其状态信息，点击某一房屋标识可显示房主信息
- 查询求租房屋信息，点击某一标识可显示求租用户基本信息；
- 查询一定条件下当前已经成交租房的累计中介费收益信息。 
### 系统功能模块 

- 用户注册功能； 
- 用户登录功能；在首页输入用户名、密码，验证后登录系统； 
- 用户信息管理模块：用户可以浏览自己注册的基本信息，只能修改联系电话和登录密码
- 房源信息查询功能模块：默认显示所有房源信息
  - 可以输入地区条件、房型、是否有电梯、楼层条件，显示满足条件的房源信息
  - 注意房东姓名、证件、电话号码信息不可见
- 求租信息查询功能模块：默认显示所有求租信息

  - 可以输入地区条件、房型、是否有电梯、楼层条件，显示满足条件的求租信息

  - 注意求租用户姓名、证件、电话号码信息不可见
- 我要出租功能模块：默认显示当前自己已发布的所有房源信息；

  - 发布新的房源信息

  - 修改自己已发布未成交房源信息

  - 删除自己已发布未成交房源信息
- 我要租房功能模块：
  - 默认显示当前已发布的所有求租信息；
  - 发布自己新的求租信息
  - 修改自己已发布未成交的求租信息；
  - 删除已发布未成交的求租信息
- 统计分析功能模块：
  - 显示起始年月、终止年月、某个地域成交中介费的明细，
  - 并按月以折线图的方式展示每月累计成交笔数、中介费金额的变化趋势
### 数据库

- 用户类

  | 列名 | 值域 | 说明                                    |
  | ---- | ---- | --------------------------------------- | 
  |   userId   |    int  | 用户标识                                |
  |    userNickName  |  nvarchar(20)    | 用户名                                  | 
  |    password  |   varchar(20)   | 登录密码                                |
  |    userType  |    int  | 用户类型 （系统管理员1/普通用户0，默认为0） |
  |     userName |   nvarchar(20)   | 用户姓名                                |
  |    cardType  |  int    | 证件类型（护照1、默认身份证0）                  |
  |     idNumber |    varchar(20)  | 证件号码                                |
  |    phoneNumber  |   varchar(20)   | 手机号码(11位）                           |
  |    userLevel  |   int   | 用户级别（钻石级3、重要2、一般0，默认为0）          |
  |    registCity  |   nvarchar(10)   | 注册城市                                |
  |   updateTime   |    varchar(20)  | 修改时间 |

  ```
  create table User(
    userId int auto_increment primary key,
    userNickName nvarchar(20),
    password varchar(20),
    userType int default 0,
    userName nvarchar(20),
    cardType int,
    idNumber varchar(20),
    phoneNumber varchar(20),
    userLevel int default 0,
    registCity nvarchar(10),
    updateTime varchar(20)
  )default charset=utf8;

  insert into User(UserNickName,Password,UserType,UserName,CardType,IdNumber,PhoneNumber,RegistCity,UpdateTime) values('小明','123456',0,'王明',0,'123456789012345678','12345678901','北京','20181222');
  ```


- 房屋类

  | 列名 | 值域 | 说明                                    |
  | ---- | ---- | --------------------------------------- |
  |   houseId   |   int   | 房屋标识                           |
  |    publishUserId  |   int   | 发布用户标识                           |
  |    cityName  |   nvarchar(10)   | 所在城市                           |
  |   communityName   |  nvarchar(50)    | 小区名称 |
  |   buildingNumber   |   nvarchar(20)   | 具体楼门号                           |
  |   houseType   |   int   | 房屋类型（一居、二居、三居、三居以上） |
  |   houseArea   |   int   | 房屋面积（N 平米）                     |
  |    floorNumber  |    int  | 所在楼层                       |
  |   elevatorOrNot   |  int    | 是否有电梯     |
  |     houseDescription |    nvarchar(500)  | 房屋家居描述                         |
  |  photoNum     |   int   | 房屋照片数量 |
  |depositMoney |float(10,2) | 押金（N 个月） |
  |paymentMethod |int | 租金支付方式（月、季、年） |
  | rentMoney|float(10,2)  | 租金 |
  |registTime |varchar(20)  | 注册时间 |
  |updateTime | varchar(20) | 修改时间 |
  |houseStatus |int | 状态（已租1、待租0，默认为0） |


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
      photoNum int,
      depositMoney float(10,2),
      paymentMethod int,
      rentMoney float(10,2),
      registTime varchar(20),
      updateTime varchar(20),
      houseStatus int default 0
    )default charset=utf8;
```
- 照片
|列名|值域|说明|
|---|---|---|
|photoId|int|照片标识|
|houseId|int|照片的房屋|
|housePhoto    |   varchar(50)   | 照片 |
```
create table Photo(
    photoId int auto_increment primary key,
    houseId int,
    housePhoto varchar(50)
)default charset=utf8;
```

- 创建求租信息类
  
  | 列名 | 值域 | 说明                                    |
  | ---- | ---- | --------------------------------------- |
  |   rentId   |   int   | 求租标识                      |
  |    publishUserId  |  int    | 发布用户标识                         |
  |   cityName   |   nvarchar(10)   | 所在城市                        |
  | communityName|nvarchar(50) | 小区名称 |
  | houseType|int | 房屋类型（一居、二居、三居、三居以上） |
  |floorNumber |int | 所在楼层 |
  |elevatorOrNot |int | 是否有电梯 |
  |houseDescription | nvarchar(500)| 房屋家居描述 |
  |depositMoney | float(10,2)| 押金（N 个月） |
  |paymentMethod|int | 租金支付方式（月、季、年） |
  |rentMoney |float(10,2) | 租金 |
  | registTime|varchar(20) | 注册时间 |
  |updateTime | varchar(20)| 修改时间 |

```
create table RentInformation(
    rentId int auto_increment primary key,
    publishUserId int,
    cityName nvarchar(10),
    communityName nvarchar(50),
    houseType int,
    floorNumber int,
    elevatorOrNot int,
    houseDescription nvarchar(500),
    depositMoney float(10,2),
    paymentMethod int,
    rentMoney float(10,2),
    registTime varchar(20),
    updateTime varchar(20)
  )default charset=utf8;
```

- 房屋出租成交明细表
  
| 列名 | 值域 | 说明                                    |
| ---- | ---- | --------------------------------------- |
| transactionId | int |成交订单标识 |
|  houseId   |  int    | 房屋标识                 |
|    landlordId  |  int    | 房东用户标识                    |
|   tenantId   |   int   | 租户用户标识                    |
| transactionDate|varchar(20) | 成交日期 |
| startMonth| varchar(10)| 出租起始月份 |
| endMonth| varchar(10)| 出租终止月份 |
|depositMoney |float(10,2)  | 押金金额 |
|paymentMethod |int | 租金支付方式（月、季、年） |
| monthRent|float(10,2) | 月租金 |
| totalRent| float(10,2)| 总租金 |
| landlordPaymentAgencyFee|float(12,4) | 房东支付中介费（总租金*0.03） |
|tenantPaymentAgencyFee |float(12,4) | 租户支付中介费（总租金*0.03） |
```
create table renttransaction(
    transactionId int auto_increment primary key,
    houseId int,
    landlordId int,
    tenantId int,
    transactionDate varchar(20),
    startMonth varchar(10),
    endMonth varchar(10),
    depositMoney float(10,2),
    paymentMethod int,
    monthRent float(10,2),
    totalRent float(10,2),
    landlordPaymentAgencyFee float(12,4),
    tenantPaymentAgencyFee float(12,4)
  )default charset=utf8;
```

- 中介收益汇总表
  
| 列名 | 值域 | 说明                                    |
| ---- | ---- | --------------------------------------- |
|   month   |    varchar(20)  | 月度（YYYYMM）       |
|    area  |   nvarchar(20)   | 地域（省-市）            |
|   transactionNum   |    int  | 成交笔数               |
|feeIncome | float(12,4) | 中介费收入金额 |

```
create table Income(
    month varchar(20),
    area nvarchar(20),
    primary key(Month,Area),
    transactionNum int,
    feeIncome float(12,4)
  )default charset=utf8;
```

### 视图要求

- 用户注册页面：输入用户基本信息及密码。（要求密码不少于 8 位，必须含有两个数字，不能与原来的密码相似，不能都为大写或小写） 
- 用户登录页面，输入用户名、密码进行验证登录系统。用户名、密码可
  以事先插入到数据库中。 
- 修改用户信息页面：显示所有基本信息，但只能修改手机号码和密码（同前要求）、
- 房屋信息新增发布、查询、修改、删除功能页面； 
- 求租信息新增发布、查询、修改、删除功能页面； 
- 用户详细信息展示页面； 
- 申请租房信息显示及确认页面； 
- 房屋出租成交明细及统计信息查询页面； 
  - 可输入起始年月、终止年月、某个地域条件，按条件查询显示房屋
    成交中介费的明细列表，并按月以折线图的方式展示每月累计成交
    笔数、中介费金额的变化趋势
  - 可支持按照累计成交笔数、累计中介费排序的功能。 
- 在完成基本功能基础之上，可扩展其它功能。如根据用户的级别开放租户或房东的部分信息可见，采用不同的中介费计价规则等。 


