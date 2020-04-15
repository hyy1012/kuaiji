package com.huaxing.account.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Class Name: com.huaxing.account.pay.PayApplication
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/15 11:28
 * Description: PayApplication
 * ==================================
 */
@SpringBootApplication
public class PayApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PayApplication.class);
    }
}
