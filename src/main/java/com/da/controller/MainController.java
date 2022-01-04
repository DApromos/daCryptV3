package com.da.controller;

import com.da.entity.DigitalCurrencyMonthly;
import com.da.entity.RealtimeCurrencyExchangeRate;
import com.da.entity.TransfExRate;
import com.da.service.DigitalCurrencyMonthlyServiceImplementation;
import com.da.service.RealtimeCurrencyExchangeRateServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    //Adding dependencies for both monthly and single reports
    @Autowired
    private DigitalCurrencyMonthlyServiceImplementation digitalCurrencyMonthlyServiceImplementation;

    @Autowired
    private RealtimeCurrencyExchangeRateServiceImplementation rateServiceImplementation;

    //Intermediary object for getting input (currencies) from view
    @Autowired
    public TransfExRate transfExRate;

    //Reading currencies from view and set them for both instances (daily and monthly)
    @RequestMapping(value = "/checkPare", method = RequestMethod.POST)
    public String checkPare(TransfExRate transfExRate) {
        System.out.println("From currency: " + transfExRate.getFromCurrency());
        System.out.println("To currency: " + transfExRate.getToCurrency());
        rateServiceImplementation.setFromCurrency(transfExRate.getFromCurrency());
        rateServiceImplementation.setToCurrency(transfExRate.getToCurrency());
        digitalCurrencyMonthlyServiceImplementation.setFromCurrency(transfExRate.getFromCurrency());
        digitalCurrencyMonthlyServiceImplementation.setToCurrency(transfExRate.getToCurrency());
        return "redirect:/";
    }

    @RequestMapping("/showDailyReport")
    public String showRealTimeExRate(Model model) {
        List<RealtimeCurrencyExchangeRate> realtimeCurrencyExchangeRates =
                rateServiceImplementation.getRealtimeCurrencyExchangeRate();
        model.addAttribute("realTimeExRates", realtimeCurrencyExchangeRates);
        return "daily-report-list";
    }


    @RequestMapping("/addNewPare")
    public String saveRealtimeExchangeRate(Model model) {
        List<RealtimeCurrencyExchangeRate> realtimeCurrencyExchangeRate =
                rateServiceImplementation.saveExchangeRate();
        model.addAttribute("realTimeExRates", realtimeCurrencyExchangeRate);
        return "welcome-page";

    }


    @RequestMapping("/addMonthlyReport")
    public String saveMonthlyReport(Model model) {
        List<DigitalCurrencyMonthly> digitalCurrencyMonthly =
                digitalCurrencyMonthlyServiceImplementation.saveReport();
        model.addAttribute("monthlyReport", digitalCurrencyMonthly);
        return "welcome-page";

    }

    @RequestMapping("/showMonthlyReport")
    public String showMonthlyReport(Model model) {
        List<DigitalCurrencyMonthly> digitalCurrencyMonthlyServiceImplementations =
                digitalCurrencyMonthlyServiceImplementation.monthlyReport();
        model.addAttribute("monthlyReport", digitalCurrencyMonthlyServiceImplementations);
        return "monthly-report-list";
    }

    @RequestMapping("/")
    public String welcomePage(){
        return "welcome-page";
    }


}