package com.rent.service.impl;

import com.rent.dao.RentTransactionMapper;
import com.rent.entity.RentTransaction;
import com.rent.entity.RentTransactionExample;
import com.rent.service.RentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentTransactionImpl implements RentTransactionService {
    @Autowired
    private RentTransactionMapper rentTransactionMapper;

    @Override
    public int insertRentTransaction(RentTransaction record) {
        return rentTransactionMapper.insertSelective(record);
    }


    @Override
    public <List> RentTransaction queryRentTransaction(RentTransactionExample example) {
        return (RentTransaction) rentTransactionMapper.selectByExample(example);
    }
}
