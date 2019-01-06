package com.rent.web;

import com.rent.service.HouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("house")
public class HouseController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    private HouseService houseService;

    @RequestMapping("/list")
    public void houseListPage(@RequestParam("prideList[]") List<String> prideList,
                                     @RequestParam("cityList[]") List<String> cityList) {
        for(String i:cityList) {
            logger.info(i);
        }
        for(String i:prideList) {
            logger.info(i);
        }
//        List<House> houselist=HouseService.queryHouse(HouseExample,0,5);

    }


}
