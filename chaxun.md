对House查询
houseId int
publishUserId int
cityName String
communityName String
buildingNumber String
houseType int
floorNumber int
elevatorOrNot int
paymentMethod int
depositMoneyMin depositMoneyMax float
rentMoneyMin rentMoneyMax float
houseAreaMin houseAreaMax int

houseStatus int

对RentInformation查询
rentId int
publishUserId int
cityName String
communityName String
houseType int
floorNumber int
elevatorOrNot int
paymentMethod int
depositMoneyMin depositMoneyMax float
rentMoneyMin rentMoneyMax float

对RentTransaction查询
transactionId int 
houseId int
landlordId int
tenantId int
transactionDate String
startMonthMin startMonthMax String
endMonthMin endMonthMax String
paymentMethod int
depositMoneyMin depositMoneyMax float
monthRentMin monthRentMax float
totalRentMin totalRentMax float
landlordPaymentAgencyFeeMin landlordPaymentAgencyFeeMax float
tenantPaymentAgencyFeeMin tenantPaymentAgencyFeeMax float
rentStatus int

对Income查询
monthMin monthMax String
area String
transactionNumMin transactionNumMax int
feeIncomeMin feeIncomeMax float