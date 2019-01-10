package com.rent.service.impl;

import com.rent.common.CommonEnum;
import com.rent.dao.PhotoMapper;
import com.rent.entity.Photo;
import com.rent.entity.PhotoExample;
import com.rent.service.PhotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PhotoServiceImpl implements PhotoService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PhotoMapper photoMapper;


    @Override
    public Map<String, Object> insertPhoto(Photo record) {
        Map<String,Object> map=new HashMap<String,Object>();
        int num = photoMapper.insertSelective(record);
        //失败
        if (num==0)
        {
            map.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
            map.put("resmsg",CommonEnum.REQUEST_FAILED.getMsg());
            return map;
        }
        //成功
        map.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
        map.put("resmsg",CommonEnum.REQUEST_SUCCESS.getMsg());
        PhotoExample suithouse = new PhotoExample();
        List<Photo> list = photoMapper.selectByExample(suithouse);
        map.put("photoId",list.get(list.size()-1).getPhotoid());
        return map;
    }

    @Override
    public int deletePhoto(Integer photoid) {
        return photoMapper.deleteByPrimaryKey(photoid);
    }

    @Override
    public List<Photo> queryHouse(int houseId, int start, int end) {
        PhotoExample suitphoto = new PhotoExample();
        suitphoto.or().andHouseidEqualTo(houseId);
        return photoMapper.selectByExample(suitphoto).subList(start,end);
    }
}
