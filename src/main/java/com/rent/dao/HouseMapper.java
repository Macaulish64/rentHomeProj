package com.rent.dao;

import com.rent.entity.House;

public interface HouseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Tue Dec 25 11:22:31 CST 2018
     */
    int deleteByPrimaryKey(Integer houseid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Tue Dec 25 11:22:31 CST 2018
     */
    int insert(House record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Tue Dec 25 11:22:31 CST 2018
     */
    int insertSelective(House record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Tue Dec 25 11:22:31 CST 2018
     */
    House selectByPrimaryKey(Integer houseid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Tue Dec 25 11:22:31 CST 2018
     */
    int updateByPrimaryKeySelective(House record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..house
     *
     * @mbggenerated Tue Dec 25 11:22:31 CST 2018
     */
    int updateByPrimaryKey(House record);
}