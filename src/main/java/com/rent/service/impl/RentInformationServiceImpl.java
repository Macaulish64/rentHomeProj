package com.rent.service.impl;

import com.rent.common.CommonEnum;
import com.rent.dao.RentInformationMapper;
import com.rent.entity.RentInformation;
import com.rent.entity.RentInformationExample;
import com.rent.service.RentInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RentInformationServiceImpl implements RentInformationService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RentInformationMapper rentInformationMapper;


    @Override
    public Map<String, Object> insertRentInformation(RentInformation record) {
        Map<String,Object> map=new HashMap<String,Object>();
        int num=rentInformationMapper.insertSelective(record);

        if (num==0)
        {
            //失败
            map.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
            map.put("resmsg",CommonEnum.REQUEST_FAILED.getMsg());
            return map;
        }
        //成功
        map.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
        map.put("resmsg",CommonEnum.REQUEST_SUCCESS.getMsg());
        RentInformationExample suithouse = new RentInformationExample();
        List<RentInformation> list = rentInformationMapper.selectByExample(suithouse);
        map.put("rentId",list.get(list.size()-1).getRentid());
        return map;
    }

    @Override
    public int deleteRentInformation(Integer rentId) {
        return rentInformationMapper.deleteByPrimaryKey(rentId);
    }

    @Override
    public Map<String, Object> updateRentInformation(RentInformation record) {
        Map<String,Object> map=new HashMap<String,Object>();
        int num=rentInformationMapper.updateByPrimaryKeySelective(record);

        if (num==0)
        {
            //失败
            map.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
            map.put("resmsg",CommonEnum.REQUEST_FAILED.getMsg());
            return map;
        }
        //成功
        map.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
        map.put("resmsg",CommonEnum.REQUEST_SUCCESS.getMsg());
        return map;
    }

    @Override
    public RentInformation selectRentInformationById(Integer rentId) {
        return rentInformationMapper.selectByPrimaryKey(rentId);
    }

    @Override
    public int queryRentInformationNum(Map<String, List> map) {
        RentInformationExample suitrent =new RentInformationExample();
        RentInformationExample.Criteria criteria = suitrent.createCriteria();

        if (map.containsKey("rentId"))
            criteria.andRentidIn(map.get("rentId"));
        if (map.containsKey("publishUserId"))
            criteria.andPublishuseridIn(map.get("publishUserId"));
        if (map.containsKey("cityName"))
            criteria.andCitynameIn(map.get("cityName"));
        if (map.containsKey("communityName"))
            criteria.andCommunitynameIn(map.get("communityName"));
        if (map.containsKey("houseType"))
            criteria.andHousetypeIn(map.get("houseType"));
        if (map.containsKey("floorNumber"))
            criteria.andFloornumberIn(map.get("floorNumber"));
        if (map.containsKey("elevatorOrNot"))
            criteria.andElevatorornotIn(map.get("elevatorOrNot"));
        if (map.containsKey("paymentMethod"))
            criteria.andPaymentmethodIn(map.get("paymentMethod"));
        if (map.containsKey("depositMoneyMax") && map.containsKey("depositMoneyMin"))
            criteria.andDepositmoneyBetween((float)map.get("depositMoneyMin").get(0),(float)map.get("depositMoneyMax").get(0));
        if (map.containsKey("rentMoneyMax") && map.containsKey("rentMoneyMin"))
            criteria.andRentmoneyBetween((float)map.get("rentMoneyMin").get(0),(float)map.get("rentMoneyMax").get(0));

        return rentInformationMapper.selectByExample(suitrent).size();
    }

    @Override
    public List<RentInformation> queryRentInformation(Map<String, List> map, int start, int end) {
        RentInformationExample suitrent =new RentInformationExample();
        RentInformationExample.Criteria criteria = suitrent.createCriteria();

        if (map.containsKey("rentId"))
            criteria.andRentidIn(map.get("rentId"));
        if (map.containsKey("publishUserId"))
            criteria.andPublishuseridIn(map.get("publishUserId"));
        if (map.containsKey("cityName"))
            criteria.andCitynameIn(map.get("cityName"));
        if (map.containsKey("communityName"))
            criteria.andCommunitynameIn(map.get("communityName"));
        if (map.containsKey("houseType"))
            criteria.andHousetypeIn(map.get("houseType"));
        if (map.containsKey("floorNumber"))
            criteria.andFloornumberIn(map.get("floorNumber"));
        if (map.containsKey("elevatorOrNot"))
            criteria.andElevatorornotIn(map.get("elevatorOrNot"));
        if (map.containsKey("paymentMethod"))
            criteria.andPaymentmethodIn(map.get("paymentMethod"));
        if (map.containsKey("depositMoneyMax") && map.containsKey("depositMoneyMin"))
            criteria.andDepositmoneyBetween((float)map.get("depositMoneyMin").get(0),(float)map.get("depositMoneyMax").get(0));
        if (map.containsKey("rentMoneyMax") && map.containsKey("rentMoneyMin"))
            criteria.andRentmoneyBetween((float)map.get("rentMoneyMin").get(0),(float)map.get("rentMoneyMax").get(0));
        return rentInformationMapper.selectByExample(suitrent).subList(start,end);
    }
}
