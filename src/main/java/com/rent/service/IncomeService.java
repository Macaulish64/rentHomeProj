package com.rent.service;

import com.rent.entity.Income;

import java.util.List;
import java.util.Map;

public interface IncomeService {
    //插入
    public Map<String,Object> insertIncome(Income record);
    //在已知主键（月份+地区）的情况下，更新
    public Map<String,Object> updateIncome(Income record);
    //查询，从start项到end项，从0开始
    public List<Income> queryIncome(Map<String,List> map, int start, int end);
    //计数
    public Map<String,Object> queryIncomeNum(Map<String,List> map);
}
