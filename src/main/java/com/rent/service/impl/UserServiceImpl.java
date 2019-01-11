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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getExistUser(UserExample example) {
        List<User> nowlistuser=userMapper.selectByExample(example);
        if (nowlistuser.size()==0) return null;
        return nowlistuser.get(0);
    }

    @Override
    public Map<String, Object> insertUser(User record) {
        record.setUpdatetime(df.format(new Date()));
        Map<String,Object> map=new HashMap<String,Object>();
        int num = userMapper.insertSelective(record);
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
        UserExample suithouse = new UserExample();
        List<User> list = userMapper.selectByExample(suithouse);
        map.put("userId",list.get(list.size()-1).getUserid());
        return map;
    }

    @Override
    public Map<String, Object> updateUser(User record) {
        record.setUpdatetime(df.format(new Date()));
        Map<String,Object> map=new HashMap<String,Object>();
        int num = userMapper.updateByPrimaryKeySelective(record);
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
        return map;
    }

    @Override
    public User selectUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Map<String, Object> updateUserPassword(int Userid, String oldpassword, String newPassword) {

        Map<String, Object> map = new HashMap<String, Object>();
        String truePassword=selectUserById(Userid).getPassword();
        //密码错误
        if (truePassword.equals(oldpassword))
        {
            User newUser = new User();
            newUser.setUserid(Userid);
            newUser.setPassword(newPassword);
            newUser.setUpdatetime(df.format(new Date()));
            int num = userMapper.updateByPrimaryKeySelective(newUser);
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
            return map;
        }
       else {
            map.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
            map.put("resmsg",CommonEnum.REQUEST_FAILED.getMsg());
            return map;
        }
    }

    @Override
    public Map<String, Object> updateUserPhonenumber(int Userid, String phonenum) {
        Map<String, Object> map = new HashMap<String, Object>();
        User newUser = new User();
        newUser.setUserid(Userid);
        newUser.setPhonenumber(phonenum);
        newUser.setUpdatetime(df.format(new Date()));
        int num = userMapper.updateByPrimaryKeySelective(newUser);
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
        return map;
    }

    @Override
    public List<User> queryUser(Map<String, List> map, int start, int end) {
        UserExample suituser = new UserExample();
        UserExample.Criteria criteria= suituser.createCriteria();
        if (map.containsKey("userId"))
            criteria.andUseridIn(map.get("userId"));
        if (map.containsKey("userNickName"))
            criteria.andUsernicknameIn(map.get("userNickName"));
        if (map.containsKey("password"))
            criteria.andPasswordIn(map.get("password"));
        if (map.containsKey("userType"))
            criteria.andUsertypeIn(map.get("userType"));
        if (map.containsKey("userName"))
            criteria.andUsernameIn(map.get("userName"));
        if (map.containsKey("cardType"))
            criteria.andCardtypeIn(map.get("cardType"));
        if (map.containsKey("idNumber"))
            criteria.andIdnumberIn(map.get("idNumber"));
        if (map.containsKey("phoneNumber"))
            criteria.andPhonenumberIn(map.get("phoneNumber"));
        if (map.containsKey("userLevel"))
            criteria.andUserlevelIn(map.get("userLevel"));
        if (map.containsKey("registCity"))
            criteria.andRegistcityIn(map.get("registCity"));

        return userMapper.selectByExample(suituser).subList(start,end);
    }

    @Override
    public int queryUserNum(Map<String, List> map) {
        UserExample suithouse = new UserExample();
        UserExample.Criteria criteria= suithouse.createCriteria();
        if (map.containsKey("userId"))
            criteria.andUseridIn(map.get("userId"));
        if (map.containsKey("userNickName"))
            criteria.andUsernicknameIn(map.get("userNickName"));
        if (map.containsKey("password"))
            criteria.andPasswordIn(map.get("password"));
        if (map.containsKey("userType"))
            criteria.andUsertypeIn(map.get("userType"));
        if (map.containsKey("userName"))
            criteria.andUsernameIn(map.get("userName"));
        if (map.containsKey("cardType"))
            criteria.andCardtypeIn(map.get("cardType"));
        if (map.containsKey("idNumber"))
            criteria.andIdnumberIn(map.get("idNumber"));
        if (map.containsKey("phoneNumber"))
            criteria.andPhonenumberIn(map.get("phoneNumber"));
        if (map.containsKey("userLevel"))
            criteria.andUserlevelIn(map.get("userLevel"));
        if (map.containsKey("registCity"))
            criteria.andRegistcityIn(map.get("registCity"));

        return userMapper.selectByExample(suithouse).size();
    }

    @Override
    public Map<String,Object> checkUserLogin(User record) {
        Map<String,Object> map=new HashMap<String,Object>();
        UserExample newUser = new UserExample();
        newUser.or().andUsernicknameEqualTo(record.getUsernickname());
        newUser.or().andPasswordEqualTo(record.getPassword());
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
        map.put("resmsg",CommonEnum.LOGIN_SUCCESS.getMsg());
        logger.info("checkUserLogin出参:\n");
        for(Map.Entry<String,Object> entry:map.entrySet()) {
            logger.info("["+entry.getKey() + ":" + entry.getValue() + "],");
        }
        logger.info("\n");
        return map;
    }
}
