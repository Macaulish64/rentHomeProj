package com.rent.service;

import com.rent.entity.Photo;

import java.util.List;
import java.util.Map;

public interface PhotoService {
    //插入照片
    public Map<String,Object> insertPhoto(Photo record);
    //在已知照片标识的情况下，删除房屋
    public int deletePhoto(Integer photoid);
    //查找照片，从start项到end项，从0开始
    public List<Photo> queryHouse(int houseId, int start , int end);
}
