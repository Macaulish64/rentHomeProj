package com.rent.service;

import com.rent.entity.Photo;

public interface PhotoService {
    int insertPhoto(Photo record);
    int deletePhoto(Integer photoid);
}
