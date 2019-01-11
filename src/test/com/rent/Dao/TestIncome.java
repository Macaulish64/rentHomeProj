package com.rent.Dao;

import com.rent.BaseTest;
import com.rent.dao.IncomeMapper;
import com.rent.service.IncomeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestIncome extends BaseTest {
    @Autowired
    private IncomeMapper incomeMapper;

    @Autowired
    private IncomeService incomeService;

    @Test
    public void queryincome() {
        Map<String, List> map = new HashMap<String,List>();
        List list1 = new ArrayList();
        List list2 = new ArrayList();

        list1.add("2018-12");
        list2.add("2019-01");
        map.put("monthMin",list1);
        map.put("monthMax",list2);

        System.out.println(incomeService.queryIncome(map,0,1));
    }
}
