package com.rent.service;

import com.rent.entity.Income;
import com.rent.entity.IncomeExample;

public interface IncomeService {
    int insertIncome(Income record);
    int updateIncome(Income record);
    <List>Income queryIncome(IncomeExample example);
}
