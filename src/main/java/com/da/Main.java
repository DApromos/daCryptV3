package com.da;

import com.da.service.RealtimeCurrencyExchangeRateService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
       ClassPathXmlApplicationContext context =
               new ClassPathXmlApplicationContext("applicationContext.xml");
//        context.getBean(RealtimeCurrencyExchangeRateService.class).saveExchangeRate();

    }
}
