package com.rent.entity;

public class IncomeKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..income.month
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    private String month;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..income.area
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    private String area;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..income.month
     *
     * @return the value of rentsystem..income.month
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public String getMonth() {
        return month;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..income.month
     *
     * @param month the value for rentsystem..income.month
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..income.area
     *
     * @return the value of rentsystem..income.area
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public String getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..income.area
     *
     * @param area the value for rentsystem..income.area
     *
     * @mbggenerated Tue Dec 25 13:12:59 CST 2018
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }
}