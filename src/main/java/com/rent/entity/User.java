package com.rent.entity;

public class User {
    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", usernickname='" + usernickname + '\'' +
                ", password='" + password + '\'' +
                ", usertype=" + usertype +
                ", username='" + username + '\'' +
                ", cardtype=" + cardtype +
                ", idnumber='" + idnumber + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", userlevel=" + userlevel +
                ", registcity='" + registcity + '\'' +
                ", updatetime='" + updatetime + '\'' +
                '}';
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..user.userId
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..user.userNickName
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private String usernickname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..user.password
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..user.userType
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private Integer usertype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..user.userName
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..user.cardType
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private Integer cardtype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..user.idNumber
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private String idnumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..user.phoneNumber
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private String phonenumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..user.userLevel
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private Integer userlevel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..user.registCity
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private String registcity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..user.updateTime
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    private String updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..user.userId
     *
     * @return the value of rentsystem..user.userId
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..user.userId
     *
     * @param userid the value for rentsystem..user.userId
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..user.userNickName
     *
     * @return the value of rentsystem..user.userNickName
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public String getUsernickname() {
        return usernickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..user.userNickName
     *
     * @param usernickname the value for rentsystem..user.userNickName
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setUsernickname(String usernickname) {
        this.usernickname = usernickname == null ? null : usernickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..user.password
     *
     * @return the value of rentsystem..user.password
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..user.password
     *
     * @param password the value for rentsystem..user.password
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..user.userType
     *
     * @return the value of rentsystem..user.userType
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public Integer getUsertype() {
        return usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..user.userType
     *
     * @param usertype the value for rentsystem..user.userType
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..user.userName
     *
     * @return the value of rentsystem..user.userName
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..user.userName
     *
     * @param username the value for rentsystem..user.userName
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..user.cardType
     *
     * @return the value of rentsystem..user.cardType
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public Integer getCardtype() {
        return cardtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..user.cardType
     *
     * @param cardtype the value for rentsystem..user.cardType
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setCardtype(Integer cardtype) {
        this.cardtype = cardtype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..user.idNumber
     *
     * @return the value of rentsystem..user.idNumber
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public String getIdnumber() {
        return idnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..user.idNumber
     *
     * @param idnumber the value for rentsystem..user.idNumber
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..user.phoneNumber
     *
     * @return the value of rentsystem..user.phoneNumber
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..user.phoneNumber
     *
     * @param phonenumber the value for rentsystem..user.phoneNumber
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..user.userLevel
     *
     * @return the value of rentsystem..user.userLevel
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public Integer getUserlevel() {
        return userlevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..user.userLevel
     *
     * @param userlevel the value for rentsystem..user.userLevel
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setUserlevel(Integer userlevel) {
        this.userlevel = userlevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..user.registCity
     *
     * @return the value of rentsystem..user.registCity
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public String getRegistcity() {
        return registcity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..user.registCity
     *
     * @param registcity the value for rentsystem..user.registCity
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setRegistcity(String registcity) {
        this.registcity = registcity == null ? null : registcity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..user.updateTime
     *
     * @return the value of rentsystem..user.updateTime
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..user.updateTime
     *
     * @param updatetime the value for rentsystem..user.updateTime
     *
     * @mbggenerated Fri Jan 11 18:01:24 CST 2019
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }
}