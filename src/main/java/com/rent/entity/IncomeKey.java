package com.rent.entity;

public class IncomeKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..income.month
     *
     * @mbggenerated Sat Jan 05 18:32:55 CST 2019
     */
    private String month;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..income.area
     *
     * @mbggenerated Sat Jan 05 18:32:55 CST 2019
     */
    private String area;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..income.month
     *
     * @return the value of rentsystem..income.month
     *
     * @mbggenerated Sat Jan 05 18:32:55 CST 2019
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
     * @mbggenerated Sat Jan 05 18:32:55 CST 2019
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
     * @mbggenerated Sat Jan 05 18:32:55 CST 2019
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
     * @mbggenerated Sat Jan 05 18:32:55 CST 2019
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }
}