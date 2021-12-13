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
            <button onclick="window.location.href = 'addNewPare'">Submit</button>
            <br>
            <br>
            <input type="button" value="Add" onclick="window.location.href = 'addNewPare'"/>
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


</body>
</html>