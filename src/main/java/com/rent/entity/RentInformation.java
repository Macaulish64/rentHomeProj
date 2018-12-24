package com.rent.entity;

public class RentInformation {
    private int rentId;
    private int publishUserId;
    private String cityName;
    private String communityName;
    private int houseType;
    private int floorNumber;
    private int elevatorOrNot;
    private String houseDescription;
    private float depositMoney;
    private int paymentMethod;
    private float rentMoney;
    private String registTime;
    private String updateTime;

    @Override
    public String toString() {
        return "RentInformation{" +
                "rentId=" + rentId +
                ", publishUserId=" + publishUserId +
                ", cityName='" + cityName + '\'' +
                ", communityName='" + communityName + '\'' +
                ", houseType=" + houseType +
                ", floorNumber=" + floorNumber +
                ", elevatorOrNot=" + elevatorOrNot +
                ", houseDescription='" + houseDescription + '\'' +
                ", depositMoney=" + depositMoney +
                ", paymentMethod=" + paymentMethod +
                ", rentMoney=" + rentMoney +
                ", registTime='" + registTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public int getRentId() {
        return rentId;
    }

    public int getPublishUserId() {
        return publishUserId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCommunityName() {
        return communityName;
    }

    public int getHouseType() {
        return houseType;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getElevatorOrNot() {
        return elevatorOrNot;
    }

    public String getHouseDescription() {
        return houseDescription;
    }

    public float getDepositMoney() {
        return depositMoney;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public float getRentMoney() {
        return rentMoney;
    }

    public String getRegistTime() {
        return registTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setRentId(int rentId) {
        this.rentId = rentId;
    }

    public void setPublishUserId(int publishUserId) {
        this.publishUserId = publishUserId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public void setHouseType(int houseType) {
        this.houseType = houseType;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setElevatorOrNot(int elevatorOrNot) {
        this.elevatorOrNot = elevatorOrNot;
    }

    public void setHouseDescription(String houseDescription) {
        this.houseDescription = houseDescription;
    }

    public void setDepositMoney(float depositMoney) {
        this.depositMoney = depositMoney;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setRentMoney(float rentMoney) {
        this.rentMoney = rentMoney;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
