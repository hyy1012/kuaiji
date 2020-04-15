package com.huaxing.account.pay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class Name: com.huaxing.account.pay.controller.TestController
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/15 11:32
 * Description: TestController
 * ==================================
 */
@RestController
public class TestController {

    @GetMapping("test")
    public String test(){
        return "test";
    }

}
