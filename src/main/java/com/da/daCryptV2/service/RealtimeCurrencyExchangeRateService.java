package com.da.daCryptV2.service;

import com.da.daCryptV2.entity.RealtimeCurrencyExchangeRate;

import java.util.List;

public interface RealtimeCurrencyExchangeRateService {

    List<RealtimeCurrencyExchangeRate> getRealtimeCurrencyExchangeRate();

    RealtimeCurrencyExchangeRate saveExchangeRate();



}
