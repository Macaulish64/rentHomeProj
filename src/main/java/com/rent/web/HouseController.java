package com.rent.web;

import com.rent.service.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
