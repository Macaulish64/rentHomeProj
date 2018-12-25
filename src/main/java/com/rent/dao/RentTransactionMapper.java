package com.rent.dao;

import com.rent.entity.RentTransaction;

public interface RentTransactionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    int deleteByPrimaryKey(Integer transactionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    int insert(RentTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    int insertSelective(RentTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    RentTransaction selectByPrimaryKey(Integer transactionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    int updateByPrimaryKeySelective(RentTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    int updateByPrimaryKey(RentTransaction record);
}