package com.rent.web;

import com.rent.service.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/house")
public class HouseController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
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

    @RequestMapping(value="/details/{houseid}",method = RequestMethod.POST)
    @ResponseBody
    public String houseDetails(HttpServletRequest request)
    {

        return "";
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

    @RequestMapping(value="/updatahouse",method=RequestMethod.POST)
    @ResponseBody
    public String updataHouse(HttpServletRequest requset)
    {
        return "";
    }

    @RequestMapping(value="/addFavoriteHouse",method=RequestMethod.POST)
    @ResponseBody
    public String addFavoriteHouse(HttpServletRequest request)
    {

        return "";
    }

    


}
