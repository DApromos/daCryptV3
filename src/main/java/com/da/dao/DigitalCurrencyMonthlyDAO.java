package com.da.dao;

import com.da.entity.DigitalCurrencyMonthly;

import java.util.List;

public interface DigitalCurrencyMonthlyDAO {

    public List<DigitalCurrencyMonthly> getMonthlyReport();

    public void saveMonthlyReport(List<DigitalCurrencyMonthly> monthlyReport);

    public void saveSingleItem(DigitalCurrencyMonthly digitalCurrencyMonthly);

}
