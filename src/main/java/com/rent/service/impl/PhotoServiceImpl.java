package com.rent.service.impl;

import com.rent.dao.PhotoMapper;
import com.rent.entity.Photo;
import com.rent.entity.PhotoExample;
import com.rent.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Photo> queryHouse(PhotoExample example, int start, int end) {
        return  photoMapper.selectByExample(example).subList(start,end);
    }

}
