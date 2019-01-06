package com.rent.service.impl;

import com.rent.dao.HouseMapper;
import com.rent.entity.House;
import com.rent.entity.HouseExample;
import com.rent.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public int insertHouse(House record) {
        return houseMapper.insertSelective(record);
    }

    @Override
    public int updateHouse(House record) {
        return houseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<House> queryHouse(HouseExample example, int start , int end) {
        return houseMapper.selectByExample(example).subList(start,end);
    }

    @Override
    public int deleteHouse(Integer houseId) {
        return houseMapper.deleteByPrimaryKey(houseId);
    }

    @Override
    public House selectHouseById(Integer houseId) {
        return houseMapper.selectByPrimaryKey(houseId);
    }

    @Override
    public int countHouse(HouseExample example) {
        return houseMapper.countByExample(example);
    }
}
