package com.da.daCryptV2.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Component
public class TransfExRate {

    public String fromCurrency;
    public  String toCurrency;

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }
}
