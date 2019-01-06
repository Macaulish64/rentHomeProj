package com.rent.service.impl;

import com.rent.dao.RentInformationMapper;
import com.rent.entity.RentInformation;
import com.rent.entity.RentInformationExample;
import com.rent.service.RentInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentInformationServiceImpl implements RentInformationService {
    @Autowired
    private RentInformationMapper rentInformationMapper;

    @Override
    public int insertRentInformation(RentInformation record) {
        return rentInformationMapper.insertSelective(record);
    }

    @Override
    public int deleteRentInformation(Integer rentId) {
        return rentInformationMapper.deleteByPrimaryKey(rentId);
    }

    @Override
    public int updateRentInformation(RentInformation record) {
        return rentInformationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public RentInformation selectRentInformationById(Integer rentId) {
        return rentInformationMapper.selectByPrimaryKey(rentId);
    }

    @Override
    public List<RentInformation> queryRentInformation(RentInformationExample example, int start, int end) {
        return  rentInformationMapper.selectByExample(example).subList(start,end);
    }

    @Override
    public int countRentInformation(RentInformationExample example) {
        return rentInformationMapper.countByExample(example);
    }
}
