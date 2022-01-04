package com.da.service;

import com.da.dao.DigitalCurrencyMonthlyDAO;
import com.da.entity.DigitalCurrencyMonthly;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Service
public class DigitalCurrencyMonthlyServiceImplementation implements DigitalCurrencyMonthlyService{

    @Getter
    @Setter
    private static String fromCurrency;

    @Getter
    @Setter
    private static String toCurrency;

    @Autowired
    private DigitalCurrencyMonthlyDAO digitalCurrencyMonthlyDAO;


    public List<DigitalCurrencyMonthly> monthlyReport() {
        return digitalCurrencyMonthlyDAO.getMonthlyReport();
    }

    public List<DigitalCurrencyMonthly> saveReport() {
        List<DigitalCurrencyMonthly> monthlyList = new ArrayList<>();
        DigitalCurrencyMonthly digitalCurrencyMonthly;

        try {
////            Copied from test file
//            HttpResponse<String> response = Unirest.get("https://alpha-vantage.p.rapidapi.com/query?function=DIGITAL_CURRENCY_MONTHLY&market=EUR&symbol=BTC")
////            HttpResponse<String> response = Unirest.get("https://alpha-vantage.p.rapidapi.com/query?function=DIGITAL_CURRENCY_MONTHLY&market={fromCurrency}&symbol={toCurrency}")
////                    .routeParam("fromCurrency", getToCurrency())
////                    .routeParam("toCurrency", getFromCurrency())
//                    .header("x-rapidapi-host", "alpha-vantage.p.rapidapi.com")
//                    .header("x-rapidapi-key", "0de12c6716mshc9a0edac6f3fdd0p18f951jsn923a10990321")
//                    .asString();
//
//            System.out.println(response.getBody());
//
//            JSONParser parser = new JSONParser();
//
//            JSONObject digitalCurrencyObject1 = (JSONObject) parser.parse(response.getBody());
//            JSONObject digitalCurrencyObject2 = (JSONObject) digitalCurrencyObject1.get("Meta Data");
//
//            String currencyCode = (String) digitalCurrencyObject2.get("4. Market Code");
//            String currencyName = (String) digitalCurrencyObject2.get("5. Market Name");
//            String marketCode = (String) digitalCurrencyObject2.get("2. Digital Currency Code");
//            String marketName = (String) digitalCurrencyObject2.get("3. Digital Currency Name");
//            String lastRefreshed = (String) digitalCurrencyObject2.get("6. Last Refreshed");
//            String timeZone = (String) digitalCurrencyObject2.get("7. Time Zone");
//
//            JSONObject digitalCurrencyObject3 =
//                    (JSONObject) digitalCurrencyObject1.get("Time Series (Digital Currency Monthly)");
//
//            String checkDate = LocalDate.now().toString();
//
//            JSONObject digitalCurrencyObject4 = (JSONObject) digitalCurrencyObject3.get(checkDate);
//
//            String highestPriceInputRaw = (String) digitalCurrencyObject4.get("2a. high (EUR)");
//            double highestPriceInput = Double.parseDouble(highestPriceInputRaw);
//
//            String highestPriceUSDRaw = (String) digitalCurrencyObject4.get("2b. high (USD)");
//            double highestPriceUSD = Double.parseDouble(highestPriceUSDRaw);
//
//            String lowestPriceInputRaw = (String) digitalCurrencyObject4.get("3a. low (EUR)");
//            double lowestPriceInput = Double.parseDouble(lowestPriceInputRaw);
//
//            String lowestPriceUSDRaw = (String) digitalCurrencyObject4.get("3b. low (USD)");
//            double lowestPriceUSD = Double.parseDouble(lowestPriceUSDRaw);
//
//            String volumeRaw = (String) digitalCurrencyObject4.get("5. volume");
//            double volume = Double.parseDouble(volumeRaw);
//
//            String marketCapUSDRaw = (String) digitalCurrencyObject4.get("6. market cap (USD)");
//            double marketCapUSD = Double.parseDouble(marketCapUSDRaw);
//
//
//            digitalCurrencyMonthly =
//                    new DigitalCurrencyMonthly(currencyCode, currencyName, marketCode, marketName, lastRefreshed,
//                            timeZone, checkDate, highestPriceInput, highestPriceUSD, lowestPriceInput, lowestPriceUSD,
//                            volume, marketCapUSD);
//
//            System.out.println(digitalCurrencyMonthly);
//
//            monthlyList.add(digitalCurrencyMonthly);
//
//            digitalCurrencyMonthlyDAO.saveSingleItem(digitalCurrencyMonthly);


/* ----------------------------------------------------------------------------------------------------------------------*/


//            String initialDate = LocalDate.now().minusMonths(32).toString();



//            Original version

            System.out.println(getFromCurrency());
            System.out.println(getToCurrency());


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

            String currencyCode = (String) digitalCurrencyObject2.get("4. Market Code");
            String currencyName = (String) digitalCurrencyObject2.get("5. Market Name");
            String marketCode = (String) digitalCurrencyObject2.get("2. Digital Currency Code");
            String marketName = (String) digitalCurrencyObject2.get("3. Digital Currency Name");
            String lastRefreshed = (String) digitalCurrencyObject2.get("6. Last Refreshed");
            String timeZone = (String) digitalCurrencyObject2.get("7. Time Zone");

            JSONObject digitalCurrencyObject3 =
                    (JSONObject) digitalCurrencyObject1.get("Time Series (Digital Currency Monthly)");

            String checkDate = LocalDate.now().toString();

            JSONObject digitalCurrencyObject4 = (JSONObject) digitalCurrencyObject3.get(checkDate);

            // Set the decimal format for parsed decimal values
            DecimalFormat df = new DecimalFormat("#.###");

            String highestPriceInputRaw = (String) digitalCurrencyObject4.get("2a. high (" + getToCurrency() + ")");
            double highestPriceInput = Double.parseDouble(highestPriceInputRaw);

            String highestPriceUSDRaw = (String) digitalCurrencyObject4.get("2b. high (USD)");
            double highestPriceUSD = Double.parseDouble(highestPriceUSDRaw);

            String lowestPriceInputRaw = (String) digitalCurrencyObject4.get("3a. low (" + getToCurrency() + ")");
            double lowestPriceInput = Double.parseDouble(lowestPriceInputRaw);

            String lowestPriceUSDRaw = (String) digitalCurrencyObject4.get("3b. low (USD)");
            double lowestPriceUSD = Double.parseDouble(lowestPriceUSDRaw);

            String volumeRaw = (String) digitalCurrencyObject4.get("5. volume");
            double volume = Math.round(Double.parseDouble(volumeRaw));

            String marketCapUSDRaw = (String) digitalCurrencyObject4.get("6. market cap (USD)");
            double marketCapUSD = Math.round(Double.parseDouble(marketCapUSDRaw));



            DigitalCurrencyMonthly firstItem =
                    new DigitalCurrencyMonthly(currencyCode, currencyName, marketCode, marketName, lastRefreshed,
                            timeZone, checkDate, highestPriceInput, highestPriceUSD, lowestPriceInput, lowestPriceUSD,
                            volume, marketCapUSD);

            System.out.println(firstItem);

            LocalDate initialDate = LocalDate.now().minusMonths(32);

            System.out.println(initialDate);

            monthlyList.add(firstItem);

            for (LocalDate date = initialDate; date.isBefore(LocalDate.now()); date = date.plusMonths(1)) {

                String partDate = date.with(lastDayOfMonth()).toString();

                JSONObject digitalCurrencyObject5 = (JSONObject) digitalCurrencyObject3.get(partDate);

                String highestPriceInputRaw2 = (String) digitalCurrencyObject5.get("2a. high (" + getToCurrency() + ")");
                double highestPriceInput2 = Double.parseDouble(highestPriceInputRaw2);

                String highestPriceUSDRaw2 = (String) digitalCurrencyObject5.get("2b. high (USD)");
                double highestPriceUSD2 = Double.parseDouble(highestPriceUSDRaw2);

                String lowestPriceInputRaw2 = (String) digitalCurrencyObject5.get("3a. low (" + getToCurrency() + ")");
                double lowestPriceInput2 = Double.parseDouble(lowestPriceInputRaw2);

                String lowestPriceUSDRaw2 = (String) digitalCurrencyObject5.get("3b. low (USD)");
                double lowestPriceUSD2 = Double.parseDouble(lowestPriceUSDRaw2);

                String volumeRaw2 = (String) digitalCurrencyObject5.get("5. volume");
                double volume2 = Math.round(Double.parseDouble(volumeRaw2));

                String marketCapUSDRaw2 = (String) digitalCurrencyObject5.get("6. market cap (USD)");
                double marketCapUSD2 = Math.round(Double.parseDouble(marketCapUSDRaw2));


                digitalCurrencyMonthly =
                        new DigitalCurrencyMonthly(currencyCode, currencyName, marketCode, marketName, lastRefreshed,
                                timeZone, partDate, highestPriceInput2, highestPriceUSD2, lowestPriceInput2, lowestPriceUSD2,
                                volume2, marketCapUSD2);

                monthlyList.add(digitalCurrencyMonthly);

            }

            digitalCurrencyMonthlyDAO.saveMonthlyReport(monthlyList);



        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return monthlyList;


    }
}
