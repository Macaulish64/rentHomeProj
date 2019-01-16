package com.rent.Dao;

import com.rent.BaseTest;
import com.rent.dao.RentTransactionMapper;
import com.rent.entity.RentTransaction;
import com.rent.entity.RentTransactionExample;
import com.rent.service.RentTransactionService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class TestTransaction extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RentTransactionService renttservice;

    @Autowired
    private RentTransactionMapper rentTransactionMapper;

    @Test
    public void queryTransaction() {
        int op=1;
        logger.info("Test -> Query Owner Transaction");
        logger.info("Test -> Query Type:"+op);
        Map<String, List> map=new HashMap<String,List>();
        List<Integer> rentstate=new ArrayList<Integer>();

        rentstate.add(op);
        map.put("transactionId",rentstate);


        RentTransactionExample suittrans = new RentTransactionExample();
        RentTransactionExample.Criteria criteria= suittrans.createCriteria();


        criteria.andTransactiondateBetween("2019-01-00 00:00:00","2019-01-99 99:99:99");

        List<RentTransaction> transactionlist = rentTransactionMapper.selectByExample(suittrans);
        logger.info(transactionlist.size()+"");
        //RentTransaction record = renttservice.selectRentTransactionById(1);
        System.out.println(transactionlist);
    }

    @Test
    public void insertTrans()
    {
        Map<String,Object> map = renttservice.submitTransaction(1,5,"2019-01","2019-03",3);
        renttservice.confirmTransaction((Integer) map.get("transId"));

        System.out.println("!!!!\n");
    }
}
