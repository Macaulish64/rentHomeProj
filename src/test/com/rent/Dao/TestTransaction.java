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

        if (map.containsKey("transactionId"))
            criteria.andTransactionidIn(map.get("transactionId"));
        if (map.containsKey("houseId"))
            criteria.andHouseidIn(map.get("houseId"));
        if (map.containsKey("landlordId"))
            criteria.andLandlordidIn(map.get("landlordId"));
        if (map.containsKey("tenantId"))
            criteria.andTenantidIn(map.get("tenantId"));
        if (map.containsKey("transactionDate"))
            criteria.andTransactiondateIn(map.get("transactionDate"));
        if (map.containsKey("startMonth"))
            criteria.andStartmonthIn(map.get("startMonth"));
        if (map.containsKey("endMonth"))
            criteria.andEndmonthIn(map.get("endMonth"));
        if (map.containsKey("paymentMethod"))
            criteria.andPaymentmethodIn(map.get("paymentMethod"));
        if (map.containsKey("depositMoneyMax") && map.containsKey("depositMoneyMin"))
            criteria.andDepositmoneyBetween((float)map.get("depositMoneyMin").get(0),(float)map.get("depositMoneyMax").get(0));
        if (map.containsKey("monthRentMax") && map.containsKey("monthRentMin"))
            criteria.andMonthrentBetween((float)map.get("monthRentMin").get(0),(float)map.get("monthRentMax").get(0));
        if (map.containsKey("landlordPaymentAgencyFeeMax") && map.containsKey("landlordPaymentAgencyFeeMin"))
            criteria.andDepositmoneyBetween((float)map.get("landlordPaymentAgencyFeeMin").get(0),(float)map.get("landlordPaymentAgencyFeeMax").get(0));
        if (map.containsKey("totalRentMax") && map.containsKey("totalRentMin"))
            criteria.andMonthrentBetween((float)map.get("totalRentMin").get(0),(float)map.get("totalRentMax").get(0));
        if (map.containsKey("tenantPaymentAgencyFeeMax") && map.containsKey("tenantPaymentAgencyFeeMin"))
            criteria.andMonthrentBetween((float)map.get("tenantPaymentAgencyFeeMin").get(0),(float)map.get("tenantPaymentAgencyFeeMax").get(0));

        List<RentTransaction> transactionlist = rentTransactionMapper.selectByExample(suittrans).subList(0,1);
        logger.info(transactionlist.size()+"");
        //RentTransaction record = renttservice.selectRentTransactionById(1);
        System.out.println(transactionlist);
    }

    @Test
    public  void insertTrans()
    {
       // RentTransaction record = new RentTransaction();
        Map<String,Object> map = renttservice.submitTransaction(1,5);
        renttservice.confirmTransaction((Integer) map.get("transId"),"2019-01","2019-02",3);
        System.out.println("!!!!\n");
    }
}
