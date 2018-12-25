package com.rent.entity;

public class Income extends IncomeKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..income.transactionNum
     *
     * @mbggenerated Tue Dec 25 11:32:42 CST 2018
     */
    private Integer transactionnum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..income.feeIncome
     *
     * @mbggenerated Tue Dec 25 11:32:42 CST 2018
     */
    private Float feeincome;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..income.transactionNum
     *
     * @return the value of rentsystem..income.transactionNum
     *
     * @mbggenerated Tue Dec 25 11:32:42 CST 2018
     */
    public Integer getTransactionnum() {
        return transactionnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..income.transactionNum
     *
     * @param transactionnum the value for rentsystem..income.transactionNum
     *
     * @mbggenerated Tue Dec 25 11:32:42 CST 2018
     */
    public void setTransactionnum(Integer transactionnum) {
        this.transactionnum = transactionnum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..income.feeIncome
     *
     * @return the value of rentsystem..income.feeIncome
     *
     * @mbggenerated Tue Dec 25 11:32:42 CST 2018
     */
    public Float getFeeincome() {
        return feeincome;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..income.feeIncome
     *
     * @param feeincome the value for rentsystem..income.feeIncome
     *
     * @mbggenerated Tue Dec 25 11:32:42 CST 2018
     */
    public void setFeeincome(Float feeincome) {
        this.feeincome = feeincome;
    }
}