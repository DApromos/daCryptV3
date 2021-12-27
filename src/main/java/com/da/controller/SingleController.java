package com.da.controller;

import com.da.entity.RealtimeCurrencyExchangeRate;
import com.da.entity.TransfExRate;
import com.da.service.RealtimeCurrencyExchangeRateServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SingleController {

    @Autowired
    public TransfExRate transfExRate;

    @Autowired
    private RealtimeCurrencyExchangeRateServiceImplementation rateServiceImplementation;


    @RequestMapping("/")
    public String showRealTimeExRate(Model model) {
        List<RealtimeCurrencyExchangeRate> realtimeCurrencyExchangeRates =
                rateServiceImplementation.getRealtimeCurrencyExchangeRate();
        model.addAttribute("realTimeExRates", realtimeCurrencyExchangeRates);
        return "main-page";
    }


    @RequestMapping("/addNewPare")
    public String saveRealtimeExchangeRate(Model model) {
        List<RealtimeCurrencyExchangeRate> realtimeCurrencyExchangeRate =
                rateServiceImplementation.saveExchangeRate();
        model.addAttribute("realTimeExRates", realtimeCurrencyExchangeRate);
        return "main-page";

    }


//    @RequestMapping("/populate")
//    public String populateCurrencies(Model model) {
//        RealtimeCurrencyExchangeRate rate = new RealtimeCurrencyExchangeRate();
//        model.addAttribute("exRate", rate);
//        return "main-page";
//    }


    @RequestMapping(value = "/checkPare", method = RequestMethod.POST)
    public String checkPare(TransfExRate transfExRate) {
        System.out.println("From currency: " + transfExRate.getFromCurrency());
        System.out.println("To currency: " + transfExRate.getToCurrency());
        rateServiceImplementation.setFromCurrency(transfExRate.getFromCurrency());
        rateServiceImplementation.setToCurrency(transfExRate.getToCurrency());
        return "redirect:/";
    }

//    @RequestMapping(value = "/checkMonthlyReport", method = RequestMethod.POST)
//    public String monthlyReport(TransfExRate transfExRate) {
//        System.out.println("From currency: " + transfExRate.getFromCurrency());
//        System.out.println("To currency: " + transfExRate.getToCurrency());
//        digitalCurrencyMonthlyServiceImplementation.setFromCurrency(transfExRate.getFromCurrency());
//        digitalCurrencyMonthlyServiceImplementation.setToCurrency(transfExRate.getToCurrency());
//        return "redirect:/";
//    }




}