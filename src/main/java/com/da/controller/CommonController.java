package com.da.controller;


import com.da.entity.DigitalCurrencyMonthly;
import com.da.service.DigitalCurrencyMonthlyServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CommonController {

    @Autowired
    private DigitalCurrencyMonthlyServiceImplementation digitalCurrencyMonthlyServiceImplementation;

    @RequestMapping("/addMonthlyReport")
    public String saveMonthlyReport(Model model) {
        List<DigitalCurrencyMonthly> digitalCurrencyMonthly =
                digitalCurrencyMonthlyServiceImplementation.saveReport();
        model.addAttribute("monthlyReport", digitalCurrencyMonthly);
        return "main-page";

    }

    @RequestMapping("/showMonthlyReport")
    public String showMonthlyReport(Model model) {
        List<DigitalCurrencyMonthly> digitalCurrencyMonthlyServiceImplementations =
                digitalCurrencyMonthlyServiceImplementation.monthlyReport();
        model.addAttribute("monthlyReport", digitalCurrencyMonthlyServiceImplementations);
        return "main-page";
    }


}






//    @RequestMapping("/addMonthlyReport")
//    public String saveMonthlyReport() {
//        DigitalCurrencyMonthly currencyMonthly = new DigitalCurrencyMonthly("EUR", "Euro", "BTC",
//                "Bitcoin", "2021-12-22 00:00:00", "UTC", "2021-12-23", 52309.63d,
//                59053.55d, 37203.8d, 42000.3, 919329.08d,
//                919329.0d);
//        digitalCurrencyMonthlyServiceImplementation.saveReport();
//        return "main-page";
//
//    }