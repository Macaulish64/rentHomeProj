package com.rent.entity;

public class RentTransaction {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..renttransaction.transactionId
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    private Integer transactionid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..renttransaction.houseId
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    private Integer houseid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..renttransaction.landlordId
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    private Integer landlordid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..renttransaction.tenantId
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    private Integer tenantid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..renttransaction.transactionDate
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    private String transactiondate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..renttransaction.startMonth
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    private String startmonth;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..renttransaction.endMonth
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    private String endmonth;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..renttransaction.deposit
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    private Float deposit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..renttransaction.paymentMethod
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    private Integer paymentmethod;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..renttransaction.monthRent
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    private Float monthrent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..renttransaction.totalRent
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    private Float totalrent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..renttransaction.landlordPaymentAgencyFee
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    private Float landlordpaymentagencyfee;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..renttransaction.tenantPaymentAgencyFee
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    private Float tenantpaymentagencyfee;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..renttransaction.transactionId
     *
     * @return the value of rentsystem..renttransaction.transactionId
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public Integer getTransactionid() {
        return transactionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..renttransaction.transactionId
     *
     * @param transactionid the value for rentsystem..renttransaction.transactionId
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public void setTransactionid(Integer transactionid) {
        this.transactionid = transactionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..renttransaction.houseId
     *
     * @return the value of rentsystem..renttransaction.houseId
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public Integer getHouseid() {
        return houseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..renttransaction.houseId
     *
     * @param houseid the value for rentsystem..renttransaction.houseId
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public void setHouseid(Integer houseid) {
        this.houseid = houseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..renttransaction.landlordId
     *
     * @return the value of rentsystem..renttransaction.landlordId
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public Integer getLandlordid() {
        return landlordid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..renttransaction.landlordId
     *
     * @param landlordid the value for rentsystem..renttransaction.landlordId
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public void setLandlordid(Integer landlordid) {
        this.landlordid = landlordid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..renttransaction.tenantId
     *
     * @return the value of rentsystem..renttransaction.tenantId
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public Integer getTenantid() {
        return tenantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..renttransaction.tenantId
     *
     * @param tenantid the value for rentsystem..renttransaction.tenantId
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public void setTenantid(Integer tenantid) {
        this.tenantid = tenantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..renttransaction.transactionDate
     *
     * @return the value of rentsystem..renttransaction.transactionDate
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public String getTransactiondate() {
        return transactiondate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..renttransaction.transactionDate
     *
     * @param transactiondate the value for rentsystem..renttransaction.transactionDate
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public void setTransactiondate(String transactiondate) {
        this.transactiondate = transactiondate == null ? null : transactiondate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..renttransaction.startMonth
     *
     * @return the value of rentsystem..renttransaction.startMonth
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public String getStartmonth() {
        return startmonth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..renttransaction.startMonth
     *
     * @param startmonth the value for rentsystem..renttransaction.startMonth
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public void setStartmonth(String startmonth) {
        this.startmonth = startmonth == null ? null : startmonth.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..renttransaction.endMonth
     *
     * @return the value of rentsystem..renttransaction.endMonth
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public String getEndmonth() {
        return endmonth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..renttransaction.endMonth
     *
     * @param endmonth the value for rentsystem..renttransaction.endMonth
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public void setEndmonth(String endmonth) {
        this.endmonth = endmonth == null ? null : endmonth.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..renttransaction.deposit
     *
     * @return the value of rentsystem..renttransaction.deposit
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public Float getDeposit() {
        return deposit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..renttransaction.deposit
     *
     * @param deposit the value for rentsystem..renttransaction.deposit
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public void setDeposit(Float deposit) {
        this.deposit = deposit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..renttransaction.paymentMethod
     *
     * @return the value of rentsystem..renttransaction.paymentMethod
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public Integer getPaymentmethod() {
        return paymentmethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..renttransaction.paymentMethod
     *
     * @param paymentmethod the value for rentsystem..renttransaction.paymentMethod
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public void setPaymentmethod(Integer paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..renttransaction.monthRent
     *
     * @return the value of rentsystem..renttransaction.monthRent
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public Float getMonthrent() {
        return monthrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..renttransaction.monthRent
     *
     * @param monthrent the value for rentsystem..renttransaction.monthRent
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public void setMonthrent(Float monthrent) {
        this.monthrent = monthrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..renttransaction.totalRent
     *
     * @return the value of rentsystem..renttransaction.totalRent
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public Float getTotalrent() {
        return totalrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..renttransaction.totalRent
     *
     * @param totalrent the value for rentsystem..renttransaction.totalRent
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public void setTotalrent(Float totalrent) {
        this.totalrent = totalrent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..renttransaction.landlordPaymentAgencyFee
     *
     * @return the value of rentsystem..renttransaction.landlordPaymentAgencyFee
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public Float getLandlordpaymentagencyfee() {
        return landlordpaymentagencyfee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..renttransaction.landlordPaymentAgencyFee
     *
     * @param landlordpaymentagencyfee the value for rentsystem..renttransaction.landlordPaymentAgencyFee
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public void setLandlordpaymentagencyfee(Float landlordpaymentagencyfee) {
        this.landlordpaymentagencyfee = landlordpaymentagencyfee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..renttransaction.tenantPaymentAgencyFee
     *
     * @return the value of rentsystem..renttransaction.tenantPaymentAgencyFee
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public Float getTenantpaymentagencyfee() {
        return tenantpaymentagencyfee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..renttransaction.tenantPaymentAgencyFee
     *
     * @param tenantpaymentagencyfee the value for rentsystem..renttransaction.tenantPaymentAgencyFee
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public void setTenantpaymentagencyfee(Float tenantpaymentagencyfee) {
        this.tenantpaymentagencyfee = tenantpaymentagencyfee;
    }
}