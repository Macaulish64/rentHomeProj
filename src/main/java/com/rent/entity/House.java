package com.rent.entity;

public class House {
    private int houseId ;
    private int publishUserId;
    private String cityName;
    private String communityName;
    private String buildingNumber;
    private int houseType;
    private int  houseArea;
    private int floorNumber;
    private int elevatorOrNot;
    private String houseDescription;
    private String housePhoto;
    private float depositMoney;
    private int paymentMethod;
    private float rentMoney;
    private String registTime;
    private String updateTime;
    private int housestatus;

    @Override
    public String toString() {
        return "House{" +
                "houseId=" + houseId +
                ", publishUserId=" + publishUserId +
                ", cityName='" + cityName + '\'' +
                ", communityName='" + communityName + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", houseType=" + houseType +
                ", houseArea=" + houseArea +
                ", floorNumber=" + floorNumber +
                ", elevatorOrNot=" + elevatorOrNot +
                ", houseDescription='" + houseDescription + '\'' +
                ", housePhoto='" + housePhoto + '\'' +
                ", depositMoney=" + depositMoney +
                ", paymentMethod=" + paymentMethod +
                ", rentMoney=" + rentMoney +
                ", registTime='" + registTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", housestatus=" + housestatus +
                '}';
    }

    public int getHouseId() {
        return houseId;
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

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public int getHouseType() {
        return houseType;
    }

    public int getHouseArea() {
        return houseArea;
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

    public String getHousePhoto() {
        return housePhoto;
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

    public int getHousestatus() {
        return housestatus;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
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

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setHouseType(int houseType) {
        this.houseType = houseType;
    }

    public void setHouseArea(int houseArea) {
        this.houseArea = houseArea;
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

    public void setHousePhoto(String housePhoto) {
        this.housePhoto = housePhoto;
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

    public void setHousestatus(int housestatus) {
        this.housestatus = housestatus;
    }
}
