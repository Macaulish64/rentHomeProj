package com.rent.service;

import com.rent.entity.RentInformation;
import com.rent.entity.RentInformationExample;

public interface RentInformationService {

    int insertRentInformation(RentInformation record);
    //在已知求租信息标识的情况下，删除房屋信息
    int deleteRentInformation(Integer transactionid);
    //在已知求租信息标识的情况下，更新房屋信息
    int updateRentInformation(RentInformation record);
    //查找求租信息，从start项到end项，从0开始
    <List>RentInformation queryRentInformation(RentInformationExample example,int start,int end);
    //计数
    int countRentInformation(RentInformationExample example);
}
