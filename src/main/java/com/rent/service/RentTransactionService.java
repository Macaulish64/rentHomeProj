package com.rent.service;

import com.rent.entity.RentTransaction;
import com.rent.entity.RentTransactionExample;

import java.util.List;

public interface RentTransactionService {
    //计数
    int countRentTransaction(RentTransactionExample example);

    int insertRentTransaction(RentTransaction record);
    //查找交易记录，从start项到end项，从0开始
    List<RentTransaction> queryRentTransaction(RentTransactionExample example, int start, int end);
}