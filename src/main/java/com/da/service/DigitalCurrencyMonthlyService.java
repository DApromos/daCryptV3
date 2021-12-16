package com.da.service;

import com.da.entity.DigitalCurrencyMonthly;

import java.util.List;

interface DigitalCurrencyMonthlyService {

    List<DigitalCurrencyMonthly> monthlyReport();

    List<DigitalCurrencyMonthly> saveReport();

}
