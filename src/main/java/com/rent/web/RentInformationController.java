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
@RequestMapping("rentInformation")
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
    public String rentListPage(HttpServletRequest request)
    {
        return "";
    }



    @RequestMapping(value="/details/{rentid}",method = RequestMethod.GET)
    @ResponseBody
    public String rentDetails(@PathVariable("rentid") int rentid)
    {
        RentInformation nowrent=rentInformationService.selectRentInformationById(rentid);
        Map<String ,Object> map=new HashMap<>();
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
            userid = Integer.parseInt(request.getParameter("publishUserId"));
        }catch(NumberFormatException e) { }
        String cityName = request.getParameter("cityName");
        String communityName = request.getParameter("communityName");
        int houseType=0,floorNumber=0,elevatorOrNot=0,paymentMethod=0;
        String houseDescription = request.getParameter("houseDescription");
        try{
            houseType = Integer.parseInt(request.getParameter("houseType"));
        }catch(NumberFormatException e) { }
        try{
            floorNumber = Integer.parseInt(request.getParameter("floorNumber"));
        }catch(NumberFormatException e) { }
        try{
            elevatorOrNot = Integer.parseInt(request.getParameter("elevatorOrNot"));
        }catch(NumberFormatException e) { }
        try{
            paymentMethod = Integer.parseInt(request.getParameter("paymentMethod"));
        }catch(NumberFormatException e) { }
        float depositMoney = 0, rentMoney =0;
        try{
            depositMoney = Float.parseFloat(request.getParameter("depositMoney"));
        }catch(NumberFormatException e) { }
        try{
            rentMoney = Float.parseFloat(request.getParameter("rentMoney"));
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
        return "";
    }

    @RequestMapping(value="/updaterent",method=RequestMethod.POST)
    @ResponseBody
    public String updateRent(HttpServletRequest requset)
    {
        int rentid=0;
        try{
            rentid = Integer.parseInt(requset.getParameter("rentId"));
        }catch(NumberFormatException e) { }
        RentInformation newrent = new RentInformation();
        newrent.setRentid(rentid);
        String cityName = requset.getParameter("cityName");
        String communityName = requset.getParameter("communityName");
        int houseType=0,floorNumber=0,elevatorOrNot=0,paymentMethod=0;
        String houseDescription = requset.getParameter("houseDescription");
        try{
            houseType = Integer.parseInt(requset.getParameter("houseType"));
        }catch(NumberFormatException e) { }
        try{
            floorNumber = Integer.parseInt(requset.getParameter("floorNumber"));
        }catch(NumberFormatException e) { }
        try{
            elevatorOrNot = Integer.parseInt(requset.getParameter("elevatorOrNot"));
        }catch(NumberFormatException e) { }
        try{
            paymentMethod = Integer.parseInt(requset.getParameter("paymentMethod"));
        }catch(NumberFormatException e) { }
        float depositMoney = 0, rentMoney =0;
        try{
            depositMoney = Float.parseFloat(requset.getParameter("depositMoney"));
        }catch(NumberFormatException e) { }
        try{
            rentMoney = Float.parseFloat(requset.getParameter("rentMoney"));
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
    public String getOwnerHouseList(@PathVariable("userid") int userid,
                                    HttpServletRequest request) {
        List<RentInformation> rentlist;
        Map<String, List> map=new HashMap<>();
        List<Integer> publishuserlist=new ArrayList<>();
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
