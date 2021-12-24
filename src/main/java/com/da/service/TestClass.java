package com.da.service;

import com.da.dao.DigitalCurrencyMonthlyDAO;
import com.da.dao.DigitalCurrencyMonthlyDAOImplementation;
import com.da.entity.DigitalCurrencyMonthly;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

@ToString
@Repository
public class TestClass{

    @Getter
    @Setter
    private static String fromCurrency;

    @Getter
    @Setter
    private static String toCurrency;

    @Autowired
    DigitalCurrencyMonthlyDAOImplementation monthlyDAO;



    public DigitalCurrencyMonthly saveReport() {


        List<DigitalCurrencyMonthly> monthlyList = new ArrayList<>();

        DigitalCurrencyMonthly digitalCurrencyMonthly = new DigitalCurrencyMonthly();

        try {
            HttpResponse<String> response = Unirest.get("https://alpha-vantage.p.rapidapi.com/query?function=DIGITAL_CURRENCY_MONTHLY&market=EUR&symbol=BTC")
//            HttpResponse<String> response = Unirest.get("https://alpha-vantage.p.rapidapi.com/query?function=DIGITAL_CURRENCY_MONTHLY&market={fromCurrency}&symbol={toCurrency}")
//                    .routeParam("fromCurrency", getToCurrency())
//                    .routeParam("toCurrency", getFromCurrency())
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

//            LocalDate checkDate = LocalDate.now();
            String checkDate = LocalDate.now().toString();

            JSONObject digitalCurrencyObject4 = (JSONObject) digitalCurrencyObject3.get(checkDate.toString());

            String highestPriceInputRaw = (String) digitalCurrencyObject4.get("2a. high (" + getFromCurrency() + ")");
            double highestPriceInput = Double.parseDouble(highestPriceInputRaw);

            String highestPriceUSDRaw = (String) digitalCurrencyObject4.get("2b. high (USD)");
            double highestPriceUSD = Double.parseDouble(highestPriceUSDRaw);

            String lowestPriceInputRaw = (String) digitalCurrencyObject4.get("3a. low (" + getFromCurrency() + ")");
            double lowestPriceInput = Double.parseDouble(lowestPriceInputRaw);

            String lowestPriceUSDRaw = (String) digitalCurrencyObject4.get("3b. low (USD)");
            double lowestPriceUSD = Double.parseDouble(lowestPriceUSDRaw);

            BigDecimal volume = new BigDecimal((String) digitalCurrencyObject4.get("5. volume"));

            BigDecimal marketCapUSD = new BigDecimal((String)digitalCurrencyObject4.get("6. market cap (USD)"));


//            digitalCurrencyMonthly =
//                    new DigitalCurrencyMonthly(currencyCode, currencyName, marketCode, marketName, lastRefreshed,
//                            timeZone, checkDate, highestPriceInput, highestPriceUSD, lowestPriceInput, lowestPriceUSD,
//                            volume, marketCapUSD);

            System.out.println(digitalCurrencyMonthly);


            LocalDate initialDate = LocalDate.now().minusMonths(32);

            System.out.println(initialDate);

            monthlyList.add(digitalCurrencyMonthly);



//            for (LocalDate date = initialDate; date.isBefore(checkDate); date = date.plusMonths(1)) {
//
//                LocalDate partDate = date.with(lastDayOfMonth());
//
//                JSONObject digitalCurrencyObject5 = (JSONObject) digitalCurrencyObject3.get(partDate.toString());
//
//                String highestPriceInputRaw2 = (String) digitalCurrencyObject5.get("2a. high (" + getFromCurrency() + ")");
//                double highestPriceInput2 = Double.parseDouble(highestPriceInputRaw2);
//
//                String highestPriceUSDRaw2 = (String) digitalCurrencyObject5.get("2b. high (USD)");
//                double highestPriceUSD2 = Double.parseDouble(highestPriceUSDRaw2);
//
//                String lowestPriceInputRaw2 = (String) digitalCurrencyObject5.get("3a. low (" + getFromCurrency() + ")");
//                double lowestPriceInput2 = Double.parseDouble(lowestPriceInputRaw2);
//
//                String lowestPriceUSDRaw2 = (String) digitalCurrencyObject5.get("3b. low (USD)");
//                double lowestPriceUSD2 = Double.parseDouble(lowestPriceUSDRaw2);
//
//                BigDecimal volume2 = new BigDecimal((String) digitalCurrencyObject5.get("5. volume"));
//
//                BigDecimal marketCapUSD2 = new BigDecimal((String) digitalCurrencyObject5.get("6. market cap (USD)"));
//
//
//                DigitalCurrencyMonthly digitalCurrencyItem =
//                        new DigitalCurrencyMonthly(currencyCode, currencyName, marketCode, marketName, lastRefreshed,
//                                timeZone, partDate, highestPriceInput2, highestPriceUSD2, lowestPriceInput2, lowestPriceUSD2,
//                                volume2, marketCapUSD2);
//
//                monthlyList.add(digitalCurrencyItem);
//
//
//            }


//            SessionFactory sessionFactory = null;
//            Session session = sessionFactory.openSession();
//            session.beginTransaction();
//
//            SQLQuery insertsqlQuery = session.createSQLQuery("INSERT INTO digitalcurrenciesmonthly(id, currencyCode, currencyName, marketCode, marketName, " +
//                    "lastRefreshed, timeZone, checkDate, highestPriceInput, highestPriceUSD, lowestPriceInput, lowestPriceUSD, volume, marketCapUSD)");
//
//
//            insertsqlQuery.setParameter(0, 2);
//            insertsqlQuery.setParameter(1, "EUR");
//            insertsqlQuery.setParameter(2, "Euro");
//            insertsqlQuery.setParameter(3, "BTC");
//            insertsqlQuery.setParameter(4, "Bitcoin");
//            insertsqlQuery.setParameter(5, "2021-12-21 00:00:00");
//            insertsqlQuery.setParameter(6, "UTC");
//            insertsqlQuery.setParameter(7, 2021-12-21);
//            insertsqlQuery.setParameter(8, 52356.87743);
//            insertsqlQuery.setParameter(9, 59053.55);
//            insertsqlQuery.setParameter(10, 37237.46598);
//            insertsqlQuery.setParameter(11, 42000.3);
//            insertsqlQuery.setParameter(12, 881813.35083800);
//            insertsqlQuery.setParameter(13, 881813.35083800);
//
//            insertsqlQuery.executeUpdate();



        } catch (UnirestException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return digitalCurrencyMonthly;
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        setFromCurrency("EUR");
        setToCurrency("BTC");
        testClass.saveReport();
    }

}

