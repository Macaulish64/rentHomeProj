package com.rent.service;

import com.rent.entity.RentTransaction;

import java.util.List;
import java.util.Map;

public interface RentTransactionService {
    //计数
    public int queryRentTransactionNum(Map<String, List> map);

    //插入
    public Map<String, Object> insertRentTransaction(RentTransaction record);

    //已知交易记录标识，查找
    public RentTransaction selectRentTransactionById(int transactionId);

    //查找交易记录，从start项到end项，从0开始
    public List<RentTransaction> queryRentTransaction(Map<String, List> map, int start, int end);

    //租客提交申请
    public Map<String,Object> submitTransaction(int houseid,int userid,String startMonth,String endNMonth,int monthNum);

    //房东同意申请
    public Map<String,Object> confirmTransaction(int transId);

    //op为0表示房东，op为1表示租客
    public Map<String,Object> countTransaction(int userid,int op);

    //done,use queryRentTransaction
    //对于房东,查找已经交易的记录
    //rentstate=1
    //对于房东,查找还没交易的记录
    //rentstate=0
    //对于房客,查找还没交易的记录
    //rentstate=1
    //对于房客,查找已经交易的记录
    //rentstate=0
    //对于管理员,查找已经交易的记录
    //rentstate=1
    //对于管理员,查找所有记录
    //rentstate=0,1
    //对于管理员,查找已交易的记录
    //rentstate=1
    //对于管理员,查找未交易的记录
    //rentstate=0
}