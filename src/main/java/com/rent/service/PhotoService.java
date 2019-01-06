package com.rent.service;

import com.rent.entity.Photo;
import com.rent.entity.PhotoExample;

public interface PhotoService {

    int insertPhoto(Photo record);
    //在已知照片标识的情况下，删除房屋
    int deletePhoto(Integer photoid);
    //查找照片，从start项到end项，从0开始
    <List>Photo queryHouse(PhotoExample example, int start , int end);
}
