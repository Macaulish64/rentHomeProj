package com.rent.Dao;

import com.rent.BaseTest;
import com.rent.dao.IncomeMapper;
import com.rent.entity.Income;
import com.rent.entity.IncomeKey;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestIncome extends BaseTest {
    @Autowired
    private IncomeMapper incomeMapper;

    @Test
    public void queryincome() {
        IncomeKey newKey = new IncomeKey();
        newKey.setMonth("2018-12");
        newKey.setArea("上海");
        Income income = incomeMapper.selectByPrimaryKey(newKey);

        if (income == null) {
            income = new Income();
            income.setFeeincome((float) 0);
            income.setTransactionnum(0);
            income.setMonth("2018-12");
            income.setArea("上海");
            incomeMapper.insertSelective(income);
        }
        System.out.println("!!!!\n");
    }
}
