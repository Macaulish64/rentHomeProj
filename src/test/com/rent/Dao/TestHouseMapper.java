package com.rent.Dao;

import com.rent.BaseTest;
import com.rent.dao.HouseMapper;
import com.rent.entity.House;
import com.rent.entity.HouseExample;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class TestHouseMapper extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HouseMapper houseMapper;

    /* */
    @Test
    public void insert() {
    //    for(Integer i=1;i<=20;i++) {
            House newHouse = new House();
      //      newHouse.setHouseid(100+i);
            newHouse.setCityname("天津");
            newHouse.setCommunityname("北城");
            newHouse.setBuildingnumber(Integer.valueOf(100).toString());
            int num = houseMapper.insertSelective(newHouse);
            System.out.println(num);
     //   }
    }

    /* */
    @Test
    public void queryhouse() {
        HouseExample newHouse = new HouseExample();
        newHouse.or().andCitynameLike("%津%");
        newHouse.or().andCommunitynameLike("%北%");
        List<House> newhouses = houseMapper.selectByExample(newHouse);
        System.out.println(newhouses);
    }

    @Test
    public void deletehouse()
    {
        System.out.println(houseMapper.deleteByPrimaryKey(4));
    }
    @Test
    public void queryhouse2()
    {
        Map<String, List> map = new HashMap<String ,List>();
        List list1 = new ArrayList();
        list1.add("天津");
        list1.add("北城");
        map.put("cityName",list1);
        map.put("communityName",list1);
        HouseExample suithouse = new HouseExample();
        HouseExample.Criteria criteria = suithouse.createCriteria();
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


        System.out.println(houseMapper.selectByExample(suithouse).size());
    }
}
