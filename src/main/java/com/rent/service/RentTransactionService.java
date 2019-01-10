package com.rent.service;

import com.rent.entity.RentTransaction;

import java.util.List;
import java.util.Map;

public interface RentTransactionService {
    //计数
    public int queryRentTransactionNum(Map<String,List> map);
    //插入
    public Map<String,Object> insertRentTransaction(RentTransaction record);
    //已知交易记录标识，查找
    public RentTransaction selectRentTransactionById(int transactionId);
    //查找交易记录，从start项到end项，从0开始
    public List<RentTransaction> queryRentTransaction(Map<String,List> map, int start, int end);
}