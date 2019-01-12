package com.rent.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rent.common.CommonEnum;
import com.rent.entity.House;
import com.rent.service.HouseService;
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
@RequestMapping("house")
@CrossOrigin(origins = "*", maxAge = 3600)
public class HouseController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private HouseService houseService;

    @RequestMapping(value ="/list",method = RequestMethod.POST)
    @ResponseBody
    public void houseListPageOne(@RequestParam("prideList[]") List<Integer> prideList,
                              @RequestParam("cityList[]") List<Integer> cityList) {
        logger.info("!!!I am in House List Test\n");
        for(Integer i:cityList) {
            logger.info("value="+i);
        }
        for(Integer i:prideList) {
            logger.info("value="+i);
        }
//        List<House> houselist=HouseService.queryHouse(HouseExample,0,5);

    }

    @RequestMapping(value="/houselist/{pagenumber}",method = RequestMethod.POST)
    @ResponseBody
    public String houseListPage(HttpServletRequest request)
    {
        return "";
    }



    @RequestMapping(value="/details/{houseid}",method = RequestMethod.GET)
    @ResponseBody
    public String houseDetails(@PathVariable("houseid") int houseid)
    {
        House nowhouse=houseService.selectHouseById(houseid);
        Map<String ,Object> map=new HashMap<>();
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
    public String addHouse(HttpServletRequest request)
    {

        return "";
    }

    @RequestMapping(value="/deletehouse",method=RequestMethod.POST)
    @ResponseBody
    public String deleteHouse(HttpServletRequest requset)
    {
        return "";
    }

    @RequestMapping(value="/updatehouse",method=RequestMethod.POST)
    @ResponseBody
    public String updateHouse(HttpServletRequest requset)
    {
        return "";
    }


    @RequestMapping(value="/ownerhouselist/{userid}",method=RequestMethod.GET)
    @ResponseBody
    public String getOwnerHouseList(@PathVariable("userid") int userid,
                                    HttpServletRequest request) {
        List<House> houselist;
        Map<String,List> map=new HashMap<>();
        List<Integer> publishuserlist=new ArrayList<>();
        publishuserlist.add(userid);
        map.put("publishUserId",publishuserlist);
        houselist=houseService.queryHouse(map,0,3);
        for(House nowhouse : houselist) {//其内部实质上还是调用了迭代器遍历方式，这种循环方式还有其他限制，不建议使用。
            System.out.println(nowhouse.toString());
        }
        String json= JSON.toJSONString(houselist, SerializerFeature.WriteMapNullValue);
        return json;
    }

}
