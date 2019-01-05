package com.rent.service.impl;

import com.rent.dao.IncomeMapper;
import com.rent.entity.Income;
import com.rent.entity.IncomeExample;
import com.rent.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    private IncomeMapper incomeMapper;

    @Override
    public int insertIncome(Income record) {
        return incomeMapper.insertSelective(record);
    }

    @Override
    public int updateIncome(Income record) {
        return incomeMapper.updateByPrimaryKey(record);
    }

    @Override
    public <List> Income queryIncome(IncomeExample example) {
        return (Income) incomeMapper.selectByExample(example);
    }
}