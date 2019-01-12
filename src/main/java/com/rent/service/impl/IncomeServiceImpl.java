package com.rent.service.impl;

import com.rent.common.CommonEnum;
import com.rent.dao.IncomeMapper;
import com.rent.entity.Income;
import com.rent.entity.IncomeExample;
import com.rent.entity.IncomeKey;
import com.rent.service.IncomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IncomeServiceImpl implements IncomeService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IncomeMapper incomeMapper;

    @Override
    public Map<String, Object> insertIncome(Income record) {
        Map<String,Object> map=new HashMap<String,Object>();
        int num = incomeMapper.insertSelective(record);
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
    public Income queryIncomeByKey(String Month, String Area) {
        IncomeKey newKey = new IncomeKey();
        newKey.setMonth(Month);
        newKey.setArea(Area);
        Income income= incomeMapper.selectByPrimaryKey(newKey);

        if (income==null)
        {
            income = new Income();
            income.setFeeincome((float) 0);
            income.setTransactionnum(0);
            income.setMonth(Month);
            income.setArea(Area);
            insertIncome(income);
            return incomeMapper.selectByPrimaryKey(newKey);
        }
        else return income;
    }

    @Override
    public Map<String, Object> updateIncome(Income record) {
        Map<String,Object> map=new HashMap<String,Object>();
        int num = incomeMapper.updateByPrimaryKeySelective(record);
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
    public List<Income> queryIncome(Map<String, List> map, int start, int end) {
        IncomeExample suitincome = new IncomeExample();
        IncomeExample.Criteria criteria= suitincome.createCriteria();
        if (map.containsKey("monthMax")&&map.containsKey("monthMin"))
            criteria.andMonthBetween((String)map.get("monthMin").get(0),(String)map.get("monthMax").get(0));
        if (map.containsKey("area"))
            criteria.andAreaIn(map.get("area"));
        if (map.containsKey("transactionNumMax") && map.containsKey("transactionNumMin"))
            criteria.andTransactionnumBetween((int)map.get("transactionNumMin").get(0),(int)map.get("transactionNumMax").get(0));
        if (map.containsKey("feeIncomeMax") && map.containsKey("feeIncomeMin"))
            criteria.andFeeincomeBetween((float)map.get("feeIncomeMin").get(0),(float)map.get("feeIncomeMax").get(0));
        return incomeMapper.selectByExample(suitincome).subList(start,end);
    }

    @Override
    public int queryIncomeNum(Map<String, List> map) {
        IncomeExample suitincome = new IncomeExample();
        IncomeExample.Criteria criteria= suitincome.createCriteria();
        if (map.containsKey("monthMax")&&map.containsKey("monthMin"))
            criteria.andMonthBetween((String)map.get("monthMin").get(0),(String)map.get("monthMax").get(0));
        if (map.containsKey("area"))
            criteria.andAreaIn(map.get("area"));
        if (map.containsKey("transactionNumMax") && map.containsKey("transactionNumMin"))
            criteria.andTransactionnumBetween((int)map.get("transactionNumMin").get(0),(int)map.get("transactionNumMax").get(0));
        if (map.containsKey("feeIncomeMax") && map.containsKey("feeIncomeMin"))
            criteria.andFeeincomeBetween((float)map.get("feeIncomeMin").get(0),(float)map.get("feeIncomeMax").get(0));
        return incomeMapper.selectByExample(suitincome).size();
    }

    @Override
    public Map<String, Object> countIncome(Map<String, List> map) {
        IncomeExample suitincome = new IncomeExample();
        IncomeExample.Criteria criteria= suitincome.createCriteria();
        if (map.containsKey("monthMax")&&map.containsKey("monthMin"))
            criteria.andMonthBetween((String)map.get("monthMin").get(0),(String)map.get("monthMax").get(0));
        if (map.containsKey("area"))
            criteria.andAreaIn(map.get("area"));
        if (map.containsKey("transactionNumMax") && map.containsKey("transactionNumMin"))
            criteria.andTransactionnumBetween((int)map.get("transactionNumMin").get(0),(int)map.get("transactionNumMax").get(0));
        if (map.containsKey("feeIncomeMax") && map.containsKey("feeIncomeMin"))
            criteria.andFeeincomeBetween((float)map.get("feeIncomeMin").get(0),(float)map.get("feeIncomeMax").get(0));
        List<Income> list=incomeMapper.selectByExample(suitincome);
        float Feeincome=0;
        int Transnum=0;
        Map<String,Object> newmap=new HashMap<String, Object>();
        for (int i=0;i<list.size();i++) {
            Feeincome+=list.get(i).getFeeincome();
            Transnum+=list.get(i).getTransactionnum();
        }
        newmap.put("transactionNum",Transnum);
        newmap.put("feeIncome",Feeincome);
        return newmap;
    }
}
