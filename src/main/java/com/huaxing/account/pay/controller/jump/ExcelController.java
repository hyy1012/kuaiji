package com.huaxing.account.pay.controller.jump;

import cn.hutool.core.date.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class Name: com.huaxing.account.pay.controller.jump.ExcelController
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/16 19:44
 * Description: ExcelController
 * ==================================
 */
@Controller
@RequestMapping("excel")
public class ExcelController {

    @GetMapping("contract")
    public String contract(){
        return "excel/contract";
    }

    @GetMapping("acceptance_bill")
    public String acceptanceBill(Model md){
        List<Integer> list = new ArrayList<>();
        int year = DateUtil.year(new Date());
        while (year >= 2011){
            list.add(year);
            year--;
        }
        md.addAttribute("years", list);
        return "excel/acceptance_bill";
    }

}
