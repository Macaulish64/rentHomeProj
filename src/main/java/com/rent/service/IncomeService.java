package com.rent.service;

import com.rent.entity.Income;
import com.rent.entity.IncomeExample;

public interface IncomeService {

    int insertIncome(Income record);
    //在已知主键（月份+地区）的情况下，更新
    int updateIncome(Income record);
    //查询，从start项到end项，从0开始
    <List>Income queryIncome(IncomeExample example,int start,int end);
    //计数
    int countIncome(IncomeExample example);
}
