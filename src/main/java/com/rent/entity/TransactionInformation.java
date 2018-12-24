package com.rent.entity;

public class TransactionInformation {
    private int transactionId;
    private int houseId ;
    private int landlordId;
    private int tenantId ;
    private String transactionDate;
    private String startMonth;
    private String endMonth;
    private float deposit;
    private int paymentMethod;
    private float monthRent;
    private float totalRent;
    private float landlordPaymentAgencyFee;
    private float tenantPaymentAgencyFee;

    @Override
    public String toString() {
        return "TransactionInformation{" +
                "transactionId=" + transactionId +
                ", houseId=" + houseId +
                ", landlordId=" + landlordId +
                ", tenantId=" + tenantId +
                ", transactionDate='" + transactionDate + '\'' +
                ", startMonth='" + startMonth + '\'' +
                ", endMonth='" + endMonth + '\'' +
                ", deposit=" + deposit +
                ", paymentMethod=" + paymentMethod +
                ", monthRent=" + monthRent +
                ", totalRent=" + totalRent +
                ", landlordPaymentAgencyFee=" + landlordPaymentAgencyFee +
                ", tenantPaymentAgencyFee=" + tenantPaymentAgencyFee +
                '}';
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(int landlordId) {
        this.landlordId = landlordId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public float getMonthRent() {
        return monthRent;
    }

    public void setMonthRent(float monthRent) {
        this.monthRent = monthRent;
    }

    public float getTotalRent() {
        return totalRent;
    }

    public void setTotalRent(float totalRent) {
        this.totalRent = totalRent;
    }

    public float getLandlordPaymentAgencyFee() {
        return landlordPaymentAgencyFee;
    }

    public void setLandlordPaymentAgencyFee(float landlordPaymentAgencyFee) {
        this.landlordPaymentAgencyFee = landlordPaymentAgencyFee;
    }

    public float getTenantPaymentAgencyFee() {
        return tenantPaymentAgencyFee;
    }

    public void setTenantPaymentAgencyFee(float tenantPaymentAgencyFee) {
        this.tenantPaymentAgencyFee = tenantPaymentAgencyFee;
    }
}
