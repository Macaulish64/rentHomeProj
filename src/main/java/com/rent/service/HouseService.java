package com.rent.service;

import com.rent.entity.House;
import com.rent.entity.HouseExample;

import java.util.List;

public interface HouseService {

    int insertHouse(House record);
    //在已知房屋标识的情况下，修改房屋
    int updateHouse(House record);
    //查找房屋，从start项到end项，从0开始
    List<House> queryHouse(HouseExample example, int start , int end);
    //在已知房屋标识的情况下，删除房屋
    int deleteHouse(Integer houseId);
    //在已知房屋标识的情况下，查找
    House selectHouseById(Integer houseId);
    //计数
    int countHouse(HouseExample example);
}
