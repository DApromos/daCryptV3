package com.da.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "CommonMonthlyReport2")
@ToString
public class DigitalCurrencyMonthly {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Getter
    @Setter
    private String currencyCode;

    @Getter
    @Setter
    private String currencyName;

    @Getter
    @Setter
    private String marketCode;

    @Getter
    @Setter
    private String marketName;

    @Getter
    @Setter
    private String lastRefreshed;

    @Getter
    @Setter
    private String timeZone;

    @Getter
    @Setter
    private String checkDate;

    @Getter
    @Setter
    private double highestPriceInput;

    @Getter
    @Setter
    private double highestPriceUSD;

    @Getter
    @Setter
    private double lowestPriceInput;

    @Getter
    @Setter
    private double lowestPriceUSD;

    @Getter
    @Setter
    private double volume;

    @Getter
    @Setter
    private double marketCapUSD;

    public DigitalCurrencyMonthly() {
    }

    public DigitalCurrencyMonthly(String currencyCode, String currencyName, String marketCode, String marketName, String lastRefreshed,
                                  String timeZone, String checkDate, double highestPriceInput, double highestPriceUSD,
                                  double lowestPriceInput, double lowestPriceUSD, double volume, double marketCapUSD) {
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;
        this.marketCode = marketCode;
        this.marketName = marketName;
        this.lastRefreshed = lastRefreshed;
        this.timeZone = timeZone;
        this.checkDate = checkDate;
        this.highestPriceInput = highestPriceInput;
        this.highestPriceUSD = highestPriceUSD;
        this.lowestPriceInput = lowestPriceInput;
        this.lowestPriceUSD = lowestPriceUSD;
        this.volume = volume;
        this.marketCapUSD = marketCapUSD;
    }
}
