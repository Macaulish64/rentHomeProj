package com.rent.service;

import com.rent.entity.House;
import com.rent.entity.HouseExample;

public interface HouseService {
    int insertHouse(House record);
    int updateHouse(House record);
    <List>House queryHouse(HouseExample example);
    int deleteHouse(Integer houseid);
}
