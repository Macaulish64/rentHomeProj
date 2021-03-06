package com.rent.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rent.common.CommonEnum;
import com.rent.entity.House;
import com.rent.entity.Photo;
import com.rent.service.HouseService;
import com.rent.service.PhotoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("house")
@CrossOrigin(origins = "*", maxAge = 3600)
public class HouseController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private HouseService houseService;
    @Autowired
    private PhotoService photoService;

    @RequestMapping(value="/list",method = RequestMethod.GET)
    @ResponseBody
    public String houseListPage(HttpServletRequest request)
    {
        //if ()
        //String str=(request.getAttribute("map")).toString();
        logger.info("=========================================================");
        String aaa=request.getParameter("map");
        logger.info(aaa);
        Map<String, List> map = (Map<String,List>) JSON.parse(aaa);
        int numlist = houseService.queryHouseNum(map);
        Map<String ,Object> map2=new HashMap<String, Object>();
        map2.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
        map2.put("resmsg", CommonEnum.REQUEST_SUCCESS.getMsg());
        map2.put("list",houseService.queryHouse(map ,0,numlist));
        String json= JSON.toJSONString(map2, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value="/searchbar",method=RequestMethod.GET)
    @ResponseBody
    public String searchBar(HttpServletRequest request)throws UnsupportedEncodingException
    {
        //if ()
        request.setCharacterEncoding("UTF-8");
        logger.info("=========================================================");
        String search =request.getParameter("search");
        //search=java.net.URLDecoder.decode(search, "UTF-8");
        logger.info("houselist request(search bar)"+search+java.net.URLDecoder.decode(search, "UTF-8"));
        search=java.net.URLDecoder.decode(search, "UTF-8");
        List<House> list = houseService.searchBar(search);
        Map<String ,Object> map2=new HashMap<String, Object>();
        map2.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
        map2.put("resmsg", CommonEnum.REQUEST_SUCCESS.getMsg());
        map2.put("list",list);
        String json= JSON.toJSONString(map2, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value="/houselist/{pagenumber}",method = RequestMethod.GET)
    @ResponseBody
    public String houseListPage(@PathVariable("pagenumber") int pagenumber,
                                HttpServletRequest request)
    {
        logger.info("=========================================================");
        logger.info("houselist request(JSON)");
        String aaa = request.getParameter("map");
        Map<String,List> map = (Map<String,List>) JSON.parse(aaa);
        int num = houseService.queryHouseNum(map);
        Map<String ,Object> map2=new HashMap<String, Object>();
        if (num < (pagenumber - 1) * 5 + 1)
        {
            map2.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
            map2.put("resmsg",CommonEnum.REQUEST_FAILED.getMsg());
        }
        else
        {
            map2.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
            map2.put("resmsg", CommonEnum.REQUEST_SUCCESS.getMsg());
            if (num > pagenumber * 5)
                map2.put("list",houseService.queryHouse(map ,(pagenumber-1)*5 ,pagenumber*5));
            else
                map2.put("list",houseService.queryHouse(map ,(pagenumber-1)*5 ,num));
        }
        String json= JSON.toJSONString(map2, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value="/details/{houseid}",method = RequestMethod.GET)
    @ResponseBody
    public String houseDetails(@PathVariable("houseid") int houseid)
    {
        House nowhouse=houseService.selectHouseById(houseid);
        Map<String ,Object> map=new HashMap<String, Object>();
        if (nowhouse==null) {
            map.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
            map.put("resmsg",CommonEnum.REQUEST_FAILED.getMsg());
        }
        else {
            map.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
            map.put("resmsg", CommonEnum.REQUEST_SUCCESS.getMsg());
            map.put("house", nowhouse);
        }
        String json= JSON.toJSONString(map, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value="/addhouse",method=RequestMethod.POST)
    @ResponseBody
    public String addHouse(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        int publishUserId=0;
        try{
            publishUserId = Integer.parseInt(request.getParameter("publishuserid"));
        }catch(NumberFormatException e) { }
        House newhouse = new House();
        newhouse.setPublishuserid(publishUserId);
        String cityName = request.getParameter("cityname");
        String communityName = request.getParameter("communityname");
        int houseType=0,floorNumber=0,elevatorOrNot=0,paymentMethod=0,houseArea = 0;
        int photoNum= 0;
        String buildingNumber = request.getParameter("buildingnumber");
        String houseDescription = request.getParameter("housedescription");
        try{
            houseType = Integer.parseInt(request.getParameter("housetype"));
        }catch(NumberFormatException e) { }
        try{
            houseArea = Integer.parseInt(request.getParameter("housearea"));
        }catch(NumberFormatException e) { }
        try{
            floorNumber = Integer.parseInt(request.getParameter("floornumber"));
        }catch(NumberFormatException e) { }
        try{
            elevatorOrNot = Integer.parseInt(request.getParameter("elevatorornot"));
        }catch(NumberFormatException e) { }
        try{
            paymentMethod = Integer.parseInt(request.getParameter("paymentmethod"));
        }catch(NumberFormatException e) { }
        float depositMoney = 0, rentMoney =0;
        try{
            depositMoney = Float.parseFloat(request.getParameter("depositmoney"));
        }catch(NumberFormatException e) { }
        try{
            rentMoney = Float.parseFloat(request.getParameter("rentmoney"));
        }catch(NumberFormatException e) { }
        try{
            photoNum = Integer.parseInt(request.getParameter("photonum"));
        }catch(NumberFormatException e) { }

        newhouse.setCityname(cityName);
        newhouse.setCommunityname(communityName);
        newhouse.setBuildingnumber(buildingNumber);
        newhouse.setHousetype(houseType);
        newhouse.setFloornumber(floorNumber);
        newhouse.setHousearea(houseArea);
        newhouse.setElevatorornot(elevatorOrNot);
        newhouse.setDepositmoney(depositMoney);
        newhouse.setHousedescription(houseDescription);
        newhouse.setPaymentmethod(paymentMethod);
        newhouse.setRentmoney(rentMoney);
        newhouse.setPhotonum(photoNum);

        Map<String,Object> map = houseService.insertHouse(newhouse);

        if((Integer) map.get("rescode") == 10004)
            return JSON.toJSONString(map);

        if (photoNum!=0)
        {
            List list = (List) request.getAttribute("photolist");
            Photo photo = new Photo();
            photo.setHouseid((Integer) map.get("houseId"));
            for (int i=0;i<list.size();i++)
            {
                photo.setHousephoto((String) list.get(i));
                photoService.insertPhoto(photo);
            }
        }
        return JSON.toJSONString(map);
    }

    @RequestMapping(value="/deletehouse",method=RequestMethod.POST)
    @ResponseBody
    public String deleteHouse(HttpServletRequest requset)
    {
        int houseid = 0;
        try{
            houseid = Integer.parseInt(requset.getParameter("houseid"));
        }catch(NumberFormatException e) { }
        Map<String,Object> map = houseService.deleteHouse(houseid);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value="/updatehouse",method=RequestMethod.POST)
    @ResponseBody
    public String updateHouse(HttpServletRequest requset)
    {
        int houseid=0;
        try{
            houseid = Integer.parseInt(requset.getParameter("houseid"));
        }catch(NumberFormatException e) { }
        House newhouse = new House();
        newhouse.setHouseid(houseid);
        String cityName = requset.getParameter("cityname");
        String communityName = requset.getParameter("communityname");
        int houseType=0,floorNumber=0,elevatorOrNot=0,paymentMethod=0,houseArea = 0;
        String buildingNumber = requset.getParameter("buildingnumber");
        String houseDescription = requset.getParameter("housedescription");
        try{
            houseType = Integer.parseInt(requset.getParameter("housetype"));
        }catch(NumberFormatException e) { }
        try{
            houseArea = Integer.parseInt(requset.getParameter("housearea"));
        }catch(NumberFormatException e) { }
        try{
            floorNumber = Integer.parseInt(requset.getParameter("floornumber"));
        }catch(NumberFormatException e) { }
        try{
            elevatorOrNot = Integer.parseInt(requset.getParameter("elevatorornot"));
        }catch(NumberFormatException e) { }
        try{
            paymentMethod = Integer.parseInt(requset.getParameter("paymentmethod"));
        }catch(NumberFormatException e) { }
        float depositMoney = 0, rentMoney =0;
        try{
            depositMoney = Float.parseFloat(requset.getParameter("depositmoney"));
        }catch(NumberFormatException e) { }
        try{
            rentMoney = Float.parseFloat(requset.getParameter("rentmoney"));
        }catch(NumberFormatException e) { }

        newhouse.setCityname(cityName);
        newhouse.setCommunityname(communityName);
        newhouse.setBuildingnumber(buildingNumber);
        newhouse.setHousetype(houseType);
        newhouse.setFloornumber(floorNumber);
        newhouse.setHousearea(houseArea);
        newhouse.setElevatorornot(elevatorOrNot);
        newhouse.setDepositmoney(depositMoney);
        newhouse.setHousedescription(houseDescription);
        newhouse.setPaymentmethod(paymentMethod);
        newhouse.setRentmoney(rentMoney);

        Map<String,Object> map = houseService.updateHouse(newhouse);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value="/ownerhouselist/{userid}",method=RequestMethod.GET)
    @ResponseBody
    public String getOwnerHouseList(@PathVariable("userid") int userid) {
        List<House> houselist;
        Map<String,List> map=new HashMap<String, List>();
        List<Integer> publishuserlist=new ArrayList<Integer>();
        publishuserlist.add(userid);
        map.put("publishUserId",publishuserlist);
        int listlen=houseService.queryHouseNum(map);
        houselist=houseService.queryHouse(map,0,listlen);
        for(House nowhouse : houselist) {//其内部实质上还是调用了迭代器遍历方式，这种循环方式还有其他限制，不建议使用。
            System.out.println(nowhouse.toString());
        }
        String json= JSON.toJSONString(houselist, SerializerFeature.WriteMapNullValue);
        return json;
    }


}
