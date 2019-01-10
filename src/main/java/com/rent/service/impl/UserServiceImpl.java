package com.rent.service.impl;

import com.rent.common.CommonEnum;
import com.rent.common.JWTUtil;
import com.rent.dao.UserMapper;
import com.rent.entity.JWTInfo;
import com.rent.entity.User;
import com.rent.entity.UserExample;
import com.rent.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserMapper userMapper;


    @Override
    public User getExistUser(UserExample example) {
        return userMapper.selectByExample(example).get(0);
    }

    @Override
    public int insertUser(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public int updateUser(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public User selectUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> queryUser(UserExample example, int start, int end) {
        return  userMapper.selectByExample(example).subList(start,end);
    }

    @Override
    public int countUser(UserExample example) {
        return userMapper.countByExample(example);
    }

    @Override
    public Map<String,Object> checkUserLogin(User record) {
        Map<String,Object> map=new HashMap<String,Object>();
        UserExample newUser = new UserExample();
        newUser.createCriteria().andUsernicknameEqualTo(record.getUsernickname());
        newUser.createCriteria().andPasswordEqualTo(record.getPassword());
        record=getExistUser(newUser);
        logger.info("Check User Login:",record);
        if (record == null) {
            /*密码错误*/
            map.put("rescode", CommonEnum.LOGIN_FAILED.getCode());
            map.put("resmsg",CommonEnum.LOGIN_FAILED.getMsg());
            return map;
        }
        /* 密码正确 */
        JWTInfo jwtInfo = new JWTInfo();
        jwtInfo.setPassword(record.getPassword());
        jwtInfo.setUsername(record.getUsernickname());
        String jwt = JWTUtil.sign(jwtInfo, Long.valueOf(CommonEnum.JWT_MAXAGE.getMsg()));
        // 放入返回
        map.put("JWT",jwt);
        map.put("userid",record.getUserid());
        map.put("username",record.getUsernickname());
        map.put("usertype",record.getUsertype());
        map.put("rescode",CommonEnum.LOGIN_SUCCESS.getCode());
        map.put("resmsp",CommonEnum.LOGIN_SUCCESS.getMsg());
        logger.info("checkUserLogin出参:\n");
        for(Map.Entry<String,Object> entry:map.entrySet()) {
            logger.info("[", entry.getKey() + ":" + entry.getValue() + "],");
        }
        logger.info("\n");
        return map;
    }
}
