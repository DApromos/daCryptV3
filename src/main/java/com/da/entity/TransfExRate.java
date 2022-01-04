package com.da.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

//Special entity for transferring currencies from the view
@Component
public class TransfExRate {

    @Getter
    @Setter
    public String fromCurrency;

    @Getter
    @Setter
    public  String toCurrency;

}
