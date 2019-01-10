package com.rent.service;

import com.rent.entity.House;

import java.util.List;
import java.util.Map;

public interface HouseService {
    //搜索框,与城市、小区名字相似
    public List<House> searchBar(String c);

    //插入房屋，成功返回houseid
    public Map<String,Object> insertHouse(House record);

    //在已知房屋标识的情况下，修改房屋
    public Map<String,Object> updateHouse(House record);

    //在已知房屋标识的情况下，删除房屋
    public int deleteHouse(Integer houseId);

    //查找房屋的数量
    public int queryHouseNum(Map<String,List> map);

    //查找房屋
    public List<House> queryHouse(Map<String,List> map, int start,int end);

    //在已知房屋标识的情况下，查找
    House selectHouseById(Integer houseId);
}
