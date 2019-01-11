package com.rent.dao;

import com.rent.entity.RentInformation;
import com.rent.entity.RentInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RentInformationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..rentinformation
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int countByExample(RentInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..rentinformation
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int deleteByExample(RentInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..rentinformation
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int deleteByPrimaryKey(Integer rentid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..rentinformation
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int insert(RentInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..rentinformation
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int insertSelective(RentInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..rentinformation
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    List<RentInformation> selectByExample(RentInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..rentinformation
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    RentInformation selectByPrimaryKey(Integer rentid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..rentinformation
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int updateByExampleSelective(@Param("record") RentInformation record, @Param("example") RentInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..rentinformation
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int updateByExample(@Param("record") RentInformation record, @Param("example") RentInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..rentinformation
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int updateByPrimaryKeySelective(RentInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rentsystem..rentinformation
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    int updateByPrimaryKey(RentInformation record);
}