package com.da.daCryptV2.service;

import com.da.daCryptV2.dao.RealtimeCurrencyExchangeRateDAO;
import com.da.daCryptV2.entity.RealtimeCurrencyExchangeRate;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RealtimeCurrencyExchangeRateServiceImplementation{

    private static String fromCurrency;
    private static String toCurrency;


    @Autowired
    private RealtimeCurrencyExchangeRateDAO realtimeCurrencyExchangeRateDAO;


    @Transactional
    public List<RealtimeCurrencyExchangeRate> getRealtimeCurrencyExchangeRate() {
        return realtimeCurrencyExchangeRateDAO.getRealtimeCurrencyExchangeRate();
    }


    @Transactional
    public List<RealtimeCurrencyExchangeRate> saveExchangeRate() {

        RealtimeCurrencyExchangeRate realtimeCurrencyExchangeRate;
        List<RealtimeCurrencyExchangeRate> realtimeCurrencyExchangeRateList = new ArrayList<>();

        try {
            HttpResponse<String> response = Unirest.get("https://alpha-vantage.p.rapidapi.com/query?from_currency={fromCurrency}&function=CURRENCY_EXCHANGE_RATE&to_currency={toCurrency}")
                    .routeParam("fromCurrency", getToCurrency())
                    .routeParam("toCurrency", getFromCurrency())
                    .header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
                    .header("x-rapidapi-key", "0de12c6716mshc9a0edac6f3fdd0p18f951jsn923a10990321")
                    .asString();

            System.out.println(response.getBody());

            JSONParser parser = new JSONParser();
            JSONObject exchangeRateObject1 = (JSONObject) parser.parse(response.getBody());

            JSONObject exchangeRateObject2 = (JSONObject) exchangeRateObject1.get("Realtime Currency Exchange Rate");

            String fromCurrencyShortName = (String) exchangeRateObject2.get("1. From_Currency Code");
            String fromCurrencyFullName = (String) exchangeRateObject2.get("2. From_Currency Name");
            String toCurrencyShortName = (String) exchangeRateObject2.get("3. To_Currency Code");
            String toCurrencyFullName = (String) exchangeRateObject2.get("4. To_Currency Name");
            String exchangeRateBefore = (String) exchangeRateObject2.get("5. Exchange Rate");
            double exchangeRate = Double.parseDouble(exchangeRateBefore);
            String lastRefreshed = (String) exchangeRateObject2.get("6. Last Refreshed");
            String timeZone = (String) exchangeRateObject2.get("7. Time Zone");
            String bidPriceBefore = (String) exchangeRateObject2.get("8. Bid Price");
            double bidPrice = Double.parseDouble(bidPriceBefore);
            String askPriceBefore = (String) exchangeRateObject2.get("9. Ask Price");
            double askPrice = Double.parseDouble(askPriceBefore);


            realtimeCurrencyExchangeRate =
                    new RealtimeCurrencyExchangeRate(fromCurrencyShortName, fromCurrencyFullName, toCurrencyShortName,
                            toCurrencyFullName, exchangeRate, lastRefreshed, timeZone, bidPrice, askPrice);

            realtimeCurrencyExchangeRateList.add(realtimeCurrencyExchangeRate);

            realtimeCurrencyExchangeRateDAO.saveRealtimeCurrencyExchangeRate(realtimeCurrencyExchangeRate);



        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return realtimeCurrencyExchangeRateList;

    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String FromCurrency) {
        this.fromCurrency = FromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public RealtimeCurrencyExchangeRateServiceImplementation() {
    }

    public RealtimeCurrencyExchangeRateServiceImplementation(String fromCurrency, String toCurrency) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
    }


}


