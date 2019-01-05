package com.rent.entity;

public class Photo {
    @Override
    public String toString() {
        return "Photo{" +
                "photoid=" + photoid +
                ", houseid=" + houseid +
                ", housephoto='" + housephoto + '\'' +
                '}';
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..photo.photoId
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    private Integer photoid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..photo.houseId
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    private Integer houseid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rentsystem..photo.housePhoto
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    private String housephoto;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..photo.photoId
     *
     * @return the value of rentsystem..photo.photoId
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    public Integer getPhotoid() {
        return photoid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..photo.photoId
     *
     * @param photoid the value for rentsystem..photo.photoId
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    public void setPhotoid(Integer photoid) {
        this.photoid = photoid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..photo.houseId
     *
     * @return the value of rentsystem..photo.houseId
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    public Integer getHouseid() {
        return houseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..photo.houseId
     *
     * @param houseid the value for rentsystem..photo.houseId
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    public void setHouseid(Integer houseid) {
        this.houseid = houseid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rentsystem..photo.housePhoto
     *
     * @return the value of rentsystem..photo.housePhoto
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    public String getHousephoto() {
        return housephoto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rentsystem..photo.housePhoto
     *
     * @param housephoto the value for rentsystem..photo.housePhoto
     *
     * @mbggenerated Sat Jan 05 21:07:16 CST 2019
     */
    public void setHousephoto(String housephoto) {
        this.housephoto = housephoto == null ? null : housephoto.trim();
    }
}