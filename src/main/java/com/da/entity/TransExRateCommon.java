package com.da.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
public class TransExRateCommon {

    @Setter
    @Getter
    public String fromCurrency;

    @Setter
    @Getter
    public  String toCurrency;

}
