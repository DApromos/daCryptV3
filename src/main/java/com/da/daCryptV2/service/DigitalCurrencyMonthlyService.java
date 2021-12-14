package com.da.daCryptV2.service;

import com.da.daCryptV2.entity.DigitalCurrencyMonthly;

import java.util.List;

interface DigitalCurrencyMonthlyService {

    List<DigitalCurrencyMonthly> monthlyReport();

    DigitalCurrencyMonthly saveReport();

}
