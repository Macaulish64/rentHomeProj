package com.rent.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rent.common.CommonEnum;
import com.rent.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
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

    @RequestMapping(value = "adminuserlist", method = RequestMethod.GET)
    @ResponseBody
    public String adminUserPage(HttpServletRequest request)
    {
        Map<String, List> map =new HashMap<>();
        int num = userService.queryUserNum(map);
        Map<String ,Object> map2=new HashMap<String, Object>();
        if (num == 0)
        {
            map2.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
            map2.put("resmsg",CommonEnum.REQUEST_FAILED.getMsg());
        }
        else
        {
            map2.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
            map2.put("resmsg", CommonEnum.REQUEST_SUCCESS.getMsg());
            map2.put("list",userService.queryUser(map ,0 ,num));
        }
        String json= JSON.toJSONString(map2, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "adminhouselist", method = RequestMethod.GET)
    @ResponseBody
    public String adminHousePage(HttpServletRequest request)
    {
        String aaa=request.getParameter("map");
        logger.info(aaa);
        Map<String, List> map = (Map<String,List>) JSON.parse(aaa);
        int num = houseService.queryHouseNum(map);
        Map<String ,Object> map2=new HashMap<String, Object>();
        if (num ==0)
        {
            map2.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
            map2.put("resmsg",CommonEnum.REQUEST_FAILED.getMsg());
        }
        else
        {
            map2.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
            map2.put("resmsg", CommonEnum.REQUEST_SUCCESS.getMsg());
            map2.put("list",houseService.queryHouse(map ,0 ,num));
        }
        String json= JSON.toJSONString(map2, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "adminrentlist", method = RequestMethod.GET)
    @ResponseBody
    public String adminRentPage(HttpServletRequest request)
    {
        Map<String, List> map =new HashMap<>();
        int num = rentInformationService.queryRentInformationNum(map);
        Map<String ,Object> map2=new HashMap<String, Object>();
        if (num ==0)
        {
            map2.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
            map2.put("resmsg",CommonEnum.REQUEST_FAILED.getMsg());
        }
        else
        {
            map2.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
            map2.put("resmsg", CommonEnum.REQUEST_SUCCESS.getMsg());
            map2.put("list",rentInformationService.queryRentInformation(map ,0 ,num));
        }
        String json= JSON.toJSONString(map2, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "admintranslist", method = RequestMethod.GET)
    @ResponseBody
    public String adminTransPage()
    {
        Map<String, List> map =new HashMap<>();
        int num = rentTransactionService.queryRentTransactionNum(map);
        Map<String ,Object> map2=new HashMap<String, Object>();
        if (num ==0)
        {
            map2.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
            map2.put("resmsg",CommonEnum.REQUEST_FAILED.getMsg());
        }
        else
        {
            map2.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
            map2.put("resmsg", CommonEnum.REQUEST_SUCCESS.getMsg());
            map2.put("list",rentTransactionService.queryRentTransaction(map ,0 ,num));
        }
        String json= JSON.toJSONString(map2, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        return json;
    }

    @RequestMapping(value = "adminincomelist", method = RequestMethod.GET)
    @ResponseBody
    public String adminIncomePage(HttpServletRequest request)
    {
        logger.info("=======================================");
        logger.info("Adminincomelist");
        String aaa=request.getParameter("map");
        logger.info(aaa);
        Map<String, List> map = (Map<String,List>) JSON.parse(aaa);
        int num = incomeService.queryIncomeNum(map);
        Map<String ,Object> map2=new HashMap<String, Object>();
        if (num == 0)
        {
            map2.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
            map2.put("resmsg",CommonEnum.REQUEST_FAILED.getMsg());
        }
        else
        {
            map2.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
            map2.put("resmsg", CommonEnum.REQUEST_SUCCESS.getMsg());

            map2.put("list",incomeService.queryIncome(map ,0,num));

            Map<String,Object> map3 = incomeService.countIncome(map);
            map2.put("transactionNum",map3.get("transactionNum"));
            map2.put("feeIncome",map3.get("feeIncome"));
        }
        String json= JSON.toJSONString(map2, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        return json;
    }
}
