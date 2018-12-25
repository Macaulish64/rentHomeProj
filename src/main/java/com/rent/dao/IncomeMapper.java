package com.rent.dao;

import com.rent.entity.Income;
import com.rent.entity.IncomeKey;

public interface IncomeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    int deleteByPrimaryKey(IncomeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    int insert(Income record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    int insertSelective(Income record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    Income selectByPrimaryKey(IncomeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    int updateByPrimaryKeySelective(Income record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    int updateByPrimaryKey(Income record);
}