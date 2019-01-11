package com.rent.dao;

import com.rent.entity.RentTransaction;
import com.rent.entity.RentTransactionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RentTransactionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int countByExample(RentTransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int deleteByExample(RentTransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int deleteByPrimaryKey(Integer transactionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int insert(RentTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int insertSelective(RentTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    List<RentTransaction> selectByExample(RentTransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    RentTransaction selectByPrimaryKey(Integer transactionid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int updateByExampleSelective(@Param("record") RentTransaction record, @Param("example") RentTransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int updateByExample(@Param("record") RentTransaction record, @Param("example") RentTransactionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int updateByPrimaryKeySelective(RentTransaction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..renttransaction
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int updateByPrimaryKey(RentTransaction record);
}