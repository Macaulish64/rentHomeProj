package com.rent.Dao;

import com.alibaba.fastjson.JSON;
import com.rent.BaseTest;
import com.rent.entity.RentTransaction;
import com.rent.service.RentTransactionService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestYue extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RentTransactionService rentTransctionService;

    @Test
    public void queryOwnerTransaction() {
        int userid=2;
        int op=0;
        logger.info("Query Owner Transaction");
        logger.info("Query Type:"+op);
        Map<String, List> map=new HashMap<String,List>();
        List<Integer> landlorid=new ArrayList<Integer>();
        landlorid.add(userid);
        List<Integer> rentstate=new ArrayList<Integer>();
        if (op<2) {
            rentstate.add(op);
            map.put("rentstate",rentstate);
        }
        map.put("landlordId",landlorid);
        List<RentTransaction> transactionlist=rentTransctionService.queryRentTransaction(map,0,5);
        String str=JSON.toJSONString(transactionlist);
        logger.debug(str);
    }
}
