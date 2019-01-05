package com.rent.dao;

import com.rent.entity.Income;
import com.rent.entity.IncomeExample;
import com.rent.entity.IncomeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IncomeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int countByExample(IncomeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int deleteByExample(IncomeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int deleteByPrimaryKey(IncomeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int insert(Income record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int insertSelective(Income record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    List<Income> selectByExample(IncomeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    Income selectByPrimaryKey(IncomeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int updateByExampleSelective(@Param("record") Income record, @Param("example") IncomeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int updateByExample(@Param("record") Income record, @Param("example") IncomeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int updateByPrimaryKeySelective(Income record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..income
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int updateByPrimaryKey(Income record);
}