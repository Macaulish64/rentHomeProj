package com.rent.service;

import com.rent.entity.RentInformation;
import com.rent.entity.RentInformationExample;

public interface RentInformationService {
    int insertRentInformation(RentInformation record);
    int deleteRentInformation(Integer transactionid);
    int updateRentInformation(RentInformation record);
    <List>RentInformation queryRentInformation(RentInformationExample example);
}
