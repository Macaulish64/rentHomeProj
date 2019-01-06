package com.rent.service.impl;

import com.rent.dao.RentTransactionMapper;
import com.rent.entity.RentTransaction;
import com.rent.entity.RentTransactionExample;
import com.rent.service.RentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTransactionImpl implements RentTransactionService {
    @Autowired
    private RentTransactionMapper rentTransactionMapper;

    @Override
    public int countRentTransaction(RentTransactionExample example) {
        return rentTransactionMapper.countByExample(example);
    }

    @Override
    public int insertRentTransaction(RentTransaction record) {
        return rentTransactionMapper.insertSelective(record);
    }

    @Override
    public RentTransaction selectRentTransactionById(int transactionId) {
        return rentTransactionMapper.selectByPrimaryKey(transactionId);
    }


    @Override
    public List<RentTransaction> queryRentTransaction(RentTransactionExample example, int start, int end) {
        return  rentTransactionMapper.selectByExample(example).subList(start,end);
    }
}
