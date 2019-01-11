package com.rent.Dao;

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

public class TestTransaction extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RentTransactionService rentservice;

    @Test
    private void queryTransaction() {
        int op=0;
        logger.info("Test -> Query Owner Transaction");
        logger.info("Test -> Query Type:"+op);
        Map<String, List> map=new HashMap<String,List>();
        List<Integer> rentstate=new ArrayList<Integer>();
        if (op<2) {
            rentstate.add(op);
            map.put("rentstate",rentstate);
        }
        List<RentTransaction> transactionlist=rentservice.queryRentTransaction(map,0,10);
        logger.info(transactionlist.size()+"");
    }

}
