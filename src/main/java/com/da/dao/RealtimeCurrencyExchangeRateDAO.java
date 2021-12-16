package com.da.dao;

import com.da.entity.RealtimeCurrencyExchangeRate;

import java.util.List;

public interface RealtimeCurrencyExchangeRateDAO {

    public List<RealtimeCurrencyExchangeRate> getRealtimeCurrencyExchangeRate();

    public void saveRealtimeCurrencyExchangeRate(RealtimeCurrencyExchangeRate realtimeCurrencyExchangeRate);

}