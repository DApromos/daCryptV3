package com.da.service;

import com.da.entity.RealtimeCurrencyExchangeRate;

import java.util.List;

public interface RealtimeCurrencyExchangeRateService {

    List<RealtimeCurrencyExchangeRate> getRealtimeCurrencyExchangeRate();

    RealtimeCurrencyExchangeRate saveExchangeRate();



}
