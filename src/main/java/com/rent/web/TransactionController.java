package com.rent.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rent.common.CommonEnum;
import com.rent.entity.RentTransaction;
import com.rent.service.RentTransactionService;
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

/*
String userid = request.getParameter("userid");单值
String[] insts = request.getParameterValues("inst");多值
 */
@Controller
@RequestMapping("/trans")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TransactionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RentTransactionService rentTransctionService;

    @RequestMapping(value = "/submittransaction", method = RequestMethod.POST)
    @ResponseBody
    public String submitTransaction(HttpServletRequest request) {
        int userid=0,houseid=0;
        try {
            userid=Integer.parseInt(request.getParameter("userid"));
        } catch(NumberFormatException e) { }
        try {
            houseid=Integer.parseInt(request.getParameter("houseid"));
        } catch(NumberFormatException e) { }
        String startMonth,endNMonth;
        startMonth=request.getParameter("startmonth");
        endNMonth=request.getParameter("endmonth");
        int longtime=0;
        try {
            longtime=Integer.parseInt(request.getParameter("monthcount"));
        } catch(NumberFormatException e) { }
        Map<String,Object> map=rentTransctionService.submitTransaction(houseid,userid,startMonth,endNMonth,longtime);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/confirmtransaction/{transid}", method = RequestMethod.POST)
    @ResponseBody
    public String confirmTransaction(@PathVariable("transid") int transid) {
        Map<String,Object> map=rentTransctionService.confirmTransaction(transid);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/queryownerTransaction/{userid}", method = RequestMethod.GET)
    @ResponseBody
    public String queryOwnerTransaction(@PathVariable("userid") int userid,
                                        HttpServletRequest request) {
        int op=Integer.parseInt(request.getParameter("op"));
        logger.info("Query Owner Transaction");
        logger.info("Query Type:"+op);
        Map<String,List> map=new HashMap<String,List>();
        List<Integer> landlorid=new ArrayList<Integer>();
        landlorid.add(userid);
        List<Integer> rentstate=new ArrayList<Integer>();
        if (op<2) {
            rentstate.add(op);
            map.put("rentstate",rentstate);
        }
        map.put("landlordId",landlorid);
        int listLen=rentTransctionService.queryRentTransactionNum(map);
        List<RentTransaction> transactionlist=rentTransctionService.queryRentTransaction(map,0,listLen);
        return JSON.toJSONString(transactionlist);
    }

    @RequestMapping(value = "queryHolderTransaction/{userid}", method = RequestMethod.GET)
    @ResponseBody
    public String queryHolderTransaction(@PathVariable("userid") int userid,
                                        HttpServletRequest request) {
        int op=Integer.parseInt(request.getParameter("op"));
        logger.info("Query Holder Transaction");
        logger.info("Query Type:"+op);
        Map<String,List> map=new HashMap<String,List>();
        List<Integer> tenantid=new ArrayList<Integer>();
        tenantid.add(userid);
        List<Integer> rentstate=new ArrayList<Integer>();
        if (op<2) {
            rentstate.add(op);
            map.put("rentstate",rentstate);
        }
        map.put("tenantId",tenantid);
        int listLen=rentTransctionService.queryRentTransactionNum(map);
        List<RentTransaction> transactionlist=rentTransctionService.queryRentTransaction(map,0,listLen);
        return JSON.toJSONString(transactionlist);
    }

    @RequestMapping(value="/details/{transid}",method = RequestMethod.GET)
    @ResponseBody
    public String transDetails(@PathVariable("transid") int transid)
    {
        RentTransaction newtrans=rentTransctionService.selectRentTransactionById(transid);
        Map<String ,Object> map=new HashMap<String, Object>();
        if (newtrans==null) {
            map.put("rescode", CommonEnum.REQUEST_FAILED.getCode());
            map.put("resmsg",CommonEnum.REQUEST_FAILED.getMsg());
        }
        else {
            map.put("rescode", CommonEnum.REQUEST_SUCCESS.getCode());
            map.put("resmsg", CommonEnum.REQUEST_SUCCESS.getMsg());
            map.put("trans", newtrans);
        }
        String json= JSON.toJSONString(map, SerializerFeature.WriteMapNullValue);
        System.out.println(json);
        return json;
    }
}
