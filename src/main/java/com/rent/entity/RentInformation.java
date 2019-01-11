package com.rent.entity;

public class RentInformation {
    @Override
    public String toString() {
        return "RentInformation{" +
                "rentid=" + rentid +
                ", publishuserid=" + publishuserid +
                ", cityname='" + cityname + '\'' +
                ", communityname='" + communityname + '\'' +
                ", housetype=" + housetype +
                ", floornumber=" + floornumber +
                ", elevatorornot=" + elevatorornot +
                ", housedescription='" + housedescription + '\'' +
                ", depositmoney=" + depositmoney +
                ", paymentmethod=" + paymentmethod +
                ", rentmoney=" + rentmoney +
                ", registtime='" + registtime + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..rentinformation.rentId
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private Integer rentid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..rentinformation.publishUserId
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private Integer publishuserid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..rentinformation.cityName
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private String cityname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..rentinformation.communityName
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private String communityname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..rentinformation.houseType
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private Integer housetype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..rentinformation.floorNumber
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private Integer floornumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..rentinformation.elevatorOrNot
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private Integer elevatorornot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..rentinformation.houseDescription
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private String housedescription;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..rentinformation.depositMoney
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private Float depositmoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..rentinformation.paymentMethod
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private Integer paymentmethod;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..rentinformation.rentMoney
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private Float rentmoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..rentinformation.registTime
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private String registtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..rentinformation.updateTime
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private String updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..rentinformation.rentId
     *
     * @return the value of rentsystem..rentinformation.rentId
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public Integer getRentid() {
        return rentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..rentinformation.rentId
     *
     * @param rentid the value for rentsystem..rentinformation.rentId
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setRentid(Integer rentid) {
        this.rentid = rentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..rentinformation.publishUserId
     *
     * @return the value of rentsystem..rentinformation.publishUserId
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public Integer getPublishuserid() {
        return publishuserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..rentinformation.publishUserId
     *
     * @param publishuserid the value for rentsystem..rentinformation.publishUserId
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setPublishuserid(Integer publishuserid) {
        this.publishuserid = publishuserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..rentinformation.cityName
     *
     * @return the value of rentsystem..rentinformation.cityName
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public String getCityname() {
        return cityname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..rentinformation.cityName
     *
     * @param cityname the value for rentsystem..rentinformation.cityName
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..rentinformation.communityName
     *
     * @return the value of rentsystem..rentinformation.communityName
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public String getCommunityname() {
        return communityname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..rentinformation.communityName
     *
     * @param communityname the value for rentsystem..rentinformation.communityName
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setCommunityname(String communityname) {
        this.communityname = communityname == null ? null : communityname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..rentinformation.houseType
     *
     * @return the value of rentsystem..rentinformation.houseType
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public Integer getHousetype() {
        return housetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..rentinformation.houseType
     *
     * @param housetype the value for rentsystem..rentinformation.houseType
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setHousetype(Integer housetype) {
        this.housetype = housetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..rentinformation.floorNumber
     *
     * @return the value of rentsystem..rentinformation.floorNumber
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public Integer getFloornumber() {
        return floornumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..rentinformation.floorNumber
     *
     * @param floornumber the value for rentsystem..rentinformation.floorNumber
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setFloornumber(Integer floornumber) {
        this.floornumber = floornumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..rentinformation.elevatorOrNot
     *
     * @return the value of rentsystem..rentinformation.elevatorOrNot
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public Integer getElevatorornot() {
        return elevatorornot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..rentinformation.elevatorOrNot
     *
     * @param elevatorornot the value for rentsystem..rentinformation.elevatorOrNot
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setElevatorornot(Integer elevatorornot) {
        this.elevatorornot = elevatorornot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..rentinformation.houseDescription
     *
     * @return the value of rentsystem..rentinformation.houseDescription
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public String getHousedescription() {
        return housedescription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..rentinformation.houseDescription
     *
     * @param housedescription the value for rentsystem..rentinformation.houseDescription
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setHousedescription(String housedescription) {
        this.housedescription = housedescription == null ? null : housedescription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..rentinformation.depositMoney
     *
     * @return the value of rentsystem..rentinformation.depositMoney
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public Float getDepositmoney() {
        return depositmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..rentinformation.depositMoney
     *
     * @param depositmoney the value for rentsystem..rentinformation.depositMoney
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setDepositmoney(Float depositmoney) {
        this.depositmoney = depositmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..rentinformation.paymentMethod
     *
     * @return the value of rentsystem..rentinformation.paymentMethod
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public Integer getPaymentmethod() {
        return paymentmethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..rentinformation.paymentMethod
     *
     * @param paymentmethod the value for rentsystem..rentinformation.paymentMethod
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setPaymentmethod(Integer paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..rentinformation.rentMoney
     *
     * @return the value of rentsystem..rentinformation.rentMoney
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public Float getRentmoney() {
        return rentmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..rentinformation.rentMoney
     *
     * @param rentmoney the value for rentsystem..rentinformation.rentMoney
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setRentmoney(Float rentmoney) {
        this.rentmoney = rentmoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..rentinformation.registTime
     *
     * @return the value of rentsystem..rentinformation.registTime
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public String getRegisttime() {
        return registtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..rentinformation.registTime
     *
     * @param registtime the value for rentsystem..rentinformation.registTime
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setRegisttime(String registtime) {
        this.registtime = registtime == null ? null : registtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..rentinformation.updateTime
     *
     * @return the value of rentsystem..rentinformation.updateTime
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..rentinformation.updateTime
     *
     * @param updatetime the value for rentsystem..rentinformation.updateTime
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }
}