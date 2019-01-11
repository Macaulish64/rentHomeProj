package com.rent.web;

import com.alibaba.fastjson.JSON;
import com.rent.entity.RentTransaction;
import com.rent.service.RentTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/transaction")
public class TransactionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RentTransactionService rentTransctionService;

    @RequestMapping(value = "submittransaction", method = RequestMethod.POST)
    @ResponseBody
    private String submitTransaction(HttpServletRequest request) {
        int userid=0,houseid=0;
        try {
            userid=Integer.parseInt(request.getParameter("userid"));
        } catch(NumberFormatException e) { }
        try {
            userid=Integer.parseInt(request.getParameter("houseid"));
        } catch(NumberFormatException e) { }
        Map<String,Object> map=rentTransctionService.submitTransaction(houseid,userid);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "confirmtransaction", method = RequestMethod.POST)
    @ResponseBody
    private String confirmTransaction(HttpServletRequest request) {
        int userid=0,houseid=0;
        try {
            userid=Integer.parseInt(request.getParameter("userid"));
        } catch(NumberFormatException e) { }
        try {
            userid=Integer.parseInt(request.getParameter("houseid"));
        } catch(NumberFormatException e) { }
        Map<String,Object> map=rentTransctionService.confirmTransaction(houseid,userid);
        return JSON.toJSONString(map);
    }

    @RequestMapping(value = "queryownerTransaction/{op}", method = RequestMethod.GET)
    @ResponseBody
    private String queryOwnerTransaction(HttpServletRequest request,
                                         @PathVariable("op") int op) {
        int userid=0;
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
    private String queryHolderTransaction(@PathVariable("op") int op,
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
            map.put("rentstate",rentstate);
        }
        map.put("tenantid",tenantid);
        List<RentTransaction> transactionlist=rentTransctionService.queryRentTransaction(map,0,10);
        return JSON.toJSONString(transactionlist);
    }

    @RequestMapping(value = "/admin/queryAdminTransaction/{op}", method = RequestMethod.GET)
    @ResponseBody
    private String queryAdminTransaction(@PathVariable("op") int op,
                                          HttpServletRequest request) {
        Map<String,List> map=new HashMap<String,List>();
        List<Integer> rentstate=new ArrayList<Integer>();
        if (op<2) {
            rentstate.add(op);
            map.put("rentstate",rentstate);
        }
        List<RentTransaction> transactionlist=rentTransctionService.queryRentTransaction(map,0,10);
        return JSON.toJSONString(transactionlist);
    }


}
