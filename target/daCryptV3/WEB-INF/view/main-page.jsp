<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h1>Real Time Exchange Rate</h1>
<form id="checkPare" action="checkPare" method="post">
    <h3>Please input first and second currencies</h3>
    <label> From currency: </label>
    <br>
    <input type="text" name="ToCurrency">
    <br>
    <label> To currency: </label>
    <br>
    <input type="text" name="FromCurrency">
    <br>
    <br>
    <table>
        <tr>
            <button >Submit</button>
            <br>
            <br>
            <input type="button" value="Add new pare" onclick="window.location.href = 'addNewPare'"/>
            <br>
            <br>
            <input type="button" value="Check monthly report " onclick="window.location.href = 'addMonthlyReport'"/>
            <br>
            <br>
            <input type="button" value="Show monthly report " onclick="window.location.href = 'showMonthlyReport'"/>
            <br>
            <br>
            <button onClick="window.location.reload();">Refresh Page</button>
            <br>
            <br>

        </tr>
    </table>
</form>
<br>
<br>
<br>
<table border="1">
    <thead>
    <tr>
        <th>From Currency</th>
        <th>To Currency</th>
        <th>Exchange Rate</th>
        <th>Last Refreshed</th>
        <th>Bid Price</th>
        <th>Ask Price</th>
    </tr>
    </thead>

    <c:forEach var="currencyPare" items="${realTimeExRates}">

        <tbody>
        <tr>
            <td>${currencyPare.fromCurrencyFullName}</td>
            <td>${currencyPare.toCurrencyFullName}</td>
            <td>${currencyPare.exchangeRate}</td>
            <td>${currencyPare.lastRefreshed}</td>
            <td>${currencyPare.bidPrice}</td>
            <td>${currencyPare.askPrice}</td>
        </tr>
        </tbody>
    </c:forEach>

</table>

<br>
<br>
<br>

<table border="1">
    <thead>
    <tr>
        <th>From Currency (code)</th>
        <th>From Currency (name)</th>
        <th>To Currency (code)</th>
        <th>To Currency (name)</th>
        <th>Last refreshed</th>
        <th>Time Zone</th>
        <th>Check date</th>
        <th>Highest price of the month</th>
        <th>Highest price of the month (USD)</th>
        <th>Lowest price of the month</th>
        <th>Lowest price of the month (USD)</th>
        <th>Volume</th>
        <th>Market capitalization (USD)</th>
    </tr>
    </thead>

    <c:forEach var="monthlyItem" items="${monthlyReport}">

        <tbody>
        <tr>
            <td>${monthlyItem.currencyCode}</td>
            <td>${monthlyItem.currencyName}</td>
            <td>${monthlyItem.marketCode}</td>
            <td>${monthlyItem.marketName}</td>
            <td>${monthlyItem.lastRefreshed}</td>
            <td>${monthlyItem.timeZone}</td>
            <td>${monthlyItem.checkDate}</td>
            <td>${monthlyItem.highestPriceInput}</td>
            <td>${monthlyItem.highestPriceUSD}</td>
            <td>${monthlyItem.lowestPriceInput}</td>
            <td>${monthlyItem.lowestPriceUSD}</td>
            <td>${monthlyItem.volume}</td>
            <td>${monthlyItem.marketCapUSD}</td>
        </tr>
        </tbody>
    </c:forEach>

</table>

</body>
</html>