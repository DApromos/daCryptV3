package com.da.daCryptV2.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "sdsd")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DigitalCurrencyMonthly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
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
    private LocalDate checkDate;

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
    private BigDecimal volume;

    @Getter
    @Setter
    private BigDecimal marketCapUSD;

    public DigitalCurrencyMonthly(String currencyCode, String currencyName, String marketCode, String marketName, String lastRefreshed,
                                  String timeZone, LocalDate checkDate, double highestPriceInput, double highestPriceUSD,
                                  double lowestPriceInput, double lowestPriceUSD, BigDecimal volume, BigDecimal marketCapUSD) {
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
