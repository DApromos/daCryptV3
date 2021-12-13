package com.da.daCryptV2.dao;

import com.da.daCryptV2.entity.RealtimeCurrencyExchangeRate;

import java.util.List;

public interface RealtimeCurrencyExchangeRateDAO {

    public List<RealtimeCurrencyExchangeRate> getRealtimeCurrencyExchangeRate();

    public void saveRealtimeCurrencyExchangeRate(RealtimeCurrencyExchangeRate realtimeCurrencyExchangeRate);

}