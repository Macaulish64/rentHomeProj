package com.rent.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rent.common.CommonEnum;
import com.rent.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("adminindex")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdminindexController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    IncomeService incomeService;
    @Autowired
    UserService userService;
    @Autowired
    HouseService houseService;
    @Autowired
    RentInformationService rentInformationService;
    @Autowired
    RentTransactionService rentTransactionService;

    @RequestMapping(value = "adminuserlist/{pagenumber}", method = RequestMethod.POST)
    @ResponseBody
    public String adminUserPage(@PathVariable("pagenumber") int pagenumber, HttpServletRequest request)
    {
        Map<String, List> map = (Map<String,List>) request.getAttribute("map");
        int num = userService.queryUserNum(map);
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
                map2.put("list",userService.queryUser(map ,(pagenumber-1)*5 ,pagenumber*5));
            else
                map2.put("list",userService.queryUser(map ,(pagenumber-1)*5 ,num));
        }
        String json= JSON.toJSONString(map2, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "adminhouselist/{pagenumber}", method = RequestMethod.POST)
    @ResponseBody
    public String adminHousePage(@PathVariable("pagenumber") int pagenumber, HttpServletRequest request)
    {
        Map<String, List> map = (Map<String,List>) request.getAttribute("map");
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

    @RequestMapping(value = "adminrentlist/{pagenumber}", method = RequestMethod.POST)
    @ResponseBody
    public String adminRentPage(@PathVariable("pagenumber") int pagenumber, HttpServletRequest request)
    {
        Map<String, List> map = (Map<String,List>) request.getAttribute("map");
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

    @RequestMapping(value = "admintranslist/{pagenumber}", method = RequestMethod.POST)
    @ResponseBody
    public String adminTransPage(@PathVariable("pagenumber") int pagenumber, HttpServletRequest request)
    {
        Map<String, List> map = (Map<String,List>) request.getAttribute("map");
        int num = rentTransactionService.queryRentTransactionNum(map);
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
                map2.put("list",rentTransactionService.queryRentTransaction(map ,(pagenumber-1)*5 ,pagenumber*5));
            else
                map2.put("list",rentTransactionService.queryRentTransaction(map ,(pagenumber-1)*5 ,num));
        }
        String json= JSON.toJSONString(map2, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "adminincomelist/{pagenumber}", method = RequestMethod.POST)
    @ResponseBody
    public String adminIncomePage(@PathVariable("pagenumber") int pagenumber, HttpServletRequest request)
    {
        Map<String, List> map = (Map<String,List>) request.getAttribute("map");
        int num = incomeService.queryIncomeNum(map);
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
                map2.put("list",incomeService.queryIncome(map ,(pagenumber-1)*5 ,pagenumber*5));
            else
                map2.put("list",incomeService.queryIncome(map ,(pagenumber-1)*5 ,num));

            Map<String,Object> map3 = incomeService.countIncome(map);
            map2.put("transactionNum",map3.get("transactionNum"));
            map2.put("feeIncome",map3.get("feeIncome"));
        }
        String json= JSON.toJSONString(map2, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        return json;
    }
}
