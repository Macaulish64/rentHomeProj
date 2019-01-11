package com.rent.service.impl;

import com.rent.common.CommonEnum;
import com.rent.dao.HouseMapper;
import com.rent.entity.House;
import com.rent.entity.HouseExample;
import com.rent.service.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl implements HouseService {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public List<House> searchBar(String c) {
        HouseExample suithouse = new HouseExample();
        c='%'+c+'%';
        suithouse.or().andCitynameLike(c);
        suithouse.or().andCommunitynameLike(c);

        return houseMapper.selectByExample(suithouse);
    }

    @Override
    public Map<String, Object> insertHouse(House record) {
        record.setUpdatetime(df.format(new Date()));
        record.setRegisttime(df.format(new Date()));
        Map<String,Object> map=new HashMap<String,Object>();
        int num = houseMapper.insertSelective(record);
        //失败
        if (num==0)
        {
            map.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
            map.put("resmsg",CommonEnum.REQUEST_FAILED.getMsg());
            return map;
        }
        //成功
        map.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
        map.put("resmsg",CommonEnum.REQUEST_SUCCESS.getMsg());
        HouseExample suithouse = new HouseExample();
        List<House> list = houseMapper.selectByExample(suithouse);
        map.put("houseId",list.get(list.size()-1).getHouseid());
        return map;
    }

    @Override
    public Map<String, Object> updateHouse(House record) {
        record.setUpdatetime(df.format(new Date()));
        Map<String,Object> map=new HashMap<String,Object>();
        int num = houseMapper.updateByPrimaryKeySelective(record);
        //失败
        if (num==0)
        {
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
    public int deleteHouse(Integer houseId) {
       return houseMapper.deleteByPrimaryKey(houseId);
    }

    @Override
    public int queryHouseNum(Map<String, List> map) {
        HouseExample suithouse = new HouseExample();
        HouseExample.Criteria criteria= suithouse.createCriteria();
        if (map.containsKey("houseId"))
            criteria.andHouseidIn(map.get("houseId"));
        if (map.containsKey("publishUserId"))
            criteria.andPublishuseridIn(map.get("publishUserId"));
        if (map.containsKey("cityName"))
            criteria.andCitynameIn(map.get("cityName"));
        if (map.containsKey("communityName"))
            criteria.andCommunitynameIn(map.get("communityName"));
        if (map.containsKey("buildingNumber"))
            criteria.andBuildingnumberIn(map.get("buildingNumber"));
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
        if (map.containsKey("houseStatus"))
            criteria.andHousestatusIn(map.get("houseStatus"));

        return houseMapper.selectByExample(suithouse).size();
    }

    @Override
    public List<House> queryHouse(Map<String, List> map, int start, int end) {
        HouseExample suithouse = new HouseExample();
        HouseExample.Criteria criteria= suithouse.createCriteria();
        if (map.containsKey("houseId"))
            criteria.andHouseidIn(map.get("houseId"));
        if (map.containsKey("publishUserId"))
            criteria.andPublishuseridIn(map.get("publishUserId"));
        if (map.containsKey("cityName"))
            criteria.andCitynameIn(map.get("cityName"));
        if (map.containsKey("communityName"))
            criteria.andCommunitynameIn(map.get("communityName"));
        if (map.containsKey("buildingNumber"))
            criteria.andBuildingnumberIn(map.get("buildingNumber"));
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
        if (map.containsKey("houseStatus"))
            criteria.andHousestatusIn(map.get("houseStatus"));

        return houseMapper.selectByExample(suithouse).subList(start,end);
    }

    @Override
    public House selectHouseById(Integer houseId) {
        return houseMapper.selectByPrimaryKey(houseId);
    }
}
