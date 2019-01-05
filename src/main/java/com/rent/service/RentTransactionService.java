package com.rent.service;

import com.rent.entity.RentTransaction;
import com.rent.entity.RentTransactionExample;

public interface RentTransactionService {
    int countRentTransaction(RentTransactionExample example);
    int insertRentTransaction(RentTransaction record);
    <List>RentTransaction queryRentTransaction(RentTransactionExample example);
}