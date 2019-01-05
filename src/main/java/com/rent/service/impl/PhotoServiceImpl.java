package com.rent.service.impl;

import com.rent.dao.PhotoMapper;
import com.rent.entity.Photo;
import com.rent.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoMapper photoMapper;

    @Override
    public int insertPhoto(Photo record) {
        return photoMapper.insertSelective(record);
    }

    @Override
    public int deletePhoto(Integer photoid) {
        return photoMapper.deleteByPrimaryKey(photoid);
    }

}
