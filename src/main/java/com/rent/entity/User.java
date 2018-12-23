package com.rent.entity;

public class User {
    private int userId;
    private String userNickName;
    private String password;
    private int userType;
    private String userName;
    private int cardType;
    private String idNumber;
    private String phoneNumber;
    private int userLevel;
    private String registCity;
    private String updateTime;

    @Override
    public String toString() {
        return "User{"+
                "userId" + userId + "," +
                "userNickName" + userNickName + "," +
                "password" + password + "," +
                "userType" + userType + "," +
                "userName" + userName + "," +
                "cardType" + cardType + "," +
                "idNumber" + idNumber + "," +
                "phoneNumber" + phoneNumber + "," +
                "userLevel" + userLevel + "," +
                "registCity" + registCity + "," +
                "updateTime" + updateTime + "," +
                "}";
    }

    public int getUserId() {return userId;}
    public void setUserId(int userId) {this.userId=userId;}

    public String getUserNicknName() {return userNickName;}
    public void setuSerNickName(String userNickName) {this.userNickName=userNickName;}

    public String getPassword() {return password;}
    public void setPasserId(String password) {this.password=password;}

    public int getUserType() {return userType;}
    public void setUserType(int userType) {this.userType=userType;}






}
