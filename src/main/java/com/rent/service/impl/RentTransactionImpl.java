package com.rent.service.impl;

import com.rent.common.CommonEnum;
import com.rent.dao.HouseMapper;
import com.rent.dao.RentTransactionMapper;
import com.rent.entity.House;
import com.rent.entity.Income;
import com.rent.entity.RentTransaction;
import com.rent.entity.RentTransactionExample;
import com.rent.service.IncomeService;
import com.rent.service.RentTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RentTransactionImpl implements RentTransactionService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM");
    @Autowired
    private RentTransactionMapper rentTransactionMapper;
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private IncomeService incomeService;

    @Override
    public int queryRentTransactionNum(Map<String, List> map) {
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
        if (map.containsKey("rentStatus"))
            criteria.andRentstatusIn(map.get("rentStatus"));
        return rentTransactionMapper.selectByExample(suittrans).size();
    }

    @Override
    public Map<String, Object> insertRentTransaction(RentTransaction record) {
        record.setTransactiondate(df.format(new Date()));
        Map<String,Object> map=new HashMap<String,Object>();
        int num = rentTransactionMapper.insertSelective(record);
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
        RentTransactionExample suithouse = new RentTransactionExample();
        List<RentTransaction> list = rentTransactionMapper.selectByExample(suithouse);
        map.put("transId",list.get(list.size()-1).getTenantid());

        return map;
    }

    @Override
    public RentTransaction selectRentTransactionById(int transactionId) {
        return rentTransactionMapper.selectByPrimaryKey(transactionId);
    }

    @Override
    public List<RentTransaction> queryRentTransaction(Map<String, List> map, int start, int end) {
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
        if (map.containsKey("rentStatus"))
            criteria.andRentstatusIn(map.get("rentStatus"));
        return rentTransactionMapper.selectByExample(suittrans).subList(start,end);
    }

    //租客提交申请
    @Override
    public Map<String,Object> submitTransaction(int houseid,int userid)
    {
        Map<String,Object> map = new HashMap<String, Object>();
        House house = houseMapper.selectByPrimaryKey(houseid);
        RentTransaction record = new RentTransaction();
        record.setHouseid(houseid);
        record.setTenantid(userid);
        record.setLandlordid(house.getPublishuserid());
        record.setDepositmoney(house.getDepositmoney());
        record.setPaymentmethod(house.getPaymentmethod());
        record.setMonthrent(house.getRentmoney());
        map = insertRentTransaction(record);
        return map;
    }

    //房东同意申请
    @Override
    public Map<String,Object> confirmTransaction(int transId,String startMonth,String endNMonth,int monthNum)
    {
        Map<String,Object> map=new HashMap<String,Object>();
        RentTransaction record = new RentTransaction();
        record.setTransactionid(transId);
        record.setTransactiondate(df.format(new Date()));
        record.setStartmonth(startMonth);
        record.setEndmonth(endNMonth);
        record.setTotalrent(selectRentTransactionById(transId).getMonthrent() * monthNum);
        record.setLandlordpaymentagencyfee((float) (record.getTotalrent()*0.03));
        record.setTenantpaymentagencyfee((float) (record.getTotalrent()*0.03));
        record.setRentstatus(1);
        int num = rentTransactionMapper.updateByPrimaryKeySelective(record);

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

        int houseid=selectRentTransactionById(transId).getHouseid();
        Income income=incomeService.queryIncomeByKey(df2.format(new Date()),houseMapper.selectByPrimaryKey(houseid).getCityname());
        int transnum=income.getTransactionnum();
        float feeincome=income.getFeeincome();
        income.setTransactionnum(transnum+1);
        income.setFeeincome(feeincome+record.getLandlordpaymentagencyfee()*2);

        map = incomeService.updateIncome(income);
        return map;
    }

    @Override
    public Map<String, Object> countTransaction(int userid, int op) {
        RentTransactionExample suittrans = new RentTransactionExample();
        if (op==0)
        {
            suittrans.or().andLandlordidIn(Collections.singletonList(userid));
        }
        else
        {
            suittrans.or().andTenantidIn(Collections.singletonList(userid));
        }
        List<RentTransaction> list = rentTransactionMapper.selectByExample(suittrans);
        Map<String,Object> map = new HashMap<String, Object>();

        int transnum=0;
        float depositnum=0,rentnum=0,feenum=0;
        for (int i=0;i<list.size();i++)
        {
            transnum++;
            depositnum+=list.get(i).getDepositmoney();
            rentnum+=list.get(i).getTotalrent();
            feenum+=list.get(i).getTenantpaymentagencyfee();
        }
        map.put("transnum",transnum);
        map.put("deppsitnum",depositnum);
        map.put("rentnum",rentnum);
        map.put("feenum",feenum);
        return map;
    }
}
