package com.rent.web;

import com.alibaba.fastjson.JSON;
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
@RequestMapping("transaction")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TransactionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RentTransactionService rentTransctionService;

    @RequestMapping(value = "submittransaction", method = RequestMethod.POST)
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

    @RequestMapping(value = "confirmtransaction", method = RequestMethod.POST)
    @ResponseBody
    public String confirmTransaction(HttpServletRequest request) {
        int transid=0,num1;
//        ,monthNum=0,num1,num2;
//        String startMonth,endNMonth;
        try {
            transid=Integer.parseInt(request.getParameter("transid"));
        } catch(NumberFormatException e) { }
//        try {
//            monthNum=Integer.parseInt(request.getParameter("monthNum"));
//        } catch(NumberFormatException e) { }
        Map<String,Object> map=rentTransctionService.confirmTransaction(transid);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "/queryownerTransaction", method = RequestMethod.GET)
    @ResponseBody
    public String queryOwnerTransaction(HttpServletRequest request) {
        int userid=0;
        int op=Integer.parseInt(request.getParameter("op"));
        logger.info("Query Owner Transaction");
        logger.info("Query Type:"+op);
        try {
            userid=Integer.parseInt(request.getParameter("userid"));
        } catch(NumberFormatException e) { }
        Map<String,List> map=new HashMap<String,List>();
        List<Integer> landlorid=new ArrayList<Integer>();
        landlorid.add(userid);
        List<Integer> rentstate=new ArrayList<Integer>();
        if (op<2) {
            rentstate.add(op);
            map.put("rentstate",rentstate);
        }
        map.put("landlordId",landlorid);
        List<RentTransaction> transactionlist=rentTransctionService.queryRentTransaction(map,0,10);
        return JSON.toJSONString(transactionlist);
    }

    @RequestMapping(value = "queryHolderTransaction/{op}", method = RequestMethod.GET)
    @ResponseBody
    public String queryHolderTransaction(@PathVariable("op") int op,
                                            HttpServletRequest request) {
        int userid=0;
        try {
            userid=Integer.parseInt(request.getParameter("userid"));
        } catch(NumberFormatException e) { }
        Map<String,List> map=new HashMap<String,List>();
        List<Integer> tenantid=new ArrayList<Integer>();
        tenantid.add(userid);
        List<Integer> rentstate=new ArrayList<Integer>();
        if (op<2) {
            rentstate.add(op);
            map.put("rentStatus",rentstate);
        }
        map.put("tenantId",tenantid);
        List<RentTransaction> transactionlist=rentTransctionService.queryRentTransaction(map,0,10);
        for(RentTransaction attribute : transactionlist) {
            logger.info(attribute.toString());
        }
        return JSON.toJSONString(transactionlist);
    }

    @RequestMapping(value = "/admin/queryAdminTransaction/{op}", method = RequestMethod.GET)
    @ResponseBody
    public String queryAdminTransaction(@PathVariable("op") int op,
                                          HttpServletRequest request) {
        Map<String,List> map=new HashMap<String,List>();
        List<Integer> rentstate=new ArrayList<Integer>();
        if (op<2) {
            rentstate.add(op);
            map.put("rentStatus",rentstate);
        }
        List<RentTransaction> transactionlist=rentTransctionService.queryRentTransaction(map,0,10);
        return JSON.toJSONString(transactionlist);
    }

}
