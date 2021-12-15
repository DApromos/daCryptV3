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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

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

            JSONObject digitalCurrencyObject3 =
                    (JSONObject) digitalCurrencyObject1.get("Time Series (Digital Currency Monthly)");

            LocalDate checkDate = (LocalDate) digitalCurrencyObject3.get(LocalDate.now());
            JSONObject digitalCurrencyObject4 = (JSONObject) digitalCurrencyObject3.get(LocalDate.now());

            String highestPriceInputRaw = (String) digitalCurrencyObject4.get("2a. high " + getFromCurrency() + ")");
            double highestPriceInput = Double.parseDouble(highestPriceInputRaw);

            String highestPriceUSDRaw = (String) digitalCurrencyObject4.get("2b. high (USD)");
            double highestPriceUSD = Double.parseDouble(highestPriceUSDRaw);

            String lowestPriceInputRaw = (String) digitalCurrencyObject4.get("3a. low " + getFromCurrency() + ")");
            double lowestPriceInput = Double.parseDouble(lowestPriceInputRaw);

            String lowestPriceUSDRaw = (String) digitalCurrencyObject4.get("3b. low (USD)");
            double lowestPriceUSD = Double.parseDouble(lowestPriceUSDRaw);

            String volumeRaw = (String) digitalCurrencyObject4.get("5. volume");
            BigDecimal volume = BigDecimal.valueOf(Double.parseDouble(volumeRaw));

            String marketCapUSDRaw = (String) digitalCurrencyObject4.get("6. market cap (USD)");
            BigDecimal marketCapUSD = BigDecimal.valueOf(Double.parseDouble(marketCapUSDRaw));

            DigitalCurrencyMonthly firstItem =
                    new DigitalCurrencyMonthly(currencyCode, currencyName, marketCode, marketName, lastRefreshed,
                            timeZone, checkDate, highestPriceInput, highestPriceUSD, lowestPriceInput, lowestPriceUSD,
                            volume, marketCapUSD);



            LocalDate initialDate = checkDate.minusMonths(32);

            DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            List<DigitalCurrencyMonthly> monthlyList = new ArrayList<>();
            monthlyList.add(firstItem);

            for (LocalDate date = initialDate; date.isBefore(checkDate); date = date.plusMonths(1)) {

                LocalDate lastDay = date.with(lastDayOfMonth());
                format1.format(lastDay);

                JSONObject digitalCurrencyObject5 = (JSONObject) digitalCurrencyObject3.get(lastDay);

                String highestPriceInputRaw2 = (String) digitalCurrencyObject5.get("2a. high " + getFromCurrency() + ")");
                double highestPriceInput2 = Double.parseDouble(highestPriceInputRaw);

                String highestPriceUSDRaw2 = (String) digitalCurrencyObject5.get("2b. high (USD)");
                double highestPriceUSD2 = Double.parseDouble(highestPriceUSDRaw);

                String lowestPriceInputRaw2 = (String) digitalCurrencyObject5.get("3a. low " + getFromCurrency() + ")");
                double lowestPriceInput2 = Double.parseDouble(lowestPriceInputRaw);

                String lowestPriceUSDRaw2 = (String) digitalCurrencyObject5.get("3b. low (USD)");
                double lowestPriceUSD2 = Double.parseDouble(lowestPriceUSDRaw);

                String volumeRaw2 = (String) digitalCurrencyObject5.get("5. volume");
                BigDecimal volume2 = BigDecimal.valueOf(Double.parseDouble(volumeRaw));

                String marketCapUSDRaw2 = (String) digitalCurrencyObject5.get("6. market cap (USD)");
                BigDecimal marketCapUSD2 = BigDecimal.valueOf(Double.parseDouble(marketCapUSDRaw));

                DigitalCurrencyMonthly digitalCurrencyItem =
                        new DigitalCurrencyMonthly(currencyCode, currencyName, marketCode, marketName, lastRefreshed,
                                timeZone, checkDate, highestPriceInput2, highestPriceUSD2, lowestPriceInput2, lowestPriceUSD2,
                                volume2, marketCapUSD2);
                monthlyList.add(digitalCurrencyItem);



            }





        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return null;
    }
}
