package com.rent.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rent.common.CommonEnum;
import com.rent.entity.RentInformation;
import com.rent.service.RentInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("rentinformation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RentInformationController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RentInformationService rentInformationService;

    @RequestMapping(value ="/list",method = RequestMethod.POST)
    @ResponseBody
    public void rentListPageOne(@RequestParam("prideList[]") List<Integer> prideList,
                                 @RequestParam("cityList[]") List<Integer> cityList) {
        logger.info("!!!I am in Rent List Test\n");
        for(Integer i:cityList) {
            logger.info("value="+i);
        }
        for(Integer i:prideList) {
            logger.info("value="+i);
        }
//        List<House> houselist=HouseService.queryHouse(HouseExample,0,5);

    }

    @RequestMapping(value="/rentlist/{pagenumber}",method = RequestMethod.POST)
    @ResponseBody
    public String houseListPage(@PathVariable("pagenumber") int pagenumber,HttpServletRequest request)
    {
        Map<String,List> map = (Map<String,List>) request.getAttribute("map");
        int num = rentInformationService.queryRentInformationNum(map);
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
                map2.put("list",rentInformationService.queryRentInformation(map ,(pagenumber-1)*5 ,pagenumber*5));
            else
                map2.put("list",rentInformationService.queryRentInformation(map ,(pagenumber-1)*5 ,num));
        }
        String json= JSON.toJSONString(map2, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value="/details/{rentid}",method = RequestMethod.GET)
    @ResponseBody
    public String rentDetails(@PathVariable("rentid") int rentid)
    {
        RentInformation nowrent=rentInformationService.selectRentInformationById(rentid);
        Map<String ,Object> map=new HashMap<String, Object>();
        if (nowrent==null) {
            map.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
            map.put("resmsg",CommonEnum.REQUEST_FAILED.getMsg());
        }
        else {
            map.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
            map.put("resmsg", CommonEnum.REQUEST_SUCCESS.getMsg());
            map.put("rent", nowrent);
        }
        String json= JSON.toJSONString(map, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value="/addrent",method=RequestMethod.POST)
    @ResponseBody
    public String addRent(HttpServletRequest request)
    {
        RentInformation newrent = new RentInformation();
        int userid=0;
        try{
            userid = Integer.parseInt(request.getParameter("publishuserid"));
        }catch(NumberFormatException e) { }
        String cityName = request.getParameter("cityname");
        String communityName = request.getParameter("communityname");
        int houseType=0,floorNumber=0,elevatorOrNot=0,paymentMethod=0;
        String houseDescription = request.getParameter("housedescription");
        try{
            houseType = Integer.parseInt(request.getParameter("housetype"));
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

        newrent.setPublishuserid(userid);
        newrent.setCityname(cityName);
        newrent.setCommunityname(communityName);
        newrent.setHousetype(houseType);
        newrent.setFloornumber(floorNumber);
        newrent.setElevatorornot(elevatorOrNot);
        newrent.setDepositmoney(depositMoney);
        newrent.setHousedescription(houseDescription);
        newrent.setPaymentmethod(paymentMethod);
        newrent.setRentmoney(rentMoney);

        Map<String,Object> map = rentInformationService.insertRentInformation(newrent);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value="/deleterent",method=RequestMethod.POST)
    @ResponseBody
    public String deleteRent(HttpServletRequest requset)
    {
        int rentid = 0;
        try{
            rentid = Integer.parseInt(requset.getParameter("rentid"));
        }catch(NumberFormatException e) { }
        Map<String,Object> map = rentInformationService.deleteRentInformation(rentid);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value="/updaterent",method=RequestMethod.POST)
    @ResponseBody
    public String updateRent(HttpServletRequest requset)
    {
        int rentid=0;
        try{
            rentid = Integer.parseInt(requset.getParameter("rentid"));
        }catch(NumberFormatException e) { }
        RentInformation newrent = new RentInformation();
        newrent.setRentid(rentid);
        String cityName = requset.getParameter("cityname");
        String communityName = requset.getParameter("communityname");
        int houseType=0,floorNumber=0,elevatorOrNot=0,paymentMethod=0;
        String houseDescription = requset.getParameter("housedescription");
        try{
            houseType = Integer.parseInt(requset.getParameter("housetype"));
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

        newrent.setCityname(cityName);
        newrent.setCommunityname(communityName);
        newrent.setHousetype(houseType);
        newrent.setFloornumber(floorNumber);
        newrent.setElevatorornot(elevatorOrNot);
        newrent.setDepositmoney(depositMoney);
        newrent.setHousedescription(houseDescription);
        newrent.setPaymentmethod(paymentMethod);
        newrent.setRentmoney(rentMoney);

        Map<String,Object> map = rentInformationService.updateRentInformation(newrent);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value="/ownerrentlist/{userid}",method= RequestMethod.GET)
    @ResponseBody
    public String getOwnerRentList(@PathVariable("userid") int userid,
                                    HttpServletRequest request) {
        List<RentInformation> rentlist;
        Map<String, List> map=new HashMap<String, List>();
        List<Integer> publishuserlist=new ArrayList<Integer>();
        publishuserlist.add(userid);
        map.put("publishUserId",publishuserlist);
        rentlist=rentInformationService.queryRentInformation(map,0,3);
        for(RentInformation nowrent : rentlist) {//其内部实质上还是调用了迭代器遍历方式，这种循环方式还有其他限制，不建议使用。
            System.out.println(nowrent.toString());
        }
        String json= JSON.toJSONString(rentlist, SerializerFeature.WriteMapNullValue);
        return json;
    }
}
