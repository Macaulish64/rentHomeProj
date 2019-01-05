package com.rent.service.impl;

import com.rent.dao.RentTransactionMapper;
import com.rent.entity.RentTransaction;
import com.rent.entity.RentTransactionExample;
import com.rent.service.RentTransactionService;

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
    public <List> RentTransaction queryRentTransaction(RentTransactionExample example) {
        return (RentTransaction) rentTransactionMapper.selectByExample(example);
    }
}
