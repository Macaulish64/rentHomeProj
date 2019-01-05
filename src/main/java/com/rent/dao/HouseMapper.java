package com.rent.dao;

import com.rent.entity.House;
import com.rent.entity.HouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int countByExample(HouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int deleteByExample(HouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int deleteByPrimaryKey(Integer houseid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int insert(House record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int insertSelective(House record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    List<House> selectByExample(HouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    House selectByPrimaryKey(Integer houseid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int updateByExampleSelective(@Param("record") House record, @Param("example") HouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int updateByExample(@Param("record") House record, @Param("example") HouseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int updateByPrimaryKeySelective(House record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    int updateByPrimaryKey(House record);
}