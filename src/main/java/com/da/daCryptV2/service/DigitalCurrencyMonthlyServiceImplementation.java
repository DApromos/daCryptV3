package com.da.daCryptV2.service;

import com.da.daCryptV2.dao.DigitalCurrencyMonthlyDAOImplementation;
import com.da.daCryptV2.entity.DigitalCurrencyMonthly;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DigitalCurrencyMonthlyServiceImplementation implements DigitalCurrencyMonthlyService {

    @Getter
    @Setter
    private static String fromCurrency;

    @Getter
    @Setter
    private static String toCurrency;

    @Autowired
    DigitalCurrencyMonthlyDAOImplementation digitalCurrencyMonthlyDAOImplementation;


    @Transactional
    @Override
    public List<DigitalCurrencyMonthly> monthlyReport() {
        return digitalCurrencyMonthlyDAOImplementation.getMonthlyReport();
    }

    @Override
    public DigitalCurrencyMonthly saveReport() {

        DigitalCurrencyMonthly digitalCurrencyMonthly;

        List<DigitalCurrencyMonthly> digitalCurrencyMonthlyList = new ArrayList<>();

        try {
            HttpResponse<String> response = Unirest.get("https://alpha-vantage.p.rapidapi.com/query?function=DIGITAL_CURRENCY_MONTHLY&market={fromCurrency}&symbol={toCurrency}")
                    .routeParam("fromCurrency", getToCurrency())
                    .routeParam("toCurrency", getFromCurrency())
                    .header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
                    .header("x-rapidapi-key", "0de12c6716mshc9a0edac6f3fdd0p18f951jsn923a10990321")
                    .asString();

            System.out.println(response.getBody());

            JSONParser parser = new JSONParser();

            JSONObject digitalCurrencyObject1 = (JSONObject) parser.parse(response.getBody());
            JSONObject digitalCurrencyObject2 = (JSONObject) digitalCurrencyObject1.get("Meta Data");


            String currencyCode = (String) digitalCurrencyObject2.get("1. From_Currency Code");
            String currencyName = (String) digitalCurrencyObject2.get("2. From_Currency Name");
            String marketCode = (String) digitalCurrencyObject2.get("3. To_Currency Code");
            String marketName = (String) digitalCurrencyObject2.get("4. To_Currency Name");
            String lastRefreshed = (String) digitalCurrencyObject2.get("6. Last Refreshed");
            String timeZone = (String) digitalCurrencyObject2.get("UTC");


            LocalDate checkDate;
            double highestPriceInput;
            double highestPriceUSD;
            double lowestPriceInput;
            double lowestPriceUSD;
            BigDecimal volume;
            BigDecimal marketCapUSD;


        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return null;
    }
}
