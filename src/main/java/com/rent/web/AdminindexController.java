package com.rent.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rent.common.CommonEnum;
import com.rent.entity.RentTransaction;
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

    @RequestMapping(value = "adminuserlist", method = RequestMethod.POST)
    @ResponseBody
    public String adminUserPage(HttpServletRequest request)
    {
        Map<String, List> map = (Map<String,List>) request.getAttribute("map");
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

    @RequestMapping(value = "adminhouselist", method = RequestMethod.POST)
    @ResponseBody
    public String adminHousePage(HttpServletRequest request)
    {
        Map<String, List> map = (Map<String,List>) request.getAttribute("map");
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

    @RequestMapping(value = "adminrentlist", method = RequestMethod.POST)
    @ResponseBody
    public String adminRentPage(HttpServletRequest request)
    {
        Map<String, List> map = (Map<String,List>) request.getAttribute("map");
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

    @RequestMapping(value = "/queryAdminTransaction/{op}", method = RequestMethod.GET)
    @ResponseBody
    public String queryAdminTransaction(HttpServletRequest request) {
        int op=Integer.parseInt(request.getParameter("op"));
        logger.info("Query Holder Transaction");
        logger.info("Query Type:"+op);
        Map<String,List> map=new HashMap<String,List>();

        int listLen=rentTransactionService.queryRentTransactionNum(map);
        List<RentTransaction> transactionlist=rentTransactionService.queryRentTransaction(map,0,listLen);
        return JSON.toJSONString(transactionlist);
    }

    @RequestMapping(value = "adminincomelist", method = RequestMethod.POST)
    @ResponseBody
    public String adminIncomePage(HttpServletRequest request)
    {
        Map<String, List> map = (Map<String,List>) request.getAttribute("map");
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
