package com.rent.Dao;

import com.rent.BaseTest;
import com.rent.dao.HouseMapper;
import com.rent.entity.House;
import com.rent.entity.HouseExample;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

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
            newHouse.setCommunityname("西城");
            newHouse.setBuildingnumber(Integer.valueOf(100).toString());
            int num = houseMapper.insert(newHouse);
            System.out.println("!!!!!\n");
     //   }
    }

    /* */
    @Test
    public void queryhouse() {
        HouseExample newHouse = new HouseExample();
        newHouse.createCriteria().andCitynameIn(Collections.singletonList("北京"));
        newHouse.createCriteria().andCitynameIn(Collections.singletonList("天津"));
        List<House> newhouses = houseMapper.selectByExample(newHouse);
        System.out.println(newhouses);
    }


}
