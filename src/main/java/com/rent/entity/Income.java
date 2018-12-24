package com.rent.entity;

public class Income {
    private String month;
    private String area;
    private int transactionNum;
    private float feeIncome;

    @Override
    public String toString() {
        return "Income{" +
                "month='" + month + '\'' +
                ", area='" + area + '\'' +
                ", transactionNum=" + transactionNum +
                ", feeIncome=" + feeIncome +
                '}';
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(int transactionNum) {
        this.transactionNum = transactionNum;
    }

    public float getFeeIncome() {
        return feeIncome;
    }

    public void setFeeIncome(float feeIncome) {
        this.feeIncome = feeIncome;
    }
}
