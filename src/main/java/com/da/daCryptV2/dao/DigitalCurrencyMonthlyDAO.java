package com.da.daCryptV2.dao;

import com.da.daCryptV2.entity.DigitalCurrencyMonthly;

import java.util.List;

interface DigitalCurrencyMonthlyDAO {

    public List<DigitalCurrencyMonthly> getMonthlyReport();

    public void saveMonthlyReport(List<DigitalCurrencyMonthly> monthlyReport);

}
