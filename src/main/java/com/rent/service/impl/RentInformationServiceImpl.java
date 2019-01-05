package com.rent.service.impl;

import com.rent.dao.RentInformationMapper;
import com.rent.entity.RentInformation;
import com.rent.entity.RentInformationExample;
import com.rent.service.RentInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentInformationServiceImpl implements RentInformationService {
    @Autowired
    private RentInformationMapper rentInformationMapper;

    @Override
    public int insertRentInformation(RentInformation record) {
        return rentInformationMapper.insertSelective(record);
    }

    @Override
    public int deleteRentInformation(Integer transactionid) {
        return rentInformationMapper.deleteByPrimaryKey(transactionid);
    }

    @Override
    public int updateRentInformation(RentInformation record) {
        return rentInformationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public <List> RentInformation queryRentInformation(RentInformationExample example) {
        return (RentInformation) rentInformationMapper.selectByExample(example);
    }
}
