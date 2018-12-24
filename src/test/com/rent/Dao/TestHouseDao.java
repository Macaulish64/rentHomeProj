package com.rent.Dao;

import com.rent.BaseTest;
import com.rent.dao.HouseDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TestHouseDao extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HouseDao houseDao;

    @Test
    public void queryHouseId() {

    }

}
