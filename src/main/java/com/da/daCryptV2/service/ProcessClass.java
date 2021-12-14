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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;


import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessClass {

//    private static String fromCurrency="USD";
//    private static String toCurrency="BTC";
//
//    @Autowired
//    RealtimeCurrencyExchangeRateDAO realtimeCurrencyExchangeRateDAO;



//    @Transactional
//    public List<RealtimeCurrencyExchangeRate> saveExchangeRate() {
//
////        this.fromCurrency=fromCurrency;
////        this.toCurrency=toCurrency;
//
//
//        RealtimeCurrencyExchangeRate realtimeCurrencyExchangeRate = new RealtimeCurrencyExchangeRate();
//
//        List<RealtimeCurrencyExchangeRate> realtimeCurrencyExchangeRateList = new ArrayList<>();
//
////        .uri(URI.create("https://alpha-vantage.p.rapidapi.com/query?from_currency="+fromCurrency+"&function=CURRENCY_EXCHANGE_RATE&to_currency="+ toCurrency))
////                .uri(URI.create("https://alpha-vantage.p.rapidapi.com/query?from_currency=GBP&function=CURRENCY_EXCHANGE_RATE&to_currency=CHF"))
//
//        HttpRequest request_daily = HttpRequest.newBuilder()
//                .uri(URI.create("https://alpha-vantage.p.rapidapi.com/query?from_currency=GBP&function=CURRENCY_EXCHANGE_RATE&to_currency=CHF"))
//                .header("x-rapidapi-key", "0de12c6716mshc9a0edac6f3fdd0p18f951jsn923a10990321")
//                .header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//
//
//        try {
//
//
//
//            HttpResponse<String> responseDaily = HttpClient.newHttpClient().send(request_daily, HttpResponse.BodyHandlers.ofString());
//
//            JSONParser parser = new JSONParser();
//
//            JSONObject exchangeRateObject1 = (JSONObject) parser.parse(responseDaily.body());
//
//            JSONObject exchangeRateObject2 = (JSONObject) exchangeRateObject1.get("Realtime Currency Exchange Rate");
//
//            String fromCurrencyShortName = (String) exchangeRateObject2.get("1. From_Currency Code");
//            String fromCurrencyFullName = (String) exchangeRateObject2.get("2. From_Currency Name");
//            String toCurrencyShortName = (String) exchangeRateObject2.get("3. To_Currency Code");
//            String toCurrencyFullName = (String) exchangeRateObject2.get("4. To_Currency Name");
//            String exchangeRateBefore = (String) exchangeRateObject2.get("5. Exchange Rate");
//            double exchangeRate = Double.parseDouble(exchangeRateBefore);
//            String lastRefreshed = (String) exchangeRateObject2.get("6. Last Refreshed");
//            String timeZone = (String) exchangeRateObject2.get("7. Time Zone");
//            String bidPriceBefore = (String) exchangeRateObject2.get("8. Bid Price");
//            double bidPrice = Double.parseDouble(bidPriceBefore);
//            String askPriceBefore = (String) exchangeRateObject2.get("9. Ask Price");
//            double askPrice = Double.parseDouble(askPriceBefore);
//
//            realtimeCurrencyExchangeRate =
//                    new RealtimeCurrencyExchangeRate(fromCurrencyShortName, fromCurrencyFullName, toCurrencyShortName,
//                            toCurrencyFullName, exchangeRate, lastRefreshed, timeZone, bidPrice, askPrice);
//
//            realtimeCurrencyExchangeRateList.add(realtimeCurrencyExchangeRate);
//
//            realtimeCurrencyExchangeRateDAO.saveRealtimeCurrencyExchangeRate(realtimeCurrencyExchangeRate);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//        return realtimeCurrencyExchangeRateList;
//    }
//
//

//    static String url="https://alpha-vantage.p.rapidapi.com/query?from_currency="+fromCurrency+"&function=CURRENCY_EXCHANGE_RATE&to_currency="+toCurrency;
//    static String url2=url;

    @Transactional
    public RealtimeCurrencyExchangeRate saveExRate() throws UnirestException {


        HttpResponse<String> response = Unirest.get("https://alpha-vantage.p.rapidapi.com/query?function=DIGITAL_CURRENCY_MONTHLY&market=PLN&symbol=XLM")
//                .routeParam("fromCurrency", "SOL")
//                .routeParam("toCurrency", "PLN")
                .header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
                .header("x-rapidapi-key", "0de12c6716mshc9a0edac6f3fdd0p18f951jsn923a10990321")
                .asString();

        System.out.println(response.getBody());


//        try {
//            HttpResponse<String> response = Unirest.get("https://alpha-vantage.p.rapidapi.com/query?from_currency={fromCurrency}&function=CURRENCY_EXCHANGE_RATE&to_currency={toCurrency}")
//                    .routeParam("fromCurrency", getToCurrency())
//                    .routeParam("toCurrency", getFromCurrency())
//                    .header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
//                    .header("x-rapidapi-key", "0de12c6716mshc9a0edac6f3fdd0p18f951jsn923a10990321")
//                    .asString();
//
//            System.out.println(response.getBody());

//            JSONParser parser = new JSONParser();
//            JSONObject exchangeRateObject1 = (JSONObject) parser.parse(response.getBody());
//
//            JSONObject exchangeRateObject2 = (JSONObject) exchangeRateObject1.get("Realtime Currency Exchange Rate");
//
//            String fromCurrencyShortName = (String) exchangeRateObject2.get("1. From_Currency Code");
//            String fromCurrencyFullName = (String) exchangeRateObject2.get("2. From_Currency Name");
//            String toCurrencyShortName = (String) exchangeRateObject2.get("3. To_Currency Code");
//            String toCurrencyFullName = (String) exchangeRateObject2.get("4. To_Currency Name");
//            String exchangeRateBefore = (String) exchangeRateObject2.get("5. Exchange Rate");
//            double exchangeRate = Double.parseDouble(exchangeRateBefore);
//            String lastRefreshed = (String) exchangeRateObject2.get("6. Last Refreshed");
//            String timeZone = (String) exchangeRateObject2.get("7. Time Zone");
//            String bidPriceBefore = (String) exchangeRateObject2.get("8. Bid Price");
//            double bidPrice = Double.parseDouble(bidPriceBefore);
//            String askPriceBefore = (String) exchangeRateObject2.get("9. Ask Price");
//            double askPrice = Double.parseDouble(askPriceBefore);
//
//            RealtimeCurrencyExchangeRate realtimeCurrencyExchangeRate = new RealtimeCurrencyExchangeRate();
//
//            realtimeCurrencyExchangeRate =
//                    new RealtimeCurrencyExchangeRate(fromCurrencyShortName, fromCurrencyFullName, toCurrencyShortName,
//                            toCurrencyFullName, exchangeRate, lastRefreshed, timeZone, bidPrice, askPrice);
//
//            System.out.println(realtimeCurrencyExchangeRate);


//        } catch (UnirestException e) {
//            e.printStackTrace();
//        }
//        catch (ParseException e) {
//            e.printStackTrace();
//        }



//        RealtimeCurrencyExchangeRate realtimeCurrencyExchangeRate = new RealtimeCurrencyExchangeRate();
//        return realtimeCurrencyExchangeRate;
    return null;
    }

    public static void main(String[] args) throws UnirestException {
        ProcessClass processClass = new ProcessClass();
//        processClass.saveExchangeRate();
        processClass.saveExRate().toString();
    }


//    @Override
//    public String toString() {
//        return "ProcessClass{" +
//                "realtimeCurrencyExchangeRateDAO=" + realtimeCurrencyExchangeRateDAO +
//                '}';
//    }
//
//
//    public static String getFromCurrency() {
//        return fromCurrency;
//    }
//
//    public static void setFromCurrency(String fromCurrency) {
//        ProcessClass.fromCurrency = fromCurrency;
//    }
//
//    public static String getToCurrency() {
//        return toCurrency;
//    }
//
//    public static void setToCurrency(String toCurrency) {
//        ProcessClass.toCurrency = toCurrency;
//    }
}
